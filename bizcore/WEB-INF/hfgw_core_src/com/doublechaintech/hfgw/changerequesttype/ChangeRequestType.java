
package com.doublechaintech.hfgw.changerequesttype;

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
import com.doublechaintech.hfgw.changerequest.ChangeRequest;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

@JsonSerialize(using = ChangeRequestTypeSerializer.class)
public class ChangeRequestType extends BaseEntity implements  java.io.Serializable{

	public static final String CHAINCODE_INVOKE = "CHAINCODE_INVOKE";	// 调用链码
	public static final String NETWORK_MANAGER = "NETWORK_MANAGER";	// 网络管理
	public static List<KeyValuePair> CODE_NAME_LIST;
	static {
		CODE_NAME_LIST = new ArrayList<>();

		CODE_NAME_LIST.add(new KeyValuePair(CHAINCODE_INVOKE, "调用链码"));
		CODE_NAME_LIST.add(new KeyValuePair(NETWORK_MANAGER, "网络管理"));
	}
	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String CODE_PROPERTY                  = "code"              ;
	public static final String ICON_PROPERTY                  = "icon"              ;
	public static final String DISPLAY_ORDER_PROPERTY         = "displayOrder"      ;
	public static final String BIND_TYPES_PROPERTY            = "bindTypes"         ;
	public static final String STEP_CONFIGURATION_PROPERTY    = "stepConfiguration" ;
	public static final String NETWORK_PROPERTY               = "network"           ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String CHANGE_REQUEST_LIST                      = "changeRequestList" ;

