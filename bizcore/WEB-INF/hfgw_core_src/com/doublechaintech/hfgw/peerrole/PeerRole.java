
package com.doublechaintech.hfgw.peerrole;

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
import com.doublechaintech.hfgw.channelpeerrole.ChannelPeerRole;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

@JsonSerialize(using = PeerRoleSerializer.class)
public class PeerRole extends BaseEntity implements  java.io.Serializable{

	public static final String ENDORSING_PEER = "endorsingPeer";	// endorsingPeer
	public static final String CHAINCODE_QUERY = "chaincodeQuery";	// chaincodeQuery
	public static final String LEDGER_QUERY = "ledgerQuery";	// ledgerQuery
	public static final String EVENT_SOURCE = "eventSource";	// eventSource
	public static final String DISCOVER = "discover";	// discover
	public static List<KeyValuePair> CODE_NAME_LIST;
	static {
		CODE_NAME_LIST = new ArrayList<>();

		CODE_NAME_LIST.add(new KeyValuePair(ENDORSING_PEER, "endorsingPeer"));
		CODE_NAME_LIST.add(new KeyValuePair(CHAINCODE_QUERY, "chaincodeQuery"));
		CODE_NAME_LIST.add(new KeyValuePair(LEDGER_QUERY, "ledgerQuery"));
		CODE_NAME_LIST.add(new KeyValuePair(EVENT_SOURCE, "eventSource"));
		CODE_NAME_LIST.add(new KeyValuePair(DISCOVER, "discover"));
	}
	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String CODE_PROPERTY                  = "code"              ;
	public static final String NETWORK_PROPERTY               = "network"           ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String CHANNEL_PEER_ROLE_LIST                   = "channelPeerRoleList";

	public static final String INTERNAL_TYPE="PeerRole";
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
	
	
	protected		SmartList<ChannelPeerRole>	mChannelPeerRoleList;
	
		
	public 	PeerRole(){
		// lazy load for all the properties
	}
	public 	static PeerRole withId(String id){
		PeerRole peerRole = new PeerRole();
		peerRole.setId(id);
		peerRole.setVersion(Integer.MAX_VALUE);
		return peerRole;
	}
	public 	static PeerRole refById(String id){
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
		if(CHANNEL_PEER_ROLE_LIST.equals(property)){
			List<BaseEntity> list = getChannelPeerRoleList().stream().map(item->item).collect(Collectors.toList());
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
	public PeerRole updateId(String id){
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
	public PeerRole updateName(String name){
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
	public PeerRole updateCode(String code){
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
	public PeerRole updateNetwork(HyperledgerNetwork network){
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
	public PeerRole updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<ChannelPeerRole> getChannelPeerRoleList(){
		if(this.mChannelPeerRoleList == null){
			this.mChannelPeerRoleList = new SmartList<ChannelPeerRole>();
			this.mChannelPeerRoleList.setListInternalName (CHANNEL_PEER_ROLE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mChannelPeerRoleList;	
	}
	public  void setChannelPeerRoleList(SmartList<ChannelPeerRole> channelPeerRoleList){
		for( ChannelPeerRole channelPeerRole:channelPeerRoleList){
			channelPeerRole.setPeerRole(this);
		}

		this.mChannelPeerRoleList = channelPeerRoleList;
		this.mChannelPeerRoleList.setListInternalName (CHANNEL_PEER_ROLE_LIST );
		
	}
	
	public  void addChannelPeerRole(ChannelPeerRole channelPeerRole){
		channelPeerRole.setPeerRole(this);
		getChannelPeerRoleList().add(channelPeerRole);
	}
	public  void addChannelPeerRoleList(SmartList<ChannelPeerRole> channelPeerRoleList){
		for( ChannelPeerRole channelPeerRole:channelPeerRoleList){
			channelPeerRole.setPeerRole(this);
		}
		getChannelPeerRoleList().addAll(channelPeerRoleList);
	}
	public  void mergeChannelPeerRoleList(SmartList<ChannelPeerRole> channelPeerRoleList){
		if(channelPeerRoleList==null){
			return;
		}
		if(channelPeerRoleList.isEmpty()){
			return;
		}
		addChannelPeerRoleList( channelPeerRoleList );
		
	}
	public  ChannelPeerRole removeChannelPeerRole(ChannelPeerRole channelPeerRoleIndex){
		
		int index = getChannelPeerRoleList().indexOf(channelPeerRoleIndex);
        if(index < 0){
        	String message = "ChannelPeerRole("+channelPeerRoleIndex.getId()+") with version='"+channelPeerRoleIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ChannelPeerRole channelPeerRole = getChannelPeerRoleList().get(index);        
        // channelPeerRole.clearPeerRole(); //disconnect with PeerRole
        channelPeerRole.clearFromAll(); //disconnect with PeerRole
		
		boolean result = getChannelPeerRoleList().planToRemove(channelPeerRole);
        if(!result){
        	String message = "ChannelPeerRole("+channelPeerRoleIndex.getId()+") with version='"+channelPeerRoleIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return channelPeerRole;
        
	
	}
	//断舍离
	public  void breakWithChannelPeerRole(ChannelPeerRole channelPeerRole){
		
		if(channelPeerRole == null){
			return;
		}
		channelPeerRole.setPeerRole(null);
		//getChannelPeerRoleList().remove();
	
	}
	
	public  boolean hasChannelPeerRole(ChannelPeerRole channelPeerRole){
	
		return getChannelPeerRoleList().contains(channelPeerRole);
  
	}
	
	public void copyChannelPeerRoleFrom(ChannelPeerRole channelPeerRole) {

		ChannelPeerRole channelPeerRoleInList = findTheChannelPeerRole(channelPeerRole);
		ChannelPeerRole newChannelPeerRole = new ChannelPeerRole();
		channelPeerRoleInList.copyTo(newChannelPeerRole);
		newChannelPeerRole.setVersion(0);//will trigger copy
		getChannelPeerRoleList().add(newChannelPeerRole);
		addItemToFlexiableObject(COPIED_CHILD, newChannelPeerRole);
	}
	
	public  ChannelPeerRole findTheChannelPeerRole(ChannelPeerRole channelPeerRole){
		
		int index =  getChannelPeerRoleList().indexOf(channelPeerRole);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ChannelPeerRole("+channelPeerRole.getId()+") with version='"+channelPeerRole.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getChannelPeerRoleList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpChannelPeerRoleList(){
		getChannelPeerRoleList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getNetwork(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getChannelPeerRoleList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getChannelPeerRoleList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, CODE_PROPERTY, getCode());
		appendKeyValuePair(result, NETWORK_PROPERTY, getNetwork());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, CHANNEL_PEER_ROLE_LIST, getChannelPeerRoleList());
		if(!getChannelPeerRoleList().isEmpty()){
			appendKeyValuePair(result, "channelPeerRoleCount", getChannelPeerRoleList().getTotalCount());
			appendKeyValuePair(result, "channelPeerRoleCurrentPageNumber", getChannelPeerRoleList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof PeerRole){
		
		
			PeerRole dest =(PeerRole)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setCode(getCode());
			dest.setNetwork(getNetwork());
			dest.setVersion(getVersion());
			dest.setChannelPeerRoleList(getChannelPeerRoleList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof PeerRole){
		
			
			PeerRole dest =(PeerRole)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCode(getCode());
			dest.mergeNetwork(getNetwork());
			dest.mergeVersion(getVersion());
			dest.mergeChannelPeerRoleList(getChannelPeerRoleList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof PeerRole){
		
			
			PeerRole dest =(PeerRole)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCode(getCode());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("PeerRole{");
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

