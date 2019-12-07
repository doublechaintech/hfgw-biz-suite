
package com.doublechaintech.hfgw.changerequest;

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


import com.doublechaintech.hfgw.changerequesttype.ChangeRequestType;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;
import com.doublechaintech.hfgw.chaincodeinvoker.ChainCodeInvoker;

import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetworkDAO;
import com.doublechaintech.hfgw.chaincodeinvoker.ChainCodeInvokerDAO;
import com.doublechaintech.hfgw.changerequesttype.ChangeRequestTypeDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class ChangeRequestJDBCTemplateDAO extends HfgwBaseDAOImpl implements ChangeRequestDAO{
 
 	
 	private  ChangeRequestTypeDAO  changeRequestTypeDAO;
 	public void setChangeRequestTypeDAO(ChangeRequestTypeDAO changeRequestTypeDAO){
	 	this.changeRequestTypeDAO = changeRequestTypeDAO;
 	}
 	public ChangeRequestTypeDAO getChangeRequestTypeDAO(){
	 	return this.changeRequestTypeDAO;
 	}
 
 	
 	private  HyperledgerNetworkDAO  hyperledgerNetworkDAO;
 	public void setHyperledgerNetworkDAO(HyperledgerNetworkDAO hyperledgerNetworkDAO){
	 	this.hyperledgerNetworkDAO = hyperledgerNetworkDAO;
 	}
 	public HyperledgerNetworkDAO getHyperledgerNetworkDAO(){
	 	return this.hyperledgerNetworkDAO;
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
	protected ChangeRequest load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalChangeRequest(accessKey, options);
	}
	*/
	
	public SmartList<ChangeRequest> loadAll() {
	    return this.loadAll(getChangeRequestMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public ChangeRequest load(String id,Map<String,Object> options) throws Exception{
		return loadInternalChangeRequest(ChangeRequestTable.withId(id), options);
	}
	
	
	
	public ChangeRequest save(ChangeRequest changeRequest,Map<String,Object> options){
		
		String methodName="save(ChangeRequest changeRequest,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(changeRequest, methodName, "changeRequest");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalChangeRequest(changeRequest,options);
	}
	public ChangeRequest clone(String changeRequestId, Map<String,Object> options) throws Exception{
	
		return clone(ChangeRequestTable.withId(changeRequestId),options);
	}
	
	protected ChangeRequest clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String changeRequestId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ChangeRequest newChangeRequest = loadInternalChangeRequest(accessKey, options);
		newChangeRequest.setVersion(0);
		
		
 		
 		if(isSaveChainCodeInvokerListEnabled(options)){
 			for(ChainCodeInvoker item: newChangeRequest.getChainCodeInvokerList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalChangeRequest(newChangeRequest,options);
		
		return newChangeRequest;
	}
	
	
	
	

	protected void throwIfHasException(String changeRequestId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ChangeRequestVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ChangeRequestNotFoundException(
					"The " + this.getTableName() + "(" + changeRequestId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String changeRequestId, int version) throws Exception{
	
		String methodName="delete(String changeRequestId, int version)";
		assertMethodArgumentNotNull(changeRequestId, methodName, "changeRequestId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{changeRequestId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(changeRequestId,version);
		}
		
	
	}
	
	
	
	
	

	public ChangeRequest disconnectFromAll(String changeRequestId, int version) throws Exception{
	
		
		ChangeRequest changeRequest = loadInternalChangeRequest(ChangeRequestTable.withId(changeRequestId), emptyOptions());
		changeRequest.clearFromAll();
		this.saveChangeRequest(changeRequest);
		return changeRequest;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ChangeRequestTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "change_request";
	}
	@Override
	protected String getBeanName() {
		
		return "changeRequest";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ChangeRequestTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractRequestTypeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ChangeRequestTokens.REQUESTTYPE);
 	}

 	protected boolean isSaveRequestTypeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ChangeRequestTokens.REQUESTTYPE);
 	}
 	

 	
  

 	protected boolean isExtractNetworkEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ChangeRequestTokens.NETWORK);
 	}

 	protected boolean isSaveNetworkEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ChangeRequestTokens.NETWORK);
 	}
 	

 	
 
		
	
	protected boolean isExtractChainCodeInvokerListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ChangeRequestTokens.CHAIN_CODE_INVOKER_LIST);
 	}
 	protected boolean isAnalyzeChainCodeInvokerListEnabled(Map<String,Object> options){		 		
 		return ChangeRequestTokens.of(options).analyzeChainCodeInvokerListEnabled();
 	}
	
	protected boolean isSaveChainCodeInvokerListEnabled(Map<String,Object> options){
		return checkOptions(options, ChangeRequestTokens.CHAIN_CODE_INVOKER_LIST);
		
 	}
 	
		

	

	protected ChangeRequestMapper getChangeRequestMapper(){
		return new ChangeRequestMapper();
	}

	
	
	protected ChangeRequest extractChangeRequest(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ChangeRequest changeRequest = loadSingleObject(accessKey, getChangeRequestMapper());
			return changeRequest;
		}catch(EmptyResultDataAccessException e){
			throw new ChangeRequestNotFoundException("ChangeRequest("+accessKey+") is not found!");
		}

	}

	
	

	protected ChangeRequest loadInternalChangeRequest(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ChangeRequest changeRequest = extractChangeRequest(accessKey, loadOptions);
 	
 		if(isExtractRequestTypeEnabled(loadOptions)){
	 		extractRequestType(changeRequest, loadOptions);
 		}
  	
 		if(isExtractNetworkEnabled(loadOptions)){
	 		extractNetwork(changeRequest, loadOptions);
 		}
 
		
		if(isExtractChainCodeInvokerListEnabled(loadOptions)){
	 		extractChainCodeInvokerList(changeRequest, loadOptions);
 		}	
 		if(isAnalyzeChainCodeInvokerListEnabled(loadOptions)){
	 		analyzeChainCodeInvokerList(changeRequest, loadOptions);
 		}
 		
		
		return changeRequest;
		
	}

	 

 	protected ChangeRequest extractRequestType(ChangeRequest changeRequest, Map<String,Object> options) throws Exception{

		if(changeRequest.getRequestType() == null){
			return changeRequest;
		}
		String requestTypeId = changeRequest.getRequestType().getId();
		if( requestTypeId == null){
			return changeRequest;
		}
		ChangeRequestType requestType = getChangeRequestTypeDAO().load(requestTypeId,options);
		if(requestType != null){
			changeRequest.setRequestType(requestType);
		}
		
 		
 		return changeRequest;
 	}
 		
  

 	protected ChangeRequest extractNetwork(ChangeRequest changeRequest, Map<String,Object> options) throws Exception{

		if(changeRequest.getNetwork() == null){
			return changeRequest;
		}
		String networkId = changeRequest.getNetwork().getId();
		if( networkId == null){
			return changeRequest;
		}
		HyperledgerNetwork network = getHyperledgerNetworkDAO().load(networkId,options);
		if(network != null){
			changeRequest.setNetwork(network);
		}
		
 		
 		return changeRequest;
 	}
 		
 
		
	protected void enhanceChainCodeInvokerList(SmartList<ChainCodeInvoker> chainCodeInvokerList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected ChangeRequest extractChainCodeInvokerList(ChangeRequest changeRequest, Map<String,Object> options){
		
		
		if(changeRequest == null){
			return null;
		}
		if(changeRequest.getId() == null){
			return changeRequest;
		}

		
		
		SmartList<ChainCodeInvoker> chainCodeInvokerList = getChainCodeInvokerDAO().findChainCodeInvokerByChangeRequest(changeRequest.getId(),options);
		if(chainCodeInvokerList != null){
			enhanceChainCodeInvokerList(chainCodeInvokerList,options);
			changeRequest.setChainCodeInvokerList(chainCodeInvokerList);
		}
		
		return changeRequest;
	
	}	
	
	protected ChangeRequest analyzeChainCodeInvokerList(ChangeRequest changeRequest, Map<String,Object> options){
		
		
		if(changeRequest == null){
			return null;
		}
		if(changeRequest.getId() == null){
			return changeRequest;
		}

		
		
		SmartList<ChainCodeInvoker> chainCodeInvokerList = changeRequest.getChainCodeInvokerList();
		if(chainCodeInvokerList != null){
			getChainCodeInvokerDAO().analyzeChainCodeInvokerByChangeRequest(chainCodeInvokerList, changeRequest.getId(), options);
			
		}
		
		return changeRequest;
	
	}	
	
		
		
  	
 	public SmartList<ChangeRequest> findChangeRequestByRequestType(String changeRequestTypeId,Map<String,Object> options){
 	
  		SmartList<ChangeRequest> resultList = queryWith(ChangeRequestTable.COLUMN_REQUEST_TYPE, changeRequestTypeId, options, getChangeRequestMapper());
		// analyzeChangeRequestByRequestType(resultList, changeRequestTypeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ChangeRequest> findChangeRequestByRequestType(String changeRequestTypeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ChangeRequest> resultList =  queryWithRange(ChangeRequestTable.COLUMN_REQUEST_TYPE, changeRequestTypeId, options, getChangeRequestMapper(), start, count);
 		//analyzeChangeRequestByRequestType(resultList, changeRequestTypeId, options);
 		return resultList;
 		
 	}
 	public void analyzeChangeRequestByRequestType(SmartList<ChangeRequest> resultList, String changeRequestTypeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ChangeRequest.REQUEST_TYPE_PROPERTY, changeRequestTypeId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//ChangeRequest.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("变更请求");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(ChangeRequest.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(ChangeRequest.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countChangeRequestByRequestType(String changeRequestTypeId,Map<String,Object> options){

 		return countWith(ChangeRequestTable.COLUMN_REQUEST_TYPE, changeRequestTypeId, options);
 	}
 	@Override
	public Map<String, Integer> countChangeRequestByRequestTypeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ChangeRequestTable.COLUMN_REQUEST_TYPE, ids, options);
	}
 	
  	
 	public SmartList<ChangeRequest> findChangeRequestByNetwork(String hyperledgerNetworkId,Map<String,Object> options){
 	
  		SmartList<ChangeRequest> resultList = queryWith(ChangeRequestTable.COLUMN_NETWORK, hyperledgerNetworkId, options, getChangeRequestMapper());
		// analyzeChangeRequestByNetwork(resultList, hyperledgerNetworkId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ChangeRequest> findChangeRequestByNetwork(String hyperledgerNetworkId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ChangeRequest> resultList =  queryWithRange(ChangeRequestTable.COLUMN_NETWORK, hyperledgerNetworkId, options, getChangeRequestMapper(), start, count);
 		//analyzeChangeRequestByNetwork(resultList, hyperledgerNetworkId, options);
 		return resultList;
 		
 	}
 	public void analyzeChangeRequestByNetwork(SmartList<ChangeRequest> resultList, String hyperledgerNetworkId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ChangeRequest.NETWORK_PROPERTY, hyperledgerNetworkId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//ChangeRequest.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("变更请求");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(ChangeRequest.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(ChangeRequest.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countChangeRequestByNetwork(String hyperledgerNetworkId,Map<String,Object> options){

 		return countWith(ChangeRequestTable.COLUMN_NETWORK, hyperledgerNetworkId, options);
 	}
 	@Override
	public Map<String, Integer> countChangeRequestByNetworkIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ChangeRequestTable.COLUMN_NETWORK, ids, options);
	}
 	
 	
		
		
		

	

	protected ChangeRequest saveChangeRequest(ChangeRequest  changeRequest){
		
		if(!changeRequest.isChanged()){
			return changeRequest;
		}
		
		
		String SQL=this.getSaveChangeRequestSQL(changeRequest);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveChangeRequestParameters(changeRequest);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		changeRequest.incVersion();
		return changeRequest;
	
	}
	public SmartList<ChangeRequest> saveChangeRequestList(SmartList<ChangeRequest> changeRequestList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitChangeRequestList(changeRequestList);
		
		batchChangeRequestCreate((List<ChangeRequest>)lists[CREATE_LIST_INDEX]);
		
		batchChangeRequestUpdate((List<ChangeRequest>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ChangeRequest changeRequest:changeRequestList){
			if(changeRequest.isChanged()){
				changeRequest.incVersion();
			}
			
		
		}
		
		
		return changeRequestList;
	}

	public SmartList<ChangeRequest> removeChangeRequestList(SmartList<ChangeRequest> changeRequestList,Map<String,Object> options){
		
		
		super.removeList(changeRequestList, options);
		
		return changeRequestList;
		
		
	}
	
	protected List<Object[]> prepareChangeRequestBatchCreateArgs(List<ChangeRequest> changeRequestList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ChangeRequest changeRequest:changeRequestList ){
			Object [] parameters = prepareChangeRequestCreateParameters(changeRequest);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareChangeRequestBatchUpdateArgs(List<ChangeRequest> changeRequestList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ChangeRequest changeRequest:changeRequestList ){
			if(!changeRequest.isChanged()){
				continue;
			}
			Object [] parameters = prepareChangeRequestUpdateParameters(changeRequest);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchChangeRequestCreate(List<ChangeRequest> changeRequestList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareChangeRequestBatchCreateArgs(changeRequestList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchChangeRequestUpdate(List<ChangeRequest> changeRequestList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareChangeRequestBatchUpdateArgs(changeRequestList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitChangeRequestList(List<ChangeRequest> changeRequestList){
		
		List<ChangeRequest> changeRequestCreateList=new ArrayList<ChangeRequest>();
		List<ChangeRequest> changeRequestUpdateList=new ArrayList<ChangeRequest>();
		
		for(ChangeRequest changeRequest: changeRequestList){
			if(isUpdateRequest(changeRequest)){
				changeRequestUpdateList.add( changeRequest);
				continue;
			}
			changeRequestCreateList.add(changeRequest);
		}
		
		return new Object[]{changeRequestCreateList,changeRequestUpdateList};
	}
	
	protected boolean isUpdateRequest(ChangeRequest changeRequest){
 		return changeRequest.getVersion() > 0;
 	}
 	protected String getSaveChangeRequestSQL(ChangeRequest changeRequest){
 		if(isUpdateRequest(changeRequest)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveChangeRequestParameters(ChangeRequest changeRequest){
 		if(isUpdateRequest(changeRequest) ){
 			return prepareChangeRequestUpdateParameters(changeRequest);
 		}
 		return prepareChangeRequestCreateParameters(changeRequest);
 	}
 	protected Object[] prepareChangeRequestUpdateParameters(ChangeRequest changeRequest){
 		Object[] parameters = new Object[8];
 
 		parameters[0] = changeRequest.getName();
 		parameters[1] = changeRequest.getCreateTime();
 		parameters[2] = changeRequest.getRemoteIp(); 	
 		if(changeRequest.getRequestType() != null){
 			parameters[3] = changeRequest.getRequestType().getId();
 		}
  	
 		if(changeRequest.getNetwork() != null){
 			parameters[4] = changeRequest.getNetwork().getId();
 		}
 		
 		parameters[5] = changeRequest.nextVersion();
 		parameters[6] = changeRequest.getId();
 		parameters[7] = changeRequest.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareChangeRequestCreateParameters(ChangeRequest changeRequest){
		Object[] parameters = new Object[6];
		String newChangeRequestId=getNextId();
		changeRequest.setId(newChangeRequestId);
		parameters[0] =  changeRequest.getId();
 
 		parameters[1] = changeRequest.getName();
 		parameters[2] = changeRequest.getCreateTime();
 		parameters[3] = changeRequest.getRemoteIp(); 	
 		if(changeRequest.getRequestType() != null){
 			parameters[4] = changeRequest.getRequestType().getId();
 		
 		}
 		 	
 		if(changeRequest.getNetwork() != null){
 			parameters[5] = changeRequest.getNetwork().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected ChangeRequest saveInternalChangeRequest(ChangeRequest changeRequest, Map<String,Object> options){
		
		saveChangeRequest(changeRequest);
 	
 		if(isSaveRequestTypeEnabled(options)){
	 		saveRequestType(changeRequest, options);
 		}
  	
 		if(isSaveNetworkEnabled(options)){
	 		saveNetwork(changeRequest, options);
 		}
 
		
		if(isSaveChainCodeInvokerListEnabled(options)){
	 		saveChainCodeInvokerList(changeRequest, options);
	 		//removeChainCodeInvokerList(changeRequest, options);
	 		//Not delete the record
	 		
 		}		
		
		return changeRequest;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ChangeRequest saveRequestType(ChangeRequest changeRequest, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(changeRequest.getRequestType() == null){
 			return changeRequest;//do nothing when it is null
 		}
 		
 		getChangeRequestTypeDAO().save(changeRequest.getRequestType(),options);
 		return changeRequest;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected ChangeRequest saveNetwork(ChangeRequest changeRequest, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(changeRequest.getNetwork() == null){
 			return changeRequest;//do nothing when it is null
 		}
 		
 		getHyperledgerNetworkDAO().save(changeRequest.getNetwork(),options);
 		return changeRequest;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public ChangeRequest planToRemoveChainCodeInvokerList(ChangeRequest changeRequest, String chainCodeInvokerIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChainCodeInvoker.CHANGE_REQUEST_PROPERTY, changeRequest.getId());
		key.put(ChainCodeInvoker.ID_PROPERTY, chainCodeInvokerIds);
		
		SmartList<ChainCodeInvoker> externalChainCodeInvokerList = getChainCodeInvokerDAO().
				findChainCodeInvokerWithKey(key, options);
		if(externalChainCodeInvokerList == null){
			return changeRequest;
		}
		if(externalChainCodeInvokerList.isEmpty()){
			return changeRequest;
		}
		
		for(ChainCodeInvoker chainCodeInvokerItem: externalChainCodeInvokerList){

			chainCodeInvokerItem.clearFromAll();
		}
		
		
		SmartList<ChainCodeInvoker> chainCodeInvokerList = changeRequest.getChainCodeInvokerList();		
		chainCodeInvokerList.addAllToRemoveList(externalChainCodeInvokerList);
		return changeRequest;	
	
	}


	//disconnect ChangeRequest with app_client in ChainCodeInvoker
	public ChangeRequest planToRemoveChainCodeInvokerListWithAppClient(ChangeRequest changeRequest, String appClientId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChainCodeInvoker.CHANGE_REQUEST_PROPERTY, changeRequest.getId());
		key.put(ChainCodeInvoker.APP_CLIENT_PROPERTY, appClientId);
		
		SmartList<ChainCodeInvoker> externalChainCodeInvokerList = getChainCodeInvokerDAO().
				findChainCodeInvokerWithKey(key, options);
		if(externalChainCodeInvokerList == null){
			return changeRequest;
		}
		if(externalChainCodeInvokerList.isEmpty()){
			return changeRequest;
		}
		
		for(ChainCodeInvoker chainCodeInvokerItem: externalChainCodeInvokerList){
			chainCodeInvokerItem.clearAppClient();
			chainCodeInvokerItem.clearChangeRequest();
			
		}
		
		
		SmartList<ChainCodeInvoker> chainCodeInvokerList = changeRequest.getChainCodeInvokerList();		
		chainCodeInvokerList.addAllToRemoveList(externalChainCodeInvokerList);
		return changeRequest;
	}
	
	public int countChainCodeInvokerListWithAppClient(String changeRequestId, String appClientId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChainCodeInvoker.CHANGE_REQUEST_PROPERTY, changeRequestId);
		key.put(ChainCodeInvoker.APP_CLIENT_PROPERTY, appClientId);
		
		int count = getChainCodeInvokerDAO().countChainCodeInvokerWithKey(key, options);
		return count;
	}
	
	//disconnect ChangeRequest with chain_code in ChainCodeInvoker
	public ChangeRequest planToRemoveChainCodeInvokerListWithChainCode(ChangeRequest changeRequest, String chainCodeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChainCodeInvoker.CHANGE_REQUEST_PROPERTY, changeRequest.getId());
		key.put(ChainCodeInvoker.CHAIN_CODE_PROPERTY, chainCodeId);
		
		SmartList<ChainCodeInvoker> externalChainCodeInvokerList = getChainCodeInvokerDAO().
				findChainCodeInvokerWithKey(key, options);
		if(externalChainCodeInvokerList == null){
			return changeRequest;
		}
		if(externalChainCodeInvokerList.isEmpty()){
			return changeRequest;
		}
		
		for(ChainCodeInvoker chainCodeInvokerItem: externalChainCodeInvokerList){
			chainCodeInvokerItem.clearChainCode();
			chainCodeInvokerItem.clearChangeRequest();
			
		}
		
		
		SmartList<ChainCodeInvoker> chainCodeInvokerList = changeRequest.getChainCodeInvokerList();		
		chainCodeInvokerList.addAllToRemoveList(externalChainCodeInvokerList);
		return changeRequest;
	}
	
	public int countChainCodeInvokerListWithChainCode(String changeRequestId, String chainCodeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChainCodeInvoker.CHANGE_REQUEST_PROPERTY, changeRequestId);
		key.put(ChainCodeInvoker.CHAIN_CODE_PROPERTY, chainCodeId);
		
		int count = getChainCodeInvokerDAO().countChainCodeInvokerWithKey(key, options);
		return count;
	}
	

		
	protected ChangeRequest saveChainCodeInvokerList(ChangeRequest changeRequest, Map<String,Object> options){
		
		
		
		
		SmartList<ChainCodeInvoker> chainCodeInvokerList = changeRequest.getChainCodeInvokerList();
		if(chainCodeInvokerList == null){
			//null list means nothing
			return changeRequest;
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
		
		
		return changeRequest;
	
	}
	
	protected ChangeRequest removeChainCodeInvokerList(ChangeRequest changeRequest, Map<String,Object> options){
	
	
		SmartList<ChainCodeInvoker> chainCodeInvokerList = changeRequest.getChainCodeInvokerList();
		if(chainCodeInvokerList == null){
			return changeRequest;
		}	
	
		SmartList<ChainCodeInvoker> toRemoveChainCodeInvokerList = chainCodeInvokerList.getToRemoveList();
		
		if(toRemoveChainCodeInvokerList == null){
			return changeRequest;
		}
		if(toRemoveChainCodeInvokerList.isEmpty()){
			return changeRequest;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getChainCodeInvokerDAO().removeChainCodeInvokerList(toRemoveChainCodeInvokerList,options);
		
		return changeRequest;
	
	}
	
	

 	
 	
	
	
	
		

	public ChangeRequest present(ChangeRequest changeRequest,Map<String, Object> options){
	
		presentChainCodeInvokerList(changeRequest,options);

		return changeRequest;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected ChangeRequest presentChainCodeInvokerList(
			ChangeRequest changeRequest,
			Map<String, Object> options) {

		SmartList<ChainCodeInvoker> chainCodeInvokerList = changeRequest.getChainCodeInvokerList();		
				SmartList<ChainCodeInvoker> newList= presentSubList(changeRequest.getId(),
				chainCodeInvokerList,
				options,
				getChainCodeInvokerDAO()::countChainCodeInvokerByChangeRequest,
				getChainCodeInvokerDAO()::findChainCodeInvokerByChangeRequest
				);

		
		changeRequest.setChainCodeInvokerList(newList);
		

		return changeRequest;
	}			
		

	
    public SmartList<ChangeRequest> requestCandidateChangeRequestForChainCodeInvoker(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ChangeRequestTable.COLUMN_NAME, filterKey, pageNo, pageSize, getChangeRequestMapper());
    }
		

	protected String getTableName(){
		return ChangeRequestTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<ChangeRequest> changeRequestList) {		
		this.enhanceListInternal(changeRequestList, this.getChangeRequestMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:ChainCodeInvoker的changeRequest的ChainCodeInvokerList
	public SmartList<ChainCodeInvoker> loadOurChainCodeInvokerList(HfgwUserContext userContext, List<ChangeRequest> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChainCodeInvoker.CHANGE_REQUEST_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ChainCodeInvoker> loadedObjs = userContext.getDAOGroup().getChainCodeInvokerDAO().findChainCodeInvokerWithKey(key, options);
		Map<String, List<ChainCodeInvoker>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getChangeRequest().getId()));
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
		List<ChangeRequest> changeRequestList = ownerEntity.collectRefsWithType(ChangeRequest.INTERNAL_TYPE);
		this.enhanceList(changeRequestList);
		
	}
	
	@Override
	public SmartList<ChangeRequest> findChangeRequestWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getChangeRequestMapper());

	}
	@Override
	public int countChangeRequestWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countChangeRequestWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<ChangeRequest> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getChangeRequestMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


