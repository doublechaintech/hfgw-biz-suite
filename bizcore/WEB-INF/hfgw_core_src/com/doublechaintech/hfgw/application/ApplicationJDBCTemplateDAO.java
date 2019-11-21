
package com.doublechaintech.hfgw.application;

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
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetworkDAO;
import com.doublechaintech.hfgw.servicerecord.ServiceRecordDAO;
import com.doublechaintech.hfgw.channel.ChannelDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class ApplicationJDBCTemplateDAO extends HfgwBaseDAOImpl implements ApplicationDAO{
 
 	
 	private  ChannelDAO  channelDAO;
 	public void setChannelDAO(ChannelDAO channelDAO){
	 	this.channelDAO = channelDAO;
 	}
 	public ChannelDAO getChannelDAO(){
	 	return this.channelDAO;
 	}
 
 	
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
	protected Application load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalApplication(accessKey, options);
	}
	*/
	
	public SmartList<Application> loadAll() {
	    return this.loadAll(getApplicationMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Application load(String id,Map<String,Object> options) throws Exception{
		return loadInternalApplication(ApplicationTable.withId(id), options);
	}
	
	
	
	public Application save(Application application,Map<String,Object> options){
		
		String methodName="save(Application application,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(application, methodName, "application");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalApplication(application,options);
	}
	public Application clone(String applicationId, Map<String,Object> options) throws Exception{
	
		return clone(ApplicationTable.withId(applicationId),options);
	}
	
	protected Application clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String applicationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Application newApplication = loadInternalApplication(accessKey, options);
		newApplication.setVersion(0);
		
		
 		
 		if(isSaveServiceRecordListEnabled(options)){
 			for(ServiceRecord item: newApplication.getServiceRecordList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalApplication(newApplication,options);
		
		return newApplication;
	}
	
	
	
	

	protected void throwIfHasException(String applicationId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ApplicationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ApplicationNotFoundException(
					"The " + this.getTableName() + "(" + applicationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String applicationId, int version) throws Exception{
	
		String methodName="delete(String applicationId, int version)";
		assertMethodArgumentNotNull(applicationId, methodName, "applicationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{applicationId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(applicationId,version);
		}
		
	
	}
	
	
	
	
	

	public Application disconnectFromAll(String applicationId, int version) throws Exception{
	
		
		Application application = loadInternalApplication(ApplicationTable.withId(applicationId), emptyOptions());
		application.clearFromAll();
		this.saveApplication(application);
		return application;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ApplicationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "application";
	}
	@Override
	protected String getBeanName() {
		
		return "application";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ApplicationTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractChannelEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ApplicationTokens.CHANNEL);
 	}

 	protected boolean isSaveChannelEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ApplicationTokens.CHANNEL);
 	}
 	

 	
  

 	protected boolean isExtractNetworkEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ApplicationTokens.NETWORK);
 	}

 	protected boolean isSaveNetworkEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ApplicationTokens.NETWORK);
 	}
 	

 	
 
		
	
	protected boolean isExtractServiceRecordListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ApplicationTokens.SERVICE_RECORD_LIST);
 	}
 	protected boolean isAnalyzeServiceRecordListEnabled(Map<String,Object> options){		 		
 		return ApplicationTokens.of(options).analyzeServiceRecordListEnabled();
 	}
	
	protected boolean isSaveServiceRecordListEnabled(Map<String,Object> options){
		return checkOptions(options, ApplicationTokens.SERVICE_RECORD_LIST);
		
 	}
 	
		

	

	protected ApplicationMapper getApplicationMapper(){
		return new ApplicationMapper();
	}

	
	
	protected Application extractApplication(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Application application = loadSingleObject(accessKey, getApplicationMapper());
			return application;
		}catch(EmptyResultDataAccessException e){
			throw new ApplicationNotFoundException("Application("+accessKey+") is not found!");
		}

	}

	
	

	protected Application loadInternalApplication(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Application application = extractApplication(accessKey, loadOptions);
 	
 		if(isExtractChannelEnabled(loadOptions)){
	 		extractChannel(application, loadOptions);
 		}
  	
 		if(isExtractNetworkEnabled(loadOptions)){
	 		extractNetwork(application, loadOptions);
 		}
 
		
		if(isExtractServiceRecordListEnabled(loadOptions)){
	 		extractServiceRecordList(application, loadOptions);
 		}	
 		if(isAnalyzeServiceRecordListEnabled(loadOptions)){
	 		analyzeServiceRecordList(application, loadOptions);
 		}
 		
		
		return application;
		
	}

	 

 	protected Application extractChannel(Application application, Map<String,Object> options) throws Exception{

		if(application.getChannel() == null){
			return application;
		}
		String channelId = application.getChannel().getId();
		if( channelId == null){
			return application;
		}
		Channel channel = getChannelDAO().load(channelId,options);
		if(channel != null){
			application.setChannel(channel);
		}
		
 		
 		return application;
 	}
 		
  

 	protected Application extractNetwork(Application application, Map<String,Object> options) throws Exception{

		if(application.getNetwork() == null){
			return application;
		}
		String networkId = application.getNetwork().getId();
		if( networkId == null){
			return application;
		}
		HyperledgerNetwork network = getHyperledgerNetworkDAO().load(networkId,options);
		if(network != null){
			application.setNetwork(network);
		}
		
 		
 		return application;
 	}
 		
 
		
	protected void enhanceServiceRecordList(SmartList<ServiceRecord> serviceRecordList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Application extractServiceRecordList(Application application, Map<String,Object> options){
		
		
		if(application == null){
			return null;
		}
		if(application.getId() == null){
			return application;
		}

		
		
		SmartList<ServiceRecord> serviceRecordList = getServiceRecordDAO().findServiceRecordByApplication(application.getId(),options);
		if(serviceRecordList != null){
			enhanceServiceRecordList(serviceRecordList,options);
			application.setServiceRecordList(serviceRecordList);
		}
		
		return application;
	
	}	
	
	protected Application analyzeServiceRecordList(Application application, Map<String,Object> options){
		
		
		if(application == null){
			return null;
		}
		if(application.getId() == null){
			return application;
		}

		
		
		SmartList<ServiceRecord> serviceRecordList = application.getServiceRecordList();
		if(serviceRecordList != null){
			getServiceRecordDAO().analyzeServiceRecordByApplication(serviceRecordList, application.getId(), options);
			
		}
		
		return application;
	
	}	
	
		
		
  	
 	public SmartList<Application> findApplicationByChannel(String channelId,Map<String,Object> options){
 	
  		SmartList<Application> resultList = queryWith(ApplicationTable.COLUMN_CHANNEL, channelId, options, getApplicationMapper());
		// analyzeApplicationByChannel(resultList, channelId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Application> findApplicationByChannel(String channelId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Application> resultList =  queryWithRange(ApplicationTable.COLUMN_CHANNEL, channelId, options, getApplicationMapper(), start, count);
 		//analyzeApplicationByChannel(resultList, channelId, options);
 		return resultList;
 		
 	}
 	public void analyzeApplicationByChannel(SmartList<Application> resultList, String channelId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Application.CHANNEL_PROPERTY, channelId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//Application.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("应用程序");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(Application.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(Application.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countApplicationByChannel(String channelId,Map<String,Object> options){

 		return countWith(ApplicationTable.COLUMN_CHANNEL, channelId, options);
 	}
 	@Override
	public Map<String, Integer> countApplicationByChannelIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ApplicationTable.COLUMN_CHANNEL, ids, options);
	}
 	
  	
 	public SmartList<Application> findApplicationByNetwork(String hyperledgerNetworkId,Map<String,Object> options){
 	
  		SmartList<Application> resultList = queryWith(ApplicationTable.COLUMN_NETWORK, hyperledgerNetworkId, options, getApplicationMapper());
		// analyzeApplicationByNetwork(resultList, hyperledgerNetworkId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Application> findApplicationByNetwork(String hyperledgerNetworkId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Application> resultList =  queryWithRange(ApplicationTable.COLUMN_NETWORK, hyperledgerNetworkId, options, getApplicationMapper(), start, count);
 		//analyzeApplicationByNetwork(resultList, hyperledgerNetworkId, options);
 		return resultList;
 		
 	}
 	public void analyzeApplicationByNetwork(SmartList<Application> resultList, String hyperledgerNetworkId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Application.NETWORK_PROPERTY, hyperledgerNetworkId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//Application.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("应用程序");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(Application.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(Application.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countApplicationByNetwork(String hyperledgerNetworkId,Map<String,Object> options){

 		return countWith(ApplicationTable.COLUMN_NETWORK, hyperledgerNetworkId, options);
 	}
 	@Override
	public Map<String, Integer> countApplicationByNetworkIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ApplicationTable.COLUMN_NETWORK, ids, options);
	}
 	
 	
		
		
		

	

	protected Application saveApplication(Application  application){
		
		if(!application.isChanged()){
			return application;
		}
		
		
		String SQL=this.getSaveApplicationSQL(application);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveApplicationParameters(application);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		application.incVersion();
		return application;
	
	}
	public SmartList<Application> saveApplicationList(SmartList<Application> applicationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitApplicationList(applicationList);
		
		batchApplicationCreate((List<Application>)lists[CREATE_LIST_INDEX]);
		
		batchApplicationUpdate((List<Application>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Application application:applicationList){
			if(application.isChanged()){
				application.incVersion();
			}
			
		
		}
		
		
		return applicationList;
	}

	public SmartList<Application> removeApplicationList(SmartList<Application> applicationList,Map<String,Object> options){
		
		
		super.removeList(applicationList, options);
		
		return applicationList;
		
		
	}
	
	protected List<Object[]> prepareApplicationBatchCreateArgs(List<Application> applicationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Application application:applicationList ){
			Object [] parameters = prepareApplicationCreateParameters(application);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareApplicationBatchUpdateArgs(List<Application> applicationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Application application:applicationList ){
			if(!application.isChanged()){
				continue;
			}
			Object [] parameters = prepareApplicationUpdateParameters(application);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchApplicationCreate(List<Application> applicationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareApplicationBatchCreateArgs(applicationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchApplicationUpdate(List<Application> applicationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareApplicationBatchUpdateArgs(applicationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitApplicationList(List<Application> applicationList){
		
		List<Application> applicationCreateList=new ArrayList<Application>();
		List<Application> applicationUpdateList=new ArrayList<Application>();
		
		for(Application application: applicationList){
			if(isUpdateRequest(application)){
				applicationUpdateList.add( application);
				continue;
			}
			applicationCreateList.add(application);
		}
		
		return new Object[]{applicationCreateList,applicationUpdateList};
	}
	
	protected boolean isUpdateRequest(Application application){
 		return application.getVersion() > 0;
 	}
 	protected String getSaveApplicationSQL(Application application){
 		if(isUpdateRequest(application)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveApplicationParameters(Application application){
 		if(isUpdateRequest(application) ){
 			return prepareApplicationUpdateParameters(application);
 		}
 		return prepareApplicationCreateParameters(application);
 	}
 	protected Object[] prepareApplicationUpdateParameters(Application application){
 		Object[] parameters = new Object[10];
 
 		parameters[0] = application.getName();
 		parameters[1] = application.getCreateTime();
 		parameters[2] = application.getMspid();
 		parameters[3] = application.getPublicKey();
 		parameters[4] = application.getPrivateKey(); 	
 		if(application.getChannel() != null){
 			parameters[5] = application.getChannel().getId();
 		}
  	
 		if(application.getNetwork() != null){
 			parameters[6] = application.getNetwork().getId();
 		}
 		
 		parameters[7] = application.nextVersion();
 		parameters[8] = application.getId();
 		parameters[9] = application.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareApplicationCreateParameters(Application application){
		Object[] parameters = new Object[8];
		String newApplicationId=getNextId();
		application.setId(newApplicationId);
		parameters[0] =  application.getId();
 
 		parameters[1] = application.getName();
 		parameters[2] = application.getCreateTime();
 		parameters[3] = application.getMspid();
 		parameters[4] = application.getPublicKey();
 		parameters[5] = application.getPrivateKey(); 	
 		if(application.getChannel() != null){
 			parameters[6] = application.getChannel().getId();
 		
 		}
 		 	
 		if(application.getNetwork() != null){
 			parameters[7] = application.getNetwork().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected Application saveInternalApplication(Application application, Map<String,Object> options){
		
		saveApplication(application);
 	
 		if(isSaveChannelEnabled(options)){
	 		saveChannel(application, options);
 		}
  	
 		if(isSaveNetworkEnabled(options)){
	 		saveNetwork(application, options);
 		}
 
		
		if(isSaveServiceRecordListEnabled(options)){
	 		saveServiceRecordList(application, options);
	 		//removeServiceRecordList(application, options);
	 		//Not delete the record
	 		
 		}		
		
		return application;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Application saveChannel(Application application, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(application.getChannel() == null){
 			return application;//do nothing when it is null
 		}
 		
 		getChannelDAO().save(application.getChannel(),options);
 		return application;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Application saveNetwork(Application application, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(application.getNetwork() == null){
 			return application;//do nothing when it is null
 		}
 		
 		getHyperledgerNetworkDAO().save(application.getNetwork(),options);
 		return application;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public Application planToRemoveServiceRecordList(Application application, String serviceRecordIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.APPLICATION_PROPERTY, application.getId());
		key.put(ServiceRecord.ID_PROPERTY, serviceRecordIds);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return application;
		}
		if(externalServiceRecordList.isEmpty()){
			return application;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){

			serviceRecordItem.clearFromAll();
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = application.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return application;	
	
	}


	//disconnect Application with channel in ServiceRecord
	public Application planToRemoveServiceRecordListWithChannel(Application application, String channelId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.APPLICATION_PROPERTY, application.getId());
		key.put(ServiceRecord.CHANNEL_PROPERTY, channelId);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return application;
		}
		if(externalServiceRecordList.isEmpty()){
			return application;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){
			serviceRecordItem.clearChannel();
			serviceRecordItem.clearApplication();
			
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = application.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return application;
	}
	
	public int countServiceRecordListWithChannel(String applicationId, String channelId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.APPLICATION_PROPERTY, applicationId);
		key.put(ServiceRecord.CHANNEL_PROPERTY, channelId);
		
		int count = getServiceRecordDAO().countServiceRecordWithKey(key, options);
		return count;
	}
	
	//disconnect Application with chain_code in ServiceRecord
	public Application planToRemoveServiceRecordListWithChainCode(Application application, String chainCodeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.APPLICATION_PROPERTY, application.getId());
		key.put(ServiceRecord.CHAIN_CODE_PROPERTY, chainCodeId);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return application;
		}
		if(externalServiceRecordList.isEmpty()){
			return application;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){
			serviceRecordItem.clearChainCode();
			serviceRecordItem.clearApplication();
			
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = application.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return application;
	}
	
	public int countServiceRecordListWithChainCode(String applicationId, String chainCodeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.APPLICATION_PROPERTY, applicationId);
		key.put(ServiceRecord.CHAIN_CODE_PROPERTY, chainCodeId);
		
		int count = getServiceRecordDAO().countServiceRecordWithKey(key, options);
		return count;
	}
	
	//disconnect Application with transaction_id in ServiceRecord
	public Application planToRemoveServiceRecordListWithTransactionId(Application application, String transactionIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.APPLICATION_PROPERTY, application.getId());
		key.put(ServiceRecord.TRANSACTION_ID_PROPERTY, transactionIdId);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return application;
		}
		if(externalServiceRecordList.isEmpty()){
			return application;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){
			serviceRecordItem.clearTransactionId();
			serviceRecordItem.clearApplication();
			
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = application.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return application;
	}
	
	public int countServiceRecordListWithTransactionId(String applicationId, String transactionIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.APPLICATION_PROPERTY, applicationId);
		key.put(ServiceRecord.TRANSACTION_ID_PROPERTY, transactionIdId);
		
		int count = getServiceRecordDAO().countServiceRecordWithKey(key, options);
		return count;
	}
	
	//disconnect Application with block_id in ServiceRecord
	public Application planToRemoveServiceRecordListWithBlockId(Application application, String blockIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.APPLICATION_PROPERTY, application.getId());
		key.put(ServiceRecord.BLOCK_ID_PROPERTY, blockIdId);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return application;
		}
		if(externalServiceRecordList.isEmpty()){
			return application;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){
			serviceRecordItem.clearBlockId();
			serviceRecordItem.clearApplication();
			
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = application.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return application;
	}
	
	public int countServiceRecordListWithBlockId(String applicationId, String blockIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.APPLICATION_PROPERTY, applicationId);
		key.put(ServiceRecord.BLOCK_ID_PROPERTY, blockIdId);
		
		int count = getServiceRecordDAO().countServiceRecordWithKey(key, options);
		return count;
	}
	
	//disconnect Application with network in ServiceRecord
	public Application planToRemoveServiceRecordListWithNetwork(Application application, String networkId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.APPLICATION_PROPERTY, application.getId());
		key.put(ServiceRecord.NETWORK_PROPERTY, networkId);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return application;
		}
		if(externalServiceRecordList.isEmpty()){
			return application;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){
			serviceRecordItem.clearNetwork();
			serviceRecordItem.clearApplication();
			
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = application.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return application;
	}
	
	public int countServiceRecordListWithNetwork(String applicationId, String networkId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.APPLICATION_PROPERTY, applicationId);
		key.put(ServiceRecord.NETWORK_PROPERTY, networkId);
		
		int count = getServiceRecordDAO().countServiceRecordWithKey(key, options);
		return count;
	}
	

		
	protected Application saveServiceRecordList(Application application, Map<String,Object> options){
		
		
		
		
		SmartList<ServiceRecord> serviceRecordList = application.getServiceRecordList();
		if(serviceRecordList == null){
			//null list means nothing
			return application;
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
		
		
		return application;
	
	}
	
	protected Application removeServiceRecordList(Application application, Map<String,Object> options){
	
	
		SmartList<ServiceRecord> serviceRecordList = application.getServiceRecordList();
		if(serviceRecordList == null){
			return application;
		}	
	
		SmartList<ServiceRecord> toRemoveServiceRecordList = serviceRecordList.getToRemoveList();
		
		if(toRemoveServiceRecordList == null){
			return application;
		}
		if(toRemoveServiceRecordList.isEmpty()){
			return application;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getServiceRecordDAO().removeServiceRecordList(toRemoveServiceRecordList,options);
		
		return application;
	
	}
	
	

 	
 	
	
	
	
		

	public Application present(Application application,Map<String, Object> options){
	
		presentServiceRecordList(application,options);

		return application;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Application presentServiceRecordList(
			Application application,
			Map<String, Object> options) {

		SmartList<ServiceRecord> serviceRecordList = application.getServiceRecordList();		
				SmartList<ServiceRecord> newList= presentSubList(application.getId(),
				serviceRecordList,
				options,
				getServiceRecordDAO()::countServiceRecordByApplication,
				getServiceRecordDAO()::findServiceRecordByApplication
				);

		
		application.setServiceRecordList(newList);
		

		return application;
	}			
		

	
    public SmartList<Application> requestCandidateApplicationForServiceRecord(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ApplicationTable.COLUMN_NAME, filterKey, pageNo, pageSize, getApplicationMapper());
    }
		

	protected String getTableName(){
		return ApplicationTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Application> applicationList) {		
		this.enhanceListInternal(applicationList, this.getApplicationMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:ServiceRecord的application的ServiceRecordList
	public SmartList<ServiceRecord> loadOurServiceRecordList(HfgwUserContext userContext, List<Application> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.APPLICATION_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ServiceRecord> loadedObjs = userContext.getDAOGroup().getServiceRecordDAO().findServiceRecordWithKey(key, options);
		Map<String, List<ServiceRecord>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getApplication().getId()));
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
		List<Application> applicationList = ownerEntity.collectRefsWithType(Application.INTERNAL_TYPE);
		this.enhanceList(applicationList);
		
	}
	
	@Override
	public SmartList<Application> findApplicationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getApplicationMapper());

	}
	@Override
	public int countApplicationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countApplicationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Application> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getApplicationMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


