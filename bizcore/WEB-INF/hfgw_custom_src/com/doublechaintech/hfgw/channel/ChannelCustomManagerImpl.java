package com.doublechaintech.hfgw.channel;

/*

这里面放置你需要定制的行为，可以增加方法，也可以重写原来的方法，主要是增加新的约束和关联。
注意，在同名方法里面一定要使用super来调用，不然将会出现缓冲出溢出的问题Stack Overflow。
这个类讲在第一次生成，此后这些文件不会被覆盖，如果名字发生了变更，则需要手动删除，修改本类来适应新的模型变更，
这个类已经被配置到了相应的Spring配置文件 WEB-INF/hfgw_custom_src/META-INF/hfgw_custom.xml 中，
所以直接在里面重写或者增加新的方法将会修改客户的行为

*/


import com.doublechaintech.hfgw.HFNetworkHelper;
import com.doublechaintech.hfgw.HfgwUserContext;
import com.doublechaintech.hfgw.application.Application;
import com.doublechaintech.hfgw.application.ApplicationTokens;
import com.doublechaintech.hfgw.chaincode.ChainCode;
import com.doublechaintech.hfgw.chaincode.ChainCodeTokens;
import com.doublechaintech.hfgw.servicerecord.ServiceRecord;
import com.doublechaintech.hfgw.servicerecord.ServiceRecordTokens;
import com.doublechaintech.hfgw.transactionstatus.TransactionStatus;
import com.terapico.uccaf.BaseUserContext;
import org.hyperledger.fabric.sdk.*;
import org.hyperledger.fabric.sdk.Channel;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


public class ChannelCustomManagerImpl extends ChannelManagerImpl {

