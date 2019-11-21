
package com.doublechaintech.hfgw.servicerecord;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;
import com.doublechaintech.hfgw.MultipleAccessKey;
import com.doublechaintech.hfgw.HfgwUserContext;

import com.doublechaintech.hfgw.chaincode.ChainCode;
import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.application.Application;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetworkDAO;
import com.doublechaintech.hfgw.channel.ChannelDAO;
import com.doublechaintech.hfgw.chaincode.ChainCodeDAO;
import com.doublechaintech.hfgw.application.ApplicationDAO;


public interface ServiceRecordDAO{

	public SmartList<ServiceRecord> loadAll();
	public ServiceRecord load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ServiceRecord> serviceRecordList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ServiceRecord present(ServiceRecord serviceRecord,Map<String,Object> options) throws Exception;
	public ServiceRecord clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ServiceRecord save(ServiceRecord serviceRecord,Map<String,Object> options);
	public SmartList<ServiceRecord> saveServiceRecordList(SmartList<ServiceRecord> serviceRecordList,Map<String,Object> options);
	public SmartList<ServiceRecord> removeServiceRecordList(SmartList<ServiceRecord> serviceRecordList,Map<String,Object> options);
	public SmartList<ServiceRecord> findServiceRecordWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countServiceRecordWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countServiceRecordWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String serviceRecordId, int version) throws Exception;
	public ServiceRecord disconnectFromAll(String serviceRecordId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<ServiceRecord> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<ServiceRecord> findServiceRecordByChannel(String channelId, Map<String,Object> options);
 	public int countServiceRecordByChannel(String channelId, Map<String,Object> options);
 	public Map<String, Integer> countServiceRecordByChannelIds(String[] ids, Map<String,Object> options);
 	public SmartList<ServiceRecord> findServiceRecordByChannel(String channelId, int start, int count, Map<String,Object> options);
 	public void analyzeServiceRecordByChannel(SmartList<ServiceRecord> resultList, String channelId, Map<String,Object> options);

 
  
 	public SmartList<ServiceRecord> findServiceRecordByChainCode(String chainCodeId, Map<String,Object> options);
 	public int countServiceRecordByChainCode(String chainCodeId, Map<String,Object> options);
 	public Map<String, Integer> countServiceRecordByChainCodeIds(String[] ids, Map<String,Object> options);
 	public SmartList<ServiceRecord> findServiceRecordByChainCode(String chainCodeId, int start, int count, Map<String,Object> options);
 	public void analyzeServiceRecordByChainCode(SmartList<ServiceRecord> resultList, String chainCodeId, Map<String,Object> options);

 
  
 	public SmartList<ServiceRecord> findServiceRecordByApplication(String applicationId, Map<String,Object> options);
 	public int countServiceRecordByApplication(String applicationId, Map<String,Object> options);
 	public Map<String, Integer> countServiceRecordByApplicationIds(String[] ids, Map<String,Object> options);
 	public SmartList<ServiceRecord> findServiceRecordByApplication(String applicationId, int start, int count, Map<String,Object> options);
 	public void analyzeServiceRecordByApplication(SmartList<ServiceRecord> resultList, String applicationId, Map<String,Object> options);

 
  
 	public SmartList<ServiceRecord> findServiceRecordByNetwork(String hyperledgerNetworkId, Map<String,Object> options);
 	public int countServiceRecordByNetwork(String hyperledgerNetworkId, Map<String,Object> options);
 	public Map<String, Integer> countServiceRecordByNetworkIds(String[] ids, Map<String,Object> options);
 	public SmartList<ServiceRecord> findServiceRecordByNetwork(String hyperledgerNetworkId, int start, int count, Map<String,Object> options);
 	public void analyzeServiceRecordByNetwork(SmartList<ServiceRecord> resultList, String hyperledgerNetworkId, Map<String,Object> options);

 
 
}


