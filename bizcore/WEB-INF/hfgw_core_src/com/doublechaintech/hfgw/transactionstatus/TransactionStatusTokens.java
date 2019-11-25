
package com.doublechaintech.hfgw.transactionstatus;
import com.doublechaintech.hfgw.CommonTokens;
import java.util.Map;
public class TransactionStatusTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="transactionStatus";
	
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
	protected TransactionStatusTokens(){
		//ensure not initialized outside the class
	}
	public  static  TransactionStatusTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		TransactionStatusTokens tokens = new TransactionStatusTokens(options);
		return tokens;
		
	}
	protected TransactionStatusTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public TransactionStatusTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static TransactionStatusTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected TransactionStatusTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static TransactionStatusTokens start(){
		return new TransactionStatusTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static TransactionStatusTokens allTokens(){
		
		return start()
			.withNetwork()
			.withServiceRecordList();
	
	}
	public static TransactionStatusTokens withoutListsTokens(){
		
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
	
	public TransactionStatusTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String NETWORK = "network";
	public String getNetwork(){
		return NETWORK;
	}
	public TransactionStatusTokens withNetwork(){		
		addSimpleOptions(NETWORK);
		return this;
	}
	
	
	protected static final String SERVICE_RECORD_LIST = "serviceRecordList";
	public String getServiceRecordList(){
		return SERVICE_RECORD_LIST;
	}
	public TransactionStatusTokens withServiceRecordList(){		
		addSimpleOptions(SERVICE_RECORD_LIST);
		return this;
	}
	public TransactionStatusTokens analyzeServiceRecordList(){		
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
	public TransactionStatusTokens extractMoreFromServiceRecordList(String idsSeperatedWithComma){		
		addSimpleOptions(SERVICE_RECORD_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int serviceRecordListSortCounter = 0;
	public TransactionStatusTokens sortServiceRecordListWith(String field, String descOrAsc){		
		addSortMoreOptions(SERVICE_RECORD_LIST,serviceRecordListSortCounter++, field, descOrAsc);
		return this;
	}
	private int serviceRecordListSearchCounter = 0;
	public TransactionStatusTokens searchServiceRecordListWith(String field, String verb, String value){		
		
		withServiceRecordList();
		addSearchMoreOptions(SERVICE_RECORD_LIST,serviceRecordListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public TransactionStatusTokens searchAllTextOfServiceRecordList(String verb, String value){	
		String field = "id|name|payload|chainCodeFunction|transactionId|blockId|response";
		addSearchMoreOptions(SERVICE_RECORD_LIST,serviceRecordListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public TransactionStatusTokens rowsPerPageOfServiceRecordList(int rowsPerPage){		
		addSimpleOptions(SERVICE_RECORD_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public TransactionStatusTokens currentPageNumberOfServiceRecordList(int currentPageNumber){		
		addSimpleOptions(SERVICE_RECORD_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public TransactionStatusTokens retainColumnsOfServiceRecordList(String[] columns){		
		addSimpleOptions(SERVICE_RECORD_LIST+"RetainColumns",columns);
		return this;
	}
	public TransactionStatusTokens excludeColumnsOfServiceRecordList(String[] columns){		
		addSimpleOptions(SERVICE_RECORD_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  TransactionStatusTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfServiceRecordList(verb, value);	
		return this;
	}
}

