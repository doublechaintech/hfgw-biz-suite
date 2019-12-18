
package com.doublechaintech.hfgw.channel;
import com.doublechaintech.hfgw.CommonTokens;
import java.util.Map;
public class ChannelTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="channel";
	
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
	protected ChannelTokens(){
		//ensure not initialized outside the class
	}
	public  static  ChannelTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		ChannelTokens tokens = new ChannelTokens(options);
		return tokens;
		
	}
	protected ChannelTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public ChannelTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ChannelTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ChannelTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ChannelTokens start(){
		return new ChannelTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ChannelTokens allTokens(){
		
		return start()
			.withNetwork()
			.withNodeList()
			.withChannelPeerRoleList()
			.withChainCodeList()
			.withApplicationList()
			.withServiceRecordList();
	
	}
	public static ChannelTokens withoutListsTokens(){
		
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
	
	public ChannelTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String NETWORK = "network";
	public String getNetwork(){
		return NETWORK;
	}
	public ChannelTokens withNetwork(){		
		addSimpleOptions(NETWORK);
		return this;
	}
	
	
	protected static final String NODE_LIST = "nodeList";
	public String getNodeList(){
		return NODE_LIST;
	}
	public ChannelTokens withNodeList(){		
		addSimpleOptions(NODE_LIST);
		return this;
	}
	public ChannelTokens analyzeNodeList(){		
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
	public ChannelTokens extractMoreFromNodeList(String idsSeperatedWithComma){		
		addSimpleOptions(NODE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int nodeListSortCounter = 0;
	public ChannelTokens sortNodeListWith(String field, String descOrAsc){		
		addSortMoreOptions(NODE_LIST,nodeListSortCounter++, field, descOrAsc);
		return this;
	}
	private int nodeListSearchCounter = 0;
	public ChannelTokens searchNodeListWith(String field, String verb, String value){		
		
		withNodeList();
		addSearchMoreOptions(NODE_LIST,nodeListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ChannelTokens searchAllTextOfNodeList(String verb, String value){	
		String field = "id|name|url|tlsCacert|address|contactPerson|contactTelephone";
		addSearchMoreOptions(NODE_LIST,nodeListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ChannelTokens rowsPerPageOfNodeList(int rowsPerPage){		
		addSimpleOptions(NODE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ChannelTokens currentPageNumberOfNodeList(int currentPageNumber){		
		addSimpleOptions(NODE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ChannelTokens retainColumnsOfNodeList(String[] columns){		
		addSimpleOptions(NODE_LIST+"RetainColumns",columns);
		return this;
	}
	public ChannelTokens excludeColumnsOfNodeList(String[] columns){		
		addSimpleOptions(NODE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String CHANNEL_PEER_ROLE_LIST = "channelPeerRoleList";
	public String getChannelPeerRoleList(){
		return CHANNEL_PEER_ROLE_LIST;
	}
	public ChannelTokens withChannelPeerRoleList(){		
		addSimpleOptions(CHANNEL_PEER_ROLE_LIST);
		return this;
	}
	public ChannelTokens analyzeChannelPeerRoleList(){		
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
	public ChannelTokens extractMoreFromChannelPeerRoleList(String idsSeperatedWithComma){		
		addSimpleOptions(CHANNEL_PEER_ROLE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int channelPeerRoleListSortCounter = 0;
	public ChannelTokens sortChannelPeerRoleListWith(String field, String descOrAsc){		
		addSortMoreOptions(CHANNEL_PEER_ROLE_LIST,channelPeerRoleListSortCounter++, field, descOrAsc);
		return this;
	}
	private int channelPeerRoleListSearchCounter = 0;
	public ChannelTokens searchChannelPeerRoleListWith(String field, String verb, String value){		
		
		withChannelPeerRoleList();
		addSearchMoreOptions(CHANNEL_PEER_ROLE_LIST,channelPeerRoleListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ChannelTokens searchAllTextOfChannelPeerRoleList(String verb, String value){	
		String field = "id";
		addSearchMoreOptions(CHANNEL_PEER_ROLE_LIST,channelPeerRoleListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ChannelTokens rowsPerPageOfChannelPeerRoleList(int rowsPerPage){		
		addSimpleOptions(CHANNEL_PEER_ROLE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ChannelTokens currentPageNumberOfChannelPeerRoleList(int currentPageNumber){		
		addSimpleOptions(CHANNEL_PEER_ROLE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ChannelTokens retainColumnsOfChannelPeerRoleList(String[] columns){		
		addSimpleOptions(CHANNEL_PEER_ROLE_LIST+"RetainColumns",columns);
		return this;
	}
	public ChannelTokens excludeColumnsOfChannelPeerRoleList(String[] columns){		
		addSimpleOptions(CHANNEL_PEER_ROLE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String CHAIN_CODE_LIST = "chainCodeList";
	public String getChainCodeList(){
		return CHAIN_CODE_LIST;
	}
	public ChannelTokens withChainCodeList(){		
		addSimpleOptions(CHAIN_CODE_LIST);
		return this;
	}
	public ChannelTokens analyzeChainCodeList(){		
		addSimpleOptions(CHAIN_CODE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeChainCodeListEnabled(){		
		
		if(checkOptions(this.options(), CHAIN_CODE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public ChannelTokens extractMoreFromChainCodeList(String idsSeperatedWithComma){		
		addSimpleOptions(CHAIN_CODE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int chainCodeListSortCounter = 0;
	public ChannelTokens sortChainCodeListWith(String field, String descOrAsc){		
		addSortMoreOptions(CHAIN_CODE_LIST,chainCodeListSortCounter++, field, descOrAsc);
		return this;
	}
	private int chainCodeListSearchCounter = 0;
	public ChannelTokens searchChainCodeListWith(String field, String verb, String value){		
		
		withChainCodeList();
		addSearchMoreOptions(CHAIN_CODE_LIST,chainCodeListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ChannelTokens searchAllTextOfChainCodeList(String verb, String value){	
		String field = "id|name|codeName|codeVersion";
		addSearchMoreOptions(CHAIN_CODE_LIST,chainCodeListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ChannelTokens rowsPerPageOfChainCodeList(int rowsPerPage){		
		addSimpleOptions(CHAIN_CODE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ChannelTokens currentPageNumberOfChainCodeList(int currentPageNumber){		
		addSimpleOptions(CHAIN_CODE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ChannelTokens retainColumnsOfChainCodeList(String[] columns){		
		addSimpleOptions(CHAIN_CODE_LIST+"RetainColumns",columns);
		return this;
	}
	public ChannelTokens excludeColumnsOfChainCodeList(String[] columns){		
		addSimpleOptions(CHAIN_CODE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String APPLICATION_LIST = "applicationList";
	public String getApplicationList(){
		return APPLICATION_LIST;
	}
	public ChannelTokens withApplicationList(){		
		addSimpleOptions(APPLICATION_LIST);
		return this;
	}
	public ChannelTokens analyzeApplicationList(){		
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
	public ChannelTokens extractMoreFromApplicationList(String idsSeperatedWithComma){		
		addSimpleOptions(APPLICATION_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int applicationListSortCounter = 0;
	public ChannelTokens sortApplicationListWith(String field, String descOrAsc){		
		addSortMoreOptions(APPLICATION_LIST,applicationListSortCounter++, field, descOrAsc);
		return this;
	}
	private int applicationListSearchCounter = 0;
	public ChannelTokens searchApplicationListWith(String field, String verb, String value){		
		
		withApplicationList();
		addSearchMoreOptions(APPLICATION_LIST,applicationListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ChannelTokens searchAllTextOfApplicationList(String verb, String value){	
		String field = "id|name|mspid|publicKey|privateKey";
		addSearchMoreOptions(APPLICATION_LIST,applicationListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ChannelTokens rowsPerPageOfApplicationList(int rowsPerPage){		
		addSimpleOptions(APPLICATION_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ChannelTokens currentPageNumberOfApplicationList(int currentPageNumber){		
		addSimpleOptions(APPLICATION_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ChannelTokens retainColumnsOfApplicationList(String[] columns){		
		addSimpleOptions(APPLICATION_LIST+"RetainColumns",columns);
		return this;
	}
	public ChannelTokens excludeColumnsOfApplicationList(String[] columns){		
		addSimpleOptions(APPLICATION_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String SERVICE_RECORD_LIST = "serviceRecordList";
	public String getServiceRecordList(){
		return SERVICE_RECORD_LIST;
	}
	public ChannelTokens withServiceRecordList(){		
		addSimpleOptions(SERVICE_RECORD_LIST);
		return this;
	}
	public ChannelTokens analyzeServiceRecordList(){		
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
	public ChannelTokens extractMoreFromServiceRecordList(String idsSeperatedWithComma){		
		addSimpleOptions(SERVICE_RECORD_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int serviceRecordListSortCounter = 0;
	public ChannelTokens sortServiceRecordListWith(String field, String descOrAsc){		
		addSortMoreOptions(SERVICE_RECORD_LIST,serviceRecordListSortCounter++, field, descOrAsc);
		return this;
	}
	private int serviceRecordListSearchCounter = 0;
	public ChannelTokens searchServiceRecordListWith(String field, String verb, String value){		
		
		withServiceRecordList();
		addSearchMoreOptions(SERVICE_RECORD_LIST,serviceRecordListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ChannelTokens searchAllTextOfServiceRecordList(String verb, String value){	
		String field = "id|transactionId|name|payload|chainCodeFunction|blockId|response";
		addSearchMoreOptions(SERVICE_RECORD_LIST,serviceRecordListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ChannelTokens rowsPerPageOfServiceRecordList(int rowsPerPage){		
		addSimpleOptions(SERVICE_RECORD_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ChannelTokens currentPageNumberOfServiceRecordList(int currentPageNumber){		
		addSimpleOptions(SERVICE_RECORD_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ChannelTokens retainColumnsOfServiceRecordList(String[] columns){		
		addSimpleOptions(SERVICE_RECORD_LIST+"RetainColumns",columns);
		return this;
	}
	public ChannelTokens excludeColumnsOfServiceRecordList(String[] columns){		
		addSimpleOptions(SERVICE_RECORD_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  ChannelTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfNodeList(verb, value);	
		searchAllTextOfChannelPeerRoleList(verb, value);	
		searchAllTextOfChainCodeList(verb, value);	
		searchAllTextOfApplicationList(verb, value);	
		searchAllTextOfServiceRecordList(verb, value);	
		return this;
	}
}

