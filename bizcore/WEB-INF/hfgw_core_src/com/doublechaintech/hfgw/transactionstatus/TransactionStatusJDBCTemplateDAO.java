
package com.doublechaintech.hfgw.transactionstatus;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import com.doublechaintech.hfgw.HfgwBaseDAOImpl;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;
import com.doublechaintech.hfgw.AccessKey;
import com.doublechaintech.hfgw.DateKey;
import com.doublechaintech.hfgw.StatsInfo;
import com.doublechaintech.hfgw.StatsItem;

import com.doublechaintech.hfgw.MultipleAccessKey;
import com.doublechaintech.hfgw.HfgwUserContext;


import com.doublechaintech.hfgw.servicerecord.ServiceRecord;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetworkDAO;
import com.doublechaintech.hfgw.servicerecord.ServiceRecordDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class TransactionStatusJDBCTemplateDAO extends HfgwBaseDAOImpl implements TransactionStatusDAO{
 
 	
 	private  HyperledgerNetworkDAO  hyperledgerNetworkDAO;
 	public void setHyperledgerNetworkDAO(HyperledgerNetworkDAO hyperledgerNetworkDAO){
	 	this.hyperledgerNetworkDAO = hyperledgerNetworkDAO;
 	}
 	public HyperledgerNetworkDAO getHyperledgerNetworkDAO(){
	 	return this.hyperledgerNetworkDAO;
 	}


			
		
	
  	private  ServiceRecordDAO  serviceRecordDAO;
 	public void setServiceRecordDAO(ServiceRecordDAO pServiceRecordDAO){
 	
 		if(pServiceRecordDAO == null){
 			throw new IllegalStateException("Do not try to set serviceRecordDAO to null.");
 		}
	 	this.serviceRecordDAO = pServiceRecordDAO;
 	}
 	public ServiceRecordDAO getServiceRecordDAO(){
 		if(this.serviceRecordDAO == null){
 			throw new IllegalStateException("The serviceRecordDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.serviceRecordDAO;
 	}	
 	
			
		

	
	/*
	protected TransactionStatus load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTransactionStatus(accessKey, options);
	}
	*/
	
	public SmartList<TransactionStatus> loadAll() {
	    return this.loadAll(getTransactionStatusMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public TransactionStatus load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTransactionStatus(TransactionStatusTable.withId(id), options);
	}
	
	
	
	public TransactionStatus loadByCode(String code,Map<String,Object> options) throws Exception{
		return loadInternalTransactionStatus(TransactionStatusTable.withCode( code), options);
	}
	
	
	public TransactionStatus save(TransactionStatus transactionStatus,Map<String,Object> options){
		
		String methodName="save(TransactionStatus transactionStatus,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(transactionStatus, methodName, "transactionStatus");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalTransactionStatus(transactionStatus,options);
	}
	public TransactionStatus clone(String transactionStatusId, Map<String,Object> options) throws Exception{
	
		return clone(TransactionStatusTable.withId(transactionStatusId),options);
	}
	
	protected TransactionStatus clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String transactionStatusId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		TransactionStatus newTransactionStatus = loadInternalTransactionStatus(accessKey, options);
		newTransactionStatus.setVersion(0);
		
		
 		
 		if(isSaveServiceRecordListEnabled(options)){
 			for(ServiceRecord item: newTransactionStatus.getServiceRecordList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalTransactionStatus(newTransactionStatus,options);
		
		return newTransactionStatus;
	}
	
	
	
	public TransactionStatus cloneByCode(String code,Map<String,Object> options) throws Exception{
		return clone(TransactionStatusTable.withCode( code), options);
	}
	
	
	

	protected void throwIfHasException(String transactionStatusId,int version,int count) throws Exception{
		if (count == 1) {
			throw new TransactionStatusVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TransactionStatusNotFoundException(
					"The " + this.getTableName() + "(" + transactionStatusId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String transactionStatusId, int version) throws Exception{
	
		String methodName="delete(String transactionStatusId, int version)";
		assertMethodArgumentNotNull(transactionStatusId, methodName, "transactionStatusId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{transactionStatusId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(transactionStatusId,version);
		}
		
	
	}
	
	
	
	
	

	public TransactionStatus disconnectFromAll(String transactionStatusId, int version) throws Exception{
	
		
		TransactionStatus transactionStatus = loadInternalTransactionStatus(TransactionStatusTable.withId(transactionStatusId), emptyOptions());
		transactionStatus.clearFromAll();
		this.saveTransactionStatus(transactionStatus);
		return transactionStatus;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return TransactionStatusTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "transaction_status";
	}
	@Override
	protected String getBeanName() {
		
		return "transactionStatus";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return TransactionStatusTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractNetworkEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TransactionStatusTokens.NETWORK);
 	}

 	protected boolean isSaveNetworkEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TransactionStatusTokens.NETWORK);
 	}
 	

 	
 
		
	
	protected boolean isExtractServiceRecordListEnabled(Map<String,Object> options){		
 		return checkOptions(options,TransactionStatusTokens.SERVICE_RECORD_LIST);
 	}
 	protected boolean isAnalyzeServiceRecordListEnabled(Map<String,Object> options){		 		
 		return TransactionStatusTokens.of(options).analyzeServiceRecordListEnabled();
 	}
	
	protected boolean isSaveServiceRecordListEnabled(Map<String,Object> options){
		return checkOptions(options, TransactionStatusTokens.SERVICE_RECORD_LIST);
		
 	}
 	
		

	

	protected TransactionStatusMapper getTransactionStatusMapper(){
		return new TransactionStatusMapper();
	}

	
	
	protected TransactionStatus extractTransactionStatus(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			TransactionStatus transactionStatus = loadSingleObject(accessKey, getTransactionStatusMapper());
			return transactionStatus;
		}catch(EmptyResultDataAccessException e){
			throw new TransactionStatusNotFoundException("TransactionStatus("+accessKey+") is not found!");
		}

	}

	
	

	protected TransactionStatus loadInternalTransactionStatus(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		TransactionStatus transactionStatus = extractTransactionStatus(accessKey, loadOptions);
 	
 		if(isExtractNetworkEnabled(loadOptions)){
	 		extractNetwork(transactionStatus, loadOptions);
 		}
 
		
		if(isExtractServiceRecordListEnabled(loadOptions)){
	 		extractServiceRecordList(transactionStatus, loadOptions);
 		}	
 		if(isAnalyzeServiceRecordListEnabled(loadOptions)){
	 		analyzeServiceRecordList(transactionStatus, loadOptions);
 		}
 		
		
		return transactionStatus;
		
	}

	 

 	protected TransactionStatus extractNetwork(TransactionStatus transactionStatus, Map<String,Object> options) throws Exception{

		if(transactionStatus.getNetwork() == null){
			return transactionStatus;
		}
		String networkId = transactionStatus.getNetwork().getId();
		if( networkId == null){
			return transactionStatus;
		}
		HyperledgerNetwork network = getHyperledgerNetworkDAO().load(networkId,options);
		if(network != null){
			transactionStatus.setNetwork(network);
		}
		
 		
 		return transactionStatus;
 	}
 		
 
		
	protected void enhanceServiceRecordList(SmartList<ServiceRecord> serviceRecordList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected TransactionStatus extractServiceRecordList(TransactionStatus transactionStatus, Map<String,Object> options){
		
		
		if(transactionStatus == null){
			return null;
		}
		if(transactionStatus.getId() == null){
			return transactionStatus;
		}

		
		
		SmartList<ServiceRecord> serviceRecordList = getServiceRecordDAO().findServiceRecordByStatus(transactionStatus.getId(),options);
		if(serviceRecordList != null){
			enhanceServiceRecordList(serviceRecordList,options);
			transactionStatus.setServiceRecordList(serviceRecordList);
		}
		
		return transactionStatus;
	
	}	
	
	protected TransactionStatus analyzeServiceRecordList(TransactionStatus transactionStatus, Map<String,Object> options){
		
		
		if(transactionStatus == null){
			return null;
		}
		if(transactionStatus.getId() == null){
			return transactionStatus;
		}

		
		
		SmartList<ServiceRecord> serviceRecordList = transactionStatus.getServiceRecordList();
		if(serviceRecordList != null){
			getServiceRecordDAO().analyzeServiceRecordByStatus(serviceRecordList, transactionStatus.getId(), options);
			
		}
		
		return transactionStatus;
	
	}	
	
		
		
  	
 	public SmartList<TransactionStatus> findTransactionStatusByNetwork(String hyperledgerNetworkId,Map<String,Object> options){
 	
  		SmartList<TransactionStatus> resultList = queryWith(TransactionStatusTable.COLUMN_NETWORK, hyperledgerNetworkId, options, getTransactionStatusMapper());
		// analyzeTransactionStatusByNetwork(resultList, hyperledgerNetworkId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<TransactionStatus> findTransactionStatusByNetwork(String hyperledgerNetworkId, int start, int count,Map<String,Object> options){
 		
 		SmartList<TransactionStatus> resultList =  queryWithRange(TransactionStatusTable.COLUMN_NETWORK, hyperledgerNetworkId, options, getTransactionStatusMapper(), start, count);
 		//analyzeTransactionStatusByNetwork(resultList, hyperledgerNetworkId, options);
 		return resultList;
 		
 	}
 	public void analyzeTransactionStatusByNetwork(SmartList<TransactionStatus> resultList, String hyperledgerNetworkId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countTransactionStatusByNetwork(String hyperledgerNetworkId,Map<String,Object> options){

 		return countWith(TransactionStatusTable.COLUMN_NETWORK, hyperledgerNetworkId, options);
 	}
 	@Override
	public Map<String, Integer> countTransactionStatusByNetworkIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TransactionStatusTable.COLUMN_NETWORK, ids, options);
	}
 	
 	
		
		
		

	

	protected TransactionStatus saveTransactionStatus(TransactionStatus  transactionStatus){
		
		if(!transactionStatus.isChanged()){
			return transactionStatus;
		}
		
		
		String SQL=this.getSaveTransactionStatusSQL(transactionStatus);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTransactionStatusParameters(transactionStatus);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		transactionStatus.incVersion();
		return transactionStatus;
	
	}
	public SmartList<TransactionStatus> saveTransactionStatusList(SmartList<TransactionStatus> transactionStatusList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTransactionStatusList(transactionStatusList);
		
		batchTransactionStatusCreate((List<TransactionStatus>)lists[CREATE_LIST_INDEX]);
		
		batchTransactionStatusUpdate((List<TransactionStatus>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(TransactionStatus transactionStatus:transactionStatusList){
			if(transactionStatus.isChanged()){
				transactionStatus.incVersion();
			}
			
		
		}
		
		
		return transactionStatusList;
	}

	public SmartList<TransactionStatus> removeTransactionStatusList(SmartList<TransactionStatus> transactionStatusList,Map<String,Object> options){
		
		
		super.removeList(transactionStatusList, options);
		
		return transactionStatusList;
		
		
	}
	
	protected List<Object[]> prepareTransactionStatusBatchCreateArgs(List<TransactionStatus> transactionStatusList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransactionStatus transactionStatus:transactionStatusList ){
			Object [] parameters = prepareTransactionStatusCreateParameters(transactionStatus);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareTransactionStatusBatchUpdateArgs(List<TransactionStatus> transactionStatusList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransactionStatus transactionStatus:transactionStatusList ){
			if(!transactionStatus.isChanged()){
				continue;
			}
			Object [] parameters = prepareTransactionStatusUpdateParameters(transactionStatus);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchTransactionStatusCreate(List<TransactionStatus> transactionStatusList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTransactionStatusBatchCreateArgs(transactionStatusList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchTransactionStatusUpdate(List<TransactionStatus> transactionStatusList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTransactionStatusBatchUpdateArgs(transactionStatusList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitTransactionStatusList(List<TransactionStatus> transactionStatusList){
		
		List<TransactionStatus> transactionStatusCreateList=new ArrayList<TransactionStatus>();
		List<TransactionStatus> transactionStatusUpdateList=new ArrayList<TransactionStatus>();
		
		for(TransactionStatus transactionStatus: transactionStatusList){
			if(isUpdateRequest(transactionStatus)){
				transactionStatusUpdateList.add( transactionStatus);
				continue;
			}
			transactionStatusCreateList.add(transactionStatus);
		}
		
		return new Object[]{transactionStatusCreateList,transactionStatusUpdateList};
	}
	
	protected boolean isUpdateRequest(TransactionStatus transactionStatus){
 		return transactionStatus.getVersion() > 0;
 	}
 	protected String getSaveTransactionStatusSQL(TransactionStatus transactionStatus){
 		if(isUpdateRequest(transactionStatus)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveTransactionStatusParameters(TransactionStatus transactionStatus){
 		if(isUpdateRequest(transactionStatus) ){
 			return prepareTransactionStatusUpdateParameters(transactionStatus);
 		}
 		return prepareTransactionStatusCreateParameters(transactionStatus);
 	}
 	protected Object[] prepareTransactionStatusUpdateParameters(TransactionStatus transactionStatus){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = transactionStatus.getName();
 		parameters[1] = transactionStatus.getCode(); 	
 		if(transactionStatus.getNetwork() != null){
 			parameters[2] = transactionStatus.getNetwork().getId();
 		}
 		
 		parameters[3] = transactionStatus.nextVersion();
 		parameters[4] = transactionStatus.getId();
 		parameters[5] = transactionStatus.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareTransactionStatusCreateParameters(TransactionStatus transactionStatus){
		Object[] parameters = new Object[4];
		String newTransactionStatusId=getNextId();
		transactionStatus.setId(newTransactionStatusId);
		parameters[0] =  transactionStatus.getId();
 
 		parameters[1] = transactionStatus.getName();
 		parameters[2] = transactionStatus.getCode(); 	
 		if(transactionStatus.getNetwork() != null){
 			parameters[3] = transactionStatus.getNetwork().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected TransactionStatus saveInternalTransactionStatus(TransactionStatus transactionStatus, Map<String,Object> options){
		
		saveTransactionStatus(transactionStatus);
 	
 		if(isSaveNetworkEnabled(options)){
	 		saveNetwork(transactionStatus, options);
 		}
 
		
		if(isSaveServiceRecordListEnabled(options)){
	 		saveServiceRecordList(transactionStatus, options);
	 		//removeServiceRecordList(transactionStatus, options);
	 		//Not delete the record
	 		
 		}		
		
		return transactionStatus;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected TransactionStatus saveNetwork(TransactionStatus transactionStatus, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(transactionStatus.getNetwork() == null){
 			return transactionStatus;//do nothing when it is null
 		}
 		
 		getHyperledgerNetworkDAO().save(transactionStatus.getNetwork(),options);
 		return transactionStatus;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public TransactionStatus planToRemoveServiceRecordList(TransactionStatus transactionStatus, String serviceRecordIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.STATUS_PROPERTY, transactionStatus.getId());
		key.put(ServiceRecord.ID_PROPERTY, serviceRecordIds);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return transactionStatus;
		}
		if(externalServiceRecordList.isEmpty()){
			return transactionStatus;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){

			serviceRecordItem.clearFromAll();
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = transactionStatus.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return transactionStatus;	
	
	}


	//disconnect TransactionStatus with channel in ServiceRecord
	public TransactionStatus planToRemoveServiceRecordListWithChannel(TransactionStatus transactionStatus, String channelId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.STATUS_PROPERTY, transactionStatus.getId());
		key.put(ServiceRecord.CHANNEL_PROPERTY, channelId);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return transactionStatus;
		}
		if(externalServiceRecordList.isEmpty()){
			return transactionStatus;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){
			serviceRecordItem.clearChannel();
			serviceRecordItem.clearStatus();
			
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = transactionStatus.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return transactionStatus;
	}
	
	public int countServiceRecordListWithChannel(String transactionStatusId, String channelId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.STATUS_PROPERTY, transactionStatusId);
		key.put(ServiceRecord.CHANNEL_PROPERTY, channelId);
		
		int count = getServiceRecordDAO().countServiceRecordWithKey(key, options);
		return count;
	}
	
	//disconnect TransactionStatus with chain_code in ServiceRecord
	public TransactionStatus planToRemoveServiceRecordListWithChainCode(TransactionStatus transactionStatus, String chainCodeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.STATUS_PROPERTY, transactionStatus.getId());
		key.put(ServiceRecord.CHAIN_CODE_PROPERTY, chainCodeId);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return transactionStatus;
		}
		if(externalServiceRecordList.isEmpty()){
			return transactionStatus;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){
			serviceRecordItem.clearChainCode();
			serviceRecordItem.clearStatus();
			
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = transactionStatus.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return transactionStatus;
	}
	
	public int countServiceRecordListWithChainCode(String transactionStatusId, String chainCodeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.STATUS_PROPERTY, transactionStatusId);
		key.put(ServiceRecord.CHAIN_CODE_PROPERTY, chainCodeId);
		
		int count = getServiceRecordDAO().countServiceRecordWithKey(key, options);
		return count;
	}
	
	//disconnect TransactionStatus with transaction_id in ServiceRecord
	public TransactionStatus planToRemoveServiceRecordListWithTransactionId(TransactionStatus transactionStatus, String transactionIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.STATUS_PROPERTY, transactionStatus.getId());
		key.put(ServiceRecord.TRANSACTION_ID_PROPERTY, transactionIdId);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return transactionStatus;
		}
		if(externalServiceRecordList.isEmpty()){
			return transactionStatus;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){
			serviceRecordItem.clearTransactionId();
			serviceRecordItem.clearStatus();
			
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = transactionStatus.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return transactionStatus;
	}
	
	public int countServiceRecordListWithTransactionId(String transactionStatusId, String transactionIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.STATUS_PROPERTY, transactionStatusId);
		key.put(ServiceRecord.TRANSACTION_ID_PROPERTY, transactionIdId);
		
		int count = getServiceRecordDAO().countServiceRecordWithKey(key, options);
		return count;
	}
	
	//disconnect TransactionStatus with block_id in ServiceRecord
	public TransactionStatus planToRemoveServiceRecordListWithBlockId(TransactionStatus transactionStatus, String blockIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.STATUS_PROPERTY, transactionStatus.getId());
		key.put(ServiceRecord.BLOCK_ID_PROPERTY, blockIdId);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return transactionStatus;
		}
		if(externalServiceRecordList.isEmpty()){
			return transactionStatus;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){
			serviceRecordItem.clearBlockId();
			serviceRecordItem.clearStatus();
			
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = transactionStatus.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return transactionStatus;
	}
	
	public int countServiceRecordListWithBlockId(String transactionStatusId, String blockIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.STATUS_PROPERTY, transactionStatusId);
		key.put(ServiceRecord.BLOCK_ID_PROPERTY, blockIdId);
		
		int count = getServiceRecordDAO().countServiceRecordWithKey(key, options);
		return count;
	}
	
	//disconnect TransactionStatus with app_client in ServiceRecord
	public TransactionStatus planToRemoveServiceRecordListWithAppClient(TransactionStatus transactionStatus, String appClientId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.STATUS_PROPERTY, transactionStatus.getId());
		key.put(ServiceRecord.APP_CLIENT_PROPERTY, appClientId);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return transactionStatus;
		}
		if(externalServiceRecordList.isEmpty()){
			return transactionStatus;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){
			serviceRecordItem.clearAppClient();
			serviceRecordItem.clearStatus();
			
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = transactionStatus.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return transactionStatus;
	}
	
	public int countServiceRecordListWithAppClient(String transactionStatusId, String appClientId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.STATUS_PROPERTY, transactionStatusId);
		key.put(ServiceRecord.APP_CLIENT_PROPERTY, appClientId);
		
		int count = getServiceRecordDAO().countServiceRecordWithKey(key, options);
		return count;
	}
	
	//disconnect TransactionStatus with network in ServiceRecord
	public TransactionStatus planToRemoveServiceRecordListWithNetwork(TransactionStatus transactionStatus, String networkId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.STATUS_PROPERTY, transactionStatus.getId());
		key.put(ServiceRecord.NETWORK_PROPERTY, networkId);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return transactionStatus;
		}
		if(externalServiceRecordList.isEmpty()){
			return transactionStatus;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){
			serviceRecordItem.clearNetwork();
			serviceRecordItem.clearStatus();
			
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = transactionStatus.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return transactionStatus;
	}
	
	public int countServiceRecordListWithNetwork(String transactionStatusId, String networkId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.STATUS_PROPERTY, transactionStatusId);
		key.put(ServiceRecord.NETWORK_PROPERTY, networkId);
		
		int count = getServiceRecordDAO().countServiceRecordWithKey(key, options);
		return count;
	}
	

		
	protected TransactionStatus saveServiceRecordList(TransactionStatus transactionStatus, Map<String,Object> options){
		
		
		
		
		SmartList<ServiceRecord> serviceRecordList = transactionStatus.getServiceRecordList();
		if(serviceRecordList == null){
			//null list means nothing
			return transactionStatus;
		}
		SmartList<ServiceRecord> mergedUpdateServiceRecordList = new SmartList<ServiceRecord>();
		
		
		mergedUpdateServiceRecordList.addAll(serviceRecordList); 
		if(serviceRecordList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateServiceRecordList.addAll(serviceRecordList.getToRemoveList());
			serviceRecordList.removeAll(serviceRecordList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getServiceRecordDAO().saveServiceRecordList(mergedUpdateServiceRecordList,options);
		
		if(serviceRecordList.getToRemoveList() != null){
			serviceRecordList.removeAll(serviceRecordList.getToRemoveList());
		}
		
		
		return transactionStatus;
	
	}
	
	protected TransactionStatus removeServiceRecordList(TransactionStatus transactionStatus, Map<String,Object> options){
	
	
		SmartList<ServiceRecord> serviceRecordList = transactionStatus.getServiceRecordList();
		if(serviceRecordList == null){
			return transactionStatus;
		}	
	
		SmartList<ServiceRecord> toRemoveServiceRecordList = serviceRecordList.getToRemoveList();
		
		if(toRemoveServiceRecordList == null){
			return transactionStatus;
		}
		if(toRemoveServiceRecordList.isEmpty()){
			return transactionStatus;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getServiceRecordDAO().removeServiceRecordList(toRemoveServiceRecordList,options);
		
		return transactionStatus;
	
	}
	
	

 	
 	
	
	
	
		

	public TransactionStatus present(TransactionStatus transactionStatus,Map<String, Object> options){
	
		presentServiceRecordList(transactionStatus,options);

		return transactionStatus;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected TransactionStatus presentServiceRecordList(
			TransactionStatus transactionStatus,
			Map<String, Object> options) {

		SmartList<ServiceRecord> serviceRecordList = transactionStatus.getServiceRecordList();		
				SmartList<ServiceRecord> newList= presentSubList(transactionStatus.getId(),
				serviceRecordList,
				options,
				getServiceRecordDAO()::countServiceRecordByStatus,
				getServiceRecordDAO()::findServiceRecordByStatus
				);

		
		transactionStatus.setServiceRecordList(newList);
		

		return transactionStatus;
	}			
		

	
    public SmartList<TransactionStatus> requestCandidateTransactionStatusForServiceRecord(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(TransactionStatusTable.COLUMN_NAME, filterKey, pageNo, pageSize, getTransactionStatusMapper());
    }
		

	protected String getTableName(){
		return TransactionStatusTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<TransactionStatus> transactionStatusList) {		
		this.enhanceListInternal(transactionStatusList, this.getTransactionStatusMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:ServiceRecord的status的ServiceRecordList
	public SmartList<ServiceRecord> loadOurServiceRecordList(HfgwUserContext userContext, List<TransactionStatus> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.STATUS_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ServiceRecord> loadedObjs = userContext.getDAOGroup().getServiceRecordDAO().findServiceRecordWithKey(key, options);
		Map<String, List<ServiceRecord>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getStatus().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<ServiceRecord> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<ServiceRecord> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setServiceRecordList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<TransactionStatus> transactionStatusList = ownerEntity.collectRefsWithType(TransactionStatus.INTERNAL_TYPE);
		this.enhanceList(transactionStatusList);
		
	}
	
	@Override
	public SmartList<TransactionStatus> findTransactionStatusWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getTransactionStatusMapper());

	}
	@Override
	public int countTransactionStatusWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countTransactionStatusWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<TransactionStatus> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getTransactionStatusMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


