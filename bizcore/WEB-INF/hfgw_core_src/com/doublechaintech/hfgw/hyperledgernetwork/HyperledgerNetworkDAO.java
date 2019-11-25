
package com.doublechaintech.hfgw.hyperledgernetwork;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;
import com.doublechaintech.hfgw.MultipleAccessKey;
import com.doublechaintech.hfgw.HfgwUserContext;

import com.doublechaintech.hfgw.peerrole.PeerRole;
import com.doublechaintech.hfgw.transactionstatus.TransactionStatus;
import com.doublechaintech.hfgw.changerequest.ChangeRequest;
import com.doublechaintech.hfgw.node.Node;
import com.doublechaintech.hfgw.organization.Organization;
import com.doublechaintech.hfgw.nodetype.NodeType;
import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.application.Application;
import com.doublechaintech.hfgw.changerequesttype.ChangeRequestType;
import com.doublechaintech.hfgw.servicerecord.ServiceRecord;

import com.doublechaintech.hfgw.node.NodeDAO;
import com.doublechaintech.hfgw.organization.OrganizationDAO;
import com.doublechaintech.hfgw.peerrole.PeerRoleDAO;
import com.doublechaintech.hfgw.servicerecord.ServiceRecordDAO;
import com.doublechaintech.hfgw.channel.ChannelDAO;
import com.doublechaintech.hfgw.transactionstatus.TransactionStatusDAO;
import com.doublechaintech.hfgw.changerequest.ChangeRequestDAO;
import com.doublechaintech.hfgw.application.ApplicationDAO;
import com.doublechaintech.hfgw.nodetype.NodeTypeDAO;
import com.doublechaintech.hfgw.changerequesttype.ChangeRequestTypeDAO;


public interface HyperledgerNetworkDAO{

