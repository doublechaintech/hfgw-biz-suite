
package com.doublechaintech.hfgw.chaincode;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.hfgw.BaseDAO;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;
import com.doublechaintech.hfgw.MultipleAccessKey;
import com.doublechaintech.hfgw.HfgwUserContext;

import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.servicerecord.ServiceRecord;
import com.doublechaintech.hfgw.chaincodeinvoker.ChainCodeInvoker;

import com.doublechaintech.hfgw.chaincodeinvoker.ChainCodeInvokerDAO;
import com.doublechaintech.hfgw.servicerecord.ServiceRecordDAO;
import com.doublechaintech.hfgw.channel.ChannelDAO;


public interface ChainCodeDAO extends BaseDAO{

	public SmartList<ChainCode> loadAll();
	public ChainCode load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ChainCode> chainCodeList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ChainCode present(ChainCode chainCode,Map<String,Object> options) throws Exception;
	public ChainCode clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ChainCode save(ChainCode chainCode,Map<String,Object> options);
	public SmartList<ChainCode> saveChainCodeList(SmartList<ChainCode> chainCodeList,Map<String,Object> options);
	public SmartList<ChainCode> removeChainCodeList(SmartList<ChainCode> chainCodeList,Map<String,Object> options);
	public SmartList<ChainCode> findChainCodeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countChainCodeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countChainCodeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String chainCodeId, int version) throws Exception;
	public ChainCode disconnectFromAll(String chainCodeId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ServiceRecordDAO getServiceRecordDAO();
		
	public ChainCodeInvokerDAO getChainCodeInvokerDAO();
		
	
 	public SmartList<ChainCode> requestCandidateChainCodeForServiceRecord(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<ChainCode> requestCandidateChainCodeForChainCodeInvoker(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public ChainCode planToRemoveServiceRecordList(ChainCode chainCode, String serviceRecordIds[], Map<String,Object> options)throws Exception;


	//disconnect ChainCode with transaction_id in ServiceRecord
	public ChainCode planToRemoveServiceRecordListWithTransactionId(ChainCode chainCode, String transactionIdId, Map<String,Object> options)throws Exception;
	public int countServiceRecordListWithTransactionId(String chainCodeId, String transactionIdId, Map<String,Object> options)throws Exception;
	
	//disconnect ChainCode with channel in ServiceRecord
	public ChainCode planToRemoveServiceRecordListWithChannel(ChainCode chainCode, String channelId, Map<String,Object> options)throws Exception;
	public int countServiceRecordListWithChannel(String chainCodeId, String channelId, Map<String,Object> options)throws Exception;
	
	//disconnect ChainCode with block_id in ServiceRecord
	public ChainCode planToRemoveServiceRecordListWithBlockId(ChainCode chainCode, String blockIdId, Map<String,Object> options)throws Exception;
	public int countServiceRecordListWithBlockId(String chainCodeId, String blockIdId, Map<String,Object> options)throws Exception;
	
	//disconnect ChainCode with app_client in ServiceRecord
	public ChainCode planToRemoveServiceRecordListWithAppClient(ChainCode chainCode, String appClientId, Map<String,Object> options)throws Exception;
	public int countServiceRecordListWithAppClient(String chainCodeId, String appClientId, Map<String,Object> options)throws Exception;
	
	//disconnect ChainCode with network in ServiceRecord
	public ChainCode planToRemoveServiceRecordListWithNetwork(ChainCode chainCode, String networkId, Map<String,Object> options)throws Exception;
	public int countServiceRecordListWithNetwork(String chainCodeId, String networkId, Map<String,Object> options)throws Exception;
	
	//disconnect ChainCode with status in ServiceRecord
	public ChainCode planToRemoveServiceRecordListWithStatus(ChainCode chainCode, String statusId, Map<String,Object> options)throws Exception;
	public int countServiceRecordListWithStatus(String chainCodeId, String statusId, Map<String,Object> options)throws Exception;
	
	public ChainCode planToRemoveChainCodeInvokerList(ChainCode chainCode, String chainCodeInvokerIds[], Map<String,Object> options)throws Exception;


	//disconnect ChainCode with app_client in ChainCodeInvoker
	public ChainCode planToRemoveChainCodeInvokerListWithAppClient(ChainCode chainCode, String appClientId, Map<String,Object> options)throws Exception;
	public int countChainCodeInvokerListWithAppClient(String chainCodeId, String appClientId, Map<String,Object> options)throws Exception;
	
	//disconnect ChainCode with change_request in ChainCodeInvoker
	public ChainCode planToRemoveChainCodeInvokerListWithChangeRequest(ChainCode chainCode, String changeRequestId, Map<String,Object> options)throws Exception;
	public int countChainCodeInvokerListWithChangeRequest(String chainCodeId, String changeRequestId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<ChainCode> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<ChainCode> findChainCodeByChannel(String channelId, Map<String,Object> options);
 	public int countChainCodeByChannel(String channelId, Map<String,Object> options);
 	public Map<String, Integer> countChainCodeByChannelIds(String[] ids, Map<String,Object> options);
 	public SmartList<ChainCode> findChainCodeByChannel(String channelId, int start, int count, Map<String,Object> options);
 	public void analyzeChainCodeByChannel(SmartList<ChainCode> resultList, String channelId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:ServiceRecord的chainCode的ServiceRecordList
	public SmartList<ServiceRecord> loadOurServiceRecordList(HfgwUserContext userContext, List<ChainCode> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:ChainCodeInvoker的chainCode的ChainCodeInvokerList
	public SmartList<ChainCodeInvoker> loadOurChainCodeInvokerList(HfgwUserContext userContext, List<ChainCode> us, Map<String,Object> options) throws Exception;
	
}


