
package com.doublechaintech.hfgw.nodetype;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;
import com.doublechaintech.hfgw.MultipleAccessKey;
import com.doublechaintech.hfgw.HfgwUserContext;

import com.doublechaintech.hfgw.node.Node;

import com.doublechaintech.hfgw.node.NodeDAO;


public interface NodeTypeDAO{

	public SmartList<NodeType> loadAll();
	public NodeType load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<NodeType> nodeTypeList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public NodeType loadByCode(String code,Map<String,Object> options) throws Exception;
	
	
	public NodeType present(NodeType nodeType,Map<String,Object> options) throws Exception;
	public NodeType clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public NodeType cloneByCode(String code,Map<String,Object> options) throws Exception;
	
	
	public NodeType save(NodeType nodeType,Map<String,Object> options);
	public SmartList<NodeType> saveNodeTypeList(SmartList<NodeType> nodeTypeList,Map<String,Object> options);
	public SmartList<NodeType> removeNodeTypeList(SmartList<NodeType> nodeTypeList,Map<String,Object> options);
	public SmartList<NodeType> findNodeTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countNodeTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countNodeTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String nodeTypeId, int version) throws Exception;
	public NodeType disconnectFromAll(String nodeTypeId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public NodeDAO getNodeDAO();
		
	
 	public SmartList<NodeType> requestCandidateNodeTypeForNode(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public NodeType planToRemoveNodeList(NodeType nodeType, String nodeIds[], Map<String,Object> options)throws Exception;


	//disconnect NodeType with organization in Node
	public NodeType planToRemoveNodeListWithOrganization(NodeType nodeType, String organizationId, Map<String,Object> options)throws Exception;
	public int countNodeListWithOrganization(String nodeTypeId, String organizationId, Map<String,Object> options)throws Exception;
	
	//disconnect NodeType with channel in Node
	public NodeType planToRemoveNodeListWithChannel(NodeType nodeType, String channelId, Map<String,Object> options)throws Exception;
	public int countNodeListWithChannel(String nodeTypeId, String channelId, Map<String,Object> options)throws Exception;
	
	//disconnect NodeType with network in Node
	public NodeType planToRemoveNodeListWithNetwork(NodeType nodeType, String networkId, Map<String,Object> options)throws Exception;
	public int countNodeListWithNetwork(String nodeTypeId, String networkId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<NodeType> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);

	// 需要一个加载引用我的对象的enhance方法:Node的type的NodeList
	public SmartList<Node> loadOurNodeList(HfgwUserContext userContext, List<NodeType> us, Map<String,Object> options) throws Exception;
	
}