	public static final String INTERNAL_TYPE="ChangeRequestType";
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
	protected		String              	mIcon               ;
	protected		int                 	mDisplayOrder       ;
	protected		String              	mBindTypes          ;
	protected		String              	mStepConfiguration  ;
	protected		HyperledgerNetwork  	mNetwork            ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<ChangeRequest>	mChangeRequestList  ;
	
		
	public 	ChangeRequestType(){
		// lazy load for all the properties
	}
	public 	static ChangeRequestType withId(String id){
		ChangeRequestType changeRequestType = new ChangeRequestType();
		changeRequestType.setId(id);
		changeRequestType.setVersion(Integer.MAX_VALUE);
		return changeRequestType;
	}
	public 	static ChangeRequestType refById(String id){
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
		if(ICON_PROPERTY.equals(property)){
			changeIconProperty(newValueExpr);
		}
		if(DISPLAY_ORDER_PROPERTY.equals(property)){
			changeDisplayOrderProperty(newValueExpr);
		}
		if(BIND_TYPES_PROPERTY.equals(property)){
			changeBindTypesProperty(newValueExpr);
		}
		if(STEP_CONFIGURATION_PROPERTY.equals(property)){
			changeStepConfigurationProperty(newValueExpr);
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
			
			
			
	protected void changeIconProperty(String newValueExpr){
		String oldValue = getIcon();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateIcon(newValue);
		this.onChangeProperty(ICON_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeDisplayOrderProperty(String newValueExpr){
		int oldValue = getDisplayOrder();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDisplayOrder(newValue);
		this.onChangeProperty(DISPLAY_ORDER_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeBindTypesProperty(String newValueExpr){
		String oldValue = getBindTypes();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateBindTypes(newValue);
		this.onChangeProperty(BIND_TYPES_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeStepConfigurationProperty(String newValueExpr){
		String oldValue = getStepConfiguration();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateStepConfiguration(newValue);
		this.onChangeProperty(STEP_CONFIGURATION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(CODE_PROPERTY.equals(property)){
			return getCode();
		}
		if(ICON_PROPERTY.equals(property)){
			return getIcon();
		}
		if(DISPLAY_ORDER_PROPERTY.equals(property)){
			return getDisplayOrder();
		}
		if(BIND_TYPES_PROPERTY.equals(property)){
			return getBindTypes();
		}
		if(STEP_CONFIGURATION_PROPERTY.equals(property)){
			return getStepConfiguration();
		}
		if(NETWORK_PROPERTY.equals(property)){
			return getNetwork();
		}
		if(CHANGE_REQUEST_LIST.equals(property)){
			List<BaseEntity> list = getChangeRequestList().stream().map(item->item).collect(Collectors.toList());
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
	public ChangeRequestType updateId(String id){
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
	public ChangeRequestType updateName(String name){
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
	public ChangeRequestType updateCode(String code){
		this.mCode = trimString(code);;
		this.changed = true;
		return this;
	}
	public void mergeCode(String code){
		if(code != null) { setCode(code);}
	}
	
	
	public void setIcon(String icon){
		this.mIcon = trimString(icon);;
	}
	public String getIcon(){
		return this.mIcon;
	}
	public ChangeRequestType updateIcon(String icon){
		this.mIcon = trimString(icon);;
		this.changed = true;
		return this;
	}
	public void mergeIcon(String icon){
		if(icon != null) { setIcon(icon);}
	}
	
	
	public void setDisplayOrder(int displayOrder){
		this.mDisplayOrder = displayOrder;;
	}
	public int getDisplayOrder(){
		return this.mDisplayOrder;
	}
	public ChangeRequestType updateDisplayOrder(int displayOrder){
		this.mDisplayOrder = displayOrder;;
		this.changed = true;
		return this;
	}
	public void mergeDisplayOrder(int displayOrder){
		setDisplayOrder(displayOrder);
	}
	
	
	public void setBindTypes(String bindTypes){
		this.mBindTypes = bindTypes;;
	}
	public String getBindTypes(){
		return this.mBindTypes;
	}
	public ChangeRequestType updateBindTypes(String bindTypes){
		this.mBindTypes = bindTypes;;
		this.changed = true;
		return this;
	}
	public void mergeBindTypes(String bindTypes){
		if(bindTypes != null) { setBindTypes(bindTypes);}
	}
	
	
	public void setStepConfiguration(String stepConfiguration){
		this.mStepConfiguration = stepConfiguration;;
	}
	public String getStepConfiguration(){
		return this.mStepConfiguration;
	}
	public ChangeRequestType updateStepConfiguration(String stepConfiguration){
		this.mStepConfiguration = stepConfiguration;;
		this.changed = true;
		return this;
	}
	public void mergeStepConfiguration(String stepConfiguration){
		if(stepConfiguration != null) { setStepConfiguration(stepConfiguration);}
	}
	
	
	public void setNetwork(HyperledgerNetwork network){
		this.mNetwork = network;;
	}
	public HyperledgerNetwork getNetwork(){
		return this.mNetwork;
	}
	public ChangeRequestType updateNetwork(HyperledgerNetwork network){
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
	public ChangeRequestType updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<ChangeRequest> getChangeRequestList(){
		if(this.mChangeRequestList == null){
			this.mChangeRequestList = new SmartList<ChangeRequest>();
			this.mChangeRequestList.setListInternalName (CHANGE_REQUEST_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mChangeRequestList;	
	}
	public  void setChangeRequestList(SmartList<ChangeRequest> changeRequestList){
		for( ChangeRequest changeRequest:changeRequestList){
			changeRequest.setRequestType(this);
		}

		this.mChangeRequestList = changeRequestList;
		this.mChangeRequestList.setListInternalName (CHANGE_REQUEST_LIST );
		
	}
	
	public  void addChangeRequest(ChangeRequest changeRequest){
		changeRequest.setRequestType(this);
		getChangeRequestList().add(changeRequest);
	}
	public  void addChangeRequestList(SmartList<ChangeRequest> changeRequestList){
		for( ChangeRequest changeRequest:changeRequestList){
			changeRequest.setRequestType(this);
		}
		getChangeRequestList().addAll(changeRequestList);
	}
	public  void mergeChangeRequestList(SmartList<ChangeRequest> changeRequestList){
		if(changeRequestList==null){
			return;
		}
		if(changeRequestList.isEmpty()){
			return;
		}
		addChangeRequestList( changeRequestList );
		
	}
	public  ChangeRequest removeChangeRequest(ChangeRequest changeRequestIndex){
		
		int index = getChangeRequestList().indexOf(changeRequestIndex);
        if(index < 0){
        	String message = "ChangeRequest("+changeRequestIndex.getId()+") with version='"+changeRequestIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ChangeRequest changeRequest = getChangeRequestList().get(index);        
        // changeRequest.clearRequestType(); //disconnect with RequestType
        changeRequest.clearFromAll(); //disconnect with RequestType
		
		boolean result = getChangeRequestList().planToRemove(changeRequest);
        if(!result){
        	String message = "ChangeRequest("+changeRequestIndex.getId()+") with version='"+changeRequestIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return changeRequest;
        
	
	}
	//断舍离
	public  void breakWithChangeRequest(ChangeRequest changeRequest){
		
		if(changeRequest == null){
			return;
		}
		changeRequest.setRequestType(null);
		//getChangeRequestList().remove();
	
	}
	
	public  boolean hasChangeRequest(ChangeRequest changeRequest){
	
		return getChangeRequestList().contains(changeRequest);
  
	}
	
	public void copyChangeRequestFrom(ChangeRequest changeRequest) {

		ChangeRequest changeRequestInList = findTheChangeRequest(changeRequest);
		ChangeRequest newChangeRequest = new ChangeRequest();
		changeRequestInList.copyTo(newChangeRequest);
		newChangeRequest.setVersion(0);//will trigger copy
		getChangeRequestList().add(newChangeRequest);
		addItemToFlexiableObject(COPIED_CHILD, newChangeRequest);
	}
	
	public  ChangeRequest findTheChangeRequest(ChangeRequest changeRequest){
		
		int index =  getChangeRequestList().indexOf(changeRequest);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ChangeRequest("+changeRequest.getId()+") with version='"+changeRequest.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getChangeRequestList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpChangeRequestList(){
		getChangeRequestList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getNetwork(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getChangeRequestList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getChangeRequestList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, CODE_PROPERTY, getCode());
		appendKeyValuePair(result, ICON_PROPERTY, getIcon());
		appendKeyValuePair(result, DISPLAY_ORDER_PROPERTY, getDisplayOrder());
		appendKeyValuePair(result, BIND_TYPES_PROPERTY, getBindTypes());
		appendKeyValuePair(result, STEP_CONFIGURATION_PROPERTY, getStepConfiguration());
		appendKeyValuePair(result, NETWORK_PROPERTY, getNetwork());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, CHANGE_REQUEST_LIST, getChangeRequestList());
		if(!getChangeRequestList().isEmpty()){
			appendKeyValuePair(result, "changeRequestCount", getChangeRequestList().getTotalCount());
			appendKeyValuePair(result, "changeRequestCurrentPageNumber", getChangeRequestList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ChangeRequestType){
		
		
			ChangeRequestType dest =(ChangeRequestType)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setCode(getCode());
			dest.setIcon(getIcon());
			dest.setDisplayOrder(getDisplayOrder());
			dest.setBindTypes(getBindTypes());
			dest.setStepConfiguration(getStepConfiguration());
			dest.setNetwork(getNetwork());
			dest.setVersion(getVersion());
			dest.setChangeRequestList(getChangeRequestList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ChangeRequestType){
		
			
			ChangeRequestType dest =(ChangeRequestType)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCode(getCode());
			dest.mergeIcon(getIcon());
			dest.mergeDisplayOrder(getDisplayOrder());
			dest.mergeBindTypes(getBindTypes());
			dest.mergeStepConfiguration(getStepConfiguration());
			dest.mergeNetwork(getNetwork());
			dest.mergeVersion(getVersion());
			dest.mergeChangeRequestList(getChangeRequestList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ChangeRequestType){
		
			
			ChangeRequestType dest =(ChangeRequestType)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCode(getCode());
			dest.mergeIcon(getIcon());
			dest.mergeDisplayOrder(getDisplayOrder());
			dest.mergeBindTypes(getBindTypes());
			dest.mergeStepConfiguration(getStepConfiguration());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("ChangeRequestType{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tcode='"+getCode()+"';");
		stringBuilder.append("\ticon='"+getIcon()+"';");
		stringBuilder.append("\tdisplayOrder='"+getDisplayOrder()+"';");
		stringBuilder.append("\tbindTypes='"+getBindTypes()+"';");
		stringBuilder.append("\tstepConfiguration='"+getStepConfiguration()+"';");
		if(getNetwork() != null ){
 			stringBuilder.append("\tnetwork='HyperledgerNetwork("+getNetwork().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	
	public void increaseDisplayOrder(int incDisplayOrder){
		updateDisplayOrder(this.mDisplayOrder +  incDisplayOrder);
	}
	public void decreaseDisplayOrder(int decDisplayOrder){
		updateDisplayOrder(this.mDisplayOrder - decDisplayOrder);
	}
	

}

