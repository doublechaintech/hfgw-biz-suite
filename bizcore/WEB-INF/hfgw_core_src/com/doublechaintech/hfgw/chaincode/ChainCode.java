
package com.doublechaintech.hfgw.chaincode;

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

@JsonSerialize(using = ChainCodeSerializer.class)
public class ChainCode extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String CODE_NAME_PROPERTY             = "codeName"          ;
	public static final String CODE_VERSION_PROPERTY          = "codeVersion"       ;
	public static final String CHANNEL_PROPERTY               = "channel"           ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String SERVICE_RECORD_LIST                      = "serviceRecordList" ;

	public static final String INTERNAL_TYPE="ChainCode";
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
	protected		String              	mCodeName           ;
	protected		String              	mCodeVersion        ;
	protected		Channel             	mChannel            ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<ServiceRecord>	mServiceRecordList  ;
	
		
	public 	ChainCode(){
		// lazy load for all the properties
	}
	public 	static ChainCode withId(String id){
		ChainCode chainCode = new ChainCode();
		chainCode.setId(id);
		chainCode.setVersion(Integer.MAX_VALUE);
		return chainCode;
	}
	public 	static ChainCode refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setChannel( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(CODE_NAME_PROPERTY.equals(property)){
			changeCodeNameProperty(newValueExpr);
		}
		if(CODE_VERSION_PROPERTY.equals(property)){
			changeCodeVersionProperty(newValueExpr);
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
			
			
			
	protected void changeCodeNameProperty(String newValueExpr){
		String oldValue = getCodeName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCodeName(newValue);
		this.onChangeProperty(CODE_NAME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeCodeVersionProperty(String newValueExpr){
		String oldValue = getCodeVersion();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCodeVersion(newValue);
		this.onChangeProperty(CODE_VERSION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(CODE_NAME_PROPERTY.equals(property)){
			return getCodeName();
		}
		if(CODE_VERSION_PROPERTY.equals(property)){
			return getCodeVersion();
		}
		if(CHANNEL_PROPERTY.equals(property)){
			return getChannel();
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
	public ChainCode updateId(String id){
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
	public ChainCode updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setCodeName(String codeName){
		this.mCodeName = trimString(codeName);;
	}
	public String getCodeName(){
		return this.mCodeName;
	}
	public ChainCode updateCodeName(String codeName){
		this.mCodeName = trimString(codeName);;
		this.changed = true;
		return this;
	}
	public void mergeCodeName(String codeName){
		if(codeName != null) { setCodeName(codeName);}
	}
	
	
	public void setCodeVersion(String codeVersion){
		this.mCodeVersion = trimString(codeVersion);;
	}
	public String getCodeVersion(){
		return this.mCodeVersion;
	}
	public ChainCode updateCodeVersion(String codeVersion){
		this.mCodeVersion = trimString(codeVersion);;
		this.changed = true;
		return this;
	}
	public void mergeCodeVersion(String codeVersion){
		if(codeVersion != null) { setCodeVersion(codeVersion);}
	}
	
	
	public void setChannel(Channel channel){
		this.mChannel = channel;;
	}
	public Channel getChannel(){
		return this.mChannel;
	}
	public ChainCode updateChannel(Channel channel){
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
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public ChainCode updateVersion(int version){
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
			serviceRecord.setChainCode(this);
		}

		this.mServiceRecordList = serviceRecordList;
		this.mServiceRecordList.setListInternalName (SERVICE_RECORD_LIST );
		
	}
	
	public  void addServiceRecord(ServiceRecord serviceRecord){
		serviceRecord.setChainCode(this);
		getServiceRecordList().add(serviceRecord);
	}
	public  void addServiceRecordList(SmartList<ServiceRecord> serviceRecordList){
		for( ServiceRecord serviceRecord:serviceRecordList){
			serviceRecord.setChainCode(this);
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
        // serviceRecord.clearChainCode(); //disconnect with ChainCode
        serviceRecord.clearFromAll(); //disconnect with ChainCode
		
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
		serviceRecord.setChainCode(null);
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
		appendKeyValuePair(result, CODE_NAME_PROPERTY, getCodeName());
		appendKeyValuePair(result, CODE_VERSION_PROPERTY, getCodeVersion());
		appendKeyValuePair(result, CHANNEL_PROPERTY, getChannel());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, SERVICE_RECORD_LIST, getServiceRecordList());
		if(!getServiceRecordList().isEmpty()){
			appendKeyValuePair(result, "serviceRecordCount", getServiceRecordList().getTotalCount());
			appendKeyValuePair(result, "serviceRecordCurrentPageNumber", getServiceRecordList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ChainCode){
		
		
			ChainCode dest =(ChainCode)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setCodeName(getCodeName());
			dest.setCodeVersion(getCodeVersion());
			dest.setChannel(getChannel());
			dest.setVersion(getVersion());
			dest.setServiceRecordList(getServiceRecordList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ChainCode){
		
			
			ChainCode dest =(ChainCode)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCodeName(getCodeName());
			dest.mergeCodeVersion(getCodeVersion());
			dest.mergeChannel(getChannel());
			dest.mergeVersion(getVersion());
			dest.mergeServiceRecordList(getServiceRecordList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ChainCode){
		
			
			ChainCode dest =(ChainCode)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCodeName(getCodeName());
			dest.mergeCodeVersion(getCodeVersion());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("ChainCode{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tcodeName='"+getCodeName()+"';");
		stringBuilder.append("\tcodeVersion='"+getCodeVersion()+"';");
		if(getChannel() != null ){
 			stringBuilder.append("\tchannel='Channel("+getChannel().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

