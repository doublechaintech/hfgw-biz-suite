
package com.doublechaintech.hfgw.changerequest;

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
import com.doublechaintech.hfgw.changerequesttype.ChangeRequestType;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;
import com.doublechaintech.hfgw.chaincodeinvoker.ChainCodeInvoker;

@JsonSerialize(using = ChangeRequestSerializer.class)
public class ChangeRequest extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String CREATE_TIME_PROPERTY           = "createTime"        ;
	public static final String REMOTE_IP_PROPERTY             = "remoteIp"          ;
	public static final String REQUEST_TYPE_PROPERTY          = "requestType"       ;
	public static final String NETWORK_PROPERTY               = "network"           ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String CHAIN_CODE_INVOKER_LIST                  = "chainCodeInvokerList";

	public static final String INTERNAL_TYPE="ChangeRequest";
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
	protected		String              	mRemoteIp           ;
	protected		ChangeRequestType   	mRequestType        ;
	protected		HyperledgerNetwork  	mNetwork            ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<ChainCodeInvoker>	mChainCodeInvokerList;
	
		
	public 	ChangeRequest(){
		// lazy load for all the properties
	}
	public 	static ChangeRequest withId(String id){
		ChangeRequest changeRequest = new ChangeRequest();
		changeRequest.setId(id);
		changeRequest.setVersion(Integer.MAX_VALUE);
		return changeRequest;
	}
	public 	static ChangeRequest refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setRequestType( null );
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
		if(REMOTE_IP_PROPERTY.equals(property)){
			changeRemoteIpProperty(newValueExpr);
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
			
			
			
	protected void changeRemoteIpProperty(String newValueExpr){
		String oldValue = getRemoteIp();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateRemoteIp(newValue);
		this.onChangeProperty(REMOTE_IP_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(CREATE_TIME_PROPERTY.equals(property)){
			return getCreateTime();
		}
		if(REMOTE_IP_PROPERTY.equals(property)){
			return getRemoteIp();
		}
		if(REQUEST_TYPE_PROPERTY.equals(property)){
			return getRequestType();
		}
		if(NETWORK_PROPERTY.equals(property)){
			return getNetwork();
		}
		if(CHAIN_CODE_INVOKER_LIST.equals(property)){
			List<BaseEntity> list = getChainCodeInvokerList().stream().map(item->item).collect(Collectors.toList());
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
	public ChangeRequest updateId(String id){
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
	public ChangeRequest updateName(String name){
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
	public ChangeRequest updateCreateTime(DateTime createTime){
		this.mCreateTime = createTime;;
		this.changed = true;
		return this;
	}
	public void mergeCreateTime(DateTime createTime){
		setCreateTime(createTime);
	}
	
	
	public void setRemoteIp(String remoteIp){
		this.mRemoteIp = trimString(remoteIp);;
	}
	public String getRemoteIp(){
		return this.mRemoteIp;
	}
	public ChangeRequest updateRemoteIp(String remoteIp){
		this.mRemoteIp = trimString(remoteIp);;
		this.changed = true;
		return this;
	}
	public void mergeRemoteIp(String remoteIp){
		if(remoteIp != null) { setRemoteIp(remoteIp);}
	}
	
	
	public void setRequestType(ChangeRequestType requestType){
		this.mRequestType = requestType;;
	}
	public ChangeRequestType getRequestType(){
		return this.mRequestType;
	}
	public ChangeRequest updateRequestType(ChangeRequestType requestType){
		this.mRequestType = requestType;;
		this.changed = true;
		return this;
	}
	public void mergeRequestType(ChangeRequestType requestType){
		if(requestType != null) { setRequestType(requestType);}
	}
	
	
	public void clearRequestType(){
		setRequestType ( null );
		this.changed = true;
	}
	
	public void setNetwork(HyperledgerNetwork network){
		this.mNetwork = network;;
	}
	public HyperledgerNetwork getNetwork(){
		return this.mNetwork;
	}
	public ChangeRequest updateNetwork(HyperledgerNetwork network){
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
	public ChangeRequest updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<ChainCodeInvoker> getChainCodeInvokerList(){
		if(this.mChainCodeInvokerList == null){
			this.mChainCodeInvokerList = new SmartList<ChainCodeInvoker>();
			this.mChainCodeInvokerList.setListInternalName (CHAIN_CODE_INVOKER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mChainCodeInvokerList;	
	}
	public  void setChainCodeInvokerList(SmartList<ChainCodeInvoker> chainCodeInvokerList){
		for( ChainCodeInvoker chainCodeInvoker:chainCodeInvokerList){
			chainCodeInvoker.setChangeRequest(this);
		}

		this.mChainCodeInvokerList = chainCodeInvokerList;
		this.mChainCodeInvokerList.setListInternalName (CHAIN_CODE_INVOKER_LIST );
		
	}
	
	public  void addChainCodeInvoker(ChainCodeInvoker chainCodeInvoker){
		chainCodeInvoker.setChangeRequest(this);
		getChainCodeInvokerList().add(chainCodeInvoker);
	}
	public  void addChainCodeInvokerList(SmartList<ChainCodeInvoker> chainCodeInvokerList){
		for( ChainCodeInvoker chainCodeInvoker:chainCodeInvokerList){
			chainCodeInvoker.setChangeRequest(this);
		}
		getChainCodeInvokerList().addAll(chainCodeInvokerList);
	}
	public  void mergeChainCodeInvokerList(SmartList<ChainCodeInvoker> chainCodeInvokerList){
		if(chainCodeInvokerList==null){
			return;
		}
		if(chainCodeInvokerList.isEmpty()){
			return;
		}
		addChainCodeInvokerList( chainCodeInvokerList );
		
	}
	public  ChainCodeInvoker removeChainCodeInvoker(ChainCodeInvoker chainCodeInvokerIndex){
		
		int index = getChainCodeInvokerList().indexOf(chainCodeInvokerIndex);
        if(index < 0){
        	String message = "ChainCodeInvoker("+chainCodeInvokerIndex.getId()+") with version='"+chainCodeInvokerIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ChainCodeInvoker chainCodeInvoker = getChainCodeInvokerList().get(index);        
        // chainCodeInvoker.clearChangeRequest(); //disconnect with ChangeRequest
        chainCodeInvoker.clearFromAll(); //disconnect with ChangeRequest
		
		boolean result = getChainCodeInvokerList().planToRemove(chainCodeInvoker);
        if(!result){
        	String message = "ChainCodeInvoker("+chainCodeInvokerIndex.getId()+") with version='"+chainCodeInvokerIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return chainCodeInvoker;
        
	
	}
	//断舍离
	public  void breakWithChainCodeInvoker(ChainCodeInvoker chainCodeInvoker){
		
		if(chainCodeInvoker == null){
			return;
		}
		chainCodeInvoker.setChangeRequest(null);
		//getChainCodeInvokerList().remove();
	
	}
	
	public  boolean hasChainCodeInvoker(ChainCodeInvoker chainCodeInvoker){
	
		return getChainCodeInvokerList().contains(chainCodeInvoker);
  
	}
	
	public void copyChainCodeInvokerFrom(ChainCodeInvoker chainCodeInvoker) {

		ChainCodeInvoker chainCodeInvokerInList = findTheChainCodeInvoker(chainCodeInvoker);
		ChainCodeInvoker newChainCodeInvoker = new ChainCodeInvoker();
		chainCodeInvokerInList.copyTo(newChainCodeInvoker);
		newChainCodeInvoker.setVersion(0);//will trigger copy
		getChainCodeInvokerList().add(newChainCodeInvoker);
		addItemToFlexiableObject(COPIED_CHILD, newChainCodeInvoker);
	}
	
	public  ChainCodeInvoker findTheChainCodeInvoker(ChainCodeInvoker chainCodeInvoker){
		
		int index =  getChainCodeInvokerList().indexOf(chainCodeInvoker);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ChainCodeInvoker("+chainCodeInvoker.getId()+") with version='"+chainCodeInvoker.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getChainCodeInvokerList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpChainCodeInvokerList(){
		getChainCodeInvokerList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getRequestType(), internalType);
		addToEntityList(this, entityList, getNetwork(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getChainCodeInvokerList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getChainCodeInvokerList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, CREATE_TIME_PROPERTY, getCreateTime());
		appendKeyValuePair(result, REMOTE_IP_PROPERTY, getRemoteIp());
		appendKeyValuePair(result, REQUEST_TYPE_PROPERTY, getRequestType());
		appendKeyValuePair(result, NETWORK_PROPERTY, getNetwork());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, CHAIN_CODE_INVOKER_LIST, getChainCodeInvokerList());
		if(!getChainCodeInvokerList().isEmpty()){
			appendKeyValuePair(result, "chainCodeInvokerCount", getChainCodeInvokerList().getTotalCount());
			appendKeyValuePair(result, "chainCodeInvokerCurrentPageNumber", getChainCodeInvokerList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ChangeRequest){
		
		
			ChangeRequest dest =(ChangeRequest)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setCreateTime(getCreateTime());
			dest.setRemoteIp(getRemoteIp());
			dest.setRequestType(getRequestType());
			dest.setNetwork(getNetwork());
			dest.setVersion(getVersion());
			dest.setChainCodeInvokerList(getChainCodeInvokerList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ChangeRequest){
		
			
			ChangeRequest dest =(ChangeRequest)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCreateTime(getCreateTime());
			dest.mergeRemoteIp(getRemoteIp());
			dest.mergeRequestType(getRequestType());
			dest.mergeNetwork(getNetwork());
			dest.mergeVersion(getVersion());
			dest.mergeChainCodeInvokerList(getChainCodeInvokerList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ChangeRequest){
		
			
			ChangeRequest dest =(ChangeRequest)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCreateTime(getCreateTime());
			dest.mergeRemoteIp(getRemoteIp());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("ChangeRequest{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tcreateTime='"+getCreateTime()+"';");
		stringBuilder.append("\tremoteIp='"+getRemoteIp()+"';");
		if(getRequestType() != null ){
 			stringBuilder.append("\trequestType='ChangeRequestType("+getRequestType().getId()+")';");
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

