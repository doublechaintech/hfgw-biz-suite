package com.doublechaintech.hfgw.changerequest;
import com.doublechaintech.hfgw.BaseForm;
import com.doublechaintech.hfgw.genericform.GenericForm;
import com.doublechaintech.hfgw.formfield.FormField;
import com.doublechaintech.hfgw.formaction.FormAction;
import com.doublechaintech.hfgw.formmessage.FormMessage;
import com.doublechaintech.hfgw.formfieldmessage.FormFieldMessage;



public class ChangeRequestForm extends BaseForm {
	
	
	public ChangeRequestForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ChangeRequestForm changeRequestIdField(String parameterName, String initValue){
		FormField field = idFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm changeRequestIdField(String initValue){
		return changeRequestIdField("changeRequestId",initValue);
	}
	public ChangeRequestForm changeRequestIdField(){
		return changeRequestIdField("changeRequestId","");
	}


	public ChangeRequestForm nameField(String parameterName, String initValue){
		FormField field = nameFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ChangeRequestForm nameField(){
		return nameField("name","");
	}


	public ChangeRequestForm createTimeField(String parameterName, String initValue){
		FormField field = createTimeFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm createTimeField(String initValue){
		return createTimeField("createTime",initValue);
	}
	public ChangeRequestForm createTimeField(){
		return createTimeField("createTime","");
	}


	public ChangeRequestForm remoteIpField(String parameterName, String initValue){
		FormField field = remoteIpFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm remoteIpField(String initValue){
		return remoteIpField("remoteIp",initValue);
	}
	public ChangeRequestForm remoteIpField(){
		return remoteIpField("remoteIp","");
	}


	public ChangeRequestForm requestTypeIdField(String parameterName, String initValue){
		FormField field = requestTypeIdFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm requestTypeIdField(String initValue){
		return requestTypeIdField("requestTypeId",initValue);
	}
	public ChangeRequestForm requestTypeIdField(){
		return requestTypeIdField("requestTypeId","");
	}


	public ChangeRequestForm networkIdField(String parameterName, String initValue){
		FormField field = networkIdFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm networkIdField(String initValue){
		return networkIdField("networkId",initValue);
	}
	public ChangeRequestForm networkIdField(){
		return networkIdField("networkId","");
	}

	
	


	public ChangeRequestForm changeRequestTypeIdFieldOfChangeRequestType(String parameterName, String initValue){
		FormField field =  idFromChangeRequestType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChangeRequestForm changeRequestTypeIdFieldOfChangeRequestType(String initValue){
		return changeRequestTypeIdFieldOfChangeRequestType("changeRequestTypeId",initValue);
	}
	public ChangeRequestForm changeRequestTypeIdFieldOfChangeRequestType(){
		return changeRequestTypeIdFieldOfChangeRequestType("changeRequestTypeId","");
	}


	public ChangeRequestForm nameFieldOfChangeRequestType(String parameterName, String initValue){
		FormField field =  nameFromChangeRequestType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChangeRequestForm nameFieldOfChangeRequestType(String initValue){
		return nameFieldOfChangeRequestType("name",initValue);
	}
	public ChangeRequestForm nameFieldOfChangeRequestType(){
		return nameFieldOfChangeRequestType("name","");
	}


	public ChangeRequestForm codeFieldOfChangeRequestType(String parameterName, String initValue){
		FormField field =  codeFromChangeRequestType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChangeRequestForm codeFieldOfChangeRequestType(String initValue){
		return codeFieldOfChangeRequestType("code",initValue);
	}
	public ChangeRequestForm codeFieldOfChangeRequestType(){
		return codeFieldOfChangeRequestType("code","");
	}


	public ChangeRequestForm iconFieldOfChangeRequestType(String parameterName, String initValue){
		FormField field =  iconFromChangeRequestType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChangeRequestForm iconFieldOfChangeRequestType(String initValue){
		return iconFieldOfChangeRequestType("icon",initValue);
	}
	public ChangeRequestForm iconFieldOfChangeRequestType(){
		return iconFieldOfChangeRequestType("icon","");
	}


	public ChangeRequestForm displayOrderFieldOfChangeRequestType(String parameterName, String initValue){
		FormField field =  displayOrderFromChangeRequestType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChangeRequestForm displayOrderFieldOfChangeRequestType(String initValue){
		return displayOrderFieldOfChangeRequestType("displayOrder",initValue);
	}
	public ChangeRequestForm displayOrderFieldOfChangeRequestType(){
		return displayOrderFieldOfChangeRequestType("displayOrder","");
	}


	public ChangeRequestForm bindTypesFieldOfChangeRequestType(String parameterName, String initValue){
		FormField field =  bindTypesFromChangeRequestType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChangeRequestForm bindTypesFieldOfChangeRequestType(String initValue){
		return bindTypesFieldOfChangeRequestType("bindTypes",initValue);
	}
	public ChangeRequestForm bindTypesFieldOfChangeRequestType(){
		return bindTypesFieldOfChangeRequestType("bindTypes","");
	}


	public ChangeRequestForm stepConfigurationFieldOfChangeRequestType(String parameterName, String initValue){
		FormField field =  stepConfigurationFromChangeRequestType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChangeRequestForm stepConfigurationFieldOfChangeRequestType(String initValue){
		return stepConfigurationFieldOfChangeRequestType("stepConfiguration",initValue);
	}
	public ChangeRequestForm stepConfigurationFieldOfChangeRequestType(){
		return stepConfigurationFieldOfChangeRequestType("stepConfiguration","");
	}


	public ChangeRequestForm networkIdFieldOfChangeRequestType(String parameterName, String initValue){
		FormField field =  networkIdFromChangeRequestType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChangeRequestForm networkIdFieldOfChangeRequestType(String initValue){
		return networkIdFieldOfChangeRequestType("networkId",initValue);
	}
	public ChangeRequestForm networkIdFieldOfChangeRequestType(){
		return networkIdFieldOfChangeRequestType("networkId","");
	}


	public ChangeRequestForm hyperledgerNetworkIdFieldOfHyperledgerNetwork(String parameterName, String initValue){
		FormField field =  idFromHyperledgerNetwork(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChangeRequestForm hyperledgerNetworkIdFieldOfHyperledgerNetwork(String initValue){
		return hyperledgerNetworkIdFieldOfHyperledgerNetwork("hyperledgerNetworkId",initValue);
	}
	public ChangeRequestForm hyperledgerNetworkIdFieldOfHyperledgerNetwork(){
		return hyperledgerNetworkIdFieldOfHyperledgerNetwork("hyperledgerNetworkId","");
	}


	public ChangeRequestForm nameFieldOfHyperledgerNetwork(String parameterName, String initValue){
		FormField field =  nameFromHyperledgerNetwork(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChangeRequestForm nameFieldOfHyperledgerNetwork(String initValue){
		return nameFieldOfHyperledgerNetwork("name",initValue);
	}
	public ChangeRequestForm nameFieldOfHyperledgerNetwork(){
		return nameFieldOfHyperledgerNetwork("name","");
	}


	public ChangeRequestForm descriptionFieldOfHyperledgerNetwork(String parameterName, String initValue){
		FormField field =  descriptionFromHyperledgerNetwork(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChangeRequestForm descriptionFieldOfHyperledgerNetwork(String initValue){
		return descriptionFieldOfHyperledgerNetwork("description",initValue);
	}
	public ChangeRequestForm descriptionFieldOfHyperledgerNetwork(){
		return descriptionFieldOfHyperledgerNetwork("description","");
	}

	



	public ChangeRequestForm chainCodeInvokerIdFieldForChainCodeInvoker(String parameterName, String initValue){
		FormField field =  idFromChainCodeInvoker(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm chainCodeInvokerIdFieldForChainCodeInvoker(String initValue){
		return chainCodeInvokerIdFieldForChainCodeInvoker("chainCodeInvokerId",initValue);
	}
	public ChangeRequestForm chainCodeInvokerIdFieldForChainCodeInvoker(){
		return chainCodeInvokerIdFieldForChainCodeInvoker("chainCodeInvokerId","");
	}


	public ChangeRequestForm appClientIdFieldForChainCodeInvoker(String parameterName, String initValue){
		FormField field =  appClientIdFromChainCodeInvoker(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm appClientIdFieldForChainCodeInvoker(String initValue){
		return appClientIdFieldForChainCodeInvoker("appClientId",initValue);
	}
	public ChangeRequestForm appClientIdFieldForChainCodeInvoker(){
		return appClientIdFieldForChainCodeInvoker("appClientId","");
	}


	public ChangeRequestForm chainCodeIdFieldForChainCodeInvoker(String parameterName, String initValue){
		FormField field =  chainCodeIdFromChainCodeInvoker(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm chainCodeIdFieldForChainCodeInvoker(String initValue){
		return chainCodeIdFieldForChainCodeInvoker("chainCodeId",initValue);
	}
	public ChangeRequestForm chainCodeIdFieldForChainCodeInvoker(){
		return chainCodeIdFieldForChainCodeInvoker("chainCodeId","");
	}


	public ChangeRequestForm parametersFieldForChainCodeInvoker(String parameterName, String initValue){
		FormField field =  parametersFromChainCodeInvoker(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm parametersFieldForChainCodeInvoker(String initValue){
		return parametersFieldForChainCodeInvoker("parameters",initValue);
	}
	public ChangeRequestForm parametersFieldForChainCodeInvoker(){
		return parametersFieldForChainCodeInvoker("parameters","");
	}


	public ChangeRequestForm changeRequestIdFieldForChainCodeInvoker(String parameterName, String initValue){
		FormField field =  changeRequestIdFromChainCodeInvoker(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm changeRequestIdFieldForChainCodeInvoker(String initValue){
		return changeRequestIdFieldForChainCodeInvoker("changeRequestId",initValue);
	}
	public ChangeRequestForm changeRequestIdFieldForChainCodeInvoker(){
		return changeRequestIdFieldForChainCodeInvoker("changeRequestId","");
	}

	

	
 	public ChangeRequestForm transferToAnotherRequestTypeAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherRequestType/changeRequestId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public ChangeRequestForm transferToAnotherNetworkAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherNetwork/changeRequestId/");
		this.addFormAction(action);
		return this;
	}

 

	public ChangeRequestForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


