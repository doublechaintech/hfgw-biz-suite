
package com.doublechaintech.hfgw;
import java.text.MessageFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
public class HfgwChecker extends BaseChecker{

	
	public HfgwChecker() {
		this.messageList = new ArrayList<Message>();
	}
	

	public static final String  ID_OF_HYPERLEDGER_NETWORK ="hyperledger_network.id";
	public HfgwChecker checkIdOfHyperledgerNetwork(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_HYPERLEDGER_NETWORK ); 		
		
		return this;
	}	

	public static final String  NAME_OF_HYPERLEDGER_NETWORK ="hyperledger_network.name";
	public HfgwChecker checkNameOfHyperledgerNetwork(String name)
	{
		
	 	checkStringLengthRange(name,1, 200,NAME_OF_HYPERLEDGER_NETWORK ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_HYPERLEDGER_NETWORK ="hyperledger_network.description";
	public HfgwChecker checkDescriptionOfHyperledgerNetwork(String description)
	{
		
	 	checkLongtext(description,0, 1048576,DESCRIPTION_OF_HYPERLEDGER_NETWORK ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_HYPERLEDGER_NETWORK ="hyperledger_network.version";
	public HfgwChecker checkVersionOfHyperledgerNetwork(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_HYPERLEDGER_NETWORK ); 		
		
		return this;
	}	

	public static final String  ID_OF_ORGANIZATION ="organization.id";
	public HfgwChecker checkIdOfOrganization(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_ORGANIZATION ); 		
		
		return this;
	}	

	public static final String  NAME_OF_ORGANIZATION ="organization.name";
	public HfgwChecker checkNameOfOrganization(String name)
	{
		
	 	checkStringLengthRange(name,1, 50,NAME_OF_ORGANIZATION ); 		
		
		return this;
	}	

	public static final String  MSPID_OF_ORGANIZATION ="organization.mspid";
	public HfgwChecker checkMspidOfOrganization(String mspid)
	{
		
	 	checkStringLengthRange(mspid,1, 20,MSPID_OF_ORGANIZATION ); 		
		
		return this;
	}	

	public static final String  NETWORK_OF_ORGANIZATION ="organization.network";
	public HfgwChecker checkNetworkIdOfOrganization(String networkId)
	{
		
	 	checkIdOfOrganization(networkId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_ORGANIZATION ="organization.version";
	public HfgwChecker checkVersionOfOrganization(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ORGANIZATION ); 		
		
		return this;
	}	

	public static final String  ID_OF_NODE_TYPE ="node_type.id";
	public HfgwChecker checkIdOfNodeType(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_NODE_TYPE ); 		
		
		return this;
	}	

	public static final String  NAME_OF_NODE_TYPE ="node_type.name";
	public HfgwChecker checkNameOfNodeType(String name)
	{
		
	 	checkStringLengthRange(name,2, 28,NAME_OF_NODE_TYPE ); 		
		
		return this;
	}	

	public static final String  CODE_OF_NODE_TYPE ="node_type.code";
	public HfgwChecker checkCodeOfNodeType(String code)
	{
		
	 	checkStringLengthRange(code,2, 28,CODE_OF_NODE_TYPE ); 		
		
		return this;
	}	

	public static final String  NETWORK_OF_NODE_TYPE ="node_type.network";
	public HfgwChecker checkNetworkIdOfNodeType(String networkId)
	{
		
	 	checkIdOfNodeType(networkId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_NODE_TYPE ="node_type.version";
	public HfgwChecker checkVersionOfNodeType(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_NODE_TYPE ); 		
		
		return this;
	}	

	public static final String  ID_OF_NODE ="node.id";
	public HfgwChecker checkIdOfNode(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_NODE ); 		
		
		return this;
	}	

	public static final String  NAME_OF_NODE ="node.name";
	public HfgwChecker checkNameOfNode(String name)
	{
		
	 	checkStringLengthRange(name,1, 50,NAME_OF_NODE ); 		
		
		return this;
	}	

	public static final String  URL_OF_NODE ="node.url";
	public HfgwChecker checkUrlOfNode(String url)
	{
		
	 	checkStringLengthRange(url,1, 200,URL_OF_NODE ); 		
		
		return this;
	}	

	public static final String  ORGANIZATION_OF_NODE ="node.organization";
	public HfgwChecker checkOrganizationIdOfNode(String organizationId)
	{
		
	 	checkIdOfNode(organizationId ); 		
		
		return this;
	}	

	public static final String  CHANNEL_OF_NODE ="node.channel";
	public HfgwChecker checkChannelIdOfNode(String channelId)
	{
		
	 	checkIdOfNode(channelId ); 		
		
		return this;
	}	

	public static final String  NETWORK_OF_NODE ="node.network";
	public HfgwChecker checkNetworkIdOfNode(String networkId)
	{
		
	 	checkIdOfNode(networkId ); 		
		
		return this;
	}	

	public static final String  TLS_CACERT_OF_NODE ="node.tls_cacert";
	public HfgwChecker checkTlsCacertOfNode(String tlsCacert)
	{
		
	 	checkLongtext(tlsCacert,0, 1048576,TLS_CACERT_OF_NODE ); 		
		
		return this;
	}	

	public static final String  TYPE_OF_NODE ="node.type";
	public HfgwChecker checkTypeIdOfNode(String typeId)
	{
		
	 	checkIdOfNode(typeId ); 		
		
		return this;
	}	

	public static final String  ADDRESS_OF_NODE ="node.address";
	public HfgwChecker checkAddressOfNode(String address)
	{
		
	 	checkStringLengthRange(address,4, 52,ADDRESS_OF_NODE ); 		
		
		return this;
	}	

	public static final String  CONTACT_PERSON_OF_NODE ="node.contact_person";
	public HfgwChecker checkContactPersonOfNode(String contactPerson)
	{
		
	 	checkStringLengthRange(contactPerson,1, 8,CONTACT_PERSON_OF_NODE ); 		
		
		return this;
	}	

	public static final String  CONTACT_TELEPHONE_OF_NODE ="node.contact_telephone";
	public HfgwChecker checkContactTelephoneOfNode(String contactTelephone)
	{
		
	 	checkStringLengthRange(contactTelephone,3, 44,CONTACT_TELEPHONE_OF_NODE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_NODE ="node.version";
	public HfgwChecker checkVersionOfNode(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_NODE ); 		
		
		return this;
	}	

	public static final String  ID_OF_GRPC_OPTION ="grpc_option.id";
	public HfgwChecker checkIdOfGrpcOption(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_GRPC_OPTION ); 		
		
		return this;
	}	

	public static final String  PARAMETER_NAME_OF_GRPC_OPTION ="grpc_option.parameter_name";
	public HfgwChecker checkParameterNameOfGrpcOption(String parameterName)
	{
		
	 	checkStringLengthRange(parameterName,1, 200,PARAMETER_NAME_OF_GRPC_OPTION ); 		
		
		return this;
	}	

	public static final String  PARAMETER_VALUE_OF_GRPC_OPTION ="grpc_option.parameter_value";
	public HfgwChecker checkParameterValueOfGrpcOption(String parameterValue)
	{
		
	 	checkStringLengthRange(parameterValue,1, 200,PARAMETER_VALUE_OF_GRPC_OPTION ); 		
		
		return this;
	}	

	public static final String  NODE_OF_GRPC_OPTION ="grpc_option.node";
	public HfgwChecker checkNodeIdOfGrpcOption(String nodeId)
	{
		
	 	checkIdOfGrpcOption(nodeId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_GRPC_OPTION ="grpc_option.version";
	public HfgwChecker checkVersionOfGrpcOption(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GRPC_OPTION ); 		
		
		return this;
	}	

	public static final String  ID_OF_CHANNEL ="channel.id";
	public HfgwChecker checkIdOfChannel(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_CHANNEL ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CHANNEL ="channel.name";
	public HfgwChecker checkNameOfChannel(String name)
	{
		
	 	checkStringLengthRange(name,1, 20,NAME_OF_CHANNEL ); 		
		
		return this;
	}	

	public static final String  NETWORK_OF_CHANNEL ="channel.network";
	public HfgwChecker checkNetworkIdOfChannel(String networkId)
	{
		
	 	checkIdOfChannel(networkId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CHANNEL ="channel.version";
	public HfgwChecker checkVersionOfChannel(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CHANNEL ); 		
		
		return this;
	}	

	public static final String  ID_OF_PEER_ROLE ="peer_role.id";
	public HfgwChecker checkIdOfPeerRole(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_PEER_ROLE ); 		
		
		return this;
	}	

	public static final String  NAME_OF_PEER_ROLE ="peer_role.name";
	public HfgwChecker checkNameOfPeerRole(String name)
	{
		
	 	checkStringLengthRange(name,4, 56,NAME_OF_PEER_ROLE ); 		
		
		return this;
	}	

	public static final String  CODE_OF_PEER_ROLE ="peer_role.code";
	public HfgwChecker checkCodeOfPeerRole(String code)
	{
		
	 	checkStringLengthRange(code,4, 56,CODE_OF_PEER_ROLE ); 		
		
		return this;
	}	

	public static final String  NETWORK_OF_PEER_ROLE ="peer_role.network";
	public HfgwChecker checkNetworkIdOfPeerRole(String networkId)
	{
		
	 	checkIdOfPeerRole(networkId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_PEER_ROLE ="peer_role.version";
	public HfgwChecker checkVersionOfPeerRole(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PEER_ROLE ); 		
		
		return this;
	}	

	public static final String  ID_OF_CHANNEL_PEER_ROLE ="channel_peer_role.id";
	public HfgwChecker checkIdOfChannelPeerRole(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_CHANNEL_PEER_ROLE ); 		
		
		return this;
	}	

	public static final String  CHANNEL_OF_CHANNEL_PEER_ROLE ="channel_peer_role.channel";
	public HfgwChecker checkChannelIdOfChannelPeerRole(String channelId)
	{
		
	 	checkIdOfChannelPeerRole(channelId ); 		
		
		return this;
	}	

	public static final String  NODE_OF_CHANNEL_PEER_ROLE ="channel_peer_role.node";
	public HfgwChecker checkNodeIdOfChannelPeerRole(String nodeId)
	{
		
	 	checkIdOfChannelPeerRole(nodeId ); 		
		
		return this;
	}	

	public static final String  PEER_ROLE_OF_CHANNEL_PEER_ROLE ="channel_peer_role.peer_role";
	public HfgwChecker checkPeerRoleIdOfChannelPeerRole(String peerRoleId)
	{
		
	 	checkIdOfChannelPeerRole(peerRoleId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CHANNEL_PEER_ROLE ="channel_peer_role.version";
	public HfgwChecker checkVersionOfChannelPeerRole(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CHANNEL_PEER_ROLE ); 		
		
		return this;
	}	

	public static final String  ID_OF_CHAIN_CODE ="chain_code.id";
	public HfgwChecker checkIdOfChainCode(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_CHAIN_CODE ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CHAIN_CODE ="chain_code.name";
	public HfgwChecker checkNameOfChainCode(String name)
	{
		
	 	checkStringLengthRange(name,2, 24,NAME_OF_CHAIN_CODE ); 		
		
		return this;
	}	

	public static final String  CODE_NAME_OF_CHAIN_CODE ="chain_code.code_name";
	public HfgwChecker checkCodeNameOfChainCode(String codeName)
	{
		
	 	checkStringLengthRange(codeName,1, 50,CODE_NAME_OF_CHAIN_CODE ); 		
		
		return this;
	}	

	public static final String  CODE_VERSION_OF_CHAIN_CODE ="chain_code.code_version";
	public HfgwChecker checkCodeVersionOfChainCode(String codeVersion)
	{
		
	 	checkStringLengthRange(codeVersion,1, 50,CODE_VERSION_OF_CHAIN_CODE ); 		
		
		return this;
	}	

	public static final String  CHANNEL_OF_CHAIN_CODE ="chain_code.channel";
	public HfgwChecker checkChannelIdOfChainCode(String channelId)
	{
		
	 	checkIdOfChainCode(channelId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CHAIN_CODE ="chain_code.version";
	public HfgwChecker checkVersionOfChainCode(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CHAIN_CODE ); 		
		
		return this;
	}	

	public static final String  ID_OF_APPLICATION ="application.id";
	public HfgwChecker checkIdOfApplication(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_APPLICATION ); 		
		
		return this;
	}	

	public static final String  NAME_OF_APPLICATION ="application.name";
	public HfgwChecker checkNameOfApplication(String name)
	{
		
	 	checkStringLengthRange(name,1, 200,NAME_OF_APPLICATION ); 		
		
		return this;
	}	

	public static final String  MSPID_OF_APPLICATION ="application.mspid";
	public HfgwChecker checkMspidOfApplication(String mspid)
	{
		
	 	checkStringLengthRange(mspid,1, 200,MSPID_OF_APPLICATION ); 		
		
		return this;
	}	

	public static final String  PUBLIC_KEY_OF_APPLICATION ="application.public_key";
	public HfgwChecker checkPublicKeyOfApplication(String publicKey)
	{
		
	 	checkLongtext(publicKey,0, 1048576,PUBLIC_KEY_OF_APPLICATION ); 		
		
		return this;
	}	

	public static final String  PRIVATE_KEY_OF_APPLICATION ="application.private_key";
	public HfgwChecker checkPrivateKeyOfApplication(String privateKey)
	{
		
	 	checkLongtext(privateKey,0, 1048576,PRIVATE_KEY_OF_APPLICATION ); 		
		
		return this;
	}	

	public static final String  CHANNEL_OF_APPLICATION ="application.channel";
	public HfgwChecker checkChannelIdOfApplication(String channelId)
	{
		
	 	checkIdOfApplication(channelId ); 		
		
		return this;
	}	

	public static final String  NETWORK_OF_APPLICATION ="application.network";
	public HfgwChecker checkNetworkIdOfApplication(String networkId)
	{
		
	 	checkIdOfApplication(networkId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_APPLICATION ="application.version";
	public HfgwChecker checkVersionOfApplication(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_APPLICATION ); 		
		
		return this;
	}	

	public static final String  ID_OF_SERVICE_RECORD ="service_record.id";
	public HfgwChecker checkIdOfServiceRecord(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_SERVICE_RECORD ); 		
		
		return this;
	}	

	public static final String  TRANSACTION_ID_OF_SERVICE_RECORD ="service_record.transaction_id";
	public HfgwChecker checkTransactionIdOfServiceRecord(String transactionId)
	{
		
	 	checkStringLengthRange(transactionId,0, 200,TRANSACTION_ID_OF_SERVICE_RECORD ); 		
		
		return this;
	}	

	public static final String  NAME_OF_SERVICE_RECORD ="service_record.name";
	public HfgwChecker checkNameOfServiceRecord(String name)
	{
		
	 	checkStringLengthRange(name,1, 200,NAME_OF_SERVICE_RECORD ); 		
		
		return this;
	}	

	public static final String  PAYLOAD_OF_SERVICE_RECORD ="service_record.payload";
	public HfgwChecker checkPayloadOfServiceRecord(String payload)
	{
		
	 	checkLongtext(payload,0, 1048576,PAYLOAD_OF_SERVICE_RECORD ); 		
		
		return this;
	}	

	public static final String  CHANNEL_OF_SERVICE_RECORD ="service_record.channel";
	public HfgwChecker checkChannelIdOfServiceRecord(String channelId)
	{
		
	 	checkIdOfServiceRecord(channelId ); 		
		
		return this;
	}	

	public static final String  CHAIN_CODE_OF_SERVICE_RECORD ="service_record.chain_code";
	public HfgwChecker checkChainCodeIdOfServiceRecord(String chainCodeId)
	{
		
	 	checkIdOfServiceRecord(chainCodeId ); 		
		
		return this;
	}	

	public static final String  CHAIN_CODE_FUNCTION_OF_SERVICE_RECORD ="service_record.chain_code_function";
	public HfgwChecker checkChainCodeFunctionOfServiceRecord(String chainCodeFunction)
	{
		
	 	checkStringLengthRange(chainCodeFunction,1, 20,CHAIN_CODE_FUNCTION_OF_SERVICE_RECORD ); 		
		
		return this;
	}	

	public static final String  BLOCK_ID_OF_SERVICE_RECORD ="service_record.block_id";
	public HfgwChecker checkBlockIdOfServiceRecord(String blockId)
	{
		
	 	checkStringLengthRange(blockId,0, 200,BLOCK_ID_OF_SERVICE_RECORD ); 		
		
		return this;
	}	

	public static final String  APP_CLIENT_OF_SERVICE_RECORD ="service_record.app_client";
	public HfgwChecker checkAppClientIdOfServiceRecord(String appClientId)
	{
		
	 	checkIdOfServiceRecord(appClientId ); 		
		
		return this;
	}	

	public static final String  NETWORK_OF_SERVICE_RECORD ="service_record.network";
	public HfgwChecker checkNetworkIdOfServiceRecord(String networkId)
	{
		
	 	checkIdOfServiceRecord(networkId ); 		
		
		return this;
	}	

	public static final String  RESPONSE_OF_SERVICE_RECORD ="service_record.response";
	public HfgwChecker checkResponseOfServiceRecord(String response)
	{
		
	 	checkLongtext(response,0, 1048576,RESPONSE_OF_SERVICE_RECORD ); 		
		
		return this;
	}	

	public static final String  STATUS_OF_SERVICE_RECORD ="service_record.status";
	public HfgwChecker checkStatusIdOfServiceRecord(String statusId)
	{
		
	 	checkIdOfServiceRecord(statusId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SERVICE_RECORD ="service_record.version";
	public HfgwChecker checkVersionOfServiceRecord(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SERVICE_RECORD ); 		
		
		return this;
	}	

	public static final String  ID_OF_TRANSACTION_STATUS ="transaction_status.id";
	public HfgwChecker checkIdOfTransactionStatus(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_TRANSACTION_STATUS ); 		
		
		return this;
	}	

	public static final String  NAME_OF_TRANSACTION_STATUS ="transaction_status.name";
	public HfgwChecker checkNameOfTransactionStatus(String name)
	{
		
	 	checkStringLengthRange(name,1, 36,NAME_OF_TRANSACTION_STATUS ); 		
		
		return this;
	}	

	public static final String  CODE_OF_TRANSACTION_STATUS ="transaction_status.code";
	public HfgwChecker checkCodeOfTransactionStatus(String code)
	{
		
	 	checkStringLengthRange(code,1, 36,CODE_OF_TRANSACTION_STATUS ); 		
		
		return this;
	}	

	public static final String  NETWORK_OF_TRANSACTION_STATUS ="transaction_status.network";
	public HfgwChecker checkNetworkIdOfTransactionStatus(String networkId)
	{
		
	 	checkIdOfTransactionStatus(networkId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_TRANSACTION_STATUS ="transaction_status.version";
	public HfgwChecker checkVersionOfTransactionStatus(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRANSACTION_STATUS ); 		
		
		return this;
	}	

	public static final String  ID_OF_CHANGE_REQUEST_TYPE ="change_request_type.id";
	public HfgwChecker checkIdOfChangeRequestType(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_CHANGE_REQUEST_TYPE ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CHANGE_REQUEST_TYPE ="change_request_type.name";
	public HfgwChecker checkNameOfChangeRequestType(String name)
	{
		
	 	checkStringLengthRange(name,2, 32,NAME_OF_CHANGE_REQUEST_TYPE ); 		
		
		return this;
	}	

	public static final String  CODE_OF_CHANGE_REQUEST_TYPE ="change_request_type.code";
	public HfgwChecker checkCodeOfChangeRequestType(String code)
	{
		
	 	checkStringLengthRange(code,5, 68,CODE_OF_CHANGE_REQUEST_TYPE ); 		
		
		return this;
	}	

	public static final String  ICON_OF_CHANGE_REQUEST_TYPE ="change_request_type.icon";
	public HfgwChecker checkIconOfChangeRequestType(String icon)
	{
		
	 	checkStringLengthRange(icon,2, 24,ICON_OF_CHANGE_REQUEST_TYPE ); 		
		
		return this;
	}	

	public static final String  DISPLAY_ORDER_OF_CHANGE_REQUEST_TYPE ="change_request_type.display_order";
	public HfgwChecker checkDisplayOrderOfChangeRequestType(int displayOrder)
	{
		
	 	checkIntegerRange(displayOrder,0, 7,DISPLAY_ORDER_OF_CHANGE_REQUEST_TYPE ); 		
		
		return this;
	}	

	public static final String  BIND_TYPES_OF_CHANGE_REQUEST_TYPE ="change_request_type.bind_types";
	public HfgwChecker checkBindTypesOfChangeRequestType(String bindTypes)
	{
		
	 	checkLongtext(bindTypes,0, 1048576,BIND_TYPES_OF_CHANGE_REQUEST_TYPE ); 		
		
		return this;
	}	

	public static final String  STEP_CONFIGURATION_OF_CHANGE_REQUEST_TYPE ="change_request_type.step_configuration";
	public HfgwChecker checkStepConfigurationOfChangeRequestType(String stepConfiguration)
	{
		
	 	checkLongtext(stepConfiguration,0, 1048576,STEP_CONFIGURATION_OF_CHANGE_REQUEST_TYPE ); 		
		
		return this;
	}	

	public static final String  NETWORK_OF_CHANGE_REQUEST_TYPE ="change_request_type.network";
	public HfgwChecker checkNetworkIdOfChangeRequestType(String networkId)
	{
		
	 	checkIdOfChangeRequestType(networkId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CHANGE_REQUEST_TYPE ="change_request_type.version";
	public HfgwChecker checkVersionOfChangeRequestType(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CHANGE_REQUEST_TYPE ); 		
		
		return this;
	}	

	public static final String  ID_OF_CHANGE_REQUEST ="change_request.id";
	public HfgwChecker checkIdOfChangeRequest(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_CHANGE_REQUEST ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CHANGE_REQUEST ="change_request.name";
	public HfgwChecker checkNameOfChangeRequest(String name)
	{
		
	 	checkStringLengthRange(name,1, 50,NAME_OF_CHANGE_REQUEST ); 		
		
		return this;
	}	

	public static final String  REQUEST_TYPE_OF_CHANGE_REQUEST ="change_request.request_type";
	public HfgwChecker checkRequestTypeIdOfChangeRequest(String requestTypeId)
	{
		
	 	checkIdOfChangeRequest(requestTypeId ); 		
		
		return this;
	}	

	public static final String  NETWORK_OF_CHANGE_REQUEST ="change_request.network";
	public HfgwChecker checkNetworkIdOfChangeRequest(String networkId)
	{
		
	 	checkIdOfChangeRequest(networkId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CHANGE_REQUEST ="change_request.version";
	public HfgwChecker checkVersionOfChangeRequest(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CHANGE_REQUEST ); 		
		
		return this;
	}	

	public static final String  ID_OF_CHAIN_CODE_INVOKER ="chain_code_invoker.id";
	public HfgwChecker checkIdOfChainCodeInvoker(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_CHAIN_CODE_INVOKER ); 		
		
		return this;
	}	

	public static final String  APP_CLIENT_OF_CHAIN_CODE_INVOKER ="chain_code_invoker.app_client";
	public HfgwChecker checkAppClientIdOfChainCodeInvoker(String appClientId)
	{
		
	 	checkIdOfChainCodeInvoker(appClientId ); 		
		
		return this;
	}	

	public static final String  CHAIN_CODE_OF_CHAIN_CODE_INVOKER ="chain_code_invoker.chain_code";
	public HfgwChecker checkChainCodeIdOfChainCodeInvoker(String chainCodeId)
	{
		
	 	checkIdOfChainCodeInvoker(chainCodeId ); 		
		
		return this;
	}	

	public static final String  PARAMETERS_OF_CHAIN_CODE_INVOKER ="chain_code_invoker.parameters";
	public HfgwChecker checkParametersOfChainCodeInvoker(String parameters)
	{
		
	 	checkLongtext(parameters,0, 1048576,PARAMETERS_OF_CHAIN_CODE_INVOKER ); 		
		
		return this;
	}	

	public static final String  CHANGE_REQUEST_OF_CHAIN_CODE_INVOKER ="chain_code_invoker.change_request";
	public HfgwChecker checkChangeRequestIdOfChainCodeInvoker(String changeRequestId)
	{
		
	 	checkIdOfChainCodeInvoker(changeRequestId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CHAIN_CODE_INVOKER ="chain_code_invoker.version";
	public HfgwChecker checkVersionOfChainCodeInvoker(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CHAIN_CODE_INVOKER ); 		
		
		return this;
	}	

	public static final String  ID_OF_USER_DOMAIN ="user_domain.id";
	public HfgwChecker checkIdOfUserDomain(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_USER_DOMAIN ); 		
		
		return this;
	}	

	public static final String  NAME_OF_USER_DOMAIN ="user_domain.name";
	public HfgwChecker checkNameOfUserDomain(String name)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_USER_DOMAIN ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_USER_DOMAIN ="user_domain.version";
	public HfgwChecker checkVersionOfUserDomain(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_DOMAIN ); 		
		
		return this;
	}	

	public static final String  ID_OF_USER_WHITE_LIST ="user_white_list.id";
	public HfgwChecker checkIdOfUserWhiteList(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	

	public static final String  USER_IDENTITY_OF_USER_WHITE_LIST ="user_white_list.user_identity";
	public HfgwChecker checkUserIdentityOfUserWhiteList(String userIdentity)
	{
		
	 	checkStringLengthRange(userIdentity,1, 40,USER_IDENTITY_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	

	public static final String  USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ="user_white_list.user_special_functions";
	public HfgwChecker checkUserSpecialFunctionsOfUserWhiteList(String userSpecialFunctions)
	{
		
	 	checkStringLengthRange(userSpecialFunctions,1, 200,USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	

	public static final String  DOMAIN_OF_USER_WHITE_LIST ="user_white_list.domain";
	public HfgwChecker checkDomainIdOfUserWhiteList(String domainId)
	{
		
	 	checkIdOfUserWhiteList(domainId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_USER_WHITE_LIST ="user_white_list.version";
	public HfgwChecker checkVersionOfUserWhiteList(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	

	public static final String  ID_OF_SEC_USER ="sec_user.id";
	public HfgwChecker checkIdOfSecUser(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  LOGIN_OF_SEC_USER ="sec_user.login";
	public HfgwChecker checkLoginOfSecUser(String login)
	{
		
	 	checkStringLengthRange(login,0, 256,LOGIN_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  MOBILE_OF_SEC_USER ="sec_user.mobile";
	public HfgwChecker checkMobileOfSecUser(String mobile)
	{
		
	 	checkChinaMobilePhone(mobile,0, 11,MOBILE_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  EMAIL_OF_SEC_USER ="sec_user.email";
	public HfgwChecker checkEmailOfSecUser(String email)
	{
		
	 	checkEmail(email,0, 256,EMAIL_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  PWD_OF_SEC_USER ="sec_user.pwd";
	public HfgwChecker checkPwdOfSecUser(String pwd)
	{
		
	 	checkPassword(pwd,3, 28,PWD_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  WEIXIN_OPENID_OF_SEC_USER ="sec_user.weixin_openid";
	public HfgwChecker checkWeixinOpenidOfSecUser(String weixinOpenid)
	{
		
	 	checkStringLengthRange(weixinOpenid,0, 128,WEIXIN_OPENID_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  WEIXIN_APPID_OF_SEC_USER ="sec_user.weixin_appid";
	public HfgwChecker checkWeixinAppidOfSecUser(String weixinAppid)
	{
		
	 	checkStringLengthRange(weixinAppid,0, 128,WEIXIN_APPID_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  ACCESS_TOKEN_OF_SEC_USER ="sec_user.access_token";
	public HfgwChecker checkAccessTokenOfSecUser(String accessToken)
	{
		
	 	checkStringLengthRange(accessToken,0, 128,ACCESS_TOKEN_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  VERIFICATION_CODE_OF_SEC_USER ="sec_user.verification_code";
	public HfgwChecker checkVerificationCodeOfSecUser(int verificationCode)
	{
		
	 	checkIntegerRange(verificationCode,0, 9999999,VERIFICATION_CODE_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  VERIFICATION_CODE_EXPIRE_OF_SEC_USER ="sec_user.verification_code_expire";
	public HfgwChecker checkVerificationCodeExpireOfSecUser(DateTime verificationCodeExpire)
	{
		
	 	checkDateTime(verificationCodeExpire,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),VERIFICATION_CODE_EXPIRE_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  LAST_LOGIN_TIME_OF_SEC_USER ="sec_user.last_login_time";
	public HfgwChecker checkLastLoginTimeOfSecUser(DateTime lastLoginTime)
	{
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),LAST_LOGIN_TIME_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  DOMAIN_OF_SEC_USER ="sec_user.domain";
	public HfgwChecker checkDomainIdOfSecUser(String domainId)
	{
		
	 	checkIdOfSecUser(domainId ); 		
		
		return this;
	}	

	public static final String  BLOCKING_OF_SEC_USER ="sec_user.blocking";
	public HfgwChecker checkBlockingIdOfSecUser(String blockingId)
	{
		
	 	checkIdOfSecUser(blockingId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SEC_USER ="sec_user.version";
	public HfgwChecker checkVersionOfSecUser(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  ID_OF_SEC_USER_BLOCKING ="sec_user_blocking.id";
	public HfgwChecker checkIdOfSecUserBlocking(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	

	public static final String  WHO_OF_SEC_USER_BLOCKING ="sec_user_blocking.who";
	public HfgwChecker checkWhoOfSecUserBlocking(String who)
	{
		
	 	checkStringLengthRange(who,4, 52,WHO_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	

	public static final String  COMMENTS_OF_SEC_USER_BLOCKING ="sec_user_blocking.comments";
	public HfgwChecker checkCommentsOfSecUserBlocking(String comments)
	{
		
	 	checkStringLengthRange(comments,7, 96,COMMENTS_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SEC_USER_BLOCKING ="sec_user_blocking.version";
	public HfgwChecker checkVersionOfSecUserBlocking(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	

	public static final String  ID_OF_USER_APP ="user_app.id";
	public HfgwChecker checkIdOfUserApp(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_USER_APP ="user_app.title";
	public HfgwChecker checkTitleOfUserApp(String title)
	{
		
	 	checkStringLengthRange(title,1, 300,TITLE_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  SEC_USER_OF_USER_APP ="user_app.sec_user";
	public HfgwChecker checkSecUserIdOfUserApp(String secUserId)
	{
		
	 	checkIdOfUserApp(secUserId ); 		
		
		return this;
	}	

	public static final String  APP_ICON_OF_USER_APP ="user_app.app_icon";
	public HfgwChecker checkAppIconOfUserApp(String appIcon)
	{
		
	 	checkStringLengthRange(appIcon,2, 36,APP_ICON_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  FULL_ACCESS_OF_USER_APP ="user_app.full_access";
	public HfgwChecker checkFullAccessOfUserApp(boolean fullAccess)
	{
		
	 	checkBooleanRange(fullAccess,0, true,FULL_ACCESS_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  PERMISSION_OF_USER_APP ="user_app.permission";
	public HfgwChecker checkPermissionOfUserApp(String permission)
	{
		
	 	checkStringLengthRange(permission,2, 16,PERMISSION_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  OBJECT_TYPE_OF_USER_APP ="user_app.object_type";
	public HfgwChecker checkObjectTypeOfUserApp(String objectType)
	{
		
	 	checkStringLengthRange(objectType,1, 100,OBJECT_TYPE_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  OBJECT_ID_OF_USER_APP ="user_app.object_id";
	public HfgwChecker checkObjectIdOfUserApp(String objectId)
	{
		
	 	checkStringLengthRange(objectId,4, 40,OBJECT_ID_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  LOCATION_OF_USER_APP ="user_app.location";
	public HfgwChecker checkLocationOfUserApp(String location)
	{
		
	 	checkStringLengthRange(location,4, 48,LOCATION_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_USER_APP ="user_app.version";
	public HfgwChecker checkVersionOfUserApp(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  ID_OF_QUICK_LINK ="quick_link.id";
	public HfgwChecker checkIdOfQuickLink(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  NAME_OF_QUICK_LINK ="quick_link.name";
	public HfgwChecker checkNameOfQuickLink(String name)
	{
		
	 	checkStringLengthRange(name,1, 200,NAME_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  ICON_OF_QUICK_LINK ="quick_link.icon";
	public HfgwChecker checkIconOfQuickLink(String icon)
	{
		
	 	checkStringLengthRange(icon,1, 200,ICON_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  IMAGE_PATH_OF_QUICK_LINK ="quick_link.image_path";
	public HfgwChecker checkImagePathOfQuickLink(String imagePath)
	{
		
	 	checkImage(imagePath,0, 512,IMAGE_PATH_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  LINK_TARGET_OF_QUICK_LINK ="quick_link.link_target";
	public HfgwChecker checkLinkTargetOfQuickLink(String linkTarget)
	{
		
	 	checkStringLengthRange(linkTarget,1, 200,LINK_TARGET_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  APP_OF_QUICK_LINK ="quick_link.app";
	public HfgwChecker checkAppIdOfQuickLink(String appId)
	{
		
	 	checkIdOfQuickLink(appId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_QUICK_LINK ="quick_link.version";
	public HfgwChecker checkVersionOfQuickLink(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  ID_OF_LIST_ACCESS ="list_access.id";
	public HfgwChecker checkIdOfListAccess(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  NAME_OF_LIST_ACCESS ="list_access.name";
	public HfgwChecker checkNameOfListAccess(String name)
	{
		
	 	checkStringLengthRange(name,1, 200,NAME_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  INTERNAL_NAME_OF_LIST_ACCESS ="list_access.internal_name";
	public HfgwChecker checkInternalNameOfListAccess(String internalName)
	{
		
	 	checkStringLengthRange(internalName,1, 200,INTERNAL_NAME_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  READ_PERMISSION_OF_LIST_ACCESS ="list_access.read_permission";
	public HfgwChecker checkReadPermissionOfListAccess(boolean readPermission)
	{
		
	 	checkBooleanRange(readPermission,0, true,READ_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  CREATE_PERMISSION_OF_LIST_ACCESS ="list_access.create_permission";
	public HfgwChecker checkCreatePermissionOfListAccess(boolean createPermission)
	{
		
	 	checkBooleanRange(createPermission,0, true,CREATE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  DELETE_PERMISSION_OF_LIST_ACCESS ="list_access.delete_permission";
	public HfgwChecker checkDeletePermissionOfListAccess(boolean deletePermission)
	{
		
	 	checkBooleanRange(deletePermission,0, true,DELETE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  UPDATE_PERMISSION_OF_LIST_ACCESS ="list_access.update_permission";
	public HfgwChecker checkUpdatePermissionOfListAccess(boolean updatePermission)
	{
		
	 	checkBooleanRange(updatePermission,0, true,UPDATE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  EXECUTION_PERMISSION_OF_LIST_ACCESS ="list_access.execution_permission";
	public HfgwChecker checkExecutionPermissionOfListAccess(boolean executionPermission)
	{
		
	 	checkBooleanRange(executionPermission,0, true,EXECUTION_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  APP_OF_LIST_ACCESS ="list_access.app";
	public HfgwChecker checkAppIdOfListAccess(String appId)
	{
		
	 	checkIdOfListAccess(appId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_LIST_ACCESS ="list_access.version";
	public HfgwChecker checkVersionOfListAccess(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  ID_OF_OBJECT_ACCESS ="object_access.id";
	public HfgwChecker checkIdOfObjectAccess(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  NAME_OF_OBJECT_ACCESS ="object_access.name";
	public HfgwChecker checkNameOfObjectAccess(String name)
	{
		
	 	checkStringLengthRange(name,2, 28,NAME_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  OBJECT_TYPE_OF_OBJECT_ACCESS ="object_access.object_type";
	public HfgwChecker checkObjectTypeOfObjectAccess(String objectType)
	{
		
	 	checkStringLengthRange(objectType,5, 112,OBJECT_TYPE_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST1_OF_OBJECT_ACCESS ="object_access.list1";
	public HfgwChecker checkList1OfObjectAccess(String list1)
	{
		
	 	checkStringLengthRange(list1,5, 80,LIST1_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST2_OF_OBJECT_ACCESS ="object_access.list2";
	public HfgwChecker checkList2OfObjectAccess(String list2)
	{
		
	 	checkStringLengthRange(list2,5, 80,LIST2_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST3_OF_OBJECT_ACCESS ="object_access.list3";
	public HfgwChecker checkList3OfObjectAccess(String list3)
	{
		
	 	checkStringLengthRange(list3,5, 80,LIST3_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST4_OF_OBJECT_ACCESS ="object_access.list4";
	public HfgwChecker checkList4OfObjectAccess(String list4)
	{
		
	 	checkStringLengthRange(list4,5, 80,LIST4_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST5_OF_OBJECT_ACCESS ="object_access.list5";
	public HfgwChecker checkList5OfObjectAccess(String list5)
	{
		
	 	checkStringLengthRange(list5,5, 80,LIST5_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST6_OF_OBJECT_ACCESS ="object_access.list6";
	public HfgwChecker checkList6OfObjectAccess(String list6)
	{
		
	 	checkStringLengthRange(list6,5, 80,LIST6_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST7_OF_OBJECT_ACCESS ="object_access.list7";
	public HfgwChecker checkList7OfObjectAccess(String list7)
	{
		
	 	checkStringLengthRange(list7,5, 80,LIST7_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST8_OF_OBJECT_ACCESS ="object_access.list8";
	public HfgwChecker checkList8OfObjectAccess(String list8)
	{
		
	 	checkStringLengthRange(list8,5, 80,LIST8_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST9_OF_OBJECT_ACCESS ="object_access.list9";
	public HfgwChecker checkList9OfObjectAccess(String list9)
	{
		
	 	checkStringLengthRange(list9,5, 80,LIST9_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  APP_OF_OBJECT_ACCESS ="object_access.app";
	public HfgwChecker checkAppIdOfObjectAccess(String appId)
	{
		
	 	checkIdOfObjectAccess(appId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_OBJECT_ACCESS ="object_access.version";
	public HfgwChecker checkVersionOfObjectAccess(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  ID_OF_LOGIN_HISTORY ="login_history.id";
	public HfgwChecker checkIdOfLoginHistory(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	

	public static final String  FROM_IP_OF_LOGIN_HISTORY ="login_history.from_ip";
	public HfgwChecker checkFromIpOfLoginHistory(String fromIp)
	{
		
	 	checkStringLengthRange(fromIp,5, 44,FROM_IP_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_LOGIN_HISTORY ="login_history.description";
	public HfgwChecker checkDescriptionOfLoginHistory(String description)
	{
		
	 	checkStringLengthRange(description,2, 16,DESCRIPTION_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	

	public static final String  SEC_USER_OF_LOGIN_HISTORY ="login_history.sec_user";
	public HfgwChecker checkSecUserIdOfLoginHistory(String secUserId)
	{
		
	 	checkIdOfLoginHistory(secUserId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_LOGIN_HISTORY ="login_history.version";
	public HfgwChecker checkVersionOfLoginHistory(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	

	public static final String  ID_OF_GENERIC_FORM ="generic_form.id";
	public HfgwChecker checkIdOfGenericForm(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_GENERIC_FORM ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_GENERIC_FORM ="generic_form.title";
	public HfgwChecker checkTitleOfGenericForm(String title)
	{
		
	 	checkStringLengthRange(title,2, 20,TITLE_OF_GENERIC_FORM ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_GENERIC_FORM ="generic_form.description";
	public HfgwChecker checkDescriptionOfGenericForm(String description)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_GENERIC_FORM ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_GENERIC_FORM ="generic_form.version";
	public HfgwChecker checkVersionOfGenericForm(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GENERIC_FORM ); 		
		
		return this;
	}	

	public static final String  ID_OF_FORM_MESSAGE ="form_message.id";
	public HfgwChecker checkIdOfFormMessage(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_FORM_MESSAGE ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_FORM_MESSAGE ="form_message.title";
	public HfgwChecker checkTitleOfFormMessage(String title)
	{
		
	 	checkStringLengthRange(title,2, 24,TITLE_OF_FORM_MESSAGE ); 		
		
		return this;
	}	

	public static final String  FORM_OF_FORM_MESSAGE ="form_message.form";
	public HfgwChecker checkFormIdOfFormMessage(String formId)
	{
		
	 	checkIdOfFormMessage(formId ); 		
		
		return this;
	}	

	public static final String  LEVEL_OF_FORM_MESSAGE ="form_message.level";
	public HfgwChecker checkLevelOfFormMessage(String level)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_MESSAGE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_FORM_MESSAGE ="form_message.version";
	public HfgwChecker checkVersionOfFormMessage(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_MESSAGE ); 		
		
		return this;
	}	

	public static final String  ID_OF_FORM_FIELD_MESSAGE ="form_field_message.id";
	public HfgwChecker checkIdOfFormFieldMessage(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_FORM_FIELD_MESSAGE ="form_field_message.title";
	public HfgwChecker checkTitleOfFormFieldMessage(String title)
	{
		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	

	public static final String  PARAMETER_NAME_OF_FORM_FIELD_MESSAGE ="form_field_message.parameter_name";
	public HfgwChecker checkParameterNameOfFormFieldMessage(String parameterName)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	

	public static final String  FORM_OF_FORM_FIELD_MESSAGE ="form_field_message.form";
	public HfgwChecker checkFormIdOfFormFieldMessage(String formId)
	{
		
	 	checkIdOfFormFieldMessage(formId ); 		
		
		return this;
	}	

	public static final String  LEVEL_OF_FORM_FIELD_MESSAGE ="form_field_message.level";
	public HfgwChecker checkLevelOfFormFieldMessage(String level)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_FORM_FIELD_MESSAGE ="form_field_message.version";
	public HfgwChecker checkVersionOfFormFieldMessage(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	

	public static final String  ID_OF_FORM_FIELD ="form_field.id";
	public HfgwChecker checkIdOfFormField(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  LABEL_OF_FORM_FIELD ="form_field.label";
	public HfgwChecker checkLabelOfFormField(String label)
	{
		
	 	checkStringLengthRange(label,1, 12,LABEL_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  LOCALE_KEY_OF_FORM_FIELD ="form_field.locale_key";
	public HfgwChecker checkLocaleKeyOfFormField(String localeKey)
	{
		
	 	checkStringLengthRange(localeKey,1, 44,LOCALE_KEY_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  PARAMETER_NAME_OF_FORM_FIELD ="form_field.parameter_name";
	public HfgwChecker checkParameterNameOfFormField(String parameterName)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  TYPE_OF_FORM_FIELD ="form_field.type";
	public HfgwChecker checkTypeOfFormField(String type)
	{
		
	 	checkStringLengthRange(type,1, 36,TYPE_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  FORM_OF_FORM_FIELD ="form_field.form";
	public HfgwChecker checkFormIdOfFormField(String formId)
	{
		
	 	checkIdOfFormField(formId ); 		
		
		return this;
	}	

	public static final String  PLACEHOLDER_OF_FORM_FIELD ="form_field.placeholder";
	public HfgwChecker checkPlaceholderOfFormField(String placeholder)
	{
		
	 	checkStringLengthRange(placeholder,4, 48,PLACEHOLDER_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  DEFAULT_VALUE_OF_FORM_FIELD ="form_field.default_value";
	public HfgwChecker checkDefaultValueOfFormField(String defaultValue)
	{
		
	 	checkStringLengthRange(defaultValue,1, 12,DEFAULT_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_FORM_FIELD ="form_field.description";
	public HfgwChecker checkDescriptionOfFormField(String description)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  FIELD_GROUP_OF_FORM_FIELD ="form_field.field_group";
	public HfgwChecker checkFieldGroupOfFormField(String fieldGroup)
	{
		
	 	checkStringLengthRange(fieldGroup,2, 16,FIELD_GROUP_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  MINIMUM_VALUE_OF_FORM_FIELD ="form_field.minimum_value";
	public HfgwChecker checkMinimumValueOfFormField(String minimumValue)
	{
		
	 	checkStringLengthRange(minimumValue,4, 60,MINIMUM_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  MAXIMUM_VALUE_OF_FORM_FIELD ="form_field.maximum_value";
	public HfgwChecker checkMaximumValueOfFormField(String maximumValue)
	{
		
	 	checkStringLengthRange(maximumValue,5, 72,MAXIMUM_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  REQUIRED_OF_FORM_FIELD ="form_field.required";
	public HfgwChecker checkRequiredOfFormField(boolean required)
	{
		
	 	checkBooleanRange(required,0, true|false,REQUIRED_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  DISABLED_OF_FORM_FIELD ="form_field.disabled";
	public HfgwChecker checkDisabledOfFormField(boolean disabled)
	{
		
	 	checkBooleanRange(disabled,0, true|false,DISABLED_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  CUSTOM_RENDERING_OF_FORM_FIELD ="form_field.custom_rendering";
	public HfgwChecker checkCustomRenderingOfFormField(boolean customRendering)
	{
		
	 	checkBooleanRange(customRendering,0, false,CUSTOM_RENDERING_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  CANDIDATE_VALUES_OF_FORM_FIELD ="form_field.candidate_values";
	public HfgwChecker checkCandidateValuesOfFormField(String candidateValues)
	{
		
	 	checkStringLengthRange(candidateValues,0, 12,CANDIDATE_VALUES_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  SUGGEST_VALUES_OF_FORM_FIELD ="form_field.suggest_values";
	public HfgwChecker checkSuggestValuesOfFormField(String suggestValues)
	{
		
	 	checkStringLengthRange(suggestValues,0, 12,SUGGEST_VALUES_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_FORM_FIELD ="form_field.version";
	public HfgwChecker checkVersionOfFormField(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  ID_OF_FORM_ACTION ="form_action.id";
	public HfgwChecker checkIdOfFormAction(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_FORM_ACTION ); 		
		
		return this;
	}	

	public static final String  LABEL_OF_FORM_ACTION ="form_action.label";
	public HfgwChecker checkLabelOfFormAction(String label)
	{
		
	 	checkStringLengthRange(label,1, 8,LABEL_OF_FORM_ACTION ); 		
		
		return this;
	}	

	public static final String  LOCALE_KEY_OF_FORM_ACTION ="form_action.locale_key";
	public HfgwChecker checkLocaleKeyOfFormAction(String localeKey)
	{
		
	 	checkStringLengthRange(localeKey,2, 16,LOCALE_KEY_OF_FORM_ACTION ); 		
		
		return this;
	}	

	public static final String  ACTION_KEY_OF_FORM_ACTION ="form_action.action_key";
	public HfgwChecker checkActionKeyOfFormAction(String actionKey)
	{
		
	 	checkStringLengthRange(actionKey,2, 24,ACTION_KEY_OF_FORM_ACTION ); 		
		
		return this;
	}	

	public static final String  LEVEL_OF_FORM_ACTION ="form_action.level";
	public HfgwChecker checkLevelOfFormAction(String level)
	{
		
	 	checkStringLengthRange(level,3, 28,LEVEL_OF_FORM_ACTION ); 		
		
		return this;
	}	

	public static final String  URL_OF_FORM_ACTION ="form_action.url";
	public HfgwChecker checkUrlOfFormAction(String url)
	{
		
	 	checkStringLengthRange(url,11, 168,URL_OF_FORM_ACTION ); 		
		
		return this;
	}	

	public static final String  FORM_OF_FORM_ACTION ="form_action.form";
	public HfgwChecker checkFormIdOfFormAction(String formId)
	{
		
	 	checkIdOfFormAction(formId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_FORM_ACTION ="form_action.version";
	public HfgwChecker checkVersionOfFormAction(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_ACTION ); 		
		
		return this;
	}	

	public static final String  ID_OF_CANDIDATE_CONTAINER ="candidate_container.id";
	public HfgwChecker checkIdOfCandidateContainer(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_CANDIDATE_CONTAINER ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CANDIDATE_CONTAINER ="candidate_container.name";
	public HfgwChecker checkNameOfCandidateContainer(String name)
	{
		
	 	checkStringLengthRange(name,2, 28,NAME_OF_CANDIDATE_CONTAINER ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CANDIDATE_CONTAINER ="candidate_container.version";
	public HfgwChecker checkVersionOfCandidateContainer(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CANDIDATE_CONTAINER ); 		
		
		return this;
	}	

	public static final String  ID_OF_CANDIDATE_ELEMENT ="candidate_element.id";
	public HfgwChecker checkIdOfCandidateElement(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CANDIDATE_ELEMENT ="candidate_element.name";
	public HfgwChecker checkNameOfCandidateElement(String name)
	{
		
	 	checkStringLengthRange(name,1, 200,NAME_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  TYPE_OF_CANDIDATE_ELEMENT ="candidate_element.type";
	public HfgwChecker checkTypeOfCandidateElement(String type)
	{
		
	 	checkStringLengthRange(type,1, 200,TYPE_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  IMAGE_OF_CANDIDATE_ELEMENT ="candidate_element.image";
	public HfgwChecker checkImageOfCandidateElement(String image)
	{
		
	 	checkImage(image,0, 512,IMAGE_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  CONTAINER_OF_CANDIDATE_ELEMENT ="candidate_element.container";
	public HfgwChecker checkContainerIdOfCandidateElement(String containerId)
	{
		
	 	checkIdOfCandidateElement(containerId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CANDIDATE_ELEMENT ="candidate_element.version";
	public HfgwChecker checkVersionOfCandidateElement(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	
}









