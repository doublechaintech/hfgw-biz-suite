
package com.doublechaintech.hfgw.tlscacert;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;
import com.doublechaintech.hfgw.MultipleAccessKey;
import com.doublechaintech.hfgw.HfgwUserContext;

import com.doublechaintech.hfgw.node.Node;

import com.doublechaintech.hfgw.node.NodeDAO;


public interface TlsCacertDAO{

	public SmartList<TlsCacert> loadAll();
	public TlsCacert load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<TlsCacert> tlsCacertList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public TlsCacert present(TlsCacert tlsCacert,Map<String,Object> options) throws Exception;
	public TlsCacert clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public TlsCacert save(TlsCacert tlsCacert,Map<String,Object> options);
	public SmartList<TlsCacert> saveTlsCacertList(SmartList<TlsCacert> tlsCacertList,Map<String,Object> options);
	public SmartList<TlsCacert> removeTlsCacertList(SmartList<TlsCacert> tlsCacertList,Map<String,Object> options);
	public SmartList<TlsCacert> findTlsCacertWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countTlsCacertWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countTlsCacertWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String tlsCacertId, int version) throws Exception;
	public TlsCacert disconnectFromAll(String tlsCacertId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<TlsCacert> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<TlsCacert> findTlsCacertByNode(String nodeId, Map<String,Object> options);
 	public int countTlsCacertByNode(String nodeId, Map<String,Object> options);
 	public Map<String, Integer> countTlsCacertByNodeIds(String[] ids, Map<String,Object> options);
 	public SmartList<TlsCacert> findTlsCacertByNode(String nodeId, int start, int count, Map<String,Object> options);
 	public void analyzeTlsCacertByNode(SmartList<TlsCacert> resultList, String nodeId, Map<String,Object> options);

 
 
}