	public SmartList<HyperledgerNetwork> loadAll();
	public HyperledgerNetwork load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<HyperledgerNetwork> hyperledgerNetworkList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public HyperledgerNetwork present(HyperledgerNetwork hyperledgerNetwork,Map<String,Object> options) throws Exception;
	public HyperledgerNetwork clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public HyperledgerNetwork save(HyperledgerNetwork hyperledgerNetwork,Map<String,Object> options);
	public SmartList<HyperledgerNetwork> saveHyperledgerNetworkList(SmartList<HyperledgerNetwork> hyperledgerNetworkList,Map<String,Object> options);
	public SmartList<HyperledgerNetwork> removeHyperledgerNetworkList(SmartList<HyperledgerNetwork> hyperledgerNetworkList,Map<String,Object> options);
	public SmartList<HyperledgerNetwork> findHyperledgerNetworkWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countHyperledgerNetworkWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countHyperledgerNetworkWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String hyperledgerNetworkId, int version) throws Exception;
	public HyperledgerNetwork disconnectFromAll(String hyperledgerNetworkId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public OrganizationDAO getOrganizationDAO();
		
	public NodeTypeDAO getNodeTypeDAO();
		
	public NodeDAO getNodeDAO();
		
	public ChannelDAO getChannelDAO();
		
	public PeerRoleDAO getPeerRoleDAO();
		
	public ApplicationDAO getApplicationDAO();
		
	public ServiceRecordDAO getServiceRecordDAO();
		
	public TransactionStatusDAO getTransactionStatusDAO();
		
	public ChangeRequestTypeDAO getChangeRequestTypeDAO();
		
	public ChangeRequestDAO getChangeRequestDAO();
		
	
 	public SmartList<HyperledgerNetwork> requestCandidateHyperledgerNetworkForOrganization(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<HyperledgerNetwork> requestCandidateHyperledgerNetworkForNodeType(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<HyperledgerNetwork> requestCandidateHyperledgerNetworkForNode(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<HyperledgerNetwork> requestCandidateHyperledgerNetworkForChannel(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<HyperledgerNetwork> requestCandidateHyperledgerNetworkForPeerRole(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<HyperledgerNetwork> requestCandidateHyperledgerNetworkForApplication(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<HyperledgerNetwork> requestCandidateHyperledgerNetworkForServiceRecord(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<HyperledgerNetwork> requestCandidateHyperledgerNetworkForTransactionStatus(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<HyperledgerNetwork> requestCandidateHyperledgerNetworkForChangeRequestType(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<HyperledgerNetwork> requestCandidateHyperledgerNetworkForChangeRequest(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public HyperledgerNetwork planToRemoveOrganizationList(HyperledgerNetwork hyperledgerNetwork, String organizationIds[], Map<String,Object> options)throws Exception;


	public HyperledgerNetwork planToRemoveNodeTypeList(HyperledgerNetwork hyperledgerNetwork, String nodeTypeIds[], Map<String,Object> options)throws Exception;


	public HyperledgerNetwork planToRemoveNodeList(HyperledgerNetwork hyperledgerNetwork, String nodeIds[], Map<String,Object> options)throws Exception;


	//disconnect HyperledgerNetwork with organization in Node
	public HyperledgerNetwork planToRemoveNodeListWithOrganization(HyperledgerNetwork hyperledgerNetwork, String organizationId, Map<String,Object> options)throws Exception;
	public int countNodeListWithOrganization(String hyperledgerNetworkId, String organizationId, Map<String,Object> options)throws Exception;
	
	//disconnect HyperledgerNetwork with channel in Node
	public HyperledgerNetwork planToRemoveNodeListWithChannel(HyperledgerNetwork hyperledgerNetwork, String channelId, Map<String,Object> options)throws Exception;
	public int countNodeListWithChannel(String hyperledgerNetworkId, String channelId, Map<String,Object> options)throws Exception;
	
	//disconnect HyperledgerNetwork with type in Node
	public HyperledgerNetwork planToRemoveNodeListWithType(HyperledgerNetwork hyperledgerNetwork, String typeId, Map<String,Object> options)throws Exception;
	public int countNodeListWithType(String hyperledgerNetworkId, String typeId, Map<String,Object> options)throws Exception;
	
	public HyperledgerNetwork planToRemoveChannelList(HyperledgerNetwork hyperledgerNetwork, String channelIds[], Map<String,Object> options)throws Exception;


	public HyperledgerNetwork planToRemovePeerRoleList(HyperledgerNetwork hyperledgerNetwork, String peerRoleIds[], Map<String,Object> options)throws Exception;


	public HyperledgerNetwork planToRemoveApplicationList(HyperledgerNetwork hyperledgerNetwork, String applicationIds[], Map<String,Object> options)throws Exception;


	//disconnect HyperledgerNetwork with channel in Application
	public HyperledgerNetwork planToRemoveApplicationListWithChannel(HyperledgerNetwork hyperledgerNetwork, String channelId, Map<String,Object> options)throws Exception;
	public int countApplicationListWithChannel(String hyperledgerNetworkId, String channelId, Map<String,Object> options)throws Exception;
	
	public HyperledgerNetwork planToRemoveServiceRecordList(HyperledgerNetwork hyperledgerNetwork, String serviceRecordIds[], Map<String,Object> options)throws Exception;


	//disconnect HyperledgerNetwork with channel in ServiceRecord
	public HyperledgerNetwork planToRemoveServiceRecordListWithChannel(HyperledgerNetwork hyperledgerNetwork, String channelId, Map<String,Object> options)throws Exception;
	public int countServiceRecordListWithChannel(String hyperledgerNetworkId, String channelId, Map<String,Object> options)throws Exception;
	
	//disconnect HyperledgerNetwork with chain_code in ServiceRecord
	public HyperledgerNetwork planToRemoveServiceRecordListWithChainCode(HyperledgerNetwork hyperledgerNetwork, String chainCodeId, Map<String,Object> options)throws Exception;
	public int countServiceRecordListWithChainCode(String hyperledgerNetworkId, String chainCodeId, Map<String,Object> options)throws Exception;
	
	//disconnect HyperledgerNetwork with transaction_id in ServiceRecord
	public HyperledgerNetwork planToRemoveServiceRecordListWithTransactionId(HyperledgerNetwork hyperledgerNetwork, String transactionIdId, Map<String,Object> options)throws Exception;
	public int countServiceRecordListWithTransactionId(String hyperledgerNetworkId, String transactionIdId, Map<String,Object> options)throws Exception;
	
	//disconnect HyperledgerNetwork with block_id in ServiceRecord
	public HyperledgerNetwork planToRemoveServiceRecordListWithBlockId(HyperledgerNetwork hyperledgerNetwork, String blockIdId, Map<String,Object> options)throws Exception;
	public int countServiceRecordListWithBlockId(String hyperledgerNetworkId, String blockIdId, Map<String,Object> options)throws Exception;
	
	//disconnect HyperledgerNetwork with app_client in ServiceRecord
	public HyperledgerNetwork planToRemoveServiceRecordListWithAppClient(HyperledgerNetwork hyperledgerNetwork, String appClientId, Map<String,Object> options)throws Exception;
	public int countServiceRecordListWithAppClient(String hyperledgerNetworkId, String appClientId, Map<String,Object> options)throws Exception;
	
	//disconnect HyperledgerNetwork with status in ServiceRecord
	public HyperledgerNetwork planToRemoveServiceRecordListWithStatus(HyperledgerNetwork hyperledgerNetwork, String statusId, Map<String,Object> options)throws Exception;
	public int countServiceRecordListWithStatus(String hyperledgerNetworkId, String statusId, Map<String,Object> options)throws Exception;
	
	public HyperledgerNetwork planToRemoveTransactionStatusList(HyperledgerNetwork hyperledgerNetwork, String transactionStatusIds[], Map<String,Object> options)throws Exception;


	public HyperledgerNetwork planToRemoveChangeRequestTypeList(HyperledgerNetwork hyperledgerNetwork, String changeRequestTypeIds[], Map<String,Object> options)throws Exception;


	public HyperledgerNetwork planToRemoveChangeRequestList(HyperledgerNetwork hyperledgerNetwork, String changeRequestIds[], Map<String,Object> options)throws Exception;


	//disconnect HyperledgerNetwork with request_type in ChangeRequest
	public HyperledgerNetwork planToRemoveChangeRequestListWithRequestType(HyperledgerNetwork hyperledgerNetwork, String requestTypeId, Map<String,Object> options)throws Exception;
	public int countChangeRequestListWithRequestType(String hyperledgerNetworkId, String requestTypeId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<HyperledgerNetwork> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);

	// 需要一个加载引用我的对象的enhance方法:Organization的network的OrganizationList
	public SmartList<Organization> loadOurOrganizationList(HfgwUserContext userContext, List<HyperledgerNetwork> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:NodeType的network的NodeTypeList
	public SmartList<NodeType> loadOurNodeTypeList(HfgwUserContext userContext, List<HyperledgerNetwork> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:Node的network的NodeList
	public SmartList<Node> loadOurNodeList(HfgwUserContext userContext, List<HyperledgerNetwork> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:Channel的network的ChannelList
	public SmartList<Channel> loadOurChannelList(HfgwUserContext userContext, List<HyperledgerNetwork> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:PeerRole的network的PeerRoleList
	public SmartList<PeerRole> loadOurPeerRoleList(HfgwUserContext userContext, List<HyperledgerNetwork> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:Application的network的ApplicationList
	public SmartList<Application> loadOurApplicationList(HfgwUserContext userContext, List<HyperledgerNetwork> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:ServiceRecord的network的ServiceRecordList
	public SmartList<ServiceRecord> loadOurServiceRecordList(HfgwUserContext userContext, List<HyperledgerNetwork> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:TransactionStatus的network的TransactionStatusList
	public SmartList<TransactionStatus> loadOurTransactionStatusList(HfgwUserContext userContext, List<HyperledgerNetwork> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:ChangeRequestType的network的ChangeRequestTypeList
	public SmartList<ChangeRequestType> loadOurChangeRequestTypeList(HfgwUserContext userContext, List<HyperledgerNetwork> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:ChangeRequest的network的ChangeRequestList
	public SmartList<ChangeRequest> loadOurChangeRequestList(HfgwUserContext userContext, List<HyperledgerNetwork> us, Map<String,Object> options) throws Exception;
	
}


