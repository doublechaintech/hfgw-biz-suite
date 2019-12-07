
package com.doublechaintech.hfgw.changerequest;

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

import com.doublechaintech.hfgw.changerequesttype.ChangeRequestType;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;
import com.doublechaintech.hfgw.chaincodeinvoker.ChainCodeInvoker;

import com.doublechaintech.hfgw.changerequesttype.CandidateChangeRequestType;
import com.doublechaintech.hfgw.hyperledgernetwork.CandidateHyperledgerNetwork;

import com.doublechaintech.hfgw.chaincode.ChainCode;
import com.doublechaintech.hfgw.changerequest.ChangeRequest;
import com.doublechaintech.hfgw.application.Application;






public class ChangeRequestManagerImpl extends CustomHfgwCheckerManager implements ChangeRequestManager {
	
	private static final String SERVICE_TYPE = "ChangeRequest";
	@Override
	public ChangeRequestDAO daoOf(HfgwUserContext userContext) {
		return changeRequestDaoOf(userContext);
	}
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ChangeRequestManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ChangeRequestManagerException(message);

	}
	
	

 	protected ChangeRequest saveChangeRequest(HfgwUserContext userContext, ChangeRequest changeRequest, String [] tokensExpr) throws Exception{	
 		//return getChangeRequestDAO().save(changeRequest, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveChangeRequest(userContext, changeRequest, tokens);
 	}
 	
 	protected ChangeRequest saveChangeRequestDetail(HfgwUserContext userContext, ChangeRequest changeRequest) throws Exception{	

 		
 		return saveChangeRequest(userContext, changeRequest, allTokens());
 	}
 	
 	public ChangeRequest loadChangeRequest(HfgwUserContext userContext, String changeRequestId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		checkerOf(userContext).throwExceptionIfHasErrors( ChangeRequestManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ChangeRequest changeRequest = loadChangeRequest( userContext, changeRequestId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,changeRequest, tokens);
 	}
 	
 	
 	 public ChangeRequest searchChangeRequest(HfgwUserContext userContext, String changeRequestId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		checkerOf(userContext).throwExceptionIfHasErrors( ChangeRequestManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ChangeRequest changeRequest = loadChangeRequest( userContext, changeRequestId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,changeRequest, tokens);
 	}
 	
 	

 	protected ChangeRequest present(HfgwUserContext userContext, ChangeRequest changeRequest, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,changeRequest,tokens);
		
		
		ChangeRequest  changeRequestToPresent = changeRequestDaoOf(userContext).present(changeRequest, tokens);
		
		List<BaseEntity> entityListToNaming = changeRequestToPresent.collectRefercencesFromLists();
		changeRequestDaoOf(userContext).alias(entityListToNaming);
		
		return  changeRequestToPresent;
		
		
	}
 
 	
 	
 	public ChangeRequest loadChangeRequestDetail(HfgwUserContext userContext, String changeRequestId) throws Exception{	
 		ChangeRequest changeRequest = loadChangeRequest( userContext, changeRequestId, allTokens());
 		return present(userContext,changeRequest, allTokens());
		
 	}
 	
 	public Object view(HfgwUserContext userContext, String changeRequestId) throws Exception{	
 		ChangeRequest changeRequest = loadChangeRequest( userContext, changeRequestId, viewTokens());
 		return present(userContext,changeRequest, allTokens());
		
 	}
 	protected ChangeRequest saveChangeRequest(HfgwUserContext userContext, ChangeRequest changeRequest, Map<String,Object>tokens) throws Exception{	
 		return changeRequestDaoOf(userContext).save(changeRequest, tokens);
 	}
 	protected ChangeRequest loadChangeRequest(HfgwUserContext userContext, String changeRequestId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		checkerOf(userContext).throwExceptionIfHasErrors( ChangeRequestManagerException.class);

 
 		return changeRequestDaoOf(userContext).load(changeRequestId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, ChangeRequest changeRequest, Map<String, Object> tokens){
		super.addActions(userContext, changeRequest, tokens);
		
		addAction(userContext, changeRequest, tokens,"@create","createChangeRequest","createChangeRequest/","main","primary");
		addAction(userContext, changeRequest, tokens,"@update","updateChangeRequest","updateChangeRequest/"+changeRequest.getId()+"/","main","primary");
		addAction(userContext, changeRequest, tokens,"@copy","cloneChangeRequest","cloneChangeRequest/"+changeRequest.getId()+"/","main","primary");
		
		addAction(userContext, changeRequest, tokens,"change_request.transfer_to_request_type","transferToAnotherRequestType","transferToAnotherRequestType/"+changeRequest.getId()+"/","main","primary");
		addAction(userContext, changeRequest, tokens,"change_request.transfer_to_network","transferToAnotherNetwork","transferToAnotherNetwork/"+changeRequest.getId()+"/","main","primary");
		addAction(userContext, changeRequest, tokens,"change_request.addChainCodeInvoker","addChainCodeInvoker","addChainCodeInvoker/"+changeRequest.getId()+"/","chainCodeInvokerList","primary");
		addAction(userContext, changeRequest, tokens,"change_request.removeChainCodeInvoker","removeChainCodeInvoker","removeChainCodeInvoker/"+changeRequest.getId()+"/","chainCodeInvokerList","primary");
		addAction(userContext, changeRequest, tokens,"change_request.updateChainCodeInvoker","updateChainCodeInvoker","updateChainCodeInvoker/"+changeRequest.getId()+"/","chainCodeInvokerList","primary");
		addAction(userContext, changeRequest, tokens,"change_request.copyChainCodeInvokerFrom","copyChainCodeInvokerFrom","copyChainCodeInvokerFrom/"+changeRequest.getId()+"/","chainCodeInvokerList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, ChangeRequest changeRequest, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public ChangeRequest createChangeRequest(HfgwUserContext userContext, String name,String requestTypeId,String networkId) throws Exception
	//public ChangeRequest createChangeRequest(HfgwUserContext userContext,String name, String requestTypeId, String networkId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkNameOfChangeRequest(name);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);


		ChangeRequest changeRequest=createNewChangeRequest();	

		changeRequest.setName(name);
		changeRequest.setCreateTime(userContext.now());
		changeRequest.setRemoteIp(userContext.getRemoteIP());
			
		ChangeRequestType requestType = loadChangeRequestType(userContext, requestTypeId,emptyOptions());
		changeRequest.setRequestType(requestType);
		
		
			
		HyperledgerNetwork network = loadHyperledgerNetwork(userContext, networkId,emptyOptions());
		changeRequest.setNetwork(network);
		
		

		changeRequest = saveChangeRequest(userContext, changeRequest, emptyOptions());
		
		onNewInstanceCreated(userContext, changeRequest);
		return changeRequest;

		
	}
	protected ChangeRequest createNewChangeRequest() 
	{
		
		return new ChangeRequest();		
	}
	
	protected void checkParamsForUpdatingChangeRequest(HfgwUserContext userContext,String changeRequestId, int changeRequestVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		checkerOf(userContext).checkVersionOfChangeRequest( changeRequestVersion);
		

		if(ChangeRequest.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfChangeRequest(parseString(newValueExpr));
		}		

				

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);
	
		
	}
	
	
	
	public ChangeRequest clone(HfgwUserContext userContext, String fromChangeRequestId) throws Exception{
		
		return changeRequestDaoOf(userContext).clone(fromChangeRequestId, this.allTokens());
	}
	
	public ChangeRequest internalSaveChangeRequest(HfgwUserContext userContext, ChangeRequest changeRequest) throws Exception 
	{
		return internalSaveChangeRequest(userContext, changeRequest, allTokens());

	}
	public ChangeRequest internalSaveChangeRequest(HfgwUserContext userContext, ChangeRequest changeRequest, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingChangeRequest(userContext, changeRequestId, changeRequestVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(changeRequest){ 
			//will be good when the changeRequest loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ChangeRequest.
			if (changeRequest.isChanged()){
			changeRequest.updateRemoteIp(userContext.getRemoteIP());
			}
			changeRequest = saveChangeRequest(userContext, changeRequest, options);
			return changeRequest;
			
		}

	}
	
	public ChangeRequest updateChangeRequest(HfgwUserContext userContext,String changeRequestId, int changeRequestVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingChangeRequest(userContext, changeRequestId, changeRequestVersion, property, newValueExpr, tokensExpr);
		
		
		
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());
		if(changeRequest.getVersion() != changeRequestVersion){
			String message = "The target version("+changeRequest.getVersion()+") is not equals to version("+changeRequestVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(changeRequest){ 
			//will be good when the changeRequest loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ChangeRequest.
			changeRequest.updateRemoteIp(userContext.getRemoteIP());
			changeRequest.changeProperty(property, newValueExpr);
			changeRequest = saveChangeRequest(userContext, changeRequest, tokens().done());
			return present(userContext,changeRequest, mergedAllTokens(tokensExpr));
			//return saveChangeRequest(userContext, changeRequest, tokens().done());
		}

	}
	
	public ChangeRequest updateChangeRequestProperty(HfgwUserContext userContext,String changeRequestId, int changeRequestVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingChangeRequest(userContext, changeRequestId, changeRequestVersion, property, newValueExpr, tokensExpr);
		
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());
		if(changeRequest.getVersion() != changeRequestVersion){
			String message = "The target version("+changeRequest.getVersion()+") is not equals to version("+changeRequestVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(changeRequest){ 
			//will be good when the changeRequest loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ChangeRequest.
			
			changeRequest.changeProperty(property, newValueExpr);
			changeRequest.updateRemoteIp(userContext.getRemoteIP());
			changeRequest = saveChangeRequest(userContext, changeRequest, tokens().done());
			return present(userContext,changeRequest, mergedAllTokens(tokensExpr));
			//return saveChangeRequest(userContext, changeRequest, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ChangeRequestTokens tokens(){
		return ChangeRequestTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ChangeRequestTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortChainCodeInvokerListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ChangeRequestTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherRequestType(HfgwUserContext userContext, String changeRequestId, String anotherRequestTypeId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
 		checkerOf(userContext).checkIdOfChangeRequestType(anotherRequestTypeId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);
 		
 	}
 	public ChangeRequest transferToAnotherRequestType(HfgwUserContext userContext, String changeRequestId, String anotherRequestTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherRequestType(userContext, changeRequestId,anotherRequestTypeId);
 
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());	
		synchronized(changeRequest){
			//will be good when the changeRequest loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ChangeRequestType requestType = loadChangeRequestType(userContext, anotherRequestTypeId, emptyOptions());		
			changeRequest.updateRequestType(requestType);		
			changeRequest = saveChangeRequest(userContext, changeRequest, emptyOptions());
			
			return present(userContext,changeRequest, allTokens());
			
		}

 	}
 	
	

	protected void checkParamsForTransferingAnotherRequestTypeWithCode(HfgwUserContext userContext, String changeRequestId, String anotherCode) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
 		checkerOf(userContext).checkCodeOfChangeRequestType( anotherCode);
 		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);
 		
 	}

 	public ChangeRequest transferToAnotherRequestTypeWithCode(HfgwUserContext userContext, String changeRequestId, String anotherCode) throws Exception
 	{
 		checkParamsForTransferingAnotherRequestTypeWithCode(userContext, changeRequestId,anotherCode);
 		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());	
		synchronized(changeRequest){
			//will be good when the changeRequest loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ChangeRequestType requestType = loadChangeRequestTypeWithCode(userContext, anotherCode, emptyOptions());		
			changeRequest.updateRequestType(requestType);		
			changeRequest = saveChangeRequest(userContext, changeRequest, emptyOptions());
			
			return present(userContext,changeRequest, allTokens());
			
		}
 	}	

	  	
 	
 	
	public CandidateChangeRequestType requestCandidateRequestType(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateChangeRequestType result = new CandidateChangeRequestType();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<ChangeRequestType> candidateList = changeRequestTypeDaoOf(userContext).requestCandidateChangeRequestTypeForChangeRequest(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherNetwork(HfgwUserContext userContext, String changeRequestId, String anotherNetworkId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
 		checkerOf(userContext).checkIdOfHyperledgerNetwork(anotherNetworkId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);
 		
 	}
 	public ChangeRequest transferToAnotherNetwork(HfgwUserContext userContext, String changeRequestId, String anotherNetworkId) throws Exception
 	{
 		checkParamsForTransferingAnotherNetwork(userContext, changeRequestId,anotherNetworkId);
 
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());	
		synchronized(changeRequest){
			//will be good when the changeRequest loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			HyperledgerNetwork network = loadHyperledgerNetwork(userContext, anotherNetworkId, emptyOptions());		
			changeRequest.updateNetwork(network);		
			changeRequest = saveChangeRequest(userContext, changeRequest, emptyOptions());
			
			return present(userContext,changeRequest, allTokens());
			
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
		SmartList<HyperledgerNetwork> candidateList = hyperledgerNetworkDaoOf(userContext).requestCandidateHyperledgerNetworkForChangeRequest(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected ChangeRequestType loadChangeRequestType(HfgwUserContext userContext, String newRequestTypeId, Map<String,Object> options) throws Exception
 	{
		
 		return changeRequestTypeDaoOf(userContext).load(newRequestTypeId, options);
 	}
 	
 	protected ChangeRequestType loadChangeRequestTypeWithCode(HfgwUserContext userContext, String newCode, Map<String,Object> options) throws Exception
 	{
		
 		return changeRequestTypeDaoOf(userContext).loadByCode(newCode, options);
 	}
 	
 	
 	
 	
	
	 	
 	protected HyperledgerNetwork loadHyperledgerNetwork(HfgwUserContext userContext, String newNetworkId, Map<String,Object> options) throws Exception
 	{
		
 		return hyperledgerNetworkDaoOf(userContext).load(newNetworkId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(HfgwUserContext userContext, String changeRequestId, int changeRequestVersion) throws Exception {
		//deleteInternal(userContext, changeRequestId, changeRequestVersion);		
	}
	protected void deleteInternal(HfgwUserContext userContext,
			String changeRequestId, int changeRequestVersion) throws Exception{
			
		changeRequestDaoOf(userContext).delete(changeRequestId, changeRequestVersion);
	}
	
	public ChangeRequest forgetByAll(HfgwUserContext userContext, String changeRequestId, int changeRequestVersion) throws Exception {
		return forgetByAllInternal(userContext, changeRequestId, changeRequestVersion);		
	}
	protected ChangeRequest forgetByAllInternal(HfgwUserContext userContext,
			String changeRequestId, int changeRequestVersion) throws Exception{
			
		return changeRequestDaoOf(userContext).disconnectFromAll(changeRequestId, changeRequestVersion);
	}
	
	

	
	public int deleteAll(HfgwUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ChangeRequestManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HfgwUserContext userContext) throws Exception{
		return changeRequestDaoOf(userContext).deleteAll();
	}


	//disconnect ChangeRequest with app_client in ChainCodeInvoker
	protected ChangeRequest breakWithChainCodeInvokerByAppClient(HfgwUserContext userContext, String changeRequestId, String appClientId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());

			synchronized(changeRequest){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				changeRequestDaoOf(userContext).planToRemoveChainCodeInvokerListWithAppClient(changeRequest, appClientId, this.emptyOptions());

				changeRequest = saveChangeRequest(userContext, changeRequest, tokens().withChainCodeInvokerList().done());
				return changeRequest;
			}
	}
	//disconnect ChangeRequest with chain_code in ChainCodeInvoker
	protected ChangeRequest breakWithChainCodeInvokerByChainCode(HfgwUserContext userContext, String changeRequestId, String chainCodeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());

			synchronized(changeRequest){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				changeRequestDaoOf(userContext).planToRemoveChainCodeInvokerListWithChainCode(changeRequest, chainCodeId, this.emptyOptions());

				changeRequest = saveChangeRequest(userContext, changeRequest, tokens().withChainCodeInvokerList().done());
				return changeRequest;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingChainCodeInvoker(HfgwUserContext userContext, String changeRequestId, String appClientId, String chainCodeId, String parameters,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);

		
		checkerOf(userContext).checkAppClientIdOfChainCodeInvoker(appClientId);
		
		checkerOf(userContext).checkChainCodeIdOfChainCodeInvoker(chainCodeId);
		
		checkerOf(userContext).checkParametersOfChainCodeInvoker(parameters);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);

	
	}
	public  ChangeRequest addChainCodeInvoker(HfgwUserContext userContext, String changeRequestId, String appClientId, String chainCodeId, String parameters, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingChainCodeInvoker(userContext,changeRequestId,appClientId, chainCodeId, parameters,tokensExpr);
		
		ChainCodeInvoker chainCodeInvoker = createChainCodeInvoker(userContext,appClientId, chainCodeId, parameters);
		
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());
		synchronized(changeRequest){ 
			//Will be good when the changeRequest loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			changeRequest.addChainCodeInvoker( chainCodeInvoker );		
			changeRequest = saveChangeRequest(userContext, changeRequest, tokens().withChainCodeInvokerList().done());
			
			userContext.getManagerGroup().getChainCodeInvokerManager().onNewInstanceCreated(userContext, chainCodeInvoker);
			return present(userContext,changeRequest, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingChainCodeInvokerProperties(HfgwUserContext userContext, String changeRequestId,String id,String parameters,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		checkerOf(userContext).checkIdOfChainCodeInvoker(id);
		
		checkerOf(userContext).checkParametersOfChainCodeInvoker( parameters);

		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);
		
	}
	public  ChangeRequest updateChainCodeInvokerProperties(HfgwUserContext userContext, String changeRequestId, String id,String parameters, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingChainCodeInvokerProperties(userContext,changeRequestId,id,parameters,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withChainCodeInvokerListList()
				.searchChainCodeInvokerListWith(ChainCodeInvoker.ID_PROPERTY, "is", id).done();
		
		ChangeRequest changeRequestToUpdate = loadChangeRequest(userContext, changeRequestId, options);
		
		if(changeRequestToUpdate.getChainCodeInvokerList().isEmpty()){
			throw new ChangeRequestManagerException("ChainCodeInvoker is NOT FOUND with id: '"+id+"'");
		}
		
		ChainCodeInvoker item = changeRequestToUpdate.getChainCodeInvokerList().first();
		
		item.updateParameters( parameters );

		
		//checkParamsForAddingChainCodeInvoker(userContext,changeRequestId,name, code, used,tokensExpr);
		ChangeRequest changeRequest = saveChangeRequest(userContext, changeRequestToUpdate, tokens().withChainCodeInvokerList().done());
		synchronized(changeRequest){ 
			return present(userContext,changeRequest, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ChainCodeInvoker createChainCodeInvoker(HfgwUserContext userContext, String appClientId, String chainCodeId, String parameters) throws Exception{

		ChainCodeInvoker chainCodeInvoker = new ChainCodeInvoker();
		
		
		Application  appClient = new Application();
		appClient.setId(appClientId);		
		chainCodeInvoker.setAppClient(appClient);		
		ChainCode  chainCode = new ChainCode();
		chainCode.setId(chainCodeId);		
		chainCodeInvoker.setChainCode(chainCode);		
		chainCodeInvoker.setParameters(parameters);
	
		
		return chainCodeInvoker;
	
		
	}
	
	protected ChainCodeInvoker createIndexedChainCodeInvoker(String id, int version){

		ChainCodeInvoker chainCodeInvoker = new ChainCodeInvoker();
		chainCodeInvoker.setId(id);
		chainCodeInvoker.setVersion(version);
		return chainCodeInvoker;			
		
	}
	
	protected void checkParamsForRemovingChainCodeInvokerList(HfgwUserContext userContext, String changeRequestId, 
			String chainCodeInvokerIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		for(String chainCodeInvokerIdItem: chainCodeInvokerIds){
			checkerOf(userContext).checkIdOfChainCodeInvoker(chainCodeInvokerIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);
		
	}
	public  ChangeRequest removeChainCodeInvokerList(HfgwUserContext userContext, String changeRequestId, 
			String chainCodeInvokerIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingChainCodeInvokerList(userContext, changeRequestId,  chainCodeInvokerIds, tokensExpr);
			
			
			ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());
			synchronized(changeRequest){ 
				//Will be good when the changeRequest loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				changeRequestDaoOf(userContext).planToRemoveChainCodeInvokerList(changeRequest, chainCodeInvokerIds, allTokens());
				changeRequest = saveChangeRequest(userContext, changeRequest, tokens().withChainCodeInvokerList().done());
				deleteRelationListInGraph(userContext, changeRequest.getChainCodeInvokerList());
				return present(userContext,changeRequest, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingChainCodeInvoker(HfgwUserContext userContext, String changeRequestId, 
		String chainCodeInvokerId, int chainCodeInvokerVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfChangeRequest( changeRequestId);
		checkerOf(userContext).checkIdOfChainCodeInvoker(chainCodeInvokerId);
		checkerOf(userContext).checkVersionOfChainCodeInvoker(chainCodeInvokerVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);
	
	}
	public  ChangeRequest removeChainCodeInvoker(HfgwUserContext userContext, String changeRequestId, 
		String chainCodeInvokerId, int chainCodeInvokerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingChainCodeInvoker(userContext,changeRequestId, chainCodeInvokerId, chainCodeInvokerVersion,tokensExpr);
		
		ChainCodeInvoker chainCodeInvoker = createIndexedChainCodeInvoker(chainCodeInvokerId, chainCodeInvokerVersion);
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());
		synchronized(changeRequest){ 
			//Will be good when the changeRequest loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			changeRequest.removeChainCodeInvoker( chainCodeInvoker );		
			changeRequest = saveChangeRequest(userContext, changeRequest, tokens().withChainCodeInvokerList().done());
			deleteRelationInGraph(userContext, chainCodeInvoker);
			return present(userContext,changeRequest, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingChainCodeInvoker(HfgwUserContext userContext, String changeRequestId, 
		String chainCodeInvokerId, int chainCodeInvokerVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfChangeRequest( changeRequestId);
		checkerOf(userContext).checkIdOfChainCodeInvoker(chainCodeInvokerId);
		checkerOf(userContext).checkVersionOfChainCodeInvoker(chainCodeInvokerVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);
	
	}
	public  ChangeRequest copyChainCodeInvokerFrom(HfgwUserContext userContext, String changeRequestId, 
		String chainCodeInvokerId, int chainCodeInvokerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingChainCodeInvoker(userContext,changeRequestId, chainCodeInvokerId, chainCodeInvokerVersion,tokensExpr);
		
		ChainCodeInvoker chainCodeInvoker = createIndexedChainCodeInvoker(chainCodeInvokerId, chainCodeInvokerVersion);
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());
		synchronized(changeRequest){ 
			//Will be good when the changeRequest loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			changeRequest.copyChainCodeInvokerFrom( chainCodeInvoker );		
			changeRequest = saveChangeRequest(userContext, changeRequest, tokens().withChainCodeInvokerList().done());
			
			userContext.getManagerGroup().getChainCodeInvokerManager().onNewInstanceCreated(userContext, (ChainCodeInvoker)changeRequest.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,changeRequest, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingChainCodeInvoker(HfgwUserContext userContext, String changeRequestId, String chainCodeInvokerId, int chainCodeInvokerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		checkerOf(userContext).checkIdOfChainCodeInvoker(chainCodeInvokerId);
		checkerOf(userContext).checkVersionOfChainCodeInvoker(chainCodeInvokerVersion);
		

		if(ChainCodeInvoker.PARAMETERS_PROPERTY.equals(property)){
			checkerOf(userContext).checkParametersOfChainCodeInvoker(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);
	
	}
	
	public  ChangeRequest updateChainCodeInvoker(HfgwUserContext userContext, String changeRequestId, String chainCodeInvokerId, int chainCodeInvokerVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingChainCodeInvoker(userContext, changeRequestId, chainCodeInvokerId, chainCodeInvokerVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withChainCodeInvokerList().searchChainCodeInvokerListWith(ChainCodeInvoker.ID_PROPERTY, "eq", chainCodeInvokerId).done();
		
		
		
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, loadTokens);
		
		synchronized(changeRequest){ 
			//Will be good when the changeRequest loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//changeRequest.removeChainCodeInvoker( chainCodeInvoker );	
			//make changes to AcceleraterAccount.
			ChainCodeInvoker chainCodeInvokerIndex = createIndexedChainCodeInvoker(chainCodeInvokerId, chainCodeInvokerVersion);
		
			ChainCodeInvoker chainCodeInvoker = changeRequest.findTheChainCodeInvoker(chainCodeInvokerIndex);
			if(chainCodeInvoker == null){
				throw new ChangeRequestManagerException(chainCodeInvoker+" is NOT FOUND" );
			}
			
			chainCodeInvoker.changeProperty(property, newValueExpr);
			
			changeRequest = saveChangeRequest(userContext, changeRequest, tokens().withChainCodeInvokerList().done());
			return present(userContext,changeRequest, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(HfgwUserContext userContext, ChangeRequest newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


