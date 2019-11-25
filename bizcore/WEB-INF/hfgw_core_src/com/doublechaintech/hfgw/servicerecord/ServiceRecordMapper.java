
package com.doublechaintech.hfgw.servicerecord;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.hfgw.BaseRowMapper;
import com.doublechaintech.hfgw.chaincode.ChainCode;
import com.doublechaintech.hfgw.transactionstatus.TransactionStatus;
import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.application.Application;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

public class ServiceRecordMapper extends BaseRowMapper<ServiceRecord>{
	
	protected ServiceRecord internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ServiceRecord serviceRecord = getServiceRecord();		
		 		
 		setId(serviceRecord, rs, rowNumber); 		
 		setName(serviceRecord, rs, rowNumber); 		
 		setPayload(serviceRecord, rs, rowNumber); 		
 		setChannel(serviceRecord, rs, rowNumber); 		
 		setChainCode(serviceRecord, rs, rowNumber); 		
 		setChainCodeFunction(serviceRecord, rs, rowNumber); 		
 		setTransactionId(serviceRecord, rs, rowNumber); 		
 		setBlockId(serviceRecord, rs, rowNumber); 		
 		setCreateTime(serviceRecord, rs, rowNumber); 		
 		setAppClient(serviceRecord, rs, rowNumber); 		
 		setNetwork(serviceRecord, rs, rowNumber); 		
 		setResponse(serviceRecord, rs, rowNumber); 		
 		setStatus(serviceRecord, rs, rowNumber); 		
 		setVersion(serviceRecord, rs, rowNumber);

