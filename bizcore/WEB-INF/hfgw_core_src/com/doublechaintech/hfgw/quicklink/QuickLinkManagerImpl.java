
package com.doublechaintech.hfgw.quicklink;

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







public class QuickLinkManagerImpl extends CustomHfgwCheckerManager implements QuickLinkManager {
	
	private static final String SERVICE_TYPE = "QuickLink";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws QuickLinkManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new QuickLinkManagerException(message);

	}
	
	

 	protected QuickLink saveQuickLink(HfgwUserContext userContext, QuickLink quickLink, String [] tokensExpr) throws Exception{	
 		//return getQuickLinkDAO().save(quickLink, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveQuickLink(userContext, quickLink, tokens);
 	}
 	
 	protected QuickLink saveQuickLinkDetail(HfgwUserContext userContext, QuickLink quickLink) throws Exception{	

 		
 		return saveQuickLink(userContext, quickLink, allTokens());
 	}
 	
 	public QuickLink loadQuickLink(HfgwUserContext userContext, String quickLinkId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfQuickLink(quickLinkId);
		checkerOf(userContext).throwExceptionIfHasErrors( QuickLinkManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		QuickLink quickLink = loadQuickLink( userContext, quickLinkId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,quickLink, tokens);
 	}
 	
 	
 	 public QuickLink searchQuickLink(HfgwUserContext userContext, String quickLinkId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfQuickLink(quickLinkId);
		checkerOf(userContext).throwExceptionIfHasErrors( QuickLinkManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		QuickLink quickLink = loadQuickLink( userContext, quickLinkId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,quickLink, tokens);
 	}
 	
 	

 	protected QuickLink present(HfgwUserContext userContext, QuickLink quickLink, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,quickLink,tokens);
		
		
		QuickLink  quickLinkToPresent = quickLinkDaoOf(userContext).present(quickLink, tokens);
		
		List<BaseEntity> entityListToNaming = quickLinkToPresent.collectRefercencesFromLists();
		quickLinkDaoOf(userContext).alias(entityListToNaming);
		
		return  quickLinkToPresent;
		
		
	}
 
 	
 	
 	public QuickLink loadQuickLinkDetail(HfgwUserContext userContext, String quickLinkId) throws Exception{	
 		QuickLink quickLink = loadQuickLink( userContext, quickLinkId, allTokens());
 		return present(userContext,quickLink, allTokens());
		
 	}
 	
 	public Object view(HfgwUserContext userContext, String quickLinkId) throws Exception{	
 		QuickLink quickLink = loadQuickLink( userContext, quickLinkId, viewTokens());
 		return present(userContext,quickLink, allTokens());
		
 	}
 	protected QuickLink saveQuickLink(HfgwUserContext userContext, QuickLink quickLink, Map<String,Object>tokens) throws Exception{	
 		return quickLinkDaoOf(userContext).save(quickLink, tokens);
 	}
 	protected QuickLink loadQuickLink(HfgwUserContext userContext, String quickLinkId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfQuickLink(quickLinkId);
		checkerOf(userContext).throwExceptionIfHasErrors( QuickLinkManagerException.class);

 
 		return quickLinkDaoOf(userContext).load(quickLinkId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, QuickLink quickLink, Map<String, Object> tokens){
		super.addActions(userContext, quickLink, tokens);
		
		addAction(userContext, quickLink, tokens,"@create","createQuickLink","createQuickLink/","main","primary");
		addAction(userContext, quickLink, tokens,"@update","updateQuickLink","updateQuickLink/"+quickLink.getId()+"/","main","primary");
		addAction(userContext, quickLink, tokens,"@copy","cloneQuickLink","cloneQuickLink/"+quickLink.getId()+"/","main","primary");
		
		addAction(userContext, quickLink, tokens,"quick_link.transfer_to_app","transferToAnotherApp","transferToAnotherApp/"+quickLink.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, QuickLink quickLink, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public QuickLink createQuickLink(HfgwUserContext userContext, String name,String icon,String imagePath,String linkTarget,String appId) throws Exception
	//public QuickLink createQuickLink(HfgwUserContext userContext,String name, String icon, String imagePath, String linkTarget, String appId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkNameOfQuickLink(name);
		checkerOf(userContext).checkIconOfQuickLink(icon);
		checkerOf(userContext).checkImagePathOfQuickLink(imagePath);
		checkerOf(userContext).checkLinkTargetOfQuickLink(linkTarget);
	
		checkerOf(userContext).throwExceptionIfHasErrors(QuickLinkManagerException.class);


		QuickLink quickLink=createNewQuickLink();	

		quickLink.setName(name);
		quickLink.setIcon(icon);
		quickLink.setImagePath(imagePath);
		quickLink.setLinkTarget(linkTarget);
		quickLink.setCreateTime(userContext.now());
			
		UserApp app = loadUserApp(userContext, appId,emptyOptions());
		quickLink.setApp(app);
		
		

		quickLink = saveQuickLink(userContext, quickLink, emptyOptions());
		
		onNewInstanceCreated(userContext, quickLink);
		return quickLink;

		
	}
	protected QuickLink createNewQuickLink() 
	{
		
		return new QuickLink();		
	}
	
	protected void checkParamsForUpdatingQuickLink(HfgwUserContext userContext,String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfQuickLink(quickLinkId);
		checkerOf(userContext).checkVersionOfQuickLink( quickLinkVersion);
		

		if(QuickLink.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfQuickLink(parseString(newValueExpr));
		}
		if(QuickLink.ICON_PROPERTY.equals(property)){
			checkerOf(userContext).checkIconOfQuickLink(parseString(newValueExpr));
		}
		if(QuickLink.IMAGE_PATH_PROPERTY.equals(property)){
			checkerOf(userContext).checkImagePathOfQuickLink(parseString(newValueExpr));
		}
		if(QuickLink.LINK_TARGET_PROPERTY.equals(property)){
			checkerOf(userContext).checkLinkTargetOfQuickLink(parseString(newValueExpr));
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(QuickLinkManagerException.class);
	
		
	}
	
	
	
	public QuickLink clone(HfgwUserContext userContext, String fromQuickLinkId) throws Exception{
		
		return quickLinkDaoOf(userContext).clone(fromQuickLinkId, this.allTokens());
	}
	
	public QuickLink internalSaveQuickLink(HfgwUserContext userContext, QuickLink quickLink) throws Exception 
	{
		return internalSaveQuickLink(userContext, quickLink, allTokens());

	}
	public QuickLink internalSaveQuickLink(HfgwUserContext userContext, QuickLink quickLink, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingQuickLink(userContext, quickLinkId, quickLinkVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(quickLink){ 
			//will be good when the quickLink loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to QuickLink.
			if (quickLink.isChanged()){
			
			}
			quickLink = saveQuickLink(userContext, quickLink, options);
			return quickLink;
			
		}

	}
	
	public QuickLink updateQuickLink(HfgwUserContext userContext,String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingQuickLink(userContext, quickLinkId, quickLinkVersion, property, newValueExpr, tokensExpr);
		
		
		
		QuickLink quickLink = loadQuickLink(userContext, quickLinkId, allTokens());
		if(quickLink.getVersion() != quickLinkVersion){
			String message = "The target version("+quickLink.getVersion()+") is not equals to version("+quickLinkVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(quickLink){ 
			//will be good when the quickLink loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to QuickLink.
			
			quickLink.changeProperty(property, newValueExpr);
			quickLink = saveQuickLink(userContext, quickLink, tokens().done());
			return present(userContext,quickLink, mergedAllTokens(tokensExpr));
			//return saveQuickLink(userContext, quickLink, tokens().done());
		}

	}
	
	public QuickLink updateQuickLinkProperty(HfgwUserContext userContext,String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingQuickLink(userContext, quickLinkId, quickLinkVersion, property, newValueExpr, tokensExpr);
		
		QuickLink quickLink = loadQuickLink(userContext, quickLinkId, allTokens());
		if(quickLink.getVersion() != quickLinkVersion){
			String message = "The target version("+quickLink.getVersion()+") is not equals to version("+quickLinkVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(quickLink){ 
			//will be good when the quickLink loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to QuickLink.
			
			quickLink.changeProperty(property, newValueExpr);
			
			quickLink = saveQuickLink(userContext, quickLink, tokens().done());
			return present(userContext,quickLink, mergedAllTokens(tokensExpr));
			//return saveQuickLink(userContext, quickLink, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected QuickLinkTokens tokens(){
		return QuickLinkTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return QuickLinkTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return QuickLinkTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherApp(HfgwUserContext userContext, String quickLinkId, String anotherAppId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfQuickLink(quickLinkId);
 		checkerOf(userContext).checkIdOfUserApp(anotherAppId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(QuickLinkManagerException.class);
 		
 	}
 	public QuickLink transferToAnotherApp(HfgwUserContext userContext, String quickLinkId, String anotherAppId) throws Exception
 	{
 		checkParamsForTransferingAnotherApp(userContext, quickLinkId,anotherAppId);
 
		QuickLink quickLink = loadQuickLink(userContext, quickLinkId, allTokens());	
		synchronized(quickLink){
			//will be good when the quickLink loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			UserApp app = loadUserApp(userContext, anotherAppId, emptyOptions());		
			quickLink.updateApp(app);		
			quickLink = saveQuickLink(userContext, quickLink, emptyOptions());
			
			return present(userContext,quickLink, allTokens());
			
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
		SmartList<UserApp> candidateList = userAppDaoOf(userContext).requestCandidateUserAppForQuickLink(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(HfgwUserContext userContext, String quickLinkId, int quickLinkVersion) throws Exception {
		//deleteInternal(userContext, quickLinkId, quickLinkVersion);		
	}
	protected void deleteInternal(HfgwUserContext userContext,
			String quickLinkId, int quickLinkVersion) throws Exception{
			
		quickLinkDaoOf(userContext).delete(quickLinkId, quickLinkVersion);
	}
	
	public QuickLink forgetByAll(HfgwUserContext userContext, String quickLinkId, int quickLinkVersion) throws Exception {
		return forgetByAllInternal(userContext, quickLinkId, quickLinkVersion);		
	}
	protected QuickLink forgetByAllInternal(HfgwUserContext userContext,
			String quickLinkId, int quickLinkVersion) throws Exception{
			
		return quickLinkDaoOf(userContext).disconnectFromAll(quickLinkId, quickLinkVersion);
	}
	
	

	
	public int deleteAll(HfgwUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new QuickLinkManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HfgwUserContext userContext) throws Exception{
		return quickLinkDaoOf(userContext).deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(HfgwUserContext userContext, QuickLink newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


