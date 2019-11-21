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


	public NodeTypeForm networkIdFieldForNode(String parameterName, String initValue){
		FormField field =  networkIdFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeTypeForm networkIdFieldForNode(String initValue){
		return networkIdFieldForNode("networkId",initValue);
	}
	public NodeTypeForm networkIdFieldForNode(){
		return networkIdFieldForNode("networkId","");
	}


	public NodeTypeForm tlsCacertFieldForNode(String parameterName, String initValue){
		FormField field =  tlsCacertFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeTypeForm tlsCacertFieldForNode(String initValue){
		return tlsCacertFieldForNode("tlsCacert",initValue);
	}
	public NodeTypeForm tlsCacertFieldForNode(){
		return tlsCacertFieldForNode("tlsCacert","");
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


	public NodeTypeForm addressFieldForNode(String parameterName, String initValue){
		FormField field =  addressFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeTypeForm addressFieldForNode(String initValue){
		return addressFieldForNode("address",initValue);
	}
	public NodeTypeForm addressFieldForNode(){
		return addressFieldForNode("address","");
	}


	public NodeTypeForm contactPersonFieldForNode(String parameterName, String initValue){
		FormField field =  contactPersonFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeTypeForm contactPersonFieldForNode(String initValue){
		return contactPersonFieldForNode("contactPerson",initValue);
	}
	public NodeTypeForm contactPersonFieldForNode(){
		return contactPersonFieldForNode("contactPerson","");
	}


	public NodeTypeForm contactTelephoneFieldForNode(String parameterName, String initValue){
		FormField field =  contactTelephoneFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeTypeForm contactTelephoneFieldForNode(String initValue){
		return contactTelephoneFieldForNode("contactTelephone",initValue);
	}
	public NodeTypeForm contactTelephoneFieldForNode(){
		return contactTelephoneFieldForNode("contactTelephone","");
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


