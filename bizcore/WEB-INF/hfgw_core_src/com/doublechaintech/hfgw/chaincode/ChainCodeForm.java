package com.doublechaintech.hfgw.chaincode;
import com.doublechaintech.hfgw.BaseForm;
import com.doublechaintech.hfgw.genericform.GenericForm;
import com.doublechaintech.hfgw.formfield.FormField;
import com.doublechaintech.hfgw.formaction.FormAction;
import com.doublechaintech.hfgw.formmessage.FormMessage;
import com.doublechaintech.hfgw.formfieldmessage.FormFieldMessage;



public class ChainCodeForm extends BaseForm {
	
	
	public ChainCodeForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ChainCodeForm chainCodeIdField(String parameterName, String initValue){
		FormField field = idFromChainCode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChainCodeForm chainCodeIdField(String initValue){
		return chainCodeIdField("chainCodeId",initValue);
	}
	public ChainCodeForm chainCodeIdField(){
		return chainCodeIdField("chainCodeId","");
	}


	public ChainCodeForm nameField(String parameterName, String initValue){
		FormField field = nameFromChainCode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChainCodeForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ChainCodeForm nameField(){
		return nameField("name","");
	}


	public ChainCodeForm codeNameField(String parameterName, String initValue){
		FormField field = codeNameFromChainCode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChainCodeForm codeNameField(String initValue){
		return codeNameField("codeName",initValue);
	}
	public ChainCodeForm codeNameField(){
		return codeNameField("codeName","");
	}


	public ChainCodeForm codeVersionField(String parameterName, String initValue){
		FormField field = codeVersionFromChainCode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChainCodeForm codeVersionField(String initValue){
		return codeVersionField("codeVersion",initValue);
	}
	public ChainCodeForm codeVersionField(){
		return codeVersionField("codeVersion","");
	}


	public ChainCodeForm channelIdField(String parameterName, String initValue){
		FormField field = channelIdFromChainCode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChainCodeForm channelIdField(String initValue){
		return channelIdField("channelId",initValue);
	}
	public ChainCodeForm channelIdField(){
		return channelIdField("channelId","");
	}

	
	


	public ChainCodeForm channelIdFieldOfChannel(String parameterName, String initValue){
		FormField field =  idFromChannel(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChainCodeForm channelIdFieldOfChannel(String initValue){
		return channelIdFieldOfChannel("channelId",initValue);
	}
	public ChainCodeForm channelIdFieldOfChannel(){
		return channelIdFieldOfChannel("channelId","");
	}


	public ChainCodeForm nameFieldOfChannel(String parameterName, String initValue){
		FormField field =  nameFromChannel(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChainCodeForm nameFieldOfChannel(String initValue){
		return nameFieldOfChannel("name",initValue);
	}
	public ChainCodeForm nameFieldOfChannel(){
		return nameFieldOfChannel("name","");
	}


	public ChainCodeForm networkIdFieldOfChannel(String parameterName, String initValue){
		FormField field =  networkIdFromChannel(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChainCodeForm networkIdFieldOfChannel(String initValue){
		return networkIdFieldOfChannel("networkId",initValue);
	}
	public ChainCodeForm networkIdFieldOfChannel(){
		return networkIdFieldOfChannel("networkId","");
	}

	



	public ChainCodeForm serviceRecordIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  idFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChainCodeForm serviceRecordIdFieldForServiceRecord(String initValue){
		return serviceRecordIdFieldForServiceRecord("serviceRecordId",initValue);
	}
	public ChainCodeForm serviceRecordIdFieldForServiceRecord(){
		return serviceRecordIdFieldForServiceRecord("serviceRecordId","");
	}


	public ChainCodeForm nameFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  nameFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChainCodeForm nameFieldForServiceRecord(String initValue){
		return nameFieldForServiceRecord("name",initValue);
	}
	public ChainCodeForm nameFieldForServiceRecord(){
		return nameFieldForServiceRecord("name","");
	}


	public ChainCodeForm payloadFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  payloadFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChainCodeForm payloadFieldForServiceRecord(String initValue){
		return payloadFieldForServiceRecord("payload",initValue);
	}
	public ChainCodeForm payloadFieldForServiceRecord(){
		return payloadFieldForServiceRecord("payload","");
	}


	public ChainCodeForm channelIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  channelIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChainCodeForm channelIdFieldForServiceRecord(String initValue){
		return channelIdFieldForServiceRecord("channelId",initValue);
	}
	public ChainCodeForm channelIdFieldForServiceRecord(){
		return channelIdFieldForServiceRecord("channelId","");
	}


	public ChainCodeForm chainCodeIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  chainCodeIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChainCodeForm chainCodeIdFieldForServiceRecord(String initValue){
		return chainCodeIdFieldForServiceRecord("chainCodeId",initValue);
	}
	public ChainCodeForm chainCodeIdFieldForServiceRecord(){
		return chainCodeIdFieldForServiceRecord("chainCodeId","");
	}


	public ChainCodeForm chainCodeFunctionFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  chainCodeFunctionFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChainCodeForm chainCodeFunctionFieldForServiceRecord(String initValue){
		return chainCodeFunctionFieldForServiceRecord("chainCodeFunction",initValue);
	}
	public ChainCodeForm chainCodeFunctionFieldForServiceRecord(){
		return chainCodeFunctionFieldForServiceRecord("chainCodeFunction","");
	}


	public ChainCodeForm transactionIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  transactionIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChainCodeForm transactionIdFieldForServiceRecord(String initValue){
		return transactionIdFieldForServiceRecord("transactionId",initValue);
	}
	public ChainCodeForm transactionIdFieldForServiceRecord(){
		return transactionIdFieldForServiceRecord("transactionId","");
	}


	public ChainCodeForm blockIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  blockIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChainCodeForm blockIdFieldForServiceRecord(String initValue){
		return blockIdFieldForServiceRecord("blockId",initValue);
	}
	public ChainCodeForm blockIdFieldForServiceRecord(){
		return blockIdFieldForServiceRecord("blockId","");
	}


	public ChainCodeForm createTimeFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  createTimeFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChainCodeForm createTimeFieldForServiceRecord(String initValue){
		return createTimeFieldForServiceRecord("createTime",initValue);
	}
	public ChainCodeForm createTimeFieldForServiceRecord(){
		return createTimeFieldForServiceRecord("createTime","");
	}


	public ChainCodeForm appClientIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  appClientIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChainCodeForm appClientIdFieldForServiceRecord(String initValue){
		return appClientIdFieldForServiceRecord("appClientId",initValue);
	}
	public ChainCodeForm appClientIdFieldForServiceRecord(){
		return appClientIdFieldForServiceRecord("appClientId","");
	}


	public ChainCodeForm networkIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  networkIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChainCodeForm networkIdFieldForServiceRecord(String initValue){
		return networkIdFieldForServiceRecord("networkId",initValue);
	}
	public ChainCodeForm networkIdFieldForServiceRecord(){
		return networkIdFieldForServiceRecord("networkId","");
	}


	public ChainCodeForm responseFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  responseFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChainCodeForm responseFieldForServiceRecord(String initValue){
		return responseFieldForServiceRecord("response",initValue);
	}
	public ChainCodeForm responseFieldForServiceRecord(){
		return responseFieldForServiceRecord("response","");
	}


	public ChainCodeForm statusIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  statusIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChainCodeForm statusIdFieldForServiceRecord(String initValue){
		return statusIdFieldForServiceRecord("statusId",initValue);
	}
	public ChainCodeForm statusIdFieldForServiceRecord(){
		return statusIdFieldForServiceRecord("statusId","");
	}

	

	
 	public ChainCodeForm transferToAnotherChannelAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherChannel/chainCodeId/");
		this.addFormAction(action);
		return this;
	}

 

	public ChainCodeForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


