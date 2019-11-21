
package com.doublechaintech.hfgw.node;

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

import com.doublechaintech.hfgw.organization.Organization;
import com.doublechaintech.hfgw.tlscacert.TlsCacert;
import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.nodetype.NodeType;
import com.doublechaintech.hfgw.grpcoption.GrpcOption;

import com.doublechaintech.hfgw.organization.CandidateOrganization;
import com.doublechaintech.hfgw.channel.CandidateChannel;
import com.doublechaintech.hfgw.nodetype.CandidateNodeType;

import com.doublechaintech.hfgw.node.Node;






public class NodeManagerImpl extends CustomHfgwCheckerManager implements NodeManager {
	
	private static final String SERVICE_TYPE = "Node";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws NodeManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new NodeManagerException(message);

	}
	
	

 	protected Node saveNode(HfgwUserContext userContext, Node node, String [] tokensExpr) throws Exception{	
 		//return getNodeDAO().save(node, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveNode(userContext, node, tokens);
 	}
 	
 	protected Node saveNodeDetail(HfgwUserContext userContext, Node node) throws Exception{	

 		
 		return saveNode(userContext, node, allTokens());
 	}
 	
 	public Node loadNode(HfgwUserContext userContext, String nodeId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfNode(nodeId);
		checkerOf(userContext).throwExceptionIfHasErrors( NodeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Node node = loadNode( userContext, nodeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,node, tokens);
 	}
 	
 	
 	 public Node searchNode(HfgwUserContext userContext, String nodeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfNode(nodeId);
		checkerOf(userContext).throwExceptionIfHasErrors( NodeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Node node = loadNode( userContext, nodeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,node, tokens);
 	}
 	
 	

 	protected Node present(HfgwUserContext userContext, Node node, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,node,tokens);
		
		
		Node  nodeToPresent = nodeDaoOf(userContext).present(node, tokens);
		
		List<BaseEntity> entityListToNaming = nodeToPresent.collectRefercencesFromLists();
		nodeDaoOf(userContext).alias(entityListToNaming);
		
		return  nodeToPresent;
		
		
	}
 
 	
 	
 	public Node loadNodeDetail(HfgwUserContext userContext, String nodeId) throws Exception{	
 		Node node = loadNode( userContext, nodeId, allTokens());
 		return present(userContext,node, allTokens());
		
 	}
 	
 	public Object view(HfgwUserContext userContext, String nodeId) throws Exception{	
 		Node node = loadNode( userContext, nodeId, viewTokens());
 		return present(userContext,node, allTokens());
		
 	}
 	protected Node saveNode(HfgwUserContext userContext, Node node, Map<String,Object>tokens) throws Exception{	
 		return nodeDaoOf(userContext).save(node, tokens);
 	}
 	protected Node loadNode(HfgwUserContext userContext, String nodeId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfNode(nodeId);
		checkerOf(userContext).throwExceptionIfHasErrors( NodeManagerException.class);

 
 		return nodeDaoOf(userContext).load(nodeId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, Node node, Map<String, Object> tokens){
		super.addActions(userContext, node, tokens);
		
		addAction(userContext, node, tokens,"@create","createNode","createNode/","main","primary");
		addAction(userContext, node, tokens,"@update","updateNode","updateNode/"+node.getId()+"/","main","primary");
		addAction(userContext, node, tokens,"@copy","cloneNode","cloneNode/"+node.getId()+"/","main","primary");
		
		addAction(userContext, node, tokens,"node.transfer_to_organization","transferToAnotherOrganization","transferToAnotherOrganization/"+node.getId()+"/","main","primary");
		addAction(userContext, node, tokens,"node.transfer_to_channel","transferToAnotherChannel","transferToAnotherChannel/"+node.getId()+"/","main","primary");
		addAction(userContext, node, tokens,"node.transfer_to_type","transferToAnotherType","transferToAnotherType/"+node.getId()+"/","main","primary");
		addAction(userContext, node, tokens,"node.addGrpcOption","addGrpcOption","addGrpcOption/"+node.getId()+"/","grpcOptionList","primary");
		addAction(userContext, node, tokens,"node.removeGrpcOption","removeGrpcOption","removeGrpcOption/"+node.getId()+"/","grpcOptionList","primary");
		addAction(userContext, node, tokens,"node.updateGrpcOption","updateGrpcOption","updateGrpcOption/"+node.getId()+"/","grpcOptionList","primary");
		addAction(userContext, node, tokens,"node.copyGrpcOptionFrom","copyGrpcOptionFrom","copyGrpcOptionFrom/"+node.getId()+"/","grpcOptionList","primary");
		addAction(userContext, node, tokens,"node.addTlsCacert","addTlsCacert","addTlsCacert/"+node.getId()+"/","tlsCacertList","primary");
		addAction(userContext, node, tokens,"node.removeTlsCacert","removeTlsCacert","removeTlsCacert/"+node.getId()+"/","tlsCacertList","primary");
		addAction(userContext, node, tokens,"node.updateTlsCacert","updateTlsCacert","updateTlsCacert/"+node.getId()+"/","tlsCacertList","primary");
		addAction(userContext, node, tokens,"node.copyTlsCacertFrom","copyTlsCacertFrom","copyTlsCacertFrom/"+node.getId()+"/","tlsCacertList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, Node node, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public Node createNode(HfgwUserContext userContext, String name,String url,String organizationId,String channelId,String typeId) throws Exception
	//public Node createNode(HfgwUserContext userContext,String name, String url, String organizationId, String channelId, String typeId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkNameOfNode(name);
		checkerOf(userContext).checkUrlOfNode(url);
	
		checkerOf(userContext).throwExceptionIfHasErrors(NodeManagerException.class);


		Node node=createNewNode();	

		node.setName(name);
		node.setUrl(url);
			
		Organization organization = loadOrganization(userContext, organizationId,emptyOptions());
		node.setOrganization(organization);
		
		
			
		Channel channel = loadChannel(userContext, channelId,emptyOptions());
		node.setChannel(channel);
		
		
			
		NodeType type = loadNodeType(userContext, typeId,emptyOptions());
		node.setType(type);
		
		

		node = saveNode(userContext, node, emptyOptions());
		
		onNewInstanceCreated(userContext, node);
		return node;

		
	}
	protected Node createNewNode() 
	{
		
		return new Node();		
	}
	
	protected void checkParamsForUpdatingNode(HfgwUserContext userContext,String nodeId, int nodeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfNode(nodeId);
		checkerOf(userContext).checkVersionOfNode( nodeVersion);
		

		if(Node.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfNode(parseString(newValueExpr));
		}
		if(Node.URL_PROPERTY.equals(property)){
			checkerOf(userContext).checkUrlOfNode(parseString(newValueExpr));
		}		

				

				

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(NodeManagerException.class);
	
		
	}
	
	
	
	public Node clone(HfgwUserContext userContext, String fromNodeId) throws Exception{
		
		return nodeDaoOf(userContext).clone(fromNodeId, this.allTokens());
	}
	
	public Node internalSaveNode(HfgwUserContext userContext, Node node) throws Exception 
	{
		return internalSaveNode(userContext, node, allTokens());

	}
	public Node internalSaveNode(HfgwUserContext userContext, Node node, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingNode(userContext, nodeId, nodeVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(node){ 
			//will be good when the node loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Node.
			if (node.isChanged()){
			
			}
			node = saveNode(userContext, node, options);
			return node;
			
		}

	}
	
	public Node updateNode(HfgwUserContext userContext,String nodeId, int nodeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingNode(userContext, nodeId, nodeVersion, property, newValueExpr, tokensExpr);
		
		
		
		Node node = loadNode(userContext, nodeId, allTokens());
		if(node.getVersion() != nodeVersion){
			String message = "The target version("+node.getVersion()+") is not equals to version("+nodeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(node){ 
			//will be good when the node loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Node.
			
			node.changeProperty(property, newValueExpr);
			node = saveNode(userContext, node, tokens().done());
			return present(userContext,node, mergedAllTokens(tokensExpr));
			//return saveNode(userContext, node, tokens().done());
		}

	}
	
	public Node updateNodeProperty(HfgwUserContext userContext,String nodeId, int nodeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingNode(userContext, nodeId, nodeVersion, property, newValueExpr, tokensExpr);
		
		Node node = loadNode(userContext, nodeId, allTokens());
		if(node.getVersion() != nodeVersion){
			String message = "The target version("+node.getVersion()+") is not equals to version("+nodeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(node){ 
			//will be good when the node loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Node.
			
			node.changeProperty(property, newValueExpr);
			
			node = saveNode(userContext, node, tokens().done());
			return present(userContext,node, mergedAllTokens(tokensExpr));
			//return saveNode(userContext, node, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected NodeTokens tokens(){
		return NodeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return NodeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortGrpcOptionListWith("id","desc")
		.sortTlsCacertListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return NodeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherOrganization(HfgwUserContext userContext, String nodeId, String anotherOrganizationId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfNode(nodeId);
 		checkerOf(userContext).checkIdOfOrganization(anotherOrganizationId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(NodeManagerException.class);
 		
 	}
 	public Node transferToAnotherOrganization(HfgwUserContext userContext, String nodeId, String anotherOrganizationId) throws Exception
 	{
 		checkParamsForTransferingAnotherOrganization(userContext, nodeId,anotherOrganizationId);
 
		Node node = loadNode(userContext, nodeId, allTokens());	
		synchronized(node){
			//will be good when the node loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Organization organization = loadOrganization(userContext, anotherOrganizationId, emptyOptions());		
			node.updateOrganization(organization);		
			node = saveNode(userContext, node, emptyOptions());
			
			return present(userContext,node, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateOrganization requestCandidateOrganization(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateOrganization result = new CandidateOrganization();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Organization> candidateList = organizationDaoOf(userContext).requestCandidateOrganizationForNode(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherChannel(HfgwUserContext userContext, String nodeId, String anotherChannelId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfNode(nodeId);
 		checkerOf(userContext).checkIdOfChannel(anotherChannelId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(NodeManagerException.class);
 		
 	}
 	public Node transferToAnotherChannel(HfgwUserContext userContext, String nodeId, String anotherChannelId) throws Exception
 	{
 		checkParamsForTransferingAnotherChannel(userContext, nodeId,anotherChannelId);
 
		Node node = loadNode(userContext, nodeId, allTokens());	
		synchronized(node){
			//will be good when the node loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Channel channel = loadChannel(userContext, anotherChannelId, emptyOptions());		
			node.updateChannel(channel);		
			node = saveNode(userContext, node, emptyOptions());
			
			return present(userContext,node, allTokens());
			
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
		SmartList<Channel> candidateList = channelDaoOf(userContext).requestCandidateChannelForNode(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherType(HfgwUserContext userContext, String nodeId, String anotherTypeId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfNode(nodeId);
 		checkerOf(userContext).checkIdOfNodeType(anotherTypeId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(NodeManagerException.class);
 		
 	}
 	public Node transferToAnotherType(HfgwUserContext userContext, String nodeId, String anotherTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherType(userContext, nodeId,anotherTypeId);
 
		Node node = loadNode(userContext, nodeId, allTokens());	
		synchronized(node){
			//will be good when the node loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			NodeType type = loadNodeType(userContext, anotherTypeId, emptyOptions());		
			node.updateType(type);		
			node = saveNode(userContext, node, emptyOptions());
			
			return present(userContext,node, allTokens());
			
		}

 	}
 	
	

	protected void checkParamsForTransferingAnotherTypeWithCode(HfgwUserContext userContext, String nodeId, String anotherCode) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfNode(nodeId);
 		checkerOf(userContext).checkCodeOfNodeType( anotherCode);
 		checkerOf(userContext).throwExceptionIfHasErrors(NodeManagerException.class);
 		
 	}

 	public Node transferToAnotherTypeWithCode(HfgwUserContext userContext, String nodeId, String anotherCode) throws Exception
 	{
 		checkParamsForTransferingAnotherTypeWithCode(userContext, nodeId,anotherCode);
 		Node node = loadNode(userContext, nodeId, allTokens());	
		synchronized(node){
			//will be good when the node loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			NodeType type = loadNodeTypeWithCode(userContext, anotherCode, emptyOptions());		
			node.updateType(type);		
			node = saveNode(userContext, node, emptyOptions());
			
			return present(userContext,node, allTokens());
			
		}
 	}	

	  	
 	
 	
	public CandidateNodeType requestCandidateType(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateNodeType result = new CandidateNodeType();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<NodeType> candidateList = nodeTypeDaoOf(userContext).requestCandidateNodeTypeForNode(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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
 	
 	
 	
	
	 	
 	protected Organization loadOrganization(HfgwUserContext userContext, String newOrganizationId, Map<String,Object> options) throws Exception
 	{
		
 		return organizationDaoOf(userContext).load(newOrganizationId, options);
 	}
 	
 	
 	
	
	 	
 	protected NodeType loadNodeType(HfgwUserContext userContext, String newTypeId, Map<String,Object> options) throws Exception
 	{
		
 		return nodeTypeDaoOf(userContext).load(newTypeId, options);
 	}
 	
 	protected NodeType loadNodeTypeWithCode(HfgwUserContext userContext, String newCode, Map<String,Object> options) throws Exception
 	{
		
 		return nodeTypeDaoOf(userContext).loadByCode(newCode, options);
 	}
 	
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(HfgwUserContext userContext, String nodeId, int nodeVersion) throws Exception {
		//deleteInternal(userContext, nodeId, nodeVersion);		
	}
	protected void deleteInternal(HfgwUserContext userContext,
			String nodeId, int nodeVersion) throws Exception{
			
		nodeDaoOf(userContext).delete(nodeId, nodeVersion);
	}
	
	public Node forgetByAll(HfgwUserContext userContext, String nodeId, int nodeVersion) throws Exception {
		return forgetByAllInternal(userContext, nodeId, nodeVersion);		
	}
	protected Node forgetByAllInternal(HfgwUserContext userContext,
			String nodeId, int nodeVersion) throws Exception{
			
		return nodeDaoOf(userContext).disconnectFromAll(nodeId, nodeVersion);
	}
	
	

	
	public int deleteAll(HfgwUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new NodeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HfgwUserContext userContext) throws Exception{
		return nodeDaoOf(userContext).deleteAll();
	}


	
	
	
	
	

	protected void checkParamsForAddingGrpcOption(HfgwUserContext userContext, String nodeId, String parameterName, String parameterValue,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfNode(nodeId);

		
		checkerOf(userContext).checkParameterNameOfGrpcOption(parameterName);
		
		checkerOf(userContext).checkParameterValueOfGrpcOption(parameterValue);
	
		checkerOf(userContext).throwExceptionIfHasErrors(NodeManagerException.class);

	
	}
	public  Node addGrpcOption(HfgwUserContext userContext, String nodeId, String parameterName, String parameterValue, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGrpcOption(userContext,nodeId,parameterName, parameterValue,tokensExpr);
		
		GrpcOption grpcOption = createGrpcOption(userContext,parameterName, parameterValue);
		
		Node node = loadNode(userContext, nodeId, allTokens());
		synchronized(node){ 
			//Will be good when the node loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			node.addGrpcOption( grpcOption );		
			node = saveNode(userContext, node, tokens().withGrpcOptionList().done());
			
			userContext.getManagerGroup().getGrpcOptionManager().onNewInstanceCreated(userContext, grpcOption);
			return present(userContext,node, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingGrpcOptionProperties(HfgwUserContext userContext, String nodeId,String id,String parameterName,String parameterValue,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfNode(nodeId);
		checkerOf(userContext).checkIdOfGrpcOption(id);
		
		checkerOf(userContext).checkParameterNameOfGrpcOption( parameterName);
		checkerOf(userContext).checkParameterValueOfGrpcOption( parameterValue);

		checkerOf(userContext).throwExceptionIfHasErrors(NodeManagerException.class);
		
	}
	public  Node updateGrpcOptionProperties(HfgwUserContext userContext, String nodeId, String id,String parameterName,String parameterValue, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingGrpcOptionProperties(userContext,nodeId,id,parameterName,parameterValue,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withGrpcOptionListList()
				.searchGrpcOptionListWith(GrpcOption.ID_PROPERTY, "is", id).done();
		
		Node nodeToUpdate = loadNode(userContext, nodeId, options);
		
		if(nodeToUpdate.getGrpcOptionList().isEmpty()){
			throw new NodeManagerException("GrpcOption is NOT FOUND with id: '"+id+"'");
		}
		
		GrpcOption item = nodeToUpdate.getGrpcOptionList().first();
		
		item.updateParameterName( parameterName );
		item.updateParameterValue( parameterValue );

		
		//checkParamsForAddingGrpcOption(userContext,nodeId,name, code, used,tokensExpr);
		Node node = saveNode(userContext, nodeToUpdate, tokens().withGrpcOptionList().done());
		synchronized(node){ 
			return present(userContext,node, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected GrpcOption createGrpcOption(HfgwUserContext userContext, String parameterName, String parameterValue) throws Exception{

		GrpcOption grpcOption = new GrpcOption();
		
		
		grpcOption.setParameterName(parameterName);		
		grpcOption.setParameterValue(parameterValue);
	
		
		return grpcOption;
	
		
	}
	
	protected GrpcOption createIndexedGrpcOption(String id, int version){

		GrpcOption grpcOption = new GrpcOption();
		grpcOption.setId(id);
		grpcOption.setVersion(version);
		return grpcOption;			
		
	}
	
	protected void checkParamsForRemovingGrpcOptionList(HfgwUserContext userContext, String nodeId, 
			String grpcOptionIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfNode(nodeId);
		for(String grpcOptionIdItem: grpcOptionIds){
			checkerOf(userContext).checkIdOfGrpcOption(grpcOptionIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(NodeManagerException.class);
		
	}
	public  Node removeGrpcOptionList(HfgwUserContext userContext, String nodeId, 
			String grpcOptionIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingGrpcOptionList(userContext, nodeId,  grpcOptionIds, tokensExpr);
			
			
			Node node = loadNode(userContext, nodeId, allTokens());
			synchronized(node){ 
				//Will be good when the node loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				nodeDaoOf(userContext).planToRemoveGrpcOptionList(node, grpcOptionIds, allTokens());
				node = saveNode(userContext, node, tokens().withGrpcOptionList().done());
				deleteRelationListInGraph(userContext, node.getGrpcOptionList());
				return present(userContext,node, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingGrpcOption(HfgwUserContext userContext, String nodeId, 
		String grpcOptionId, int grpcOptionVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfNode( nodeId);
		checkerOf(userContext).checkIdOfGrpcOption(grpcOptionId);
		checkerOf(userContext).checkVersionOfGrpcOption(grpcOptionVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(NodeManagerException.class);
	
	}
	public  Node removeGrpcOption(HfgwUserContext userContext, String nodeId, 
		String grpcOptionId, int grpcOptionVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGrpcOption(userContext,nodeId, grpcOptionId, grpcOptionVersion,tokensExpr);
		
		GrpcOption grpcOption = createIndexedGrpcOption(grpcOptionId, grpcOptionVersion);
		Node node = loadNode(userContext, nodeId, allTokens());
		synchronized(node){ 
			//Will be good when the node loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			node.removeGrpcOption( grpcOption );		
			node = saveNode(userContext, node, tokens().withGrpcOptionList().done());
			deleteRelationInGraph(userContext, grpcOption);
			return present(userContext,node, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingGrpcOption(HfgwUserContext userContext, String nodeId, 
		String grpcOptionId, int grpcOptionVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfNode( nodeId);
		checkerOf(userContext).checkIdOfGrpcOption(grpcOptionId);
		checkerOf(userContext).checkVersionOfGrpcOption(grpcOptionVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(NodeManagerException.class);
	
	}
	public  Node copyGrpcOptionFrom(HfgwUserContext userContext, String nodeId, 
		String grpcOptionId, int grpcOptionVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGrpcOption(userContext,nodeId, grpcOptionId, grpcOptionVersion,tokensExpr);
		
		GrpcOption grpcOption = createIndexedGrpcOption(grpcOptionId, grpcOptionVersion);
		Node node = loadNode(userContext, nodeId, allTokens());
		synchronized(node){ 
			//Will be good when the node loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			node.copyGrpcOptionFrom( grpcOption );		
			node = saveNode(userContext, node, tokens().withGrpcOptionList().done());
			
			userContext.getManagerGroup().getGrpcOptionManager().onNewInstanceCreated(userContext, (GrpcOption)node.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,node, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingGrpcOption(HfgwUserContext userContext, String nodeId, String grpcOptionId, int grpcOptionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfNode(nodeId);
		checkerOf(userContext).checkIdOfGrpcOption(grpcOptionId);
		checkerOf(userContext).checkVersionOfGrpcOption(grpcOptionVersion);
		

		if(GrpcOption.PARAMETER_NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkParameterNameOfGrpcOption(parseString(newValueExpr));
		}
		
		if(GrpcOption.PARAMETER_VALUE_PROPERTY.equals(property)){
			checkerOf(userContext).checkParameterValueOfGrpcOption(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(NodeManagerException.class);
	
	}
	
	public  Node updateGrpcOption(HfgwUserContext userContext, String nodeId, String grpcOptionId, int grpcOptionVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGrpcOption(userContext, nodeId, grpcOptionId, grpcOptionVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withGrpcOptionList().searchGrpcOptionListWith(GrpcOption.ID_PROPERTY, "eq", grpcOptionId).done();
		
		
		
		Node node = loadNode(userContext, nodeId, loadTokens);
		
		synchronized(node){ 
			//Will be good when the node loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//node.removeGrpcOption( grpcOption );	
			//make changes to AcceleraterAccount.
			GrpcOption grpcOptionIndex = createIndexedGrpcOption(grpcOptionId, grpcOptionVersion);
		
			GrpcOption grpcOption = node.findTheGrpcOption(grpcOptionIndex);
			if(grpcOption == null){
				throw new NodeManagerException(grpcOption+" is NOT FOUND" );
			}
			
			grpcOption.changeProperty(property, newValueExpr);
			
			node = saveNode(userContext, node, tokens().withGrpcOptionList().done());
			return present(userContext,node, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingTlsCacert(HfgwUserContext userContext, String nodeId, String path, String cert,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfNode(nodeId);

		
		checkerOf(userContext).checkPathOfTlsCacert(path);
		
		checkerOf(userContext).checkCertOfTlsCacert(cert);
	
		checkerOf(userContext).throwExceptionIfHasErrors(NodeManagerException.class);

	
	}
	public  Node addTlsCacert(HfgwUserContext userContext, String nodeId, String path, String cert, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTlsCacert(userContext,nodeId,path, cert,tokensExpr);
		
		TlsCacert tlsCacert = createTlsCacert(userContext,path, cert);
		
		Node node = loadNode(userContext, nodeId, allTokens());
		synchronized(node){ 
			//Will be good when the node loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			node.addTlsCacert( tlsCacert );		
			node = saveNode(userContext, node, tokens().withTlsCacertList().done());
			
			userContext.getManagerGroup().getTlsCacertManager().onNewInstanceCreated(userContext, tlsCacert);
			return present(userContext,node, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTlsCacertProperties(HfgwUserContext userContext, String nodeId,String id,String path,String cert,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfNode(nodeId);
		checkerOf(userContext).checkIdOfTlsCacert(id);
		
		checkerOf(userContext).checkPathOfTlsCacert( path);
		checkerOf(userContext).checkCertOfTlsCacert( cert);

		checkerOf(userContext).throwExceptionIfHasErrors(NodeManagerException.class);
		
	}
	public  Node updateTlsCacertProperties(HfgwUserContext userContext, String nodeId, String id,String path,String cert, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTlsCacertProperties(userContext,nodeId,id,path,cert,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTlsCacertListList()
				.searchTlsCacertListWith(TlsCacert.ID_PROPERTY, "is", id).done();
		
		Node nodeToUpdate = loadNode(userContext, nodeId, options);
		
		if(nodeToUpdate.getTlsCacertList().isEmpty()){
			throw new NodeManagerException("TlsCacert is NOT FOUND with id: '"+id+"'");
		}
		
		TlsCacert item = nodeToUpdate.getTlsCacertList().first();
		
		item.updatePath( path );
		item.updateCert( cert );

		
		//checkParamsForAddingTlsCacert(userContext,nodeId,name, code, used,tokensExpr);
		Node node = saveNode(userContext, nodeToUpdate, tokens().withTlsCacertList().done());
		synchronized(node){ 
			return present(userContext,node, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TlsCacert createTlsCacert(HfgwUserContext userContext, String path, String cert) throws Exception{

		TlsCacert tlsCacert = new TlsCacert();
		
		
		tlsCacert.setPath(path);		
		tlsCacert.setCert(cert);
	
		
		return tlsCacert;
	
		
	}
	
	protected TlsCacert createIndexedTlsCacert(String id, int version){

		TlsCacert tlsCacert = new TlsCacert();
		tlsCacert.setId(id);
		tlsCacert.setVersion(version);
		return tlsCacert;			
		
	}
	
	protected void checkParamsForRemovingTlsCacertList(HfgwUserContext userContext, String nodeId, 
			String tlsCacertIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfNode(nodeId);
		for(String tlsCacertIdItem: tlsCacertIds){
			checkerOf(userContext).checkIdOfTlsCacert(tlsCacertIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(NodeManagerException.class);
		
	}
	public  Node removeTlsCacertList(HfgwUserContext userContext, String nodeId, 
			String tlsCacertIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTlsCacertList(userContext, nodeId,  tlsCacertIds, tokensExpr);
			
			
			Node node = loadNode(userContext, nodeId, allTokens());
			synchronized(node){ 
				//Will be good when the node loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				nodeDaoOf(userContext).planToRemoveTlsCacertList(node, tlsCacertIds, allTokens());
				node = saveNode(userContext, node, tokens().withTlsCacertList().done());
				deleteRelationListInGraph(userContext, node.getTlsCacertList());
				return present(userContext,node, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTlsCacert(HfgwUserContext userContext, String nodeId, 
		String tlsCacertId, int tlsCacertVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfNode( nodeId);
		checkerOf(userContext).checkIdOfTlsCacert(tlsCacertId);
		checkerOf(userContext).checkVersionOfTlsCacert(tlsCacertVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(NodeManagerException.class);
	
	}
	public  Node removeTlsCacert(HfgwUserContext userContext, String nodeId, 
		String tlsCacertId, int tlsCacertVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTlsCacert(userContext,nodeId, tlsCacertId, tlsCacertVersion,tokensExpr);
		
		TlsCacert tlsCacert = createIndexedTlsCacert(tlsCacertId, tlsCacertVersion);
		Node node = loadNode(userContext, nodeId, allTokens());
		synchronized(node){ 
			//Will be good when the node loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			node.removeTlsCacert( tlsCacert );		
			node = saveNode(userContext, node, tokens().withTlsCacertList().done());
			deleteRelationInGraph(userContext, tlsCacert);
			return present(userContext,node, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTlsCacert(HfgwUserContext userContext, String nodeId, 
		String tlsCacertId, int tlsCacertVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfNode( nodeId);
		checkerOf(userContext).checkIdOfTlsCacert(tlsCacertId);
		checkerOf(userContext).checkVersionOfTlsCacert(tlsCacertVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(NodeManagerException.class);
	
	}
	public  Node copyTlsCacertFrom(HfgwUserContext userContext, String nodeId, 
		String tlsCacertId, int tlsCacertVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTlsCacert(userContext,nodeId, tlsCacertId, tlsCacertVersion,tokensExpr);
		
		TlsCacert tlsCacert = createIndexedTlsCacert(tlsCacertId, tlsCacertVersion);
		Node node = loadNode(userContext, nodeId, allTokens());
		synchronized(node){ 
			//Will be good when the node loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			node.copyTlsCacertFrom( tlsCacert );		
			node = saveNode(userContext, node, tokens().withTlsCacertList().done());
			
			userContext.getManagerGroup().getTlsCacertManager().onNewInstanceCreated(userContext, (TlsCacert)node.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,node, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTlsCacert(HfgwUserContext userContext, String nodeId, String tlsCacertId, int tlsCacertVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfNode(nodeId);
		checkerOf(userContext).checkIdOfTlsCacert(tlsCacertId);
		checkerOf(userContext).checkVersionOfTlsCacert(tlsCacertVersion);
		

		if(TlsCacert.PATH_PROPERTY.equals(property)){
			checkerOf(userContext).checkPathOfTlsCacert(parseString(newValueExpr));
		}
		
		if(TlsCacert.CERT_PROPERTY.equals(property)){
			checkerOf(userContext).checkCertOfTlsCacert(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(NodeManagerException.class);
	
	}
	
	public  Node updateTlsCacert(HfgwUserContext userContext, String nodeId, String tlsCacertId, int tlsCacertVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTlsCacert(userContext, nodeId, tlsCacertId, tlsCacertVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTlsCacertList().searchTlsCacertListWith(TlsCacert.ID_PROPERTY, "eq", tlsCacertId).done();
		
		
		
		Node node = loadNode(userContext, nodeId, loadTokens);
		
		synchronized(node){ 
			//Will be good when the node loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//node.removeTlsCacert( tlsCacert );	
			//make changes to AcceleraterAccount.
			TlsCacert tlsCacertIndex = createIndexedTlsCacert(tlsCacertId, tlsCacertVersion);
		
			TlsCacert tlsCacert = node.findTheTlsCacert(tlsCacertIndex);
			if(tlsCacert == null){
				throw new NodeManagerException(tlsCacert+" is NOT FOUND" );
			}
			
			tlsCacert.changeProperty(property, newValueExpr);
			
			node = saveNode(userContext, node, tokens().withTlsCacertList().done());
			return present(userContext,node, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(HfgwUserContext userContext, Node newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


