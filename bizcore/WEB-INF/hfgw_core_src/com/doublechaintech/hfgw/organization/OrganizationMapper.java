
package com.doublechaintech.hfgw.organization;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.hfgw.BaseRowMapper;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

public class OrganizationMapper extends BaseRowMapper<Organization>{
	
	protected Organization internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Organization organization = getOrganization();		
		 		
 		setId(organization, rs, rowNumber); 		
 		setName(organization, rs, rowNumber); 		
 		setMspid(organization, rs, rowNumber); 		
 		setNetwork(organization, rs, rowNumber); 		
 		setVersion(organization, rs, rowNumber);

		return organization;
	}
	
	protected Organization getOrganization(){
		return new Organization();
	}		
		
	protected void setId(Organization organization, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(OrganizationTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		organization.setId(id);
	}
		
	protected void setName(Organization organization, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(OrganizationTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		organization.setName(name);
	}
		
	protected void setMspid(Organization organization, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String mspid = rs.getString(OrganizationTable.COLUMN_MSPID);
		if(mspid == null){
			//do nothing when nothing found in database
			return;
		}
		
		organization.setMspid(mspid);
	}
		 		
 	protected void setNetwork(Organization organization, ResultSet rs, int rowNumber) throws SQLException{
 		String hyperledgerNetworkId = rs.getString(OrganizationTable.COLUMN_NETWORK);
 		if( hyperledgerNetworkId == null){
 			return;
 		}
 		if( hyperledgerNetworkId.isEmpty()){
 			return;
 		}
 		HyperledgerNetwork hyperledgerNetwork = organization.getNetwork();
 		if( hyperledgerNetwork != null ){
 			//if the root object 'organization' already have the property, just set the id for it;
 			hyperledgerNetwork.setId(hyperledgerNetworkId);
 			
 			return;
 		}
 		organization.setNetwork(createEmptyNetwork(hyperledgerNetworkId));
 	}
 	
	protected void setVersion(Organization organization, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(OrganizationTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		organization.setVersion(version);
	}
		
		

 	protected HyperledgerNetwork  createEmptyNetwork(String hyperledgerNetworkId){
 		HyperledgerNetwork hyperledgerNetwork = new HyperledgerNetwork();
 		hyperledgerNetwork.setId(hyperledgerNetworkId);
 		hyperledgerNetwork.setVersion(Integer.MAX_VALUE);
 		return hyperledgerNetwork;
 	}
 	
}


