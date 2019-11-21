
package com.doublechaintech.hfgw.changerequesttype;

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

import com.doublechaintech.hfgw.changerequest.ChangeRequest;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

import com.doublechaintech.hfgw.hyperledgernetwork.CandidateHyperledgerNetwork;

import com.doublechaintech.hfgw.changerequesttype.ChangeRequestType;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;






public class ChangeRequestTypeManagerImpl extends CustomHfgwCheckerManager implements ChangeRequestTypeManager {
	
	private static final String SERVICE_TYPE = "ChangeRequestType";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ChangeRequestTypeManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ChangeRequestTypeManagerException(message);

	}
	
	

 	protected ChangeRequestType saveChangeRequestType(HfgwUserContext userContext, ChangeRequestType changeRequestType, String [] tokensExpr) throws Exception{	
 		//return getChangeRequestTypeDAO().save(changeRequestType, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveChangeRequestType(userContext, changeRequestType, tokens);
 	}
 	
 	protected ChangeRequestType saveChangeRequestTypeDetail(HfgwUserContext userContext, ChangeRequestType changeRequestType) throws Exception{	

 		
 		return saveChangeRequestType(userContext, changeRequestType, allTokens());
 	}
 	
 	public ChangeRequestType loadChangeRequestType(HfgwUserContext userContext, String changeRequestTypeId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfChangeRequestType(changeRequestTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( ChangeRequestTypeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ChangeRequestType changeRequestType = loadChangeRequestType( userContext, changeRequestTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,changeRequestType, tokens);
 	}
 	
 	
 	 public ChangeRequestType searchChangeRequestType(HfgwUserContext userContext, String changeRequestTypeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfChangeRequestType(changeRequestTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( ChangeRequestTypeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ChangeRequestType changeRequestType = loadChangeRequestType( userContext, changeRequestTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,changeRequestType, tokens);
 	}
 	
 	

 	protected ChangeRequestType present(HfgwUserContext userContext, ChangeRequestType changeRequestType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,changeRequestType,tokens);
		
		
		ChangeRequestType  changeRequestTypeToPresent = changeRequestTypeDaoOf(userContext).present(changeRequestType, tokens);
		
		List<BaseEntity> entityListToNaming = changeRequestTypeToPresent.collectRefercencesFromLists();
		changeRequestTypeDaoOf(userContext).alias(entityListToNaming);
		
		return  changeRequestTypeToPresent;
		
		
	}
 
 	
 	
 	public ChangeRequestType loadChangeRequestTypeDetail(HfgwUserContext userContext, String changeRequestTypeId) throws Exception{	
 		ChangeRequestType changeRequestType = loadChangeRequestType( userContext, changeRequestTypeId, allTokens());
 		return present(userContext,changeRequestType, allTokens());
		
 	}
 	
 	public Object view(HfgwUserContext userContext, String changeRequestTypeId) throws Exception{	
 		ChangeRequestType changeRequestType = loadChangeRequestType( userContext, changeRequestTypeId, viewTokens());
 		return present(userContext,changeRequestType, allTokens());
		
 	}
 	protected ChangeRequestType saveChangeRequestType(HfgwUserContext userContext, ChangeRequestType changeRequestType, Map<String,Object>tokens) throws Exception{	
 		return changeRequestTypeDaoOf(userContext).save(changeRequestType, tokens);
 	}
 	protected ChangeRequestType loadChangeRequestType(HfgwUserContext userContext, String changeRequestTypeId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfChangeRequestType(changeRequestTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( ChangeRequestTypeManagerException.class);

 
 		return changeRequestTypeDaoOf(userContext).load(changeRequestTypeId, tokens);
 	}

	
	

	public ChangeRequestType loadChangeRequestTypeWithCode(HfgwUserContext userContext, String code, Map<String,Object>tokens) throws Exception{	
 		return changeRequestTypeDaoOf(userContext).loadByCode(code, tokens);
 	}

	 


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, ChangeRequestType changeRequestType, Map<String, Object> tokens){
		super.addActions(userContext, changeRequestType, tokens);
		
		addAction(userContext, changeRequestType, tokens,"@create","createChangeRequestType","createChangeRequestType/","main","primary");
		addAction(userContext, changeRequestType, tokens,"@update","updateChangeRequestType","updateChangeRequestType/"+changeRequestType.getId()+"/","main","primary");
		addAction(userContext, changeRequestType, tokens,"@copy","cloneChangeRequestType","cloneChangeRequestType/"+changeRequestType.getId()+"/","main","primary");
		
		addAction(userContext, changeRequestType, tokens,"change_request_type.transfer_to_network","transferToAnotherNetwork","transferToAnotherNetwork/"+changeRequestType.getId()+"/","main","primary");
		addAction(userContext, changeRequestType, tokens,"change_request_type.addChangeRequest","addChangeRequest","addChangeRequest/"+changeRequestType.getId()+"/","changeRequestList","primary");
		addAction(userContext, changeRequestType, tokens,"change_request_type.removeChangeRequest","removeChangeRequest","removeChangeRequest/"+changeRequestType.getId()+"/","changeRequestList","primary");
		addAction(userContext, changeRequestType, tokens,"change_request_type.updateChangeRequest","updateChangeRequest","updateChangeRequest/"+changeRequestType.getId()+"/","changeRequestList","primary");
		addAction(userContext, changeRequestType, tokens,"change_request_type.copyChangeRequestFrom","copyChangeRequestFrom","copyChangeRequestFrom/"+changeRequestType.getId()+"/","changeRequestList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, ChangeRequestType changeRequestType, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public ChangeRequestType createChangeRequestType(HfgwUserContext userContext, String name,String code,String icon,int displayOrder,String bindTypes,String stepConfiguration,String networkId) throws Exception
	//public ChangeRequestType createChangeRequestType(HfgwUserContext userContext,String name, String code, String icon, int displayOrder, String bindTypes, String stepConfiguration, String networkId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkNameOfChangeRequestType(name);
		checkerOf(userContext).checkCodeOfChangeRequestType(code);
		checkerOf(userContext).checkIconOfChangeRequestType(icon);
		checkerOf(userContext).checkDisplayOrderOfChangeRequestType(displayOrder);
		checkerOf(userContext).checkBindTypesOfChangeRequestType(bindTypes);
		checkerOf(userContext).checkStepConfigurationOfChangeRequestType(stepConfiguration);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestTypeManagerException.class);


		ChangeRequestType changeRequestType=createNewChangeRequestType();	

		changeRequestType.setName(name);
		changeRequestType.setCode(code);
		changeRequestType.setIcon(icon);
		changeRequestType.setDisplayOrder(displayOrder);
		changeRequestType.setBindTypes(bindTypes);
		changeRequestType.setStepConfiguration(stepConfiguration);
			
		HyperledgerNetwork network = loadHyperledgerNetwork(userContext, networkId,emptyOptions());
		changeRequestType.setNetwork(network);
		
		

		changeRequestType = saveChangeRequestType(userContext, changeRequestType, emptyOptions());
		
		onNewInstanceCreated(userContext, changeRequestType);
		return changeRequestType;

		
	}
	protected ChangeRequestType createNewChangeRequestType() 
	{
		
		return new ChangeRequestType();		
	}
	
	protected void checkParamsForUpdatingChangeRequestType(HfgwUserContext userContext,String changeRequestTypeId, int changeRequestTypeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfChangeRequestType(changeRequestTypeId);
		checkerOf(userContext).checkVersionOfChangeRequestType( changeRequestTypeVersion);
		

		if(ChangeRequestType.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfChangeRequestType(parseString(newValueExpr));
		}
		if(ChangeRequestType.CODE_PROPERTY.equals(property)){
			checkerOf(userContext).checkCodeOfChangeRequestType(parseString(newValueExpr));
		}
		if(ChangeRequestType.ICON_PROPERTY.equals(property)){
			checkerOf(userContext).checkIconOfChangeRequestType(parseString(newValueExpr));
		}
		if(ChangeRequestType.DISPLAY_ORDER_PROPERTY.equals(property)){
			checkerOf(userContext).checkDisplayOrderOfChangeRequestType(parseInt(newValueExpr));
		}
		if(ChangeRequestType.BIND_TYPES_PROPERTY.equals(property)){
			checkerOf(userContext).checkBindTypesOfChangeRequestType(parseString(newValueExpr));
		}
		if(ChangeRequestType.STEP_CONFIGURATION_PROPERTY.equals(property)){
			checkerOf(userContext).checkStepConfigurationOfChangeRequestType(parseString(newValueExpr));
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestTypeManagerException.class);
	
		
	}
	
	
	
	public ChangeRequestType clone(HfgwUserContext userContext, String fromChangeRequestTypeId) throws Exception{
		
		return changeRequestTypeDaoOf(userContext).clone(fromChangeRequestTypeId, this.allTokens());
	}
	
	public ChangeRequestType internalSaveChangeRequestType(HfgwUserContext userContext, ChangeRequestType changeRequestType) throws Exception 
	{
		return internalSaveChangeRequestType(userContext, changeRequestType, allTokens());

	}
	public ChangeRequestType internalSaveChangeRequestType(HfgwUserContext userContext, ChangeRequestType changeRequestType, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingChangeRequestType(userContext, changeRequestTypeId, changeRequestTypeVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(changeRequestType){ 
			//will be good when the changeRequestType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ChangeRequestType.
			if (changeRequestType.isChanged()){
			
			}
			changeRequestType = saveChangeRequestType(userContext, changeRequestType, options);
			return changeRequestType;
			
		}

	}
	
	public ChangeRequestType updateChangeRequestType(HfgwUserContext userContext,String changeRequestTypeId, int changeRequestTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingChangeRequestType(userContext, changeRequestTypeId, changeRequestTypeVersion, property, newValueExpr, tokensExpr);
		
		
		
		ChangeRequestType changeRequestType = loadChangeRequestType(userContext, changeRequestTypeId, allTokens());
		if(changeRequestType.getVersion() != changeRequestTypeVersion){
			String message = "The target version("+changeRequestType.getVersion()+") is not equals to version("+changeRequestTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(changeRequestType){ 
			//will be good when the changeRequestType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ChangeRequestType.
			
			changeRequestType.changeProperty(property, newValueExpr);
			changeRequestType = saveChangeRequestType(userContext, changeRequestType, tokens().done());
			return present(userContext,changeRequestType, mergedAllTokens(tokensExpr));
			//return saveChangeRequestType(userContext, changeRequestType, tokens().done());
		}

	}
	
	public ChangeRequestType updateChangeRequestTypeProperty(HfgwUserContext userContext,String changeRequestTypeId, int changeRequestTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingChangeRequestType(userContext, changeRequestTypeId, changeRequestTypeVersion, property, newValueExpr, tokensExpr);
		
		ChangeRequestType changeRequestType = loadChangeRequestType(userContext, changeRequestTypeId, allTokens());
		if(changeRequestType.getVersion() != changeRequestTypeVersion){
			String message = "The target version("+changeRequestType.getVersion()+") is not equals to version("+changeRequestTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(changeRequestType){ 
			//will be good when the changeRequestType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ChangeRequestType.
			
			changeRequestType.changeProperty(property, newValueExpr);
			
			changeRequestType = saveChangeRequestType(userContext, changeRequestType, tokens().done());
			return present(userContext,changeRequestType, mergedAllTokens(tokensExpr));
			//return saveChangeRequestType(userContext, changeRequestType, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ChangeRequestTypeTokens tokens(){
		return ChangeRequestTypeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ChangeRequestTypeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortChangeRequestListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ChangeRequestTypeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherNetwork(HfgwUserContext userContext, String changeRequestTypeId, String anotherNetworkId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfChangeRequestType(changeRequestTypeId);
 		checkerOf(userContext).checkIdOfHyperledgerNetwork(anotherNetworkId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestTypeManagerException.class);
 		
 	}
 	public ChangeRequestType transferToAnotherNetwork(HfgwUserContext userContext, String changeRequestTypeId, String anotherNetworkId) throws Exception
 	{
 		checkParamsForTransferingAnotherNetwork(userContext, changeRequestTypeId,anotherNetworkId);
 
		ChangeRequestType changeRequestType = loadChangeRequestType(userContext, changeRequestTypeId, allTokens());	
		synchronized(changeRequestType){
			//will be good when the changeRequestType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			HyperledgerNetwork network = loadHyperledgerNetwork(userContext, anotherNetworkId, emptyOptions());		
			changeRequestType.updateNetwork(network);		
			changeRequestType = saveChangeRequestType(userContext, changeRequestType, emptyOptions());
			
			return present(userContext,changeRequestType, allTokens());
			
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
		SmartList<HyperledgerNetwork> candidateList = hyperledgerNetworkDaoOf(userContext).requestCandidateHyperledgerNetworkForChangeRequestType(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(HfgwUserContext userContext, String changeRequestTypeId, int changeRequestTypeVersion) throws Exception {
		//deleteInternal(userContext, changeRequestTypeId, changeRequestTypeVersion);		
	}
	protected void deleteInternal(HfgwUserContext userContext,
			String changeRequestTypeId, int changeRequestTypeVersion) throws Exception{
			
		changeRequestTypeDaoOf(userContext).delete(changeRequestTypeId, changeRequestTypeVersion);
	}
	
	public ChangeRequestType forgetByAll(HfgwUserContext userContext, String changeRequestTypeId, int changeRequestTypeVersion) throws Exception {
		return forgetByAllInternal(userContext, changeRequestTypeId, changeRequestTypeVersion);		
	}
	protected ChangeRequestType forgetByAllInternal(HfgwUserContext userContext,
			String changeRequestTypeId, int changeRequestTypeVersion) throws Exception{
			
		return changeRequestTypeDaoOf(userContext).disconnectFromAll(changeRequestTypeId, changeRequestTypeVersion);
	}
	
	

	
	public int deleteAll(HfgwUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ChangeRequestTypeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HfgwUserContext userContext) throws Exception{
		return changeRequestTypeDaoOf(userContext).deleteAll();
	}


	//disconnect ChangeRequestType with network in ChangeRequest
	protected ChangeRequestType breakWithChangeRequestByNetwork(HfgwUserContext userContext, String changeRequestTypeId, String networkId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ChangeRequestType changeRequestType = loadChangeRequestType(userContext, changeRequestTypeId, allTokens());

			synchronized(changeRequestType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				changeRequestTypeDaoOf(userContext).planToRemoveChangeRequestListWithNetwork(changeRequestType, networkId, this.emptyOptions());

				changeRequestType = saveChangeRequestType(userContext, changeRequestType, tokens().withChangeRequestList().done());
				return changeRequestType;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingChangeRequest(HfgwUserContext userContext, String changeRequestTypeId, String name, String networkId,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfChangeRequestType(changeRequestTypeId);

		
		checkerOf(userContext).checkNameOfChangeRequest(name);
		
		checkerOf(userContext).checkNetworkIdOfChangeRequest(networkId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestTypeManagerException.class);

	
	}
	public  ChangeRequestType addChangeRequest(HfgwUserContext userContext, String changeRequestTypeId, String name, String networkId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingChangeRequest(userContext,changeRequestTypeId,name, networkId,tokensExpr);
		
		ChangeRequest changeRequest = createChangeRequest(userContext,name, networkId);
		
		ChangeRequestType changeRequestType = loadChangeRequestType(userContext, changeRequestTypeId, allTokens());
		synchronized(changeRequestType){ 
			//Will be good when the changeRequestType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			changeRequestType.addChangeRequest( changeRequest );		
			changeRequestType = saveChangeRequestType(userContext, changeRequestType, tokens().withChangeRequestList().done());
			
			userContext.getManagerGroup().getChangeRequestManager().onNewInstanceCreated(userContext, changeRequest);
			return present(userContext,changeRequestType, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingChangeRequestProperties(HfgwUserContext userContext, String changeRequestTypeId,String id,String name,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfChangeRequestType(changeRequestTypeId);
		checkerOf(userContext).checkIdOfChangeRequest(id);
		
		checkerOf(userContext).checkNameOfChangeRequest( name);

		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestTypeManagerException.class);
		
	}
	public  ChangeRequestType updateChangeRequestProperties(HfgwUserContext userContext, String changeRequestTypeId, String id,String name, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingChangeRequestProperties(userContext,changeRequestTypeId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withChangeRequestListList()
				.searchChangeRequestListWith(ChangeRequest.ID_PROPERTY, "is", id).done();
		
		ChangeRequestType changeRequestTypeToUpdate = loadChangeRequestType(userContext, changeRequestTypeId, options);
		
		if(changeRequestTypeToUpdate.getChangeRequestList().isEmpty()){
			throw new ChangeRequestTypeManagerException("ChangeRequest is NOT FOUND with id: '"+id+"'");
		}
		
		ChangeRequest item = changeRequestTypeToUpdate.getChangeRequestList().first();
		
		item.updateName( name );

		
		//checkParamsForAddingChangeRequest(userContext,changeRequestTypeId,name, code, used,tokensExpr);
		ChangeRequestType changeRequestType = saveChangeRequestType(userContext, changeRequestTypeToUpdate, tokens().withChangeRequestList().done());
		synchronized(changeRequestType){ 
			return present(userContext,changeRequestType, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ChangeRequest createChangeRequest(HfgwUserContext userContext, String name, String networkId) throws Exception{

		ChangeRequest changeRequest = new ChangeRequest();
		
		
		changeRequest.setName(name);		
		changeRequest.setCreateTime(userContext.now());		
		changeRequest.setRemoteIp(userContext.getRemoteIP());		
		HyperledgerNetwork  network = new HyperledgerNetwork();
		network.setId(networkId);		
		changeRequest.setNetwork(network);
	
		
		return changeRequest;
	
		
	}
	
	protected ChangeRequest createIndexedChangeRequest(String id, int version){

		ChangeRequest changeRequest = new ChangeRequest();
		changeRequest.setId(id);
		changeRequest.setVersion(version);
		return changeRequest;			
		
	}
	
	protected void checkParamsForRemovingChangeRequestList(HfgwUserContext userContext, String changeRequestTypeId, 
			String changeRequestIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfChangeRequestType(changeRequestTypeId);
		for(String changeRequestIdItem: changeRequestIds){
			checkerOf(userContext).checkIdOfChangeRequest(changeRequestIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestTypeManagerException.class);
		
	}
	public  ChangeRequestType removeChangeRequestList(HfgwUserContext userContext, String changeRequestTypeId, 
			String changeRequestIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingChangeRequestList(userContext, changeRequestTypeId,  changeRequestIds, tokensExpr);
			
			
			ChangeRequestType changeRequestType = loadChangeRequestType(userContext, changeRequestTypeId, allTokens());
			synchronized(changeRequestType){ 
				//Will be good when the changeRequestType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				changeRequestTypeDaoOf(userContext).planToRemoveChangeRequestList(changeRequestType, changeRequestIds, allTokens());
				changeRequestType = saveChangeRequestType(userContext, changeRequestType, tokens().withChangeRequestList().done());
				deleteRelationListInGraph(userContext, changeRequestType.getChangeRequestList());
				return present(userContext,changeRequestType, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingChangeRequest(HfgwUserContext userContext, String changeRequestTypeId, 
		String changeRequestId, int changeRequestVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfChangeRequestType( changeRequestTypeId);
		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		checkerOf(userContext).checkVersionOfChangeRequest(changeRequestVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestTypeManagerException.class);
	
	}
	public  ChangeRequestType removeChangeRequest(HfgwUserContext userContext, String changeRequestTypeId, 
		String changeRequestId, int changeRequestVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingChangeRequest(userContext,changeRequestTypeId, changeRequestId, changeRequestVersion,tokensExpr);
		
		ChangeRequest changeRequest = createIndexedChangeRequest(changeRequestId, changeRequestVersion);
		ChangeRequestType changeRequestType = loadChangeRequestType(userContext, changeRequestTypeId, allTokens());
		synchronized(changeRequestType){ 
			//Will be good when the changeRequestType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			changeRequestType.removeChangeRequest( changeRequest );		
			changeRequestType = saveChangeRequestType(userContext, changeRequestType, tokens().withChangeRequestList().done());
			deleteRelationInGraph(userContext, changeRequest);
			return present(userContext,changeRequestType, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingChangeRequest(HfgwUserContext userContext, String changeRequestTypeId, 
		String changeRequestId, int changeRequestVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfChangeRequestType( changeRequestTypeId);
		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		checkerOf(userContext).checkVersionOfChangeRequest(changeRequestVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestTypeManagerException.class);
	
	}
	public  ChangeRequestType copyChangeRequestFrom(HfgwUserContext userContext, String changeRequestTypeId, 
		String changeRequestId, int changeRequestVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingChangeRequest(userContext,changeRequestTypeId, changeRequestId, changeRequestVersion,tokensExpr);
		
		ChangeRequest changeRequest = createIndexedChangeRequest(changeRequestId, changeRequestVersion);
		ChangeRequestType changeRequestType = loadChangeRequestType(userContext, changeRequestTypeId, allTokens());
		synchronized(changeRequestType){ 
			//Will be good when the changeRequestType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			changeRequest.updateRemoteIp(userContext.getRemoteIP());
			
			changeRequestType.copyChangeRequestFrom( changeRequest );		
			changeRequestType = saveChangeRequestType(userContext, changeRequestType, tokens().withChangeRequestList().done());
			
			userContext.getManagerGroup().getChangeRequestManager().onNewInstanceCreated(userContext, (ChangeRequest)changeRequestType.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,changeRequestType, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingChangeRequest(HfgwUserContext userContext, String changeRequestTypeId, String changeRequestId, int changeRequestVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfChangeRequestType(changeRequestTypeId);
		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		checkerOf(userContext).checkVersionOfChangeRequest(changeRequestVersion);
		

		if(ChangeRequest.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfChangeRequest(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestTypeManagerException.class);
	
	}
	
	public  ChangeRequestType updateChangeRequest(HfgwUserContext userContext, String changeRequestTypeId, String changeRequestId, int changeRequestVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingChangeRequest(userContext, changeRequestTypeId, changeRequestId, changeRequestVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withChangeRequestList().searchChangeRequestListWith(ChangeRequest.ID_PROPERTY, "eq", changeRequestId).done();
		
		
		
		ChangeRequestType changeRequestType = loadChangeRequestType(userContext, changeRequestTypeId, loadTokens);
		
		synchronized(changeRequestType){ 
			//Will be good when the changeRequestType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//changeRequestType.removeChangeRequest( changeRequest );	
			//make changes to AcceleraterAccount.
			ChangeRequest changeRequestIndex = createIndexedChangeRequest(changeRequestId, changeRequestVersion);
		
			ChangeRequest changeRequest = changeRequestType.findTheChangeRequest(changeRequestIndex);
			if(changeRequest == null){
				throw new ChangeRequestTypeManagerException(changeRequest+" is NOT FOUND" );
			}
			
			changeRequest.changeProperty(property, newValueExpr);
			changeRequest.updateRemoteIp(userContext.getRemoteIP());
			changeRequestType = saveChangeRequestType(userContext, changeRequestType, tokens().withChangeRequestList().done());
			return present(userContext,changeRequestType, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(HfgwUserContext userContext, ChangeRequestType newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


