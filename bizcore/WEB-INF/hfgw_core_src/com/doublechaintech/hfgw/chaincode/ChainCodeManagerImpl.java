
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

import com.doublechaintech.hfgw.channel.CandidateChannel;

import com.doublechaintech.hfgw.chaincode.ChainCode;
import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.application.Application;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;






public class ChainCodeManagerImpl extends CustomHfgwCheckerManager implements ChainCodeManager {
	
	private static final String SERVICE_TYPE = "ChainCode";
	
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
	
	
	
	
	

	protected void checkParamsForAddingServiceRecord(HfgwUserContext userContext, String chainCodeId, String name, String payLoad, String channelId, String transactionId, String blockId, String networkId,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfChainCode(chainCodeId);

		
		checkerOf(userContext).checkNameOfServiceRecord(name);
		
		checkerOf(userContext).checkPayLoadOfServiceRecord(payLoad);
		
		checkerOf(userContext).checkChannelIdOfServiceRecord(channelId);
		
		checkerOf(userContext).checkTransactionIdOfServiceRecord(transactionId);
		
		checkerOf(userContext).checkBlockIdOfServiceRecord(blockId);
		
		checkerOf(userContext).checkNetworkIdOfServiceRecord(networkId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChainCodeManagerException.class);

	
	}
	public  ChainCode addServiceRecord(HfgwUserContext userContext, String chainCodeId, String name, String payLoad, String channelId, String transactionId, String blockId, String networkId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingServiceRecord(userContext,chainCodeId,name, payLoad, channelId, transactionId, blockId, networkId,tokensExpr);
		
		ServiceRecord serviceRecord = createServiceRecord(userContext,name, payLoad, channelId, transactionId, blockId, networkId);
		
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
	protected void checkParamsForUpdatingServiceRecordProperties(HfgwUserContext userContext, String chainCodeId,String id,String name,String payLoad,String transactionId,String blockId,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfChainCode(chainCodeId);
		checkerOf(userContext).checkIdOfServiceRecord(id);
		
		checkerOf(userContext).checkNameOfServiceRecord( name);
		checkerOf(userContext).checkPayLoadOfServiceRecord( payLoad);
		checkerOf(userContext).checkTransactionIdOfServiceRecord( transactionId);
		checkerOf(userContext).checkBlockIdOfServiceRecord( blockId);

		checkerOf(userContext).throwExceptionIfHasErrors(ChainCodeManagerException.class);
		
	}
	public  ChainCode updateServiceRecordProperties(HfgwUserContext userContext, String chainCodeId, String id,String name,String payLoad,String transactionId,String blockId, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingServiceRecordProperties(userContext,chainCodeId,id,name,payLoad,transactionId,blockId,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withServiceRecordListList()
				.searchServiceRecordListWith(ServiceRecord.ID_PROPERTY, "is", id).done();
		
		ChainCode chainCodeToUpdate = loadChainCode(userContext, chainCodeId, options);
		
		if(chainCodeToUpdate.getServiceRecordList().isEmpty()){
			throw new ChainCodeManagerException("ServiceRecord is NOT FOUND with id: '"+id+"'");
		}
		
		ServiceRecord item = chainCodeToUpdate.getServiceRecordList().first();
		
		item.updateName( name );
		item.updatePayLoad( payLoad );
		item.updateTransactionId( transactionId );
		item.updateBlockId( blockId );

		
		//checkParamsForAddingServiceRecord(userContext,chainCodeId,name, code, used,tokensExpr);
		ChainCode chainCode = saveChainCode(userContext, chainCodeToUpdate, tokens().withServiceRecordList().done());
		synchronized(chainCode){ 
			return present(userContext,chainCode, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ServiceRecord createServiceRecord(HfgwUserContext userContext, String name, String payLoad, String channelId, String transactionId, String blockId, String networkId) throws Exception{

		ServiceRecord serviceRecord = new ServiceRecord();
		
		
		serviceRecord.setName(name);		
		serviceRecord.setPayLoad(payLoad);		
		Channel  channel = new Channel();
		channel.setId(channelId);		
		serviceRecord.setChannel(channel);		
		serviceRecord.setTransactionId(transactionId);		
		serviceRecord.setBlockId(blockId);		
		serviceRecord.setCreateTime(userContext.now());		
		HyperledgerNetwork  network = new HyperledgerNetwork();
		network.setId(networkId);		
		serviceRecord.setNetwork(network);		
		serviceRecord.setCurrentStatus("INIT");
	
		
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
		

		if(ServiceRecord.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfServiceRecord(parseString(newValueExpr));
		}
		
		if(ServiceRecord.PAY_LOAD_PROPERTY.equals(property)){
			checkerOf(userContext).checkPayLoadOfServiceRecord(parseString(newValueExpr));
		}
		
		if(ServiceRecord.TRANSACTION_ID_PROPERTY.equals(property)){
			checkerOf(userContext).checkTransactionIdOfServiceRecord(parseString(newValueExpr));
		}
		
		if(ServiceRecord.BLOCK_ID_PROPERTY.equals(property)){
			checkerOf(userContext).checkBlockIdOfServiceRecord(parseString(newValueExpr));
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
	public  ChainCode associateServiceRecordListToNewApplication(HfgwUserContext userContext, String chainCodeId, String  serviceRecordIds[], String name, String mspid, String publicKey, String privateKey, String channelId, String networkId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchServiceRecordListWith(ServiceRecord.ID_PROPERTY, "oneof", this.joinArray("|", serviceRecordIds)).done();
		
		ChainCode chainCode = loadChainCode(userContext, chainCodeId, options);
		
		Application application = applicationManagerOf(userContext).createApplication(userContext,  name,  mspid,  publicKey,  privateKey, channelId, networkId);
		
		for(ServiceRecord serviceRecord: chainCode.getServiceRecordList()) {
			//TODO: need to check if already associated
			serviceRecord.updateApplication(application);
		}
		return this.internalSaveChainCode(userContext, chainCode);
	}
	*/
	
	public  ChainCode associateServiceRecordListToApplication(HfgwUserContext userContext, String chainCodeId, String  serviceRecordIds[], String applicationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchServiceRecordListWith(ServiceRecord.ID_PROPERTY, "oneof", this.joinArray("|", serviceRecordIds)).done();
		
		ChainCode chainCode = loadChainCode(userContext, chainCodeId, options);
		
		Application application = applicationManagerOf(userContext).loadApplication(userContext,applicationId,new String[]{"none"} );
		
		for(ServiceRecord serviceRecord: chainCode.getServiceRecordList()) {
			//TODO: need to check if already associated
			serviceRecord.updateApplication(application);
		}
		return this.internalSaveChainCode(userContext, chainCode);
	}


	public void onNewInstanceCreated(HfgwUserContext userContext, ChainCode newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


