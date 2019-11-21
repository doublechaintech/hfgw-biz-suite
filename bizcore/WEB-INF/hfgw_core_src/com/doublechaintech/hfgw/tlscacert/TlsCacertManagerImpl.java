
package com.doublechaintech.hfgw.tlscacert;

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







public class TlsCacertManagerImpl extends CustomHfgwCheckerManager implements TlsCacertManager {
	
	private static final String SERVICE_TYPE = "TlsCacert";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws TlsCacertManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new TlsCacertManagerException(message);

	}
	
	

 	protected TlsCacert saveTlsCacert(HfgwUserContext userContext, TlsCacert tlsCacert, String [] tokensExpr) throws Exception{	
 		//return getTlsCacertDAO().save(tlsCacert, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTlsCacert(userContext, tlsCacert, tokens);
 	}
 	
 	protected TlsCacert saveTlsCacertDetail(HfgwUserContext userContext, TlsCacert tlsCacert) throws Exception{	

 		
 		return saveTlsCacert(userContext, tlsCacert, allTokens());
 	}
 	
 	public TlsCacert loadTlsCacert(HfgwUserContext userContext, String tlsCacertId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfTlsCacert(tlsCacertId);
		checkerOf(userContext).throwExceptionIfHasErrors( TlsCacertManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TlsCacert tlsCacert = loadTlsCacert( userContext, tlsCacertId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,tlsCacert, tokens);
 	}
 	
 	
 	 public TlsCacert searchTlsCacert(HfgwUserContext userContext, String tlsCacertId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfTlsCacert(tlsCacertId);
		checkerOf(userContext).throwExceptionIfHasErrors( TlsCacertManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		TlsCacert tlsCacert = loadTlsCacert( userContext, tlsCacertId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,tlsCacert, tokens);
 	}
 	
 	

 	protected TlsCacert present(HfgwUserContext userContext, TlsCacert tlsCacert, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,tlsCacert,tokens);
		
		
		TlsCacert  tlsCacertToPresent = tlsCacertDaoOf(userContext).present(tlsCacert, tokens);
		
		List<BaseEntity> entityListToNaming = tlsCacertToPresent.collectRefercencesFromLists();
		tlsCacertDaoOf(userContext).alias(entityListToNaming);
		
		return  tlsCacertToPresent;
		
		
	}
 
 	
 	
 	public TlsCacert loadTlsCacertDetail(HfgwUserContext userContext, String tlsCacertId) throws Exception{	
 		TlsCacert tlsCacert = loadTlsCacert( userContext, tlsCacertId, allTokens());
 		return present(userContext,tlsCacert, allTokens());
		
 	}
 	
 	public Object view(HfgwUserContext userContext, String tlsCacertId) throws Exception{	
 		TlsCacert tlsCacert = loadTlsCacert( userContext, tlsCacertId, viewTokens());
 		return present(userContext,tlsCacert, allTokens());
		
 	}
 	protected TlsCacert saveTlsCacert(HfgwUserContext userContext, TlsCacert tlsCacert, Map<String,Object>tokens) throws Exception{	
 		return tlsCacertDaoOf(userContext).save(tlsCacert, tokens);
 	}
 	protected TlsCacert loadTlsCacert(HfgwUserContext userContext, String tlsCacertId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfTlsCacert(tlsCacertId);
		checkerOf(userContext).throwExceptionIfHasErrors( TlsCacertManagerException.class);

 
 		return tlsCacertDaoOf(userContext).load(tlsCacertId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, TlsCacert tlsCacert, Map<String, Object> tokens){
		super.addActions(userContext, tlsCacert, tokens);
		
		addAction(userContext, tlsCacert, tokens,"@create","createTlsCacert","createTlsCacert/","main","primary");
		addAction(userContext, tlsCacert, tokens,"@update","updateTlsCacert","updateTlsCacert/"+tlsCacert.getId()+"/","main","primary");
		addAction(userContext, tlsCacert, tokens,"@copy","cloneTlsCacert","cloneTlsCacert/"+tlsCacert.getId()+"/","main","primary");
		
		addAction(userContext, tlsCacert, tokens,"tls_cacert.transfer_to_node","transferToAnotherNode","transferToAnotherNode/"+tlsCacert.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, TlsCacert tlsCacert, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public TlsCacert createTlsCacert(HfgwUserContext userContext, String path,String cert,String nodeId) throws Exception
	//public TlsCacert createTlsCacert(HfgwUserContext userContext,String path, String cert, String nodeId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkPathOfTlsCacert(path);
		checkerOf(userContext).checkCertOfTlsCacert(cert);
	
		checkerOf(userContext).throwExceptionIfHasErrors(TlsCacertManagerException.class);


		TlsCacert tlsCacert=createNewTlsCacert();	

		tlsCacert.setPath(path);
		tlsCacert.setCert(cert);
			
		Node node = loadNode(userContext, nodeId,emptyOptions());
		tlsCacert.setNode(node);
		
		

		tlsCacert = saveTlsCacert(userContext, tlsCacert, emptyOptions());
		
		onNewInstanceCreated(userContext, tlsCacert);
		return tlsCacert;

		
	}
	protected TlsCacert createNewTlsCacert() 
	{
		
		return new TlsCacert();		
	}
	
	protected void checkParamsForUpdatingTlsCacert(HfgwUserContext userContext,String tlsCacertId, int tlsCacertVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfTlsCacert(tlsCacertId);
		checkerOf(userContext).checkVersionOfTlsCacert( tlsCacertVersion);
		

		if(TlsCacert.PATH_PROPERTY.equals(property)){
			checkerOf(userContext).checkPathOfTlsCacert(parseString(newValueExpr));
		}
		if(TlsCacert.CERT_PROPERTY.equals(property)){
			checkerOf(userContext).checkCertOfTlsCacert(parseString(newValueExpr));
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(TlsCacertManagerException.class);
	
		
	}
	
	
	
	public TlsCacert clone(HfgwUserContext userContext, String fromTlsCacertId) throws Exception{
		
		return tlsCacertDaoOf(userContext).clone(fromTlsCacertId, this.allTokens());
	}
	
	public TlsCacert internalSaveTlsCacert(HfgwUserContext userContext, TlsCacert tlsCacert) throws Exception 
	{
		return internalSaveTlsCacert(userContext, tlsCacert, allTokens());

	}
	public TlsCacert internalSaveTlsCacert(HfgwUserContext userContext, TlsCacert tlsCacert, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingTlsCacert(userContext, tlsCacertId, tlsCacertVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(tlsCacert){ 
			//will be good when the tlsCacert loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TlsCacert.
			if (tlsCacert.isChanged()){
			
			}
			tlsCacert = saveTlsCacert(userContext, tlsCacert, options);
			return tlsCacert;
			
		}

	}
	
	public TlsCacert updateTlsCacert(HfgwUserContext userContext,String tlsCacertId, int tlsCacertVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTlsCacert(userContext, tlsCacertId, tlsCacertVersion, property, newValueExpr, tokensExpr);
		
		
		
		TlsCacert tlsCacert = loadTlsCacert(userContext, tlsCacertId, allTokens());
		if(tlsCacert.getVersion() != tlsCacertVersion){
			String message = "The target version("+tlsCacert.getVersion()+") is not equals to version("+tlsCacertVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(tlsCacert){ 
			//will be good when the tlsCacert loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TlsCacert.
			
			tlsCacert.changeProperty(property, newValueExpr);
			tlsCacert = saveTlsCacert(userContext, tlsCacert, tokens().done());
			return present(userContext,tlsCacert, mergedAllTokens(tokensExpr));
			//return saveTlsCacert(userContext, tlsCacert, tokens().done());
		}

	}
	
	public TlsCacert updateTlsCacertProperty(HfgwUserContext userContext,String tlsCacertId, int tlsCacertVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTlsCacert(userContext, tlsCacertId, tlsCacertVersion, property, newValueExpr, tokensExpr);
		
		TlsCacert tlsCacert = loadTlsCacert(userContext, tlsCacertId, allTokens());
		if(tlsCacert.getVersion() != tlsCacertVersion){
			String message = "The target version("+tlsCacert.getVersion()+") is not equals to version("+tlsCacertVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(tlsCacert){ 
			//will be good when the tlsCacert loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TlsCacert.
			
			tlsCacert.changeProperty(property, newValueExpr);
			
			tlsCacert = saveTlsCacert(userContext, tlsCacert, tokens().done());
			return present(userContext,tlsCacert, mergedAllTokens(tokensExpr));
			//return saveTlsCacert(userContext, tlsCacert, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TlsCacertTokens tokens(){
		return TlsCacertTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TlsCacertTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TlsCacertTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherNode(HfgwUserContext userContext, String tlsCacertId, String anotherNodeId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfTlsCacert(tlsCacertId);
 		checkerOf(userContext).checkIdOfNode(anotherNodeId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(TlsCacertManagerException.class);
 		
 	}
 	public TlsCacert transferToAnotherNode(HfgwUserContext userContext, String tlsCacertId, String anotherNodeId) throws Exception
 	{
 		checkParamsForTransferingAnotherNode(userContext, tlsCacertId,anotherNodeId);
 
		TlsCacert tlsCacert = loadTlsCacert(userContext, tlsCacertId, allTokens());	
		synchronized(tlsCacert){
			//will be good when the tlsCacert loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Node node = loadNode(userContext, anotherNodeId, emptyOptions());		
			tlsCacert.updateNode(node);		
			tlsCacert = saveTlsCacert(userContext, tlsCacert, emptyOptions());
			
			return present(userContext,tlsCacert, allTokens());
			
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
		SmartList<Node> candidateList = nodeDaoOf(userContext).requestCandidateNodeForTlsCacert(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(HfgwUserContext userContext, String tlsCacertId, int tlsCacertVersion) throws Exception {
		//deleteInternal(userContext, tlsCacertId, tlsCacertVersion);		
	}
	protected void deleteInternal(HfgwUserContext userContext,
			String tlsCacertId, int tlsCacertVersion) throws Exception{
			
		tlsCacertDaoOf(userContext).delete(tlsCacertId, tlsCacertVersion);
	}
	
	public TlsCacert forgetByAll(HfgwUserContext userContext, String tlsCacertId, int tlsCacertVersion) throws Exception {
		return forgetByAllInternal(userContext, tlsCacertId, tlsCacertVersion);		
	}
	protected TlsCacert forgetByAllInternal(HfgwUserContext userContext,
			String tlsCacertId, int tlsCacertVersion) throws Exception{
			
		return tlsCacertDaoOf(userContext).disconnectFromAll(tlsCacertId, tlsCacertVersion);
	}
	
	

	
	public int deleteAll(HfgwUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TlsCacertManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HfgwUserContext userContext) throws Exception{
		return tlsCacertDaoOf(userContext).deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(HfgwUserContext userContext, TlsCacert newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


