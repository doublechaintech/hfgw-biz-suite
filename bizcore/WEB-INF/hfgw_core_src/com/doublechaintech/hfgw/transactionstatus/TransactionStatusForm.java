package com.doublechaintech.hfgw.transactionstatus;
import com.doublechaintech.hfgw.BaseForm;
import com.doublechaintech.hfgw.genericform.GenericForm;
import com.doublechaintech.hfgw.formfield.FormField;
import com.doublechaintech.hfgw.formaction.FormAction;
import com.doublechaintech.hfgw.formmessage.FormMessage;
import com.doublechaintech.hfgw.formfieldmessage.FormFieldMessage;



public class TransactionStatusForm extends BaseForm {
	
	
	public TransactionStatusForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public TransactionStatusForm transactionStatusIdField(String parameterName, String initValue){
		FormField field = idFromTransactionStatus(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionStatusForm transactionStatusIdField(String initValue){
		return transactionStatusIdField("transactionStatusId",initValue);
	}
	public TransactionStatusForm transactionStatusIdField(){
		return transactionStatusIdField("transactionStatusId","");
	}


	public TransactionStatusForm nameField(String parameterName, String initValue){
		FormField field = nameFromTransactionStatus(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionStatusForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public TransactionStatusForm nameField(){
		return nameField("name","");
	}


	public TransactionStatusForm codeField(String parameterName, String initValue){
		FormField field = codeFromTransactionStatus(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionStatusForm codeField(String initValue){
		return codeField("code",initValue);
	}
	public TransactionStatusForm codeField(){
		return codeField("code","");
	}


	public TransactionStatusForm networkIdField(String parameterName, String initValue){
		FormField field = networkIdFromTransactionStatus(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionStatusForm networkIdField(String initValue){
		return networkIdField("networkId",initValue);
	}
	public TransactionStatusForm networkIdField(){
		return networkIdField("networkId","");
	}

	
	


	public TransactionStatusForm hyperledgerNetworkIdFieldOfHyperledgerNetwork(String parameterName, String initValue){
		FormField field =  idFromHyperledgerNetwork(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransactionStatusForm hyperledgerNetworkIdFieldOfHyperledgerNetwork(String initValue){
		return hyperledgerNetworkIdFieldOfHyperledgerNetwork("hyperledgerNetworkId",initValue);
	}
	public TransactionStatusForm hyperledgerNetworkIdFieldOfHyperledgerNetwork(){
		return hyperledgerNetworkIdFieldOfHyperledgerNetwork("hyperledgerNetworkId","");
	}


	public TransactionStatusForm nameFieldOfHyperledgerNetwork(String parameterName, String initValue){
		FormField field =  nameFromHyperledgerNetwork(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransactionStatusForm nameFieldOfHyperledgerNetwork(String initValue){
		return nameFieldOfHyperledgerNetwork("name",initValue);
	}
	public TransactionStatusForm nameFieldOfHyperledgerNetwork(){
		return nameFieldOfHyperledgerNetwork("name","");
	}


	public TransactionStatusForm descriptionFieldOfHyperledgerNetwork(String parameterName, String initValue){
		FormField field =  descriptionFromHyperledgerNetwork(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransactionStatusForm descriptionFieldOfHyperledgerNetwork(String initValue){
		return descriptionFieldOfHyperledgerNetwork("description",initValue);
	}
	public TransactionStatusForm descriptionFieldOfHyperledgerNetwork(){
		return descriptionFieldOfHyperledgerNetwork("description","");
	}

	



	public TransactionStatusForm serviceRecordIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  idFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionStatusForm serviceRecordIdFieldForServiceRecord(String initValue){
		return serviceRecordIdFieldForServiceRecord("serviceRecordId",initValue);
	}
	public TransactionStatusForm serviceRecordIdFieldForServiceRecord(){
		return serviceRecordIdFieldForServiceRecord("serviceRecordId","");
	}


	public TransactionStatusForm nameFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  nameFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionStatusForm nameFieldForServiceRecord(String initValue){
		return nameFieldForServiceRecord("name",initValue);
	}
	public TransactionStatusForm nameFieldForServiceRecord(){
		return nameFieldForServiceRecord("name","");
	}


	public TransactionStatusForm payloadFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  payloadFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionStatusForm payloadFieldForServiceRecord(String initValue){
		return payloadFieldForServiceRecord("payload",initValue);
	}
	public TransactionStatusForm payloadFieldForServiceRecord(){
		return payloadFieldForServiceRecord("payload","");
	}


	public TransactionStatusForm channelIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  channelIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionStatusForm channelIdFieldForServiceRecord(String initValue){
		return channelIdFieldForServiceRecord("channelId",initValue);
	}
	public TransactionStatusForm channelIdFieldForServiceRecord(){
		return channelIdFieldForServiceRecord("channelId","");
	}


	public TransactionStatusForm chainCodeIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  chainCodeIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionStatusForm chainCodeIdFieldForServiceRecord(String initValue){
		return chainCodeIdFieldForServiceRecord("chainCodeId",initValue);
	}
	public TransactionStatusForm chainCodeIdFieldForServiceRecord(){
		return chainCodeIdFieldForServiceRecord("chainCodeId","");
	}


	public TransactionStatusForm chainCodeFunctionFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  chainCodeFunctionFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionStatusForm chainCodeFunctionFieldForServiceRecord(String initValue){
		return chainCodeFunctionFieldForServiceRecord("chainCodeFunction",initValue);
	}
	public TransactionStatusForm chainCodeFunctionFieldForServiceRecord(){
		return chainCodeFunctionFieldForServiceRecord("chainCodeFunction","");
	}


	public TransactionStatusForm transactionIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  transactionIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionStatusForm transactionIdFieldForServiceRecord(String initValue){
		return transactionIdFieldForServiceRecord("transactionId",initValue);
	}
	public TransactionStatusForm transactionIdFieldForServiceRecord(){
		return transactionIdFieldForServiceRecord("transactionId","");
	}


	public TransactionStatusForm blockIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  blockIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionStatusForm blockIdFieldForServiceRecord(String initValue){
		return blockIdFieldForServiceRecord("blockId",initValue);
	}
	public TransactionStatusForm blockIdFieldForServiceRecord(){
		return blockIdFieldForServiceRecord("blockId","");
	}


	public TransactionStatusForm createTimeFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  createTimeFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionStatusForm createTimeFieldForServiceRecord(String initValue){
		return createTimeFieldForServiceRecord("createTime",initValue);
	}
	public TransactionStatusForm createTimeFieldForServiceRecord(){
		return createTimeFieldForServiceRecord("createTime","");
	}


	public TransactionStatusForm appClientIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  appClientIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionStatusForm appClientIdFieldForServiceRecord(String initValue){
		return appClientIdFieldForServiceRecord("appClientId",initValue);
	}
	public TransactionStatusForm appClientIdFieldForServiceRecord(){
		return appClientIdFieldForServiceRecord("appClientId","");
	}


	public TransactionStatusForm networkIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  networkIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionStatusForm networkIdFieldForServiceRecord(String initValue){
		return networkIdFieldForServiceRecord("networkId",initValue);
	}
	public TransactionStatusForm networkIdFieldForServiceRecord(){
		return networkIdFieldForServiceRecord("networkId","");
	}


	public TransactionStatusForm responseFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  responseFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionStatusForm responseFieldForServiceRecord(String initValue){
		return responseFieldForServiceRecord("response",initValue);
	}
	public TransactionStatusForm responseFieldForServiceRecord(){
		return responseFieldForServiceRecord("response","");
	}


	public TransactionStatusForm statusIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  statusIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransactionStatusForm statusIdFieldForServiceRecord(String initValue){
		return statusIdFieldForServiceRecord("statusId",initValue);
	}
	public TransactionStatusForm statusIdFieldForServiceRecord(){
		return statusIdFieldForServiceRecord("statusId","");
	}

	

	
 	public TransactionStatusForm transferToAnotherNetworkAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherNetwork/transactionStatusId/");
		this.addFormAction(action);
		return this;
	}

 

	public TransactionStatusForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


