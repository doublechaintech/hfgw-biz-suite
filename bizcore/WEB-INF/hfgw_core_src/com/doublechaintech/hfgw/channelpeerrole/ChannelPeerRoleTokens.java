
package com.doublechaintech.hfgw.channelpeerrole;
import com.doublechaintech.hfgw.CommonTokens;
import java.util.Map;
public class ChannelPeerRoleTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="channelPeerRole";
	
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
	protected ChannelPeerRoleTokens(){
		//ensure not initialized outside the class
	}
	public  static  ChannelPeerRoleTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		ChannelPeerRoleTokens tokens = new ChannelPeerRoleTokens(options);
		return tokens;
		
	}
	protected ChannelPeerRoleTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public ChannelPeerRoleTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ChannelPeerRoleTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ChannelPeerRoleTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ChannelPeerRoleTokens start(){
		return new ChannelPeerRoleTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ChannelPeerRoleTokens allTokens(){
		
		return start()
			.withChannel()
			.withNode()
			.withPeerRole();
	
	}
	public static ChannelPeerRoleTokens withoutListsTokens(){
		
		return start()
			.withChannel()
			.withNode()
			.withPeerRole();
	
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
	
	public ChannelPeerRoleTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String CHANNEL = "channel";
	public String getChannel(){
		return CHANNEL;
	}
	public ChannelPeerRoleTokens withChannel(){		
		addSimpleOptions(CHANNEL);
		return this;
	}
	
	
	protected static final String NODE = "node";
	public String getNode(){
		return NODE;
	}
	public ChannelPeerRoleTokens withNode(){		
		addSimpleOptions(NODE);
		return this;
	}
	
	
	protected static final String PEERROLE = "peerRole";
	public String getPeerRole(){
		return PEERROLE;
	}
	public ChannelPeerRoleTokens withPeerRole(){		
		addSimpleOptions(PEERROLE);
		return this;
	}
	
	
	
	public  ChannelPeerRoleTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

