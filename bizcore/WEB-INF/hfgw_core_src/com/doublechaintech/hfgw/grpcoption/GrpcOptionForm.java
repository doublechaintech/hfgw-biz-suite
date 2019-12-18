package com.doublechaintech.hfgw.grpcoption;
import com.doublechaintech.hfgw.BaseForm;
import com.doublechaintech.hfgw.genericform.GenericForm;
import com.doublechaintech.hfgw.formfield.FormField;
import com.doublechaintech.hfgw.formaction.FormAction;
import com.doublechaintech.hfgw.formmessage.FormMessage;
import com.doublechaintech.hfgw.formfieldmessage.FormFieldMessage;



public class GrpcOptionForm extends BaseForm {
	
	
	public GrpcOptionForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public GrpcOptionForm grpcOptionIdField(String parameterName, String initValue){
		FormField field = idFromGrpcOption(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GrpcOptionForm grpcOptionIdField(String initValue){
		return grpcOptionIdField("grpcOptionId",initValue);
	}
	public GrpcOptionForm grpcOptionIdField(){
		return grpcOptionIdField("grpcOptionId","");
	}


	public GrpcOptionForm parameterNameField(String parameterName, String initValue){
		FormField field = parameterNameFromGrpcOption(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GrpcOptionForm parameterNameField(String initValue){
		return parameterNameField("parameterName",initValue);
	}
	public GrpcOptionForm parameterNameField(){
		return parameterNameField("parameterName","");
	}


	public GrpcOptionForm parameterValueField(String parameterName, String initValue){
		FormField field = parameterValueFromGrpcOption(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GrpcOptionForm parameterValueField(String initValue){
		return parameterValueField("parameterValue",initValue);
	}
	public GrpcOptionForm parameterValueField(){
		return parameterValueField("parameterValue","");
	}


	public GrpcOptionForm nodeIdField(String parameterName, String initValue){
		FormField field = nodeIdFromGrpcOption(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GrpcOptionForm nodeIdField(String initValue){
		return nodeIdField("nodeId",initValue);
	}
	public GrpcOptionForm nodeIdField(){
		return nodeIdField("nodeId","");
	}

	
	


	public GrpcOptionForm nodeIdFieldOfNode(String parameterName, String initValue){
		FormField field =  idFromNode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GrpcOptionForm nodeIdFieldOfNode(String initValue){
		return nodeIdFieldOfNode("nodeId",initValue);
	}
	public GrpcOptionForm nodeIdFieldOfNode(){
		return nodeIdFieldOfNode("nodeId","");
	}


	public GrpcOptionForm nameFieldOfNode(String parameterName, String initValue){
		FormField field =  nameFromNode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GrpcOptionForm nameFieldOfNode(String initValue){
		return nameFieldOfNode("name",initValue);
	}
	public GrpcOptionForm nameFieldOfNode(){
		return nameFieldOfNode("name","");
	}


	public GrpcOptionForm urlFieldOfNode(String parameterName, String initValue){
		FormField field =  urlFromNode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GrpcOptionForm urlFieldOfNode(String initValue){
		return urlFieldOfNode("url",initValue);
	}
	public GrpcOptionForm urlFieldOfNode(){
		return urlFieldOfNode("url","");
	}


	public GrpcOptionForm organizationIdFieldOfNode(String parameterName, String initValue){
		FormField field =  organizationIdFromNode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GrpcOptionForm organizationIdFieldOfNode(String initValue){
		return organizationIdFieldOfNode("organizationId",initValue);
	}
	public GrpcOptionForm organizationIdFieldOfNode(){
		return organizationIdFieldOfNode("organizationId","");
	}


	public GrpcOptionForm channelIdFieldOfNode(String parameterName, String initValue){
		FormField field =  channelIdFromNode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GrpcOptionForm channelIdFieldOfNode(String initValue){
		return channelIdFieldOfNode("channelId",initValue);
	}
	public GrpcOptionForm channelIdFieldOfNode(){
		return channelIdFieldOfNode("channelId","");
	}


	public GrpcOptionForm networkIdFieldOfNode(String parameterName, String initValue){
		FormField field =  networkIdFromNode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GrpcOptionForm networkIdFieldOfNode(String initValue){
		return networkIdFieldOfNode("networkId",initValue);
	}
	public GrpcOptionForm networkIdFieldOfNode(){
		return networkIdFieldOfNode("networkId","");
	}


	public GrpcOptionForm tlsCacertFieldOfNode(String parameterName, String initValue){
		FormField field =  tlsCacertFromNode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GrpcOptionForm tlsCacertFieldOfNode(String initValue){
		return tlsCacertFieldOfNode("tlsCacert",initValue);
	}
	public GrpcOptionForm tlsCacertFieldOfNode(){
		return tlsCacertFieldOfNode("tlsCacert","");
	}


	public GrpcOptionForm typeIdFieldOfNode(String parameterName, String initValue){
		FormField field =  typeIdFromNode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GrpcOptionForm typeIdFieldOfNode(String initValue){
		return typeIdFieldOfNode("typeId",initValue);
	}
	public GrpcOptionForm typeIdFieldOfNode(){
		return typeIdFieldOfNode("typeId","");
	}


	public GrpcOptionForm addressFieldOfNode(String parameterName, String initValue){
		FormField field =  addressFromNode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GrpcOptionForm addressFieldOfNode(String initValue){
		return addressFieldOfNode("address",initValue);
	}
	public GrpcOptionForm addressFieldOfNode(){
		return addressFieldOfNode("address","");
	}


	public GrpcOptionForm contactPersonFieldOfNode(String parameterName, String initValue){
		FormField field =  contactPersonFromNode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GrpcOptionForm contactPersonFieldOfNode(String initValue){
		return contactPersonFieldOfNode("contactPerson",initValue);
	}
	public GrpcOptionForm contactPersonFieldOfNode(){
		return contactPersonFieldOfNode("contactPerson","");
	}


	public GrpcOptionForm contactTelephoneFieldOfNode(String parameterName, String initValue){
		FormField field =  contactTelephoneFromNode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GrpcOptionForm contactTelephoneFieldOfNode(String initValue){
		return contactTelephoneFieldOfNode("contactTelephone",initValue);
	}
	public GrpcOptionForm contactTelephoneFieldOfNode(){
		return contactTelephoneFieldOfNode("contactTelephone","");
	}

	


	

	
 	public GrpcOptionForm transferToAnotherNodeAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherNode/grpcOptionId/");
		this.addFormAction(action);
		return this;
	}

 

	public GrpcOptionForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


