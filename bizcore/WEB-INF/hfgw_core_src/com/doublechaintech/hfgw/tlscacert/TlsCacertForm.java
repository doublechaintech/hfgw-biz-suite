package com.doublechaintech.hfgw.tlscacert;
import com.doublechaintech.hfgw.BaseForm;
import com.doublechaintech.hfgw.genericform.GenericForm;
import com.doublechaintech.hfgw.formfield.FormField;
import com.doublechaintech.hfgw.formaction.FormAction;
import com.doublechaintech.hfgw.formmessage.FormMessage;
import com.doublechaintech.hfgw.formfieldmessage.FormFieldMessage;



public class TlsCacertForm extends BaseForm {
	
	
	public TlsCacertForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public TlsCacertForm tlsCacertIdField(String parameterName, String initValue){
		FormField field = idFromTlsCacert(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TlsCacertForm tlsCacertIdField(String initValue){
		return tlsCacertIdField("tlsCacertId",initValue);
	}
	public TlsCacertForm tlsCacertIdField(){
		return tlsCacertIdField("tlsCacertId","");
	}


	public TlsCacertForm pathField(String parameterName, String initValue){
		FormField field = pathFromTlsCacert(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TlsCacertForm pathField(String initValue){
		return pathField("path",initValue);
	}
	public TlsCacertForm pathField(){
		return pathField("path","");
	}


	public TlsCacertForm certField(String parameterName, String initValue){
		FormField field = certFromTlsCacert(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TlsCacertForm certField(String initValue){
		return certField("cert",initValue);
	}
	public TlsCacertForm certField(){
		return certField("cert","");
	}


	public TlsCacertForm nodeIdField(String parameterName, String initValue){
		FormField field = nodeIdFromTlsCacert(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TlsCacertForm nodeIdField(String initValue){
		return nodeIdField("nodeId",initValue);
	}
	public TlsCacertForm nodeIdField(){
		return nodeIdField("nodeId","");
	}

	
	


	public TlsCacertForm nodeIdFieldOfNode(String parameterName, String initValue){
		FormField field =  idFromNode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TlsCacertForm nodeIdFieldOfNode(String initValue){
		return nodeIdFieldOfNode("nodeId",initValue);
	}
	public TlsCacertForm nodeIdFieldOfNode(){
		return nodeIdFieldOfNode("nodeId","");
	}


	public TlsCacertForm nameFieldOfNode(String parameterName, String initValue){
		FormField field =  nameFromNode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TlsCacertForm nameFieldOfNode(String initValue){
		return nameFieldOfNode("name",initValue);
	}
	public TlsCacertForm nameFieldOfNode(){
		return nameFieldOfNode("name","");
	}


	public TlsCacertForm urlFieldOfNode(String parameterName, String initValue){
		FormField field =  urlFromNode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TlsCacertForm urlFieldOfNode(String initValue){
		return urlFieldOfNode("url",initValue);
	}
	public TlsCacertForm urlFieldOfNode(){
		return urlFieldOfNode("url","");
	}


	public TlsCacertForm organizationIdFieldOfNode(String parameterName, String initValue){
		FormField field =  organizationIdFromNode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TlsCacertForm organizationIdFieldOfNode(String initValue){
		return organizationIdFieldOfNode("organizationId",initValue);
	}
	public TlsCacertForm organizationIdFieldOfNode(){
		return organizationIdFieldOfNode("organizationId","");
	}


	public TlsCacertForm channelIdFieldOfNode(String parameterName, String initValue){
		FormField field =  channelIdFromNode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TlsCacertForm channelIdFieldOfNode(String initValue){
		return channelIdFieldOfNode("channelId",initValue);
	}
	public TlsCacertForm channelIdFieldOfNode(){
		return channelIdFieldOfNode("channelId","");
	}


	public TlsCacertForm typeIdFieldOfNode(String parameterName, String initValue){
		FormField field =  typeIdFromNode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TlsCacertForm typeIdFieldOfNode(String initValue){
		return typeIdFieldOfNode("typeId",initValue);
	}
	public TlsCacertForm typeIdFieldOfNode(){
		return typeIdFieldOfNode("typeId","");
	}

	


	

	
 	public TlsCacertForm transferToAnotherNodeAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherNode/tlsCacertId/");
		this.addFormAction(action);
		return this;
	}

 

	public TlsCacertForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


