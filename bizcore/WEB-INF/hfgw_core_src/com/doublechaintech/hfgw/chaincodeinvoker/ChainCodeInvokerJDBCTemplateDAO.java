
package com.doublechaintech.hfgw.chaincodeinvoker;

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


import com.doublechaintech.hfgw.chaincode.ChainCode;
import com.doublechaintech.hfgw.changerequest.ChangeRequest;
import com.doublechaintech.hfgw.application.Application;

import com.doublechaintech.hfgw.chaincode.ChainCodeDAO;
import com.doublechaintech.hfgw.changerequest.ChangeRequestDAO;
import com.doublechaintech.hfgw.application.ApplicationDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class ChainCodeInvokerJDBCTemplateDAO extends HfgwBaseDAOImpl implements ChainCodeInvokerDAO{
 
 	
 	private  ChangeRequestDAO  changeRequestDAO;
 	public void setChangeRequestDAO(ChangeRequestDAO changeRequestDAO){
	 	this.changeRequestDAO = changeRequestDAO;
 	}
 	public ChangeRequestDAO getChangeRequestDAO(){
	 	return this.changeRequestDAO;
 	}
 
 	
 	private  ApplicationDAO  applicationDAO;
 	public void setApplicationDAO(ApplicationDAO applicationDAO){
	 	this.applicationDAO = applicationDAO;
 	}
 	public ApplicationDAO getApplicationDAO(){
	 	return this.applicationDAO;
 	}
 
 	
 	private  ChainCodeDAO  chainCodeDAO;
 	public void setChainCodeDAO(ChainCodeDAO chainCodeDAO){
	 	this.chainCodeDAO = chainCodeDAO;
 	}
 	public ChainCodeDAO getChainCodeDAO(){
	 	return this.chainCodeDAO;
 	}


			
		

	
	/*
	protected ChainCodeInvoker load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalChainCodeInvoker(accessKey, options);
	}
	*/
	
	public SmartList<ChainCodeInvoker> loadAll() {
	    return this.loadAll(getChainCodeInvokerMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public ChainCodeInvoker load(String id,Map<String,Object> options) throws Exception{
		return loadInternalChainCodeInvoker(ChainCodeInvokerTable.withId(id), options);
	}
	
	
	
	public ChainCodeInvoker save(ChainCodeInvoker chainCodeInvoker,Map<String,Object> options){
		
		String methodName="save(ChainCodeInvoker chainCodeInvoker,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(chainCodeInvoker, methodName, "chainCodeInvoker");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalChainCodeInvoker(chainCodeInvoker,options);
	}
	public ChainCodeInvoker clone(String chainCodeInvokerId, Map<String,Object> options) throws Exception{
	
		return clone(ChainCodeInvokerTable.withId(chainCodeInvokerId),options);
	}
	
	protected ChainCodeInvoker clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String chainCodeInvokerId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ChainCodeInvoker newChainCodeInvoker = loadInternalChainCodeInvoker(accessKey, options);
		newChainCodeInvoker.setVersion(0);
		
		

		
		saveInternalChainCodeInvoker(newChainCodeInvoker,options);
		
		return newChainCodeInvoker;
	}
	
	
	
	

	protected void throwIfHasException(String chainCodeInvokerId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ChainCodeInvokerVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ChainCodeInvokerNotFoundException(
					"The " + this.getTableName() + "(" + chainCodeInvokerId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String chainCodeInvokerId, int version) throws Exception{
	
		String methodName="delete(String chainCodeInvokerId, int version)";
		assertMethodArgumentNotNull(chainCodeInvokerId, methodName, "chainCodeInvokerId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{chainCodeInvokerId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(chainCodeInvokerId,version);
		}
		
	
	}
	
	
	
	
	

	public ChainCodeInvoker disconnectFromAll(String chainCodeInvokerId, int version) throws Exception{
	
		
		ChainCodeInvoker chainCodeInvoker = loadInternalChainCodeInvoker(ChainCodeInvokerTable.withId(chainCodeInvokerId), emptyOptions());
		chainCodeInvoker.clearFromAll();
		this.saveChainCodeInvoker(chainCodeInvoker);
		return chainCodeInvoker;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ChainCodeInvokerTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "chain_code_invoker";
	}
	@Override
	protected String getBeanName() {
		
		return "chainCodeInvoker";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ChainCodeInvokerTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractAppClientEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ChainCodeInvokerTokens.APPCLIENT);
 	}

 	protected boolean isSaveAppClientEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ChainCodeInvokerTokens.APPCLIENT);
 	}
 	

 	
  

 	protected boolean isExtractChainCodeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ChainCodeInvokerTokens.CHAINCODE);
 	}

 	protected boolean isSaveChainCodeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ChainCodeInvokerTokens.CHAINCODE);
 	}
 	

 	
  

 	protected boolean isExtractChangeRequestEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ChainCodeInvokerTokens.CHANGEREQUEST);
 	}

 	protected boolean isSaveChangeRequestEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ChainCodeInvokerTokens.CHANGEREQUEST);
 	}
 	

 	
 
		

	

	protected ChainCodeInvokerMapper getChainCodeInvokerMapper(){
		return new ChainCodeInvokerMapper();
	}

	
	
	protected ChainCodeInvoker extractChainCodeInvoker(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ChainCodeInvoker chainCodeInvoker = loadSingleObject(accessKey, getChainCodeInvokerMapper());
			return chainCodeInvoker;
		}catch(EmptyResultDataAccessException e){
			throw new ChainCodeInvokerNotFoundException("ChainCodeInvoker("+accessKey+") is not found!");
		}

	}

	
	

	protected ChainCodeInvoker loadInternalChainCodeInvoker(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ChainCodeInvoker chainCodeInvoker = extractChainCodeInvoker(accessKey, loadOptions);
 	
 		if(isExtractAppClientEnabled(loadOptions)){
	 		extractAppClient(chainCodeInvoker, loadOptions);
 		}
  	
 		if(isExtractChainCodeEnabled(loadOptions)){
	 		extractChainCode(chainCodeInvoker, loadOptions);
 		}
  	
 		if(isExtractChangeRequestEnabled(loadOptions)){
	 		extractChangeRequest(chainCodeInvoker, loadOptions);
 		}
 
		
		return chainCodeInvoker;
		
	}

	 

 	protected ChainCodeInvoker extractAppClient(ChainCodeInvoker chainCodeInvoker, Map<String,Object> options) throws Exception{

		if(chainCodeInvoker.getAppClient() == null){
			return chainCodeInvoker;
		}
		String appClientId = chainCodeInvoker.getAppClient().getId();
		if( appClientId == null){
			return chainCodeInvoker;
		}
		Application appClient = getApplicationDAO().load(appClientId,options);
		if(appClient != null){
			chainCodeInvoker.setAppClient(appClient);
		}
		
 		
 		return chainCodeInvoker;
 	}
 		
  

 	protected ChainCodeInvoker extractChainCode(ChainCodeInvoker chainCodeInvoker, Map<String,Object> options) throws Exception{

		if(chainCodeInvoker.getChainCode() == null){
			return chainCodeInvoker;
		}
		String chainCodeId = chainCodeInvoker.getChainCode().getId();
		if( chainCodeId == null){
			return chainCodeInvoker;
		}
		ChainCode chainCode = getChainCodeDAO().load(chainCodeId,options);
		if(chainCode != null){
			chainCodeInvoker.setChainCode(chainCode);
		}
		
 		
 		return chainCodeInvoker;
 	}
 		
  

 	protected ChainCodeInvoker extractChangeRequest(ChainCodeInvoker chainCodeInvoker, Map<String,Object> options) throws Exception{

		if(chainCodeInvoker.getChangeRequest() == null){
			return chainCodeInvoker;
		}
		String changeRequestId = chainCodeInvoker.getChangeRequest().getId();
		if( changeRequestId == null){
			return chainCodeInvoker;
		}
		ChangeRequest changeRequest = getChangeRequestDAO().load(changeRequestId,options);
		if(changeRequest != null){
			chainCodeInvoker.setChangeRequest(changeRequest);
		}
		
 		
 		return chainCodeInvoker;
 	}
 		
 
		
		
  	
 	public SmartList<ChainCodeInvoker> findChainCodeInvokerByAppClient(String applicationId,Map<String,Object> options){
 	
  		SmartList<ChainCodeInvoker> resultList = queryWith(ChainCodeInvokerTable.COLUMN_APP_CLIENT, applicationId, options, getChainCodeInvokerMapper());
		// analyzeChainCodeInvokerByAppClient(resultList, applicationId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ChainCodeInvoker> findChainCodeInvokerByAppClient(String applicationId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ChainCodeInvoker> resultList =  queryWithRange(ChainCodeInvokerTable.COLUMN_APP_CLIENT, applicationId, options, getChainCodeInvokerMapper(), start, count);
 		//analyzeChainCodeInvokerByAppClient(resultList, applicationId, options);
 		return resultList;
 		
 	}
 	public void analyzeChainCodeInvokerByAppClient(SmartList<ChainCodeInvoker> resultList, String applicationId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ChainCodeInvoker.APP_CLIENT_PROPERTY, applicationId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countChainCodeInvokerByAppClient(String applicationId,Map<String,Object> options){

 		return countWith(ChainCodeInvokerTable.COLUMN_APP_CLIENT, applicationId, options);
 	}
 	@Override
	public Map<String, Integer> countChainCodeInvokerByAppClientIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ChainCodeInvokerTable.COLUMN_APP_CLIENT, ids, options);
	}
 	
  	
 	public SmartList<ChainCodeInvoker> findChainCodeInvokerByChainCode(String chainCodeId,Map<String,Object> options){
 	
  		SmartList<ChainCodeInvoker> resultList = queryWith(ChainCodeInvokerTable.COLUMN_CHAIN_CODE, chainCodeId, options, getChainCodeInvokerMapper());
		// analyzeChainCodeInvokerByChainCode(resultList, chainCodeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ChainCodeInvoker> findChainCodeInvokerByChainCode(String chainCodeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ChainCodeInvoker> resultList =  queryWithRange(ChainCodeInvokerTable.COLUMN_CHAIN_CODE, chainCodeId, options, getChainCodeInvokerMapper(), start, count);
 		//analyzeChainCodeInvokerByChainCode(resultList, chainCodeId, options);
 		return resultList;
 		
 	}
 	public void analyzeChainCodeInvokerByChainCode(SmartList<ChainCodeInvoker> resultList, String chainCodeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ChainCodeInvoker.CHAIN_CODE_PROPERTY, chainCodeId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countChainCodeInvokerByChainCode(String chainCodeId,Map<String,Object> options){

 		return countWith(ChainCodeInvokerTable.COLUMN_CHAIN_CODE, chainCodeId, options);
 	}
 	@Override
	public Map<String, Integer> countChainCodeInvokerByChainCodeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ChainCodeInvokerTable.COLUMN_CHAIN_CODE, ids, options);
	}
 	
  	
 	public SmartList<ChainCodeInvoker> findChainCodeInvokerByChangeRequest(String changeRequestId,Map<String,Object> options){
 	
  		SmartList<ChainCodeInvoker> resultList = queryWith(ChainCodeInvokerTable.COLUMN_CHANGE_REQUEST, changeRequestId, options, getChainCodeInvokerMapper());
		// analyzeChainCodeInvokerByChangeRequest(resultList, changeRequestId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ChainCodeInvoker> findChainCodeInvokerByChangeRequest(String changeRequestId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ChainCodeInvoker> resultList =  queryWithRange(ChainCodeInvokerTable.COLUMN_CHANGE_REQUEST, changeRequestId, options, getChainCodeInvokerMapper(), start, count);
 		//analyzeChainCodeInvokerByChangeRequest(resultList, changeRequestId, options);
 		return resultList;
 		
 	}
 	public void analyzeChainCodeInvokerByChangeRequest(SmartList<ChainCodeInvoker> resultList, String changeRequestId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ChainCodeInvoker.CHANGE_REQUEST_PROPERTY, changeRequestId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countChainCodeInvokerByChangeRequest(String changeRequestId,Map<String,Object> options){

 		return countWith(ChainCodeInvokerTable.COLUMN_CHANGE_REQUEST, changeRequestId, options);
 	}
 	@Override
	public Map<String, Integer> countChainCodeInvokerByChangeRequestIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ChainCodeInvokerTable.COLUMN_CHANGE_REQUEST, ids, options);
	}
 	
 	
		
		
		

	

	protected ChainCodeInvoker saveChainCodeInvoker(ChainCodeInvoker  chainCodeInvoker){
		
		if(!chainCodeInvoker.isChanged()){
			return chainCodeInvoker;
		}
		
		
		String SQL=this.getSaveChainCodeInvokerSQL(chainCodeInvoker);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveChainCodeInvokerParameters(chainCodeInvoker);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		chainCodeInvoker.incVersion();
		return chainCodeInvoker;
	
	}
	public SmartList<ChainCodeInvoker> saveChainCodeInvokerList(SmartList<ChainCodeInvoker> chainCodeInvokerList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitChainCodeInvokerList(chainCodeInvokerList);
		
		batchChainCodeInvokerCreate((List<ChainCodeInvoker>)lists[CREATE_LIST_INDEX]);
		
		batchChainCodeInvokerUpdate((List<ChainCodeInvoker>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ChainCodeInvoker chainCodeInvoker:chainCodeInvokerList){
			if(chainCodeInvoker.isChanged()){
				chainCodeInvoker.incVersion();
			}
			
		
		}
		
		
		return chainCodeInvokerList;
	}

	public SmartList<ChainCodeInvoker> removeChainCodeInvokerList(SmartList<ChainCodeInvoker> chainCodeInvokerList,Map<String,Object> options){
		
		
		super.removeList(chainCodeInvokerList, options);
		
		return chainCodeInvokerList;
		
		
	}
	
	protected List<Object[]> prepareChainCodeInvokerBatchCreateArgs(List<ChainCodeInvoker> chainCodeInvokerList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ChainCodeInvoker chainCodeInvoker:chainCodeInvokerList ){
			Object [] parameters = prepareChainCodeInvokerCreateParameters(chainCodeInvoker);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareChainCodeInvokerBatchUpdateArgs(List<ChainCodeInvoker> chainCodeInvokerList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ChainCodeInvoker chainCodeInvoker:chainCodeInvokerList ){
			if(!chainCodeInvoker.isChanged()){
				continue;
			}
			Object [] parameters = prepareChainCodeInvokerUpdateParameters(chainCodeInvoker);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchChainCodeInvokerCreate(List<ChainCodeInvoker> chainCodeInvokerList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareChainCodeInvokerBatchCreateArgs(chainCodeInvokerList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchChainCodeInvokerUpdate(List<ChainCodeInvoker> chainCodeInvokerList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareChainCodeInvokerBatchUpdateArgs(chainCodeInvokerList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitChainCodeInvokerList(List<ChainCodeInvoker> chainCodeInvokerList){
		
		List<ChainCodeInvoker> chainCodeInvokerCreateList=new ArrayList<ChainCodeInvoker>();
		List<ChainCodeInvoker> chainCodeInvokerUpdateList=new ArrayList<ChainCodeInvoker>();
		
		for(ChainCodeInvoker chainCodeInvoker: chainCodeInvokerList){
			if(isUpdateRequest(chainCodeInvoker)){
				chainCodeInvokerUpdateList.add( chainCodeInvoker);
				continue;
			}
			chainCodeInvokerCreateList.add(chainCodeInvoker);
		}
		
		return new Object[]{chainCodeInvokerCreateList,chainCodeInvokerUpdateList};
	}
	
	protected boolean isUpdateRequest(ChainCodeInvoker chainCodeInvoker){
 		return chainCodeInvoker.getVersion() > 0;
 	}
 	protected String getSaveChainCodeInvokerSQL(ChainCodeInvoker chainCodeInvoker){
 		if(isUpdateRequest(chainCodeInvoker)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveChainCodeInvokerParameters(ChainCodeInvoker chainCodeInvoker){
 		if(isUpdateRequest(chainCodeInvoker) ){
 			return prepareChainCodeInvokerUpdateParameters(chainCodeInvoker);
 		}
 		return prepareChainCodeInvokerCreateParameters(chainCodeInvoker);
 	}
 	protected Object[] prepareChainCodeInvokerUpdateParameters(ChainCodeInvoker chainCodeInvoker){
 		Object[] parameters = new Object[7];
  	
 		if(chainCodeInvoker.getAppClient() != null){
 			parameters[0] = chainCodeInvoker.getAppClient().getId();
 		}
  	
 		if(chainCodeInvoker.getChainCode() != null){
 			parameters[1] = chainCodeInvoker.getChainCode().getId();
 		}
 
 		parameters[2] = chainCodeInvoker.getParameters(); 	
 		if(chainCodeInvoker.getChangeRequest() != null){
 			parameters[3] = chainCodeInvoker.getChangeRequest().getId();
 		}
 		
 		parameters[4] = chainCodeInvoker.nextVersion();
 		parameters[5] = chainCodeInvoker.getId();
 		parameters[6] = chainCodeInvoker.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareChainCodeInvokerCreateParameters(ChainCodeInvoker chainCodeInvoker){
		Object[] parameters = new Object[5];
		String newChainCodeInvokerId=getNextId();
		chainCodeInvoker.setId(newChainCodeInvokerId);
		parameters[0] =  chainCodeInvoker.getId();
  	
 		if(chainCodeInvoker.getAppClient() != null){
 			parameters[1] = chainCodeInvoker.getAppClient().getId();
 		
 		}
 		 	
 		if(chainCodeInvoker.getChainCode() != null){
 			parameters[2] = chainCodeInvoker.getChainCode().getId();
 		
 		}
 		
 		parameters[3] = chainCodeInvoker.getParameters(); 	
 		if(chainCodeInvoker.getChangeRequest() != null){
 			parameters[4] = chainCodeInvoker.getChangeRequest().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected ChainCodeInvoker saveInternalChainCodeInvoker(ChainCodeInvoker chainCodeInvoker, Map<String,Object> options){
		
		saveChainCodeInvoker(chainCodeInvoker);
 	
 		if(isSaveAppClientEnabled(options)){
	 		saveAppClient(chainCodeInvoker, options);
 		}
  	
 		if(isSaveChainCodeEnabled(options)){
	 		saveChainCode(chainCodeInvoker, options);
 		}
  	
 		if(isSaveChangeRequestEnabled(options)){
	 		saveChangeRequest(chainCodeInvoker, options);
 		}
 
		
		return chainCodeInvoker;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ChainCodeInvoker saveAppClient(ChainCodeInvoker chainCodeInvoker, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(chainCodeInvoker.getAppClient() == null){
 			return chainCodeInvoker;//do nothing when it is null
 		}
 		
 		getApplicationDAO().save(chainCodeInvoker.getAppClient(),options);
 		return chainCodeInvoker;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected ChainCodeInvoker saveChainCode(ChainCodeInvoker chainCodeInvoker, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(chainCodeInvoker.getChainCode() == null){
 			return chainCodeInvoker;//do nothing when it is null
 		}
 		
 		getChainCodeDAO().save(chainCodeInvoker.getChainCode(),options);
 		return chainCodeInvoker;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected ChainCodeInvoker saveChangeRequest(ChainCodeInvoker chainCodeInvoker, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(chainCodeInvoker.getChangeRequest() == null){
 			return chainCodeInvoker;//do nothing when it is null
 		}
 		
 		getChangeRequestDAO().save(chainCodeInvoker.getChangeRequest(),options);
 		return chainCodeInvoker;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public ChainCodeInvoker present(ChainCodeInvoker chainCodeInvoker,Map<String, Object> options){
	

		return chainCodeInvoker;
	
	}
		

	

	protected String getTableName(){
		return ChainCodeInvokerTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<ChainCodeInvoker> chainCodeInvokerList) {		
		this.enhanceListInternal(chainCodeInvokerList, this.getChainCodeInvokerMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<ChainCodeInvoker> chainCodeInvokerList = ownerEntity.collectRefsWithType(ChainCodeInvoker.INTERNAL_TYPE);
		this.enhanceList(chainCodeInvokerList);
		
	}
	
	@Override
	public SmartList<ChainCodeInvoker> findChainCodeInvokerWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getChainCodeInvokerMapper());

	}
	@Override
	public int countChainCodeInvokerWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countChainCodeInvokerWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<ChainCodeInvoker> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getChainCodeInvokerMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


