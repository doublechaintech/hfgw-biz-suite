
package com.doublechaintech.hfgw.nodetype;
import com.doublechaintech.hfgw.AccessKey;


public class NodeTypeTable{


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
	public static final String TABLE_NAME="node_type_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_CODE = "code";
	static final String COLUMN_NETWORK = "network";
	static final String COLUMN_ADDRESS = "address";
	static final String COLUMN_CONTACT_PERSON = "contact_person";
	static final String COLUMN_CONTACT_TELEPHONE = "contact_telephone";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_CODE,COLUMN_NETWORK,COLUMN_ADDRESS,COLUMN_CONTACT_PERSON,COLUMN_CONTACT_TELEPHONE,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_CODE,COLUMN_NETWORK,COLUMN_ADDRESS,COLUMN_CONTACT_PERSON,COLUMN_CONTACT_TELEPHONE};
	
	
}


