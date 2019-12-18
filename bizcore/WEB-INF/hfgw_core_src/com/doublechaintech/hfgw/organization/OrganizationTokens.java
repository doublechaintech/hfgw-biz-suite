
package com.doublechaintech.hfgw.organization;
import com.doublechaintech.hfgw.CommonTokens;
import java.util.Map;
public class OrganizationTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="organization";
	
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
	protected OrganizationTokens(){
		//ensure not initialized outside the class
	}
	public  static  OrganizationTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		OrganizationTokens tokens = new OrganizationTokens(options);
		return tokens;
		
	}
	protected OrganizationTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public OrganizationTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static OrganizationTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected OrganizationTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static OrganizationTokens start(){
		return new OrganizationTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static OrganizationTokens allTokens(){
		
		return start()
			.withNetwork()
			.withNodeList();
	
	}
	public static OrganizationTokens withoutListsTokens(){
		
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
	
	public OrganizationTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String NETWORK = "network";
	public String getNetwork(){
		return NETWORK;
	}
	public OrganizationTokens withNetwork(){		
		addSimpleOptions(NETWORK);
		return this;
	}
	
	
	protected static final String NODE_LIST = "nodeList";
	public String getNodeList(){
		return NODE_LIST;
	}
	public OrganizationTokens withNodeList(){		
		addSimpleOptions(NODE_LIST);
		return this;
	}
	public OrganizationTokens analyzeNodeList(){		
		addSimpleOptions(NODE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeNodeListEnabled(){		
		
		if(checkOptions(this.options(), NODE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public OrganizationTokens extractMoreFromNodeList(String idsSeperatedWithComma){		
		addSimpleOptions(NODE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int nodeListSortCounter = 0;
	public OrganizationTokens sortNodeListWith(String field, String descOrAsc){		
		addSortMoreOptions(NODE_LIST,nodeListSortCounter++, field, descOrAsc);
		return this;
	}
	private int nodeListSearchCounter = 0;
	public OrganizationTokens searchNodeListWith(String field, String verb, String value){		
		
		withNodeList();
		addSearchMoreOptions(NODE_LIST,nodeListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public OrganizationTokens searchAllTextOfNodeList(String verb, String value){	
		String field = "id|name|url|tlsCacert|address|contactPerson|contactTelephone";
		addSearchMoreOptions(NODE_LIST,nodeListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public OrganizationTokens rowsPerPageOfNodeList(int rowsPerPage){		
		addSimpleOptions(NODE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public OrganizationTokens currentPageNumberOfNodeList(int currentPageNumber){		
		addSimpleOptions(NODE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public OrganizationTokens retainColumnsOfNodeList(String[] columns){		
		addSimpleOptions(NODE_LIST+"RetainColumns",columns);
		return this;
	}
	public OrganizationTokens excludeColumnsOfNodeList(String[] columns){		
		addSimpleOptions(NODE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  OrganizationTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfNodeList(verb, value);	
		return this;
	}
}

