
package com.doublechaintech.hfgw.node;
import com.doublechaintech.hfgw.AccessKey;


public class NodeTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="node_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_URL = "url";
	static final String COLUMN_ORGANIZATION = "organization";
	static final String COLUMN_CHANNEL = "channel";
	static final String COLUMN_TYPE = "type";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_URL,COLUMN_ORGANIZATION,COLUMN_CHANNEL,COLUMN_TYPE,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_URL,COLUMN_ORGANIZATION,COLUMN_CHANNEL,COLUMN_TYPE};
	
	
}


