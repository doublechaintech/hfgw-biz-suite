
package com.doublechaintech.hfgw.node;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.hfgw.BaseRowMapper;
import com.doublechaintech.hfgw.organization.Organization;
import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.nodetype.NodeType;

public class NodeMapper extends BaseRowMapper<Node>{
	
	protected Node internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Node node = getNode();		
		 		
 		setId(node, rs, rowNumber); 		
 		setName(node, rs, rowNumber); 		
 		setUrl(node, rs, rowNumber); 		
 		setOrganization(node, rs, rowNumber); 		
 		setChannel(node, rs, rowNumber); 		
 		setType(node, rs, rowNumber); 		
 		setVersion(node, rs, rowNumber);

		return node;
	}
	
	protected Node getNode(){
		return new Node();
	}		
		
	protected void setId(Node node, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(NodeTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		node.setId(id);
	}
		
	protected void setName(Node node, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(NodeTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		node.setName(name);
	}
		
	protected void setUrl(Node node, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String url = rs.getString(NodeTable.COLUMN_URL);
		if(url == null){
			//do nothing when nothing found in database
			return;
		}
		
		node.setUrl(url);
	}
		 		
 	protected void setOrganization(Node node, ResultSet rs, int rowNumber) throws SQLException{
 		String organizationId = rs.getString(NodeTable.COLUMN_ORGANIZATION);
 		if( organizationId == null){
 			return;
 		}
 		if( organizationId.isEmpty()){
 			return;
 		}
 		Organization organization = node.getOrganization();
 		if( organization != null ){
 			//if the root object 'node' already have the property, just set the id for it;
 			organization.setId(organizationId);
 			
 			return;
 		}
 		node.setOrganization(createEmptyOrganization(organizationId));
 	}
 	 		
 	protected void setChannel(Node node, ResultSet rs, int rowNumber) throws SQLException{
 		String channelId = rs.getString(NodeTable.COLUMN_CHANNEL);
 		if( channelId == null){
 			return;
 		}
 		if( channelId.isEmpty()){
 			return;
 		}
 		Channel channel = node.getChannel();
 		if( channel != null ){
 			//if the root object 'node' already have the property, just set the id for it;
 			channel.setId(channelId);
 			
 			return;
 		}
 		node.setChannel(createEmptyChannel(channelId));
 	}
 	 		
 	protected void setType(Node node, ResultSet rs, int rowNumber) throws SQLException{
 		String nodeTypeId = rs.getString(NodeTable.COLUMN_TYPE);
 		if( nodeTypeId == null){
 			return;
 		}
 		if( nodeTypeId.isEmpty()){
 			return;
 		}
 		NodeType nodeType = node.getType();
 		if( nodeType != null ){
 			//if the root object 'node' already have the property, just set the id for it;
 			nodeType.setId(nodeTypeId);
 			
 			return;
 		}
 		node.setType(createEmptyType(nodeTypeId));
 	}
 	
	protected void setVersion(Node node, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(NodeTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		node.setVersion(version);
	}
		
		

 	protected Organization  createEmptyOrganization(String organizationId){
 		Organization organization = new Organization();
 		organization.setId(organizationId);
 		organization.setVersion(Integer.MAX_VALUE);
 		return organization;
 	}
 	
 	protected Channel  createEmptyChannel(String channelId){
 		Channel channel = new Channel();
 		channel.setId(channelId);
 		channel.setVersion(Integer.MAX_VALUE);
 		return channel;
 	}
 	
 	protected NodeType  createEmptyType(String nodeTypeId){
 		NodeType nodeType = new NodeType();
 		nodeType.setId(nodeTypeId);
 		nodeType.setVersion(Integer.MAX_VALUE);
 		return nodeType;
 	}
 	
}


