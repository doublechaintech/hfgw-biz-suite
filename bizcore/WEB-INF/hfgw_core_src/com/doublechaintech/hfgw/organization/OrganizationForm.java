package com.doublechaintech.hfgw.organization;
import com.doublechaintech.hfgw.BaseForm;
import com.doublechaintech.hfgw.genericform.GenericForm;
import com.doublechaintech.hfgw.formfield.FormField;
import com.doublechaintech.hfgw.formaction.FormAction;
import com.doublechaintech.hfgw.formmessage.FormMessage;
import com.doublechaintech.hfgw.formfieldmessage.FormFieldMessage;



public class OrganizationForm extends BaseForm {
	
	
	public OrganizationForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public OrganizationForm organizationIdField(String parameterName, String initValue){
		FormField field = idFromOrganization(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OrganizationForm organizationIdField(String initValue){
		return organizationIdField("organizationId",initValue);
	}
	public OrganizationForm organizationIdField(){
		return organizationIdField("organizationId","");
	}


	public OrganizationForm nameField(String parameterName, String initValue){
		FormField field = nameFromOrganization(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OrganizationForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public OrganizationForm nameField(){
		return nameField("name","");
	}


	public OrganizationForm mspidField(String parameterName, String initValue){
		FormField field = mspidFromOrganization(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OrganizationForm mspidField(String initValue){
		return mspidField("mspid",initValue);
	}
	public OrganizationForm mspidField(){
		return mspidField("mspid","");
	}


	public OrganizationForm networkIdField(String parameterName, String initValue){
		FormField field = networkIdFromOrganization(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OrganizationForm networkIdField(String initValue){
		return networkIdField("networkId",initValue);
	}
	public OrganizationForm networkIdField(){
		return networkIdField("networkId","");
	}

	
	


	public OrganizationForm hyperledgerNetworkIdFieldOfHyperledgerNetwork(String parameterName, String initValue){
		FormField field =  idFromHyperledgerNetwork(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OrganizationForm hyperledgerNetworkIdFieldOfHyperledgerNetwork(String initValue){
		return hyperledgerNetworkIdFieldOfHyperledgerNetwork("hyperledgerNetworkId",initValue);
	}
	public OrganizationForm hyperledgerNetworkIdFieldOfHyperledgerNetwork(){
		return hyperledgerNetworkIdFieldOfHyperledgerNetwork("hyperledgerNetworkId","");
	}


	public OrganizationForm nameFieldOfHyperledgerNetwork(String parameterName, String initValue){
		FormField field =  nameFromHyperledgerNetwork(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OrganizationForm nameFieldOfHyperledgerNetwork(String initValue){
		return nameFieldOfHyperledgerNetwork("name",initValue);
	}
	public OrganizationForm nameFieldOfHyperledgerNetwork(){
		return nameFieldOfHyperledgerNetwork("name","");
	}


	public OrganizationForm descriptionFieldOfHyperledgerNetwork(String parameterName, String initValue){
		FormField field =  descriptionFromHyperledgerNetwork(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OrganizationForm descriptionFieldOfHyperledgerNetwork(String initValue){
		return descriptionFieldOfHyperledgerNetwork("description",initValue);
	}
	public OrganizationForm descriptionFieldOfHyperledgerNetwork(){
		return descriptionFieldOfHyperledgerNetwork("description","");
	}

	



	public OrganizationForm nodeIdFieldForNode(String parameterName, String initValue){
		FormField field =  idFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OrganizationForm nodeIdFieldForNode(String initValue){
		return nodeIdFieldForNode("nodeId",initValue);
	}
	public OrganizationForm nodeIdFieldForNode(){
		return nodeIdFieldForNode("nodeId","");
	}


	public OrganizationForm nameFieldForNode(String parameterName, String initValue){
		FormField field =  nameFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OrganizationForm nameFieldForNode(String initValue){
		return nameFieldForNode("name",initValue);
	}
	public OrganizationForm nameFieldForNode(){
		return nameFieldForNode("name","");
	}


	public OrganizationForm urlFieldForNode(String parameterName, String initValue){
		FormField field =  urlFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OrganizationForm urlFieldForNode(String initValue){
		return urlFieldForNode("url",initValue);
	}
	public OrganizationForm urlFieldForNode(){
		return urlFieldForNode("url","");
	}


	public OrganizationForm organizationIdFieldForNode(String parameterName, String initValue){
		FormField field =  organizationIdFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OrganizationForm organizationIdFieldForNode(String initValue){
		return organizationIdFieldForNode("organizationId",initValue);
	}
	public OrganizationForm organizationIdFieldForNode(){
		return organizationIdFieldForNode("organizationId","");
	}


	public OrganizationForm channelIdFieldForNode(String parameterName, String initValue){
		FormField field =  channelIdFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OrganizationForm channelIdFieldForNode(String initValue){
		return channelIdFieldForNode("channelId",initValue);
	}
	public OrganizationForm channelIdFieldForNode(){
		return channelIdFieldForNode("channelId","");
	}


	public OrganizationForm networkIdFieldForNode(String parameterName, String initValue){
		FormField field =  networkIdFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OrganizationForm networkIdFieldForNode(String initValue){
		return networkIdFieldForNode("networkId",initValue);
	}
	public OrganizationForm networkIdFieldForNode(){
		return networkIdFieldForNode("networkId","");
	}


	public OrganizationForm tlsCacertFieldForNode(String parameterName, String initValue){
		FormField field =  tlsCacertFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OrganizationForm tlsCacertFieldForNode(String initValue){
		return tlsCacertFieldForNode("tlsCacert",initValue);
	}
	public OrganizationForm tlsCacertFieldForNode(){
		return tlsCacertFieldForNode("tlsCacert","");
	}


	public OrganizationForm typeIdFieldForNode(String parameterName, String initValue){
		FormField field =  typeIdFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OrganizationForm typeIdFieldForNode(String initValue){
		return typeIdFieldForNode("typeId",initValue);
	}
	public OrganizationForm typeIdFieldForNode(){
		return typeIdFieldForNode("typeId","");
	}


	public OrganizationForm addressFieldForNode(String parameterName, String initValue){
		FormField field =  addressFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OrganizationForm addressFieldForNode(String initValue){
		return addressFieldForNode("address",initValue);
	}
	public OrganizationForm addressFieldForNode(){
		return addressFieldForNode("address","");
	}


	public OrganizationForm contactPersonFieldForNode(String parameterName, String initValue){
		FormField field =  contactPersonFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OrganizationForm contactPersonFieldForNode(String initValue){
		return contactPersonFieldForNode("contactPerson",initValue);
	}
	public OrganizationForm contactPersonFieldForNode(){
		return contactPersonFieldForNode("contactPerson","");
	}


	public OrganizationForm contactTelephoneFieldForNode(String parameterName, String initValue){
		FormField field =  contactTelephoneFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OrganizationForm contactTelephoneFieldForNode(String initValue){
		return contactTelephoneFieldForNode("contactTelephone",initValue);
	}
	public OrganizationForm contactTelephoneFieldForNode(){
		return contactTelephoneFieldForNode("contactTelephone","");
	}

	

	
 	public OrganizationForm transferToAnotherNetworkAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherNetwork/organizationId/");
		this.addFormAction(action);
		return this;
	}

 

	public OrganizationForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


