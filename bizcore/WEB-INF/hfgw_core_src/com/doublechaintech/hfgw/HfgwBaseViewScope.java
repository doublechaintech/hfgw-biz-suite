package com.doublechaintech.hfgw;


import com.terapico.caf.viewpage.SerializeScope;

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


public class HfgwBaseViewScope {

	protected static SerializeScope HyperledgerNetworkBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(HyperledgerNetwork.ID_PROPERTY)
		.field(HyperledgerNetwork.NAME_PROPERTY)
		.field(HyperledgerNetwork.DESCRIPTION_PROPERTY)
		;
	/** 用于HyperledgerNetwork的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getHyperledgerNetworkSummaryScope() {
		return HyperledgerNetworkBaseSummaryScope;
	}

	protected static SerializeScope OrganizationBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(Organization.ID_PROPERTY)
		.field(Organization.NAME_PROPERTY)
		.field(Organization.MSPID_PROPERTY)
		;
	/** 用于Organization的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getOrganizationSummaryScope() {
		return OrganizationBaseSummaryScope;
	}

	protected static SerializeScope NodeTypeBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(NodeType.ID_PROPERTY)
		.field(NodeType.NAME_PROPERTY)
		.field(NodeType.CODE_PROPERTY)
		;
	/** 用于NodeType的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getNodeTypeSummaryScope() {
		return NodeTypeBaseSummaryScope;
	}

	protected static SerializeScope NodeBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(Node.ID_PROPERTY)
		.field(Node.NAME_PROPERTY)
		.field(Node.URL_PROPERTY)
		.field(Node.TLS_CACERT_PROPERTY)
		.field(Node.ADDRESS_PROPERTY)
		.field(Node.CONTACT_PERSON_PROPERTY)
		.field(Node.CONTACT_TELEPHONE_PROPERTY)
		;
	/** 用于Node的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getNodeSummaryScope() {
		return NodeBaseSummaryScope;
	}

	protected static SerializeScope GrpcOptionBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(GrpcOption.ID_PROPERTY)
		.field(GrpcOption.PARAMETER_NAME_PROPERTY)
		.field(GrpcOption.PARAMETER_VALUE_PROPERTY)
		;
	/** 用于GrpcOption的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getGrpcOptionSummaryScope() {
		return GrpcOptionBaseSummaryScope;
	}

	protected static SerializeScope ChannelBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(Channel.ID_PROPERTY)
		.field(Channel.NAME_PROPERTY)
		;
	/** 用于Channel的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getChannelSummaryScope() {
		return ChannelBaseSummaryScope;
	}

	protected static SerializeScope PeerRoleBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(PeerRole.ID_PROPERTY)
		.field(PeerRole.NAME_PROPERTY)
		.field(PeerRole.CODE_PROPERTY)
		;
	/** 用于PeerRole的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPeerRoleSummaryScope() {
		return PeerRoleBaseSummaryScope;
	}

	protected static SerializeScope ChannelPeerRoleBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ChannelPeerRole.ID_PROPERTY)
		;
	/** 用于ChannelPeerRole的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getChannelPeerRoleSummaryScope() {
		return ChannelPeerRoleBaseSummaryScope;
	}

	protected static SerializeScope ChainCodeBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ChainCode.ID_PROPERTY)
		.field(ChainCode.NAME_PROPERTY)
		.field(ChainCode.CODE_NAME_PROPERTY)
		.field(ChainCode.CODE_VERSION_PROPERTY)
		;
	/** 用于ChainCode的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getChainCodeSummaryScope() {
		return ChainCodeBaseSummaryScope;
	}

	protected static SerializeScope ApplicationBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(Application.ID_PROPERTY)
		.field(Application.NAME_PROPERTY)
		.field(Application.CREATE_TIME_PROPERTY)
		.field(Application.MSPID_PROPERTY)
		.field(Application.PUBLIC_KEY_PROPERTY)
		.field(Application.PRIVATE_KEY_PROPERTY)
		;
	/** 用于Application的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getApplicationSummaryScope() {
		return ApplicationBaseSummaryScope;
	}

	protected static SerializeScope ServiceRecordBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ServiceRecord.ID_PROPERTY)
		.field(ServiceRecord.TRANSACTION_ID_PROPERTY)
		.field(ServiceRecord.NAME_PROPERTY)
		.field(ServiceRecord.PAYLOAD_PROPERTY)
		.field(ServiceRecord.CHAIN_CODE_FUNCTION_PROPERTY)
		.field(ServiceRecord.BLOCK_ID_PROPERTY)
		.field(ServiceRecord.CREATE_TIME_PROPERTY)
		.field(ServiceRecord.RESPONSE_PROPERTY)
		;
	/** 用于ServiceRecord的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getServiceRecordSummaryScope() {
		return ServiceRecordBaseSummaryScope;
	}

	protected static SerializeScope TransactionStatusBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(TransactionStatus.ID_PROPERTY)
		.field(TransactionStatus.NAME_PROPERTY)
		.field(TransactionStatus.CODE_PROPERTY)
		;
	/** 用于TransactionStatus的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getTransactionStatusSummaryScope() {
		return TransactionStatusBaseSummaryScope;
	}

	protected static SerializeScope ChangeRequestTypeBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ChangeRequestType.ID_PROPERTY)
		.field(ChangeRequestType.NAME_PROPERTY)
		.field(ChangeRequestType.CODE_PROPERTY)
		.field(ChangeRequestType.ICON_PROPERTY)
		.field(ChangeRequestType.DISPLAY_ORDER_PROPERTY)
		.field(ChangeRequestType.BIND_TYPES_PROPERTY)
		.field(ChangeRequestType.STEP_CONFIGURATION_PROPERTY)
		;
	/** 用于ChangeRequestType的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getChangeRequestTypeSummaryScope() {
		return ChangeRequestTypeBaseSummaryScope;
	}

	protected static SerializeScope ChangeRequestBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ChangeRequest.ID_PROPERTY)
		.field(ChangeRequest.NAME_PROPERTY)
		.field(ChangeRequest.CREATE_TIME_PROPERTY)
		.field(ChangeRequest.REMOTE_IP_PROPERTY)
		;
	/** 用于ChangeRequest的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getChangeRequestSummaryScope() {
		return ChangeRequestBaseSummaryScope;
	}

	protected static SerializeScope ChainCodeInvokerBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ChainCodeInvoker.ID_PROPERTY)
		.field(ChainCodeInvoker.PARAMETERS_PROPERTY)
		;
	/** 用于ChainCodeInvoker的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getChainCodeInvokerSummaryScope() {
		return ChainCodeInvokerBaseSummaryScope;
	}

	protected static SerializeScope UserDomainBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(UserDomain.ID_PROPERTY)
		.field(UserDomain.NAME_PROPERTY)
		;
	/** 用于UserDomain的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserDomainSummaryScope() {
		return UserDomainBaseSummaryScope;
	}

	protected static SerializeScope UserWhiteListBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(UserWhiteList.ID_PROPERTY)
		.field(UserWhiteList.USER_IDENTITY_PROPERTY)
		.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY)
		;
	/** 用于UserWhiteList的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserWhiteListSummaryScope() {
		return UserWhiteListBaseSummaryScope;
	}

	protected static SerializeScope SecUserBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(SecUser.ID_PROPERTY)
		.field(SecUser.LOGIN_PROPERTY)
		.field(SecUser.MOBILE_PROPERTY)
		.field(SecUser.EMAIL_PROPERTY)
		.field(SecUser.PWD_PROPERTY)
		.field(SecUser.WEIXIN_OPENID_PROPERTY)
		.field(SecUser.WEIXIN_APPID_PROPERTY)
		.field(SecUser.ACCESS_TOKEN_PROPERTY)
		.field(SecUser.VERIFICATION_CODE_PROPERTY)
		.field(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY)
		.field(SecUser.LAST_LOGIN_TIME_PROPERTY)
		;
	/** 用于SecUser的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSecUserSummaryScope() {
		return SecUserBaseSummaryScope;
	}

	protected static SerializeScope SecUserBlockingBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(SecUserBlocking.ID_PROPERTY)
		.field(SecUserBlocking.WHO_PROPERTY)
		.field(SecUserBlocking.BLOCK_TIME_PROPERTY)
		.field(SecUserBlocking.COMMENTS_PROPERTY)
		;
	/** 用于SecUserBlocking的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSecUserBlockingSummaryScope() {
		return SecUserBlockingBaseSummaryScope;
	}

	protected static SerializeScope UserAppBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(UserApp.ID_PROPERTY)
		.field(UserApp.TITLE_PROPERTY)
		.field(UserApp.APP_ICON_PROPERTY)
		.field(UserApp.FULL_ACCESS_PROPERTY)
		.field(UserApp.PERMISSION_PROPERTY)
		.field(UserApp.OBJECT_TYPE_PROPERTY)
		.field(UserApp.OBJECT_ID_PROPERTY)
		.field(UserApp.LOCATION_PROPERTY)
		;
	/** 用于UserApp的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserAppSummaryScope() {
		return UserAppBaseSummaryScope;
	}

	protected static SerializeScope QuickLinkBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(QuickLink.ID_PROPERTY)
		.field(QuickLink.NAME_PROPERTY)
		.field(QuickLink.ICON_PROPERTY)
		.field(QuickLink.IMAGE_PATH_PROPERTY)
		.field(QuickLink.LINK_TARGET_PROPERTY)
		.field(QuickLink.CREATE_TIME_PROPERTY)
		;
	/** 用于QuickLink的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getQuickLinkSummaryScope() {
		return QuickLinkBaseSummaryScope;
	}

	protected static SerializeScope ListAccessBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ListAccess.ID_PROPERTY)
		.field(ListAccess.NAME_PROPERTY)
		.field(ListAccess.INTERNAL_NAME_PROPERTY)
		.field(ListAccess.READ_PERMISSION_PROPERTY)
		.field(ListAccess.CREATE_PERMISSION_PROPERTY)
		.field(ListAccess.DELETE_PERMISSION_PROPERTY)
		.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
		.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
		;
	/** 用于ListAccess的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getListAccessSummaryScope() {
		return ListAccessBaseSummaryScope;
	}

	protected static SerializeScope ObjectAccessBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ObjectAccess.ID_PROPERTY)
		.field(ObjectAccess.NAME_PROPERTY)
		.field(ObjectAccess.OBJECT_TYPE_PROPERTY)
		.field(ObjectAccess.LIST1_PROPERTY)
		.field(ObjectAccess.LIST2_PROPERTY)
		.field(ObjectAccess.LIST3_PROPERTY)
		.field(ObjectAccess.LIST4_PROPERTY)
		.field(ObjectAccess.LIST5_PROPERTY)
		.field(ObjectAccess.LIST6_PROPERTY)
		.field(ObjectAccess.LIST7_PROPERTY)
		.field(ObjectAccess.LIST8_PROPERTY)
		.field(ObjectAccess.LIST9_PROPERTY)
		;
	/** 用于ObjectAccess的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getObjectAccessSummaryScope() {
		return ObjectAccessBaseSummaryScope;
	}

	protected static SerializeScope LoginHistoryBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(LoginHistory.ID_PROPERTY)
		.field(LoginHistory.LOGIN_TIME_PROPERTY)
		.field(LoginHistory.FROM_IP_PROPERTY)
		.field(LoginHistory.DESCRIPTION_PROPERTY)
		;
	/** 用于LoginHistory的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLoginHistorySummaryScope() {
		return LoginHistoryBaseSummaryScope;
	}

	protected static SerializeScope GenericFormBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(GenericForm.ID_PROPERTY)
		.field(GenericForm.TITLE_PROPERTY)
		.field(GenericForm.DESCRIPTION_PROPERTY)
		;
	/** 用于GenericForm的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getGenericFormSummaryScope() {
		return GenericFormBaseSummaryScope;
	}

	protected static SerializeScope FormMessageBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(FormMessage.ID_PROPERTY)
		.field(FormMessage.TITLE_PROPERTY)
		.field(FormMessage.LEVEL_PROPERTY)
		;
	/** 用于FormMessage的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormMessageSummaryScope() {
		return FormMessageBaseSummaryScope;
	}

	protected static SerializeScope FormFieldMessageBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(FormFieldMessage.ID_PROPERTY)
		.field(FormFieldMessage.TITLE_PROPERTY)
		.field(FormFieldMessage.PARAMETER_NAME_PROPERTY)
		.field(FormFieldMessage.LEVEL_PROPERTY)
		;
	/** 用于FormFieldMessage的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormFieldMessageSummaryScope() {
		return FormFieldMessageBaseSummaryScope;
	}

	protected static SerializeScope FormFieldBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(FormField.ID_PROPERTY)
		.field(FormField.LABEL_PROPERTY)
		.field(FormField.LOCALE_KEY_PROPERTY)
		.field(FormField.PARAMETER_NAME_PROPERTY)
		.field(FormField.TYPE_PROPERTY)
		.field(FormField.PLACEHOLDER_PROPERTY)
		.field(FormField.DEFAULT_VALUE_PROPERTY)
		.field(FormField.DESCRIPTION_PROPERTY)
		.field(FormField.FIELD_GROUP_PROPERTY)
		.field(FormField.MINIMUM_VALUE_PROPERTY)
		.field(FormField.MAXIMUM_VALUE_PROPERTY)
		.field(FormField.REQUIRED_PROPERTY)
		.field(FormField.DISABLED_PROPERTY)
		.field(FormField.CUSTOM_RENDERING_PROPERTY)
		.field(FormField.CANDIDATE_VALUES_PROPERTY)
		.field(FormField.SUGGEST_VALUES_PROPERTY)
		;
	/** 用于FormField的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormFieldSummaryScope() {
		return FormFieldBaseSummaryScope;
	}

	protected static SerializeScope FormActionBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(FormAction.ID_PROPERTY)
		.field(FormAction.LABEL_PROPERTY)
		.field(FormAction.LOCALE_KEY_PROPERTY)
		.field(FormAction.ACTION_KEY_PROPERTY)
		.field(FormAction.LEVEL_PROPERTY)
		.field(FormAction.URL_PROPERTY)
		;
	/** 用于FormAction的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormActionSummaryScope() {
		return FormActionBaseSummaryScope;
	}

	protected static SerializeScope CandidateContainerBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(CandidateContainer.ID_PROPERTY)
		.field(CandidateContainer.NAME_PROPERTY)
		;
	/** 用于CandidateContainer的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCandidateContainerSummaryScope() {
		return CandidateContainerBaseSummaryScope;
	}

	protected static SerializeScope CandidateElementBaseSummaryScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(CandidateElement.ID_PROPERTY)
		.field(CandidateElement.NAME_PROPERTY)
		.field(CandidateElement.TYPE_PROPERTY)
		.field(CandidateElement.IMAGE_PROPERTY)
		;
	/** 用于CandidateElement的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCandidateElementSummaryScope() {
		return CandidateElementBaseSummaryScope;
	}

	protected static SerializeScope HyperledgerNetworkBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(HyperledgerNetwork.ID_PROPERTY)
		.field(HyperledgerNetwork.NAME_PROPERTY)
		.field(HyperledgerNetwork.DESCRIPTION_PROPERTY)
		;
	/** 用于HyperledgerNetwork的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getHyperledgerNetworkSecondaryListItemScope() {
		return HyperledgerNetworkBaseSecondaryListItemScope;
	}

	protected static SerializeScope OrganizationBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(Organization.ID_PROPERTY)
		.field(Organization.NAME_PROPERTY)
		.field(Organization.MSPID_PROPERTY)
		;
	/** 用于Organization的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getOrganizationSecondaryListItemScope() {
		return OrganizationBaseSecondaryListItemScope;
	}

	protected static SerializeScope NodeTypeBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(NodeType.ID_PROPERTY)
		.field(NodeType.NAME_PROPERTY)
		.field(NodeType.CODE_PROPERTY)
		;
	/** 用于NodeType的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getNodeTypeSecondaryListItemScope() {
		return NodeTypeBaseSecondaryListItemScope;
	}

	protected static SerializeScope NodeBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(Node.ID_PROPERTY)
		.field(Node.NAME_PROPERTY)
		.field(Node.URL_PROPERTY)
		.field(Node.TLS_CACERT_PROPERTY)
		.field(Node.ADDRESS_PROPERTY)
		.field(Node.CONTACT_PERSON_PROPERTY)
		.field(Node.CONTACT_TELEPHONE_PROPERTY)
		;
	/** 用于Node的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getNodeSecondaryListItemScope() {
		return NodeBaseSecondaryListItemScope;
	}

	protected static SerializeScope GrpcOptionBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(GrpcOption.ID_PROPERTY)
		.field(GrpcOption.PARAMETER_NAME_PROPERTY)
		.field(GrpcOption.PARAMETER_VALUE_PROPERTY)
		;
	/** 用于GrpcOption的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getGrpcOptionSecondaryListItemScope() {
		return GrpcOptionBaseSecondaryListItemScope;
	}

	protected static SerializeScope ChannelBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(Channel.ID_PROPERTY)
		.field(Channel.NAME_PROPERTY)
		;
	/** 用于Channel的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getChannelSecondaryListItemScope() {
		return ChannelBaseSecondaryListItemScope;
	}

	protected static SerializeScope PeerRoleBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(PeerRole.ID_PROPERTY)
		.field(PeerRole.NAME_PROPERTY)
		.field(PeerRole.CODE_PROPERTY)
		;
	/** 用于PeerRole的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPeerRoleSecondaryListItemScope() {
		return PeerRoleBaseSecondaryListItemScope;
	}

	protected static SerializeScope ChannelPeerRoleBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ChannelPeerRole.ID_PROPERTY)
		;
	/** 用于ChannelPeerRole的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getChannelPeerRoleSecondaryListItemScope() {
		return ChannelPeerRoleBaseSecondaryListItemScope;
	}

	protected static SerializeScope ChainCodeBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ChainCode.ID_PROPERTY)
		.field(ChainCode.NAME_PROPERTY)
		.field(ChainCode.CODE_NAME_PROPERTY)
		.field(ChainCode.CODE_VERSION_PROPERTY)
		;
	/** 用于ChainCode的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getChainCodeSecondaryListItemScope() {
		return ChainCodeBaseSecondaryListItemScope;
	}

	protected static SerializeScope ApplicationBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(Application.ID_PROPERTY)
		.field(Application.NAME_PROPERTY)
		.field(Application.CREATE_TIME_PROPERTY)
		.field(Application.MSPID_PROPERTY)
		.field(Application.PUBLIC_KEY_PROPERTY)
		.field(Application.PRIVATE_KEY_PROPERTY)
		;
	/** 用于Application的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getApplicationSecondaryListItemScope() {
		return ApplicationBaseSecondaryListItemScope;
	}

	protected static SerializeScope ServiceRecordBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ServiceRecord.ID_PROPERTY)
		.field(ServiceRecord.TRANSACTION_ID_PROPERTY)
		.field(ServiceRecord.NAME_PROPERTY)
		.field(ServiceRecord.PAYLOAD_PROPERTY)
		.field(ServiceRecord.CHAIN_CODE_FUNCTION_PROPERTY)
		.field(ServiceRecord.BLOCK_ID_PROPERTY)
		.field(ServiceRecord.CREATE_TIME_PROPERTY)
		.field(ServiceRecord.RESPONSE_PROPERTY)
		;
	/** 用于ServiceRecord的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getServiceRecordSecondaryListItemScope() {
		return ServiceRecordBaseSecondaryListItemScope;
	}

	protected static SerializeScope TransactionStatusBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(TransactionStatus.ID_PROPERTY)
		.field(TransactionStatus.NAME_PROPERTY)
		.field(TransactionStatus.CODE_PROPERTY)
		;
	/** 用于TransactionStatus的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getTransactionStatusSecondaryListItemScope() {
		return TransactionStatusBaseSecondaryListItemScope;
	}

	protected static SerializeScope ChangeRequestTypeBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ChangeRequestType.ID_PROPERTY)
		.field(ChangeRequestType.NAME_PROPERTY)
		.field(ChangeRequestType.CODE_PROPERTY)
		.field(ChangeRequestType.ICON_PROPERTY)
		.field(ChangeRequestType.DISPLAY_ORDER_PROPERTY)
		.field(ChangeRequestType.BIND_TYPES_PROPERTY)
		.field(ChangeRequestType.STEP_CONFIGURATION_PROPERTY)
		;
	/** 用于ChangeRequestType的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getChangeRequestTypeSecondaryListItemScope() {
		return ChangeRequestTypeBaseSecondaryListItemScope;
	}

	protected static SerializeScope ChangeRequestBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ChangeRequest.ID_PROPERTY)
		.field(ChangeRequest.NAME_PROPERTY)
		.field(ChangeRequest.CREATE_TIME_PROPERTY)
		.field(ChangeRequest.REMOTE_IP_PROPERTY)
		;
	/** 用于ChangeRequest的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getChangeRequestSecondaryListItemScope() {
		return ChangeRequestBaseSecondaryListItemScope;
	}

	protected static SerializeScope ChainCodeInvokerBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ChainCodeInvoker.ID_PROPERTY)
		.field(ChainCodeInvoker.PARAMETERS_PROPERTY)
		;
	/** 用于ChainCodeInvoker的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getChainCodeInvokerSecondaryListItemScope() {
		return ChainCodeInvokerBaseSecondaryListItemScope;
	}

	protected static SerializeScope UserDomainBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(UserDomain.ID_PROPERTY)
		.field(UserDomain.NAME_PROPERTY)
		;
	/** 用于UserDomain的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserDomainSecondaryListItemScope() {
		return UserDomainBaseSecondaryListItemScope;
	}

	protected static SerializeScope UserWhiteListBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(UserWhiteList.ID_PROPERTY)
		.field(UserWhiteList.USER_IDENTITY_PROPERTY)
		.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY)
		;
	/** 用于UserWhiteList的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserWhiteListSecondaryListItemScope() {
		return UserWhiteListBaseSecondaryListItemScope;
	}

	protected static SerializeScope SecUserBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(SecUser.ID_PROPERTY)
		.field(SecUser.LOGIN_PROPERTY)
		.field(SecUser.MOBILE_PROPERTY)
		.field(SecUser.EMAIL_PROPERTY)
		.field(SecUser.PWD_PROPERTY)
		.field(SecUser.WEIXIN_OPENID_PROPERTY)
		.field(SecUser.WEIXIN_APPID_PROPERTY)
		.field(SecUser.ACCESS_TOKEN_PROPERTY)
		.field(SecUser.VERIFICATION_CODE_PROPERTY)
		.field(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY)
		.field(SecUser.LAST_LOGIN_TIME_PROPERTY)
		;
	/** 用于SecUser的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSecUserSecondaryListItemScope() {
		return SecUserBaseSecondaryListItemScope;
	}

	protected static SerializeScope SecUserBlockingBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(SecUserBlocking.ID_PROPERTY)
		.field(SecUserBlocking.WHO_PROPERTY)
		.field(SecUserBlocking.BLOCK_TIME_PROPERTY)
		.field(SecUserBlocking.COMMENTS_PROPERTY)
		;
	/** 用于SecUserBlocking的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSecUserBlockingSecondaryListItemScope() {
		return SecUserBlockingBaseSecondaryListItemScope;
	}

	protected static SerializeScope UserAppBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(UserApp.ID_PROPERTY)
		.field(UserApp.TITLE_PROPERTY)
		.field(UserApp.APP_ICON_PROPERTY)
		.field(UserApp.FULL_ACCESS_PROPERTY)
		.field(UserApp.PERMISSION_PROPERTY)
		.field(UserApp.OBJECT_TYPE_PROPERTY)
		.field(UserApp.OBJECT_ID_PROPERTY)
		.field(UserApp.LOCATION_PROPERTY)
		;
	/** 用于UserApp的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserAppSecondaryListItemScope() {
		return UserAppBaseSecondaryListItemScope;
	}

	protected static SerializeScope QuickLinkBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(QuickLink.ID_PROPERTY)
		.field(QuickLink.NAME_PROPERTY)
		.field(QuickLink.ICON_PROPERTY)
		.field(QuickLink.IMAGE_PATH_PROPERTY)
		.field(QuickLink.LINK_TARGET_PROPERTY)
		.field(QuickLink.CREATE_TIME_PROPERTY)
		;
	/** 用于QuickLink的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getQuickLinkSecondaryListItemScope() {
		return QuickLinkBaseSecondaryListItemScope;
	}

	protected static SerializeScope ListAccessBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ListAccess.ID_PROPERTY)
		.field(ListAccess.NAME_PROPERTY)
		.field(ListAccess.INTERNAL_NAME_PROPERTY)
		.field(ListAccess.READ_PERMISSION_PROPERTY)
		.field(ListAccess.CREATE_PERMISSION_PROPERTY)
		.field(ListAccess.DELETE_PERMISSION_PROPERTY)
		.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
		.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
		;
	/** 用于ListAccess的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getListAccessSecondaryListItemScope() {
		return ListAccessBaseSecondaryListItemScope;
	}

	protected static SerializeScope ObjectAccessBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ObjectAccess.ID_PROPERTY)
		.field(ObjectAccess.NAME_PROPERTY)
		.field(ObjectAccess.OBJECT_TYPE_PROPERTY)
		.field(ObjectAccess.LIST1_PROPERTY)
		.field(ObjectAccess.LIST2_PROPERTY)
		.field(ObjectAccess.LIST3_PROPERTY)
		.field(ObjectAccess.LIST4_PROPERTY)
		.field(ObjectAccess.LIST5_PROPERTY)
		.field(ObjectAccess.LIST6_PROPERTY)
		.field(ObjectAccess.LIST7_PROPERTY)
		.field(ObjectAccess.LIST8_PROPERTY)
		.field(ObjectAccess.LIST9_PROPERTY)
		;
	/** 用于ObjectAccess的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getObjectAccessSecondaryListItemScope() {
		return ObjectAccessBaseSecondaryListItemScope;
	}

	protected static SerializeScope LoginHistoryBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(LoginHistory.ID_PROPERTY)
		.field(LoginHistory.LOGIN_TIME_PROPERTY)
		.field(LoginHistory.FROM_IP_PROPERTY)
		.field(LoginHistory.DESCRIPTION_PROPERTY)
		;
	/** 用于LoginHistory的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLoginHistorySecondaryListItemScope() {
		return LoginHistoryBaseSecondaryListItemScope;
	}

	protected static SerializeScope GenericFormBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(GenericForm.ID_PROPERTY)
		.field(GenericForm.TITLE_PROPERTY)
		.field(GenericForm.DESCRIPTION_PROPERTY)
		;
	/** 用于GenericForm的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getGenericFormSecondaryListItemScope() {
		return GenericFormBaseSecondaryListItemScope;
	}

	protected static SerializeScope FormMessageBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(FormMessage.ID_PROPERTY)
		.field(FormMessage.TITLE_PROPERTY)
		.field(FormMessage.LEVEL_PROPERTY)
		;
	/** 用于FormMessage的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormMessageSecondaryListItemScope() {
		return FormMessageBaseSecondaryListItemScope;
	}

	protected static SerializeScope FormFieldMessageBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(FormFieldMessage.ID_PROPERTY)
		.field(FormFieldMessage.TITLE_PROPERTY)
		.field(FormFieldMessage.PARAMETER_NAME_PROPERTY)
		.field(FormFieldMessage.LEVEL_PROPERTY)
		;
	/** 用于FormFieldMessage的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormFieldMessageSecondaryListItemScope() {
		return FormFieldMessageBaseSecondaryListItemScope;
	}

	protected static SerializeScope FormFieldBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(FormField.ID_PROPERTY)
		.field(FormField.LABEL_PROPERTY)
		.field(FormField.LOCALE_KEY_PROPERTY)
		.field(FormField.PARAMETER_NAME_PROPERTY)
		.field(FormField.TYPE_PROPERTY)
		.field(FormField.PLACEHOLDER_PROPERTY)
		.field(FormField.DEFAULT_VALUE_PROPERTY)
		.field(FormField.DESCRIPTION_PROPERTY)
		.field(FormField.FIELD_GROUP_PROPERTY)
		.field(FormField.MINIMUM_VALUE_PROPERTY)
		.field(FormField.MAXIMUM_VALUE_PROPERTY)
		.field(FormField.REQUIRED_PROPERTY)
		.field(FormField.DISABLED_PROPERTY)
		.field(FormField.CUSTOM_RENDERING_PROPERTY)
		.field(FormField.CANDIDATE_VALUES_PROPERTY)
		.field(FormField.SUGGEST_VALUES_PROPERTY)
		;
	/** 用于FormField的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormFieldSecondaryListItemScope() {
		return FormFieldBaseSecondaryListItemScope;
	}

	protected static SerializeScope FormActionBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(FormAction.ID_PROPERTY)
		.field(FormAction.LABEL_PROPERTY)
		.field(FormAction.LOCALE_KEY_PROPERTY)
		.field(FormAction.ACTION_KEY_PROPERTY)
		.field(FormAction.LEVEL_PROPERTY)
		.field(FormAction.URL_PROPERTY)
		;
	/** 用于FormAction的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormActionSecondaryListItemScope() {
		return FormActionBaseSecondaryListItemScope;
	}

	protected static SerializeScope CandidateContainerBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(CandidateContainer.ID_PROPERTY)
		.field(CandidateContainer.NAME_PROPERTY)
		;
	/** 用于CandidateContainer的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCandidateContainerSecondaryListItemScope() {
		return CandidateContainerBaseSecondaryListItemScope;
	}

	protected static SerializeScope CandidateElementBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(CandidateElement.ID_PROPERTY)
		.field(CandidateElement.NAME_PROPERTY)
		.field(CandidateElement.TYPE_PROPERTY)
		.field(CandidateElement.IMAGE_PROPERTY)
		;
	/** 用于CandidateElement的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCandidateElementSecondaryListItemScope() {
		return CandidateElementBaseSecondaryListItemScope;
	}

	protected static SerializeScope HyperledgerNetworkBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(HyperledgerNetwork.ID_PROPERTY)
		.field(HyperledgerNetwork.NAME_PROPERTY)
		.field(HyperledgerNetwork.DESCRIPTION_PROPERTY)
		.field(HyperledgerNetwork.ORGANIZATION_LIST, getOrganizationSecondaryListItemScope())
		.field(HyperledgerNetwork.NODE_TYPE_LIST, getNodeTypeSecondaryListItemScope())
		.field(HyperledgerNetwork.NODE_LIST, getNodeSecondaryListItemScope())
		.field(HyperledgerNetwork.CHANNEL_LIST, getChannelSecondaryListItemScope())
		.field(HyperledgerNetwork.PEER_ROLE_LIST, getPeerRoleSecondaryListItemScope())
		.field(HyperledgerNetwork.APPLICATION_LIST, getApplicationSecondaryListItemScope())
		.field(HyperledgerNetwork.SERVICE_RECORD_LIST, getServiceRecordSecondaryListItemScope())
		.field(HyperledgerNetwork.TRANSACTION_STATUS_LIST, getTransactionStatusSecondaryListItemScope())
		.field(HyperledgerNetwork.CHANGE_REQUEST_TYPE_LIST, getChangeRequestTypeSecondaryListItemScope())
		.field(HyperledgerNetwork.CHANGE_REQUEST_LIST, getChangeRequestSecondaryListItemScope())
		;
	/** 用于HyperledgerNetwork对象的列表时需要序列化的属性列表 */
	public static SerializeScope getHyperledgerNetworkListItemScope() {
		return HyperledgerNetworkBaseListItemScope;
	}

