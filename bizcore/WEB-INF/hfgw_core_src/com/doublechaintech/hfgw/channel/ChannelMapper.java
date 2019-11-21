
package com.doublechaintech.hfgw.channel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.hfgw.BaseRowMapper;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

public class ChannelMapper extends BaseRowMapper<Channel>{
	
	protected Channel internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Channel channel = getChannel();		
		 		
 		setId(channel, rs, rowNumber); 		
 		setName(channel, rs, rowNumber); 		
 		setNetwork(channel, rs, rowNumber); 		
 		setVersion(channel, rs, rowNumber);

		return channel;
	}
	
	protected Channel getChannel(){
		return new Channel();
	}		
		
	protected void setId(Channel channel, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ChannelTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		channel.setId(id);
	}
		
	protected void setName(Channel channel, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(ChannelTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		channel.setName(name);
	}
		 		
 	protected void setNetwork(Channel channel, ResultSet rs, int rowNumber) throws SQLException{
 		String hyperledgerNetworkId = rs.getString(ChannelTable.COLUMN_NETWORK);
 		if( hyperledgerNetworkId == null){
 			return;
 		}
 		if( hyperledgerNetworkId.isEmpty()){
 			return;
 		}
 		HyperledgerNetwork hyperledgerNetwork = channel.getNetwork();
 		if( hyperledgerNetwork != null ){
 			//if the root object 'channel' already have the property, just set the id for it;
 			hyperledgerNetwork.setId(hyperledgerNetworkId);
 			
 			return;
 		}
 		channel.setNetwork(createEmptyNetwork(hyperledgerNetworkId));
 	}
 	
	protected void setVersion(Channel channel, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ChannelTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		channel.setVersion(version);
	}
		
		

 	protected HyperledgerNetwork  createEmptyNetwork(String hyperledgerNetworkId){
 		HyperledgerNetwork hyperledgerNetwork = new HyperledgerNetwork();
 		hyperledgerNetwork.setId(hyperledgerNetworkId);
 		hyperledgerNetwork.setVersion(Integer.MAX_VALUE);
 		return hyperledgerNetwork;
 	}
 	
}


