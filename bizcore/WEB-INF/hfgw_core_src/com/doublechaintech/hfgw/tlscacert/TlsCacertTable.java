
package com.doublechaintech.hfgw.tlscacert;
import com.doublechaintech.hfgw.AccessKey;


public class TlsCacertTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="tls_cacert_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_PATH = "path";
	static final String COLUMN_CERT = "cert";
	static final String COLUMN_NODE = "node";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_PATH,COLUMN_CERT,COLUMN_NODE,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_PATH,COLUMN_CERT,COLUMN_NODE};
	
	
}


