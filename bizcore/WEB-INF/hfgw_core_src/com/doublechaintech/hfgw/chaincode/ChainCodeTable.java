
package com.doublechaintech.hfgw.chaincode;
import com.doublechaintech.hfgw.AccessKey;


public class ChainCodeTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="chain_code_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_CODE_NAME = "code_name";
	static final String COLUMN_CODE_VERSION = "code_version";
	static final String COLUMN_CHANNEL = "channel";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_CODE_NAME,COLUMN_CODE_VERSION,COLUMN_CHANNEL,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_CODE_NAME,COLUMN_CODE_VERSION,COLUMN_CHANNEL};
	
	
}


