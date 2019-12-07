
package com.doublechaintech.hfgw;
import java.util.Map;

import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;
import com.doublechaintech.hfgw.organization.Organization;
import com.doublechaintech.hfgw.nodetype.NodeType;
import com.doublechaintech.hfgw.node.Node;
import com.doublechaintech.hfgw.grpcoption.GrpcOption;
import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.peerrole.PeerRole;
import com.doublechaintech.hfgw.channelpeerrole.ChannelPeerRole;
import com.doublechaintech.hfgw.chaincode.ChainCode;
import com.doublechaintech.hfgw.application.Application;
import com.doublechaintech.hfgw.servicerecord.ServiceRecord;
import com.doublechaintech.hfgw.transactionstatus.TransactionStatus;
import com.doublechaintech.hfgw.changerequesttype.ChangeRequestType;
import com.doublechaintech.hfgw.changerequest.ChangeRequest;
import com.doublechaintech.hfgw.chaincodeinvoker.ChainCodeInvoker;
import com.doublechaintech.hfgw.userdomain.UserDomain;
import com.doublechaintech.hfgw.userwhitelist.UserWhiteList;
import com.doublechaintech.hfgw.secuser.SecUser;
import com.doublechaintech.hfgw.secuserblocking.SecUserBlocking;
import com.doublechaintech.hfgw.userapp.UserApp;
import com.doublechaintech.hfgw.quicklink.QuickLink;
import com.doublechaintech.hfgw.listaccess.ListAccess;
import com.doublechaintech.hfgw.objectaccess.ObjectAccess;
import com.doublechaintech.hfgw.loginhistory.LoginHistory;
import com.doublechaintech.hfgw.genericform.GenericForm;
import com.doublechaintech.hfgw.formmessage.FormMessage;
import com.doublechaintech.hfgw.formfieldmessage.FormFieldMessage;
import com.doublechaintech.hfgw.formfield.FormField;
import com.doublechaintech.hfgw.formaction.FormAction;
import com.doublechaintech.hfgw.candidatecontainer.CandidateContainer;
import com.doublechaintech.hfgw.candidateelement.CandidateElement;

public class BeanFactoryImpl{


	public HyperledgerNetwork createHyperledgerNetwork(Map<String,Object> options){
		return new HyperledgerNetwork();
	}


	public Organization createOrganization(Map<String,Object> options){
		return new Organization();
	}


	public NodeType createNodeType(Map<String,Object> options){
		return new NodeType();
	}


	public Node createNode(Map<String,Object> options){
		return new Node();
	}


	public GrpcOption createGrpcOption(Map<String,Object> options){
		return new GrpcOption();
	}


	public Channel createChannel(Map<String,Object> options){
		return new Channel();
	}


	public PeerRole createPeerRole(Map<String,Object> options){
		return new PeerRole();
	}


	public ChannelPeerRole createChannelPeerRole(Map<String,Object> options){
		return new ChannelPeerRole();
	}


	public ChainCode createChainCode(Map<String,Object> options){
		return new ChainCode();
	}


	public Application createApplication(Map<String,Object> options){
		return new Application();
	}


	public ServiceRecord createServiceRecord(Map<String,Object> options){
		return new ServiceRecord();
	}


	public TransactionStatus createTransactionStatus(Map<String,Object> options){
		return new TransactionStatus();
	}


	public ChangeRequestType createChangeRequestType(Map<String,Object> options){
		return new ChangeRequestType();
	}


	public ChangeRequest createChangeRequest(Map<String,Object> options){
		return new ChangeRequest();
	}


	public ChainCodeInvoker createChainCodeInvoker(Map<String,Object> options){
		return new ChainCodeInvoker();
	}


	public UserDomain createUserDomain(Map<String,Object> options){
		return new UserDomain();
	}


	public UserWhiteList createUserWhiteList(Map<String,Object> options){
		return new UserWhiteList();
	}


	public SecUser createSecUser(Map<String,Object> options){
		return new SecUser();
	}


	public SecUserBlocking createSecUserBlocking(Map<String,Object> options){
		return new SecUserBlocking();
	}


	public UserApp createUserApp(Map<String,Object> options){
		return new UserApp();
	}


	public QuickLink createQuickLink(Map<String,Object> options){
		return new QuickLink();
	}


	public ListAccess createListAccess(Map<String,Object> options){
		return new ListAccess();
	}


	public ObjectAccess createObjectAccess(Map<String,Object> options){
		return new ObjectAccess();
	}


	public LoginHistory createLoginHistory(Map<String,Object> options){
		return new LoginHistory();
	}


	public GenericForm createGenericForm(Map<String,Object> options){
		return new GenericForm();
	}


	public FormMessage createFormMessage(Map<String,Object> options){
		return new FormMessage();
	}


	public FormFieldMessage createFormFieldMessage(Map<String,Object> options){
		return new FormFieldMessage();
	}


	public FormField createFormField(Map<String,Object> options){
		return new FormField();
	}


	public FormAction createFormAction(Map<String,Object> options){
		return new FormAction();
	}


	public CandidateContainer createCandidateContainer(Map<String,Object> options){
		return new CandidateContainer();
	}


	public CandidateElement createCandidateElement(Map<String,Object> options){
		return new CandidateElement();
	}





}







