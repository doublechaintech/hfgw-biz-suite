
package com.doublechaintech.hfgw.transactionstatus;

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
import com.doublechaintech.hfgw.servicerecord.ServiceRecord;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

@JsonSerialize(using = TransactionStatusSerializer.class)
public class TransactionStatus extends BaseEntity implements  java.io.Serializable{

	public static final String NEW = "new";	// new
	public static final String ENDORSED = "endorsed";	// endorsed
	public static final String COMMITTED = "committed";	// committed
	public static final String REJECTED = "rejected";	// rejected
	public static List<KeyValuePair> CODE_NAME_LIST;
	static {
		CODE_NAME_LIST = new ArrayList<>();

		CODE_NAME_LIST.add(new KeyValuePair(NEW, "new"));
		CODE_NAME_LIST.add(new KeyValuePair(ENDORSED, "endorsed"));
		CODE_NAME_LIST.add(new KeyValuePair(COMMITTED, "committed"));
		CODE_NAME_LIST.add(new KeyValuePair(REJECTED, "rejected"));
	}
	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String CODE_PROPERTY                  = "code"              ;
	public static final String NETWORK_PROPERTY               = "network"           ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String SERVICE_RECORD_LIST                      = "serviceRecordList" ;

	public static final String INTERNAL_TYPE="TransactionStatus";
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
	protected		String              	mCode               ;
	protected		HyperledgerNetwork  	mNetwork            ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<ServiceRecord>	mServiceRecordList  ;
	
		
	public 	TransactionStatus(){
		// lazy load for all the properties
	}
	public 	static TransactionStatus withId(String id){
		TransactionStatus transactionStatus = new TransactionStatus();
		transactionStatus.setId(id);
		transactionStatus.setVersion(Integer.MAX_VALUE);
		return transactionStatus;
	}
	public 	static TransactionStatus refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setNetwork( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(CODE_PROPERTY.equals(property)){
			changeCodeProperty(newValueExpr);
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
			
			
			
	protected void changeCodeProperty(String newValueExpr){
		String oldValue = getCode();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCode(newValue);
		this.onChangeProperty(CODE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(CODE_PROPERTY.equals(property)){
			return getCode();
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
	public TransactionStatus updateId(String id){
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
	public TransactionStatus updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setCode(String code){
		this.mCode = trimString(code);;
	}
	public String getCode(){
		return this.mCode;
	}
	public TransactionStatus updateCode(String code){
		this.mCode = trimString(code);;
		this.changed = true;
		return this;
	}
	public void mergeCode(String code){
		if(code != null) { setCode(code);}
	}
	
	
	public void setNetwork(HyperledgerNetwork network){
		this.mNetwork = network;;
	}
	public HyperledgerNetwork getNetwork(){
		return this.mNetwork;
	}
	public TransactionStatus updateNetwork(HyperledgerNetwork network){
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
	public TransactionStatus updateVersion(int version){
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
			serviceRecord.setStatus(this);
		}

		this.mServiceRecordList = serviceRecordList;
		this.mServiceRecordList.setListInternalName (SERVICE_RECORD_LIST );
		
	}
	
	public  void addServiceRecord(ServiceRecord serviceRecord){
		serviceRecord.setStatus(this);
		getServiceRecordList().add(serviceRecord);
	}
	public  void addServiceRecordList(SmartList<ServiceRecord> serviceRecordList){
		for( ServiceRecord serviceRecord:serviceRecordList){
			serviceRecord.setStatus(this);
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
        // serviceRecord.clearStatus(); //disconnect with Status
        serviceRecord.clearFromAll(); //disconnect with Status
		
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
		serviceRecord.setStatus(null);
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
		appendKeyValuePair(result, CODE_PROPERTY, getCode());
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
		
		
		if(baseDest instanceof TransactionStatus){
		
		
			TransactionStatus dest =(TransactionStatus)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setCode(getCode());
			dest.setNetwork(getNetwork());
			dest.setVersion(getVersion());
			dest.setServiceRecordList(getServiceRecordList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TransactionStatus){
		
			
			TransactionStatus dest =(TransactionStatus)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCode(getCode());
			dest.mergeNetwork(getNetwork());
			dest.mergeVersion(getVersion());
			dest.mergeServiceRecordList(getServiceRecordList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TransactionStatus){
		
			
			TransactionStatus dest =(TransactionStatus)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCode(getCode());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("TransactionStatus{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tcode='"+getCode()+"';");
		if(getNetwork() != null ){
 			stringBuilder.append("\tnetwork='HyperledgerNetwork("+getNetwork().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

