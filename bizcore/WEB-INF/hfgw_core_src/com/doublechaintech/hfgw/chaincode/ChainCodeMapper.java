
package com.doublechaintech.hfgw.chaincode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.hfgw.BaseRowMapper;
import com.doublechaintech.hfgw.channel.Channel;

public class ChainCodeMapper extends BaseRowMapper<ChainCode>{
	
	protected ChainCode internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ChainCode chainCode = getChainCode();		
		 		
 		setId(chainCode, rs, rowNumber); 		
 		setName(chainCode, rs, rowNumber); 		
 		setCodeName(chainCode, rs, rowNumber); 		
 		setCodeVersion(chainCode, rs, rowNumber); 		
 		setChannel(chainCode, rs, rowNumber); 		
 		setVersion(chainCode, rs, rowNumber);

		return chainCode;
	}
	
	protected ChainCode getChainCode(){
		return new ChainCode();
	}		
		
	protected void setId(ChainCode chainCode, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ChainCodeTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		chainCode.setId(id);
	}
		
	protected void setName(ChainCode chainCode, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(ChainCodeTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		chainCode.setName(name);
	}
		
	protected void setCodeName(ChainCode chainCode, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String codeName = rs.getString(ChainCodeTable.COLUMN_CODE_NAME);
		if(codeName == null){
			//do nothing when nothing found in database
			return;
		}
		
		chainCode.setCodeName(codeName);
	}
		
	protected void setCodeVersion(ChainCode chainCode, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String codeVersion = rs.getString(ChainCodeTable.COLUMN_CODE_VERSION);
		if(codeVersion == null){
			//do nothing when nothing found in database
			return;
		}
		
		chainCode.setCodeVersion(codeVersion);
	}
		 		
 	protected void setChannel(ChainCode chainCode, ResultSet rs, int rowNumber) throws SQLException{
 		String channelId = rs.getString(ChainCodeTable.COLUMN_CHANNEL);
 		if( channelId == null){
 			return;
 		}
 		if( channelId.isEmpty()){
 			return;
 		}
 		Channel channel = chainCode.getChannel();
 		if( channel != null ){
 			//if the root object 'chainCode' already have the property, just set the id for it;
 			channel.setId(channelId);
 			
 			return;
 		}
 		chainCode.setChannel(createEmptyChannel(channelId));
 	}
 	
	protected void setVersion(ChainCode chainCode, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ChainCodeTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		chainCode.setVersion(version);
	}
		
		

 	protected Channel  createEmptyChannel(String channelId){
 		Channel channel = new Channel();
 		channel.setId(channelId);
 		channel.setVersion(Integer.MAX_VALUE);
 		return channel;
 	}
 	
}


