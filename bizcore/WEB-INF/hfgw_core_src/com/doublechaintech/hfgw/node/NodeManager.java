
package com.doublechaintech.hfgw.node;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.HfgwUserContext;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;

public interface NodeManager{

		

	public Node createNode(HfgwUserContext userContext, String name,String url,String organizationId,String channelId,String networkId,String tlsCacert,String typeId,String address,String contactPerson,String contactTelephone) throws Exception;	
	public Node updateNode(HfgwUserContext userContext,String nodeId, int nodeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Node loadNode(HfgwUserContext userContext, String nodeId, String [] tokensExpr) throws Exception;
	public Node internalSaveNode(HfgwUserContext userContext, Node node) throws Exception;
	public Node internalSaveNode(HfgwUserContext userContext, Node node,Map<String,Object>option) throws Exception;
	
	public Node transferToAnotherOrganization(HfgwUserContext userContext, String nodeId, String anotherOrganizationId)  throws Exception;
 	public Node transferToAnotherChannel(HfgwUserContext userContext, String nodeId, String anotherChannelId)  throws Exception;
 	public Node transferToAnotherNetwork(HfgwUserContext userContext, String nodeId, String anotherNetworkId)  throws Exception;
 	public Node transferToAnotherType(HfgwUserContext userContext, String nodeId, String anotherTypeId)  throws Exception;
 

	public void delete(HfgwUserContext userContext, String nodeId, int version) throws Exception;
	public int deleteAll(HfgwUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HfgwUserContext userContext, Node newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  GrpcOptionManager getGrpcOptionManager(HfgwUserContext userContext, String nodeId, String parameterName, String parameterValue ,String [] tokensExpr)  throws Exception;
	
	public  Node addGrpcOption(HfgwUserContext userContext, String nodeId, String parameterName, String parameterValue , String [] tokensExpr)  throws Exception;
	public  Node removeGrpcOption(HfgwUserContext userContext, String nodeId, String grpcOptionId, int grpcOptionVersion,String [] tokensExpr)  throws Exception;
	public  Node updateGrpcOption(HfgwUserContext userContext, String nodeId, String grpcOptionId, int grpcOptionVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ChannelPeerRoleManager getChannelPeerRoleManager(HfgwUserContext userContext, String nodeId, String channelId, String peerRoleId ,String [] tokensExpr)  throws Exception;
	
	public  Node addChannelPeerRole(HfgwUserContext userContext, String nodeId, String channelId, String peerRoleId , String [] tokensExpr)  throws Exception;
	public  Node removeChannelPeerRole(HfgwUserContext userContext, String nodeId, String channelPeerRoleId, int channelPeerRoleVersion,String [] tokensExpr)  throws Exception;
	public  Node updateChannelPeerRole(HfgwUserContext userContext, String nodeId, String channelPeerRoleId, int channelPeerRoleVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


