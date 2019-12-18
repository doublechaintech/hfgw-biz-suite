
package com.doublechaintech.hfgw.nodetype;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.hfgw.BaseRowMapper;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

public class NodeTypeMapper extends BaseRowMapper<NodeType>{
	
	protected NodeType internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		NodeType nodeType = getNodeType();		
		 		
 		setId(nodeType, rs, rowNumber); 		
 		setName(nodeType, rs, rowNumber); 		
 		setCode(nodeType, rs, rowNumber); 		
 		setNetwork(nodeType, rs, rowNumber); 		
 		setVersion(nodeType, rs, rowNumber);

		return nodeType;
	}
	
	protected NodeType getNodeType(){
		return new NodeType();
	}		
		
	protected void setId(NodeType nodeType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(NodeTypeTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		nodeType.setId(id);
	}
		
	protected void setName(NodeType nodeType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(NodeTypeTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		nodeType.setName(name);
	}
		
	protected void setCode(NodeType nodeType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String code = rs.getString(NodeTypeTable.COLUMN_CODE);
		if(code == null){
			//do nothing when nothing found in database
			return;
		}
		
		nodeType.setCode(code);
	}
		 		
 	protected void setNetwork(NodeType nodeType, ResultSet rs, int rowNumber) throws SQLException{
 		String hyperledgerNetworkId = rs.getString(NodeTypeTable.COLUMN_NETWORK);
 		if( hyperledgerNetworkId == null){
 			return;
 		}
 		if( hyperledgerNetworkId.isEmpty()){
 			return;
 		}
 		HyperledgerNetwork hyperledgerNetwork = nodeType.getNetwork();
 		if( hyperledgerNetwork != null ){
 			//if the root object 'nodeType' already have the property, just set the id for it;
 			hyperledgerNetwork.setId(hyperledgerNetworkId);
 			
 			return;
 		}
 		nodeType.setNetwork(createEmptyNetwork(hyperledgerNetworkId));
 	}
 	
	protected void setVersion(NodeType nodeType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(NodeTypeTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		nodeType.setVersion(version);
	}
		
		

 	protected HyperledgerNetwork  createEmptyNetwork(String hyperledgerNetworkId){
 		HyperledgerNetwork hyperledgerNetwork = new HyperledgerNetwork();
 		hyperledgerNetwork.setId(hyperledgerNetworkId);
 		hyperledgerNetwork.setVersion(Integer.MAX_VALUE);
 		return hyperledgerNetwork;
 	}
 	
}


