
package com.doublechaintech.hfgw.channelpeerrole;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.HfgwUserContext;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;

public interface ChannelPeerRoleManager{

		

	public ChannelPeerRole createChannelPeerRole(HfgwUserContext userContext, String channelId,String nodeId,String peerRoleId) throws Exception;	
	public ChannelPeerRole updateChannelPeerRole(HfgwUserContext userContext,String channelPeerRoleId, int channelPeerRoleVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ChannelPeerRole loadChannelPeerRole(HfgwUserContext userContext, String channelPeerRoleId, String [] tokensExpr) throws Exception;
	public ChannelPeerRole internalSaveChannelPeerRole(HfgwUserContext userContext, ChannelPeerRole channelPeerRole) throws Exception;
	public ChannelPeerRole internalSaveChannelPeerRole(HfgwUserContext userContext, ChannelPeerRole channelPeerRole,Map<String,Object>option) throws Exception;
	
	public ChannelPeerRole transferToAnotherChannel(HfgwUserContext userContext, String channelPeerRoleId, String anotherChannelId)  throws Exception;
 	public ChannelPeerRole transferToAnotherNode(HfgwUserContext userContext, String channelPeerRoleId, String anotherNodeId)  throws Exception;
 	public ChannelPeerRole transferToAnotherPeerRole(HfgwUserContext userContext, String channelPeerRoleId, String anotherPeerRoleId)  throws Exception;
 

	public void delete(HfgwUserContext userContext, String channelPeerRoleId, int version) throws Exception;
	public int deleteAll(HfgwUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HfgwUserContext userContext, ChannelPeerRole newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


