
package com.doublechaintech.hfgw.nodetype;

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
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

import com.doublechaintech.hfgw.hyperledgernetwork.CandidateHyperledgerNetwork;

import com.doublechaintech.hfgw.organization.Organization;
import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.nodetype.NodeType;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;






public class NodeTypeManagerImpl extends CustomHfgwCheckerManager implements NodeTypeManager {
	
	private static final String SERVICE_TYPE = "NodeType";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws NodeTypeManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new NodeTypeManagerException(message);

	}
	
	

 	protected NodeType saveNodeType(HfgwUserContext userContext, NodeType nodeType, String [] tokensExpr) throws Exception{	
 		//return getNodeTypeDAO().save(nodeType, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveNodeType(userContext, nodeType, tokens);
 	}
 	
 	protected NodeType saveNodeTypeDetail(HfgwUserContext userContext, NodeType nodeType) throws Exception{	

 		
 		return saveNodeType(userContext, nodeType, allTokens());
 	}
 	
 	public NodeType loadNodeType(HfgwUserContext userContext, String nodeTypeId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfNodeType(nodeTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( NodeTypeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		NodeType nodeType = loadNodeType( userContext, nodeTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,nodeType, tokens);
 	}
 	
 	
 	 public NodeType searchNodeType(HfgwUserContext userContext, String nodeTypeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfNodeType(nodeTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( NodeTypeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		NodeType nodeType = loadNodeType( userContext, nodeTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,nodeType, tokens);
 	}
 	
 	

 	protected NodeType present(HfgwUserContext userContext, NodeType nodeType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,nodeType,tokens);
		
		
		NodeType  nodeTypeToPresent = nodeTypeDaoOf(userContext).present(nodeType, tokens);
		
		List<BaseEntity> entityListToNaming = nodeTypeToPresent.collectRefercencesFromLists();
		nodeTypeDaoOf(userContext).alias(entityListToNaming);
		
		return  nodeTypeToPresent;
		
		
	}
 
 	
 	
 	public NodeType loadNodeTypeDetail(HfgwUserContext userContext, String nodeTypeId) throws Exception{	
 		NodeType nodeType = loadNodeType( userContext, nodeTypeId, allTokens());
 		return present(userContext,nodeType, allTokens());
		
 	}
 	
 	public Object view(HfgwUserContext userContext, String nodeTypeId) throws Exception{	
 		NodeType nodeType = loadNodeType( userContext, nodeTypeId, viewTokens());
 		return present(userContext,nodeType, allTokens());
		
 	}
 	protected NodeType saveNodeType(HfgwUserContext userContext, NodeType nodeType, Map<String,Object>tokens) throws Exception{	
 		return nodeTypeDaoOf(userContext).save(nodeType, tokens);
 	}
 	protected NodeType loadNodeType(HfgwUserContext userContext, String nodeTypeId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfNodeType(nodeTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( NodeTypeManagerException.class);

 
 		return nodeTypeDaoOf(userContext).load(nodeTypeId, tokens);
 	}

	
	

	public NodeType loadNodeTypeWithCode(HfgwUserContext userContext, String code, Map<String,Object>tokens) throws Exception{	
 		return nodeTypeDaoOf(userContext).loadByCode(code, tokens);
 	}

	 


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, NodeType nodeType, Map<String, Object> tokens){
		super.addActions(userContext, nodeType, tokens);
		
		addAction(userContext, nodeType, tokens,"@create","createNodeType","createNodeType/","main","primary");
		addAction(userContext, nodeType, tokens,"@update","updateNodeType","updateNodeType/"+nodeType.getId()+"/","main","primary");
		addAction(userContext, nodeType, tokens,"@copy","cloneNodeType","cloneNodeType/"+nodeType.getId()+"/","main","primary");
		
		addAction(userContext, nodeType, tokens,"node_type.transfer_to_network","transferToAnotherNetwork","transferToAnotherNetwork/"+nodeType.getId()+"/","main","primary");
		addAction(userContext, nodeType, tokens,"node_type.addNode","addNode","addNode/"+nodeType.getId()+"/","nodeList","primary");
		addAction(userContext, nodeType, tokens,"node_type.removeNode","removeNode","removeNode/"+nodeType.getId()+"/","nodeList","primary");
		addAction(userContext, nodeType, tokens,"node_type.updateNode","updateNode","updateNode/"+nodeType.getId()+"/","nodeList","primary");
		addAction(userContext, nodeType, tokens,"node_type.copyNodeFrom","copyNodeFrom","copyNodeFrom/"+nodeType.getId()+"/","nodeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, NodeType nodeType, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public NodeType createNodeType(HfgwUserContext userContext, String name,String code,String networkId) throws Exception
	//public NodeType createNodeType(HfgwUserContext userContext,String name, String code, String networkId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkNameOfNodeType(name);
		checkerOf(userContext).checkCodeOfNodeType(code);
	
		checkerOf(userContext).throwExceptionIfHasErrors(NodeTypeManagerException.class);


		NodeType nodeType=createNewNodeType();	

		nodeType.setName(name);
		nodeType.setCode(code);
			
		HyperledgerNetwork network = loadHyperledgerNetwork(userContext, networkId,emptyOptions());
		nodeType.setNetwork(network);
		
		

		nodeType = saveNodeType(userContext, nodeType, emptyOptions());
		
		onNewInstanceCreated(userContext, nodeType);
		return nodeType;

		
	}
	protected NodeType createNewNodeType() 
	{
		
		return new NodeType();		
	}
	
	protected void checkParamsForUpdatingNodeType(HfgwUserContext userContext,String nodeTypeId, int nodeTypeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfNodeType(nodeTypeId);
		checkerOf(userContext).checkVersionOfNodeType( nodeTypeVersion);
		

		if(NodeType.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfNodeType(parseString(newValueExpr));
		}
		if(NodeType.CODE_PROPERTY.equals(property)){
			checkerOf(userContext).checkCodeOfNodeType(parseString(newValueExpr));
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(NodeTypeManagerException.class);
	
		
	}
	
	
	
	public NodeType clone(HfgwUserContext userContext, String fromNodeTypeId) throws Exception{
		
		return nodeTypeDaoOf(userContext).clone(fromNodeTypeId, this.allTokens());
	}
	
	public NodeType internalSaveNodeType(HfgwUserContext userContext, NodeType nodeType) throws Exception 
	{
		return internalSaveNodeType(userContext, nodeType, allTokens());

	}
	public NodeType internalSaveNodeType(HfgwUserContext userContext, NodeType nodeType, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingNodeType(userContext, nodeTypeId, nodeTypeVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(nodeType){ 
			//will be good when the nodeType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to NodeType.
			if (nodeType.isChanged()){
			
			}
			nodeType = saveNodeType(userContext, nodeType, options);
			return nodeType;
			
		}

	}
	
	public NodeType updateNodeType(HfgwUserContext userContext,String nodeTypeId, int nodeTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingNodeType(userContext, nodeTypeId, nodeTypeVersion, property, newValueExpr, tokensExpr);
		
		
		
		NodeType nodeType = loadNodeType(userContext, nodeTypeId, allTokens());
		if(nodeType.getVersion() != nodeTypeVersion){
			String message = "The target version("+nodeType.getVersion()+") is not equals to version("+nodeTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(nodeType){ 
			//will be good when the nodeType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to NodeType.
			
			nodeType.changeProperty(property, newValueExpr);
			nodeType = saveNodeType(userContext, nodeType, tokens().done());
			return present(userContext,nodeType, mergedAllTokens(tokensExpr));
			//return saveNodeType(userContext, nodeType, tokens().done());
		}

	}
	
	public NodeType updateNodeTypeProperty(HfgwUserContext userContext,String nodeTypeId, int nodeTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingNodeType(userContext, nodeTypeId, nodeTypeVersion, property, newValueExpr, tokensExpr);
		
		NodeType nodeType = loadNodeType(userContext, nodeTypeId, allTokens());
		if(nodeType.getVersion() != nodeTypeVersion){
			String message = "The target version("+nodeType.getVersion()+") is not equals to version("+nodeTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(nodeType){ 
			//will be good when the nodeType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to NodeType.
			
			nodeType.changeProperty(property, newValueExpr);
			
			nodeType = saveNodeType(userContext, nodeType, tokens().done());
			return present(userContext,nodeType, mergedAllTokens(tokensExpr));
			//return saveNodeType(userContext, nodeType, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected NodeTypeTokens tokens(){
		return NodeTypeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return NodeTypeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortNodeListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return NodeTypeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherNetwork(HfgwUserContext userContext, String nodeTypeId, String anotherNetworkId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfNodeType(nodeTypeId);
 		checkerOf(userContext).checkIdOfHyperledgerNetwork(anotherNetworkId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(NodeTypeManagerException.class);
 		
 	}
 	public NodeType transferToAnotherNetwork(HfgwUserContext userContext, String nodeTypeId, String anotherNetworkId) throws Exception
 	{
 		checkParamsForTransferingAnotherNetwork(userContext, nodeTypeId,anotherNetworkId);
 
		NodeType nodeType = loadNodeType(userContext, nodeTypeId, allTokens());	
		synchronized(nodeType){
			//will be good when the nodeType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			HyperledgerNetwork network = loadHyperledgerNetwork(userContext, anotherNetworkId, emptyOptions());		
			nodeType.updateNetwork(network);		
			nodeType = saveNodeType(userContext, nodeType, emptyOptions());
			
			return present(userContext,nodeType, allTokens());
			
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
		SmartList<HyperledgerNetwork> candidateList = hyperledgerNetworkDaoOf(userContext).requestCandidateHyperledgerNetworkForNodeType(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(HfgwUserContext userContext, String nodeTypeId, int nodeTypeVersion) throws Exception {
		//deleteInternal(userContext, nodeTypeId, nodeTypeVersion);		
	}
	protected void deleteInternal(HfgwUserContext userContext,
			String nodeTypeId, int nodeTypeVersion) throws Exception{
			
		nodeTypeDaoOf(userContext).delete(nodeTypeId, nodeTypeVersion);
	}
	
	public NodeType forgetByAll(HfgwUserContext userContext, String nodeTypeId, int nodeTypeVersion) throws Exception {
		return forgetByAllInternal(userContext, nodeTypeId, nodeTypeVersion);		
	}
	protected NodeType forgetByAllInternal(HfgwUserContext userContext,
			String nodeTypeId, int nodeTypeVersion) throws Exception{
			
		return nodeTypeDaoOf(userContext).disconnectFromAll(nodeTypeId, nodeTypeVersion);
	}
	
	

	
	public int deleteAll(HfgwUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new NodeTypeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HfgwUserContext userContext) throws Exception{
		return nodeTypeDaoOf(userContext).deleteAll();
	}


	//disconnect NodeType with organization in Node
	protected NodeType breakWithNodeByOrganization(HfgwUserContext userContext, String nodeTypeId, String organizationId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			NodeType nodeType = loadNodeType(userContext, nodeTypeId, allTokens());

			synchronized(nodeType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				nodeTypeDaoOf(userContext).planToRemoveNodeListWithOrganization(nodeType, organizationId, this.emptyOptions());

				nodeType = saveNodeType(userContext, nodeType, tokens().withNodeList().done());
				return nodeType;
			}
	}
	//disconnect NodeType with channel in Node
	protected NodeType breakWithNodeByChannel(HfgwUserContext userContext, String nodeTypeId, String channelId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			NodeType nodeType = loadNodeType(userContext, nodeTypeId, allTokens());

			synchronized(nodeType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				nodeTypeDaoOf(userContext).planToRemoveNodeListWithChannel(nodeType, channelId, this.emptyOptions());

				nodeType = saveNodeType(userContext, nodeType, tokens().withNodeList().done());
				return nodeType;
			}
	}
	//disconnect NodeType with network in Node
	protected NodeType breakWithNodeByNetwork(HfgwUserContext userContext, String nodeTypeId, String networkId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			NodeType nodeType = loadNodeType(userContext, nodeTypeId, allTokens());

			synchronized(nodeType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				nodeTypeDaoOf(userContext).planToRemoveNodeListWithNetwork(nodeType, networkId, this.emptyOptions());

				nodeType = saveNodeType(userContext, nodeType, tokens().withNodeList().done());
				return nodeType;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingNode(HfgwUserContext userContext, String nodeTypeId, String name, String url, String organizationId, String channelId, String networkId, String tlsCacert, String address, String contactPerson, String contactTelephone,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfNodeType(nodeTypeId);

		
		checkerOf(userContext).checkNameOfNode(name);
		
		checkerOf(userContext).checkUrlOfNode(url);
		
		checkerOf(userContext).checkOrganizationIdOfNode(organizationId);
		
		checkerOf(userContext).checkChannelIdOfNode(channelId);
		
		checkerOf(userContext).checkNetworkIdOfNode(networkId);
		
		checkerOf(userContext).checkTlsCacertOfNode(tlsCacert);
		
		checkerOf(userContext).checkAddressOfNode(address);
		
		checkerOf(userContext).checkContactPersonOfNode(contactPerson);
		
		checkerOf(userContext).checkContactTelephoneOfNode(contactTelephone);
	
		checkerOf(userContext).throwExceptionIfHasErrors(NodeTypeManagerException.class);

	
	}
	public  NodeType addNode(HfgwUserContext userContext, String nodeTypeId, String name, String url, String organizationId, String channelId, String networkId, String tlsCacert, String address, String contactPerson, String contactTelephone, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingNode(userContext,nodeTypeId,name, url, organizationId, channelId, networkId, tlsCacert, address, contactPerson, contactTelephone,tokensExpr);
		
		Node node = createNode(userContext,name, url, organizationId, channelId, networkId, tlsCacert, address, contactPerson, contactTelephone);
		
		NodeType nodeType = loadNodeType(userContext, nodeTypeId, allTokens());
		synchronized(nodeType){ 
			//Will be good when the nodeType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			nodeType.addNode( node );		
			nodeType = saveNodeType(userContext, nodeType, tokens().withNodeList().done());
			
			userContext.getManagerGroup().getNodeManager().onNewInstanceCreated(userContext, node);
			return present(userContext,nodeType, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingNodeProperties(HfgwUserContext userContext, String nodeTypeId,String id,String name,String url,String tlsCacert,String address,String contactPerson,String contactTelephone,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfNodeType(nodeTypeId);
		checkerOf(userContext).checkIdOfNode(id);
		
		checkerOf(userContext).checkNameOfNode( name);
		checkerOf(userContext).checkUrlOfNode( url);
		checkerOf(userContext).checkTlsCacertOfNode( tlsCacert);
		checkerOf(userContext).checkAddressOfNode( address);
		checkerOf(userContext).checkContactPersonOfNode( contactPerson);
		checkerOf(userContext).checkContactTelephoneOfNode( contactTelephone);

		checkerOf(userContext).throwExceptionIfHasErrors(NodeTypeManagerException.class);
		
	}
	public  NodeType updateNodeProperties(HfgwUserContext userContext, String nodeTypeId, String id,String name,String url,String tlsCacert,String address,String contactPerson,String contactTelephone, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingNodeProperties(userContext,nodeTypeId,id,name,url,tlsCacert,address,contactPerson,contactTelephone,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withNodeListList()
				.searchNodeListWith(Node.ID_PROPERTY, "is", id).done();
		
		NodeType nodeTypeToUpdate = loadNodeType(userContext, nodeTypeId, options);
		
		if(nodeTypeToUpdate.getNodeList().isEmpty()){
			throw new NodeTypeManagerException("Node is NOT FOUND with id: '"+id+"'");
		}
		
		Node item = nodeTypeToUpdate.getNodeList().first();
		
		item.updateName( name );
		item.updateUrl( url );
		item.updateTlsCacert( tlsCacert );
		item.updateAddress( address );
		item.updateContactPerson( contactPerson );
		item.updateContactTelephone( contactTelephone );

		
		//checkParamsForAddingNode(userContext,nodeTypeId,name, code, used,tokensExpr);
		NodeType nodeType = saveNodeType(userContext, nodeTypeToUpdate, tokens().withNodeList().done());
		synchronized(nodeType){ 
			return present(userContext,nodeType, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Node createNode(HfgwUserContext userContext, String name, String url, String organizationId, String channelId, String networkId, String tlsCacert, String address, String contactPerson, String contactTelephone) throws Exception{

		Node node = new Node();
		
		
		node.setName(name);		
		node.setUrl(url);		
		Organization  organization = new Organization();
		organization.setId(organizationId);		
		node.setOrganization(organization);		
		Channel  channel = new Channel();
		channel.setId(channelId);		
		node.setChannel(channel);		
		HyperledgerNetwork  network = new HyperledgerNetwork();
		network.setId(networkId);		
		node.setNetwork(network);		
		node.setTlsCacert(tlsCacert);		
		node.setAddress(address);		
		node.setContactPerson(contactPerson);		
		node.setContactTelephone(contactTelephone);
	
		
		return node;
	
		
	}
	
	protected Node createIndexedNode(String id, int version){

		Node node = new Node();
		node.setId(id);
		node.setVersion(version);
		return node;			
		
	}
	
	protected void checkParamsForRemovingNodeList(HfgwUserContext userContext, String nodeTypeId, 
			String nodeIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfNodeType(nodeTypeId);
		for(String nodeIdItem: nodeIds){
			checkerOf(userContext).checkIdOfNode(nodeIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(NodeTypeManagerException.class);
		
	}
	public  NodeType removeNodeList(HfgwUserContext userContext, String nodeTypeId, 
			String nodeIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingNodeList(userContext, nodeTypeId,  nodeIds, tokensExpr);
			
			
			NodeType nodeType = loadNodeType(userContext, nodeTypeId, allTokens());
			synchronized(nodeType){ 
				//Will be good when the nodeType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				nodeTypeDaoOf(userContext).planToRemoveNodeList(nodeType, nodeIds, allTokens());
				nodeType = saveNodeType(userContext, nodeType, tokens().withNodeList().done());
				deleteRelationListInGraph(userContext, nodeType.getNodeList());
				return present(userContext,nodeType, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingNode(HfgwUserContext userContext, String nodeTypeId, 
		String nodeId, int nodeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfNodeType( nodeTypeId);
		checkerOf(userContext).checkIdOfNode(nodeId);
		checkerOf(userContext).checkVersionOfNode(nodeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(NodeTypeManagerException.class);
	
	}
	public  NodeType removeNode(HfgwUserContext userContext, String nodeTypeId, 
		String nodeId, int nodeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingNode(userContext,nodeTypeId, nodeId, nodeVersion,tokensExpr);
		
		Node node = createIndexedNode(nodeId, nodeVersion);
		NodeType nodeType = loadNodeType(userContext, nodeTypeId, allTokens());
		synchronized(nodeType){ 
			//Will be good when the nodeType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			nodeType.removeNode( node );		
			nodeType = saveNodeType(userContext, nodeType, tokens().withNodeList().done());
			deleteRelationInGraph(userContext, node);
			return present(userContext,nodeType, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingNode(HfgwUserContext userContext, String nodeTypeId, 
		String nodeId, int nodeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfNodeType( nodeTypeId);
		checkerOf(userContext).checkIdOfNode(nodeId);
		checkerOf(userContext).checkVersionOfNode(nodeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(NodeTypeManagerException.class);
	
	}
	public  NodeType copyNodeFrom(HfgwUserContext userContext, String nodeTypeId, 
		String nodeId, int nodeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingNode(userContext,nodeTypeId, nodeId, nodeVersion,tokensExpr);
		
		Node node = createIndexedNode(nodeId, nodeVersion);
		NodeType nodeType = loadNodeType(userContext, nodeTypeId, allTokens());
		synchronized(nodeType){ 
			//Will be good when the nodeType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			nodeType.copyNodeFrom( node );		
			nodeType = saveNodeType(userContext, nodeType, tokens().withNodeList().done());
			
			userContext.getManagerGroup().getNodeManager().onNewInstanceCreated(userContext, (Node)nodeType.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,nodeType, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingNode(HfgwUserContext userContext, String nodeTypeId, String nodeId, int nodeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfNodeType(nodeTypeId);
		checkerOf(userContext).checkIdOfNode(nodeId);
		checkerOf(userContext).checkVersionOfNode(nodeVersion);
		

		if(Node.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfNode(parseString(newValueExpr));
		}
		
		if(Node.URL_PROPERTY.equals(property)){
			checkerOf(userContext).checkUrlOfNode(parseString(newValueExpr));
		}
		
		if(Node.TLS_CACERT_PROPERTY.equals(property)){
			checkerOf(userContext).checkTlsCacertOfNode(parseString(newValueExpr));
		}
		
		if(Node.ADDRESS_PROPERTY.equals(property)){
			checkerOf(userContext).checkAddressOfNode(parseString(newValueExpr));
		}
		
		if(Node.CONTACT_PERSON_PROPERTY.equals(property)){
			checkerOf(userContext).checkContactPersonOfNode(parseString(newValueExpr));
		}
		
		if(Node.CONTACT_TELEPHONE_PROPERTY.equals(property)){
			checkerOf(userContext).checkContactTelephoneOfNode(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(NodeTypeManagerException.class);
	
	}
	
	public  NodeType updateNode(HfgwUserContext userContext, String nodeTypeId, String nodeId, int nodeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingNode(userContext, nodeTypeId, nodeId, nodeVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withNodeList().searchNodeListWith(Node.ID_PROPERTY, "eq", nodeId).done();
		
		
		
		NodeType nodeType = loadNodeType(userContext, nodeTypeId, loadTokens);
		
		synchronized(nodeType){ 
			//Will be good when the nodeType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//nodeType.removeNode( node );	
			//make changes to AcceleraterAccount.
			Node nodeIndex = createIndexedNode(nodeId, nodeVersion);
		
			Node node = nodeType.findTheNode(nodeIndex);
			if(node == null){
				throw new NodeTypeManagerException(node+" is NOT FOUND" );
			}
			
			node.changeProperty(property, newValueExpr);
			
			nodeType = saveNodeType(userContext, nodeType, tokens().withNodeList().done());
			return present(userContext,nodeType, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(HfgwUserContext userContext, NodeType newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


