
package com.doublechaintech.hfgw.changerequesttype;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.hfgw.BaseRowMapper;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

public class ChangeRequestTypeMapper extends BaseRowMapper<ChangeRequestType>{
	
	protected ChangeRequestType internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ChangeRequestType changeRequestType = getChangeRequestType();		
		 		
 		setId(changeRequestType, rs, rowNumber); 		
 		setName(changeRequestType, rs, rowNumber); 		
 		setCode(changeRequestType, rs, rowNumber); 		
 		setIcon(changeRequestType, rs, rowNumber); 		
 		setDisplayOrder(changeRequestType, rs, rowNumber); 		
 		setBindTypes(changeRequestType, rs, rowNumber); 		
 		setStepConfiguration(changeRequestType, rs, rowNumber); 		
 		setNetwork(changeRequestType, rs, rowNumber); 		
 		setVersion(changeRequestType, rs, rowNumber);

		return changeRequestType;
	}
	
	protected ChangeRequestType getChangeRequestType(){
		return new ChangeRequestType();
	}		
		
	protected void setId(ChangeRequestType changeRequestType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ChangeRequestTypeTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		changeRequestType.setId(id);
	}
		
	protected void setName(ChangeRequestType changeRequestType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(ChangeRequestTypeTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		changeRequestType.setName(name);
	}
		
	protected void setCode(ChangeRequestType changeRequestType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String code = rs.getString(ChangeRequestTypeTable.COLUMN_CODE);
		if(code == null){
			//do nothing when nothing found in database
			return;
		}
		
		changeRequestType.setCode(code);
	}
		
	protected void setIcon(ChangeRequestType changeRequestType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String icon = rs.getString(ChangeRequestTypeTable.COLUMN_ICON);
		if(icon == null){
			//do nothing when nothing found in database
			return;
		}
		
		changeRequestType.setIcon(icon);
	}
		
	protected void setDisplayOrder(ChangeRequestType changeRequestType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer displayOrder = rs.getInt(ChangeRequestTypeTable.COLUMN_DISPLAY_ORDER);
		if(displayOrder == null){
			//do nothing when nothing found in database
			return;
		}
		
		changeRequestType.setDisplayOrder(displayOrder);
	}
		
	protected void setBindTypes(ChangeRequestType changeRequestType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String bindTypes = rs.getString(ChangeRequestTypeTable.COLUMN_BIND_TYPES);
		if(bindTypes == null){
			//do nothing when nothing found in database
			return;
		}
		
		changeRequestType.setBindTypes(bindTypes);
	}
		
	protected void setStepConfiguration(ChangeRequestType changeRequestType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String stepConfiguration = rs.getString(ChangeRequestTypeTable.COLUMN_STEP_CONFIGURATION);
		if(stepConfiguration == null){
			//do nothing when nothing found in database
			return;
		}
		
		changeRequestType.setStepConfiguration(stepConfiguration);
	}
		 		
 	protected void setNetwork(ChangeRequestType changeRequestType, ResultSet rs, int rowNumber) throws SQLException{
 		String hyperledgerNetworkId = rs.getString(ChangeRequestTypeTable.COLUMN_NETWORK);
 		if( hyperledgerNetworkId == null){
 			return;
 		}
 		if( hyperledgerNetworkId.isEmpty()){
 			return;
 		}
 		HyperledgerNetwork hyperledgerNetwork = changeRequestType.getNetwork();
 		if( hyperledgerNetwork != null ){
 			//if the root object 'changeRequestType' already have the property, just set the id for it;
 			hyperledgerNetwork.setId(hyperledgerNetworkId);
 			
 			return;
 		}
 		changeRequestType.setNetwork(createEmptyNetwork(hyperledgerNetworkId));
 	}
 	
	protected void setVersion(ChangeRequestType changeRequestType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ChangeRequestTypeTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		changeRequestType.setVersion(version);
	}
		
		

 	protected HyperledgerNetwork  createEmptyNetwork(String hyperledgerNetworkId){
 		HyperledgerNetwork hyperledgerNetwork = new HyperledgerNetwork();
 		hyperledgerNetwork.setId(hyperledgerNetworkId);
 		hyperledgerNetwork.setVersion(Integer.MAX_VALUE);
 		return hyperledgerNetwork;
 	}
 	
}


