
package com.doublechaintech.hfgw.peerrole;

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

import com.doublechaintech.hfgw.channelpeerrole.ChannelPeerRole;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

import com.doublechaintech.hfgw.hyperledgernetwork.CandidateHyperledgerNetwork;

import com.doublechaintech.hfgw.peerrole.PeerRole;
import com.doublechaintech.hfgw.node.Node;
import com.doublechaintech.hfgw.channel.Channel;






public class PeerRoleManagerImpl extends CustomHfgwCheckerManager implements PeerRoleManager {
	
	private static final String SERVICE_TYPE = "PeerRole";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws PeerRoleManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new PeerRoleManagerException(message);

	}
	
	

 	protected PeerRole savePeerRole(HfgwUserContext userContext, PeerRole peerRole, String [] tokensExpr) throws Exception{	
 		//return getPeerRoleDAO().save(peerRole, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return savePeerRole(userContext, peerRole, tokens);
 	}
 	
 	protected PeerRole savePeerRoleDetail(HfgwUserContext userContext, PeerRole peerRole) throws Exception{	

 		
 		return savePeerRole(userContext, peerRole, allTokens());
 	}
 	
 	public PeerRole loadPeerRole(HfgwUserContext userContext, String peerRoleId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfPeerRole(peerRoleId);
		checkerOf(userContext).throwExceptionIfHasErrors( PeerRoleManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		PeerRole peerRole = loadPeerRole( userContext, peerRoleId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,peerRole, tokens);
 	}
 	
 	
 	 public PeerRole searchPeerRole(HfgwUserContext userContext, String peerRoleId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfPeerRole(peerRoleId);
		checkerOf(userContext).throwExceptionIfHasErrors( PeerRoleManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		PeerRole peerRole = loadPeerRole( userContext, peerRoleId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,peerRole, tokens);
 	}
 	
 	

 	protected PeerRole present(HfgwUserContext userContext, PeerRole peerRole, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,peerRole,tokens);
		
		
		PeerRole  peerRoleToPresent = peerRoleDaoOf(userContext).present(peerRole, tokens);
		
		List<BaseEntity> entityListToNaming = peerRoleToPresent.collectRefercencesFromLists();
		peerRoleDaoOf(userContext).alias(entityListToNaming);
		
		return  peerRoleToPresent;
		
		
	}
 
 	
 	
 	public PeerRole loadPeerRoleDetail(HfgwUserContext userContext, String peerRoleId) throws Exception{	
 		PeerRole peerRole = loadPeerRole( userContext, peerRoleId, allTokens());
 		return present(userContext,peerRole, allTokens());
		
 	}
 	
 	public Object view(HfgwUserContext userContext, String peerRoleId) throws Exception{	
 		PeerRole peerRole = loadPeerRole( userContext, peerRoleId, viewTokens());
 		return present(userContext,peerRole, allTokens());
		
 	}
 	protected PeerRole savePeerRole(HfgwUserContext userContext, PeerRole peerRole, Map<String,Object>tokens) throws Exception{	
 		return peerRoleDaoOf(userContext).save(peerRole, tokens);
 	}
 	protected PeerRole loadPeerRole(HfgwUserContext userContext, String peerRoleId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfPeerRole(peerRoleId);
		checkerOf(userContext).throwExceptionIfHasErrors( PeerRoleManagerException.class);

 
 		return peerRoleDaoOf(userContext).load(peerRoleId, tokens);
 	}

	
	

	public PeerRole loadPeerRoleWithCode(HfgwUserContext userContext, String code, Map<String,Object>tokens) throws Exception{	
 		return peerRoleDaoOf(userContext).loadByCode(code, tokens);
 	}

	 


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, PeerRole peerRole, Map<String, Object> tokens){
		super.addActions(userContext, peerRole, tokens);
		
		addAction(userContext, peerRole, tokens,"@create","createPeerRole","createPeerRole/","main","primary");
		addAction(userContext, peerRole, tokens,"@update","updatePeerRole","updatePeerRole/"+peerRole.getId()+"/","main","primary");
		addAction(userContext, peerRole, tokens,"@copy","clonePeerRole","clonePeerRole/"+peerRole.getId()+"/","main","primary");
		
		addAction(userContext, peerRole, tokens,"peer_role.transfer_to_network","transferToAnotherNetwork","transferToAnotherNetwork/"+peerRole.getId()+"/","main","primary");
		addAction(userContext, peerRole, tokens,"peer_role.addChannelPeerRole","addChannelPeerRole","addChannelPeerRole/"+peerRole.getId()+"/","channelPeerRoleList","primary");
		addAction(userContext, peerRole, tokens,"peer_role.removeChannelPeerRole","removeChannelPeerRole","removeChannelPeerRole/"+peerRole.getId()+"/","channelPeerRoleList","primary");
		addAction(userContext, peerRole, tokens,"peer_role.updateChannelPeerRole","updateChannelPeerRole","updateChannelPeerRole/"+peerRole.getId()+"/","channelPeerRoleList","primary");
		addAction(userContext, peerRole, tokens,"peer_role.copyChannelPeerRoleFrom","copyChannelPeerRoleFrom","copyChannelPeerRoleFrom/"+peerRole.getId()+"/","channelPeerRoleList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, PeerRole peerRole, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public PeerRole createPeerRole(HfgwUserContext userContext, String name,String code,String networkId) throws Exception
	//public PeerRole createPeerRole(HfgwUserContext userContext,String name, String code, String networkId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkNameOfPeerRole(name);
		checkerOf(userContext).checkCodeOfPeerRole(code);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PeerRoleManagerException.class);


		PeerRole peerRole=createNewPeerRole();	

		peerRole.setName(name);
		peerRole.setCode(code);
			
		HyperledgerNetwork network = loadHyperledgerNetwork(userContext, networkId,emptyOptions());
		peerRole.setNetwork(network);
		
		

		peerRole = savePeerRole(userContext, peerRole, emptyOptions());
		
		onNewInstanceCreated(userContext, peerRole);
		return peerRole;

		
	}
	protected PeerRole createNewPeerRole() 
	{
		
		return new PeerRole();		
	}
	
	protected void checkParamsForUpdatingPeerRole(HfgwUserContext userContext,String peerRoleId, int peerRoleVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfPeerRole(peerRoleId);
		checkerOf(userContext).checkVersionOfPeerRole( peerRoleVersion);
		

		if(PeerRole.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfPeerRole(parseString(newValueExpr));
		}
		if(PeerRole.CODE_PROPERTY.equals(property)){
			checkerOf(userContext).checkCodeOfPeerRole(parseString(newValueExpr));
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(PeerRoleManagerException.class);
	
		
	}
	
	
	
	public PeerRole clone(HfgwUserContext userContext, String fromPeerRoleId) throws Exception{
		
		return peerRoleDaoOf(userContext).clone(fromPeerRoleId, this.allTokens());
	}
	
	public PeerRole internalSavePeerRole(HfgwUserContext userContext, PeerRole peerRole) throws Exception 
	{
		return internalSavePeerRole(userContext, peerRole, allTokens());

	}
	public PeerRole internalSavePeerRole(HfgwUserContext userContext, PeerRole peerRole, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingPeerRole(userContext, peerRoleId, peerRoleVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(peerRole){ 
			//will be good when the peerRole loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PeerRole.
			if (peerRole.isChanged()){
			
			}
			peerRole = savePeerRole(userContext, peerRole, options);
			return peerRole;
			
		}

	}
	
	public PeerRole updatePeerRole(HfgwUserContext userContext,String peerRoleId, int peerRoleVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPeerRole(userContext, peerRoleId, peerRoleVersion, property, newValueExpr, tokensExpr);
		
		
		
		PeerRole peerRole = loadPeerRole(userContext, peerRoleId, allTokens());
		if(peerRole.getVersion() != peerRoleVersion){
			String message = "The target version("+peerRole.getVersion()+") is not equals to version("+peerRoleVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(peerRole){ 
			//will be good when the peerRole loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PeerRole.
			
			peerRole.changeProperty(property, newValueExpr);
			peerRole = savePeerRole(userContext, peerRole, tokens().done());
			return present(userContext,peerRole, mergedAllTokens(tokensExpr));
			//return savePeerRole(userContext, peerRole, tokens().done());
		}

	}
	
	public PeerRole updatePeerRoleProperty(HfgwUserContext userContext,String peerRoleId, int peerRoleVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPeerRole(userContext, peerRoleId, peerRoleVersion, property, newValueExpr, tokensExpr);
		
		PeerRole peerRole = loadPeerRole(userContext, peerRoleId, allTokens());
		if(peerRole.getVersion() != peerRoleVersion){
			String message = "The target version("+peerRole.getVersion()+") is not equals to version("+peerRoleVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(peerRole){ 
			//will be good when the peerRole loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PeerRole.
			
			peerRole.changeProperty(property, newValueExpr);
			
			peerRole = savePeerRole(userContext, peerRole, tokens().done());
			return present(userContext,peerRole, mergedAllTokens(tokensExpr));
			//return savePeerRole(userContext, peerRole, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected PeerRoleTokens tokens(){
		return PeerRoleTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return PeerRoleTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortChannelPeerRoleListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PeerRoleTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherNetwork(HfgwUserContext userContext, String peerRoleId, String anotherNetworkId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfPeerRole(peerRoleId);
 		checkerOf(userContext).checkIdOfHyperledgerNetwork(anotherNetworkId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(PeerRoleManagerException.class);
 		
 	}
 	public PeerRole transferToAnotherNetwork(HfgwUserContext userContext, String peerRoleId, String anotherNetworkId) throws Exception
 	{
 		checkParamsForTransferingAnotherNetwork(userContext, peerRoleId,anotherNetworkId);
 
		PeerRole peerRole = loadPeerRole(userContext, peerRoleId, allTokens());	
		synchronized(peerRole){
			//will be good when the peerRole loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			HyperledgerNetwork network = loadHyperledgerNetwork(userContext, anotherNetworkId, emptyOptions());		
			peerRole.updateNetwork(network);		
			peerRole = savePeerRole(userContext, peerRole, emptyOptions());
			
			return present(userContext,peerRole, allTokens());
			
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
		SmartList<HyperledgerNetwork> candidateList = hyperledgerNetworkDaoOf(userContext).requestCandidateHyperledgerNetworkForPeerRole(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(HfgwUserContext userContext, String peerRoleId, int peerRoleVersion) throws Exception {
		//deleteInternal(userContext, peerRoleId, peerRoleVersion);		
	}
	protected void deleteInternal(HfgwUserContext userContext,
			String peerRoleId, int peerRoleVersion) throws Exception{
			
		peerRoleDaoOf(userContext).delete(peerRoleId, peerRoleVersion);
	}
	
	public PeerRole forgetByAll(HfgwUserContext userContext, String peerRoleId, int peerRoleVersion) throws Exception {
		return forgetByAllInternal(userContext, peerRoleId, peerRoleVersion);		
	}
	protected PeerRole forgetByAllInternal(HfgwUserContext userContext,
			String peerRoleId, int peerRoleVersion) throws Exception{
			
		return peerRoleDaoOf(userContext).disconnectFromAll(peerRoleId, peerRoleVersion);
	}
	
	

	
	public int deleteAll(HfgwUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new PeerRoleManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HfgwUserContext userContext) throws Exception{
		return peerRoleDaoOf(userContext).deleteAll();
	}


	//disconnect PeerRole with channel in ChannelPeerRole
	protected PeerRole breakWithChannelPeerRoleByChannel(HfgwUserContext userContext, String peerRoleId, String channelId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			PeerRole peerRole = loadPeerRole(userContext, peerRoleId, allTokens());

			synchronized(peerRole){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				peerRoleDaoOf(userContext).planToRemoveChannelPeerRoleListWithChannel(peerRole, channelId, this.emptyOptions());

				peerRole = savePeerRole(userContext, peerRole, tokens().withChannelPeerRoleList().done());
				return peerRole;
			}
	}
	//disconnect PeerRole with node in ChannelPeerRole
	protected PeerRole breakWithChannelPeerRoleByNode(HfgwUserContext userContext, String peerRoleId, String nodeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			PeerRole peerRole = loadPeerRole(userContext, peerRoleId, allTokens());

			synchronized(peerRole){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				peerRoleDaoOf(userContext).planToRemoveChannelPeerRoleListWithNode(peerRole, nodeId, this.emptyOptions());

				peerRole = savePeerRole(userContext, peerRole, tokens().withChannelPeerRoleList().done());
				return peerRole;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingChannelPeerRole(HfgwUserContext userContext, String peerRoleId, String channelId, String nodeId,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfPeerRole(peerRoleId);

		
		checkerOf(userContext).checkChannelIdOfChannelPeerRole(channelId);
		
		checkerOf(userContext).checkNodeIdOfChannelPeerRole(nodeId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PeerRoleManagerException.class);

	
	}
	public  PeerRole addChannelPeerRole(HfgwUserContext userContext, String peerRoleId, String channelId, String nodeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingChannelPeerRole(userContext,peerRoleId,channelId, nodeId,tokensExpr);
		
		ChannelPeerRole channelPeerRole = createChannelPeerRole(userContext,channelId, nodeId);
		
		PeerRole peerRole = loadPeerRole(userContext, peerRoleId, allTokens());
		synchronized(peerRole){ 
			//Will be good when the peerRole loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			peerRole.addChannelPeerRole( channelPeerRole );		
			peerRole = savePeerRole(userContext, peerRole, tokens().withChannelPeerRoleList().done());
			
			userContext.getManagerGroup().getChannelPeerRoleManager().onNewInstanceCreated(userContext, channelPeerRole);
			return present(userContext,peerRole, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingChannelPeerRoleProperties(HfgwUserContext userContext, String peerRoleId,String id,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfPeerRole(peerRoleId);
		checkerOf(userContext).checkIdOfChannelPeerRole(id);
		

		checkerOf(userContext).throwExceptionIfHasErrors(PeerRoleManagerException.class);
		
	}
	public  PeerRole updateChannelPeerRoleProperties(HfgwUserContext userContext, String peerRoleId, String id, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingChannelPeerRoleProperties(userContext,peerRoleId,id,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withChannelPeerRoleListList()
				.searchChannelPeerRoleListWith(ChannelPeerRole.ID_PROPERTY, "is", id).done();
		
		PeerRole peerRoleToUpdate = loadPeerRole(userContext, peerRoleId, options);
		
		if(peerRoleToUpdate.getChannelPeerRoleList().isEmpty()){
			throw new PeerRoleManagerException("ChannelPeerRole is NOT FOUND with id: '"+id+"'");
		}
		
		ChannelPeerRole item = peerRoleToUpdate.getChannelPeerRoleList().first();
		

		
		//checkParamsForAddingChannelPeerRole(userContext,peerRoleId,name, code, used,tokensExpr);
		PeerRole peerRole = savePeerRole(userContext, peerRoleToUpdate, tokens().withChannelPeerRoleList().done());
		synchronized(peerRole){ 
			return present(userContext,peerRole, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ChannelPeerRole createChannelPeerRole(HfgwUserContext userContext, String channelId, String nodeId) throws Exception{

		ChannelPeerRole channelPeerRole = new ChannelPeerRole();
		
		
		Channel  channel = new Channel();
		channel.setId(channelId);		
		channelPeerRole.setChannel(channel);		
		Node  node = new Node();
		node.setId(nodeId);		
		channelPeerRole.setNode(node);
	
		
		return channelPeerRole;
	
		
	}
	
	protected ChannelPeerRole createIndexedChannelPeerRole(String id, int version){

		ChannelPeerRole channelPeerRole = new ChannelPeerRole();
		channelPeerRole.setId(id);
		channelPeerRole.setVersion(version);
		return channelPeerRole;			
		
	}
	
	protected void checkParamsForRemovingChannelPeerRoleList(HfgwUserContext userContext, String peerRoleId, 
			String channelPeerRoleIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfPeerRole(peerRoleId);
		for(String channelPeerRoleIdItem: channelPeerRoleIds){
			checkerOf(userContext).checkIdOfChannelPeerRole(channelPeerRoleIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(PeerRoleManagerException.class);
		
	}
	public  PeerRole removeChannelPeerRoleList(HfgwUserContext userContext, String peerRoleId, 
			String channelPeerRoleIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingChannelPeerRoleList(userContext, peerRoleId,  channelPeerRoleIds, tokensExpr);
			
			
			PeerRole peerRole = loadPeerRole(userContext, peerRoleId, allTokens());
			synchronized(peerRole){ 
				//Will be good when the peerRole loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				peerRoleDaoOf(userContext).planToRemoveChannelPeerRoleList(peerRole, channelPeerRoleIds, allTokens());
				peerRole = savePeerRole(userContext, peerRole, tokens().withChannelPeerRoleList().done());
				deleteRelationListInGraph(userContext, peerRole.getChannelPeerRoleList());
				return present(userContext,peerRole, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingChannelPeerRole(HfgwUserContext userContext, String peerRoleId, 
		String channelPeerRoleId, int channelPeerRoleVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPeerRole( peerRoleId);
		checkerOf(userContext).checkIdOfChannelPeerRole(channelPeerRoleId);
		checkerOf(userContext).checkVersionOfChannelPeerRole(channelPeerRoleVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PeerRoleManagerException.class);
	
	}
	public  PeerRole removeChannelPeerRole(HfgwUserContext userContext, String peerRoleId, 
		String channelPeerRoleId, int channelPeerRoleVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingChannelPeerRole(userContext,peerRoleId, channelPeerRoleId, channelPeerRoleVersion,tokensExpr);
		
		ChannelPeerRole channelPeerRole = createIndexedChannelPeerRole(channelPeerRoleId, channelPeerRoleVersion);
		PeerRole peerRole = loadPeerRole(userContext, peerRoleId, allTokens());
		synchronized(peerRole){ 
			//Will be good when the peerRole loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			peerRole.removeChannelPeerRole( channelPeerRole );		
			peerRole = savePeerRole(userContext, peerRole, tokens().withChannelPeerRoleList().done());
			deleteRelationInGraph(userContext, channelPeerRole);
			return present(userContext,peerRole, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingChannelPeerRole(HfgwUserContext userContext, String peerRoleId, 
		String channelPeerRoleId, int channelPeerRoleVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPeerRole( peerRoleId);
		checkerOf(userContext).checkIdOfChannelPeerRole(channelPeerRoleId);
		checkerOf(userContext).checkVersionOfChannelPeerRole(channelPeerRoleVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PeerRoleManagerException.class);
	
	}
	public  PeerRole copyChannelPeerRoleFrom(HfgwUserContext userContext, String peerRoleId, 
		String channelPeerRoleId, int channelPeerRoleVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingChannelPeerRole(userContext,peerRoleId, channelPeerRoleId, channelPeerRoleVersion,tokensExpr);
		
		ChannelPeerRole channelPeerRole = createIndexedChannelPeerRole(channelPeerRoleId, channelPeerRoleVersion);
		PeerRole peerRole = loadPeerRole(userContext, peerRoleId, allTokens());
		synchronized(peerRole){ 
			//Will be good when the peerRole loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			peerRole.copyChannelPeerRoleFrom( channelPeerRole );		
			peerRole = savePeerRole(userContext, peerRole, tokens().withChannelPeerRoleList().done());
			
			userContext.getManagerGroup().getChannelPeerRoleManager().onNewInstanceCreated(userContext, (ChannelPeerRole)peerRole.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,peerRole, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingChannelPeerRole(HfgwUserContext userContext, String peerRoleId, String channelPeerRoleId, int channelPeerRoleVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfPeerRole(peerRoleId);
		checkerOf(userContext).checkIdOfChannelPeerRole(channelPeerRoleId);
		checkerOf(userContext).checkVersionOfChannelPeerRole(channelPeerRoleVersion);
		

	
		checkerOf(userContext).throwExceptionIfHasErrors(PeerRoleManagerException.class);
	
	}
	
	public  PeerRole updateChannelPeerRole(HfgwUserContext userContext, String peerRoleId, String channelPeerRoleId, int channelPeerRoleVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingChannelPeerRole(userContext, peerRoleId, channelPeerRoleId, channelPeerRoleVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withChannelPeerRoleList().searchChannelPeerRoleListWith(ChannelPeerRole.ID_PROPERTY, "eq", channelPeerRoleId).done();
		
		
		
		PeerRole peerRole = loadPeerRole(userContext, peerRoleId, loadTokens);
		
		synchronized(peerRole){ 
			//Will be good when the peerRole loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//peerRole.removeChannelPeerRole( channelPeerRole );	
			//make changes to AcceleraterAccount.
			ChannelPeerRole channelPeerRoleIndex = createIndexedChannelPeerRole(channelPeerRoleId, channelPeerRoleVersion);
		
			ChannelPeerRole channelPeerRole = peerRole.findTheChannelPeerRole(channelPeerRoleIndex);
			if(channelPeerRole == null){
				throw new PeerRoleManagerException(channelPeerRole+" is NOT FOUND" );
			}
			
			channelPeerRole.changeProperty(property, newValueExpr);
			
			peerRole = savePeerRole(userContext, peerRole, tokens().withChannelPeerRoleList().done());
			return present(userContext,peerRole, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(HfgwUserContext userContext, PeerRole newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


