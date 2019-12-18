
package com.doublechaintech.hfgw.application;

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
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;
import com.doublechaintech.hfgw.chaincodeinvoker.ChainCodeInvoker;

import com.doublechaintech.hfgw.channel.CandidateChannel;
import com.doublechaintech.hfgw.hyperledgernetwork.CandidateHyperledgerNetwork;

import com.doublechaintech.hfgw.chaincode.ChainCode;
import com.doublechaintech.hfgw.transactionstatus.TransactionStatus;
import com.doublechaintech.hfgw.changerequest.ChangeRequest;
import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.application.Application;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;






public class ApplicationManagerImpl extends CustomHfgwCheckerManager implements ApplicationManager {
	
	private static final String SERVICE_TYPE = "Application";
	@Override
	public ApplicationDAO daoOf(HfgwUserContext userContext) {
		return applicationDaoOf(userContext);
	}
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ApplicationManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ApplicationManagerException(message);

	}
	
	

 	protected Application saveApplication(HfgwUserContext userContext, Application application, String [] tokensExpr) throws Exception{	
 		//return getApplicationDAO().save(application, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveApplication(userContext, application, tokens);
 	}
 	
 	protected Application saveApplicationDetail(HfgwUserContext userContext, Application application) throws Exception{	

 		
 		return saveApplication(userContext, application, allTokens());
 	}
 	
 	public Application loadApplication(HfgwUserContext userContext, String applicationId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfApplication(applicationId);
		checkerOf(userContext).throwExceptionIfHasErrors( ApplicationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Application application = loadApplication( userContext, applicationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,application, tokens);
 	}
 	
 	
 	 public Application searchApplication(HfgwUserContext userContext, String applicationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfApplication(applicationId);
		checkerOf(userContext).throwExceptionIfHasErrors( ApplicationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Application application = loadApplication( userContext, applicationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,application, tokens);
 	}
 	
 	

 	protected Application present(HfgwUserContext userContext, Application application, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,application,tokens);
		
		
		Application  applicationToPresent = applicationDaoOf(userContext).present(application, tokens);
		
		List<BaseEntity> entityListToNaming = applicationToPresent.collectRefercencesFromLists();
		applicationDaoOf(userContext).alias(entityListToNaming);
		
		return  applicationToPresent;
		
		
	}
 
 	
 	
 	public Application loadApplicationDetail(HfgwUserContext userContext, String applicationId) throws Exception{	
 		Application application = loadApplication( userContext, applicationId, allTokens());
 		return present(userContext,application, allTokens());
		
 	}
 	
 	public Object view(HfgwUserContext userContext, String applicationId) throws Exception{	
 		Application application = loadApplication( userContext, applicationId, viewTokens());
 		return present(userContext,application, allTokens());
		
 	}
 	protected Application saveApplication(HfgwUserContext userContext, Application application, Map<String,Object>tokens) throws Exception{	
 		return applicationDaoOf(userContext).save(application, tokens);
 	}
 	protected Application loadApplication(HfgwUserContext userContext, String applicationId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfApplication(applicationId);
		checkerOf(userContext).throwExceptionIfHasErrors( ApplicationManagerException.class);

 
 		return applicationDaoOf(userContext).load(applicationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, Application application, Map<String, Object> tokens){
		super.addActions(userContext, application, tokens);
		
		addAction(userContext, application, tokens,"@create","createApplication","createApplication/","main","primary");
		addAction(userContext, application, tokens,"@update","updateApplication","updateApplication/"+application.getId()+"/","main","primary");
		addAction(userContext, application, tokens,"@copy","cloneApplication","cloneApplication/"+application.getId()+"/","main","primary");
		
		addAction(userContext, application, tokens,"application.transfer_to_channel","transferToAnotherChannel","transferToAnotherChannel/"+application.getId()+"/","main","primary");
		addAction(userContext, application, tokens,"application.transfer_to_network","transferToAnotherNetwork","transferToAnotherNetwork/"+application.getId()+"/","main","primary");
		addAction(userContext, application, tokens,"application.addServiceRecord","addServiceRecord","addServiceRecord/"+application.getId()+"/","serviceRecordList","primary");
		addAction(userContext, application, tokens,"application.removeServiceRecord","removeServiceRecord","removeServiceRecord/"+application.getId()+"/","serviceRecordList","primary");
		addAction(userContext, application, tokens,"application.updateServiceRecord","updateServiceRecord","updateServiceRecord/"+application.getId()+"/","serviceRecordList","primary");
		addAction(userContext, application, tokens,"application.copyServiceRecordFrom","copyServiceRecordFrom","copyServiceRecordFrom/"+application.getId()+"/","serviceRecordList","primary");
		addAction(userContext, application, tokens,"application.addChainCodeInvoker","addChainCodeInvoker","addChainCodeInvoker/"+application.getId()+"/","chainCodeInvokerList","primary");
		addAction(userContext, application, tokens,"application.removeChainCodeInvoker","removeChainCodeInvoker","removeChainCodeInvoker/"+application.getId()+"/","chainCodeInvokerList","primary");
		addAction(userContext, application, tokens,"application.updateChainCodeInvoker","updateChainCodeInvoker","updateChainCodeInvoker/"+application.getId()+"/","chainCodeInvokerList","primary");
		addAction(userContext, application, tokens,"application.copyChainCodeInvokerFrom","copyChainCodeInvokerFrom","copyChainCodeInvokerFrom/"+application.getId()+"/","chainCodeInvokerList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, Application application, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public Application createApplication(HfgwUserContext userContext, String name,String mspid,String publicKey,String privateKey,String channelId,String networkId) throws Exception
	//public Application createApplication(HfgwUserContext userContext,String name, String mspid, String publicKey, String privateKey, String channelId, String networkId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkNameOfApplication(name);
		checkerOf(userContext).checkMspidOfApplication(mspid);
		checkerOf(userContext).checkPublicKeyOfApplication(publicKey);
		checkerOf(userContext).checkPrivateKeyOfApplication(privateKey);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ApplicationManagerException.class);


		Application application=createNewApplication();	

		application.setName(name);
		application.setCreateTime(userContext.now());
		application.setMspid(mspid);
		application.setPublicKey(publicKey);
		application.setPrivateKey(privateKey);
			
		Channel channel = loadChannel(userContext, channelId,emptyOptions());
		application.setChannel(channel);
		
		
			
		HyperledgerNetwork network = loadHyperledgerNetwork(userContext, networkId,emptyOptions());
		application.setNetwork(network);
		
		

		application = saveApplication(userContext, application, emptyOptions());
		
		onNewInstanceCreated(userContext, application);
		return application;

		
	}
	protected Application createNewApplication() 
	{
		
		return new Application();		
	}
	
	protected void checkParamsForUpdatingApplication(HfgwUserContext userContext,String applicationId, int applicationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfApplication(applicationId);
		checkerOf(userContext).checkVersionOfApplication( applicationVersion);
		

		if(Application.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfApplication(parseString(newValueExpr));
		}
		if(Application.MSPID_PROPERTY.equals(property)){
			checkerOf(userContext).checkMspidOfApplication(parseString(newValueExpr));
		}
		if(Application.PUBLIC_KEY_PROPERTY.equals(property)){
			checkerOf(userContext).checkPublicKeyOfApplication(parseString(newValueExpr));
		}
		if(Application.PRIVATE_KEY_PROPERTY.equals(property)){
			checkerOf(userContext).checkPrivateKeyOfApplication(parseString(newValueExpr));
		}		

				

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ApplicationManagerException.class);
	
		
	}
	
	
	
	public Application clone(HfgwUserContext userContext, String fromApplicationId) throws Exception{
		
		return applicationDaoOf(userContext).clone(fromApplicationId, this.allTokens());
	}
	
	public Application internalSaveApplication(HfgwUserContext userContext, Application application) throws Exception 
	{
		return internalSaveApplication(userContext, application, allTokens());

	}
	public Application internalSaveApplication(HfgwUserContext userContext, Application application, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingApplication(userContext, applicationId, applicationVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(application){ 
			//will be good when the application loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Application.
			if (application.isChanged()){
			
			}
			application = saveApplication(userContext, application, options);
			return application;
			
		}

	}
	
	public Application updateApplication(HfgwUserContext userContext,String applicationId, int applicationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingApplication(userContext, applicationId, applicationVersion, property, newValueExpr, tokensExpr);
		
		
		
		Application application = loadApplication(userContext, applicationId, allTokens());
		if(application.getVersion() != applicationVersion){
			String message = "The target version("+application.getVersion()+") is not equals to version("+applicationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(application){ 
			//will be good when the application loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Application.
			
			application.changeProperty(property, newValueExpr);
			application = saveApplication(userContext, application, tokens().done());
			return present(userContext,application, mergedAllTokens(tokensExpr));
			//return saveApplication(userContext, application, tokens().done());
		}

	}
	
	public Application updateApplicationProperty(HfgwUserContext userContext,String applicationId, int applicationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingApplication(userContext, applicationId, applicationVersion, property, newValueExpr, tokensExpr);
		
		Application application = loadApplication(userContext, applicationId, allTokens());
		if(application.getVersion() != applicationVersion){
			String message = "The target version("+application.getVersion()+") is not equals to version("+applicationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(application){ 
			//will be good when the application loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Application.
			
			application.changeProperty(property, newValueExpr);
			
			application = saveApplication(userContext, application, tokens().done());
			return present(userContext,application, mergedAllTokens(tokensExpr));
			//return saveApplication(userContext, application, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ApplicationTokens tokens(){
		return ApplicationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ApplicationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortServiceRecordListWith("id","desc")
		.sortChainCodeInvokerListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ApplicationTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherChannel(HfgwUserContext userContext, String applicationId, String anotherChannelId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfApplication(applicationId);
 		checkerOf(userContext).checkIdOfChannel(anotherChannelId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ApplicationManagerException.class);
 		
 	}
 	public Application transferToAnotherChannel(HfgwUserContext userContext, String applicationId, String anotherChannelId) throws Exception
 	{
 		checkParamsForTransferingAnotherChannel(userContext, applicationId,anotherChannelId);
 
		Application application = loadApplication(userContext, applicationId, allTokens());	
		synchronized(application){
			//will be good when the application loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Channel channel = loadChannel(userContext, anotherChannelId, emptyOptions());		
			application.updateChannel(channel);		
			application = saveApplication(userContext, application, emptyOptions());
			
			return present(userContext,application, allTokens());
			
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
		SmartList<Channel> candidateList = channelDaoOf(userContext).requestCandidateChannelForApplication(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherNetwork(HfgwUserContext userContext, String applicationId, String anotherNetworkId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfApplication(applicationId);
 		checkerOf(userContext).checkIdOfHyperledgerNetwork(anotherNetworkId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ApplicationManagerException.class);
 		
 	}
 	public Application transferToAnotherNetwork(HfgwUserContext userContext, String applicationId, String anotherNetworkId) throws Exception
 	{
 		checkParamsForTransferingAnotherNetwork(userContext, applicationId,anotherNetworkId);
 
		Application application = loadApplication(userContext, applicationId, allTokens());	
		synchronized(application){
			//will be good when the application loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			HyperledgerNetwork network = loadHyperledgerNetwork(userContext, anotherNetworkId, emptyOptions());		
			application.updateNetwork(network);		
			application = saveApplication(userContext, application, emptyOptions());
			
			return present(userContext,application, allTokens());
			
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
		SmartList<HyperledgerNetwork> candidateList = hyperledgerNetworkDaoOf(userContext).requestCandidateHyperledgerNetworkForApplication(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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
 	
 	
 	
	
	 	
 	protected HyperledgerNetwork loadHyperledgerNetwork(HfgwUserContext userContext, String newNetworkId, Map<String,Object> options) throws Exception
 	{
		
 		return hyperledgerNetworkDaoOf(userContext).load(newNetworkId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(HfgwUserContext userContext, String applicationId, int applicationVersion) throws Exception {
		//deleteInternal(userContext, applicationId, applicationVersion);		
	}
	protected void deleteInternal(HfgwUserContext userContext,
			String applicationId, int applicationVersion) throws Exception{
			
		applicationDaoOf(userContext).delete(applicationId, applicationVersion);
	}
	
	public Application forgetByAll(HfgwUserContext userContext, String applicationId, int applicationVersion) throws Exception {
		return forgetByAllInternal(userContext, applicationId, applicationVersion);		
	}
	protected Application forgetByAllInternal(HfgwUserContext userContext,
			String applicationId, int applicationVersion) throws Exception{
			
		return applicationDaoOf(userContext).disconnectFromAll(applicationId, applicationVersion);
	}
	
	

	
	public int deleteAll(HfgwUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ApplicationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HfgwUserContext userContext) throws Exception{
		return applicationDaoOf(userContext).deleteAll();
	}


	//disconnect Application with transaction_id in ServiceRecord
	protected Application breakWithServiceRecordByTransactionId(HfgwUserContext userContext, String applicationId, String transactionIdId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Application application = loadApplication(userContext, applicationId, allTokens());

			synchronized(application){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				applicationDaoOf(userContext).planToRemoveServiceRecordListWithTransactionId(application, transactionIdId, this.emptyOptions());

				application = saveApplication(userContext, application, tokens().withServiceRecordList().done());
				return application;
			}
	}
	//disconnect Application with channel in ServiceRecord
	protected Application breakWithServiceRecordByChannel(HfgwUserContext userContext, String applicationId, String channelId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Application application = loadApplication(userContext, applicationId, allTokens());

			synchronized(application){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				applicationDaoOf(userContext).planToRemoveServiceRecordListWithChannel(application, channelId, this.emptyOptions());

				application = saveApplication(userContext, application, tokens().withServiceRecordList().done());
				return application;
			}
	}
	//disconnect Application with chain_code in ServiceRecord
	protected Application breakWithServiceRecordByChainCode(HfgwUserContext userContext, String applicationId, String chainCodeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Application application = loadApplication(userContext, applicationId, allTokens());

			synchronized(application){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				applicationDaoOf(userContext).planToRemoveServiceRecordListWithChainCode(application, chainCodeId, this.emptyOptions());

				application = saveApplication(userContext, application, tokens().withServiceRecordList().done());
				return application;
			}
	}
	//disconnect Application with block_id in ServiceRecord
	protected Application breakWithServiceRecordByBlockId(HfgwUserContext userContext, String applicationId, String blockIdId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Application application = loadApplication(userContext, applicationId, allTokens());

			synchronized(application){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				applicationDaoOf(userContext).planToRemoveServiceRecordListWithBlockId(application, blockIdId, this.emptyOptions());

				application = saveApplication(userContext, application, tokens().withServiceRecordList().done());
				return application;
			}
	}
	//disconnect Application with network in ServiceRecord
	protected Application breakWithServiceRecordByNetwork(HfgwUserContext userContext, String applicationId, String networkId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Application application = loadApplication(userContext, applicationId, allTokens());

			synchronized(application){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				applicationDaoOf(userContext).planToRemoveServiceRecordListWithNetwork(application, networkId, this.emptyOptions());

				application = saveApplication(userContext, application, tokens().withServiceRecordList().done());
				return application;
			}
	}
	//disconnect Application with status in ServiceRecord
	protected Application breakWithServiceRecordByStatus(HfgwUserContext userContext, String applicationId, String statusId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Application application = loadApplication(userContext, applicationId, allTokens());

			synchronized(application){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				applicationDaoOf(userContext).planToRemoveServiceRecordListWithStatus(application, statusId, this.emptyOptions());

				application = saveApplication(userContext, application, tokens().withServiceRecordList().done());
				return application;
			}
	}
	//disconnect Application with chain_code in ChainCodeInvoker
	protected Application breakWithChainCodeInvokerByChainCode(HfgwUserContext userContext, String applicationId, String chainCodeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Application application = loadApplication(userContext, applicationId, allTokens());

			synchronized(application){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				applicationDaoOf(userContext).planToRemoveChainCodeInvokerListWithChainCode(application, chainCodeId, this.emptyOptions());

				application = saveApplication(userContext, application, tokens().withChainCodeInvokerList().done());
				return application;
			}
	}
	//disconnect Application with change_request in ChainCodeInvoker
	protected Application breakWithChainCodeInvokerByChangeRequest(HfgwUserContext userContext, String applicationId, String changeRequestId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Application application = loadApplication(userContext, applicationId, allTokens());

			synchronized(application){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				applicationDaoOf(userContext).planToRemoveChainCodeInvokerListWithChangeRequest(application, changeRequestId, this.emptyOptions());

				application = saveApplication(userContext, application, tokens().withChainCodeInvokerList().done());
				return application;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingServiceRecord(HfgwUserContext userContext, String applicationId, String transactionId, String name, String payload, String channelId, String chainCodeId, String chainCodeFunction, String blockId, String networkId, String response, String statusId,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfApplication(applicationId);

		
		checkerOf(userContext).checkTransactionIdOfServiceRecord(transactionId);
		
		checkerOf(userContext).checkNameOfServiceRecord(name);
		
		checkerOf(userContext).checkPayloadOfServiceRecord(payload);
		
		checkerOf(userContext).checkChannelIdOfServiceRecord(channelId);
		
		checkerOf(userContext).checkChainCodeIdOfServiceRecord(chainCodeId);
		
		checkerOf(userContext).checkChainCodeFunctionOfServiceRecord(chainCodeFunction);
		
		checkerOf(userContext).checkBlockIdOfServiceRecord(blockId);
		
		checkerOf(userContext).checkNetworkIdOfServiceRecord(networkId);
		
		checkerOf(userContext).checkResponseOfServiceRecord(response);
		
		checkerOf(userContext).checkStatusIdOfServiceRecord(statusId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ApplicationManagerException.class);

	
	}
	public  Application addServiceRecord(HfgwUserContext userContext, String applicationId, String transactionId, String name, String payload, String channelId, String chainCodeId, String chainCodeFunction, String blockId, String networkId, String response, String statusId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingServiceRecord(userContext,applicationId,transactionId, name, payload, channelId, chainCodeId, chainCodeFunction, blockId, networkId, response, statusId,tokensExpr);
		
		ServiceRecord serviceRecord = createServiceRecord(userContext,transactionId, name, payload, channelId, chainCodeId, chainCodeFunction, blockId, networkId, response, statusId);
		
		Application application = loadApplication(userContext, applicationId, allTokens());
		synchronized(application){ 
			//Will be good when the application loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			application.addServiceRecord( serviceRecord );		
			application = saveApplication(userContext, application, tokens().withServiceRecordList().done());
			
			userContext.getManagerGroup().getServiceRecordManager().onNewInstanceCreated(userContext, serviceRecord);
			return present(userContext,application, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingServiceRecordProperties(HfgwUserContext userContext, String applicationId,String id,String transactionId,String name,String payload,String chainCodeFunction,String blockId,String response,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfApplication(applicationId);
		checkerOf(userContext).checkIdOfServiceRecord(id);
		
		checkerOf(userContext).checkTransactionIdOfServiceRecord( transactionId);
		checkerOf(userContext).checkNameOfServiceRecord( name);
		checkerOf(userContext).checkPayloadOfServiceRecord( payload);
		checkerOf(userContext).checkChainCodeFunctionOfServiceRecord( chainCodeFunction);
		checkerOf(userContext).checkBlockIdOfServiceRecord( blockId);
		checkerOf(userContext).checkResponseOfServiceRecord( response);

		checkerOf(userContext).throwExceptionIfHasErrors(ApplicationManagerException.class);
		
	}
	public  Application updateServiceRecordProperties(HfgwUserContext userContext, String applicationId, String id,String transactionId,String name,String payload,String chainCodeFunction,String blockId,String response, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingServiceRecordProperties(userContext,applicationId,id,transactionId,name,payload,chainCodeFunction,blockId,response,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withServiceRecordListList()
				.searchServiceRecordListWith(ServiceRecord.ID_PROPERTY, "is", id).done();
		
		Application applicationToUpdate = loadApplication(userContext, applicationId, options);
		
		if(applicationToUpdate.getServiceRecordList().isEmpty()){
			throw new ApplicationManagerException("ServiceRecord is NOT FOUND with id: '"+id+"'");
		}
		
		ServiceRecord item = applicationToUpdate.getServiceRecordList().first();
		
		item.updateTransactionId( transactionId );
		item.updateName( name );
		item.updatePayload( payload );
		item.updateChainCodeFunction( chainCodeFunction );
		item.updateBlockId( blockId );
		item.updateResponse( response );

		
		//checkParamsForAddingServiceRecord(userContext,applicationId,name, code, used,tokensExpr);
		Application application = saveApplication(userContext, applicationToUpdate, tokens().withServiceRecordList().done());
		synchronized(application){ 
			return present(userContext,application, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ServiceRecord createServiceRecord(HfgwUserContext userContext, String transactionId, String name, String payload, String channelId, String chainCodeId, String chainCodeFunction, String blockId, String networkId, String response, String statusId) throws Exception{

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
	
	protected void checkParamsForRemovingServiceRecordList(HfgwUserContext userContext, String applicationId, 
			String serviceRecordIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfApplication(applicationId);
		for(String serviceRecordIdItem: serviceRecordIds){
			checkerOf(userContext).checkIdOfServiceRecord(serviceRecordIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(ApplicationManagerException.class);
		
	}
	public  Application removeServiceRecordList(HfgwUserContext userContext, String applicationId, 
			String serviceRecordIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingServiceRecordList(userContext, applicationId,  serviceRecordIds, tokensExpr);
			
			
			Application application = loadApplication(userContext, applicationId, allTokens());
			synchronized(application){ 
				//Will be good when the application loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				applicationDaoOf(userContext).planToRemoveServiceRecordList(application, serviceRecordIds, allTokens());
				application = saveApplication(userContext, application, tokens().withServiceRecordList().done());
				deleteRelationListInGraph(userContext, application.getServiceRecordList());
				return present(userContext,application, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingServiceRecord(HfgwUserContext userContext, String applicationId, 
		String serviceRecordId, int serviceRecordVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfApplication( applicationId);
		checkerOf(userContext).checkIdOfServiceRecord(serviceRecordId);
		checkerOf(userContext).checkVersionOfServiceRecord(serviceRecordVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ApplicationManagerException.class);
	
	}
	public  Application removeServiceRecord(HfgwUserContext userContext, String applicationId, 
		String serviceRecordId, int serviceRecordVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingServiceRecord(userContext,applicationId, serviceRecordId, serviceRecordVersion,tokensExpr);
		
		ServiceRecord serviceRecord = createIndexedServiceRecord(serviceRecordId, serviceRecordVersion);
		Application application = loadApplication(userContext, applicationId, allTokens());
		synchronized(application){ 
			//Will be good when the application loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			application.removeServiceRecord( serviceRecord );		
			application = saveApplication(userContext, application, tokens().withServiceRecordList().done());
			deleteRelationInGraph(userContext, serviceRecord);
			return present(userContext,application, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingServiceRecord(HfgwUserContext userContext, String applicationId, 
		String serviceRecordId, int serviceRecordVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfApplication( applicationId);
		checkerOf(userContext).checkIdOfServiceRecord(serviceRecordId);
		checkerOf(userContext).checkVersionOfServiceRecord(serviceRecordVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ApplicationManagerException.class);
	
	}
	public  Application copyServiceRecordFrom(HfgwUserContext userContext, String applicationId, 
		String serviceRecordId, int serviceRecordVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingServiceRecord(userContext,applicationId, serviceRecordId, serviceRecordVersion,tokensExpr);
		
		ServiceRecord serviceRecord = createIndexedServiceRecord(serviceRecordId, serviceRecordVersion);
		Application application = loadApplication(userContext, applicationId, allTokens());
		synchronized(application){ 
			//Will be good when the application loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			application.copyServiceRecordFrom( serviceRecord );		
			application = saveApplication(userContext, application, tokens().withServiceRecordList().done());
			
			userContext.getManagerGroup().getServiceRecordManager().onNewInstanceCreated(userContext, (ServiceRecord)application.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,application, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingServiceRecord(HfgwUserContext userContext, String applicationId, String serviceRecordId, int serviceRecordVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfApplication(applicationId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ApplicationManagerException.class);
	
	}
	
	public  Application updateServiceRecord(HfgwUserContext userContext, String applicationId, String serviceRecordId, int serviceRecordVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingServiceRecord(userContext, applicationId, serviceRecordId, serviceRecordVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withServiceRecordList().searchServiceRecordListWith(ServiceRecord.ID_PROPERTY, "eq", serviceRecordId).done();
		
		
		
		Application application = loadApplication(userContext, applicationId, loadTokens);
		
		synchronized(application){ 
			//Will be good when the application loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//application.removeServiceRecord( serviceRecord );	
			//make changes to AcceleraterAccount.
			ServiceRecord serviceRecordIndex = createIndexedServiceRecord(serviceRecordId, serviceRecordVersion);
		
			ServiceRecord serviceRecord = application.findTheServiceRecord(serviceRecordIndex);
			if(serviceRecord == null){
				throw new ApplicationManagerException(serviceRecord+" is NOT FOUND" );
			}
			
			serviceRecord.changeProperty(property, newValueExpr);
			
			application = saveApplication(userContext, application, tokens().withServiceRecordList().done());
			return present(userContext,application, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingChainCodeInvoker(HfgwUserContext userContext, String applicationId, String chainCodeId, String parameters, String changeRequestId,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfApplication(applicationId);

		
		checkerOf(userContext).checkChainCodeIdOfChainCodeInvoker(chainCodeId);
		
		checkerOf(userContext).checkParametersOfChainCodeInvoker(parameters);
		
		checkerOf(userContext).checkChangeRequestIdOfChainCodeInvoker(changeRequestId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ApplicationManagerException.class);

	
	}
	public  Application addChainCodeInvoker(HfgwUserContext userContext, String applicationId, String chainCodeId, String parameters, String changeRequestId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingChainCodeInvoker(userContext,applicationId,chainCodeId, parameters, changeRequestId,tokensExpr);
		
		ChainCodeInvoker chainCodeInvoker = createChainCodeInvoker(userContext,chainCodeId, parameters, changeRequestId);
		
		Application application = loadApplication(userContext, applicationId, allTokens());
		synchronized(application){ 
			//Will be good when the application loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			application.addChainCodeInvoker( chainCodeInvoker );		
			application = saveApplication(userContext, application, tokens().withChainCodeInvokerList().done());
			
			userContext.getManagerGroup().getChainCodeInvokerManager().onNewInstanceCreated(userContext, chainCodeInvoker);
			return present(userContext,application, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingChainCodeInvokerProperties(HfgwUserContext userContext, String applicationId,String id,String parameters,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfApplication(applicationId);
		checkerOf(userContext).checkIdOfChainCodeInvoker(id);
		
		checkerOf(userContext).checkParametersOfChainCodeInvoker( parameters);

		checkerOf(userContext).throwExceptionIfHasErrors(ApplicationManagerException.class);
		
	}
	public  Application updateChainCodeInvokerProperties(HfgwUserContext userContext, String applicationId, String id,String parameters, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingChainCodeInvokerProperties(userContext,applicationId,id,parameters,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withChainCodeInvokerListList()
				.searchChainCodeInvokerListWith(ChainCodeInvoker.ID_PROPERTY, "is", id).done();
		
		Application applicationToUpdate = loadApplication(userContext, applicationId, options);
		
		if(applicationToUpdate.getChainCodeInvokerList().isEmpty()){
			throw new ApplicationManagerException("ChainCodeInvoker is NOT FOUND with id: '"+id+"'");
		}
		
		ChainCodeInvoker item = applicationToUpdate.getChainCodeInvokerList().first();
		
		item.updateParameters( parameters );

		
		//checkParamsForAddingChainCodeInvoker(userContext,applicationId,name, code, used,tokensExpr);
		Application application = saveApplication(userContext, applicationToUpdate, tokens().withChainCodeInvokerList().done());
		synchronized(application){ 
			return present(userContext,application, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ChainCodeInvoker createChainCodeInvoker(HfgwUserContext userContext, String chainCodeId, String parameters, String changeRequestId) throws Exception{

		ChainCodeInvoker chainCodeInvoker = new ChainCodeInvoker();
		
		
		ChainCode  chainCode = new ChainCode();
		chainCode.setId(chainCodeId);		
		chainCodeInvoker.setChainCode(chainCode);		
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
	
	protected void checkParamsForRemovingChainCodeInvokerList(HfgwUserContext userContext, String applicationId, 
			String chainCodeInvokerIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfApplication(applicationId);
		for(String chainCodeInvokerIdItem: chainCodeInvokerIds){
			checkerOf(userContext).checkIdOfChainCodeInvoker(chainCodeInvokerIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(ApplicationManagerException.class);
		
	}
	public  Application removeChainCodeInvokerList(HfgwUserContext userContext, String applicationId, 
			String chainCodeInvokerIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingChainCodeInvokerList(userContext, applicationId,  chainCodeInvokerIds, tokensExpr);
			
			
			Application application = loadApplication(userContext, applicationId, allTokens());
			synchronized(application){ 
				//Will be good when the application loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				applicationDaoOf(userContext).planToRemoveChainCodeInvokerList(application, chainCodeInvokerIds, allTokens());
				application = saveApplication(userContext, application, tokens().withChainCodeInvokerList().done());
				deleteRelationListInGraph(userContext, application.getChainCodeInvokerList());
				return present(userContext,application, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingChainCodeInvoker(HfgwUserContext userContext, String applicationId, 
		String chainCodeInvokerId, int chainCodeInvokerVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfApplication( applicationId);
		checkerOf(userContext).checkIdOfChainCodeInvoker(chainCodeInvokerId);
		checkerOf(userContext).checkVersionOfChainCodeInvoker(chainCodeInvokerVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ApplicationManagerException.class);
	
	}
	public  Application removeChainCodeInvoker(HfgwUserContext userContext, String applicationId, 
		String chainCodeInvokerId, int chainCodeInvokerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingChainCodeInvoker(userContext,applicationId, chainCodeInvokerId, chainCodeInvokerVersion,tokensExpr);
		
		ChainCodeInvoker chainCodeInvoker = createIndexedChainCodeInvoker(chainCodeInvokerId, chainCodeInvokerVersion);
		Application application = loadApplication(userContext, applicationId, allTokens());
		synchronized(application){ 
			//Will be good when the application loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			application.removeChainCodeInvoker( chainCodeInvoker );		
			application = saveApplication(userContext, application, tokens().withChainCodeInvokerList().done());
			deleteRelationInGraph(userContext, chainCodeInvoker);
			return present(userContext,application, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingChainCodeInvoker(HfgwUserContext userContext, String applicationId, 
		String chainCodeInvokerId, int chainCodeInvokerVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfApplication( applicationId);
		checkerOf(userContext).checkIdOfChainCodeInvoker(chainCodeInvokerId);
		checkerOf(userContext).checkVersionOfChainCodeInvoker(chainCodeInvokerVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ApplicationManagerException.class);
	
	}
	public  Application copyChainCodeInvokerFrom(HfgwUserContext userContext, String applicationId, 
		String chainCodeInvokerId, int chainCodeInvokerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingChainCodeInvoker(userContext,applicationId, chainCodeInvokerId, chainCodeInvokerVersion,tokensExpr);
		
		ChainCodeInvoker chainCodeInvoker = createIndexedChainCodeInvoker(chainCodeInvokerId, chainCodeInvokerVersion);
		Application application = loadApplication(userContext, applicationId, allTokens());
		synchronized(application){ 
			//Will be good when the application loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			application.copyChainCodeInvokerFrom( chainCodeInvoker );		
			application = saveApplication(userContext, application, tokens().withChainCodeInvokerList().done());
			
			userContext.getManagerGroup().getChainCodeInvokerManager().onNewInstanceCreated(userContext, (ChainCodeInvoker)application.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,application, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingChainCodeInvoker(HfgwUserContext userContext, String applicationId, String chainCodeInvokerId, int chainCodeInvokerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfApplication(applicationId);
		checkerOf(userContext).checkIdOfChainCodeInvoker(chainCodeInvokerId);
		checkerOf(userContext).checkVersionOfChainCodeInvoker(chainCodeInvokerVersion);
		

		if(ChainCodeInvoker.PARAMETERS_PROPERTY.equals(property)){
			checkerOf(userContext).checkParametersOfChainCodeInvoker(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ApplicationManagerException.class);
	
	}
	
	public  Application updateChainCodeInvoker(HfgwUserContext userContext, String applicationId, String chainCodeInvokerId, int chainCodeInvokerVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingChainCodeInvoker(userContext, applicationId, chainCodeInvokerId, chainCodeInvokerVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withChainCodeInvokerList().searchChainCodeInvokerListWith(ChainCodeInvoker.ID_PROPERTY, "eq", chainCodeInvokerId).done();
		
		
		
		Application application = loadApplication(userContext, applicationId, loadTokens);
		
		synchronized(application){ 
			//Will be good when the application loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//application.removeChainCodeInvoker( chainCodeInvoker );	
			//make changes to AcceleraterAccount.
			ChainCodeInvoker chainCodeInvokerIndex = createIndexedChainCodeInvoker(chainCodeInvokerId, chainCodeInvokerVersion);
		
			ChainCodeInvoker chainCodeInvoker = application.findTheChainCodeInvoker(chainCodeInvokerIndex);
			if(chainCodeInvoker == null){
				throw new ApplicationManagerException(chainCodeInvoker+" is NOT FOUND" );
			}
			
			chainCodeInvoker.changeProperty(property, newValueExpr);
			
			application = saveApplication(userContext, application, tokens().withChainCodeInvokerList().done());
			return present(userContext,application, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(HfgwUserContext userContext, Application newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


