package com.doublechaintech.hfgw.servicerecord;
import com.doublechaintech.hfgw.BaseForm;
import com.doublechaintech.hfgw.genericform.GenericForm;
import com.doublechaintech.hfgw.formfield.FormField;
import com.doublechaintech.hfgw.formaction.FormAction;
import com.doublechaintech.hfgw.formmessage.FormMessage;
import com.doublechaintech.hfgw.formfieldmessage.FormFieldMessage;



public class ServiceRecordForm extends BaseForm {
	
	
	public ServiceRecordForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ServiceRecordForm serviceRecordIdField(String parameterName, String initValue){
		FormField field = idFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ServiceRecordForm serviceRecordIdField(String initValue){
		return serviceRecordIdField("serviceRecordId",initValue);
	}
	public ServiceRecordForm serviceRecordIdField(){
		return serviceRecordIdField("serviceRecordId","");
	}


	public ServiceRecordForm nameField(String parameterName, String initValue){
		FormField field = nameFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ServiceRecordForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ServiceRecordForm nameField(){
		return nameField("name","");
	}


	public ServiceRecordForm payLoadField(String parameterName, String initValue){
		FormField field = payLoadFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ServiceRecordForm payLoadField(String initValue){
		return payLoadField("payLoad",initValue);
	}
	public ServiceRecordForm payLoadField(){
		return payLoadField("payLoad","");
	}


	public ServiceRecordForm channelIdField(String parameterName, String initValue){
		FormField field = channelIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ServiceRecordForm channelIdField(String initValue){
		return channelIdField("channelId",initValue);
	}
	public ServiceRecordForm channelIdField(){
		return channelIdField("channelId","");
	}


	public ServiceRecordForm chainCodeIdField(String parameterName, String initValue){
		FormField field = chainCodeIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ServiceRecordForm chainCodeIdField(String initValue){
		return chainCodeIdField("chainCodeId",initValue);
	}
	public ServiceRecordForm chainCodeIdField(){
		return chainCodeIdField("chainCodeId","");
	}


	public ServiceRecordForm transactionIdField(String parameterName, String initValue){
		FormField field = transactionIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ServiceRecordForm transactionIdField(String initValue){
		return transactionIdField("transactionId",initValue);
	}
	public ServiceRecordForm transactionIdField(){
		return transactionIdField("transactionId","");
	}


	public ServiceRecordForm blockIdField(String parameterName, String initValue){
		FormField field = blockIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ServiceRecordForm blockIdField(String initValue){
		return blockIdField("blockId",initValue);
	}
	public ServiceRecordForm blockIdField(){
		return blockIdField("blockId","");
	}


	public ServiceRecordForm createTimeField(String parameterName, String initValue){
		FormField field = createTimeFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ServiceRecordForm createTimeField(String initValue){
		return createTimeField("createTime",initValue);
	}
	public ServiceRecordForm createTimeField(){
		return createTimeField("createTime","");
	}


	public ServiceRecordForm applicationIdField(String parameterName, String initValue){
		FormField field = applicationIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ServiceRecordForm applicationIdField(String initValue){
		return applicationIdField("applicationId",initValue);
	}
	public ServiceRecordForm applicationIdField(){
		return applicationIdField("applicationId","");
	}


	public ServiceRecordForm networkIdField(String parameterName, String initValue){
		FormField field = networkIdFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ServiceRecordForm networkIdField(String initValue){
		return networkIdField("networkId",initValue);
	}
	public ServiceRecordForm networkIdField(){
		return networkIdField("networkId","");
	}


	public ServiceRecordForm currentStatusField(String parameterName, String initValue){
		FormField field = currentStatusFromServiceRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ServiceRecordForm currentStatusField(String initValue){
		return currentStatusField("currentStatus",initValue);
	}
	public ServiceRecordForm currentStatusField(){
		return currentStatusField("currentStatus","");
	}

	
	


	public ServiceRecordForm channelIdFieldOfChannel(String parameterName, String initValue){
		FormField field =  idFromChannel(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ServiceRecordForm channelIdFieldOfChannel(String initValue){
		return channelIdFieldOfChannel("channelId",initValue);
	}
	public ServiceRecordForm channelIdFieldOfChannel(){
		return channelIdFieldOfChannel("channelId","");
	}


	public ServiceRecordForm nameFieldOfChannel(String parameterName, String initValue){
		FormField field =  nameFromChannel(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ServiceRecordForm nameFieldOfChannel(String initValue){
		return nameFieldOfChannel("name",initValue);
	}
	public ServiceRecordForm nameFieldOfChannel(){
		return nameFieldOfChannel("name","");
	}


	public ServiceRecordForm networkIdFieldOfChannel(String parameterName, String initValue){
		FormField field =  networkIdFromChannel(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ServiceRecordForm networkIdFieldOfChannel(String initValue){
		return networkIdFieldOfChannel("networkId",initValue);
	}
	public ServiceRecordForm networkIdFieldOfChannel(){
		return networkIdFieldOfChannel("networkId","");
	}


	public ServiceRecordForm chainCodeIdFieldOfChainCode(String parameterName, String initValue){
		FormField field =  idFromChainCode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ServiceRecordForm chainCodeIdFieldOfChainCode(String initValue){
		return chainCodeIdFieldOfChainCode("chainCodeId",initValue);
	}
	public ServiceRecordForm chainCodeIdFieldOfChainCode(){
		return chainCodeIdFieldOfChainCode("chainCodeId","");
	}


	public ServiceRecordForm nameFieldOfChainCode(String parameterName, String initValue){
		FormField field =  nameFromChainCode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ServiceRecordForm nameFieldOfChainCode(String initValue){
		return nameFieldOfChainCode("name",initValue);
	}
	public ServiceRecordForm nameFieldOfChainCode(){
		return nameFieldOfChainCode("name","");
	}


	public ServiceRecordForm codeNameFieldOfChainCode(String parameterName, String initValue){
		FormField field =  codeNameFromChainCode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ServiceRecordForm codeNameFieldOfChainCode(String initValue){
		return codeNameFieldOfChainCode("codeName",initValue);
	}
	public ServiceRecordForm codeNameFieldOfChainCode(){
		return codeNameFieldOfChainCode("codeName","");
	}


	public ServiceRecordForm codeVersionFieldOfChainCode(String parameterName, String initValue){
		FormField field =  codeVersionFromChainCode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ServiceRecordForm codeVersionFieldOfChainCode(String initValue){
		return codeVersionFieldOfChainCode("codeVersion",initValue);
	}
	public ServiceRecordForm codeVersionFieldOfChainCode(){
		return codeVersionFieldOfChainCode("codeVersion","");
	}


	public ServiceRecordForm channelIdFieldOfChainCode(String parameterName, String initValue){
		FormField field =  channelIdFromChainCode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ServiceRecordForm channelIdFieldOfChainCode(String initValue){
		return channelIdFieldOfChainCode("channelId",initValue);
	}
	public ServiceRecordForm channelIdFieldOfChainCode(){
		return channelIdFieldOfChainCode("channelId","");
	}


	public ServiceRecordForm applicationIdFieldOfApplication(String parameterName, String initValue){
		FormField field =  idFromApplication(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ServiceRecordForm applicationIdFieldOfApplication(String initValue){
		return applicationIdFieldOfApplication("applicationId",initValue);
	}
	public ServiceRecordForm applicationIdFieldOfApplication(){
		return applicationIdFieldOfApplication("applicationId","");
	}


	public ServiceRecordForm nameFieldOfApplication(String parameterName, String initValue){
		FormField field =  nameFromApplication(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ServiceRecordForm nameFieldOfApplication(String initValue){
		return nameFieldOfApplication("name",initValue);
	}
	public ServiceRecordForm nameFieldOfApplication(){
		return nameFieldOfApplication("name","");
	}


	public ServiceRecordForm createTimeFieldOfApplication(String parameterName, String initValue){
		FormField field =  createTimeFromApplication(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ServiceRecordForm createTimeFieldOfApplication(String initValue){
		return createTimeFieldOfApplication("createTime",initValue);
	}
	public ServiceRecordForm createTimeFieldOfApplication(){
		return createTimeFieldOfApplication("createTime","");
	}


	public ServiceRecordForm mspidFieldOfApplication(String parameterName, String initValue){
		FormField field =  mspidFromApplication(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ServiceRecordForm mspidFieldOfApplication(String initValue){
		return mspidFieldOfApplication("mspid",initValue);
	}
	public ServiceRecordForm mspidFieldOfApplication(){
		return mspidFieldOfApplication("mspid","");
	}


	public ServiceRecordForm publicKeyFieldOfApplication(String parameterName, String initValue){
		FormField field =  publicKeyFromApplication(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ServiceRecordForm publicKeyFieldOfApplication(String initValue){
		return publicKeyFieldOfApplication("publicKey",initValue);
	}
	public ServiceRecordForm publicKeyFieldOfApplication(){
		return publicKeyFieldOfApplication("publicKey","");
	}


	public ServiceRecordForm privateKeyFieldOfApplication(String parameterName, String initValue){
		FormField field =  privateKeyFromApplication(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ServiceRecordForm privateKeyFieldOfApplication(String initValue){
		return privateKeyFieldOfApplication("privateKey",initValue);
	}
	public ServiceRecordForm privateKeyFieldOfApplication(){
		return privateKeyFieldOfApplication("privateKey","");
	}


	public ServiceRecordForm channelIdFieldOfApplication(String parameterName, String initValue){
		FormField field =  channelIdFromApplication(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ServiceRecordForm channelIdFieldOfApplication(String initValue){
		return channelIdFieldOfApplication("channelId",initValue);
	}
	public ServiceRecordForm channelIdFieldOfApplication(){
		return channelIdFieldOfApplication("channelId","");
	}


	public ServiceRecordForm networkIdFieldOfApplication(String parameterName, String initValue){
		FormField field =  networkIdFromApplication(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ServiceRecordForm networkIdFieldOfApplication(String initValue){
		return networkIdFieldOfApplication("networkId",initValue);
	}
	public ServiceRecordForm networkIdFieldOfApplication(){
		return networkIdFieldOfApplication("networkId","");
	}


	public ServiceRecordForm hyperledgerNetworkIdFieldOfHyperledgerNetwork(String parameterName, String initValue){
		FormField field =  idFromHyperledgerNetwork(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ServiceRecordForm hyperledgerNetworkIdFieldOfHyperledgerNetwork(String initValue){
		return hyperledgerNetworkIdFieldOfHyperledgerNetwork("hyperledgerNetworkId",initValue);
	}
	public ServiceRecordForm hyperledgerNetworkIdFieldOfHyperledgerNetwork(){
		return hyperledgerNetworkIdFieldOfHyperledgerNetwork("hyperledgerNetworkId","");
	}


	public ServiceRecordForm nameFieldOfHyperledgerNetwork(String parameterName, String initValue){
		FormField field =  nameFromHyperledgerNetwork(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ServiceRecordForm nameFieldOfHyperledgerNetwork(String initValue){
		return nameFieldOfHyperledgerNetwork("name",initValue);
	}
	public ServiceRecordForm nameFieldOfHyperledgerNetwork(){
		return nameFieldOfHyperledgerNetwork("name","");
	}


	public ServiceRecordForm descriptionFieldOfHyperledgerNetwork(String parameterName, String initValue){
		FormField field =  descriptionFromHyperledgerNetwork(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ServiceRecordForm descriptionFieldOfHyperledgerNetwork(String initValue){
		return descriptionFieldOfHyperledgerNetwork("description",initValue);
	}
	public ServiceRecordForm descriptionFieldOfHyperledgerNetwork(){
		return descriptionFieldOfHyperledgerNetwork("description","");
	}

	


	

	
 	public ServiceRecordForm transferToAnotherChannelAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherChannel/serviceRecordId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public ServiceRecordForm transferToAnotherChainCodeAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherChainCode/serviceRecordId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public ServiceRecordForm  applyAction(){
		FormAction action = new FormAction();
		action.setLabel("应用程序");
		action.setLocaleKey("service_record.apply");
		action.setUrl("serviceRecordManager/apply/serviceRecordId/name/mspid/publicKey/privateKey/channelIdnetworkId");
		this.addFormAction(action);
		return this;
	}	
 	public ServiceRecordForm transferToAnotherNetworkAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherNetwork/serviceRecordId/");
		this.addFormAction(action);
		return this;
	}

 

	public ServiceRecordForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


