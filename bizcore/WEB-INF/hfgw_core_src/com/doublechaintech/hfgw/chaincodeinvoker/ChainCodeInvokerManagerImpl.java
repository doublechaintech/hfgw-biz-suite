
package com.doublechaintech.hfgw.chaincodeinvoker;

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
import com.doublechaintech.hfgw.changerequest.ChangeRequest;
import com.doublechaintech.hfgw.application.Application;

import com.doublechaintech.hfgw.chaincode.CandidateChainCode;
import com.doublechaintech.hfgw.changerequest.CandidateChangeRequest;
import com.doublechaintech.hfgw.application.CandidateApplication;







public class ChainCodeInvokerManagerImpl extends CustomHfgwCheckerManager implements ChainCodeInvokerManager {
	
	private static final String SERVICE_TYPE = "ChainCodeInvoker";
	@Override
	public ChainCodeInvokerDAO daoOf(HfgwUserContext userContext) {
		return chainCodeInvokerDaoOf(userContext);
	}
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ChainCodeInvokerManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ChainCodeInvokerManagerException(message);

	}
	
	

 	protected ChainCodeInvoker saveChainCodeInvoker(HfgwUserContext userContext, ChainCodeInvoker chainCodeInvoker, String [] tokensExpr) throws Exception{	
 		//return getChainCodeInvokerDAO().save(chainCodeInvoker, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveChainCodeInvoker(userContext, chainCodeInvoker, tokens);
 	}
 	
 	protected ChainCodeInvoker saveChainCodeInvokerDetail(HfgwUserContext userContext, ChainCodeInvoker chainCodeInvoker) throws Exception{	

 		
 		return saveChainCodeInvoker(userContext, chainCodeInvoker, allTokens());
 	}
 	
 	public ChainCodeInvoker loadChainCodeInvoker(HfgwUserContext userContext, String chainCodeInvokerId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfChainCodeInvoker(chainCodeInvokerId);
		checkerOf(userContext).throwExceptionIfHasErrors( ChainCodeInvokerManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ChainCodeInvoker chainCodeInvoker = loadChainCodeInvoker( userContext, chainCodeInvokerId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,chainCodeInvoker, tokens);
 	}
 	
 	
 	 public ChainCodeInvoker searchChainCodeInvoker(HfgwUserContext userContext, String chainCodeInvokerId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfChainCodeInvoker(chainCodeInvokerId);
		checkerOf(userContext).throwExceptionIfHasErrors( ChainCodeInvokerManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ChainCodeInvoker chainCodeInvoker = loadChainCodeInvoker( userContext, chainCodeInvokerId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,chainCodeInvoker, tokens);
 	}
 	
 	

 	protected ChainCodeInvoker present(HfgwUserContext userContext, ChainCodeInvoker chainCodeInvoker, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,chainCodeInvoker,tokens);
		
		
		ChainCodeInvoker  chainCodeInvokerToPresent = chainCodeInvokerDaoOf(userContext).present(chainCodeInvoker, tokens);
		
		List<BaseEntity> entityListToNaming = chainCodeInvokerToPresent.collectRefercencesFromLists();
		chainCodeInvokerDaoOf(userContext).alias(entityListToNaming);
		
		return  chainCodeInvokerToPresent;
		
		
	}
 
 	
 	
 	public ChainCodeInvoker loadChainCodeInvokerDetail(HfgwUserContext userContext, String chainCodeInvokerId) throws Exception{	
 		ChainCodeInvoker chainCodeInvoker = loadChainCodeInvoker( userContext, chainCodeInvokerId, allTokens());
 		return present(userContext,chainCodeInvoker, allTokens());
		
 	}
 	
 	public Object view(HfgwUserContext userContext, String chainCodeInvokerId) throws Exception{	
 		ChainCodeInvoker chainCodeInvoker = loadChainCodeInvoker( userContext, chainCodeInvokerId, viewTokens());
 		return present(userContext,chainCodeInvoker, allTokens());
		
 	}
 	protected ChainCodeInvoker saveChainCodeInvoker(HfgwUserContext userContext, ChainCodeInvoker chainCodeInvoker, Map<String,Object>tokens) throws Exception{	
 		return chainCodeInvokerDaoOf(userContext).save(chainCodeInvoker, tokens);
 	}
 	protected ChainCodeInvoker loadChainCodeInvoker(HfgwUserContext userContext, String chainCodeInvokerId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfChainCodeInvoker(chainCodeInvokerId);
		checkerOf(userContext).throwExceptionIfHasErrors( ChainCodeInvokerManagerException.class);

 
 		return chainCodeInvokerDaoOf(userContext).load(chainCodeInvokerId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, ChainCodeInvoker chainCodeInvoker, Map<String, Object> tokens){
		super.addActions(userContext, chainCodeInvoker, tokens);
		
		addAction(userContext, chainCodeInvoker, tokens,"@create","createChainCodeInvoker","createChainCodeInvoker/","main","primary");
		addAction(userContext, chainCodeInvoker, tokens,"@update","updateChainCodeInvoker","updateChainCodeInvoker/"+chainCodeInvoker.getId()+"/","main","primary");
		addAction(userContext, chainCodeInvoker, tokens,"@copy","cloneChainCodeInvoker","cloneChainCodeInvoker/"+chainCodeInvoker.getId()+"/","main","primary");
		
		addAction(userContext, chainCodeInvoker, tokens,"chain_code_invoker.transfer_to_app_client","transferToAnotherAppClient","transferToAnotherAppClient/"+chainCodeInvoker.getId()+"/","main","primary");
		addAction(userContext, chainCodeInvoker, tokens,"chain_code_invoker.transfer_to_chain_code","transferToAnotherChainCode","transferToAnotherChainCode/"+chainCodeInvoker.getId()+"/","main","primary");
		addAction(userContext, chainCodeInvoker, tokens,"chain_code_invoker.transfer_to_change_request","transferToAnotherChangeRequest","transferToAnotherChangeRequest/"+chainCodeInvoker.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, ChainCodeInvoker chainCodeInvoker, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public ChainCodeInvoker createChainCodeInvoker(HfgwUserContext userContext, String appClientId,String chainCodeId,String parameters,String changeRequestId) throws Exception
	//public ChainCodeInvoker createChainCodeInvoker(HfgwUserContext userContext,String appClientId, String chainCodeId, String parameters, String changeRequestId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkParametersOfChainCodeInvoker(parameters);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChainCodeInvokerManagerException.class);


		ChainCodeInvoker chainCodeInvoker=createNewChainCodeInvoker();	

			
		Application appClient = loadApplication(userContext, appClientId,emptyOptions());
		chainCodeInvoker.setAppClient(appClient);
		
		
			
		ChainCode chainCode = loadChainCode(userContext, chainCodeId,emptyOptions());
		chainCodeInvoker.setChainCode(chainCode);
		
		
		chainCodeInvoker.setParameters(parameters);
			
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId,emptyOptions());
		chainCodeInvoker.setChangeRequest(changeRequest);
		
		

		chainCodeInvoker = saveChainCodeInvoker(userContext, chainCodeInvoker, emptyOptions());
		
		onNewInstanceCreated(userContext, chainCodeInvoker);
		return chainCodeInvoker;

		
	}
	protected ChainCodeInvoker createNewChainCodeInvoker() 
	{
		
		return new ChainCodeInvoker();		
	}
	
	protected void checkParamsForUpdatingChainCodeInvoker(HfgwUserContext userContext,String chainCodeInvokerId, int chainCodeInvokerVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfChainCodeInvoker(chainCodeInvokerId);
		checkerOf(userContext).checkVersionOfChainCodeInvoker( chainCodeInvokerVersion);
		
		

				

		
		if(ChainCodeInvoker.PARAMETERS_PROPERTY.equals(property)){
			checkerOf(userContext).checkParametersOfChainCodeInvoker(parseString(newValueExpr));
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChainCodeInvokerManagerException.class);
	
		
	}
	
	
	
	public ChainCodeInvoker clone(HfgwUserContext userContext, String fromChainCodeInvokerId) throws Exception{
		
		return chainCodeInvokerDaoOf(userContext).clone(fromChainCodeInvokerId, this.allTokens());
	}
	
	public ChainCodeInvoker internalSaveChainCodeInvoker(HfgwUserContext userContext, ChainCodeInvoker chainCodeInvoker) throws Exception 
	{
		return internalSaveChainCodeInvoker(userContext, chainCodeInvoker, allTokens());

	}
	public ChainCodeInvoker internalSaveChainCodeInvoker(HfgwUserContext userContext, ChainCodeInvoker chainCodeInvoker, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingChainCodeInvoker(userContext, chainCodeInvokerId, chainCodeInvokerVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(chainCodeInvoker){ 
			//will be good when the chainCodeInvoker loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ChainCodeInvoker.
			if (chainCodeInvoker.isChanged()){
			
			}
			chainCodeInvoker = saveChainCodeInvoker(userContext, chainCodeInvoker, options);
			return chainCodeInvoker;
			
		}

	}
	
	public ChainCodeInvoker updateChainCodeInvoker(HfgwUserContext userContext,String chainCodeInvokerId, int chainCodeInvokerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingChainCodeInvoker(userContext, chainCodeInvokerId, chainCodeInvokerVersion, property, newValueExpr, tokensExpr);
		
		
		
		ChainCodeInvoker chainCodeInvoker = loadChainCodeInvoker(userContext, chainCodeInvokerId, allTokens());
		if(chainCodeInvoker.getVersion() != chainCodeInvokerVersion){
			String message = "The target version("+chainCodeInvoker.getVersion()+") is not equals to version("+chainCodeInvokerVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(chainCodeInvoker){ 
			//will be good when the chainCodeInvoker loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ChainCodeInvoker.
			
			chainCodeInvoker.changeProperty(property, newValueExpr);
			chainCodeInvoker = saveChainCodeInvoker(userContext, chainCodeInvoker, tokens().done());
			return present(userContext,chainCodeInvoker, mergedAllTokens(tokensExpr));
			//return saveChainCodeInvoker(userContext, chainCodeInvoker, tokens().done());
		}

	}
	
	public ChainCodeInvoker updateChainCodeInvokerProperty(HfgwUserContext userContext,String chainCodeInvokerId, int chainCodeInvokerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingChainCodeInvoker(userContext, chainCodeInvokerId, chainCodeInvokerVersion, property, newValueExpr, tokensExpr);
		
		ChainCodeInvoker chainCodeInvoker = loadChainCodeInvoker(userContext, chainCodeInvokerId, allTokens());
		if(chainCodeInvoker.getVersion() != chainCodeInvokerVersion){
			String message = "The target version("+chainCodeInvoker.getVersion()+") is not equals to version("+chainCodeInvokerVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(chainCodeInvoker){ 
			//will be good when the chainCodeInvoker loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ChainCodeInvoker.
			
			chainCodeInvoker.changeProperty(property, newValueExpr);
			
			chainCodeInvoker = saveChainCodeInvoker(userContext, chainCodeInvoker, tokens().done());
			return present(userContext,chainCodeInvoker, mergedAllTokens(tokensExpr));
			//return saveChainCodeInvoker(userContext, chainCodeInvoker, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ChainCodeInvokerTokens tokens(){
		return ChainCodeInvokerTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ChainCodeInvokerTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ChainCodeInvokerTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherAppClient(HfgwUserContext userContext, String chainCodeInvokerId, String anotherAppClientId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfChainCodeInvoker(chainCodeInvokerId);
 		checkerOf(userContext).checkIdOfApplication(anotherAppClientId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ChainCodeInvokerManagerException.class);
 		
 	}
 	public ChainCodeInvoker transferToAnotherAppClient(HfgwUserContext userContext, String chainCodeInvokerId, String anotherAppClientId) throws Exception
 	{
 		checkParamsForTransferingAnotherAppClient(userContext, chainCodeInvokerId,anotherAppClientId);
 
		ChainCodeInvoker chainCodeInvoker = loadChainCodeInvoker(userContext, chainCodeInvokerId, allTokens());	
		synchronized(chainCodeInvoker){
			//will be good when the chainCodeInvoker loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Application appClient = loadApplication(userContext, anotherAppClientId, emptyOptions());		
			chainCodeInvoker.updateAppClient(appClient);		
			chainCodeInvoker = saveChainCodeInvoker(userContext, chainCodeInvoker, emptyOptions());
			
			return present(userContext,chainCodeInvoker, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateApplication requestCandidateAppClient(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

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
		SmartList<Application> candidateList = applicationDaoOf(userContext).requestCandidateApplicationForChainCodeInvoker(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherChainCode(HfgwUserContext userContext, String chainCodeInvokerId, String anotherChainCodeId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfChainCodeInvoker(chainCodeInvokerId);
 		checkerOf(userContext).checkIdOfChainCode(anotherChainCodeId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ChainCodeInvokerManagerException.class);
 		
 	}
 	public ChainCodeInvoker transferToAnotherChainCode(HfgwUserContext userContext, String chainCodeInvokerId, String anotherChainCodeId) throws Exception
 	{
 		checkParamsForTransferingAnotherChainCode(userContext, chainCodeInvokerId,anotherChainCodeId);
 
		ChainCodeInvoker chainCodeInvoker = loadChainCodeInvoker(userContext, chainCodeInvokerId, allTokens());	
		synchronized(chainCodeInvoker){
			//will be good when the chainCodeInvoker loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ChainCode chainCode = loadChainCode(userContext, anotherChainCodeId, emptyOptions());		
			chainCodeInvoker.updateChainCode(chainCode);		
			chainCodeInvoker = saveChainCodeInvoker(userContext, chainCodeInvoker, emptyOptions());
			
			return present(userContext,chainCodeInvoker, allTokens());
			
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
		SmartList<ChainCode> candidateList = chainCodeDaoOf(userContext).requestCandidateChainCodeForChainCodeInvoker(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherChangeRequest(HfgwUserContext userContext, String chainCodeInvokerId, String anotherChangeRequestId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfChainCodeInvoker(chainCodeInvokerId);
 		checkerOf(userContext).checkIdOfChangeRequest(anotherChangeRequestId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ChainCodeInvokerManagerException.class);
 		
 	}
 	public ChainCodeInvoker transferToAnotherChangeRequest(HfgwUserContext userContext, String chainCodeInvokerId, String anotherChangeRequestId) throws Exception
 	{
 		checkParamsForTransferingAnotherChangeRequest(userContext, chainCodeInvokerId,anotherChangeRequestId);
 
		ChainCodeInvoker chainCodeInvoker = loadChainCodeInvoker(userContext, chainCodeInvokerId, allTokens());	
		synchronized(chainCodeInvoker){
			//will be good when the chainCodeInvoker loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ChangeRequest changeRequest = loadChangeRequest(userContext, anotherChangeRequestId, emptyOptions());		
			chainCodeInvoker.updateChangeRequest(changeRequest);		
			chainCodeInvoker = saveChainCodeInvoker(userContext, chainCodeInvoker, emptyOptions());
			
			return present(userContext,chainCodeInvoker, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateChangeRequest requestCandidateChangeRequest(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateChangeRequest result = new CandidateChangeRequest();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<ChangeRequest> candidateList = changeRequestDaoOf(userContext).requestCandidateChangeRequestForChainCodeInvoker(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected ChangeRequest loadChangeRequest(HfgwUserContext userContext, String newChangeRequestId, Map<String,Object> options) throws Exception
 	{
		
 		return changeRequestDaoOf(userContext).load(newChangeRequestId, options);
 	}
 	
 	
 	
	
	 	
 	protected Application loadApplication(HfgwUserContext userContext, String newAppClientId, Map<String,Object> options) throws Exception
 	{
		
 		return applicationDaoOf(userContext).load(newAppClientId, options);
 	}
 	
 	
 	
	
	 	
 	protected ChainCode loadChainCode(HfgwUserContext userContext, String newChainCodeId, Map<String,Object> options) throws Exception
 	{
		
 		return chainCodeDaoOf(userContext).load(newChainCodeId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(HfgwUserContext userContext, String chainCodeInvokerId, int chainCodeInvokerVersion) throws Exception {
		//deleteInternal(userContext, chainCodeInvokerId, chainCodeInvokerVersion);		
	}
	protected void deleteInternal(HfgwUserContext userContext,
			String chainCodeInvokerId, int chainCodeInvokerVersion) throws Exception{
			
		chainCodeInvokerDaoOf(userContext).delete(chainCodeInvokerId, chainCodeInvokerVersion);
	}
	
	public ChainCodeInvoker forgetByAll(HfgwUserContext userContext, String chainCodeInvokerId, int chainCodeInvokerVersion) throws Exception {
		return forgetByAllInternal(userContext, chainCodeInvokerId, chainCodeInvokerVersion);		
	}
	protected ChainCodeInvoker forgetByAllInternal(HfgwUserContext userContext,
			String chainCodeInvokerId, int chainCodeInvokerVersion) throws Exception{
			
		return chainCodeInvokerDaoOf(userContext).disconnectFromAll(chainCodeInvokerId, chainCodeInvokerVersion);
	}
	
	

	
	public int deleteAll(HfgwUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ChainCodeInvokerManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HfgwUserContext userContext) throws Exception{
		return chainCodeInvokerDaoOf(userContext).deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(HfgwUserContext userContext, ChainCodeInvoker newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


