
package com.doublechaintech.hfgw.objectaccess;

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

import com.doublechaintech.hfgw.userapp.UserApp;

import com.doublechaintech.hfgw.userapp.CandidateUserApp;







public class ObjectAccessManagerImpl extends CustomHfgwCheckerManager implements ObjectAccessManager {
	
	private static final String SERVICE_TYPE = "ObjectAccess";
	@Override
	public ObjectAccessDAO daoOf(HfgwUserContext userContext) {
		return objectAccessDaoOf(userContext);
	}
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ObjectAccessManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ObjectAccessManagerException(message);

	}
	
	

 	protected ObjectAccess saveObjectAccess(HfgwUserContext userContext, ObjectAccess objectAccess, String [] tokensExpr) throws Exception{	
 		//return getObjectAccessDAO().save(objectAccess, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveObjectAccess(userContext, objectAccess, tokens);
 	}
 	
 	protected ObjectAccess saveObjectAccessDetail(HfgwUserContext userContext, ObjectAccess objectAccess) throws Exception{	

 		
 		return saveObjectAccess(userContext, objectAccess, allTokens());
 	}
 	
 	public ObjectAccess loadObjectAccess(HfgwUserContext userContext, String objectAccessId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfObjectAccess(objectAccessId);
		checkerOf(userContext).throwExceptionIfHasErrors( ObjectAccessManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ObjectAccess objectAccess = loadObjectAccess( userContext, objectAccessId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,objectAccess, tokens);
 	}
 	
 	
 	 public ObjectAccess searchObjectAccess(HfgwUserContext userContext, String objectAccessId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfObjectAccess(objectAccessId);
		checkerOf(userContext).throwExceptionIfHasErrors( ObjectAccessManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ObjectAccess objectAccess = loadObjectAccess( userContext, objectAccessId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,objectAccess, tokens);
 	}
 	
 	

 	protected ObjectAccess present(HfgwUserContext userContext, ObjectAccess objectAccess, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,objectAccess,tokens);
		
		
		ObjectAccess  objectAccessToPresent = objectAccessDaoOf(userContext).present(objectAccess, tokens);
		
		List<BaseEntity> entityListToNaming = objectAccessToPresent.collectRefercencesFromLists();
		objectAccessDaoOf(userContext).alias(entityListToNaming);
		
		return  objectAccessToPresent;
		
		
	}
 
 	
 	
 	public ObjectAccess loadObjectAccessDetail(HfgwUserContext userContext, String objectAccessId) throws Exception{	
 		ObjectAccess objectAccess = loadObjectAccess( userContext, objectAccessId, allTokens());
 		return present(userContext,objectAccess, allTokens());
		
 	}
 	
 	public Object view(HfgwUserContext userContext, String objectAccessId) throws Exception{	
 		ObjectAccess objectAccess = loadObjectAccess( userContext, objectAccessId, viewTokens());
 		return present(userContext,objectAccess, allTokens());
		
 	}
 	protected ObjectAccess saveObjectAccess(HfgwUserContext userContext, ObjectAccess objectAccess, Map<String,Object>tokens) throws Exception{	
 		return objectAccessDaoOf(userContext).save(objectAccess, tokens);
 	}
 	protected ObjectAccess loadObjectAccess(HfgwUserContext userContext, String objectAccessId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfObjectAccess(objectAccessId);
		checkerOf(userContext).throwExceptionIfHasErrors( ObjectAccessManagerException.class);

 
 		return objectAccessDaoOf(userContext).load(objectAccessId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, ObjectAccess objectAccess, Map<String, Object> tokens){
		super.addActions(userContext, objectAccess, tokens);
		
		addAction(userContext, objectAccess, tokens,"@create","createObjectAccess","createObjectAccess/","main","primary");
		addAction(userContext, objectAccess, tokens,"@update","updateObjectAccess","updateObjectAccess/"+objectAccess.getId()+"/","main","primary");
		addAction(userContext, objectAccess, tokens,"@copy","cloneObjectAccess","cloneObjectAccess/"+objectAccess.getId()+"/","main","primary");
		
		addAction(userContext, objectAccess, tokens,"object_access.transfer_to_app","transferToAnotherApp","transferToAnotherApp/"+objectAccess.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, ObjectAccess objectAccess, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public ObjectAccess createObjectAccess(HfgwUserContext userContext, String name,String objectType,String list1,String list2,String list3,String list4,String list5,String list6,String list7,String list8,String list9,String appId) throws Exception
	//public ObjectAccess createObjectAccess(HfgwUserContext userContext,String name, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9, String appId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkNameOfObjectAccess(name);
		checkerOf(userContext).checkObjectTypeOfObjectAccess(objectType);
		checkerOf(userContext).checkList1OfObjectAccess(list1);
		checkerOf(userContext).checkList2OfObjectAccess(list2);
		checkerOf(userContext).checkList3OfObjectAccess(list3);
		checkerOf(userContext).checkList4OfObjectAccess(list4);
		checkerOf(userContext).checkList5OfObjectAccess(list5);
		checkerOf(userContext).checkList6OfObjectAccess(list6);
		checkerOf(userContext).checkList7OfObjectAccess(list7);
		checkerOf(userContext).checkList8OfObjectAccess(list8);
		checkerOf(userContext).checkList9OfObjectAccess(list9);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ObjectAccessManagerException.class);


		ObjectAccess objectAccess=createNewObjectAccess();	

		objectAccess.setName(name);
		objectAccess.setObjectType(objectType);
		objectAccess.setList1(list1);
		objectAccess.setList2(list2);
		objectAccess.setList3(list3);
		objectAccess.setList4(list4);
		objectAccess.setList5(list5);
		objectAccess.setList6(list6);
		objectAccess.setList7(list7);
		objectAccess.setList8(list8);
		objectAccess.setList9(list9);
			
		UserApp app = loadUserApp(userContext, appId,emptyOptions());
		objectAccess.setApp(app);
		
		

		objectAccess = saveObjectAccess(userContext, objectAccess, emptyOptions());
		
		onNewInstanceCreated(userContext, objectAccess);
		return objectAccess;

		
	}
	protected ObjectAccess createNewObjectAccess() 
	{
		
		return new ObjectAccess();		
	}
	
	protected void checkParamsForUpdatingObjectAccess(HfgwUserContext userContext,String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfObjectAccess(objectAccessId);
		checkerOf(userContext).checkVersionOfObjectAccess( objectAccessVersion);
		

		if(ObjectAccess.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfObjectAccess(parseString(newValueExpr));
		}
		if(ObjectAccess.OBJECT_TYPE_PROPERTY.equals(property)){
			checkerOf(userContext).checkObjectTypeOfObjectAccess(parseString(newValueExpr));
		}
		if(ObjectAccess.LIST1_PROPERTY.equals(property)){
			checkerOf(userContext).checkList1OfObjectAccess(parseString(newValueExpr));
		}
		if(ObjectAccess.LIST2_PROPERTY.equals(property)){
			checkerOf(userContext).checkList2OfObjectAccess(parseString(newValueExpr));
		}
		if(ObjectAccess.LIST3_PROPERTY.equals(property)){
			checkerOf(userContext).checkList3OfObjectAccess(parseString(newValueExpr));
		}
		if(ObjectAccess.LIST4_PROPERTY.equals(property)){
			checkerOf(userContext).checkList4OfObjectAccess(parseString(newValueExpr));
		}
		if(ObjectAccess.LIST5_PROPERTY.equals(property)){
			checkerOf(userContext).checkList5OfObjectAccess(parseString(newValueExpr));
		}
		if(ObjectAccess.LIST6_PROPERTY.equals(property)){
			checkerOf(userContext).checkList6OfObjectAccess(parseString(newValueExpr));
		}
		if(ObjectAccess.LIST7_PROPERTY.equals(property)){
			checkerOf(userContext).checkList7OfObjectAccess(parseString(newValueExpr));
		}
		if(ObjectAccess.LIST8_PROPERTY.equals(property)){
			checkerOf(userContext).checkList8OfObjectAccess(parseString(newValueExpr));
		}
		if(ObjectAccess.LIST9_PROPERTY.equals(property)){
			checkerOf(userContext).checkList9OfObjectAccess(parseString(newValueExpr));
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ObjectAccessManagerException.class);
	
		
	}
	
	
	
	public ObjectAccess clone(HfgwUserContext userContext, String fromObjectAccessId) throws Exception{
		
		return objectAccessDaoOf(userContext).clone(fromObjectAccessId, this.allTokens());
	}
	
	public ObjectAccess internalSaveObjectAccess(HfgwUserContext userContext, ObjectAccess objectAccess) throws Exception 
	{
		return internalSaveObjectAccess(userContext, objectAccess, allTokens());

	}
	public ObjectAccess internalSaveObjectAccess(HfgwUserContext userContext, ObjectAccess objectAccess, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingObjectAccess(userContext, objectAccessId, objectAccessVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(objectAccess){ 
			//will be good when the objectAccess loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ObjectAccess.
			if (objectAccess.isChanged()){
			
			}
			objectAccess = saveObjectAccess(userContext, objectAccess, options);
			return objectAccess;
			
		}

	}
	
	public ObjectAccess updateObjectAccess(HfgwUserContext userContext,String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingObjectAccess(userContext, objectAccessId, objectAccessVersion, property, newValueExpr, tokensExpr);
		
		
		
		ObjectAccess objectAccess = loadObjectAccess(userContext, objectAccessId, allTokens());
		if(objectAccess.getVersion() != objectAccessVersion){
			String message = "The target version("+objectAccess.getVersion()+") is not equals to version("+objectAccessVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(objectAccess){ 
			//will be good when the objectAccess loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ObjectAccess.
			
			objectAccess.changeProperty(property, newValueExpr);
			objectAccess = saveObjectAccess(userContext, objectAccess, tokens().done());
			return present(userContext,objectAccess, mergedAllTokens(tokensExpr));
			//return saveObjectAccess(userContext, objectAccess, tokens().done());
		}

	}
	
	public ObjectAccess updateObjectAccessProperty(HfgwUserContext userContext,String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingObjectAccess(userContext, objectAccessId, objectAccessVersion, property, newValueExpr, tokensExpr);
		
		ObjectAccess objectAccess = loadObjectAccess(userContext, objectAccessId, allTokens());
		if(objectAccess.getVersion() != objectAccessVersion){
			String message = "The target version("+objectAccess.getVersion()+") is not equals to version("+objectAccessVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(objectAccess){ 
			//will be good when the objectAccess loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ObjectAccess.
			
			objectAccess.changeProperty(property, newValueExpr);
			
			objectAccess = saveObjectAccess(userContext, objectAccess, tokens().done());
			return present(userContext,objectAccess, mergedAllTokens(tokensExpr));
			//return saveObjectAccess(userContext, objectAccess, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ObjectAccessTokens tokens(){
		return ObjectAccessTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ObjectAccessTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ObjectAccessTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherApp(HfgwUserContext userContext, String objectAccessId, String anotherAppId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfObjectAccess(objectAccessId);
 		checkerOf(userContext).checkIdOfUserApp(anotherAppId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ObjectAccessManagerException.class);
 		
 	}
 	public ObjectAccess transferToAnotherApp(HfgwUserContext userContext, String objectAccessId, String anotherAppId) throws Exception
 	{
 		checkParamsForTransferingAnotherApp(userContext, objectAccessId,anotherAppId);
 
		ObjectAccess objectAccess = loadObjectAccess(userContext, objectAccessId, allTokens());	
		synchronized(objectAccess){
			//will be good when the objectAccess loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			UserApp app = loadUserApp(userContext, anotherAppId, emptyOptions());		
			objectAccess.updateApp(app);		
			objectAccess = saveObjectAccess(userContext, objectAccess, emptyOptions());
			
			return present(userContext,objectAccess, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateUserApp requestCandidateApp(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateUserApp result = new CandidateUserApp();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("title");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<UserApp> candidateList = userAppDaoOf(userContext).requestCandidateUserAppForObjectAccess(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected UserApp loadUserApp(HfgwUserContext userContext, String newAppId, Map<String,Object> options) throws Exception
 	{
		
 		return userAppDaoOf(userContext).load(newAppId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(HfgwUserContext userContext, String objectAccessId, int objectAccessVersion) throws Exception {
		//deleteInternal(userContext, objectAccessId, objectAccessVersion);		
	}
	protected void deleteInternal(HfgwUserContext userContext,
			String objectAccessId, int objectAccessVersion) throws Exception{
			
		objectAccessDaoOf(userContext).delete(objectAccessId, objectAccessVersion);
	}
	
	public ObjectAccess forgetByAll(HfgwUserContext userContext, String objectAccessId, int objectAccessVersion) throws Exception {
		return forgetByAllInternal(userContext, objectAccessId, objectAccessVersion);		
	}
	protected ObjectAccess forgetByAllInternal(HfgwUserContext userContext,
			String objectAccessId, int objectAccessVersion) throws Exception{
			
		return objectAccessDaoOf(userContext).disconnectFromAll(objectAccessId, objectAccessVersion);
	}
	
	

	
	public int deleteAll(HfgwUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ObjectAccessManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HfgwUserContext userContext) throws Exception{
		return objectAccessDaoOf(userContext).deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(HfgwUserContext userContext, ObjectAccess newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


