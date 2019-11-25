package com.doublechaintech.hfgw;


import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetworkManager;

import com.doublechaintech.hfgw.organization.OrganizationManager;

import com.doublechaintech.hfgw.nodetype.NodeTypeManager;

import com.doublechaintech.hfgw.node.NodeManager;

import com.doublechaintech.hfgw.grpcoption.GrpcOptionManager;

import com.doublechaintech.hfgw.channel.ChannelManager;

import com.doublechaintech.hfgw.peerrole.PeerRoleManager;

import com.doublechaintech.hfgw.channelpeerrole.ChannelPeerRoleManager;

import com.doublechaintech.hfgw.chaincode.ChainCodeManager;

import com.doublechaintech.hfgw.application.ApplicationManager;

import com.doublechaintech.hfgw.servicerecord.ServiceRecordManager;

import com.doublechaintech.hfgw.transactionstatus.TransactionStatusManager;

import com.doublechaintech.hfgw.changerequesttype.ChangeRequestTypeManager;

import com.doublechaintech.hfgw.changerequest.ChangeRequestManager;

import com.doublechaintech.hfgw.userdomain.UserDomainManager;

import com.doublechaintech.hfgw.userwhitelist.UserWhiteListManager;

import com.doublechaintech.hfgw.secuser.SecUserManager;

import com.doublechaintech.hfgw.secuserblocking.SecUserBlockingManager;

import com.doublechaintech.hfgw.userapp.UserAppManager;

import com.doublechaintech.hfgw.quicklink.QuickLinkManager;

import com.doublechaintech.hfgw.listaccess.ListAccessManager;

import com.doublechaintech.hfgw.objectaccess.ObjectAccessManager;

import com.doublechaintech.hfgw.loginhistory.LoginHistoryManager;

import com.doublechaintech.hfgw.genericform.GenericFormManager;

import com.doublechaintech.hfgw.formmessage.FormMessageManager;

import com.doublechaintech.hfgw.formfieldmessage.FormFieldMessageManager;

import com.doublechaintech.hfgw.formfield.FormFieldManager;

import com.doublechaintech.hfgw.formaction.FormActionManager;

import com.doublechaintech.hfgw.candidatecontainer.CandidateContainerManager;

import com.doublechaintech.hfgw.candidateelement.CandidateElementManager;


public class ManagerGroup {

	protected HyperledgerNetworkManager hyperledgerNetworkManager;

	protected OrganizationManager organizationManager;

	protected NodeTypeManager nodeTypeManager;

	protected NodeManager nodeManager;

	protected GrpcOptionManager grpcOptionManager;

	protected ChannelManager channelManager;

	protected PeerRoleManager peerRoleManager;

	protected ChannelPeerRoleManager channelPeerRoleManager;

	protected ChainCodeManager chainCodeManager;

	protected ApplicationManager applicationManager;

	protected ServiceRecordManager serviceRecordManager;

	protected TransactionStatusManager transactionStatusManager;

	protected ChangeRequestTypeManager changeRequestTypeManager;

	protected ChangeRequestManager changeRequestManager;

	protected UserDomainManager userDomainManager;

	protected UserWhiteListManager userWhiteListManager;

	protected SecUserManager secUserManager;

	protected SecUserBlockingManager secUserBlockingManager;

	protected UserAppManager userAppManager;

	protected QuickLinkManager quickLinkManager;

	protected ListAccessManager listAccessManager;

	protected ObjectAccessManager objectAccessManager;

	protected LoginHistoryManager loginHistoryManager;

	protected GenericFormManager genericFormManager;

	protected FormMessageManager formMessageManager;

	protected FormFieldMessageManager formFieldMessageManager;

	protected FormFieldManager formFieldManager;

	protected FormActionManager formActionManager;

	protected CandidateContainerManager candidateContainerManager;

	protected CandidateElementManager candidateElementManager;

	

	public HyperledgerNetworkManager getHyperledgerNetworkManager(){
		return this.hyperledgerNetworkManager;
	}
	public void setHyperledgerNetworkManager(HyperledgerNetworkManager manager){
		this.hyperledgerNetworkManager = manager;
	}


	public OrganizationManager getOrganizationManager(){
		return this.organizationManager;
	}
	public void setOrganizationManager(OrganizationManager manager){
		this.organizationManager = manager;
	}


	public NodeTypeManager getNodeTypeManager(){
		return this.nodeTypeManager;
	}
	public void setNodeTypeManager(NodeTypeManager manager){
		this.nodeTypeManager = manager;
	}


	public NodeManager getNodeManager(){
		return this.nodeManager;
	}
	public void setNodeManager(NodeManager manager){
		this.nodeManager = manager;
	}


	public GrpcOptionManager getGrpcOptionManager(){
		return this.grpcOptionManager;
	}
	public void setGrpcOptionManager(GrpcOptionManager manager){
		this.grpcOptionManager = manager;
	}


	public ChannelManager getChannelManager(){
		return this.channelManager;
	}
	public void setChannelManager(ChannelManager manager){
		this.channelManager = manager;
	}


