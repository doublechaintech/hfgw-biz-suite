
package com.doublechaintech.hfgw.chaincode;

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


import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.servicerecord.ServiceRecord;
import com.doublechaintech.hfgw.chaincodeinvoker.ChainCodeInvoker;

import com.doublechaintech.hfgw.chaincodeinvoker.ChainCodeInvokerDAO;
import com.doublechaintech.hfgw.servicerecord.ServiceRecordDAO;
import com.doublechaintech.hfgw.channel.ChannelDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class ChainCodeJDBCTemplateDAO extends HfgwBaseDAOImpl implements ChainCodeDAO{
 
 	
 	private  ChannelDAO  channelDAO;
 	public void setChannelDAO(ChannelDAO channelDAO){
	 	this.channelDAO = channelDAO;
 	}
 	public ChannelDAO getChannelDAO(){
	 	return this.channelDAO;
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
 	
			
		
	
  	private  ChainCodeInvokerDAO  chainCodeInvokerDAO;
 	public void setChainCodeInvokerDAO(ChainCodeInvokerDAO pChainCodeInvokerDAO){
 	
 		if(pChainCodeInvokerDAO == null){
 			throw new IllegalStateException("Do not try to set chainCodeInvokerDAO to null.");
 		}
	 	this.chainCodeInvokerDAO = pChainCodeInvokerDAO;
 	}
 	public ChainCodeInvokerDAO getChainCodeInvokerDAO(){
 		if(this.chainCodeInvokerDAO == null){
 			throw new IllegalStateException("The chainCodeInvokerDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.chainCodeInvokerDAO;
 	}	
 	
			
		

	
	/*
	protected ChainCode load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalChainCode(accessKey, options);
	}
	*/
	
	public SmartList<ChainCode> loadAll() {
	    return this.loadAll(getChainCodeMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public ChainCode load(String id,Map<String,Object> options) throws Exception{
		return loadInternalChainCode(ChainCodeTable.withId(id), options);
	}
	
	
	
	public ChainCode save(ChainCode chainCode,Map<String,Object> options){
		
		String methodName="save(ChainCode chainCode,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(chainCode, methodName, "chainCode");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalChainCode(chainCode,options);
	}
	public ChainCode clone(String chainCodeId, Map<String,Object> options) throws Exception{
	
		return clone(ChainCodeTable.withId(chainCodeId),options);
	}
	
	protected ChainCode clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String chainCodeId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ChainCode newChainCode = loadInternalChainCode(accessKey, options);
		newChainCode.setVersion(0);
		
		
 		
 		if(isSaveServiceRecordListEnabled(options)){
 			for(ServiceRecord item: newChainCode.getServiceRecordList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveChainCodeInvokerListEnabled(options)){
 			for(ChainCodeInvoker item: newChainCode.getChainCodeInvokerList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalChainCode(newChainCode,options);
		
		return newChainCode;
	}
	
	
	
	

	protected void throwIfHasException(String chainCodeId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ChainCodeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ChainCodeNotFoundException(
					"The " + this.getTableName() + "(" + chainCodeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String chainCodeId, int version) throws Exception{
	
		String methodName="delete(String chainCodeId, int version)";
		assertMethodArgumentNotNull(chainCodeId, methodName, "chainCodeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{chainCodeId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(chainCodeId,version);
		}
		
	
	}
	
	
	
	
	

	public ChainCode disconnectFromAll(String chainCodeId, int version) throws Exception{
	
		
		ChainCode chainCode = loadInternalChainCode(ChainCodeTable.withId(chainCodeId), emptyOptions());
		chainCode.clearFromAll();
		this.saveChainCode(chainCode);
		return chainCode;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ChainCodeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "chain_code";
	}
	@Override
	protected String getBeanName() {
		
		return "chainCode";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ChainCodeTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractChannelEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ChainCodeTokens.CHANNEL);
 	}

 	protected boolean isSaveChannelEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ChainCodeTokens.CHANNEL);
 	}
 	

 	
 
		
	
	protected boolean isExtractServiceRecordListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ChainCodeTokens.SERVICE_RECORD_LIST);
 	}
 	protected boolean isAnalyzeServiceRecordListEnabled(Map<String,Object> options){		 		
 		return ChainCodeTokens.of(options).analyzeServiceRecordListEnabled();
 	}
	
	protected boolean isSaveServiceRecordListEnabled(Map<String,Object> options){
		return checkOptions(options, ChainCodeTokens.SERVICE_RECORD_LIST);
		
 	}
 	
		
	
	protected boolean isExtractChainCodeInvokerListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ChainCodeTokens.CHAIN_CODE_INVOKER_LIST);
 	}
 	protected boolean isAnalyzeChainCodeInvokerListEnabled(Map<String,Object> options){		 		
 		return ChainCodeTokens.of(options).analyzeChainCodeInvokerListEnabled();
 	}
	
	protected boolean isSaveChainCodeInvokerListEnabled(Map<String,Object> options){
		return checkOptions(options, ChainCodeTokens.CHAIN_CODE_INVOKER_LIST);
		
 	}
 	
		

	

	protected ChainCodeMapper getChainCodeMapper(){
		return new ChainCodeMapper();
	}

	
	
	protected ChainCode extractChainCode(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ChainCode chainCode = loadSingleObject(accessKey, getChainCodeMapper());
			return chainCode;
		}catch(EmptyResultDataAccessException e){
			throw new ChainCodeNotFoundException("ChainCode("+accessKey+") is not found!");
		}

	}

	
	

	protected ChainCode loadInternalChainCode(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ChainCode chainCode = extractChainCode(accessKey, loadOptions);
 	
 		if(isExtractChannelEnabled(loadOptions)){
	 		extractChannel(chainCode, loadOptions);
 		}
 
		
		if(isExtractServiceRecordListEnabled(loadOptions)){
	 		extractServiceRecordList(chainCode, loadOptions);
 		}	
 		if(isAnalyzeServiceRecordListEnabled(loadOptions)){
	 		analyzeServiceRecordList(chainCode, loadOptions);
 		}
 		
		
		if(isExtractChainCodeInvokerListEnabled(loadOptions)){
	 		extractChainCodeInvokerList(chainCode, loadOptions);
 		}	
 		if(isAnalyzeChainCodeInvokerListEnabled(loadOptions)){
	 		analyzeChainCodeInvokerList(chainCode, loadOptions);
 		}
 		
		
		return chainCode;
		
	}

	 

 	protected ChainCode extractChannel(ChainCode chainCode, Map<String,Object> options) throws Exception{

		if(chainCode.getChannel() == null){
			return chainCode;
		}
		String channelId = chainCode.getChannel().getId();
		if( channelId == null){
			return chainCode;
		}
		Channel channel = getChannelDAO().load(channelId,options);
		if(channel != null){
			chainCode.setChannel(channel);
		}
		
 		
 		return chainCode;
 	}
 		
 
		
	protected void enhanceServiceRecordList(SmartList<ServiceRecord> serviceRecordList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected ChainCode extractServiceRecordList(ChainCode chainCode, Map<String,Object> options){
		
		
		if(chainCode == null){
			return null;
		}
		if(chainCode.getId() == null){
			return chainCode;
		}

		
		
		SmartList<ServiceRecord> serviceRecordList = getServiceRecordDAO().findServiceRecordByChainCode(chainCode.getId(),options);
		if(serviceRecordList != null){
			enhanceServiceRecordList(serviceRecordList,options);
			chainCode.setServiceRecordList(serviceRecordList);
		}
		
		return chainCode;
	
	}	
	
	protected ChainCode analyzeServiceRecordList(ChainCode chainCode, Map<String,Object> options){
		
		
		if(chainCode == null){
			return null;
		}
		if(chainCode.getId() == null){
			return chainCode;
		}

		
		
		SmartList<ServiceRecord> serviceRecordList = chainCode.getServiceRecordList();
		if(serviceRecordList != null){
			getServiceRecordDAO().analyzeServiceRecordByChainCode(serviceRecordList, chainCode.getId(), options);
			
		}
		
		return chainCode;
	
	}	
	
		
	protected void enhanceChainCodeInvokerList(SmartList<ChainCodeInvoker> chainCodeInvokerList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected ChainCode extractChainCodeInvokerList(ChainCode chainCode, Map<String,Object> options){
		
		
		if(chainCode == null){
			return null;
		}
		if(chainCode.getId() == null){
			return chainCode;
		}

		
		
		SmartList<ChainCodeInvoker> chainCodeInvokerList = getChainCodeInvokerDAO().findChainCodeInvokerByChainCode(chainCode.getId(),options);
		if(chainCodeInvokerList != null){
			enhanceChainCodeInvokerList(chainCodeInvokerList,options);
			chainCode.setChainCodeInvokerList(chainCodeInvokerList);
		}
		
		return chainCode;
	
	}	
	
	protected ChainCode analyzeChainCodeInvokerList(ChainCode chainCode, Map<String,Object> options){
		
		
		if(chainCode == null){
			return null;
		}
		if(chainCode.getId() == null){
			return chainCode;
		}

		
		
		SmartList<ChainCodeInvoker> chainCodeInvokerList = chainCode.getChainCodeInvokerList();
		if(chainCodeInvokerList != null){
			getChainCodeInvokerDAO().analyzeChainCodeInvokerByChainCode(chainCodeInvokerList, chainCode.getId(), options);
			
		}
		
		return chainCode;
	
	}	
	
		
		
  	
 	public SmartList<ChainCode> findChainCodeByChannel(String channelId,Map<String,Object> options){
 	
  		SmartList<ChainCode> resultList = queryWith(ChainCodeTable.COLUMN_CHANNEL, channelId, options, getChainCodeMapper());
		// analyzeChainCodeByChannel(resultList, channelId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ChainCode> findChainCodeByChannel(String channelId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ChainCode> resultList =  queryWithRange(ChainCodeTable.COLUMN_CHANNEL, channelId, options, getChainCodeMapper(), start, count);
 		//analyzeChainCodeByChannel(resultList, channelId, options);
 		return resultList;
 		
 	}
 	public void analyzeChainCodeByChannel(SmartList<ChainCode> resultList, String channelId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countChainCodeByChannel(String channelId,Map<String,Object> options){

 		return countWith(ChainCodeTable.COLUMN_CHANNEL, channelId, options);
 	}
 	@Override
	public Map<String, Integer> countChainCodeByChannelIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ChainCodeTable.COLUMN_CHANNEL, ids, options);
	}
 	
 	
		
		
		

	

	protected ChainCode saveChainCode(ChainCode  chainCode){
		
		if(!chainCode.isChanged()){
			return chainCode;
		}
		
		
		String SQL=this.getSaveChainCodeSQL(chainCode);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveChainCodeParameters(chainCode);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		chainCode.incVersion();
		return chainCode;
	
	}
	public SmartList<ChainCode> saveChainCodeList(SmartList<ChainCode> chainCodeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitChainCodeList(chainCodeList);
		
		batchChainCodeCreate((List<ChainCode>)lists[CREATE_LIST_INDEX]);
		
		batchChainCodeUpdate((List<ChainCode>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ChainCode chainCode:chainCodeList){
			if(chainCode.isChanged()){
				chainCode.incVersion();
			}
			
		
		}
		
		
		return chainCodeList;
	}

	public SmartList<ChainCode> removeChainCodeList(SmartList<ChainCode> chainCodeList,Map<String,Object> options){
		
		
		super.removeList(chainCodeList, options);
		
		return chainCodeList;
		
		
	}
	
	protected List<Object[]> prepareChainCodeBatchCreateArgs(List<ChainCode> chainCodeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ChainCode chainCode:chainCodeList ){
			Object [] parameters = prepareChainCodeCreateParameters(chainCode);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareChainCodeBatchUpdateArgs(List<ChainCode> chainCodeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ChainCode chainCode:chainCodeList ){
			if(!chainCode.isChanged()){
				continue;
			}
			Object [] parameters = prepareChainCodeUpdateParameters(chainCode);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchChainCodeCreate(List<ChainCode> chainCodeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareChainCodeBatchCreateArgs(chainCodeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchChainCodeUpdate(List<ChainCode> chainCodeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareChainCodeBatchUpdateArgs(chainCodeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitChainCodeList(List<ChainCode> chainCodeList){
		
		List<ChainCode> chainCodeCreateList=new ArrayList<ChainCode>();
		List<ChainCode> chainCodeUpdateList=new ArrayList<ChainCode>();
		
		for(ChainCode chainCode: chainCodeList){
			if(isUpdateRequest(chainCode)){
				chainCodeUpdateList.add( chainCode);
				continue;
			}
			chainCodeCreateList.add(chainCode);
		}
		
		return new Object[]{chainCodeCreateList,chainCodeUpdateList};
	}
	
	protected boolean isUpdateRequest(ChainCode chainCode){
 		return chainCode.getVersion() > 0;
 	}
 	protected String getSaveChainCodeSQL(ChainCode chainCode){
 		if(isUpdateRequest(chainCode)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveChainCodeParameters(ChainCode chainCode){
 		if(isUpdateRequest(chainCode) ){
 			return prepareChainCodeUpdateParameters(chainCode);
 		}
 		return prepareChainCodeCreateParameters(chainCode);
 	}
 	protected Object[] prepareChainCodeUpdateParameters(ChainCode chainCode){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = chainCode.getName();
 		parameters[1] = chainCode.getCodeName();
 		parameters[2] = chainCode.getCodeVersion(); 	
 		if(chainCode.getChannel() != null){
 			parameters[3] = chainCode.getChannel().getId();
 		}
 		
 		parameters[4] = chainCode.nextVersion();
 		parameters[5] = chainCode.getId();
 		parameters[6] = chainCode.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareChainCodeCreateParameters(ChainCode chainCode){
		Object[] parameters = new Object[5];
		String newChainCodeId=getNextId();
		chainCode.setId(newChainCodeId);
		parameters[0] =  chainCode.getId();
 
 		parameters[1] = chainCode.getName();
 		parameters[2] = chainCode.getCodeName();
 		parameters[3] = chainCode.getCodeVersion(); 	
 		if(chainCode.getChannel() != null){
 			parameters[4] = chainCode.getChannel().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected ChainCode saveInternalChainCode(ChainCode chainCode, Map<String,Object> options){
		
		saveChainCode(chainCode);
 	
 		if(isSaveChannelEnabled(options)){
	 		saveChannel(chainCode, options);
 		}
 
		
		if(isSaveServiceRecordListEnabled(options)){
	 		saveServiceRecordList(chainCode, options);
	 		//removeServiceRecordList(chainCode, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveChainCodeInvokerListEnabled(options)){
	 		saveChainCodeInvokerList(chainCode, options);
	 		//removeChainCodeInvokerList(chainCode, options);
	 		//Not delete the record
	 		
 		}		
		
		return chainCode;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ChainCode saveChannel(ChainCode chainCode, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(chainCode.getChannel() == null){
 			return chainCode;//do nothing when it is null
 		}
 		
 		getChannelDAO().save(chainCode.getChannel(),options);
 		return chainCode;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public ChainCode planToRemoveServiceRecordList(ChainCode chainCode, String serviceRecordIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.CHAIN_CODE_PROPERTY, chainCode.getId());
		key.put(ServiceRecord.ID_PROPERTY, serviceRecordIds);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return chainCode;
		}
		if(externalServiceRecordList.isEmpty()){
			return chainCode;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){

			serviceRecordItem.clearFromAll();
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = chainCode.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return chainCode;	
	
	}


	//disconnect ChainCode with transaction_id in ServiceRecord
	public ChainCode planToRemoveServiceRecordListWithTransactionId(ChainCode chainCode, String transactionIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.CHAIN_CODE_PROPERTY, chainCode.getId());
		key.put(ServiceRecord.TRANSACTION_ID_PROPERTY, transactionIdId);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return chainCode;
		}
		if(externalServiceRecordList.isEmpty()){
			return chainCode;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){
			serviceRecordItem.clearTransactionId();
			serviceRecordItem.clearChainCode();
			
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = chainCode.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return chainCode;
	}
	
	public int countServiceRecordListWithTransactionId(String chainCodeId, String transactionIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.CHAIN_CODE_PROPERTY, chainCodeId);
		key.put(ServiceRecord.TRANSACTION_ID_PROPERTY, transactionIdId);
		
		int count = getServiceRecordDAO().countServiceRecordWithKey(key, options);
		return count;
	}
	
	//disconnect ChainCode with channel in ServiceRecord
	public ChainCode planToRemoveServiceRecordListWithChannel(ChainCode chainCode, String channelId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.CHAIN_CODE_PROPERTY, chainCode.getId());
		key.put(ServiceRecord.CHANNEL_PROPERTY, channelId);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return chainCode;
		}
		if(externalServiceRecordList.isEmpty()){
			return chainCode;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){
			serviceRecordItem.clearChannel();
			serviceRecordItem.clearChainCode();
			
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = chainCode.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return chainCode;
	}
	
	public int countServiceRecordListWithChannel(String chainCodeId, String channelId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.CHAIN_CODE_PROPERTY, chainCodeId);
		key.put(ServiceRecord.CHANNEL_PROPERTY, channelId);
		
		int count = getServiceRecordDAO().countServiceRecordWithKey(key, options);
		return count;
	}
	
	//disconnect ChainCode with block_id in ServiceRecord
	public ChainCode planToRemoveServiceRecordListWithBlockId(ChainCode chainCode, String blockIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.CHAIN_CODE_PROPERTY, chainCode.getId());
		key.put(ServiceRecord.BLOCK_ID_PROPERTY, blockIdId);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return chainCode;
		}
		if(externalServiceRecordList.isEmpty()){
			return chainCode;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){
			serviceRecordItem.clearBlockId();
			serviceRecordItem.clearChainCode();
			
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = chainCode.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return chainCode;
	}
	
	public int countServiceRecordListWithBlockId(String chainCodeId, String blockIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.CHAIN_CODE_PROPERTY, chainCodeId);
		key.put(ServiceRecord.BLOCK_ID_PROPERTY, blockIdId);
		
		int count = getServiceRecordDAO().countServiceRecordWithKey(key, options);
		return count;
	}
	
	//disconnect ChainCode with app_client in ServiceRecord
	public ChainCode planToRemoveServiceRecordListWithAppClient(ChainCode chainCode, String appClientId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.CHAIN_CODE_PROPERTY, chainCode.getId());
		key.put(ServiceRecord.APP_CLIENT_PROPERTY, appClientId);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return chainCode;
		}
		if(externalServiceRecordList.isEmpty()){
			return chainCode;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){
			serviceRecordItem.clearAppClient();
			serviceRecordItem.clearChainCode();
			
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = chainCode.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return chainCode;
	}
	
	public int countServiceRecordListWithAppClient(String chainCodeId, String appClientId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.CHAIN_CODE_PROPERTY, chainCodeId);
		key.put(ServiceRecord.APP_CLIENT_PROPERTY, appClientId);
		
		int count = getServiceRecordDAO().countServiceRecordWithKey(key, options);
		return count;
	}
	
	//disconnect ChainCode with network in ServiceRecord
	public ChainCode planToRemoveServiceRecordListWithNetwork(ChainCode chainCode, String networkId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.CHAIN_CODE_PROPERTY, chainCode.getId());
		key.put(ServiceRecord.NETWORK_PROPERTY, networkId);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return chainCode;
		}
		if(externalServiceRecordList.isEmpty()){
			return chainCode;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){
			serviceRecordItem.clearNetwork();
			serviceRecordItem.clearChainCode();
			
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = chainCode.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return chainCode;
	}
	
	public int countServiceRecordListWithNetwork(String chainCodeId, String networkId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.CHAIN_CODE_PROPERTY, chainCodeId);
		key.put(ServiceRecord.NETWORK_PROPERTY, networkId);
		
		int count = getServiceRecordDAO().countServiceRecordWithKey(key, options);
		return count;
	}
	
	//disconnect ChainCode with status in ServiceRecord
	public ChainCode planToRemoveServiceRecordListWithStatus(ChainCode chainCode, String statusId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.CHAIN_CODE_PROPERTY, chainCode.getId());
		key.put(ServiceRecord.STATUS_PROPERTY, statusId);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return chainCode;
		}
		if(externalServiceRecordList.isEmpty()){
			return chainCode;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){
			serviceRecordItem.clearStatus();
			serviceRecordItem.clearChainCode();
			
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = chainCode.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return chainCode;
	}
	
	public int countServiceRecordListWithStatus(String chainCodeId, String statusId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.CHAIN_CODE_PROPERTY, chainCodeId);
		key.put(ServiceRecord.STATUS_PROPERTY, statusId);
		
		int count = getServiceRecordDAO().countServiceRecordWithKey(key, options);
		return count;
	}
	
	public ChainCode planToRemoveChainCodeInvokerList(ChainCode chainCode, String chainCodeInvokerIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChainCodeInvoker.CHAIN_CODE_PROPERTY, chainCode.getId());
		key.put(ChainCodeInvoker.ID_PROPERTY, chainCodeInvokerIds);
		
		SmartList<ChainCodeInvoker> externalChainCodeInvokerList = getChainCodeInvokerDAO().
				findChainCodeInvokerWithKey(key, options);
		if(externalChainCodeInvokerList == null){
			return chainCode;
		}
		if(externalChainCodeInvokerList.isEmpty()){
			return chainCode;
		}
		
		for(ChainCodeInvoker chainCodeInvokerItem: externalChainCodeInvokerList){

			chainCodeInvokerItem.clearFromAll();
		}
		
		
		SmartList<ChainCodeInvoker> chainCodeInvokerList = chainCode.getChainCodeInvokerList();		
		chainCodeInvokerList.addAllToRemoveList(externalChainCodeInvokerList);
		return chainCode;	
	
	}


	//disconnect ChainCode with app_client in ChainCodeInvoker
	public ChainCode planToRemoveChainCodeInvokerListWithAppClient(ChainCode chainCode, String appClientId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChainCodeInvoker.CHAIN_CODE_PROPERTY, chainCode.getId());
		key.put(ChainCodeInvoker.APP_CLIENT_PROPERTY, appClientId);
		
		SmartList<ChainCodeInvoker> externalChainCodeInvokerList = getChainCodeInvokerDAO().
				findChainCodeInvokerWithKey(key, options);
		if(externalChainCodeInvokerList == null){
			return chainCode;
		}
		if(externalChainCodeInvokerList.isEmpty()){
			return chainCode;
		}
		
		for(ChainCodeInvoker chainCodeInvokerItem: externalChainCodeInvokerList){
			chainCodeInvokerItem.clearAppClient();
			chainCodeInvokerItem.clearChainCode();
			
		}
		
		
		SmartList<ChainCodeInvoker> chainCodeInvokerList = chainCode.getChainCodeInvokerList();		
		chainCodeInvokerList.addAllToRemoveList(externalChainCodeInvokerList);
		return chainCode;
	}
	
	public int countChainCodeInvokerListWithAppClient(String chainCodeId, String appClientId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChainCodeInvoker.CHAIN_CODE_PROPERTY, chainCodeId);
		key.put(ChainCodeInvoker.APP_CLIENT_PROPERTY, appClientId);
		
		int count = getChainCodeInvokerDAO().countChainCodeInvokerWithKey(key, options);
		return count;
	}
	
	//disconnect ChainCode with change_request in ChainCodeInvoker
	public ChainCode planToRemoveChainCodeInvokerListWithChangeRequest(ChainCode chainCode, String changeRequestId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChainCodeInvoker.CHAIN_CODE_PROPERTY, chainCode.getId());
		key.put(ChainCodeInvoker.CHANGE_REQUEST_PROPERTY, changeRequestId);
		
		SmartList<ChainCodeInvoker> externalChainCodeInvokerList = getChainCodeInvokerDAO().
				findChainCodeInvokerWithKey(key, options);
		if(externalChainCodeInvokerList == null){
			return chainCode;
		}
		if(externalChainCodeInvokerList.isEmpty()){
			return chainCode;
		}
		
		for(ChainCodeInvoker chainCodeInvokerItem: externalChainCodeInvokerList){
			chainCodeInvokerItem.clearChangeRequest();
			chainCodeInvokerItem.clearChainCode();
			
		}
		
		
		SmartList<ChainCodeInvoker> chainCodeInvokerList = chainCode.getChainCodeInvokerList();		
		chainCodeInvokerList.addAllToRemoveList(externalChainCodeInvokerList);
		return chainCode;
	}
	
	public int countChainCodeInvokerListWithChangeRequest(String chainCodeId, String changeRequestId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChainCodeInvoker.CHAIN_CODE_PROPERTY, chainCodeId);
		key.put(ChainCodeInvoker.CHANGE_REQUEST_PROPERTY, changeRequestId);
		
		int count = getChainCodeInvokerDAO().countChainCodeInvokerWithKey(key, options);
		return count;
	}
	

		
	protected ChainCode saveServiceRecordList(ChainCode chainCode, Map<String,Object> options){
		
		
		
		
		SmartList<ServiceRecord> serviceRecordList = chainCode.getServiceRecordList();
		if(serviceRecordList == null){
			//null list means nothing
			return chainCode;
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
		
		
		return chainCode;
	
	}
	
	protected ChainCode removeServiceRecordList(ChainCode chainCode, Map<String,Object> options){
	
	
		SmartList<ServiceRecord> serviceRecordList = chainCode.getServiceRecordList();
		if(serviceRecordList == null){
			return chainCode;
		}	
	
		SmartList<ServiceRecord> toRemoveServiceRecordList = serviceRecordList.getToRemoveList();
		
		if(toRemoveServiceRecordList == null){
			return chainCode;
		}
		if(toRemoveServiceRecordList.isEmpty()){
			return chainCode;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getServiceRecordDAO().removeServiceRecordList(toRemoveServiceRecordList,options);
		
		return chainCode;
	
	}
	
	

 	
 	
	
	
	
		
	protected ChainCode saveChainCodeInvokerList(ChainCode chainCode, Map<String,Object> options){
		
		
		
		
		SmartList<ChainCodeInvoker> chainCodeInvokerList = chainCode.getChainCodeInvokerList();
		if(chainCodeInvokerList == null){
			//null list means nothing
			return chainCode;
		}
		SmartList<ChainCodeInvoker> mergedUpdateChainCodeInvokerList = new SmartList<ChainCodeInvoker>();
		
		
		mergedUpdateChainCodeInvokerList.addAll(chainCodeInvokerList); 
		if(chainCodeInvokerList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateChainCodeInvokerList.addAll(chainCodeInvokerList.getToRemoveList());
			chainCodeInvokerList.removeAll(chainCodeInvokerList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getChainCodeInvokerDAO().saveChainCodeInvokerList(mergedUpdateChainCodeInvokerList,options);
		
		if(chainCodeInvokerList.getToRemoveList() != null){
			chainCodeInvokerList.removeAll(chainCodeInvokerList.getToRemoveList());
		}
		
		
		return chainCode;
	
	}
	
	protected ChainCode removeChainCodeInvokerList(ChainCode chainCode, Map<String,Object> options){
	
	
		SmartList<ChainCodeInvoker> chainCodeInvokerList = chainCode.getChainCodeInvokerList();
		if(chainCodeInvokerList == null){
			return chainCode;
		}	
	
		SmartList<ChainCodeInvoker> toRemoveChainCodeInvokerList = chainCodeInvokerList.getToRemoveList();
		
		if(toRemoveChainCodeInvokerList == null){
			return chainCode;
		}
		if(toRemoveChainCodeInvokerList.isEmpty()){
			return chainCode;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getChainCodeInvokerDAO().removeChainCodeInvokerList(toRemoveChainCodeInvokerList,options);
		
		return chainCode;
	
	}
	
	

 	
 	
	
	
	
		

	public ChainCode present(ChainCode chainCode,Map<String, Object> options){
	
		presentServiceRecordList(chainCode,options);
		presentChainCodeInvokerList(chainCode,options);

		return chainCode;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected ChainCode presentServiceRecordList(
			ChainCode chainCode,
			Map<String, Object> options) {

		SmartList<ServiceRecord> serviceRecordList = chainCode.getServiceRecordList();		
				SmartList<ServiceRecord> newList= presentSubList(chainCode.getId(),
				serviceRecordList,
				options,
				getServiceRecordDAO()::countServiceRecordByChainCode,
				getServiceRecordDAO()::findServiceRecordByChainCode
				);

		
		chainCode.setServiceRecordList(newList);
		

		return chainCode;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected ChainCode presentChainCodeInvokerList(
			ChainCode chainCode,
			Map<String, Object> options) {

		SmartList<ChainCodeInvoker> chainCodeInvokerList = chainCode.getChainCodeInvokerList();		
				SmartList<ChainCodeInvoker> newList= presentSubList(chainCode.getId(),
				chainCodeInvokerList,
				options,
				getChainCodeInvokerDAO()::countChainCodeInvokerByChainCode,
				getChainCodeInvokerDAO()::findChainCodeInvokerByChainCode
				);

		
		chainCode.setChainCodeInvokerList(newList);
		

		return chainCode;
	}			
		

	
    public SmartList<ChainCode> requestCandidateChainCodeForServiceRecord(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ChainCodeTable.COLUMN_NAME, filterKey, pageNo, pageSize, getChainCodeMapper());
    }
		
    public SmartList<ChainCode> requestCandidateChainCodeForChainCodeInvoker(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ChainCodeTable.COLUMN_NAME, filterKey, pageNo, pageSize, getChainCodeMapper());
    }
		

	protected String getTableName(){
		return ChainCodeTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<ChainCode> chainCodeList) {		
		this.enhanceListInternal(chainCodeList, this.getChainCodeMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:ServiceRecord的chainCode的ServiceRecordList
	public SmartList<ServiceRecord> loadOurServiceRecordList(HfgwUserContext userContext, List<ChainCode> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.CHAIN_CODE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ServiceRecord> loadedObjs = userContext.getDAOGroup().getServiceRecordDAO().findServiceRecordWithKey(key, options);
		Map<String, List<ServiceRecord>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getChainCode().getId()));
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
	
	// 需要一个加载引用我的对象的enhance方法:ChainCodeInvoker的chainCode的ChainCodeInvokerList
	public SmartList<ChainCodeInvoker> loadOurChainCodeInvokerList(HfgwUserContext userContext, List<ChainCode> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChainCodeInvoker.CHAIN_CODE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ChainCodeInvoker> loadedObjs = userContext.getDAOGroup().getChainCodeInvokerDAO().findChainCodeInvokerWithKey(key, options);
		Map<String, List<ChainCodeInvoker>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getChainCode().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<ChainCodeInvoker> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<ChainCodeInvoker> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setChainCodeInvokerList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<ChainCode> chainCodeList = ownerEntity.collectRefsWithType(ChainCode.INTERNAL_TYPE);
		this.enhanceList(chainCodeList);
		
	}
	
	@Override
	public SmartList<ChainCode> findChainCodeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getChainCodeMapper());

	}
	@Override
	public int countChainCodeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countChainCodeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<ChainCode> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getChainCodeMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