	protected static SerializeScope OrganizationBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(Organization.ID_PROPERTY)
		.field(Organization.NAME_PROPERTY)
		.field(Organization.MSPID_PROPERTY)
		.field(Organization.NETWORK_PROPERTY, getHyperledgerNetworkSummaryScope())
		.field(Organization.NODE_LIST, getNodeSecondaryListItemScope())
		;
	/** 用于Organization对象的列表时需要序列化的属性列表 */
	public static SerializeScope getOrganizationListItemScope() {
		return OrganizationBaseListItemScope;
	}

	protected static SerializeScope NodeTypeBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(NodeType.ID_PROPERTY)
		.field(NodeType.NAME_PROPERTY)
		.field(NodeType.CODE_PROPERTY)
		.field(NodeType.NETWORK_PROPERTY, getHyperledgerNetworkSummaryScope())
		.field(NodeType.NODE_LIST, getNodeSecondaryListItemScope())
		;
	/** 用于NodeType对象的列表时需要序列化的属性列表 */
	public static SerializeScope getNodeTypeListItemScope() {
		return NodeTypeBaseListItemScope;
	}

	protected static SerializeScope NodeBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(Node.ID_PROPERTY)
		.field(Node.NAME_PROPERTY)
		.field(Node.URL_PROPERTY)
		.field(Node.ORGANIZATION_PROPERTY, getOrganizationSummaryScope())
		.field(Node.CHANNEL_PROPERTY, getChannelSummaryScope())
		.field(Node.NETWORK_PROPERTY, getHyperledgerNetworkSummaryScope())
		.field(Node.TLS_CACERT_PROPERTY)
		.field(Node.TYPE_PROPERTY, getNodeTypeSummaryScope())
		.field(Node.ADDRESS_PROPERTY)
		.field(Node.CONTACT_PERSON_PROPERTY)
		.field(Node.CONTACT_TELEPHONE_PROPERTY)
		.field(Node.GRPC_OPTION_LIST, getGrpcOptionSecondaryListItemScope())
		.field(Node.CHANNEL_PEER_ROLE_LIST, getChannelPeerRoleSecondaryListItemScope())
		;
	/** 用于Node对象的列表时需要序列化的属性列表 */
	public static SerializeScope getNodeListItemScope() {
		return NodeBaseListItemScope;
	}

