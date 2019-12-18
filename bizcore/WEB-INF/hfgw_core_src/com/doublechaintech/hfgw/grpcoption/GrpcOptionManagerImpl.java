
package com.doublechaintech.hfgw.grpcoption;

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

import com.doublechaintech.hfgw.node.Node;

import com.doublechaintech.hfgw.node.CandidateNode;







public class GrpcOptionManagerImpl extends CustomHfgwCheckerManager implements GrpcOptionManager {
	
	private static final String SERVICE_TYPE = "GrpcOption";
	@Override
	public GrpcOptionDAO daoOf(HfgwUserContext userContext) {
		return grpcOptionDaoOf(userContext);
	}
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws GrpcOptionManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new GrpcOptionManagerException(message);

	}
	
	

 	protected GrpcOption saveGrpcOption(HfgwUserContext userContext, GrpcOption grpcOption, String [] tokensExpr) throws Exception{	
 		//return getGrpcOptionDAO().save(grpcOption, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveGrpcOption(userContext, grpcOption, tokens);
 	}
 	
 	protected GrpcOption saveGrpcOptionDetail(HfgwUserContext userContext, GrpcOption grpcOption) throws Exception{	

 		
 		return saveGrpcOption(userContext, grpcOption, allTokens());
 	}
 	
 	public GrpcOption loadGrpcOption(HfgwUserContext userContext, String grpcOptionId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfGrpcOption(grpcOptionId);
		checkerOf(userContext).throwExceptionIfHasErrors( GrpcOptionManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		GrpcOption grpcOption = loadGrpcOption( userContext, grpcOptionId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,grpcOption, tokens);
 	}
 	
 	
 	 public GrpcOption searchGrpcOption(HfgwUserContext userContext, String grpcOptionId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfGrpcOption(grpcOptionId);
		checkerOf(userContext).throwExceptionIfHasErrors( GrpcOptionManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		GrpcOption grpcOption = loadGrpcOption( userContext, grpcOptionId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,grpcOption, tokens);
 	}
 	
 	

 	protected GrpcOption present(HfgwUserContext userContext, GrpcOption grpcOption, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,grpcOption,tokens);
		
		
		GrpcOption  grpcOptionToPresent = grpcOptionDaoOf(userContext).present(grpcOption, tokens);
		
		List<BaseEntity> entityListToNaming = grpcOptionToPresent.collectRefercencesFromLists();
		grpcOptionDaoOf(userContext).alias(entityListToNaming);
		
		return  grpcOptionToPresent;
		
		
	}
 
 	
 	
 	public GrpcOption loadGrpcOptionDetail(HfgwUserContext userContext, String grpcOptionId) throws Exception{	
 		GrpcOption grpcOption = loadGrpcOption( userContext, grpcOptionId, allTokens());
 		return present(userContext,grpcOption, allTokens());
		
 	}
 	
 	public Object view(HfgwUserContext userContext, String grpcOptionId) throws Exception{	
 		GrpcOption grpcOption = loadGrpcOption( userContext, grpcOptionId, viewTokens());
 		return present(userContext,grpcOption, allTokens());
		
 	}
 	protected GrpcOption saveGrpcOption(HfgwUserContext userContext, GrpcOption grpcOption, Map<String,Object>tokens) throws Exception{	
 		return grpcOptionDaoOf(userContext).save(grpcOption, tokens);
 	}
 	protected GrpcOption loadGrpcOption(HfgwUserContext userContext, String grpcOptionId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfGrpcOption(grpcOptionId);
		checkerOf(userContext).throwExceptionIfHasErrors( GrpcOptionManagerException.class);

 
 		return grpcOptionDaoOf(userContext).load(grpcOptionId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, GrpcOption grpcOption, Map<String, Object> tokens){
		super.addActions(userContext, grpcOption, tokens);
		
		addAction(userContext, grpcOption, tokens,"@create","createGrpcOption","createGrpcOption/","main","primary");
		addAction(userContext, grpcOption, tokens,"@update","updateGrpcOption","updateGrpcOption/"+grpcOption.getId()+"/","main","primary");
		addAction(userContext, grpcOption, tokens,"@copy","cloneGrpcOption","cloneGrpcOption/"+grpcOption.getId()+"/","main","primary");
		
		addAction(userContext, grpcOption, tokens,"grpc_option.transfer_to_node","transferToAnotherNode","transferToAnotherNode/"+grpcOption.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, GrpcOption grpcOption, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public GrpcOption createGrpcOption(HfgwUserContext userContext, String parameterName,String parameterValue,String nodeId) throws Exception
	//public GrpcOption createGrpcOption(HfgwUserContext userContext,String parameterName, String parameterValue, String nodeId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkParameterNameOfGrpcOption(parameterName);
		checkerOf(userContext).checkParameterValueOfGrpcOption(parameterValue);
	
		checkerOf(userContext).throwExceptionIfHasErrors(GrpcOptionManagerException.class);


		GrpcOption grpcOption=createNewGrpcOption();	

		grpcOption.setParameterName(parameterName);
		grpcOption.setParameterValue(parameterValue);
			
		Node node = loadNode(userContext, nodeId,emptyOptions());
		grpcOption.setNode(node);
		
		

		grpcOption = saveGrpcOption(userContext, grpcOption, emptyOptions());
		
		onNewInstanceCreated(userContext, grpcOption);
		return grpcOption;

		
	}
	protected GrpcOption createNewGrpcOption() 
	{
		
		return new GrpcOption();		
	}
	
	protected void checkParamsForUpdatingGrpcOption(HfgwUserContext userContext,String grpcOptionId, int grpcOptionVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfGrpcOption(grpcOptionId);
		checkerOf(userContext).checkVersionOfGrpcOption( grpcOptionVersion);
		

		if(GrpcOption.PARAMETER_NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkParameterNameOfGrpcOption(parseString(newValueExpr));
		}
		if(GrpcOption.PARAMETER_VALUE_PROPERTY.equals(property)){
			checkerOf(userContext).checkParameterValueOfGrpcOption(parseString(newValueExpr));
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(GrpcOptionManagerException.class);
	
		
	}
	
	
	
	public GrpcOption clone(HfgwUserContext userContext, String fromGrpcOptionId) throws Exception{
		
		return grpcOptionDaoOf(userContext).clone(fromGrpcOptionId, this.allTokens());
	}
	
	public GrpcOption internalSaveGrpcOption(HfgwUserContext userContext, GrpcOption grpcOption) throws Exception 
	{
		return internalSaveGrpcOption(userContext, grpcOption, allTokens());

	}
	public GrpcOption internalSaveGrpcOption(HfgwUserContext userContext, GrpcOption grpcOption, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingGrpcOption(userContext, grpcOptionId, grpcOptionVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(grpcOption){ 
			//will be good when the grpcOption loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GrpcOption.
			if (grpcOption.isChanged()){
			
			}
			grpcOption = saveGrpcOption(userContext, grpcOption, options);
			return grpcOption;
			
		}

	}
	
	public GrpcOption updateGrpcOption(HfgwUserContext userContext,String grpcOptionId, int grpcOptionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingGrpcOption(userContext, grpcOptionId, grpcOptionVersion, property, newValueExpr, tokensExpr);
		
		
		
		GrpcOption grpcOption = loadGrpcOption(userContext, grpcOptionId, allTokens());
		if(grpcOption.getVersion() != grpcOptionVersion){
			String message = "The target version("+grpcOption.getVersion()+") is not equals to version("+grpcOptionVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(grpcOption){ 
			//will be good when the grpcOption loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GrpcOption.
			
			grpcOption.changeProperty(property, newValueExpr);
			grpcOption = saveGrpcOption(userContext, grpcOption, tokens().done());
			return present(userContext,grpcOption, mergedAllTokens(tokensExpr));
			//return saveGrpcOption(userContext, grpcOption, tokens().done());
		}

	}
	
	public GrpcOption updateGrpcOptionProperty(HfgwUserContext userContext,String grpcOptionId, int grpcOptionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingGrpcOption(userContext, grpcOptionId, grpcOptionVersion, property, newValueExpr, tokensExpr);
		
		GrpcOption grpcOption = loadGrpcOption(userContext, grpcOptionId, allTokens());
		if(grpcOption.getVersion() != grpcOptionVersion){
			String message = "The target version("+grpcOption.getVersion()+") is not equals to version("+grpcOptionVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(grpcOption){ 
			//will be good when the grpcOption loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GrpcOption.
			
			grpcOption.changeProperty(property, newValueExpr);
			
			grpcOption = saveGrpcOption(userContext, grpcOption, tokens().done());
			return present(userContext,grpcOption, mergedAllTokens(tokensExpr));
			//return saveGrpcOption(userContext, grpcOption, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected GrpcOptionTokens tokens(){
		return GrpcOptionTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return GrpcOptionTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return GrpcOptionTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherNode(HfgwUserContext userContext, String grpcOptionId, String anotherNodeId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfGrpcOption(grpcOptionId);
 		checkerOf(userContext).checkIdOfNode(anotherNodeId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(GrpcOptionManagerException.class);
 		
 	}
 	public GrpcOption transferToAnotherNode(HfgwUserContext userContext, String grpcOptionId, String anotherNodeId) throws Exception
 	{
 		checkParamsForTransferingAnotherNode(userContext, grpcOptionId,anotherNodeId);
 
		GrpcOption grpcOption = loadGrpcOption(userContext, grpcOptionId, allTokens());	
		synchronized(grpcOption){
			//will be good when the grpcOption loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Node node = loadNode(userContext, anotherNodeId, emptyOptions());		
			grpcOption.updateNode(node);		
			grpcOption = saveGrpcOption(userContext, grpcOption, emptyOptions());
			
			return present(userContext,grpcOption, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateNode requestCandidateNode(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateNode result = new CandidateNode();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Node> candidateList = nodeDaoOf(userContext).requestCandidateNodeForGrpcOption(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Node loadNode(HfgwUserContext userContext, String newNodeId, Map<String,Object> options) throws Exception
 	{
		
 		return nodeDaoOf(userContext).load(newNodeId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(HfgwUserContext userContext, String grpcOptionId, int grpcOptionVersion) throws Exception {
		//deleteInternal(userContext, grpcOptionId, grpcOptionVersion);		
	}
	protected void deleteInternal(HfgwUserContext userContext,
			String grpcOptionId, int grpcOptionVersion) throws Exception{
			
		grpcOptionDaoOf(userContext).delete(grpcOptionId, grpcOptionVersion);
	}
	
	public GrpcOption forgetByAll(HfgwUserContext userContext, String grpcOptionId, int grpcOptionVersion) throws Exception {
		return forgetByAllInternal(userContext, grpcOptionId, grpcOptionVersion);		
	}
	protected GrpcOption forgetByAllInternal(HfgwUserContext userContext,
			String grpcOptionId, int grpcOptionVersion) throws Exception{
			
		return grpcOptionDaoOf(userContext).disconnectFromAll(grpcOptionId, grpcOptionVersion);
	}
	
	

	
	public int deleteAll(HfgwUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new GrpcOptionManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HfgwUserContext userContext) throws Exception{
		return grpcOptionDaoOf(userContext).deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(HfgwUserContext userContext, GrpcOption newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


