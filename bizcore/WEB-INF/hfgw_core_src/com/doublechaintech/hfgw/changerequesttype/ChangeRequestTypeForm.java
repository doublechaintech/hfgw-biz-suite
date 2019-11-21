package com.doublechaintech.hfgw.changerequesttype;
import com.doublechaintech.hfgw.BaseForm;
import com.doublechaintech.hfgw.genericform.GenericForm;
import com.doublechaintech.hfgw.formfield.FormField;
import com.doublechaintech.hfgw.formaction.FormAction;
import com.doublechaintech.hfgw.formmessage.FormMessage;
import com.doublechaintech.hfgw.formfieldmessage.FormFieldMessage;



public class ChangeRequestTypeForm extends BaseForm {
	
	
	public ChangeRequestTypeForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ChangeRequestTypeForm changeRequestTypeIdField(String parameterName, String initValue){
		FormField field = idFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestTypeForm changeRequestTypeIdField(String initValue){
		return changeRequestTypeIdField("changeRequestTypeId",initValue);
	}
	public ChangeRequestTypeForm changeRequestTypeIdField(){
		return changeRequestTypeIdField("changeRequestTypeId","");
	}


	public ChangeRequestTypeForm nameField(String parameterName, String initValue){
		FormField field = nameFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestTypeForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ChangeRequestTypeForm nameField(){
		return nameField("name","");
	}


	public ChangeRequestTypeForm codeField(String parameterName, String initValue){
		FormField field = codeFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestTypeForm codeField(String initValue){
		return codeField("code",initValue);
	}
	public ChangeRequestTypeForm codeField(){
		return codeField("code","");
	}


	public ChangeRequestTypeForm iconField(String parameterName, String initValue){
		FormField field = iconFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestTypeForm iconField(String initValue){
		return iconField("icon",initValue);
	}
	public ChangeRequestTypeForm iconField(){
		return iconField("icon","");
	}


	public ChangeRequestTypeForm displayOrderField(String parameterName, String initValue){
		FormField field = displayOrderFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestTypeForm displayOrderField(String initValue){
		return displayOrderField("displayOrder",initValue);
	}
	public ChangeRequestTypeForm displayOrderField(){
		return displayOrderField("displayOrder","");
	}


	public ChangeRequestTypeForm bindTypesField(String parameterName, String initValue){
		FormField field = bindTypesFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestTypeForm bindTypesField(String initValue){
		return bindTypesField("bindTypes",initValue);
	}
	public ChangeRequestTypeForm bindTypesField(){
		return bindTypesField("bindTypes","");
	}


	public ChangeRequestTypeForm stepConfigurationField(String parameterName, String initValue){
		FormField field = stepConfigurationFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestTypeForm stepConfigurationField(String initValue){
		return stepConfigurationField("stepConfiguration",initValue);
	}
	public ChangeRequestTypeForm stepConfigurationField(){
		return stepConfigurationField("stepConfiguration","");
	}


	public ChangeRequestTypeForm networkIdField(String parameterName, String initValue){
		FormField field = networkIdFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestTypeForm networkIdField(String initValue){
		return networkIdField("networkId",initValue);
	}
	public ChangeRequestTypeForm networkIdField(){
		return networkIdField("networkId","");
	}

	
	


	public ChangeRequestTypeForm hyperledgerNetworkIdFieldOfHyperledgerNetwork(String parameterName, String initValue){
		FormField field =  idFromHyperledgerNetwork(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChangeRequestTypeForm hyperledgerNetworkIdFieldOfHyperledgerNetwork(String initValue){
		return hyperledgerNetworkIdFieldOfHyperledgerNetwork("hyperledgerNetworkId",initValue);
	}
	public ChangeRequestTypeForm hyperledgerNetworkIdFieldOfHyperledgerNetwork(){
		return hyperledgerNetworkIdFieldOfHyperledgerNetwork("hyperledgerNetworkId","");
	}


	public ChangeRequestTypeForm nameFieldOfHyperledgerNetwork(String parameterName, String initValue){
		FormField field =  nameFromHyperledgerNetwork(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChangeRequestTypeForm nameFieldOfHyperledgerNetwork(String initValue){
		return nameFieldOfHyperledgerNetwork("name",initValue);
	}
	public ChangeRequestTypeForm nameFieldOfHyperledgerNetwork(){
		return nameFieldOfHyperledgerNetwork("name","");
	}


	public ChangeRequestTypeForm descriptionFieldOfHyperledgerNetwork(String parameterName, String initValue){
		FormField field =  descriptionFromHyperledgerNetwork(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChangeRequestTypeForm descriptionFieldOfHyperledgerNetwork(String initValue){
		return descriptionFieldOfHyperledgerNetwork("description",initValue);
	}
	public ChangeRequestTypeForm descriptionFieldOfHyperledgerNetwork(){
		return descriptionFieldOfHyperledgerNetwork("description","");
	}

	



	public ChangeRequestTypeForm changeRequestIdFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  idFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestTypeForm changeRequestIdFieldForChangeRequest(String initValue){
		return changeRequestIdFieldForChangeRequest("changeRequestId",initValue);
	}
	public ChangeRequestTypeForm changeRequestIdFieldForChangeRequest(){
		return changeRequestIdFieldForChangeRequest("changeRequestId","");
	}


	public ChangeRequestTypeForm nameFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  nameFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestTypeForm nameFieldForChangeRequest(String initValue){
		return nameFieldForChangeRequest("name",initValue);
	}
	public ChangeRequestTypeForm nameFieldForChangeRequest(){
		return nameFieldForChangeRequest("name","");
	}


	public ChangeRequestTypeForm createTimeFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  createTimeFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestTypeForm createTimeFieldForChangeRequest(String initValue){
		return createTimeFieldForChangeRequest("createTime",initValue);
	}
	public ChangeRequestTypeForm createTimeFieldForChangeRequest(){
		return createTimeFieldForChangeRequest("createTime","");
	}


	public ChangeRequestTypeForm remoteIpFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  remoteIpFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestTypeForm remoteIpFieldForChangeRequest(String initValue){
		return remoteIpFieldForChangeRequest("remoteIp",initValue);
	}
	public ChangeRequestTypeForm remoteIpFieldForChangeRequest(){
		return remoteIpFieldForChangeRequest("remoteIp","");
	}


	public ChangeRequestTypeForm requestTypeIdFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  requestTypeIdFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestTypeForm requestTypeIdFieldForChangeRequest(String initValue){
		return requestTypeIdFieldForChangeRequest("requestTypeId",initValue);
	}
	public ChangeRequestTypeForm requestTypeIdFieldForChangeRequest(){
		return requestTypeIdFieldForChangeRequest("requestTypeId","");
	}


	public ChangeRequestTypeForm networkIdFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  networkIdFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestTypeForm networkIdFieldForChangeRequest(String initValue){
		return networkIdFieldForChangeRequest("networkId",initValue);
	}
	public ChangeRequestTypeForm networkIdFieldForChangeRequest(){
		return networkIdFieldForChangeRequest("networkId","");
	}

	

	
 	public ChangeRequestTypeForm transferToAnotherNetworkAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherNetwork/changeRequestTypeId/");
		this.addFormAction(action);
		return this;
	}

 

	public ChangeRequestTypeForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


