
package com.doublechaintech.hfgw.grpcoption;

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

@JsonSerialize(using = GrpcOptionSerializer.class)
public class GrpcOption extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String PARAMETER_NAME_PROPERTY        = "parameterName"     ;
	public static final String PARAMETER_VALUE_PROPERTY       = "parameterValue"    ;
	public static final String NODE_PROPERTY                  = "node"              ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="GrpcOption";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getParameterName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mParameterName      ;
	protected		String              	mParameterValue     ;
	protected		Node                	mNode               ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	GrpcOption(){
		// lazy load for all the properties
	}
	public 	static GrpcOption withId(String id){
		GrpcOption grpcOption = new GrpcOption();
		grpcOption.setId(id);
		grpcOption.setVersion(Integer.MAX_VALUE);
		return grpcOption;
	}
	public 	static GrpcOption refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setNode( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(PARAMETER_NAME_PROPERTY.equals(property)){
			changeParameterNameProperty(newValueExpr);
		}
		if(PARAMETER_VALUE_PROPERTY.equals(property)){
			changeParameterValueProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeParameterNameProperty(String newValueExpr){
		String oldValue = getParameterName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateParameterName(newValue);
		this.onChangeProperty(PARAMETER_NAME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeParameterValueProperty(String newValueExpr){
		String oldValue = getParameterValue();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateParameterValue(newValue);
		this.onChangeProperty(PARAMETER_VALUE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(PARAMETER_NAME_PROPERTY.equals(property)){
			return getParameterName();
		}
		if(PARAMETER_VALUE_PROPERTY.equals(property)){
			return getParameterValue();
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
	public GrpcOption updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setParameterName(String parameterName){
		this.mParameterName = trimString(parameterName);;
	}
	public String getParameterName(){
		return this.mParameterName;
	}
	public GrpcOption updateParameterName(String parameterName){
		this.mParameterName = trimString(parameterName);;
		this.changed = true;
		return this;
	}
	public void mergeParameterName(String parameterName){
		if(parameterName != null) { setParameterName(parameterName);}
	}
	
	
	public void setParameterValue(String parameterValue){
		this.mParameterValue = trimString(parameterValue);;
	}
	public String getParameterValue(){
		return this.mParameterValue;
	}
	public GrpcOption updateParameterValue(String parameterValue){
		this.mParameterValue = trimString(parameterValue);;
		this.changed = true;
		return this;
	}
	public void mergeParameterValue(String parameterValue){
		if(parameterValue != null) { setParameterValue(parameterValue);}
	}
	
	
	public void setNode(Node node){
		this.mNode = node;;
	}
	public Node getNode(){
		return this.mNode;
	}
	public GrpcOption updateNode(Node node){
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
	public GrpcOption updateVersion(int version){
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
		appendKeyValuePair(result, PARAMETER_NAME_PROPERTY, getParameterName());
		appendKeyValuePair(result, PARAMETER_VALUE_PROPERTY, getParameterValue());
		appendKeyValuePair(result, NODE_PROPERTY, getNode());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof GrpcOption){
		
		
			GrpcOption dest =(GrpcOption)baseDest;
		
			dest.setId(getId());
			dest.setParameterName(getParameterName());
			dest.setParameterValue(getParameterValue());
			dest.setNode(getNode());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof GrpcOption){
		
			
			GrpcOption dest =(GrpcOption)baseDest;
		
			dest.mergeId(getId());
			dest.mergeParameterName(getParameterName());
			dest.mergeParameterValue(getParameterValue());
			dest.mergeNode(getNode());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof GrpcOption){
		
			
			GrpcOption dest =(GrpcOption)baseDest;
		
			dest.mergeId(getId());
			dest.mergeParameterName(getParameterName());
			dest.mergeParameterValue(getParameterValue());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("GrpcOption{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tparameterName='"+getParameterName()+"';");
		stringBuilder.append("\tparameterValue='"+getParameterValue()+"';");
		if(getNode() != null ){
 			stringBuilder.append("\tnode='Node("+getNode().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

