
package com.doublechaintech.hfgw.grpcoption;
import com.doublechaintech.hfgw.CommonTokens;
import java.util.Map;
public class GrpcOptionTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="grpcOption";
	
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
	protected GrpcOptionTokens(){
		//ensure not initialized outside the class
	}
	public  static  GrpcOptionTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		GrpcOptionTokens tokens = new GrpcOptionTokens(options);
		return tokens;
		
	}
	protected GrpcOptionTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public GrpcOptionTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static GrpcOptionTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected GrpcOptionTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static GrpcOptionTokens start(){
		return new GrpcOptionTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static GrpcOptionTokens allTokens(){
		
		return start()
			.withNode();
	
	}
	public static GrpcOptionTokens withoutListsTokens(){
		
		return start()
			.withNode();
	
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
	
	public GrpcOptionTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String NODE = "node";
	public String getNode(){
		return NODE;
	}
	public GrpcOptionTokens withNode(){		
		addSimpleOptions(NODE);
		return this;
	}
	
	
	
	public  GrpcOptionTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

