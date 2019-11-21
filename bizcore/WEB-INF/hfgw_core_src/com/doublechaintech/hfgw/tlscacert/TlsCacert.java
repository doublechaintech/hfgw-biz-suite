
package com.doublechaintech.hfgw.tlscacert;

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

@JsonSerialize(using = TlsCacertSerializer.class)
public class TlsCacert extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String PATH_PROPERTY                  = "path"              ;
	public static final String CERT_PROPERTY                  = "cert"              ;
	public static final String NODE_PROPERTY                  = "node"              ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="TlsCacert";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getPath();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mPath               ;
	protected		String              	mCert               ;
	protected		Node                	mNode               ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	TlsCacert(){
		// lazy load for all the properties
	}
	public 	static TlsCacert withId(String id){
		TlsCacert tlsCacert = new TlsCacert();
		tlsCacert.setId(id);
		tlsCacert.setVersion(Integer.MAX_VALUE);
		return tlsCacert;
	}
	public 	static TlsCacert refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setNode( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(PATH_PROPERTY.equals(property)){
			changePathProperty(newValueExpr);
		}
		if(CERT_PROPERTY.equals(property)){
			changeCertProperty(newValueExpr);
		}

      
	}
    
    
	protected void changePathProperty(String newValueExpr){
		String oldValue = getPath();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePath(newValue);
		this.onChangeProperty(PATH_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeCertProperty(String newValueExpr){
		String oldValue = getCert();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCert(newValue);
		this.onChangeProperty(CERT_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(PATH_PROPERTY.equals(property)){
			return getPath();
		}
		if(CERT_PROPERTY.equals(property)){
			return getCert();
		}
		if(NODE_PROPERTY.equals(property)){
			return getNode();
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
	public TlsCacert updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setPath(String path){
		this.mPath = trimString(path);;
	}
	public String getPath(){
		return this.mPath;
	}
	public TlsCacert updatePath(String path){
		this.mPath = trimString(path);;
		this.changed = true;
		return this;
	}
	public void mergePath(String path){
		if(path != null) { setPath(path);}
	}
	
	
	public void setCert(String cert){
		this.mCert = cert;;
	}
	public String getCert(){
		return this.mCert;
	}
	public TlsCacert updateCert(String cert){
		this.mCert = cert;;
		this.changed = true;
		return this;
	}
	public void mergeCert(String cert){
		if(cert != null) { setCert(cert);}
	}
	
	
	public void setNode(Node node){
		this.mNode = node;;
	}
	public Node getNode(){
		return this.mNode;
	}
	public TlsCacert updateNode(Node node){
		this.mNode = node;;
		this.changed = true;
		return this;
	}
	public void mergeNode(Node node){
		if(node != null) { setNode(node);}
	}
	
	
	public void clearNode(){
		setNode ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public TlsCacert updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getNode(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, PATH_PROPERTY, getPath());
		appendKeyValuePair(result, CERT_PROPERTY, getCert());
		appendKeyValuePair(result, NODE_PROPERTY, getNode());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TlsCacert){
		
		
			TlsCacert dest =(TlsCacert)baseDest;
		
			dest.setId(getId());
			dest.setPath(getPath());
			dest.setCert(getCert());
			dest.setNode(getNode());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TlsCacert){
		
			
			TlsCacert dest =(TlsCacert)baseDest;
		
			dest.mergeId(getId());
			dest.mergePath(getPath());
			dest.mergeCert(getCert());
			dest.mergeNode(getNode());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TlsCacert){
		
			
			TlsCacert dest =(TlsCacert)baseDest;
		
			dest.mergeId(getId());
			dest.mergePath(getPath());
			dest.mergeCert(getCert());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("TlsCacert{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tpath='"+getPath()+"';");
		stringBuilder.append("\tcert='"+getCert()+"';");
		if(getNode() != null ){
 			stringBuilder.append("\tnode='Node("+getNode().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

