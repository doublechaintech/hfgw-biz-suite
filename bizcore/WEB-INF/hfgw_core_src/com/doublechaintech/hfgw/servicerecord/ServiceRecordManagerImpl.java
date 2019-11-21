
package com.doublechaintech.hfgw.servicerecord;

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

import com.doublechaintech.hfgw.chaincode.ChainCode;
import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.application.Application;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

import com.doublechaintech.hfgw.chaincode.CandidateChainCode;
import com.doublechaintech.hfgw.channel.CandidateChannel;
import com.doublechaintech.hfgw.application.CandidateApplication;
import com.doublechaintech.hfgw.hyperledgernetwork.CandidateHyperledgerNetwork;


import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;





public class ServiceRecordManagerImpl extends CustomHfgwCheckerManager implements ServiceRecordManager {
	
	private static final String SERVICE_TYPE = "ServiceRecord";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ServiceRecordManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ServiceRecordManagerException(message);

	}
	
	

 	protected ServiceRecord saveServiceRecord(HfgwUserContext userContext, ServiceRecord serviceRecord, String [] tokensExpr) throws Exception{	
 		//return getServiceRecordDAO().save(serviceRecord, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveServiceRecord(userContext, serviceRecord, tokens);
 	}
 	
 	protected ServiceRecord saveServiceRecordDetail(HfgwUserContext userContext, ServiceRecord serviceRecord) throws Exception{	

 		
 		return saveServiceRecord(userContext, serviceRecord, allTokens());
 	}
 	
 	public ServiceRecord loadServiceRecord(HfgwUserContext userContext, String serviceRecordId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfServiceRecord(serviceRecordId);
		checkerOf(userContext).throwExceptionIfHasErrors( ServiceRecordManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ServiceRecord serviceRecord = loadServiceRecord( userContext, serviceRecordId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,serviceRecord, tokens);
 	}
 	
 	
 	 public ServiceRecord searchServiceRecord(HfgwUserContext userContext, String serviceRecordId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfServiceRecord(serviceRecordId);
		checkerOf(userContext).throwExceptionIfHasErrors( ServiceRecordManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ServiceRecord serviceRecord = loadServiceRecord( userContext, serviceRecordId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,serviceRecord, tokens);
 	}
 	
 	

 	protected ServiceRecord present(HfgwUserContext userContext, ServiceRecord serviceRecord, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,serviceRecord,tokens);
		
		
		ServiceRecord  serviceRecordToPresent = serviceRecordDaoOf(userContext).present(serviceRecord, tokens);
		
		List<BaseEntity> entityListToNaming = serviceRecordToPresent.collectRefercencesFromLists();
		serviceRecordDaoOf(userContext).alias(entityListToNaming);
		
		return  serviceRecordToPresent;
		
		
	}
 
 	
 	
 	public ServiceRecord loadServiceRecordDetail(HfgwUserContext userContext, String serviceRecordId) throws Exception{	
 		ServiceRecord serviceRecord = loadServiceRecord( userContext, serviceRecordId, allTokens());
 		return present(userContext,serviceRecord, allTokens());
		
 	}
 	
 	public Object view(HfgwUserContext userContext, String serviceRecordId) throws Exception{	
 		ServiceRecord serviceRecord = loadServiceRecord( userContext, serviceRecordId, viewTokens());
 		return present(userContext,serviceRecord, allTokens());
		
 	}
 	protected ServiceRecord saveServiceRecord(HfgwUserContext userContext, ServiceRecord serviceRecord, Map<String,Object>tokens) throws Exception{	
 		return serviceRecordDaoOf(userContext).save(serviceRecord, tokens);
 	}
 	protected ServiceRecord loadServiceRecord(HfgwUserContext userContext, String serviceRecordId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfServiceRecord(serviceRecordId);
		checkerOf(userContext).throwExceptionIfHasErrors( ServiceRecordManagerException.class);

 
 		return serviceRecordDaoOf(userContext).load(serviceRecordId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, ServiceRecord serviceRecord, Map<String, Object> tokens){
		super.addActions(userContext, serviceRecord, tokens);
		
		addAction(userContext, serviceRecord, tokens,"@create","createServiceRecord","createServiceRecord/","main","primary");
		addAction(userContext, serviceRecord, tokens,"@update","updateServiceRecord","updateServiceRecord/"+serviceRecord.getId()+"/","main","primary");
		addAction(userContext, serviceRecord, tokens,"@copy","cloneServiceRecord","cloneServiceRecord/"+serviceRecord.getId()+"/","main","primary");
		
		addAction(userContext, serviceRecord, tokens,"service_record.transfer_to_channel","transferToAnotherChannel","transferToAnotherChannel/"+serviceRecord.getId()+"/","main","primary");
		addAction(userContext, serviceRecord, tokens,"service_record.transfer_to_chain_code","transferToAnotherChainCode","transferToAnotherChainCode/"+serviceRecord.getId()+"/","main","primary");
		addAction(userContext, serviceRecord, tokens,"service_record.transfer_to_network","transferToAnotherNetwork","transferToAnotherNetwork/"+serviceRecord.getId()+"/","main","primary");
		addAction(userContext, serviceRecord, tokens,"service_record.apply","apply","applyActionForm/"+serviceRecord.getId()+"/","main","info");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, ServiceRecord serviceRecord, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public ServiceRecord createServiceRecord(HfgwUserContext userContext, String name,String payLoad,String channelId,String chainCodeId,String chainCodeFunction,String transactionId,String blockId,String networkId) throws Exception
	//public ServiceRecord createServiceRecord(HfgwUserContext userContext,String name, String payLoad, String channelId, String chainCodeId, String chainCodeFunction, String transactionId, String blockId, String networkId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkNameOfServiceRecord(name);
		checkerOf(userContext).checkPayLoadOfServiceRecord(payLoad);
		checkerOf(userContext).checkChainCodeFunctionOfServiceRecord(chainCodeFunction);
		checkerOf(userContext).checkTransactionIdOfServiceRecord(transactionId);
		checkerOf(userContext).checkBlockIdOfServiceRecord(blockId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ServiceRecordManagerException.class);


		ServiceRecord serviceRecord=createNewServiceRecord();	

		serviceRecord.setName(name);
		serviceRecord.setPayLoad(payLoad);
			
		Channel channel = loadChannel(userContext, channelId,emptyOptions());
		serviceRecord.setChannel(channel);
		
		
			
		ChainCode chainCode = loadChainCode(userContext, chainCodeId,emptyOptions());
		serviceRecord.setChainCode(chainCode);
		
		
		serviceRecord.setChainCodeFunction(chainCodeFunction);
		serviceRecord.setTransactionId(transactionId);
		serviceRecord.setBlockId(blockId);
		serviceRecord.setCreateTime(userContext.now());
			
		HyperledgerNetwork network = loadHyperledgerNetwork(userContext, networkId,emptyOptions());
		serviceRecord.setNetwork(network);
		
		
		serviceRecord.setCurrentStatus("INIT");

		serviceRecord = saveServiceRecord(userContext, serviceRecord, emptyOptions());
		
		onNewInstanceCreated(userContext, serviceRecord);
		return serviceRecord;

		
	}
	protected ServiceRecord createNewServiceRecord() 
	{
		
		return new ServiceRecord();		
	}
	
	protected void checkParamsForUpdatingServiceRecord(HfgwUserContext userContext,String serviceRecordId, int serviceRecordVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfServiceRecord(serviceRecordId);
		checkerOf(userContext).checkVersionOfServiceRecord( serviceRecordVersion);
		

		if(ServiceRecord.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfServiceRecord(parseString(newValueExpr));
		}
		if(ServiceRecord.PAY_LOAD_PROPERTY.equals(property)){
			checkerOf(userContext).checkPayLoadOfServiceRecord(parseString(newValueExpr));
		}		

				

		
		if(ServiceRecord.CHAIN_CODE_FUNCTION_PROPERTY.equals(property)){
			checkerOf(userContext).checkChainCodeFunctionOfServiceRecord(parseString(newValueExpr));
		}
		if(ServiceRecord.TRANSACTION_ID_PROPERTY.equals(property)){
			checkerOf(userContext).checkTransactionIdOfServiceRecord(parseString(newValueExpr));
		}
		if(ServiceRecord.BLOCK_ID_PROPERTY.equals(property)){
			checkerOf(userContext).checkBlockIdOfServiceRecord(parseString(newValueExpr));
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ServiceRecordManagerException.class);
	
		
	}
	
	
	
	public ServiceRecord clone(HfgwUserContext userContext, String fromServiceRecordId) throws Exception{
		
		return serviceRecordDaoOf(userContext).clone(fromServiceRecordId, this.allTokens());
	}
	
	public ServiceRecord internalSaveServiceRecord(HfgwUserContext userContext, ServiceRecord serviceRecord) throws Exception 
	{
		return internalSaveServiceRecord(userContext, serviceRecord, allTokens());

	}
	public ServiceRecord internalSaveServiceRecord(HfgwUserContext userContext, ServiceRecord serviceRecord, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingServiceRecord(userContext, serviceRecordId, serviceRecordVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(serviceRecord){ 
			//will be good when the serviceRecord loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ServiceRecord.
			if (serviceRecord.isChanged()){
			
			}
			serviceRecord = saveServiceRecord(userContext, serviceRecord, options);
			return serviceRecord;
			
		}

	}
	
	public ServiceRecord updateServiceRecord(HfgwUserContext userContext,String serviceRecordId, int serviceRecordVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingServiceRecord(userContext, serviceRecordId, serviceRecordVersion, property, newValueExpr, tokensExpr);
		
		
		
		ServiceRecord serviceRecord = loadServiceRecord(userContext, serviceRecordId, allTokens());
		if(serviceRecord.getVersion() != serviceRecordVersion){
			String message = "The target version("+serviceRecord.getVersion()+") is not equals to version("+serviceRecordVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(serviceRecord){ 
			//will be good when the serviceRecord loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ServiceRecord.
			
			serviceRecord.changeProperty(property, newValueExpr);
			serviceRecord = saveServiceRecord(userContext, serviceRecord, tokens().done());
			return present(userContext,serviceRecord, mergedAllTokens(tokensExpr));
			//return saveServiceRecord(userContext, serviceRecord, tokens().done());
		}

	}
	
	public ServiceRecord updateServiceRecordProperty(HfgwUserContext userContext,String serviceRecordId, int serviceRecordVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingServiceRecord(userContext, serviceRecordId, serviceRecordVersion, property, newValueExpr, tokensExpr);
		
		ServiceRecord serviceRecord = loadServiceRecord(userContext, serviceRecordId, allTokens());
		if(serviceRecord.getVersion() != serviceRecordVersion){
			String message = "The target version("+serviceRecord.getVersion()+") is not equals to version("+serviceRecordVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(serviceRecord){ 
			//will be good when the serviceRecord loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ServiceRecord.
			
			serviceRecord.changeProperty(property, newValueExpr);
			
			serviceRecord = saveServiceRecord(userContext, serviceRecord, tokens().done());
			return present(userContext,serviceRecord, mergedAllTokens(tokensExpr));
			//return saveServiceRecord(userContext, serviceRecord, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ServiceRecordTokens tokens(){
		return ServiceRecordTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ServiceRecordTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ServiceRecordTokens.mergeAll(tokens).done();
	}
	
	private static final String [] STATUS_SEQUENCE={"APPLIED"};
 	protected String[] getNextCandidateStatus(HfgwUserContext userContext, String currentStatus) throws Exception{
 	
 		if("INIT".equals(currentStatus)){
 			//if current status is null, just return the first status as the next status
 			//code makes sure not throwing ArrayOutOfIndexException here.
 			return STATUS_SEQUENCE;
 		}
 		/*
 		List<String> statusList = Arrays.asList(STATUS_SEQUENCE);
 		int index = statusList.indexOf(currentStatus);
 		if(index < 0){
 			throwExceptionWithMessage("The status '"+currentStatus+"' is not found from status list: "+ statusList );
 		}
 		if(index + 1 == statusList.size()){
 			//this is the last status code; no next status any more
 			return null;
 		}
 		
 		//this is not the last one, just return it.
 		*/
 		return STATUS_SEQUENCE;
 	
 	}/**/
 	protected void ensureStatus(HfgwUserContext userContext, ServiceRecord serviceRecord, String expectedNextStatus) throws Exception{
		String currentStatus = serviceRecord.getCurrentStatus();
		//'null' is fine for function getNextStatus
		String candidateStatus[] = getNextCandidateStatus(userContext, currentStatus);
		
		if(candidateStatus == null){
			//no more next status
			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'HIDDEN'";
			throwExceptionWithMessage(message);
		}
		int index = Arrays.asList(candidateStatus).indexOf(expectedNextStatus);
		if(index<0){
			String message = "The current status '"+currentStatus+"' next candidate status should be one of '"+candidateStatus+"', but you want to transit the status to '"+expectedNextStatus+"'";
			throwExceptionWithMessage(message);
		}
	}
	
	protected void checkParamsForTransferingAnotherChannel(HfgwUserContext userContext, String serviceRecordId, String anotherChannelId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfServiceRecord(serviceRecordId);
 		checkerOf(userContext).checkIdOfChannel(anotherChannelId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ServiceRecordManagerException.class);
 		
 	}
 	public ServiceRecord transferToAnotherChannel(HfgwUserContext userContext, String serviceRecordId, String anotherChannelId) throws Exception
 	{
 		checkParamsForTransferingAnotherChannel(userContext, serviceRecordId,anotherChannelId);
 
		ServiceRecord serviceRecord = loadServiceRecord(userContext, serviceRecordId, allTokens());	
		synchronized(serviceRecord){
			//will be good when the serviceRecord loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Channel channel = loadChannel(userContext, anotherChannelId, emptyOptions());		
			serviceRecord.updateChannel(channel);		
			serviceRecord = saveServiceRecord(userContext, serviceRecord, emptyOptions());
			
			return present(userContext,serviceRecord, allTokens());
			
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
		SmartList<Channel> candidateList = channelDaoOf(userContext).requestCandidateChannelForServiceRecord(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherChainCode(HfgwUserContext userContext, String serviceRecordId, String anotherChainCodeId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfServiceRecord(serviceRecordId);
 		checkerOf(userContext).checkIdOfChainCode(anotherChainCodeId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ServiceRecordManagerException.class);
 		
 	}
 	public ServiceRecord transferToAnotherChainCode(HfgwUserContext userContext, String serviceRecordId, String anotherChainCodeId) throws Exception
 	{
 		checkParamsForTransferingAnotherChainCode(userContext, serviceRecordId,anotherChainCodeId);
 
		ServiceRecord serviceRecord = loadServiceRecord(userContext, serviceRecordId, allTokens());	
		synchronized(serviceRecord){
			//will be good when the serviceRecord loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ChainCode chainCode = loadChainCode(userContext, anotherChainCodeId, emptyOptions());		
			serviceRecord.updateChainCode(chainCode);		
			serviceRecord = saveServiceRecord(userContext, serviceRecord, emptyOptions());
			
			return present(userContext,serviceRecord, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateChainCode requestCandidateChainCode(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateChainCode result = new CandidateChainCode();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<ChainCode> candidateList = chainCodeDaoOf(userContext).requestCandidateChainCodeForServiceRecord(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherApplication(HfgwUserContext userContext, String serviceRecordId, String anotherApplicationId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfServiceRecord(serviceRecordId);
 		checkerOf(userContext).checkIdOfApplication(anotherApplicationId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ServiceRecordManagerException.class);
 		
 	}
 	public ServiceRecord transferToAnotherApplication(HfgwUserContext userContext, String serviceRecordId, String anotherApplicationId) throws Exception
 	{
 		checkParamsForTransferingAnotherApplication(userContext, serviceRecordId,anotherApplicationId);
 
		ServiceRecord serviceRecord = loadServiceRecord(userContext, serviceRecordId, allTokens());	
		synchronized(serviceRecord){
			//will be good when the serviceRecord loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Application application = loadApplication(userContext, anotherApplicationId, emptyOptions());		
			serviceRecord.updateApplication(application);		
			serviceRecord = saveServiceRecord(userContext, serviceRecord, emptyOptions());
			
			return present(userContext,serviceRecord, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateApplication requestCandidateApplication(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateApplication result = new CandidateApplication();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Application> candidateList = applicationDaoOf(userContext).requestCandidateApplicationForServiceRecord(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String APPLIED_STATUS = "APPLIED";
 	protected void checkParamsForApplication(HfgwUserContext userContext, String serviceRecordId, String name, String mspid, String publicKey, String privateKey, String channelId, String networkId
) throws Exception
 	{
 				checkerOf(userContext).checkIdOfServiceRecord(serviceRecordId);
		checkerOf(userContext).checkNameOfApplication(name);
		checkerOf(userContext).checkMspidOfApplication(mspid);
		checkerOf(userContext).checkPublicKeyOfApplication(publicKey);
		checkerOf(userContext).checkPrivateKeyOfApplication(privateKey);
		checkerOf(userContext).checkIdOfChannel(channelId);
		checkerOf(userContext).checkIdOfHyperledgerNetwork(networkId);

	
		checkerOf(userContext).throwExceptionIfHasErrors(ServiceRecordManagerException.class);

 	}
 	public ServiceRecord apply(HfgwUserContext userContext, String serviceRecordId, String name, String mspid, String publicKey, String privateKey, String channelId, String networkId
) throws Exception
 	{
		checkParamsForApplication(userContext, serviceRecordId, name, mspid, publicKey, privateKey, channelId, networkId);
		ServiceRecord serviceRecord = loadServiceRecord(userContext, serviceRecordId, allTokens());	
		synchronized(serviceRecord){
			//will be good when the serviceRecord loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForApplication(userContext,serviceRecord);
 		

			serviceRecord.updateCurrentStatus(APPLIED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively
			Channel channel = loadChannel(userContext, channelId, emptyOptions());
			HyperledgerNetwork network = loadHyperledgerNetwork(userContext, networkId, emptyOptions());


			Application application = createApplication(userContext, name, mspid, publicKey, privateKey, channel, network);		
			serviceRecord.updateApplication(application);		
			
			
			serviceRecord = saveServiceRecord(userContext, serviceRecord, tokens().withApplication().done());
			return present(userContext,serviceRecord, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public ServiceRecordForm applyActionForm(HfgwUserContext userContext, String serviceRecordId) throws Exception
 	{
		return new ServiceRecordForm()
			.withTitle("apply")
			.serviceRecordIdField(serviceRecordId)
			.nameFieldOfApplication()
			.mspidFieldOfApplication()
			.publicKeyFieldOfApplication()
			.privateKeyFieldOfApplication()
			.channelIdFieldOfApplication()
			.networkIdFieldOfApplication()
			.applyAction();
 	}
	
 	
 	protected Application createApplication(HfgwUserContext userContext, String name, String mspid, String publicKey, String privateKey, Channel channel, HyperledgerNetwork network){
 		Application application = new Application();
 		//name, mspid, publicKey, privateKey, channel, network
 		
		application.setName(name);
		application.setCreateTime(userContext.now());
		application.setMspid(mspid);
		application.setPublicKey(publicKey);
		application.setPrivateKey(privateKey);
		application.setChannel(channel);
		application.setNetwork(network);

 		
 		
 		
 		return applicationDaoOf(userContext).save(application,emptyOptions());
 	}
 	protected void checkIfEligibleForApplication(HfgwUserContext userContext, ServiceRecord serviceRecord) throws Exception{
 
 		ensureStatus(userContext,serviceRecord, APPLIED_STATUS);
 		
 		Application application = serviceRecord.getApplication();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = application 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( application != null){
				throwExceptionWithMessage("The ServiceRecord("+serviceRecord.getId()+") has already been "+ APPLIED_STATUS+".");
		}
 		
 		
 	}
	protected void checkParamsForTransferingAnotherNetwork(HfgwUserContext userContext, String serviceRecordId, String anotherNetworkId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfServiceRecord(serviceRecordId);
 		checkerOf(userContext).checkIdOfHyperledgerNetwork(anotherNetworkId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ServiceRecordManagerException.class);
 		
 	}
 	public ServiceRecord transferToAnotherNetwork(HfgwUserContext userContext, String serviceRecordId, String anotherNetworkId) throws Exception
 	{
 		checkParamsForTransferingAnotherNetwork(userContext, serviceRecordId,anotherNetworkId);
 
		ServiceRecord serviceRecord = loadServiceRecord(userContext, serviceRecordId, allTokens());	
		synchronized(serviceRecord){
			//will be good when the serviceRecord loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			HyperledgerNetwork network = loadHyperledgerNetwork(userContext, anotherNetworkId, emptyOptions());		
			serviceRecord.updateNetwork(network);		
			serviceRecord = saveServiceRecord(userContext, serviceRecord, emptyOptions());
			
			return present(userContext,serviceRecord, allTokens());
			
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
		SmartList<HyperledgerNetwork> candidateList = hyperledgerNetworkDaoOf(userContext).requestCandidateHyperledgerNetworkForServiceRecord(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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
 	
 	
 	
	
	 	
 	protected ChainCode loadChainCode(HfgwUserContext userContext, String newChainCodeId, Map<String,Object> options) throws Exception
 	{
		
 		return chainCodeDaoOf(userContext).load(newChainCodeId, options);
 	}
 	
 	
 	
	
	 	
 	protected HyperledgerNetwork loadHyperledgerNetwork(HfgwUserContext userContext, String newNetworkId, Map<String,Object> options) throws Exception
 	{
		
 		return hyperledgerNetworkDaoOf(userContext).load(newNetworkId, options);
 	}
 	
 	
 	
	
	 	
 	protected Application loadApplication(HfgwUserContext userContext, String newApplicationId, Map<String,Object> options) throws Exception
 	{
		
 		return applicationDaoOf(userContext).load(newApplicationId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(HfgwUserContext userContext, String serviceRecordId, int serviceRecordVersion) throws Exception {
		//deleteInternal(userContext, serviceRecordId, serviceRecordVersion);		
	}
	protected void deleteInternal(HfgwUserContext userContext,
			String serviceRecordId, int serviceRecordVersion) throws Exception{
			
		serviceRecordDaoOf(userContext).delete(serviceRecordId, serviceRecordVersion);
	}
	
	public ServiceRecord forgetByAll(HfgwUserContext userContext, String serviceRecordId, int serviceRecordVersion) throws Exception {
		return forgetByAllInternal(userContext, serviceRecordId, serviceRecordVersion);		
	}
	protected ServiceRecord forgetByAllInternal(HfgwUserContext userContext,
			String serviceRecordId, int serviceRecordVersion) throws Exception{
			
		return serviceRecordDaoOf(userContext).disconnectFromAll(serviceRecordId, serviceRecordVersion);
	}
	
	

	
	public int deleteAll(HfgwUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ServiceRecordManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HfgwUserContext userContext) throws Exception{
		return serviceRecordDaoOf(userContext).deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(HfgwUserContext userContext, ServiceRecord newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


