import HyperledgerNetworkBase from './hyperledgernetwork/HyperledgerNetwork.base';
import HyperledgerNetworkBizApp from './hyperledgernetwork/HyperledgerNetwork.app';
import HyperledgerNetworkModel from './hyperledgernetwork/HyperledgerNetwork.model';
import HyperledgerNetworkDashboard from './hyperledgernetwork/HyperledgerNetwork.dashboard';
import HyperledgerNetworkModalTable from './hyperledgernetwork/HyperledgerNetwork.modaltable';
import HyperledgerNetworkSearch from './hyperledgernetwork/HyperledgerNetwork.search';
import HyperledgerNetworkSearchForm from './hyperledgernetwork/HyperledgerNetwork.searchform';
import HyperledgerNetworkCreateForm from './hyperledgernetwork/HyperledgerNetwork.createform';
import HyperledgerNetworkAssociateForm from './hyperledgernetwork/HyperledgerNetwork.associateform';
import HyperledgerNetworkTable from './hyperledgernetwork/HyperledgerNetwork.table';
import HyperledgerNetworkPermission from './hyperledgernetwork/HyperledgerNetwork.permission';
import HyperledgerNetworkProfile from './hyperledgernetwork/HyperledgerNetwork.profile';
import HyperledgerNetworkCreateFormBody from './hyperledgernetwork/HyperledgerNetwork.createformbody';
import HyperledgerNetworkService from './hyperledgernetwork/HyperledgerNetwork.service';
import HyperledgerNetworkUpdateForm from './hyperledgernetwork/HyperledgerNetwork.updateform';
import OrganizationBase from './organization/Organization.base';
import OrganizationBizApp from './organization/Organization.app';
import OrganizationModel from './organization/Organization.model';
import OrganizationDashboard from './organization/Organization.dashboard';
import OrganizationModalTable from './organization/Organization.modaltable';
import OrganizationSearch from './organization/Organization.search';
import OrganizationSearchForm from './organization/Organization.searchform';
import OrganizationCreateForm from './organization/Organization.createform';
import OrganizationAssociateForm from './organization/Organization.associateform';
import OrganizationTable from './organization/Organization.table';
import OrganizationPermission from './organization/Organization.permission';
import OrganizationProfile from './organization/Organization.profile';
import OrganizationCreateFormBody from './organization/Organization.createformbody';
import OrganizationService from './organization/Organization.service';
import OrganizationUpdateForm from './organization/Organization.updateform';
import NodeTypeBase from './nodetype/NodeType.base';
import NodeTypeBizApp from './nodetype/NodeType.app';
import NodeTypeModel from './nodetype/NodeType.model';
import NodeTypeDashboard from './nodetype/NodeType.dashboard';
import NodeTypeModalTable from './nodetype/NodeType.modaltable';
import NodeTypeSearch from './nodetype/NodeType.search';
import NodeTypeSearchForm from './nodetype/NodeType.searchform';
import NodeTypeCreateForm from './nodetype/NodeType.createform';
import NodeTypeAssociateForm from './nodetype/NodeType.associateform';
import NodeTypeTable from './nodetype/NodeType.table';
import NodeTypePermission from './nodetype/NodeType.permission';
import NodeTypeProfile from './nodetype/NodeType.profile';
import NodeTypeCreateFormBody from './nodetype/NodeType.createformbody';
import NodeTypeService from './nodetype/NodeType.service';
import NodeTypeUpdateForm from './nodetype/NodeType.updateform';
import NodeBase from './node/Node.base';
import NodeBizApp from './node/Node.app';
import NodeModel from './node/Node.model';
import NodeDashboard from './node/Node.dashboard';
import NodeModalTable from './node/Node.modaltable';
import NodeSearch from './node/Node.search';
import NodeSearchForm from './node/Node.searchform';
import NodeCreateForm from './node/Node.createform';
import NodeAssociateForm from './node/Node.associateform';
import NodeTable from './node/Node.table';
import NodePermission from './node/Node.permission';
import NodeProfile from './node/Node.profile';
import NodeCreateFormBody from './node/Node.createformbody';
import NodeService from './node/Node.service';
import NodeUpdateForm from './node/Node.updateform';
import GrpcOptionBase from './grpcoption/GrpcOption.base';
import GrpcOptionBizApp from './grpcoption/GrpcOption.app';
import GrpcOptionModel from './grpcoption/GrpcOption.model';
import GrpcOptionDashboard from './grpcoption/GrpcOption.dashboard';
import GrpcOptionModalTable from './grpcoption/GrpcOption.modaltable';
import GrpcOptionSearch from './grpcoption/GrpcOption.search';
import GrpcOptionSearchForm from './grpcoption/GrpcOption.searchform';
import GrpcOptionCreateForm from './grpcoption/GrpcOption.createform';
import GrpcOptionAssociateForm from './grpcoption/GrpcOption.associateform';
import GrpcOptionTable from './grpcoption/GrpcOption.table';
import GrpcOptionPermission from './grpcoption/GrpcOption.permission';
import GrpcOptionProfile from './grpcoption/GrpcOption.profile';
import GrpcOptionCreateFormBody from './grpcoption/GrpcOption.createformbody';
import GrpcOptionService from './grpcoption/GrpcOption.service';
import GrpcOptionUpdateForm from './grpcoption/GrpcOption.updateform';
import ChannelBase from './channel/Channel.base';
import ChannelBizApp from './channel/Channel.app';
import ChannelModel from './channel/Channel.model';
import ChannelDashboard from './channel/Channel.dashboard';
import ChannelModalTable from './channel/Channel.modaltable';
import ChannelSearch from './channel/Channel.search';
import ChannelSearchForm from './channel/Channel.searchform';
import ChannelCreateForm from './channel/Channel.createform';
import ChannelAssociateForm from './channel/Channel.associateform';
import ChannelTable from './channel/Channel.table';
import ChannelPermission from './channel/Channel.permission';
import ChannelProfile from './channel/Channel.profile';
import ChannelCreateFormBody from './channel/Channel.createformbody';
import ChannelService from './channel/Channel.service';
import ChannelUpdateForm from './channel/Channel.updateform';
import PeerRoleBase from './peerrole/PeerRole.base';
import PeerRoleBizApp from './peerrole/PeerRole.app';
import PeerRoleModel from './peerrole/PeerRole.model';
import PeerRoleDashboard from './peerrole/PeerRole.dashboard';
import PeerRoleModalTable from './peerrole/PeerRole.modaltable';
import PeerRoleSearch from './peerrole/PeerRole.search';
import PeerRoleSearchForm from './peerrole/PeerRole.searchform';
import PeerRoleCreateForm from './peerrole/PeerRole.createform';
import PeerRoleAssociateForm from './peerrole/PeerRole.associateform';
import PeerRoleTable from './peerrole/PeerRole.table';
import PeerRolePermission from './peerrole/PeerRole.permission';
import PeerRoleProfile from './peerrole/PeerRole.profile';
import PeerRoleCreateFormBody from './peerrole/PeerRole.createformbody';
import PeerRoleService from './peerrole/PeerRole.service';
import PeerRoleUpdateForm from './peerrole/PeerRole.updateform';
import ChannelPeerRoleBase from './channelpeerrole/ChannelPeerRole.base';
import ChannelPeerRoleBizApp from './channelpeerrole/ChannelPeerRole.app';
import ChannelPeerRoleModel from './channelpeerrole/ChannelPeerRole.model';
import ChannelPeerRoleDashboard from './channelpeerrole/ChannelPeerRole.dashboard';
import ChannelPeerRoleModalTable from './channelpeerrole/ChannelPeerRole.modaltable';
import ChannelPeerRoleSearch from './channelpeerrole/ChannelPeerRole.search';
import ChannelPeerRoleSearchForm from './channelpeerrole/ChannelPeerRole.searchform';
import ChannelPeerRoleCreateForm from './channelpeerrole/ChannelPeerRole.createform';
import ChannelPeerRoleAssociateForm from './channelpeerrole/ChannelPeerRole.associateform';
import ChannelPeerRoleTable from './channelpeerrole/ChannelPeerRole.table';
import ChannelPeerRolePermission from './channelpeerrole/ChannelPeerRole.permission';
import ChannelPeerRoleProfile from './channelpeerrole/ChannelPeerRole.profile';
import ChannelPeerRoleCreateFormBody from './channelpeerrole/ChannelPeerRole.createformbody';
import ChannelPeerRoleService from './channelpeerrole/ChannelPeerRole.service';
import ChannelPeerRoleUpdateForm from './channelpeerrole/ChannelPeerRole.updateform';
import ChainCodeBase from './chaincode/ChainCode.base';
import ChainCodeBizApp from './chaincode/ChainCode.app';
import ChainCodeModel from './chaincode/ChainCode.model';
import ChainCodeDashboard from './chaincode/ChainCode.dashboard';
import ChainCodeModalTable from './chaincode/ChainCode.modaltable';
import ChainCodeSearch from './chaincode/ChainCode.search';
import ChainCodeSearchForm from './chaincode/ChainCode.searchform';
import ChainCodeCreateForm from './chaincode/ChainCode.createform';
import ChainCodeAssociateForm from './chaincode/ChainCode.associateform';
import ChainCodeTable from './chaincode/ChainCode.table';
import ChainCodePermission from './chaincode/ChainCode.permission';
import ChainCodeProfile from './chaincode/ChainCode.profile';
import ChainCodeCreateFormBody from './chaincode/ChainCode.createformbody';
import ChainCodeService from './chaincode/ChainCode.service';
import ChainCodeUpdateForm from './chaincode/ChainCode.updateform';
import ApplicationBase from './application/Application.base';
import ApplicationBizApp from './application/Application.app';
import ApplicationModel from './application/Application.model';
import ApplicationDashboard from './application/Application.dashboard';
import ApplicationModalTable from './application/Application.modaltable';
import ApplicationSearch from './application/Application.search';
import ApplicationSearchForm from './application/Application.searchform';
import ApplicationCreateForm from './application/Application.createform';
import ApplicationAssociateForm from './application/Application.associateform';
import ApplicationTable from './application/Application.table';
import ApplicationPermission from './application/Application.permission';
import ApplicationProfile from './application/Application.profile';
import ApplicationCreateFormBody from './application/Application.createformbody';
import ApplicationService from './application/Application.service';
import ApplicationUpdateForm from './application/Application.updateform';
import ServiceRecordBase from './servicerecord/ServiceRecord.base';
import ServiceRecordBizApp from './servicerecord/ServiceRecord.app';
import ServiceRecordModel from './servicerecord/ServiceRecord.model';
import ServiceRecordDashboard from './servicerecord/ServiceRecord.dashboard';
import ServiceRecordModalTable from './servicerecord/ServiceRecord.modaltable';
import ServiceRecordSearch from './servicerecord/ServiceRecord.search';
import ServiceRecordSearchForm from './servicerecord/ServiceRecord.searchform';
import ServiceRecordCreateForm from './servicerecord/ServiceRecord.createform';
import ServiceRecordAssociateForm from './servicerecord/ServiceRecord.associateform';
import ServiceRecordTable from './servicerecord/ServiceRecord.table';
import ServiceRecordPermission from './servicerecord/ServiceRecord.permission';
import ServiceRecordProfile from './servicerecord/ServiceRecord.profile';
import ServiceRecordCreateFormBody from './servicerecord/ServiceRecord.createformbody';
import ServiceRecordService from './servicerecord/ServiceRecord.service';
import ServiceRecordUpdateForm from './servicerecord/ServiceRecord.updateform';
import TransactionStatusBase from './transactionstatus/TransactionStatus.base';
import TransactionStatusBizApp from './transactionstatus/TransactionStatus.app';
import TransactionStatusModel from './transactionstatus/TransactionStatus.model';
import TransactionStatusDashboard from './transactionstatus/TransactionStatus.dashboard';
import TransactionStatusModalTable from './transactionstatus/TransactionStatus.modaltable';
import TransactionStatusSearch from './transactionstatus/TransactionStatus.search';
import TransactionStatusSearchForm from './transactionstatus/TransactionStatus.searchform';
import TransactionStatusCreateForm from './transactionstatus/TransactionStatus.createform';
import TransactionStatusAssociateForm from './transactionstatus/TransactionStatus.associateform';
import TransactionStatusTable from './transactionstatus/TransactionStatus.table';
import TransactionStatusPermission from './transactionstatus/TransactionStatus.permission';
import TransactionStatusProfile from './transactionstatus/TransactionStatus.profile';
import TransactionStatusCreateFormBody from './transactionstatus/TransactionStatus.createformbody';
import TransactionStatusService from './transactionstatus/TransactionStatus.service';
import TransactionStatusUpdateForm from './transactionstatus/TransactionStatus.updateform';
import ChangeRequestTypeBase from './changerequesttype/ChangeRequestType.base';
import ChangeRequestTypeBizApp from './changerequesttype/ChangeRequestType.app';
import ChangeRequestTypeModel from './changerequesttype/ChangeRequestType.model';
import ChangeRequestTypeDashboard from './changerequesttype/ChangeRequestType.dashboard';
import ChangeRequestTypeModalTable from './changerequesttype/ChangeRequestType.modaltable';
import ChangeRequestTypeSearch from './changerequesttype/ChangeRequestType.search';
import ChangeRequestTypeSearchForm from './changerequesttype/ChangeRequestType.searchform';
import ChangeRequestTypeCreateForm from './changerequesttype/ChangeRequestType.createform';
import ChangeRequestTypeAssociateForm from './changerequesttype/ChangeRequestType.associateform';
import ChangeRequestTypeTable from './changerequesttype/ChangeRequestType.table';
import ChangeRequestTypePermission from './changerequesttype/ChangeRequestType.permission';
import ChangeRequestTypeProfile from './changerequesttype/ChangeRequestType.profile';
import ChangeRequestTypeCreateFormBody from './changerequesttype/ChangeRequestType.createformbody';
import ChangeRequestTypeService from './changerequesttype/ChangeRequestType.service';
import ChangeRequestTypeUpdateForm from './changerequesttype/ChangeRequestType.updateform';
import ChangeRequestBase from './changerequest/ChangeRequest.base';
import ChangeRequestBizApp from './changerequest/ChangeRequest.app';
import ChangeRequestModel from './changerequest/ChangeRequest.model';
import ChangeRequestDashboard from './changerequest/ChangeRequest.dashboard';
import ChangeRequestModalTable from './changerequest/ChangeRequest.modaltable';
import ChangeRequestSearch from './changerequest/ChangeRequest.search';
import ChangeRequestSearchForm from './changerequest/ChangeRequest.searchform';
import ChangeRequestCreateForm from './changerequest/ChangeRequest.createform';
import ChangeRequestAssociateForm from './changerequest/ChangeRequest.associateform';
import ChangeRequestTable from './changerequest/ChangeRequest.table';
import ChangeRequestPermission from './changerequest/ChangeRequest.permission';
import ChangeRequestProfile from './changerequest/ChangeRequest.profile';
import ChangeRequestCreateFormBody from './changerequest/ChangeRequest.createformbody';
import ChangeRequestService from './changerequest/ChangeRequest.service';
import ChangeRequestUpdateForm from './changerequest/ChangeRequest.updateform';
import UserDomainBase from './userdomain/UserDomain.base';
import UserDomainBizApp from './userdomain/UserDomain.app';
import UserDomainModel from './userdomain/UserDomain.model';
import UserDomainDashboard from './userdomain/UserDomain.dashboard';
import UserDomainModalTable from './userdomain/UserDomain.modaltable';
import UserDomainSearch from './userdomain/UserDomain.search';
import UserDomainSearchForm from './userdomain/UserDomain.searchform';
import UserDomainCreateForm from './userdomain/UserDomain.createform';
import UserDomainAssociateForm from './userdomain/UserDomain.associateform';
import UserDomainTable from './userdomain/UserDomain.table';
import UserDomainPermission from './userdomain/UserDomain.permission';
import UserDomainProfile from './userdomain/UserDomain.profile';
import UserDomainCreateFormBody from './userdomain/UserDomain.createformbody';
import UserDomainService from './userdomain/UserDomain.service';
import UserDomainUpdateForm from './userdomain/UserDomain.updateform';
import UserWhiteListBase from './userwhitelist/UserWhiteList.base';
import UserWhiteListBizApp from './userwhitelist/UserWhiteList.app';
import UserWhiteListModel from './userwhitelist/UserWhiteList.model';
import UserWhiteListDashboard from './userwhitelist/UserWhiteList.dashboard';
import UserWhiteListModalTable from './userwhitelist/UserWhiteList.modaltable';
import UserWhiteListSearch from './userwhitelist/UserWhiteList.search';
import UserWhiteListSearchForm from './userwhitelist/UserWhiteList.searchform';
import UserWhiteListCreateForm from './userwhitelist/UserWhiteList.createform';
import UserWhiteListAssociateForm from './userwhitelist/UserWhiteList.associateform';
import UserWhiteListTable from './userwhitelist/UserWhiteList.table';
import UserWhiteListPermission from './userwhitelist/UserWhiteList.permission';
import UserWhiteListProfile from './userwhitelist/UserWhiteList.profile';
import UserWhiteListCreateFormBody from './userwhitelist/UserWhiteList.createformbody';
import UserWhiteListService from './userwhitelist/UserWhiteList.service';
import UserWhiteListUpdateForm from './userwhitelist/UserWhiteList.updateform';
import SecUserBase from './secuser/SecUser.base';
import SecUserBizApp from './secuser/SecUser.app';
import SecUserModel from './secuser/SecUser.model';
import SecUserDashboard from './secuser/SecUser.dashboard';
import SecUserModalTable from './secuser/SecUser.modaltable';
import SecUserSearch from './secuser/SecUser.search';
import SecUserSearchForm from './secuser/SecUser.searchform';
import SecUserCreateForm from './secuser/SecUser.createform';
import SecUserAssociateForm from './secuser/SecUser.associateform';
import SecUserTable from './secuser/SecUser.table';
import SecUserPermission from './secuser/SecUser.permission';
import SecUserProfile from './secuser/SecUser.profile';
import SecUserCreateFormBody from './secuser/SecUser.createformbody';
import SecUserService from './secuser/SecUser.service';
import SecUserUpdateForm from './secuser/SecUser.updateform';
import SecUserBlockingBase from './secuserblocking/SecUserBlocking.base';
import SecUserBlockingBizApp from './secuserblocking/SecUserBlocking.app';
import SecUserBlockingModel from './secuserblocking/SecUserBlocking.model';
import SecUserBlockingDashboard from './secuserblocking/SecUserBlocking.dashboard';
import SecUserBlockingModalTable from './secuserblocking/SecUserBlocking.modaltable';
import SecUserBlockingSearch from './secuserblocking/SecUserBlocking.search';
import SecUserBlockingSearchForm from './secuserblocking/SecUserBlocking.searchform';
import SecUserBlockingCreateForm from './secuserblocking/SecUserBlocking.createform';
import SecUserBlockingAssociateForm from './secuserblocking/SecUserBlocking.associateform';
import SecUserBlockingTable from './secuserblocking/SecUserBlocking.table';
import SecUserBlockingPermission from './secuserblocking/SecUserBlocking.permission';
import SecUserBlockingProfile from './secuserblocking/SecUserBlocking.profile';
import SecUserBlockingCreateFormBody from './secuserblocking/SecUserBlocking.createformbody';
import SecUserBlockingService from './secuserblocking/SecUserBlocking.service';
import SecUserBlockingUpdateForm from './secuserblocking/SecUserBlocking.updateform';
import UserAppBase from './userapp/UserApp.base';
import UserAppBizApp from './userapp/UserApp.app';
import UserAppModel from './userapp/UserApp.model';
import UserAppDashboard from './userapp/UserApp.dashboard';
import UserAppModalTable from './userapp/UserApp.modaltable';
import UserAppSearch from './userapp/UserApp.search';
import UserAppSearchForm from './userapp/UserApp.searchform';
import UserAppCreateForm from './userapp/UserApp.createform';
import UserAppAssociateForm from './userapp/UserApp.associateform';
import UserAppTable from './userapp/UserApp.table';
import UserAppPermission from './userapp/UserApp.permission';
import UserAppProfile from './userapp/UserApp.profile';
import UserAppCreateFormBody from './userapp/UserApp.createformbody';
import UserAppService from './userapp/UserApp.service';
import UserAppUpdateForm from './userapp/UserApp.updateform';
import QuickLinkBase from './quicklink/QuickLink.base';
import QuickLinkBizApp from './quicklink/QuickLink.app';
import QuickLinkModel from './quicklink/QuickLink.model';
import QuickLinkDashboard from './quicklink/QuickLink.dashboard';
import QuickLinkModalTable from './quicklink/QuickLink.modaltable';
import QuickLinkSearch from './quicklink/QuickLink.search';
import QuickLinkSearchForm from './quicklink/QuickLink.searchform';
import QuickLinkCreateForm from './quicklink/QuickLink.createform';
import QuickLinkAssociateForm from './quicklink/QuickLink.associateform';
import QuickLinkTable from './quicklink/QuickLink.table';
import QuickLinkPermission from './quicklink/QuickLink.permission';
import QuickLinkProfile from './quicklink/QuickLink.profile';
import QuickLinkCreateFormBody from './quicklink/QuickLink.createformbody';
import QuickLinkService from './quicklink/QuickLink.service';
import QuickLinkUpdateForm from './quicklink/QuickLink.updateform';
import ListAccessBase from './listaccess/ListAccess.base';
import ListAccessBizApp from './listaccess/ListAccess.app';
import ListAccessModel from './listaccess/ListAccess.model';
import ListAccessDashboard from './listaccess/ListAccess.dashboard';
import ListAccessModalTable from './listaccess/ListAccess.modaltable';
import ListAccessSearch from './listaccess/ListAccess.search';
import ListAccessSearchForm from './listaccess/ListAccess.searchform';
import ListAccessCreateForm from './listaccess/ListAccess.createform';
import ListAccessAssociateForm from './listaccess/ListAccess.associateform';
import ListAccessTable from './listaccess/ListAccess.table';
import ListAccessPermission from './listaccess/ListAccess.permission';
import ListAccessProfile from './listaccess/ListAccess.profile';
import ListAccessCreateFormBody from './listaccess/ListAccess.createformbody';
import ListAccessService from './listaccess/ListAccess.service';
import ListAccessUpdateForm from './listaccess/ListAccess.updateform';
import ObjectAccessBase from './objectaccess/ObjectAccess.base';
import ObjectAccessBizApp from './objectaccess/ObjectAccess.app';
import ObjectAccessModel from './objectaccess/ObjectAccess.model';
import ObjectAccessDashboard from './objectaccess/ObjectAccess.dashboard';
import ObjectAccessModalTable from './objectaccess/ObjectAccess.modaltable';
import ObjectAccessSearch from './objectaccess/ObjectAccess.search';
import ObjectAccessSearchForm from './objectaccess/ObjectAccess.searchform';
import ObjectAccessCreateForm from './objectaccess/ObjectAccess.createform';
import ObjectAccessAssociateForm from './objectaccess/ObjectAccess.associateform';
import ObjectAccessTable from './objectaccess/ObjectAccess.table';
import ObjectAccessPermission from './objectaccess/ObjectAccess.permission';
import ObjectAccessProfile from './objectaccess/ObjectAccess.profile';
import ObjectAccessCreateFormBody from './objectaccess/ObjectAccess.createformbody';
import ObjectAccessService from './objectaccess/ObjectAccess.service';
import ObjectAccessUpdateForm from './objectaccess/ObjectAccess.updateform';
import LoginHistoryBase from './loginhistory/LoginHistory.base';
import LoginHistoryBizApp from './loginhistory/LoginHistory.app';
import LoginHistoryModel from './loginhistory/LoginHistory.model';
import LoginHistoryDashboard from './loginhistory/LoginHistory.dashboard';
import LoginHistoryModalTable from './loginhistory/LoginHistory.modaltable';
import LoginHistorySearch from './loginhistory/LoginHistory.search';
import LoginHistorySearchForm from './loginhistory/LoginHistory.searchform';
import LoginHistoryCreateForm from './loginhistory/LoginHistory.createform';
import LoginHistoryAssociateForm from './loginhistory/LoginHistory.associateform';
import LoginHistoryTable from './loginhistory/LoginHistory.table';
import LoginHistoryPermission from './loginhistory/LoginHistory.permission';
import LoginHistoryProfile from './loginhistory/LoginHistory.profile';
import LoginHistoryCreateFormBody from './loginhistory/LoginHistory.createformbody';
import LoginHistoryService from './loginhistory/LoginHistory.service';
import LoginHistoryUpdateForm from './loginhistory/LoginHistory.updateform';
import GenericFormBase from './genericform/GenericForm.base';
import GenericFormBizApp from './genericform/GenericForm.app';
import GenericFormModel from './genericform/GenericForm.model';
import GenericFormDashboard from './genericform/GenericForm.dashboard';
import GenericFormModalTable from './genericform/GenericForm.modaltable';
import GenericFormSearch from './genericform/GenericForm.search';
import GenericFormSearchForm from './genericform/GenericForm.searchform';
import GenericFormCreateForm from './genericform/GenericForm.createform';
import GenericFormAssociateForm from './genericform/GenericForm.associateform';
import GenericFormTable from './genericform/GenericForm.table';
import GenericFormPermission from './genericform/GenericForm.permission';
import GenericFormProfile from './genericform/GenericForm.profile';
import GenericFormCreateFormBody from './genericform/GenericForm.createformbody';
import GenericFormService from './genericform/GenericForm.service';
import GenericFormUpdateForm from './genericform/GenericForm.updateform';
import FormMessageBase from './formmessage/FormMessage.base';
import FormMessageBizApp from './formmessage/FormMessage.app';
import FormMessageModel from './formmessage/FormMessage.model';
import FormMessageDashboard from './formmessage/FormMessage.dashboard';
import FormMessageModalTable from './formmessage/FormMessage.modaltable';
import FormMessageSearch from './formmessage/FormMessage.search';
import FormMessageSearchForm from './formmessage/FormMessage.searchform';
import FormMessageCreateForm from './formmessage/FormMessage.createform';
import FormMessageAssociateForm from './formmessage/FormMessage.associateform';
import FormMessageTable from './formmessage/FormMessage.table';
import FormMessagePermission from './formmessage/FormMessage.permission';
import FormMessageProfile from './formmessage/FormMessage.profile';
import FormMessageCreateFormBody from './formmessage/FormMessage.createformbody';
import FormMessageService from './formmessage/FormMessage.service';
import FormMessageUpdateForm from './formmessage/FormMessage.updateform';
import FormFieldMessageBase from './formfieldmessage/FormFieldMessage.base';
import FormFieldMessageBizApp from './formfieldmessage/FormFieldMessage.app';
import FormFieldMessageModel from './formfieldmessage/FormFieldMessage.model';
import FormFieldMessageDashboard from './formfieldmessage/FormFieldMessage.dashboard';
import FormFieldMessageModalTable from './formfieldmessage/FormFieldMessage.modaltable';
import FormFieldMessageSearch from './formfieldmessage/FormFieldMessage.search';
import FormFieldMessageSearchForm from './formfieldmessage/FormFieldMessage.searchform';
import FormFieldMessageCreateForm from './formfieldmessage/FormFieldMessage.createform';
import FormFieldMessageAssociateForm from './formfieldmessage/FormFieldMessage.associateform';
import FormFieldMessageTable from './formfieldmessage/FormFieldMessage.table';
import FormFieldMessagePermission from './formfieldmessage/FormFieldMessage.permission';
import FormFieldMessageProfile from './formfieldmessage/FormFieldMessage.profile';
import FormFieldMessageCreateFormBody from './formfieldmessage/FormFieldMessage.createformbody';
import FormFieldMessageService from './formfieldmessage/FormFieldMessage.service';
import FormFieldMessageUpdateForm from './formfieldmessage/FormFieldMessage.updateform';
import FormFieldBase from './formfield/FormField.base';
import FormFieldBizApp from './formfield/FormField.app';
import FormFieldModel from './formfield/FormField.model';
import FormFieldDashboard from './formfield/FormField.dashboard';
import FormFieldModalTable from './formfield/FormField.modaltable';
import FormFieldSearch from './formfield/FormField.search';
import FormFieldSearchForm from './formfield/FormField.searchform';
import FormFieldCreateForm from './formfield/FormField.createform';
import FormFieldAssociateForm from './formfield/FormField.associateform';
import FormFieldTable from './formfield/FormField.table';
import FormFieldPermission from './formfield/FormField.permission';
import FormFieldProfile from './formfield/FormField.profile';
import FormFieldCreateFormBody from './formfield/FormField.createformbody';
import FormFieldService from './formfield/FormField.service';
import FormFieldUpdateForm from './formfield/FormField.updateform';
import FormActionBase from './formaction/FormAction.base';
import FormActionBizApp from './formaction/FormAction.app';
import FormActionModel from './formaction/FormAction.model';
import FormActionDashboard from './formaction/FormAction.dashboard';
import FormActionModalTable from './formaction/FormAction.modaltable';
import FormActionSearch from './formaction/FormAction.search';
import FormActionSearchForm from './formaction/FormAction.searchform';
import FormActionCreateForm from './formaction/FormAction.createform';
import FormActionAssociateForm from './formaction/FormAction.associateform';
import FormActionTable from './formaction/FormAction.table';
import FormActionPermission from './formaction/FormAction.permission';
import FormActionProfile from './formaction/FormAction.profile';
import FormActionCreateFormBody from './formaction/FormAction.createformbody';
import FormActionService from './formaction/FormAction.service';
import FormActionUpdateForm from './formaction/FormAction.updateform';
import CandidateContainerBase from './candidatecontainer/CandidateContainer.base';
import CandidateContainerBizApp from './candidatecontainer/CandidateContainer.app';
import CandidateContainerModel from './candidatecontainer/CandidateContainer.model';
import CandidateContainerDashboard from './candidatecontainer/CandidateContainer.dashboard';
import CandidateContainerModalTable from './candidatecontainer/CandidateContainer.modaltable';
import CandidateContainerSearch from './candidatecontainer/CandidateContainer.search';
import CandidateContainerSearchForm from './candidatecontainer/CandidateContainer.searchform';
import CandidateContainerCreateForm from './candidatecontainer/CandidateContainer.createform';
import CandidateContainerAssociateForm from './candidatecontainer/CandidateContainer.associateform';
import CandidateContainerTable from './candidatecontainer/CandidateContainer.table';
import CandidateContainerPermission from './candidatecontainer/CandidateContainer.permission';
import CandidateContainerProfile from './candidatecontainer/CandidateContainer.profile';
import CandidateContainerCreateFormBody from './candidatecontainer/CandidateContainer.createformbody';
import CandidateContainerService from './candidatecontainer/CandidateContainer.service';
import CandidateContainerUpdateForm from './candidatecontainer/CandidateContainer.updateform';
import CandidateElementBase from './candidateelement/CandidateElement.base';
import CandidateElementBizApp from './candidateelement/CandidateElement.app';
import CandidateElementModel from './candidateelement/CandidateElement.model';
import CandidateElementDashboard from './candidateelement/CandidateElement.dashboard';
import CandidateElementModalTable from './candidateelement/CandidateElement.modaltable';
import CandidateElementSearch from './candidateelement/CandidateElement.search';
import CandidateElementSearchForm from './candidateelement/CandidateElement.searchform';
import CandidateElementCreateForm from './candidateelement/CandidateElement.createform';
import CandidateElementAssociateForm from './candidateelement/CandidateElement.associateform';
import CandidateElementTable from './candidateelement/CandidateElement.table';
import CandidateElementPermission from './candidateelement/CandidateElement.permission';
import CandidateElementProfile from './candidateelement/CandidateElement.profile';
import CandidateElementCreateFormBody from './candidateelement/CandidateElement.createformbody';
import CandidateElementService from './candidateelement/CandidateElement.service';
import CandidateElementUpdateForm from './candidateelement/CandidateElement.updateform';
import ChangeRequestStepForm from './changerequest/ChangeRequest.stepform';

