
package com.doublechaintech.hfgw.channel;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.HfgwUserContext;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;

public interface ChannelManager{

		

	public Channel createChannel(HfgwUserContext userContext, String name,String networkId) throws Exception;	
	public Channel updateChannel(HfgwUserContext userContext,String channelId, int channelVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Channel loadChannel(HfgwUserContext userContext, String channelId, String [] tokensExpr) throws Exception;
	public Channel internalSaveChannel(HfgwUserContext userContext, Channel channel) throws Exception;
	public Channel internalSaveChannel(HfgwUserContext userContext, Channel channel,Map<String,Object>option) throws Exception;
	
	public Channel transferToAnotherNetwork(HfgwUserContext userContext, String channelId, String anotherNetworkId)  throws Exception;
 

	public void delete(HfgwUserContext userContext, String channelId, int version) throws Exception;
	public int deleteAll(HfgwUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HfgwUserContext userContext, Channel newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  NodeManager getNodeManager(HfgwUserContext userContext, String channelId, String name, String url, String organizationId, String networkId, String tlsCacert, String typeId, String address, String contactPerson, String contactTelephone ,String [] tokensExpr)  throws Exception;
	
	public  Channel addNode(HfgwUserContext userContext, String channelId, String name, String url, String organizationId, String networkId, String tlsCacert, String typeId, String address, String contactPerson, String contactTelephone , String [] tokensExpr)  throws Exception;
	public  Channel removeNode(HfgwUserContext userContext, String channelId, String nodeId, int nodeVersion,String [] tokensExpr)  throws Exception;
	public  Channel updateNode(HfgwUserContext userContext, String channelId, String nodeId, int nodeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ChannelPeerRoleManager getChannelPeerRoleManager(HfgwUserContext userContext, String channelId, String nodeId, String peerRoleId ,String [] tokensExpr)  throws Exception;
	
	public  Channel addChannelPeerRole(HfgwUserContext userContext, String channelId, String nodeId, String peerRoleId , String [] tokensExpr)  throws Exception;
	public  Channel removeChannelPeerRole(HfgwUserContext userContext, String channelId, String channelPeerRoleId, int channelPeerRoleVersion,String [] tokensExpr)  throws Exception;
	public  Channel updateChannelPeerRole(HfgwUserContext userContext, String channelId, String channelPeerRoleId, int channelPeerRoleVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ChainCodeManager getChainCodeManager(HfgwUserContext userContext, String channelId, String name, String codeName, String codeVersion ,String [] tokensExpr)  throws Exception;
	
	public  Channel addChainCode(HfgwUserContext userContext, String channelId, String name, String codeName, String codeVersion , String [] tokensExpr)  throws Exception;
	public  Channel removeChainCode(HfgwUserContext userContext, String channelId, String chainCodeId, int chainCodeVersion,String [] tokensExpr)  throws Exception;
	public  Channel updateChainCode(HfgwUserContext userContext, String channelId, String chainCodeId, int chainCodeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ApplicationManager getApplicationManager(HfgwUserContext userContext, String channelId, String name, String mspid, String publicKey, String privateKey, String networkId ,String [] tokensExpr)  throws Exception;
	
	public  Channel addApplication(HfgwUserContext userContext, String channelId, String name, String mspid, String publicKey, String privateKey, String networkId , String [] tokensExpr)  throws Exception;
	public  Channel removeApplication(HfgwUserContext userContext, String channelId, String applicationId, int applicationVersion,String [] tokensExpr)  throws Exception;
	public  Channel updateApplication(HfgwUserContext userContext, String channelId, String applicationId, int applicationVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ServiceRecordManager getServiceRecordManager(HfgwUserContext userContext, String channelId, String name, String payLoad, String chainCodeId, String chainCodeFunction, String transactionId, String blockId, String networkId ,String [] tokensExpr)  throws Exception;
	
	public  Channel addServiceRecord(HfgwUserContext userContext, String channelId, String name, String payLoad, String chainCodeId, String chainCodeFunction, String transactionId, String blockId, String networkId , String [] tokensExpr)  throws Exception;
	public  Channel removeServiceRecord(HfgwUserContext userContext, String channelId, String serviceRecordId, int serviceRecordVersion,String [] tokensExpr)  throws Exception;
	public  Channel updateServiceRecord(HfgwUserContext userContext, String channelId, String serviceRecordId, int serviceRecordVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  Channel associateServiceRecordListToNewApplication(HfgwUserContext userContext, String channelId, String  serviceRecordIds[], String name, String mspid, String publicKey, String privateKey, String channelId, String networkId, String [] tokensExpr) throws Exception ;
	public  Channel associateServiceRecordListToApplication(HfgwUserContext userContext, String channelId, String  serviceRecordIds[],String applicationId, String [] tokensExpr) throws Exception ;

	*/



}


