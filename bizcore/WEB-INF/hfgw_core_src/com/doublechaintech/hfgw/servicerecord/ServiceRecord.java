
package com.doublechaintech.hfgw.servicerecord;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;
import com.doublechaintech.hfgw.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.hfgw.chaincode.ChainCode;
import com.doublechaintech.hfgw.transactionstatus.TransactionStatus;
import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.application.Application;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

@JsonSerialize(using = ServiceRecordSerializer.class)
public class ServiceRecord extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TRANSACTION_ID_PROPERTY        = "transactionId"     ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String PAYLOAD_PROPERTY               = "payload"           ;
	public static final String CHANNEL_PROPERTY               = "channel"           ;
	public static final String CHAIN_CODE_PROPERTY            = "chainCode"         ;
	public static final String CHAIN_CODE_FUNCTION_PROPERTY   = "chainCodeFunction" ;
	public static final String BLOCK_ID_PROPERTY              = "blockId"           ;
	public static final String CREATE_TIME_PROPERTY           = "createTime"        ;
	public static final String APP_CLIENT_PROPERTY            = "appClient"         ;
	public static final String NETWORK_PROPERTY               = "network"           ;
	public static final String RESPONSE_PROPERTY              = "response"          ;
	public static final String STATUS_PROPERTY                = "status"            ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="ServiceRecord";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getTransactionId();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mTransactionId      ;
	protected		String              	mName               ;
	protected		String              	mPayload            ;
	protected		Channel             	mChannel            ;
	protected		ChainCode           	mChainCode          ;
	protected		String              	mChainCodeFunction  ;
	protected		String              	mBlockId            ;
	protected		DateTime            	mCreateTime         ;
	protected		Application         	mAppClient          ;
	protected		HyperledgerNetwork  	mNetwork            ;
	protected		String              	mResponse           ;
	protected		TransactionStatus   	mStatus             ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	ServiceRecord(){
		// lazy load for all the properties
	}
	public 	static ServiceRecord withId(String id){
		ServiceRecord serviceRecord = new ServiceRecord();
		serviceRecord.setId(id);
		serviceRecord.setVersion(Integer.MAX_VALUE);
		return serviceRecord;
	}
	public 	static ServiceRecord refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setChannel( null );
		setChainCode( null );
		setAppClient( null );
		setNetwork( null );
		setStatus( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(TRANSACTION_ID_PROPERTY.equals(property)){
			changeTransactionIdProperty(newValueExpr);
		}
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(PAYLOAD_PROPERTY.equals(property)){
			changePayloadProperty(newValueExpr);
		}
		if(CHAIN_CODE_FUNCTION_PROPERTY.equals(property)){
			changeChainCodeFunctionProperty(newValueExpr);
		}
		if(BLOCK_ID_PROPERTY.equals(property)){
			changeBlockIdProperty(newValueExpr);
		}
		if(CREATE_TIME_PROPERTY.equals(property)){
			changeCreateTimeProperty(newValueExpr);
		}
		if(RESPONSE_PROPERTY.equals(property)){
			changeResponseProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeTransactionIdProperty(String newValueExpr){
		String oldValue = getTransactionId();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateTransactionId(newValue);
		this.onChangeProperty(TRANSACTION_ID_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeNameProperty(String newValueExpr){
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateName(newValue);
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changePayloadProperty(String newValueExpr){
		String oldValue = getPayload();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePayload(newValue);
		this.onChangeProperty(PAYLOAD_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeChainCodeFunctionProperty(String newValueExpr){
		String oldValue = getChainCodeFunction();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateChainCodeFunction(newValue);
		this.onChangeProperty(CHAIN_CODE_FUNCTION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeBlockIdProperty(String newValueExpr){
		String oldValue = getBlockId();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateBlockId(newValue);
		this.onChangeProperty(BLOCK_ID_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeCreateTimeProperty(String newValueExpr){
		DateTime oldValue = getCreateTime();
		DateTime newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCreateTime(newValue);
		this.onChangeProperty(CREATE_TIME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeResponseProperty(String newValueExpr){
		String oldValue = getResponse();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateResponse(newValue);
		this.onChangeProperty(RESPONSE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(TRANSACTION_ID_PROPERTY.equals(property)){
			return getTransactionId();
		}
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(PAYLOAD_PROPERTY.equals(property)){
			return getPayload();
		}
		if(CHANNEL_PROPERTY.equals(property)){
			return getChannel();
		}
		if(CHAIN_CODE_PROPERTY.equals(property)){
			return getChainCode();
		}
		if(CHAIN_CODE_FUNCTION_PROPERTY.equals(property)){
			return getChainCodeFunction();
		}
		if(BLOCK_ID_PROPERTY.equals(property)){
			return getBlockId();
		}
		if(CREATE_TIME_PROPERTY.equals(property)){
			return getCreateTime();
		}
		if(APP_CLIENT_PROPERTY.equals(property)){
			return getAppClient();
		}
		if(NETWORK_PROPERTY.equals(property)){
			return getNetwork();
		}
		if(RESPONSE_PROPERTY.equals(property)){
			return getResponse();
		}
		if(STATUS_PROPERTY.equals(property)){
			return getStatus();
		}

    		//other property not include here
		return super.propertyOf(property);
	}
    
    


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public ServiceRecord updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setTransactionId(String transactionId){
		this.mTransactionId = trimString(transactionId);;
	}
	public String getTransactionId(){
		return this.mTransactionId;
	}
	public ServiceRecord updateTransactionId(String transactionId){
		this.mTransactionId = trimString(transactionId);;
		this.changed = true;
		return this;
	}
	public void mergeTransactionId(String transactionId){
		if(transactionId != null) { setTransactionId(transactionId);}
	}
	
	
	public void clearTransactionId(){
		setTransactionId ( null );
		this.changed = true;
	}
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public ServiceRecord updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setPayload(String payload){
		this.mPayload = payload;;
	}
	public String getPayload(){
		return this.mPayload;
	}
	public ServiceRecord updatePayload(String payload){
		this.mPayload = payload;;
		this.changed = true;
		return this;
	}
	public void mergePayload(String payload){
		if(payload != null) { setPayload(payload);}
	}
	
	
	public void setChannel(Channel channel){
		this.mChannel = channel;;
	}
	public Channel getChannel(){
		return this.mChannel;
	}
	public ServiceRecord updateChannel(Channel channel){
		this.mChannel = channel;;
		this.changed = true;
		return this;
	}
	public void mergeChannel(Channel channel){
		if(channel != null) { setChannel(channel);}
	}
	
	
	public void clearChannel(){
		setChannel ( null );
		this.changed = true;
	}
	
	public void setChainCode(ChainCode chainCode){
		this.mChainCode = chainCode;;
	}
	public ChainCode getChainCode(){
		return this.mChainCode;
	}
	public ServiceRecord updateChainCode(ChainCode chainCode){
		this.mChainCode = chainCode;;
		this.changed = true;
		return this;
	}
	public void mergeChainCode(ChainCode chainCode){
		if(chainCode != null) { setChainCode(chainCode);}
	}
	
	
	public void clearChainCode(){
		setChainCode ( null );
		this.changed = true;
	}
	
	public void setChainCodeFunction(String chainCodeFunction){
		this.mChainCodeFunction = trimString(chainCodeFunction);;
	}
	public String getChainCodeFunction(){
		return this.mChainCodeFunction;
	}
	public ServiceRecord updateChainCodeFunction(String chainCodeFunction){
		this.mChainCodeFunction = trimString(chainCodeFunction);;
		this.changed = true;
		return this;
	}
	public void mergeChainCodeFunction(String chainCodeFunction){
		if(chainCodeFunction != null) { setChainCodeFunction(chainCodeFunction);}
	}
	
	
	public void setBlockId(String blockId){
		this.mBlockId = trimString(blockId);;
	}
	public String getBlockId(){
		return this.mBlockId;
	}
	public ServiceRecord updateBlockId(String blockId){
		this.mBlockId = trimString(blockId);;
		this.changed = true;
		return this;
	}
	public void mergeBlockId(String blockId){
		if(blockId != null) { setBlockId(blockId);}
	}
	
	
	public void clearBlockId(){
		setBlockId ( null );
		this.changed = true;
	}
	
	public void setCreateTime(DateTime createTime){
		this.mCreateTime = createTime;;
	}
	public DateTime getCreateTime(){
		return this.mCreateTime;
	}
	public ServiceRecord updateCreateTime(DateTime createTime){
		this.mCreateTime = createTime;;
		this.changed = true;
		return this;
	}
	public void mergeCreateTime(DateTime createTime){
		setCreateTime(createTime);
	}
	
	
	public void setAppClient(Application appClient){
		this.mAppClient = appClient;;
	}
	public Application getAppClient(){
		return this.mAppClient;
	}
	public ServiceRecord updateAppClient(Application appClient){
		this.mAppClient = appClient;;
		this.changed = true;
		return this;
	}
	public void mergeAppClient(Application appClient){
		if(appClient != null) { setAppClient(appClient);}
	}
	
	
	public void clearAppClient(){
		setAppClient ( null );
		this.changed = true;
	}
	
	public void setNetwork(HyperledgerNetwork network){
		this.mNetwork = network;;
	}
	public HyperledgerNetwork getNetwork(){
		return this.mNetwork;
	}
	public ServiceRecord updateNetwork(HyperledgerNetwork network){
		this.mNetwork = network;;
		this.changed = true;
		return this;
	}
	public void mergeNetwork(HyperledgerNetwork network){
		if(network != null) { setNetwork(network);}
	}
	
	
	public void clearNetwork(){
		setNetwork ( null );
		this.changed = true;
	}
	
	public void setResponse(String response){
		this.mResponse = response;;
	}
	public String getResponse(){
		return this.mResponse;
	}
	public ServiceRecord updateResponse(String response){
		this.mResponse = response;;
		this.changed = true;
		return this;
	}
	public void mergeResponse(String response){
		if(response != null) { setResponse(response);}
	}
	
	
	public void setStatus(TransactionStatus status){
		this.mStatus = status;;
	}
	public TransactionStatus getStatus(){
		return this.mStatus;
	}
	public ServiceRecord updateStatus(TransactionStatus status){
		this.mStatus = status;;
		this.changed = true;
		return this;
	}
	public void mergeStatus(TransactionStatus status){
		if(status != null) { setStatus(status);}
	}
	
	
	public void clearStatus(){
		setStatus ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public ServiceRecord updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getChannel(), internalType);
		addToEntityList(this, entityList, getChainCode(), internalType);
		addToEntityList(this, entityList, getAppClient(), internalType);
		addToEntityList(this, entityList, getNetwork(), internalType);
		addToEntityList(this, entityList, getStatus(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, TRANSACTION_ID_PROPERTY, getTransactionId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, PAYLOAD_PROPERTY, getPayload());
		appendKeyValuePair(result, CHANNEL_PROPERTY, getChannel());
		appendKeyValuePair(result, CHAIN_CODE_PROPERTY, getChainCode());
		appendKeyValuePair(result, CHAIN_CODE_FUNCTION_PROPERTY, getChainCodeFunction());
		appendKeyValuePair(result, BLOCK_ID_PROPERTY, getBlockId());
		appendKeyValuePair(result, CREATE_TIME_PROPERTY, getCreateTime());
		appendKeyValuePair(result, APP_CLIENT_PROPERTY, getAppClient());
		appendKeyValuePair(result, NETWORK_PROPERTY, getNetwork());
		appendKeyValuePair(result, RESPONSE_PROPERTY, getResponse());
		appendKeyValuePair(result, STATUS_PROPERTY, getStatus());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ServiceRecord){
		
		
			ServiceRecord dest =(ServiceRecord)baseDest;
		
			dest.setId(getId());
			dest.setTransactionId(getTransactionId());
			dest.setName(getName());
			dest.setPayload(getPayload());
			dest.setChannel(getChannel());
			dest.setChainCode(getChainCode());
			dest.setChainCodeFunction(getChainCodeFunction());
			dest.setBlockId(getBlockId());
			dest.setCreateTime(getCreateTime());
			dest.setAppClient(getAppClient());
			dest.setNetwork(getNetwork());
			dest.setResponse(getResponse());
			dest.setStatus(getStatus());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ServiceRecord){
		
			
			ServiceRecord dest =(ServiceRecord)baseDest;
		
			dest.mergeId(getId());
			dest.mergeTransactionId(getTransactionId());
			dest.mergeName(getName());
			dest.mergePayload(getPayload());
			dest.mergeChannel(getChannel());
			dest.mergeChainCode(getChainCode());
			dest.mergeChainCodeFunction(getChainCodeFunction());
			dest.mergeBlockId(getBlockId());
			dest.mergeCreateTime(getCreateTime());
			dest.mergeAppClient(getAppClient());
			dest.mergeNetwork(getNetwork());
			dest.mergeResponse(getResponse());
			dest.mergeStatus(getStatus());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ServiceRecord){
		
			
			ServiceRecord dest =(ServiceRecord)baseDest;
		
			dest.mergeId(getId());
			dest.mergeTransactionId(getTransactionId());
			dest.mergeName(getName());
			dest.mergePayload(getPayload());
			dest.mergeChainCodeFunction(getChainCodeFunction());
			dest.mergeBlockId(getBlockId());
			dest.mergeCreateTime(getCreateTime());
			dest.mergeResponse(getResponse());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("ServiceRecord{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttransactionId='"+getTransactionId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tpayload='"+getPayload()+"';");
		if(getChannel() != null ){
 			stringBuilder.append("\tchannel='Channel("+getChannel().getId()+")';");
 		}
		if(getChainCode() != null ){
 			stringBuilder.append("\tchainCode='ChainCode("+getChainCode().getId()+")';");
 		}
		stringBuilder.append("\tchainCodeFunction='"+getChainCodeFunction()+"';");
		stringBuilder.append("\tblockId='"+getBlockId()+"';");
		stringBuilder.append("\tcreateTime='"+getCreateTime()+"';");
		if(getAppClient() != null ){
 			stringBuilder.append("\tappClient='Application("+getAppClient().getId()+")';");
 		}
		if(getNetwork() != null ){
 			stringBuilder.append("\tnetwork='HyperledgerNetwork("+getNetwork().getId()+")';");
 		}
		stringBuilder.append("\tresponse='"+getResponse()+"';");
		if(getStatus() != null ){
 			stringBuilder.append("\tstatus='TransactionStatus("+getStatus().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

