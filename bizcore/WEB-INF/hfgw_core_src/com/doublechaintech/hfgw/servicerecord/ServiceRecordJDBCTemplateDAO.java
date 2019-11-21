
package com.doublechaintech.hfgw.servicerecord;

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
import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.application.Application;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetworkDAO;
import com.doublechaintech.hfgw.channel.ChannelDAO;
import com.doublechaintech.hfgw.chaincode.ChainCodeDAO;
import com.doublechaintech.hfgw.application.ApplicationDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class ServiceRecordJDBCTemplateDAO extends HfgwBaseDAOImpl implements ServiceRecordDAO{
 
 	
 	private  ChannelDAO  channelDAO;
 	public void setChannelDAO(ChannelDAO channelDAO){
	 	this.channelDAO = channelDAO;
 	}
 	public ChannelDAO getChannelDAO(){
	 	return this.channelDAO;
 	}
 
 	
 	private  ChainCodeDAO  chainCodeDAO;
 	public void setChainCodeDAO(ChainCodeDAO chainCodeDAO){
	 	this.chainCodeDAO = chainCodeDAO;
 	}
 	public ChainCodeDAO getChainCodeDAO(){
	 	return this.chainCodeDAO;
 	}
 
 	
 	private  HyperledgerNetworkDAO  hyperledgerNetworkDAO;
 	public void setHyperledgerNetworkDAO(HyperledgerNetworkDAO hyperledgerNetworkDAO){
	 	this.hyperledgerNetworkDAO = hyperledgerNetworkDAO;
 	}
 	public HyperledgerNetworkDAO getHyperledgerNetworkDAO(){
	 	return this.hyperledgerNetworkDAO;
 	}
 
 	
 	private  ApplicationDAO  applicationDAO;
 	public void setApplicationDAO(ApplicationDAO applicationDAO){
	 	this.applicationDAO = applicationDAO;
 	}
 	public ApplicationDAO getApplicationDAO(){
	 	return this.applicationDAO;
 	}


			
		

	
	/*
	protected ServiceRecord load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalServiceRecord(accessKey, options);
	}
	*/
	
	public SmartList<ServiceRecord> loadAll() {
	    return this.loadAll(getServiceRecordMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public ServiceRecord load(String id,Map<String,Object> options) throws Exception{
		return loadInternalServiceRecord(ServiceRecordTable.withId(id), options);
	}
	
	
	
	public ServiceRecord save(ServiceRecord serviceRecord,Map<String,Object> options){
		
		String methodName="save(ServiceRecord serviceRecord,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(serviceRecord, methodName, "serviceRecord");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalServiceRecord(serviceRecord,options);
	}
	public ServiceRecord clone(String serviceRecordId, Map<String,Object> options) throws Exception{
	
		return clone(ServiceRecordTable.withId(serviceRecordId),options);
	}
	
	protected ServiceRecord clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String serviceRecordId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ServiceRecord newServiceRecord = loadInternalServiceRecord(accessKey, options);
		newServiceRecord.setVersion(0);
		
		

		
		saveInternalServiceRecord(newServiceRecord,options);
		
		return newServiceRecord;
	}
	
	
	
	

	protected void throwIfHasException(String serviceRecordId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ServiceRecordVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ServiceRecordNotFoundException(
					"The " + this.getTableName() + "(" + serviceRecordId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String serviceRecordId, int version) throws Exception{
	
		String methodName="delete(String serviceRecordId, int version)";
		assertMethodArgumentNotNull(serviceRecordId, methodName, "serviceRecordId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{serviceRecordId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(serviceRecordId,version);
		}
		
	
	}
	
	
	
	
	

	public ServiceRecord disconnectFromAll(String serviceRecordId, int version) throws Exception{
	
		
		ServiceRecord serviceRecord = loadInternalServiceRecord(ServiceRecordTable.withId(serviceRecordId), emptyOptions());
		serviceRecord.clearFromAll();
		this.saveServiceRecord(serviceRecord);
		return serviceRecord;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ServiceRecordTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "service_record";
	}
	@Override
	protected String getBeanName() {
		
		return "serviceRecord";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ServiceRecordTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractChannelEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ServiceRecordTokens.CHANNEL);
 	}

 	protected boolean isSaveChannelEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ServiceRecordTokens.CHANNEL);
 	}
 	

 	
  

 	protected boolean isExtractChainCodeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ServiceRecordTokens.CHAINCODE);
 	}

 	protected boolean isSaveChainCodeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ServiceRecordTokens.CHAINCODE);
 	}
 	

 	
  

 	protected boolean isExtractApplicationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ServiceRecordTokens.APPLICATION);
 	}

 	protected boolean isSaveApplicationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ServiceRecordTokens.APPLICATION);
 	}
 	

 	
  

 	protected boolean isExtractNetworkEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ServiceRecordTokens.NETWORK);
 	}

 	protected boolean isSaveNetworkEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ServiceRecordTokens.NETWORK);
 	}
 	

 	
 
		

	

	protected ServiceRecordMapper getServiceRecordMapper(){
		return new ServiceRecordMapper();
	}

	
	
	protected ServiceRecord extractServiceRecord(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ServiceRecord serviceRecord = loadSingleObject(accessKey, getServiceRecordMapper());
			return serviceRecord;
		}catch(EmptyResultDataAccessException e){
			throw new ServiceRecordNotFoundException("ServiceRecord("+accessKey+") is not found!");
		}

	}

	
	

	protected ServiceRecord loadInternalServiceRecord(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ServiceRecord serviceRecord = extractServiceRecord(accessKey, loadOptions);
 	
 		if(isExtractChannelEnabled(loadOptions)){
	 		extractChannel(serviceRecord, loadOptions);
 		}
  	
 		if(isExtractChainCodeEnabled(loadOptions)){
	 		extractChainCode(serviceRecord, loadOptions);
 		}
  	
 		if(isExtractApplicationEnabled(loadOptions)){
	 		extractApplication(serviceRecord, loadOptions);
 		}
  	
 		if(isExtractNetworkEnabled(loadOptions)){
	 		extractNetwork(serviceRecord, loadOptions);
 		}
 
		
		return serviceRecord;
		
	}

	 

 	protected ServiceRecord extractChannel(ServiceRecord serviceRecord, Map<String,Object> options) throws Exception{

		if(serviceRecord.getChannel() == null){
			return serviceRecord;
		}
		String channelId = serviceRecord.getChannel().getId();
		if( channelId == null){
			return serviceRecord;
		}
		Channel channel = getChannelDAO().load(channelId,options);
		if(channel != null){
			serviceRecord.setChannel(channel);
		}
		
 		
 		return serviceRecord;
 	}
 		
  

 	protected ServiceRecord extractChainCode(ServiceRecord serviceRecord, Map<String,Object> options) throws Exception{

		if(serviceRecord.getChainCode() == null){
			return serviceRecord;
		}
		String chainCodeId = serviceRecord.getChainCode().getId();
		if( chainCodeId == null){
			return serviceRecord;
		}
		ChainCode chainCode = getChainCodeDAO().load(chainCodeId,options);
		if(chainCode != null){
			serviceRecord.setChainCode(chainCode);
		}
		
 		
 		return serviceRecord;
 	}
 		
  

 	protected ServiceRecord extractApplication(ServiceRecord serviceRecord, Map<String,Object> options) throws Exception{

		if(serviceRecord.getApplication() == null){
			return serviceRecord;
		}
		String applicationId = serviceRecord.getApplication().getId();
		if( applicationId == null){
			return serviceRecord;
		}
		Application application = getApplicationDAO().load(applicationId,options);
		if(application != null){
			serviceRecord.setApplication(application);
		}
		
 		
 		return serviceRecord;
 	}
 		
  

 	protected ServiceRecord extractNetwork(ServiceRecord serviceRecord, Map<String,Object> options) throws Exception{

		if(serviceRecord.getNetwork() == null){
			return serviceRecord;
		}
		String networkId = serviceRecord.getNetwork().getId();
		if( networkId == null){
			return serviceRecord;
		}
		HyperledgerNetwork network = getHyperledgerNetworkDAO().load(networkId,options);
		if(network != null){
			serviceRecord.setNetwork(network);
		}
		
 		
 		return serviceRecord;
 	}
 		
 
		
		
  	
 	public SmartList<ServiceRecord> findServiceRecordByChannel(String channelId,Map<String,Object> options){
 	
  		SmartList<ServiceRecord> resultList = queryWith(ServiceRecordTable.COLUMN_CHANNEL, channelId, options, getServiceRecordMapper());
		// analyzeServiceRecordByChannel(resultList, channelId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ServiceRecord> findServiceRecordByChannel(String channelId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ServiceRecord> resultList =  queryWithRange(ServiceRecordTable.COLUMN_CHANNEL, channelId, options, getServiceRecordMapper(), start, count);
 		//analyzeServiceRecordByChannel(resultList, channelId, options);
 		return resultList;
 		
 	}
 	public void analyzeServiceRecordByChannel(SmartList<ServiceRecord> resultList, String channelId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ServiceRecord.CHANNEL_PROPERTY, channelId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//ServiceRecord.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("服务记录");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(ServiceRecord.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(ServiceRecord.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countServiceRecordByChannel(String channelId,Map<String,Object> options){

 		return countWith(ServiceRecordTable.COLUMN_CHANNEL, channelId, options);
 	}
 	@Override
	public Map<String, Integer> countServiceRecordByChannelIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ServiceRecordTable.COLUMN_CHANNEL, ids, options);
	}
 	
  	
 	public SmartList<ServiceRecord> findServiceRecordByChainCode(String chainCodeId,Map<String,Object> options){
 	
  		SmartList<ServiceRecord> resultList = queryWith(ServiceRecordTable.COLUMN_CHAIN_CODE, chainCodeId, options, getServiceRecordMapper());
		// analyzeServiceRecordByChainCode(resultList, chainCodeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ServiceRecord> findServiceRecordByChainCode(String chainCodeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ServiceRecord> resultList =  queryWithRange(ServiceRecordTable.COLUMN_CHAIN_CODE, chainCodeId, options, getServiceRecordMapper(), start, count);
 		//analyzeServiceRecordByChainCode(resultList, chainCodeId, options);
 		return resultList;
 		
 	}
 	public void analyzeServiceRecordByChainCode(SmartList<ServiceRecord> resultList, String chainCodeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ServiceRecord.CHAIN_CODE_PROPERTY, chainCodeId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//ServiceRecord.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("服务记录");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(ServiceRecord.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(ServiceRecord.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countServiceRecordByChainCode(String chainCodeId,Map<String,Object> options){

 		return countWith(ServiceRecordTable.COLUMN_CHAIN_CODE, chainCodeId, options);
 	}
 	@Override
	public Map<String, Integer> countServiceRecordByChainCodeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ServiceRecordTable.COLUMN_CHAIN_CODE, ids, options);
	}
 	
  	
 	public SmartList<ServiceRecord> findServiceRecordByApplication(String applicationId,Map<String,Object> options){
 	
  		SmartList<ServiceRecord> resultList = queryWith(ServiceRecordTable.COLUMN_APPLICATION, applicationId, options, getServiceRecordMapper());
		// analyzeServiceRecordByApplication(resultList, applicationId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ServiceRecord> findServiceRecordByApplication(String applicationId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ServiceRecord> resultList =  queryWithRange(ServiceRecordTable.COLUMN_APPLICATION, applicationId, options, getServiceRecordMapper(), start, count);
 		//analyzeServiceRecordByApplication(resultList, applicationId, options);
 		return resultList;
 		
 	}
 	public void analyzeServiceRecordByApplication(SmartList<ServiceRecord> resultList, String applicationId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ServiceRecord.APPLICATION_PROPERTY, applicationId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//ServiceRecord.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("服务记录");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(ServiceRecord.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(ServiceRecord.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countServiceRecordByApplication(String applicationId,Map<String,Object> options){

 		return countWith(ServiceRecordTable.COLUMN_APPLICATION, applicationId, options);
 	}
 	@Override
	public Map<String, Integer> countServiceRecordByApplicationIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ServiceRecordTable.COLUMN_APPLICATION, ids, options);
	}
 	
  	
 	public SmartList<ServiceRecord> findServiceRecordByNetwork(String hyperledgerNetworkId,Map<String,Object> options){
 	
  		SmartList<ServiceRecord> resultList = queryWith(ServiceRecordTable.COLUMN_NETWORK, hyperledgerNetworkId, options, getServiceRecordMapper());
		// analyzeServiceRecordByNetwork(resultList, hyperledgerNetworkId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ServiceRecord> findServiceRecordByNetwork(String hyperledgerNetworkId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ServiceRecord> resultList =  queryWithRange(ServiceRecordTable.COLUMN_NETWORK, hyperledgerNetworkId, options, getServiceRecordMapper(), start, count);
 		//analyzeServiceRecordByNetwork(resultList, hyperledgerNetworkId, options);
 		return resultList;
 		
 	}
 	public void analyzeServiceRecordByNetwork(SmartList<ServiceRecord> resultList, String hyperledgerNetworkId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ServiceRecord.NETWORK_PROPERTY, hyperledgerNetworkId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//ServiceRecord.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("服务记录");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(ServiceRecord.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(ServiceRecord.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countServiceRecordByNetwork(String hyperledgerNetworkId,Map<String,Object> options){

 		return countWith(ServiceRecordTable.COLUMN_NETWORK, hyperledgerNetworkId, options);
 	}
 	@Override
	public Map<String, Integer> countServiceRecordByNetworkIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ServiceRecordTable.COLUMN_NETWORK, ids, options);
	}
 	
 	
		
		
		

	

	protected ServiceRecord saveServiceRecord(ServiceRecord  serviceRecord){
		
		if(!serviceRecord.isChanged()){
			return serviceRecord;
		}
		
		
		String SQL=this.getSaveServiceRecordSQL(serviceRecord);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveServiceRecordParameters(serviceRecord);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		serviceRecord.incVersion();
		return serviceRecord;
	
	}
	public SmartList<ServiceRecord> saveServiceRecordList(SmartList<ServiceRecord> serviceRecordList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitServiceRecordList(serviceRecordList);
		
		batchServiceRecordCreate((List<ServiceRecord>)lists[CREATE_LIST_INDEX]);
		
		batchServiceRecordUpdate((List<ServiceRecord>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ServiceRecord serviceRecord:serviceRecordList){
			if(serviceRecord.isChanged()){
				serviceRecord.incVersion();
			}
			
		
		}
		
		
		return serviceRecordList;
	}

	public SmartList<ServiceRecord> removeServiceRecordList(SmartList<ServiceRecord> serviceRecordList,Map<String,Object> options){
		
		
		super.removeList(serviceRecordList, options);
		
		return serviceRecordList;
		
		
	}
	
	protected List<Object[]> prepareServiceRecordBatchCreateArgs(List<ServiceRecord> serviceRecordList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ServiceRecord serviceRecord:serviceRecordList ){
			Object [] parameters = prepareServiceRecordCreateParameters(serviceRecord);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareServiceRecordBatchUpdateArgs(List<ServiceRecord> serviceRecordList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ServiceRecord serviceRecord:serviceRecordList ){
			if(!serviceRecord.isChanged()){
				continue;
			}
			Object [] parameters = prepareServiceRecordUpdateParameters(serviceRecord);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchServiceRecordCreate(List<ServiceRecord> serviceRecordList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareServiceRecordBatchCreateArgs(serviceRecordList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchServiceRecordUpdate(List<ServiceRecord> serviceRecordList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareServiceRecordBatchUpdateArgs(serviceRecordList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitServiceRecordList(List<ServiceRecord> serviceRecordList){
		
		List<ServiceRecord> serviceRecordCreateList=new ArrayList<ServiceRecord>();
		List<ServiceRecord> serviceRecordUpdateList=new ArrayList<ServiceRecord>();
		
		for(ServiceRecord serviceRecord: serviceRecordList){
			if(isUpdateRequest(serviceRecord)){
				serviceRecordUpdateList.add( serviceRecord);
				continue;
			}
			serviceRecordCreateList.add(serviceRecord);
		}
		
		return new Object[]{serviceRecordCreateList,serviceRecordUpdateList};
	}
	
	protected boolean isUpdateRequest(ServiceRecord serviceRecord){
 		return serviceRecord.getVersion() > 0;
 	}
 	protected String getSaveServiceRecordSQL(ServiceRecord serviceRecord){
 		if(isUpdateRequest(serviceRecord)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveServiceRecordParameters(ServiceRecord serviceRecord){
 		if(isUpdateRequest(serviceRecord) ){
 			return prepareServiceRecordUpdateParameters(serviceRecord);
 		}
 		return prepareServiceRecordCreateParameters(serviceRecord);
 	}
 	protected Object[] prepareServiceRecordUpdateParameters(ServiceRecord serviceRecord){
 		Object[] parameters = new Object[13];
 
 		parameters[0] = serviceRecord.getName();
 		parameters[1] = serviceRecord.getPayLoad(); 	
 		if(serviceRecord.getChannel() != null){
 			parameters[2] = serviceRecord.getChannel().getId();
 		}
  	
 		if(serviceRecord.getChainCode() != null){
 			parameters[3] = serviceRecord.getChainCode().getId();
 		}
 
 		parameters[4] = serviceRecord.getTransactionId();
 		parameters[5] = serviceRecord.getBlockId();
 		parameters[6] = serviceRecord.getCreateTime(); 	
 		if(serviceRecord.getApplication() != null){
 			parameters[7] = serviceRecord.getApplication().getId();
 		}
  	
 		if(serviceRecord.getNetwork() != null){
 			parameters[8] = serviceRecord.getNetwork().getId();
 		}
 
 		parameters[9] = serviceRecord.getCurrentStatus();		
 		parameters[10] = serviceRecord.nextVersion();
 		parameters[11] = serviceRecord.getId();
 		parameters[12] = serviceRecord.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareServiceRecordCreateParameters(ServiceRecord serviceRecord){
		Object[] parameters = new Object[11];
		String newServiceRecordId=getNextId();
		serviceRecord.setId(newServiceRecordId);
		parameters[0] =  serviceRecord.getId();
 
 		parameters[1] = serviceRecord.getName();
 		parameters[2] = serviceRecord.getPayLoad(); 	
 		if(serviceRecord.getChannel() != null){
 			parameters[3] = serviceRecord.getChannel().getId();
 		
 		}
 		 	
 		if(serviceRecord.getChainCode() != null){
 			parameters[4] = serviceRecord.getChainCode().getId();
 		
 		}
 		
 		parameters[5] = serviceRecord.getTransactionId();
 		parameters[6] = serviceRecord.getBlockId();
 		parameters[7] = serviceRecord.getCreateTime(); 	
 		if(serviceRecord.getApplication() != null){
 			parameters[8] = serviceRecord.getApplication().getId();
 		
 		}
 		 	
 		if(serviceRecord.getNetwork() != null){
 			parameters[9] = serviceRecord.getNetwork().getId();
 		
 		}
 		
 		parameters[10] = serviceRecord.getCurrentStatus();		
 				
 		return parameters;
 	}
 	
	protected ServiceRecord saveInternalServiceRecord(ServiceRecord serviceRecord, Map<String,Object> options){
		
		saveServiceRecord(serviceRecord);
 	
 		if(isSaveChannelEnabled(options)){
	 		saveChannel(serviceRecord, options);
 		}
  	
 		if(isSaveChainCodeEnabled(options)){
	 		saveChainCode(serviceRecord, options);
 		}
  	
 		if(isSaveApplicationEnabled(options)){
	 		saveApplication(serviceRecord, options);
 		}
  	
 		if(isSaveNetworkEnabled(options)){
	 		saveNetwork(serviceRecord, options);
 		}
 
		
		return serviceRecord;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ServiceRecord saveChannel(ServiceRecord serviceRecord, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(serviceRecord.getChannel() == null){
 			return serviceRecord;//do nothing when it is null
 		}
 		
 		getChannelDAO().save(serviceRecord.getChannel(),options);
 		return serviceRecord;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected ServiceRecord saveChainCode(ServiceRecord serviceRecord, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(serviceRecord.getChainCode() == null){
 			return serviceRecord;//do nothing when it is null
 		}
 		
 		getChainCodeDAO().save(serviceRecord.getChainCode(),options);
 		return serviceRecord;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected ServiceRecord saveApplication(ServiceRecord serviceRecord, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(serviceRecord.getApplication() == null){
 			return serviceRecord;//do nothing when it is null
 		}
 		
 		getApplicationDAO().save(serviceRecord.getApplication(),options);
 		return serviceRecord;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected ServiceRecord saveNetwork(ServiceRecord serviceRecord, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(serviceRecord.getNetwork() == null){
 			return serviceRecord;//do nothing when it is null
 		}
 		
 		getHyperledgerNetworkDAO().save(serviceRecord.getNetwork(),options);
 		return serviceRecord;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public ServiceRecord present(ServiceRecord serviceRecord,Map<String, Object> options){
	

		return serviceRecord;
	
	}
		

	

	protected String getTableName(){
		return ServiceRecordTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<ServiceRecord> serviceRecordList) {		
		this.enhanceListInternal(serviceRecordList, this.getServiceRecordMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<ServiceRecord> serviceRecordList = ownerEntity.collectRefsWithType(ServiceRecord.INTERNAL_TYPE);
		this.enhanceList(serviceRecordList);
		
	}
	
	@Override
	public SmartList<ServiceRecord> findServiceRecordWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getServiceRecordMapper());

	}
	@Override
	public int countServiceRecordWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countServiceRecordWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<ServiceRecord> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getServiceRecordMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