    public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters) throws IllegalAccessException {
        return accessOK();
    }

    public ServiceRecord invokeChaincode(HfgwUserContext context, String applicationId, String chaincodeId, String[] parameters) throws Exception {
        if (parameters == null || parameters.length < 1) {
            throwExceptionWithMessage("parameters have at least 1 element");
        }

        //ensure app, chaincode is there
        Application app = applicationManagerOf(context).loadApplication(context, applicationId, ApplicationTokens.mergeAll(null).toArray());
        ChainCode chaincode = chainCodeManagerOf(context).loadChainCode(context, chaincodeId, ChainCodeTokens.start().withChannel().toArray());


        //resolve the client, one client one app, and init the channel
        HFClient client = HFNetworkHelper.findClientByApp(context, applicationId);

        //create the serviceRecord
        String func = parameters[0];
        ArrayList realParameters = new ArrayList(Arrays.asList(parameters).subList(1, parameters.length));
        ServiceRecord serviceRecord = serviceRecordManagerOf(context).createServiceRecord(context,
                "",
                "调用链码",
                func + realParameters.stream().collect(Collectors.joining(",", "(", ")")),
                app.getChannel().getId(),
                chaincodeId,
                func,
                "",
                app.getId(),
                app.getNetwork().getId(),
                "",
                TransactionStatus.NEW
        );

        TransactionProposalRequest setRequest = (TransactionProposalRequest) client.newTransactionProposalRequest().setFcn(func).setArgs(realParameters);
        ChaincodeID chaincodeID = ChaincodeID.newBuilder().setName(chaincode.getCodeName())
                .setVersion(chaincode.getCodeVersion()).build();
        setRequest.setChaincodeID(chaincodeID);

        //go to endorsers and get the responses
        Collection<ProposalResponse> transactionPropResp = client.getChannel(app.getChannel().getName()).sendTransactionProposalToEndorsers(setRequest, new Channel.DiscoveryOptions().setInspectResults(true));
        String tid = transactionPropResp.stream().findAny().map(ProposalResponse::getTransactionID).orElse("");
        serviceRecord.updateTransactionId(tid);
        Optional<String> invalidMessage = transactionPropResp.stream().filter(ProposalResponse::isInvalid).findAny().map(ProposalResponse::getMessage);

        //any endorser fail, mark the status reject, and set the error msg as the response
        if (invalidMessage.isPresent()) {
            serviceRecord.updateStatus(TransactionStatus.refById(TransactionStatus.REJECTED));
            serviceRecord.updateResponse(invalidMessage.get());
            serviceRecordManagerOf(context).internalSaveServiceRecord(context, serviceRecord);
            return serviceRecordManagerOf(context).loadServiceRecord(context, serviceRecord.getId(), ServiceRecordTokens.start().toArray());
        } else {
            //all endorser pass, mark the status as endorsed
            serviceRecord.updateStatus(TransactionStatus.refById(TransactionStatus.ENDORSED));
            serviceRecordManagerOf(context).internalSaveServiceRecord(context, serviceRecord);
        }

        client.getChannel(app.getChannel().getName()).sendTransaction(transactionPropResp)
                .whenComplete((event, e) -> {
                    if (e != null) {
                        serviceRecord.updateStatus(TransactionStatus.refById(TransactionStatus.REJECTED));
                        serviceRecord.updateResponse(e.getMessage());
                        return;
                    }
                    serviceRecord.updateBlockId(String.valueOf(event.getBlockEvent().getBlockNumber()));
                    Optional<String> response = StreamSupport.stream(event.getTransactionActionInfos().spliterator(), false).findAny().map(BlockInfo.TransactionEnvelopeInfo.TransactionActionInfo::getResponseMessage);
                    serviceRecord.updateResponse(response.orElse(""));
                    if (event.isValid()) {
                        serviceRecord.updateStatus(TransactionStatus.refById(TransactionStatus.COMMITTED));
                    } else {
                        serviceRecord.updateStatus(TransactionStatus.refById(TransactionStatus.REJECTED));
                    }
                })
                .get(120, TimeUnit.SECONDS);


        serviceRecordManagerOf(context).internalSaveServiceRecord(context, serviceRecord);

        return serviceRecordManagerOf(context).loadServiceRecord(context, serviceRecord.getId(), ServiceRecordTokens.start().toArray());
    }


    public ServiceRecord queryChaincode(HfgwUserContext context, String applicationId, String chaincodeId, String[] parameters) throws Exception {
        if (parameters == null || parameters.length < 1) {
            throwExceptionWithMessage("parameters have at least 1 element ");
        }

        //ensure app, chaincode is there
        Application app = applicationManagerOf(context).loadApplication(context, applicationId, ApplicationTokens.mergeAll(null).toArray());
        ChainCode chaincode = chainCodeManagerOf(context).loadChainCode(context, chaincodeId, ChainCodeTokens.start().withChannel().toArray());

        //resolve the client, one client one app, and init the channel
        HFClient client = HFNetworkHelper.findClientByApp(context, applicationId);

        String func = parameters[0];
        ArrayList realParameters = new ArrayList(Arrays.asList(parameters).subList(1, parameters.length));
        QueryByChaincodeRequest request = (QueryByChaincodeRequest) client.newQueryProposalRequest().setFcn(func).setArgs(realParameters);

        ChaincodeID chaincodeID = ChaincodeID.newBuilder().setName(chaincode.getCodeName())
                .setVersion(chaincode.getCodeVersion()).build();
        request.setChaincodeID(chaincodeID);

        ServiceRecord serviceRecord = serviceRecordManagerOf(context).createServiceRecord(context,
                "",
                "通过链码查询",
                func + realParameters.stream().collect(Collectors.joining(",", "(", ")")),
                app.getChannel().getId(),
                chaincodeId,
                func,
                "",
                app.getId(),
                app.getNetwork().getId(),
                "",
                TransactionStatus.NEW
        );

        Collection<ProposalResponse> queryResponses = client.getChannel(app.getChannel().getName()).queryByChaincode(request);

        //valid response
        Optional<ProposalResponse> msg = queryResponses.stream().filter(res -> !res.isInvalid()).findAny();

        if (msg.isPresent()) {
            serviceRecord.updateTransactionId(msg.map(ProposalResponse::getTransactionID).orElse(""));
            serviceRecord.updateResponse(msg.get().getProposalResponse().getResponse().getPayload().toStringUtf8());
            serviceRecord.updateStatus(TransactionStatus.refById(TransactionStatus.COMMITTED));
        } else {
            serviceRecord.updateTransactionId(queryResponses.stream().findAny().map(ProposalResponse::getTransactionID).orElse(""));
            serviceRecord.updateStatus(TransactionStatus.refById(TransactionStatus.REJECTED));
            serviceRecord.updateResponse(queryResponses.stream().findAny().map(ProposalResponse::getMessage).orElse(""));
        }

        serviceRecordManagerOf(context).internalSaveServiceRecord(context, serviceRecord);
        return serviceRecordManagerOf(context).loadServiceRecord(context, serviceRecord.getId(), ServiceRecordTokens.start().toArray());
    }
}

