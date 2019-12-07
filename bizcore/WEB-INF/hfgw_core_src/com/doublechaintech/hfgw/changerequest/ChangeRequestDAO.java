
package com.doublechaintech.hfgw.changerequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.hfgw.BaseDAO;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;
import com.doublechaintech.hfgw.MultipleAccessKey;
import com.doublechaintech.hfgw.HfgwUserContext;

import com.doublechaintech.hfgw.changerequesttype.ChangeRequestType;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;
import com.doublechaintech.hfgw.chaincodeinvoker.ChainCodeInvoker;

import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetworkDAO;
import com.doublechaintech.hfgw.chaincodeinvoker.ChainCodeInvokerDAO;
import com.doublechaintech.hfgw.changerequesttype.ChangeRequestTypeDAO;


public interface ChangeRequestDAO extends BaseDAO{

	public SmartList<ChangeRequest> loadAll();
	public ChangeRequest load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ChangeRequest> changeRequestList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ChangeRequest present(ChangeRequest changeRequest,Map<String,Object> options) throws Exception;
	public ChangeRequest clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ChangeRequest save(ChangeRequest changeRequest,Map<String,Object> options);
	public SmartList<ChangeRequest> saveChangeRequestList(SmartList<ChangeRequest> changeRequestList,Map<String,Object> options);
	public SmartList<ChangeRequest> removeChangeRequestList(SmartList<ChangeRequest> changeRequestList,Map<String,Object> options);
	public SmartList<ChangeRequest> findChangeRequestWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countChangeRequestWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countChangeRequestWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String changeRequestId, int version) throws Exception;
	public ChangeRequest disconnectFromAll(String changeRequestId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ChainCodeInvokerDAO getChainCodeInvokerDAO();
		
	
 	public SmartList<ChangeRequest> requestCandidateChangeRequestForChainCodeInvoker(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public ChangeRequest planToRemoveChainCodeInvokerList(ChangeRequest changeRequest, String chainCodeInvokerIds[], Map<String,Object> options)throws Exception;


	//disconnect ChangeRequest with app_client in ChainCodeInvoker
	public ChangeRequest planToRemoveChainCodeInvokerListWithAppClient(ChangeRequest changeRequest, String appClientId, Map<String,Object> options)throws Exception;
	public int countChainCodeInvokerListWithAppClient(String changeRequestId, String appClientId, Map<String,Object> options)throws Exception;
	
	//disconnect ChangeRequest with chain_code in ChainCodeInvoker
	public ChangeRequest planToRemoveChainCodeInvokerListWithChainCode(ChangeRequest changeRequest, String chainCodeId, Map<String,Object> options)throws Exception;
	public int countChainCodeInvokerListWithChainCode(String changeRequestId, String chainCodeId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<ChangeRequest> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<ChangeRequest> findChangeRequestByRequestType(String changeRequestTypeId, Map<String,Object> options);
 	public int countChangeRequestByRequestType(String changeRequestTypeId, Map<String,Object> options);
 	public Map<String, Integer> countChangeRequestByRequestTypeIds(String[] ids, Map<String,Object> options);
 	public SmartList<ChangeRequest> findChangeRequestByRequestType(String changeRequestTypeId, int start, int count, Map<String,Object> options);
 	public void analyzeChangeRequestByRequestType(SmartList<ChangeRequest> resultList, String changeRequestTypeId, Map<String,Object> options);

 
  
 	public SmartList<ChangeRequest> findChangeRequestByNetwork(String hyperledgerNetworkId, Map<String,Object> options);
 	public int countChangeRequestByNetwork(String hyperledgerNetworkId, Map<String,Object> options);
 	public Map<String, Integer> countChangeRequestByNetworkIds(String[] ids, Map<String,Object> options);
 	public SmartList<ChangeRequest> findChangeRequestByNetwork(String hyperledgerNetworkId, int start, int count, Map<String,Object> options);
 	public void analyzeChangeRequestByNetwork(SmartList<ChangeRequest> resultList, String hyperledgerNetworkId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:ChainCodeInvoker的changeRequest的ChainCodeInvokerList
	public SmartList<ChainCodeInvoker> loadOurChainCodeInvokerList(HfgwUserContext userContext, List<ChangeRequest> us, Map<String,Object> options) throws Exception;
	
}


