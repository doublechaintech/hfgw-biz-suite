package com.doublechaintech.hfgw;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetworkDAO;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetworkTokens;
import com.doublechaintech.hfgw.organization.Organization;
import com.doublechaintech.hfgw.organization.OrganizationDAO;
import com.doublechaintech.hfgw.organization.OrganizationTokens;
import com.doublechaintech.hfgw.nodetype.NodeType;
import com.doublechaintech.hfgw.nodetype.NodeTypeDAO;
import com.doublechaintech.hfgw.nodetype.NodeTypeTokens;
import com.doublechaintech.hfgw.node.Node;
import com.doublechaintech.hfgw.node.NodeDAO;
import com.doublechaintech.hfgw.node.NodeTokens;
import com.doublechaintech.hfgw.grpcoption.GrpcOption;
import com.doublechaintech.hfgw.grpcoption.GrpcOptionDAO;
import com.doublechaintech.hfgw.grpcoption.GrpcOptionTokens;
import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.channel.ChannelDAO;
import com.doublechaintech.hfgw.channel.ChannelTokens;
import com.doublechaintech.hfgw.peerrole.PeerRole;
import com.doublechaintech.hfgw.peerrole.PeerRoleDAO;
import com.doublechaintech.hfgw.peerrole.PeerRoleTokens;
import com.doublechaintech.hfgw.channelpeerrole.ChannelPeerRole;
import com.doublechaintech.hfgw.channelpeerrole.ChannelPeerRoleDAO;
import com.doublechaintech.hfgw.channelpeerrole.ChannelPeerRoleTokens;
import com.doublechaintech.hfgw.chaincode.ChainCode;
import com.doublechaintech.hfgw.chaincode.ChainCodeDAO;
import com.doublechaintech.hfgw.chaincode.ChainCodeTokens;
import com.doublechaintech.hfgw.application.Application;
import com.doublechaintech.hfgw.application.ApplicationDAO;
import com.doublechaintech.hfgw.application.ApplicationTokens;
import com.doublechaintech.hfgw.servicerecord.ServiceRecord;
import com.doublechaintech.hfgw.servicerecord.ServiceRecordDAO;
import com.doublechaintech.hfgw.servicerecord.ServiceRecordTokens;
import com.doublechaintech.hfgw.transactionstatus.TransactionStatus;
import com.doublechaintech.hfgw.transactionstatus.TransactionStatusDAO;
import com.doublechaintech.hfgw.transactionstatus.TransactionStatusTokens;
import com.doublechaintech.hfgw.changerequesttype.ChangeRequestType;
import com.doublechaintech.hfgw.changerequesttype.ChangeRequestTypeDAO;
import com.doublechaintech.hfgw.changerequesttype.ChangeRequestTypeTokens;
import com.doublechaintech.hfgw.changerequest.ChangeRequest;
import com.doublechaintech.hfgw.changerequest.ChangeRequestDAO;
import com.doublechaintech.hfgw.changerequest.ChangeRequestTokens;
import com.doublechaintech.hfgw.chaincodeinvoker.ChainCodeInvoker;
import com.doublechaintech.hfgw.chaincodeinvoker.ChainCodeInvokerDAO;
import com.doublechaintech.hfgw.chaincodeinvoker.ChainCodeInvokerTokens;
import com.doublechaintech.hfgw.userdomain.UserDomain;
import com.doublechaintech.hfgw.userdomain.UserDomainDAO;
import com.doublechaintech.hfgw.userdomain.UserDomainTokens;
import com.doublechaintech.hfgw.userwhitelist.UserWhiteList;
import com.doublechaintech.hfgw.userwhitelist.UserWhiteListDAO;
import com.doublechaintech.hfgw.userwhitelist.UserWhiteListTokens;
import com.doublechaintech.hfgw.secuser.SecUser;
import com.doublechaintech.hfgw.secuser.SecUserDAO;
import com.doublechaintech.hfgw.secuser.SecUserTokens;
import com.doublechaintech.hfgw.secuserblocking.SecUserBlocking;
import com.doublechaintech.hfgw.secuserblocking.SecUserBlockingDAO;
import com.doublechaintech.hfgw.secuserblocking.SecUserBlockingTokens;
import com.doublechaintech.hfgw.userapp.UserApp;
import com.doublechaintech.hfgw.userapp.UserAppDAO;
import com.doublechaintech.hfgw.userapp.UserAppTokens;
import com.doublechaintech.hfgw.quicklink.QuickLink;
import com.doublechaintech.hfgw.quicklink.QuickLinkDAO;
import com.doublechaintech.hfgw.quicklink.QuickLinkTokens;
import com.doublechaintech.hfgw.listaccess.ListAccess;
import com.doublechaintech.hfgw.listaccess.ListAccessDAO;
import com.doublechaintech.hfgw.listaccess.ListAccessTokens;
import com.doublechaintech.hfgw.objectaccess.ObjectAccess;
import com.doublechaintech.hfgw.objectaccess.ObjectAccessDAO;
import com.doublechaintech.hfgw.objectaccess.ObjectAccessTokens;
import com.doublechaintech.hfgw.loginhistory.LoginHistory;
import com.doublechaintech.hfgw.loginhistory.LoginHistoryDAO;
import com.doublechaintech.hfgw.loginhistory.LoginHistoryTokens;
import com.doublechaintech.hfgw.genericform.GenericForm;
import com.doublechaintech.hfgw.genericform.GenericFormDAO;
import com.doublechaintech.hfgw.genericform.GenericFormTokens;
import com.doublechaintech.hfgw.formmessage.FormMessage;
import com.doublechaintech.hfgw.formmessage.FormMessageDAO;
import com.doublechaintech.hfgw.formmessage.FormMessageTokens;
import com.doublechaintech.hfgw.formfieldmessage.FormFieldMessage;
import com.doublechaintech.hfgw.formfieldmessage.FormFieldMessageDAO;
import com.doublechaintech.hfgw.formfieldmessage.FormFieldMessageTokens;
import com.doublechaintech.hfgw.formfield.FormField;
import com.doublechaintech.hfgw.formfield.FormFieldDAO;
import com.doublechaintech.hfgw.formfield.FormFieldTokens;
import com.doublechaintech.hfgw.formaction.FormAction;
import com.doublechaintech.hfgw.formaction.FormActionDAO;
import com.doublechaintech.hfgw.formaction.FormActionTokens;
import com.doublechaintech.hfgw.candidatecontainer.CandidateContainer;
import com.doublechaintech.hfgw.candidatecontainer.CandidateContainerDAO;
import com.doublechaintech.hfgw.candidatecontainer.CandidateContainerTokens;
import com.doublechaintech.hfgw.candidateelement.CandidateElement;
import com.doublechaintech.hfgw.candidateelement.CandidateElementDAO;
import com.doublechaintech.hfgw.candidateelement.CandidateElementTokens;

