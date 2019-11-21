package com.doublechaintech.hfgw.peerrole;
import com.doublechaintech.hfgw.BaseForm;
import com.doublechaintech.hfgw.genericform.GenericForm;
import com.doublechaintech.hfgw.formfield.FormField;
import com.doublechaintech.hfgw.formaction.FormAction;
import com.doublechaintech.hfgw.formmessage.FormMessage;
import com.doublechaintech.hfgw.formfieldmessage.FormFieldMessage;



public class PeerRoleForm extends BaseForm {
	
	
	public PeerRoleForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public PeerRoleForm peerRoleIdField(String parameterName, String initValue){
		FormField field = idFromPeerRole(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PeerRoleForm peerRoleIdField(String initValue){
		return peerRoleIdField("peerRoleId",initValue);
	}
	public PeerRoleForm peerRoleIdField(){
		return peerRoleIdField("peerRoleId","");
	}


	public PeerRoleForm nameField(String parameterName, String initValue){
		FormField field = nameFromPeerRole(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PeerRoleForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public PeerRoleForm nameField(){
		return nameField("name","");
	}


	public PeerRoleForm codeField(String parameterName, String initValue){
		FormField field = codeFromPeerRole(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PeerRoleForm codeField(String initValue){
		return codeField("code",initValue);
	}
	public PeerRoleForm codeField(){
		return codeField("code","");
	}

	
	

	



	public PeerRoleForm channelPeerRoleIdFieldForChannelPeerRole(String parameterName, String initValue){
		FormField field =  idFromChannelPeerRole(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PeerRoleForm channelPeerRoleIdFieldForChannelPeerRole(String initValue){
		return channelPeerRoleIdFieldForChannelPeerRole("channelPeerRoleId",initValue);
	}
	public PeerRoleForm channelPeerRoleIdFieldForChannelPeerRole(){
		return channelPeerRoleIdFieldForChannelPeerRole("channelPeerRoleId","");
	}


	public PeerRoleForm channelIdFieldForChannelPeerRole(String parameterName, String initValue){
		FormField field =  channelIdFromChannelPeerRole(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PeerRoleForm channelIdFieldForChannelPeerRole(String initValue){
		return channelIdFieldForChannelPeerRole("channelId",initValue);
	}
	public PeerRoleForm channelIdFieldForChannelPeerRole(){
		return channelIdFieldForChannelPeerRole("channelId","");
	}


	public PeerRoleForm nodeIdFieldForChannelPeerRole(String parameterName, String initValue){
		FormField field =  nodeIdFromChannelPeerRole(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PeerRoleForm nodeIdFieldForChannelPeerRole(String initValue){
		return nodeIdFieldForChannelPeerRole("nodeId",initValue);
	}
	public PeerRoleForm nodeIdFieldForChannelPeerRole(){
		return nodeIdFieldForChannelPeerRole("nodeId","");
	}


	public PeerRoleForm peerRoleIdFieldForChannelPeerRole(String parameterName, String initValue){
		FormField field =  peerRoleIdFromChannelPeerRole(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PeerRoleForm peerRoleIdFieldForChannelPeerRole(String initValue){
		return peerRoleIdFieldForChannelPeerRole("peerRoleId",initValue);
	}
	public PeerRoleForm peerRoleIdFieldForChannelPeerRole(){
		return peerRoleIdFieldForChannelPeerRole("peerRoleId","");
	}

	



	public PeerRoleForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


