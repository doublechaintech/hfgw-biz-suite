package com.doublechaintech.hfgw.application;
import com.doublechaintech.hfgw.BaseForm;
import com.doublechaintech.hfgw.genericform.GenericForm;
import com.doublechaintech.hfgw.formfield.FormField;
import com.doublechaintech.hfgw.formaction.FormAction;
import com.doublechaintech.hfgw.formmessage.FormMessage;
import com.doublechaintech.hfgw.formfieldmessage.FormFieldMessage;



public class ApplicationForm extends BaseForm {
	
	
	public ApplicationForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ApplicationForm applicationIdField(String parameterName, String initValue){
		FormField field = idFromApplication(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ApplicationForm applicationIdField(String initValue){
		return applicationIdField("applicationId",initValue);
	}
	public ApplicationForm applicationIdField(){
		return applicationIdField("applicationId","");
	}


	public ApplicationForm nameField(String parameterName, String initValue){
		FormField field = nameFromApplication(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ApplicationForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ApplicationForm nameField(){
		return nameField("name","");
	}


	public ApplicationForm createTimeField(String parameterName, String initValue){
		FormField field = createTimeFromApplication(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ApplicationForm createTimeField(String initValue){
		return createTimeField("createTime",initValue);
	}
	public ApplicationForm createTimeField(){
		return createTimeField("createTime","");
	}


	public ApplicationForm mspidField(String parameterName, String initValue){
		FormField field = mspidFromApplication(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ApplicationForm mspidField(String initValue){
		return mspidField("mspid",initValue);
	}
	public ApplicationForm mspidField(){
		return mspidField("mspid","");
	}


	public ApplicationForm publicKeyField(String parameterName, String initValue){
		FormField field = publicKeyFromApplication(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ApplicationForm publicKeyField(String initValue){
		return publicKeyField("publicKey",initValue);
	}
	public ApplicationForm publicKeyField(){
		return publicKeyField("publicKey","");
	}


	public ApplicationForm privateKeyField(String parameterName, String initValue){
		FormField field = privateKeyFromApplication(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ApplicationForm privateKeyField(String initValue){
		return privateKeyField("privateKey",initValue);
	}
	public ApplicationForm privateKeyField(){
		return privateKeyField("privateKey","");
	}


	public ApplicationForm channelIdField(String parameterName, String initValue){
		FormField field = channelIdFromApplication(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ApplicationForm channelIdField(String initValue){
		return channelIdField("channelId",initValue);
	}
	public ApplicationForm channelIdField(){
		return channelIdField("channelId","");
	}


	public ApplicationForm networkIdField(String parameterName, String initValue){
		FormField field = networkIdFromApplication(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ApplicationForm networkIdField(String initValue){
		return networkIdField("networkId",initValue);
	}
	public ApplicationForm networkIdField(){
		return networkIdField("networkId","");
	}

	
	


	public ApplicationForm channelIdFieldOfChannel(String parameterName, String initValue){
		FormField field =  idFromChannel(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ApplicationForm channelIdFieldOfChannel(String initValue){
		return channelIdFieldOfChannel("channelId",initValue);
	}
	public ApplicationForm channelIdFieldOfChannel(){
		return channelIdFieldOfChannel("channelId","");
	}


	public ApplicationForm nameFieldOfChannel(String parameterName, String initValue){
		FormField field =  nameFromChannel(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ApplicationForm nameFieldOfChannel(String initValue){
		return nameFieldOfChannel("name",initValue);
	}
	public ApplicationForm nameFieldOfChannel(){
		return nameFieldOfChannel("name","");
	}


	public ApplicationForm networkIdFieldOfChannel(String parameterName, String initValue){
		FormField field =  networkIdFromChannel(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ApplicationForm networkIdFieldOfChannel(String initValue){
		return networkIdFieldOfChannel("networkId",initValue);
	}
	public ApplicationForm networkIdFieldOfChannel(){
		return networkIdFieldOfChannel("networkId","");
	}


	public ApplicationForm hyperledgerNetworkIdFieldOfHyperledgerNetwork(String parameterName, String initValue){
		FormField field =  idFromHyperledgerNetwork(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ApplicationForm hyperledgerNetworkIdFieldOfHyperledgerNetwork(String initValue){
		return hyperledgerNetworkIdFieldOfHyperledgerNetwork("hyperledgerNetworkId",initValue);
	}
	public ApplicationForm hyperledgerNetworkIdFieldOfHyperledgerNetwork(){
		return hyperledgerNetworkIdFieldOfHyperledgerNetwork("hyperledgerNetworkId","");
	}


	public ApplicationForm nameFieldOfHyperledgerNetwork(String parameterName, String initValue){
		FormField field =  nameFromHyperledgerNetwork(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ApplicationForm nameFieldOfHyperledgerNetwork(String initValue){
		return nameFieldOfHyperledgerNetwork("name",initValue);
	}
	public ApplicationForm nameFieldOfHyperledgerNetwork(){
		return nameFieldOfHyperledgerNetwork("name","");
	}


	public ApplicationForm descriptionFieldOfHyperledgerNetwork(String parameterName, String initValue){
		FormField field =  descriptionFromHyperledgerNetwork(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ApplicationForm descriptionFieldOfHyperledgerNetwork(String initValue){
		return descriptionFieldOfHyperledgerNetwork("description",initValue);
	}
	public ApplicationForm descriptionFieldOfHyperledgerNetwork(){
		return descriptionFieldOfHyperledgerNetwork("description","");
	}

	



	public ApplicationForm serviceRecordIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  idFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ApplicationForm serviceRecordIdFieldForServiceRecord(String initValue){
		return serviceRecordIdFieldForServiceRecord("serviceRecordId",initValue);
	}
	public ApplicationForm serviceRecordIdFieldForServiceRecord(){
		return serviceRecordIdFieldForServiceRecord("serviceRecordId","");
	}


	public ApplicationForm nameFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  nameFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ApplicationForm nameFieldForServiceRecord(String initValue){
		return nameFieldForServiceRecord("name",initValue);
	}
	public ApplicationForm nameFieldForServiceRecord(){
		return nameFieldForServiceRecord("name","");
	}


	public ApplicationForm payLoadFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  payLoadFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ApplicationForm payLoadFieldForServiceRecord(String initValue){
		return payLoadFieldForServiceRecord("payLoad",initValue);
	}
	public ApplicationForm payLoadFieldForServiceRecord(){
		return payLoadFieldForServiceRecord("payLoad","");
	}


	public ApplicationForm channelIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  channelIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ApplicationForm channelIdFieldForServiceRecord(String initValue){
		return channelIdFieldForServiceRecord("channelId",initValue);
	}
	public ApplicationForm channelIdFieldForServiceRecord(){
		return channelIdFieldForServiceRecord("channelId","");
	}


	public ApplicationForm chainCodeIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  chainCodeIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ApplicationForm chainCodeIdFieldForServiceRecord(String initValue){
		return chainCodeIdFieldForServiceRecord("chainCodeId",initValue);
	}
	public ApplicationForm chainCodeIdFieldForServiceRecord(){
		return chainCodeIdFieldForServiceRecord("chainCodeId","");
	}


	public ApplicationForm chainCodeFunctionFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  chainCodeFunctionFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ApplicationForm chainCodeFunctionFieldForServiceRecord(String initValue){
		return chainCodeFunctionFieldForServiceRecord("chainCodeFunction",initValue);
	}
	public ApplicationForm chainCodeFunctionFieldForServiceRecord(){
		return chainCodeFunctionFieldForServiceRecord("chainCodeFunction","");
	}


	public ApplicationForm transactionIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  transactionIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ApplicationForm transactionIdFieldForServiceRecord(String initValue){
		return transactionIdFieldForServiceRecord("transactionId",initValue);
	}
	public ApplicationForm transactionIdFieldForServiceRecord(){
		return transactionIdFieldForServiceRecord("transactionId","");
	}


	public ApplicationForm blockIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  blockIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ApplicationForm blockIdFieldForServiceRecord(String initValue){
		return blockIdFieldForServiceRecord("blockId",initValue);
	}
	public ApplicationForm blockIdFieldForServiceRecord(){
		return blockIdFieldForServiceRecord("blockId","");
	}


	public ApplicationForm createTimeFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  createTimeFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ApplicationForm createTimeFieldForServiceRecord(String initValue){
		return createTimeFieldForServiceRecord("createTime",initValue);
	}
	public ApplicationForm createTimeFieldForServiceRecord(){
		return createTimeFieldForServiceRecord("createTime","");
	}


	public ApplicationForm applicationIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  applicationIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ApplicationForm applicationIdFieldForServiceRecord(String initValue){
		return applicationIdFieldForServiceRecord("applicationId",initValue);
	}
	public ApplicationForm applicationIdFieldForServiceRecord(){
		return applicationIdFieldForServiceRecord("applicationId","");
	}


	public ApplicationForm networkIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  networkIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ApplicationForm networkIdFieldForServiceRecord(String initValue){
		return networkIdFieldForServiceRecord("networkId",initValue);
	}
	public ApplicationForm networkIdFieldForServiceRecord(){
		return networkIdFieldForServiceRecord("networkId","");
	}


	public ApplicationForm currentStatusFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  currentStatusFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ApplicationForm currentStatusFieldForServiceRecord(String initValue){
		return currentStatusFieldForServiceRecord("currentStatus",initValue);
	}
	public ApplicationForm currentStatusFieldForServiceRecord(){
		return currentStatusFieldForServiceRecord("currentStatus","");
	}

	

	
 	public ApplicationForm transferToAnotherChannelAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherChannel/applicationId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public ApplicationForm transferToAnotherNetworkAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherNetwork/applicationId/");
		this.addFormAction(action);
		return this;
	}

 

	public ApplicationForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


