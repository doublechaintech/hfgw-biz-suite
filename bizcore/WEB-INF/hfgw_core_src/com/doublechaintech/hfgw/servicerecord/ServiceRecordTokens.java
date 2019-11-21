
package com.doublechaintech.hfgw.servicerecord;
import com.doublechaintech.hfgw.CommonTokens;
import java.util.Map;
public class ServiceRecordTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="serviceRecord";
	
	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){
		
		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner? 
			return false; 
		}
		
 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.			
 			return true;
 		}
 		
 		return false;
	
	}
	protected ServiceRecordTokens(){
		//ensure not initialized outside the class
	}
	public  static  ServiceRecordTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		ServiceRecordTokens tokens = new ServiceRecordTokens(options);
		return tokens;
		
	}
	protected ServiceRecordTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public ServiceRecordTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ServiceRecordTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ServiceRecordTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ServiceRecordTokens start(){
		return new ServiceRecordTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ServiceRecordTokens allTokens(){
		
		return start()
			.withChannel()
			.withChainCode()
			.withApplication()
			.withNetwork();
	
	}
	public static ServiceRecordTokens withoutListsTokens(){
		
		return start()
			.withChannel()
			.withChainCode()
			.withApplication()
			.withNetwork();
	
	}
	
	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}
	
	public ServiceRecordTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String CHANNEL = "channel";
	public String getChannel(){
		return CHANNEL;
	}
	public ServiceRecordTokens withChannel(){		
		addSimpleOptions(CHANNEL);
		return this;
	}
	
	
	protected static final String CHAINCODE = "chainCode";
	public String getChainCode(){
		return CHAINCODE;
	}
	public ServiceRecordTokens withChainCode(){		
		addSimpleOptions(CHAINCODE);
		return this;
	}
	
	
	protected static final String APPLICATION = "application";
	public String getApplication(){
		return APPLICATION;
	}
	public ServiceRecordTokens withApplication(){		
		addSimpleOptions(APPLICATION);
		return this;
	}
	
	
	protected static final String NETWORK = "network";
	public String getNetwork(){
		return NETWORK;
	}
	public ServiceRecordTokens withNetwork(){		
		addSimpleOptions(NETWORK);
		return this;
	}
	
	
	
	public  ServiceRecordTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