	public PeerRoleManager getPeerRoleManager(){
		return this.peerRoleManager;
	}
	public void setPeerRoleManager(PeerRoleManager manager){
		this.peerRoleManager = manager;
	}


	public ChannelPeerRoleManager getChannelPeerRoleManager(){
		return this.channelPeerRoleManager;
	}
	public void setChannelPeerRoleManager(ChannelPeerRoleManager manager){
		this.channelPeerRoleManager = manager;
	}


	public ChainCodeManager getChainCodeManager(){
		return this.chainCodeManager;
	}
	public void setChainCodeManager(ChainCodeManager manager){
		this.chainCodeManager = manager;
	}


	public ApplicationManager getApplicationManager(){
		return this.applicationManager;
	}
	public void setApplicationManager(ApplicationManager manager){
		this.applicationManager = manager;
	}


	public ServiceRecordManager getServiceRecordManager(){
		return this.serviceRecordManager;
	}
	public void setServiceRecordManager(ServiceRecordManager manager){
		this.serviceRecordManager = manager;
	}


	public TransactionStatusManager getTransactionStatusManager(){
		return this.transactionStatusManager;
	}
	public void setTransactionStatusManager(TransactionStatusManager manager){
		this.transactionStatusManager = manager;
	}


	public ChangeRequestTypeManager getChangeRequestTypeManager(){
		return this.changeRequestTypeManager;
	}
	public void setChangeRequestTypeManager(ChangeRequestTypeManager manager){
		this.changeRequestTypeManager = manager;
	}


	public ChangeRequestManager getChangeRequestManager(){
		return this.changeRequestManager;
	}
	public void setChangeRequestManager(ChangeRequestManager manager){
		this.changeRequestManager = manager;
	}


	public UserDomainManager getUserDomainManager(){
		return this.userDomainManager;
	}
	public void setUserDomainManager(UserDomainManager manager){
		this.userDomainManager = manager;
	}


	public UserWhiteListManager getUserWhiteListManager(){
		return this.userWhiteListManager;
	}
	public void setUserWhiteListManager(UserWhiteListManager manager){
		this.userWhiteListManager = manager;
	}


	public SecUserManager getSecUserManager(){
		return this.secUserManager;
	}
	public void setSecUserManager(SecUserManager manager){
		this.secUserManager = manager;
	}


	public SecUserBlockingManager getSecUserBlockingManager(){
		return this.secUserBlockingManager;
	}
	public void setSecUserBlockingManager(SecUserBlockingManager manager){
		this.secUserBlockingManager = manager;
	}


	public UserAppManager getUserAppManager(){
		return this.userAppManager;
	}
	public void setUserAppManager(UserAppManager manager){
		this.userAppManager = manager;
	}


	public QuickLinkManager getQuickLinkManager(){
		return this.quickLinkManager;
	}
	public void setQuickLinkManager(QuickLinkManager manager){
		this.quickLinkManager = manager;
	}


	public ListAccessManager getListAccessManager(){
		return this.listAccessManager;
	}
	public void setListAccessManager(ListAccessManager manager){
		this.listAccessManager = manager;
	}


	public ObjectAccessManager getObjectAccessManager(){
		return this.objectAccessManager;
	}
	public void setObjectAccessManager(ObjectAccessManager manager){
		this.objectAccessManager = manager;
	}


	public LoginHistoryManager getLoginHistoryManager(){
		return this.loginHistoryManager;
	}
	public void setLoginHistoryManager(LoginHistoryManager manager){
		this.loginHistoryManager = manager;
	}


	public GenericFormManager getGenericFormManager(){
		return this.genericFormManager;
	}
	public void setGenericFormManager(GenericFormManager manager){
		this.genericFormManager = manager;
	}


	public FormMessageManager getFormMessageManager(){
		return this.formMessageManager;
	}
	public void setFormMessageManager(FormMessageManager manager){
		this.formMessageManager = manager;
	}


	public FormFieldMessageManager getFormFieldMessageManager(){
		return this.formFieldMessageManager;
	}
	public void setFormFieldMessageManager(FormFieldMessageManager manager){
		this.formFieldMessageManager = manager;
	}


	public FormFieldManager getFormFieldManager(){
		return this.formFieldManager;
	}
	public void setFormFieldManager(FormFieldManager manager){
		this.formFieldManager = manager;
	}


	public FormActionManager getFormActionManager(){
		return this.formActionManager;
	}
	public void setFormActionManager(FormActionManager manager){
		this.formActionManager = manager;
	}


	public CandidateContainerManager getCandidateContainerManager(){
		return this.candidateContainerManager;
	}
	public void setCandidateContainerManager(CandidateContainerManager manager){
		this.candidateContainerManager = manager;
	}


	public CandidateElementManager getCandidateElementManager(){
		return this.candidateElementManager;
	}
	public void setCandidateElementManager(CandidateElementManager manager){
		this.candidateElementManager = manager;
	}


}






