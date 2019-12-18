
package com.doublechaintech.hfgw.channel;

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
import com.doublechaintech.hfgw.node.Node;
import com.doublechaintech.hfgw.channelpeerrole.ChannelPeerRole;
import com.doublechaintech.hfgw.application.Application;
import com.doublechaintech.hfgw.servicerecord.ServiceRecord;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

@JsonSerialize(using = ChannelSerializer.class)
public class Channel extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String NETWORK_PROPERTY               = "network"           ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String NODE_LIST                                = "nodeList"          ;
	public static final String CHANNEL_PEER_ROLE_LIST                   = "channelPeerRoleList";
	public static final String CHAIN_CODE_LIST                          = "chainCodeList"     ;
	public static final String APPLICATION_LIST                         = "applicationList"   ;
	public static final String SERVICE_RECORD_LIST                      = "serviceRecordList" ;

	public static final String INTERNAL_TYPE="Channel";
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
	protected		HyperledgerNetwork  	mNetwork            ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Node>     	mNodeList           ;
	protected		SmartList<ChannelPeerRole>	mChannelPeerRoleList;
	protected		SmartList<ChainCode>	mChainCodeList      ;
	protected		SmartList<Application>	mApplicationList    ;
	protected		SmartList<ServiceRecord>	mServiceRecordList  ;
	
		
	public 	Channel(){
		// lazy load for all the properties
	}
	public 	static Channel withId(String id){
		Channel channel = new Channel();
		channel.setId(id);
		channel.setVersion(Integer.MAX_VALUE);
		return channel;
	}
	public 	static Channel refById(String id){
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
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(NETWORK_PROPERTY.equals(property)){
			return getNetwork();
		}
		if(NODE_LIST.equals(property)){
			List<BaseEntity> list = getNodeList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(CHANNEL_PEER_ROLE_LIST.equals(property)){
			List<BaseEntity> list = getChannelPeerRoleList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(CHAIN_CODE_LIST.equals(property)){
			List<BaseEntity> list = getChainCodeList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(APPLICATION_LIST.equals(property)){
			List<BaseEntity> list = getApplicationList().stream().map(item->item).collect(Collectors.toList());
			return list;
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
	public Channel updateId(String id){
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
	public Channel updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setNetwork(HyperledgerNetwork network){
		this.mNetwork = network;;
	}
	public HyperledgerNetwork getNetwork(){
		return this.mNetwork;
	}
	public Channel updateNetwork(HyperledgerNetwork network){
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
	public Channel updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<Node> getNodeList(){
		if(this.mNodeList == null){
			this.mNodeList = new SmartList<Node>();
			this.mNodeList.setListInternalName (NODE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mNodeList;	
	}
	public  void setNodeList(SmartList<Node> nodeList){
		for( Node node:nodeList){
			node.setChannel(this);
		}

		this.mNodeList = nodeList;
		this.mNodeList.setListInternalName (NODE_LIST );
		
	}
	
	public  void addNode(Node node){
		node.setChannel(this);
		getNodeList().add(node);
	}
	public  void addNodeList(SmartList<Node> nodeList){
		for( Node node:nodeList){
			node.setChannel(this);
		}
		getNodeList().addAll(nodeList);
	}
	public  void mergeNodeList(SmartList<Node> nodeList){
		if(nodeList==null){
			return;
		}
		if(nodeList.isEmpty()){
			return;
		}
		addNodeList( nodeList );
		
	}
	public  Node removeNode(Node nodeIndex){
		
		int index = getNodeList().indexOf(nodeIndex);
        if(index < 0){
        	String message = "Node("+nodeIndex.getId()+") with version='"+nodeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Node node = getNodeList().get(index);        
        // node.clearChannel(); //disconnect with Channel
        node.clearFromAll(); //disconnect with Channel
		
		boolean result = getNodeList().planToRemove(node);
        if(!result){
        	String message = "Node("+nodeIndex.getId()+") with version='"+nodeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return node;
        
	
	}
	//断舍离
	public  void breakWithNode(Node node){
		
		if(node == null){
			return;
		}
		node.setChannel(null);
		//getNodeList().remove();
	
	}
	
	public  boolean hasNode(Node node){
	
		return getNodeList().contains(node);
  
	}
	
	public void copyNodeFrom(Node node) {

		Node nodeInList = findTheNode(node);
		Node newNode = new Node();
		nodeInList.copyTo(newNode);
		newNode.setVersion(0);//will trigger copy
		getNodeList().add(newNode);
		addItemToFlexiableObject(COPIED_CHILD, newNode);
	}
	
	public  Node findTheNode(Node node){
		
		int index =  getNodeList().indexOf(node);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Node("+node.getId()+") with version='"+node.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getNodeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpNodeList(){
		getNodeList().clear();
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
			channelPeerRole.setChannel(this);
		}

		this.mChannelPeerRoleList = channelPeerRoleList;
		this.mChannelPeerRoleList.setListInternalName (CHANNEL_PEER_ROLE_LIST );
		
	}
	
	public  void addChannelPeerRole(ChannelPeerRole channelPeerRole){
		channelPeerRole.setChannel(this);
		getChannelPeerRoleList().add(channelPeerRole);
	}
	public  void addChannelPeerRoleList(SmartList<ChannelPeerRole> channelPeerRoleList){
		for( ChannelPeerRole channelPeerRole:channelPeerRoleList){
			channelPeerRole.setChannel(this);
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
        // channelPeerRole.clearChannel(); //disconnect with Channel
        channelPeerRole.clearFromAll(); //disconnect with Channel
		
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
		channelPeerRole.setChannel(null);
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
	
	
	


	public  SmartList<ChainCode> getChainCodeList(){
		if(this.mChainCodeList == null){
			this.mChainCodeList = new SmartList<ChainCode>();
			this.mChainCodeList.setListInternalName (CHAIN_CODE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mChainCodeList;	
	}
	public  void setChainCodeList(SmartList<ChainCode> chainCodeList){
		for( ChainCode chainCode:chainCodeList){
			chainCode.setChannel(this);
		}

		this.mChainCodeList = chainCodeList;
		this.mChainCodeList.setListInternalName (CHAIN_CODE_LIST );
		
	}
	
	public  void addChainCode(ChainCode chainCode){
		chainCode.setChannel(this);
		getChainCodeList().add(chainCode);
	}
	public  void addChainCodeList(SmartList<ChainCode> chainCodeList){
		for( ChainCode chainCode:chainCodeList){
			chainCode.setChannel(this);
		}
		getChainCodeList().addAll(chainCodeList);
	}
	public  void mergeChainCodeList(SmartList<ChainCode> chainCodeList){
		if(chainCodeList==null){
			return;
		}
		if(chainCodeList.isEmpty()){
			return;
		}
		addChainCodeList( chainCodeList );
		
	}
	public  ChainCode removeChainCode(ChainCode chainCodeIndex){
		
		int index = getChainCodeList().indexOf(chainCodeIndex);
        if(index < 0){
        	String message = "ChainCode("+chainCodeIndex.getId()+") with version='"+chainCodeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ChainCode chainCode = getChainCodeList().get(index);        
        // chainCode.clearChannel(); //disconnect with Channel
        chainCode.clearFromAll(); //disconnect with Channel
		
		boolean result = getChainCodeList().planToRemove(chainCode);
        if(!result){
        	String message = "ChainCode("+chainCodeIndex.getId()+") with version='"+chainCodeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return chainCode;
        
	
	}
	//断舍离
	public  void breakWithChainCode(ChainCode chainCode){
		
		if(chainCode == null){
			return;
		}
		chainCode.setChannel(null);
		//getChainCodeList().remove();
	
	}
	
	public  boolean hasChainCode(ChainCode chainCode){
	
		return getChainCodeList().contains(chainCode);
  
	}
	
	public void copyChainCodeFrom(ChainCode chainCode) {

		ChainCode chainCodeInList = findTheChainCode(chainCode);
		ChainCode newChainCode = new ChainCode();
		chainCodeInList.copyTo(newChainCode);
		newChainCode.setVersion(0);//will trigger copy
		getChainCodeList().add(newChainCode);
		addItemToFlexiableObject(COPIED_CHILD, newChainCode);
	}
	
	public  ChainCode findTheChainCode(ChainCode chainCode){
		
		int index =  getChainCodeList().indexOf(chainCode);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ChainCode("+chainCode.getId()+") with version='"+chainCode.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getChainCodeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpChainCodeList(){
		getChainCodeList().clear();
	}
	
	
	


	public  SmartList<Application> getApplicationList(){
		if(this.mApplicationList == null){
			this.mApplicationList = new SmartList<Application>();
			this.mApplicationList.setListInternalName (APPLICATION_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mApplicationList;	
	}
	public  void setApplicationList(SmartList<Application> applicationList){
		for( Application application:applicationList){
			application.setChannel(this);
		}

		this.mApplicationList = applicationList;
		this.mApplicationList.setListInternalName (APPLICATION_LIST );
		
	}
	
	public  void addApplication(Application application){
		application.setChannel(this);
		getApplicationList().add(application);
	}
	public  void addApplicationList(SmartList<Application> applicationList){
		for( Application application:applicationList){
			application.setChannel(this);
		}
		getApplicationList().addAll(applicationList);
	}
	public  void mergeApplicationList(SmartList<Application> applicationList){
		if(applicationList==null){
			return;
		}
		if(applicationList.isEmpty()){
			return;
		}
		addApplicationList( applicationList );
		
	}
	public  Application removeApplication(Application applicationIndex){
		
		int index = getApplicationList().indexOf(applicationIndex);
        if(index < 0){
        	String message = "Application("+applicationIndex.getId()+") with version='"+applicationIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Application application = getApplicationList().get(index);        
        // application.clearChannel(); //disconnect with Channel
        application.clearFromAll(); //disconnect with Channel
		
		boolean result = getApplicationList().planToRemove(application);
        if(!result){
        	String message = "Application("+applicationIndex.getId()+") with version='"+applicationIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return application;
        
	
	}
	//断舍离
	public  void breakWithApplication(Application application){
		
		if(application == null){
			return;
		}
		application.setChannel(null);
		//getApplicationList().remove();
	
	}
	
	public  boolean hasApplication(Application application){
	
		return getApplicationList().contains(application);
  
	}
	
	public void copyApplicationFrom(Application application) {

		Application applicationInList = findTheApplication(application);
		Application newApplication = new Application();
		applicationInList.copyTo(newApplication);
		newApplication.setVersion(0);//will trigger copy
		getApplicationList().add(newApplication);
		addItemToFlexiableObject(COPIED_CHILD, newApplication);
	}
	
	public  Application findTheApplication(Application application){
		
		int index =  getApplicationList().indexOf(application);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Application("+application.getId()+") with version='"+application.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getApplicationList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpApplicationList(){
		getApplicationList().clear();
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
			serviceRecord.setChannel(this);
		}

		this.mServiceRecordList = serviceRecordList;
		this.mServiceRecordList.setListInternalName (SERVICE_RECORD_LIST );
		
	}
	
	public  void addServiceRecord(ServiceRecord serviceRecord){
		serviceRecord.setChannel(this);
		getServiceRecordList().add(serviceRecord);
	}
	public  void addServiceRecordList(SmartList<ServiceRecord> serviceRecordList){
		for( ServiceRecord serviceRecord:serviceRecordList){
			serviceRecord.setChannel(this);
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
        // serviceRecord.clearChannel(); //disconnect with Channel
        serviceRecord.clearFromAll(); //disconnect with Channel
		
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
		serviceRecord.setChannel(null);
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
		collectFromList(this, entityList, getNodeList(), internalType);
		collectFromList(this, entityList, getChannelPeerRoleList(), internalType);
		collectFromList(this, entityList, getChainCodeList(), internalType);
		collectFromList(this, entityList, getApplicationList(), internalType);
		collectFromList(this, entityList, getServiceRecordList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getNodeList());
		listOfList.add( getChannelPeerRoleList());
		listOfList.add( getChainCodeList());
		listOfList.add( getApplicationList());
		listOfList.add( getServiceRecordList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, NETWORK_PROPERTY, getNetwork());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, NODE_LIST, getNodeList());
		if(!getNodeList().isEmpty()){
			appendKeyValuePair(result, "nodeCount", getNodeList().getTotalCount());
			appendKeyValuePair(result, "nodeCurrentPageNumber", getNodeList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, CHANNEL_PEER_ROLE_LIST, getChannelPeerRoleList());
		if(!getChannelPeerRoleList().isEmpty()){
			appendKeyValuePair(result, "channelPeerRoleCount", getChannelPeerRoleList().getTotalCount());
			appendKeyValuePair(result, "channelPeerRoleCurrentPageNumber", getChannelPeerRoleList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, CHAIN_CODE_LIST, getChainCodeList());
		if(!getChainCodeList().isEmpty()){
			appendKeyValuePair(result, "chainCodeCount", getChainCodeList().getTotalCount());
			appendKeyValuePair(result, "chainCodeCurrentPageNumber", getChainCodeList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, APPLICATION_LIST, getApplicationList());
		if(!getApplicationList().isEmpty()){
			appendKeyValuePair(result, "applicationCount", getApplicationList().getTotalCount());
			appendKeyValuePair(result, "applicationCurrentPageNumber", getApplicationList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, SERVICE_RECORD_LIST, getServiceRecordList());
		if(!getServiceRecordList().isEmpty()){
			appendKeyValuePair(result, "serviceRecordCount", getServiceRecordList().getTotalCount());
			appendKeyValuePair(result, "serviceRecordCurrentPageNumber", getServiceRecordList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Channel){
		
		
			Channel dest =(Channel)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setNetwork(getNetwork());
			dest.setVersion(getVersion());
			dest.setNodeList(getNodeList());
			dest.setChannelPeerRoleList(getChannelPeerRoleList());
			dest.setChainCodeList(getChainCodeList());
			dest.setApplicationList(getApplicationList());
			dest.setServiceRecordList(getServiceRecordList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Channel){
		
			
			Channel dest =(Channel)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeNetwork(getNetwork());
			dest.mergeVersion(getVersion());
			dest.mergeNodeList(getNodeList());
			dest.mergeChannelPeerRoleList(getChannelPeerRoleList());
			dest.mergeChainCodeList(getChainCodeList());
			dest.mergeApplicationList(getApplicationList());
			dest.mergeServiceRecordList(getServiceRecordList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Channel){
		
			
			Channel dest =(Channel)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Channel{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getNetwork() != null ){
 			stringBuilder.append("\tnetwork='HyperledgerNetwork("+getNetwork().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

