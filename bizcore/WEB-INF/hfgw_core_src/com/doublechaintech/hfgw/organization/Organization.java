
package com.doublechaintech.hfgw.organization;

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
import com.doublechaintech.hfgw.node.Node;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

@JsonSerialize(using = OrganizationSerializer.class)
public class Organization extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String MSPID_PROPERTY                 = "mspid"             ;
	public static final String NETWORK_PROPERTY               = "network"           ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String NODE_LIST                                = "nodeList"          ;

	public static final String INTERNAL_TYPE="Organization";
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
	protected		String              	mMspid              ;
	protected		HyperledgerNetwork  	mNetwork            ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Node>     	mNodeList           ;
	
		
	public 	Organization(){
		// lazy load for all the properties
	}
	public 	static Organization withId(String id){
		Organization organization = new Organization();
		organization.setId(id);
		organization.setVersion(Integer.MAX_VALUE);
		return organization;
	}
	public 	static Organization refById(String id){
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
		if(MSPID_PROPERTY.equals(property)){
			changeMspidProperty(newValueExpr);
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
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(MSPID_PROPERTY.equals(property)){
			return getMspid();
		}
		if(NETWORK_PROPERTY.equals(property)){
			return getNetwork();
		}
		if(NODE_LIST.equals(property)){
			List<BaseEntity> list = getNodeList().stream().map(item->item).collect(Collectors.toList());
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
	public Organization updateId(String id){
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
	public Organization updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setMspid(String mspid){
		this.mMspid = trimString(mspid);;
	}
	public String getMspid(){
		return this.mMspid;
	}
	public Organization updateMspid(String mspid){
		this.mMspid = trimString(mspid);;
		this.changed = true;
		return this;
	}
	public void mergeMspid(String mspid){
		if(mspid != null) { setMspid(mspid);}
	}
	
	
	public void setNetwork(HyperledgerNetwork network){
		this.mNetwork = network;;
	}
	public HyperledgerNetwork getNetwork(){
		return this.mNetwork;
	}
	public Organization updateNetwork(HyperledgerNetwork network){
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
	public Organization updateVersion(int version){
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
			node.setOrganization(this);
		}

		this.mNodeList = nodeList;
		this.mNodeList.setListInternalName (NODE_LIST );
		
	}
	
	public  void addNode(Node node){
		node.setOrganization(this);
		getNodeList().add(node);
	}
	public  void addNodeList(SmartList<Node> nodeList){
		for( Node node:nodeList){
			node.setOrganization(this);
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
        // node.clearOrganization(); //disconnect with Organization
        node.clearFromAll(); //disconnect with Organization
		
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
		node.setOrganization(null);
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
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getNetwork(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getNodeList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getNodeList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, MSPID_PROPERTY, getMspid());
		appendKeyValuePair(result, NETWORK_PROPERTY, getNetwork());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, NODE_LIST, getNodeList());
		if(!getNodeList().isEmpty()){
			appendKeyValuePair(result, "nodeCount", getNodeList().getTotalCount());
			appendKeyValuePair(result, "nodeCurrentPageNumber", getNodeList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Organization){
		
		
			Organization dest =(Organization)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setMspid(getMspid());
			dest.setNetwork(getNetwork());
			dest.setVersion(getVersion());
			dest.setNodeList(getNodeList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Organization){
		
			
			Organization dest =(Organization)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeMspid(getMspid());
			dest.mergeNetwork(getNetwork());
			dest.mergeVersion(getVersion());
			dest.mergeNodeList(getNodeList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Organization){
		
			
			Organization dest =(Organization)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeMspid(getMspid());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Organization{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tmspid='"+getMspid()+"';");
		if(getNetwork() != null ){
 			stringBuilder.append("\tnetwork='HyperledgerNetwork("+getNetwork().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

