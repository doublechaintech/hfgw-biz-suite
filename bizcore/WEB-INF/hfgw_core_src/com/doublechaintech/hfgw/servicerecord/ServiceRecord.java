
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
import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.application.Application;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

@JsonSerialize(using = ServiceRecordSerializer.class)
public class ServiceRecord extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String PAY_LOAD_PROPERTY              = "payLoad"           ;
	public static final String CHANNEL_PROPERTY               = "channel"           ;
	public static final String CHAIN_CODE_PROPERTY            = "chainCode"         ;
	public static final String CHAIN_CODE_FUNCTION_PROPERTY   = "chainCodeFunction" ;
	public static final String TRANSACTION_ID_PROPERTY        = "transactionId"     ;
	public static final String BLOCK_ID_PROPERTY              = "blockId"           ;
	public static final String CREATE_TIME_PROPERTY           = "createTime"        ;
	public static final String APPLICATION_PROPERTY           = "application"       ;
	public static final String NETWORK_PROPERTY               = "network"           ;
	public static final String CURRENT_STATUS_PROPERTY        = "currentStatus"     ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="ServiceRecord";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mPayLoad            ;
	protected		Channel             	mChannel            ;
	protected		ChainCode           	mChainCode          ;
	protected		String              	mChainCodeFunction  ;
	protected		String              	mTransactionId      ;
	protected		String              	mBlockId            ;
	protected		DateTime            	mCreateTime         ;
	protected		Application         	mApplication        ;
	protected		HyperledgerNetwork  	mNetwork            ;
	protected		String              	mCurrentStatus      ;
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
		setApplication( null );
		setNetwork( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(PAY_LOAD_PROPERTY.equals(property)){
			changePayLoadProperty(newValueExpr);
		}
		if(CHAIN_CODE_FUNCTION_PROPERTY.equals(property)){
			changeChainCodeFunctionProperty(newValueExpr);
		}
		if(TRANSACTION_ID_PROPERTY.equals(property)){
			changeTransactionIdProperty(newValueExpr);
		}
		if(BLOCK_ID_PROPERTY.equals(property)){
			changeBlockIdProperty(newValueExpr);
		}
		if(CREATE_TIME_PROPERTY.equals(property)){
			changeCreateTimeProperty(newValueExpr);
		}

      
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
			
			
			
	protected void changePayLoadProperty(String newValueExpr){
		String oldValue = getPayLoad();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePayLoad(newValue);
		this.onChangeProperty(PAY_LOAD_PROPERTY, oldValue, newValue);
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
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(PAY_LOAD_PROPERTY.equals(property)){
			return getPayLoad();
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
		if(TRANSACTION_ID_PROPERTY.equals(property)){
			return getTransactionId();
		}
		if(BLOCK_ID_PROPERTY.equals(property)){
			return getBlockId();
		}
		if(CREATE_TIME_PROPERTY.equals(property)){
			return getCreateTime();
		}
		if(APPLICATION_PROPERTY.equals(property)){
			return getApplication();
		}
		if(NETWORK_PROPERTY.equals(property)){
			return getNetwork();
		}
		if(CURRENT_STATUS_PROPERTY.equals(property)){
			return getCurrentStatus();
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
	
	
	public void setPayLoad(String payLoad){
		this.mPayLoad = payLoad;;
	}
	public String getPayLoad(){
		return this.mPayLoad;
	}
	public ServiceRecord updatePayLoad(String payLoad){
		this.mPayLoad = payLoad;;
		this.changed = true;
		return this;
	}
	public void mergePayLoad(String payLoad){
		if(payLoad != null) { setPayLoad(payLoad);}
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
	
	
	public void setApplication(Application application){
		this.mApplication = application;;
	}
	public Application getApplication(){
		return this.mApplication;
	}
	public ServiceRecord updateApplication(Application application){
		this.mApplication = application;;
		this.changed = true;
		return this;
	}
	public void mergeApplication(Application application){
		if(application != null) { setApplication(application);}
	}
	
	
	public void clearApplication(){
		setApplication ( null );
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
	
	public void setCurrentStatus(String currentStatus){
		this.mCurrentStatus = trimString(currentStatus);;
	}
	public String getCurrentStatus(){
		return this.mCurrentStatus;
	}
	public ServiceRecord updateCurrentStatus(String currentStatus){
		this.mCurrentStatus = trimString(currentStatus);;
		this.changed = true;
		return this;
	}
	public void mergeCurrentStatus(String currentStatus){
		if(currentStatus != null) { setCurrentStatus(currentStatus);}
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
		addToEntityList(this, entityList, getApplication(), internalType);
		addToEntityList(this, entityList, getNetwork(), internalType);

		
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
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, PAY_LOAD_PROPERTY, getPayLoad());
		appendKeyValuePair(result, CHANNEL_PROPERTY, getChannel());
		appendKeyValuePair(result, CHAIN_CODE_PROPERTY, getChainCode());
		appendKeyValuePair(result, CHAIN_CODE_FUNCTION_PROPERTY, getChainCodeFunction());
		appendKeyValuePair(result, TRANSACTION_ID_PROPERTY, getTransactionId());
		appendKeyValuePair(result, BLOCK_ID_PROPERTY, getBlockId());
		appendKeyValuePair(result, CREATE_TIME_PROPERTY, getCreateTime());
		appendKeyValuePair(result, APPLICATION_PROPERTY, getApplication());
		appendKeyValuePair(result, NETWORK_PROPERTY, getNetwork());
		appendKeyValuePair(result, CURRENT_STATUS_PROPERTY, getCurrentStatus());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ServiceRecord){
		
		
			ServiceRecord dest =(ServiceRecord)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setPayLoad(getPayLoad());
			dest.setChannel(getChannel());
			dest.setChainCode(getChainCode());
			dest.setChainCodeFunction(getChainCodeFunction());
			dest.setTransactionId(getTransactionId());
			dest.setBlockId(getBlockId());
			dest.setCreateTime(getCreateTime());
			dest.setApplication(getApplication());
			dest.setNetwork(getNetwork());
			dest.setCurrentStatus(getCurrentStatus());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ServiceRecord){
		
			
			ServiceRecord dest =(ServiceRecord)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergePayLoad(getPayLoad());
			dest.mergeChannel(getChannel());
			dest.mergeChainCode(getChainCode());
			dest.mergeChainCodeFunction(getChainCodeFunction());
			dest.mergeTransactionId(getTransactionId());
			dest.mergeBlockId(getBlockId());
			dest.mergeCreateTime(getCreateTime());
			dest.mergeApplication(getApplication());
			dest.mergeNetwork(getNetwork());
			dest.mergeCurrentStatus(getCurrentStatus());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ServiceRecord){
		
			
			ServiceRecord dest =(ServiceRecord)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergePayLoad(getPayLoad());
			dest.mergeChainCodeFunction(getChainCodeFunction());
			dest.mergeTransactionId(getTransactionId());
			dest.mergeBlockId(getBlockId());
			dest.mergeCreateTime(getCreateTime());
			dest.mergeCurrentStatus(getCurrentStatus());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("ServiceRecord{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tpayLoad='"+getPayLoad()+"';");
		if(getChannel() != null ){
 			stringBuilder.append("\tchannel='Channel("+getChannel().getId()+")';");
 		}
		if(getChainCode() != null ){
 			stringBuilder.append("\tchainCode='ChainCode("+getChainCode().getId()+")';");
 		}
		stringBuilder.append("\tchainCodeFunction='"+getChainCodeFunction()+"';");
		stringBuilder.append("\ttransactionId='"+getTransactionId()+"';");
		stringBuilder.append("\tblockId='"+getBlockId()+"';");
		stringBuilder.append("\tcreateTime='"+getCreateTime()+"';");
		if(getApplication() != null ){
 			stringBuilder.append("\tapplication='Application("+getApplication().getId()+")';");
 		}
		if(getNetwork() != null ){
 			stringBuilder.append("\tnetwork='HyperledgerNetwork("+getNetwork().getId()+")';");
 		}
		stringBuilder.append("\tcurrentStatus='"+getCurrentStatus()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

