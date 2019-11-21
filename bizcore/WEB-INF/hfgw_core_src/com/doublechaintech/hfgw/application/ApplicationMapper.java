
package com.doublechaintech.hfgw.application;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.hfgw.BaseRowMapper;
import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

public class ApplicationMapper extends BaseRowMapper<Application>{
	
	protected Application internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Application application = getApplication();		
		 		
 		setId(application, rs, rowNumber); 		
 		setName(application, rs, rowNumber); 		
 		setCreateTime(application, rs, rowNumber); 		
 		setMspid(application, rs, rowNumber); 		
 		setPublicKey(application, rs, rowNumber); 		
 		setPrivateKey(application, rs, rowNumber); 		
 		setChannel(application, rs, rowNumber); 		
 		setNetwork(application, rs, rowNumber); 		
 		setVersion(application, rs, rowNumber);

		return application;
	}
	
	protected Application getApplication(){
		return new Application();
	}		
		
	protected void setId(Application application, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ApplicationTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		application.setId(id);
	}
		
	protected void setName(Application application, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(ApplicationTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		application.setName(name);
	}
		
	protected void setCreateTime(Application application, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date createTime = rs.getTimestamp(ApplicationTable.COLUMN_CREATE_TIME);
		if(createTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		application.setCreateTime(convertToDateTime(createTime));
	}
		
	protected void setMspid(Application application, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String mspid = rs.getString(ApplicationTable.COLUMN_MSPID);
		if(mspid == null){
			//do nothing when nothing found in database
			return;
		}
		
		application.setMspid(mspid);
	}
		
	protected void setPublicKey(Application application, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String publicKey = rs.getString(ApplicationTable.COLUMN_PUBLIC_KEY);
		if(publicKey == null){
			//do nothing when nothing found in database
			return;
		}
		
		application.setPublicKey(publicKey);
	}
		
	protected void setPrivateKey(Application application, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String privateKey = rs.getString(ApplicationTable.COLUMN_PRIVATE_KEY);
		if(privateKey == null){
			//do nothing when nothing found in database
			return;
		}
		
		application.setPrivateKey(privateKey);
	}
		 		
 	protected void setChannel(Application application, ResultSet rs, int rowNumber) throws SQLException{
 		String channelId = rs.getString(ApplicationTable.COLUMN_CHANNEL);
 		if( channelId == null){
 			return;
 		}
 		if( channelId.isEmpty()){
 			return;
 		}
 		Channel channel = application.getChannel();
 		if( channel != null ){
 			//if the root object 'application' already have the property, just set the id for it;
 			channel.setId(channelId);
 			
 			return;
 		}
 		application.setChannel(createEmptyChannel(channelId));
 	}
 	 		
 	protected void setNetwork(Application application, ResultSet rs, int rowNumber) throws SQLException{
 		String hyperledgerNetworkId = rs.getString(ApplicationTable.COLUMN_NETWORK);
 		if( hyperledgerNetworkId == null){
 			return;
 		}
 		if( hyperledgerNetworkId.isEmpty()){
 			return;
 		}
 		HyperledgerNetwork hyperledgerNetwork = application.getNetwork();
 		if( hyperledgerNetwork != null ){
 			//if the root object 'application' already have the property, just set the id for it;
 			hyperledgerNetwork.setId(hyperledgerNetworkId);
 			
 			return;
 		}
 		application.setNetwork(createEmptyNetwork(hyperledgerNetworkId));
 	}
 	
	protected void setVersion(Application application, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ApplicationTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		application.setVersion(version);
	}
		
		

 	protected Channel  createEmptyChannel(String channelId){
 		Channel channel = new Channel();
 		channel.setId(channelId);
 		channel.setVersion(Integer.MAX_VALUE);
 		return channel;
 	}
 	
 	protected HyperledgerNetwork  createEmptyNetwork(String hyperledgerNetworkId){
 		HyperledgerNetwork hyperledgerNetwork = new HyperledgerNetwork();
 		hyperledgerNetwork.setId(hyperledgerNetworkId);
 		hyperledgerNetwork.setVersion(Integer.MAX_VALUE);
 		return hyperledgerNetwork;
 	}
 	
}


