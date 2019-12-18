
package com.doublechaintech.hfgw.transactionstatus;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.hfgw.BaseDAO;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;
import com.doublechaintech.hfgw.MultipleAccessKey;
import com.doublechaintech.hfgw.HfgwUserContext;

import com.doublechaintech.hfgw.servicerecord.ServiceRecord;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetworkDAO;
import com.doublechaintech.hfgw.servicerecord.ServiceRecordDAO;


public interface TransactionStatusDAO extends BaseDAO{

	public SmartList<TransactionStatus> loadAll();
	public TransactionStatus load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<TransactionStatus> transactionStatusList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public TransactionStatus loadByCode(String code,Map<String,Object> options) throws Exception;
	
	
	public TransactionStatus present(TransactionStatus transactionStatus,Map<String,Object> options) throws Exception;
	public TransactionStatus clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public TransactionStatus cloneByCode(String code,Map<String,Object> options) throws Exception;
	
	
	public TransactionStatus save(TransactionStatus transactionStatus,Map<String,Object> options);
	public SmartList<TransactionStatus> saveTransactionStatusList(SmartList<TransactionStatus> transactionStatusList,Map<String,Object> options);
	public SmartList<TransactionStatus> removeTransactionStatusList(SmartList<TransactionStatus> transactionStatusList,Map<String,Object> options);
	public SmartList<TransactionStatus> findTransactionStatusWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countTransactionStatusWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countTransactionStatusWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String transactionStatusId, int version) throws Exception;
	public TransactionStatus disconnectFromAll(String transactionStatusId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ServiceRecordDAO getServiceRecordDAO();
		
	
 	public SmartList<TransactionStatus> requestCandidateTransactionStatusForServiceRecord(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public TransactionStatus planToRemoveServiceRecordList(TransactionStatus transactionStatus, String serviceRecordIds[], Map<String,Object> options)throws Exception;


	//disconnect TransactionStatus with transaction_id in ServiceRecord
	public TransactionStatus planToRemoveServiceRecordListWithTransactionId(TransactionStatus transactionStatus, String transactionIdId, Map<String,Object> options)throws Exception;
	public int countServiceRecordListWithTransactionId(String transactionStatusId, String transactionIdId, Map<String,Object> options)throws Exception;
	
	//disconnect TransactionStatus with channel in ServiceRecord
	public TransactionStatus planToRemoveServiceRecordListWithChannel(TransactionStatus transactionStatus, String channelId, Map<String,Object> options)throws Exception;
	public int countServiceRecordListWithChannel(String transactionStatusId, String channelId, Map<String,Object> options)throws Exception;
	
	//disconnect TransactionStatus with chain_code in ServiceRecord
	public TransactionStatus planToRemoveServiceRecordListWithChainCode(TransactionStatus transactionStatus, String chainCodeId, Map<String,Object> options)throws Exception;
	public int countServiceRecordListWithChainCode(String transactionStatusId, String chainCodeId, Map<String,Object> options)throws Exception;
	
	//disconnect TransactionStatus with block_id in ServiceRecord
	public TransactionStatus planToRemoveServiceRecordListWithBlockId(TransactionStatus transactionStatus, String blockIdId, Map<String,Object> options)throws Exception;
	public int countServiceRecordListWithBlockId(String transactionStatusId, String blockIdId, Map<String,Object> options)throws Exception;
	
	//disconnect TransactionStatus with app_client in ServiceRecord
	public TransactionStatus planToRemoveServiceRecordListWithAppClient(TransactionStatus transactionStatus, String appClientId, Map<String,Object> options)throws Exception;
	public int countServiceRecordListWithAppClient(String transactionStatusId, String appClientId, Map<String,Object> options)throws Exception;
	
	//disconnect TransactionStatus with network in ServiceRecord
	public TransactionStatus planToRemoveServiceRecordListWithNetwork(TransactionStatus transactionStatus, String networkId, Map<String,Object> options)throws Exception;
	public int countServiceRecordListWithNetwork(String transactionStatusId, String networkId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<TransactionStatus> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<TransactionStatus> findTransactionStatusByNetwork(String hyperledgerNetworkId, Map<String,Object> options);
 	public int countTransactionStatusByNetwork(String hyperledgerNetworkId, Map<String,Object> options);
 	public Map<String, Integer> countTransactionStatusByNetworkIds(String[] ids, Map<String,Object> options);
 	public SmartList<TransactionStatus> findTransactionStatusByNetwork(String hyperledgerNetworkId, int start, int count, Map<String,Object> options);
 	public void analyzeTransactionStatusByNetwork(SmartList<TransactionStatus> resultList, String hyperledgerNetworkId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:ServiceRecord的status的ServiceRecordList
	public SmartList<ServiceRecord> loadOurServiceRecordList(HfgwUserContext userContext, List<TransactionStatus> us, Map<String,Object> options) throws Exception;
	
}


