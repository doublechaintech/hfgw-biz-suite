
package com.doublechaintech.hfgw.application;

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
import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.servicerecord.ServiceRecord;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

@JsonSerialize(using = ApplicationSerializer.class)
public class Application extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String CREATE_TIME_PROPERTY           = "createTime"        ;
	public static final String MSPID_PROPERTY                 = "mspid"             ;
	public static final String PUBLIC_KEY_PROPERTY            = "publicKey"         ;
	public static final String PRIVATE_KEY_PROPERTY           = "privateKey"        ;
	public static final String CHANNEL_PROPERTY               = "channel"           ;
	public static final String NETWORK_PROPERTY               = "network"           ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String SERVICE_RECORD_LIST                      = "serviceRecordList" ;

	public static final String INTERNAL_TYPE="Application";
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
	protected		DateTime            	mCreateTime         ;
	protected		String              	mMspid              ;
	protected		String              	mPublicKey          ;
	protected		String              	mPrivateKey         ;
	protected		Channel             	mChannel            ;
	protected		HyperledgerNetwork  	mNetwork            ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<ServiceRecord>	mServiceRecordList  ;
	
		
	public 	Application(){
		// lazy load for all the properties
	}
	public 	static Application withId(String id){
		Application application = new Application();
		application.setId(id);
		application.setVersion(Integer.MAX_VALUE);
		return application;
	}
	public 	static Application refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setChannel( null );
		setNetwork( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(CREATE_TIME_PROPERTY.equals(property)){
			changeCreateTimeProperty(newValueExpr);
		}
		if(MSPID_PROPERTY.equals(property)){
			changeMspidProperty(newValueExpr);
		}
		if(PUBLIC_KEY_PROPERTY.equals(property)){
			changePublicKeyProperty(newValueExpr);
		}
		if(PRIVATE_KEY_PROPERTY.equals(property)){
			changePrivateKeyProperty(newValueExpr);
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
			
			
			
	protected void changeMspidProperty(String newValueExpr){
		String oldValue = getMspid();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateMspid(newValue);
		this.onChangeProperty(MSPID_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changePublicKeyProperty(String newValueExpr){
		String oldValue = getPublicKey();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePublicKey(newValue);
		this.onChangeProperty(PUBLIC_KEY_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changePrivateKeyProperty(String newValueExpr){
		String oldValue = getPrivateKey();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePrivateKey(newValue);
		this.onChangeProperty(PRIVATE_KEY_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(CREATE_TIME_PROPERTY.equals(property)){
			return getCreateTime();
		}
		if(MSPID_PROPERTY.equals(property)){
			return getMspid();
		}
		if(PUBLIC_KEY_PROPERTY.equals(property)){
			return getPublicKey();
		}
		if(PRIVATE_KEY_PROPERTY.equals(property)){
			return getPrivateKey();
		}
		if(CHANNEL_PROPERTY.equals(property)){
			return getChannel();
		}
		if(NETWORK_PROPERTY.equals(property)){
			return getNetwork();
		}
		if(SERVICE_RECORD_LIST.equals(property)){
			List<BaseEntity> list = getServiceRecordList().stream().map(item->item).collect(Collectors.toList());
			return list;
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
	public Application updateId(String id){
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
	public Application updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setCreateTime(DateTime createTime){
		this.mCreateTime = createTime;;
	}
	public DateTime getCreateTime(){
		return this.mCreateTime;
	}
	public Application updateCreateTime(DateTime createTime){
		this.mCreateTime = createTime;;
		this.changed = true;
		return this;
	}
	public void mergeCreateTime(DateTime createTime){
		setCreateTime(createTime);
	}
	
	
	public void setMspid(String mspid){
		this.mMspid = trimString(mspid);;
	}
	public String getMspid(){
		return this.mMspid;
	}
	public Application updateMspid(String mspid){
		this.mMspid = trimString(mspid);;
		this.changed = true;
		return this;
	}
	public void mergeMspid(String mspid){
		if(mspid != null) { setMspid(mspid);}
	}
	
	
	public void setPublicKey(String publicKey){
		this.mPublicKey = publicKey;;
	}
	public String getPublicKey(){
		return this.mPublicKey;
	}
	public Application updatePublicKey(String publicKey){
		this.mPublicKey = publicKey;;
		this.changed = true;
		return this;
	}
	public void mergePublicKey(String publicKey){
		if(publicKey != null) { setPublicKey(publicKey);}
	}
	
	
	public void setPrivateKey(String privateKey){
		this.mPrivateKey = privateKey;;
	}
	public String getPrivateKey(){
		return this.mPrivateKey;
	}
	public Application updatePrivateKey(String privateKey){
		this.mPrivateKey = privateKey;;
		this.changed = true;
		return this;
	}
	public void mergePrivateKey(String privateKey){
		if(privateKey != null) { setPrivateKey(privateKey);}
	}
	
	
	public void setChannel(Channel channel){
		this.mChannel = channel;;
	}
	public Channel getChannel(){
		return this.mChannel;
	}
	public Application updateChannel(Channel channel){
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
	
	public void setNetwork(HyperledgerNetwork network){
		this.mNetwork = network;;
	}
	public HyperledgerNetwork getNetwork(){
		return this.mNetwork;
	}
	public Application updateNetwork(HyperledgerNetwork network){
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
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Application updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<ServiceRecord> getServiceRecordList(){
		if(this.mServiceRecordList == null){
			this.mServiceRecordList = new SmartList<ServiceRecord>();
			this.mServiceRecordList.setListInternalName (SERVICE_RECORD_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mServiceRecordList;	
	}
	public  void setServiceRecordList(SmartList<ServiceRecord> serviceRecordList){
		for( ServiceRecord serviceRecord:serviceRecordList){
			serviceRecord.setApplication(this);
		}

		this.mServiceRecordList = serviceRecordList;
		this.mServiceRecordList.setListInternalName (SERVICE_RECORD_LIST );
		
	}
	
	public  void addServiceRecord(ServiceRecord serviceRecord){
		serviceRecord.setApplication(this);
		getServiceRecordList().add(serviceRecord);
	}
	public  void addServiceRecordList(SmartList<ServiceRecord> serviceRecordList){
		for( ServiceRecord serviceRecord:serviceRecordList){
			serviceRecord.setApplication(this);
		}
		getServiceRecordList().addAll(serviceRecordList);
	}
	public  void mergeServiceRecordList(SmartList<ServiceRecord> serviceRecordList){
		if(serviceRecordList==null){
			return;
		}
		if(serviceRecordList.isEmpty()){
			return;
		}
		addServiceRecordList( serviceRecordList );
		
	}
	public  ServiceRecord removeServiceRecord(ServiceRecord serviceRecordIndex){
		
		int index = getServiceRecordList().indexOf(serviceRecordIndex);
        if(index < 0){
        	String message = "ServiceRecord("+serviceRecordIndex.getId()+") with version='"+serviceRecordIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ServiceRecord serviceRecord = getServiceRecordList().get(index);        
        // serviceRecord.clearApplication(); //disconnect with Application
        serviceRecord.clearFromAll(); //disconnect with Application
		
		boolean result = getServiceRecordList().planToRemove(serviceRecord);
        if(!result){
        	String message = "ServiceRecord("+serviceRecordIndex.getId()+") with version='"+serviceRecordIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return serviceRecord;
        
	
	}
	//断舍离
	public  void breakWithServiceRecord(ServiceRecord serviceRecord){
		
		if(serviceRecord == null){
			return;
		}
		serviceRecord.setApplication(null);
		//getServiceRecordList().remove();
	
	}
	
	public  boolean hasServiceRecord(ServiceRecord serviceRecord){
	
		return getServiceRecordList().contains(serviceRecord);
  
	}
	
	public void copyServiceRecordFrom(ServiceRecord serviceRecord) {

		ServiceRecord serviceRecordInList = findTheServiceRecord(serviceRecord);
		ServiceRecord newServiceRecord = new ServiceRecord();
		serviceRecordInList.copyTo(newServiceRecord);
		newServiceRecord.setVersion(0);//will trigger copy
		getServiceRecordList().add(newServiceRecord);
		addItemToFlexiableObject(COPIED_CHILD, newServiceRecord);
	}
	
	public  ServiceRecord findTheServiceRecord(ServiceRecord serviceRecord){
		
		int index =  getServiceRecordList().indexOf(serviceRecord);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ServiceRecord("+serviceRecord.getId()+") with version='"+serviceRecord.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getServiceRecordList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpServiceRecordList(){
		getServiceRecordList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getChannel(), internalType);
		addToEntityList(this, entityList, getNetwork(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getServiceRecordList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getServiceRecordList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, CREATE_TIME_PROPERTY, getCreateTime());
		appendKeyValuePair(result, MSPID_PROPERTY, getMspid());
		appendKeyValuePair(result, PUBLIC_KEY_PROPERTY, getPublicKey());
		appendKeyValuePair(result, PRIVATE_KEY_PROPERTY, getPrivateKey());
		appendKeyValuePair(result, CHANNEL_PROPERTY, getChannel());
		appendKeyValuePair(result, NETWORK_PROPERTY, getNetwork());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, SERVICE_RECORD_LIST, getServiceRecordList());
		if(!getServiceRecordList().isEmpty()){
			appendKeyValuePair(result, "serviceRecordCount", getServiceRecordList().getTotalCount());
			appendKeyValuePair(result, "serviceRecordCurrentPageNumber", getServiceRecordList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Application){
		
		
			Application dest =(Application)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setCreateTime(getCreateTime());
			dest.setMspid(getMspid());
			dest.setPublicKey(getPublicKey());
			dest.setPrivateKey(getPrivateKey());
			dest.setChannel(getChannel());
			dest.setNetwork(getNetwork());
			dest.setVersion(getVersion());
			dest.setServiceRecordList(getServiceRecordList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Application){
		
			
			Application dest =(Application)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCreateTime(getCreateTime());
			dest.mergeMspid(getMspid());
			dest.mergePublicKey(getPublicKey());
			dest.mergePrivateKey(getPrivateKey());
			dest.mergeChannel(getChannel());
			dest.mergeNetwork(getNetwork());
			dest.mergeVersion(getVersion());
			dest.mergeServiceRecordList(getServiceRecordList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Application){
		
			
			Application dest =(Application)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCreateTime(getCreateTime());
			dest.mergeMspid(getMspid());
			dest.mergePublicKey(getPublicKey());
			dest.mergePrivateKey(getPrivateKey());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Application{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tcreateTime='"+getCreateTime()+"';");
		stringBuilder.append("\tmspid='"+getMspid()+"';");
		stringBuilder.append("\tpublicKey='"+getPublicKey()+"';");
		stringBuilder.append("\tprivateKey='"+getPrivateKey()+"';");
		if(getChannel() != null ){
 			stringBuilder.append("\tchannel='Channel("+getChannel().getId()+")';");
 		}
		if(getNetwork() != null ){
 			stringBuilder.append("\tnetwork='HyperledgerNetwork("+getNetwork().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