public class DAOGroup {

	protected HyperledgerNetworkDAO hyperledgerNetworkDAO;

	protected OrganizationDAO organizationDAO;

	protected NodeTypeDAO nodeTypeDAO;

	protected NodeDAO nodeDAO;

	protected GrpcOptionDAO grpcOptionDAO;

	protected ChannelDAO channelDAO;

	protected PeerRoleDAO peerRoleDAO;

	protected ChannelPeerRoleDAO channelPeerRoleDAO;

	protected ChainCodeDAO chainCodeDAO;

	protected ApplicationDAO applicationDAO;

	protected ServiceRecordDAO serviceRecordDAO;

	protected TransactionStatusDAO transactionStatusDAO;

	protected ChangeRequestTypeDAO changeRequestTypeDAO;

	protected ChangeRequestDAO changeRequestDAO;

	protected ChainCodeInvokerDAO chainCodeInvokerDAO;

	protected UserDomainDAO userDomainDAO;

	protected UserWhiteListDAO userWhiteListDAO;

	protected SecUserDAO secUserDAO;

	protected SecUserBlockingDAO secUserBlockingDAO;

	protected UserAppDAO userAppDAO;

	protected QuickLinkDAO quickLinkDAO;

	protected ListAccessDAO listAccessDAO;

	protected ObjectAccessDAO objectAccessDAO;

	protected LoginHistoryDAO loginHistoryDAO;

	protected GenericFormDAO genericFormDAO;

	protected FormMessageDAO formMessageDAO;

	protected FormFieldMessageDAO formFieldMessageDAO;

