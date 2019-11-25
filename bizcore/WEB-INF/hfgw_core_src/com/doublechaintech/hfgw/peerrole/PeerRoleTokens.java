
package com.doublechaintech.hfgw.peerrole;
import com.doublechaintech.hfgw.CommonTokens;
import java.util.Map;
public class PeerRoleTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="peerRole";
	
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
	protected PeerRoleTokens(){
		//ensure not initialized outside the class
	}
	public  static  PeerRoleTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		PeerRoleTokens tokens = new PeerRoleTokens(options);
		return tokens;
		
	}
	protected PeerRoleTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public PeerRoleTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static PeerRoleTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected PeerRoleTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static PeerRoleTokens start(){
		return new PeerRoleTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static PeerRoleTokens allTokens(){
		
		return start()
			.withNetwork()
			.withChannelPeerRoleList();
	
	}
	public static PeerRoleTokens withoutListsTokens(){
		
		return start()
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
	
	public PeerRoleTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String NETWORK = "network";
	public String getNetwork(){
		return NETWORK;
	}
	public PeerRoleTokens withNetwork(){		
		addSimpleOptions(NETWORK);
		return this;
	}
	
	
	protected static final String CHANNEL_PEER_ROLE_LIST = "channelPeerRoleList";
	public String getChannelPeerRoleList(){
		return CHANNEL_PEER_ROLE_LIST;
	}
	public PeerRoleTokens withChannelPeerRoleList(){		
		addSimpleOptions(CHANNEL_PEER_ROLE_LIST);
		return this;
	}
	public PeerRoleTokens analyzeChannelPeerRoleList(){		
		addSimpleOptions(CHANNEL_PEER_ROLE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeChannelPeerRoleListEnabled(){		
		
		if(checkOptions(this.options(), CHANNEL_PEER_ROLE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public PeerRoleTokens extractMoreFromChannelPeerRoleList(String idsSeperatedWithComma){		
		addSimpleOptions(CHANNEL_PEER_ROLE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int channelPeerRoleListSortCounter = 0;
	public PeerRoleTokens sortChannelPeerRoleListWith(String field, String descOrAsc){		
		addSortMoreOptions(CHANNEL_PEER_ROLE_LIST,channelPeerRoleListSortCounter++, field, descOrAsc);
		return this;
	}
	private int channelPeerRoleListSearchCounter = 0;
	public PeerRoleTokens searchChannelPeerRoleListWith(String field, String verb, String value){		
		
		withChannelPeerRoleList();
		addSearchMoreOptions(CHANNEL_PEER_ROLE_LIST,channelPeerRoleListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PeerRoleTokens searchAllTextOfChannelPeerRoleList(String verb, String value){	
		String field = "id";
		addSearchMoreOptions(CHANNEL_PEER_ROLE_LIST,channelPeerRoleListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PeerRoleTokens rowsPerPageOfChannelPeerRoleList(int rowsPerPage){		
		addSimpleOptions(CHANNEL_PEER_ROLE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PeerRoleTokens currentPageNumberOfChannelPeerRoleList(int currentPageNumber){		
		addSimpleOptions(CHANNEL_PEER_ROLE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PeerRoleTokens retainColumnsOfChannelPeerRoleList(String[] columns){		
		addSimpleOptions(CHANNEL_PEER_ROLE_LIST+"RetainColumns",columns);
		return this;
	}
	public PeerRoleTokens excludeColumnsOfChannelPeerRoleList(String[] columns){		
		addSimpleOptions(CHANNEL_PEER_ROLE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  PeerRoleTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfChannelPeerRoleList(verb, value);	
		return this;
	}
}

