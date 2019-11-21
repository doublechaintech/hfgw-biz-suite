
package com.doublechaintech.hfgw.organization;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;
import com.doublechaintech.hfgw.MultipleAccessKey;
import com.doublechaintech.hfgw.HfgwUserContext;

import com.doublechaintech.hfgw.node.Node;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetworkDAO;
import com.doublechaintech.hfgw.node.NodeDAO;


public interface OrganizationDAO{

	public SmartList<Organization> loadAll();
	public Organization load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Organization> organizationList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Organization present(Organization organization,Map<String,Object> options) throws Exception;
	public Organization clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Organization save(Organization organization,Map<String,Object> options);
	public SmartList<Organization> saveOrganizationList(SmartList<Organization> organizationList,Map<String,Object> options);
	public SmartList<Organization> removeOrganizationList(SmartList<Organization> organizationList,Map<String,Object> options);
	public SmartList<Organization> findOrganizationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countOrganizationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countOrganizationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String organizationId, int version) throws Exception;
	public Organization disconnectFromAll(String organizationId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public NodeDAO getNodeDAO();
		
	
 	public SmartList<Organization> requestCandidateOrganizationForNode(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Organization planToRemoveNodeList(Organization organization, String nodeIds[], Map<String,Object> options)throws Exception;


	//disconnect Organization with channel in Node
	public Organization planToRemoveNodeListWithChannel(Organization organization, String channelId, Map<String,Object> options)throws Exception;
	public int countNodeListWithChannel(String organizationId, String channelId, Map<String,Object> options)throws Exception;
	
	//disconnect Organization with network in Node
	public Organization planToRemoveNodeListWithNetwork(Organization organization, String networkId, Map<String,Object> options)throws Exception;
	public int countNodeListWithNetwork(String organizationId, String networkId, Map<String,Object> options)throws Exception;
	
	//disconnect Organization with type in Node
	public Organization planToRemoveNodeListWithType(Organization organization, String typeId, Map<String,Object> options)throws Exception;
	public int countNodeListWithType(String organizationId, String typeId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Organization> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<Organization> findOrganizationByNetwork(String hyperledgerNetworkId, Map<String,Object> options);
 	public int countOrganizationByNetwork(String hyperledgerNetworkId, Map<String,Object> options);
 	public Map<String, Integer> countOrganizationByNetworkIds(String[] ids, Map<String,Object> options);
 	public SmartList<Organization> findOrganizationByNetwork(String hyperledgerNetworkId, int start, int count, Map<String,Object> options);
 	public void analyzeOrganizationByNetwork(SmartList<Organization> resultList, String hyperledgerNetworkId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:Node的organization的NodeList
	public SmartList<Node> loadOurNodeList(HfgwUserContext userContext, List<Organization> us, Map<String,Object> options) throws Exception;
	
}