	protected FormFieldDAO formFieldDAO;

	protected FormActionDAO formActionDAO;

	protected CandidateContainerDAO candidateContainerDAO;

	protected CandidateElementDAO candidateElementDAO;

	

	public HyperledgerNetworkDAO getHyperledgerNetworkDAO(){
		return this.hyperledgerNetworkDAO;
	}
	public void setHyperledgerNetworkDAO(HyperledgerNetworkDAO dao){
		this.hyperledgerNetworkDAO = dao;
	}


	public OrganizationDAO getOrganizationDAO(){
		return this.organizationDAO;
	}
	public void setOrganizationDAO(OrganizationDAO dao){
		this.organizationDAO = dao;
	}


	public NodeTypeDAO getNodeTypeDAO(){
		return this.nodeTypeDAO;
	}
	public void setNodeTypeDAO(NodeTypeDAO dao){
		this.nodeTypeDAO = dao;
	}


	public NodeDAO getNodeDAO(){
		return this.nodeDAO;
	}
	public void setNodeDAO(NodeDAO dao){
		this.nodeDAO = dao;
	}


	public GrpcOptionDAO getGrpcOptionDAO(){
		return this.grpcOptionDAO;
	}
	public void setGrpcOptionDAO(GrpcOptionDAO dao){
		this.grpcOptionDAO = dao;
	}


	public ChannelDAO getChannelDAO(){
		return this.channelDAO;
	}
	public void setChannelDAO(ChannelDAO dao){
		this.channelDAO = dao;
	}


	public PeerRoleDAO getPeerRoleDAO(){
		return this.peerRoleDAO;
	}
	public void setPeerRoleDAO(PeerRoleDAO dao){
		this.peerRoleDAO = dao;
	}


	public ChannelPeerRoleDAO getChannelPeerRoleDAO(){
		return this.channelPeerRoleDAO;
	}
	public void setChannelPeerRoleDAO(ChannelPeerRoleDAO dao){
		this.channelPeerRoleDAO = dao;
	}


	public ChainCodeDAO getChainCodeDAO(){
		return this.chainCodeDAO;
	}
	public void setChainCodeDAO(ChainCodeDAO dao){
		this.chainCodeDAO = dao;
	}


	public ApplicationDAO getApplicationDAO(){
		return this.applicationDAO;
	}
	public void setApplicationDAO(ApplicationDAO dao){
		this.applicationDAO = dao;
	}


	public ServiceRecordDAO getServiceRecordDAO(){
		return this.serviceRecordDAO;
	}
	public void setServiceRecordDAO(ServiceRecordDAO dao){
		this.serviceRecordDAO = dao;
	}


	public TransactionStatusDAO getTransactionStatusDAO(){
		return this.transactionStatusDAO;
	}
	public void setTransactionStatusDAO(TransactionStatusDAO dao){
		this.transactionStatusDAO = dao;
	}


	public ChangeRequestTypeDAO getChangeRequestTypeDAO(){
		return this.changeRequestTypeDAO;
	}
	public void setChangeRequestTypeDAO(ChangeRequestTypeDAO dao){
		this.changeRequestTypeDAO = dao;
	}


	public ChangeRequestDAO getChangeRequestDAO(){
		return this.changeRequestDAO;
	}
	public void setChangeRequestDAO(ChangeRequestDAO dao){
		this.changeRequestDAO = dao;
	}


	public ChainCodeInvokerDAO getChainCodeInvokerDAO(){
		return this.chainCodeInvokerDAO;
	}
	public void setChainCodeInvokerDAO(ChainCodeInvokerDAO dao){
		this.chainCodeInvokerDAO = dao;
	}


	public UserDomainDAO getUserDomainDAO(){
		return this.userDomainDAO;
	}
	public void setUserDomainDAO(UserDomainDAO dao){
		this.userDomainDAO = dao;
	}


	public UserWhiteListDAO getUserWhiteListDAO(){
		return this.userWhiteListDAO;
	}
	public void setUserWhiteListDAO(UserWhiteListDAO dao){
		this.userWhiteListDAO = dao;
	}


	public SecUserDAO getSecUserDAO(){
		return this.secUserDAO;
	}
	public void setSecUserDAO(SecUserDAO dao){
		this.secUserDAO = dao;
	}