const BizModels = [
  HyperledgerNetworkModel,
  OrganizationModel,
  NodeTypeModel,
  NodeModel,
  GrpcOptionModel,
  ChannelModel,
  PeerRoleModel,
  ChannelPeerRoleModel,
  ChainCodeModel,
  ApplicationModel,
  ServiceRecordModel,
  TransactionStatusModel,
  ChangeRequestTypeModel,
  ChangeRequestModel,
  UserDomainModel,
  UserWhiteListModel,
  SecUserModel,
  SecUserBlockingModel,
  UserAppModel,
  QuickLinkModel,
  ListAccessModel,
  ObjectAccessModel,
  LoginHistoryModel,
  GenericFormModel,
  FormMessageModel,
  FormFieldMessageModel,
  FormFieldModel,
  FormActionModel,
  CandidateContainerModel,
  CandidateElementModel,
];

const bindBizModels = app => {
  BizModels.map(model => app.model(model));
};
const unbindBizModels = app => {
  BizModels.map(model => app.unmodel(model));
};

const menuLibrary = [];

menuLibrary.hyperledgerNetwork = HyperledgerNetworkBase.menuData;
menuLibrary.organization = OrganizationBase.menuData;
menuLibrary.nodeType = NodeTypeBase.menuData;
menuLibrary.node = NodeBase.menuData;
menuLibrary.grpcOption = GrpcOptionBase.menuData;
menuLibrary.channel = ChannelBase.menuData;
menuLibrary.peerRole = PeerRoleBase.menuData;
menuLibrary.channelPeerRole = ChannelPeerRoleBase.menuData;
menuLibrary.chainCode = ChainCodeBase.menuData;
menuLibrary.application = ApplicationBase.menuData;
menuLibrary.serviceRecord = ServiceRecordBase.menuData;
menuLibrary.transactionStatus = TransactionStatusBase.menuData;
menuLibrary.changeRequestType = ChangeRequestTypeBase.menuData;
menuLibrary.changeRequest = ChangeRequestBase.menuData;
menuLibrary.userDomain = UserDomainBase.menuData;
menuLibrary.userWhiteList = UserWhiteListBase.menuData;
menuLibrary.secUser = SecUserBase.menuData;
menuLibrary.secUserBlocking = SecUserBlockingBase.menuData;
menuLibrary.userApp = UserAppBase.menuData;
menuLibrary.quickLink = QuickLinkBase.menuData;
menuLibrary.listAccess = ListAccessBase.menuData;
menuLibrary.objectAccess = ObjectAccessBase.menuData;
menuLibrary.loginHistory = LoginHistoryBase.menuData;
menuLibrary.genericForm = GenericFormBase.menuData;
menuLibrary.formMessage = FormMessageBase.menuData;
menuLibrary.formFieldMessage = FormFieldMessageBase.menuData;
menuLibrary.formField = FormFieldBase.menuData;
menuLibrary.formAction = FormActionBase.menuData;
menuLibrary.candidateContainer = CandidateContainerBase.menuData;
menuLibrary.candidateElement = CandidateElementBase.menuData;

