
package com.doublechaintech.hfgw.hyperledgernetwork;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.HfgwUserContext;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;

public interface HyperledgerNetworkManager{

		

	public HyperledgerNetwork createHyperledgerNetwork(HfgwUserContext userContext, String name,String description) throws Exception;	
	public HyperledgerNetwork updateHyperledgerNetwork(HfgwUserContext userContext,String hyperledgerNetworkId, int hyperledgerNetworkVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public HyperledgerNetwork loadHyperledgerNetwork(HfgwUserContext userContext, String hyperledgerNetworkId, String [] tokensExpr) throws Exception;
	public HyperledgerNetwork internalSaveHyperledgerNetwork(HfgwUserContext userContext, HyperledgerNetwork hyperledgerNetwork) throws Exception;
	public HyperledgerNetwork internalSaveHyperledgerNetwork(HfgwUserContext userContext, HyperledgerNetwork hyperledgerNetwork,Map<String,Object>option) throws Exception;
	


	public void delete(HfgwUserContext userContext, String hyperledgerNetworkId, int version) throws Exception;
	public int deleteAll(HfgwUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HfgwUserContext userContext, HyperledgerNetwork newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  OrganizationManager getOrganizationManager(HfgwUserContext userContext, String hyperledgerNetworkId, String name, String mspid ,String [] tokensExpr)  throws Exception;
	
	public  HyperledgerNetwork addOrganization(HfgwUserContext userContext, String hyperledgerNetworkId, String name, String mspid , String [] tokensExpr)  throws Exception;
	public  HyperledgerNetwork removeOrganization(HfgwUserContext userContext, String hyperledgerNetworkId, String organizationId, int organizationVersion,String [] tokensExpr)  throws Exception;
	public  HyperledgerNetwork updateOrganization(HfgwUserContext userContext, String hyperledgerNetworkId, String organizationId, int organizationVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  NodeTypeManager getNodeTypeManager(HfgwUserContext userContext, String hyperledgerNetworkId, String name, String code, String address, String contactPerson, String contactTelephone ,String [] tokensExpr)  throws Exception;
	
	public  HyperledgerNetwork addNodeType(HfgwUserContext userContext, String hyperledgerNetworkId, String name, String code, String address, String contactPerson, String contactTelephone , String [] tokensExpr)  throws Exception;
	public  HyperledgerNetwork removeNodeType(HfgwUserContext userContext, String hyperledgerNetworkId, String nodeTypeId, int nodeTypeVersion,String [] tokensExpr)  throws Exception;
	public  HyperledgerNetwork updateNodeType(HfgwUserContext userContext, String hyperledgerNetworkId, String nodeTypeId, int nodeTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ChannelManager getChannelManager(HfgwUserContext userContext, String hyperledgerNetworkId, String name ,String [] tokensExpr)  throws Exception;
	
	public  HyperledgerNetwork addChannel(HfgwUserContext userContext, String hyperledgerNetworkId, String name , String [] tokensExpr)  throws Exception;
	public  HyperledgerNetwork removeChannel(HfgwUserContext userContext, String hyperledgerNetworkId, String channelId, int channelVersion,String [] tokensExpr)  throws Exception;
	public  HyperledgerNetwork updateChannel(HfgwUserContext userContext, String hyperledgerNetworkId, String channelId, int channelVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ApplicationManager getApplicationManager(HfgwUserContext userContext, String hyperledgerNetworkId, String name, String mspid, String publicKey, String privateKey, String channelId ,String [] tokensExpr)  throws Exception;
	
	public  HyperledgerNetwork addApplication(HfgwUserContext userContext, String hyperledgerNetworkId, String name, String mspid, String publicKey, String privateKey, String channelId , String [] tokensExpr)  throws Exception;
	public  HyperledgerNetwork removeApplication(HfgwUserContext userContext, String hyperledgerNetworkId, String applicationId, int applicationVersion,String [] tokensExpr)  throws Exception;
	public  HyperledgerNetwork updateApplication(HfgwUserContext userContext, String hyperledgerNetworkId, String applicationId, int applicationVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ServiceRecordManager getServiceRecordManager(HfgwUserContext userContext, String hyperledgerNetworkId, String name, String payLoad, String channelId, String chainCodeId, String transactionId, String blockId ,String [] tokensExpr)  throws Exception;
	
	public  HyperledgerNetwork addServiceRecord(HfgwUserContext userContext, String hyperledgerNetworkId, String name, String payLoad, String channelId, String chainCodeId, String transactionId, String blockId , String [] tokensExpr)  throws Exception;
	public  HyperledgerNetwork removeServiceRecord(HfgwUserContext userContext, String hyperledgerNetworkId, String serviceRecordId, int serviceRecordVersion,String [] tokensExpr)  throws Exception;
	public  HyperledgerNetwork updateServiceRecord(HfgwUserContext userContext, String hyperledgerNetworkId, String serviceRecordId, int serviceRecordVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  HyperledgerNetwork associateServiceRecordListToNewApplication(HfgwUserContext userContext, String hyperledgerNetworkId, String  serviceRecordIds[], String name, String mspid, String publicKey, String privateKey, String channelId, String networkId, String [] tokensExpr) throws Exception ;
	public  HyperledgerNetwork associateServiceRecordListToApplication(HfgwUserContext userContext, String hyperledgerNetworkId, String  serviceRecordIds[],String applicationId, String [] tokensExpr) throws Exception ;

	*/

	//public  ChangeRequestTypeManager getChangeRequestTypeManager(HfgwUserContext userContext, String hyperledgerNetworkId, String name, String code, String icon, int displayOrder, String bindTypes, String stepConfiguration ,String [] tokensExpr)  throws Exception;
	
	public  HyperledgerNetwork addChangeRequestType(HfgwUserContext userContext, String hyperledgerNetworkId, String name, String code, String icon, int displayOrder, String bindTypes, String stepConfiguration , String [] tokensExpr)  throws Exception;
	public  HyperledgerNetwork removeChangeRequestType(HfgwUserContext userContext, String hyperledgerNetworkId, String changeRequestTypeId, int changeRequestTypeVersion,String [] tokensExpr)  throws Exception;
	public  HyperledgerNetwork updateChangeRequestType(HfgwUserContext userContext, String hyperledgerNetworkId, String changeRequestTypeId, int changeRequestTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ChangeRequestManager getChangeRequestManager(HfgwUserContext userContext, String hyperledgerNetworkId, String name, String requestTypeId ,String [] tokensExpr)  throws Exception;
	
	public  HyperledgerNetwork addChangeRequest(HfgwUserContext userContext, String hyperledgerNetworkId, String name, String requestTypeId , String [] tokensExpr)  throws Exception;
	public  HyperledgerNetwork removeChangeRequest(HfgwUserContext userContext, String hyperledgerNetworkId, String changeRequestId, int changeRequestVersion,String [] tokensExpr)  throws Exception;
	public  HyperledgerNetwork updateChangeRequest(HfgwUserContext userContext, String hyperledgerNetworkId, String changeRequestId, int changeRequestVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


