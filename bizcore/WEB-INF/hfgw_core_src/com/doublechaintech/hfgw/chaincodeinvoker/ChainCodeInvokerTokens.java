
package com.doublechaintech.hfgw.chaincodeinvoker;
import com.doublechaintech.hfgw.CommonTokens;
import java.util.Map;
public class ChainCodeInvokerTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="chainCodeInvoker";
	
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
	protected ChainCodeInvokerTokens(){
		//ensure not initialized outside the class
	}
	public  static  ChainCodeInvokerTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		ChainCodeInvokerTokens tokens = new ChainCodeInvokerTokens(options);
		return tokens;
		
	}
	protected ChainCodeInvokerTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public ChainCodeInvokerTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ChainCodeInvokerTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ChainCodeInvokerTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ChainCodeInvokerTokens start(){
		return new ChainCodeInvokerTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ChainCodeInvokerTokens allTokens(){
		
		return start()
			.withAppClient()
			.withChainCode()
			.withChangeRequest();
	
	}
	public static ChainCodeInvokerTokens withoutListsTokens(){
		
		return start()
			.withAppClient()
			.withChainCode()
			.withChangeRequest();
	
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
	
	public ChainCodeInvokerTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String APPCLIENT = "appClient";
	public String getAppClient(){
		return APPCLIENT;
	}
	public ChainCodeInvokerTokens withAppClient(){		
		addSimpleOptions(APPCLIENT);
		return this;
	}
	
	
	protected static final String CHAINCODE = "chainCode";
	public String getChainCode(){
		return CHAINCODE;
	}
	public ChainCodeInvokerTokens withChainCode(){		
		addSimpleOptions(CHAINCODE);
		return this;
	}
	
	
	protected static final String CHANGEREQUEST = "changeRequest";
	public String getChangeRequest(){
		return CHANGEREQUEST;
	}
	public ChainCodeInvokerTokens withChangeRequest(){		
		addSimpleOptions(CHANGEREQUEST);
		return this;
	}
	
	
	
	public  ChainCodeInvokerTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

