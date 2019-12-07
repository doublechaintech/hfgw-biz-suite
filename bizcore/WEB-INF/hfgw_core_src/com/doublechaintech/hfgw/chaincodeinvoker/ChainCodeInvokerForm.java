package com.doublechaintech.hfgw.chaincodeinvoker;
import com.doublechaintech.hfgw.BaseForm;
import com.doublechaintech.hfgw.genericform.GenericForm;
import com.doublechaintech.hfgw.formfield.FormField;
import com.doublechaintech.hfgw.formaction.FormAction;
import com.doublechaintech.hfgw.formmessage.FormMessage;
import com.doublechaintech.hfgw.formfieldmessage.FormFieldMessage;



public class ChainCodeInvokerForm extends BaseForm {
	
	
	public ChainCodeInvokerForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ChainCodeInvokerForm chainCodeInvokerIdField(String parameterName, String initValue){
		FormField field = idFromChainCodeInvoker(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChainCodeInvokerForm chainCodeInvokerIdField(String initValue){
		return chainCodeInvokerIdField("chainCodeInvokerId",initValue);
	}
	public ChainCodeInvokerForm chainCodeInvokerIdField(){
		return chainCodeInvokerIdField("chainCodeInvokerId","");
	}


	public ChainCodeInvokerForm appClientIdField(String parameterName, String initValue){
		FormField field = appClientIdFromChainCodeInvoker(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChainCodeInvokerForm appClientIdField(String initValue){
		return appClientIdField("appClientId",initValue);
	}
	public ChainCodeInvokerForm appClientIdField(){
		return appClientIdField("appClientId","");
	}


	public ChainCodeInvokerForm chainCodeIdField(String parameterName, String initValue){
		FormField field = chainCodeIdFromChainCodeInvoker(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChainCodeInvokerForm chainCodeIdField(String initValue){
		return chainCodeIdField("chainCodeId",initValue);
	}
	public ChainCodeInvokerForm chainCodeIdField(){
		return chainCodeIdField("chainCodeId","");
	}


	public ChainCodeInvokerForm parametersField(String parameterName, String initValue){
		FormField field = parametersFromChainCodeInvoker(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChainCodeInvokerForm parametersField(String initValue){
		return parametersField("parameters",initValue);
	}
	public ChainCodeInvokerForm parametersField(){
		return parametersField("parameters","");
	}


	public ChainCodeInvokerForm changeRequestIdField(String parameterName, String initValue){
		FormField field = changeRequestIdFromChainCodeInvoker(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChainCodeInvokerForm changeRequestIdField(String initValue){
		return changeRequestIdField("changeRequestId",initValue);
	}
	public ChainCodeInvokerForm changeRequestIdField(){
		return changeRequestIdField("changeRequestId","");
	}

	
	


	public ChainCodeInvokerForm applicationIdFieldOfApplication(String parameterName, String initValue){
		FormField field =  idFromApplication(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChainCodeInvokerForm applicationIdFieldOfApplication(String initValue){
		return applicationIdFieldOfApplication("applicationId",initValue);
	}
	public ChainCodeInvokerForm applicationIdFieldOfApplication(){
		return applicationIdFieldOfApplication("applicationId","");
	}


	public ChainCodeInvokerForm nameFieldOfApplication(String parameterName, String initValue){
		FormField field =  nameFromApplication(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChainCodeInvokerForm nameFieldOfApplication(String initValue){
		return nameFieldOfApplication("name",initValue);
	}
	public ChainCodeInvokerForm nameFieldOfApplication(){
		return nameFieldOfApplication("name","");
	}


	public ChainCodeInvokerForm createTimeFieldOfApplication(String parameterName, String initValue){
		FormField field =  createTimeFromApplication(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChainCodeInvokerForm createTimeFieldOfApplication(String initValue){
		return createTimeFieldOfApplication("createTime",initValue);
	}
	public ChainCodeInvokerForm createTimeFieldOfApplication(){
		return createTimeFieldOfApplication("createTime","");
	}


	public ChainCodeInvokerForm mspidFieldOfApplication(String parameterName, String initValue){
		FormField field =  mspidFromApplication(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChainCodeInvokerForm mspidFieldOfApplication(String initValue){
		return mspidFieldOfApplication("mspid",initValue);
	}
	public ChainCodeInvokerForm mspidFieldOfApplication(){
		return mspidFieldOfApplication("mspid","");
	}


	public ChainCodeInvokerForm publicKeyFieldOfApplication(String parameterName, String initValue){
		FormField field =  publicKeyFromApplication(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChainCodeInvokerForm publicKeyFieldOfApplication(String initValue){
		return publicKeyFieldOfApplication("publicKey",initValue);
	}
	public ChainCodeInvokerForm publicKeyFieldOfApplication(){
		return publicKeyFieldOfApplication("publicKey","");
	}


	public ChainCodeInvokerForm privateKeyFieldOfApplication(String parameterName, String initValue){
		FormField field =  privateKeyFromApplication(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChainCodeInvokerForm privateKeyFieldOfApplication(String initValue){
		return privateKeyFieldOfApplication("privateKey",initValue);
	}
	public ChainCodeInvokerForm privateKeyFieldOfApplication(){
		return privateKeyFieldOfApplication("privateKey","");
	}


	public ChainCodeInvokerForm channelIdFieldOfApplication(String parameterName, String initValue){
		FormField field =  channelIdFromApplication(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChainCodeInvokerForm channelIdFieldOfApplication(String initValue){
		return channelIdFieldOfApplication("channelId",initValue);
	}
	public ChainCodeInvokerForm channelIdFieldOfApplication(){
		return channelIdFieldOfApplication("channelId","");
	}


	public ChainCodeInvokerForm networkIdFieldOfApplication(String parameterName, String initValue){
		FormField field =  networkIdFromApplication(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChainCodeInvokerForm networkIdFieldOfApplication(String initValue){
		return networkIdFieldOfApplication("networkId",initValue);
	}
	public ChainCodeInvokerForm networkIdFieldOfApplication(){
		return networkIdFieldOfApplication("networkId","");
	}


	public ChainCodeInvokerForm chainCodeIdFieldOfChainCode(String parameterName, String initValue){
		FormField field =  idFromChainCode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChainCodeInvokerForm chainCodeIdFieldOfChainCode(String initValue){
		return chainCodeIdFieldOfChainCode("chainCodeId",initValue);
	}
	public ChainCodeInvokerForm chainCodeIdFieldOfChainCode(){
		return chainCodeIdFieldOfChainCode("chainCodeId","");
	}


	public ChainCodeInvokerForm nameFieldOfChainCode(String parameterName, String initValue){
		FormField field =  nameFromChainCode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChainCodeInvokerForm nameFieldOfChainCode(String initValue){
		return nameFieldOfChainCode("name",initValue);
	}
	public ChainCodeInvokerForm nameFieldOfChainCode(){
		return nameFieldOfChainCode("name","");
	}


	public ChainCodeInvokerForm codeNameFieldOfChainCode(String parameterName, String initValue){
		FormField field =  codeNameFromChainCode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChainCodeInvokerForm codeNameFieldOfChainCode(String initValue){
		return codeNameFieldOfChainCode("codeName",initValue);
	}
	public ChainCodeInvokerForm codeNameFieldOfChainCode(){
		return codeNameFieldOfChainCode("codeName","");
	}


	public ChainCodeInvokerForm codeVersionFieldOfChainCode(String parameterName, String initValue){
		FormField field =  codeVersionFromChainCode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChainCodeInvokerForm codeVersionFieldOfChainCode(String initValue){
		return codeVersionFieldOfChainCode("codeVersion",initValue);
	}
	public ChainCodeInvokerForm codeVersionFieldOfChainCode(){
		return codeVersionFieldOfChainCode("codeVersion","");
	}


	public ChainCodeInvokerForm channelIdFieldOfChainCode(String parameterName, String initValue){
		FormField field =  channelIdFromChainCode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChainCodeInvokerForm channelIdFieldOfChainCode(String initValue){
		return channelIdFieldOfChainCode("channelId",initValue);
	}
	public ChainCodeInvokerForm channelIdFieldOfChainCode(){
		return channelIdFieldOfChainCode("channelId","");
	}


	public ChainCodeInvokerForm changeRequestIdFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  idFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChainCodeInvokerForm changeRequestIdFieldOfChangeRequest(String initValue){
		return changeRequestIdFieldOfChangeRequest("changeRequestId",initValue);
	}
	public ChainCodeInvokerForm changeRequestIdFieldOfChangeRequest(){
		return changeRequestIdFieldOfChangeRequest("changeRequestId","");
	}


	public ChainCodeInvokerForm nameFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  nameFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChainCodeInvokerForm nameFieldOfChangeRequest(String initValue){
		return nameFieldOfChangeRequest("name",initValue);
	}
	public ChainCodeInvokerForm nameFieldOfChangeRequest(){
		return nameFieldOfChangeRequest("name","");
	}


	public ChainCodeInvokerForm createTimeFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  createTimeFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChainCodeInvokerForm createTimeFieldOfChangeRequest(String initValue){
		return createTimeFieldOfChangeRequest("createTime",initValue);
	}
	public ChainCodeInvokerForm createTimeFieldOfChangeRequest(){
		return createTimeFieldOfChangeRequest("createTime","");
	}


	public ChainCodeInvokerForm remoteIpFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  remoteIpFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChainCodeInvokerForm remoteIpFieldOfChangeRequest(String initValue){
		return remoteIpFieldOfChangeRequest("remoteIp",initValue);
	}
	public ChainCodeInvokerForm remoteIpFieldOfChangeRequest(){
		return remoteIpFieldOfChangeRequest("remoteIp","");
	}


	public ChainCodeInvokerForm requestTypeIdFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  requestTypeIdFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChainCodeInvokerForm requestTypeIdFieldOfChangeRequest(String initValue){
		return requestTypeIdFieldOfChangeRequest("requestTypeId",initValue);
	}
	public ChainCodeInvokerForm requestTypeIdFieldOfChangeRequest(){
		return requestTypeIdFieldOfChangeRequest("requestTypeId","");
	}


	public ChainCodeInvokerForm networkIdFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  networkIdFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChainCodeInvokerForm networkIdFieldOfChangeRequest(String initValue){
		return networkIdFieldOfChangeRequest("networkId",initValue);
	}
	public ChainCodeInvokerForm networkIdFieldOfChangeRequest(){
		return networkIdFieldOfChangeRequest("networkId","");
	}

	


	

	
 	public ChainCodeInvokerForm transferToAnotherAppClientAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherAppClient/chainCodeInvokerId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public ChainCodeInvokerForm transferToAnotherChainCodeAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherChainCode/chainCodeInvokerId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public ChainCodeInvokerForm transferToAnotherChangeRequestAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherChangeRequest/chainCodeInvokerId/");
		this.addFormAction(action);
		return this;
	}

 

	public ChainCodeInvokerForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