	protected static SerializeScope GrpcOptionBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(GrpcOption.ID_PROPERTY)
		.field(GrpcOption.PARAMETER_NAME_PROPERTY)
		.field(GrpcOption.PARAMETER_VALUE_PROPERTY)
		.field(GrpcOption.NODE_PROPERTY, getNodeSummaryScope())
		;
	/** 用于GrpcOption对象的列表时需要序列化的属性列表 */
	public static SerializeScope getGrpcOptionListItemScope() {
		return GrpcOptionBaseListItemScope;
	}

	protected static SerializeScope ChannelBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(Channel.ID_PROPERTY)
		.field(Channel.NAME_PROPERTY)
		.field(Channel.NETWORK_PROPERTY, getHyperledgerNetworkSummaryScope())
		.field(Channel.NODE_LIST, getNodeSecondaryListItemScope())
		.field(Channel.CHANNEL_PEER_ROLE_LIST, getChannelPeerRoleSecondaryListItemScope())
		.field(Channel.CHAIN_CODE_LIST, getChainCodeSecondaryListItemScope())
		.field(Channel.APPLICATION_LIST, getApplicationSecondaryListItemScope())
		.field(Channel.SERVICE_RECORD_LIST, getServiceRecordSecondaryListItemScope())
		;
	/** 用于Channel对象的列表时需要序列化的属性列表 */
	public static SerializeScope getChannelListItemScope() {
		return ChannelBaseListItemScope;
	}