const menuDataOf = type => {
  const menu = menuLibrary[type];

  if (menu) {
    return menu;
  }
  console.error(`Not able to find corresponding menu for ${type}`);

  return null;
};

const ViewMapping = {
  'com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork': { name: 'hyperledgerNetwork' },
  'com.doublechaintech.hfgw.organization.Organization': { name: 'organization' },
  'com.doublechaintech.hfgw.nodetype.NodeType': { name: 'nodeType' },
  'com.doublechaintech.hfgw.node.Node': { name: 'node' },
  'com.doublechaintech.hfgw.grpcoption.GrpcOption': { name: 'grpcOption' },
  'com.doublechaintech.hfgw.channel.Channel': { name: 'channel' },
  'com.doublechaintech.hfgw.peerrole.PeerRole': { name: 'peerRole' },
  'com.doublechaintech.hfgw.channelpeerrole.ChannelPeerRole': { name: 'channelPeerRole' },
  'com.doublechaintech.hfgw.chaincode.ChainCode': { name: 'chainCode' },
  'com.doublechaintech.hfgw.application.Application': { name: 'application' },
  'com.doublechaintech.hfgw.servicerecord.ServiceRecord': { name: 'serviceRecord' },
  'com.doublechaintech.hfgw.transactionstatus.TransactionStatus': { name: 'transactionStatus' },
  'com.doublechaintech.hfgw.changerequesttype.ChangeRequestType': { name: 'changeRequestType' },
  'com.doublechaintech.hfgw.changerequest.ChangeRequest': { name: 'changeRequest' },
  'com.doublechaintech.hfgw.userdomain.UserDomain': { name: 'userDomain' },
  'com.doublechaintech.hfgw.userwhitelist.UserWhiteList': { name: 'userWhiteList' },
  'com.doublechaintech.hfgw.secuser.SecUser': { name: 'secUser' },
  'com.doublechaintech.hfgw.secuserblocking.SecUserBlocking': { name: 'secUserBlocking' },
  'com.doublechaintech.hfgw.userapp.UserApp': { name: 'userApp' },
  'com.doublechaintech.hfgw.quicklink.QuickLink': { name: 'quickLink' },
  'com.doublechaintech.hfgw.listaccess.ListAccess': { name: 'listAccess' },
  'com.doublechaintech.hfgw.objectaccess.ObjectAccess': { name: 'objectAccess' },
  'com.doublechaintech.hfgw.loginhistory.LoginHistory': { name: 'loginHistory' },
  'com.doublechaintech.hfgw.genericform.GenericForm': { name: 'genericForm' },
  'com.doublechaintech.hfgw.formmessage.FormMessage': { name: 'formMessage' },
  'com.doublechaintech.hfgw.formfieldmessage.FormFieldMessage': { name: 'formFieldMessage' },
  'com.doublechaintech.hfgw.formfield.FormField': { name: 'formField' },
  'com.doublechaintech.hfgw.formaction.FormAction': { name: 'formAction' },
  'com.doublechaintech.hfgw.candidatecontainer.CandidateContainer': { name: 'candidateContainer' },
  'com.doublechaintech.hfgw.candidateelement.CandidateElement': { name: 'candidateElement' },
};