	public SecUserBlockingDAO getSecUserBlockingDAO(){
		return this.secUserBlockingDAO;
	}
	public void setSecUserBlockingDAO(SecUserBlockingDAO dao){
		this.secUserBlockingDAO = dao;
	}


	public UserAppDAO getUserAppDAO(){
		return this.userAppDAO;
	}
	public void setUserAppDAO(UserAppDAO dao){
		this.userAppDAO = dao;
	}


	public QuickLinkDAO getQuickLinkDAO(){
		return this.quickLinkDAO;
	}
	public void setQuickLinkDAO(QuickLinkDAO dao){
		this.quickLinkDAO = dao;
	}


	public ListAccessDAO getListAccessDAO(){
		return this.listAccessDAO;
	}
	public void setListAccessDAO(ListAccessDAO dao){
		this.listAccessDAO = dao;
	}


	public ObjectAccessDAO getObjectAccessDAO(){
		return this.objectAccessDAO;
	}
	public void setObjectAccessDAO(ObjectAccessDAO dao){
		this.objectAccessDAO = dao;
	}


	public LoginHistoryDAO getLoginHistoryDAO(){
		return this.loginHistoryDAO;
	}
	public void setLoginHistoryDAO(LoginHistoryDAO dao){
		this.loginHistoryDAO = dao;
	}


	public GenericFormDAO getGenericFormDAO(){
		return this.genericFormDAO;
	}
	public void setGenericFormDAO(GenericFormDAO dao){
		this.genericFormDAO = dao;
	}


	public FormMessageDAO getFormMessageDAO(){
		return this.formMessageDAO;
	}
	public void setFormMessageDAO(FormMessageDAO dao){
		this.formMessageDAO = dao;
	}


	public FormFieldMessageDAO getFormFieldMessageDAO(){
		return this.formFieldMessageDAO;
	}
	public void setFormFieldMessageDAO(FormFieldMessageDAO dao){
		this.formFieldMessageDAO = dao;
	}


	public FormFieldDAO getFormFieldDAO(){
		return this.formFieldDAO;
	}
	public void setFormFieldDAO(FormFieldDAO dao){
		this.formFieldDAO = dao;
	}


	public FormActionDAO getFormActionDAO(){
		return this.formActionDAO;
	}
	public void setFormActionDAO(FormActionDAO dao){
		this.formActionDAO = dao;
	}


	public CandidateContainerDAO getCandidateContainerDAO(){
		return this.candidateContainerDAO;
	}
	public void setCandidateContainerDAO(CandidateContainerDAO dao){
		this.candidateContainerDAO = dao;
	}


	public CandidateElementDAO getCandidateElementDAO(){
		return this.candidateElementDAO;
	}
	public void setCandidateElementDAO(CandidateElementDAO dao){
		this.candidateElementDAO = dao;
	}


