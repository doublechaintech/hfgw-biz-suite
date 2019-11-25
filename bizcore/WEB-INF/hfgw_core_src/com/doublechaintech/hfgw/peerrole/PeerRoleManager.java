
package com.doublechaintech.hfgw.peerrole;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.HfgwUserContext;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;

public interface PeerRoleManager{

		
	

	public PeerRole loadPeerRoleWithCode(HfgwUserContext userContext, String code, Map<String,Object>tokens) throws Exception;

	 

	public PeerRole createPeerRole(HfgwUserContext userContext, String name,String code,String networkId) throws Exception;	
	public PeerRole updatePeerRole(HfgwUserContext userContext,String peerRoleId, int peerRoleVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public PeerRole loadPeerRole(HfgwUserContext userContext, String peerRoleId, String [] tokensExpr) throws Exception;
	public PeerRole internalSavePeerRole(HfgwUserContext userContext, PeerRole peerRole) throws Exception;
	public PeerRole internalSavePeerRole(HfgwUserContext userContext, PeerRole peerRole,Map<String,Object>option) throws Exception;
	
	public PeerRole transferToAnotherNetwork(HfgwUserContext userContext, String peerRoleId, String anotherNetworkId)  throws Exception;
 

	public void delete(HfgwUserContext userContext, String peerRoleId, int version) throws Exception;
	public int deleteAll(HfgwUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HfgwUserContext userContext, PeerRole newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ChannelPeerRoleManager getChannelPeerRoleManager(HfgwUserContext userContext, String peerRoleId, String channelId, String nodeId ,String [] tokensExpr)  throws Exception;
	
	public  PeerRole addChannelPeerRole(HfgwUserContext userContext, String peerRoleId, String channelId, String nodeId , String [] tokensExpr)  throws Exception;
	public  PeerRole removeChannelPeerRole(HfgwUserContext userContext, String peerRoleId, String channelPeerRoleId, int channelPeerRoleVersion,String [] tokensExpr)  throws Exception;
	public  PeerRole updateChannelPeerRole(HfgwUserContext userContext, String peerRoleId, String channelPeerRoleId, int channelPeerRoleVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


