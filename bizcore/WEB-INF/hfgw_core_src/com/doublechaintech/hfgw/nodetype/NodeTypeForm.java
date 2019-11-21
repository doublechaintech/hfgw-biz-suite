package com.doublechaintech.hfgw.nodetype;
import com.doublechaintech.hfgw.BaseForm;
import com.doublechaintech.hfgw.genericform.GenericForm;
import com.doublechaintech.hfgw.formfield.FormField;
import com.doublechaintech.hfgw.formaction.FormAction;
import com.doublechaintech.hfgw.formmessage.FormMessage;
import com.doublechaintech.hfgw.formfieldmessage.FormFieldMessage;



public class NodeTypeForm extends BaseForm {
	
	
	public NodeTypeForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public NodeTypeForm nodeTypeIdField(String parameterName, String initValue){
		FormField field = idFromNodeType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeTypeForm nodeTypeIdField(String initValue){
		return nodeTypeIdField("nodeTypeId",initValue);
	}
	public NodeTypeForm nodeTypeIdField(){
		return nodeTypeIdField("nodeTypeId","");
	}


	public NodeTypeForm nameField(String parameterName, String initValue){
		FormField field = nameFromNodeType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeTypeForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public NodeTypeForm nameField(){
		return nameField("name","");
	}


	public NodeTypeForm codeField(String parameterName, String initValue){
		FormField field = codeFromNodeType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeTypeForm codeField(String initValue){
		return codeField("code",initValue);
	}
	public NodeTypeForm codeField(){
		return codeField("code","");
	}


	public NodeTypeForm networkIdField(String parameterName, String initValue){
		FormField field = networkIdFromNodeType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeTypeForm networkIdField(String initValue){
		return networkIdField("networkId",initValue);
	}
	public NodeTypeForm networkIdField(){
		return networkIdField("networkId","");
	}


	public NodeTypeForm addressField(String parameterName, String initValue){
		FormField field = addressFromNodeType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeTypeForm addressField(String initValue){
		return addressField("address",initValue);
	}
	public NodeTypeForm addressField(){
		return addressField("address","");
	}


	public NodeTypeForm contactPersonField(String parameterName, String initValue){
		FormField field = contactPersonFromNodeType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeTypeForm contactPersonField(String initValue){
		return contactPersonField("contactPerson",initValue);
	}
	public NodeTypeForm contactPersonField(){
		return contactPersonField("contactPerson","");
	}


	public NodeTypeForm contactTelephoneField(String parameterName, String initValue){
		FormField field = contactTelephoneFromNodeType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeTypeForm contactTelephoneField(String initValue){
		return contactTelephoneField("contactTelephone",initValue);
	}
	public NodeTypeForm contactTelephoneField(){
		return contactTelephoneField("contactTelephone","");
	}

	
	


	public NodeTypeForm hyperledgerNetworkIdFieldOfHyperledgerNetwork(String parameterName, String initValue){
		FormField field =  idFromHyperledgerNetwork(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NodeTypeForm hyperledgerNetworkIdFieldOfHyperledgerNetwork(String initValue){
		return hyperledgerNetworkIdFieldOfHyperledgerNetwork("hyperledgerNetworkId",initValue);
	}
	public NodeTypeForm hyperledgerNetworkIdFieldOfHyperledgerNetwork(){
		return hyperledgerNetworkIdFieldOfHyperledgerNetwork("hyperledgerNetworkId","");
	}


	public NodeTypeForm nameFieldOfHyperledgerNetwork(String parameterName, String initValue){
		FormField field =  nameFromHyperledgerNetwork(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NodeTypeForm nameFieldOfHyperledgerNetwork(String initValue){
		return nameFieldOfHyperledgerNetwork("name",initValue);
	}
	public NodeTypeForm nameFieldOfHyperledgerNetwork(){
		return nameFieldOfHyperledgerNetwork("name","");
	}


	public NodeTypeForm descriptionFieldOfHyperledgerNetwork(String parameterName, String initValue){
		FormField field =  descriptionFromHyperledgerNetwork(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NodeTypeForm descriptionFieldOfHyperledgerNetwork(String initValue){
		return descriptionFieldOfHyperledgerNetwork("description",initValue);
	}
	public NodeTypeForm descriptionFieldOfHyperledgerNetwork(){
		return descriptionFieldOfHyperledgerNetwork("description","");
	}

	



	public NodeTypeForm nodeIdFieldForNode(String parameterName, String initValue){
		FormField field =  idFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeTypeForm nodeIdFieldForNode(String initValue){
		return nodeIdFieldForNode("nodeId",initValue);
	}
	public NodeTypeForm nodeIdFieldForNode(){
		return nodeIdFieldForNode("nodeId","");
	}


	public NodeTypeForm nameFieldForNode(String parameterName, String initValue){
		FormField field =  nameFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeTypeForm nameFieldForNode(String initValue){
		return nameFieldForNode("name",initValue);
	}
	public NodeTypeForm nameFieldForNode(){
		return nameFieldForNode("name","");
	}


	public NodeTypeForm urlFieldForNode(String parameterName, String initValue){
		FormField field =  urlFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeTypeForm urlFieldForNode(String initValue){
		return urlFieldForNode("url",initValue);
	}
	public NodeTypeForm urlFieldForNode(){
		return urlFieldForNode("url","");
	}


	public NodeTypeForm organizationIdFieldForNode(String parameterName, String initValue){
		FormField field =  organizationIdFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeTypeForm organizationIdFieldForNode(String initValue){
		return organizationIdFieldForNode("organizationId",initValue);
	}
	public NodeTypeForm organizationIdFieldForNode(){
		return organizationIdFieldForNode("organizationId","");
	}


	public NodeTypeForm channelIdFieldForNode(String parameterName, String initValue){
		FormField field =  channelIdFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeTypeForm channelIdFieldForNode(String initValue){
		return channelIdFieldForNode("channelId",initValue);
	}
	public NodeTypeForm channelIdFieldForNode(){
		return channelIdFieldForNode("channelId","");
	}


	public NodeTypeForm typeIdFieldForNode(String parameterName, String initValue){
		FormField field =  typeIdFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeTypeForm typeIdFieldForNode(String initValue){
		return typeIdFieldForNode("typeId",initValue);
	}
	public NodeTypeForm typeIdFieldForNode(){
		return typeIdFieldForNode("typeId","");
	}

	

	
 	public NodeTypeForm transferToAnotherNetworkAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherNetwork/nodeTypeId/");
		this.addFormAction(action);
		return this;
	}

 

	public NodeTypeForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


