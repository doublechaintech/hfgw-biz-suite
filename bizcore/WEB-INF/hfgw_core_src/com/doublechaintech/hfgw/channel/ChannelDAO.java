
package com.doublechaintech.hfgw.channel;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;
import com.doublechaintech.hfgw.MultipleAccessKey;
import com.doublechaintech.hfgw.HfgwUserContext;

import com.doublechaintech.hfgw.chaincode.ChainCode;
import com.doublechaintech.hfgw.node.Node;
import com.doublechaintech.hfgw.channelpeerrole.ChannelPeerRole;
import com.doublechaintech.hfgw.application.Application;
import com.doublechaintech.hfgw.servicerecord.ServiceRecord;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetworkDAO;
import com.doublechaintech.hfgw.channelpeerrole.ChannelPeerRoleDAO;
import com.doublechaintech.hfgw.node.NodeDAO;
import com.doublechaintech.hfgw.servicerecord.ServiceRecordDAO;
import com.doublechaintech.hfgw.chaincode.ChainCodeDAO;
import com.doublechaintech.hfgw.application.ApplicationDAO;


public interface ChannelDAO{

	public SmartList<Channel> loadAll();
	public Channel load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Channel> channelList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Channel present(Channel channel,Map<String,Object> options) throws Exception;
	public Channel clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Channel save(Channel channel,Map<String,Object> options);
	public SmartList<Channel> saveChannelList(SmartList<Channel> channelList,Map<String,Object> options);
	public SmartList<Channel> removeChannelList(SmartList<Channel> channelList,Map<String,Object> options);
	public SmartList<Channel> findChannelWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countChannelWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countChannelWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String channelId, int version) throws Exception;
	public Channel disconnectFromAll(String channelId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public NodeDAO getNodeDAO();
		
	public ChannelPeerRoleDAO getChannelPeerRoleDAO();
		
	public ChainCodeDAO getChainCodeDAO();
		
	public ApplicationDAO getApplicationDAO();
		
	public ServiceRecordDAO getServiceRecordDAO();
		
	
 	public SmartList<Channel> requestCandidateChannelForNode(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Channel> requestCandidateChannelForChannelPeerRole(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Channel> requestCandidateChannelForChainCode(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Channel> requestCandidateChannelForApplication(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Channel> requestCandidateChannelForServiceRecord(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Channel planToRemoveNodeList(Channel channel, String nodeIds[], Map<String,Object> options)throws Exception;


	//disconnect Channel with organization in Node
	public Channel planToRemoveNodeListWithOrganization(Channel channel, String organizationId, Map<String,Object> options)throws Exception;
	public int countNodeListWithOrganization(String channelId, String organizationId, Map<String,Object> options)throws Exception;
	
	//disconnect Channel with network in Node
	public Channel planToRemoveNodeListWithNetwork(Channel channel, String networkId, Map<String,Object> options)throws Exception;
	public int countNodeListWithNetwork(String channelId, String networkId, Map<String,Object> options)throws Exception;
	
	//disconnect Channel with type in Node
	public Channel planToRemoveNodeListWithType(Channel channel, String typeId, Map<String,Object> options)throws Exception;
	public int countNodeListWithType(String channelId, String typeId, Map<String,Object> options)throws Exception;
	
	public Channel planToRemoveChannelPeerRoleList(Channel channel, String channelPeerRoleIds[], Map<String,Object> options)throws Exception;


	//disconnect Channel with node in ChannelPeerRole
	public Channel planToRemoveChannelPeerRoleListWithNode(Channel channel, String nodeId, Map<String,Object> options)throws Exception;
	public int countChannelPeerRoleListWithNode(String channelId, String nodeId, Map<String,Object> options)throws Exception;
	
	//disconnect Channel with peer_role in ChannelPeerRole
	public Channel planToRemoveChannelPeerRoleListWithPeerRole(Channel channel, String peerRoleId, Map<String,Object> options)throws Exception;
	public int countChannelPeerRoleListWithPeerRole(String channelId, String peerRoleId, Map<String,Object> options)throws Exception;
	
	public Channel planToRemoveChainCodeList(Channel channel, String chainCodeIds[], Map<String,Object> options)throws Exception;


	public Channel planToRemoveApplicationList(Channel channel, String applicationIds[], Map<String,Object> options)throws Exception;


	//disconnect Channel with network in Application
	public Channel planToRemoveApplicationListWithNetwork(Channel channel, String networkId, Map<String,Object> options)throws Exception;
	public int countApplicationListWithNetwork(String channelId, String networkId, Map<String,Object> options)throws Exception;
	
	public Channel planToRemoveServiceRecordList(Channel channel, String serviceRecordIds[], Map<String,Object> options)throws Exception;


	//disconnect Channel with chain_code in ServiceRecord
	public Channel planToRemoveServiceRecordListWithChainCode(Channel channel, String chainCodeId, Map<String,Object> options)throws Exception;
	public int countServiceRecordListWithChainCode(String channelId, String chainCodeId, Map<String,Object> options)throws Exception;
	
	//disconnect Channel with transaction_id in ServiceRecord
	public Channel planToRemoveServiceRecordListWithTransactionId(Channel channel, String transactionIdId, Map<String,Object> options)throws Exception;
	public int countServiceRecordListWithTransactionId(String channelId, String transactionIdId, Map<String,Object> options)throws Exception;
	
	//disconnect Channel with block_id in ServiceRecord
	public Channel planToRemoveServiceRecordListWithBlockId(Channel channel, String blockIdId, Map<String,Object> options)throws Exception;
	public int countServiceRecordListWithBlockId(String channelId, String blockIdId, Map<String,Object> options)throws Exception;
	
	//disconnect Channel with network in ServiceRecord
	public Channel planToRemoveServiceRecordListWithNetwork(Channel channel, String networkId, Map<String,Object> options)throws Exception;
	public int countServiceRecordListWithNetwork(String channelId, String networkId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Channel> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<Channel> findChannelByNetwork(String hyperledgerNetworkId, Map<String,Object> options);
 	public int countChannelByNetwork(String hyperledgerNetworkId, Map<String,Object> options);
 	public Map<String, Integer> countChannelByNetworkIds(String[] ids, Map<String,Object> options);
 	public SmartList<Channel> findChannelByNetwork(String hyperledgerNetworkId, int start, int count, Map<String,Object> options);
 	public void analyzeChannelByNetwork(SmartList<Channel> resultList, String hyperledgerNetworkId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:Node的channel的NodeList
	public SmartList<Node> loadOurNodeList(HfgwUserContext userContext, List<Channel> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:ChannelPeerRole的channel的ChannelPeerRoleList
	public SmartList<ChannelPeerRole> loadOurChannelPeerRoleList(HfgwUserContext userContext, List<Channel> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:ChainCode的channel的ChainCodeList
	public SmartList<ChainCode> loadOurChainCodeList(HfgwUserContext userContext, List<Channel> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:Application的channel的ApplicationList
	public SmartList<Application> loadOurApplicationList(HfgwUserContext userContext, List<Channel> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:ServiceRecord的channel的ServiceRecordList
	public SmartList<ServiceRecord> loadOurServiceRecordList(HfgwUserContext userContext, List<Channel> us, Map<String,Object> options) throws Exception;
	
}


