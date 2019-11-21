
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
import com.doublechaintech.hfgw.organization.Organization;
import com.doublechaintech.hfgw.tlscacert.TlsCacert;
import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.nodetype.NodeType;
import com.doublechaintech.hfgw.grpcoption.GrpcOption;

@JsonSerialize(using = NodeSerializer.class)
public class Node extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String URL_PROPERTY                   = "url"               ;
	public static final String ORGANIZATION_PROPERTY          = "organization"      ;
	public static final String CHANNEL_PROPERTY               = "channel"           ;
	public static final String TYPE_PROPERTY                  = "type"              ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String GRPC_OPTION_LIST                         = "grpcOptionList"    ;
	public static final String TLS_CACERT_LIST                          = "tlsCacertList"     ;

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
	protected		NodeType            	mType               ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<GrpcOption>	mGrpcOptionList     ;
	protected		SmartList<TlsCacert>	mTlsCacertList      ;
	
		
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
		if(TYPE_PROPERTY.equals(property)){
			return getType();
		}
		if(GRPC_OPTION_LIST.equals(property)){
			List<BaseEntity> list = getGrpcOptionList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(TLS_CACERT_LIST.equals(property)){
			List<BaseEntity> list = getTlsCacertList().stream().map(item->item).collect(Collectors.toList());
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
	
	
	


	public  SmartList<TlsCacert> getTlsCacertList(){
		if(this.mTlsCacertList == null){
			this.mTlsCacertList = new SmartList<TlsCacert>();
			this.mTlsCacertList.setListInternalName (TLS_CACERT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mTlsCacertList;	
	}
	public  void setTlsCacertList(SmartList<TlsCacert> tlsCacertList){
		for( TlsCacert tlsCacert:tlsCacertList){
			tlsCacert.setNode(this);
		}

		this.mTlsCacertList = tlsCacertList;
		this.mTlsCacertList.setListInternalName (TLS_CACERT_LIST );
		
	}
	
	public  void addTlsCacert(TlsCacert tlsCacert){
		tlsCacert.setNode(this);
		getTlsCacertList().add(tlsCacert);
	}
	public  void addTlsCacertList(SmartList<TlsCacert> tlsCacertList){
		for( TlsCacert tlsCacert:tlsCacertList){
			tlsCacert.setNode(this);
		}
		getTlsCacertList().addAll(tlsCacertList);
	}
	public  void mergeTlsCacertList(SmartList<TlsCacert> tlsCacertList){
		if(tlsCacertList==null){
			return;
		}
		if(tlsCacertList.isEmpty()){
			return;
		}
		addTlsCacertList( tlsCacertList );
		
	}
	public  TlsCacert removeTlsCacert(TlsCacert tlsCacertIndex){
		
		int index = getTlsCacertList().indexOf(tlsCacertIndex);
        if(index < 0){
        	String message = "TlsCacert("+tlsCacertIndex.getId()+") with version='"+tlsCacertIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        TlsCacert tlsCacert = getTlsCacertList().get(index);        
        // tlsCacert.clearNode(); //disconnect with Node
        tlsCacert.clearFromAll(); //disconnect with Node
		
		boolean result = getTlsCacertList().planToRemove(tlsCacert);
        if(!result){
        	String message = "TlsCacert("+tlsCacertIndex.getId()+") with version='"+tlsCacertIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return tlsCacert;
        
	
	}
	//断舍离
	public  void breakWithTlsCacert(TlsCacert tlsCacert){
		
		if(tlsCacert == null){
			return;
		}
		tlsCacert.setNode(null);
		//getTlsCacertList().remove();
	
	}
	
	public  boolean hasTlsCacert(TlsCacert tlsCacert){
	
		return getTlsCacertList().contains(tlsCacert);
  
	}
	
	public void copyTlsCacertFrom(TlsCacert tlsCacert) {

		TlsCacert tlsCacertInList = findTheTlsCacert(tlsCacert);
		TlsCacert newTlsCacert = new TlsCacert();
		tlsCacertInList.copyTo(newTlsCacert);
		newTlsCacert.setVersion(0);//will trigger copy
		getTlsCacertList().add(newTlsCacert);
		addItemToFlexiableObject(COPIED_CHILD, newTlsCacert);
	}
	
	public  TlsCacert findTheTlsCacert(TlsCacert tlsCacert){
		
		int index =  getTlsCacertList().indexOf(tlsCacert);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "TlsCacert("+tlsCacert.getId()+") with version='"+tlsCacert.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getTlsCacertList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTlsCacertList(){
		getTlsCacertList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getOrganization(), internalType);
		addToEntityList(this, entityList, getChannel(), internalType);
		addToEntityList(this, entityList, getType(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getGrpcOptionList(), internalType);
		collectFromList(this, entityList, getTlsCacertList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getGrpcOptionList());
		listOfList.add( getTlsCacertList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, URL_PROPERTY, getUrl());
		appendKeyValuePair(result, ORGANIZATION_PROPERTY, getOrganization());
		appendKeyValuePair(result, CHANNEL_PROPERTY, getChannel());
		appendKeyValuePair(result, TYPE_PROPERTY, getType());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, GRPC_OPTION_LIST, getGrpcOptionList());
		if(!getGrpcOptionList().isEmpty()){
			appendKeyValuePair(result, "grpcOptionCount", getGrpcOptionList().getTotalCount());
			appendKeyValuePair(result, "grpcOptionCurrentPageNumber", getGrpcOptionList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, TLS_CACERT_LIST, getTlsCacertList());
		if(!getTlsCacertList().isEmpty()){
			appendKeyValuePair(result, "tlsCacertCount", getTlsCacertList().getTotalCount());
			appendKeyValuePair(result, "tlsCacertCurrentPageNumber", getTlsCacertList().getCurrentPageNumber());
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
			dest.setType(getType());
			dest.setVersion(getVersion());
			dest.setGrpcOptionList(getGrpcOptionList());
			dest.setTlsCacertList(getTlsCacertList());

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
			dest.mergeType(getType());
			dest.mergeVersion(getVersion());
			dest.mergeGrpcOptionList(getGrpcOptionList());
			dest.mergeTlsCacertList(getTlsCacertList());

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
		if(getType() != null ){
 			stringBuilder.append("\ttype='NodeType("+getType().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

