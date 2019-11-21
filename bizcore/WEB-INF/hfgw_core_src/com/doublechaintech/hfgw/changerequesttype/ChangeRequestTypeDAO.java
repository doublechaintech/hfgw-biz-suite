
package com.doublechaintech.hfgw.changerequesttype;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;
import com.doublechaintech.hfgw.MultipleAccessKey;
import com.doublechaintech.hfgw.HfgwUserContext;

import com.doublechaintech.hfgw.changerequest.ChangeRequest;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetworkDAO;
import com.doublechaintech.hfgw.changerequest.ChangeRequestDAO;


public interface ChangeRequestTypeDAO{

	public SmartList<ChangeRequestType> loadAll();
	public ChangeRequestType load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ChangeRequestType> changeRequestTypeList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ChangeRequestType loadByCode(String code,Map<String,Object> options) throws Exception;
	
	
	public ChangeRequestType present(ChangeRequestType changeRequestType,Map<String,Object> options) throws Exception;
	public ChangeRequestType clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ChangeRequestType cloneByCode(String code,Map<String,Object> options) throws Exception;
	
	
	public ChangeRequestType save(ChangeRequestType changeRequestType,Map<String,Object> options);
	public SmartList<ChangeRequestType> saveChangeRequestTypeList(SmartList<ChangeRequestType> changeRequestTypeList,Map<String,Object> options);
	public SmartList<ChangeRequestType> removeChangeRequestTypeList(SmartList<ChangeRequestType> changeRequestTypeList,Map<String,Object> options);
	public SmartList<ChangeRequestType> findChangeRequestTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countChangeRequestTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countChangeRequestTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String changeRequestTypeId, int version) throws Exception;
	public ChangeRequestType disconnectFromAll(String changeRequestTypeId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ChangeRequestDAO getChangeRequestDAO();
		
	
 	public SmartList<ChangeRequestType> requestCandidateChangeRequestTypeForChangeRequest(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public ChangeRequestType planToRemoveChangeRequestList(ChangeRequestType changeRequestType, String changeRequestIds[], Map<String,Object> options)throws Exception;


	//disconnect ChangeRequestType with network in ChangeRequest
	public ChangeRequestType planToRemoveChangeRequestListWithNetwork(ChangeRequestType changeRequestType, String networkId, Map<String,Object> options)throws Exception;
	public int countChangeRequestListWithNetwork(String changeRequestTypeId, String networkId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<ChangeRequestType> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<ChangeRequestType> findChangeRequestTypeByNetwork(String hyperledgerNetworkId, Map<String,Object> options);
 	public int countChangeRequestTypeByNetwork(String hyperledgerNetworkId, Map<String,Object> options);
 	public Map<String, Integer> countChangeRequestTypeByNetworkIds(String[] ids, Map<String,Object> options);
 	public SmartList<ChangeRequestType> findChangeRequestTypeByNetwork(String hyperledgerNetworkId, int start, int count, Map<String,Object> options);
 	public void analyzeChangeRequestTypeByNetwork(SmartList<ChangeRequestType> resultList, String hyperledgerNetworkId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:ChangeRequest的requestType的ChangeRequestList
	public SmartList<ChangeRequest> loadOurChangeRequestList(HfgwUserContext userContext, List<ChangeRequestType> us, Map<String,Object> options) throws Exception;
	
}


