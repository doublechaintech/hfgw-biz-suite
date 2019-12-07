
package com.doublechaintech.hfgw.chaincode;

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

import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.servicerecord.ServiceRecord;
import com.doublechaintech.hfgw.chaincodeinvoker.ChainCodeInvoker;

import com.doublechaintech.hfgw.channel.CandidateChannel;

import com.doublechaintech.hfgw.chaincode.ChainCode;
import com.doublechaintech.hfgw.transactionstatus.TransactionStatus;
import com.doublechaintech.hfgw.changerequest.ChangeRequest;
import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.application.Application;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;






public class ChainCodeManagerImpl extends CustomHfgwCheckerManager implements ChainCodeManager {
	
	private static final String SERVICE_TYPE = "ChainCode";
	@Override
	public ChainCodeDAO daoOf(HfgwUserContext userContext) {
		return chainCodeDaoOf(userContext);
	}
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ChainCodeManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ChainCodeManagerException(message);

	}
	
	

 	protected ChainCode saveChainCode(HfgwUserContext userContext, ChainCode chainCode, String [] tokensExpr) throws Exception{	
 		//return getChainCodeDAO().save(chainCode, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveChainCode(userContext, chainCode, tokens);
 	}
 	
 	protected ChainCode saveChainCodeDetail(HfgwUserContext userContext, ChainCode chainCode) throws Exception{	

 		
 		return saveChainCode(userContext, chainCode, allTokens());
 	}
 	
 	public ChainCode loadChainCode(HfgwUserContext userContext, String chainCodeId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfChainCode(chainCodeId);
		checkerOf(userContext).throwExceptionIfHasErrors( ChainCodeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ChainCode chainCode = loadChainCode( userContext, chainCodeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,chainCode, tokens);
 	}
 	
 	
 	 public ChainCode searchChainCode(HfgwUserContext userContext, String chainCodeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfChainCode(chainCodeId);
		checkerOf(userContext).throwExceptionIfHasErrors( ChainCodeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ChainCode chainCode = loadChainCode( userContext, chainCodeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,chainCode, tokens);
 	}
 	
 	

 	protected ChainCode present(HfgwUserContext userContext, ChainCode chainCode, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,chainCode,tokens);
		
		
		ChainCode  chainCodeToPresent = chainCodeDaoOf(userContext).present(chainCode, tokens);
		
		List<BaseEntity> entityListToNaming = chainCodeToPresent.collectRefercencesFromLists();
		chainCodeDaoOf(userContext).alias(entityListToNaming);
		
		return  chainCodeToPresent;
		
		
	}
 
 	
 	
 	public ChainCode loadChainCodeDetail(HfgwUserContext userContext, String chainCodeId) throws Exception{	
 		ChainCode chainCode = loadChainCode( userContext, chainCodeId, allTokens());
 		return present(userContext,chainCode, allTokens());
		
 	}
 	
 	public Object view(HfgwUserContext userContext, String chainCodeId) throws Exception{	
 		ChainCode chainCode = loadChainCode( userContext, chainCodeId, viewTokens());
 		return present(userContext,chainCode, allTokens());
		
 	}
 	protected ChainCode saveChainCode(HfgwUserContext userContext, ChainCode chainCode, Map<String,Object>tokens) throws Exception{	
 		return chainCodeDaoOf(userContext).save(chainCode, tokens);
 	}
 	protected ChainCode loadChainCode(HfgwUserContext userContext, String chainCodeId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfChainCode(chainCodeId);
		checkerOf(userContext).throwExceptionIfHasErrors( ChainCodeManagerException.class);

 
 		return chainCodeDaoOf(userContext).load(chainCodeId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, ChainCode chainCode, Map<String, Object> tokens){
		super.addActions(userContext, chainCode, tokens);
		
		addAction(userContext, chainCode, tokens,"@create","createChainCode","createChainCode/","main","primary");
		addAction(userContext, chainCode, tokens,"@update","updateChainCode","updateChainCode/"+chainCode.getId()+"/","main","primary");
		addAction(userContext, chainCode, tokens,"@copy","cloneChainCode","cloneChainCode/"+chainCode.getId()+"/","main","primary");
		
		addAction(userContext, chainCode, tokens,"chain_code.transfer_to_channel","transferToAnotherChannel","transferToAnotherChannel/"+chainCode.getId()+"/","main","primary");
		addAction(userContext, chainCode, tokens,"chain_code.addServiceRecord","addServiceRecord","addServiceRecord/"+chainCode.getId()+"/","serviceRecordList","primary");
		addAction(userContext, chainCode, tokens,"chain_code.removeServiceRecord","removeServiceRecord","removeServiceRecord/"+chainCode.getId()+"/","serviceRecordList","primary");
		addAction(userContext, chainCode, tokens,"chain_code.updateServiceRecord","updateServiceRecord","updateServiceRecord/"+chainCode.getId()+"/","serviceRecordList","primary");
		addAction(userContext, chainCode, tokens,"chain_code.copyServiceRecordFrom","copyServiceRecordFrom","copyServiceRecordFrom/"+chainCode.getId()+"/","serviceRecordList","primary");
		addAction(userContext, chainCode, tokens,"chain_code.addChainCodeInvoker","addChainCodeInvoker","addChainCodeInvoker/"+chainCode.getId()+"/","chainCodeInvokerList","primary");
		addAction(userContext, chainCode, tokens,"chain_code.removeChainCodeInvoker","removeChainCodeInvoker","removeChainCodeInvoker/"+chainCode.getId()+"/","chainCodeInvokerList","primary");
		addAction(userContext, chainCode, tokens,"chain_code.updateChainCodeInvoker","updateChainCodeInvoker","updateChainCodeInvoker/"+chainCode.getId()+"/","chainCodeInvokerList","primary");
		addAction(userContext, chainCode, tokens,"chain_code.copyChainCodeInvokerFrom","copyChainCodeInvokerFrom","copyChainCodeInvokerFrom/"+chainCode.getId()+"/","chainCodeInvokerList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, ChainCode chainCode, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public ChainCode createChainCode(HfgwUserContext userContext, String name,String codeName,String codeVersion,String channelId) throws Exception
	//public ChainCode createChainCode(HfgwUserContext userContext,String name, String codeName, String codeVersion, String channelId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkNameOfChainCode(name);
		checkerOf(userContext).checkCodeNameOfChainCode(codeName);
		checkerOf(userContext).checkCodeVersionOfChainCode(codeVersion);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChainCodeManagerException.class);


		ChainCode chainCode=createNewChainCode();	

		chainCode.setName(name);
		chainCode.setCodeName(codeName);
		chainCode.setCodeVersion(codeVersion);
			
		Channel channel = loadChannel(userContext, channelId,emptyOptions());
		chainCode.setChannel(channel);
		
		

		chainCode = saveChainCode(userContext, chainCode, emptyOptions());
		
		onNewInstanceCreated(userContext, chainCode);
		return chainCode;

		
	}
	protected ChainCode createNewChainCode() 
	{
		
		return new ChainCode();		
	}
	
	protected void checkParamsForUpdatingChainCode(HfgwUserContext userContext,String chainCodeId, int chainCodeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfChainCode(chainCodeId);
		checkerOf(userContext).checkVersionOfChainCode( chainCodeVersion);
		

		if(ChainCode.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfChainCode(parseString(newValueExpr));
		}
		if(ChainCode.CODE_NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkCodeNameOfChainCode(parseString(newValueExpr));
		}
		if(ChainCode.CODE_VERSION_PROPERTY.equals(property)){
			checkerOf(userContext).checkCodeVersionOfChainCode(parseString(newValueExpr));
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChainCodeManagerException.class);
	
		
	}
	
	
	
	public ChainCode clone(HfgwUserContext userContext, String fromChainCodeId) throws Exception{
		
		return chainCodeDaoOf(userContext).clone(fromChainCodeId, this.allTokens());
	}
	
	public ChainCode internalSaveChainCode(HfgwUserContext userContext, ChainCode chainCode) throws Exception 
	{
		return internalSaveChainCode(userContext, chainCode, allTokens());

	}
	public ChainCode internalSaveChainCode(HfgwUserContext userContext, ChainCode chainCode, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingChainCode(userContext, chainCodeId, chainCodeVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(chainCode){ 
			//will be good when the chainCode loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ChainCode.
			if (chainCode.isChanged()){
			
			}
			chainCode = saveChainCode(userContext, chainCode, options);
			return chainCode;
			
		}

	}
	
	public ChainCode updateChainCode(HfgwUserContext userContext,String chainCodeId, int chainCodeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingChainCode(userContext, chainCodeId, chainCodeVersion, property, newValueExpr, tokensExpr);
		
		
		
		ChainCode chainCode = loadChainCode(userContext, chainCodeId, allTokens());
		if(chainCode.getVersion() != chainCodeVersion){
			String message = "The target version("+chainCode.getVersion()+") is not equals to version("+chainCodeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(chainCode){ 
			//will be good when the chainCode loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ChainCode.
			
			chainCode.changeProperty(property, newValueExpr);
			chainCode = saveChainCode(userContext, chainCode, tokens().done());
			return present(userContext,chainCode, mergedAllTokens(tokensExpr));
			//return saveChainCode(userContext, chainCode, tokens().done());
		}

	}
	
	public ChainCode updateChainCodeProperty(HfgwUserContext userContext,String chainCodeId, int chainCodeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingChainCode(userContext, chainCodeId, chainCodeVersion, property, newValueExpr, tokensExpr);
		
		ChainCode chainCode = loadChainCode(userContext, chainCodeId, allTokens());
		if(chainCode.getVersion() != chainCodeVersion){
			String message = "The target version("+chainCode.getVersion()+") is not equals to version("+chainCodeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(chainCode){ 
			//will be good when the chainCode loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ChainCode.
			
			chainCode.changeProperty(property, newValueExpr);
			
			chainCode = saveChainCode(userContext, chainCode, tokens().done());
			return present(userContext,chainCode, mergedAllTokens(tokensExpr));
			//return saveChainCode(userContext, chainCode, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ChainCodeTokens tokens(){
		return ChainCodeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ChainCodeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortServiceRecordListWith("id","desc")
		.sortChainCodeInvokerListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ChainCodeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherChannel(HfgwUserContext userContext, String chainCodeId, String anotherChannelId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfChainCode(chainCodeId);
 		checkerOf(userContext).checkIdOfChannel(anotherChannelId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ChainCodeManagerException.class);
 		
 	}
 	public ChainCode transferToAnotherChannel(HfgwUserContext userContext, String chainCodeId, String anotherChannelId) throws Exception
 	{
 		checkParamsForTransferingAnotherChannel(userContext, chainCodeId,anotherChannelId);
 
		ChainCode chainCode = loadChainCode(userContext, chainCodeId, allTokens());	
		synchronized(chainCode){
			//will be good when the chainCode loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Channel channel = loadChannel(userContext, anotherChannelId, emptyOptions());		
			chainCode.updateChannel(channel);		
			chainCode = saveChainCode(userContext, chainCode, emptyOptions());
			
			return present(userContext,chainCode, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateChannel requestCandidateChannel(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateChannel result = new CandidateChannel();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Channel> candidateList = channelDaoOf(userContext).requestCandidateChannelForChainCode(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Channel loadChannel(HfgwUserContext userContext, String newChannelId, Map<String,Object> options) throws Exception
 	{
		
 		return channelDaoOf(userContext).load(newChannelId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(HfgwUserContext userContext, String chainCodeId, int chainCodeVersion) throws Exception {
		//deleteInternal(userContext, chainCodeId, chainCodeVersion);		
	}
	protected void deleteInternal(HfgwUserContext userContext,
			String chainCodeId, int chainCodeVersion) throws Exception{
			
		chainCodeDaoOf(userContext).delete(chainCodeId, chainCodeVersion);
	}
	
	public ChainCode forgetByAll(HfgwUserContext userContext, String chainCodeId, int chainCodeVersion) throws Exception {
		return forgetByAllInternal(userContext, chainCodeId, chainCodeVersion);		
	}
	protected ChainCode forgetByAllInternal(HfgwUserContext userContext,
			String chainCodeId, int chainCodeVersion) throws Exception{
			
		return chainCodeDaoOf(userContext).disconnectFromAll(chainCodeId, chainCodeVersion);
	}
	
	

	
	public int deleteAll(HfgwUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ChainCodeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HfgwUserContext userContext) throws Exception{
		return chainCodeDaoOf(userContext).deleteAll();
	}


	//disconnect ChainCode with transaction_id in ServiceRecord
	protected ChainCode breakWithServiceRecordByTransactionId(HfgwUserContext userContext, String chainCodeId, String transactionIdId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ChainCode chainCode = loadChainCode(userContext, chainCodeId, allTokens());

			synchronized(chainCode){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				chainCodeDaoOf(userContext).planToRemoveServiceRecordListWithTransactionId(chainCode, transactionIdId, this.emptyOptions());

				chainCode = saveChainCode(userContext, chainCode, tokens().withServiceRecordList().done());
				return chainCode;
			}
	}
	//disconnect ChainCode with channel in ServiceRecord
	protected ChainCode breakWithServiceRecordByChannel(HfgwUserContext userContext, String chainCodeId, String channelId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ChainCode chainCode = loadChainCode(userContext, chainCodeId, allTokens());

			synchronized(chainCode){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				chainCodeDaoOf(userContext).planToRemoveServiceRecordListWithChannel(chainCode, channelId, this.emptyOptions());

				chainCode = saveChainCode(userContext, chainCode, tokens().withServiceRecordList().done());
				return chainCode;
			}
	}
	//disconnect ChainCode with block_id in ServiceRecord
	protected ChainCode breakWithServiceRecordByBlockId(HfgwUserContext userContext, String chainCodeId, String blockIdId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ChainCode chainCode = loadChainCode(userContext, chainCodeId, allTokens());

			synchronized(chainCode){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				chainCodeDaoOf(userContext).planToRemoveServiceRecordListWithBlockId(chainCode, blockIdId, this.emptyOptions());

				chainCode = saveChainCode(userContext, chainCode, tokens().withServiceRecordList().done());
				return chainCode;
			}
	}
	//disconnect ChainCode with app_client in ServiceRecord
	protected ChainCode breakWithServiceRecordByAppClient(HfgwUserContext userContext, String chainCodeId, String appClientId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ChainCode chainCode = loadChainCode(userContext, chainCodeId, allTokens());

			synchronized(chainCode){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				chainCodeDaoOf(userContext).planToRemoveServiceRecordListWithAppClient(chainCode, appClientId, this.emptyOptions());

				chainCode = saveChainCode(userContext, chainCode, tokens().withServiceRecordList().done());
				return chainCode;
			}
	}
	//disconnect ChainCode with network in ServiceRecord
	protected ChainCode breakWithServiceRecordByNetwork(HfgwUserContext userContext, String chainCodeId, String networkId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ChainCode chainCode = loadChainCode(userContext, chainCodeId, allTokens());

			synchronized(chainCode){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				chainCodeDaoOf(userContext).planToRemoveServiceRecordListWithNetwork(chainCode, networkId, this.emptyOptions());

				chainCode = saveChainCode(userContext, chainCode, tokens().withServiceRecordList().done());
				return chainCode;
			}
	}
	//disconnect ChainCode with status in ServiceRecord
	protected ChainCode breakWithServiceRecordByStatus(HfgwUserContext userContext, String chainCodeId, String statusId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ChainCode chainCode = loadChainCode(userContext, chainCodeId, allTokens());

			synchronized(chainCode){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				chainCodeDaoOf(userContext).planToRemoveServiceRecordListWithStatus(chainCode, statusId, this.emptyOptions());

				chainCode = saveChainCode(userContext, chainCode, tokens().withServiceRecordList().done());
				return chainCode;
			}
	}
	//disconnect ChainCode with app_client in ChainCodeInvoker
	protected ChainCode breakWithChainCodeInvokerByAppClient(HfgwUserContext userContext, String chainCodeId, String appClientId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ChainCode chainCode = loadChainCode(userContext, chainCodeId, allTokens());

			synchronized(chainCode){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				chainCodeDaoOf(userContext).planToRemoveChainCodeInvokerListWithAppClient(chainCode, appClientId, this.emptyOptions());

				chainCode = saveChainCode(userContext, chainCode, tokens().withChainCodeInvokerList().done());
				return chainCode;
			}
	}
	//disconnect ChainCode with change_request in ChainCodeInvoker
	protected ChainCode breakWithChainCodeInvokerByChangeRequest(HfgwUserContext userContext, String chainCodeId, String changeRequestId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ChainCode chainCode = loadChainCode(userContext, chainCodeId, allTokens());

			synchronized(chainCode){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				chainCodeDaoOf(userContext).planToRemoveChainCodeInvokerListWithChangeRequest(chainCode, changeRequestId, this.emptyOptions());

				chainCode = saveChainCode(userContext, chainCode, tokens().withChainCodeInvokerList().done());
				return chainCode;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingServiceRecord(HfgwUserContext userContext, String chainCodeId, String transactionId, String name, String payload, String channelId, String chainCodeFunction, String blockId, String appClientId, String networkId, String response, String statusId,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfChainCode(chainCodeId);

		
		checkerOf(userContext).checkTransactionIdOfServiceRecord(transactionId);
		
		checkerOf(userContext).checkNameOfServiceRecord(name);
		
		checkerOf(userContext).checkPayloadOfServiceRecord(payload);
		
		checkerOf(userContext).checkChannelIdOfServiceRecord(channelId);
		
		checkerOf(userContext).checkChainCodeFunctionOfServiceRecord(chainCodeFunction);
		
		checkerOf(userContext).checkBlockIdOfServiceRecord(blockId);
		
		checkerOf(userContext).checkAppClientIdOfServiceRecord(appClientId);
		
		checkerOf(userContext).checkNetworkIdOfServiceRecord(networkId);
		
		checkerOf(userContext).checkResponseOfServiceRecord(response);
		
		checkerOf(userContext).checkStatusIdOfServiceRecord(statusId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChainCodeManagerException.class);

	
	}
	public  ChainCode addServiceRecord(HfgwUserContext userContext, String chainCodeId, String transactionId, String name, String payload, String channelId, String chainCodeFunction, String blockId, String appClientId, String networkId, String response, String statusId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingServiceRecord(userContext,chainCodeId,transactionId, name, payload, channelId, chainCodeFunction, blockId, appClientId, networkId, response, statusId,tokensExpr);
		
		ServiceRecord serviceRecord = createServiceRecord(userContext,transactionId, name, payload, channelId, chainCodeFunction, blockId, appClientId, networkId, response, statusId);
		
		ChainCode chainCode = loadChainCode(userContext, chainCodeId, allTokens());
		synchronized(chainCode){ 
			//Will be good when the chainCode loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			chainCode.addServiceRecord( serviceRecord );		
			chainCode = saveChainCode(userContext, chainCode, tokens().withServiceRecordList().done());
			
			userContext.getManagerGroup().getServiceRecordManager().onNewInstanceCreated(userContext, serviceRecord);
			return present(userContext,chainCode, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingServiceRecordProperties(HfgwUserContext userContext, String chainCodeId,String id,String transactionId,String name,String payload,String chainCodeFunction,String blockId,String response,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfChainCode(chainCodeId);
		checkerOf(userContext).checkIdOfServiceRecord(id);
		
		checkerOf(userContext).checkTransactionIdOfServiceRecord( transactionId);
		checkerOf(userContext).checkNameOfServiceRecord( name);
		checkerOf(userContext).checkPayloadOfServiceRecord( payload);
		checkerOf(userContext).checkChainCodeFunctionOfServiceRecord( chainCodeFunction);
		checkerOf(userContext).checkBlockIdOfServiceRecord( blockId);
		checkerOf(userContext).checkResponseOfServiceRecord( response);

		checkerOf(userContext).throwExceptionIfHasErrors(ChainCodeManagerException.class);
		
	}
	public  ChainCode updateServiceRecordProperties(HfgwUserContext userContext, String chainCodeId, String id,String transactionId,String name,String payload,String chainCodeFunction,String blockId,String response, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingServiceRecordProperties(userContext,chainCodeId,id,transactionId,name,payload,chainCodeFunction,blockId,response,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withServiceRecordListList()
				.searchServiceRecordListWith(ServiceRecord.ID_PROPERTY, "is", id).done();
		
		ChainCode chainCodeToUpdate = loadChainCode(userContext, chainCodeId, options);
		
		if(chainCodeToUpdate.getServiceRecordList().isEmpty()){
			throw new ChainCodeManagerException("ServiceRecord is NOT FOUND with id: '"+id+"'");
		}
		
		ServiceRecord item = chainCodeToUpdate.getServiceRecordList().first();
		
		item.updateTransactionId( transactionId );
		item.updateName( name );
		item.updatePayload( payload );
		item.updateChainCodeFunction( chainCodeFunction );
		item.updateBlockId( blockId );
		item.updateResponse( response );

		
		//checkParamsForAddingServiceRecord(userContext,chainCodeId,name, code, used,tokensExpr);
		ChainCode chainCode = saveChainCode(userContext, chainCodeToUpdate, tokens().withServiceRecordList().done());
		synchronized(chainCode){ 
			return present(userContext,chainCode, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ServiceRecord createServiceRecord(HfgwUserContext userContext, String transactionId, String name, String payload, String channelId, String chainCodeFunction, String blockId, String appClientId, String networkId, String response, String statusId) throws Exception{

		ServiceRecord serviceRecord = new ServiceRecord();
		
		
		serviceRecord.setTransactionId(transactionId);		
		serviceRecord.setName(name);		
		serviceRecord.setPayload(payload);		
		Channel  channel = new Channel();
		channel.setId(channelId);		
		serviceRecord.setChannel(channel);		
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
		TransactionStatus  status = new TransactionStatus();
		status.setId(statusId);		
		serviceRecord.setStatus(status);
	
		
		return serviceRecord;
	
		
	}
	
	protected ServiceRecord createIndexedServiceRecord(String id, int version){

		ServiceRecord serviceRecord = new ServiceRecord();
		serviceRecord.setId(id);
		serviceRecord.setVersion(version);
		return serviceRecord;			
		
	}
	
	protected void checkParamsForRemovingServiceRecordList(HfgwUserContext userContext, String chainCodeId, 
			String serviceRecordIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfChainCode(chainCodeId);
		for(String serviceRecordIdItem: serviceRecordIds){
			checkerOf(userContext).checkIdOfServiceRecord(serviceRecordIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(ChainCodeManagerException.class);
		
	}
	public  ChainCode removeServiceRecordList(HfgwUserContext userContext, String chainCodeId, 
			String serviceRecordIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingServiceRecordList(userContext, chainCodeId,  serviceRecordIds, tokensExpr);
			
			
			ChainCode chainCode = loadChainCode(userContext, chainCodeId, allTokens());
			synchronized(chainCode){ 
				//Will be good when the chainCode loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				chainCodeDaoOf(userContext).planToRemoveServiceRecordList(chainCode, serviceRecordIds, allTokens());
				chainCode = saveChainCode(userContext, chainCode, tokens().withServiceRecordList().done());
				deleteRelationListInGraph(userContext, chainCode.getServiceRecordList());
				return present(userContext,chainCode, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingServiceRecord(HfgwUserContext userContext, String chainCodeId, 
		String serviceRecordId, int serviceRecordVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfChainCode( chainCodeId);
		checkerOf(userContext).checkIdOfServiceRecord(serviceRecordId);
		checkerOf(userContext).checkVersionOfServiceRecord(serviceRecordVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ChainCodeManagerException.class);
	
	}
	public  ChainCode removeServiceRecord(HfgwUserContext userContext, String chainCodeId, 
		String serviceRecordId, int serviceRecordVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingServiceRecord(userContext,chainCodeId, serviceRecordId, serviceRecordVersion,tokensExpr);
		
		ServiceRecord serviceRecord = createIndexedServiceRecord(serviceRecordId, serviceRecordVersion);
		ChainCode chainCode = loadChainCode(userContext, chainCodeId, allTokens());
		synchronized(chainCode){ 
			//Will be good when the chainCode loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			chainCode.removeServiceRecord( serviceRecord );		
			chainCode = saveChainCode(userContext, chainCode, tokens().withServiceRecordList().done());
			deleteRelationInGraph(userContext, serviceRecord);
			return present(userContext,chainCode, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingServiceRecord(HfgwUserContext userContext, String chainCodeId, 
		String serviceRecordId, int serviceRecordVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfChainCode( chainCodeId);
		checkerOf(userContext).checkIdOfServiceRecord(serviceRecordId);
		checkerOf(userContext).checkVersionOfServiceRecord(serviceRecordVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ChainCodeManagerException.class);
	
	}
	public  ChainCode copyServiceRecordFrom(HfgwUserContext userContext, String chainCodeId, 
		String serviceRecordId, int serviceRecordVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingServiceRecord(userContext,chainCodeId, serviceRecordId, serviceRecordVersion,tokensExpr);
		
		ServiceRecord serviceRecord = createIndexedServiceRecord(serviceRecordId, serviceRecordVersion);
		ChainCode chainCode = loadChainCode(userContext, chainCodeId, allTokens());
		synchronized(chainCode){ 
			//Will be good when the chainCode loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			chainCode.copyServiceRecordFrom( serviceRecord );		
			chainCode = saveChainCode(userContext, chainCode, tokens().withServiceRecordList().done());
			
			userContext.getManagerGroup().getServiceRecordManager().onNewInstanceCreated(userContext, (ServiceRecord)chainCode.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,chainCode, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingServiceRecord(HfgwUserContext userContext, String chainCodeId, String serviceRecordId, int serviceRecordVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfChainCode(chainCodeId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChainCodeManagerException.class);
	
	}
	
	public  ChainCode updateServiceRecord(HfgwUserContext userContext, String chainCodeId, String serviceRecordId, int serviceRecordVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingServiceRecord(userContext, chainCodeId, serviceRecordId, serviceRecordVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withServiceRecordList().searchServiceRecordListWith(ServiceRecord.ID_PROPERTY, "eq", serviceRecordId).done();
		
		
		
		ChainCode chainCode = loadChainCode(userContext, chainCodeId, loadTokens);
		
		synchronized(chainCode){ 
			//Will be good when the chainCode loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//chainCode.removeServiceRecord( serviceRecord );	
			//make changes to AcceleraterAccount.
			ServiceRecord serviceRecordIndex = createIndexedServiceRecord(serviceRecordId, serviceRecordVersion);
		
			ServiceRecord serviceRecord = chainCode.findTheServiceRecord(serviceRecordIndex);
			if(serviceRecord == null){
				throw new ChainCodeManagerException(serviceRecord+" is NOT FOUND" );
			}
			
			serviceRecord.changeProperty(property, newValueExpr);
			
			chainCode = saveChainCode(userContext, chainCode, tokens().withServiceRecordList().done());
			return present(userContext,chainCode, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingChainCodeInvoker(HfgwUserContext userContext, String chainCodeId, String appClientId, String parameters, String changeRequestId,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfChainCode(chainCodeId);

		
		checkerOf(userContext).checkAppClientIdOfChainCodeInvoker(appClientId);
		
		checkerOf(userContext).checkParametersOfChainCodeInvoker(parameters);
		
		checkerOf(userContext).checkChangeRequestIdOfChainCodeInvoker(changeRequestId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChainCodeManagerException.class);

	
	}
	public  ChainCode addChainCodeInvoker(HfgwUserContext userContext, String chainCodeId, String appClientId, String parameters, String changeRequestId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingChainCodeInvoker(userContext,chainCodeId,appClientId, parameters, changeRequestId,tokensExpr);
		
		ChainCodeInvoker chainCodeInvoker = createChainCodeInvoker(userContext,appClientId, parameters, changeRequestId);
		
		ChainCode chainCode = loadChainCode(userContext, chainCodeId, allTokens());
		synchronized(chainCode){ 
			//Will be good when the chainCode loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			chainCode.addChainCodeInvoker( chainCodeInvoker );		
			chainCode = saveChainCode(userContext, chainCode, tokens().withChainCodeInvokerList().done());
			
			userContext.getManagerGroup().getChainCodeInvokerManager().onNewInstanceCreated(userContext, chainCodeInvoker);
			return present(userContext,chainCode, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingChainCodeInvokerProperties(HfgwUserContext userContext, String chainCodeId,String id,String parameters,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfChainCode(chainCodeId);
		checkerOf(userContext).checkIdOfChainCodeInvoker(id);
		
		checkerOf(userContext).checkParametersOfChainCodeInvoker( parameters);

		checkerOf(userContext).throwExceptionIfHasErrors(ChainCodeManagerException.class);
		
	}
	public  ChainCode updateChainCodeInvokerProperties(HfgwUserContext userContext, String chainCodeId, String id,String parameters, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingChainCodeInvokerProperties(userContext,chainCodeId,id,parameters,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withChainCodeInvokerListList()
				.searchChainCodeInvokerListWith(ChainCodeInvoker.ID_PROPERTY, "is", id).done();
		
		ChainCode chainCodeToUpdate = loadChainCode(userContext, chainCodeId, options);
		
		if(chainCodeToUpdate.getChainCodeInvokerList().isEmpty()){
			throw new ChainCodeManagerException("ChainCodeInvoker is NOT FOUND with id: '"+id+"'");
		}
		
		ChainCodeInvoker item = chainCodeToUpdate.getChainCodeInvokerList().first();
		
		item.updateParameters( parameters );

		
		//checkParamsForAddingChainCodeInvoker(userContext,chainCodeId,name, code, used,tokensExpr);
		ChainCode chainCode = saveChainCode(userContext, chainCodeToUpdate, tokens().withChainCodeInvokerList().done());
		synchronized(chainCode){ 
			return present(userContext,chainCode, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ChainCodeInvoker createChainCodeInvoker(HfgwUserContext userContext, String appClientId, String parameters, String changeRequestId) throws Exception{

		ChainCodeInvoker chainCodeInvoker = new ChainCodeInvoker();
		
		
		Application  appClient = new Application();
		appClient.setId(appClientId);		
		chainCodeInvoker.setAppClient(appClient);		
		chainCodeInvoker.setParameters(parameters);		
		ChangeRequest  changeRequest = new ChangeRequest();
		changeRequest.setId(changeRequestId);		
		chainCodeInvoker.setChangeRequest(changeRequest);
	
		
		return chainCodeInvoker;
	
		
	}
	
	protected ChainCodeInvoker createIndexedChainCodeInvoker(String id, int version){

		ChainCodeInvoker chainCodeInvoker = new ChainCodeInvoker();
		chainCodeInvoker.setId(id);
		chainCodeInvoker.setVersion(version);
		return chainCodeInvoker;			
		
	}
	
	protected void checkParamsForRemovingChainCodeInvokerList(HfgwUserContext userContext, String chainCodeId, 
			String chainCodeInvokerIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfChainCode(chainCodeId);
		for(String chainCodeInvokerIdItem: chainCodeInvokerIds){
			checkerOf(userContext).checkIdOfChainCodeInvoker(chainCodeInvokerIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(ChainCodeManagerException.class);
		
	}
	public  ChainCode removeChainCodeInvokerList(HfgwUserContext userContext, String chainCodeId, 
			String chainCodeInvokerIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingChainCodeInvokerList(userContext, chainCodeId,  chainCodeInvokerIds, tokensExpr);
			
			
			ChainCode chainCode = loadChainCode(userContext, chainCodeId, allTokens());
			synchronized(chainCode){ 
				//Will be good when the chainCode loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				chainCodeDaoOf(userContext).planToRemoveChainCodeInvokerList(chainCode, chainCodeInvokerIds, allTokens());
				chainCode = saveChainCode(userContext, chainCode, tokens().withChainCodeInvokerList().done());
				deleteRelationListInGraph(userContext, chainCode.getChainCodeInvokerList());
				return present(userContext,chainCode, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingChainCodeInvoker(HfgwUserContext userContext, String chainCodeId, 
		String chainCodeInvokerId, int chainCodeInvokerVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfChainCode( chainCodeId);
		checkerOf(userContext).checkIdOfChainCodeInvoker(chainCodeInvokerId);
		checkerOf(userContext).checkVersionOfChainCodeInvoker(chainCodeInvokerVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ChainCodeManagerException.class);
	
	}
	public  ChainCode removeChainCodeInvoker(HfgwUserContext userContext, String chainCodeId, 
		String chainCodeInvokerId, int chainCodeInvokerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingChainCodeInvoker(userContext,chainCodeId, chainCodeInvokerId, chainCodeInvokerVersion,tokensExpr);
		
		ChainCodeInvoker chainCodeInvoker = createIndexedChainCodeInvoker(chainCodeInvokerId, chainCodeInvokerVersion);
		ChainCode chainCode = loadChainCode(userContext, chainCodeId, allTokens());
		synchronized(chainCode){ 
			//Will be good when the chainCode loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			chainCode.removeChainCodeInvoker( chainCodeInvoker );		
			chainCode = saveChainCode(userContext, chainCode, tokens().withChainCodeInvokerList().done());
			deleteRelationInGraph(userContext, chainCodeInvoker);
			return present(userContext,chainCode, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingChainCodeInvoker(HfgwUserContext userContext, String chainCodeId, 
		String chainCodeInvokerId, int chainCodeInvokerVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfChainCode( chainCodeId);
		checkerOf(userContext).checkIdOfChainCodeInvoker(chainCodeInvokerId);
		checkerOf(userContext).checkVersionOfChainCodeInvoker(chainCodeInvokerVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ChainCodeManagerException.class);
	
	}
	public  ChainCode copyChainCodeInvokerFrom(HfgwUserContext userContext, String chainCodeId, 
		String chainCodeInvokerId, int chainCodeInvokerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingChainCodeInvoker(userContext,chainCodeId, chainCodeInvokerId, chainCodeInvokerVersion,tokensExpr);
		
		ChainCodeInvoker chainCodeInvoker = createIndexedChainCodeInvoker(chainCodeInvokerId, chainCodeInvokerVersion);
		ChainCode chainCode = loadChainCode(userContext, chainCodeId, allTokens());
		synchronized(chainCode){ 
			//Will be good when the chainCode loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			chainCode.copyChainCodeInvokerFrom( chainCodeInvoker );		
			chainCode = saveChainCode(userContext, chainCode, tokens().withChainCodeInvokerList().done());
			
			userContext.getManagerGroup().getChainCodeInvokerManager().onNewInstanceCreated(userContext, (ChainCodeInvoker)chainCode.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,chainCode, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingChainCodeInvoker(HfgwUserContext userContext, String chainCodeId, String chainCodeInvokerId, int chainCodeInvokerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfChainCode(chainCodeId);
		checkerOf(userContext).checkIdOfChainCodeInvoker(chainCodeInvokerId);
		checkerOf(userContext).checkVersionOfChainCodeInvoker(chainCodeInvokerVersion);
		

		if(ChainCodeInvoker.PARAMETERS_PROPERTY.equals(property)){
			checkerOf(userContext).checkParametersOfChainCodeInvoker(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChainCodeManagerException.class);
	
	}
	
	public  ChainCode updateChainCodeInvoker(HfgwUserContext userContext, String chainCodeId, String chainCodeInvokerId, int chainCodeInvokerVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingChainCodeInvoker(userContext, chainCodeId, chainCodeInvokerId, chainCodeInvokerVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withChainCodeInvokerList().searchChainCodeInvokerListWith(ChainCodeInvoker.ID_PROPERTY, "eq", chainCodeInvokerId).done();
		
		
		
		ChainCode chainCode = loadChainCode(userContext, chainCodeId, loadTokens);
		
		synchronized(chainCode){ 
			//Will be good when the chainCode loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//chainCode.removeChainCodeInvoker( chainCodeInvoker );	
			//make changes to AcceleraterAccount.
			ChainCodeInvoker chainCodeInvokerIndex = createIndexedChainCodeInvoker(chainCodeInvokerId, chainCodeInvokerVersion);
		
			ChainCodeInvoker chainCodeInvoker = chainCode.findTheChainCodeInvoker(chainCodeInvokerIndex);
			if(chainCodeInvoker == null){
				throw new ChainCodeManagerException(chainCodeInvoker+" is NOT FOUND" );
			}
			
			chainCodeInvoker.changeProperty(property, newValueExpr);
			
			chainCode = saveChainCode(userContext, chainCode, tokens().withChainCodeInvokerList().done());
			return present(userContext,chainCode, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(HfgwUserContext userContext, ChainCode newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


