
package com.doublechaintech.hfgw.application;
import com.doublechaintech.hfgw.AccessKey;


public class ApplicationTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="application_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_CREATE_TIME = "create_time";
	static final String COLUMN_MSPID = "mspid";
	static final String COLUMN_PUBLIC_KEY = "public_key";
	static final String COLUMN_PRIVATE_KEY = "private_key";
	static final String COLUMN_CHANNEL = "channel";
	static final String COLUMN_NETWORK = "network";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_CREATE_TIME,COLUMN_MSPID,COLUMN_PUBLIC_KEY,COLUMN_PRIVATE_KEY,COLUMN_CHANNEL,COLUMN_NETWORK,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_CREATE_TIME,COLUMN_MSPID,COLUMN_PUBLIC_KEY,COLUMN_PRIVATE_KEY,COLUMN_CHANNEL,COLUMN_NETWORK};
	
	
}


