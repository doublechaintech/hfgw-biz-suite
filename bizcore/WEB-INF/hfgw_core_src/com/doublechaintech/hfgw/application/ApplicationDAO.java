
package com.doublechaintech.hfgw.application;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;
import com.doublechaintech.hfgw.MultipleAccessKey;
import com.doublechaintech.hfgw.HfgwUserContext;

import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.servicerecord.ServiceRecord;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetworkDAO;
import com.doublechaintech.hfgw.servicerecord.ServiceRecordDAO;
import com.doublechaintech.hfgw.channel.ChannelDAO;


public interface ApplicationDAO{

	public SmartList<Application> loadAll();
	public Application load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Application> applicationList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Application present(Application application,Map<String,Object> options) throws Exception;
	public Application clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Application save(Application application,Map<String,Object> options);
	public SmartList<Application> saveApplicationList(SmartList<Application> applicationList,Map<String,Object> options);
	public SmartList<Application> removeApplicationList(SmartList<Application> applicationList,Map<String,Object> options);
	public SmartList<Application> findApplicationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countApplicationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countApplicationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String applicationId, int version) throws Exception;
	public Application disconnectFromAll(String applicationId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ServiceRecordDAO getServiceRecordDAO();
		
	
 	public SmartList<Application> requestCandidateApplicationForServiceRecord(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Application planToRemoveServiceRecordList(Application application, String serviceRecordIds[], Map<String,Object> options)throws Exception;


	//disconnect Application with channel in ServiceRecord
	public Application planToRemoveServiceRecordListWithChannel(Application application, String channelId, Map<String,Object> options)throws Exception;
	public int countServiceRecordListWithChannel(String applicationId, String channelId, Map<String,Object> options)throws Exception;
	
	//disconnect Application with chain_code in ServiceRecord
	public Application planToRemoveServiceRecordListWithChainCode(Application application, String chainCodeId, Map<String,Object> options)throws Exception;
	public int countServiceRecordListWithChainCode(String applicationId, String chainCodeId, Map<String,Object> options)throws Exception;
	
	//disconnect Application with transaction_id in ServiceRecord
	public Application planToRemoveServiceRecordListWithTransactionId(Application application, String transactionIdId, Map<String,Object> options)throws Exception;
	public int countServiceRecordListWithTransactionId(String applicationId, String transactionIdId, Map<String,Object> options)throws Exception;
	
	//disconnect Application with block_id in ServiceRecord
	public Application planToRemoveServiceRecordListWithBlockId(Application application, String blockIdId, Map<String,Object> options)throws Exception;
	public int countServiceRecordListWithBlockId(String applicationId, String blockIdId, Map<String,Object> options)throws Exception;
	
	//disconnect Application with network in ServiceRecord
	public Application planToRemoveServiceRecordListWithNetwork(Application application, String networkId, Map<String,Object> options)throws Exception;
	public int countServiceRecordListWithNetwork(String applicationId, String networkId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Application> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<Application> findApplicationByChannel(String channelId, Map<String,Object> options);
 	public int countApplicationByChannel(String channelId, Map<String,Object> options);
 	public Map<String, Integer> countApplicationByChannelIds(String[] ids, Map<String,Object> options);
 	public SmartList<Application> findApplicationByChannel(String channelId, int start, int count, Map<String,Object> options);
 	public void analyzeApplicationByChannel(SmartList<Application> resultList, String channelId, Map<String,Object> options);

 
  
 	public SmartList<Application> findApplicationByNetwork(String hyperledgerNetworkId, Map<String,Object> options);
 	public int countApplicationByNetwork(String hyperledgerNetworkId, Map<String,Object> options);
 	public Map<String, Integer> countApplicationByNetworkIds(String[] ids, Map<String,Object> options);
 	public SmartList<Application> findApplicationByNetwork(String hyperledgerNetworkId, int start, int count, Map<String,Object> options);
 	public void analyzeApplicationByNetwork(SmartList<Application> resultList, String hyperledgerNetworkId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:ServiceRecord的application的ServiceRecordList
	public SmartList<ServiceRecord> loadOurServiceRecordList(HfgwUserContext userContext, List<Application> us, Map<String,Object> options) throws Exception;
	
}


