
package com.doublechaintech.hfgw.transactionstatus;
import com.doublechaintech.hfgw.AccessKey;


public class TransactionStatusTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	
	public static AccessKey withCode(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_CODE);
		accessKey.setValue(value);
		return accessKey;
	}
	 

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="transaction_status_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_CODE = "code";
	static final String COLUMN_NETWORK = "network";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_CODE,COLUMN_NETWORK,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_CODE,COLUMN_NETWORK};
	
	
}