// eslint-disable-next-line no-unused-vars
const presentApp = (clazz, data) => {
  // console.log(data)
};

const calcLocationPath = (clazz, id, subLocation) => {
  const location = ViewMapping[clazz];
  if (!location) {
    console.error('Not able to find an app for class: ', clazz);
    return 'home';
  }
  const { name } = location;
  if (!name) {
    return '/home';
  }
  if (name) {
    return `${name}/${id}/${subLocation}`;
  }
  return '/home';
};

const calcMenuData = clazz => {
  const location = ViewMapping[clazz];
  if (!location) {
    console.error('Not able to find an app for class: ', clazz);
    return {};
  }
  const { name } = location;
  //const { menuDataOf } = GlobalComponents
  return menuDataOf(name);
};

// console.log("element", )

const OOTBComponents = {
  HyperledgerNetworkBase,
  HyperledgerNetworkBizApp,
  HyperledgerNetworkModel,
  HyperledgerNetworkDashboard,
  HyperledgerNetworkModalTable,
  HyperledgerNetworkSearch,
  HyperledgerNetworkSearchForm,
  HyperledgerNetworkCreateForm,
  HyperledgerNetworkAssociateForm,
  HyperledgerNetworkTable,
  HyperledgerNetworkPermission,
  HyperledgerNetworkProfile,
  HyperledgerNetworkCreateFormBody,
  HyperledgerNetworkService,
  HyperledgerNetworkUpdateForm,
  OrganizationBase,
  OrganizationBizApp,
  OrganizationModel,
  OrganizationDashboard,
  OrganizationModalTable,
  OrganizationSearch,
  OrganizationSearchForm,
  OrganizationCreateForm,
  OrganizationAssociateForm,
  OrganizationTable,
  OrganizationPermission,
  OrganizationProfile,
  OrganizationCreateFormBody,
  OrganizationService,
  OrganizationUpdateForm,
  NodeTypeBase,
  NodeTypeBizApp,
  NodeTypeModel,
  NodeTypeDashboard,
  NodeTypeModalTable,
  NodeTypeSearch,
  NodeTypeSearchForm,
  NodeTypeCreateForm,
  NodeTypeAssociateForm,
  NodeTypeTable,
  NodeTypePermission,
  NodeTypeProfile,
  NodeTypeCreateFormBody,
  NodeTypeService,
  NodeTypeUpdateForm,
  NodeBase,
  NodeBizApp,
  NodeModel,
  NodeDashboard,
  NodeModalTable,
  NodeSearch,
  NodeSearchForm,
  NodeCreateForm,
  NodeAssociateForm,
  NodeTable,
  NodePermission,
  NodeProfile,
  NodeCreateFormBody,
  NodeService,
  NodeUpdateForm,
  GrpcOptionBase,
  GrpcOptionBizApp,
  GrpcOptionModel,
  GrpcOptionDashboard,
  GrpcOptionModalTable,
  GrpcOptionSearch,
  GrpcOptionSearchForm,
  GrpcOptionCreateForm,
  GrpcOptionAssociateForm,
  GrpcOptionTable,
  GrpcOptionPermission,
  GrpcOptionProfile,
  GrpcOptionCreateFormBody,
  GrpcOptionService,
  GrpcOptionUpdateForm,
  ChannelBase,
  ChannelBizApp,
  ChannelModel,
  ChannelDashboard,
  ChannelModalTable,
  ChannelSearch,
  ChannelSearchForm,
  ChannelCreateForm,
  ChannelAssociateForm,
  ChannelTable,
  ChannelPermission,
  ChannelProfile,
  ChannelCreateFormBody,
  ChannelService,
  ChannelUpdateForm,
  PeerRoleBase,
  PeerRoleBizApp,
  PeerRoleModel,
  PeerRoleDashboard,
  PeerRoleModalTable,
  PeerRoleSearch,
  PeerRoleSearchForm,
  PeerRoleCreateForm,
  PeerRoleAssociateForm,
  PeerRoleTable,
  PeerRolePermission,
  PeerRoleProfile,
  PeerRoleCreateFormBody,
  PeerRoleService,
  PeerRoleUpdateForm,
  ChannelPeerRoleBase,
  ChannelPeerRoleBizApp,
  ChannelPeerRoleModel,
  ChannelPeerRoleDashboard,
  ChannelPeerRoleModalTable,
  ChannelPeerRoleSearch,
  ChannelPeerRoleSearchForm,
  ChannelPeerRoleCreateForm,
  ChannelPeerRoleAssociateForm,
  ChannelPeerRoleTable,
  ChannelPeerRolePermission,
  ChannelPeerRoleProfile,
  ChannelPeerRoleCreateFormBody,
  ChannelPeerRoleService,
  ChannelPeerRoleUpdateForm,
  ChainCodeBase,
  ChainCodeBizApp,
  ChainCodeModel,
  ChainCodeDashboard,
  ChainCodeModalTable,
  ChainCodeSearch,
  ChainCodeSearchForm,
  ChainCodeCreateForm,
  ChainCodeAssociateForm,
  ChainCodeTable,
  ChainCodePermission,
  ChainCodeProfile,
  ChainCodeCreateFormBody,
  ChainCodeService,
  ChainCodeUpdateForm,
  ApplicationBase,
  ApplicationBizApp,
  ApplicationModel,
  ApplicationDashboard,
  ApplicationModalTable,
  ApplicationSearch,
  ApplicationSearchForm,
  ApplicationCreateForm,
  ApplicationAssociateForm,
  ApplicationTable,
  ApplicationPermission,
  ApplicationProfile,
  ApplicationCreateFormBody,
  ApplicationService,
  ApplicationUpdateForm,
  ServiceRecordBase,
  ServiceRecordBizApp,
  ServiceRecordModel,
  ServiceRecordDashboard,
  ServiceRecordModalTable,
  ServiceRecordSearch,
  ServiceRecordSearchForm,
  ServiceRecordCreateForm,
  ServiceRecordAssociateForm,
  ServiceRecordTable,
  ServiceRecordPermission,
  ServiceRecordProfile,
  ServiceRecordCreateFormBody,
  ServiceRecordService,
  ServiceRecordUpdateForm,
  TransactionStatusBase,
  TransactionStatusBizApp,
  TransactionStatusModel,
  TransactionStatusDashboard,
  TransactionStatusModalTable,
  TransactionStatusSearch,
  TransactionStatusSearchForm,
  TransactionStatusCreateForm,
  TransactionStatusAssociateForm,
  TransactionStatusTable,
  TransactionStatusPermission,
  TransactionStatusProfile,
  TransactionStatusCreateFormBody,
  TransactionStatusService,
  TransactionStatusUpdateForm,
  ChangeRequestTypeBase,
  ChangeRequestTypeBizApp,
  ChangeRequestTypeModel,
  ChangeRequestTypeDashboard,
  ChangeRequestTypeModalTable,
  ChangeRequestTypeSearch,
  ChangeRequestTypeSearchForm,
  ChangeRequestTypeCreateForm,
  ChangeRequestTypeAssociateForm,
  ChangeRequestTypeTable,
  ChangeRequestTypePermission,
  ChangeRequestTypeProfile,
  ChangeRequestTypeCreateFormBody,
  ChangeRequestTypeService,
  ChangeRequestTypeUpdateForm,
  ChangeRequestBase,
  ChangeRequestBizApp,
  ChangeRequestModel,
  ChangeRequestDashboard,
  ChangeRequestModalTable,
  ChangeRequestSearch,
  ChangeRequestSearchForm,
  ChangeRequestCreateForm,
  ChangeRequestAssociateForm,
  ChangeRequestTable,
  ChangeRequestPermission,
  ChangeRequestProfile,
  ChangeRequestCreateFormBody,
  ChangeRequestService,
  ChangeRequestUpdateForm,
  UserDomainBase,
  UserDomainBizApp,
  UserDomainModel,
  UserDomainDashboard,
  UserDomainModalTable,
  UserDomainSearch,
  UserDomainSearchForm,
  UserDomainCreateForm,
  UserDomainAssociateForm,
  UserDomainTable,
  UserDomainPermission,
  UserDomainProfile,
  UserDomainCreateFormBody,
  UserDomainService,
  UserDomainUpdateForm,
  UserWhiteListBase,
  UserWhiteListBizApp,
  UserWhiteListModel,
  UserWhiteListDashboard,
  UserWhiteListModalTable,
  UserWhiteListSearch,
  UserWhiteListSearchForm,
  UserWhiteListCreateForm,
  UserWhiteListAssociateForm,
  UserWhiteListTable,
  UserWhiteListPermission,
  UserWhiteListProfile,
  UserWhiteListCreateFormBody,
  UserWhiteListService,
  UserWhiteListUpdateForm,
  SecUserBase,
  SecUserBizApp,
  SecUserModel,
  SecUserDashboard,
  SecUserModalTable,
  SecUserSearch,
  SecUserSearchForm,
  SecUserCreateForm,
  SecUserAssociateForm,
  SecUserTable,
  SecUserPermission,
  SecUserProfile,
  SecUserCreateFormBody,
  SecUserService,
  SecUserUpdateForm,
  SecUserBlockingBase,
  SecUserBlockingBizApp,
  SecUserBlockingModel,
  SecUserBlockingDashboard,
  SecUserBlockingModalTable,
  SecUserBlockingSearch,
  SecUserBlockingSearchForm,
  SecUserBlockingCreateForm,
  SecUserBlockingAssociateForm,
  SecUserBlockingTable,
  SecUserBlockingPermission,
  SecUserBlockingProfile,
  SecUserBlockingCreateFormBody,
  SecUserBlockingService,
  SecUserBlockingUpdateForm,
  UserAppBase,
  UserAppBizApp,
  UserAppModel,
  UserAppDashboard,
  UserAppModalTable,
  UserAppSearch,
  UserAppSearchForm,
  UserAppCreateForm,
  UserAppAssociateForm,
  UserAppTable,
  UserAppPermission,
  UserAppProfile,
  UserAppCreateFormBody,
  UserAppService,
  UserAppUpdateForm,
  QuickLinkBase,
  QuickLinkBizApp,
  QuickLinkModel,
  QuickLinkDashboard,
  QuickLinkModalTable,
  QuickLinkSearch,
  QuickLinkSearchForm,
  QuickLinkCreateForm,
  QuickLinkAssociateForm,
  QuickLinkTable,
  QuickLinkPermission,
  QuickLinkProfile,
  QuickLinkCreateFormBody,
  QuickLinkService,
  QuickLinkUpdateForm,
  ListAccessBase,
  ListAccessBizApp,
  ListAccessModel,
  ListAccessDashboard,
  ListAccessModalTable,
  ListAccessSearch,
  ListAccessSearchForm,
  ListAccessCreateForm,
  ListAccessAssociateForm,
  ListAccessTable,
  ListAccessPermission,
  ListAccessProfile,
  ListAccessCreateFormBody,
  ListAccessService,
  ListAccessUpdateForm,
  ObjectAccessBase,
  ObjectAccessBizApp,
  ObjectAccessModel,
  ObjectAccessDashboard,
  ObjectAccessModalTable,
  ObjectAccessSearch,
  ObjectAccessSearchForm,
  ObjectAccessCreateForm,
  ObjectAccessAssociateForm,
  ObjectAccessTable,
  ObjectAccessPermission,
  ObjectAccessProfile,
  ObjectAccessCreateFormBody,
  ObjectAccessService,
  ObjectAccessUpdateForm,
  LoginHistoryBase,
  LoginHistoryBizApp,
  LoginHistoryModel,
  LoginHistoryDashboard,
  LoginHistoryModalTable,
  LoginHistorySearch,
  LoginHistorySearchForm,
  LoginHistoryCreateForm,
  LoginHistoryAssociateForm,
  LoginHistoryTable,
  LoginHistoryPermission,
  LoginHistoryProfile,
  LoginHistoryCreateFormBody,
  LoginHistoryService,
  LoginHistoryUpdateForm,
  GenericFormBase,
  GenericFormBizApp,
  GenericFormModel,
  GenericFormDashboard,
  GenericFormModalTable,
  GenericFormSearch,
  GenericFormSearchForm,
  GenericFormCreateForm,
  GenericFormAssociateForm,
  GenericFormTable,
  GenericFormPermission,
  GenericFormProfile,
  GenericFormCreateFormBody,
  GenericFormService,
  GenericFormUpdateForm,
  FormMessageBase,
  FormMessageBizApp,
  FormMessageModel,
  FormMessageDashboard,
  FormMessageModalTable,
  FormMessageSearch,
  FormMessageSearchForm,
  FormMessageCreateForm,
  FormMessageAssociateForm,
  FormMessageTable,
  FormMessagePermission,
  FormMessageProfile,
  FormMessageCreateFormBody,
  FormMessageService,
  FormMessageUpdateForm,
  FormFieldMessageBase,
  FormFieldMessageBizApp,
  FormFieldMessageModel,
  FormFieldMessageDashboard,
  FormFieldMessageModalTable,
  FormFieldMessageSearch,
  FormFieldMessageSearchForm,
  FormFieldMessageCreateForm,
  FormFieldMessageAssociateForm,
  FormFieldMessageTable,
  FormFieldMessagePermission,
  FormFieldMessageProfile,
  FormFieldMessageCreateFormBody,
  FormFieldMessageService,
  FormFieldMessageUpdateForm,
  FormFieldBase,
  FormFieldBizApp,
  FormFieldModel,
  FormFieldDashboard,
  FormFieldModalTable,
  FormFieldSearch,
  FormFieldSearchForm,
  FormFieldCreateForm,
  FormFieldAssociateForm,
  FormFieldTable,
  FormFieldPermission,
  FormFieldProfile,
  FormFieldCreateFormBody,
  FormFieldService,
  FormFieldUpdateForm,
  FormActionBase,
  FormActionBizApp,
  FormActionModel,
  FormActionDashboard,
  FormActionModalTable,
  FormActionSearch,
  FormActionSearchForm,
  FormActionCreateForm,
  FormActionAssociateForm,
  FormActionTable,
  FormActionPermission,
  FormActionProfile,
  FormActionCreateFormBody,
  FormActionService,
  FormActionUpdateForm,
  CandidateContainerBase,
  CandidateContainerBizApp,
  CandidateContainerModel,
  CandidateContainerDashboard,
  CandidateContainerModalTable,
  CandidateContainerSearch,
  CandidateContainerSearchForm,
  CandidateContainerCreateForm,
  CandidateContainerAssociateForm,
  CandidateContainerTable,
  CandidateContainerPermission,
  CandidateContainerProfile,
  CandidateContainerCreateFormBody,
  CandidateContainerService,
  CandidateContainerUpdateForm,
  CandidateElementBase,
  CandidateElementBizApp,
  CandidateElementModel,
  CandidateElementDashboard,
  CandidateElementModalTable,
  CandidateElementSearch,
  CandidateElementSearchForm,
  CandidateElementCreateForm,
  CandidateElementAssociateForm,
  CandidateElementTable,
  CandidateElementPermission,
  CandidateElementProfile,
  CandidateElementCreateFormBody,
  CandidateElementService,
  CandidateElementUpdateForm,
  ChangeRequestStepForm,

  menuDataOf,
  bindBizModels,
  unbindBizModels,
  calcLocationPath,
  calcMenuData,
};

export default OOTBComponents;
