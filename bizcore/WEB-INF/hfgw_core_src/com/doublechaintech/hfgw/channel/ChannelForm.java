package com.doublechaintech.hfgw.channel;
import com.doublechaintech.hfgw.BaseForm;
import com.doublechaintech.hfgw.genericform.GenericForm;
import com.doublechaintech.hfgw.formfield.FormField;
import com.doublechaintech.hfgw.formaction.FormAction;
import com.doublechaintech.hfgw.formmessage.FormMessage;
import com.doublechaintech.hfgw.formfieldmessage.FormFieldMessage;



public class ChannelForm extends BaseForm {
	
	
	public ChannelForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ChannelForm channelIdField(String parameterName, String initValue){
		FormField field = idFromChannel(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm channelIdField(String initValue){
		return channelIdField("channelId",initValue);
	}
	public ChannelForm channelIdField(){
		return channelIdField("channelId","");
	}


	public ChannelForm nameField(String parameterName, String initValue){
		FormField field = nameFromChannel(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ChannelForm nameField(){
		return nameField("name","");
	}


	public ChannelForm networkIdField(String parameterName, String initValue){
		FormField field = networkIdFromChannel(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm networkIdField(String initValue){
		return networkIdField("networkId",initValue);
	}
	public ChannelForm networkIdField(){
		return networkIdField("networkId","");
	}

	
	


	public ChannelForm hyperledgerNetworkIdFieldOfHyperledgerNetwork(String parameterName, String initValue){
		FormField field =  idFromHyperledgerNetwork(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChannelForm hyperledgerNetworkIdFieldOfHyperledgerNetwork(String initValue){
		return hyperledgerNetworkIdFieldOfHyperledgerNetwork("hyperledgerNetworkId",initValue);
	}
	public ChannelForm hyperledgerNetworkIdFieldOfHyperledgerNetwork(){
		return hyperledgerNetworkIdFieldOfHyperledgerNetwork("hyperledgerNetworkId","");
	}


	public ChannelForm nameFieldOfHyperledgerNetwork(String parameterName, String initValue){
		FormField field =  nameFromHyperledgerNetwork(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChannelForm nameFieldOfHyperledgerNetwork(String initValue){
		return nameFieldOfHyperledgerNetwork("name",initValue);
	}
	public ChannelForm nameFieldOfHyperledgerNetwork(){
		return nameFieldOfHyperledgerNetwork("name","");
	}


	public ChannelForm descriptionFieldOfHyperledgerNetwork(String parameterName, String initValue){
		FormField field =  descriptionFromHyperledgerNetwork(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChannelForm descriptionFieldOfHyperledgerNetwork(String initValue){
		return descriptionFieldOfHyperledgerNetwork("description",initValue);
	}
	public ChannelForm descriptionFieldOfHyperledgerNetwork(){
		return descriptionFieldOfHyperledgerNetwork("description","");
	}

	



	public ChannelForm nodeIdFieldForNode(String parameterName, String initValue){
		FormField field =  idFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm nodeIdFieldForNode(String initValue){
		return nodeIdFieldForNode("nodeId",initValue);
	}
	public ChannelForm nodeIdFieldForNode(){
		return nodeIdFieldForNode("nodeId","");
	}


	public ChannelForm nameFieldForNode(String parameterName, String initValue){
		FormField field =  nameFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm nameFieldForNode(String initValue){
		return nameFieldForNode("name",initValue);
	}
	public ChannelForm nameFieldForNode(){
		return nameFieldForNode("name","");
	}


	public ChannelForm urlFieldForNode(String parameterName, String initValue){
		FormField field =  urlFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm urlFieldForNode(String initValue){
		return urlFieldForNode("url",initValue);
	}
	public ChannelForm urlFieldForNode(){
		return urlFieldForNode("url","");
	}


	public ChannelForm organizationIdFieldForNode(String parameterName, String initValue){
		FormField field =  organizationIdFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm organizationIdFieldForNode(String initValue){
		return organizationIdFieldForNode("organizationId",initValue);
	}
	public ChannelForm organizationIdFieldForNode(){
		return organizationIdFieldForNode("organizationId","");
	}


	public ChannelForm channelIdFieldForNode(String parameterName, String initValue){
		FormField field =  channelIdFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm channelIdFieldForNode(String initValue){
		return channelIdFieldForNode("channelId",initValue);
	}
	public ChannelForm channelIdFieldForNode(){
		return channelIdFieldForNode("channelId","");
	}


	public ChannelForm typeIdFieldForNode(String parameterName, String initValue){
		FormField field =  typeIdFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm typeIdFieldForNode(String initValue){
		return typeIdFieldForNode("typeId",initValue);
	}
	public ChannelForm typeIdFieldForNode(){
		return typeIdFieldForNode("typeId","");
	}


	public ChannelForm chainCodeIdFieldForChainCode(String parameterName, String initValue){
		FormField field =  idFromChainCode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm chainCodeIdFieldForChainCode(String initValue){
		return chainCodeIdFieldForChainCode("chainCodeId",initValue);
	}
	public ChannelForm chainCodeIdFieldForChainCode(){
		return chainCodeIdFieldForChainCode("chainCodeId","");
	}


	public ChannelForm nameFieldForChainCode(String parameterName, String initValue){
		FormField field =  nameFromChainCode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm nameFieldForChainCode(String initValue){
		return nameFieldForChainCode("name",initValue);
	}
	public ChannelForm nameFieldForChainCode(){
		return nameFieldForChainCode("name","");
	}


	public ChannelForm codeNameFieldForChainCode(String parameterName, String initValue){
		FormField field =  codeNameFromChainCode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm codeNameFieldForChainCode(String initValue){
		return codeNameFieldForChainCode("codeName",initValue);
	}
	public ChannelForm codeNameFieldForChainCode(){
		return codeNameFieldForChainCode("codeName","");
	}


	public ChannelForm codeVersionFieldForChainCode(String parameterName, String initValue){
		FormField field =  codeVersionFromChainCode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm codeVersionFieldForChainCode(String initValue){
		return codeVersionFieldForChainCode("codeVersion",initValue);
	}
	public ChannelForm codeVersionFieldForChainCode(){
		return codeVersionFieldForChainCode("codeVersion","");
	}


	public ChannelForm channelIdFieldForChainCode(String parameterName, String initValue){
		FormField field =  channelIdFromChainCode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm channelIdFieldForChainCode(String initValue){
		return channelIdFieldForChainCode("channelId",initValue);
	}
	public ChannelForm channelIdFieldForChainCode(){
		return channelIdFieldForChainCode("channelId","");
	}


	public ChannelForm applicationIdFieldForApplication(String parameterName, String initValue){
		FormField field =  idFromApplication(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm applicationIdFieldForApplication(String initValue){
		return applicationIdFieldForApplication("applicationId",initValue);
	}
	public ChannelForm applicationIdFieldForApplication(){
		return applicationIdFieldForApplication("applicationId","");
	}


	public ChannelForm nameFieldForApplication(String parameterName, String initValue){
		FormField field =  nameFromApplication(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm nameFieldForApplication(String initValue){
		return nameFieldForApplication("name",initValue);
	}
	public ChannelForm nameFieldForApplication(){
		return nameFieldForApplication("name","");
	}


	public ChannelForm createTimeFieldForApplication(String parameterName, String initValue){
		FormField field =  createTimeFromApplication(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm createTimeFieldForApplication(String initValue){
		return createTimeFieldForApplication("createTime",initValue);
	}
	public ChannelForm createTimeFieldForApplication(){
		return createTimeFieldForApplication("createTime","");
	}


	public ChannelForm mspidFieldForApplication(String parameterName, String initValue){
		FormField field =  mspidFromApplication(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm mspidFieldForApplication(String initValue){
		return mspidFieldForApplication("mspid",initValue);
	}
	public ChannelForm mspidFieldForApplication(){
		return mspidFieldForApplication("mspid","");
	}


	public ChannelForm publicKeyFieldForApplication(String parameterName, String initValue){
		FormField field =  publicKeyFromApplication(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm publicKeyFieldForApplication(String initValue){
		return publicKeyFieldForApplication("publicKey",initValue);
	}
	public ChannelForm publicKeyFieldForApplication(){
		return publicKeyFieldForApplication("publicKey","");
	}


	public ChannelForm privateKeyFieldForApplication(String parameterName, String initValue){
		FormField field =  privateKeyFromApplication(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm privateKeyFieldForApplication(String initValue){
		return privateKeyFieldForApplication("privateKey",initValue);
	}
	public ChannelForm privateKeyFieldForApplication(){
		return privateKeyFieldForApplication("privateKey","");
	}


	public ChannelForm channelIdFieldForApplication(String parameterName, String initValue){
		FormField field =  channelIdFromApplication(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm channelIdFieldForApplication(String initValue){
		return channelIdFieldForApplication("channelId",initValue);
	}
	public ChannelForm channelIdFieldForApplication(){
		return channelIdFieldForApplication("channelId","");
	}


	public ChannelForm networkIdFieldForApplication(String parameterName, String initValue){
		FormField field =  networkIdFromApplication(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm networkIdFieldForApplication(String initValue){
		return networkIdFieldForApplication("networkId",initValue);
	}
	public ChannelForm networkIdFieldForApplication(){
		return networkIdFieldForApplication("networkId","");
	}


	public ChannelForm serviceRecordIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  idFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm serviceRecordIdFieldForServiceRecord(String initValue){
		return serviceRecordIdFieldForServiceRecord("serviceRecordId",initValue);
	}
	public ChannelForm serviceRecordIdFieldForServiceRecord(){
		return serviceRecordIdFieldForServiceRecord("serviceRecordId","");
	}


	public ChannelForm nameFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  nameFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm nameFieldForServiceRecord(String initValue){
		return nameFieldForServiceRecord("name",initValue);
	}
	public ChannelForm nameFieldForServiceRecord(){
		return nameFieldForServiceRecord("name","");
	}


	public ChannelForm payLoadFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  payLoadFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm payLoadFieldForServiceRecord(String initValue){
		return payLoadFieldForServiceRecord("payLoad",initValue);
	}
	public ChannelForm payLoadFieldForServiceRecord(){
		return payLoadFieldForServiceRecord("payLoad","");
	}


	public ChannelForm channelIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  channelIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm channelIdFieldForServiceRecord(String initValue){
		return channelIdFieldForServiceRecord("channelId",initValue);
	}
	public ChannelForm channelIdFieldForServiceRecord(){
		return channelIdFieldForServiceRecord("channelId","");
	}


	public ChannelForm chainCodeIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  chainCodeIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm chainCodeIdFieldForServiceRecord(String initValue){
		return chainCodeIdFieldForServiceRecord("chainCodeId",initValue);
	}
	public ChannelForm chainCodeIdFieldForServiceRecord(){
		return chainCodeIdFieldForServiceRecord("chainCodeId","");
	}


	public ChannelForm transactionIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  transactionIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm transactionIdFieldForServiceRecord(String initValue){
		return transactionIdFieldForServiceRecord("transactionId",initValue);
	}
	public ChannelForm transactionIdFieldForServiceRecord(){
		return transactionIdFieldForServiceRecord("transactionId","");
	}


	public ChannelForm blockIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  blockIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm blockIdFieldForServiceRecord(String initValue){
		return blockIdFieldForServiceRecord("blockId",initValue);
	}
	public ChannelForm blockIdFieldForServiceRecord(){
		return blockIdFieldForServiceRecord("blockId","");
	}


	public ChannelForm createTimeFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  createTimeFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm createTimeFieldForServiceRecord(String initValue){
		return createTimeFieldForServiceRecord("createTime",initValue);
	}
	public ChannelForm createTimeFieldForServiceRecord(){
		return createTimeFieldForServiceRecord("createTime","");
	}


	public ChannelForm applicationIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  applicationIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm applicationIdFieldForServiceRecord(String initValue){
		return applicationIdFieldForServiceRecord("applicationId",initValue);
	}
	public ChannelForm applicationIdFieldForServiceRecord(){
		return applicationIdFieldForServiceRecord("applicationId","");
	}


	public ChannelForm networkIdFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  networkIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm networkIdFieldForServiceRecord(String initValue){
		return networkIdFieldForServiceRecord("networkId",initValue);
	}
	public ChannelForm networkIdFieldForServiceRecord(){
		return networkIdFieldForServiceRecord("networkId","");
	}


	public ChannelForm currentStatusFieldForServiceRecord(String parameterName, String initValue){
		FormField field =  currentStatusFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelForm currentStatusFieldForServiceRecord(String initValue){
		return currentStatusFieldForServiceRecord("currentStatus",initValue);
	}
	public ChannelForm currentStatusFieldForServiceRecord(){
		return currentStatusFieldForServiceRecord("currentStatus","");
	}

	

	
 	public ChannelForm transferToAnotherNetworkAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherNetwork/channelId/");
		this.addFormAction(action);
		return this;
	}

 

	public ChannelForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


