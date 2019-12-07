
package com.doublechaintech.hfgw.channelpeerrole;

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

import com.doublechaintech.hfgw.peerrole.PeerRole;
import com.doublechaintech.hfgw.node.Node;
import com.doublechaintech.hfgw.channel.Channel;

import com.doublechaintech.hfgw.peerrole.CandidatePeerRole;
import com.doublechaintech.hfgw.node.CandidateNode;
import com.doublechaintech.hfgw.channel.CandidateChannel;







public class ChannelPeerRoleManagerImpl extends CustomHfgwCheckerManager implements ChannelPeerRoleManager {
	
	private static final String SERVICE_TYPE = "ChannelPeerRole";
	@Override
	public ChannelPeerRoleDAO daoOf(HfgwUserContext userContext) {
		return channelPeerRoleDaoOf(userContext);
	}
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ChannelPeerRoleManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ChannelPeerRoleManagerException(message);

	}
	
	

 	protected ChannelPeerRole saveChannelPeerRole(HfgwUserContext userContext, ChannelPeerRole channelPeerRole, String [] tokensExpr) throws Exception{	
 		//return getChannelPeerRoleDAO().save(channelPeerRole, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveChannelPeerRole(userContext, channelPeerRole, tokens);
 	}
 	
 	protected ChannelPeerRole saveChannelPeerRoleDetail(HfgwUserContext userContext, ChannelPeerRole channelPeerRole) throws Exception{	

 		
 		return saveChannelPeerRole(userContext, channelPeerRole, allTokens());
 	}
 	
 	public ChannelPeerRole loadChannelPeerRole(HfgwUserContext userContext, String channelPeerRoleId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfChannelPeerRole(channelPeerRoleId);
		checkerOf(userContext).throwExceptionIfHasErrors( ChannelPeerRoleManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ChannelPeerRole channelPeerRole = loadChannelPeerRole( userContext, channelPeerRoleId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,channelPeerRole, tokens);
 	}
 	
 	
 	 public ChannelPeerRole searchChannelPeerRole(HfgwUserContext userContext, String channelPeerRoleId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfChannelPeerRole(channelPeerRoleId);
		checkerOf(userContext).throwExceptionIfHasErrors( ChannelPeerRoleManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ChannelPeerRole channelPeerRole = loadChannelPeerRole( userContext, channelPeerRoleId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,channelPeerRole, tokens);
 	}
 	
 	

 	protected ChannelPeerRole present(HfgwUserContext userContext, ChannelPeerRole channelPeerRole, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,channelPeerRole,tokens);
		
		
		ChannelPeerRole  channelPeerRoleToPresent = channelPeerRoleDaoOf(userContext).present(channelPeerRole, tokens);
		
		List<BaseEntity> entityListToNaming = channelPeerRoleToPresent.collectRefercencesFromLists();
		channelPeerRoleDaoOf(userContext).alias(entityListToNaming);
		
		return  channelPeerRoleToPresent;
		
		
	}
 
 	
 	
 	public ChannelPeerRole loadChannelPeerRoleDetail(HfgwUserContext userContext, String channelPeerRoleId) throws Exception{	
 		ChannelPeerRole channelPeerRole = loadChannelPeerRole( userContext, channelPeerRoleId, allTokens());
 		return present(userContext,channelPeerRole, allTokens());
		
 	}
 	
 	public Object view(HfgwUserContext userContext, String channelPeerRoleId) throws Exception{	
 		ChannelPeerRole channelPeerRole = loadChannelPeerRole( userContext, channelPeerRoleId, viewTokens());
 		return present(userContext,channelPeerRole, allTokens());
		
 	}
 	protected ChannelPeerRole saveChannelPeerRole(HfgwUserContext userContext, ChannelPeerRole channelPeerRole, Map<String,Object>tokens) throws Exception{	
 		return channelPeerRoleDaoOf(userContext).save(channelPeerRole, tokens);
 	}
 	protected ChannelPeerRole loadChannelPeerRole(HfgwUserContext userContext, String channelPeerRoleId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfChannelPeerRole(channelPeerRoleId);
		checkerOf(userContext).throwExceptionIfHasErrors( ChannelPeerRoleManagerException.class);

 
 		return channelPeerRoleDaoOf(userContext).load(channelPeerRoleId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, ChannelPeerRole channelPeerRole, Map<String, Object> tokens){
		super.addActions(userContext, channelPeerRole, tokens);
		
		addAction(userContext, channelPeerRole, tokens,"@create","createChannelPeerRole","createChannelPeerRole/","main","primary");
		addAction(userContext, channelPeerRole, tokens,"@update","updateChannelPeerRole","updateChannelPeerRole/"+channelPeerRole.getId()+"/","main","primary");
		addAction(userContext, channelPeerRole, tokens,"@copy","cloneChannelPeerRole","cloneChannelPeerRole/"+channelPeerRole.getId()+"/","main","primary");
		
		addAction(userContext, channelPeerRole, tokens,"channel_peer_role.transfer_to_channel","transferToAnotherChannel","transferToAnotherChannel/"+channelPeerRole.getId()+"/","main","primary");
		addAction(userContext, channelPeerRole, tokens,"channel_peer_role.transfer_to_node","transferToAnotherNode","transferToAnotherNode/"+channelPeerRole.getId()+"/","main","primary");
		addAction(userContext, channelPeerRole, tokens,"channel_peer_role.transfer_to_peer_role","transferToAnotherPeerRole","transferToAnotherPeerRole/"+channelPeerRole.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, ChannelPeerRole channelPeerRole, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public ChannelPeerRole createChannelPeerRole(HfgwUserContext userContext, String channelId,String nodeId,String peerRoleId) throws Exception
	//public ChannelPeerRole createChannelPeerRole(HfgwUserContext userContext,String channelId, String nodeId, String peerRoleId) throws Exception
	{
		
		

		

	
		checkerOf(userContext).throwExceptionIfHasErrors(ChannelPeerRoleManagerException.class);


		ChannelPeerRole channelPeerRole=createNewChannelPeerRole();	

			
		Channel channel = loadChannel(userContext, channelId,emptyOptions());
		channelPeerRole.setChannel(channel);
		
		
			
		Node node = loadNode(userContext, nodeId,emptyOptions());
		channelPeerRole.setNode(node);
		
		
			
		PeerRole peerRole = loadPeerRole(userContext, peerRoleId,emptyOptions());
		channelPeerRole.setPeerRole(peerRole);
		
		

		channelPeerRole = saveChannelPeerRole(userContext, channelPeerRole, emptyOptions());
		
		onNewInstanceCreated(userContext, channelPeerRole);
		return channelPeerRole;

		
	}
	protected ChannelPeerRole createNewChannelPeerRole() 
	{
		
		return new ChannelPeerRole();		
	}
	
	protected void checkParamsForUpdatingChannelPeerRole(HfgwUserContext userContext,String channelPeerRoleId, int channelPeerRoleVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfChannelPeerRole(channelPeerRoleId);
		checkerOf(userContext).checkVersionOfChannelPeerRole( channelPeerRoleVersion);
		
		

				

				

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChannelPeerRoleManagerException.class);
	
		
	}
	
	
	
	public ChannelPeerRole clone(HfgwUserContext userContext, String fromChannelPeerRoleId) throws Exception{
		
		return channelPeerRoleDaoOf(userContext).clone(fromChannelPeerRoleId, this.allTokens());
	}
	
	public ChannelPeerRole internalSaveChannelPeerRole(HfgwUserContext userContext, ChannelPeerRole channelPeerRole) throws Exception 
	{
		return internalSaveChannelPeerRole(userContext, channelPeerRole, allTokens());

	}
	public ChannelPeerRole internalSaveChannelPeerRole(HfgwUserContext userContext, ChannelPeerRole channelPeerRole, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingChannelPeerRole(userContext, channelPeerRoleId, channelPeerRoleVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(channelPeerRole){ 
			//will be good when the channelPeerRole loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ChannelPeerRole.
			if (channelPeerRole.isChanged()){
			
			}
			channelPeerRole = saveChannelPeerRole(userContext, channelPeerRole, options);
			return channelPeerRole;
			
		}

	}
	
	public ChannelPeerRole updateChannelPeerRole(HfgwUserContext userContext,String channelPeerRoleId, int channelPeerRoleVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingChannelPeerRole(userContext, channelPeerRoleId, channelPeerRoleVersion, property, newValueExpr, tokensExpr);
		
		
		
		ChannelPeerRole channelPeerRole = loadChannelPeerRole(userContext, channelPeerRoleId, allTokens());
		if(channelPeerRole.getVersion() != channelPeerRoleVersion){
			String message = "The target version("+channelPeerRole.getVersion()+") is not equals to version("+channelPeerRoleVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(channelPeerRole){ 
			//will be good when the channelPeerRole loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ChannelPeerRole.
			
			channelPeerRole.changeProperty(property, newValueExpr);
			channelPeerRole = saveChannelPeerRole(userContext, channelPeerRole, tokens().done());
			return present(userContext,channelPeerRole, mergedAllTokens(tokensExpr));
			//return saveChannelPeerRole(userContext, channelPeerRole, tokens().done());
		}

	}
	
	public ChannelPeerRole updateChannelPeerRoleProperty(HfgwUserContext userContext,String channelPeerRoleId, int channelPeerRoleVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingChannelPeerRole(userContext, channelPeerRoleId, channelPeerRoleVersion, property, newValueExpr, tokensExpr);
		
		ChannelPeerRole channelPeerRole = loadChannelPeerRole(userContext, channelPeerRoleId, allTokens());
		if(channelPeerRole.getVersion() != channelPeerRoleVersion){
			String message = "The target version("+channelPeerRole.getVersion()+") is not equals to version("+channelPeerRoleVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(channelPeerRole){ 
			//will be good when the channelPeerRole loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ChannelPeerRole.
			
			channelPeerRole.changeProperty(property, newValueExpr);
			
			channelPeerRole = saveChannelPeerRole(userContext, channelPeerRole, tokens().done());
			return present(userContext,channelPeerRole, mergedAllTokens(tokensExpr));
			//return saveChannelPeerRole(userContext, channelPeerRole, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ChannelPeerRoleTokens tokens(){
		return ChannelPeerRoleTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ChannelPeerRoleTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ChannelPeerRoleTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherChannel(HfgwUserContext userContext, String channelPeerRoleId, String anotherChannelId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfChannelPeerRole(channelPeerRoleId);
 		checkerOf(userContext).checkIdOfChannel(anotherChannelId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ChannelPeerRoleManagerException.class);
 		
 	}
 	public ChannelPeerRole transferToAnotherChannel(HfgwUserContext userContext, String channelPeerRoleId, String anotherChannelId) throws Exception
 	{
 		checkParamsForTransferingAnotherChannel(userContext, channelPeerRoleId,anotherChannelId);
 
		ChannelPeerRole channelPeerRole = loadChannelPeerRole(userContext, channelPeerRoleId, allTokens());	
		synchronized(channelPeerRole){
			//will be good when the channelPeerRole loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Channel channel = loadChannel(userContext, anotherChannelId, emptyOptions());		
			channelPeerRole.updateChannel(channel);		
			channelPeerRole = saveChannelPeerRole(userContext, channelPeerRole, emptyOptions());
			
			return present(userContext,channelPeerRole, allTokens());
			
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
		SmartList<Channel> candidateList = channelDaoOf(userContext).requestCandidateChannelForChannelPeerRole(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherNode(HfgwUserContext userContext, String channelPeerRoleId, String anotherNodeId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfChannelPeerRole(channelPeerRoleId);
 		checkerOf(userContext).checkIdOfNode(anotherNodeId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ChannelPeerRoleManagerException.class);
 		
 	}
 	public ChannelPeerRole transferToAnotherNode(HfgwUserContext userContext, String channelPeerRoleId, String anotherNodeId) throws Exception
 	{
 		checkParamsForTransferingAnotherNode(userContext, channelPeerRoleId,anotherNodeId);
 
		ChannelPeerRole channelPeerRole = loadChannelPeerRole(userContext, channelPeerRoleId, allTokens());	
		synchronized(channelPeerRole){
			//will be good when the channelPeerRole loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Node node = loadNode(userContext, anotherNodeId, emptyOptions());		
			channelPeerRole.updateNode(node);		
			channelPeerRole = saveChannelPeerRole(userContext, channelPeerRole, emptyOptions());
			
			return present(userContext,channelPeerRole, allTokens());
			
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
		SmartList<Node> candidateList = nodeDaoOf(userContext).requestCandidateNodeForChannelPeerRole(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherPeerRole(HfgwUserContext userContext, String channelPeerRoleId, String anotherPeerRoleId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfChannelPeerRole(channelPeerRoleId);
 		checkerOf(userContext).checkIdOfPeerRole(anotherPeerRoleId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ChannelPeerRoleManagerException.class);
 		
 	}
 	public ChannelPeerRole transferToAnotherPeerRole(HfgwUserContext userContext, String channelPeerRoleId, String anotherPeerRoleId) throws Exception
 	{
 		checkParamsForTransferingAnotherPeerRole(userContext, channelPeerRoleId,anotherPeerRoleId);
 
		ChannelPeerRole channelPeerRole = loadChannelPeerRole(userContext, channelPeerRoleId, allTokens());	
		synchronized(channelPeerRole){
			//will be good when the channelPeerRole loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			PeerRole peerRole = loadPeerRole(userContext, anotherPeerRoleId, emptyOptions());		
			channelPeerRole.updatePeerRole(peerRole);		
			channelPeerRole = saveChannelPeerRole(userContext, channelPeerRole, emptyOptions());
			
			return present(userContext,channelPeerRole, allTokens());
			
		}

 	}
 	
	

	protected void checkParamsForTransferingAnotherPeerRoleWithCode(HfgwUserContext userContext, String channelPeerRoleId, String anotherCode) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfChannelPeerRole(channelPeerRoleId);
 		checkerOf(userContext).checkCodeOfPeerRole( anotherCode);
 		checkerOf(userContext).throwExceptionIfHasErrors(ChannelPeerRoleManagerException.class);
 		
 	}

 	public ChannelPeerRole transferToAnotherPeerRoleWithCode(HfgwUserContext userContext, String channelPeerRoleId, String anotherCode) throws Exception
 	{
 		checkParamsForTransferingAnotherPeerRoleWithCode(userContext, channelPeerRoleId,anotherCode);
 		ChannelPeerRole channelPeerRole = loadChannelPeerRole(userContext, channelPeerRoleId, allTokens());	
		synchronized(channelPeerRole){
			//will be good when the channelPeerRole loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			PeerRole peerRole = loadPeerRoleWithCode(userContext, anotherCode, emptyOptions());		
			channelPeerRole.updatePeerRole(peerRole);		
			channelPeerRole = saveChannelPeerRole(userContext, channelPeerRole, emptyOptions());
			
			return present(userContext,channelPeerRole, allTokens());
			
		}
 	}	

	  	
 	
 	
	public CandidatePeerRole requestCandidatePeerRole(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePeerRole result = new CandidatePeerRole();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<PeerRole> candidateList = peerRoleDaoOf(userContext).requestCandidatePeerRoleForChannelPeerRole(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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
 	
 	
 	
	
	 	
 	protected Node loadNode(HfgwUserContext userContext, String newNodeId, Map<String,Object> options) throws Exception
 	{
		
 		return nodeDaoOf(userContext).load(newNodeId, options);
 	}
 	
 	
 	
	
	 	
 	protected PeerRole loadPeerRole(HfgwUserContext userContext, String newPeerRoleId, Map<String,Object> options) throws Exception
 	{
		
 		return peerRoleDaoOf(userContext).load(newPeerRoleId, options);
 	}
 	
 	protected PeerRole loadPeerRoleWithCode(HfgwUserContext userContext, String newCode, Map<String,Object> options) throws Exception
 	{
		
 		return peerRoleDaoOf(userContext).loadByCode(newCode, options);
 	}
 	
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(HfgwUserContext userContext, String channelPeerRoleId, int channelPeerRoleVersion) throws Exception {
		//deleteInternal(userContext, channelPeerRoleId, channelPeerRoleVersion);		
	}
	protected void deleteInternal(HfgwUserContext userContext,
			String channelPeerRoleId, int channelPeerRoleVersion) throws Exception{
			
		channelPeerRoleDaoOf(userContext).delete(channelPeerRoleId, channelPeerRoleVersion);
	}
	
	public ChannelPeerRole forgetByAll(HfgwUserContext userContext, String channelPeerRoleId, int channelPeerRoleVersion) throws Exception {
		return forgetByAllInternal(userContext, channelPeerRoleId, channelPeerRoleVersion);		
	}
	protected ChannelPeerRole forgetByAllInternal(HfgwUserContext userContext,
			String channelPeerRoleId, int channelPeerRoleVersion) throws Exception{
			
		return channelPeerRoleDaoOf(userContext).disconnectFromAll(channelPeerRoleId, channelPeerRoleVersion);
	}
	
	

	
	public int deleteAll(HfgwUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ChannelPeerRoleManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HfgwUserContext userContext) throws Exception{
		return channelPeerRoleDaoOf(userContext).deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(HfgwUserContext userContext, ChannelPeerRole newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


