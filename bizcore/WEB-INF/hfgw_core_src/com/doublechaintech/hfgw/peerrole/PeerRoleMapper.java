
package com.doublechaintech.hfgw.peerrole;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.hfgw.BaseRowMapper;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

public class PeerRoleMapper extends BaseRowMapper<PeerRole>{
	
	protected PeerRole internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		PeerRole peerRole = getPeerRole();		
		 		
 		setId(peerRole, rs, rowNumber); 		
 		setName(peerRole, rs, rowNumber); 		
 		setCode(peerRole, rs, rowNumber); 		
 		setNetwork(peerRole, rs, rowNumber); 		
 		setVersion(peerRole, rs, rowNumber);

		return peerRole;
	}
	
	protected PeerRole getPeerRole(){
		return new PeerRole();
	}		
		
	protected void setId(PeerRole peerRole, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(PeerRoleTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		peerRole.setId(id);
	}
		
	protected void setName(PeerRole peerRole, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(PeerRoleTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		peerRole.setName(name);
	}
		
	protected void setCode(PeerRole peerRole, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String code = rs.getString(PeerRoleTable.COLUMN_CODE);
		if(code == null){
			//do nothing when nothing found in database
			return;
		}
		
		peerRole.setCode(code);
	}
		 		
 	protected void setNetwork(PeerRole peerRole, ResultSet rs, int rowNumber) throws SQLException{
 		String hyperledgerNetworkId = rs.getString(PeerRoleTable.COLUMN_NETWORK);
 		if( hyperledgerNetworkId == null){
 			return;
 		}
 		if( hyperledgerNetworkId.isEmpty()){
 			return;
 		}
 		HyperledgerNetwork hyperledgerNetwork = peerRole.getNetwork();
 		if( hyperledgerNetwork != null ){
 			//if the root object 'peerRole' already have the property, just set the id for it;
 			hyperledgerNetwork.setId(hyperledgerNetworkId);
 			
 			return;
 		}
 		peerRole.setNetwork(createEmptyNetwork(hyperledgerNetworkId));
 	}
 	
	protected void setVersion(PeerRole peerRole, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(PeerRoleTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		peerRole.setVersion(version);
	}
		
		

 	protected HyperledgerNetwork  createEmptyNetwork(String hyperledgerNetworkId){
 		HyperledgerNetwork hyperledgerNetwork = new HyperledgerNetwork();
 		hyperledgerNetwork.setId(hyperledgerNetworkId);
 		hyperledgerNetwork.setVersion(Integer.MAX_VALUE);
 		return hyperledgerNetwork;
 	}
 	
}


