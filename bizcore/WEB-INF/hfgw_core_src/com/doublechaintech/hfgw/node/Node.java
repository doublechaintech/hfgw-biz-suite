
package com.doublechaintech.hfgw.node;

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
import com.doublechaintech.hfgw.organization.Organization;
import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.nodetype.NodeType;
import com.doublechaintech.hfgw.grpcoption.GrpcOption;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

@JsonSerialize(using = NodeSerializer.class)
public class Node extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String URL_PROPERTY                   = "url"               ;
	public static final String ORGANIZATION_PROPERTY          = "organization"      ;
	public static final String CHANNEL_PROPERTY               = "channel"           ;
	public static final String NETWORK_PROPERTY               = "network"           ;
	public static final String TLS_CACERT_PROPERTY            = "tlsCacert"         ;
	public static final String TYPE_PROPERTY                  = "type"              ;
	public static final String ADDRESS_PROPERTY               = "address"           ;
	public static final String CONTACT_PERSON_PROPERTY        = "contactPerson"     ;
	public static final String CONTACT_TELEPHONE_PROPERTY     = "contactTelephone"  ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String GRPC_OPTION_LIST                         = "grpcOptionList"    ;
	public static final String CHANNEL_PEER_ROLE_LIST                   = "channelPeerRoleList";

	public static final String INTERNAL_TYPE="Node";
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
	protected		String              	mUrl                ;
	protected		Organization        	mOrganization       ;
	protected		Channel             	mChannel            ;
	protected		HyperledgerNetwork  	mNetwork            ;
	protected		String              	mTlsCacert          ;
	protected		NodeType            	mType               ;
	protected		String              	mAddress            ;
	protected		String              	mContactPerson      ;
	protected		String              	mContactTelephone   ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<GrpcOption>	mGrpcOptionList     ;
	protected		SmartList<ChannelPeerRole>	mChannelPeerRoleList;
	
		
	public 	Node(){
		// lazy load for all the properties
	}
	public 	static Node withId(String id){
		Node node = new Node();
		node.setId(id);
		node.setVersion(Integer.MAX_VALUE);
		return node;
	}
	public 	static Node refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setOrganization( null );
		setChannel( null );
		setNetwork( null );
		setType( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(URL_PROPERTY.equals(property)){
			changeUrlProperty(newValueExpr);
		}
		if(TLS_CACERT_PROPERTY.equals(property)){
			changeTlsCacertProperty(newValueExpr);
		}
		if(ADDRESS_PROPERTY.equals(property)){
			changeAddressProperty(newValueExpr);
		}
		if(CONTACT_PERSON_PROPERTY.equals(property)){
			changeContactPersonProperty(newValueExpr);
		}
		if(CONTACT_TELEPHONE_PROPERTY.equals(property)){
			changeContactTelephoneProperty(newValueExpr);
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
			
			
			
	protected void changeUrlProperty(String newValueExpr){
		String oldValue = getUrl();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateUrl(newValue);
		this.onChangeProperty(URL_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeTlsCacertProperty(String newValueExpr){
		String oldValue = getTlsCacert();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateTlsCacert(newValue);
		this.onChangeProperty(TLS_CACERT_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeAddressProperty(String newValueExpr){
		String oldValue = getAddress();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAddress(newValue);
		this.onChangeProperty(ADDRESS_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeContactPersonProperty(String newValueExpr){
		String oldValue = getContactPerson();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateContactPerson(newValue);
		this.onChangeProperty(CONTACT_PERSON_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeContactTelephoneProperty(String newValueExpr){
		String oldValue = getContactTelephone();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateContactTelephone(newValue);
		this.onChangeProperty(CONTACT_TELEPHONE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(URL_PROPERTY.equals(property)){
			return getUrl();
		}
		if(ORGANIZATION_PROPERTY.equals(property)){
			return getOrganization();
		}
		if(CHANNEL_PROPERTY.equals(property)){
			return getChannel();
		}
		if(NETWORK_PROPERTY.equals(property)){
			return getNetwork();
		}
		if(TLS_CACERT_PROPERTY.equals(property)){
			return getTlsCacert();
		}
		if(TYPE_PROPERTY.equals(property)){
			return getType();
		}
		if(ADDRESS_PROPERTY.equals(property)){
			return getAddress();
		}
		if(CONTACT_PERSON_PROPERTY.equals(property)){
			return getContactPerson();
		}
		if(CONTACT_TELEPHONE_PROPERTY.equals(property)){
			return getContactTelephone();
		}
		if(GRPC_OPTION_LIST.equals(property)){
			List<BaseEntity> list = getGrpcOptionList().stream().map(item->item).collect(Collectors.toList());
			return list;
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
	public Node updateId(String id){
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
	public Node updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setUrl(String url){
		this.mUrl = trimString(url);;
	}
	public String getUrl(){
		return this.mUrl;
	}
	public Node updateUrl(String url){
		this.mUrl = trimString(url);;
		this.changed = true;
		return this;
	}
	public void mergeUrl(String url){
		if(url != null) { setUrl(url);}
	}
	
	
	public void setOrganization(Organization organization){
		this.mOrganization = organization;;
	}
	public Organization getOrganization(){
		return this.mOrganization;
	}
	public Node updateOrganization(Organization organization){
		this.mOrganization = organization;;
		this.changed = true;
		return this;
	}
	public void mergeOrganization(Organization organization){
		if(organization != null) { setOrganization(organization);}
	}
	
	
	public void clearOrganization(){
		setOrganization ( null );
		this.changed = true;
	}
	
	public void setChannel(Channel channel){
		this.mChannel = channel;;
	}
	public Channel getChannel(){
		return this.mChannel;
	}
	public Node updateChannel(Channel channel){
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
	public Node updateNetwork(HyperledgerNetwork network){
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
	
	public void setTlsCacert(String tlsCacert){
		this.mTlsCacert = tlsCacert;;
	}
	public String getTlsCacert(){
		return this.mTlsCacert;
	}
	public Node updateTlsCacert(String tlsCacert){
		this.mTlsCacert = tlsCacert;;
		this.changed = true;
		return this;
	}
	public void mergeTlsCacert(String tlsCacert){
		if(tlsCacert != null) { setTlsCacert(tlsCacert);}
	}
	
	
	public void setType(NodeType type){
		this.mType = type;;
	}
	public NodeType getType(){
		return this.mType;
	}
	public Node updateType(NodeType type){
		this.mType = type;;
		this.changed = true;
		return this;
	}
	public void mergeType(NodeType type){
		if(type != null) { setType(type);}
	}
	
	
	public void clearType(){
		setType ( null );
		this.changed = true;
	}
	
	public void setAddress(String address){
		this.mAddress = trimString(address);;
	}
	public String getAddress(){
		return this.mAddress;
	}
	public Node updateAddress(String address){
		this.mAddress = trimString(address);;
		this.changed = true;
		return this;
	}
	public void mergeAddress(String address){
		if(address != null) { setAddress(address);}
	}
	
	
	public void setContactPerson(String contactPerson){
		this.mContactPerson = trimString(contactPerson);;
	}
	public String getContactPerson(){
		return this.mContactPerson;
	}
	public Node updateContactPerson(String contactPerson){
		this.mContactPerson = trimString(contactPerson);;
		this.changed = true;
		return this;
	}
	public void mergeContactPerson(String contactPerson){
		if(contactPerson != null) { setContactPerson(contactPerson);}
	}
	
	
	public void setContactTelephone(String contactTelephone){
		this.mContactTelephone = trimString(contactTelephone);;
	}
	public String getContactTelephone(){
		return this.mContactTelephone;
	}
	public Node updateContactTelephone(String contactTelephone){
		this.mContactTelephone = trimString(contactTelephone);;
		this.changed = true;
		return this;
	}
	public void mergeContactTelephone(String contactTelephone){
		if(contactTelephone != null) { setContactTelephone(contactTelephone);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Node updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<GrpcOption> getGrpcOptionList(){
		if(this.mGrpcOptionList == null){
			this.mGrpcOptionList = new SmartList<GrpcOption>();
			this.mGrpcOptionList.setListInternalName (GRPC_OPTION_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mGrpcOptionList;	
	}
	public  void setGrpcOptionList(SmartList<GrpcOption> grpcOptionList){
		for( GrpcOption grpcOption:grpcOptionList){
			grpcOption.setNode(this);
		}

		this.mGrpcOptionList = grpcOptionList;
		this.mGrpcOptionList.setListInternalName (GRPC_OPTION_LIST );
		
	}
	
	public  void addGrpcOption(GrpcOption grpcOption){
		grpcOption.setNode(this);
		getGrpcOptionList().add(grpcOption);
	}
	public  void addGrpcOptionList(SmartList<GrpcOption> grpcOptionList){
		for( GrpcOption grpcOption:grpcOptionList){
			grpcOption.setNode(this);
		}
		getGrpcOptionList().addAll(grpcOptionList);
	}
	public  void mergeGrpcOptionList(SmartList<GrpcOption> grpcOptionList){
		if(grpcOptionList==null){
			return;
		}
		if(grpcOptionList.isEmpty()){
			return;
		}
		addGrpcOptionList( grpcOptionList );
		
	}
	public  GrpcOption removeGrpcOption(GrpcOption grpcOptionIndex){
		
		int index = getGrpcOptionList().indexOf(grpcOptionIndex);
        if(index < 0){
        	String message = "GrpcOption("+grpcOptionIndex.getId()+") with version='"+grpcOptionIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        GrpcOption grpcOption = getGrpcOptionList().get(index);        
        // grpcOption.clearNode(); //disconnect with Node
        grpcOption.clearFromAll(); //disconnect with Node
		
		boolean result = getGrpcOptionList().planToRemove(grpcOption);
        if(!result){
        	String message = "GrpcOption("+grpcOptionIndex.getId()+") with version='"+grpcOptionIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return grpcOption;
        
	
	}
	//断舍离
	public  void breakWithGrpcOption(GrpcOption grpcOption){
		
		if(grpcOption == null){
			return;
		}
		grpcOption.setNode(null);
		//getGrpcOptionList().remove();
	
	}
	
	public  boolean hasGrpcOption(GrpcOption grpcOption){
	
		return getGrpcOptionList().contains(grpcOption);
  
	}
	
	public void copyGrpcOptionFrom(GrpcOption grpcOption) {

		GrpcOption grpcOptionInList = findTheGrpcOption(grpcOption);
		GrpcOption newGrpcOption = new GrpcOption();
		grpcOptionInList.copyTo(newGrpcOption);
		newGrpcOption.setVersion(0);//will trigger copy
		getGrpcOptionList().add(newGrpcOption);
		addItemToFlexiableObject(COPIED_CHILD, newGrpcOption);
	}
	
	public  GrpcOption findTheGrpcOption(GrpcOption grpcOption){
		
		int index =  getGrpcOptionList().indexOf(grpcOption);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "GrpcOption("+grpcOption.getId()+") with version='"+grpcOption.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getGrpcOptionList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpGrpcOptionList(){
		getGrpcOptionList().clear();
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
			channelPeerRole.setNode(this);
		}

		this.mChannelPeerRoleList = channelPeerRoleList;
		this.mChannelPeerRoleList.setListInternalName (CHANNEL_PEER_ROLE_LIST );
		
	}
	
	public  void addChannelPeerRole(ChannelPeerRole channelPeerRole){
		channelPeerRole.setNode(this);
		getChannelPeerRoleList().add(channelPeerRole);
	}
	public  void addChannelPeerRoleList(SmartList<ChannelPeerRole> channelPeerRoleList){
		for( ChannelPeerRole channelPeerRole:channelPeerRoleList){
			channelPeerRole.setNode(this);
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
        // channelPeerRole.clearNode(); //disconnect with Node
        channelPeerRole.clearFromAll(); //disconnect with Node
		
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
		channelPeerRole.setNode(null);
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

		addToEntityList(this, entityList, getOrganization(), internalType);
		addToEntityList(this, entityList, getChannel(), internalType);
		addToEntityList(this, entityList, getNetwork(), internalType);
		addToEntityList(this, entityList, getType(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getGrpcOptionList(), internalType);
		collectFromList(this, entityList, getChannelPeerRoleList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getGrpcOptionList());
		listOfList.add( getChannelPeerRoleList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, URL_PROPERTY, getUrl());
		appendKeyValuePair(result, ORGANIZATION_PROPERTY, getOrganization());
		appendKeyValuePair(result, CHANNEL_PROPERTY, getChannel());
		appendKeyValuePair(result, NETWORK_PROPERTY, getNetwork());
		appendKeyValuePair(result, TLS_CACERT_PROPERTY, getTlsCacert());
		appendKeyValuePair(result, TYPE_PROPERTY, getType());
		appendKeyValuePair(result, ADDRESS_PROPERTY, getAddress());
		appendKeyValuePair(result, CONTACT_PERSON_PROPERTY, getContactPerson());
		appendKeyValuePair(result, CONTACT_TELEPHONE_PROPERTY, getContactTelephone());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, GRPC_OPTION_LIST, getGrpcOptionList());
		if(!getGrpcOptionList().isEmpty()){
			appendKeyValuePair(result, "grpcOptionCount", getGrpcOptionList().getTotalCount());
			appendKeyValuePair(result, "grpcOptionCurrentPageNumber", getGrpcOptionList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, CHANNEL_PEER_ROLE_LIST, getChannelPeerRoleList());
		if(!getChannelPeerRoleList().isEmpty()){
			appendKeyValuePair(result, "channelPeerRoleCount", getChannelPeerRoleList().getTotalCount());
			appendKeyValuePair(result, "channelPeerRoleCurrentPageNumber", getChannelPeerRoleList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Node){
		
		
			Node dest =(Node)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setUrl(getUrl());
			dest.setOrganization(getOrganization());
			dest.setChannel(getChannel());
			dest.setNetwork(getNetwork());
			dest.setTlsCacert(getTlsCacert());
			dest.setType(getType());
			dest.setAddress(getAddress());
			dest.setContactPerson(getContactPerson());
			dest.setContactTelephone(getContactTelephone());
			dest.setVersion(getVersion());
			dest.setGrpcOptionList(getGrpcOptionList());
			dest.setChannelPeerRoleList(getChannelPeerRoleList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Node){
		
			
			Node dest =(Node)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeUrl(getUrl());
			dest.mergeOrganization(getOrganization());
			dest.mergeChannel(getChannel());
			dest.mergeNetwork(getNetwork());
			dest.mergeTlsCacert(getTlsCacert());
			dest.mergeType(getType());
			dest.mergeAddress(getAddress());
			dest.mergeContactPerson(getContactPerson());
			dest.mergeContactTelephone(getContactTelephone());
			dest.mergeVersion(getVersion());
			dest.mergeGrpcOptionList(getGrpcOptionList());
			dest.mergeChannelPeerRoleList(getChannelPeerRoleList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Node){
		
			
			Node dest =(Node)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeUrl(getUrl());
			dest.mergeTlsCacert(getTlsCacert());
			dest.mergeAddress(getAddress());
			dest.mergeContactPerson(getContactPerson());
			dest.mergeContactTelephone(getContactTelephone());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Node{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\turl='"+getUrl()+"';");
		if(getOrganization() != null ){
 			stringBuilder.append("\torganization='Organization("+getOrganization().getId()+")';");
 		}
		if(getChannel() != null ){
 			stringBuilder.append("\tchannel='Channel("+getChannel().getId()+")';");
 		}
		if(getNetwork() != null ){
 			stringBuilder.append("\tnetwork='HyperledgerNetwork("+getNetwork().getId()+")';");
 		}
		stringBuilder.append("\ttlsCacert='"+getTlsCacert()+"';");
		if(getType() != null ){
 			stringBuilder.append("\ttype='NodeType("+getType().getId()+")';");
 		}
		stringBuilder.append("\taddress='"+getAddress()+"';");
		stringBuilder.append("\tcontactPerson='"+getContactPerson()+"';");
		stringBuilder.append("\tcontactTelephone='"+getContactTelephone()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

