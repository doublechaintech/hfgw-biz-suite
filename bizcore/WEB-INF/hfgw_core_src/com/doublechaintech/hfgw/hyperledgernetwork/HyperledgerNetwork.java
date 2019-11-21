
package com.doublechaintech.hfgw.hyperledgernetwork;

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
import com.doublechaintech.hfgw.node.Node;
import com.doublechaintech.hfgw.organization.Organization;
import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.application.Application;
import com.doublechaintech.hfgw.changerequesttype.ChangeRequestType;
import com.doublechaintech.hfgw.servicerecord.ServiceRecord;

@JsonSerialize(using = HyperledgerNetworkSerializer.class)
public class HyperledgerNetwork extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String ORGANIZATION_LIST                        = "organizationList"  ;
	public static final String NODE_LIST                                = "nodeList"          ;
	public static final String CHANNEL_LIST                             = "channelList"       ;
	public static final String APPLICATION_LIST                         = "applicationList"   ;
	public static final String SERVICE_RECORD_LIST                      = "serviceRecordList" ;
	public static final String CHANGE_REQUEST_TYPE_LIST                 = "changeRequestTypeList";
	public static final String CHANGE_REQUEST_LIST                      = "changeRequestList" ;

	public static final String INTERNAL_TYPE="HyperledgerNetwork";
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
	protected		String              	mDescription        ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Organization>	mOrganizationList   ;
	protected		SmartList<Node>     	mNodeList           ;
	protected		SmartList<Channel>  	mChannelList        ;
	protected		SmartList<Application>	mApplicationList    ;
	protected		SmartList<ServiceRecord>	mServiceRecordList  ;
	protected		SmartList<ChangeRequestType>	mChangeRequestTypeList;
	protected		SmartList<ChangeRequest>	mChangeRequestList  ;
	
		
	public 	HyperledgerNetwork(){
		// lazy load for all the properties
	}
	public 	static HyperledgerNetwork withId(String id){
		HyperledgerNetwork hyperledgerNetwork = new HyperledgerNetwork();
		hyperledgerNetwork.setId(id);
		hyperledgerNetwork.setVersion(Integer.MAX_VALUE);
		return hyperledgerNetwork;
	}
	public 	static HyperledgerNetwork refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
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
			
			
			
	protected void changeDescriptionProperty(String newValueExpr){
		String oldValue = getDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDescription(newValue);
		this.onChangeProperty(DESCRIPTION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			return getDescription();
		}
		if(ORGANIZATION_LIST.equals(property)){
			List<BaseEntity> list = getOrganizationList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(NODE_LIST.equals(property)){
			List<BaseEntity> list = getNodeList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(CHANNEL_LIST.equals(property)){
			List<BaseEntity> list = getChannelList().stream().map(item->item).collect(Collectors.toList());
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
		if(CHANGE_REQUEST_TYPE_LIST.equals(property)){
			List<BaseEntity> list = getChangeRequestTypeList().stream().map(item->item).collect(Collectors.toList());
			return list;
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
	public HyperledgerNetwork updateId(String id){
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
	public HyperledgerNetwork updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setDescription(String description){
		this.mDescription = description;;
	}
	public String getDescription(){
		return this.mDescription;
	}
	public HyperledgerNetwork updateDescription(String description){
		this.mDescription = description;;
		this.changed = true;
		return this;
	}
	public void mergeDescription(String description){
		if(description != null) { setDescription(description);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public HyperledgerNetwork updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<Organization> getOrganizationList(){
		if(this.mOrganizationList == null){
			this.mOrganizationList = new SmartList<Organization>();
			this.mOrganizationList.setListInternalName (ORGANIZATION_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mOrganizationList;	
	}
	public  void setOrganizationList(SmartList<Organization> organizationList){
		for( Organization organization:organizationList){
			organization.setNetwork(this);
		}

		this.mOrganizationList = organizationList;
		this.mOrganizationList.setListInternalName (ORGANIZATION_LIST );
		
	}
	
	public  void addOrganization(Organization organization){
		organization.setNetwork(this);
		getOrganizationList().add(organization);
	}
	public  void addOrganizationList(SmartList<Organization> organizationList){
		for( Organization organization:organizationList){
			organization.setNetwork(this);
		}
		getOrganizationList().addAll(organizationList);
	}
	public  void mergeOrganizationList(SmartList<Organization> organizationList){
		if(organizationList==null){
			return;
		}
		if(organizationList.isEmpty()){
			return;
		}
		addOrganizationList( organizationList );
		
	}
	public  Organization removeOrganization(Organization organizationIndex){
		
		int index = getOrganizationList().indexOf(organizationIndex);
        if(index < 0){
        	String message = "Organization("+organizationIndex.getId()+") with version='"+organizationIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Organization organization = getOrganizationList().get(index);        
        // organization.clearNetwork(); //disconnect with Network
        organization.clearFromAll(); //disconnect with Network
		
		boolean result = getOrganizationList().planToRemove(organization);
        if(!result){
        	String message = "Organization("+organizationIndex.getId()+") with version='"+organizationIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return organization;
        
	
	}
	//断舍离
	public  void breakWithOrganization(Organization organization){
		
		if(organization == null){
			return;
		}
		organization.setNetwork(null);
		//getOrganizationList().remove();
	
	}
	
	public  boolean hasOrganization(Organization organization){
	
		return getOrganizationList().contains(organization);
  
	}
	
	public void copyOrganizationFrom(Organization organization) {

		Organization organizationInList = findTheOrganization(organization);
		Organization newOrganization = new Organization();
		organizationInList.copyTo(newOrganization);
		newOrganization.setVersion(0);//will trigger copy
		getOrganizationList().add(newOrganization);
		addItemToFlexiableObject(COPIED_CHILD, newOrganization);
	}
	
	public  Organization findTheOrganization(Organization organization){
		
		int index =  getOrganizationList().indexOf(organization);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Organization("+organization.getId()+") with version='"+organization.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getOrganizationList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpOrganizationList(){
		getOrganizationList().clear();
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
			node.setNetwork(this);
		}

		this.mNodeList = nodeList;
		this.mNodeList.setListInternalName (NODE_LIST );
		
	}
	
	public  void addNode(Node node){
		node.setNetwork(this);
		getNodeList().add(node);
	}
	public  void addNodeList(SmartList<Node> nodeList){
		for( Node node:nodeList){
			node.setNetwork(this);
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
        // node.clearNetwork(); //disconnect with Network
        node.clearFromAll(); //disconnect with Network
		
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
		node.setNetwork(null);
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
	
	
	


	public  SmartList<Channel> getChannelList(){
		if(this.mChannelList == null){
			this.mChannelList = new SmartList<Channel>();
			this.mChannelList.setListInternalName (CHANNEL_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mChannelList;	
	}
	public  void setChannelList(SmartList<Channel> channelList){
		for( Channel channel:channelList){
			channel.setNetwork(this);
		}

		this.mChannelList = channelList;
		this.mChannelList.setListInternalName (CHANNEL_LIST );
		
	}
	
	public  void addChannel(Channel channel){
		channel.setNetwork(this);
		getChannelList().add(channel);
	}
	public  void addChannelList(SmartList<Channel> channelList){
		for( Channel channel:channelList){
			channel.setNetwork(this);
		}
		getChannelList().addAll(channelList);
	}
	public  void mergeChannelList(SmartList<Channel> channelList){
		if(channelList==null){
			return;
		}
		if(channelList.isEmpty()){
			return;
		}
		addChannelList( channelList );
		
	}
	public  Channel removeChannel(Channel channelIndex){
		
		int index = getChannelList().indexOf(channelIndex);
        if(index < 0){
        	String message = "Channel("+channelIndex.getId()+") with version='"+channelIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Channel channel = getChannelList().get(index);        
        // channel.clearNetwork(); //disconnect with Network
        channel.clearFromAll(); //disconnect with Network
		
		boolean result = getChannelList().planToRemove(channel);
        if(!result){
        	String message = "Channel("+channelIndex.getId()+") with version='"+channelIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return channel;
        
	
	}
	//断舍离
	public  void breakWithChannel(Channel channel){
		
		if(channel == null){
			return;
		}
		channel.setNetwork(null);
		//getChannelList().remove();
	
	}
	
	public  boolean hasChannel(Channel channel){
	
		return getChannelList().contains(channel);
  
	}
	
	public void copyChannelFrom(Channel channel) {

		Channel channelInList = findTheChannel(channel);
		Channel newChannel = new Channel();
		channelInList.copyTo(newChannel);
		newChannel.setVersion(0);//will trigger copy
		getChannelList().add(newChannel);
		addItemToFlexiableObject(COPIED_CHILD, newChannel);
	}
	
	public  Channel findTheChannel(Channel channel){
		
		int index =  getChannelList().indexOf(channel);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Channel("+channel.getId()+") with version='"+channel.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getChannelList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpChannelList(){
		getChannelList().clear();
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
			application.setNetwork(this);
		}

		this.mApplicationList = applicationList;
		this.mApplicationList.setListInternalName (APPLICATION_LIST );
		
	}
	
	public  void addApplication(Application application){
		application.setNetwork(this);
		getApplicationList().add(application);
	}
	public  void addApplicationList(SmartList<Application> applicationList){
		for( Application application:applicationList){
			application.setNetwork(this);
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
        // application.clearNetwork(); //disconnect with Network
        application.clearFromAll(); //disconnect with Network
		
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
		application.setNetwork(null);
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
			serviceRecord.setNetwork(this);
		}

		this.mServiceRecordList = serviceRecordList;
		this.mServiceRecordList.setListInternalName (SERVICE_RECORD_LIST );
		
	}
	
	public  void addServiceRecord(ServiceRecord serviceRecord){
		serviceRecord.setNetwork(this);
		getServiceRecordList().add(serviceRecord);
	}
	public  void addServiceRecordList(SmartList<ServiceRecord> serviceRecordList){
		for( ServiceRecord serviceRecord:serviceRecordList){
			serviceRecord.setNetwork(this);
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
        // serviceRecord.clearNetwork(); //disconnect with Network
        serviceRecord.clearFromAll(); //disconnect with Network
		
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
		serviceRecord.setNetwork(null);
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
	
	
	


	public  SmartList<ChangeRequestType> getChangeRequestTypeList(){
		if(this.mChangeRequestTypeList == null){
			this.mChangeRequestTypeList = new SmartList<ChangeRequestType>();
			this.mChangeRequestTypeList.setListInternalName (CHANGE_REQUEST_TYPE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mChangeRequestTypeList;	
	}
	public  void setChangeRequestTypeList(SmartList<ChangeRequestType> changeRequestTypeList){
		for( ChangeRequestType changeRequestType:changeRequestTypeList){
			changeRequestType.setNetwork(this);
		}

		this.mChangeRequestTypeList = changeRequestTypeList;
		this.mChangeRequestTypeList.setListInternalName (CHANGE_REQUEST_TYPE_LIST );
		
	}
	
	public  void addChangeRequestType(ChangeRequestType changeRequestType){
		changeRequestType.setNetwork(this);
		getChangeRequestTypeList().add(changeRequestType);
	}
	public  void addChangeRequestTypeList(SmartList<ChangeRequestType> changeRequestTypeList){
		for( ChangeRequestType changeRequestType:changeRequestTypeList){
			changeRequestType.setNetwork(this);
		}
		getChangeRequestTypeList().addAll(changeRequestTypeList);
	}
	public  void mergeChangeRequestTypeList(SmartList<ChangeRequestType> changeRequestTypeList){
		if(changeRequestTypeList==null){
			return;
		}
		if(changeRequestTypeList.isEmpty()){
			return;
		}
		addChangeRequestTypeList( changeRequestTypeList );
		
	}
	public  ChangeRequestType removeChangeRequestType(ChangeRequestType changeRequestTypeIndex){
		
		int index = getChangeRequestTypeList().indexOf(changeRequestTypeIndex);
        if(index < 0){
        	String message = "ChangeRequestType("+changeRequestTypeIndex.getId()+") with version='"+changeRequestTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ChangeRequestType changeRequestType = getChangeRequestTypeList().get(index);        
        // changeRequestType.clearNetwork(); //disconnect with Network
        changeRequestType.clearFromAll(); //disconnect with Network
		
		boolean result = getChangeRequestTypeList().planToRemove(changeRequestType);
        if(!result){
        	String message = "ChangeRequestType("+changeRequestTypeIndex.getId()+") with version='"+changeRequestTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return changeRequestType;
        
	
	}
	//断舍离
	public  void breakWithChangeRequestType(ChangeRequestType changeRequestType){
		
		if(changeRequestType == null){
			return;
		}
		changeRequestType.setNetwork(null);
		//getChangeRequestTypeList().remove();
	
	}
	
	public  boolean hasChangeRequestType(ChangeRequestType changeRequestType){
	
		return getChangeRequestTypeList().contains(changeRequestType);
  
	}
	
	public void copyChangeRequestTypeFrom(ChangeRequestType changeRequestType) {

		ChangeRequestType changeRequestTypeInList = findTheChangeRequestType(changeRequestType);
		ChangeRequestType newChangeRequestType = new ChangeRequestType();
		changeRequestTypeInList.copyTo(newChangeRequestType);
		newChangeRequestType.setVersion(0);//will trigger copy
		getChangeRequestTypeList().add(newChangeRequestType);
		addItemToFlexiableObject(COPIED_CHILD, newChangeRequestType);
	}
	
	public  ChangeRequestType findTheChangeRequestType(ChangeRequestType changeRequestType){
		
		int index =  getChangeRequestTypeList().indexOf(changeRequestType);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ChangeRequestType("+changeRequestType.getId()+") with version='"+changeRequestType.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getChangeRequestTypeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpChangeRequestTypeList(){
		getChangeRequestTypeList().clear();
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
			changeRequest.setNetwork(this);
		}

		this.mChangeRequestList = changeRequestList;
		this.mChangeRequestList.setListInternalName (CHANGE_REQUEST_LIST );
		
	}
	
	public  void addChangeRequest(ChangeRequest changeRequest){
		changeRequest.setNetwork(this);
		getChangeRequestList().add(changeRequest);
	}
	public  void addChangeRequestList(SmartList<ChangeRequest> changeRequestList){
		for( ChangeRequest changeRequest:changeRequestList){
			changeRequest.setNetwork(this);
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
        // changeRequest.clearNetwork(); //disconnect with Network
        changeRequest.clearFromAll(); //disconnect with Network
		
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
		changeRequest.setNetwork(null);
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


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getOrganizationList(), internalType);
		collectFromList(this, entityList, getNodeList(), internalType);
		collectFromList(this, entityList, getChannelList(), internalType);
		collectFromList(this, entityList, getApplicationList(), internalType);
		collectFromList(this, entityList, getServiceRecordList(), internalType);
		collectFromList(this, entityList, getChangeRequestTypeList(), internalType);
		collectFromList(this, entityList, getChangeRequestList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getOrganizationList());
		listOfList.add( getNodeList());
		listOfList.add( getChannelList());
		listOfList.add( getApplicationList());
		listOfList.add( getServiceRecordList());
		listOfList.add( getChangeRequestTypeList());
		listOfList.add( getChangeRequestList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, ORGANIZATION_LIST, getOrganizationList());
		if(!getOrganizationList().isEmpty()){
			appendKeyValuePair(result, "organizationCount", getOrganizationList().getTotalCount());
			appendKeyValuePair(result, "organizationCurrentPageNumber", getOrganizationList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, NODE_LIST, getNodeList());
		if(!getNodeList().isEmpty()){
			appendKeyValuePair(result, "nodeCount", getNodeList().getTotalCount());
			appendKeyValuePair(result, "nodeCurrentPageNumber", getNodeList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, CHANNEL_LIST, getChannelList());
		if(!getChannelList().isEmpty()){
			appendKeyValuePair(result, "channelCount", getChannelList().getTotalCount());
			appendKeyValuePair(result, "channelCurrentPageNumber", getChannelList().getCurrentPageNumber());
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
		appendKeyValuePair(result, CHANGE_REQUEST_TYPE_LIST, getChangeRequestTypeList());
		if(!getChangeRequestTypeList().isEmpty()){
			appendKeyValuePair(result, "changeRequestTypeCount", getChangeRequestTypeList().getTotalCount());
			appendKeyValuePair(result, "changeRequestTypeCurrentPageNumber", getChangeRequestTypeList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, CHANGE_REQUEST_LIST, getChangeRequestList());
		if(!getChangeRequestList().isEmpty()){
			appendKeyValuePair(result, "changeRequestCount", getChangeRequestList().getTotalCount());
			appendKeyValuePair(result, "changeRequestCurrentPageNumber", getChangeRequestList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof HyperledgerNetwork){
		
		
			HyperledgerNetwork dest =(HyperledgerNetwork)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setDescription(getDescription());
			dest.setVersion(getVersion());
			dest.setOrganizationList(getOrganizationList());
			dest.setNodeList(getNodeList());
			dest.setChannelList(getChannelList());
			dest.setApplicationList(getApplicationList());
			dest.setServiceRecordList(getServiceRecordList());
			dest.setChangeRequestTypeList(getChangeRequestTypeList());
			dest.setChangeRequestList(getChangeRequestList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof HyperledgerNetwork){
		
			
			HyperledgerNetwork dest =(HyperledgerNetwork)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeDescription(getDescription());
			dest.mergeVersion(getVersion());
			dest.mergeOrganizationList(getOrganizationList());
			dest.mergeNodeList(getNodeList());
			dest.mergeChannelList(getChannelList());
			dest.mergeApplicationList(getApplicationList());
			dest.mergeServiceRecordList(getServiceRecordList());
			dest.mergeChangeRequestTypeList(getChangeRequestTypeList());
			dest.mergeChangeRequestList(getChangeRequestList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof HyperledgerNetwork){
		
			
			HyperledgerNetwork dest =(HyperledgerNetwork)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeDescription(getDescription());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("HyperledgerNetwork{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

