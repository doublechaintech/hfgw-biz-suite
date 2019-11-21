
package com.doublechaintech.hfgw.channelpeerrole;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.hfgw.BaseRowMapper;
import com.doublechaintech.hfgw.peerrole.PeerRole;
import com.doublechaintech.hfgw.node.Node;
import com.doublechaintech.hfgw.channel.Channel;

public class ChannelPeerRoleMapper extends BaseRowMapper<ChannelPeerRole>{
	
	protected ChannelPeerRole internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ChannelPeerRole channelPeerRole = getChannelPeerRole();		
		 		
 		setId(channelPeerRole, rs, rowNumber); 		
 		setChannel(channelPeerRole, rs, rowNumber); 		
 		setNode(channelPeerRole, rs, rowNumber); 		
 		setPeerRole(channelPeerRole, rs, rowNumber); 		
 		setVersion(channelPeerRole, rs, rowNumber);

		return channelPeerRole;
	}
	
	protected ChannelPeerRole getChannelPeerRole(){
		return new ChannelPeerRole();
	}		
		
	protected void setId(ChannelPeerRole channelPeerRole, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ChannelPeerRoleTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		channelPeerRole.setId(id);
	}
		 		
 	protected void setChannel(ChannelPeerRole channelPeerRole, ResultSet rs, int rowNumber) throws SQLException{
 		String channelId = rs.getString(ChannelPeerRoleTable.COLUMN_CHANNEL);
 		if( channelId == null){
 			return;
 		}
 		if( channelId.isEmpty()){
 			return;
 		}
 		Channel channel = channelPeerRole.getChannel();
 		if( channel != null ){
 			//if the root object 'channelPeerRole' already have the property, just set the id for it;
 			channel.setId(channelId);
 			
 			return;
 		}
 		channelPeerRole.setChannel(createEmptyChannel(channelId));
 	}
 	 		
 	protected void setNode(ChannelPeerRole channelPeerRole, ResultSet rs, int rowNumber) throws SQLException{
 		String nodeId = rs.getString(ChannelPeerRoleTable.COLUMN_NODE);
 		if( nodeId == null){
 			return;
 		}
 		if( nodeId.isEmpty()){
 			return;
 		}
 		Node node = channelPeerRole.getNode();
 		if( node != null ){
 			//if the root object 'channelPeerRole' already have the property, just set the id for it;
 			node.setId(nodeId);
 			
 			return;
 		}
 		channelPeerRole.setNode(createEmptyNode(nodeId));
 	}
 	 		
 	protected void setPeerRole(ChannelPeerRole channelPeerRole, ResultSet rs, int rowNumber) throws SQLException{
 		String peerRoleId = rs.getString(ChannelPeerRoleTable.COLUMN_PEER_ROLE);
 		if( peerRoleId == null){
 			return;
 		}
 		if( peerRoleId.isEmpty()){
 			return;
 		}
 		PeerRole peerRole = channelPeerRole.getPeerRole();
 		if( peerRole != null ){
 			//if the root object 'channelPeerRole' already have the property, just set the id for it;
 			peerRole.setId(peerRoleId);
 			
 			return;
 		}
 		channelPeerRole.setPeerRole(createEmptyPeerRole(peerRoleId));
 	}
 	
	protected void setVersion(ChannelPeerRole channelPeerRole, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ChannelPeerRoleTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		channelPeerRole.setVersion(version);
	}
		
		

 	protected Channel  createEmptyChannel(String channelId){
 		Channel channel = new Channel();
 		channel.setId(channelId);
 		channel.setVersion(Integer.MAX_VALUE);
 		return channel;
 	}
 	
 	protected Node  createEmptyNode(String nodeId){
 		Node node = new Node();
 		node.setId(nodeId);
 		node.setVersion(Integer.MAX_VALUE);
 		return node;
 	}
 	
 	protected PeerRole  createEmptyPeerRole(String peerRoleId){
 		PeerRole peerRole = new PeerRole();
 		peerRole.setId(peerRoleId);
 		peerRole.setVersion(Integer.MAX_VALUE);
 		return peerRole;
 	}
 	
}


