
package com.doublechaintech.hfgw.hyperledgernetwork;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.hfgw.BaseRowMapper;

public class HyperledgerNetworkMapper extends BaseRowMapper<HyperledgerNetwork>{
	
	protected HyperledgerNetwork internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		HyperledgerNetwork hyperledgerNetwork = getHyperledgerNetwork();		
		 		
 		setId(hyperledgerNetwork, rs, rowNumber); 		
 		setName(hyperledgerNetwork, rs, rowNumber); 		
 		setDescription(hyperledgerNetwork, rs, rowNumber); 		
 		setVersion(hyperledgerNetwork, rs, rowNumber);

		return hyperledgerNetwork;
	}
	
	protected HyperledgerNetwork getHyperledgerNetwork(){
		return new HyperledgerNetwork();
	}		
		
	protected void setId(HyperledgerNetwork hyperledgerNetwork, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(HyperledgerNetworkTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		hyperledgerNetwork.setId(id);
	}
		
	protected void setName(HyperledgerNetwork hyperledgerNetwork, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(HyperledgerNetworkTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		hyperledgerNetwork.setName(name);
	}
		
	protected void setDescription(HyperledgerNetwork hyperledgerNetwork, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String description = rs.getString(HyperledgerNetworkTable.COLUMN_DESCRIPTION);
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		hyperledgerNetwork.setDescription(description);
	}
		
	protected void setVersion(HyperledgerNetwork hyperledgerNetwork, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(HyperledgerNetworkTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		hyperledgerNetwork.setVersion(version);
	}
		
		

}


