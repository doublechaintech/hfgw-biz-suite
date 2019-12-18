
package com.doublechaintech.hfgw.changerequest;
import com.doublechaintech.hfgw.CommonTokens;
import java.util.Map;
public class ChangeRequestTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="changeRequest";
	
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
	protected ChangeRequestTokens(){
		//ensure not initialized outside the class
	}
	public  static  ChangeRequestTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		ChangeRequestTokens tokens = new ChangeRequestTokens(options);
		return tokens;
		
	}
	protected ChangeRequestTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public ChangeRequestTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ChangeRequestTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ChangeRequestTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ChangeRequestTokens start(){
		return new ChangeRequestTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ChangeRequestTokens allTokens(){
		
		return start()
			.withRequestType()
			.withNetwork()
			.withChainCodeInvokerList();
	
	}
	public static ChangeRequestTokens withoutListsTokens(){
		
		return start()
			.withRequestType()
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
	
	public ChangeRequestTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String REQUESTTYPE = "requestType";
	public String getRequestType(){
		return REQUESTTYPE;
	}
	public ChangeRequestTokens withRequestType(){		
		addSimpleOptions(REQUESTTYPE);
		return this;
	}
	
	
	protected static final String NETWORK = "network";
	public String getNetwork(){
		return NETWORK;
	}
	public ChangeRequestTokens withNetwork(){		
		addSimpleOptions(NETWORK);
		return this;
	}
	
	
	protected static final String CHAIN_CODE_INVOKER_LIST = "chainCodeInvokerList";
	public String getChainCodeInvokerList(){
		return CHAIN_CODE_INVOKER_LIST;
	}
	public ChangeRequestTokens withChainCodeInvokerList(){		
		addSimpleOptions(CHAIN_CODE_INVOKER_LIST);
		return this;
	}
	public ChangeRequestTokens analyzeChainCodeInvokerList(){		
		addSimpleOptions(CHAIN_CODE_INVOKER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeChainCodeInvokerListEnabled(){		
		
		if(checkOptions(this.options(), CHAIN_CODE_INVOKER_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public ChangeRequestTokens extractMoreFromChainCodeInvokerList(String idsSeperatedWithComma){		
		addSimpleOptions(CHAIN_CODE_INVOKER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int chainCodeInvokerListSortCounter = 0;
	public ChangeRequestTokens sortChainCodeInvokerListWith(String field, String descOrAsc){		
		addSortMoreOptions(CHAIN_CODE_INVOKER_LIST,chainCodeInvokerListSortCounter++, field, descOrAsc);
		return this;
	}
	private int chainCodeInvokerListSearchCounter = 0;
	public ChangeRequestTokens searchChainCodeInvokerListWith(String field, String verb, String value){		
		
		withChainCodeInvokerList();
		addSearchMoreOptions(CHAIN_CODE_INVOKER_LIST,chainCodeInvokerListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ChangeRequestTokens searchAllTextOfChainCodeInvokerList(String verb, String value){	
		String field = "id|parameters";
		addSearchMoreOptions(CHAIN_CODE_INVOKER_LIST,chainCodeInvokerListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ChangeRequestTokens rowsPerPageOfChainCodeInvokerList(int rowsPerPage){		
		addSimpleOptions(CHAIN_CODE_INVOKER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ChangeRequestTokens currentPageNumberOfChainCodeInvokerList(int currentPageNumber){		
		addSimpleOptions(CHAIN_CODE_INVOKER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ChangeRequestTokens retainColumnsOfChainCodeInvokerList(String[] columns){		
		addSimpleOptions(CHAIN_CODE_INVOKER_LIST+"RetainColumns",columns);
		return this;
	}
	public ChangeRequestTokens excludeColumnsOfChainCodeInvokerList(String[] columns){		
		addSimpleOptions(CHAIN_CODE_INVOKER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  ChangeRequestTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfChainCodeInvokerList(verb, value);	
		return this;
	}
}

