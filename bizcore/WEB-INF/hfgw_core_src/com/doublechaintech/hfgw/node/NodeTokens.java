
package com.doublechaintech.hfgw.node;
import com.doublechaintech.hfgw.CommonTokens;
import java.util.Map;
public class NodeTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="node";
	
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
	protected NodeTokens(){
		//ensure not initialized outside the class
	}
	public  static  NodeTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		NodeTokens tokens = new NodeTokens(options);
		return tokens;
		
	}
	protected NodeTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public NodeTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static NodeTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected NodeTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static NodeTokens start(){
		return new NodeTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static NodeTokens allTokens(){
		
		return start()
			.withOrganization()
			.withChannel()
			.withType()
			.withGrpcOptionList()
			.withTlsCacertList();
	
	}
	public static NodeTokens withoutListsTokens(){
		
		return start()
			.withOrganization()
			.withChannel()
			.withType();
	
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
	
	public NodeTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String ORGANIZATION = "organization";
	public String getOrganization(){
		return ORGANIZATION;
	}
	public NodeTokens withOrganization(){		
		addSimpleOptions(ORGANIZATION);
		return this;
	}
	
	
	protected static final String CHANNEL = "channel";
	public String getChannel(){
		return CHANNEL;
	}
	public NodeTokens withChannel(){		
		addSimpleOptions(CHANNEL);
		return this;
	}
	
	
	protected static final String TYPE = "type";
	public String getType(){
		return TYPE;
	}
	public NodeTokens withType(){		
		addSimpleOptions(TYPE);
		return this;
	}
	
	
	protected static final String GRPC_OPTION_LIST = "grpcOptionList";
	public String getGrpcOptionList(){
		return GRPC_OPTION_LIST;
	}
	public NodeTokens withGrpcOptionList(){		
		addSimpleOptions(GRPC_OPTION_LIST);
		return this;
	}
	public NodeTokens analyzeGrpcOptionList(){		
		addSimpleOptions(GRPC_OPTION_LIST+".anaylze");
		return this;
	}
	public boolean analyzeGrpcOptionListEnabled(){		
		
		if(checkOptions(this.options(), GRPC_OPTION_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public NodeTokens extractMoreFromGrpcOptionList(String idsSeperatedWithComma){		
		addSimpleOptions(GRPC_OPTION_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int grpcOptionListSortCounter = 0;
	public NodeTokens sortGrpcOptionListWith(String field, String descOrAsc){		
		addSortMoreOptions(GRPC_OPTION_LIST,grpcOptionListSortCounter++, field, descOrAsc);
		return this;
	}
	private int grpcOptionListSearchCounter = 0;
	public NodeTokens searchGrpcOptionListWith(String field, String verb, String value){		
		
		withGrpcOptionList();
		addSearchMoreOptions(GRPC_OPTION_LIST,grpcOptionListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public NodeTokens searchAllTextOfGrpcOptionList(String verb, String value){	
		String field = "id|parameterName|parameterValue";
		addSearchMoreOptions(GRPC_OPTION_LIST,grpcOptionListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public NodeTokens rowsPerPageOfGrpcOptionList(int rowsPerPage){		
		addSimpleOptions(GRPC_OPTION_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public NodeTokens currentPageNumberOfGrpcOptionList(int currentPageNumber){		
		addSimpleOptions(GRPC_OPTION_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public NodeTokens retainColumnsOfGrpcOptionList(String[] columns){		
		addSimpleOptions(GRPC_OPTION_LIST+"RetainColumns",columns);
		return this;
	}
	public NodeTokens excludeColumnsOfGrpcOptionList(String[] columns){		
		addSimpleOptions(GRPC_OPTION_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String TLS_CACERT_LIST = "tlsCacertList";
	public String getTlsCacertList(){
		return TLS_CACERT_LIST;
	}
	public NodeTokens withTlsCacertList(){		
		addSimpleOptions(TLS_CACERT_LIST);
		return this;
	}
	public NodeTokens analyzeTlsCacertList(){		
		addSimpleOptions(TLS_CACERT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTlsCacertListEnabled(){		
		
		if(checkOptions(this.options(), TLS_CACERT_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public NodeTokens extractMoreFromTlsCacertList(String idsSeperatedWithComma){		
		addSimpleOptions(TLS_CACERT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int tlsCacertListSortCounter = 0;
	public NodeTokens sortTlsCacertListWith(String field, String descOrAsc){		
		addSortMoreOptions(TLS_CACERT_LIST,tlsCacertListSortCounter++, field, descOrAsc);
		return this;
	}
	private int tlsCacertListSearchCounter = 0;
	public NodeTokens searchTlsCacertListWith(String field, String verb, String value){		
		
		withTlsCacertList();
		addSearchMoreOptions(TLS_CACERT_LIST,tlsCacertListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public NodeTokens searchAllTextOfTlsCacertList(String verb, String value){	
		String field = "id|path|cert";
		addSearchMoreOptions(TLS_CACERT_LIST,tlsCacertListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public NodeTokens rowsPerPageOfTlsCacertList(int rowsPerPage){		
		addSimpleOptions(TLS_CACERT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public NodeTokens currentPageNumberOfTlsCacertList(int currentPageNumber){		
		addSimpleOptions(TLS_CACERT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public NodeTokens retainColumnsOfTlsCacertList(String[] columns){		
		addSimpleOptions(TLS_CACERT_LIST+"RetainColumns",columns);
		return this;
	}
	public NodeTokens excludeColumnsOfTlsCacertList(String[] columns){		
		addSimpleOptions(TLS_CACERT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  NodeTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfGrpcOptionList(verb, value);	
		searchAllTextOfTlsCacertList(verb, value);	
		return this;
	}
}

