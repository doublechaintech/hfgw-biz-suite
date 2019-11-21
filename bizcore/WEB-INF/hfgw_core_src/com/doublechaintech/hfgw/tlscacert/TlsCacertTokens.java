
package com.doublechaintech.hfgw.tlscacert;
import com.doublechaintech.hfgw.CommonTokens;
import java.util.Map;
public class TlsCacertTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="tlsCacert";
	
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
	protected TlsCacertTokens(){
		//ensure not initialized outside the class
	}
	public  static  TlsCacertTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		TlsCacertTokens tokens = new TlsCacertTokens(options);
		return tokens;
		
	}
	protected TlsCacertTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public TlsCacertTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static TlsCacertTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected TlsCacertTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static TlsCacertTokens start(){
		return new TlsCacertTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static TlsCacertTokens allTokens(){
		
		return start()
			.withNode();
	
	}
	public static TlsCacertTokens withoutListsTokens(){
		
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
	
	public TlsCacertTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String NODE = "node";
	public String getNode(){
		return NODE;
	}
	public TlsCacertTokens withNode(){		
		addSimpleOptions(NODE);
		return this;
	}
	
	
	
	public  TlsCacertTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

