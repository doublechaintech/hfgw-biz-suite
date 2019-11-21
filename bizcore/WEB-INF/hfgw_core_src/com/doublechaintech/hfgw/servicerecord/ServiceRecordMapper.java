
package com.doublechaintech.hfgw.servicerecord;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.hfgw.BaseRowMapper;
import com.doublechaintech.hfgw.chaincode.ChainCode;
import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.application.Application;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

public class ServiceRecordMapper extends BaseRowMapper<ServiceRecord>{
	
	protected ServiceRecord internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ServiceRecord serviceRecord = getServiceRecord();		
		 		
 		setId(serviceRecord, rs, rowNumber); 		
 		setName(serviceRecord, rs, rowNumber); 		
 		setPayLoad(serviceRecord, rs, rowNumber); 		
 		setChannel(serviceRecord, rs, rowNumber); 		
 		setChainCode(serviceRecord, rs, rowNumber); 		
 		setChainCodeFunction(serviceRecord, rs, rowNumber); 		
 		setTransactionId(serviceRecord, rs, rowNumber); 		
 		setBlockId(serviceRecord, rs, rowNumber); 		
 		setCreateTime(serviceRecord, rs, rowNumber); 		
 		setApplication(serviceRecord, rs, rowNumber); 		
 		setNetwork(serviceRecord, rs, rowNumber); 		
 		setCurrentStatus(serviceRecord, rs, rowNumber); 		
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
		
	protected void setPayLoad(ServiceRecord serviceRecord, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String payLoad = rs.getString(ServiceRecordTable.COLUMN_PAY_LOAD);
		if(payLoad == null){
			//do nothing when nothing found in database
			return;
		}
		
		serviceRecord.setPayLoad(payLoad);
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
		 		
 	protected void setApplication(ServiceRecord serviceRecord, ResultSet rs, int rowNumber) throws SQLException{
 		String applicationId = rs.getString(ServiceRecordTable.COLUMN_APPLICATION);
 		if( applicationId == null){
 			return;
 		}
 		if( applicationId.isEmpty()){
 			return;
 		}
 		Application application = serviceRecord.getApplication();
 		if( application != null ){
 			//if the root object 'serviceRecord' already have the property, just set the id for it;
 			application.setId(applicationId);
 			
 			return;
 		}
 		serviceRecord.setApplication(createEmptyApplication(applicationId));
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
 	
	protected void setCurrentStatus(ServiceRecord serviceRecord, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String currentStatus = rs.getString(ServiceRecordTable.COLUMN_CURRENT_STATUS);
		if(currentStatus == null){
			//do nothing when nothing found in database
			return;
		}
		
		serviceRecord.setCurrentStatus(currentStatus);
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
 	
 	protected Application  createEmptyApplication(String applicationId){
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
 	
}


