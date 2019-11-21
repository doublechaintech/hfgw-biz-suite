
package com.doublechaintech.hfgw.hyperledgernetwork;
import com.doublechaintech.hfgw.CommonTokens;
import java.util.Map;
public class HyperledgerNetworkTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="hyperledgerNetwork";
	
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
	protected HyperledgerNetworkTokens(){
		//ensure not initialized outside the class
	}
	public  static  HyperledgerNetworkTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		HyperledgerNetworkTokens tokens = new HyperledgerNetworkTokens(options);
		return tokens;
		
	}
	protected HyperledgerNetworkTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public HyperledgerNetworkTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static HyperledgerNetworkTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected HyperledgerNetworkTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static HyperledgerNetworkTokens start(){
		return new HyperledgerNetworkTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static HyperledgerNetworkTokens allTokens(){
		
		return start()
			.withOrganizationList()
			.withNodeList()
			.withChannelList()
			.withApplicationList()
			.withServiceRecordList()
			.withChangeRequestTypeList()
			.withChangeRequestList();
	
	}
	public static HyperledgerNetworkTokens withoutListsTokens(){
		
		return start();
	
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
	
	public HyperledgerNetworkTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String ORGANIZATION_LIST = "organizationList";
	public String getOrganizationList(){
		return ORGANIZATION_LIST;
	}
	public HyperledgerNetworkTokens withOrganizationList(){		
		addSimpleOptions(ORGANIZATION_LIST);
		return this;
	}
	public HyperledgerNetworkTokens analyzeOrganizationList(){		
		addSimpleOptions(ORGANIZATION_LIST+".anaylze");
		return this;
	}
	public boolean analyzeOrganizationListEnabled(){		
		
		if(checkOptions(this.options(), ORGANIZATION_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public HyperledgerNetworkTokens extractMoreFromOrganizationList(String idsSeperatedWithComma){		
		addSimpleOptions(ORGANIZATION_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int organizationListSortCounter = 0;
	public HyperledgerNetworkTokens sortOrganizationListWith(String field, String descOrAsc){		
		addSortMoreOptions(ORGANIZATION_LIST,organizationListSortCounter++, field, descOrAsc);
		return this;
	}
	private int organizationListSearchCounter = 0;
	public HyperledgerNetworkTokens searchOrganizationListWith(String field, String verb, String value){		
		
		withOrganizationList();
		addSearchMoreOptions(ORGANIZATION_LIST,organizationListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public HyperledgerNetworkTokens searchAllTextOfOrganizationList(String verb, String value){	
		String field = "id|name|mspid";
		addSearchMoreOptions(ORGANIZATION_LIST,organizationListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public HyperledgerNetworkTokens rowsPerPageOfOrganizationList(int rowsPerPage){		
		addSimpleOptions(ORGANIZATION_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public HyperledgerNetworkTokens currentPageNumberOfOrganizationList(int currentPageNumber){		
		addSimpleOptions(ORGANIZATION_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public HyperledgerNetworkTokens retainColumnsOfOrganizationList(String[] columns){		
		addSimpleOptions(ORGANIZATION_LIST+"RetainColumns",columns);
		return this;
	}
	public HyperledgerNetworkTokens excludeColumnsOfOrganizationList(String[] columns){		
		addSimpleOptions(ORGANIZATION_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String NODE_LIST = "nodeList";
	public String getNodeList(){
		return NODE_LIST;
	}
	public HyperledgerNetworkTokens withNodeList(){		
		addSimpleOptions(NODE_LIST);
		return this;
	}
	public HyperledgerNetworkTokens analyzeNodeList(){		
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
	public HyperledgerNetworkTokens extractMoreFromNodeList(String idsSeperatedWithComma){		
		addSimpleOptions(NODE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int nodeListSortCounter = 0;
	public HyperledgerNetworkTokens sortNodeListWith(String field, String descOrAsc){		
		addSortMoreOptions(NODE_LIST,nodeListSortCounter++, field, descOrAsc);
		return this;
	}
	private int nodeListSearchCounter = 0;
	public HyperledgerNetworkTokens searchNodeListWith(String field, String verb, String value){		
		
		withNodeList();
		addSearchMoreOptions(NODE_LIST,nodeListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public HyperledgerNetworkTokens searchAllTextOfNodeList(String verb, String value){	
		String field = "id|name|url|tlsCacert|address|contactPerson|contactTelephone";
		addSearchMoreOptions(NODE_LIST,nodeListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public HyperledgerNetworkTokens rowsPerPageOfNodeList(int rowsPerPage){		
		addSimpleOptions(NODE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public HyperledgerNetworkTokens currentPageNumberOfNodeList(int currentPageNumber){		
		addSimpleOptions(NODE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public HyperledgerNetworkTokens retainColumnsOfNodeList(String[] columns){		
		addSimpleOptions(NODE_LIST+"RetainColumns",columns);
		return this;
	}
	public HyperledgerNetworkTokens excludeColumnsOfNodeList(String[] columns){		
		addSimpleOptions(NODE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String CHANNEL_LIST = "channelList";
	public String getChannelList(){
		return CHANNEL_LIST;
	}
	public HyperledgerNetworkTokens withChannelList(){		
		addSimpleOptions(CHANNEL_LIST);
		return this;
	}
	public HyperledgerNetworkTokens analyzeChannelList(){		
		addSimpleOptions(CHANNEL_LIST+".anaylze");
		return this;
	}
	public boolean analyzeChannelListEnabled(){		
		
		if(checkOptions(this.options(), CHANNEL_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public HyperledgerNetworkTokens extractMoreFromChannelList(String idsSeperatedWithComma){		
		addSimpleOptions(CHANNEL_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int channelListSortCounter = 0;
	public HyperledgerNetworkTokens sortChannelListWith(String field, String descOrAsc){		
		addSortMoreOptions(CHANNEL_LIST,channelListSortCounter++, field, descOrAsc);
		return this;
	}
	private int channelListSearchCounter = 0;
	public HyperledgerNetworkTokens searchChannelListWith(String field, String verb, String value){		
		
		withChannelList();
		addSearchMoreOptions(CHANNEL_LIST,channelListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public HyperledgerNetworkTokens searchAllTextOfChannelList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(CHANNEL_LIST,channelListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public HyperledgerNetworkTokens rowsPerPageOfChannelList(int rowsPerPage){		
		addSimpleOptions(CHANNEL_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public HyperledgerNetworkTokens currentPageNumberOfChannelList(int currentPageNumber){		
		addSimpleOptions(CHANNEL_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public HyperledgerNetworkTokens retainColumnsOfChannelList(String[] columns){		
		addSimpleOptions(CHANNEL_LIST+"RetainColumns",columns);
		return this;
	}
	public HyperledgerNetworkTokens excludeColumnsOfChannelList(String[] columns){		
		addSimpleOptions(CHANNEL_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String APPLICATION_LIST = "applicationList";
	public String getApplicationList(){
		return APPLICATION_LIST;
	}
	public HyperledgerNetworkTokens withApplicationList(){		
		addSimpleOptions(APPLICATION_LIST);
		return this;
	}
	public HyperledgerNetworkTokens analyzeApplicationList(){		
		addSimpleOptions(APPLICATION_LIST+".anaylze");
		return this;
	}
	public boolean analyzeApplicationListEnabled(){		
		
		if(checkOptions(this.options(), APPLICATION_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public HyperledgerNetworkTokens extractMoreFromApplicationList(String idsSeperatedWithComma){		
		addSimpleOptions(APPLICATION_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int applicationListSortCounter = 0;
	public HyperledgerNetworkTokens sortApplicationListWith(String field, String descOrAsc){		
		addSortMoreOptions(APPLICATION_LIST,applicationListSortCounter++, field, descOrAsc);
		return this;
	}
	private int applicationListSearchCounter = 0;
	public HyperledgerNetworkTokens searchApplicationListWith(String field, String verb, String value){		
		
		withApplicationList();
		addSearchMoreOptions(APPLICATION_LIST,applicationListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public HyperledgerNetworkTokens searchAllTextOfApplicationList(String verb, String value){	
		String field = "id|name|mspid|publicKey|privateKey";
		addSearchMoreOptions(APPLICATION_LIST,applicationListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public HyperledgerNetworkTokens rowsPerPageOfApplicationList(int rowsPerPage){		
		addSimpleOptions(APPLICATION_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public HyperledgerNetworkTokens currentPageNumberOfApplicationList(int currentPageNumber){		
		addSimpleOptions(APPLICATION_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public HyperledgerNetworkTokens retainColumnsOfApplicationList(String[] columns){		
		addSimpleOptions(APPLICATION_LIST+"RetainColumns",columns);
		return this;
	}
	public HyperledgerNetworkTokens excludeColumnsOfApplicationList(String[] columns){		
		addSimpleOptions(APPLICATION_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String SERVICE_RECORD_LIST = "serviceRecordList";
	public String getServiceRecordList(){
		return SERVICE_RECORD_LIST;
	}
	public HyperledgerNetworkTokens withServiceRecordList(){		
		addSimpleOptions(SERVICE_RECORD_LIST);
		return this;
	}
	public HyperledgerNetworkTokens analyzeServiceRecordList(){		
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
	public HyperledgerNetworkTokens extractMoreFromServiceRecordList(String idsSeperatedWithComma){		
		addSimpleOptions(SERVICE_RECORD_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int serviceRecordListSortCounter = 0;
	public HyperledgerNetworkTokens sortServiceRecordListWith(String field, String descOrAsc){		
		addSortMoreOptions(SERVICE_RECORD_LIST,serviceRecordListSortCounter++, field, descOrAsc);
		return this;
	}
	private int serviceRecordListSearchCounter = 0;
	public HyperledgerNetworkTokens searchServiceRecordListWith(String field, String verb, String value){		
		
		withServiceRecordList();
		addSearchMoreOptions(SERVICE_RECORD_LIST,serviceRecordListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public HyperledgerNetworkTokens searchAllTextOfServiceRecordList(String verb, String value){	
		String field = "id|name|payLoad|chainCodeFunction|transactionId|blockId|currentStatus";
		addSearchMoreOptions(SERVICE_RECORD_LIST,serviceRecordListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public HyperledgerNetworkTokens rowsPerPageOfServiceRecordList(int rowsPerPage){		
		addSimpleOptions(SERVICE_RECORD_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public HyperledgerNetworkTokens currentPageNumberOfServiceRecordList(int currentPageNumber){		
		addSimpleOptions(SERVICE_RECORD_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public HyperledgerNetworkTokens retainColumnsOfServiceRecordList(String[] columns){		
		addSimpleOptions(SERVICE_RECORD_LIST+"RetainColumns",columns);
		return this;
	}
	public HyperledgerNetworkTokens excludeColumnsOfServiceRecordList(String[] columns){		
		addSimpleOptions(SERVICE_RECORD_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String CHANGE_REQUEST_TYPE_LIST = "changeRequestTypeList";
	public String getChangeRequestTypeList(){
		return CHANGE_REQUEST_TYPE_LIST;
	}
	public HyperledgerNetworkTokens withChangeRequestTypeList(){		
		addSimpleOptions(CHANGE_REQUEST_TYPE_LIST);
		return this;
	}
	public HyperledgerNetworkTokens analyzeChangeRequestTypeList(){		
		addSimpleOptions(CHANGE_REQUEST_TYPE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeChangeRequestTypeListEnabled(){		
		
		if(checkOptions(this.options(), CHANGE_REQUEST_TYPE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public HyperledgerNetworkTokens extractMoreFromChangeRequestTypeList(String idsSeperatedWithComma){		
		addSimpleOptions(CHANGE_REQUEST_TYPE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int changeRequestTypeListSortCounter = 0;
	public HyperledgerNetworkTokens sortChangeRequestTypeListWith(String field, String descOrAsc){		
		addSortMoreOptions(CHANGE_REQUEST_TYPE_LIST,changeRequestTypeListSortCounter++, field, descOrAsc);
		return this;
	}
	private int changeRequestTypeListSearchCounter = 0;
	public HyperledgerNetworkTokens searchChangeRequestTypeListWith(String field, String verb, String value){		
		
		withChangeRequestTypeList();
		addSearchMoreOptions(CHANGE_REQUEST_TYPE_LIST,changeRequestTypeListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public HyperledgerNetworkTokens searchAllTextOfChangeRequestTypeList(String verb, String value){	
		String field = "id|name|code|icon|bindTypes|stepConfiguration";
		addSearchMoreOptions(CHANGE_REQUEST_TYPE_LIST,changeRequestTypeListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public HyperledgerNetworkTokens rowsPerPageOfChangeRequestTypeList(int rowsPerPage){		
		addSimpleOptions(CHANGE_REQUEST_TYPE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public HyperledgerNetworkTokens currentPageNumberOfChangeRequestTypeList(int currentPageNumber){		
		addSimpleOptions(CHANGE_REQUEST_TYPE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public HyperledgerNetworkTokens retainColumnsOfChangeRequestTypeList(String[] columns){		
		addSimpleOptions(CHANGE_REQUEST_TYPE_LIST+"RetainColumns",columns);
		return this;
	}
	public HyperledgerNetworkTokens excludeColumnsOfChangeRequestTypeList(String[] columns){		
		addSimpleOptions(CHANGE_REQUEST_TYPE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String CHANGE_REQUEST_LIST = "changeRequestList";
	public String getChangeRequestList(){
		return CHANGE_REQUEST_LIST;
	}
	public HyperledgerNetworkTokens withChangeRequestList(){		
		addSimpleOptions(CHANGE_REQUEST_LIST);
		return this;
	}
	public HyperledgerNetworkTokens analyzeChangeRequestList(){		
		addSimpleOptions(CHANGE_REQUEST_LIST+".anaylze");
		return this;
	}
	public boolean analyzeChangeRequestListEnabled(){		
		
		if(checkOptions(this.options(), CHANGE_REQUEST_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public HyperledgerNetworkTokens extractMoreFromChangeRequestList(String idsSeperatedWithComma){		
		addSimpleOptions(CHANGE_REQUEST_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int changeRequestListSortCounter = 0;
	public HyperledgerNetworkTokens sortChangeRequestListWith(String field, String descOrAsc){		
		addSortMoreOptions(CHANGE_REQUEST_LIST,changeRequestListSortCounter++, field, descOrAsc);
		return this;
	}
	private int changeRequestListSearchCounter = 0;
	public HyperledgerNetworkTokens searchChangeRequestListWith(String field, String verb, String value){		
		
		withChangeRequestList();
		addSearchMoreOptions(CHANGE_REQUEST_LIST,changeRequestListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public HyperledgerNetworkTokens searchAllTextOfChangeRequestList(String verb, String value){	
		String field = "id|name|remoteIp";
		addSearchMoreOptions(CHANGE_REQUEST_LIST,changeRequestListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public HyperledgerNetworkTokens rowsPerPageOfChangeRequestList(int rowsPerPage){		
		addSimpleOptions(CHANGE_REQUEST_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public HyperledgerNetworkTokens currentPageNumberOfChangeRequestList(int currentPageNumber){		
		addSimpleOptions(CHANGE_REQUEST_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public HyperledgerNetworkTokens retainColumnsOfChangeRequestList(String[] columns){		
		addSimpleOptions(CHANGE_REQUEST_LIST+"RetainColumns",columns);
		return this;
	}
	public HyperledgerNetworkTokens excludeColumnsOfChangeRequestList(String[] columns){		
		addSimpleOptions(CHANGE_REQUEST_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  HyperledgerNetworkTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfOrganizationList(verb, value);	
		searchAllTextOfNodeList(verb, value);	
		searchAllTextOfChannelList(verb, value);	
		searchAllTextOfApplicationList(verb, value);	
		searchAllTextOfServiceRecordList(verb, value);	
		searchAllTextOfChangeRequestTypeList(verb, value);	
		searchAllTextOfChangeRequestList(verb, value);	
		return this;
	}
}

