
package com.doublechaintech.hfgw.chaincodeinvoker;
import com.doublechaintech.hfgw.AccessKey;


public class ChainCodeInvokerTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="chain_code_invoker_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_APP_CLIENT = "app_client";
	static final String COLUMN_CHAIN_CODE = "chain_code";
	static final String COLUMN_PARAMETERS = "parameters";
	static final String COLUMN_CHANGE_REQUEST = "change_request";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_APP_CLIENT,COLUMN_CHAIN_CODE,COLUMN_PARAMETERS,COLUMN_CHANGE_REQUEST,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_APP_CLIENT,COLUMN_CHAIN_CODE,COLUMN_PARAMETERS,COLUMN_CHANGE_REQUEST};
	
	
}


