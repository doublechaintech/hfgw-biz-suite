
package com.doublechaintech.hfgw.organization;

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






public class OrganizationManagerImpl extends CustomHfgwCheckerManager implements OrganizationManager {
	
	private static final String SERVICE_TYPE = "Organization";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws OrganizationManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new OrganizationManagerException(message);

	}
	
	

 	protected Organization saveOrganization(HfgwUserContext userContext, Organization organization, String [] tokensExpr) throws Exception{	
 		//return getOrganizationDAO().save(organization, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveOrganization(userContext, organization, tokens);
 	}
 	
 	protected Organization saveOrganizationDetail(HfgwUserContext userContext, Organization organization) throws Exception{	

 		
 		return saveOrganization(userContext, organization, allTokens());
 	}
 	
 	public Organization loadOrganization(HfgwUserContext userContext, String organizationId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfOrganization(organizationId);
		checkerOf(userContext).throwExceptionIfHasErrors( OrganizationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Organization organization = loadOrganization( userContext, organizationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,organization, tokens);
 	}
 	
 	
 	 public Organization searchOrganization(HfgwUserContext userContext, String organizationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfOrganization(organizationId);
		checkerOf(userContext).throwExceptionIfHasErrors( OrganizationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Organization organization = loadOrganization( userContext, organizationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,organization, tokens);
 	}
 	
 	

 	protected Organization present(HfgwUserContext userContext, Organization organization, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,organization,tokens);
		
		
		Organization  organizationToPresent = organizationDaoOf(userContext).present(organization, tokens);
		
		List<BaseEntity> entityListToNaming = organizationToPresent.collectRefercencesFromLists();
		organizationDaoOf(userContext).alias(entityListToNaming);
		
		return  organizationToPresent;
		
		
	}
 
 	
 	
 	public Organization loadOrganizationDetail(HfgwUserContext userContext, String organizationId) throws Exception{	
 		Organization organization = loadOrganization( userContext, organizationId, allTokens());
 		return present(userContext,organization, allTokens());
		
 	}
 	
 	public Object view(HfgwUserContext userContext, String organizationId) throws Exception{	
 		Organization organization = loadOrganization( userContext, organizationId, viewTokens());
 		return present(userContext,organization, allTokens());
		
 	}
 	protected Organization saveOrganization(HfgwUserContext userContext, Organization organization, Map<String,Object>tokens) throws Exception{	
 		return organizationDaoOf(userContext).save(organization, tokens);
 	}
 	protected Organization loadOrganization(HfgwUserContext userContext, String organizationId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfOrganization(organizationId);
		checkerOf(userContext).throwExceptionIfHasErrors( OrganizationManagerException.class);

 
 		return organizationDaoOf(userContext).load(organizationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, Organization organization, Map<String, Object> tokens){
		super.addActions(userContext, organization, tokens);
		
		addAction(userContext, organization, tokens,"@create","createOrganization","createOrganization/","main","primary");
		addAction(userContext, organization, tokens,"@update","updateOrganization","updateOrganization/"+organization.getId()+"/","main","primary");
		addAction(userContext, organization, tokens,"@copy","cloneOrganization","cloneOrganization/"+organization.getId()+"/","main","primary");
		
		addAction(userContext, organization, tokens,"organization.transfer_to_network","transferToAnotherNetwork","transferToAnotherNetwork/"+organization.getId()+"/","main","primary");
		addAction(userContext, organization, tokens,"organization.addNode","addNode","addNode/"+organization.getId()+"/","nodeList","primary");
		addAction(userContext, organization, tokens,"organization.removeNode","removeNode","removeNode/"+organization.getId()+"/","nodeList","primary");
		addAction(userContext, organization, tokens,"organization.updateNode","updateNode","updateNode/"+organization.getId()+"/","nodeList","primary");
		addAction(userContext, organization, tokens,"organization.copyNodeFrom","copyNodeFrom","copyNodeFrom/"+organization.getId()+"/","nodeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, Organization organization, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public Organization createOrganization(HfgwUserContext userContext, String name,String mspid,String networkId) throws Exception
	//public Organization createOrganization(HfgwUserContext userContext,String name, String mspid, String networkId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkNameOfOrganization(name);
		checkerOf(userContext).checkMspidOfOrganization(mspid);
	
		checkerOf(userContext).throwExceptionIfHasErrors(OrganizationManagerException.class);


		Organization organization=createNewOrganization();	

		organization.setName(name);
		organization.setMspid(mspid);
			
		HyperledgerNetwork network = loadHyperledgerNetwork(userContext, networkId,emptyOptions());
		organization.setNetwork(network);
		
		

		organization = saveOrganization(userContext, organization, emptyOptions());
		
		onNewInstanceCreated(userContext, organization);
		return organization;

		
	}
	protected Organization createNewOrganization() 
	{
		
		return new Organization();		
	}
	
	protected void checkParamsForUpdatingOrganization(HfgwUserContext userContext,String organizationId, int organizationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfOrganization(organizationId);
		checkerOf(userContext).checkVersionOfOrganization( organizationVersion);
		

		if(Organization.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfOrganization(parseString(newValueExpr));
		}
		if(Organization.MSPID_PROPERTY.equals(property)){
			checkerOf(userContext).checkMspidOfOrganization(parseString(newValueExpr));
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(OrganizationManagerException.class);
	
		
	}
	
	
	
	public Organization clone(HfgwUserContext userContext, String fromOrganizationId) throws Exception{
		
		return organizationDaoOf(userContext).clone(fromOrganizationId, this.allTokens());
	}
	
	public Organization internalSaveOrganization(HfgwUserContext userContext, Organization organization) throws Exception 
	{
		return internalSaveOrganization(userContext, organization, allTokens());

	}
	public Organization internalSaveOrganization(HfgwUserContext userContext, Organization organization, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingOrganization(userContext, organizationId, organizationVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(organization){ 
			//will be good when the organization loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Organization.
			if (organization.isChanged()){
			
			}
			organization = saveOrganization(userContext, organization, options);
			return organization;
			
		}

	}
	
	public Organization updateOrganization(HfgwUserContext userContext,String organizationId, int organizationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingOrganization(userContext, organizationId, organizationVersion, property, newValueExpr, tokensExpr);
		
		
		
		Organization organization = loadOrganization(userContext, organizationId, allTokens());
		if(organization.getVersion() != organizationVersion){
			String message = "The target version("+organization.getVersion()+") is not equals to version("+organizationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(organization){ 
			//will be good when the organization loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Organization.
			
			organization.changeProperty(property, newValueExpr);
			organization = saveOrganization(userContext, organization, tokens().done());
			return present(userContext,organization, mergedAllTokens(tokensExpr));
			//return saveOrganization(userContext, organization, tokens().done());
		}

	}
	
	public Organization updateOrganizationProperty(HfgwUserContext userContext,String organizationId, int organizationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingOrganization(userContext, organizationId, organizationVersion, property, newValueExpr, tokensExpr);
		
		Organization organization = loadOrganization(userContext, organizationId, allTokens());
		if(organization.getVersion() != organizationVersion){
			String message = "The target version("+organization.getVersion()+") is not equals to version("+organizationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(organization){ 
			//will be good when the organization loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Organization.
			
			organization.changeProperty(property, newValueExpr);
			
			organization = saveOrganization(userContext, organization, tokens().done());
			return present(userContext,organization, mergedAllTokens(tokensExpr));
			//return saveOrganization(userContext, organization, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected OrganizationTokens tokens(){
		return OrganizationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return OrganizationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortNodeListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return OrganizationTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherNetwork(HfgwUserContext userContext, String organizationId, String anotherNetworkId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfOrganization(organizationId);
 		checkerOf(userContext).checkIdOfHyperledgerNetwork(anotherNetworkId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(OrganizationManagerException.class);
 		
 	}
 	public Organization transferToAnotherNetwork(HfgwUserContext userContext, String organizationId, String anotherNetworkId) throws Exception
 	{
 		checkParamsForTransferingAnotherNetwork(userContext, organizationId,anotherNetworkId);
 
		Organization organization = loadOrganization(userContext, organizationId, allTokens());	
		synchronized(organization){
			//will be good when the organization loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			HyperledgerNetwork network = loadHyperledgerNetwork(userContext, anotherNetworkId, emptyOptions());		
			organization.updateNetwork(network);		
			organization = saveOrganization(userContext, organization, emptyOptions());
			
			return present(userContext,organization, allTokens());
			
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
		SmartList<HyperledgerNetwork> candidateList = hyperledgerNetworkDaoOf(userContext).requestCandidateHyperledgerNetworkForOrganization(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(HfgwUserContext userContext, String organizationId, int organizationVersion) throws Exception {
		//deleteInternal(userContext, organizationId, organizationVersion);		
	}
	protected void deleteInternal(HfgwUserContext userContext,
			String organizationId, int organizationVersion) throws Exception{
			
		organizationDaoOf(userContext).delete(organizationId, organizationVersion);
	}
	
	public Organization forgetByAll(HfgwUserContext userContext, String organizationId, int organizationVersion) throws Exception {
		return forgetByAllInternal(userContext, organizationId, organizationVersion);		
	}
	protected Organization forgetByAllInternal(HfgwUserContext userContext,
			String organizationId, int organizationVersion) throws Exception{
			
		return organizationDaoOf(userContext).disconnectFromAll(organizationId, organizationVersion);
	}
	
	

	
	public int deleteAll(HfgwUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new OrganizationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HfgwUserContext userContext) throws Exception{
		return organizationDaoOf(userContext).deleteAll();
	}


	//disconnect Organization with channel in Node
	protected Organization breakWithNodeByChannel(HfgwUserContext userContext, String organizationId, String channelId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Organization organization = loadOrganization(userContext, organizationId, allTokens());

			synchronized(organization){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				organizationDaoOf(userContext).planToRemoveNodeListWithChannel(organization, channelId, this.emptyOptions());

				organization = saveOrganization(userContext, organization, tokens().withNodeList().done());
				return organization;
			}
	}
	//disconnect Organization with network in Node
	protected Organization breakWithNodeByNetwork(HfgwUserContext userContext, String organizationId, String networkId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Organization organization = loadOrganization(userContext, organizationId, allTokens());

			synchronized(organization){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				organizationDaoOf(userContext).planToRemoveNodeListWithNetwork(organization, networkId, this.emptyOptions());

				organization = saveOrganization(userContext, organization, tokens().withNodeList().done());
				return organization;
			}
	}
	//disconnect Organization with type in Node
	protected Organization breakWithNodeByType(HfgwUserContext userContext, String organizationId, String typeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Organization organization = loadOrganization(userContext, organizationId, allTokens());

			synchronized(organization){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				organizationDaoOf(userContext).planToRemoveNodeListWithType(organization, typeId, this.emptyOptions());

				organization = saveOrganization(userContext, organization, tokens().withNodeList().done());
				return organization;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingNode(HfgwUserContext userContext, String organizationId, String name, String url, String channelId, String networkId, String tlsCacert, String typeId, String address, String contactPerson, String contactTelephone,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfOrganization(organizationId);

		
		checkerOf(userContext).checkNameOfNode(name);
		
		checkerOf(userContext).checkUrlOfNode(url);
		
		checkerOf(userContext).checkChannelIdOfNode(channelId);
		
		checkerOf(userContext).checkNetworkIdOfNode(networkId);
		
		checkerOf(userContext).checkTlsCacertOfNode(tlsCacert);
		
		checkerOf(userContext).checkTypeIdOfNode(typeId);
		
		checkerOf(userContext).checkAddressOfNode(address);
		
		checkerOf(userContext).checkContactPersonOfNode(contactPerson);
		
		checkerOf(userContext).checkContactTelephoneOfNode(contactTelephone);
	
		checkerOf(userContext).throwExceptionIfHasErrors(OrganizationManagerException.class);

	
	}
	public  Organization addNode(HfgwUserContext userContext, String organizationId, String name, String url, String channelId, String networkId, String tlsCacert, String typeId, String address, String contactPerson, String contactTelephone, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingNode(userContext,organizationId,name, url, channelId, networkId, tlsCacert, typeId, address, contactPerson, contactTelephone,tokensExpr);
		
		Node node = createNode(userContext,name, url, channelId, networkId, tlsCacert, typeId, address, contactPerson, contactTelephone);
		
		Organization organization = loadOrganization(userContext, organizationId, allTokens());
		synchronized(organization){ 
			//Will be good when the organization loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			organization.addNode( node );		
			organization = saveOrganization(userContext, organization, tokens().withNodeList().done());
			
			userContext.getManagerGroup().getNodeManager().onNewInstanceCreated(userContext, node);
			return present(userContext,organization, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingNodeProperties(HfgwUserContext userContext, String organizationId,String id,String name,String url,String tlsCacert,String address,String contactPerson,String contactTelephone,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfOrganization(organizationId);
		checkerOf(userContext).checkIdOfNode(id);
		
		checkerOf(userContext).checkNameOfNode( name);
		checkerOf(userContext).checkUrlOfNode( url);
		checkerOf(userContext).checkTlsCacertOfNode( tlsCacert);
		checkerOf(userContext).checkAddressOfNode( address);
		checkerOf(userContext).checkContactPersonOfNode( contactPerson);
		checkerOf(userContext).checkContactTelephoneOfNode( contactTelephone);

		checkerOf(userContext).throwExceptionIfHasErrors(OrganizationManagerException.class);
		
	}
	public  Organization updateNodeProperties(HfgwUserContext userContext, String organizationId, String id,String name,String url,String tlsCacert,String address,String contactPerson,String contactTelephone, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingNodeProperties(userContext,organizationId,id,name,url,tlsCacert,address,contactPerson,contactTelephone,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withNodeListList()
				.searchNodeListWith(Node.ID_PROPERTY, "is", id).done();
		
		Organization organizationToUpdate = loadOrganization(userContext, organizationId, options);
		
		if(organizationToUpdate.getNodeList().isEmpty()){
			throw new OrganizationManagerException("Node is NOT FOUND with id: '"+id+"'");
		}
		
		Node item = organizationToUpdate.getNodeList().first();
		
		item.updateName( name );
		item.updateUrl( url );
		item.updateTlsCacert( tlsCacert );
		item.updateAddress( address );
		item.updateContactPerson( contactPerson );
		item.updateContactTelephone( contactTelephone );

		
		//checkParamsForAddingNode(userContext,organizationId,name, code, used,tokensExpr);
		Organization organization = saveOrganization(userContext, organizationToUpdate, tokens().withNodeList().done());
		synchronized(organization){ 
			return present(userContext,organization, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Node createNode(HfgwUserContext userContext, String name, String url, String channelId, String networkId, String tlsCacert, String typeId, String address, String contactPerson, String contactTelephone) throws Exception{

		Node node = new Node();
		
		
		node.setName(name);		
		node.setUrl(url);		
		Channel  channel = new Channel();
		channel.setId(channelId);		
		node.setChannel(channel);		
		HyperledgerNetwork  network = new HyperledgerNetwork();
		network.setId(networkId);		
		node.setNetwork(network);		
		node.setTlsCacert(tlsCacert);		
		NodeType  type = new NodeType();
		type.setId(typeId);		
		node.setType(type);		
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
	
	protected void checkParamsForRemovingNodeList(HfgwUserContext userContext, String organizationId, 
			String nodeIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfOrganization(organizationId);
		for(String nodeIdItem: nodeIds){
			checkerOf(userContext).checkIdOfNode(nodeIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(OrganizationManagerException.class);
		
	}
	public  Organization removeNodeList(HfgwUserContext userContext, String organizationId, 
			String nodeIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingNodeList(userContext, organizationId,  nodeIds, tokensExpr);
			
			
			Organization organization = loadOrganization(userContext, organizationId, allTokens());
			synchronized(organization){ 
				//Will be good when the organization loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				organizationDaoOf(userContext).planToRemoveNodeList(organization, nodeIds, allTokens());
				organization = saveOrganization(userContext, organization, tokens().withNodeList().done());
				deleteRelationListInGraph(userContext, organization.getNodeList());
				return present(userContext,organization, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingNode(HfgwUserContext userContext, String organizationId, 
		String nodeId, int nodeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfOrganization( organizationId);
		checkerOf(userContext).checkIdOfNode(nodeId);
		checkerOf(userContext).checkVersionOfNode(nodeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(OrganizationManagerException.class);
	
	}
	public  Organization removeNode(HfgwUserContext userContext, String organizationId, 
		String nodeId, int nodeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingNode(userContext,organizationId, nodeId, nodeVersion,tokensExpr);
		
		Node node = createIndexedNode(nodeId, nodeVersion);
		Organization organization = loadOrganization(userContext, organizationId, allTokens());
		synchronized(organization){ 
			//Will be good when the organization loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			organization.removeNode( node );		
			organization = saveOrganization(userContext, organization, tokens().withNodeList().done());
			deleteRelationInGraph(userContext, node);
			return present(userContext,organization, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingNode(HfgwUserContext userContext, String organizationId, 
		String nodeId, int nodeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfOrganization( organizationId);
		checkerOf(userContext).checkIdOfNode(nodeId);
		checkerOf(userContext).checkVersionOfNode(nodeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(OrganizationManagerException.class);
	
	}
	public  Organization copyNodeFrom(HfgwUserContext userContext, String organizationId, 
		String nodeId, int nodeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingNode(userContext,organizationId, nodeId, nodeVersion,tokensExpr);
		
		Node node = createIndexedNode(nodeId, nodeVersion);
		Organization organization = loadOrganization(userContext, organizationId, allTokens());
		synchronized(organization){ 
			//Will be good when the organization loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			organization.copyNodeFrom( node );		
			organization = saveOrganization(userContext, organization, tokens().withNodeList().done());
			
			userContext.getManagerGroup().getNodeManager().onNewInstanceCreated(userContext, (Node)organization.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,organization, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingNode(HfgwUserContext userContext, String organizationId, String nodeId, int nodeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfOrganization(organizationId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(OrganizationManagerException.class);
	
	}
	
	public  Organization updateNode(HfgwUserContext userContext, String organizationId, String nodeId, int nodeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingNode(userContext, organizationId, nodeId, nodeVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withNodeList().searchNodeListWith(Node.ID_PROPERTY, "eq", nodeId).done();
		
		
		
		Organization organization = loadOrganization(userContext, organizationId, loadTokens);
		
		synchronized(organization){ 
			//Will be good when the organization loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//organization.removeNode( node );	
			//make changes to AcceleraterAccount.
			Node nodeIndex = createIndexedNode(nodeId, nodeVersion);
		
			Node node = organization.findTheNode(nodeIndex);
			if(node == null){
				throw new OrganizationManagerException(node+" is NOT FOUND" );
			}
			
			node.changeProperty(property, newValueExpr);
			
			organization = saveOrganization(userContext, organization, tokens().withNodeList().done());
			return present(userContext,organization, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(HfgwUserContext userContext, Organization newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


