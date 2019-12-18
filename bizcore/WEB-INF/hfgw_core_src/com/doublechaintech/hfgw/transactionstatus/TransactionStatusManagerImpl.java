
package com.doublechaintech.hfgw.transactionstatus;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.BaseEntity;


import com.doublechaintech.hfgw.Message;
import com.doublechaintech.hfgw.SmartList;
import com.doublechaintech.hfgw.MultipleAccessKey;

import com.doublechaintech.hfgw.HfgwUserContext;
//import com.doublechaintech.hfgw.BaseManagerImpl;
import com.doublechaintech.hfgw.HfgwCheckerManager;
import com.doublechaintech.hfgw.CustomHfgwCheckerManager;

import com.doublechaintech.hfgw.servicerecord.ServiceRecord;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

import com.doublechaintech.hfgw.hyperledgernetwork.CandidateHyperledgerNetwork;

import com.doublechaintech.hfgw.chaincode.ChainCode;
import com.doublechaintech.hfgw.transactionstatus.TransactionStatus;
import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.application.Application;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;






public class TransactionStatusManagerImpl extends CustomHfgwCheckerManager implements TransactionStatusManager {
	
	private static final String SERVICE_TYPE = "TransactionStatus";
	@Override
	public TransactionStatusDAO daoOf(HfgwUserContext userContext) {
		return transactionStatusDaoOf(userContext);
	}
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws TransactionStatusManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new TransactionStatusManagerException(message);

	}
	
	

 	protected TransactionStatus saveTransactionStatus(HfgwUserContext userContext, TransactionStatus transactionStatus, String [] tokensExpr) throws Exception{	
 		//return getTransactionStatusDAO().save(transactionStatus, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTransactionStatus(userContext, transactionStatus, tokens);
 	}
 	
 	protected TransactionStatus saveTransactionStatusDetail(HfgwUserContext userContext, TransactionStatus transactionStatus) throws Exception{	

 		
 		return saveTransactionStatus(userContext, transactionStatus, allTokens());
 	}
 	
 	public TransactionStatus loadTransactionStatus(HfgwUserContext userContext, String transactionStatusId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfTransactionStatus(transactionStatusId);
		checkerOf(userContext).throwExceptionIfHasErrors( TransactionStatusManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TransactionStatus transactionStatus = loadTransactionStatus( userContext, transactionStatusId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transactionStatus, tokens);
 	}
 	
 	
 	 public TransactionStatus searchTransactionStatus(HfgwUserContext userContext, String transactionStatusId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfTransactionStatus(transactionStatusId);
		checkerOf(userContext).throwExceptionIfHasErrors( TransactionStatusManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		TransactionStatus transactionStatus = loadTransactionStatus( userContext, transactionStatusId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transactionStatus, tokens);
 	}
 	
 	

 	protected TransactionStatus present(HfgwUserContext userContext, TransactionStatus transactionStatus, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,transactionStatus,tokens);
		
		
		TransactionStatus  transactionStatusToPresent = transactionStatusDaoOf(userContext).present(transactionStatus, tokens);
		
		List<BaseEntity> entityListToNaming = transactionStatusToPresent.collectRefercencesFromLists();
		transactionStatusDaoOf(userContext).alias(entityListToNaming);
		
		return  transactionStatusToPresent;
		
		
	}
 
 	
 	
 	public TransactionStatus loadTransactionStatusDetail(HfgwUserContext userContext, String transactionStatusId) throws Exception{	
 		TransactionStatus transactionStatus = loadTransactionStatus( userContext, transactionStatusId, allTokens());
 		return present(userContext,transactionStatus, allTokens());
		
 	}
 	
 	public Object view(HfgwUserContext userContext, String transactionStatusId) throws Exception{	
 		TransactionStatus transactionStatus = loadTransactionStatus( userContext, transactionStatusId, viewTokens());
 		return present(userContext,transactionStatus, allTokens());
		
 	}
 	protected TransactionStatus saveTransactionStatus(HfgwUserContext userContext, TransactionStatus transactionStatus, Map<String,Object>tokens) throws Exception{	
 		return transactionStatusDaoOf(userContext).save(transactionStatus, tokens);
 	}
 	protected TransactionStatus loadTransactionStatus(HfgwUserContext userContext, String transactionStatusId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfTransactionStatus(transactionStatusId);
		checkerOf(userContext).throwExceptionIfHasErrors( TransactionStatusManagerException.class);

 
 		return transactionStatusDaoOf(userContext).load(transactionStatusId, tokens);
 	}

	
	

	public TransactionStatus loadTransactionStatusWithCode(HfgwUserContext userContext, String code, Map<String,Object>tokens) throws Exception{	
 		return transactionStatusDaoOf(userContext).loadByCode(code, tokens);
 	}

	 


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, TransactionStatus transactionStatus, Map<String, Object> tokens){
		super.addActions(userContext, transactionStatus, tokens);
		
		addAction(userContext, transactionStatus, tokens,"@create","createTransactionStatus","createTransactionStatus/","main","primary");
		addAction(userContext, transactionStatus, tokens,"@update","updateTransactionStatus","updateTransactionStatus/"+transactionStatus.getId()+"/","main","primary");
		addAction(userContext, transactionStatus, tokens,"@copy","cloneTransactionStatus","cloneTransactionStatus/"+transactionStatus.getId()+"/","main","primary");
		
		addAction(userContext, transactionStatus, tokens,"transaction_status.transfer_to_network","transferToAnotherNetwork","transferToAnotherNetwork/"+transactionStatus.getId()+"/","main","primary");
		addAction(userContext, transactionStatus, tokens,"transaction_status.addServiceRecord","addServiceRecord","addServiceRecord/"+transactionStatus.getId()+"/","serviceRecordList","primary");
		addAction(userContext, transactionStatus, tokens,"transaction_status.removeServiceRecord","removeServiceRecord","removeServiceRecord/"+transactionStatus.getId()+"/","serviceRecordList","primary");
		addAction(userContext, transactionStatus, tokens,"transaction_status.updateServiceRecord","updateServiceRecord","updateServiceRecord/"+transactionStatus.getId()+"/","serviceRecordList","primary");
		addAction(userContext, transactionStatus, tokens,"transaction_status.copyServiceRecordFrom","copyServiceRecordFrom","copyServiceRecordFrom/"+transactionStatus.getId()+"/","serviceRecordList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, TransactionStatus transactionStatus, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public TransactionStatus createTransactionStatus(HfgwUserContext userContext, String name,String code,String networkId) throws Exception
	//public TransactionStatus createTransactionStatus(HfgwUserContext userContext,String name, String code, String networkId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkNameOfTransactionStatus(name);
		checkerOf(userContext).checkCodeOfTransactionStatus(code);
	
		checkerOf(userContext).throwExceptionIfHasErrors(TransactionStatusManagerException.class);


		TransactionStatus transactionStatus=createNewTransactionStatus();	

		transactionStatus.setName(name);
		transactionStatus.setCode(code);
			
		HyperledgerNetwork network = loadHyperledgerNetwork(userContext, networkId,emptyOptions());
		transactionStatus.setNetwork(network);
		
		

		transactionStatus = saveTransactionStatus(userContext, transactionStatus, emptyOptions());
		
		onNewInstanceCreated(userContext, transactionStatus);
		return transactionStatus;

		
	}
	protected TransactionStatus createNewTransactionStatus() 
	{
		
		return new TransactionStatus();		
	}
	
	protected void checkParamsForUpdatingTransactionStatus(HfgwUserContext userContext,String transactionStatusId, int transactionStatusVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfTransactionStatus(transactionStatusId);
		checkerOf(userContext).checkVersionOfTransactionStatus( transactionStatusVersion);
		

		if(TransactionStatus.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfTransactionStatus(parseString(newValueExpr));
		}
		if(TransactionStatus.CODE_PROPERTY.equals(property)){
			checkerOf(userContext).checkCodeOfTransactionStatus(parseString(newValueExpr));
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(TransactionStatusManagerException.class);
	
		
	}
	
	
	
	public TransactionStatus clone(HfgwUserContext userContext, String fromTransactionStatusId) throws Exception{
		
		return transactionStatusDaoOf(userContext).clone(fromTransactionStatusId, this.allTokens());
	}
	
	public TransactionStatus internalSaveTransactionStatus(HfgwUserContext userContext, TransactionStatus transactionStatus) throws Exception 
	{
		return internalSaveTransactionStatus(userContext, transactionStatus, allTokens());

	}
	public TransactionStatus internalSaveTransactionStatus(HfgwUserContext userContext, TransactionStatus transactionStatus, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingTransactionStatus(userContext, transactionStatusId, transactionStatusVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(transactionStatus){ 
			//will be good when the transactionStatus loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransactionStatus.
			if (transactionStatus.isChanged()){
			
			}
			transactionStatus = saveTransactionStatus(userContext, transactionStatus, options);
			return transactionStatus;
			
		}

	}
	
	public TransactionStatus updateTransactionStatus(HfgwUserContext userContext,String transactionStatusId, int transactionStatusVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTransactionStatus(userContext, transactionStatusId, transactionStatusVersion, property, newValueExpr, tokensExpr);
		
		
		
		TransactionStatus transactionStatus = loadTransactionStatus(userContext, transactionStatusId, allTokens());
		if(transactionStatus.getVersion() != transactionStatusVersion){
			String message = "The target version("+transactionStatus.getVersion()+") is not equals to version("+transactionStatusVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transactionStatus){ 
			//will be good when the transactionStatus loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransactionStatus.
			
			transactionStatus.changeProperty(property, newValueExpr);
			transactionStatus = saveTransactionStatus(userContext, transactionStatus, tokens().done());
			return present(userContext,transactionStatus, mergedAllTokens(tokensExpr));
			//return saveTransactionStatus(userContext, transactionStatus, tokens().done());
		}

	}
	
	public TransactionStatus updateTransactionStatusProperty(HfgwUserContext userContext,String transactionStatusId, int transactionStatusVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTransactionStatus(userContext, transactionStatusId, transactionStatusVersion, property, newValueExpr, tokensExpr);
		
		TransactionStatus transactionStatus = loadTransactionStatus(userContext, transactionStatusId, allTokens());
		if(transactionStatus.getVersion() != transactionStatusVersion){
			String message = "The target version("+transactionStatus.getVersion()+") is not equals to version("+transactionStatusVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transactionStatus){ 
			//will be good when the transactionStatus loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransactionStatus.
			
			transactionStatus.changeProperty(property, newValueExpr);
			
			transactionStatus = saveTransactionStatus(userContext, transactionStatus, tokens().done());
			return present(userContext,transactionStatus, mergedAllTokens(tokensExpr));
			//return saveTransactionStatus(userContext, transactionStatus, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TransactionStatusTokens tokens(){
		return TransactionStatusTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TransactionStatusTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortServiceRecordListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TransactionStatusTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherNetwork(HfgwUserContext userContext, String transactionStatusId, String anotherNetworkId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfTransactionStatus(transactionStatusId);
 		checkerOf(userContext).checkIdOfHyperledgerNetwork(anotherNetworkId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(TransactionStatusManagerException.class);
 		
 	}
 	public TransactionStatus transferToAnotherNetwork(HfgwUserContext userContext, String transactionStatusId, String anotherNetworkId) throws Exception
 	{
 		checkParamsForTransferingAnotherNetwork(userContext, transactionStatusId,anotherNetworkId);
 
		TransactionStatus transactionStatus = loadTransactionStatus(userContext, transactionStatusId, allTokens());	
		synchronized(transactionStatus){
			//will be good when the transactionStatus loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			HyperledgerNetwork network = loadHyperledgerNetwork(userContext, anotherNetworkId, emptyOptions());		
			transactionStatus.updateNetwork(network);		
			transactionStatus = saveTransactionStatus(userContext, transactionStatus, emptyOptions());
			
			return present(userContext,transactionStatus, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateHyperledgerNetwork requestCandidateNetwork(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateHyperledgerNetwork result = new CandidateHyperledgerNetwork();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<HyperledgerNetwork> candidateList = hyperledgerNetworkDaoOf(userContext).requestCandidateHyperledgerNetworkForTransactionStatus(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected HyperledgerNetwork loadHyperledgerNetwork(HfgwUserContext userContext, String newNetworkId, Map<String,Object> options) throws Exception
 	{
		
 		return hyperledgerNetworkDaoOf(userContext).load(newNetworkId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(HfgwUserContext userContext, String transactionStatusId, int transactionStatusVersion) throws Exception {
		//deleteInternal(userContext, transactionStatusId, transactionStatusVersion);		
	}
	protected void deleteInternal(HfgwUserContext userContext,
			String transactionStatusId, int transactionStatusVersion) throws Exception{
			
		transactionStatusDaoOf(userContext).delete(transactionStatusId, transactionStatusVersion);
	}
	
	public TransactionStatus forgetByAll(HfgwUserContext userContext, String transactionStatusId, int transactionStatusVersion) throws Exception {
		return forgetByAllInternal(userContext, transactionStatusId, transactionStatusVersion);		
	}
	protected TransactionStatus forgetByAllInternal(HfgwUserContext userContext,
			String transactionStatusId, int transactionStatusVersion) throws Exception{
			
		return transactionStatusDaoOf(userContext).disconnectFromAll(transactionStatusId, transactionStatusVersion);
	}
	
	

	
	public int deleteAll(HfgwUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TransactionStatusManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HfgwUserContext userContext) throws Exception{
		return transactionStatusDaoOf(userContext).deleteAll();
	}


	//disconnect TransactionStatus with transaction_id in ServiceRecord
	protected TransactionStatus breakWithServiceRecordByTransactionId(HfgwUserContext userContext, String transactionStatusId, String transactionIdId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TransactionStatus transactionStatus = loadTransactionStatus(userContext, transactionStatusId, allTokens());

			synchronized(transactionStatus){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				transactionStatusDaoOf(userContext).planToRemoveServiceRecordListWithTransactionId(transactionStatus, transactionIdId, this.emptyOptions());

				transactionStatus = saveTransactionStatus(userContext, transactionStatus, tokens().withServiceRecordList().done());
				return transactionStatus;
			}
	}
	//disconnect TransactionStatus with channel in ServiceRecord
	protected TransactionStatus breakWithServiceRecordByChannel(HfgwUserContext userContext, String transactionStatusId, String channelId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TransactionStatus transactionStatus = loadTransactionStatus(userContext, transactionStatusId, allTokens());

			synchronized(transactionStatus){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				transactionStatusDaoOf(userContext).planToRemoveServiceRecordListWithChannel(transactionStatus, channelId, this.emptyOptions());

				transactionStatus = saveTransactionStatus(userContext, transactionStatus, tokens().withServiceRecordList().done());
				return transactionStatus;
			}
	}
	//disconnect TransactionStatus with chain_code in ServiceRecord
	protected TransactionStatus breakWithServiceRecordByChainCode(HfgwUserContext userContext, String transactionStatusId, String chainCodeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TransactionStatus transactionStatus = loadTransactionStatus(userContext, transactionStatusId, allTokens());

			synchronized(transactionStatus){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				transactionStatusDaoOf(userContext).planToRemoveServiceRecordListWithChainCode(transactionStatus, chainCodeId, this.emptyOptions());

				transactionStatus = saveTransactionStatus(userContext, transactionStatus, tokens().withServiceRecordList().done());
				return transactionStatus;
			}
	}
	//disconnect TransactionStatus with block_id in ServiceRecord
	protected TransactionStatus breakWithServiceRecordByBlockId(HfgwUserContext userContext, String transactionStatusId, String blockIdId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TransactionStatus transactionStatus = loadTransactionStatus(userContext, transactionStatusId, allTokens());

			synchronized(transactionStatus){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				transactionStatusDaoOf(userContext).planToRemoveServiceRecordListWithBlockId(transactionStatus, blockIdId, this.emptyOptions());

				transactionStatus = saveTransactionStatus(userContext, transactionStatus, tokens().withServiceRecordList().done());
				return transactionStatus;
			}
	}
	//disconnect TransactionStatus with app_client in ServiceRecord
	protected TransactionStatus breakWithServiceRecordByAppClient(HfgwUserContext userContext, String transactionStatusId, String appClientId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TransactionStatus transactionStatus = loadTransactionStatus(userContext, transactionStatusId, allTokens());

			synchronized(transactionStatus){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				transactionStatusDaoOf(userContext).planToRemoveServiceRecordListWithAppClient(transactionStatus, appClientId, this.emptyOptions());

				transactionStatus = saveTransactionStatus(userContext, transactionStatus, tokens().withServiceRecordList().done());
				return transactionStatus;
			}
	}
	//disconnect TransactionStatus with network in ServiceRecord
	protected TransactionStatus breakWithServiceRecordByNetwork(HfgwUserContext userContext, String transactionStatusId, String networkId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TransactionStatus transactionStatus = loadTransactionStatus(userContext, transactionStatusId, allTokens());

			synchronized(transactionStatus){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				transactionStatusDaoOf(userContext).planToRemoveServiceRecordListWithNetwork(transactionStatus, networkId, this.emptyOptions());

				transactionStatus = saveTransactionStatus(userContext, transactionStatus, tokens().withServiceRecordList().done());
				return transactionStatus;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingServiceRecord(HfgwUserContext userContext, String transactionStatusId, String transactionId, String name, String payload, String channelId, String chainCodeId, String chainCodeFunction, String blockId, String appClientId, String networkId, String response,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfTransactionStatus(transactionStatusId);

		
		checkerOf(userContext).checkTransactionIdOfServiceRecord(transactionId);
		
		checkerOf(userContext).checkNameOfServiceRecord(name);
		
		checkerOf(userContext).checkPayloadOfServiceRecord(payload);
		
		checkerOf(userContext).checkChannelIdOfServiceRecord(channelId);
		
		checkerOf(userContext).checkChainCodeIdOfServiceRecord(chainCodeId);
		
		checkerOf(userContext).checkChainCodeFunctionOfServiceRecord(chainCodeFunction);
		
		checkerOf(userContext).checkBlockIdOfServiceRecord(blockId);
		
		checkerOf(userContext).checkAppClientIdOfServiceRecord(appClientId);
		
		checkerOf(userContext).checkNetworkIdOfServiceRecord(networkId);
		
		checkerOf(userContext).checkResponseOfServiceRecord(response);
	
		checkerOf(userContext).throwExceptionIfHasErrors(TransactionStatusManagerException.class);

	
	}
	public  TransactionStatus addServiceRecord(HfgwUserContext userContext, String transactionStatusId, String transactionId, String name, String payload, String channelId, String chainCodeId, String chainCodeFunction, String blockId, String appClientId, String networkId, String response, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingServiceRecord(userContext,transactionStatusId,transactionId, name, payload, channelId, chainCodeId, chainCodeFunction, blockId, appClientId, networkId, response,tokensExpr);
		
		ServiceRecord serviceRecord = createServiceRecord(userContext,transactionId, name, payload, channelId, chainCodeId, chainCodeFunction, blockId, appClientId, networkId, response);
		
		TransactionStatus transactionStatus = loadTransactionStatus(userContext, transactionStatusId, allTokens());
		synchronized(transactionStatus){ 
			//Will be good when the transactionStatus loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transactionStatus.addServiceRecord( serviceRecord );		
			transactionStatus = saveTransactionStatus(userContext, transactionStatus, tokens().withServiceRecordList().done());
			
			userContext.getManagerGroup().getServiceRecordManager().onNewInstanceCreated(userContext, serviceRecord);
			return present(userContext,transactionStatus, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingServiceRecordProperties(HfgwUserContext userContext, String transactionStatusId,String id,String transactionId,String name,String payload,String chainCodeFunction,String blockId,String response,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfTransactionStatus(transactionStatusId);
		checkerOf(userContext).checkIdOfServiceRecord(id);
		
		checkerOf(userContext).checkTransactionIdOfServiceRecord( transactionId);
		checkerOf(userContext).checkNameOfServiceRecord( name);
		checkerOf(userContext).checkPayloadOfServiceRecord( payload);
		checkerOf(userContext).checkChainCodeFunctionOfServiceRecord( chainCodeFunction);
		checkerOf(userContext).checkBlockIdOfServiceRecord( blockId);
		checkerOf(userContext).checkResponseOfServiceRecord( response);

		checkerOf(userContext).throwExceptionIfHasErrors(TransactionStatusManagerException.class);
		
	}
	public  TransactionStatus updateServiceRecordProperties(HfgwUserContext userContext, String transactionStatusId, String id,String transactionId,String name,String payload,String chainCodeFunction,String blockId,String response, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingServiceRecordProperties(userContext,transactionStatusId,id,transactionId,name,payload,chainCodeFunction,blockId,response,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withServiceRecordListList()
				.searchServiceRecordListWith(ServiceRecord.ID_PROPERTY, "is", id).done();
		
		TransactionStatus transactionStatusToUpdate = loadTransactionStatus(userContext, transactionStatusId, options);
		
		if(transactionStatusToUpdate.getServiceRecordList().isEmpty()){
			throw new TransactionStatusManagerException("ServiceRecord is NOT FOUND with id: '"+id+"'");
		}
		
		ServiceRecord item = transactionStatusToUpdate.getServiceRecordList().first();
		
		item.updateTransactionId( transactionId );
		item.updateName( name );
		item.updatePayload( payload );
		item.updateChainCodeFunction( chainCodeFunction );
		item.updateBlockId( blockId );
		item.updateResponse( response );

		
		//checkParamsForAddingServiceRecord(userContext,transactionStatusId,name, code, used,tokensExpr);
		TransactionStatus transactionStatus = saveTransactionStatus(userContext, transactionStatusToUpdate, tokens().withServiceRecordList().done());
		synchronized(transactionStatus){ 
			return present(userContext,transactionStatus, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ServiceRecord createServiceRecord(HfgwUserContext userContext, String transactionId, String name, String payload, String channelId, String chainCodeId, String chainCodeFunction, String blockId, String appClientId, String networkId, String response) throws Exception{

		ServiceRecord serviceRecord = new ServiceRecord();
		
		
		serviceRecord.setTransactionId(transactionId);		
		serviceRecord.setName(name);		
		serviceRecord.setPayload(payload);		
		Channel  channel = new Channel();
		channel.setId(channelId);		
		serviceRecord.setChannel(channel);		
		ChainCode  chainCode = new ChainCode();
		chainCode.setId(chainCodeId);		
		serviceRecord.setChainCode(chainCode);		
		serviceRecord.setChainCodeFunction(chainCodeFunction);		
		serviceRecord.setBlockId(blockId);		
		serviceRecord.setCreateTime(userContext.now());		
		Application  appClient = new Application();
		appClient.setId(appClientId);		
		serviceRecord.setAppClient(appClient);		
		HyperledgerNetwork  network = new HyperledgerNetwork();
		network.setId(networkId);		
		serviceRecord.setNetwork(network);		
		serviceRecord.setResponse(response);
	
		
		return serviceRecord;
	
		
	}
	
	protected ServiceRecord createIndexedServiceRecord(String id, int version){

		ServiceRecord serviceRecord = new ServiceRecord();
		serviceRecord.setId(id);
		serviceRecord.setVersion(version);
		return serviceRecord;			
		
	}
	
	protected void checkParamsForRemovingServiceRecordList(HfgwUserContext userContext, String transactionStatusId, 
			String serviceRecordIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfTransactionStatus(transactionStatusId);
		for(String serviceRecordIdItem: serviceRecordIds){
			checkerOf(userContext).checkIdOfServiceRecord(serviceRecordIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(TransactionStatusManagerException.class);
		
	}
	public  TransactionStatus removeServiceRecordList(HfgwUserContext userContext, String transactionStatusId, 
			String serviceRecordIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingServiceRecordList(userContext, transactionStatusId,  serviceRecordIds, tokensExpr);
			
			
			TransactionStatus transactionStatus = loadTransactionStatus(userContext, transactionStatusId, allTokens());
			synchronized(transactionStatus){ 
				//Will be good when the transactionStatus loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				transactionStatusDaoOf(userContext).planToRemoveServiceRecordList(transactionStatus, serviceRecordIds, allTokens());
				transactionStatus = saveTransactionStatus(userContext, transactionStatus, tokens().withServiceRecordList().done());
				deleteRelationListInGraph(userContext, transactionStatus.getServiceRecordList());
				return present(userContext,transactionStatus, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingServiceRecord(HfgwUserContext userContext, String transactionStatusId, 
		String serviceRecordId, int serviceRecordVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfTransactionStatus( transactionStatusId);
		checkerOf(userContext).checkIdOfServiceRecord(serviceRecordId);
		checkerOf(userContext).checkVersionOfServiceRecord(serviceRecordVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(TransactionStatusManagerException.class);
	
	}
	public  TransactionStatus removeServiceRecord(HfgwUserContext userContext, String transactionStatusId, 
		String serviceRecordId, int serviceRecordVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingServiceRecord(userContext,transactionStatusId, serviceRecordId, serviceRecordVersion,tokensExpr);
		
		ServiceRecord serviceRecord = createIndexedServiceRecord(serviceRecordId, serviceRecordVersion);
		TransactionStatus transactionStatus = loadTransactionStatus(userContext, transactionStatusId, allTokens());
		synchronized(transactionStatus){ 
			//Will be good when the transactionStatus loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transactionStatus.removeServiceRecord( serviceRecord );		
			transactionStatus = saveTransactionStatus(userContext, transactionStatus, tokens().withServiceRecordList().done());
			deleteRelationInGraph(userContext, serviceRecord);
			return present(userContext,transactionStatus, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingServiceRecord(HfgwUserContext userContext, String transactionStatusId, 
		String serviceRecordId, int serviceRecordVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfTransactionStatus( transactionStatusId);
		checkerOf(userContext).checkIdOfServiceRecord(serviceRecordId);
		checkerOf(userContext).checkVersionOfServiceRecord(serviceRecordVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(TransactionStatusManagerException.class);
	
	}
	public  TransactionStatus copyServiceRecordFrom(HfgwUserContext userContext, String transactionStatusId, 
		String serviceRecordId, int serviceRecordVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingServiceRecord(userContext,transactionStatusId, serviceRecordId, serviceRecordVersion,tokensExpr);
		
		ServiceRecord serviceRecord = createIndexedServiceRecord(serviceRecordId, serviceRecordVersion);
		TransactionStatus transactionStatus = loadTransactionStatus(userContext, transactionStatusId, allTokens());
		synchronized(transactionStatus){ 
			//Will be good when the transactionStatus loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			transactionStatus.copyServiceRecordFrom( serviceRecord );		
			transactionStatus = saveTransactionStatus(userContext, transactionStatus, tokens().withServiceRecordList().done());
			
			userContext.getManagerGroup().getServiceRecordManager().onNewInstanceCreated(userContext, (ServiceRecord)transactionStatus.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,transactionStatus, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingServiceRecord(HfgwUserContext userContext, String transactionStatusId, String serviceRecordId, int serviceRecordVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfTransactionStatus(transactionStatusId);
		checkerOf(userContext).checkIdOfServiceRecord(serviceRecordId);
		checkerOf(userContext).checkVersionOfServiceRecord(serviceRecordVersion);
		

		if(ServiceRecord.TRANSACTION_ID_PROPERTY.equals(property)){
			checkerOf(userContext).checkTransactionIdOfServiceRecord(parseString(newValueExpr));
		}
		
		if(ServiceRecord.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfServiceRecord(parseString(newValueExpr));
		}
		
		if(ServiceRecord.PAYLOAD_PROPERTY.equals(property)){
			checkerOf(userContext).checkPayloadOfServiceRecord(parseString(newValueExpr));
		}
		
		if(ServiceRecord.CHAIN_CODE_FUNCTION_PROPERTY.equals(property)){
			checkerOf(userContext).checkChainCodeFunctionOfServiceRecord(parseString(newValueExpr));
		}
		
		if(ServiceRecord.BLOCK_ID_PROPERTY.equals(property)){
			checkerOf(userContext).checkBlockIdOfServiceRecord(parseString(newValueExpr));
		}
		
		if(ServiceRecord.RESPONSE_PROPERTY.equals(property)){
			checkerOf(userContext).checkResponseOfServiceRecord(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(TransactionStatusManagerException.class);
	
	}
	
	public  TransactionStatus updateServiceRecord(HfgwUserContext userContext, String transactionStatusId, String serviceRecordId, int serviceRecordVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingServiceRecord(userContext, transactionStatusId, serviceRecordId, serviceRecordVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withServiceRecordList().searchServiceRecordListWith(ServiceRecord.ID_PROPERTY, "eq", serviceRecordId).done();
		
		
		
		TransactionStatus transactionStatus = loadTransactionStatus(userContext, transactionStatusId, loadTokens);
		
		synchronized(transactionStatus){ 
			//Will be good when the transactionStatus loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//transactionStatus.removeServiceRecord( serviceRecord );	
			//make changes to AcceleraterAccount.
			ServiceRecord serviceRecordIndex = createIndexedServiceRecord(serviceRecordId, serviceRecordVersion);
		
			ServiceRecord serviceRecord = transactionStatus.findTheServiceRecord(serviceRecordIndex);
			if(serviceRecord == null){
				throw new TransactionStatusManagerException(serviceRecord+" is NOT FOUND" );
			}
			
			serviceRecord.changeProperty(property, newValueExpr);
			
			transactionStatus = saveTransactionStatus(userContext, transactionStatus, tokens().withServiceRecordList().done());
			return present(userContext,transactionStatus, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(HfgwUserContext userContext, TransactionStatus newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


