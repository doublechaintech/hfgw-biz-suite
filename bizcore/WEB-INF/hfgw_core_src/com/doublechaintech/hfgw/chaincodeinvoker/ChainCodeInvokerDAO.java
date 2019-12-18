
package com.doublechaintech.hfgw.chaincodeinvoker;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.hfgw.BaseDAO;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;
import com.doublechaintech.hfgw.MultipleAccessKey;
import com.doublechaintech.hfgw.HfgwUserContext;

import com.doublechaintech.hfgw.chaincode.ChainCode;
import com.doublechaintech.hfgw.changerequest.ChangeRequest;
import com.doublechaintech.hfgw.application.Application;

import com.doublechaintech.hfgw.chaincode.ChainCodeDAO;
import com.doublechaintech.hfgw.changerequest.ChangeRequestDAO;
import com.doublechaintech.hfgw.application.ApplicationDAO;


public interface ChainCodeInvokerDAO extends BaseDAO{

	public SmartList<ChainCodeInvoker> loadAll();
	public ChainCodeInvoker load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ChainCodeInvoker> chainCodeInvokerList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ChainCodeInvoker present(ChainCodeInvoker chainCodeInvoker,Map<String,Object> options) throws Exception;
	public ChainCodeInvoker clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ChainCodeInvoker save(ChainCodeInvoker chainCodeInvoker,Map<String,Object> options);
	public SmartList<ChainCodeInvoker> saveChainCodeInvokerList(SmartList<ChainCodeInvoker> chainCodeInvokerList,Map<String,Object> options);
	public SmartList<ChainCodeInvoker> removeChainCodeInvokerList(SmartList<ChainCodeInvoker> chainCodeInvokerList,Map<String,Object> options);
	public SmartList<ChainCodeInvoker> findChainCodeInvokerWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countChainCodeInvokerWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countChainCodeInvokerWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String chainCodeInvokerId, int version) throws Exception;
	public ChainCodeInvoker disconnectFromAll(String chainCodeInvokerId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<ChainCodeInvoker> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<ChainCodeInvoker> findChainCodeInvokerByAppClient(String applicationId, Map<String,Object> options);
 	public int countChainCodeInvokerByAppClient(String applicationId, Map<String,Object> options);
 	public Map<String, Integer> countChainCodeInvokerByAppClientIds(String[] ids, Map<String,Object> options);
 	public SmartList<ChainCodeInvoker> findChainCodeInvokerByAppClient(String applicationId, int start, int count, Map<String,Object> options);
 	public void analyzeChainCodeInvokerByAppClient(SmartList<ChainCodeInvoker> resultList, String applicationId, Map<String,Object> options);

 
  
 	public SmartList<ChainCodeInvoker> findChainCodeInvokerByChainCode(String chainCodeId, Map<String,Object> options);
 	public int countChainCodeInvokerByChainCode(String chainCodeId, Map<String,Object> options);
 	public Map<String, Integer> countChainCodeInvokerByChainCodeIds(String[] ids, Map<String,Object> options);
 	public SmartList<ChainCodeInvoker> findChainCodeInvokerByChainCode(String chainCodeId, int start, int count, Map<String,Object> options);
 	public void analyzeChainCodeInvokerByChainCode(SmartList<ChainCodeInvoker> resultList, String chainCodeId, Map<String,Object> options);

 
  
 	public SmartList<ChainCodeInvoker> findChainCodeInvokerByChangeRequest(String changeRequestId, Map<String,Object> options);
 	public int countChainCodeInvokerByChangeRequest(String changeRequestId, Map<String,Object> options);
 	public Map<String, Integer> countChainCodeInvokerByChangeRequestIds(String[] ids, Map<String,Object> options);
 	public SmartList<ChainCodeInvoker> findChainCodeInvokerByChangeRequest(String changeRequestId, int start, int count, Map<String,Object> options);
 	public void analyzeChainCodeInvokerByChangeRequest(SmartList<ChainCodeInvoker> resultList, String changeRequestId, Map<String,Object> options);

 
 
}


