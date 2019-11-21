
package com.doublechaintech.hfgw.hyperledgernetwork;

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

import com.doublechaintech.hfgw.changerequest.ChangeRequest;
import com.doublechaintech.hfgw.organization.Organization;
import com.doublechaintech.hfgw.nodetype.NodeType;
import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.application.Application;
import com.doublechaintech.hfgw.changerequesttype.ChangeRequestType;
import com.doublechaintech.hfgw.servicerecord.ServiceRecord;


import com.doublechaintech.hfgw.chaincode.ChainCode;
import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.application.Application;
import com.doublechaintech.hfgw.changerequesttype.ChangeRequestType;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;






public class HyperledgerNetworkManagerImpl extends CustomHfgwCheckerManager implements HyperledgerNetworkManager {
	
	private static final String SERVICE_TYPE = "HyperledgerNetwork";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws HyperledgerNetworkManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new HyperledgerNetworkManagerException(message);

	}
	
	

 	protected HyperledgerNetwork saveHyperledgerNetwork(HfgwUserContext userContext, HyperledgerNetwork hyperledgerNetwork, String [] tokensExpr) throws Exception{	
 		//return getHyperledgerNetworkDAO().save(hyperledgerNetwork, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens);
 	}
 	
 	protected HyperledgerNetwork saveHyperledgerNetworkDetail(HfgwUserContext userContext, HyperledgerNetwork hyperledgerNetwork) throws Exception{	

 		
 		return saveHyperledgerNetwork(userContext, hyperledgerNetwork, allTokens());
 	}
 	
 	public HyperledgerNetwork loadHyperledgerNetwork(HfgwUserContext userContext, String hyperledgerNetworkId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);
		checkerOf(userContext).throwExceptionIfHasErrors( HyperledgerNetworkManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork( userContext, hyperledgerNetworkId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,hyperledgerNetwork, tokens);
 	}
 	
 	
 	 public HyperledgerNetwork searchHyperledgerNetwork(HfgwUserContext userContext, String hyperledgerNetworkId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);
		checkerOf(userContext).throwExceptionIfHasErrors( HyperledgerNetworkManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork( userContext, hyperledgerNetworkId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,hyperledgerNetwork, tokens);
 	}
 	
 	

 	protected HyperledgerNetwork present(HfgwUserContext userContext, HyperledgerNetwork hyperledgerNetwork, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,hyperledgerNetwork,tokens);
		
		
		HyperledgerNetwork  hyperledgerNetworkToPresent = hyperledgerNetworkDaoOf(userContext).present(hyperledgerNetwork, tokens);
		
		List<BaseEntity> entityListToNaming = hyperledgerNetworkToPresent.collectRefercencesFromLists();
		hyperledgerNetworkDaoOf(userContext).alias(entityListToNaming);
		
		return  hyperledgerNetworkToPresent;
		
		
	}
 
 	
 	
 	public HyperledgerNetwork loadHyperledgerNetworkDetail(HfgwUserContext userContext, String hyperledgerNetworkId) throws Exception{	
 		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork( userContext, hyperledgerNetworkId, allTokens());
 		return present(userContext,hyperledgerNetwork, allTokens());
		
 	}
 	
 	public Object view(HfgwUserContext userContext, String hyperledgerNetworkId) throws Exception{	
 		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork( userContext, hyperledgerNetworkId, viewTokens());
 		return present(userContext,hyperledgerNetwork, allTokens());
		
 	}
 	protected HyperledgerNetwork saveHyperledgerNetwork(HfgwUserContext userContext, HyperledgerNetwork hyperledgerNetwork, Map<String,Object>tokens) throws Exception{	
 		return hyperledgerNetworkDaoOf(userContext).save(hyperledgerNetwork, tokens);
 	}
 	protected HyperledgerNetwork loadHyperledgerNetwork(HfgwUserContext userContext, String hyperledgerNetworkId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);
		checkerOf(userContext).throwExceptionIfHasErrors( HyperledgerNetworkManagerException.class);

 
 		return hyperledgerNetworkDaoOf(userContext).load(hyperledgerNetworkId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, HyperledgerNetwork hyperledgerNetwork, Map<String, Object> tokens){
		super.addActions(userContext, hyperledgerNetwork, tokens);
		
		addAction(userContext, hyperledgerNetwork, tokens,"@create","createHyperledgerNetwork","createHyperledgerNetwork/","main","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"@update","updateHyperledgerNetwork","updateHyperledgerNetwork/"+hyperledgerNetwork.getId()+"/","main","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"@copy","cloneHyperledgerNetwork","cloneHyperledgerNetwork/"+hyperledgerNetwork.getId()+"/","main","primary");
		
		addAction(userContext, hyperledgerNetwork, tokens,"hyperledger_network.addOrganization","addOrganization","addOrganization/"+hyperledgerNetwork.getId()+"/","organizationList","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"hyperledger_network.removeOrganization","removeOrganization","removeOrganization/"+hyperledgerNetwork.getId()+"/","organizationList","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"hyperledger_network.updateOrganization","updateOrganization","updateOrganization/"+hyperledgerNetwork.getId()+"/","organizationList","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"hyperledger_network.copyOrganizationFrom","copyOrganizationFrom","copyOrganizationFrom/"+hyperledgerNetwork.getId()+"/","organizationList","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"hyperledger_network.addNodeType","addNodeType","addNodeType/"+hyperledgerNetwork.getId()+"/","nodeTypeList","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"hyperledger_network.removeNodeType","removeNodeType","removeNodeType/"+hyperledgerNetwork.getId()+"/","nodeTypeList","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"hyperledger_network.updateNodeType","updateNodeType","updateNodeType/"+hyperledgerNetwork.getId()+"/","nodeTypeList","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"hyperledger_network.copyNodeTypeFrom","copyNodeTypeFrom","copyNodeTypeFrom/"+hyperledgerNetwork.getId()+"/","nodeTypeList","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"hyperledger_network.addChannel","addChannel","addChannel/"+hyperledgerNetwork.getId()+"/","channelList","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"hyperledger_network.removeChannel","removeChannel","removeChannel/"+hyperledgerNetwork.getId()+"/","channelList","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"hyperledger_network.updateChannel","updateChannel","updateChannel/"+hyperledgerNetwork.getId()+"/","channelList","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"hyperledger_network.copyChannelFrom","copyChannelFrom","copyChannelFrom/"+hyperledgerNetwork.getId()+"/","channelList","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"hyperledger_network.addApplication","addApplication","addApplication/"+hyperledgerNetwork.getId()+"/","applicationList","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"hyperledger_network.removeApplication","removeApplication","removeApplication/"+hyperledgerNetwork.getId()+"/","applicationList","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"hyperledger_network.updateApplication","updateApplication","updateApplication/"+hyperledgerNetwork.getId()+"/","applicationList","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"hyperledger_network.copyApplicationFrom","copyApplicationFrom","copyApplicationFrom/"+hyperledgerNetwork.getId()+"/","applicationList","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"hyperledger_network.addServiceRecord","addServiceRecord","addServiceRecord/"+hyperledgerNetwork.getId()+"/","serviceRecordList","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"hyperledger_network.removeServiceRecord","removeServiceRecord","removeServiceRecord/"+hyperledgerNetwork.getId()+"/","serviceRecordList","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"hyperledger_network.updateServiceRecord","updateServiceRecord","updateServiceRecord/"+hyperledgerNetwork.getId()+"/","serviceRecordList","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"hyperledger_network.copyServiceRecordFrom","copyServiceRecordFrom","copyServiceRecordFrom/"+hyperledgerNetwork.getId()+"/","serviceRecordList","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"hyperledger_network.addChangeRequestType","addChangeRequestType","addChangeRequestType/"+hyperledgerNetwork.getId()+"/","changeRequestTypeList","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"hyperledger_network.removeChangeRequestType","removeChangeRequestType","removeChangeRequestType/"+hyperledgerNetwork.getId()+"/","changeRequestTypeList","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"hyperledger_network.updateChangeRequestType","updateChangeRequestType","updateChangeRequestType/"+hyperledgerNetwork.getId()+"/","changeRequestTypeList","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"hyperledger_network.copyChangeRequestTypeFrom","copyChangeRequestTypeFrom","copyChangeRequestTypeFrom/"+hyperledgerNetwork.getId()+"/","changeRequestTypeList","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"hyperledger_network.addChangeRequest","addChangeRequest","addChangeRequest/"+hyperledgerNetwork.getId()+"/","changeRequestList","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"hyperledger_network.removeChangeRequest","removeChangeRequest","removeChangeRequest/"+hyperledgerNetwork.getId()+"/","changeRequestList","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"hyperledger_network.updateChangeRequest","updateChangeRequest","updateChangeRequest/"+hyperledgerNetwork.getId()+"/","changeRequestList","primary");
		addAction(userContext, hyperledgerNetwork, tokens,"hyperledger_network.copyChangeRequestFrom","copyChangeRequestFrom","copyChangeRequestFrom/"+hyperledgerNetwork.getId()+"/","changeRequestList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(HfgwUserContext userContext, HyperledgerNetwork hyperledgerNetwork, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public HyperledgerNetwork createHyperledgerNetwork(HfgwUserContext userContext, String name,String description) throws Exception
	//public HyperledgerNetwork createHyperledgerNetwork(HfgwUserContext userContext,String name, String description) throws Exception
	{
		
		

		

		checkerOf(userContext).checkNameOfHyperledgerNetwork(name);
		checkerOf(userContext).checkDescriptionOfHyperledgerNetwork(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);


		HyperledgerNetwork hyperledgerNetwork=createNewHyperledgerNetwork();	

		hyperledgerNetwork.setName(name);
		hyperledgerNetwork.setDescription(description);

		hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, emptyOptions());
		
		onNewInstanceCreated(userContext, hyperledgerNetwork);
		return hyperledgerNetwork;

		
	}
	protected HyperledgerNetwork createNewHyperledgerNetwork() 
	{
		
		return new HyperledgerNetwork();		
	}
	
	protected void checkParamsForUpdatingHyperledgerNetwork(HfgwUserContext userContext,String hyperledgerNetworkId, int hyperledgerNetworkVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);
		checkerOf(userContext).checkVersionOfHyperledgerNetwork( hyperledgerNetworkVersion);
		

		if(HyperledgerNetwork.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfHyperledgerNetwork(parseString(newValueExpr));
		}
		if(HyperledgerNetwork.DESCRIPTION_PROPERTY.equals(property)){
			checkerOf(userContext).checkDescriptionOfHyperledgerNetwork(parseString(newValueExpr));
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
	
		
	}
	
	
	
	public HyperledgerNetwork clone(HfgwUserContext userContext, String fromHyperledgerNetworkId) throws Exception{
		
		return hyperledgerNetworkDaoOf(userContext).clone(fromHyperledgerNetworkId, this.allTokens());
	}
	
	public HyperledgerNetwork internalSaveHyperledgerNetwork(HfgwUserContext userContext, HyperledgerNetwork hyperledgerNetwork) throws Exception 
	{
		return internalSaveHyperledgerNetwork(userContext, hyperledgerNetwork, allTokens());

	}
	public HyperledgerNetwork internalSaveHyperledgerNetwork(HfgwUserContext userContext, HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingHyperledgerNetwork(userContext, hyperledgerNetworkId, hyperledgerNetworkVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(hyperledgerNetwork){ 
			//will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to HyperledgerNetwork.
			if (hyperledgerNetwork.isChanged()){
			
			}
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, options);
			return hyperledgerNetwork;
			
		}

	}
	
	public HyperledgerNetwork updateHyperledgerNetwork(HfgwUserContext userContext,String hyperledgerNetworkId, int hyperledgerNetworkVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingHyperledgerNetwork(userContext, hyperledgerNetworkId, hyperledgerNetworkVersion, property, newValueExpr, tokensExpr);
		
		
		
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
		if(hyperledgerNetwork.getVersion() != hyperledgerNetworkVersion){
			String message = "The target version("+hyperledgerNetwork.getVersion()+") is not equals to version("+hyperledgerNetworkVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(hyperledgerNetwork){ 
			//will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to HyperledgerNetwork.
			
			hyperledgerNetwork.changeProperty(property, newValueExpr);
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().done());
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
			//return saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().done());
		}

	}
	
	public HyperledgerNetwork updateHyperledgerNetworkProperty(HfgwUserContext userContext,String hyperledgerNetworkId, int hyperledgerNetworkVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingHyperledgerNetwork(userContext, hyperledgerNetworkId, hyperledgerNetworkVersion, property, newValueExpr, tokensExpr);
		
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
		if(hyperledgerNetwork.getVersion() != hyperledgerNetworkVersion){
			String message = "The target version("+hyperledgerNetwork.getVersion()+") is not equals to version("+hyperledgerNetworkVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(hyperledgerNetwork){ 
			//will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to HyperledgerNetwork.
			
			hyperledgerNetwork.changeProperty(property, newValueExpr);
			
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().done());
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
			//return saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected HyperledgerNetworkTokens tokens(){
		return HyperledgerNetworkTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return HyperledgerNetworkTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortOrganizationListWith("id","desc")
		.sortNodeTypeListWith("id","desc")
		.sortChannelListWith("id","desc")
		.sortApplicationListWith("id","desc")
		.sortServiceRecordListWith("id","desc")
		.sortChangeRequestTypeListWith("id","desc")
		.sortChangeRequestListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return HyperledgerNetworkTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(HfgwUserContext userContext, String hyperledgerNetworkId, int hyperledgerNetworkVersion) throws Exception {
		//deleteInternal(userContext, hyperledgerNetworkId, hyperledgerNetworkVersion);		
	}
	protected void deleteInternal(HfgwUserContext userContext,
			String hyperledgerNetworkId, int hyperledgerNetworkVersion) throws Exception{
			
		hyperledgerNetworkDaoOf(userContext).delete(hyperledgerNetworkId, hyperledgerNetworkVersion);
	}
	
	public HyperledgerNetwork forgetByAll(HfgwUserContext userContext, String hyperledgerNetworkId, int hyperledgerNetworkVersion) throws Exception {
		return forgetByAllInternal(userContext, hyperledgerNetworkId, hyperledgerNetworkVersion);		
	}
	protected HyperledgerNetwork forgetByAllInternal(HfgwUserContext userContext,
			String hyperledgerNetworkId, int hyperledgerNetworkVersion) throws Exception{
			
		return hyperledgerNetworkDaoOf(userContext).disconnectFromAll(hyperledgerNetworkId, hyperledgerNetworkVersion);
	}
	
	

	
	public int deleteAll(HfgwUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new HyperledgerNetworkManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(HfgwUserContext userContext) throws Exception{
		return hyperledgerNetworkDaoOf(userContext).deleteAll();
	}


	//disconnect HyperledgerNetwork with channel in Application
	protected HyperledgerNetwork breakWithApplicationByChannel(HfgwUserContext userContext, String hyperledgerNetworkId, String channelId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());

			synchronized(hyperledgerNetwork){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				hyperledgerNetworkDaoOf(userContext).planToRemoveApplicationListWithChannel(hyperledgerNetwork, channelId, this.emptyOptions());

				hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withApplicationList().done());
				return hyperledgerNetwork;
			}
	}
	//disconnect HyperledgerNetwork with channel in ServiceRecord
	protected HyperledgerNetwork breakWithServiceRecordByChannel(HfgwUserContext userContext, String hyperledgerNetworkId, String channelId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());

			synchronized(hyperledgerNetwork){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				hyperledgerNetworkDaoOf(userContext).planToRemoveServiceRecordListWithChannel(hyperledgerNetwork, channelId, this.emptyOptions());

				hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withServiceRecordList().done());
				return hyperledgerNetwork;
			}
	}
	//disconnect HyperledgerNetwork with chain_code in ServiceRecord
	protected HyperledgerNetwork breakWithServiceRecordByChainCode(HfgwUserContext userContext, String hyperledgerNetworkId, String chainCodeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());

			synchronized(hyperledgerNetwork){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				hyperledgerNetworkDaoOf(userContext).planToRemoveServiceRecordListWithChainCode(hyperledgerNetwork, chainCodeId, this.emptyOptions());

				hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withServiceRecordList().done());
				return hyperledgerNetwork;
			}
	}
	//disconnect HyperledgerNetwork with transaction_id in ServiceRecord
	protected HyperledgerNetwork breakWithServiceRecordByTransactionId(HfgwUserContext userContext, String hyperledgerNetworkId, String transactionIdId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());

			synchronized(hyperledgerNetwork){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				hyperledgerNetworkDaoOf(userContext).planToRemoveServiceRecordListWithTransactionId(hyperledgerNetwork, transactionIdId, this.emptyOptions());

				hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withServiceRecordList().done());
				return hyperledgerNetwork;
			}
	}
	//disconnect HyperledgerNetwork with block_id in ServiceRecord
	protected HyperledgerNetwork breakWithServiceRecordByBlockId(HfgwUserContext userContext, String hyperledgerNetworkId, String blockIdId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());

			synchronized(hyperledgerNetwork){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				hyperledgerNetworkDaoOf(userContext).planToRemoveServiceRecordListWithBlockId(hyperledgerNetwork, blockIdId, this.emptyOptions());

				hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withServiceRecordList().done());
				return hyperledgerNetwork;
			}
	}
	//disconnect HyperledgerNetwork with request_type in ChangeRequest
	protected HyperledgerNetwork breakWithChangeRequestByRequestType(HfgwUserContext userContext, String hyperledgerNetworkId, String requestTypeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());

			synchronized(hyperledgerNetwork){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				hyperledgerNetworkDaoOf(userContext).planToRemoveChangeRequestListWithRequestType(hyperledgerNetwork, requestTypeId, this.emptyOptions());

				hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withChangeRequestList().done());
				return hyperledgerNetwork;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingOrganization(HfgwUserContext userContext, String hyperledgerNetworkId, String name, String mspid,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);

		
		checkerOf(userContext).checkNameOfOrganization(name);
		
		checkerOf(userContext).checkMspidOfOrganization(mspid);
	
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);

	
	}
	public  HyperledgerNetwork addOrganization(HfgwUserContext userContext, String hyperledgerNetworkId, String name, String mspid, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingOrganization(userContext,hyperledgerNetworkId,name, mspid,tokensExpr);
		
		Organization organization = createOrganization(userContext,name, mspid);
		
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
		synchronized(hyperledgerNetwork){ 
			//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hyperledgerNetwork.addOrganization( organization );		
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withOrganizationList().done());
			
			userContext.getManagerGroup().getOrganizationManager().onNewInstanceCreated(userContext, organization);
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingOrganizationProperties(HfgwUserContext userContext, String hyperledgerNetworkId,String id,String name,String mspid,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);
		checkerOf(userContext).checkIdOfOrganization(id);
		
		checkerOf(userContext).checkNameOfOrganization( name);
		checkerOf(userContext).checkMspidOfOrganization( mspid);

		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
		
	}
	public  HyperledgerNetwork updateOrganizationProperties(HfgwUserContext userContext, String hyperledgerNetworkId, String id,String name,String mspid, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingOrganizationProperties(userContext,hyperledgerNetworkId,id,name,mspid,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withOrganizationListList()
				.searchOrganizationListWith(Organization.ID_PROPERTY, "is", id).done();
		
		HyperledgerNetwork hyperledgerNetworkToUpdate = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, options);
		
		if(hyperledgerNetworkToUpdate.getOrganizationList().isEmpty()){
			throw new HyperledgerNetworkManagerException("Organization is NOT FOUND with id: '"+id+"'");
		}
		
		Organization item = hyperledgerNetworkToUpdate.getOrganizationList().first();
		
		item.updateName( name );
		item.updateMspid( mspid );

		
		//checkParamsForAddingOrganization(userContext,hyperledgerNetworkId,name, code, used,tokensExpr);
		HyperledgerNetwork hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetworkToUpdate, tokens().withOrganizationList().done());
		synchronized(hyperledgerNetwork){ 
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Organization createOrganization(HfgwUserContext userContext, String name, String mspid) throws Exception{

		Organization organization = new Organization();
		
		
		organization.setName(name);		
		organization.setMspid(mspid);
	
		
		return organization;
	
		
	}
	
	protected Organization createIndexedOrganization(String id, int version){

		Organization organization = new Organization();
		organization.setId(id);
		organization.setVersion(version);
		return organization;			
		
	}
	
	protected void checkParamsForRemovingOrganizationList(HfgwUserContext userContext, String hyperledgerNetworkId, 
			String organizationIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);
		for(String organizationIdItem: organizationIds){
			checkerOf(userContext).checkIdOfOrganization(organizationIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
		
	}
	public  HyperledgerNetwork removeOrganizationList(HfgwUserContext userContext, String hyperledgerNetworkId, 
			String organizationIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingOrganizationList(userContext, hyperledgerNetworkId,  organizationIds, tokensExpr);
			
			
			HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
			synchronized(hyperledgerNetwork){ 
				//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				hyperledgerNetworkDaoOf(userContext).planToRemoveOrganizationList(hyperledgerNetwork, organizationIds, allTokens());
				hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withOrganizationList().done());
				deleteRelationListInGraph(userContext, hyperledgerNetwork.getOrganizationList());
				return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingOrganization(HfgwUserContext userContext, String hyperledgerNetworkId, 
		String organizationId, int organizationVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork( hyperledgerNetworkId);
		checkerOf(userContext).checkIdOfOrganization(organizationId);
		checkerOf(userContext).checkVersionOfOrganization(organizationVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
	
	}
	public  HyperledgerNetwork removeOrganization(HfgwUserContext userContext, String hyperledgerNetworkId, 
		String organizationId, int organizationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingOrganization(userContext,hyperledgerNetworkId, organizationId, organizationVersion,tokensExpr);
		
		Organization organization = createIndexedOrganization(organizationId, organizationVersion);
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
		synchronized(hyperledgerNetwork){ 
			//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hyperledgerNetwork.removeOrganization( organization );		
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withOrganizationList().done());
			deleteRelationInGraph(userContext, organization);
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingOrganization(HfgwUserContext userContext, String hyperledgerNetworkId, 
		String organizationId, int organizationVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork( hyperledgerNetworkId);
		checkerOf(userContext).checkIdOfOrganization(organizationId);
		checkerOf(userContext).checkVersionOfOrganization(organizationVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
	
	}
	public  HyperledgerNetwork copyOrganizationFrom(HfgwUserContext userContext, String hyperledgerNetworkId, 
		String organizationId, int organizationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingOrganization(userContext,hyperledgerNetworkId, organizationId, organizationVersion,tokensExpr);
		
		Organization organization = createIndexedOrganization(organizationId, organizationVersion);
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
		synchronized(hyperledgerNetwork){ 
			//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			hyperledgerNetwork.copyOrganizationFrom( organization );		
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withOrganizationList().done());
			
			userContext.getManagerGroup().getOrganizationManager().onNewInstanceCreated(userContext, (Organization)hyperledgerNetwork.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingOrganization(HfgwUserContext userContext, String hyperledgerNetworkId, String organizationId, int organizationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);
		checkerOf(userContext).checkIdOfOrganization(organizationId);
		checkerOf(userContext).checkVersionOfOrganization(organizationVersion);
		

		if(Organization.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfOrganization(parseString(newValueExpr));
		}
		
		if(Organization.MSPID_PROPERTY.equals(property)){
			checkerOf(userContext).checkMspidOfOrganization(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
	
	}
	
	public  HyperledgerNetwork updateOrganization(HfgwUserContext userContext, String hyperledgerNetworkId, String organizationId, int organizationVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingOrganization(userContext, hyperledgerNetworkId, organizationId, organizationVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withOrganizationList().searchOrganizationListWith(Organization.ID_PROPERTY, "eq", organizationId).done();
		
		
		
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, loadTokens);
		
		synchronized(hyperledgerNetwork){ 
			//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//hyperledgerNetwork.removeOrganization( organization );	
			//make changes to AcceleraterAccount.
			Organization organizationIndex = createIndexedOrganization(organizationId, organizationVersion);
		
			Organization organization = hyperledgerNetwork.findTheOrganization(organizationIndex);
			if(organization == null){
				throw new HyperledgerNetworkManagerException(organization+" is NOT FOUND" );
			}
			
			organization.changeProperty(property, newValueExpr);
			
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withOrganizationList().done());
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingNodeType(HfgwUserContext userContext, String hyperledgerNetworkId, String name, String code, String address, String contactPerson, String contactTelephone,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);

		
		checkerOf(userContext).checkNameOfNodeType(name);
		
		checkerOf(userContext).checkCodeOfNodeType(code);
		
		checkerOf(userContext).checkAddressOfNodeType(address);
		
		checkerOf(userContext).checkContactPersonOfNodeType(contactPerson);
		
		checkerOf(userContext).checkContactTelephoneOfNodeType(contactTelephone);
	
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);

	
	}
	public  HyperledgerNetwork addNodeType(HfgwUserContext userContext, String hyperledgerNetworkId, String name, String code, String address, String contactPerson, String contactTelephone, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingNodeType(userContext,hyperledgerNetworkId,name, code, address, contactPerson, contactTelephone,tokensExpr);
		
		NodeType nodeType = createNodeType(userContext,name, code, address, contactPerson, contactTelephone);
		
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
		synchronized(hyperledgerNetwork){ 
			//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hyperledgerNetwork.addNodeType( nodeType );		
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withNodeTypeList().done());
			
			userContext.getManagerGroup().getNodeTypeManager().onNewInstanceCreated(userContext, nodeType);
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingNodeTypeProperties(HfgwUserContext userContext, String hyperledgerNetworkId,String id,String name,String code,String address,String contactPerson,String contactTelephone,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);
		checkerOf(userContext).checkIdOfNodeType(id);
		
		checkerOf(userContext).checkNameOfNodeType( name);
		checkerOf(userContext).checkCodeOfNodeType( code);
		checkerOf(userContext).checkAddressOfNodeType( address);
		checkerOf(userContext).checkContactPersonOfNodeType( contactPerson);
		checkerOf(userContext).checkContactTelephoneOfNodeType( contactTelephone);

		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
		
	}
	public  HyperledgerNetwork updateNodeTypeProperties(HfgwUserContext userContext, String hyperledgerNetworkId, String id,String name,String code,String address,String contactPerson,String contactTelephone, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingNodeTypeProperties(userContext,hyperledgerNetworkId,id,name,code,address,contactPerson,contactTelephone,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withNodeTypeListList()
				.searchNodeTypeListWith(NodeType.ID_PROPERTY, "is", id).done();
		
		HyperledgerNetwork hyperledgerNetworkToUpdate = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, options);
		
		if(hyperledgerNetworkToUpdate.getNodeTypeList().isEmpty()){
			throw new HyperledgerNetworkManagerException("NodeType is NOT FOUND with id: '"+id+"'");
		}
		
		NodeType item = hyperledgerNetworkToUpdate.getNodeTypeList().first();
		
		item.updateName( name );
		item.updateCode( code );
		item.updateAddress( address );
		item.updateContactPerson( contactPerson );
		item.updateContactTelephone( contactTelephone );

		
		//checkParamsForAddingNodeType(userContext,hyperledgerNetworkId,name, code, used,tokensExpr);
		HyperledgerNetwork hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetworkToUpdate, tokens().withNodeTypeList().done());
		synchronized(hyperledgerNetwork){ 
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected NodeType createNodeType(HfgwUserContext userContext, String name, String code, String address, String contactPerson, String contactTelephone) throws Exception{

		NodeType nodeType = new NodeType();
		
		
		nodeType.setName(name);		
		nodeType.setCode(code);		
		nodeType.setAddress(address);		
		nodeType.setContactPerson(contactPerson);		
		nodeType.setContactTelephone(contactTelephone);
	
		
		return nodeType;
	
		
	}
	
	protected NodeType createIndexedNodeType(String id, int version){

		NodeType nodeType = new NodeType();
		nodeType.setId(id);
		nodeType.setVersion(version);
		return nodeType;			
		
	}
	
	protected void checkParamsForRemovingNodeTypeList(HfgwUserContext userContext, String hyperledgerNetworkId, 
			String nodeTypeIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);
		for(String nodeTypeIdItem: nodeTypeIds){
			checkerOf(userContext).checkIdOfNodeType(nodeTypeIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
		
	}
	public  HyperledgerNetwork removeNodeTypeList(HfgwUserContext userContext, String hyperledgerNetworkId, 
			String nodeTypeIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingNodeTypeList(userContext, hyperledgerNetworkId,  nodeTypeIds, tokensExpr);
			
			
			HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
			synchronized(hyperledgerNetwork){ 
				//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				hyperledgerNetworkDaoOf(userContext).planToRemoveNodeTypeList(hyperledgerNetwork, nodeTypeIds, allTokens());
				hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withNodeTypeList().done());
				deleteRelationListInGraph(userContext, hyperledgerNetwork.getNodeTypeList());
				return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingNodeType(HfgwUserContext userContext, String hyperledgerNetworkId, 
		String nodeTypeId, int nodeTypeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork( hyperledgerNetworkId);
		checkerOf(userContext).checkIdOfNodeType(nodeTypeId);
		checkerOf(userContext).checkVersionOfNodeType(nodeTypeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
	
	}
	public  HyperledgerNetwork removeNodeType(HfgwUserContext userContext, String hyperledgerNetworkId, 
		String nodeTypeId, int nodeTypeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingNodeType(userContext,hyperledgerNetworkId, nodeTypeId, nodeTypeVersion,tokensExpr);
		
		NodeType nodeType = createIndexedNodeType(nodeTypeId, nodeTypeVersion);
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
		synchronized(hyperledgerNetwork){ 
			//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hyperledgerNetwork.removeNodeType( nodeType );		
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withNodeTypeList().done());
			deleteRelationInGraph(userContext, nodeType);
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingNodeType(HfgwUserContext userContext, String hyperledgerNetworkId, 
		String nodeTypeId, int nodeTypeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork( hyperledgerNetworkId);
		checkerOf(userContext).checkIdOfNodeType(nodeTypeId);
		checkerOf(userContext).checkVersionOfNodeType(nodeTypeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
	
	}
	public  HyperledgerNetwork copyNodeTypeFrom(HfgwUserContext userContext, String hyperledgerNetworkId, 
		String nodeTypeId, int nodeTypeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingNodeType(userContext,hyperledgerNetworkId, nodeTypeId, nodeTypeVersion,tokensExpr);
		
		NodeType nodeType = createIndexedNodeType(nodeTypeId, nodeTypeVersion);
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
		synchronized(hyperledgerNetwork){ 
			//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			hyperledgerNetwork.copyNodeTypeFrom( nodeType );		
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withNodeTypeList().done());
			
			userContext.getManagerGroup().getNodeTypeManager().onNewInstanceCreated(userContext, (NodeType)hyperledgerNetwork.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingNodeType(HfgwUserContext userContext, String hyperledgerNetworkId, String nodeTypeId, int nodeTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);
		checkerOf(userContext).checkIdOfNodeType(nodeTypeId);
		checkerOf(userContext).checkVersionOfNodeType(nodeTypeVersion);
		

		if(NodeType.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfNodeType(parseString(newValueExpr));
		}
		
		if(NodeType.CODE_PROPERTY.equals(property)){
			checkerOf(userContext).checkCodeOfNodeType(parseString(newValueExpr));
		}
		
		if(NodeType.ADDRESS_PROPERTY.equals(property)){
			checkerOf(userContext).checkAddressOfNodeType(parseString(newValueExpr));
		}
		
		if(NodeType.CONTACT_PERSON_PROPERTY.equals(property)){
			checkerOf(userContext).checkContactPersonOfNodeType(parseString(newValueExpr));
		}
		
		if(NodeType.CONTACT_TELEPHONE_PROPERTY.equals(property)){
			checkerOf(userContext).checkContactTelephoneOfNodeType(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
	
	}
	
	public  HyperledgerNetwork updateNodeType(HfgwUserContext userContext, String hyperledgerNetworkId, String nodeTypeId, int nodeTypeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingNodeType(userContext, hyperledgerNetworkId, nodeTypeId, nodeTypeVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withNodeTypeList().searchNodeTypeListWith(NodeType.ID_PROPERTY, "eq", nodeTypeId).done();
		
		
		
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, loadTokens);
		
		synchronized(hyperledgerNetwork){ 
			//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//hyperledgerNetwork.removeNodeType( nodeType );	
			//make changes to AcceleraterAccount.
			NodeType nodeTypeIndex = createIndexedNodeType(nodeTypeId, nodeTypeVersion);
		
			NodeType nodeType = hyperledgerNetwork.findTheNodeType(nodeTypeIndex);
			if(nodeType == null){
				throw new HyperledgerNetworkManagerException(nodeType+" is NOT FOUND" );
			}
			
			nodeType.changeProperty(property, newValueExpr);
			
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withNodeTypeList().done());
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingChannel(HfgwUserContext userContext, String hyperledgerNetworkId, String name,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);

		
		checkerOf(userContext).checkNameOfChannel(name);
	
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);

	
	}
	public  HyperledgerNetwork addChannel(HfgwUserContext userContext, String hyperledgerNetworkId, String name, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingChannel(userContext,hyperledgerNetworkId,name,tokensExpr);
		
		Channel channel = createChannel(userContext,name);
		
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
		synchronized(hyperledgerNetwork){ 
			//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hyperledgerNetwork.addChannel( channel );		
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withChannelList().done());
			
			userContext.getManagerGroup().getChannelManager().onNewInstanceCreated(userContext, channel);
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingChannelProperties(HfgwUserContext userContext, String hyperledgerNetworkId,String id,String name,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);
		checkerOf(userContext).checkIdOfChannel(id);
		
		checkerOf(userContext).checkNameOfChannel( name);

		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
		
	}
	public  HyperledgerNetwork updateChannelProperties(HfgwUserContext userContext, String hyperledgerNetworkId, String id,String name, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingChannelProperties(userContext,hyperledgerNetworkId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withChannelListList()
				.searchChannelListWith(Channel.ID_PROPERTY, "is", id).done();
		
		HyperledgerNetwork hyperledgerNetworkToUpdate = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, options);
		
		if(hyperledgerNetworkToUpdate.getChannelList().isEmpty()){
			throw new HyperledgerNetworkManagerException("Channel is NOT FOUND with id: '"+id+"'");
		}
		
		Channel item = hyperledgerNetworkToUpdate.getChannelList().first();
		
		item.updateName( name );

		
		//checkParamsForAddingChannel(userContext,hyperledgerNetworkId,name, code, used,tokensExpr);
		HyperledgerNetwork hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetworkToUpdate, tokens().withChannelList().done());
		synchronized(hyperledgerNetwork){ 
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Channel createChannel(HfgwUserContext userContext, String name) throws Exception{

		Channel channel = new Channel();
		
		
		channel.setName(name);
	
		
		return channel;
	
		
	}
	
	protected Channel createIndexedChannel(String id, int version){

		Channel channel = new Channel();
		channel.setId(id);
		channel.setVersion(version);
		return channel;			
		
	}
	
	protected void checkParamsForRemovingChannelList(HfgwUserContext userContext, String hyperledgerNetworkId, 
			String channelIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);
		for(String channelIdItem: channelIds){
			checkerOf(userContext).checkIdOfChannel(channelIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
		
	}
	public  HyperledgerNetwork removeChannelList(HfgwUserContext userContext, String hyperledgerNetworkId, 
			String channelIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingChannelList(userContext, hyperledgerNetworkId,  channelIds, tokensExpr);
			
			
			HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
			synchronized(hyperledgerNetwork){ 
				//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				hyperledgerNetworkDaoOf(userContext).planToRemoveChannelList(hyperledgerNetwork, channelIds, allTokens());
				hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withChannelList().done());
				deleteRelationListInGraph(userContext, hyperledgerNetwork.getChannelList());
				return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingChannel(HfgwUserContext userContext, String hyperledgerNetworkId, 
		String channelId, int channelVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork( hyperledgerNetworkId);
		checkerOf(userContext).checkIdOfChannel(channelId);
		checkerOf(userContext).checkVersionOfChannel(channelVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
	
	}
	public  HyperledgerNetwork removeChannel(HfgwUserContext userContext, String hyperledgerNetworkId, 
		String channelId, int channelVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingChannel(userContext,hyperledgerNetworkId, channelId, channelVersion,tokensExpr);
		
		Channel channel = createIndexedChannel(channelId, channelVersion);
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
		synchronized(hyperledgerNetwork){ 
			//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hyperledgerNetwork.removeChannel( channel );		
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withChannelList().done());
			deleteRelationInGraph(userContext, channel);
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingChannel(HfgwUserContext userContext, String hyperledgerNetworkId, 
		String channelId, int channelVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork( hyperledgerNetworkId);
		checkerOf(userContext).checkIdOfChannel(channelId);
		checkerOf(userContext).checkVersionOfChannel(channelVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
	
	}
	public  HyperledgerNetwork copyChannelFrom(HfgwUserContext userContext, String hyperledgerNetworkId, 
		String channelId, int channelVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingChannel(userContext,hyperledgerNetworkId, channelId, channelVersion,tokensExpr);
		
		Channel channel = createIndexedChannel(channelId, channelVersion);
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
		synchronized(hyperledgerNetwork){ 
			//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			hyperledgerNetwork.copyChannelFrom( channel );		
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withChannelList().done());
			
			userContext.getManagerGroup().getChannelManager().onNewInstanceCreated(userContext, (Channel)hyperledgerNetwork.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingChannel(HfgwUserContext userContext, String hyperledgerNetworkId, String channelId, int channelVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);
		checkerOf(userContext).checkIdOfChannel(channelId);
		checkerOf(userContext).checkVersionOfChannel(channelVersion);
		

		if(Channel.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfChannel(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
	
	}
	
	public  HyperledgerNetwork updateChannel(HfgwUserContext userContext, String hyperledgerNetworkId, String channelId, int channelVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingChannel(userContext, hyperledgerNetworkId, channelId, channelVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withChannelList().searchChannelListWith(Channel.ID_PROPERTY, "eq", channelId).done();
		
		
		
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, loadTokens);
		
		synchronized(hyperledgerNetwork){ 
			//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//hyperledgerNetwork.removeChannel( channel );	
			//make changes to AcceleraterAccount.
			Channel channelIndex = createIndexedChannel(channelId, channelVersion);
		
			Channel channel = hyperledgerNetwork.findTheChannel(channelIndex);
			if(channel == null){
				throw new HyperledgerNetworkManagerException(channel+" is NOT FOUND" );
			}
			
			channel.changeProperty(property, newValueExpr);
			
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withChannelList().done());
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingApplication(HfgwUserContext userContext, String hyperledgerNetworkId, String name, String mspid, String publicKey, String privateKey, String channelId,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);

		
		checkerOf(userContext).checkNameOfApplication(name);
		
		checkerOf(userContext).checkMspidOfApplication(mspid);
		
		checkerOf(userContext).checkPublicKeyOfApplication(publicKey);
		
		checkerOf(userContext).checkPrivateKeyOfApplication(privateKey);
		
		checkerOf(userContext).checkChannelIdOfApplication(channelId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);

	
	}
	public  HyperledgerNetwork addApplication(HfgwUserContext userContext, String hyperledgerNetworkId, String name, String mspid, String publicKey, String privateKey, String channelId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingApplication(userContext,hyperledgerNetworkId,name, mspid, publicKey, privateKey, channelId,tokensExpr);
		
		Application application = createApplication(userContext,name, mspid, publicKey, privateKey, channelId);
		
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
		synchronized(hyperledgerNetwork){ 
			//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hyperledgerNetwork.addApplication( application );		
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withApplicationList().done());
			
			userContext.getManagerGroup().getApplicationManager().onNewInstanceCreated(userContext, application);
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingApplicationProperties(HfgwUserContext userContext, String hyperledgerNetworkId,String id,String name,String mspid,String publicKey,String privateKey,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);
		checkerOf(userContext).checkIdOfApplication(id);
		
		checkerOf(userContext).checkNameOfApplication( name);
		checkerOf(userContext).checkMspidOfApplication( mspid);
		checkerOf(userContext).checkPublicKeyOfApplication( publicKey);
		checkerOf(userContext).checkPrivateKeyOfApplication( privateKey);

		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
		
	}
	public  HyperledgerNetwork updateApplicationProperties(HfgwUserContext userContext, String hyperledgerNetworkId, String id,String name,String mspid,String publicKey,String privateKey, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingApplicationProperties(userContext,hyperledgerNetworkId,id,name,mspid,publicKey,privateKey,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withApplicationListList()
				.searchApplicationListWith(Application.ID_PROPERTY, "is", id).done();
		
		HyperledgerNetwork hyperledgerNetworkToUpdate = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, options);
		
		if(hyperledgerNetworkToUpdate.getApplicationList().isEmpty()){
			throw new HyperledgerNetworkManagerException("Application is NOT FOUND with id: '"+id+"'");
		}
		
		Application item = hyperledgerNetworkToUpdate.getApplicationList().first();
		
		item.updateName( name );
		item.updateMspid( mspid );
		item.updatePublicKey( publicKey );
		item.updatePrivateKey( privateKey );

		
		//checkParamsForAddingApplication(userContext,hyperledgerNetworkId,name, code, used,tokensExpr);
		HyperledgerNetwork hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetworkToUpdate, tokens().withApplicationList().done());
		synchronized(hyperledgerNetwork){ 
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Application createApplication(HfgwUserContext userContext, String name, String mspid, String publicKey, String privateKey, String channelId) throws Exception{

		Application application = new Application();
		
		
		application.setName(name);		
		application.setCreateTime(userContext.now());		
		application.setMspid(mspid);		
		application.setPublicKey(publicKey);		
		application.setPrivateKey(privateKey);		
		Channel  channel = new Channel();
		channel.setId(channelId);		
		application.setChannel(channel);
	
		
		return application;
	
		
	}
	
	protected Application createIndexedApplication(String id, int version){

		Application application = new Application();
		application.setId(id);
		application.setVersion(version);
		return application;			
		
	}
	
	protected void checkParamsForRemovingApplicationList(HfgwUserContext userContext, String hyperledgerNetworkId, 
			String applicationIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);
		for(String applicationIdItem: applicationIds){
			checkerOf(userContext).checkIdOfApplication(applicationIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
		
	}
	public  HyperledgerNetwork removeApplicationList(HfgwUserContext userContext, String hyperledgerNetworkId, 
			String applicationIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingApplicationList(userContext, hyperledgerNetworkId,  applicationIds, tokensExpr);
			
			
			HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
			synchronized(hyperledgerNetwork){ 
				//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				hyperledgerNetworkDaoOf(userContext).planToRemoveApplicationList(hyperledgerNetwork, applicationIds, allTokens());
				hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withApplicationList().done());
				deleteRelationListInGraph(userContext, hyperledgerNetwork.getApplicationList());
				return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingApplication(HfgwUserContext userContext, String hyperledgerNetworkId, 
		String applicationId, int applicationVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork( hyperledgerNetworkId);
		checkerOf(userContext).checkIdOfApplication(applicationId);
		checkerOf(userContext).checkVersionOfApplication(applicationVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
	
	}
	public  HyperledgerNetwork removeApplication(HfgwUserContext userContext, String hyperledgerNetworkId, 
		String applicationId, int applicationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingApplication(userContext,hyperledgerNetworkId, applicationId, applicationVersion,tokensExpr);
		
		Application application = createIndexedApplication(applicationId, applicationVersion);
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
		synchronized(hyperledgerNetwork){ 
			//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hyperledgerNetwork.removeApplication( application );		
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withApplicationList().done());
			deleteRelationInGraph(userContext, application);
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingApplication(HfgwUserContext userContext, String hyperledgerNetworkId, 
		String applicationId, int applicationVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork( hyperledgerNetworkId);
		checkerOf(userContext).checkIdOfApplication(applicationId);
		checkerOf(userContext).checkVersionOfApplication(applicationVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
	
	}
	public  HyperledgerNetwork copyApplicationFrom(HfgwUserContext userContext, String hyperledgerNetworkId, 
		String applicationId, int applicationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingApplication(userContext,hyperledgerNetworkId, applicationId, applicationVersion,tokensExpr);
		
		Application application = createIndexedApplication(applicationId, applicationVersion);
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
		synchronized(hyperledgerNetwork){ 
			//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			hyperledgerNetwork.copyApplicationFrom( application );		
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withApplicationList().done());
			
			userContext.getManagerGroup().getApplicationManager().onNewInstanceCreated(userContext, (Application)hyperledgerNetwork.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingApplication(HfgwUserContext userContext, String hyperledgerNetworkId, String applicationId, int applicationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
	
	}
	
	public  HyperledgerNetwork updateApplication(HfgwUserContext userContext, String hyperledgerNetworkId, String applicationId, int applicationVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingApplication(userContext, hyperledgerNetworkId, applicationId, applicationVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withApplicationList().searchApplicationListWith(Application.ID_PROPERTY, "eq", applicationId).done();
		
		
		
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, loadTokens);
		
		synchronized(hyperledgerNetwork){ 
			//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//hyperledgerNetwork.removeApplication( application );	
			//make changes to AcceleraterAccount.
			Application applicationIndex = createIndexedApplication(applicationId, applicationVersion);
		
			Application application = hyperledgerNetwork.findTheApplication(applicationIndex);
			if(application == null){
				throw new HyperledgerNetworkManagerException(application+" is NOT FOUND" );
			}
			
			application.changeProperty(property, newValueExpr);
			
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withApplicationList().done());
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingServiceRecord(HfgwUserContext userContext, String hyperledgerNetworkId, String name, String payLoad, String channelId, String chainCodeId, String transactionId, String blockId,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);

		
		checkerOf(userContext).checkNameOfServiceRecord(name);
		
		checkerOf(userContext).checkPayLoadOfServiceRecord(payLoad);
		
		checkerOf(userContext).checkChannelIdOfServiceRecord(channelId);
		
		checkerOf(userContext).checkChainCodeIdOfServiceRecord(chainCodeId);
		
		checkerOf(userContext).checkTransactionIdOfServiceRecord(transactionId);
		
		checkerOf(userContext).checkBlockIdOfServiceRecord(blockId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);

	
	}
	public  HyperledgerNetwork addServiceRecord(HfgwUserContext userContext, String hyperledgerNetworkId, String name, String payLoad, String channelId, String chainCodeId, String transactionId, String blockId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingServiceRecord(userContext,hyperledgerNetworkId,name, payLoad, channelId, chainCodeId, transactionId, blockId,tokensExpr);
		
		ServiceRecord serviceRecord = createServiceRecord(userContext,name, payLoad, channelId, chainCodeId, transactionId, blockId);
		
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
		synchronized(hyperledgerNetwork){ 
			//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hyperledgerNetwork.addServiceRecord( serviceRecord );		
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withServiceRecordList().done());
			
			userContext.getManagerGroup().getServiceRecordManager().onNewInstanceCreated(userContext, serviceRecord);
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingServiceRecordProperties(HfgwUserContext userContext, String hyperledgerNetworkId,String id,String name,String payLoad,String transactionId,String blockId,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);
		checkerOf(userContext).checkIdOfServiceRecord(id);
		
		checkerOf(userContext).checkNameOfServiceRecord( name);
		checkerOf(userContext).checkPayLoadOfServiceRecord( payLoad);
		checkerOf(userContext).checkTransactionIdOfServiceRecord( transactionId);
		checkerOf(userContext).checkBlockIdOfServiceRecord( blockId);

		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
		
	}
	public  HyperledgerNetwork updateServiceRecordProperties(HfgwUserContext userContext, String hyperledgerNetworkId, String id,String name,String payLoad,String transactionId,String blockId, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingServiceRecordProperties(userContext,hyperledgerNetworkId,id,name,payLoad,transactionId,blockId,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withServiceRecordListList()
				.searchServiceRecordListWith(ServiceRecord.ID_PROPERTY, "is", id).done();
		
		HyperledgerNetwork hyperledgerNetworkToUpdate = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, options);
		
		if(hyperledgerNetworkToUpdate.getServiceRecordList().isEmpty()){
			throw new HyperledgerNetworkManagerException("ServiceRecord is NOT FOUND with id: '"+id+"'");
		}
		
		ServiceRecord item = hyperledgerNetworkToUpdate.getServiceRecordList().first();
		
		item.updateName( name );
		item.updatePayLoad( payLoad );
		item.updateTransactionId( transactionId );
		item.updateBlockId( blockId );

		
		//checkParamsForAddingServiceRecord(userContext,hyperledgerNetworkId,name, code, used,tokensExpr);
		HyperledgerNetwork hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetworkToUpdate, tokens().withServiceRecordList().done());
		synchronized(hyperledgerNetwork){ 
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ServiceRecord createServiceRecord(HfgwUserContext userContext, String name, String payLoad, String channelId, String chainCodeId, String transactionId, String blockId) throws Exception{

		ServiceRecord serviceRecord = new ServiceRecord();
		
		
		serviceRecord.setName(name);		
		serviceRecord.setPayLoad(payLoad);		
		Channel  channel = new Channel();
		channel.setId(channelId);		
		serviceRecord.setChannel(channel);		
		ChainCode  chainCode = new ChainCode();
		chainCode.setId(chainCodeId);		
		serviceRecord.setChainCode(chainCode);		
		serviceRecord.setTransactionId(transactionId);		
		serviceRecord.setBlockId(blockId);		
		serviceRecord.setCreateTime(userContext.now());		
		serviceRecord.setCurrentStatus("INIT");
	
		
		return serviceRecord;
	
		
	}
	
	protected ServiceRecord createIndexedServiceRecord(String id, int version){

		ServiceRecord serviceRecord = new ServiceRecord();
		serviceRecord.setId(id);
		serviceRecord.setVersion(version);
		return serviceRecord;			
		
	}
	
	protected void checkParamsForRemovingServiceRecordList(HfgwUserContext userContext, String hyperledgerNetworkId, 
			String serviceRecordIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);
		for(String serviceRecordIdItem: serviceRecordIds){
			checkerOf(userContext).checkIdOfServiceRecord(serviceRecordIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
		
	}
	public  HyperledgerNetwork removeServiceRecordList(HfgwUserContext userContext, String hyperledgerNetworkId, 
			String serviceRecordIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingServiceRecordList(userContext, hyperledgerNetworkId,  serviceRecordIds, tokensExpr);
			
			
			HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
			synchronized(hyperledgerNetwork){ 
				//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				hyperledgerNetworkDaoOf(userContext).planToRemoveServiceRecordList(hyperledgerNetwork, serviceRecordIds, allTokens());
				hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withServiceRecordList().done());
				deleteRelationListInGraph(userContext, hyperledgerNetwork.getServiceRecordList());
				return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingServiceRecord(HfgwUserContext userContext, String hyperledgerNetworkId, 
		String serviceRecordId, int serviceRecordVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork( hyperledgerNetworkId);
		checkerOf(userContext).checkIdOfServiceRecord(serviceRecordId);
		checkerOf(userContext).checkVersionOfServiceRecord(serviceRecordVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
	
	}
	public  HyperledgerNetwork removeServiceRecord(HfgwUserContext userContext, String hyperledgerNetworkId, 
		String serviceRecordId, int serviceRecordVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingServiceRecord(userContext,hyperledgerNetworkId, serviceRecordId, serviceRecordVersion,tokensExpr);
		
		ServiceRecord serviceRecord = createIndexedServiceRecord(serviceRecordId, serviceRecordVersion);
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
		synchronized(hyperledgerNetwork){ 
			//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hyperledgerNetwork.removeServiceRecord( serviceRecord );		
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withServiceRecordList().done());
			deleteRelationInGraph(userContext, serviceRecord);
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingServiceRecord(HfgwUserContext userContext, String hyperledgerNetworkId, 
		String serviceRecordId, int serviceRecordVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork( hyperledgerNetworkId);
		checkerOf(userContext).checkIdOfServiceRecord(serviceRecordId);
		checkerOf(userContext).checkVersionOfServiceRecord(serviceRecordVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
	
	}
	public  HyperledgerNetwork copyServiceRecordFrom(HfgwUserContext userContext, String hyperledgerNetworkId, 
		String serviceRecordId, int serviceRecordVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingServiceRecord(userContext,hyperledgerNetworkId, serviceRecordId, serviceRecordVersion,tokensExpr);
		
		ServiceRecord serviceRecord = createIndexedServiceRecord(serviceRecordId, serviceRecordVersion);
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
		synchronized(hyperledgerNetwork){ 
			//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			hyperledgerNetwork.copyServiceRecordFrom( serviceRecord );		
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withServiceRecordList().done());
			
			userContext.getManagerGroup().getServiceRecordManager().onNewInstanceCreated(userContext, (ServiceRecord)hyperledgerNetwork.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingServiceRecord(HfgwUserContext userContext, String hyperledgerNetworkId, String serviceRecordId, int serviceRecordVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
	
	}
	
	public  HyperledgerNetwork updateServiceRecord(HfgwUserContext userContext, String hyperledgerNetworkId, String serviceRecordId, int serviceRecordVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingServiceRecord(userContext, hyperledgerNetworkId, serviceRecordId, serviceRecordVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withServiceRecordList().searchServiceRecordListWith(ServiceRecord.ID_PROPERTY, "eq", serviceRecordId).done();
		
		
		
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, loadTokens);
		
		synchronized(hyperledgerNetwork){ 
			//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//hyperledgerNetwork.removeServiceRecord( serviceRecord );	
			//make changes to AcceleraterAccount.
			ServiceRecord serviceRecordIndex = createIndexedServiceRecord(serviceRecordId, serviceRecordVersion);
		
			ServiceRecord serviceRecord = hyperledgerNetwork.findTheServiceRecord(serviceRecordIndex);
			if(serviceRecord == null){
				throw new HyperledgerNetworkManagerException(serviceRecord+" is NOT FOUND" );
			}
			
			serviceRecord.changeProperty(property, newValueExpr);
			
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withServiceRecordList().done());
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  HyperledgerNetwork associateServiceRecordListToNewApplication(HfgwUserContext userContext, String hyperledgerNetworkId, String  serviceRecordIds[], String name, String mspid, String publicKey, String privateKey, String channelId, String networkId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchServiceRecordListWith(ServiceRecord.ID_PROPERTY, "oneof", this.joinArray("|", serviceRecordIds)).done();
		
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, options);
		
		Application application = applicationManagerOf(userContext).createApplication(userContext,  name,  mspid,  publicKey,  privateKey, channelId, networkId);
		
		for(ServiceRecord serviceRecord: hyperledgerNetwork.getServiceRecordList()) {
			//TODO: need to check if already associated
			serviceRecord.updateApplication(application);
		}
		return this.internalSaveHyperledgerNetwork(userContext, hyperledgerNetwork);
	}
	*/
	
	public  HyperledgerNetwork associateServiceRecordListToApplication(HfgwUserContext userContext, String hyperledgerNetworkId, String  serviceRecordIds[], String applicationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchServiceRecordListWith(ServiceRecord.ID_PROPERTY, "oneof", this.joinArray("|", serviceRecordIds)).done();
		
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, options);
		
		Application application = applicationManagerOf(userContext).loadApplication(userContext,applicationId,new String[]{"none"} );
		
		for(ServiceRecord serviceRecord: hyperledgerNetwork.getServiceRecordList()) {
			//TODO: need to check if already associated
			serviceRecord.updateApplication(application);
		}
		return this.internalSaveHyperledgerNetwork(userContext, hyperledgerNetwork);
	}


	protected void checkParamsForAddingChangeRequestType(HfgwUserContext userContext, String hyperledgerNetworkId, String name, String code, String icon, int displayOrder, String bindTypes, String stepConfiguration,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);

		
		checkerOf(userContext).checkNameOfChangeRequestType(name);
		
		checkerOf(userContext).checkCodeOfChangeRequestType(code);
		
		checkerOf(userContext).checkIconOfChangeRequestType(icon);
		
		checkerOf(userContext).checkDisplayOrderOfChangeRequestType(displayOrder);
		
		checkerOf(userContext).checkBindTypesOfChangeRequestType(bindTypes);
		
		checkerOf(userContext).checkStepConfigurationOfChangeRequestType(stepConfiguration);
	
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);

	
	}
	public  HyperledgerNetwork addChangeRequestType(HfgwUserContext userContext, String hyperledgerNetworkId, String name, String code, String icon, int displayOrder, String bindTypes, String stepConfiguration, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingChangeRequestType(userContext,hyperledgerNetworkId,name, code, icon, displayOrder, bindTypes, stepConfiguration,tokensExpr);
		
		ChangeRequestType changeRequestType = createChangeRequestType(userContext,name, code, icon, displayOrder, bindTypes, stepConfiguration);
		
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
		synchronized(hyperledgerNetwork){ 
			//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hyperledgerNetwork.addChangeRequestType( changeRequestType );		
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withChangeRequestTypeList().done());
			
			userContext.getManagerGroup().getChangeRequestTypeManager().onNewInstanceCreated(userContext, changeRequestType);
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingChangeRequestTypeProperties(HfgwUserContext userContext, String hyperledgerNetworkId,String id,String name,String code,String icon,int displayOrder,String bindTypes,String stepConfiguration,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);
		checkerOf(userContext).checkIdOfChangeRequestType(id);
		
		checkerOf(userContext).checkNameOfChangeRequestType( name);
		checkerOf(userContext).checkCodeOfChangeRequestType( code);
		checkerOf(userContext).checkIconOfChangeRequestType( icon);
		checkerOf(userContext).checkDisplayOrderOfChangeRequestType( displayOrder);
		checkerOf(userContext).checkBindTypesOfChangeRequestType( bindTypes);
		checkerOf(userContext).checkStepConfigurationOfChangeRequestType( stepConfiguration);

		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
		
	}
	public  HyperledgerNetwork updateChangeRequestTypeProperties(HfgwUserContext userContext, String hyperledgerNetworkId, String id,String name,String code,String icon,int displayOrder,String bindTypes,String stepConfiguration, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingChangeRequestTypeProperties(userContext,hyperledgerNetworkId,id,name,code,icon,displayOrder,bindTypes,stepConfiguration,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withChangeRequestTypeListList()
				.searchChangeRequestTypeListWith(ChangeRequestType.ID_PROPERTY, "is", id).done();
		
		HyperledgerNetwork hyperledgerNetworkToUpdate = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, options);
		
		if(hyperledgerNetworkToUpdate.getChangeRequestTypeList().isEmpty()){
			throw new HyperledgerNetworkManagerException("ChangeRequestType is NOT FOUND with id: '"+id+"'");
		}
		
		ChangeRequestType item = hyperledgerNetworkToUpdate.getChangeRequestTypeList().first();
		
		item.updateName( name );
		item.updateCode( code );
		item.updateIcon( icon );
		item.updateDisplayOrder( displayOrder );
		item.updateBindTypes( bindTypes );
		item.updateStepConfiguration( stepConfiguration );

		
		//checkParamsForAddingChangeRequestType(userContext,hyperledgerNetworkId,name, code, used,tokensExpr);
		HyperledgerNetwork hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetworkToUpdate, tokens().withChangeRequestTypeList().done());
		synchronized(hyperledgerNetwork){ 
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ChangeRequestType createChangeRequestType(HfgwUserContext userContext, String name, String code, String icon, int displayOrder, String bindTypes, String stepConfiguration) throws Exception{

		ChangeRequestType changeRequestType = new ChangeRequestType();
		
		
		changeRequestType.setName(name);		
		changeRequestType.setCode(code);		
		changeRequestType.setIcon(icon);		
		changeRequestType.setDisplayOrder(displayOrder);		
		changeRequestType.setBindTypes(bindTypes);		
		changeRequestType.setStepConfiguration(stepConfiguration);
	
		
		return changeRequestType;
	
		
	}
	
	protected ChangeRequestType createIndexedChangeRequestType(String id, int version){

		ChangeRequestType changeRequestType = new ChangeRequestType();
		changeRequestType.setId(id);
		changeRequestType.setVersion(version);
		return changeRequestType;			
		
	}
	
	protected void checkParamsForRemovingChangeRequestTypeList(HfgwUserContext userContext, String hyperledgerNetworkId, 
			String changeRequestTypeIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);
		for(String changeRequestTypeIdItem: changeRequestTypeIds){
			checkerOf(userContext).checkIdOfChangeRequestType(changeRequestTypeIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
		
	}
	public  HyperledgerNetwork removeChangeRequestTypeList(HfgwUserContext userContext, String hyperledgerNetworkId, 
			String changeRequestTypeIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingChangeRequestTypeList(userContext, hyperledgerNetworkId,  changeRequestTypeIds, tokensExpr);
			
			
			HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
			synchronized(hyperledgerNetwork){ 
				//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				hyperledgerNetworkDaoOf(userContext).planToRemoveChangeRequestTypeList(hyperledgerNetwork, changeRequestTypeIds, allTokens());
				hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withChangeRequestTypeList().done());
				deleteRelationListInGraph(userContext, hyperledgerNetwork.getChangeRequestTypeList());
				return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingChangeRequestType(HfgwUserContext userContext, String hyperledgerNetworkId, 
		String changeRequestTypeId, int changeRequestTypeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork( hyperledgerNetworkId);
		checkerOf(userContext).checkIdOfChangeRequestType(changeRequestTypeId);
		checkerOf(userContext).checkVersionOfChangeRequestType(changeRequestTypeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
	
	}
	public  HyperledgerNetwork removeChangeRequestType(HfgwUserContext userContext, String hyperledgerNetworkId, 
		String changeRequestTypeId, int changeRequestTypeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingChangeRequestType(userContext,hyperledgerNetworkId, changeRequestTypeId, changeRequestTypeVersion,tokensExpr);
		
		ChangeRequestType changeRequestType = createIndexedChangeRequestType(changeRequestTypeId, changeRequestTypeVersion);
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
		synchronized(hyperledgerNetwork){ 
			//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hyperledgerNetwork.removeChangeRequestType( changeRequestType );		
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withChangeRequestTypeList().done());
			deleteRelationInGraph(userContext, changeRequestType);
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingChangeRequestType(HfgwUserContext userContext, String hyperledgerNetworkId, 
		String changeRequestTypeId, int changeRequestTypeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork( hyperledgerNetworkId);
		checkerOf(userContext).checkIdOfChangeRequestType(changeRequestTypeId);
		checkerOf(userContext).checkVersionOfChangeRequestType(changeRequestTypeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
	
	}
	public  HyperledgerNetwork copyChangeRequestTypeFrom(HfgwUserContext userContext, String hyperledgerNetworkId, 
		String changeRequestTypeId, int changeRequestTypeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingChangeRequestType(userContext,hyperledgerNetworkId, changeRequestTypeId, changeRequestTypeVersion,tokensExpr);
		
		ChangeRequestType changeRequestType = createIndexedChangeRequestType(changeRequestTypeId, changeRequestTypeVersion);
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
		synchronized(hyperledgerNetwork){ 
			//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			hyperledgerNetwork.copyChangeRequestTypeFrom( changeRequestType );		
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withChangeRequestTypeList().done());
			
			userContext.getManagerGroup().getChangeRequestTypeManager().onNewInstanceCreated(userContext, (ChangeRequestType)hyperledgerNetwork.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingChangeRequestType(HfgwUserContext userContext, String hyperledgerNetworkId, String changeRequestTypeId, int changeRequestTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);
		checkerOf(userContext).checkIdOfChangeRequestType(changeRequestTypeId);
		checkerOf(userContext).checkVersionOfChangeRequestType(changeRequestTypeVersion);
		

		if(ChangeRequestType.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfChangeRequestType(parseString(newValueExpr));
		}
		
		if(ChangeRequestType.CODE_PROPERTY.equals(property)){
			checkerOf(userContext).checkCodeOfChangeRequestType(parseString(newValueExpr));
		}
		
		if(ChangeRequestType.ICON_PROPERTY.equals(property)){
			checkerOf(userContext).checkIconOfChangeRequestType(parseString(newValueExpr));
		}
		
		if(ChangeRequestType.DISPLAY_ORDER_PROPERTY.equals(property)){
			checkerOf(userContext).checkDisplayOrderOfChangeRequestType(parseInt(newValueExpr));
		}
		
		if(ChangeRequestType.BIND_TYPES_PROPERTY.equals(property)){
			checkerOf(userContext).checkBindTypesOfChangeRequestType(parseString(newValueExpr));
		}
		
		if(ChangeRequestType.STEP_CONFIGURATION_PROPERTY.equals(property)){
			checkerOf(userContext).checkStepConfigurationOfChangeRequestType(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
	
	}
	
	public  HyperledgerNetwork updateChangeRequestType(HfgwUserContext userContext, String hyperledgerNetworkId, String changeRequestTypeId, int changeRequestTypeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingChangeRequestType(userContext, hyperledgerNetworkId, changeRequestTypeId, changeRequestTypeVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withChangeRequestTypeList().searchChangeRequestTypeListWith(ChangeRequestType.ID_PROPERTY, "eq", changeRequestTypeId).done();
		
		
		
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, loadTokens);
		
		synchronized(hyperledgerNetwork){ 
			//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//hyperledgerNetwork.removeChangeRequestType( changeRequestType );	
			//make changes to AcceleraterAccount.
			ChangeRequestType changeRequestTypeIndex = createIndexedChangeRequestType(changeRequestTypeId, changeRequestTypeVersion);
		
			ChangeRequestType changeRequestType = hyperledgerNetwork.findTheChangeRequestType(changeRequestTypeIndex);
			if(changeRequestType == null){
				throw new HyperledgerNetworkManagerException(changeRequestType+" is NOT FOUND" );
			}
			
			changeRequestType.changeProperty(property, newValueExpr);
			
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withChangeRequestTypeList().done());
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingChangeRequest(HfgwUserContext userContext, String hyperledgerNetworkId, String name, String requestTypeId,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);

		
		checkerOf(userContext).checkNameOfChangeRequest(name);
		
		checkerOf(userContext).checkRequestTypeIdOfChangeRequest(requestTypeId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);

	
	}
	public  HyperledgerNetwork addChangeRequest(HfgwUserContext userContext, String hyperledgerNetworkId, String name, String requestTypeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingChangeRequest(userContext,hyperledgerNetworkId,name, requestTypeId,tokensExpr);
		
		ChangeRequest changeRequest = createChangeRequest(userContext,name, requestTypeId);
		
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
		synchronized(hyperledgerNetwork){ 
			//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hyperledgerNetwork.addChangeRequest( changeRequest );		
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withChangeRequestList().done());
			
			userContext.getManagerGroup().getChangeRequestManager().onNewInstanceCreated(userContext, changeRequest);
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingChangeRequestProperties(HfgwUserContext userContext, String hyperledgerNetworkId,String id,String name,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);
		checkerOf(userContext).checkIdOfChangeRequest(id);
		
		checkerOf(userContext).checkNameOfChangeRequest( name);

		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
		
	}
	public  HyperledgerNetwork updateChangeRequestProperties(HfgwUserContext userContext, String hyperledgerNetworkId, String id,String name, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingChangeRequestProperties(userContext,hyperledgerNetworkId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withChangeRequestListList()
				.searchChangeRequestListWith(ChangeRequest.ID_PROPERTY, "is", id).done();
		
		HyperledgerNetwork hyperledgerNetworkToUpdate = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, options);
		
		if(hyperledgerNetworkToUpdate.getChangeRequestList().isEmpty()){
			throw new HyperledgerNetworkManagerException("ChangeRequest is NOT FOUND with id: '"+id+"'");
		}
		
		ChangeRequest item = hyperledgerNetworkToUpdate.getChangeRequestList().first();
		
		item.updateName( name );

		
		//checkParamsForAddingChangeRequest(userContext,hyperledgerNetworkId,name, code, used,tokensExpr);
		HyperledgerNetwork hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetworkToUpdate, tokens().withChangeRequestList().done());
		synchronized(hyperledgerNetwork){ 
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ChangeRequest createChangeRequest(HfgwUserContext userContext, String name, String requestTypeId) throws Exception{

		ChangeRequest changeRequest = new ChangeRequest();
		
		
		changeRequest.setName(name);		
		changeRequest.setCreateTime(userContext.now());		
		changeRequest.setRemoteIp(userContext.getRemoteIP());		
		ChangeRequestType  requestType = new ChangeRequestType();
		requestType.setId(requestTypeId);		
		changeRequest.setRequestType(requestType);
	
		
		return changeRequest;
	
		
	}
	
	protected ChangeRequest createIndexedChangeRequest(String id, int version){

		ChangeRequest changeRequest = new ChangeRequest();
		changeRequest.setId(id);
		changeRequest.setVersion(version);
		return changeRequest;			
		
	}
	
	protected void checkParamsForRemovingChangeRequestList(HfgwUserContext userContext, String hyperledgerNetworkId, 
			String changeRequestIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);
		for(String changeRequestIdItem: changeRequestIds){
			checkerOf(userContext).checkIdOfChangeRequest(changeRequestIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
		
	}
	public  HyperledgerNetwork removeChangeRequestList(HfgwUserContext userContext, String hyperledgerNetworkId, 
			String changeRequestIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingChangeRequestList(userContext, hyperledgerNetworkId,  changeRequestIds, tokensExpr);
			
			
			HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
			synchronized(hyperledgerNetwork){ 
				//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				hyperledgerNetworkDaoOf(userContext).planToRemoveChangeRequestList(hyperledgerNetwork, changeRequestIds, allTokens());
				hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withChangeRequestList().done());
				deleteRelationListInGraph(userContext, hyperledgerNetwork.getChangeRequestList());
				return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingChangeRequest(HfgwUserContext userContext, String hyperledgerNetworkId, 
		String changeRequestId, int changeRequestVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork( hyperledgerNetworkId);
		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		checkerOf(userContext).checkVersionOfChangeRequest(changeRequestVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
	
	}
	public  HyperledgerNetwork removeChangeRequest(HfgwUserContext userContext, String hyperledgerNetworkId, 
		String changeRequestId, int changeRequestVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingChangeRequest(userContext,hyperledgerNetworkId, changeRequestId, changeRequestVersion,tokensExpr);
		
		ChangeRequest changeRequest = createIndexedChangeRequest(changeRequestId, changeRequestVersion);
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
		synchronized(hyperledgerNetwork){ 
			//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			hyperledgerNetwork.removeChangeRequest( changeRequest );		
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withChangeRequestList().done());
			deleteRelationInGraph(userContext, changeRequest);
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingChangeRequest(HfgwUserContext userContext, String hyperledgerNetworkId, 
		String changeRequestId, int changeRequestVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfHyperledgerNetwork( hyperledgerNetworkId);
		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		checkerOf(userContext).checkVersionOfChangeRequest(changeRequestVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
	
	}
	public  HyperledgerNetwork copyChangeRequestFrom(HfgwUserContext userContext, String hyperledgerNetworkId, 
		String changeRequestId, int changeRequestVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingChangeRequest(userContext,hyperledgerNetworkId, changeRequestId, changeRequestVersion,tokensExpr);
		
		ChangeRequest changeRequest = createIndexedChangeRequest(changeRequestId, changeRequestVersion);
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, allTokens());
		synchronized(hyperledgerNetwork){ 
			//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			changeRequest.updateRemoteIp(userContext.getRemoteIP());
			
			hyperledgerNetwork.copyChangeRequestFrom( changeRequest );		
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withChangeRequestList().done());
			
			userContext.getManagerGroup().getChangeRequestManager().onNewInstanceCreated(userContext, (ChangeRequest)hyperledgerNetwork.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingChangeRequest(HfgwUserContext userContext, String hyperledgerNetworkId, String changeRequestId, int changeRequestVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfHyperledgerNetwork(hyperledgerNetworkId);
		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		checkerOf(userContext).checkVersionOfChangeRequest(changeRequestVersion);
		

		if(ChangeRequest.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfChangeRequest(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(HyperledgerNetworkManagerException.class);
	
	}
	
	public  HyperledgerNetwork updateChangeRequest(HfgwUserContext userContext, String hyperledgerNetworkId, String changeRequestId, int changeRequestVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingChangeRequest(userContext, hyperledgerNetworkId, changeRequestId, changeRequestVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withChangeRequestList().searchChangeRequestListWith(ChangeRequest.ID_PROPERTY, "eq", changeRequestId).done();
		
		
		
		HyperledgerNetwork hyperledgerNetwork = loadHyperledgerNetwork(userContext, hyperledgerNetworkId, loadTokens);
		
		synchronized(hyperledgerNetwork){ 
			//Will be good when the hyperledgerNetwork loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//hyperledgerNetwork.removeChangeRequest( changeRequest );	
			//make changes to AcceleraterAccount.
			ChangeRequest changeRequestIndex = createIndexedChangeRequest(changeRequestId, changeRequestVersion);
		
			ChangeRequest changeRequest = hyperledgerNetwork.findTheChangeRequest(changeRequestIndex);
			if(changeRequest == null){
				throw new HyperledgerNetworkManagerException(changeRequest+" is NOT FOUND" );
			}
			
			changeRequest.changeProperty(property, newValueExpr);
			changeRequest.updateRemoteIp(userContext.getRemoteIP());
			hyperledgerNetwork = saveHyperledgerNetwork(userContext, hyperledgerNetwork, tokens().withChangeRequestList().done());
			return present(userContext,hyperledgerNetwork, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(HfgwUserContext userContext, HyperledgerNetwork newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


