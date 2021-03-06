
package com.doublechaintech.hfgw.application;
import com.doublechaintech.hfgw.CommonTokens;
import java.util.Map;
public class ApplicationTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="application";
	
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
	protected ApplicationTokens(){
		//ensure not initialized outside the class
	}
	public  static  ApplicationTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		ApplicationTokens tokens = new ApplicationTokens(options);
		return tokens;
		
	}
	protected ApplicationTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public ApplicationTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ApplicationTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ApplicationTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ApplicationTokens start(){
		return new ApplicationTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ApplicationTokens allTokens(){
		
		return start()
			.withChannel()
			.withNetwork()
			.withServiceRecordList()
			.withChainCodeInvokerList();
	
	}
	public static ApplicationTokens withoutListsTokens(){
		
		return start()
			.withChannel()
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
	
	public ApplicationTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String CHANNEL = "channel";
	public String getChannel(){
		return CHANNEL;
	}
	public ApplicationTokens withChannel(){		
		addSimpleOptions(CHANNEL);
		return this;
	}
	
	
	protected static final String NETWORK = "network";
	public String getNetwork(){
		return NETWORK;
	}
	public ApplicationTokens withNetwork(){		
		addSimpleOptions(NETWORK);
		return this;
	}
	
	
	protected static final String SERVICE_RECORD_LIST = "serviceRecordList";
	public String getServiceRecordList(){
		return SERVICE_RECORD_LIST;
	}
	public ApplicationTokens withServiceRecordList(){		
		addSimpleOptions(SERVICE_RECORD_LIST);
		return this;
	}
	public ApplicationTokens analyzeServiceRecordList(){		
		addSimpleOptions(SERVICE_RECORD_LIST+".anaylze");
		return this;
	}
	public boolean analyzeServiceRecordListEnabled(){		
		
		if(checkOptions(this.options(), SERVICE_RECORD_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public ApplicationTokens extractMoreFromServiceRecordList(String idsSeperatedWithComma){		
		addSimpleOptions(SERVICE_RECORD_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int serviceRecordListSortCounter = 0;
	public ApplicationTokens sortServiceRecordListWith(String field, String descOrAsc){		
		addSortMoreOptions(SERVICE_RECORD_LIST,serviceRecordListSortCounter++, field, descOrAsc);
		return this;
	}
	private int serviceRecordListSearchCounter = 0;
	public ApplicationTokens searchServiceRecordListWith(String field, String verb, String value){		
		
		withServiceRecordList();
		addSearchMoreOptions(SERVICE_RECORD_LIST,serviceRecordListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ApplicationTokens searchAllTextOfServiceRecordList(String verb, String value){	
		String field = "id|transactionId|name|payload|chainCodeFunction|blockId|response";
		addSearchMoreOptions(SERVICE_RECORD_LIST,serviceRecordListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ApplicationTokens rowsPerPageOfServiceRecordList(int rowsPerPage){		
		addSimpleOptions(SERVICE_RECORD_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ApplicationTokens currentPageNumberOfServiceRecordList(int currentPageNumber){		
		addSimpleOptions(SERVICE_RECORD_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ApplicationTokens retainColumnsOfServiceRecordList(String[] columns){		
		addSimpleOptions(SERVICE_RECORD_LIST+"RetainColumns",columns);
		return this;
	}
	public ApplicationTokens excludeColumnsOfServiceRecordList(String[] columns){		
		addSimpleOptions(SERVICE_RECORD_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String CHAIN_CODE_INVOKER_LIST = "chainCodeInvokerList";
	public String getChainCodeInvokerList(){
		return CHAIN_CODE_INVOKER_LIST;
	}
	public ApplicationTokens withChainCodeInvokerList(){		
		addSimpleOptions(CHAIN_CODE_INVOKER_LIST);
		return this;
	}
	public ApplicationTokens analyzeChainCodeInvokerList(){		
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
	public ApplicationTokens extractMoreFromChainCodeInvokerList(String idsSeperatedWithComma){		
		addSimpleOptions(CHAIN_CODE_INVOKER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int chainCodeInvokerListSortCounter = 0;
	public ApplicationTokens sortChainCodeInvokerListWith(String field, String descOrAsc){		
		addSortMoreOptions(CHAIN_CODE_INVOKER_LIST,chainCodeInvokerListSortCounter++, field, descOrAsc);
		return this;
	}
	private int chainCodeInvokerListSearchCounter = 0;
	public ApplicationTokens searchChainCodeInvokerListWith(String field, String verb, String value){		
		
		withChainCodeInvokerList();
		addSearchMoreOptions(CHAIN_CODE_INVOKER_LIST,chainCodeInvokerListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ApplicationTokens searchAllTextOfChainCodeInvokerList(String verb, String value){	
		String field = "id|parameters";
		addSearchMoreOptions(CHAIN_CODE_INVOKER_LIST,chainCodeInvokerListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ApplicationTokens rowsPerPageOfChainCodeInvokerList(int rowsPerPage){		
		addSimpleOptions(CHAIN_CODE_INVOKER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ApplicationTokens currentPageNumberOfChainCodeInvokerList(int currentPageNumber){		
		addSimpleOptions(CHAIN_CODE_INVOKER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ApplicationTokens retainColumnsOfChainCodeInvokerList(String[] columns){		
		addSimpleOptions(CHAIN_CODE_INVOKER_LIST+"RetainColumns",columns);
		return this;
	}
	public ApplicationTokens excludeColumnsOfChainCodeInvokerList(String[] columns){		
		addSimpleOptions(CHAIN_CODE_INVOKER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  ApplicationTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfServiceRecordList(verb, value);	
		searchAllTextOfChainCodeInvokerList(verb, value);	
		return this;
	}
}

