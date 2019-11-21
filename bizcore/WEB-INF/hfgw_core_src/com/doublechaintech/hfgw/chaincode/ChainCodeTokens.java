
package com.doublechaintech.hfgw.chaincode;
import com.doublechaintech.hfgw.CommonTokens;
import java.util.Map;
public class ChainCodeTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="chainCode";
	
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
	protected ChainCodeTokens(){
		//ensure not initialized outside the class
	}
	public  static  ChainCodeTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		ChainCodeTokens tokens = new ChainCodeTokens(options);
		return tokens;
		
	}
	protected ChainCodeTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public ChainCodeTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ChainCodeTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ChainCodeTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ChainCodeTokens start(){
		return new ChainCodeTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ChainCodeTokens allTokens(){
		
		return start()
			.withChannel()
			.withServiceRecordList();
	
	}
	public static ChainCodeTokens withoutListsTokens(){
		
		return start()
			.withChannel();
	
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
	
	public ChainCodeTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String CHANNEL = "channel";
	public String getChannel(){
		return CHANNEL;
	}
	public ChainCodeTokens withChannel(){		
		addSimpleOptions(CHANNEL);
		return this;
	}
	
	
	protected static final String SERVICE_RECORD_LIST = "serviceRecordList";
	public String getServiceRecordList(){
		return SERVICE_RECORD_LIST;
	}
	public ChainCodeTokens withServiceRecordList(){		
		addSimpleOptions(SERVICE_RECORD_LIST);
		return this;
	}
	public ChainCodeTokens analyzeServiceRecordList(){		
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
	public ChainCodeTokens extractMoreFromServiceRecordList(String idsSeperatedWithComma){		
		addSimpleOptions(SERVICE_RECORD_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int serviceRecordListSortCounter = 0;
	public ChainCodeTokens sortServiceRecordListWith(String field, String descOrAsc){		
		addSortMoreOptions(SERVICE_RECORD_LIST,serviceRecordListSortCounter++, field, descOrAsc);
		return this;
	}
	private int serviceRecordListSearchCounter = 0;
	public ChainCodeTokens searchServiceRecordListWith(String field, String verb, String value){		
		
		withServiceRecordList();
		addSearchMoreOptions(SERVICE_RECORD_LIST,serviceRecordListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ChainCodeTokens searchAllTextOfServiceRecordList(String verb, String value){	
		String field = "id|name|payLoad|chainCodeFunction|transactionId|blockId|currentStatus";
		addSearchMoreOptions(SERVICE_RECORD_LIST,serviceRecordListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ChainCodeTokens rowsPerPageOfServiceRecordList(int rowsPerPage){		
		addSimpleOptions(SERVICE_RECORD_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ChainCodeTokens currentPageNumberOfServiceRecordList(int currentPageNumber){		
		addSimpleOptions(SERVICE_RECORD_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ChainCodeTokens retainColumnsOfServiceRecordList(String[] columns){		
		addSimpleOptions(SERVICE_RECORD_LIST+"RetainColumns",columns);
		return this;
	}
	public ChainCodeTokens excludeColumnsOfServiceRecordList(String[] columns){		
		addSimpleOptions(SERVICE_RECORD_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  ChainCodeTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfServiceRecordList(verb, value);	
		return this;
	}
}

