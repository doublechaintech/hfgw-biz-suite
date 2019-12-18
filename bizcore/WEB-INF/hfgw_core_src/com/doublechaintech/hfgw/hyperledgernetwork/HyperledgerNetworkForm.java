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


	public HyperledgerNetworkForm nodeIdFieldForNode(String parameterName, String initValue){
		FormField field =  idFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm nodeIdFieldForNode(String initValue){
		return nodeIdFieldForNode("nodeId",initValue);
	}
	public HyperledgerNetworkForm nodeIdFieldForNode(){
		return nodeIdFieldForNode("nodeId","");
	}


	public HyperledgerNetworkForm nameFieldForNode(String parameterName, String initValue){
		FormField field =  nameFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm nameFieldForNode(String initValue){
		return nameFieldForNode("name",initValue);
	}
	public HyperledgerNetworkForm nameFieldForNode(){
		return nameFieldForNode("name","");
	}


	public HyperledgerNetworkForm urlFieldForNode(String parameterName, String initValue){
		FormField field =  urlFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm urlFieldForNode(String initValue){
		return urlFieldForNode("url",initValue);
	}
	public HyperledgerNetworkForm urlFieldForNode(){
		return urlFieldForNode("url","");
	}


	public HyperledgerNetworkForm organizationIdFieldForNode(String parameterName, String initValue){
		FormField field =  organizationIdFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm organizationIdFieldForNode(String initValue){
		return organizationIdFieldForNode("organizationId",initValue);
	}
	public HyperledgerNetworkForm organizationIdFieldForNode(){
		return organizationIdFieldForNode("organizationId","");
	}


	public HyperledgerNetworkForm channelIdFieldForNode(String parameterName, String initValue){
		FormField field =  channelIdFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm channelIdFieldForNode(String initValue){
		return channelIdFieldForNode("channelId",initValue);
	}
	public HyperledgerNetworkForm channelIdFieldForNode(){
		return channelIdFieldForNode("channelId","");
	}


	public HyperledgerNetworkForm networkIdFieldForNode(String parameterName, String initValue){
		FormField field =  networkIdFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm networkIdFieldForNode(String initValue){
		return networkIdFieldForNode("networkId",initValue);
	}
	public HyperledgerNetworkForm networkIdFieldForNode(){
		return networkIdFieldForNode("networkId","");
	}


	public HyperledgerNetworkForm tlsCacertFieldForNode(String parameterName, String initValue){
		FormField field =  tlsCacertFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm tlsCacertFieldForNode(String initValue){
		return tlsCacertFieldForNode("tlsCacert",initValue);
	}
	public HyperledgerNetworkForm tlsCacertFieldForNode(){
		return tlsCacertFieldForNode("tlsCacert","");
	}


	public HyperledgerNetworkForm typeIdFieldForNode(String parameterName, String initValue){
		FormField field =  typeIdFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm typeIdFieldForNode(String initValue){
		return typeIdFieldForNode("typeId",initValue);
	}
	public HyperledgerNetworkForm typeIdFieldForNode(){
		return typeIdFieldForNode("typeId","");
	}


	public HyperledgerNetworkForm addressFieldForNode(String parameterName, String initValue){
		FormField field =  addressFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm addressFieldForNode(String initValue){
		return addressFieldForNode("address",initValue);
	}
	public HyperledgerNetworkForm addressFieldForNode(){
		return addressFieldForNode("address","");
	}


	public HyperledgerNetworkForm contactPersonFieldForNode(String parameterName, String initValue){
		FormField field =  contactPersonFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm contactPersonFieldForNode(String initValue){
		return contactPersonFieldForNode("contactPerson",initValue);
	}
	public HyperledgerNetworkForm contactPersonFieldForNode(){
		return contactPersonFieldForNode("contactPerson","");
	}


	public HyperledgerNetworkForm contactTelephoneFieldForNode(String parameterName, String initValue){
		FormField field =  contactTelephoneFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm contactTelephoneFieldForNode(String initValue){
		return contactTelephoneFieldForNode("contactTelephone",initValue);
	}
	public HyperledgerNetworkForm contactTelephoneFieldForNode(){
		return contactTelephoneFieldForNode("contactTelephone","");
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


	public HyperledgerNetworkForm peerRoleIdFieldForPeerRole(String parameterName, String initValue){
		FormField field =  idFromPeerRole(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm peerRoleIdFieldForPeerRole(String initValue){
		return peerRoleIdFieldForPeerRole("peerRoleId",initValue);
	}
	public HyperledgerNetworkForm peerRoleIdFieldForPeerRole(){
		return peerRoleIdFieldForPeerRole("peerRoleId","");
	}


	public HyperledgerNetworkForm nameFieldForPeerRole(String parameterName, String initValue){
		FormField field =  nameFromPeerRole(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm nameFieldForPeerRole(String initValue){
		return nameFieldForPeerRole("name",initValue);
	}
	public HyperledgerNetworkForm nameFieldForPeerRole(){
		return nameFieldForPeerRole("name","");
	}


	public HyperledgerNetworkForm codeFieldForPeerRole(String parameterName, String initValue){
		FormField field =  codeFromPeerRole(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm codeFieldForPeerRole(String initValue){
		return codeFieldForPeerRole("code",initValue);
	}
	public HyperledgerNetworkForm codeFieldForPeerRole(){
		return codeFieldForPeerRole("code","");
	}


	public HyperledgerNetworkForm networkIdFieldForPeerRole(String parameterName, String initValue){
		FormField field =  networkIdFromPeerRole(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm networkIdFieldForPeerRole(String initValue){
		return networkIdFieldForPeerRole("networkId",initValue);
	}
	public HyperledgerNetworkForm networkIdFieldForPeerRole(){
		return networkIdFieldForPeerRole("networkId","");
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


	public HyperledgerNetworkForm payloadFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  payloadFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm payloadFieldForServiceRecord(String initValue){
		return payloadFieldForServiceRecord("payload",initValue);
	}
	public HyperledgerNetworkForm payloadFieldForServiceRecord(){
		return payloadFieldForServiceRecord("payload","");
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


	public HyperledgerNetworkForm chainCodeFunctionFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  chainCodeFunctionFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm chainCodeFunctionFieldForServiceRecord(String initValue){
		return chainCodeFunctionFieldForServiceRecord("chainCodeFunction",initValue);
	}
	public HyperledgerNetworkForm chainCodeFunctionFieldForServiceRecord(){
		return chainCodeFunctionFieldForServiceRecord("chainCodeFunction","");
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


	public HyperledgerNetworkForm appClientIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  appClientIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm appClientIdFieldForServiceRecord(String initValue){
		return appClientIdFieldForServiceRecord("appClientId",initValue);
	}
	public HyperledgerNetworkForm appClientIdFieldForServiceRecord(){
		return appClientIdFieldForServiceRecord("appClientId","");
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


	public HyperledgerNetworkForm responseFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  responseFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm responseFieldForServiceRecord(String initValue){
		return responseFieldForServiceRecord("response",initValue);
	}
	public HyperledgerNetworkForm responseFieldForServiceRecord(){
		return responseFieldForServiceRecord("response","");
	}


	public HyperledgerNetworkForm statusIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  statusIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm statusIdFieldForServiceRecord(String initValue){
		return statusIdFieldForServiceRecord("statusId",initValue);
	}
	public HyperledgerNetworkForm statusIdFieldForServiceRecord(){
		return statusIdFieldForServiceRecord("statusId","");
	}


	public HyperledgerNetworkForm transactionStatusIdFieldForTransactionStatus(String parameterName, String initValue){
		FormField field =  idFromTransactionStatus(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm transactionStatusIdFieldForTransactionStatus(String initValue){
		return transactionStatusIdFieldForTransactionStatus("transactionStatusId",initValue);
	}
	public HyperledgerNetworkForm transactionStatusIdFieldForTransactionStatus(){
		return transactionStatusIdFieldForTransactionStatus("transactionStatusId","");
	}


	public HyperledgerNetworkForm nameFieldForTransactionStatus(String parameterName, String initValue){
		FormField field =  nameFromTransactionStatus(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm nameFieldForTransactionStatus(String initValue){
		return nameFieldForTransactionStatus("name",initValue);
	}
	public HyperledgerNetworkForm nameFieldForTransactionStatus(){
		return nameFieldForTransactionStatus("name","");
	}


	public HyperledgerNetworkForm codeFieldForTransactionStatus(String parameterName, String initValue){
		FormField field =  codeFromTransactionStatus(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm codeFieldForTransactionStatus(String initValue){
		return codeFieldForTransactionStatus("code",initValue);
	}
	public HyperledgerNetworkForm codeFieldForTransactionStatus(){
		return codeFieldForTransactionStatus("code","");
	}


	public HyperledgerNetworkForm networkIdFieldForTransactionStatus(String parameterName, String initValue){
		FormField field =  networkIdFromTransactionStatus(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HyperledgerNetworkForm networkIdFieldForTransactionStatus(String initValue){
		return networkIdFieldForTransactionStatus("networkId",initValue);
	}
	public HyperledgerNetworkForm networkIdFieldForTransactionStatus(){
		return networkIdFieldForTransactionStatus("networkId","");
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


