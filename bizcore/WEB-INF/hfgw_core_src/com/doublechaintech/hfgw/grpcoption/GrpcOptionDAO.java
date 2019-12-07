
package com.doublechaintech.hfgw.grpcoption;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.hfgw.BaseDAO;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;
import com.doublechaintech.hfgw.MultipleAccessKey;
import com.doublechaintech.hfgw.HfgwUserContext;

import com.doublechaintech.hfgw.node.Node;

import com.doublechaintech.hfgw.node.NodeDAO;


public interface GrpcOptionDAO extends BaseDAO{

	public SmartList<GrpcOption> loadAll();
	public GrpcOption load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<GrpcOption> grpcOptionList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public GrpcOption present(GrpcOption grpcOption,Map<String,Object> options) throws Exception;
	public GrpcOption clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public GrpcOption save(GrpcOption grpcOption,Map<String,Object> options);
	public SmartList<GrpcOption> saveGrpcOptionList(SmartList<GrpcOption> grpcOptionList,Map<String,Object> options);
	public SmartList<GrpcOption> removeGrpcOptionList(SmartList<GrpcOption> grpcOptionList,Map<String,Object> options);
	public SmartList<GrpcOption> findGrpcOptionWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countGrpcOptionWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countGrpcOptionWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String grpcOptionId, int version) throws Exception;
	public GrpcOption disconnectFromAll(String grpcOptionId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<GrpcOption> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<GrpcOption> findGrpcOptionByNode(String nodeId, Map<String,Object> options);
 	public int countGrpcOptionByNode(String nodeId, Map<String,Object> options);
 	public Map<String, Integer> countGrpcOptionByNodeIds(String[] ids, Map<String,Object> options);
 	public SmartList<GrpcOption> findGrpcOptionByNode(String nodeId, int start, int count, Map<String,Object> options);
 	public void analyzeGrpcOptionByNode(SmartList<GrpcOption> resultList, String nodeId, Map<String,Object> options);

 
 
}


