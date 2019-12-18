package com.doublechaintech.hfgw.channelpeerrole;
import com.doublechaintech.hfgw.BaseForm;
import com.doublechaintech.hfgw.genericform.GenericForm;
import com.doublechaintech.hfgw.formfield.FormField;
import com.doublechaintech.hfgw.formaction.FormAction;
import com.doublechaintech.hfgw.formmessage.FormMessage;
import com.doublechaintech.hfgw.formfieldmessage.FormFieldMessage;



public class ChannelPeerRoleForm extends BaseForm {
	
	
	public ChannelPeerRoleForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ChannelPeerRoleForm channelPeerRoleIdField(String parameterName, String initValue){
		FormField field = idFromChannelPeerRole(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelPeerRoleForm channelPeerRoleIdField(String initValue){
		return channelPeerRoleIdField("channelPeerRoleId",initValue);
	}
	public ChannelPeerRoleForm channelPeerRoleIdField(){
		return channelPeerRoleIdField("channelPeerRoleId","");
	}


	public ChannelPeerRoleForm channelIdField(String parameterName, String initValue){
		FormField field = channelIdFromChannelPeerRole(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelPeerRoleForm channelIdField(String initValue){
		return channelIdField("channelId",initValue);
	}
	public ChannelPeerRoleForm channelIdField(){
		return channelIdField("channelId","");
	}


	public ChannelPeerRoleForm nodeIdField(String parameterName, String initValue){
		FormField field = nodeIdFromChannelPeerRole(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelPeerRoleForm nodeIdField(String initValue){
		return nodeIdField("nodeId",initValue);
	}
	public ChannelPeerRoleForm nodeIdField(){
		return nodeIdField("nodeId","");
	}


	public ChannelPeerRoleForm peerRoleIdField(String parameterName, String initValue){
		FormField field = peerRoleIdFromChannelPeerRole(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChannelPeerRoleForm peerRoleIdField(String initValue){
		return peerRoleIdField("peerRoleId",initValue);
	}
	public ChannelPeerRoleForm peerRoleIdField(){
		return peerRoleIdField("peerRoleId","");
	}

	
	


	public ChannelPeerRoleForm channelIdFieldOfChannel(String parameterName, String initValue){
		FormField field =  idFromChannel(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChannelPeerRoleForm channelIdFieldOfChannel(String initValue){
		return channelIdFieldOfChannel("channelId",initValue);
	}
	public ChannelPeerRoleForm channelIdFieldOfChannel(){
		return channelIdFieldOfChannel("channelId","");
	}


	public ChannelPeerRoleForm nameFieldOfChannel(String parameterName, String initValue){
		FormField field =  nameFromChannel(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChannelPeerRoleForm nameFieldOfChannel(String initValue){
		return nameFieldOfChannel("name",initValue);
	}
	public ChannelPeerRoleForm nameFieldOfChannel(){
		return nameFieldOfChannel("name","");
	}


	public ChannelPeerRoleForm networkIdFieldOfChannel(String parameterName, String initValue){
		FormField field =  networkIdFromChannel(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChannelPeerRoleForm networkIdFieldOfChannel(String initValue){
		return networkIdFieldOfChannel("networkId",initValue);
	}
	public ChannelPeerRoleForm networkIdFieldOfChannel(){
		return networkIdFieldOfChannel("networkId","");
	}


	public ChannelPeerRoleForm nodeIdFieldOfNode(String parameterName, String initValue){
		FormField field =  idFromNode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChannelPeerRoleForm nodeIdFieldOfNode(String initValue){
		return nodeIdFieldOfNode("nodeId",initValue);
	}
	public ChannelPeerRoleForm nodeIdFieldOfNode(){
		return nodeIdFieldOfNode("nodeId","");
	}


	public ChannelPeerRoleForm nameFieldOfNode(String parameterName, String initValue){
		FormField field =  nameFromNode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChannelPeerRoleForm nameFieldOfNode(String initValue){
		return nameFieldOfNode("name",initValue);
	}
	public ChannelPeerRoleForm nameFieldOfNode(){
		return nameFieldOfNode("name","");
	}


	public ChannelPeerRoleForm urlFieldOfNode(String parameterName, String initValue){
		FormField field =  urlFromNode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChannelPeerRoleForm urlFieldOfNode(String initValue){
		return urlFieldOfNode("url",initValue);
	}
	public ChannelPeerRoleForm urlFieldOfNode(){
		return urlFieldOfNode("url","");
	}


	public ChannelPeerRoleForm organizationIdFieldOfNode(String parameterName, String initValue){
		FormField field =  organizationIdFromNode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChannelPeerRoleForm organizationIdFieldOfNode(String initValue){
		return organizationIdFieldOfNode("organizationId",initValue);
	}
	public ChannelPeerRoleForm organizationIdFieldOfNode(){
		return organizationIdFieldOfNode("organizationId","");
	}


	public ChannelPeerRoleForm channelIdFieldOfNode(String parameterName, String initValue){
		FormField field =  channelIdFromNode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChannelPeerRoleForm channelIdFieldOfNode(String initValue){
		return channelIdFieldOfNode("channelId",initValue);
	}
	public ChannelPeerRoleForm channelIdFieldOfNode(){
		return channelIdFieldOfNode("channelId","");
	}


	public ChannelPeerRoleForm networkIdFieldOfNode(String parameterName, String initValue){
		FormField field =  networkIdFromNode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChannelPeerRoleForm networkIdFieldOfNode(String initValue){
		return networkIdFieldOfNode("networkId",initValue);
	}
	public ChannelPeerRoleForm networkIdFieldOfNode(){
		return networkIdFieldOfNode("networkId","");
	}


	public ChannelPeerRoleForm tlsCacertFieldOfNode(String parameterName, String initValue){
		FormField field =  tlsCacertFromNode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChannelPeerRoleForm tlsCacertFieldOfNode(String initValue){
		return tlsCacertFieldOfNode("tlsCacert",initValue);
	}
	public ChannelPeerRoleForm tlsCacertFieldOfNode(){
		return tlsCacertFieldOfNode("tlsCacert","");
	}


	public ChannelPeerRoleForm typeIdFieldOfNode(String parameterName, String initValue){
		FormField field =  typeIdFromNode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChannelPeerRoleForm typeIdFieldOfNode(String initValue){
		return typeIdFieldOfNode("typeId",initValue);
	}
	public ChannelPeerRoleForm typeIdFieldOfNode(){
		return typeIdFieldOfNode("typeId","");
	}


	public ChannelPeerRoleForm addressFieldOfNode(String parameterName, String initValue){
		FormField field =  addressFromNode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChannelPeerRoleForm addressFieldOfNode(String initValue){
		return addressFieldOfNode("address",initValue);
	}
	public ChannelPeerRoleForm addressFieldOfNode(){
		return addressFieldOfNode("address","");
	}


	public ChannelPeerRoleForm contactPersonFieldOfNode(String parameterName, String initValue){
		FormField field =  contactPersonFromNode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChannelPeerRoleForm contactPersonFieldOfNode(String initValue){
		return contactPersonFieldOfNode("contactPerson",initValue);
	}
	public ChannelPeerRoleForm contactPersonFieldOfNode(){
		return contactPersonFieldOfNode("contactPerson","");
	}


	public ChannelPeerRoleForm contactTelephoneFieldOfNode(String parameterName, String initValue){
		FormField field =  contactTelephoneFromNode(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChannelPeerRoleForm contactTelephoneFieldOfNode(String initValue){
		return contactTelephoneFieldOfNode("contactTelephone",initValue);
	}
	public ChannelPeerRoleForm contactTelephoneFieldOfNode(){
		return contactTelephoneFieldOfNode("contactTelephone","");
	}


	public ChannelPeerRoleForm peerRoleIdFieldOfPeerRole(String parameterName, String initValue){
		FormField field =  idFromPeerRole(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChannelPeerRoleForm peerRoleIdFieldOfPeerRole(String initValue){
		return peerRoleIdFieldOfPeerRole("peerRoleId",initValue);
	}
	public ChannelPeerRoleForm peerRoleIdFieldOfPeerRole(){
		return peerRoleIdFieldOfPeerRole("peerRoleId","");
	}


	public ChannelPeerRoleForm nameFieldOfPeerRole(String parameterName, String initValue){
		FormField field =  nameFromPeerRole(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChannelPeerRoleForm nameFieldOfPeerRole(String initValue){
		return nameFieldOfPeerRole("name",initValue);
	}
	public ChannelPeerRoleForm nameFieldOfPeerRole(){
		return nameFieldOfPeerRole("name","");
	}


	public ChannelPeerRoleForm codeFieldOfPeerRole(String parameterName, String initValue){
		FormField field =  codeFromPeerRole(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChannelPeerRoleForm codeFieldOfPeerRole(String initValue){
		return codeFieldOfPeerRole("code",initValue);
	}
	public ChannelPeerRoleForm codeFieldOfPeerRole(){
		return codeFieldOfPeerRole("code","");
	}


	public ChannelPeerRoleForm networkIdFieldOfPeerRole(String parameterName, String initValue){
		FormField field =  networkIdFromPeerRole(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChannelPeerRoleForm networkIdFieldOfPeerRole(String initValue){
		return networkIdFieldOfPeerRole("networkId",initValue);
	}
	public ChannelPeerRoleForm networkIdFieldOfPeerRole(){
		return networkIdFieldOfPeerRole("networkId","");
	}

	


	

	
 	public ChannelPeerRoleForm transferToAnotherChannelAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherChannel/channelPeerRoleId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public ChannelPeerRoleForm transferToAnotherNodeAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherNode/channelPeerRoleId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public ChannelPeerRoleForm transferToAnotherPeerRoleAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPeerRole/channelPeerRoleId/");
		this.addFormAction(action);
		return this;
	}

 

	public ChannelPeerRoleForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


