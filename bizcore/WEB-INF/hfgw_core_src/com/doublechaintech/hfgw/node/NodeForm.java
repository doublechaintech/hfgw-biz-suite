package com.doublechaintech.hfgw.node;
import com.doublechaintech.hfgw.BaseForm;
import com.doublechaintech.hfgw.genericform.GenericForm;
import com.doublechaintech.hfgw.formfield.FormField;
import com.doublechaintech.hfgw.formaction.FormAction;
import com.doublechaintech.hfgw.formmessage.FormMessage;
import com.doublechaintech.hfgw.formfieldmessage.FormFieldMessage;



public class NodeForm extends BaseForm {
	
	
	public NodeForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public NodeForm nodeIdField(String parameterName, String initValue){
		FormField field = idFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeForm nodeIdField(String initValue){
		return nodeIdField("nodeId",initValue);
	}
	public NodeForm nodeIdField(){
		return nodeIdField("nodeId","");
	}


	public NodeForm nameField(String parameterName, String initValue){
		FormField field = nameFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public NodeForm nameField(){
		return nameField("name","");
	}


	public NodeForm urlField(String parameterName, String initValue){
		FormField field = urlFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeForm urlField(String initValue){
		return urlField("url",initValue);
	}
	public NodeForm urlField(){
		return urlField("url","");
	}


	public NodeForm organizationIdField(String parameterName, String initValue){
		FormField field = organizationIdFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeForm organizationIdField(String initValue){
		return organizationIdField("organizationId",initValue);
	}
	public NodeForm organizationIdField(){
		return organizationIdField("organizationId","");
	}


	public NodeForm channelIdField(String parameterName, String initValue){
		FormField field = channelIdFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeForm channelIdField(String initValue){
		return channelIdField("channelId",initValue);
	}
	public NodeForm channelIdField(){
		return channelIdField("channelId","");
	}


	public NodeForm networkIdField(String parameterName, String initValue){
		FormField field = networkIdFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeForm networkIdField(String initValue){
		return networkIdField("networkId",initValue);
	}
	public NodeForm networkIdField(){
		return networkIdField("networkId","");
	}


	public NodeForm tlsCacertField(String parameterName, String initValue){
		FormField field = tlsCacertFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeForm tlsCacertField(String initValue){
		return tlsCacertField("tlsCacert",initValue);
	}
	public NodeForm tlsCacertField(){
		return tlsCacertField("tlsCacert","");
	}


	public NodeForm typeIdField(String parameterName, String initValue){
		FormField field = typeIdFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeForm typeIdField(String initValue){
		return typeIdField("typeId",initValue);
	}
	public NodeForm typeIdField(){
		return typeIdField("typeId","");
	}


	public NodeForm addressField(String parameterName, String initValue){
		FormField field = addressFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeForm addressField(String initValue){
		return addressField("address",initValue);
	}
	public NodeForm addressField(){
		return addressField("address","");
	}


	public NodeForm contactPersonField(String parameterName, String initValue){
		FormField field = contactPersonFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeForm contactPersonField(String initValue){
		return contactPersonField("contactPerson",initValue);
	}
	public NodeForm contactPersonField(){
		return contactPersonField("contactPerson","");
	}


	public NodeForm contactTelephoneField(String parameterName, String initValue){
		FormField field = contactTelephoneFromNode(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeForm contactTelephoneField(String initValue){
		return contactTelephoneField("contactTelephone",initValue);
	}
	public NodeForm contactTelephoneField(){
		return contactTelephoneField("contactTelephone","");
	}

	
	


	public NodeForm organizationIdFieldOfOrganization(String parameterName, String initValue){
		FormField field =  idFromOrganization(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NodeForm organizationIdFieldOfOrganization(String initValue){
		return organizationIdFieldOfOrganization("organizationId",initValue);
	}
	public NodeForm organizationIdFieldOfOrganization(){
		return organizationIdFieldOfOrganization("organizationId","");
	}


	public NodeForm nameFieldOfOrganization(String parameterName, String initValue){
		FormField field =  nameFromOrganization(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NodeForm nameFieldOfOrganization(String initValue){
		return nameFieldOfOrganization("name",initValue);
	}
	public NodeForm nameFieldOfOrganization(){
		return nameFieldOfOrganization("name","");
	}


	public NodeForm mspidFieldOfOrganization(String parameterName, String initValue){
		FormField field =  mspidFromOrganization(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NodeForm mspidFieldOfOrganization(String initValue){
		return mspidFieldOfOrganization("mspid",initValue);
	}
	public NodeForm mspidFieldOfOrganization(){
		return mspidFieldOfOrganization("mspid","");
	}


	public NodeForm networkIdFieldOfOrganization(String parameterName, String initValue){
		FormField field =  networkIdFromOrganization(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NodeForm networkIdFieldOfOrganization(String initValue){
		return networkIdFieldOfOrganization("networkId",initValue);
	}
	public NodeForm networkIdFieldOfOrganization(){
		return networkIdFieldOfOrganization("networkId","");
	}


	public NodeForm channelIdFieldOfChannel(String parameterName, String initValue){
		FormField field =  idFromChannel(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NodeForm channelIdFieldOfChannel(String initValue){
		return channelIdFieldOfChannel("channelId",initValue);
	}
	public NodeForm channelIdFieldOfChannel(){
		return channelIdFieldOfChannel("channelId","");
	}


	public NodeForm nameFieldOfChannel(String parameterName, String initValue){
		FormField field =  nameFromChannel(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NodeForm nameFieldOfChannel(String initValue){
		return nameFieldOfChannel("name",initValue);
	}
	public NodeForm nameFieldOfChannel(){
		return nameFieldOfChannel("name","");
	}


	public NodeForm networkIdFieldOfChannel(String parameterName, String initValue){
		FormField field =  networkIdFromChannel(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NodeForm networkIdFieldOfChannel(String initValue){
		return networkIdFieldOfChannel("networkId",initValue);
	}
	public NodeForm networkIdFieldOfChannel(){
		return networkIdFieldOfChannel("networkId","");
	}


	public NodeForm hyperledgerNetworkIdFieldOfHyperledgerNetwork(String parameterName, String initValue){
		FormField field =  idFromHyperledgerNetwork(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NodeForm hyperledgerNetworkIdFieldOfHyperledgerNetwork(String initValue){
		return hyperledgerNetworkIdFieldOfHyperledgerNetwork("hyperledgerNetworkId",initValue);
	}
	public NodeForm hyperledgerNetworkIdFieldOfHyperledgerNetwork(){
		return hyperledgerNetworkIdFieldOfHyperledgerNetwork("hyperledgerNetworkId","");
	}


	public NodeForm nameFieldOfHyperledgerNetwork(String parameterName, String initValue){
		FormField field =  nameFromHyperledgerNetwork(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NodeForm nameFieldOfHyperledgerNetwork(String initValue){
		return nameFieldOfHyperledgerNetwork("name",initValue);
	}
	public NodeForm nameFieldOfHyperledgerNetwork(){
		return nameFieldOfHyperledgerNetwork("name","");
	}


	public NodeForm descriptionFieldOfHyperledgerNetwork(String parameterName, String initValue){
		FormField field =  descriptionFromHyperledgerNetwork(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NodeForm descriptionFieldOfHyperledgerNetwork(String initValue){
		return descriptionFieldOfHyperledgerNetwork("description",initValue);
	}
	public NodeForm descriptionFieldOfHyperledgerNetwork(){
		return descriptionFieldOfHyperledgerNetwork("description","");
	}


	public NodeForm nodeTypeIdFieldOfNodeType(String parameterName, String initValue){
		FormField field =  idFromNodeType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NodeForm nodeTypeIdFieldOfNodeType(String initValue){
		return nodeTypeIdFieldOfNodeType("nodeTypeId",initValue);
	}
	public NodeForm nodeTypeIdFieldOfNodeType(){
		return nodeTypeIdFieldOfNodeType("nodeTypeId","");
	}


	public NodeForm nameFieldOfNodeType(String parameterName, String initValue){
		FormField field =  nameFromNodeType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NodeForm nameFieldOfNodeType(String initValue){
		return nameFieldOfNodeType("name",initValue);
	}
	public NodeForm nameFieldOfNodeType(){
		return nameFieldOfNodeType("name","");
	}


	public NodeForm codeFieldOfNodeType(String parameterName, String initValue){
		FormField field =  codeFromNodeType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public NodeForm codeFieldOfNodeType(String initValue){
		return codeFieldOfNodeType("code",initValue);
	}
	public NodeForm codeFieldOfNodeType(){
		return codeFieldOfNodeType("code","");
	}

	



	public NodeForm grpcOptionIdFieldForGrpcOption(String parameterName, String initValue){
		FormField field =  idFromGrpcOption(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeForm grpcOptionIdFieldForGrpcOption(String initValue){
		return grpcOptionIdFieldForGrpcOption("grpcOptionId",initValue);
	}
	public NodeForm grpcOptionIdFieldForGrpcOption(){
		return grpcOptionIdFieldForGrpcOption("grpcOptionId","");
	}


	public NodeForm parameterNameFieldForGrpcOption(String parameterName, String initValue){
		FormField field =  parameterNameFromGrpcOption(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeForm parameterNameFieldForGrpcOption(String initValue){
		return parameterNameFieldForGrpcOption("parameterName",initValue);
	}
	public NodeForm parameterNameFieldForGrpcOption(){
		return parameterNameFieldForGrpcOption("parameterName","");
	}


	public NodeForm parameterValueFieldForGrpcOption(String parameterName, String initValue){
		FormField field =  parameterValueFromGrpcOption(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeForm parameterValueFieldForGrpcOption(String initValue){
		return parameterValueFieldForGrpcOption("parameterValue",initValue);
	}
	public NodeForm parameterValueFieldForGrpcOption(){
		return parameterValueFieldForGrpcOption("parameterValue","");
	}


	public NodeForm nodeIdFieldForGrpcOption(String parameterName, String initValue){
		FormField field =  nodeIdFromGrpcOption(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeForm nodeIdFieldForGrpcOption(String initValue){
		return nodeIdFieldForGrpcOption("nodeId",initValue);
	}
	public NodeForm nodeIdFieldForGrpcOption(){
		return nodeIdFieldForGrpcOption("nodeId","");
	}


	public NodeForm channelPeerRoleIdFieldForChannelPeerRole(String parameterName, String initValue){
		FormField field =  idFromChannelPeerRole(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeForm channelPeerRoleIdFieldForChannelPeerRole(String initValue){
		return channelPeerRoleIdFieldForChannelPeerRole("channelPeerRoleId",initValue);
	}
	public NodeForm channelPeerRoleIdFieldForChannelPeerRole(){
		return channelPeerRoleIdFieldForChannelPeerRole("channelPeerRoleId","");
	}


	public NodeForm channelIdFieldForChannelPeerRole(String parameterName, String initValue){
		FormField field =  channelIdFromChannelPeerRole(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeForm channelIdFieldForChannelPeerRole(String initValue){
		return channelIdFieldForChannelPeerRole("channelId",initValue);
	}
	public NodeForm channelIdFieldForChannelPeerRole(){
		return channelIdFieldForChannelPeerRole("channelId","");
	}


	public NodeForm nodeIdFieldForChannelPeerRole(String parameterName, String initValue){
		FormField field =  nodeIdFromChannelPeerRole(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeForm nodeIdFieldForChannelPeerRole(String initValue){
		return nodeIdFieldForChannelPeerRole("nodeId",initValue);
	}
	public NodeForm nodeIdFieldForChannelPeerRole(){
		return nodeIdFieldForChannelPeerRole("nodeId","");
	}


	public NodeForm peerRoleIdFieldForChannelPeerRole(String parameterName, String initValue){
		FormField field =  peerRoleIdFromChannelPeerRole(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public NodeForm peerRoleIdFieldForChannelPeerRole(String initValue){
		return peerRoleIdFieldForChannelPeerRole("peerRoleId",initValue);
	}
	public NodeForm peerRoleIdFieldForChannelPeerRole(){
		return peerRoleIdFieldForChannelPeerRole("peerRoleId","");
	}

	

	
 	public NodeForm transferToAnotherOrganizationAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherOrganization/nodeId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public NodeForm transferToAnotherChannelAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherChannel/nodeId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public NodeForm transferToAnotherNetworkAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherNetwork/nodeId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public NodeForm transferToAnotherTypeAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherType/nodeId/");
		this.addFormAction(action);
		return this;
	}

 

	public NodeForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


