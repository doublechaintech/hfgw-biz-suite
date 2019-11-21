
package com.doublechaintech.hfgw.node;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;
import com.doublechaintech.hfgw.MultipleAccessKey;
import com.doublechaintech.hfgw.HfgwUserContext;

import com.doublechaintech.hfgw.channelpeerrole.ChannelPeerRole;
import com.doublechaintech.hfgw.organization.Organization;
import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.nodetype.NodeType;
import com.doublechaintech.hfgw.grpcoption.GrpcOption;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetworkDAO;
import com.doublechaintech.hfgw.channelpeerrole.ChannelPeerRoleDAO;
import com.doublechaintech.hfgw.grpcoption.GrpcOptionDAO;
import com.doublechaintech.hfgw.organization.OrganizationDAO;
import com.doublechaintech.hfgw.channel.ChannelDAO;
import com.doublechaintech.hfgw.nodetype.NodeTypeDAO;


public interface NodeDAO{

	public SmartList<Node> loadAll();
	public Node load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Node> nodeList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Node present(Node node,Map<String,Object> options) throws Exception;
	public Node clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Node save(Node node,Map<String,Object> options);
	public SmartList<Node> saveNodeList(SmartList<Node> nodeList,Map<String,Object> options);
	public SmartList<Node> removeNodeList(SmartList<Node> nodeList,Map<String,Object> options);
	public SmartList<Node> findNodeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countNodeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countNodeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String nodeId, int version) throws Exception;
	public Node disconnectFromAll(String nodeId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public GrpcOptionDAO getGrpcOptionDAO();
		
	public ChannelPeerRoleDAO getChannelPeerRoleDAO();
		
	
 	public SmartList<Node> requestCandidateNodeForGrpcOption(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Node> requestCandidateNodeForChannelPeerRole(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Node planToRemoveGrpcOptionList(Node node, String grpcOptionIds[], Map<String,Object> options)throws Exception;


	public Node planToRemoveChannelPeerRoleList(Node node, String channelPeerRoleIds[], Map<String,Object> options)throws Exception;


	//disconnect Node with channel in ChannelPeerRole
	public Node planToRemoveChannelPeerRoleListWithChannel(Node node, String channelId, Map<String,Object> options)throws Exception;
	public int countChannelPeerRoleListWithChannel(String nodeId, String channelId, Map<String,Object> options)throws Exception;
	
	//disconnect Node with peer_role in ChannelPeerRole
	public Node planToRemoveChannelPeerRoleListWithPeerRole(Node node, String peerRoleId, Map<String,Object> options)throws Exception;
	public int countChannelPeerRoleListWithPeerRole(String nodeId, String peerRoleId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Node> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<Node> findNodeByOrganization(String organizationId, Map<String,Object> options);
 	public int countNodeByOrganization(String organizationId, Map<String,Object> options);
 	public Map<String, Integer> countNodeByOrganizationIds(String[] ids, Map<String,Object> options);
 	public SmartList<Node> findNodeByOrganization(String organizationId, int start, int count, Map<String,Object> options);
 	public void analyzeNodeByOrganization(SmartList<Node> resultList, String organizationId, Map<String,Object> options);

 
  
 	public SmartList<Node> findNodeByChannel(String channelId, Map<String,Object> options);
 	public int countNodeByChannel(String channelId, Map<String,Object> options);
 	public Map<String, Integer> countNodeByChannelIds(String[] ids, Map<String,Object> options);
 	public SmartList<Node> findNodeByChannel(String channelId, int start, int count, Map<String,Object> options);
 	public void analyzeNodeByChannel(SmartList<Node> resultList, String channelId, Map<String,Object> options);

 
  
 	public SmartList<Node> findNodeByNetwork(String hyperledgerNetworkId, Map<String,Object> options);
 	public int countNodeByNetwork(String hyperledgerNetworkId, Map<String,Object> options);
 	public Map<String, Integer> countNodeByNetworkIds(String[] ids, Map<String,Object> options);
 	public SmartList<Node> findNodeByNetwork(String hyperledgerNetworkId, int start, int count, Map<String,Object> options);
 	public void analyzeNodeByNetwork(SmartList<Node> resultList, String hyperledgerNetworkId, Map<String,Object> options);

 
  
 	public SmartList<Node> findNodeByType(String nodeTypeId, Map<String,Object> options);
 	public int countNodeByType(String nodeTypeId, Map<String,Object> options);
 	public Map<String, Integer> countNodeByTypeIds(String[] ids, Map<String,Object> options);
 	public SmartList<Node> findNodeByType(String nodeTypeId, int start, int count, Map<String,Object> options);
 	public void analyzeNodeByType(SmartList<Node> resultList, String nodeTypeId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:GrpcOption的node的GrpcOptionList
	public SmartList<GrpcOption> loadOurGrpcOptionList(HfgwUserContext userContext, List<Node> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:ChannelPeerRole的node的ChannelPeerRoleList
	public SmartList<ChannelPeerRole> loadOurChannelPeerRoleList(HfgwUserContext userContext, List<Node> us, Map<String,Object> options) throws Exception;
	
}


