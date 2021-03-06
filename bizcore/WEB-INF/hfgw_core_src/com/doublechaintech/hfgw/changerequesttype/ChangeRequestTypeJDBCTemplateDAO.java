
package com.doublechaintech.hfgw.changerequesttype;

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


import com.doublechaintech.hfgw.changerequest.ChangeRequest;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetworkDAO;
import com.doublechaintech.hfgw.changerequest.ChangeRequestDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class ChangeRequestTypeJDBCTemplateDAO extends HfgwBaseDAOImpl implements ChangeRequestTypeDAO{
 
 	
 	private  HyperledgerNetworkDAO  hyperledgerNetworkDAO;
 	public void setHyperledgerNetworkDAO(HyperledgerNetworkDAO hyperledgerNetworkDAO){
	 	this.hyperledgerNetworkDAO = hyperledgerNetworkDAO;
 	}
 	public HyperledgerNetworkDAO getHyperledgerNetworkDAO(){
	 	return this.hyperledgerNetworkDAO;
 	}


			
		
	
  	private  ChangeRequestDAO  changeRequestDAO;
 	public void setChangeRequestDAO(ChangeRequestDAO pChangeRequestDAO){
 	
 		if(pChangeRequestDAO == null){
 			throw new IllegalStateException("Do not try to set changeRequestDAO to null.");
 		}
	 	this.changeRequestDAO = pChangeRequestDAO;
 	}
 	public ChangeRequestDAO getChangeRequestDAO(){
 		if(this.changeRequestDAO == null){
 			throw new IllegalStateException("The changeRequestDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.changeRequestDAO;
 	}	
 	
			
		

	
	/*
	protected ChangeRequestType load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalChangeRequestType(accessKey, options);
	}
	*/
	
	public SmartList<ChangeRequestType> loadAll() {
	    return this.loadAll(getChangeRequestTypeMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public ChangeRequestType load(String id,Map<String,Object> options) throws Exception{
		return loadInternalChangeRequestType(ChangeRequestTypeTable.withId(id), options);
	}
	
	
	
	public ChangeRequestType loadByCode(String code,Map<String,Object> options) throws Exception{
		return loadInternalChangeRequestType(ChangeRequestTypeTable.withCode( code), options);
	}
	
	
	public ChangeRequestType save(ChangeRequestType changeRequestType,Map<String,Object> options){
		
		String methodName="save(ChangeRequestType changeRequestType,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(changeRequestType, methodName, "changeRequestType");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalChangeRequestType(changeRequestType,options);
	}
	public ChangeRequestType clone(String changeRequestTypeId, Map<String,Object> options) throws Exception{
	
		return clone(ChangeRequestTypeTable.withId(changeRequestTypeId),options);
	}
	
	protected ChangeRequestType clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String changeRequestTypeId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ChangeRequestType newChangeRequestType = loadInternalChangeRequestType(accessKey, options);
		newChangeRequestType.setVersion(0);
		
		
 		
 		if(isSaveChangeRequestListEnabled(options)){
 			for(ChangeRequest item: newChangeRequestType.getChangeRequestList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalChangeRequestType(newChangeRequestType,options);
		
		return newChangeRequestType;
	}
	
	
	
	public ChangeRequestType cloneByCode(String code,Map<String,Object> options) throws Exception{
		return clone(ChangeRequestTypeTable.withCode( code), options);
	}
	
	
	

	protected void throwIfHasException(String changeRequestTypeId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ChangeRequestTypeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ChangeRequestTypeNotFoundException(
					"The " + this.getTableName() + "(" + changeRequestTypeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String changeRequestTypeId, int version) throws Exception{
	
		String methodName="delete(String changeRequestTypeId, int version)";
		assertMethodArgumentNotNull(changeRequestTypeId, methodName, "changeRequestTypeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{changeRequestTypeId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(changeRequestTypeId,version);
		}
		
	
	}
	
	
	
	
	

	public ChangeRequestType disconnectFromAll(String changeRequestTypeId, int version) throws Exception{
	
		
		ChangeRequestType changeRequestType = loadInternalChangeRequestType(ChangeRequestTypeTable.withId(changeRequestTypeId), emptyOptions());
		changeRequestType.clearFromAll();
		this.saveChangeRequestType(changeRequestType);
		return changeRequestType;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ChangeRequestTypeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "change_request_type";
	}
	@Override
	protected String getBeanName() {
		
		return "changeRequestType";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ChangeRequestTypeTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractNetworkEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ChangeRequestTypeTokens.NETWORK);
 	}

 	protected boolean isSaveNetworkEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ChangeRequestTypeTokens.NETWORK);
 	}
 	

 	
 
		
	
	protected boolean isExtractChangeRequestListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ChangeRequestTypeTokens.CHANGE_REQUEST_LIST);
 	}
 	protected boolean isAnalyzeChangeRequestListEnabled(Map<String,Object> options){		 		
 		return ChangeRequestTypeTokens.of(options).analyzeChangeRequestListEnabled();
 	}
	
	protected boolean isSaveChangeRequestListEnabled(Map<String,Object> options){
		return checkOptions(options, ChangeRequestTypeTokens.CHANGE_REQUEST_LIST);
		
 	}
 	
		

	

	protected ChangeRequestTypeMapper getChangeRequestTypeMapper(){
		return new ChangeRequestTypeMapper();
	}

	
	
	protected ChangeRequestType extractChangeRequestType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ChangeRequestType changeRequestType = loadSingleObject(accessKey, getChangeRequestTypeMapper());
			return changeRequestType;
		}catch(EmptyResultDataAccessException e){
			throw new ChangeRequestTypeNotFoundException("ChangeRequestType("+accessKey+") is not found!");
		}

	}

	
	

	protected ChangeRequestType loadInternalChangeRequestType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ChangeRequestType changeRequestType = extractChangeRequestType(accessKey, loadOptions);
 	
 		if(isExtractNetworkEnabled(loadOptions)){
	 		extractNetwork(changeRequestType, loadOptions);
 		}
 
		
		if(isExtractChangeRequestListEnabled(loadOptions)){
	 		extractChangeRequestList(changeRequestType, loadOptions);
 		}	
 		if(isAnalyzeChangeRequestListEnabled(loadOptions)){
	 		analyzeChangeRequestList(changeRequestType, loadOptions);
 		}
 		
		
		return changeRequestType;
		
	}

	 

 	protected ChangeRequestType extractNetwork(ChangeRequestType changeRequestType, Map<String,Object> options) throws Exception{

		if(changeRequestType.getNetwork() == null){
			return changeRequestType;
		}
		String networkId = changeRequestType.getNetwork().getId();
		if( networkId == null){
			return changeRequestType;
		}
		HyperledgerNetwork network = getHyperledgerNetworkDAO().load(networkId,options);
		if(network != null){
			changeRequestType.setNetwork(network);
		}
		
 		
 		return changeRequestType;
 	}
 		
 
		
	protected void enhanceChangeRequestList(SmartList<ChangeRequest> changeRequestList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected ChangeRequestType extractChangeRequestList(ChangeRequestType changeRequestType, Map<String,Object> options){
		
		
		if(changeRequestType == null){
			return null;
		}
		if(changeRequestType.getId() == null){
			return changeRequestType;
		}

		
		
		SmartList<ChangeRequest> changeRequestList = getChangeRequestDAO().findChangeRequestByRequestType(changeRequestType.getId(),options);
		if(changeRequestList != null){
			enhanceChangeRequestList(changeRequestList,options);
			changeRequestType.setChangeRequestList(changeRequestList);
		}
		
		return changeRequestType;
	
	}	
	
	protected ChangeRequestType analyzeChangeRequestList(ChangeRequestType changeRequestType, Map<String,Object> options){
		
		
		if(changeRequestType == null){
			return null;
		}
		if(changeRequestType.getId() == null){
			return changeRequestType;
		}

		
		
		SmartList<ChangeRequest> changeRequestList = changeRequestType.getChangeRequestList();
		if(changeRequestList != null){
			getChangeRequestDAO().analyzeChangeRequestByRequestType(changeRequestList, changeRequestType.getId(), options);
			
		}
		
		return changeRequestType;
	
	}	
	
		
		
  	
 	public SmartList<ChangeRequestType> findChangeRequestTypeByNetwork(String hyperledgerNetworkId,Map<String,Object> options){
 	
  		SmartList<ChangeRequestType> resultList = queryWith(ChangeRequestTypeTable.COLUMN_NETWORK, hyperledgerNetworkId, options, getChangeRequestTypeMapper());
		// analyzeChangeRequestTypeByNetwork(resultList, hyperledgerNetworkId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ChangeRequestType> findChangeRequestTypeByNetwork(String hyperledgerNetworkId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ChangeRequestType> resultList =  queryWithRange(ChangeRequestTypeTable.COLUMN_NETWORK, hyperledgerNetworkId, options, getChangeRequestTypeMapper(), start, count);
 		//analyzeChangeRequestTypeByNetwork(resultList, hyperledgerNetworkId, options);
 		return resultList;
 		
 	}
 	public void analyzeChangeRequestTypeByNetwork(SmartList<ChangeRequestType> resultList, String hyperledgerNetworkId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countChangeRequestTypeByNetwork(String hyperledgerNetworkId,Map<String,Object> options){

 		return countWith(ChangeRequestTypeTable.COLUMN_NETWORK, hyperledgerNetworkId, options);
 	}
 	@Override
	public Map<String, Integer> countChangeRequestTypeByNetworkIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ChangeRequestTypeTable.COLUMN_NETWORK, ids, options);
	}
 	
 	
		
		
		

	

	protected ChangeRequestType saveChangeRequestType(ChangeRequestType  changeRequestType){
		
		if(!changeRequestType.isChanged()){
			return changeRequestType;
		}
		
		
		String SQL=this.getSaveChangeRequestTypeSQL(changeRequestType);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveChangeRequestTypeParameters(changeRequestType);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		changeRequestType.incVersion();
		return changeRequestType;
	
	}
	public SmartList<ChangeRequestType> saveChangeRequestTypeList(SmartList<ChangeRequestType> changeRequestTypeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitChangeRequestTypeList(changeRequestTypeList);
		
		batchChangeRequestTypeCreate((List<ChangeRequestType>)lists[CREATE_LIST_INDEX]);
		
		batchChangeRequestTypeUpdate((List<ChangeRequestType>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ChangeRequestType changeRequestType:changeRequestTypeList){
			if(changeRequestType.isChanged()){
				changeRequestType.incVersion();
			}
			
		
		}
		
		
		return changeRequestTypeList;
	}

	public SmartList<ChangeRequestType> removeChangeRequestTypeList(SmartList<ChangeRequestType> changeRequestTypeList,Map<String,Object> options){
		
		
		super.removeList(changeRequestTypeList, options);
		
		return changeRequestTypeList;
		
		
	}
	
	protected List<Object[]> prepareChangeRequestTypeBatchCreateArgs(List<ChangeRequestType> changeRequestTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ChangeRequestType changeRequestType:changeRequestTypeList ){
			Object [] parameters = prepareChangeRequestTypeCreateParameters(changeRequestType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareChangeRequestTypeBatchUpdateArgs(List<ChangeRequestType> changeRequestTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ChangeRequestType changeRequestType:changeRequestTypeList ){
			if(!changeRequestType.isChanged()){
				continue;
			}
			Object [] parameters = prepareChangeRequestTypeUpdateParameters(changeRequestType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchChangeRequestTypeCreate(List<ChangeRequestType> changeRequestTypeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareChangeRequestTypeBatchCreateArgs(changeRequestTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchChangeRequestTypeUpdate(List<ChangeRequestType> changeRequestTypeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareChangeRequestTypeBatchUpdateArgs(changeRequestTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitChangeRequestTypeList(List<ChangeRequestType> changeRequestTypeList){
		
		List<ChangeRequestType> changeRequestTypeCreateList=new ArrayList<ChangeRequestType>();
		List<ChangeRequestType> changeRequestTypeUpdateList=new ArrayList<ChangeRequestType>();
		
		for(ChangeRequestType changeRequestType: changeRequestTypeList){
			if(isUpdateRequest(changeRequestType)){
				changeRequestTypeUpdateList.add( changeRequestType);
				continue;
			}
			changeRequestTypeCreateList.add(changeRequestType);
		}
		
		return new Object[]{changeRequestTypeCreateList,changeRequestTypeUpdateList};
	}
	
	protected boolean isUpdateRequest(ChangeRequestType changeRequestType){
 		return changeRequestType.getVersion() > 0;
 	}
 	protected String getSaveChangeRequestTypeSQL(ChangeRequestType changeRequestType){
 		if(isUpdateRequest(changeRequestType)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveChangeRequestTypeParameters(ChangeRequestType changeRequestType){
 		if(isUpdateRequest(changeRequestType) ){
 			return prepareChangeRequestTypeUpdateParameters(changeRequestType);
 		}
 		return prepareChangeRequestTypeCreateParameters(changeRequestType);
 	}
 	protected Object[] prepareChangeRequestTypeUpdateParameters(ChangeRequestType changeRequestType){
 		Object[] parameters = new Object[10];
 
 		parameters[0] = changeRequestType.getName();
 		parameters[1] = changeRequestType.getCode();
 		parameters[2] = changeRequestType.getIcon();
 		parameters[3] = changeRequestType.getDisplayOrder();
 		parameters[4] = changeRequestType.getBindTypes();
 		parameters[5] = changeRequestType.getStepConfiguration(); 	
 		if(changeRequestType.getNetwork() != null){
 			parameters[6] = changeRequestType.getNetwork().getId();
 		}
 		
 		parameters[7] = changeRequestType.nextVersion();
 		parameters[8] = changeRequestType.getId();
 		parameters[9] = changeRequestType.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareChangeRequestTypeCreateParameters(ChangeRequestType changeRequestType){
		Object[] parameters = new Object[8];
		String newChangeRequestTypeId=getNextId();
		changeRequestType.setId(newChangeRequestTypeId);
		parameters[0] =  changeRequestType.getId();
 
 		parameters[1] = changeRequestType.getName();
 		parameters[2] = changeRequestType.getCode();
 		parameters[3] = changeRequestType.getIcon();
 		parameters[4] = changeRequestType.getDisplayOrder();
 		parameters[5] = changeRequestType.getBindTypes();
 		parameters[6] = changeRequestType.getStepConfiguration(); 	
 		if(changeRequestType.getNetwork() != null){
 			parameters[7] = changeRequestType.getNetwork().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected ChangeRequestType saveInternalChangeRequestType(ChangeRequestType changeRequestType, Map<String,Object> options){
		
		saveChangeRequestType(changeRequestType);
 	
 		if(isSaveNetworkEnabled(options)){
	 		saveNetwork(changeRequestType, options);
 		}
 
		
		if(isSaveChangeRequestListEnabled(options)){
	 		saveChangeRequestList(changeRequestType, options);
	 		//removeChangeRequestList(changeRequestType, options);
	 		//Not delete the record
	 		
 		}		
		
		return changeRequestType;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ChangeRequestType saveNetwork(ChangeRequestType changeRequestType, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(changeRequestType.getNetwork() == null){
 			return changeRequestType;//do nothing when it is null
 		}
 		
 		getHyperledgerNetworkDAO().save(changeRequestType.getNetwork(),options);
 		return changeRequestType;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public ChangeRequestType planToRemoveChangeRequestList(ChangeRequestType changeRequestType, String changeRequestIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChangeRequest.REQUEST_TYPE_PROPERTY, changeRequestType.getId());
		key.put(ChangeRequest.ID_PROPERTY, changeRequestIds);
		
		SmartList<ChangeRequest> externalChangeRequestList = getChangeRequestDAO().
				findChangeRequestWithKey(key, options);
		if(externalChangeRequestList == null){
			return changeRequestType;
		}
		if(externalChangeRequestList.isEmpty()){
			return changeRequestType;
		}
		
		for(ChangeRequest changeRequestItem: externalChangeRequestList){

			changeRequestItem.clearFromAll();
		}
		
		
		SmartList<ChangeRequest> changeRequestList = changeRequestType.getChangeRequestList();		
		changeRequestList.addAllToRemoveList(externalChangeRequestList);
		return changeRequestType;	
	
	}


	//disconnect ChangeRequestType with network in ChangeRequest
	public ChangeRequestType planToRemoveChangeRequestListWithNetwork(ChangeRequestType changeRequestType, String networkId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChangeRequest.REQUEST_TYPE_PROPERTY, changeRequestType.getId());
		key.put(ChangeRequest.NETWORK_PROPERTY, networkId);
		
		SmartList<ChangeRequest> externalChangeRequestList = getChangeRequestDAO().
				findChangeRequestWithKey(key, options);
		if(externalChangeRequestList == null){
			return changeRequestType;
		}
		if(externalChangeRequestList.isEmpty()){
			return changeRequestType;
		}
		
		for(ChangeRequest changeRequestItem: externalChangeRequestList){
			changeRequestItem.clearNetwork();
			changeRequestItem.clearRequestType();
			
		}
		
		
		SmartList<ChangeRequest> changeRequestList = changeRequestType.getChangeRequestList();		
		changeRequestList.addAllToRemoveList(externalChangeRequestList);
		return changeRequestType;
	}
	
	public int countChangeRequestListWithNetwork(String changeRequestTypeId, String networkId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChangeRequest.REQUEST_TYPE_PROPERTY, changeRequestTypeId);
		key.put(ChangeRequest.NETWORK_PROPERTY, networkId);
		
		int count = getChangeRequestDAO().countChangeRequestWithKey(key, options);
		return count;
	}
	

		
	protected ChangeRequestType saveChangeRequestList(ChangeRequestType changeRequestType, Map<String,Object> options){
		
		
		
		
		SmartList<ChangeRequest> changeRequestList = changeRequestType.getChangeRequestList();
		if(changeRequestList == null){
			//null list means nothing
			return changeRequestType;
		}
		SmartList<ChangeRequest> mergedUpdateChangeRequestList = new SmartList<ChangeRequest>();
		
		
		mergedUpdateChangeRequestList.addAll(changeRequestList); 
		if(changeRequestList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateChangeRequestList.addAll(changeRequestList.getToRemoveList());
			changeRequestList.removeAll(changeRequestList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getChangeRequestDAO().saveChangeRequestList(mergedUpdateChangeRequestList,options);
		
		if(changeRequestList.getToRemoveList() != null){
			changeRequestList.removeAll(changeRequestList.getToRemoveList());
		}
		
		
		return changeRequestType;
	
	}
	
	protected ChangeRequestType removeChangeRequestList(ChangeRequestType changeRequestType, Map<String,Object> options){
	
	
		SmartList<ChangeRequest> changeRequestList = changeRequestType.getChangeRequestList();
		if(changeRequestList == null){
			return changeRequestType;
		}	
	
		SmartList<ChangeRequest> toRemoveChangeRequestList = changeRequestList.getToRemoveList();
		
		if(toRemoveChangeRequestList == null){
			return changeRequestType;
		}
		if(toRemoveChangeRequestList.isEmpty()){
			return changeRequestType;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getChangeRequestDAO().removeChangeRequestList(toRemoveChangeRequestList,options);
		
		return changeRequestType;
	
	}
	
	

 	
 	
	
	
	
		

	public ChangeRequestType present(ChangeRequestType changeRequestType,Map<String, Object> options){
	
		presentChangeRequestList(changeRequestType,options);

		return changeRequestType;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected ChangeRequestType presentChangeRequestList(
			ChangeRequestType changeRequestType,
			Map<String, Object> options) {

		SmartList<ChangeRequest> changeRequestList = changeRequestType.getChangeRequestList();		
				SmartList<ChangeRequest> newList= presentSubList(changeRequestType.getId(),
				changeRequestList,
				options,
				getChangeRequestDAO()::countChangeRequestByRequestType,
				getChangeRequestDAO()::findChangeRequestByRequestType
				);

		
		changeRequestType.setChangeRequestList(newList);
		

		return changeRequestType;
	}			
		

	
    public SmartList<ChangeRequestType> requestCandidateChangeRequestTypeForChangeRequest(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ChangeRequestTypeTable.COLUMN_NAME, filterKey, pageNo, pageSize, getChangeRequestTypeMapper());
    }
		

	protected String getTableName(){
		return ChangeRequestTypeTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<ChangeRequestType> changeRequestTypeList) {		
		this.enhanceListInternal(changeRequestTypeList, this.getChangeRequestTypeMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:ChangeRequest的requestType的ChangeRequestList
	public SmartList<ChangeRequest> loadOurChangeRequestList(HfgwUserContext userContext, List<ChangeRequestType> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChangeRequest.REQUEST_TYPE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ChangeRequest> loadedObjs = userContext.getDAOGroup().getChangeRequestDAO().findChangeRequestWithKey(key, options);
		Map<String, List<ChangeRequest>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getRequestType().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<ChangeRequest> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<ChangeRequest> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setChangeRequestList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<ChangeRequestType> changeRequestTypeList = ownerEntity.collectRefsWithType(ChangeRequestType.INTERNAL_TYPE);
		this.enhanceList(changeRequestTypeList);
		
	}
	
	@Override
	public SmartList<ChangeRequestType> findChangeRequestTypeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getChangeRequestTypeMapper());

	}
	@Override
	public int countChangeRequestTypeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countChangeRequestTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<ChangeRequestType> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getChangeRequestTypeMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


