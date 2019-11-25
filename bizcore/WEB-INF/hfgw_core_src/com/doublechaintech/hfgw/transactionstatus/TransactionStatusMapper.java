
package com.doublechaintech.hfgw.transactionstatus;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.hfgw.BaseRowMapper;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

public class TransactionStatusMapper extends BaseRowMapper<TransactionStatus>{
	
	protected TransactionStatus internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		TransactionStatus transactionStatus = getTransactionStatus();		
		 		
 		setId(transactionStatus, rs, rowNumber); 		
 		setName(transactionStatus, rs, rowNumber); 		
 		setCode(transactionStatus, rs, rowNumber); 		
 		setNetwork(transactionStatus, rs, rowNumber); 		
 		setVersion(transactionStatus, rs, rowNumber);

		return transactionStatus;
	}
	
	protected TransactionStatus getTransactionStatus(){
		return new TransactionStatus();
	}		
		
	protected void setId(TransactionStatus transactionStatus, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(TransactionStatusTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		transactionStatus.setId(id);
	}
		
	protected void setName(TransactionStatus transactionStatus, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(TransactionStatusTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		transactionStatus.setName(name);
	}
		
	protected void setCode(TransactionStatus transactionStatus, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String code = rs.getString(TransactionStatusTable.COLUMN_CODE);
		if(code == null){
			//do nothing when nothing found in database
			return;
		}
		
		transactionStatus.setCode(code);
	}
		 		
 	protected void setNetwork(TransactionStatus transactionStatus, ResultSet rs, int rowNumber) throws SQLException{
 		String hyperledgerNetworkId = rs.getString(TransactionStatusTable.COLUMN_NETWORK);
 		if( hyperledgerNetworkId == null){
 			return;
 		}
 		if( hyperledgerNetworkId.isEmpty()){
 			return;
 		}
 		HyperledgerNetwork hyperledgerNetwork = transactionStatus.getNetwork();
 		if( hyperledgerNetwork != null ){
 			//if the root object 'transactionStatus' already have the property, just set the id for it;
 			hyperledgerNetwork.setId(hyperledgerNetworkId);
 			
 			return;
 		}
 		transactionStatus.setNetwork(createEmptyNetwork(hyperledgerNetworkId));
 	}
 	
	protected void setVersion(TransactionStatus transactionStatus, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(TransactionStatusTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		transactionStatus.setVersion(version);
	}
		
		

 	protected HyperledgerNetwork  createEmptyNetwork(String hyperledgerNetworkId){
 		HyperledgerNetwork hyperledgerNetwork = new HyperledgerNetwork();
 		hyperledgerNetwork.setId(hyperledgerNetworkId);
 		hyperledgerNetwork.setVersion(Integer.MAX_VALUE);
 		return hyperledgerNetwork;
 	}
 	
}


