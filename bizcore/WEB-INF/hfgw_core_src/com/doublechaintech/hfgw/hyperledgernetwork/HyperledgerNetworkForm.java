package com.doublechaintech.hfgw.hyperledgernetwork;
import com.doublechaintech.hfgw.BaseForm;
import com.doublechaintech.hfgw.genericform.GenericForm;
import com.doublechaintech.hfgw.formfield.FormField;
import com.doublechaintech.hfgw.formaction.FormAction;
import com.doublechaintech.hfgw.formmessage.FormMessage;
import com.doublechaintech.hfgw.formfieldmessage.FormFieldMessage;



public class HyperledgerNetworkForm extends BaseForm {
	
	
	public HyperledgerNetworkForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public HyperledgerNetworkForm hyperledgerNetworkIdField(String parameterName, String initValue){
		FormField field = idFromHyperledgerNetwork(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm hyperledgerNetworkIdField(String initValue){
		return hyperledgerNetworkIdField("hyperledgerNetworkId",initValue);
	}
	public HyperledgerNetworkForm hyperledgerNetworkIdField(){
		return hyperledgerNetworkIdField("hyperledgerNetworkId","");
	}


	public HyperledgerNetworkForm nameField(String parameterName, String initValue){
		FormField field = nameFromHyperledgerNetwork(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public HyperledgerNetworkForm nameField(){
		return nameField("name","");
	}


	public HyperledgerNetworkForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromHyperledgerNetwork(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public HyperledgerNetworkForm descriptionField(){
		return descriptionField("description","");
	}

	
	

	



	public HyperledgerNetworkForm organizationIdFieldForOrganization(String parameterName, String initValue){
		FormField field =  idFromOrganization(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm organizationIdFieldForOrganization(String initValue){
		return organizationIdFieldForOrganization("organizationId",initValue);
	}
	public HyperledgerNetworkForm organizationIdFieldForOrganization(){
		return organizationIdFieldForOrganization("organizationId","");
	}


	public HyperledgerNetworkForm nameFieldForOrganization(String parameterName, String initValue){
		FormField field =  nameFromOrganization(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm nameFieldForOrganization(String initValue){
		return nameFieldForOrganization("name",initValue);
	}
	public HyperledgerNetworkForm nameFieldForOrganization(){
		return nameFieldForOrganization("name","");
	}


	public HyperledgerNetworkForm mspidFieldForOrganization(String parameterName, String initValue){
		FormField field =  mspidFromOrganization(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm mspidFieldForOrganization(String initValue){
		return mspidFieldForOrganization("mspid",initValue);
	}
	public HyperledgerNetworkForm mspidFieldForOrganization(){
		return mspidFieldForOrganization("mspid","");
	}


	public HyperledgerNetworkForm networkIdFieldForOrganization(String parameterName, String initValue){
		FormField field =  networkIdFromOrganization(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm networkIdFieldForOrganization(String initValue){
		return networkIdFieldForOrganization("networkId",initValue);
	}
	public HyperledgerNetworkForm networkIdFieldForOrganization(){
		return networkIdFieldForOrganization("networkId","");
	}


	public HyperledgerNetworkForm nodeTypeIdFieldForNodeType(String parameterName, String initValue){
		FormField field =  idFromNodeType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm nodeTypeIdFieldForNodeType(String initValue){
		return nodeTypeIdFieldForNodeType("nodeTypeId",initValue);
	}
	public HyperledgerNetworkForm nodeTypeIdFieldForNodeType(){
		return nodeTypeIdFieldForNodeType("nodeTypeId","");
	}


	public HyperledgerNetworkForm nameFieldForNodeType(String parameterName, String initValue){
		FormField field =  nameFromNodeType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm nameFieldForNodeType(String initValue){
		return nameFieldForNodeType("name",initValue);
	}
	public HyperledgerNetworkForm nameFieldForNodeType(){
		return nameFieldForNodeType("name","");
	}


	public HyperledgerNetworkForm codeFieldForNodeType(String parameterName, String initValue){
		FormField field =  codeFromNodeType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm codeFieldForNodeType(String initValue){
		return codeFieldForNodeType("code",initValue);
	}
	public HyperledgerNetworkForm codeFieldForNodeType(){
		return codeFieldForNodeType("code","");
	}


	public HyperledgerNetworkForm networkIdFieldForNodeType(String parameterName, String initValue){
		FormField field =  networkIdFromNodeType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm networkIdFieldForNodeType(String initValue){
		return networkIdFieldForNodeType("networkId",initValue);
	}
	public HyperledgerNetworkForm networkIdFieldForNodeType(){
		return networkIdFieldForNodeType("networkId","");
	}


	public HyperledgerNetworkForm addressFieldForNodeType(String parameterName, String initValue){
		FormField field =  addressFromNodeType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm addressFieldForNodeType(String initValue){
		return addressFieldForNodeType("address",initValue);
	}
	public HyperledgerNetworkForm addressFieldForNodeType(){
		return addressFieldForNodeType("address","");
	}


	public HyperledgerNetworkForm contactPersonFieldForNodeType(String parameterName, String initValue){
		FormField field =  contactPersonFromNodeType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm contactPersonFieldForNodeType(String initValue){
		return contactPersonFieldForNodeType("contactPerson",initValue);
	}
	public HyperledgerNetworkForm contactPersonFieldForNodeType(){
		return contactPersonFieldForNodeType("contactPerson","");
	}


	public HyperledgerNetworkForm contactTelephoneFieldForNodeType(String parameterName, String initValue){
		FormField field =  contactTelephoneFromNodeType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm contactTelephoneFieldForNodeType(String initValue){
		return contactTelephoneFieldForNodeType("contactTelephone",initValue);
	}
	public HyperledgerNetworkForm contactTelephoneFieldForNodeType(){
		return contactTelephoneFieldForNodeType("contactTelephone","");
	}


	public HyperledgerNetworkForm channelIdFieldForChannel(String parameterName, String initValue){
		FormField field =  idFromChannel(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm channelIdFieldForChannel(String initValue){
		return channelIdFieldForChannel("channelId",initValue);
	}
	public HyperledgerNetworkForm channelIdFieldForChannel(){
		return channelIdFieldForChannel("channelId","");
	}


	public HyperledgerNetworkForm nameFieldForChannel(String parameterName, String initValue){
		FormField field =  nameFromChannel(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm nameFieldForChannel(String initValue){
		return nameFieldForChannel("name",initValue);
	}
	public HyperledgerNetworkForm nameFieldForChannel(){
		return nameFieldForChannel("name","");
	}


	public HyperledgerNetworkForm networkIdFieldForChannel(String parameterName, String initValue){
		FormField field =  networkIdFromChannel(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm networkIdFieldForChannel(String initValue){
		return networkIdFieldForChannel("networkId",initValue);
	}
	public HyperledgerNetworkForm networkIdFieldForChannel(){
		return networkIdFieldForChannel("networkId","");
	}


	public HyperledgerNetworkForm applicationIdFieldForApplication(String parameterName, String initValue){
		FormField field =  idFromApplication(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm applicationIdFieldForApplication(String initValue){
		return applicationIdFieldForApplication("applicationId",initValue);
	}
	public HyperledgerNetworkForm applicationIdFieldForApplication(){
		return applicationIdFieldForApplication("applicationId","");
	}


	public HyperledgerNetworkForm nameFieldForApplication(String parameterName, String initValue){
		FormField field =  nameFromApplication(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm nameFieldForApplication(String initValue){
		return nameFieldForApplication("name",initValue);
	}
	public HyperledgerNetworkForm nameFieldForApplication(){
		return nameFieldForApplication("name","");
	}


	public HyperledgerNetworkForm createTimeFieldForApplication(String parameterName, String initValue){
		FormField field =  createTimeFromApplication(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm createTimeFieldForApplication(String initValue){
		return createTimeFieldForApplication("createTime",initValue);
	}
	public HyperledgerNetworkForm createTimeFieldForApplication(){
		return createTimeFieldForApplication("createTime","");
	}


	public HyperledgerNetworkForm mspidFieldForApplication(String parameterName, String initValue){
		FormField field =  mspidFromApplication(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm mspidFieldForApplication(String initValue){
		return mspidFieldForApplication("mspid",initValue);
	}
	public HyperledgerNetworkForm mspidFieldForApplication(){
		return mspidFieldForApplication("mspid","");
	}


	public HyperledgerNetworkForm publicKeyFieldForApplication(String parameterName, String initValue){
		FormField field =  publicKeyFromApplication(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm publicKeyFieldForApplication(String initValue){
		return publicKeyFieldForApplication("publicKey",initValue);
	}
	public HyperledgerNetworkForm publicKeyFieldForApplication(){
		return publicKeyFieldForApplication("publicKey","");
	}


	public HyperledgerNetworkForm privateKeyFieldForApplication(String parameterName, String initValue){
		FormField field =  privateKeyFromApplication(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm privateKeyFieldForApplication(String initValue){
		return privateKeyFieldForApplication("privateKey",initValue);
	}
	public HyperledgerNetworkForm privateKeyFieldForApplication(){
		return privateKeyFieldForApplication("privateKey","");
	}


	public HyperledgerNetworkForm channelIdFieldForApplication(String parameterName, String initValue){
		FormField field =  channelIdFromApplication(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm channelIdFieldForApplication(String initValue){
		return channelIdFieldForApplication("channelId",initValue);
	}
	public HyperledgerNetworkForm channelIdFieldForApplication(){
		return channelIdFieldForApplication("channelId","");
	}


	public HyperledgerNetworkForm networkIdFieldForApplication(String parameterName, String initValue){
		FormField field =  networkIdFromApplication(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm networkIdFieldForApplication(String initValue){
		return networkIdFieldForApplication("networkId",initValue);
	}
	public HyperledgerNetworkForm networkIdFieldForApplication(){
		return networkIdFieldForApplication("networkId","");
	}


	public HyperledgerNetworkForm serviceRecordIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  idFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm serviceRecordIdFieldForServiceRecord(String initValue){
		return serviceRecordIdFieldForServiceRecord("serviceRecordId",initValue);
	}
	public HyperledgerNetworkForm serviceRecordIdFieldForServiceRecord(){
		return serviceRecordIdFieldForServiceRecord("serviceRecordId","");
	}


	public HyperledgerNetworkForm nameFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  nameFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm nameFieldForServiceRecord(String initValue){
		return nameFieldForServiceRecord("name",initValue);
	}
	public HyperledgerNetworkForm nameFieldForServiceRecord(){
		return nameFieldForServiceRecord("name","");
	}


	public HyperledgerNetworkForm payLoadFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  payLoadFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm payLoadFieldForServiceRecord(String initValue){
		return payLoadFieldForServiceRecord("payLoad",initValue);
	}
	public HyperledgerNetworkForm payLoadFieldForServiceRecord(){
		return payLoadFieldForServiceRecord("payLoad","");
	}


	public HyperledgerNetworkForm channelIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  channelIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm channelIdFieldForServiceRecord(String initValue){
		return channelIdFieldForServiceRecord("channelId",initValue);
	}
	public HyperledgerNetworkForm channelIdFieldForServiceRecord(){
		return channelIdFieldForServiceRecord("channelId","");
	}


	public HyperledgerNetworkForm chainCodeIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  chainCodeIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm chainCodeIdFieldForServiceRecord(String initValue){
		return chainCodeIdFieldForServiceRecord("chainCodeId",initValue);
	}
	public HyperledgerNetworkForm chainCodeIdFieldForServiceRecord(){
		return chainCodeIdFieldForServiceRecord("chainCodeId","");
	}


	public HyperledgerNetworkForm transactionIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  transactionIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm transactionIdFieldForServiceRecord(String initValue){
		return transactionIdFieldForServiceRecord("transactionId",initValue);
	}
	public HyperledgerNetworkForm transactionIdFieldForServiceRecord(){
		return transactionIdFieldForServiceRecord("transactionId","");
	}


	public HyperledgerNetworkForm blockIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  blockIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm blockIdFieldForServiceRecord(String initValue){
		return blockIdFieldForServiceRecord("blockId",initValue);
	}
	public HyperledgerNetworkForm blockIdFieldForServiceRecord(){
		return blockIdFieldForServiceRecord("blockId","");
	}


	public HyperledgerNetworkForm createTimeFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  createTimeFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm createTimeFieldForServiceRecord(String initValue){
		return createTimeFieldForServiceRecord("createTime",initValue);
	}
	public HyperledgerNetworkForm createTimeFieldForServiceRecord(){
		return createTimeFieldForServiceRecord("createTime","");
	}


	public HyperledgerNetworkForm applicationIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  applicationIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm applicationIdFieldForServiceRecord(String initValue){
		return applicationIdFieldForServiceRecord("applicationId",initValue);
	}
	public HyperledgerNetworkForm applicationIdFieldForServiceRecord(){
		return applicationIdFieldForServiceRecord("applicationId","");
	}


	public HyperledgerNetworkForm networkIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  networkIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm networkIdFieldForServiceRecord(String initValue){
		return networkIdFieldForServiceRecord("networkId",initValue);
	}
	public HyperledgerNetworkForm networkIdFieldForServiceRecord(){
		return networkIdFieldForServiceRecord("networkId","");
	}


	public HyperledgerNetworkForm currentStatusFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  currentStatusFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm currentStatusFieldForServiceRecord(String initValue){
		return currentStatusFieldForServiceRecord("currentStatus",initValue);
	}
	public HyperledgerNetworkForm currentStatusFieldForServiceRecord(){
		return currentStatusFieldForServiceRecord("currentStatus","");
	}


	public HyperledgerNetworkForm changeRequestTypeIdFieldForChangeRequestType(String parameterName, String initValue){
		FormField field =  idFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm changeRequestTypeIdFieldForChangeRequestType(String initValue){
		return changeRequestTypeIdFieldForChangeRequestType("changeRequestTypeId",initValue);
	}
	public HyperledgerNetworkForm changeRequestTypeIdFieldForChangeRequestType(){
		return changeRequestTypeIdFieldForChangeRequestType("changeRequestTypeId","");
	}


	public HyperledgerNetworkForm nameFieldForChangeRequestType(String parameterName, String initValue){
		FormField field =  nameFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm nameFieldForChangeRequestType(String initValue){
		return nameFieldForChangeRequestType("name",initValue);
	}
	public HyperledgerNetworkForm nameFieldForChangeRequestType(){
		return nameFieldForChangeRequestType("name","");
	}


	public HyperledgerNetworkForm codeFieldForChangeRequestType(String parameterName, String initValue){
		FormField field =  codeFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm codeFieldForChangeRequestType(String initValue){
		return codeFieldForChangeRequestType("code",initValue);
	}
	public HyperledgerNetworkForm codeFieldForChangeRequestType(){
		return codeFieldForChangeRequestType("code","");
	}


	public HyperledgerNetworkForm iconFieldForChangeRequestType(String parameterName, String initValue){
		FormField field =  iconFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm iconFieldForChangeRequestType(String initValue){
		return iconFieldForChangeRequestType("icon",initValue);
	}
	public HyperledgerNetworkForm iconFieldForChangeRequestType(){
		return iconFieldForChangeRequestType("icon","");
	}


	public HyperledgerNetworkForm displayOrderFieldForChangeRequestType(String parameterName, String initValue){
		FormField field =  displayOrderFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm displayOrderFieldForChangeRequestType(String initValue){
		return displayOrderFieldForChangeRequestType("displayOrder",initValue);
	}
	public HyperledgerNetworkForm displayOrderFieldForChangeRequestType(){
		return displayOrderFieldForChangeRequestType("displayOrder","");
	}


	public HyperledgerNetworkForm bindTypesFieldForChangeRequestType(String parameterName, String initValue){
		FormField field =  bindTypesFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm bindTypesFieldForChangeRequestType(String initValue){
		return bindTypesFieldForChangeRequestType("bindTypes",initValue);
	}
	public HyperledgerNetworkForm bindTypesFieldForChangeRequestType(){
		return bindTypesFieldForChangeRequestType("bindTypes","");
	}


	public HyperledgerNetworkForm stepConfigurationFieldForChangeRequestType(String parameterName, String initValue){
		FormField field =  stepConfigurationFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm stepConfigurationFieldForChangeRequestType(String initValue){
		return stepConfigurationFieldForChangeRequestType("stepConfiguration",initValue);
	}
	public HyperledgerNetworkForm stepConfigurationFieldForChangeRequestType(){
		return stepConfigurationFieldForChangeRequestType("stepConfiguration","");
	}


	public HyperledgerNetworkForm networkIdFieldForChangeRequestType(String parameterName, String initValue){
		FormField field =  networkIdFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm networkIdFieldForChangeRequestType(String initValue){
		return networkIdFieldForChangeRequestType("networkId",initValue);
	}
	public HyperledgerNetworkForm networkIdFieldForChangeRequestType(){
		return networkIdFieldForChangeRequestType("networkId","");
	}


	public HyperledgerNetworkForm changeRequestIdFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  idFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm changeRequestIdFieldForChangeRequest(String initValue){
		return changeRequestIdFieldForChangeRequest("changeRequestId",initValue);
	}
	public HyperledgerNetworkForm changeRequestIdFieldForChangeRequest(){
		return changeRequestIdFieldForChangeRequest("changeRequestId","");
	}


	public HyperledgerNetworkForm nameFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  nameFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm nameFieldForChangeRequest(String initValue){
		return nameFieldForChangeRequest("name",initValue);
	}
	public HyperledgerNetworkForm nameFieldForChangeRequest(){
		return nameFieldForChangeRequest("name","");
	}


	public HyperledgerNetworkForm createTimeFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  createTimeFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm createTimeFieldForChangeRequest(String initValue){
		return createTimeFieldForChangeRequest("createTime",initValue);
	}
	public HyperledgerNetworkForm createTimeFieldForChangeRequest(){
		return createTimeFieldForChangeRequest("createTime","");
	}


	public HyperledgerNetworkForm remoteIpFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  remoteIpFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm remoteIpFieldForChangeRequest(String initValue){
		return remoteIpFieldForChangeRequest("remoteIp",initValue);
	}
	public HyperledgerNetworkForm remoteIpFieldForChangeRequest(){
		return remoteIpFieldForChangeRequest("remoteIp","");
	}


	public HyperledgerNetworkForm requestTypeIdFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  requestTypeIdFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm requestTypeIdFieldForChangeRequest(String initValue){
		return requestTypeIdFieldForChangeRequest("requestTypeId",initValue);
	}
	public HyperledgerNetworkForm requestTypeIdFieldForChangeRequest(){
		return requestTypeIdFieldForChangeRequest("requestTypeId","");
	}


	public HyperledgerNetworkForm networkIdFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  networkIdFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm networkIdFieldForChangeRequest(String initValue){
		return networkIdFieldForChangeRequest("networkId",initValue);
	}
	public HyperledgerNetworkForm networkIdFieldForChangeRequest(){
		return networkIdFieldForChangeRequest("networkId","");
	}

	



	public HyperledgerNetworkForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


