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
import org.hyperledger.fabric.sdk.*;
import org.hyperledger.fabric.sdk.Channel;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.StreamSupport;


public class ChannelCustomManagerImpl extends ChannelManagerImpl {


    public Optional<String> invokeChaincode(HfgwUserContext context, String applicationId, String chaincodeId, String[] parameters) throws Exception {
        if (parameters == null || parameters.length < 1) {
            throwExceptionWithMessage("parameters have at least 1 element");
        }

        //ensure app, chaincode is there
        Application app = applicationManagerOf(context).loadApplication(context, applicationId, ApplicationTokens.mergeAll(null).toArray());
        ChainCode chaincode = chainCodeManagerOf(context).loadChainCode(context, chaincodeId, ChainCodeTokens.start().withChannel().toArray());

        //resolve the client, one client one app, and init the channel
        HFClient client = HFNetworkHelper.findClientByApp(context, applicationId);

        String func = parameters[0];
        ArrayList realParameters = new ArrayList(Arrays.asList(parameters).subList(1, parameters.length));
        TransactionProposalRequest setRequest = (TransactionProposalRequest) client.newTransactionProposalRequest().setFcn(func).setArgs(realParameters);

        ChaincodeID chaincodeID = ChaincodeID.newBuilder().setName(chaincode.getCodeName())
                .setVersion(chaincode.getCodeVersion()).build();
        setRequest.setChaincodeID(chaincodeID);

        Collection<ProposalResponse> transactionPropResp = client.getChannel(app.getChannel().getName()).sendTransactionProposalToEndorsers(setRequest, new Channel.DiscoveryOptions());
        BlockEvent.TransactionEvent transactionEvent = client.getChannel(app.getChannel().getName()).sendTransaction(transactionPropResp).get(120, TimeUnit.SECONDS);
        return StreamSupport.stream(transactionEvent.getTransactionActionInfos().spliterator(), false).findAny().map(BlockInfo.TransactionEnvelopeInfo.TransactionActionInfo::getResponseMessage);
    }


    public Optional<String> queryChaincode(HfgwUserContext context, String applicationId, String chaincodeId, String[] parameters) throws Exception {
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

        Collection<ProposalResponse> queryResponses = client.getChannel(app.getChannel().getName()).queryByChaincode(request);
        return queryResponses.stream().findAny().map(pProposalResponse -> {
            try {
                return new String(pProposalResponse.getChaincodeActionResponsePayload());
            } catch (InvalidArgumentException pE) {
                pE.printStackTrace();
                return pE.getMessage();
            }
        });
    }
}