	private interface BasicLoader{
	    BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception;
	    void enhanceList(DAOGroup daoGoup, List list) throws Exception;
	    BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception;
	    BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception;
	}
	private static Map<String, BasicLoader> internalLoaderMap;
	static {
		internalLoaderMap = new HashMap<String, BasicLoader>();

		internalLoaderMap.put("HyperledgerNetwork", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getHyperledgerNetworkDAO().load(id, HyperledgerNetworkTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getHyperledgerNetworkDAO().enhanceList((List<HyperledgerNetwork>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getHyperledgerNetworkDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getHyperledgerNetworkDAO().present((HyperledgerNetwork)data, tokens);
			}
		});

		internalLoaderMap.put("Organization", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getOrganizationDAO().load(id, OrganizationTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getOrganizationDAO().enhanceList((List<Organization>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getOrganizationDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getOrganizationDAO().present((Organization)data, tokens);
			}
		});

		internalLoaderMap.put("NodeType", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getNodeTypeDAO().load(id, NodeTypeTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getNodeTypeDAO().enhanceList((List<NodeType>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getNodeTypeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getNodeTypeDAO().present((NodeType)data, tokens);
			}
		});

		internalLoaderMap.put("Node", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getNodeDAO().load(id, NodeTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getNodeDAO().enhanceList((List<Node>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getNodeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getNodeDAO().present((Node)data, tokens);
			}
		});

		internalLoaderMap.put("GrpcOption", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getGrpcOptionDAO().load(id, GrpcOptionTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getGrpcOptionDAO().enhanceList((List<GrpcOption>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGrpcOptionDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGrpcOptionDAO().present((GrpcOption)data, tokens);
			}
		});

		internalLoaderMap.put("Channel", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getChannelDAO().load(id, ChannelTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getChannelDAO().enhanceList((List<Channel>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getChannelDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getChannelDAO().present((Channel)data, tokens);
			}
		});

		internalLoaderMap.put("PeerRole", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getPeerRoleDAO().load(id, PeerRoleTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getPeerRoleDAO().enhanceList((List<PeerRole>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPeerRoleDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPeerRoleDAO().present((PeerRole)data, tokens);
			}
		});

		internalLoaderMap.put("ChannelPeerRole", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getChannelPeerRoleDAO().load(id, ChannelPeerRoleTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getChannelPeerRoleDAO().enhanceList((List<ChannelPeerRole>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getChannelPeerRoleDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getChannelPeerRoleDAO().present((ChannelPeerRole)data, tokens);
			}
		});

		internalLoaderMap.put("ChainCode", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getChainCodeDAO().load(id, ChainCodeTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getChainCodeDAO().enhanceList((List<ChainCode>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getChainCodeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getChainCodeDAO().present((ChainCode)data, tokens);
			}
		});

		internalLoaderMap.put("Application", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getApplicationDAO().load(id, ApplicationTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getApplicationDAO().enhanceList((List<Application>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getApplicationDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getApplicationDAO().present((Application)data, tokens);
			}
		});

		internalLoaderMap.put("ServiceRecord", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getServiceRecordDAO().load(id, ServiceRecordTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getServiceRecordDAO().enhanceList((List<ServiceRecord>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getServiceRecordDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getServiceRecordDAO().present((ServiceRecord)data, tokens);
			}
		});

		internalLoaderMap.put("TransactionStatus", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getTransactionStatusDAO().load(id, TransactionStatusTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getTransactionStatusDAO().enhanceList((List<TransactionStatus>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTransactionStatusDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTransactionStatusDAO().present((TransactionStatus)data, tokens);
			}
		});

		internalLoaderMap.put("ChangeRequestType", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getChangeRequestTypeDAO().load(id, ChangeRequestTypeTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getChangeRequestTypeDAO().enhanceList((List<ChangeRequestType>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getChangeRequestTypeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getChangeRequestTypeDAO().present((ChangeRequestType)data, tokens);
			}
		});

		internalLoaderMap.put("ChangeRequest", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getChangeRequestDAO().load(id, ChangeRequestTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getChangeRequestDAO().enhanceList((List<ChangeRequest>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getChangeRequestDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getChangeRequestDAO().present((ChangeRequest)data, tokens);
			}
		});

		internalLoaderMap.put("ChainCodeInvoker", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getChainCodeInvokerDAO().load(id, ChainCodeInvokerTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getChainCodeInvokerDAO().enhanceList((List<ChainCodeInvoker>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getChainCodeInvokerDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getChainCodeInvokerDAO().present((ChainCodeInvoker)data, tokens);
			}
		});

		internalLoaderMap.put("UserDomain", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserDomainDAO().load(id, UserDomainTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getUserDomainDAO().enhanceList((List<UserDomain>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserDomainDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserDomainDAO().present((UserDomain)data, tokens);
			}
		});

		internalLoaderMap.put("UserWhiteList", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserWhiteListDAO().load(id, UserWhiteListTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getUserWhiteListDAO().enhanceList((List<UserWhiteList>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserWhiteListDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserWhiteListDAO().present((UserWhiteList)data, tokens);
			}
		});

		internalLoaderMap.put("SecUser", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSecUserDAO().load(id, SecUserTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getSecUserDAO().enhanceList((List<SecUser>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserDAO().present((SecUser)data, tokens);
			}
		});

		internalLoaderMap.put("SecUserBlocking", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSecUserBlockingDAO().load(id, SecUserBlockingTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getSecUserBlockingDAO().enhanceList((List<SecUserBlocking>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserBlockingDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserBlockingDAO().present((SecUserBlocking)data, tokens);
			}
		});

		internalLoaderMap.put("UserApp", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserAppDAO().load(id, UserAppTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getUserAppDAO().enhanceList((List<UserApp>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserAppDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserAppDAO().present((UserApp)data, tokens);
			}
		});

		internalLoaderMap.put("QuickLink", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getQuickLinkDAO().load(id, QuickLinkTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getQuickLinkDAO().enhanceList((List<QuickLink>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getQuickLinkDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getQuickLinkDAO().present((QuickLink)data, tokens);
			}
		});

		internalLoaderMap.put("ListAccess", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getListAccessDAO().load(id, ListAccessTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getListAccessDAO().enhanceList((List<ListAccess>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getListAccessDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getListAccessDAO().present((ListAccess)data, tokens);
			}
		});

		internalLoaderMap.put("ObjectAccess", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getObjectAccessDAO().load(id, ObjectAccessTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getObjectAccessDAO().enhanceList((List<ObjectAccess>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getObjectAccessDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getObjectAccessDAO().present((ObjectAccess)data, tokens);
			}
		});

		internalLoaderMap.put("LoginHistory", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLoginHistoryDAO().load(id, LoginHistoryTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getLoginHistoryDAO().enhanceList((List<LoginHistory>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLoginHistoryDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLoginHistoryDAO().present((LoginHistory)data, tokens);
			}
		});

		internalLoaderMap.put("GenericForm", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getGenericFormDAO().load(id, GenericFormTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getGenericFormDAO().enhanceList((List<GenericForm>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGenericFormDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGenericFormDAO().present((GenericForm)data, tokens);
			}
		});

		internalLoaderMap.put("FormMessage", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormMessageDAO().load(id, FormMessageTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getFormMessageDAO().enhanceList((List<FormMessage>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormMessageDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormMessageDAO().present((FormMessage)data, tokens);
			}
		});

		internalLoaderMap.put("FormFieldMessage", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormFieldMessageDAO().load(id, FormFieldMessageTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getFormFieldMessageDAO().enhanceList((List<FormFieldMessage>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldMessageDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldMessageDAO().present((FormFieldMessage)data, tokens);
			}
		});

		internalLoaderMap.put("FormField", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormFieldDAO().load(id, FormFieldTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getFormFieldDAO().enhanceList((List<FormField>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldDAO().present((FormField)data, tokens);
			}
		});

		internalLoaderMap.put("FormAction", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormActionDAO().load(id, FormActionTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getFormActionDAO().enhanceList((List<FormAction>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormActionDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormActionDAO().present((FormAction)data, tokens);
			}
		});

		internalLoaderMap.put("CandidateContainer", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getCandidateContainerDAO().load(id, CandidateContainerTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getCandidateContainerDAO().enhanceList((List<CandidateContainer>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCandidateContainerDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCandidateContainerDAO().present((CandidateContainer)data, tokens);
			}
		});

		internalLoaderMap.put("CandidateElement", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getCandidateElementDAO().load(id, CandidateElementTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getCandidateElementDAO().enhanceList((List<CandidateElement>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCandidateElementDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCandidateElementDAO().present((CandidateElement)data, tokens);
			}
		});

	}
	public BaseEntity loadBasicData(String type, String id){
	    BasicLoader loader = internalLoaderMap.get(type);
	    if (loader == null) {
	    	return null;
	    }
	    try{
	    	return loader.loadBasicData(this, id);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
	public BaseEntity loadBasicDataWithTokens(String type, String id, Map<String, Object> tokens){
	    BasicLoader loader = internalLoaderMap.get(type);
	    if (loader == null) {
	    	return null;
	    }
	    try{
	    	return loader.loadBasicDataWithToken(this, id, tokens);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
	public BaseEntity present(BaseEntity data, Map<String, Object> tokens){
	    BasicLoader loader = internalLoaderMap.get(data.getInternalType());
	    if (loader == null || data == null) {
	    	return null;
	    }
	    try{
	    	return loader.present(this, data, tokens);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
	public <T> void enhanceList(List list, Class<T> clazz) throws Exception{
	    BasicLoader loader = internalLoaderMap.get(clazz.getSimpleName());
	    if (loader == null) {
	    	return ;
	    }

	    loader.enhanceList(this, list);
	}
}

