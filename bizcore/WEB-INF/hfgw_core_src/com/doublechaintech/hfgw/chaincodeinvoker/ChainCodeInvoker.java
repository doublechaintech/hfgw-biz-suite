
package com.doublechaintech.hfgw.chaincodeinvoker;

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
import com.doublechaintech.hfgw.changerequest.ChangeRequest;
import com.doublechaintech.hfgw.application.Application;

@JsonSerialize(using = ChainCodeInvokerSerializer.class)
public class ChainCodeInvoker extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String APP_CLIENT_PROPERTY            = "appClient"         ;
	public static final String CHAIN_CODE_PROPERTY            = "chainCode"         ;
	public static final String PARAMETERS_PROPERTY            = "parameters"        ;
	public static final String CHANGE_REQUEST_PROPERTY        = "changeRequest"     ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="ChainCodeInvoker";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getParameters();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		Application         	mAppClient          ;
	protected		ChainCode           	mChainCode          ;
	protected		String              	mParameters         ;
	protected		ChangeRequest       	mChangeRequest      ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	ChainCodeInvoker(){
		// lazy load for all the properties
	}
	public 	static ChainCodeInvoker withId(String id){
		ChainCodeInvoker chainCodeInvoker = new ChainCodeInvoker();
		chainCodeInvoker.setId(id);
		chainCodeInvoker.setVersion(Integer.MAX_VALUE);
		return chainCodeInvoker;
	}
	public 	static ChainCodeInvoker refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setAppClient( null );
		setChainCode( null );
		setChangeRequest( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(PARAMETERS_PROPERTY.equals(property)){
			changeParametersProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeParametersProperty(String newValueExpr){
		String oldValue = getParameters();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateParameters(newValue);
		this.onChangeProperty(PARAMETERS_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(APP_CLIENT_PROPERTY.equals(property)){
			return getAppClient();
		}
		if(CHAIN_CODE_PROPERTY.equals(property)){
			return getChainCode();
		}
		if(PARAMETERS_PROPERTY.equals(property)){
			return getParameters();
		}
		if(CHANGE_REQUEST_PROPERTY.equals(property)){
			return getChangeRequest();
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
	public ChainCodeInvoker updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setAppClient(Application appClient){
		this.mAppClient = appClient;;
	}
	public Application getAppClient(){
		return this.mAppClient;
	}
	public ChainCodeInvoker updateAppClient(Application appClient){
		this.mAppClient = appClient;;
		this.changed = true;
		return this;
	}
	public void mergeAppClient(Application appClient){
		if(appClient != null) { setAppClient(appClient);}
	}
	
	
	public void clearAppClient(){
		setAppClient ( null );
		this.changed = true;
	}
	
	public void setChainCode(ChainCode chainCode){
		this.mChainCode = chainCode;;
	}
	public ChainCode getChainCode(){
		return this.mChainCode;
	}
	public ChainCodeInvoker updateChainCode(ChainCode chainCode){
		this.mChainCode = chainCode;;
		this.changed = true;
		return this;
	}
	public void mergeChainCode(ChainCode chainCode){
		if(chainCode != null) { setChainCode(chainCode);}
	}
	
	
	public void clearChainCode(){
		setChainCode ( null );
		this.changed = true;
	}
	
	public void setParameters(String parameters){
		this.mParameters = parameters;;
	}
	public String getParameters(){
		return this.mParameters;
	}
	public ChainCodeInvoker updateParameters(String parameters){
		this.mParameters = parameters;;
		this.changed = true;
		return this;
	}
	public void mergeParameters(String parameters){
		if(parameters != null) { setParameters(parameters);}
	}
	
	
	public void setChangeRequest(ChangeRequest changeRequest){
		this.mChangeRequest = changeRequest;;
	}
	public ChangeRequest getChangeRequest(){
		return this.mChangeRequest;
	}
	public ChainCodeInvoker updateChangeRequest(ChangeRequest changeRequest){
		this.mChangeRequest = changeRequest;;
		this.changed = true;
		return this;
	}
	public void mergeChangeRequest(ChangeRequest changeRequest){
		if(changeRequest != null) { setChangeRequest(changeRequest);}
	}
	
	
	public void clearChangeRequest(){
		setChangeRequest ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public ChainCodeInvoker updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getAppClient(), internalType);
		addToEntityList(this, entityList, getChainCode(), internalType);
		addToEntityList(this, entityList, getChangeRequest(), internalType);

		
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
		appendKeyValuePair(result, APP_CLIENT_PROPERTY, getAppClient());
		appendKeyValuePair(result, CHAIN_CODE_PROPERTY, getChainCode());
		appendKeyValuePair(result, PARAMETERS_PROPERTY, getParameters());
		appendKeyValuePair(result, CHANGE_REQUEST_PROPERTY, getChangeRequest());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ChainCodeInvoker){
		
		
			ChainCodeInvoker dest =(ChainCodeInvoker)baseDest;
		
			dest.setId(getId());
			dest.setAppClient(getAppClient());
			dest.setChainCode(getChainCode());
			dest.setParameters(getParameters());
			dest.setChangeRequest(getChangeRequest());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ChainCodeInvoker){
		
			
			ChainCodeInvoker dest =(ChainCodeInvoker)baseDest;
		
			dest.mergeId(getId());
			dest.mergeAppClient(getAppClient());
			dest.mergeChainCode(getChainCode());
			dest.mergeParameters(getParameters());
			dest.mergeChangeRequest(getChangeRequest());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ChainCodeInvoker){
		
			
			ChainCodeInvoker dest =(ChainCodeInvoker)baseDest;
		
			dest.mergeId(getId());
			dest.mergeParameters(getParameters());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("ChainCodeInvoker{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getAppClient() != null ){
 			stringBuilder.append("\tappClient='Application("+getAppClient().getId()+")';");
 		}
		if(getChainCode() != null ){
 			stringBuilder.append("\tchainCode='ChainCode("+getChainCode().getId()+")';");
 		}
		stringBuilder.append("\tparameters='"+getParameters()+"';");
		if(getChangeRequest() != null ){
 			stringBuilder.append("\tchangeRequest='ChangeRequest("+getChangeRequest().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