	protected static SerializeScope PeerRoleBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(PeerRole.ID_PROPERTY)
		.field(PeerRole.NAME_PROPERTY)
		.field(PeerRole.CODE_PROPERTY)
		.field(PeerRole.NETWORK_PROPERTY, getHyperledgerNetworkSummaryScope())
		.field(PeerRole.CHANNEL_PEER_ROLE_LIST, getChannelPeerRoleSecondaryListItemScope())
		;
	/** 用于PeerRole对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPeerRoleListItemScope() {
		return PeerRoleBaseListItemScope;
	}

	protected static SerializeScope ChannelPeerRoleBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ChannelPeerRole.ID_PROPERTY)
		.field(ChannelPeerRole.CHANNEL_PROPERTY, getChannelSummaryScope())
		.field(ChannelPeerRole.NODE_PROPERTY, getNodeSummaryScope())
		.field(ChannelPeerRole.PEER_ROLE_PROPERTY, getPeerRoleSummaryScope())
		;
	/** 用于ChannelPeerRole对象的列表时需要序列化的属性列表 */
	public static SerializeScope getChannelPeerRoleListItemScope() {
		return ChannelPeerRoleBaseListItemScope;
	}

	protected static SerializeScope ChainCodeBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ChainCode.ID_PROPERTY)
		.field(ChainCode.NAME_PROPERTY)
		.field(ChainCode.CODE_NAME_PROPERTY)
		.field(ChainCode.CODE_VERSION_PROPERTY)
		.field(ChainCode.CHANNEL_PROPERTY, getChannelSummaryScope())
		.field(ChainCode.SERVICE_RECORD_LIST, getServiceRecordSecondaryListItemScope())
		.field(ChainCode.CHAIN_CODE_INVOKER_LIST, getChainCodeInvokerSecondaryListItemScope())
		;
	/** 用于ChainCode对象的列表时需要序列化的属性列表 */
	public static SerializeScope getChainCodeListItemScope() {
		return ChainCodeBaseListItemScope;
	}

	protected static SerializeScope ApplicationBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(Application.ID_PROPERTY)
		.field(Application.NAME_PROPERTY)
		.field(Application.CREATE_TIME_PROPERTY)
		.field(Application.MSPID_PROPERTY)
		.field(Application.PUBLIC_KEY_PROPERTY)
		.field(Application.PRIVATE_KEY_PROPERTY)
		.field(Application.CHANNEL_PROPERTY, getChannelSummaryScope())
		.field(Application.NETWORK_PROPERTY, getHyperledgerNetworkSummaryScope())
		.field(Application.SERVICE_RECORD_LIST, getServiceRecordSecondaryListItemScope())
		.field(Application.CHAIN_CODE_INVOKER_LIST, getChainCodeInvokerSecondaryListItemScope())
		;
	/** 用于Application对象的列表时需要序列化的属性列表 */
	public static SerializeScope getApplicationListItemScope() {
		return ApplicationBaseListItemScope;
	}

	protected static SerializeScope ServiceRecordBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ServiceRecord.ID_PROPERTY)
		.field(ServiceRecord.TRANSACTION_ID_PROPERTY)
		.field(ServiceRecord.NAME_PROPERTY)
		.field(ServiceRecord.PAYLOAD_PROPERTY)
		.field(ServiceRecord.CHANNEL_PROPERTY, getChannelSummaryScope())
		.field(ServiceRecord.CHAIN_CODE_PROPERTY, getChainCodeSummaryScope())
		.field(ServiceRecord.CHAIN_CODE_FUNCTION_PROPERTY)
		.field(ServiceRecord.BLOCK_ID_PROPERTY)
		.field(ServiceRecord.CREATE_TIME_PROPERTY)
		.field(ServiceRecord.APP_CLIENT_PROPERTY, getApplicationSummaryScope())
		.field(ServiceRecord.NETWORK_PROPERTY, getHyperledgerNetworkSummaryScope())
		.field(ServiceRecord.RESPONSE_PROPERTY)
		.field(ServiceRecord.STATUS_PROPERTY, getTransactionStatusSummaryScope())
		;
	/** 用于ServiceRecord对象的列表时需要序列化的属性列表 */
	public static SerializeScope getServiceRecordListItemScope() {
		return ServiceRecordBaseListItemScope;
	}

	protected static SerializeScope TransactionStatusBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(TransactionStatus.ID_PROPERTY)
		.field(TransactionStatus.NAME_PROPERTY)
		.field(TransactionStatus.CODE_PROPERTY)
		.field(TransactionStatus.NETWORK_PROPERTY, getHyperledgerNetworkSummaryScope())
		.field(TransactionStatus.SERVICE_RECORD_LIST, getServiceRecordSecondaryListItemScope())
		;
	/** 用于TransactionStatus对象的列表时需要序列化的属性列表 */
	public static SerializeScope getTransactionStatusListItemScope() {
		return TransactionStatusBaseListItemScope;
	}

	protected static SerializeScope ChangeRequestTypeBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ChangeRequestType.ID_PROPERTY)
		.field(ChangeRequestType.NAME_PROPERTY)
		.field(ChangeRequestType.CODE_PROPERTY)
		.field(ChangeRequestType.ICON_PROPERTY)
		.field(ChangeRequestType.DISPLAY_ORDER_PROPERTY)
		.field(ChangeRequestType.BIND_TYPES_PROPERTY)
		.field(ChangeRequestType.STEP_CONFIGURATION_PROPERTY)
		.field(ChangeRequestType.NETWORK_PROPERTY, getHyperledgerNetworkSummaryScope())
		.field(ChangeRequestType.CHANGE_REQUEST_LIST, getChangeRequestSecondaryListItemScope())
		;
	/** 用于ChangeRequestType对象的列表时需要序列化的属性列表 */
	public static SerializeScope getChangeRequestTypeListItemScope() {
		return ChangeRequestTypeBaseListItemScope;
	}

	protected static SerializeScope ChangeRequestBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ChangeRequest.ID_PROPERTY)
		.field(ChangeRequest.NAME_PROPERTY)
		.field(ChangeRequest.CREATE_TIME_PROPERTY)
		.field(ChangeRequest.REMOTE_IP_PROPERTY)
		.field(ChangeRequest.REQUEST_TYPE_PROPERTY, getChangeRequestTypeSummaryScope())
		.field(ChangeRequest.NETWORK_PROPERTY, getHyperledgerNetworkSummaryScope())
		.field(ChangeRequest.CHAIN_CODE_INVOKER_LIST, getChainCodeInvokerSecondaryListItemScope())
		;
	/** 用于ChangeRequest对象的列表时需要序列化的属性列表 */
	public static SerializeScope getChangeRequestListItemScope() {
		return ChangeRequestBaseListItemScope;
	}

	protected static SerializeScope ChainCodeInvokerBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ChainCodeInvoker.ID_PROPERTY)
		.field(ChainCodeInvoker.APP_CLIENT_PROPERTY, getApplicationSummaryScope())
		.field(ChainCodeInvoker.CHAIN_CODE_PROPERTY, getChainCodeSummaryScope())
		.field(ChainCodeInvoker.PARAMETERS_PROPERTY)
		.field(ChainCodeInvoker.CHANGE_REQUEST_PROPERTY, getChangeRequestSummaryScope())
		;
	/** 用于ChainCodeInvoker对象的列表时需要序列化的属性列表 */
	public static SerializeScope getChainCodeInvokerListItemScope() {
		return ChainCodeInvokerBaseListItemScope;
	}

	protected static SerializeScope UserDomainBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(UserDomain.ID_PROPERTY)
		.field(UserDomain.NAME_PROPERTY)
		.field(UserDomain.USER_WHITE_LIST_LIST, getUserWhiteListSecondaryListItemScope())
		.field(UserDomain.SEC_USER_LIST, getSecUserSecondaryListItemScope())
		;
	/** 用于UserDomain对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserDomainListItemScope() {
		return UserDomainBaseListItemScope;
	}

	protected static SerializeScope UserWhiteListBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(UserWhiteList.ID_PROPERTY)
		.field(UserWhiteList.USER_IDENTITY_PROPERTY)
		.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY)
		.field(UserWhiteList.DOMAIN_PROPERTY, getUserDomainSummaryScope())
		;
	/** 用于UserWhiteList对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserWhiteListListItemScope() {
		return UserWhiteListBaseListItemScope;
	}

	protected static SerializeScope SecUserBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(SecUser.ID_PROPERTY)
		.field(SecUser.LOGIN_PROPERTY)
		.field(SecUser.MOBILE_PROPERTY)
		.field(SecUser.EMAIL_PROPERTY)
		.field(SecUser.PWD_PROPERTY)
		.field(SecUser.WEIXIN_OPENID_PROPERTY)
		.field(SecUser.WEIXIN_APPID_PROPERTY)
		.field(SecUser.ACCESS_TOKEN_PROPERTY)
		.field(SecUser.VERIFICATION_CODE_PROPERTY)
		.field(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY)
		.field(SecUser.LAST_LOGIN_TIME_PROPERTY)
		.field(SecUser.DOMAIN_PROPERTY, getUserDomainSummaryScope())
		.field(SecUser.BLOCKING_PROPERTY, getSecUserBlockingSummaryScope())
		.field(SecUser.USER_APP_LIST, getUserAppSecondaryListItemScope())
		.field(SecUser.LOGIN_HISTORY_LIST, getLoginHistorySecondaryListItemScope())
		;
	/** 用于SecUser对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSecUserListItemScope() {
		return SecUserBaseListItemScope;
	}

	protected static SerializeScope SecUserBlockingBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(SecUserBlocking.ID_PROPERTY)
		.field(SecUserBlocking.WHO_PROPERTY)
		.field(SecUserBlocking.BLOCK_TIME_PROPERTY)
		.field(SecUserBlocking.COMMENTS_PROPERTY)
		.field(SecUserBlocking.SEC_USER_LIST, getSecUserSecondaryListItemScope())
		;
	/** 用于SecUserBlocking对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSecUserBlockingListItemScope() {
		return SecUserBlockingBaseListItemScope;
	}

	protected static SerializeScope UserAppBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(UserApp.ID_PROPERTY)
		.field(UserApp.TITLE_PROPERTY)
		.field(UserApp.SEC_USER_PROPERTY, getSecUserSummaryScope())
		.field(UserApp.APP_ICON_PROPERTY)
		.field(UserApp.FULL_ACCESS_PROPERTY)
		.field(UserApp.PERMISSION_PROPERTY)
		.field(UserApp.OBJECT_TYPE_PROPERTY)
		.field(UserApp.OBJECT_ID_PROPERTY)
		.field(UserApp.LOCATION_PROPERTY)
		.field(UserApp.QUICK_LINK_LIST, getQuickLinkSecondaryListItemScope())
		.field(UserApp.LIST_ACCESS_LIST, getListAccessSecondaryListItemScope())
		.field(UserApp.OBJECT_ACCESS_LIST, getObjectAccessSecondaryListItemScope())
		;
	/** 用于UserApp对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserAppListItemScope() {
		return UserAppBaseListItemScope;
	}

	protected static SerializeScope QuickLinkBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(QuickLink.ID_PROPERTY)
		.field(QuickLink.NAME_PROPERTY)
		.field(QuickLink.ICON_PROPERTY)
		.field(QuickLink.IMAGE_PATH_PROPERTY)
		.field(QuickLink.LINK_TARGET_PROPERTY)
		.field(QuickLink.CREATE_TIME_PROPERTY)
		.field(QuickLink.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于QuickLink对象的列表时需要序列化的属性列表 */
	public static SerializeScope getQuickLinkListItemScope() {
		return QuickLinkBaseListItemScope;
	}

	protected static SerializeScope ListAccessBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ListAccess.ID_PROPERTY)
		.field(ListAccess.NAME_PROPERTY)
		.field(ListAccess.INTERNAL_NAME_PROPERTY)
		.field(ListAccess.READ_PERMISSION_PROPERTY)
		.field(ListAccess.CREATE_PERMISSION_PROPERTY)
		.field(ListAccess.DELETE_PERMISSION_PROPERTY)
		.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
		.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
		.field(ListAccess.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于ListAccess对象的列表时需要序列化的属性列表 */
	public static SerializeScope getListAccessListItemScope() {
		return ListAccessBaseListItemScope;
	}

	protected static SerializeScope ObjectAccessBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ObjectAccess.ID_PROPERTY)
		.field(ObjectAccess.NAME_PROPERTY)
		.field(ObjectAccess.OBJECT_TYPE_PROPERTY)
		.field(ObjectAccess.LIST1_PROPERTY)
		.field(ObjectAccess.LIST2_PROPERTY)
		.field(ObjectAccess.LIST3_PROPERTY)
		.field(ObjectAccess.LIST4_PROPERTY)
		.field(ObjectAccess.LIST5_PROPERTY)
		.field(ObjectAccess.LIST6_PROPERTY)
		.field(ObjectAccess.LIST7_PROPERTY)
		.field(ObjectAccess.LIST8_PROPERTY)
		.field(ObjectAccess.LIST9_PROPERTY)
		.field(ObjectAccess.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于ObjectAccess对象的列表时需要序列化的属性列表 */
	public static SerializeScope getObjectAccessListItemScope() {
		return ObjectAccessBaseListItemScope;
	}

	protected static SerializeScope LoginHistoryBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(LoginHistory.ID_PROPERTY)
		.field(LoginHistory.LOGIN_TIME_PROPERTY)
		.field(LoginHistory.FROM_IP_PROPERTY)
		.field(LoginHistory.DESCRIPTION_PROPERTY)
		.field(LoginHistory.SEC_USER_PROPERTY, getSecUserSummaryScope())
		;
	/** 用于LoginHistory对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLoginHistoryListItemScope() {
		return LoginHistoryBaseListItemScope;
	}

	protected static SerializeScope GenericFormBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(GenericForm.ID_PROPERTY)
		.field(GenericForm.TITLE_PROPERTY)
		.field(GenericForm.DESCRIPTION_PROPERTY)
		.field(GenericForm.FORM_MESSAGE_LIST, getFormMessageSecondaryListItemScope())
		.field(GenericForm.FORM_FIELD_MESSAGE_LIST, getFormFieldMessageSecondaryListItemScope())
		.field(GenericForm.FORM_FIELD_LIST, getFormFieldSecondaryListItemScope())
		.field(GenericForm.FORM_ACTION_LIST, getFormActionSecondaryListItemScope())
		;
	/** 用于GenericForm对象的列表时需要序列化的属性列表 */
	public static SerializeScope getGenericFormListItemScope() {
		return GenericFormBaseListItemScope;
	}

	protected static SerializeScope FormMessageBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(FormMessage.ID_PROPERTY)
		.field(FormMessage.TITLE_PROPERTY)
		.field(FormMessage.FORM_PROPERTY, getGenericFormSummaryScope())
		.field(FormMessage.LEVEL_PROPERTY)
		;
	/** 用于FormMessage对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormMessageListItemScope() {
		return FormMessageBaseListItemScope;
	}

	protected static SerializeScope FormFieldMessageBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(FormFieldMessage.ID_PROPERTY)
		.field(FormFieldMessage.TITLE_PROPERTY)
		.field(FormFieldMessage.PARAMETER_NAME_PROPERTY)
		.field(FormFieldMessage.FORM_PROPERTY, getGenericFormSummaryScope())
		.field(FormFieldMessage.LEVEL_PROPERTY)
		;
	/** 用于FormFieldMessage对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormFieldMessageListItemScope() {
		return FormFieldMessageBaseListItemScope;
	}

	protected static SerializeScope FormFieldBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(FormField.ID_PROPERTY)
		.field(FormField.LABEL_PROPERTY)
		.field(FormField.LOCALE_KEY_PROPERTY)
		.field(FormField.PARAMETER_NAME_PROPERTY)
		.field(FormField.TYPE_PROPERTY)
		.field(FormField.FORM_PROPERTY, getGenericFormSummaryScope())
		.field(FormField.PLACEHOLDER_PROPERTY)
		.field(FormField.DEFAULT_VALUE_PROPERTY)
		.field(FormField.DESCRIPTION_PROPERTY)
		.field(FormField.FIELD_GROUP_PROPERTY)
		.field(FormField.MINIMUM_VALUE_PROPERTY)
		.field(FormField.MAXIMUM_VALUE_PROPERTY)
		.field(FormField.REQUIRED_PROPERTY)
		.field(FormField.DISABLED_PROPERTY)
		.field(FormField.CUSTOM_RENDERING_PROPERTY)
		.field(FormField.CANDIDATE_VALUES_PROPERTY)
		.field(FormField.SUGGEST_VALUES_PROPERTY)
		;
	/** 用于FormField对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormFieldListItemScope() {
		return FormFieldBaseListItemScope;
	}

	protected static SerializeScope FormActionBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(FormAction.ID_PROPERTY)
		.field(FormAction.LABEL_PROPERTY)
		.field(FormAction.LOCALE_KEY_PROPERTY)
		.field(FormAction.ACTION_KEY_PROPERTY)
		.field(FormAction.LEVEL_PROPERTY)
		.field(FormAction.URL_PROPERTY)
		.field(FormAction.FORM_PROPERTY, getGenericFormSummaryScope())
		;
	/** 用于FormAction对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormActionListItemScope() {
		return FormActionBaseListItemScope;
	}

	protected static SerializeScope CandidateContainerBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(CandidateContainer.ID_PROPERTY)
		.field(CandidateContainer.NAME_PROPERTY)
		.field(CandidateContainer.CANDIDATE_ELEMENT_LIST, getCandidateElementSecondaryListItemScope())
		;
	/** 用于CandidateContainer对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCandidateContainerListItemScope() {
		return CandidateContainerBaseListItemScope;
	}

	protected static SerializeScope CandidateElementBaseListItemScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(CandidateElement.ID_PROPERTY)
		.field(CandidateElement.NAME_PROPERTY)
		.field(CandidateElement.TYPE_PROPERTY)
		.field(CandidateElement.IMAGE_PROPERTY)
		.field(CandidateElement.CONTAINER_PROPERTY, getCandidateContainerSummaryScope())
		;
	/** 用于CandidateElement对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCandidateElementListItemScope() {
		return CandidateElementBaseListItemScope;
	}

	protected static SerializeScope HyperledgerNetworkBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(HyperledgerNetwork.ID_PROPERTY)
		.field(HyperledgerNetwork.NAME_PROPERTY)
		.field(HyperledgerNetwork.DESCRIPTION_PROPERTY)
		.field(HyperledgerNetwork.ORGANIZATION_LIST, getOrganizationListItemScope())
		.field(HyperledgerNetwork.NODE_TYPE_LIST, getNodeTypeListItemScope())
		.field(HyperledgerNetwork.NODE_LIST, getNodeListItemScope())
		.field(HyperledgerNetwork.CHANNEL_LIST, getChannelListItemScope())
		.field(HyperledgerNetwork.PEER_ROLE_LIST, getPeerRoleListItemScope())
		.field(HyperledgerNetwork.APPLICATION_LIST, getApplicationListItemScope())
		.field(HyperledgerNetwork.SERVICE_RECORD_LIST, getServiceRecordListItemScope())
		.field(HyperledgerNetwork.TRANSACTION_STATUS_LIST, getTransactionStatusListItemScope())
		.field(HyperledgerNetwork.CHANGE_REQUEST_TYPE_LIST, getChangeRequestTypeListItemScope())
		.field(HyperledgerNetwork.CHANGE_REQUEST_LIST, getChangeRequestListItemScope())
		;
	/** 用于HyperledgerNetwork对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getHyperledgerNetworkDetailScope() {
		return HyperledgerNetworkBaseDetailScope;
	}

	protected static SerializeScope OrganizationBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(Organization.ID_PROPERTY)
		.field(Organization.NAME_PROPERTY)
		.field(Organization.MSPID_PROPERTY)
		.field(Organization.NETWORK_PROPERTY, getHyperledgerNetworkSummaryScope())
		.field(Organization.NODE_LIST, getNodeListItemScope())
		;
	/** 用于Organization对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getOrganizationDetailScope() {
		return OrganizationBaseDetailScope;
	}

	protected static SerializeScope NodeTypeBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(NodeType.ID_PROPERTY)
		.field(NodeType.NAME_PROPERTY)
		.field(NodeType.CODE_PROPERTY)
		.field(NodeType.NETWORK_PROPERTY, getHyperledgerNetworkSummaryScope())
		.field(NodeType.NODE_LIST, getNodeListItemScope())
		;
	/** 用于NodeType对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getNodeTypeDetailScope() {
		return NodeTypeBaseDetailScope;
	}

	protected static SerializeScope NodeBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(Node.ID_PROPERTY)
		.field(Node.NAME_PROPERTY)
		.field(Node.URL_PROPERTY)
		.field(Node.ORGANIZATION_PROPERTY, getOrganizationSummaryScope())
		.field(Node.CHANNEL_PROPERTY, getChannelSummaryScope())
		.field(Node.NETWORK_PROPERTY, getHyperledgerNetworkSummaryScope())
		.field(Node.TLS_CACERT_PROPERTY)
		.field(Node.TYPE_PROPERTY, getNodeTypeSummaryScope())
		.field(Node.ADDRESS_PROPERTY)
		.field(Node.CONTACT_PERSON_PROPERTY)
		.field(Node.CONTACT_TELEPHONE_PROPERTY)
		.field(Node.GRPC_OPTION_LIST, getGrpcOptionListItemScope())
		.field(Node.CHANNEL_PEER_ROLE_LIST, getChannelPeerRoleListItemScope())
		;
	/** 用于Node对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getNodeDetailScope() {
		return NodeBaseDetailScope;
	}

	protected static SerializeScope GrpcOptionBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(GrpcOption.ID_PROPERTY)
		.field(GrpcOption.PARAMETER_NAME_PROPERTY)
		.field(GrpcOption.PARAMETER_VALUE_PROPERTY)
		.field(GrpcOption.NODE_PROPERTY, getNodeSummaryScope())
		;
	/** 用于GrpcOption对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getGrpcOptionDetailScope() {
		return GrpcOptionBaseDetailScope;
	}

	protected static SerializeScope ChannelBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(Channel.ID_PROPERTY)
		.field(Channel.NAME_PROPERTY)
		.field(Channel.NETWORK_PROPERTY, getHyperledgerNetworkSummaryScope())
		.field(Channel.NODE_LIST, getNodeListItemScope())
		.field(Channel.CHANNEL_PEER_ROLE_LIST, getChannelPeerRoleListItemScope())
		.field(Channel.CHAIN_CODE_LIST, getChainCodeListItemScope())
		.field(Channel.APPLICATION_LIST, getApplicationListItemScope())
		.field(Channel.SERVICE_RECORD_LIST, getServiceRecordListItemScope())
		;
	/** 用于Channel对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getChannelDetailScope() {
		return ChannelBaseDetailScope;
	}

	protected static SerializeScope PeerRoleBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(PeerRole.ID_PROPERTY)
		.field(PeerRole.NAME_PROPERTY)
		.field(PeerRole.CODE_PROPERTY)
		.field(PeerRole.NETWORK_PROPERTY, getHyperledgerNetworkSummaryScope())
		.field(PeerRole.CHANNEL_PEER_ROLE_LIST, getChannelPeerRoleListItemScope())
		;
	/** 用于PeerRole对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPeerRoleDetailScope() {
		return PeerRoleBaseDetailScope;
	}

	protected static SerializeScope ChannelPeerRoleBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ChannelPeerRole.ID_PROPERTY)
		.field(ChannelPeerRole.CHANNEL_PROPERTY, getChannelSummaryScope())
		.field(ChannelPeerRole.NODE_PROPERTY, getNodeSummaryScope())
		.field(ChannelPeerRole.PEER_ROLE_PROPERTY, getPeerRoleSummaryScope())
		;
	/** 用于ChannelPeerRole对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getChannelPeerRoleDetailScope() {
		return ChannelPeerRoleBaseDetailScope;
	}

	protected static SerializeScope ChainCodeBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ChainCode.ID_PROPERTY)
		.field(ChainCode.NAME_PROPERTY)
		.field(ChainCode.CODE_NAME_PROPERTY)
		.field(ChainCode.CODE_VERSION_PROPERTY)
		.field(ChainCode.CHANNEL_PROPERTY, getChannelSummaryScope())
		.field(ChainCode.SERVICE_RECORD_LIST, getServiceRecordListItemScope())
		.field(ChainCode.CHAIN_CODE_INVOKER_LIST, getChainCodeInvokerListItemScope())
		;
	/** 用于ChainCode对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getChainCodeDetailScope() {
		return ChainCodeBaseDetailScope;
	}

	protected static SerializeScope ApplicationBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(Application.ID_PROPERTY)
		.field(Application.NAME_PROPERTY)
		.field(Application.CREATE_TIME_PROPERTY)
		.field(Application.MSPID_PROPERTY)
		.field(Application.PUBLIC_KEY_PROPERTY)
		.field(Application.PRIVATE_KEY_PROPERTY)
		.field(Application.CHANNEL_PROPERTY, getChannelSummaryScope())
		.field(Application.NETWORK_PROPERTY, getHyperledgerNetworkSummaryScope())
		.field(Application.SERVICE_RECORD_LIST, getServiceRecordListItemScope())
		.field(Application.CHAIN_CODE_INVOKER_LIST, getChainCodeInvokerListItemScope())
		;
	/** 用于Application对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getApplicationDetailScope() {
		return ApplicationBaseDetailScope;
	}

	protected static SerializeScope ServiceRecordBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ServiceRecord.ID_PROPERTY)
		.field(ServiceRecord.TRANSACTION_ID_PROPERTY)
		.field(ServiceRecord.NAME_PROPERTY)
		.field(ServiceRecord.PAYLOAD_PROPERTY)
		.field(ServiceRecord.CHANNEL_PROPERTY, getChannelSummaryScope())
		.field(ServiceRecord.CHAIN_CODE_PROPERTY, getChainCodeSummaryScope())
		.field(ServiceRecord.CHAIN_CODE_FUNCTION_PROPERTY)
		.field(ServiceRecord.BLOCK_ID_PROPERTY)
		.field(ServiceRecord.CREATE_TIME_PROPERTY)
		.field(ServiceRecord.APP_CLIENT_PROPERTY, getApplicationSummaryScope())
		.field(ServiceRecord.NETWORK_PROPERTY, getHyperledgerNetworkSummaryScope())
		.field(ServiceRecord.RESPONSE_PROPERTY)
		.field(ServiceRecord.STATUS_PROPERTY, getTransactionStatusSummaryScope())
		;
	/** 用于ServiceRecord对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getServiceRecordDetailScope() {
		return ServiceRecordBaseDetailScope;
	}

	protected static SerializeScope TransactionStatusBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(TransactionStatus.ID_PROPERTY)
		.field(TransactionStatus.NAME_PROPERTY)
		.field(TransactionStatus.CODE_PROPERTY)
		.field(TransactionStatus.NETWORK_PROPERTY, getHyperledgerNetworkSummaryScope())
		.field(TransactionStatus.SERVICE_RECORD_LIST, getServiceRecordListItemScope())
		;
	/** 用于TransactionStatus对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getTransactionStatusDetailScope() {
		return TransactionStatusBaseDetailScope;
	}

	protected static SerializeScope ChangeRequestTypeBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ChangeRequestType.ID_PROPERTY)
		.field(ChangeRequestType.NAME_PROPERTY)
		.field(ChangeRequestType.CODE_PROPERTY)
		.field(ChangeRequestType.ICON_PROPERTY)
		.field(ChangeRequestType.DISPLAY_ORDER_PROPERTY)
		.field(ChangeRequestType.BIND_TYPES_PROPERTY)
		.field(ChangeRequestType.STEP_CONFIGURATION_PROPERTY)
		.field(ChangeRequestType.NETWORK_PROPERTY, getHyperledgerNetworkSummaryScope())
		.field(ChangeRequestType.CHANGE_REQUEST_LIST, getChangeRequestListItemScope())
		;
	/** 用于ChangeRequestType对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getChangeRequestTypeDetailScope() {
		return ChangeRequestTypeBaseDetailScope;
	}

	protected static SerializeScope ChangeRequestBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ChangeRequest.ID_PROPERTY)
		.field(ChangeRequest.NAME_PROPERTY)
		.field(ChangeRequest.CREATE_TIME_PROPERTY)
		.field(ChangeRequest.REMOTE_IP_PROPERTY)
		.field(ChangeRequest.REQUEST_TYPE_PROPERTY, getChangeRequestTypeSummaryScope())
		.field(ChangeRequest.NETWORK_PROPERTY, getHyperledgerNetworkSummaryScope())
		.field(ChangeRequest.CHAIN_CODE_INVOKER_LIST, getChainCodeInvokerListItemScope())
		;
	/** 用于ChangeRequest对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getChangeRequestDetailScope() {
		return ChangeRequestBaseDetailScope;
	}

	protected static SerializeScope ChainCodeInvokerBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ChainCodeInvoker.ID_PROPERTY)
		.field(ChainCodeInvoker.APP_CLIENT_PROPERTY, getApplicationSummaryScope())
		.field(ChainCodeInvoker.CHAIN_CODE_PROPERTY, getChainCodeSummaryScope())
		.field(ChainCodeInvoker.PARAMETERS_PROPERTY)
		.field(ChainCodeInvoker.CHANGE_REQUEST_PROPERTY, getChangeRequestSummaryScope())
		;
	/** 用于ChainCodeInvoker对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getChainCodeInvokerDetailScope() {
		return ChainCodeInvokerBaseDetailScope;
	}

	protected static SerializeScope UserDomainBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(UserDomain.ID_PROPERTY)
		.field(UserDomain.NAME_PROPERTY)
		.field(UserDomain.USER_WHITE_LIST_LIST, getUserWhiteListListItemScope())
		.field(UserDomain.SEC_USER_LIST, getSecUserListItemScope())
		;
	/** 用于UserDomain对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserDomainDetailScope() {
		return UserDomainBaseDetailScope;
	}

	protected static SerializeScope UserWhiteListBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(UserWhiteList.ID_PROPERTY)
		.field(UserWhiteList.USER_IDENTITY_PROPERTY)
		.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY)
		.field(UserWhiteList.DOMAIN_PROPERTY, getUserDomainSummaryScope())
		;
	/** 用于UserWhiteList对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserWhiteListDetailScope() {
		return UserWhiteListBaseDetailScope;
	}

	protected static SerializeScope SecUserBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(SecUser.ID_PROPERTY)
		.field(SecUser.LOGIN_PROPERTY)
		.field(SecUser.MOBILE_PROPERTY)
		.field(SecUser.EMAIL_PROPERTY)
		.field(SecUser.PWD_PROPERTY)
		.field(SecUser.WEIXIN_OPENID_PROPERTY)
		.field(SecUser.WEIXIN_APPID_PROPERTY)
		.field(SecUser.ACCESS_TOKEN_PROPERTY)
		.field(SecUser.VERIFICATION_CODE_PROPERTY)
		.field(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY)
		.field(SecUser.LAST_LOGIN_TIME_PROPERTY)
		.field(SecUser.DOMAIN_PROPERTY, getUserDomainSummaryScope())
		.field(SecUser.BLOCKING_PROPERTY, getSecUserBlockingSummaryScope())
		.field(SecUser.USER_APP_LIST, getUserAppListItemScope())
		.field(SecUser.LOGIN_HISTORY_LIST, getLoginHistoryListItemScope())
		;
	/** 用于SecUser对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSecUserDetailScope() {
		return SecUserBaseDetailScope;
	}

	protected static SerializeScope SecUserBlockingBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(SecUserBlocking.ID_PROPERTY)
		.field(SecUserBlocking.WHO_PROPERTY)
		.field(SecUserBlocking.BLOCK_TIME_PROPERTY)
		.field(SecUserBlocking.COMMENTS_PROPERTY)
		.field(SecUserBlocking.SEC_USER_LIST, getSecUserListItemScope())
		;
	/** 用于SecUserBlocking对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSecUserBlockingDetailScope() {
		return SecUserBlockingBaseDetailScope;
	}

	protected static SerializeScope UserAppBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(UserApp.ID_PROPERTY)
		.field(UserApp.TITLE_PROPERTY)
		.field(UserApp.SEC_USER_PROPERTY, getSecUserSummaryScope())
		.field(UserApp.APP_ICON_PROPERTY)
		.field(UserApp.FULL_ACCESS_PROPERTY)
		.field(UserApp.PERMISSION_PROPERTY)
		.field(UserApp.OBJECT_TYPE_PROPERTY)
		.field(UserApp.OBJECT_ID_PROPERTY)
		.field(UserApp.LOCATION_PROPERTY)
		.field(UserApp.QUICK_LINK_LIST, getQuickLinkListItemScope())
		.field(UserApp.LIST_ACCESS_LIST, getListAccessListItemScope())
		.field(UserApp.OBJECT_ACCESS_LIST, getObjectAccessListItemScope())
		;
	/** 用于UserApp对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserAppDetailScope() {
		return UserAppBaseDetailScope;
	}

	protected static SerializeScope QuickLinkBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(QuickLink.ID_PROPERTY)
		.field(QuickLink.NAME_PROPERTY)
		.field(QuickLink.ICON_PROPERTY)
		.field(QuickLink.IMAGE_PATH_PROPERTY)
		.field(QuickLink.LINK_TARGET_PROPERTY)
		.field(QuickLink.CREATE_TIME_PROPERTY)
		.field(QuickLink.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于QuickLink对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getQuickLinkDetailScope() {
		return QuickLinkBaseDetailScope;
	}

	protected static SerializeScope ListAccessBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ListAccess.ID_PROPERTY)
		.field(ListAccess.NAME_PROPERTY)
		.field(ListAccess.INTERNAL_NAME_PROPERTY)
		.field(ListAccess.READ_PERMISSION_PROPERTY)
		.field(ListAccess.CREATE_PERMISSION_PROPERTY)
		.field(ListAccess.DELETE_PERMISSION_PROPERTY)
		.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
		.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
		.field(ListAccess.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于ListAccess对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getListAccessDetailScope() {
		return ListAccessBaseDetailScope;
	}

	protected static SerializeScope ObjectAccessBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(ObjectAccess.ID_PROPERTY)
		.field(ObjectAccess.NAME_PROPERTY)
		.field(ObjectAccess.OBJECT_TYPE_PROPERTY)
		.field(ObjectAccess.LIST1_PROPERTY)
		.field(ObjectAccess.LIST2_PROPERTY)
		.field(ObjectAccess.LIST3_PROPERTY)
		.field(ObjectAccess.LIST4_PROPERTY)
		.field(ObjectAccess.LIST5_PROPERTY)
		.field(ObjectAccess.LIST6_PROPERTY)
		.field(ObjectAccess.LIST7_PROPERTY)
		.field(ObjectAccess.LIST8_PROPERTY)
		.field(ObjectAccess.LIST9_PROPERTY)
		.field(ObjectAccess.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于ObjectAccess对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getObjectAccessDetailScope() {
		return ObjectAccessBaseDetailScope;
	}

	protected static SerializeScope LoginHistoryBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(LoginHistory.ID_PROPERTY)
		.field(LoginHistory.LOGIN_TIME_PROPERTY)
		.field(LoginHistory.FROM_IP_PROPERTY)
		.field(LoginHistory.DESCRIPTION_PROPERTY)
		.field(LoginHistory.SEC_USER_PROPERTY, getSecUserSummaryScope())
		;
	/** 用于LoginHistory对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLoginHistoryDetailScope() {
		return LoginHistoryBaseDetailScope;
	}

	protected static SerializeScope GenericFormBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(GenericForm.ID_PROPERTY)
		.field(GenericForm.TITLE_PROPERTY)
		.field(GenericForm.DESCRIPTION_PROPERTY)
		.field(GenericForm.FORM_MESSAGE_LIST, getFormMessageListItemScope())
		.field(GenericForm.FORM_FIELD_MESSAGE_LIST, getFormFieldMessageListItemScope())
		.field(GenericForm.FORM_FIELD_LIST, getFormFieldListItemScope())
		.field(GenericForm.FORM_ACTION_LIST, getFormActionListItemScope())
		;
	/** 用于GenericForm对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getGenericFormDetailScope() {
		return GenericFormBaseDetailScope;
	}

	protected static SerializeScope FormMessageBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(FormMessage.ID_PROPERTY)
		.field(FormMessage.TITLE_PROPERTY)
		.field(FormMessage.FORM_PROPERTY, getGenericFormSummaryScope())
		.field(FormMessage.LEVEL_PROPERTY)
		;
	/** 用于FormMessage对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormMessageDetailScope() {
		return FormMessageBaseDetailScope;
	}

	protected static SerializeScope FormFieldMessageBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(FormFieldMessage.ID_PROPERTY)
		.field(FormFieldMessage.TITLE_PROPERTY)
		.field(FormFieldMessage.PARAMETER_NAME_PROPERTY)
		.field(FormFieldMessage.FORM_PROPERTY, getGenericFormSummaryScope())
		.field(FormFieldMessage.LEVEL_PROPERTY)
		;
	/** 用于FormFieldMessage对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormFieldMessageDetailScope() {
		return FormFieldMessageBaseDetailScope;
	}

	protected static SerializeScope FormFieldBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(FormField.ID_PROPERTY)
		.field(FormField.LABEL_PROPERTY)
		.field(FormField.LOCALE_KEY_PROPERTY)
		.field(FormField.PARAMETER_NAME_PROPERTY)
		.field(FormField.TYPE_PROPERTY)
		.field(FormField.FORM_PROPERTY, getGenericFormSummaryScope())
		.field(FormField.PLACEHOLDER_PROPERTY)
		.field(FormField.DEFAULT_VALUE_PROPERTY)
		.field(FormField.DESCRIPTION_PROPERTY)
		.field(FormField.FIELD_GROUP_PROPERTY)
		.field(FormField.MINIMUM_VALUE_PROPERTY)
		.field(FormField.MAXIMUM_VALUE_PROPERTY)
		.field(FormField.REQUIRED_PROPERTY)
		.field(FormField.DISABLED_PROPERTY)
		.field(FormField.CUSTOM_RENDERING_PROPERTY)
		.field(FormField.CANDIDATE_VALUES_PROPERTY)
		.field(FormField.SUGGEST_VALUES_PROPERTY)
		;
	/** 用于FormField对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormFieldDetailScope() {
		return FormFieldBaseDetailScope;
	}

	protected static SerializeScope FormActionBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(FormAction.ID_PROPERTY)
		.field(FormAction.LABEL_PROPERTY)
		.field(FormAction.LOCALE_KEY_PROPERTY)
		.field(FormAction.ACTION_KEY_PROPERTY)
		.field(FormAction.LEVEL_PROPERTY)
		.field(FormAction.URL_PROPERTY)
		.field(FormAction.FORM_PROPERTY, getGenericFormSummaryScope())
		;
	/** 用于FormAction对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormActionDetailScope() {
		return FormActionBaseDetailScope;
	}

	protected static SerializeScope CandidateContainerBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(CandidateContainer.ID_PROPERTY)
		.field(CandidateContainer.NAME_PROPERTY)
		.field(CandidateContainer.CANDIDATE_ELEMENT_LIST, getCandidateElementListItemScope())
		;
	/** 用于CandidateContainer对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCandidateContainerDetailScope() {
		return CandidateContainerBaseDetailScope;
	}

	protected static SerializeScope CandidateElementBaseDetailScope = SerializeScope.INCLUDE()
		.field(HfgwBaseConstants.X_LINK_TO_URL)
		.field(CandidateElement.ID_PROPERTY)
		.field(CandidateElement.NAME_PROPERTY)
		.field(CandidateElement.TYPE_PROPERTY)
		.field(CandidateElement.IMAGE_PROPERTY)
		.field(CandidateElement.CONTAINER_PROPERTY, getCandidateContainerSummaryScope())
		;
	/** 用于CandidateElement对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCandidateElementDetailScope() {
		return CandidateElementBaseDetailScope;
	}

	

}






