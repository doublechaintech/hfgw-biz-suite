
package com.doublechaintech.hfgw.channel;

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
import com.doublechaintech.hfgw.node.Node;
import com.doublechaintech.hfgw.application.Application;
import com.doublechaintech.hfgw.servicerecord.ServiceRecord;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

import com.doublechaintech.hfgw.hyperledgernetwork.CandidateHyperledgerNetwork;

import com.doublechaintech.hfgw.chaincode.ChainCode;
import com.doublechaintech.hfgw.organization.Organization;
import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.nodetype.NodeType;
import com.doublechaintech.hfgw.application.Application;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;






public class ChannelManagerImpl extends CustomHfgwCheckerManager implements ChannelManager {
	
	private static final String SERVICE_TYPE = "Channel";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ChannelManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ChannelManagerException(message);

	}
	
	

 	protected Channel saveChannel(HfgwUserContext userContext, Channel channel, String [] tokensExpr) throws Exception{	
 		//return getChannelDAO().save(channel, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveChannel(userContext, channel, tokens);
 	}
 	
 	protected Channel saveChannelDetail(HfgwUserContext userContext, Channel channel) throws Exception{	

 		
 		return saveChannel(userContext, channel, allTokens());
 	}
 	
 	public Channel loadChannel(HfgwUserContext userContext, String channelId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfChannel(channelId);
		checkerOf(userContext).throwExceptionIfHasErrors( ChannelManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Channel channel = loadChannel( userContext, channelId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,channel, tokens);
 	}
 	
 	
 	 public Channel searchChannel(HfgwUserContext userContext, String channelId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfChannel(channelId);
		checkerOf(userContext).throwExceptionIfHasErrors( ChannelManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Channel channel = loadChannel( userContext, channelId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,channel, tokens);
 	}
 	
 	

 	protected Channel present(HfgwUserContext userContext, Channel channel, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,channel,tokens);
		
		
		Channel  channelToPresent = channelDaoOf(userContext).present(channel, tokens);
		
		List<BaseEntity> entityListToNaming = channelToPresent.collectRefercencesFromLists();
		channelDaoOf(userContext).alias(entityListToNaming);
		
		return  channelToPresent;
		
		
	}
 
 	
 	
 	public Channel loadChannelDetail(HfgwUserContext userContext, String channelId) throws Exception{	
 		Channel channel = loadChannel( userContext, channelId, allTokens());
 		return present(userContext,channel, allTokens());
		
 	}
 	
 	public Object view(HfgwUserContext userContext, String channelId) throws Exception{	
 		Channel channel = loadChannel( userContext, channelId, viewTokens());
 		return present(userContext,channel, allTokens());
		
 	}
 	protected Channel saveChannel(HfgwUserContext userContext, Channel channel, Map<String,Object>tokens) throws Exception{	
 		return channelDaoOf(userContext).save(channel, tokens);
 	}
 	protected Channel loadChannel(HfgwUserContext userContext, String channelId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfChannel(channelId);
		checkerOf(userContext).throwExceptionIfHasErrors( ChannelManagerException.class);

 
 		return channelDaoOf(userContext).load(channelId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, Channel channel, Map<String, Object> tokens){
		super.addActions(userContext, channel, tokens);
		
		addAction(userContext, channel, tokens,"@create","createChannel","createChannel/","main","primary");
		addAction(userContext, channel, tokens,"@update","updateChannel","updateChannel/"+channel.getId()+"/","main","primary");
		addAction(userContext, channel, tokens,"@copy","cloneChannel","cloneChannel/"+channel.getId()+"/","main","primary");
		
		addAction(userContext, channel, tokens,"channel.transfer_to_network","transferToAnotherNetwork","transferToAnotherNetwork/"+channel.getId()+"/","main","primary");
		addAction(userContext, channel, tokens,"channel.addNode","addNode","addNode/"+channel.getId()+"/","nodeList","primary");
		addAction(userContext, channel, tokens,"channel.removeNode","removeNode","removeNode/"+channel.getId()+"/","nodeList","primary");
		addAction(userContext, channel, tokens,"channel.updateNode","updateNode","updateNode/"+channel.getId()+"/","nodeList","primary");
		addAction(userContext, channel, tokens,"channel.copyNodeFrom","copyNodeFrom","copyNodeFrom/"+channel.getId()+"/","nodeList","primary");
		addAction(userContext, channel, tokens,"channel.addChainCode","addChainCode","addChainCode/"+channel.getId()+"/","chainCodeList","primary");
		addAction(userContext, channel, tokens,"channel.removeChainCode","removeChainCode","removeChainCode/"+channel.getId()+"/","chainCodeList","primary");
		addAction(userContext, channel, tokens,"channel.updateChainCode","updateChainCode","updateChainCode/"+channel.getId()+"/","chainCodeList","primary");
		addAction(userContext, channel, tokens,"channel.copyChainCodeFrom","copyChainCodeFrom","copyChainCodeFrom/"+channel.getId()+"/","chainCodeList","primary");
		addAction(userContext, channel, tokens,"channel.addApplication","addApplication","addApplication/"+channel.getId()+"/","applicationList","primary");
		addAction(userContext, channel, tokens,"channel.removeApplication","removeApplication","removeApplication/"+channel.getId()+"/","applicationList","primary");
		addAction(userContext, channel, tokens,"channel.updateApplication","updateApplication","updateApplication/"+channel.getId()+"/","applicationList","primary");
		addAction(userContext, channel, tokens,"channel.copyApplicationFrom","copyApplicationFrom","copyApplicationFrom/"+channel.getId()+"/","applicationList","primary");
		addAction(userContext, channel, tokens,"channel.addServiceRecord","addServiceRecord","addServiceRecord/"+channel.getId()+"/","serviceRecordList","primary");
		addAction(userContext, channel, tokens,"channel.removeServiceRecord","removeServiceRecord","removeServiceRecord/"+channel.getId()+"/","serviceRecordList","primary");
		addAction(userContext, channel, tokens,"channel.updateServiceRecord","updateServiceRecord","updateServiceRecord/"+channel.getId()+"/","serviceRecordList","primary");
		addAction(userContext, channel, tokens,"channel.copyServiceRecordFrom","copyServiceRecordFrom","copyServiceRecordFrom/"+channel.getId()+"/","serviceRecordList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, Channel channel, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public Channel createChannel(HfgwUserContext userContext, String name,String networkId) throws Exception
	//public Channel createChannel(HfgwUserContext userContext,String name, String networkId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkNameOfChannel(name);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChannelManagerException.class);


		Channel channel=createNewChannel();	

		channel.setName(name);
			
		HyperledgerNetwork network = loadHyperledgerNetwork(userContext, networkId,emptyOptions());
		channel.setNetwork(network);
		
		

		channel = saveChannel(userContext, channel, emptyOptions());
		
		onNewInstanceCreated(userContext, channel);
		return channel;

		
	}
	protected Channel createNewChannel() 
	{
		
		return new Channel();		
	}
	
	protected void checkParamsForUpdatingChannel(HfgwUserContext userContext,String channelId, int channelVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfChannel(channelId);
		checkerOf(userContext).checkVersionOfChannel( channelVersion);
		

		if(Channel.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfChannel(parseString(newValueExpr));
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChannelManagerException.class);
	
		
	}
	
	
	
	public Channel clone(HfgwUserContext userContext, String fromChannelId) throws Exception{
		
		return channelDaoOf(userContext).clone(fromChannelId, this.allTokens());
	}
	
	public Channel internalSaveChannel(HfgwUserContext userContext, Channel channel) throws Exception 
	{
		return internalSaveChannel(userContext, channel, allTokens());

	}
	public Channel internalSaveChannel(HfgwUserContext userContext, Channel channel, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingChannel(userContext, channelId, channelVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(channel){ 
			//will be good when the channel loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Channel.
			if (channel.isChanged()){
			
			}
			channel = saveChannel(userContext, channel, options);
			return channel;
			
		}

	}
	
	public Channel updateChannel(HfgwUserContext userContext,String channelId, int channelVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingChannel(userContext, channelId, channelVersion, property, newValueExpr, tokensExpr);
		
		
		
		Channel channel = loadChannel(userContext, channelId, allTokens());
		if(channel.getVersion() != channelVersion){
			String message = "The target version("+channel.getVersion()+") is not equals to version("+channelVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(channel){ 
			//will be good when the channel loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Channel.
			
			channel.changeProperty(property, newValueExpr);
			channel = saveChannel(userContext, channel, tokens().done());
			return present(userContext,channel, mergedAllTokens(tokensExpr));
			//return saveChannel(userContext, channel, tokens().done());
		}

	}
	
	public Channel updateChannelProperty(HfgwUserContext userContext,String channelId, int channelVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingChannel(userContext, channelId, channelVersion, property, newValueExpr, tokensExpr);
		
		Channel channel = loadChannel(userContext, channelId, allTokens());
		if(channel.getVersion() != channelVersion){
			String message = "The target version("+channel.getVersion()+") is not equals to version("+channelVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(channel){ 
			//will be good when the channel loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Channel.
			
			channel.changeProperty(property, newValueExpr);
			
			channel = saveChannel(userContext, channel, tokens().done());
			return present(userContext,channel, mergedAllTokens(tokensExpr));
			//return saveChannel(userContext, channel, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ChannelTokens tokens(){
		return ChannelTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ChannelTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortNodeListWith("id","desc")
		.sortChainCodeListWith("id","desc")
		.sortApplicationListWith("id","desc")
		.sortServiceRecordListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ChannelTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherNetwork(HfgwUserContext userContext, String channelId, String anotherNetworkId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfChannel(channelId);
 		checkerOf(userContext).checkIdOfHyperledgerNetwork(anotherNetworkId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ChannelManagerException.class);
 		
 	}
 	public Channel transferToAnotherNetwork(HfgwUserContext userContext, String channelId, String anotherNetworkId) throws Exception
 	{
 		checkParamsForTransferingAnotherNetwork(userContext, channelId,anotherNetworkId);
 
		Channel channel = loadChannel(userContext, channelId, allTokens());	
		synchronized(channel){
			//will be good when the channel loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			HyperledgerNetwork network = loadHyperledgerNetwork(userContext, anotherNetworkId, emptyOptions());		
			channel.updateNetwork(network);		
			channel = saveChannel(userContext, channel, emptyOptions());
			
			return present(userContext,channel, allTokens());
			
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
		SmartList<HyperledgerNetwork> candidateList = hyperledgerNetworkDaoOf(userContext).requestCandidateHyperledgerNetworkForChannel(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(HfgwUserContext userContext, String channelId, int channelVersion) throws Exception {
		//deleteInternal(userContext, channelId, channelVersion);		
	}
	protected void deleteInternal(HfgwUserContext userContext,
			String channelId, int channelVersion) throws Exception{
			
		channelDaoOf(userContext).delete(channelId, channelVersion);
	}
	
	public Channel forgetByAll(HfgwUserContext userContext, String channelId, int channelVersion) throws Exception {
		return forgetByAllInternal(userContext, channelId, channelVersion);		
	}
	protected Channel forgetByAllInternal(HfgwUserContext userContext,
			String channelId, int channelVersion) throws Exception{
			
		return channelDaoOf(userContext).disconnectFromAll(channelId, channelVersion);
	}
	
	

	
	public int deleteAll(HfgwUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ChannelManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HfgwUserContext userContext) throws Exception{
		return channelDaoOf(userContext).deleteAll();
	}


	//disconnect Channel with organization in Node
	protected Channel breakWithNodeByOrganization(HfgwUserContext userContext, String channelId, String organizationId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Channel channel = loadChannel(userContext, channelId, allTokens());

			synchronized(channel){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				channelDaoOf(userContext).planToRemoveNodeListWithOrganization(channel, organizationId, this.emptyOptions());

				channel = saveChannel(userContext, channel, tokens().withNodeList().done());
				return channel;
			}
	}
	//disconnect Channel with type in Node
	protected Channel breakWithNodeByType(HfgwUserContext userContext, String channelId, String typeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Channel channel = loadChannel(userContext, channelId, allTokens());

			synchronized(channel){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				channelDaoOf(userContext).planToRemoveNodeListWithType(channel, typeId, this.emptyOptions());

				channel = saveChannel(userContext, channel, tokens().withNodeList().done());
				return channel;
			}
	}
	//disconnect Channel with network in Application
	protected Channel breakWithApplicationByNetwork(HfgwUserContext userContext, String channelId, String networkId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Channel channel = loadChannel(userContext, channelId, allTokens());

			synchronized(channel){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				channelDaoOf(userContext).planToRemoveApplicationListWithNetwork(channel, networkId, this.emptyOptions());

				channel = saveChannel(userContext, channel, tokens().withApplicationList().done());
				return channel;
			}
	}
	//disconnect Channel with chain_code in ServiceRecord
	protected Channel breakWithServiceRecordByChainCode(HfgwUserContext userContext, String channelId, String chainCodeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Channel channel = loadChannel(userContext, channelId, allTokens());

			synchronized(channel){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				channelDaoOf(userContext).planToRemoveServiceRecordListWithChainCode(channel, chainCodeId, this.emptyOptions());

				channel = saveChannel(userContext, channel, tokens().withServiceRecordList().done());
				return channel;
			}
	}
	//disconnect Channel with transaction_id in ServiceRecord
	protected Channel breakWithServiceRecordByTransactionId(HfgwUserContext userContext, String channelId, String transactionIdId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Channel channel = loadChannel(userContext, channelId, allTokens());

			synchronized(channel){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				channelDaoOf(userContext).planToRemoveServiceRecordListWithTransactionId(channel, transactionIdId, this.emptyOptions());

				channel = saveChannel(userContext, channel, tokens().withServiceRecordList().done());
				return channel;
			}
	}
	//disconnect Channel with block_id in ServiceRecord
	protected Channel breakWithServiceRecordByBlockId(HfgwUserContext userContext, String channelId, String blockIdId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Channel channel = loadChannel(userContext, channelId, allTokens());

			synchronized(channel){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				channelDaoOf(userContext).planToRemoveServiceRecordListWithBlockId(channel, blockIdId, this.emptyOptions());

				channel = saveChannel(userContext, channel, tokens().withServiceRecordList().done());
				return channel;
			}
	}
	//disconnect Channel with network in ServiceRecord
	protected Channel breakWithServiceRecordByNetwork(HfgwUserContext userContext, String channelId, String networkId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Channel channel = loadChannel(userContext, channelId, allTokens());

			synchronized(channel){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				channelDaoOf(userContext).planToRemoveServiceRecordListWithNetwork(channel, networkId, this.emptyOptions());

				channel = saveChannel(userContext, channel, tokens().withServiceRecordList().done());
				return channel;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingNode(HfgwUserContext userContext, String channelId, String name, String url, String organizationId, String typeId,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfChannel(channelId);

		
		checkerOf(userContext).checkNameOfNode(name);
		
		checkerOf(userContext).checkUrlOfNode(url);
		
		checkerOf(userContext).checkOrganizationIdOfNode(organizationId);
		
		checkerOf(userContext).checkTypeIdOfNode(typeId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChannelManagerException.class);

	
	}
	public  Channel addNode(HfgwUserContext userContext, String channelId, String name, String url, String organizationId, String typeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingNode(userContext,channelId,name, url, organizationId, typeId,tokensExpr);
		
		Node node = createNode(userContext,name, url, organizationId, typeId);
		
		Channel channel = loadChannel(userContext, channelId, allTokens());
		synchronized(channel){ 
			//Will be good when the channel loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			channel.addNode( node );		
			channel = saveChannel(userContext, channel, tokens().withNodeList().done());
			
			userContext.getManagerGroup().getNodeManager().onNewInstanceCreated(userContext, node);
			return present(userContext,channel, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingNodeProperties(HfgwUserContext userContext, String channelId,String id,String name,String url,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfChannel(channelId);
		checkerOf(userContext).checkIdOfNode(id);
		
		checkerOf(userContext).checkNameOfNode( name);
		checkerOf(userContext).checkUrlOfNode( url);

		checkerOf(userContext).throwExceptionIfHasErrors(ChannelManagerException.class);
		
	}
	public  Channel updateNodeProperties(HfgwUserContext userContext, String channelId, String id,String name,String url, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingNodeProperties(userContext,channelId,id,name,url,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withNodeListList()
				.searchNodeListWith(Node.ID_PROPERTY, "is", id).done();
		
		Channel channelToUpdate = loadChannel(userContext, channelId, options);
		
		if(channelToUpdate.getNodeList().isEmpty()){
			throw new ChannelManagerException("Node is NOT FOUND with id: '"+id+"'");
		}
		
		Node item = channelToUpdate.getNodeList().first();
		
		item.updateName( name );
		item.updateUrl( url );

		
		//checkParamsForAddingNode(userContext,channelId,name, code, used,tokensExpr);
		Channel channel = saveChannel(userContext, channelToUpdate, tokens().withNodeList().done());
		synchronized(channel){ 
			return present(userContext,channel, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Node createNode(HfgwUserContext userContext, String name, String url, String organizationId, String typeId) throws Exception{

		Node node = new Node();
		
		
		node.setName(name);		
		node.setUrl(url);		
		Organization  organization = new Organization();
		organization.setId(organizationId);		
		node.setOrganization(organization);		
		NodeType  type = new NodeType();
		type.setId(typeId);		
		node.setType(type);
	
		
		return node;
	
		
	}
	
	protected Node createIndexedNode(String id, int version){

		Node node = new Node();
		node.setId(id);
		node.setVersion(version);
		return node;			
		
	}
	
	protected void checkParamsForRemovingNodeList(HfgwUserContext userContext, String channelId, 
			String nodeIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfChannel(channelId);
		for(String nodeIdItem: nodeIds){
			checkerOf(userContext).checkIdOfNode(nodeIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(ChannelManagerException.class);
		
	}
	public  Channel removeNodeList(HfgwUserContext userContext, String channelId, 
			String nodeIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingNodeList(userContext, channelId,  nodeIds, tokensExpr);
			
			
			Channel channel = loadChannel(userContext, channelId, allTokens());
			synchronized(channel){ 
				//Will be good when the channel loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				channelDaoOf(userContext).planToRemoveNodeList(channel, nodeIds, allTokens());
				channel = saveChannel(userContext, channel, tokens().withNodeList().done());
				deleteRelationListInGraph(userContext, channel.getNodeList());
				return present(userContext,channel, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingNode(HfgwUserContext userContext, String channelId, 
		String nodeId, int nodeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfChannel( channelId);
		checkerOf(userContext).checkIdOfNode(nodeId);
		checkerOf(userContext).checkVersionOfNode(nodeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ChannelManagerException.class);
	
	}
	public  Channel removeNode(HfgwUserContext userContext, String channelId, 
		String nodeId, int nodeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingNode(userContext,channelId, nodeId, nodeVersion,tokensExpr);
		
		Node node = createIndexedNode(nodeId, nodeVersion);
		Channel channel = loadChannel(userContext, channelId, allTokens());
		synchronized(channel){ 
			//Will be good when the channel loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			channel.removeNode( node );		
			channel = saveChannel(userContext, channel, tokens().withNodeList().done());
			deleteRelationInGraph(userContext, node);
			return present(userContext,channel, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingNode(HfgwUserContext userContext, String channelId, 
		String nodeId, int nodeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfChannel( channelId);
		checkerOf(userContext).checkIdOfNode(nodeId);
		checkerOf(userContext).checkVersionOfNode(nodeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ChannelManagerException.class);
	
	}
	public  Channel copyNodeFrom(HfgwUserContext userContext, String channelId, 
		String nodeId, int nodeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingNode(userContext,channelId, nodeId, nodeVersion,tokensExpr);
		
		Node node = createIndexedNode(nodeId, nodeVersion);
		Channel channel = loadChannel(userContext, channelId, allTokens());
		synchronized(channel){ 
			//Will be good when the channel loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			channel.copyNodeFrom( node );		
			channel = saveChannel(userContext, channel, tokens().withNodeList().done());
			
			userContext.getManagerGroup().getNodeManager().onNewInstanceCreated(userContext, (Node)channel.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,channel, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingNode(HfgwUserContext userContext, String channelId, String nodeId, int nodeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfChannel(channelId);
		checkerOf(userContext).checkIdOfNode(nodeId);
		checkerOf(userContext).checkVersionOfNode(nodeVersion);
		

		if(Node.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfNode(parseString(newValueExpr));
		}
		
		if(Node.URL_PROPERTY.equals(property)){
			checkerOf(userContext).checkUrlOfNode(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChannelManagerException.class);
	
	}
	
	public  Channel updateNode(HfgwUserContext userContext, String channelId, String nodeId, int nodeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingNode(userContext, channelId, nodeId, nodeVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withNodeList().searchNodeListWith(Node.ID_PROPERTY, "eq", nodeId).done();
		
		
		
		Channel channel = loadChannel(userContext, channelId, loadTokens);
		
		synchronized(channel){ 
			//Will be good when the channel loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//channel.removeNode( node );	
			//make changes to AcceleraterAccount.
			Node nodeIndex = createIndexedNode(nodeId, nodeVersion);
		
			Node node = channel.findTheNode(nodeIndex);
			if(node == null){
				throw new ChannelManagerException(node+" is NOT FOUND" );
			}
			
			node.changeProperty(property, newValueExpr);
			
			channel = saveChannel(userContext, channel, tokens().withNodeList().done());
			return present(userContext,channel, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingChainCode(HfgwUserContext userContext, String channelId, String name, String codeName, String codeVersion,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfChannel(channelId);

		
		checkerOf(userContext).checkNameOfChainCode(name);
		
		checkerOf(userContext).checkCodeNameOfChainCode(codeName);
		
		checkerOf(userContext).checkCodeVersionOfChainCode(codeVersion);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChannelManagerException.class);

	
	}
	public  Channel addChainCode(HfgwUserContext userContext, String channelId, String name, String codeName, String codeVersion, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingChainCode(userContext,channelId,name, codeName, codeVersion,tokensExpr);
		
		ChainCode chainCode = createChainCode(userContext,name, codeName, codeVersion);
		
		Channel channel = loadChannel(userContext, channelId, allTokens());
		synchronized(channel){ 
			//Will be good when the channel loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			channel.addChainCode( chainCode );		
			channel = saveChannel(userContext, channel, tokens().withChainCodeList().done());
			
			userContext.getManagerGroup().getChainCodeManager().onNewInstanceCreated(userContext, chainCode);
			return present(userContext,channel, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingChainCodeProperties(HfgwUserContext userContext, String channelId,String id,String name,String codeName,String codeVersion,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfChannel(channelId);
		checkerOf(userContext).checkIdOfChainCode(id);
		
		checkerOf(userContext).checkNameOfChainCode( name);
		checkerOf(userContext).checkCodeNameOfChainCode( codeName);
		checkerOf(userContext).checkCodeVersionOfChainCode( codeVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(ChannelManagerException.class);
		
	}
	public  Channel updateChainCodeProperties(HfgwUserContext userContext, String channelId, String id,String name,String codeName,String codeVersion, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingChainCodeProperties(userContext,channelId,id,name,codeName,codeVersion,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withChainCodeListList()
				.searchChainCodeListWith(ChainCode.ID_PROPERTY, "is", id).done();
		
		Channel channelToUpdate = loadChannel(userContext, channelId, options);
		
		if(channelToUpdate.getChainCodeList().isEmpty()){
			throw new ChannelManagerException("ChainCode is NOT FOUND with id: '"+id+"'");
		}
		
		ChainCode item = channelToUpdate.getChainCodeList().first();
		
		item.updateName( name );
		item.updateCodeName( codeName );
		item.updateCodeVersion( codeVersion );

		
		//checkParamsForAddingChainCode(userContext,channelId,name, code, used,tokensExpr);
		Channel channel = saveChannel(userContext, channelToUpdate, tokens().withChainCodeList().done());
		synchronized(channel){ 
			return present(userContext,channel, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ChainCode createChainCode(HfgwUserContext userContext, String name, String codeName, String codeVersion) throws Exception{

		ChainCode chainCode = new ChainCode();
		
		
		chainCode.setName(name);		
		chainCode.setCodeName(codeName);		
		chainCode.setCodeVersion(codeVersion);
	
		
		return chainCode;
	
		
	}
	
	protected ChainCode createIndexedChainCode(String id, int version){

		ChainCode chainCode = new ChainCode();
		chainCode.setId(id);
		chainCode.setVersion(version);
		return chainCode;			
		
	}
	
	protected void checkParamsForRemovingChainCodeList(HfgwUserContext userContext, String channelId, 
			String chainCodeIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfChannel(channelId);
		for(String chainCodeIdItem: chainCodeIds){
			checkerOf(userContext).checkIdOfChainCode(chainCodeIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(ChannelManagerException.class);
		
	}
	public  Channel removeChainCodeList(HfgwUserContext userContext, String channelId, 
			String chainCodeIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingChainCodeList(userContext, channelId,  chainCodeIds, tokensExpr);
			
			
			Channel channel = loadChannel(userContext, channelId, allTokens());
			synchronized(channel){ 
				//Will be good when the channel loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				channelDaoOf(userContext).planToRemoveChainCodeList(channel, chainCodeIds, allTokens());
				channel = saveChannel(userContext, channel, tokens().withChainCodeList().done());
				deleteRelationListInGraph(userContext, channel.getChainCodeList());
				return present(userContext,channel, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingChainCode(HfgwUserContext userContext, String channelId, 
		String chainCodeId, int chainCodeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfChannel( channelId);
		checkerOf(userContext).checkIdOfChainCode(chainCodeId);
		checkerOf(userContext).checkVersionOfChainCode(chainCodeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ChannelManagerException.class);
	
	}
	public  Channel removeChainCode(HfgwUserContext userContext, String channelId, 
		String chainCodeId, int chainCodeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingChainCode(userContext,channelId, chainCodeId, chainCodeVersion,tokensExpr);
		
		ChainCode chainCode = createIndexedChainCode(chainCodeId, chainCodeVersion);
		Channel channel = loadChannel(userContext, channelId, allTokens());
		synchronized(channel){ 
			//Will be good when the channel loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			channel.removeChainCode( chainCode );		
			channel = saveChannel(userContext, channel, tokens().withChainCodeList().done());
			deleteRelationInGraph(userContext, chainCode);
			return present(userContext,channel, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingChainCode(HfgwUserContext userContext, String channelId, 
		String chainCodeId, int chainCodeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfChannel( channelId);
		checkerOf(userContext).checkIdOfChainCode(chainCodeId);
		checkerOf(userContext).checkVersionOfChainCode(chainCodeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ChannelManagerException.class);
	
	}
	public  Channel copyChainCodeFrom(HfgwUserContext userContext, String channelId, 
		String chainCodeId, int chainCodeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingChainCode(userContext,channelId, chainCodeId, chainCodeVersion,tokensExpr);
		
		ChainCode chainCode = createIndexedChainCode(chainCodeId, chainCodeVersion);
		Channel channel = loadChannel(userContext, channelId, allTokens());
		synchronized(channel){ 
			//Will be good when the channel loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			channel.copyChainCodeFrom( chainCode );		
			channel = saveChannel(userContext, channel, tokens().withChainCodeList().done());
			
			userContext.getManagerGroup().getChainCodeManager().onNewInstanceCreated(userContext, (ChainCode)channel.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,channel, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingChainCode(HfgwUserContext userContext, String channelId, String chainCodeId, int chainCodeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfChannel(channelId);
		checkerOf(userContext).checkIdOfChainCode(chainCodeId);
		checkerOf(userContext).checkVersionOfChainCode(chainCodeVersion);
		

		if(ChainCode.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfChainCode(parseString(newValueExpr));
		}
		
		if(ChainCode.CODE_NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkCodeNameOfChainCode(parseString(newValueExpr));
		}
		
		if(ChainCode.CODE_VERSION_PROPERTY.equals(property)){
			checkerOf(userContext).checkCodeVersionOfChainCode(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChannelManagerException.class);
	
	}
	
	public  Channel updateChainCode(HfgwUserContext userContext, String channelId, String chainCodeId, int chainCodeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingChainCode(userContext, channelId, chainCodeId, chainCodeVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withChainCodeList().searchChainCodeListWith(ChainCode.ID_PROPERTY, "eq", chainCodeId).done();
		
		
		
		Channel channel = loadChannel(userContext, channelId, loadTokens);
		
		synchronized(channel){ 
			//Will be good when the channel loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//channel.removeChainCode( chainCode );	
			//make changes to AcceleraterAccount.
			ChainCode chainCodeIndex = createIndexedChainCode(chainCodeId, chainCodeVersion);
		
			ChainCode chainCode = channel.findTheChainCode(chainCodeIndex);
			if(chainCode == null){
				throw new ChannelManagerException(chainCode+" is NOT FOUND" );
			}
			
			chainCode.changeProperty(property, newValueExpr);
			
			channel = saveChannel(userContext, channel, tokens().withChainCodeList().done());
			return present(userContext,channel, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingApplication(HfgwUserContext userContext, String channelId, String name, String mspid, String publicKey, String privateKey, String networkId,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfChannel(channelId);

		
		checkerOf(userContext).checkNameOfApplication(name);
		
		checkerOf(userContext).checkMspidOfApplication(mspid);
		
		checkerOf(userContext).checkPublicKeyOfApplication(publicKey);
		
		checkerOf(userContext).checkPrivateKeyOfApplication(privateKey);
		
		checkerOf(userContext).checkNetworkIdOfApplication(networkId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChannelManagerException.class);

	
	}
	public  Channel addApplication(HfgwUserContext userContext, String channelId, String name, String mspid, String publicKey, String privateKey, String networkId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingApplication(userContext,channelId,name, mspid, publicKey, privateKey, networkId,tokensExpr);
		
		Application application = createApplication(userContext,name, mspid, publicKey, privateKey, networkId);
		
		Channel channel = loadChannel(userContext, channelId, allTokens());
		synchronized(channel){ 
			//Will be good when the channel loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			channel.addApplication( application );		
			channel = saveChannel(userContext, channel, tokens().withApplicationList().done());
			
			userContext.getManagerGroup().getApplicationManager().onNewInstanceCreated(userContext, application);
			return present(userContext,channel, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingApplicationProperties(HfgwUserContext userContext, String channelId,String id,String name,String mspid,String publicKey,String privateKey,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfChannel(channelId);
		checkerOf(userContext).checkIdOfApplication(id);
		
		checkerOf(userContext).checkNameOfApplication( name);
		checkerOf(userContext).checkMspidOfApplication( mspid);
		checkerOf(userContext).checkPublicKeyOfApplication( publicKey);
		checkerOf(userContext).checkPrivateKeyOfApplication( privateKey);

		checkerOf(userContext).throwExceptionIfHasErrors(ChannelManagerException.class);
		
	}
	public  Channel updateApplicationProperties(HfgwUserContext userContext, String channelId, String id,String name,String mspid,String publicKey,String privateKey, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingApplicationProperties(userContext,channelId,id,name,mspid,publicKey,privateKey,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withApplicationListList()
				.searchApplicationListWith(Application.ID_PROPERTY, "is", id).done();
		
		Channel channelToUpdate = loadChannel(userContext, channelId, options);
		
		if(channelToUpdate.getApplicationList().isEmpty()){
			throw new ChannelManagerException("Application is NOT FOUND with id: '"+id+"'");
		}
		
		Application item = channelToUpdate.getApplicationList().first();
		
		item.updateName( name );
		item.updateMspid( mspid );
		item.updatePublicKey( publicKey );
		item.updatePrivateKey( privateKey );

		
		//checkParamsForAddingApplication(userContext,channelId,name, code, used,tokensExpr);
		Channel channel = saveChannel(userContext, channelToUpdate, tokens().withApplicationList().done());
		synchronized(channel){ 
			return present(userContext,channel, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Application createApplication(HfgwUserContext userContext, String name, String mspid, String publicKey, String privateKey, String networkId) throws Exception{

		Application application = new Application();
		
		
		application.setName(name);		
		application.setCreateTime(userContext.now());		
		application.setMspid(mspid);		
		application.setPublicKey(publicKey);		
		application.setPrivateKey(privateKey);		
		HyperledgerNetwork  network = new HyperledgerNetwork();
		network.setId(networkId);		
		application.setNetwork(network);
	
		
		return application;
	
		
	}
	
	protected Application createIndexedApplication(String id, int version){

		Application application = new Application();
		application.setId(id);
		application.setVersion(version);
		return application;			
		
	}
	
	protected void checkParamsForRemovingApplicationList(HfgwUserContext userContext, String channelId, 
			String applicationIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfChannel(channelId);
		for(String applicationIdItem: applicationIds){
			checkerOf(userContext).checkIdOfApplication(applicationIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(ChannelManagerException.class);
		
	}
	public  Channel removeApplicationList(HfgwUserContext userContext, String channelId, 
			String applicationIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingApplicationList(userContext, channelId,  applicationIds, tokensExpr);
			
			
			Channel channel = loadChannel(userContext, channelId, allTokens());
			synchronized(channel){ 
				//Will be good when the channel loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				channelDaoOf(userContext).planToRemoveApplicationList(channel, applicationIds, allTokens());
				channel = saveChannel(userContext, channel, tokens().withApplicationList().done());
				deleteRelationListInGraph(userContext, channel.getApplicationList());
				return present(userContext,channel, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingApplication(HfgwUserContext userContext, String channelId, 
		String applicationId, int applicationVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfChannel( channelId);
		checkerOf(userContext).checkIdOfApplication(applicationId);
		checkerOf(userContext).checkVersionOfApplication(applicationVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ChannelManagerException.class);
	
	}
	public  Channel removeApplication(HfgwUserContext userContext, String channelId, 
		String applicationId, int applicationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingApplication(userContext,channelId, applicationId, applicationVersion,tokensExpr);
		
		Application application = createIndexedApplication(applicationId, applicationVersion);
		Channel channel = loadChannel(userContext, channelId, allTokens());
		synchronized(channel){ 
			//Will be good when the channel loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			channel.removeApplication( application );		
			channel = saveChannel(userContext, channel, tokens().withApplicationList().done());
			deleteRelationInGraph(userContext, application);
			return present(userContext,channel, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingApplication(HfgwUserContext userContext, String channelId, 
		String applicationId, int applicationVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfChannel( channelId);
		checkerOf(userContext).checkIdOfApplication(applicationId);
		checkerOf(userContext).checkVersionOfApplication(applicationVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ChannelManagerException.class);
	
	}
	public  Channel copyApplicationFrom(HfgwUserContext userContext, String channelId, 
		String applicationId, int applicationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingApplication(userContext,channelId, applicationId, applicationVersion,tokensExpr);
		
		Application application = createIndexedApplication(applicationId, applicationVersion);
		Channel channel = loadChannel(userContext, channelId, allTokens());
		synchronized(channel){ 
			//Will be good when the channel loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			channel.copyApplicationFrom( application );		
			channel = saveChannel(userContext, channel, tokens().withApplicationList().done());
			
			userContext.getManagerGroup().getApplicationManager().onNewInstanceCreated(userContext, (Application)channel.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,channel, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingApplication(HfgwUserContext userContext, String channelId, String applicationId, int applicationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfChannel(channelId);
		checkerOf(userContext).checkIdOfApplication(applicationId);
		checkerOf(userContext).checkVersionOfApplication(applicationVersion);
		

		if(Application.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfApplication(parseString(newValueExpr));
		}
		
		if(Application.MSPID_PROPERTY.equals(property)){
			checkerOf(userContext).checkMspidOfApplication(parseString(newValueExpr));
		}
		
		if(Application.PUBLIC_KEY_PROPERTY.equals(property)){
			checkerOf(userContext).checkPublicKeyOfApplication(parseString(newValueExpr));
		}
		
		if(Application.PRIVATE_KEY_PROPERTY.equals(property)){
			checkerOf(userContext).checkPrivateKeyOfApplication(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChannelManagerException.class);
	
	}
	
	public  Channel updateApplication(HfgwUserContext userContext, String channelId, String applicationId, int applicationVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingApplication(userContext, channelId, applicationId, applicationVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withApplicationList().searchApplicationListWith(Application.ID_PROPERTY, "eq", applicationId).done();
		
		
		
		Channel channel = loadChannel(userContext, channelId, loadTokens);
		
		synchronized(channel){ 
			//Will be good when the channel loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//channel.removeApplication( application );	
			//make changes to AcceleraterAccount.
			Application applicationIndex = createIndexedApplication(applicationId, applicationVersion);
		
			Application application = channel.findTheApplication(applicationIndex);
			if(application == null){
				throw new ChannelManagerException(application+" is NOT FOUND" );
			}
			
			application.changeProperty(property, newValueExpr);
			
			channel = saveChannel(userContext, channel, tokens().withApplicationList().done());
			return present(userContext,channel, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingServiceRecord(HfgwUserContext userContext, String channelId, String name, String payLoad, String chainCodeId, String transactionId, String blockId, String networkId,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfChannel(channelId);

		
		checkerOf(userContext).checkNameOfServiceRecord(name);
		
		checkerOf(userContext).checkPayLoadOfServiceRecord(payLoad);
		
		checkerOf(userContext).checkChainCodeIdOfServiceRecord(chainCodeId);
		
		checkerOf(userContext).checkTransactionIdOfServiceRecord(transactionId);
		
		checkerOf(userContext).checkBlockIdOfServiceRecord(blockId);
		
		checkerOf(userContext).checkNetworkIdOfServiceRecord(networkId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChannelManagerException.class);

	
	}
	public  Channel addServiceRecord(HfgwUserContext userContext, String channelId, String name, String payLoad, String chainCodeId, String transactionId, String blockId, String networkId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingServiceRecord(userContext,channelId,name, payLoad, chainCodeId, transactionId, blockId, networkId,tokensExpr);
		
		ServiceRecord serviceRecord = createServiceRecord(userContext,name, payLoad, chainCodeId, transactionId, blockId, networkId);
		
		Channel channel = loadChannel(userContext, channelId, allTokens());
		synchronized(channel){ 
			//Will be good when the channel loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			channel.addServiceRecord( serviceRecord );		
			channel = saveChannel(userContext, channel, tokens().withServiceRecordList().done());
			
			userContext.getManagerGroup().getServiceRecordManager().onNewInstanceCreated(userContext, serviceRecord);
			return present(userContext,channel, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingServiceRecordProperties(HfgwUserContext userContext, String channelId,String id,String name,String payLoad,String transactionId,String blockId,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfChannel(channelId);
		checkerOf(userContext).checkIdOfServiceRecord(id);
		
		checkerOf(userContext).checkNameOfServiceRecord( name);
		checkerOf(userContext).checkPayLoadOfServiceRecord( payLoad);
		checkerOf(userContext).checkTransactionIdOfServiceRecord( transactionId);
		checkerOf(userContext).checkBlockIdOfServiceRecord( blockId);

		checkerOf(userContext).throwExceptionIfHasErrors(ChannelManagerException.class);
		
	}
	public  Channel updateServiceRecordProperties(HfgwUserContext userContext, String channelId, String id,String name,String payLoad,String transactionId,String blockId, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingServiceRecordProperties(userContext,channelId,id,name,payLoad,transactionId,blockId,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withServiceRecordListList()
				.searchServiceRecordListWith(ServiceRecord.ID_PROPERTY, "is", id).done();
		
		Channel channelToUpdate = loadChannel(userContext, channelId, options);
		
		if(channelToUpdate.getServiceRecordList().isEmpty()){
			throw new ChannelManagerException("ServiceRecord is NOT FOUND with id: '"+id+"'");
		}
		
		ServiceRecord item = channelToUpdate.getServiceRecordList().first();
		
		item.updateName( name );
		item.updatePayLoad( payLoad );
		item.updateTransactionId( transactionId );
		item.updateBlockId( blockId );

		
		//checkParamsForAddingServiceRecord(userContext,channelId,name, code, used,tokensExpr);
		Channel channel = saveChannel(userContext, channelToUpdate, tokens().withServiceRecordList().done());
		synchronized(channel){ 
			return present(userContext,channel, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ServiceRecord createServiceRecord(HfgwUserContext userContext, String name, String payLoad, String chainCodeId, String transactionId, String blockId, String networkId) throws Exception{

		ServiceRecord serviceRecord = new ServiceRecord();
		
		
		serviceRecord.setName(name);		
		serviceRecord.setPayLoad(payLoad);		
		ChainCode  chainCode = new ChainCode();
		chainCode.setId(chainCodeId);		
		serviceRecord.setChainCode(chainCode);		
		serviceRecord.setTransactionId(transactionId);		
		serviceRecord.setBlockId(blockId);		
		serviceRecord.setCreateTime(userContext.now());		
		HyperledgerNetwork  network = new HyperledgerNetwork();
		network.setId(networkId);		
		serviceRecord.setNetwork(network);		
		serviceRecord.setCurrentStatus("INIT");
	
		
		return serviceRecord;
	
		
	}
	
	protected ServiceRecord createIndexedServiceRecord(String id, int version){

		ServiceRecord serviceRecord = new ServiceRecord();
		serviceRecord.setId(id);
		serviceRecord.setVersion(version);
		return serviceRecord;			
		
	}
	
	protected void checkParamsForRemovingServiceRecordList(HfgwUserContext userContext, String channelId, 
			String serviceRecordIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfChannel(channelId);
		for(String serviceRecordIdItem: serviceRecordIds){
			checkerOf(userContext).checkIdOfServiceRecord(serviceRecordIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(ChannelManagerException.class);
		
	}
	public  Channel removeServiceRecordList(HfgwUserContext userContext, String channelId, 
			String serviceRecordIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingServiceRecordList(userContext, channelId,  serviceRecordIds, tokensExpr);
			
			
			Channel channel = loadChannel(userContext, channelId, allTokens());
			synchronized(channel){ 
				//Will be good when the channel loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				channelDaoOf(userContext).planToRemoveServiceRecordList(channel, serviceRecordIds, allTokens());
				channel = saveChannel(userContext, channel, tokens().withServiceRecordList().done());
				deleteRelationListInGraph(userContext, channel.getServiceRecordList());
				return present(userContext,channel, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingServiceRecord(HfgwUserContext userContext, String channelId, 
		String serviceRecordId, int serviceRecordVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfChannel( channelId);
		checkerOf(userContext).checkIdOfServiceRecord(serviceRecordId);
		checkerOf(userContext).checkVersionOfServiceRecord(serviceRecordVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ChannelManagerException.class);
	
	}
	public  Channel removeServiceRecord(HfgwUserContext userContext, String channelId, 
		String serviceRecordId, int serviceRecordVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingServiceRecord(userContext,channelId, serviceRecordId, serviceRecordVersion,tokensExpr);
		
		ServiceRecord serviceRecord = createIndexedServiceRecord(serviceRecordId, serviceRecordVersion);
		Channel channel = loadChannel(userContext, channelId, allTokens());
		synchronized(channel){ 
			//Will be good when the channel loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			channel.removeServiceRecord( serviceRecord );		
			channel = saveChannel(userContext, channel, tokens().withServiceRecordList().done());
			deleteRelationInGraph(userContext, serviceRecord);
			return present(userContext,channel, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingServiceRecord(HfgwUserContext userContext, String channelId, 
		String serviceRecordId, int serviceRecordVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfChannel( channelId);
		checkerOf(userContext).checkIdOfServiceRecord(serviceRecordId);
		checkerOf(userContext).checkVersionOfServiceRecord(serviceRecordVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ChannelManagerException.class);
	
	}
	public  Channel copyServiceRecordFrom(HfgwUserContext userContext, String channelId, 
		String serviceRecordId, int serviceRecordVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingServiceRecord(userContext,channelId, serviceRecordId, serviceRecordVersion,tokensExpr);
		
		ServiceRecord serviceRecord = createIndexedServiceRecord(serviceRecordId, serviceRecordVersion);
		Channel channel = loadChannel(userContext, channelId, allTokens());
		synchronized(channel){ 
			//Will be good when the channel loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			channel.copyServiceRecordFrom( serviceRecord );		
			channel = saveChannel(userContext, channel, tokens().withServiceRecordList().done());
			
			userContext.getManagerGroup().getServiceRecordManager().onNewInstanceCreated(userContext, (ServiceRecord)channel.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,channel, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingServiceRecord(HfgwUserContext userContext, String channelId, String serviceRecordId, int serviceRecordVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfChannel(channelId);
		checkerOf(userContext).checkIdOfServiceRecord(serviceRecordId);
		checkerOf(userContext).checkVersionOfServiceRecord(serviceRecordVersion);
		

		if(ServiceRecord.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfServiceRecord(parseString(newValueExpr));
		}
		
		if(ServiceRecord.PAY_LOAD_PROPERTY.equals(property)){
			checkerOf(userContext).checkPayLoadOfServiceRecord(parseString(newValueExpr));
		}
		
		if(ServiceRecord.TRANSACTION_ID_PROPERTY.equals(property)){
			checkerOf(userContext).checkTransactionIdOfServiceRecord(parseString(newValueExpr));
		}
		
		if(ServiceRecord.BLOCK_ID_PROPERTY.equals(property)){
			checkerOf(userContext).checkBlockIdOfServiceRecord(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChannelManagerException.class);
	
	}
	
	public  Channel updateServiceRecord(HfgwUserContext userContext, String channelId, String serviceRecordId, int serviceRecordVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingServiceRecord(userContext, channelId, serviceRecordId, serviceRecordVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withServiceRecordList().searchServiceRecordListWith(ServiceRecord.ID_PROPERTY, "eq", serviceRecordId).done();
		
		
		
		Channel channel = loadChannel(userContext, channelId, loadTokens);
		
		synchronized(channel){ 
			//Will be good when the channel loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//channel.removeServiceRecord( serviceRecord );	
			//make changes to AcceleraterAccount.
			ServiceRecord serviceRecordIndex = createIndexedServiceRecord(serviceRecordId, serviceRecordVersion);
		
			ServiceRecord serviceRecord = channel.findTheServiceRecord(serviceRecordIndex);
			if(serviceRecord == null){
				throw new ChannelManagerException(serviceRecord+" is NOT FOUND" );
			}
			
			serviceRecord.changeProperty(property, newValueExpr);
			
			channel = saveChannel(userContext, channel, tokens().withServiceRecordList().done());
			return present(userContext,channel, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  Channel associateServiceRecordListToNewApplication(HfgwUserContext userContext, String channelId, String  serviceRecordIds[], String name, String mspid, String publicKey, String privateKey, String channelId, String networkId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchServiceRecordListWith(ServiceRecord.ID_PROPERTY, "oneof", this.joinArray("|", serviceRecordIds)).done();
		
		Channel channel = loadChannel(userContext, channelId, options);
		
		Application application = applicationManagerOf(userContext).createApplication(userContext,  name,  mspid,  publicKey,  privateKey, channelId, networkId);
		
		for(ServiceRecord serviceRecord: channel.getServiceRecordList()) {
			//TODO: need to check if already associated
			serviceRecord.updateApplication(application);
		}
		return this.internalSaveChannel(userContext, channel);
	}
	*/
	
	public  Channel associateServiceRecordListToApplication(HfgwUserContext userContext, String channelId, String  serviceRecordIds[], String applicationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchServiceRecordListWith(ServiceRecord.ID_PROPERTY, "oneof", this.joinArray("|", serviceRecordIds)).done();
		
		Channel channel = loadChannel(userContext, channelId, options);
		
		Application application = applicationManagerOf(userContext).loadApplication(userContext,applicationId,new String[]{"none"} );
		
		for(ServiceRecord serviceRecord: channel.getServiceRecordList()) {
			//TODO: need to check if already associated
			serviceRecord.updateApplication(application);
		}
		return this.internalSaveChannel(userContext, channel);
	}


	public void onNewInstanceCreated(HfgwUserContext userContext, Channel newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


