
package com.doublechaintech.hfgw.channelpeerrole;
import com.doublechaintech.hfgw.AccessKey;


public class ChannelPeerRoleTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="channel_peer_role_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_CHANNEL = "channel";
	static final String COLUMN_NODE = "node";
	static final String COLUMN_PEER_ROLE = "peer_role";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_CHANNEL,COLUMN_NODE,COLUMN_PEER_ROLE,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_CHANNEL,COLUMN_NODE,COLUMN_PEER_ROLE};
	
	
}


