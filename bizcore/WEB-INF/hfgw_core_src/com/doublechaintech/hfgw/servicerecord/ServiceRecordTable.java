
package com.doublechaintech.hfgw.servicerecord;
import com.doublechaintech.hfgw.AccessKey;


public class ServiceRecordTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="service_record_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_PAY_LOAD = "pay_load";
	static final String COLUMN_CHANNEL = "channel";
	static final String COLUMN_CHAIN_CODE = "chain_code";
	static final String COLUMN_CHAIN_CODE_FUNCTION = "chain_code_function";
	static final String COLUMN_TRANSACTION_ID = "transaction_id";
	static final String COLUMN_BLOCK_ID = "block_id";
	static final String COLUMN_CREATE_TIME = "create_time";
	static final String COLUMN_APPLICATION = "application";
	static final String COLUMN_NETWORK = "network";
	static final String COLUMN_CURRENT_STATUS = "current_status";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_PAY_LOAD,COLUMN_CHANNEL,COLUMN_CHAIN_CODE,COLUMN_CHAIN_CODE_FUNCTION,COLUMN_TRANSACTION_ID,COLUMN_BLOCK_ID,COLUMN_CREATE_TIME,COLUMN_APPLICATION,COLUMN_NETWORK,COLUMN_CURRENT_STATUS,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_PAY_LOAD,COLUMN_CHANNEL,COLUMN_CHAIN_CODE,COLUMN_CHAIN_CODE_FUNCTION,COLUMN_TRANSACTION_ID,COLUMN_BLOCK_ID,COLUMN_CREATE_TIME,COLUMN_APPLICATION,COLUMN_NETWORK,COLUMN_CURRENT_STATUS};
	
	
}