		return serviceRecord;
	}
	
	protected ServiceRecord getServiceRecord(){
		return new ServiceRecord();
	}		
		
	protected void setId(ServiceRecord serviceRecord, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ServiceRecordTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		serviceRecord.setId(id);
	}
		
	protected void setName(ServiceRecord serviceRecord, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(ServiceRecordTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		serviceRecord.setName(name);
	}
		
	protected void setPayload(ServiceRecord serviceRecord, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String payload = rs.getString(ServiceRecordTable.COLUMN_PAYLOAD);
		if(payload == null){
			//do nothing when nothing found in database
			return;
		}
		
		serviceRecord.setPayload(payload);
	}
		 		
 	protected void setChannel(ServiceRecord serviceRecord, ResultSet rs, int rowNumber) throws SQLException{
 		String channelId = rs.getString(ServiceRecordTable.COLUMN_CHANNEL);
 		if( channelId == null){
 			return;
 		}
 		if( channelId.isEmpty()){
 			return;
 		}
 		Channel channel = serviceRecord.getChannel();
 		if( channel != null ){
 			//if the root object 'serviceRecord' already have the property, just set the id for it;
 			channel.setId(channelId);
 			
 			return;
 		}
 		serviceRecord.setChannel(createEmptyChannel(channelId));
 	}
 	 		
 	protected void setChainCode(ServiceRecord serviceRecord, ResultSet rs, int rowNumber) throws SQLException{
 		String chainCodeId = rs.getString(ServiceRecordTable.COLUMN_CHAIN_CODE);
 		if( chainCodeId == null){
 			return;
 		}
 		if( chainCodeId.isEmpty()){
 			return;
 		}
 		ChainCode chainCode = serviceRecord.getChainCode();
 		if( chainCode != null ){
 			//if the root object 'serviceRecord' already have the property, just set the id for it;
 			chainCode.setId(chainCodeId);
 			
 			return;
 		}
 		serviceRecord.setChainCode(createEmptyChainCode(chainCodeId));
 	}
 	
	protected void setChainCodeFunction(ServiceRecord serviceRecord, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String chainCodeFunction = rs.getString(ServiceRecordTable.COLUMN_CHAIN_CODE_FUNCTION);
		if(chainCodeFunction == null){
			//do nothing when nothing found in database
			return;
		}
		
		serviceRecord.setChainCodeFunction(chainCodeFunction);
	}
		
	protected void setTransactionId(ServiceRecord serviceRecord, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String transactionId = rs.getString(ServiceRecordTable.COLUMN_TRANSACTION_ID);
		if(transactionId == null){
			//do nothing when nothing found in database
			return;
		}
		
		serviceRecord.setTransactionId(transactionId);
	}
		
	protected void setBlockId(ServiceRecord serviceRecord, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String blockId = rs.getString(ServiceRecordTable.COLUMN_BLOCK_ID);
		if(blockId == null){
			//do nothing when nothing found in database
			return;
		}
		
		serviceRecord.setBlockId(blockId);
	}
		
	protected void setCreateTime(ServiceRecord serviceRecord, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date createTime = rs.getTimestamp(ServiceRecordTable.COLUMN_CREATE_TIME);
		if(createTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		serviceRecord.setCreateTime(convertToDateTime(createTime));
	}
		 		
 	protected void setAppClient(ServiceRecord serviceRecord, ResultSet rs, int rowNumber) throws SQLException{
 		String applicationId = rs.getString(ServiceRecordTable.COLUMN_APP_CLIENT);
 		if( applicationId == null){
 			return;
 		}
 		if( applicationId.isEmpty()){
 			return;
 		}
 		Application application = serviceRecord.getAppClient();
 		if( application != null ){
 			//if the root object 'serviceRecord' already have the property, just set the id for it;
 			application.setId(applicationId);
 			
 			return;
 		}
 		serviceRecord.setAppClient(createEmptyAppClient(applicationId));
 	}
 	 		
 	protected void setNetwork(ServiceRecord serviceRecord, ResultSet rs, int rowNumber) throws SQLException{
 		String hyperledgerNetworkId = rs.getString(ServiceRecordTable.COLUMN_NETWORK);
 		if( hyperledgerNetworkId == null){
 			return;
 		}
 		if( hyperledgerNetworkId.isEmpty()){
 			return;
 		}
 		HyperledgerNetwork hyperledgerNetwork = serviceRecord.getNetwork();
 		if( hyperledgerNetwork != null ){
 			//if the root object 'serviceRecord' already have the property, just set the id for it;
 			hyperledgerNetwork.setId(hyperledgerNetworkId);
 			
 			return;
 		}
 		serviceRecord.setNetwork(createEmptyNetwork(hyperledgerNetworkId));
 	}
 	
	protected void setResponse(ServiceRecord serviceRecord, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String response = rs.getString(ServiceRecordTable.COLUMN_RESPONSE);
		if(response == null){
			//do nothing when nothing found in database
			return;
		}
		
		serviceRecord.setResponse(response);
	}
		 		
 	protected void setStatus(ServiceRecord serviceRecord, ResultSet rs, int rowNumber) throws SQLException{
 		String transactionStatusId = rs.getString(ServiceRecordTable.COLUMN_STATUS);
 		if( transactionStatusId == null){
 			return;
 		}
 		if( transactionStatusId.isEmpty()){
 			return;
 		}
 		TransactionStatus transactionStatus = serviceRecord.getStatus();
 		if( transactionStatus != null ){
 			//if the root object 'serviceRecord' already have the property, just set the id for it;
 			transactionStatus.setId(transactionStatusId);
 			
 			return;
 		}
 		serviceRecord.setStatus(createEmptyStatus(transactionStatusId));
 	}
 	
	protected void setVersion(ServiceRecord serviceRecord, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ServiceRecordTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		serviceRecord.setVersion(version);
	}
		
		

 	protected Channel  createEmptyChannel(String channelId){
 		Channel channel = new Channel();
 		channel.setId(channelId);
 		channel.setVersion(Integer.MAX_VALUE);
 		return channel;
 	}
 	
 	protected ChainCode  createEmptyChainCode(String chainCodeId){
 		ChainCode chainCode = new ChainCode();
 		chainCode.setId(chainCodeId);
 		chainCode.setVersion(Integer.MAX_VALUE);
 		return chainCode;
 	}
 	
 	protected Application  createEmptyAppClient(String applicationId){
 		Application application = new Application();
 		application.setId(applicationId);
 		application.setVersion(Integer.MAX_VALUE);
 		return application;
 	}
 	
 	protected HyperledgerNetwork  createEmptyNetwork(String hyperledgerNetworkId){
 		HyperledgerNetwork hyperledgerNetwork = new HyperledgerNetwork();
 		hyperledgerNetwork.setId(hyperledgerNetworkId);
 		hyperledgerNetwork.setVersion(Integer.MAX_VALUE);
 		return hyperledgerNetwork;
 	}
 	
 	protected TransactionStatus  createEmptyStatus(String transactionStatusId){
 		TransactionStatus transactionStatus = new TransactionStatus();
 		transactionStatus.setId(transactionStatusId);
 		transactionStatus.setVersion(Integer.MAX_VALUE);
 		return transactionStatus;
 	}
 	
}


