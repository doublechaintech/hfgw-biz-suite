
package com.doublechaintech.hfgw.chaincodeinvoker;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.hfgw.BaseRowMapper;
import com.doublechaintech.hfgw.chaincode.ChainCode;
import com.doublechaintech.hfgw.changerequest.ChangeRequest;
import com.doublechaintech.hfgw.application.Application;

public class ChainCodeInvokerMapper extends BaseRowMapper<ChainCodeInvoker>{
	
	protected ChainCodeInvoker internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ChainCodeInvoker chainCodeInvoker = getChainCodeInvoker();		
		 		
 		setId(chainCodeInvoker, rs, rowNumber); 		
 		setAppClient(chainCodeInvoker, rs, rowNumber); 		
 		setChainCode(chainCodeInvoker, rs, rowNumber); 		
 		setParameters(chainCodeInvoker, rs, rowNumber); 		
 		setChangeRequest(chainCodeInvoker, rs, rowNumber); 		
 		setVersion(chainCodeInvoker, rs, rowNumber);

		return chainCodeInvoker;
	}
	
	protected ChainCodeInvoker getChainCodeInvoker(){
		return new ChainCodeInvoker();
	}		
		
	protected void setId(ChainCodeInvoker chainCodeInvoker, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ChainCodeInvokerTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		chainCodeInvoker.setId(id);
	}
		 		
 	protected void setAppClient(ChainCodeInvoker chainCodeInvoker, ResultSet rs, int rowNumber) throws SQLException{
 		String applicationId = rs.getString(ChainCodeInvokerTable.COLUMN_APP_CLIENT);
 		if( applicationId == null){
 			return;
 		}
 		if( applicationId.isEmpty()){
 			return;
 		}
 		Application application = chainCodeInvoker.getAppClient();
 		if( application != null ){
 			//if the root object 'chainCodeInvoker' already have the property, just set the id for it;
 			application.setId(applicationId);
 			
 			return;
 		}
 		chainCodeInvoker.setAppClient(createEmptyAppClient(applicationId));
 	}
 	 		
 	protected void setChainCode(ChainCodeInvoker chainCodeInvoker, ResultSet rs, int rowNumber) throws SQLException{
 		String chainCodeId = rs.getString(ChainCodeInvokerTable.COLUMN_CHAIN_CODE);
 		if( chainCodeId == null){
 			return;
 		}
 		if( chainCodeId.isEmpty()){
 			return;
 		}
 		ChainCode chainCode = chainCodeInvoker.getChainCode();
 		if( chainCode != null ){
 			//if the root object 'chainCodeInvoker' already have the property, just set the id for it;
 			chainCode.setId(chainCodeId);
 			
 			return;
 		}
 		chainCodeInvoker.setChainCode(createEmptyChainCode(chainCodeId));
 	}
 	
	protected void setParameters(ChainCodeInvoker chainCodeInvoker, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String parameters = rs.getString(ChainCodeInvokerTable.COLUMN_PARAMETERS);
		if(parameters == null){
			//do nothing when nothing found in database
			return;
		}
		
		chainCodeInvoker.setParameters(parameters);
	}
		 		
 	protected void setChangeRequest(ChainCodeInvoker chainCodeInvoker, ResultSet rs, int rowNumber) throws SQLException{
 		String changeRequestId = rs.getString(ChainCodeInvokerTable.COLUMN_CHANGE_REQUEST);
 		if( changeRequestId == null){
 			return;
 		}
 		if( changeRequestId.isEmpty()){
 			return;
 		}
 		ChangeRequest changeRequest = chainCodeInvoker.getChangeRequest();
 		if( changeRequest != null ){
 			//if the root object 'chainCodeInvoker' already have the property, just set the id for it;
 			changeRequest.setId(changeRequestId);
 			
 			return;
 		}
 		chainCodeInvoker.setChangeRequest(createEmptyChangeRequest(changeRequestId));
 	}
 	
	protected void setVersion(ChainCodeInvoker chainCodeInvoker, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ChainCodeInvokerTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		chainCodeInvoker.setVersion(version);
	}
		
		

 	protected Application  createEmptyAppClient(String applicationId){
 		Application application = new Application();
 		application.setId(applicationId);
 		application.setVersion(Integer.MAX_VALUE);
 		return application;
 	}
 	
 	protected ChainCode  createEmptyChainCode(String chainCodeId){
 		ChainCode chainCode = new ChainCode();
 		chainCode.setId(chainCodeId);
 		chainCode.setVersion(Integer.MAX_VALUE);
 		return chainCode;
 	}
 	
 	protected ChangeRequest  createEmptyChangeRequest(String changeRequestId){
 		ChangeRequest changeRequest = new ChangeRequest();
 		changeRequest.setId(changeRequestId);
 		changeRequest.setVersion(Integer.MAX_VALUE);
 		return changeRequest;
 	}
 	
}


