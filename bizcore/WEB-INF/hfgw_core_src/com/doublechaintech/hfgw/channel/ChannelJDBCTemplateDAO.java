
package com.doublechaintech.hfgw.channel;

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
import com.doublechaintech.hfgw.node.Node;
import com.doublechaintech.hfgw.channelpeerrole.ChannelPeerRole;
import com.doublechaintech.hfgw.application.Application;
import com.doublechaintech.hfgw.servicerecord.ServiceRecord;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetworkDAO;
import com.doublechaintech.hfgw.channelpeerrole.ChannelPeerRoleDAO;
import com.doublechaintech.hfgw.node.NodeDAO;
import com.doublechaintech.hfgw.servicerecord.ServiceRecordDAO;
import com.doublechaintech.hfgw.chaincode.ChainCodeDAO;
import com.doublechaintech.hfgw.application.ApplicationDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class ChannelJDBCTemplateDAO extends HfgwBaseDAOImpl implements ChannelDAO{
 
 	
 	private  HyperledgerNetworkDAO  hyperledgerNetworkDAO;
 	public void setHyperledgerNetworkDAO(HyperledgerNetworkDAO hyperledgerNetworkDAO){
	 	this.hyperledgerNetworkDAO = hyperledgerNetworkDAO;
 	}
 	public HyperledgerNetworkDAO getHyperledgerNetworkDAO(){
	 	return this.hyperledgerNetworkDAO;
 	}


			
		
	
  	private  NodeDAO  nodeDAO;
 	public void setNodeDAO(NodeDAO pNodeDAO){
 	
 		if(pNodeDAO == null){
 			throw new IllegalStateException("Do not try to set nodeDAO to null.");
 		}
	 	this.nodeDAO = pNodeDAO;
 	}
 	public NodeDAO getNodeDAO(){
 		if(this.nodeDAO == null){
 			throw new IllegalStateException("The nodeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.nodeDAO;
 	}	
 	
			
		
	
  	private  ChannelPeerRoleDAO  channelPeerRoleDAO;
 	public void setChannelPeerRoleDAO(ChannelPeerRoleDAO pChannelPeerRoleDAO){
 	
 		if(pChannelPeerRoleDAO == null){
 			throw new IllegalStateException("Do not try to set channelPeerRoleDAO to null.");
 		}
	 	this.channelPeerRoleDAO = pChannelPeerRoleDAO;
 	}
 	public ChannelPeerRoleDAO getChannelPeerRoleDAO(){
 		if(this.channelPeerRoleDAO == null){
 			throw new IllegalStateException("The channelPeerRoleDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.channelPeerRoleDAO;
 	}	
 	
			
		
	
  	private  ChainCodeDAO  chainCodeDAO;
 	public void setChainCodeDAO(ChainCodeDAO pChainCodeDAO){
 	
 		if(pChainCodeDAO == null){
 			throw new IllegalStateException("Do not try to set chainCodeDAO to null.");
 		}
	 	this.chainCodeDAO = pChainCodeDAO;
 	}
 	public ChainCodeDAO getChainCodeDAO(){
 		if(this.chainCodeDAO == null){
 			throw new IllegalStateException("The chainCodeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.chainCodeDAO;
 	}	
 	
			
		
	
  	private  ApplicationDAO  applicationDAO;
 	public void setApplicationDAO(ApplicationDAO pApplicationDAO){
 	
 		if(pApplicationDAO == null){
 			throw new IllegalStateException("Do not try to set applicationDAO to null.");
 		}
	 	this.applicationDAO = pApplicationDAO;
 	}
 	public ApplicationDAO getApplicationDAO(){
 		if(this.applicationDAO == null){
 			throw new IllegalStateException("The applicationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.applicationDAO;
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
	protected Channel load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalChannel(accessKey, options);
	}
	*/
	
	public SmartList<Channel> loadAll() {
	    return this.loadAll(getChannelMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Channel load(String id,Map<String,Object> options) throws Exception{
		return loadInternalChannel(ChannelTable.withId(id), options);
	}
	
	
	
	public Channel save(Channel channel,Map<String,Object> options){
		
		String methodName="save(Channel channel,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(channel, methodName, "channel");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalChannel(channel,options);
	}
	public Channel clone(String channelId, Map<String,Object> options) throws Exception{
	
		return clone(ChannelTable.withId(channelId),options);
	}
	
	protected Channel clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String channelId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Channel newChannel = loadInternalChannel(accessKey, options);
		newChannel.setVersion(0);
		
		
 		
 		if(isSaveNodeListEnabled(options)){
 			for(Node item: newChannel.getNodeList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveChannelPeerRoleListEnabled(options)){
 			for(ChannelPeerRole item: newChannel.getChannelPeerRoleList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveChainCodeListEnabled(options)){
 			for(ChainCode item: newChannel.getChainCodeList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveApplicationListEnabled(options)){
 			for(Application item: newChannel.getApplicationList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveServiceRecordListEnabled(options)){
 			for(ServiceRecord item: newChannel.getServiceRecordList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalChannel(newChannel,options);
		
		return newChannel;
	}
	
	
	
	

	protected void throwIfHasException(String channelId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ChannelVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ChannelNotFoundException(
					"The " + this.getTableName() + "(" + channelId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String channelId, int version) throws Exception{
	
		String methodName="delete(String channelId, int version)";
		assertMethodArgumentNotNull(channelId, methodName, "channelId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{channelId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(channelId,version);
		}
		
	
	}
	
	
	
	
	

	public Channel disconnectFromAll(String channelId, int version) throws Exception{
	
		
		Channel channel = loadInternalChannel(ChannelTable.withId(channelId), emptyOptions());
		channel.clearFromAll();
		this.saveChannel(channel);
		return channel;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ChannelTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "channel";
	}
	@Override
	protected String getBeanName() {
		
		return "channel";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ChannelTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractNetworkEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ChannelTokens.NETWORK);
 	}

 	protected boolean isSaveNetworkEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ChannelTokens.NETWORK);
 	}
 	

 	
 
		
	
	protected boolean isExtractNodeListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ChannelTokens.NODE_LIST);
 	}
 	protected boolean isAnalyzeNodeListEnabled(Map<String,Object> options){		 		
 		return ChannelTokens.of(options).analyzeNodeListEnabled();
 	}
	
	protected boolean isSaveNodeListEnabled(Map<String,Object> options){
		return checkOptions(options, ChannelTokens.NODE_LIST);
		
 	}
 	
		
	
	protected boolean isExtractChannelPeerRoleListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ChannelTokens.CHANNEL_PEER_ROLE_LIST);
 	}
 	protected boolean isAnalyzeChannelPeerRoleListEnabled(Map<String,Object> options){		 		
 		return ChannelTokens.of(options).analyzeChannelPeerRoleListEnabled();
 	}
	
	protected boolean isSaveChannelPeerRoleListEnabled(Map<String,Object> options){
		return checkOptions(options, ChannelTokens.CHANNEL_PEER_ROLE_LIST);
		
 	}
 	
		
	
	protected boolean isExtractChainCodeListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ChannelTokens.CHAIN_CODE_LIST);
 	}
 	protected boolean isAnalyzeChainCodeListEnabled(Map<String,Object> options){		 		
 		return ChannelTokens.of(options).analyzeChainCodeListEnabled();
 	}
	
	protected boolean isSaveChainCodeListEnabled(Map<String,Object> options){
		return checkOptions(options, ChannelTokens.CHAIN_CODE_LIST);
		
 	}
 	
		
	
	protected boolean isExtractApplicationListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ChannelTokens.APPLICATION_LIST);
 	}
 	protected boolean isAnalyzeApplicationListEnabled(Map<String,Object> options){		 		
 		return ChannelTokens.of(options).analyzeApplicationListEnabled();
 	}
	
	protected boolean isSaveApplicationListEnabled(Map<String,Object> options){
		return checkOptions(options, ChannelTokens.APPLICATION_LIST);
		
 	}
 	
		
	
	protected boolean isExtractServiceRecordListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ChannelTokens.SERVICE_RECORD_LIST);
 	}
 	protected boolean isAnalyzeServiceRecordListEnabled(Map<String,Object> options){		 		
 		return ChannelTokens.of(options).analyzeServiceRecordListEnabled();
 	}
	
	protected boolean isSaveServiceRecordListEnabled(Map<String,Object> options){
		return checkOptions(options, ChannelTokens.SERVICE_RECORD_LIST);
		
 	}
 	
		

	

	protected ChannelMapper getChannelMapper(){
		return new ChannelMapper();
	}

	
	
	protected Channel extractChannel(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Channel channel = loadSingleObject(accessKey, getChannelMapper());
			return channel;
		}catch(EmptyResultDataAccessException e){
			throw new ChannelNotFoundException("Channel("+accessKey+") is not found!");
		}

	}

	
	

	protected Channel loadInternalChannel(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Channel channel = extractChannel(accessKey, loadOptions);
 	
 		if(isExtractNetworkEnabled(loadOptions)){
	 		extractNetwork(channel, loadOptions);
 		}
 
		
		if(isExtractNodeListEnabled(loadOptions)){
	 		extractNodeList(channel, loadOptions);
 		}	
 		if(isAnalyzeNodeListEnabled(loadOptions)){
	 		analyzeNodeList(channel, loadOptions);
 		}
 		
		
		if(isExtractChannelPeerRoleListEnabled(loadOptions)){
	 		extractChannelPeerRoleList(channel, loadOptions);
 		}	
 		if(isAnalyzeChannelPeerRoleListEnabled(loadOptions)){
	 		analyzeChannelPeerRoleList(channel, loadOptions);
 		}
 		
		
		if(isExtractChainCodeListEnabled(loadOptions)){
	 		extractChainCodeList(channel, loadOptions);
 		}	
 		if(isAnalyzeChainCodeListEnabled(loadOptions)){
	 		analyzeChainCodeList(channel, loadOptions);
 		}
 		
		
		if(isExtractApplicationListEnabled(loadOptions)){
	 		extractApplicationList(channel, loadOptions);
 		}	
 		if(isAnalyzeApplicationListEnabled(loadOptions)){
	 		analyzeApplicationList(channel, loadOptions);
 		}
 		
		
		if(isExtractServiceRecordListEnabled(loadOptions)){
	 		extractServiceRecordList(channel, loadOptions);
 		}	
 		if(isAnalyzeServiceRecordListEnabled(loadOptions)){
	 		analyzeServiceRecordList(channel, loadOptions);
 		}
 		
		
		return channel;
		
	}

	 

 	protected Channel extractNetwork(Channel channel, Map<String,Object> options) throws Exception{

		if(channel.getNetwork() == null){
			return channel;
		}
		String networkId = channel.getNetwork().getId();
		if( networkId == null){
			return channel;
		}
		HyperledgerNetwork network = getHyperledgerNetworkDAO().load(networkId,options);
		if(network != null){
			channel.setNetwork(network);
		}
		
 		
 		return channel;
 	}
 		
 
		
	protected void enhanceNodeList(SmartList<Node> nodeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Channel extractNodeList(Channel channel, Map<String,Object> options){
		
		
		if(channel == null){
			return null;
		}
		if(channel.getId() == null){
			return channel;
		}

		
		
		SmartList<Node> nodeList = getNodeDAO().findNodeByChannel(channel.getId(),options);
		if(nodeList != null){
			enhanceNodeList(nodeList,options);
			channel.setNodeList(nodeList);
		}
		
		return channel;
	
	}	
	
	protected Channel analyzeNodeList(Channel channel, Map<String,Object> options){
		
		
		if(channel == null){
			return null;
		}
		if(channel.getId() == null){
			return channel;
		}

		
		
		SmartList<Node> nodeList = channel.getNodeList();
		if(nodeList != null){
			getNodeDAO().analyzeNodeByChannel(nodeList, channel.getId(), options);
			
		}
		
		return channel;
	
	}	
	
		
	protected void enhanceChannelPeerRoleList(SmartList<ChannelPeerRole> channelPeerRoleList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Channel extractChannelPeerRoleList(Channel channel, Map<String,Object> options){
		
		
		if(channel == null){
			return null;
		}
		if(channel.getId() == null){
			return channel;
		}

		
		
		SmartList<ChannelPeerRole> channelPeerRoleList = getChannelPeerRoleDAO().findChannelPeerRoleByChannel(channel.getId(),options);
		if(channelPeerRoleList != null){
			enhanceChannelPeerRoleList(channelPeerRoleList,options);
			channel.setChannelPeerRoleList(channelPeerRoleList);
		}
		
		return channel;
	
	}	
	
	protected Channel analyzeChannelPeerRoleList(Channel channel, Map<String,Object> options){
		
		
		if(channel == null){
			return null;
		}
		if(channel.getId() == null){
			return channel;
		}

		
		
		SmartList<ChannelPeerRole> channelPeerRoleList = channel.getChannelPeerRoleList();
		if(channelPeerRoleList != null){
			getChannelPeerRoleDAO().analyzeChannelPeerRoleByChannel(channelPeerRoleList, channel.getId(), options);
			
		}
		
		return channel;
	
	}	
	
		
	protected void enhanceChainCodeList(SmartList<ChainCode> chainCodeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Channel extractChainCodeList(Channel channel, Map<String,Object> options){
		
		
		if(channel == null){
			return null;
		}
		if(channel.getId() == null){
			return channel;
		}

		
		
		SmartList<ChainCode> chainCodeList = getChainCodeDAO().findChainCodeByChannel(channel.getId(),options);
		if(chainCodeList != null){
			enhanceChainCodeList(chainCodeList,options);
			channel.setChainCodeList(chainCodeList);
		}
		
		return channel;
	
	}	
	
	protected Channel analyzeChainCodeList(Channel channel, Map<String,Object> options){
		
		
		if(channel == null){
			return null;
		}
		if(channel.getId() == null){
			return channel;
		}

		
		
		SmartList<ChainCode> chainCodeList = channel.getChainCodeList();
		if(chainCodeList != null){
			getChainCodeDAO().analyzeChainCodeByChannel(chainCodeList, channel.getId(), options);
			
		}
		
		return channel;
	
	}	
	
		
	protected void enhanceApplicationList(SmartList<Application> applicationList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Channel extractApplicationList(Channel channel, Map<String,Object> options){
		
		
		if(channel == null){
			return null;
		}
		if(channel.getId() == null){
			return channel;
		}

		
		
		SmartList<Application> applicationList = getApplicationDAO().findApplicationByChannel(channel.getId(),options);
		if(applicationList != null){
			enhanceApplicationList(applicationList,options);
			channel.setApplicationList(applicationList);
		}
		
		return channel;
	
	}	
	
	protected Channel analyzeApplicationList(Channel channel, Map<String,Object> options){
		
		
		if(channel == null){
			return null;
		}
		if(channel.getId() == null){
			return channel;
		}

		
		
		SmartList<Application> applicationList = channel.getApplicationList();
		if(applicationList != null){
			getApplicationDAO().analyzeApplicationByChannel(applicationList, channel.getId(), options);
			
		}
		
		return channel;
	
	}	
	
		
	protected void enhanceServiceRecordList(SmartList<ServiceRecord> serviceRecordList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Channel extractServiceRecordList(Channel channel, Map<String,Object> options){
		
		
		if(channel == null){
			return null;
		}
		if(channel.getId() == null){
			return channel;
		}

		
		
		SmartList<ServiceRecord> serviceRecordList = getServiceRecordDAO().findServiceRecordByChannel(channel.getId(),options);
		if(serviceRecordList != null){
			enhanceServiceRecordList(serviceRecordList,options);
			channel.setServiceRecordList(serviceRecordList);
		}
		
		return channel;
	
	}	
	
	protected Channel analyzeServiceRecordList(Channel channel, Map<String,Object> options){
		
		
		if(channel == null){
			return null;
		}
		if(channel.getId() == null){
			return channel;
		}

		
		
		SmartList<ServiceRecord> serviceRecordList = channel.getServiceRecordList();
		if(serviceRecordList != null){
			getServiceRecordDAO().analyzeServiceRecordByChannel(serviceRecordList, channel.getId(), options);
			
		}
		
		return channel;
	
	}	
	
		
		
  	
 	public SmartList<Channel> findChannelByNetwork(String hyperledgerNetworkId,Map<String,Object> options){
 	
  		SmartList<Channel> resultList = queryWith(ChannelTable.COLUMN_NETWORK, hyperledgerNetworkId, options, getChannelMapper());
		// analyzeChannelByNetwork(resultList, hyperledgerNetworkId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Channel> findChannelByNetwork(String hyperledgerNetworkId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Channel> resultList =  queryWithRange(ChannelTable.COLUMN_NETWORK, hyperledgerNetworkId, options, getChannelMapper(), start, count);
 		//analyzeChannelByNetwork(resultList, hyperledgerNetworkId, options);
 		return resultList;
 		
 	}
 	public void analyzeChannelByNetwork(SmartList<Channel> resultList, String hyperledgerNetworkId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countChannelByNetwork(String hyperledgerNetworkId,Map<String,Object> options){

 		return countWith(ChannelTable.COLUMN_NETWORK, hyperledgerNetworkId, options);
 	}
 	@Override
	public Map<String, Integer> countChannelByNetworkIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ChannelTable.COLUMN_NETWORK, ids, options);
	}
 	
 	
		
		
		

	

	protected Channel saveChannel(Channel  channel){
		
		if(!channel.isChanged()){
			return channel;
		}
		
		
		String SQL=this.getSaveChannelSQL(channel);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveChannelParameters(channel);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		channel.incVersion();
		return channel;
	
	}
	public SmartList<Channel> saveChannelList(SmartList<Channel> channelList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitChannelList(channelList);
		
		batchChannelCreate((List<Channel>)lists[CREATE_LIST_INDEX]);
		
		batchChannelUpdate((List<Channel>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Channel channel:channelList){
			if(channel.isChanged()){
				channel.incVersion();
			}
			
		
		}
		
		
		return channelList;
	}

	public SmartList<Channel> removeChannelList(SmartList<Channel> channelList,Map<String,Object> options){
		
		
		super.removeList(channelList, options);
		
		return channelList;
		
		
	}
	
	protected List<Object[]> prepareChannelBatchCreateArgs(List<Channel> channelList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Channel channel:channelList ){
			Object [] parameters = prepareChannelCreateParameters(channel);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareChannelBatchUpdateArgs(List<Channel> channelList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Channel channel:channelList ){
			if(!channel.isChanged()){
				continue;
			}
			Object [] parameters = prepareChannelUpdateParameters(channel);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchChannelCreate(List<Channel> channelList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareChannelBatchCreateArgs(channelList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchChannelUpdate(List<Channel> channelList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareChannelBatchUpdateArgs(channelList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitChannelList(List<Channel> channelList){
		
		List<Channel> channelCreateList=new ArrayList<Channel>();
		List<Channel> channelUpdateList=new ArrayList<Channel>();
		
		for(Channel channel: channelList){
			if(isUpdateRequest(channel)){
				channelUpdateList.add( channel);
				continue;
			}
			channelCreateList.add(channel);
		}
		
		return new Object[]{channelCreateList,channelUpdateList};
	}
	
	protected boolean isUpdateRequest(Channel channel){
 		return channel.getVersion() > 0;
 	}
 	protected String getSaveChannelSQL(Channel channel){
 		if(isUpdateRequest(channel)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveChannelParameters(Channel channel){
 		if(isUpdateRequest(channel) ){
 			return prepareChannelUpdateParameters(channel);
 		}
 		return prepareChannelCreateParameters(channel);
 	}
 	protected Object[] prepareChannelUpdateParameters(Channel channel){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = channel.getName(); 	
 		if(channel.getNetwork() != null){
 			parameters[1] = channel.getNetwork().getId();
 		}
 		
 		parameters[2] = channel.nextVersion();
 		parameters[3] = channel.getId();
 		parameters[4] = channel.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareChannelCreateParameters(Channel channel){
		Object[] parameters = new Object[3];
		String newChannelId=getNextId();
		channel.setId(newChannelId);
		parameters[0] =  channel.getId();
 
 		parameters[1] = channel.getName(); 	
 		if(channel.getNetwork() != null){
 			parameters[2] = channel.getNetwork().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected Channel saveInternalChannel(Channel channel, Map<String,Object> options){
		
		saveChannel(channel);
 	
 		if(isSaveNetworkEnabled(options)){
	 		saveNetwork(channel, options);
 		}
 
		
		if(isSaveNodeListEnabled(options)){
	 		saveNodeList(channel, options);
	 		//removeNodeList(channel, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveChannelPeerRoleListEnabled(options)){
	 		saveChannelPeerRoleList(channel, options);
	 		//removeChannelPeerRoleList(channel, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveChainCodeListEnabled(options)){
	 		saveChainCodeList(channel, options);
	 		//removeChainCodeList(channel, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveApplicationListEnabled(options)){
	 		saveApplicationList(channel, options);
	 		//removeApplicationList(channel, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveServiceRecordListEnabled(options)){
	 		saveServiceRecordList(channel, options);
	 		//removeServiceRecordList(channel, options);
	 		//Not delete the record
	 		
 		}		
		
		return channel;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Channel saveNetwork(Channel channel, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(channel.getNetwork() == null){
 			return channel;//do nothing when it is null
 		}
 		
 		getHyperledgerNetworkDAO().save(channel.getNetwork(),options);
 		return channel;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public Channel planToRemoveNodeList(Channel channel, String nodeIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Node.CHANNEL_PROPERTY, channel.getId());
		key.put(Node.ID_PROPERTY, nodeIds);
		
		SmartList<Node> externalNodeList = getNodeDAO().
				findNodeWithKey(key, options);
		if(externalNodeList == null){
			return channel;
		}
		if(externalNodeList.isEmpty()){
			return channel;
		}
		
		for(Node nodeItem: externalNodeList){

			nodeItem.clearFromAll();
		}
		
		
		SmartList<Node> nodeList = channel.getNodeList();		
		nodeList.addAllToRemoveList(externalNodeList);
		return channel;	
	
	}


	//disconnect Channel with organization in Node
	public Channel planToRemoveNodeListWithOrganization(Channel channel, String organizationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Node.CHANNEL_PROPERTY, channel.getId());
		key.put(Node.ORGANIZATION_PROPERTY, organizationId);
		
		SmartList<Node> externalNodeList = getNodeDAO().
				findNodeWithKey(key, options);
		if(externalNodeList == null){
			return channel;
		}
		if(externalNodeList.isEmpty()){
			return channel;
		}
		
		for(Node nodeItem: externalNodeList){
			nodeItem.clearOrganization();
			nodeItem.clearChannel();
			
		}
		
		
		SmartList<Node> nodeList = channel.getNodeList();		
		nodeList.addAllToRemoveList(externalNodeList);
		return channel;
	}
	
	public int countNodeListWithOrganization(String channelId, String organizationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Node.CHANNEL_PROPERTY, channelId);
		key.put(Node.ORGANIZATION_PROPERTY, organizationId);
		
		int count = getNodeDAO().countNodeWithKey(key, options);
		return count;
	}
	
	//disconnect Channel with network in Node
	public Channel planToRemoveNodeListWithNetwork(Channel channel, String networkId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Node.CHANNEL_PROPERTY, channel.getId());
		key.put(Node.NETWORK_PROPERTY, networkId);
		
		SmartList<Node> externalNodeList = getNodeDAO().
				findNodeWithKey(key, options);
		if(externalNodeList == null){
			return channel;
		}
		if(externalNodeList.isEmpty()){
			return channel;
		}
		
		for(Node nodeItem: externalNodeList){
			nodeItem.clearNetwork();
			nodeItem.clearChannel();
			
		}
		
		
		SmartList<Node> nodeList = channel.getNodeList();		
		nodeList.addAllToRemoveList(externalNodeList);
		return channel;
	}
	
	public int countNodeListWithNetwork(String channelId, String networkId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Node.CHANNEL_PROPERTY, channelId);
		key.put(Node.NETWORK_PROPERTY, networkId);
		
		int count = getNodeDAO().countNodeWithKey(key, options);
		return count;
	}
	
	//disconnect Channel with type in Node
	public Channel planToRemoveNodeListWithType(Channel channel, String typeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Node.CHANNEL_PROPERTY, channel.getId());
		key.put(Node.TYPE_PROPERTY, typeId);
		
		SmartList<Node> externalNodeList = getNodeDAO().
				findNodeWithKey(key, options);
		if(externalNodeList == null){
			return channel;
		}
		if(externalNodeList.isEmpty()){
			return channel;
		}
		
		for(Node nodeItem: externalNodeList){
			nodeItem.clearType();
			nodeItem.clearChannel();
			
		}
		
		
		SmartList<Node> nodeList = channel.getNodeList();		
		nodeList.addAllToRemoveList(externalNodeList);
		return channel;
	}
	
	public int countNodeListWithType(String channelId, String typeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Node.CHANNEL_PROPERTY, channelId);
		key.put(Node.TYPE_PROPERTY, typeId);
		
		int count = getNodeDAO().countNodeWithKey(key, options);
		return count;
	}
	
	public Channel planToRemoveChannelPeerRoleList(Channel channel, String channelPeerRoleIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChannelPeerRole.CHANNEL_PROPERTY, channel.getId());
		key.put(ChannelPeerRole.ID_PROPERTY, channelPeerRoleIds);
		
		SmartList<ChannelPeerRole> externalChannelPeerRoleList = getChannelPeerRoleDAO().
				findChannelPeerRoleWithKey(key, options);
		if(externalChannelPeerRoleList == null){
			return channel;
		}
		if(externalChannelPeerRoleList.isEmpty()){
			return channel;
		}
		
		for(ChannelPeerRole channelPeerRoleItem: externalChannelPeerRoleList){

			channelPeerRoleItem.clearFromAll();
		}
		
		
		SmartList<ChannelPeerRole> channelPeerRoleList = channel.getChannelPeerRoleList();		
		channelPeerRoleList.addAllToRemoveList(externalChannelPeerRoleList);
		return channel;	
	
	}


	//disconnect Channel with node in ChannelPeerRole
	public Channel planToRemoveChannelPeerRoleListWithNode(Channel channel, String nodeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChannelPeerRole.CHANNEL_PROPERTY, channel.getId());
		key.put(ChannelPeerRole.NODE_PROPERTY, nodeId);
		
		SmartList<ChannelPeerRole> externalChannelPeerRoleList = getChannelPeerRoleDAO().
				findChannelPeerRoleWithKey(key, options);
		if(externalChannelPeerRoleList == null){
			return channel;
		}
		if(externalChannelPeerRoleList.isEmpty()){
			return channel;
		}
		
		for(ChannelPeerRole channelPeerRoleItem: externalChannelPeerRoleList){
			channelPeerRoleItem.clearNode();
			channelPeerRoleItem.clearChannel();
			
		}
		
		
		SmartList<ChannelPeerRole> channelPeerRoleList = channel.getChannelPeerRoleList();		
		channelPeerRoleList.addAllToRemoveList(externalChannelPeerRoleList);
		return channel;
	}
	
	public int countChannelPeerRoleListWithNode(String channelId, String nodeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChannelPeerRole.CHANNEL_PROPERTY, channelId);
		key.put(ChannelPeerRole.NODE_PROPERTY, nodeId);
		
		int count = getChannelPeerRoleDAO().countChannelPeerRoleWithKey(key, options);
		return count;
	}
	
	//disconnect Channel with peer_role in ChannelPeerRole
	public Channel planToRemoveChannelPeerRoleListWithPeerRole(Channel channel, String peerRoleId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChannelPeerRole.CHANNEL_PROPERTY, channel.getId());
		key.put(ChannelPeerRole.PEER_ROLE_PROPERTY, peerRoleId);
		
		SmartList<ChannelPeerRole> externalChannelPeerRoleList = getChannelPeerRoleDAO().
				findChannelPeerRoleWithKey(key, options);
		if(externalChannelPeerRoleList == null){
			return channel;
		}
		if(externalChannelPeerRoleList.isEmpty()){
			return channel;
		}
		
		for(ChannelPeerRole channelPeerRoleItem: externalChannelPeerRoleList){
			channelPeerRoleItem.clearPeerRole();
			channelPeerRoleItem.clearChannel();
			
		}
		
		
		SmartList<ChannelPeerRole> channelPeerRoleList = channel.getChannelPeerRoleList();		
		channelPeerRoleList.addAllToRemoveList(externalChannelPeerRoleList);
		return channel;
	}
	
	public int countChannelPeerRoleListWithPeerRole(String channelId, String peerRoleId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChannelPeerRole.CHANNEL_PROPERTY, channelId);
		key.put(ChannelPeerRole.PEER_ROLE_PROPERTY, peerRoleId);
		
		int count = getChannelPeerRoleDAO().countChannelPeerRoleWithKey(key, options);
		return count;
	}
	
	public Channel planToRemoveChainCodeList(Channel channel, String chainCodeIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChainCode.CHANNEL_PROPERTY, channel.getId());
		key.put(ChainCode.ID_PROPERTY, chainCodeIds);
		
		SmartList<ChainCode> externalChainCodeList = getChainCodeDAO().
				findChainCodeWithKey(key, options);
		if(externalChainCodeList == null){
			return channel;
		}
		if(externalChainCodeList.isEmpty()){
			return channel;
		}
		
		for(ChainCode chainCodeItem: externalChainCodeList){

			chainCodeItem.clearFromAll();
		}
		
		
		SmartList<ChainCode> chainCodeList = channel.getChainCodeList();		
		chainCodeList.addAllToRemoveList(externalChainCodeList);
		return channel;	
	
	}


	public Channel planToRemoveApplicationList(Channel channel, String applicationIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Application.CHANNEL_PROPERTY, channel.getId());
		key.put(Application.ID_PROPERTY, applicationIds);
		
		SmartList<Application> externalApplicationList = getApplicationDAO().
				findApplicationWithKey(key, options);
		if(externalApplicationList == null){
			return channel;
		}
		if(externalApplicationList.isEmpty()){
			return channel;
		}
		
		for(Application applicationItem: externalApplicationList){

			applicationItem.clearFromAll();
		}
		
		
		SmartList<Application> applicationList = channel.getApplicationList();		
		applicationList.addAllToRemoveList(externalApplicationList);
		return channel;	
	
	}


	//disconnect Channel with network in Application
	public Channel planToRemoveApplicationListWithNetwork(Channel channel, String networkId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Application.CHANNEL_PROPERTY, channel.getId());
		key.put(Application.NETWORK_PROPERTY, networkId);
		
		SmartList<Application> externalApplicationList = getApplicationDAO().
				findApplicationWithKey(key, options);
		if(externalApplicationList == null){
			return channel;
		}
		if(externalApplicationList.isEmpty()){
			return channel;
		}
		
		for(Application applicationItem: externalApplicationList){
			applicationItem.clearNetwork();
			applicationItem.clearChannel();
			
		}
		
		
		SmartList<Application> applicationList = channel.getApplicationList();		
		applicationList.addAllToRemoveList(externalApplicationList);
		return channel;
	}
	
	public int countApplicationListWithNetwork(String channelId, String networkId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Application.CHANNEL_PROPERTY, channelId);
		key.put(Application.NETWORK_PROPERTY, networkId);
		
		int count = getApplicationDAO().countApplicationWithKey(key, options);
		return count;
	}
	
	public Channel planToRemoveServiceRecordList(Channel channel, String serviceRecordIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.CHANNEL_PROPERTY, channel.getId());
		key.put(ServiceRecord.ID_PROPERTY, serviceRecordIds);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return channel;
		}
		if(externalServiceRecordList.isEmpty()){
			return channel;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){

			serviceRecordItem.clearFromAll();
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = channel.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return channel;	
	
	}


	//disconnect Channel with transaction_id in ServiceRecord
	public Channel planToRemoveServiceRecordListWithTransactionId(Channel channel, String transactionIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.CHANNEL_PROPERTY, channel.getId());
		key.put(ServiceRecord.TRANSACTION_ID_PROPERTY, transactionIdId);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return channel;
		}
		if(externalServiceRecordList.isEmpty()){
			return channel;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){
			serviceRecordItem.clearTransactionId();
			serviceRecordItem.clearChannel();
			
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = channel.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return channel;
	}
	
	public int countServiceRecordListWithTransactionId(String channelId, String transactionIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.CHANNEL_PROPERTY, channelId);
		key.put(ServiceRecord.TRANSACTION_ID_PROPERTY, transactionIdId);
		
		int count = getServiceRecordDAO().countServiceRecordWithKey(key, options);
		return count;
	}
	
	//disconnect Channel with chain_code in ServiceRecord
	public Channel planToRemoveServiceRecordListWithChainCode(Channel channel, String chainCodeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.CHANNEL_PROPERTY, channel.getId());
		key.put(ServiceRecord.CHAIN_CODE_PROPERTY, chainCodeId);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return channel;
		}
		if(externalServiceRecordList.isEmpty()){
			return channel;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){
			serviceRecordItem.clearChainCode();
			serviceRecordItem.clearChannel();
			
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = channel.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return channel;
	}
	
	public int countServiceRecordListWithChainCode(String channelId, String chainCodeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.CHANNEL_PROPERTY, channelId);
		key.put(ServiceRecord.CHAIN_CODE_PROPERTY, chainCodeId);
		
		int count = getServiceRecordDAO().countServiceRecordWithKey(key, options);
		return count;
	}
	
	//disconnect Channel with block_id in ServiceRecord
	public Channel planToRemoveServiceRecordListWithBlockId(Channel channel, String blockIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.CHANNEL_PROPERTY, channel.getId());
		key.put(ServiceRecord.BLOCK_ID_PROPERTY, blockIdId);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return channel;
		}
		if(externalServiceRecordList.isEmpty()){
			return channel;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){
			serviceRecordItem.clearBlockId();
			serviceRecordItem.clearChannel();
			
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = channel.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return channel;
	}
	
	public int countServiceRecordListWithBlockId(String channelId, String blockIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.CHANNEL_PROPERTY, channelId);
		key.put(ServiceRecord.BLOCK_ID_PROPERTY, blockIdId);
		
		int count = getServiceRecordDAO().countServiceRecordWithKey(key, options);
		return count;
	}
	
	//disconnect Channel with app_client in ServiceRecord
	public Channel planToRemoveServiceRecordListWithAppClient(Channel channel, String appClientId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.CHANNEL_PROPERTY, channel.getId());
		key.put(ServiceRecord.APP_CLIENT_PROPERTY, appClientId);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return channel;
		}
		if(externalServiceRecordList.isEmpty()){
			return channel;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){
			serviceRecordItem.clearAppClient();
			serviceRecordItem.clearChannel();
			
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = channel.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return channel;
	}
	
	public int countServiceRecordListWithAppClient(String channelId, String appClientId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.CHANNEL_PROPERTY, channelId);
		key.put(ServiceRecord.APP_CLIENT_PROPERTY, appClientId);
		
		int count = getServiceRecordDAO().countServiceRecordWithKey(key, options);
		return count;
	}
	
	//disconnect Channel with network in ServiceRecord
	public Channel planToRemoveServiceRecordListWithNetwork(Channel channel, String networkId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.CHANNEL_PROPERTY, channel.getId());
		key.put(ServiceRecord.NETWORK_PROPERTY, networkId);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return channel;
		}
		if(externalServiceRecordList.isEmpty()){
			return channel;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){
			serviceRecordItem.clearNetwork();
			serviceRecordItem.clearChannel();
			
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = channel.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return channel;
	}
	
	public int countServiceRecordListWithNetwork(String channelId, String networkId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.CHANNEL_PROPERTY, channelId);
		key.put(ServiceRecord.NETWORK_PROPERTY, networkId);
		
		int count = getServiceRecordDAO().countServiceRecordWithKey(key, options);
		return count;
	}
	
	//disconnect Channel with status in ServiceRecord
	public Channel planToRemoveServiceRecordListWithStatus(Channel channel, String statusId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.CHANNEL_PROPERTY, channel.getId());
		key.put(ServiceRecord.STATUS_PROPERTY, statusId);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return channel;
		}
		if(externalServiceRecordList.isEmpty()){
			return channel;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){
			serviceRecordItem.clearStatus();
			serviceRecordItem.clearChannel();
			
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = channel.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return channel;
	}
	
	public int countServiceRecordListWithStatus(String channelId, String statusId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.CHANNEL_PROPERTY, channelId);
		key.put(ServiceRecord.STATUS_PROPERTY, statusId);
		
		int count = getServiceRecordDAO().countServiceRecordWithKey(key, options);
		return count;
	}
	

		
	protected Channel saveNodeList(Channel channel, Map<String,Object> options){
		
		
		
		
		SmartList<Node> nodeList = channel.getNodeList();
		if(nodeList == null){
			//null list means nothing
			return channel;
		}
		SmartList<Node> mergedUpdateNodeList = new SmartList<Node>();
		
		
		mergedUpdateNodeList.addAll(nodeList); 
		if(nodeList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateNodeList.addAll(nodeList.getToRemoveList());
			nodeList.removeAll(nodeList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getNodeDAO().saveNodeList(mergedUpdateNodeList,options);
		
		if(nodeList.getToRemoveList() != null){
			nodeList.removeAll(nodeList.getToRemoveList());
		}
		
		
		return channel;
	
	}
	
	protected Channel removeNodeList(Channel channel, Map<String,Object> options){
	
	
		SmartList<Node> nodeList = channel.getNodeList();
		if(nodeList == null){
			return channel;
		}	
	
		SmartList<Node> toRemoveNodeList = nodeList.getToRemoveList();
		
		if(toRemoveNodeList == null){
			return channel;
		}
		if(toRemoveNodeList.isEmpty()){
			return channel;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getNodeDAO().removeNodeList(toRemoveNodeList,options);
		
		return channel;
	
	}
	
	

 	
 	
	
	
	
		
	protected Channel saveChannelPeerRoleList(Channel channel, Map<String,Object> options){
		
		
		
		
		SmartList<ChannelPeerRole> channelPeerRoleList = channel.getChannelPeerRoleList();
		if(channelPeerRoleList == null){
			//null list means nothing
			return channel;
		}
		SmartList<ChannelPeerRole> mergedUpdateChannelPeerRoleList = new SmartList<ChannelPeerRole>();
		
		
		mergedUpdateChannelPeerRoleList.addAll(channelPeerRoleList); 
		if(channelPeerRoleList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateChannelPeerRoleList.addAll(channelPeerRoleList.getToRemoveList());
			channelPeerRoleList.removeAll(channelPeerRoleList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getChannelPeerRoleDAO().saveChannelPeerRoleList(mergedUpdateChannelPeerRoleList,options);
		
		if(channelPeerRoleList.getToRemoveList() != null){
			channelPeerRoleList.removeAll(channelPeerRoleList.getToRemoveList());
		}
		
		
		return channel;
	
	}
	
	protected Channel removeChannelPeerRoleList(Channel channel, Map<String,Object> options){
	
	
		SmartList<ChannelPeerRole> channelPeerRoleList = channel.getChannelPeerRoleList();
		if(channelPeerRoleList == null){
			return channel;
		}	
	
		SmartList<ChannelPeerRole> toRemoveChannelPeerRoleList = channelPeerRoleList.getToRemoveList();
		
		if(toRemoveChannelPeerRoleList == null){
			return channel;
		}
		if(toRemoveChannelPeerRoleList.isEmpty()){
			return channel;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getChannelPeerRoleDAO().removeChannelPeerRoleList(toRemoveChannelPeerRoleList,options);
		
		return channel;
	
	}
	
	

 	
 	
	
	
	
		
	protected Channel saveChainCodeList(Channel channel, Map<String,Object> options){
		
		
		
		
		SmartList<ChainCode> chainCodeList = channel.getChainCodeList();
		if(chainCodeList == null){
			//null list means nothing
			return channel;
		}
		SmartList<ChainCode> mergedUpdateChainCodeList = new SmartList<ChainCode>();
		
		
		mergedUpdateChainCodeList.addAll(chainCodeList); 
		if(chainCodeList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateChainCodeList.addAll(chainCodeList.getToRemoveList());
			chainCodeList.removeAll(chainCodeList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getChainCodeDAO().saveChainCodeList(mergedUpdateChainCodeList,options);
		
		if(chainCodeList.getToRemoveList() != null){
			chainCodeList.removeAll(chainCodeList.getToRemoveList());
		}
		
		
		return channel;
	
	}
	
	protected Channel removeChainCodeList(Channel channel, Map<String,Object> options){
	
	
		SmartList<ChainCode> chainCodeList = channel.getChainCodeList();
		if(chainCodeList == null){
			return channel;
		}	
	
		SmartList<ChainCode> toRemoveChainCodeList = chainCodeList.getToRemoveList();
		
		if(toRemoveChainCodeList == null){
			return channel;
		}
		if(toRemoveChainCodeList.isEmpty()){
			return channel;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getChainCodeDAO().removeChainCodeList(toRemoveChainCodeList,options);
		
		return channel;
	
	}
	
	

 	
 	
	
	
	
		
	protected Channel saveApplicationList(Channel channel, Map<String,Object> options){
		
		
		
		
		SmartList<Application> applicationList = channel.getApplicationList();
		if(applicationList == null){
			//null list means nothing
			return channel;
		}
		SmartList<Application> mergedUpdateApplicationList = new SmartList<Application>();
		
		
		mergedUpdateApplicationList.addAll(applicationList); 
		if(applicationList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateApplicationList.addAll(applicationList.getToRemoveList());
			applicationList.removeAll(applicationList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getApplicationDAO().saveApplicationList(mergedUpdateApplicationList,options);
		
		if(applicationList.getToRemoveList() != null){
			applicationList.removeAll(applicationList.getToRemoveList());
		}
		
		
		return channel;
	
	}
	
	protected Channel removeApplicationList(Channel channel, Map<String,Object> options){
	
	
		SmartList<Application> applicationList = channel.getApplicationList();
		if(applicationList == null){
			return channel;
		}	
	
		SmartList<Application> toRemoveApplicationList = applicationList.getToRemoveList();
		
		if(toRemoveApplicationList == null){
			return channel;
		}
		if(toRemoveApplicationList.isEmpty()){
			return channel;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getApplicationDAO().removeApplicationList(toRemoveApplicationList,options);
		
		return channel;
	
	}
	
	

 	
 	
	
	
	
		
	protected Channel saveServiceRecordList(Channel channel, Map<String,Object> options){
		
		
		
		
		SmartList<ServiceRecord> serviceRecordList = channel.getServiceRecordList();
		if(serviceRecordList == null){
			//null list means nothing
			return channel;
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
		
		
		return channel;
	
	}
	
	protected Channel removeServiceRecordList(Channel channel, Map<String,Object> options){
	
	
		SmartList<ServiceRecord> serviceRecordList = channel.getServiceRecordList();
		if(serviceRecordList == null){
			return channel;
		}	
	
		SmartList<ServiceRecord> toRemoveServiceRecordList = serviceRecordList.getToRemoveList();
		
		if(toRemoveServiceRecordList == null){
			return channel;
		}
		if(toRemoveServiceRecordList.isEmpty()){
			return channel;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getServiceRecordDAO().removeServiceRecordList(toRemoveServiceRecordList,options);
		
		return channel;
	
	}
	
	

 	
 	
	
	
	
		

	public Channel present(Channel channel,Map<String, Object> options){
	
		presentNodeList(channel,options);
		presentChannelPeerRoleList(channel,options);
		presentChainCodeList(channel,options);
		presentApplicationList(channel,options);
		presentServiceRecordList(channel,options);

		return channel;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Channel presentNodeList(
			Channel channel,
			Map<String, Object> options) {

		SmartList<Node> nodeList = channel.getNodeList();		
				SmartList<Node> newList= presentSubList(channel.getId(),
				nodeList,
				options,
				getNodeDAO()::countNodeByChannel,
				getNodeDAO()::findNodeByChannel
				);

		
		channel.setNodeList(newList);
		

		return channel;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Channel presentChannelPeerRoleList(
			Channel channel,
			Map<String, Object> options) {

		SmartList<ChannelPeerRole> channelPeerRoleList = channel.getChannelPeerRoleList();		
				SmartList<ChannelPeerRole> newList= presentSubList(channel.getId(),
				channelPeerRoleList,
				options,
				getChannelPeerRoleDAO()::countChannelPeerRoleByChannel,
				getChannelPeerRoleDAO()::findChannelPeerRoleByChannel
				);

		
		channel.setChannelPeerRoleList(newList);
		

		return channel;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Channel presentChainCodeList(
			Channel channel,
			Map<String, Object> options) {

		SmartList<ChainCode> chainCodeList = channel.getChainCodeList();		
				SmartList<ChainCode> newList= presentSubList(channel.getId(),
				chainCodeList,
				options,
				getChainCodeDAO()::countChainCodeByChannel,
				getChainCodeDAO()::findChainCodeByChannel
				);

		
		channel.setChainCodeList(newList);
		

		return channel;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Channel presentApplicationList(
			Channel channel,
			Map<String, Object> options) {

		SmartList<Application> applicationList = channel.getApplicationList();		
				SmartList<Application> newList= presentSubList(channel.getId(),
				applicationList,
				options,
				getApplicationDAO()::countApplicationByChannel,
				getApplicationDAO()::findApplicationByChannel
				);

		
		channel.setApplicationList(newList);
		

		return channel;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Channel presentServiceRecordList(
			Channel channel,
			Map<String, Object> options) {

		SmartList<ServiceRecord> serviceRecordList = channel.getServiceRecordList();		
				SmartList<ServiceRecord> newList= presentSubList(channel.getId(),
				serviceRecordList,
				options,
				getServiceRecordDAO()::countServiceRecordByChannel,
				getServiceRecordDAO()::findServiceRecordByChannel
				);

		
		channel.setServiceRecordList(newList);
		

		return channel;
	}			
		

	
    public SmartList<Channel> requestCandidateChannelForNode(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ChannelTable.COLUMN_NAME, filterKey, pageNo, pageSize, getChannelMapper());
    }
		
    public SmartList<Channel> requestCandidateChannelForChannelPeerRole(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ChannelTable.COLUMN_NAME, filterKey, pageNo, pageSize, getChannelMapper());
    }
		
    public SmartList<Channel> requestCandidateChannelForChainCode(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ChannelTable.COLUMN_NAME, filterKey, pageNo, pageSize, getChannelMapper());
    }
		
    public SmartList<Channel> requestCandidateChannelForApplication(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ChannelTable.COLUMN_NAME, filterKey, pageNo, pageSize, getChannelMapper());
    }
		
    public SmartList<Channel> requestCandidateChannelForServiceRecord(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ChannelTable.COLUMN_NAME, filterKey, pageNo, pageSize, getChannelMapper());
    }
		

	protected String getTableName(){
		return ChannelTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Channel> channelList) {		
		this.enhanceListInternal(channelList, this.getChannelMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:Node的channel的NodeList
	public SmartList<Node> loadOurNodeList(HfgwUserContext userContext, List<Channel> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Node.CHANNEL_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Node> loadedObjs = userContext.getDAOGroup().getNodeDAO().findNodeWithKey(key, options);
		Map<String, List<Node>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getChannel().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<Node> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<Node> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setNodeList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:ChannelPeerRole的channel的ChannelPeerRoleList
	public SmartList<ChannelPeerRole> loadOurChannelPeerRoleList(HfgwUserContext userContext, List<Channel> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChannelPeerRole.CHANNEL_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ChannelPeerRole> loadedObjs = userContext.getDAOGroup().getChannelPeerRoleDAO().findChannelPeerRoleWithKey(key, options);
		Map<String, List<ChannelPeerRole>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getChannel().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<ChannelPeerRole> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<ChannelPeerRole> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setChannelPeerRoleList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:ChainCode的channel的ChainCodeList
	public SmartList<ChainCode> loadOurChainCodeList(HfgwUserContext userContext, List<Channel> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChainCode.CHANNEL_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ChainCode> loadedObjs = userContext.getDAOGroup().getChainCodeDAO().findChainCodeWithKey(key, options);
		Map<String, List<ChainCode>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getChannel().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<ChainCode> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<ChainCode> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setChainCodeList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:Application的channel的ApplicationList
	public SmartList<Application> loadOurApplicationList(HfgwUserContext userContext, List<Channel> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Application.CHANNEL_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Application> loadedObjs = userContext.getDAOGroup().getApplicationDAO().findApplicationWithKey(key, options);
		Map<String, List<Application>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getChannel().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<Application> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<Application> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setApplicationList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:ServiceRecord的channel的ServiceRecordList
	public SmartList<ServiceRecord> loadOurServiceRecordList(HfgwUserContext userContext, List<Channel> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.CHANNEL_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ServiceRecord> loadedObjs = userContext.getDAOGroup().getServiceRecordDAO().findServiceRecordWithKey(key, options);
		Map<String, List<ServiceRecord>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getChannel().getId()));
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
		List<Channel> channelList = ownerEntity.collectRefsWithType(Channel.INTERNAL_TYPE);
		this.enhanceList(channelList);
		
	}
	
	@Override
	public SmartList<Channel> findChannelWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getChannelMapper());

	}
	@Override
	public int countChannelWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countChannelWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Channel> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getChannelMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


