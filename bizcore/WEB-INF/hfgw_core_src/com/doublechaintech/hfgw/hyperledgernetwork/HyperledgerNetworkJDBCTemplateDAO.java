
package com.doublechaintech.hfgw.hyperledgernetwork;

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
import com.doublechaintech.hfgw.organization.Organization;
import com.doublechaintech.hfgw.nodetype.NodeType;
import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.application.Application;
import com.doublechaintech.hfgw.changerequesttype.ChangeRequestType;
import com.doublechaintech.hfgw.servicerecord.ServiceRecord;

import com.doublechaintech.hfgw.organization.OrganizationDAO;
import com.doublechaintech.hfgw.servicerecord.ServiceRecordDAO;
import com.doublechaintech.hfgw.channel.ChannelDAO;
import com.doublechaintech.hfgw.changerequest.ChangeRequestDAO;
import com.doublechaintech.hfgw.application.ApplicationDAO;
import com.doublechaintech.hfgw.nodetype.NodeTypeDAO;
import com.doublechaintech.hfgw.changerequesttype.ChangeRequestTypeDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class HyperledgerNetworkJDBCTemplateDAO extends HfgwBaseDAOImpl implements HyperledgerNetworkDAO{


			
		
	
  	private  OrganizationDAO  organizationDAO;
 	public void setOrganizationDAO(OrganizationDAO pOrganizationDAO){
 	
 		if(pOrganizationDAO == null){
 			throw new IllegalStateException("Do not try to set organizationDAO to null.");
 		}
	 	this.organizationDAO = pOrganizationDAO;
 	}
 	public OrganizationDAO getOrganizationDAO(){
 		if(this.organizationDAO == null){
 			throw new IllegalStateException("The organizationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.organizationDAO;
 	}	
 	
			
		
	
  	private  NodeTypeDAO  nodeTypeDAO;
 	public void setNodeTypeDAO(NodeTypeDAO pNodeTypeDAO){
 	
 		if(pNodeTypeDAO == null){
 			throw new IllegalStateException("Do not try to set nodeTypeDAO to null.");
 		}
	 	this.nodeTypeDAO = pNodeTypeDAO;
 	}
 	public NodeTypeDAO getNodeTypeDAO(){
 		if(this.nodeTypeDAO == null){
 			throw new IllegalStateException("The nodeTypeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.nodeTypeDAO;
 	}	
 	
			
		
	
  	private  ChannelDAO  channelDAO;
 	public void setChannelDAO(ChannelDAO pChannelDAO){
 	
 		if(pChannelDAO == null){
 			throw new IllegalStateException("Do not try to set channelDAO to null.");
 		}
	 	this.channelDAO = pChannelDAO;
 	}
 	public ChannelDAO getChannelDAO(){
 		if(this.channelDAO == null){
 			throw new IllegalStateException("The channelDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.channelDAO;
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
 	
			
		
	
  	private  ChangeRequestTypeDAO  changeRequestTypeDAO;
 	public void setChangeRequestTypeDAO(ChangeRequestTypeDAO pChangeRequestTypeDAO){
 	
 		if(pChangeRequestTypeDAO == null){
 			throw new IllegalStateException("Do not try to set changeRequestTypeDAO to null.");
 		}
	 	this.changeRequestTypeDAO = pChangeRequestTypeDAO;
 	}
 	public ChangeRequestTypeDAO getChangeRequestTypeDAO(){
 		if(this.changeRequestTypeDAO == null){
 			throw new IllegalStateException("The changeRequestTypeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.changeRequestTypeDAO;
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
	protected HyperledgerNetwork load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalHyperledgerNetwork(accessKey, options);
	}
	*/
	
	public SmartList<HyperledgerNetwork> loadAll() {
	    return this.loadAll(getHyperledgerNetworkMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public HyperledgerNetwork load(String id,Map<String,Object> options) throws Exception{
		return loadInternalHyperledgerNetwork(HyperledgerNetworkTable.withId(id), options);
	}
	
	
	
	public HyperledgerNetwork save(HyperledgerNetwork hyperledgerNetwork,Map<String,Object> options){
		
		String methodName="save(HyperledgerNetwork hyperledgerNetwork,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(hyperledgerNetwork, methodName, "hyperledgerNetwork");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalHyperledgerNetwork(hyperledgerNetwork,options);
	}
	public HyperledgerNetwork clone(String hyperledgerNetworkId, Map<String,Object> options) throws Exception{
	
		return clone(HyperledgerNetworkTable.withId(hyperledgerNetworkId),options);
	}
	
	protected HyperledgerNetwork clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String hyperledgerNetworkId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		HyperledgerNetwork newHyperledgerNetwork = loadInternalHyperledgerNetwork(accessKey, options);
		newHyperledgerNetwork.setVersion(0);
		
		
 		
 		if(isSaveOrganizationListEnabled(options)){
 			for(Organization item: newHyperledgerNetwork.getOrganizationList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveNodeTypeListEnabled(options)){
 			for(NodeType item: newHyperledgerNetwork.getNodeTypeList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveChannelListEnabled(options)){
 			for(Channel item: newHyperledgerNetwork.getChannelList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveApplicationListEnabled(options)){
 			for(Application item: newHyperledgerNetwork.getApplicationList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveServiceRecordListEnabled(options)){
 			for(ServiceRecord item: newHyperledgerNetwork.getServiceRecordList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveChangeRequestTypeListEnabled(options)){
 			for(ChangeRequestType item: newHyperledgerNetwork.getChangeRequestTypeList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveChangeRequestListEnabled(options)){
 			for(ChangeRequest item: newHyperledgerNetwork.getChangeRequestList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalHyperledgerNetwork(newHyperledgerNetwork,options);
		
		return newHyperledgerNetwork;
	}
	
	
	
	

	protected void throwIfHasException(String hyperledgerNetworkId,int version,int count) throws Exception{
		if (count == 1) {
			throw new HyperledgerNetworkVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new HyperledgerNetworkNotFoundException(
					"The " + this.getTableName() + "(" + hyperledgerNetworkId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String hyperledgerNetworkId, int version) throws Exception{
	
		String methodName="delete(String hyperledgerNetworkId, int version)";
		assertMethodArgumentNotNull(hyperledgerNetworkId, methodName, "hyperledgerNetworkId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{hyperledgerNetworkId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(hyperledgerNetworkId,version);
		}
		
	
	}
	
	
	
	
	

	public HyperledgerNetwork disconnectFromAll(String hyperledgerNetworkId, int version) throws Exception{
	
		
		HyperledgerNetwork hyperledgerNetwork = loadInternalHyperledgerNetwork(HyperledgerNetworkTable.withId(hyperledgerNetworkId), emptyOptions());
		hyperledgerNetwork.clearFromAll();
		this.saveHyperledgerNetwork(hyperledgerNetwork);
		return hyperledgerNetwork;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return HyperledgerNetworkTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "hyperledger_network";
	}
	@Override
	protected String getBeanName() {
		
		return "hyperledgerNetwork";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return HyperledgerNetworkTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractOrganizationListEnabled(Map<String,Object> options){		
 		return checkOptions(options,HyperledgerNetworkTokens.ORGANIZATION_LIST);
 	}
 	protected boolean isAnalyzeOrganizationListEnabled(Map<String,Object> options){		 		
 		return HyperledgerNetworkTokens.of(options).analyzeOrganizationListEnabled();
 	}
	
	protected boolean isSaveOrganizationListEnabled(Map<String,Object> options){
		return checkOptions(options, HyperledgerNetworkTokens.ORGANIZATION_LIST);
		
 	}
 	
		
	
	protected boolean isExtractNodeTypeListEnabled(Map<String,Object> options){		
 		return checkOptions(options,HyperledgerNetworkTokens.NODE_TYPE_LIST);
 	}
 	protected boolean isAnalyzeNodeTypeListEnabled(Map<String,Object> options){		 		
 		return HyperledgerNetworkTokens.of(options).analyzeNodeTypeListEnabled();
 	}
	
	protected boolean isSaveNodeTypeListEnabled(Map<String,Object> options){
		return checkOptions(options, HyperledgerNetworkTokens.NODE_TYPE_LIST);
		
 	}
 	
		
	
	protected boolean isExtractChannelListEnabled(Map<String,Object> options){		
 		return checkOptions(options,HyperledgerNetworkTokens.CHANNEL_LIST);
 	}
 	protected boolean isAnalyzeChannelListEnabled(Map<String,Object> options){		 		
 		return HyperledgerNetworkTokens.of(options).analyzeChannelListEnabled();
 	}
	
	protected boolean isSaveChannelListEnabled(Map<String,Object> options){
		return checkOptions(options, HyperledgerNetworkTokens.CHANNEL_LIST);
		
 	}
 	
		
	
	protected boolean isExtractApplicationListEnabled(Map<String,Object> options){		
 		return checkOptions(options,HyperledgerNetworkTokens.APPLICATION_LIST);
 	}
 	protected boolean isAnalyzeApplicationListEnabled(Map<String,Object> options){		 		
 		return HyperledgerNetworkTokens.of(options).analyzeApplicationListEnabled();
 	}
	
	protected boolean isSaveApplicationListEnabled(Map<String,Object> options){
		return checkOptions(options, HyperledgerNetworkTokens.APPLICATION_LIST);
		
 	}
 	
		
	
	protected boolean isExtractServiceRecordListEnabled(Map<String,Object> options){		
 		return checkOptions(options,HyperledgerNetworkTokens.SERVICE_RECORD_LIST);
 	}
 	protected boolean isAnalyzeServiceRecordListEnabled(Map<String,Object> options){		 		
 		return HyperledgerNetworkTokens.of(options).analyzeServiceRecordListEnabled();
 	}
	
	protected boolean isSaveServiceRecordListEnabled(Map<String,Object> options){
		return checkOptions(options, HyperledgerNetworkTokens.SERVICE_RECORD_LIST);
		
 	}
 	
		
	
	protected boolean isExtractChangeRequestTypeListEnabled(Map<String,Object> options){		
 		return checkOptions(options,HyperledgerNetworkTokens.CHANGE_REQUEST_TYPE_LIST);
 	}
 	protected boolean isAnalyzeChangeRequestTypeListEnabled(Map<String,Object> options){		 		
 		return HyperledgerNetworkTokens.of(options).analyzeChangeRequestTypeListEnabled();
 	}
	
	protected boolean isSaveChangeRequestTypeListEnabled(Map<String,Object> options){
		return checkOptions(options, HyperledgerNetworkTokens.CHANGE_REQUEST_TYPE_LIST);
		
 	}
 	
		
	
	protected boolean isExtractChangeRequestListEnabled(Map<String,Object> options){		
 		return checkOptions(options,HyperledgerNetworkTokens.CHANGE_REQUEST_LIST);
 	}
 	protected boolean isAnalyzeChangeRequestListEnabled(Map<String,Object> options){		 		
 		return HyperledgerNetworkTokens.of(options).analyzeChangeRequestListEnabled();
 	}
	
	protected boolean isSaveChangeRequestListEnabled(Map<String,Object> options){
		return checkOptions(options, HyperledgerNetworkTokens.CHANGE_REQUEST_LIST);
		
 	}
 	
		

	

	protected HyperledgerNetworkMapper getHyperledgerNetworkMapper(){
		return new HyperledgerNetworkMapper();
	}

	
	
	protected HyperledgerNetwork extractHyperledgerNetwork(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			HyperledgerNetwork hyperledgerNetwork = loadSingleObject(accessKey, getHyperledgerNetworkMapper());
			return hyperledgerNetwork;
		}catch(EmptyResultDataAccessException e){
			throw new HyperledgerNetworkNotFoundException("HyperledgerNetwork("+accessKey+") is not found!");
		}

	}

	
	

	protected HyperledgerNetwork loadInternalHyperledgerNetwork(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		HyperledgerNetwork hyperledgerNetwork = extractHyperledgerNetwork(accessKey, loadOptions);

		
		if(isExtractOrganizationListEnabled(loadOptions)){
	 		extractOrganizationList(hyperledgerNetwork, loadOptions);
 		}	
 		if(isAnalyzeOrganizationListEnabled(loadOptions)){
	 		analyzeOrganizationList(hyperledgerNetwork, loadOptions);
 		}
 		
		
		if(isExtractNodeTypeListEnabled(loadOptions)){
	 		extractNodeTypeList(hyperledgerNetwork, loadOptions);
 		}	
 		if(isAnalyzeNodeTypeListEnabled(loadOptions)){
	 		analyzeNodeTypeList(hyperledgerNetwork, loadOptions);
 		}
 		
		
		if(isExtractChannelListEnabled(loadOptions)){
	 		extractChannelList(hyperledgerNetwork, loadOptions);
 		}	
 		if(isAnalyzeChannelListEnabled(loadOptions)){
	 		analyzeChannelList(hyperledgerNetwork, loadOptions);
 		}
 		
		
		if(isExtractApplicationListEnabled(loadOptions)){
	 		extractApplicationList(hyperledgerNetwork, loadOptions);
 		}	
 		if(isAnalyzeApplicationListEnabled(loadOptions)){
	 		analyzeApplicationList(hyperledgerNetwork, loadOptions);
 		}
 		
		
		if(isExtractServiceRecordListEnabled(loadOptions)){
	 		extractServiceRecordList(hyperledgerNetwork, loadOptions);
 		}	
 		if(isAnalyzeServiceRecordListEnabled(loadOptions)){
	 		analyzeServiceRecordList(hyperledgerNetwork, loadOptions);
 		}
 		
		
		if(isExtractChangeRequestTypeListEnabled(loadOptions)){
	 		extractChangeRequestTypeList(hyperledgerNetwork, loadOptions);
 		}	
 		if(isAnalyzeChangeRequestTypeListEnabled(loadOptions)){
	 		analyzeChangeRequestTypeList(hyperledgerNetwork, loadOptions);
 		}
 		
		
		if(isExtractChangeRequestListEnabled(loadOptions)){
	 		extractChangeRequestList(hyperledgerNetwork, loadOptions);
 		}	
 		if(isAnalyzeChangeRequestListEnabled(loadOptions)){
	 		analyzeChangeRequestList(hyperledgerNetwork, loadOptions);
 		}
 		
		
		return hyperledgerNetwork;
		
	}

	
		
	protected void enhanceOrganizationList(SmartList<Organization> organizationList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected HyperledgerNetwork extractOrganizationList(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
		
		
		if(hyperledgerNetwork == null){
			return null;
		}
		if(hyperledgerNetwork.getId() == null){
			return hyperledgerNetwork;
		}

		
		
		SmartList<Organization> organizationList = getOrganizationDAO().findOrganizationByNetwork(hyperledgerNetwork.getId(),options);
		if(organizationList != null){
			enhanceOrganizationList(organizationList,options);
			hyperledgerNetwork.setOrganizationList(organizationList);
		}
		
		return hyperledgerNetwork;
	
	}	
	
	protected HyperledgerNetwork analyzeOrganizationList(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
		
		
		if(hyperledgerNetwork == null){
			return null;
		}
		if(hyperledgerNetwork.getId() == null){
			return hyperledgerNetwork;
		}

		
		
		SmartList<Organization> organizationList = hyperledgerNetwork.getOrganizationList();
		if(organizationList != null){
			getOrganizationDAO().analyzeOrganizationByNetwork(organizationList, hyperledgerNetwork.getId(), options);
			
		}
		
		return hyperledgerNetwork;
	
	}	
	
		
	protected void enhanceNodeTypeList(SmartList<NodeType> nodeTypeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected HyperledgerNetwork extractNodeTypeList(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
		
		
		if(hyperledgerNetwork == null){
			return null;
		}
		if(hyperledgerNetwork.getId() == null){
			return hyperledgerNetwork;
		}

		
		
		SmartList<NodeType> nodeTypeList = getNodeTypeDAO().findNodeTypeByNetwork(hyperledgerNetwork.getId(),options);
		if(nodeTypeList != null){
			enhanceNodeTypeList(nodeTypeList,options);
			hyperledgerNetwork.setNodeTypeList(nodeTypeList);
		}
		
		return hyperledgerNetwork;
	
	}	
	
	protected HyperledgerNetwork analyzeNodeTypeList(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
		
		
		if(hyperledgerNetwork == null){
			return null;
		}
		if(hyperledgerNetwork.getId() == null){
			return hyperledgerNetwork;
		}

		
		
		SmartList<NodeType> nodeTypeList = hyperledgerNetwork.getNodeTypeList();
		if(nodeTypeList != null){
			getNodeTypeDAO().analyzeNodeTypeByNetwork(nodeTypeList, hyperledgerNetwork.getId(), options);
			
		}
		
		return hyperledgerNetwork;
	
	}	
	
		
	protected void enhanceChannelList(SmartList<Channel> channelList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected HyperledgerNetwork extractChannelList(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
		
		
		if(hyperledgerNetwork == null){
			return null;
		}
		if(hyperledgerNetwork.getId() == null){
			return hyperledgerNetwork;
		}

		
		
		SmartList<Channel> channelList = getChannelDAO().findChannelByNetwork(hyperledgerNetwork.getId(),options);
		if(channelList != null){
			enhanceChannelList(channelList,options);
			hyperledgerNetwork.setChannelList(channelList);
		}
		
		return hyperledgerNetwork;
	
	}	
	
	protected HyperledgerNetwork analyzeChannelList(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
		
		
		if(hyperledgerNetwork == null){
			return null;
		}
		if(hyperledgerNetwork.getId() == null){
			return hyperledgerNetwork;
		}

		
		
		SmartList<Channel> channelList = hyperledgerNetwork.getChannelList();
		if(channelList != null){
			getChannelDAO().analyzeChannelByNetwork(channelList, hyperledgerNetwork.getId(), options);
			
		}
		
		return hyperledgerNetwork;
	
	}	
	
		
	protected void enhanceApplicationList(SmartList<Application> applicationList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected HyperledgerNetwork extractApplicationList(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
		
		
		if(hyperledgerNetwork == null){
			return null;
		}
		if(hyperledgerNetwork.getId() == null){
			return hyperledgerNetwork;
		}

		
		
		SmartList<Application> applicationList = getApplicationDAO().findApplicationByNetwork(hyperledgerNetwork.getId(),options);
		if(applicationList != null){
			enhanceApplicationList(applicationList,options);
			hyperledgerNetwork.setApplicationList(applicationList);
		}
		
		return hyperledgerNetwork;
	
	}	
	
	protected HyperledgerNetwork analyzeApplicationList(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
		
		
		if(hyperledgerNetwork == null){
			return null;
		}
		if(hyperledgerNetwork.getId() == null){
			return hyperledgerNetwork;
		}

		
		
		SmartList<Application> applicationList = hyperledgerNetwork.getApplicationList();
		if(applicationList != null){
			getApplicationDAO().analyzeApplicationByNetwork(applicationList, hyperledgerNetwork.getId(), options);
			
		}
		
		return hyperledgerNetwork;
	
	}	
	
		
	protected void enhanceServiceRecordList(SmartList<ServiceRecord> serviceRecordList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected HyperledgerNetwork extractServiceRecordList(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
		
		
		if(hyperledgerNetwork == null){
			return null;
		}
		if(hyperledgerNetwork.getId() == null){
			return hyperledgerNetwork;
		}

		
		
		SmartList<ServiceRecord> serviceRecordList = getServiceRecordDAO().findServiceRecordByNetwork(hyperledgerNetwork.getId(),options);
		if(serviceRecordList != null){
			enhanceServiceRecordList(serviceRecordList,options);
			hyperledgerNetwork.setServiceRecordList(serviceRecordList);
		}
		
		return hyperledgerNetwork;
	
	}	
	
	protected HyperledgerNetwork analyzeServiceRecordList(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
		
		
		if(hyperledgerNetwork == null){
			return null;
		}
		if(hyperledgerNetwork.getId() == null){
			return hyperledgerNetwork;
		}

		
		
		SmartList<ServiceRecord> serviceRecordList = hyperledgerNetwork.getServiceRecordList();
		if(serviceRecordList != null){
			getServiceRecordDAO().analyzeServiceRecordByNetwork(serviceRecordList, hyperledgerNetwork.getId(), options);
			
		}
		
		return hyperledgerNetwork;
	
	}	
	
		
	protected void enhanceChangeRequestTypeList(SmartList<ChangeRequestType> changeRequestTypeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected HyperledgerNetwork extractChangeRequestTypeList(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
		
		
		if(hyperledgerNetwork == null){
			return null;
		}
		if(hyperledgerNetwork.getId() == null){
			return hyperledgerNetwork;
		}

		
		
		SmartList<ChangeRequestType> changeRequestTypeList = getChangeRequestTypeDAO().findChangeRequestTypeByNetwork(hyperledgerNetwork.getId(),options);
		if(changeRequestTypeList != null){
			enhanceChangeRequestTypeList(changeRequestTypeList,options);
			hyperledgerNetwork.setChangeRequestTypeList(changeRequestTypeList);
		}
		
		return hyperledgerNetwork;
	
	}	
	
	protected HyperledgerNetwork analyzeChangeRequestTypeList(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
		
		
		if(hyperledgerNetwork == null){
			return null;
		}
		if(hyperledgerNetwork.getId() == null){
			return hyperledgerNetwork;
		}

		
		
		SmartList<ChangeRequestType> changeRequestTypeList = hyperledgerNetwork.getChangeRequestTypeList();
		if(changeRequestTypeList != null){
			getChangeRequestTypeDAO().analyzeChangeRequestTypeByNetwork(changeRequestTypeList, hyperledgerNetwork.getId(), options);
			
		}
		
		return hyperledgerNetwork;
	
	}	
	
		
	protected void enhanceChangeRequestList(SmartList<ChangeRequest> changeRequestList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected HyperledgerNetwork extractChangeRequestList(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
		
		
		if(hyperledgerNetwork == null){
			return null;
		}
		if(hyperledgerNetwork.getId() == null){
			return hyperledgerNetwork;
		}

		
		
		SmartList<ChangeRequest> changeRequestList = getChangeRequestDAO().findChangeRequestByNetwork(hyperledgerNetwork.getId(),options);
		if(changeRequestList != null){
			enhanceChangeRequestList(changeRequestList,options);
			hyperledgerNetwork.setChangeRequestList(changeRequestList);
		}
		
		return hyperledgerNetwork;
	
	}	
	
	protected HyperledgerNetwork analyzeChangeRequestList(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
		
		
		if(hyperledgerNetwork == null){
			return null;
		}
		if(hyperledgerNetwork.getId() == null){
			return hyperledgerNetwork;
		}

		
		
		SmartList<ChangeRequest> changeRequestList = hyperledgerNetwork.getChangeRequestList();
		if(changeRequestList != null){
			getChangeRequestDAO().analyzeChangeRequestByNetwork(changeRequestList, hyperledgerNetwork.getId(), options);
			
		}
		
		return hyperledgerNetwork;
	
	}	
	
		
		
 	
		
		
		

	

	protected HyperledgerNetwork saveHyperledgerNetwork(HyperledgerNetwork  hyperledgerNetwork){
		
		if(!hyperledgerNetwork.isChanged()){
			return hyperledgerNetwork;
		}
		
		
		String SQL=this.getSaveHyperledgerNetworkSQL(hyperledgerNetwork);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveHyperledgerNetworkParameters(hyperledgerNetwork);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		hyperledgerNetwork.incVersion();
		return hyperledgerNetwork;
	
	}
	public SmartList<HyperledgerNetwork> saveHyperledgerNetworkList(SmartList<HyperledgerNetwork> hyperledgerNetworkList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitHyperledgerNetworkList(hyperledgerNetworkList);
		
		batchHyperledgerNetworkCreate((List<HyperledgerNetwork>)lists[CREATE_LIST_INDEX]);
		
		batchHyperledgerNetworkUpdate((List<HyperledgerNetwork>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(HyperledgerNetwork hyperledgerNetwork:hyperledgerNetworkList){
			if(hyperledgerNetwork.isChanged()){
				hyperledgerNetwork.incVersion();
			}
			
		
		}
		
		
		return hyperledgerNetworkList;
	}

	public SmartList<HyperledgerNetwork> removeHyperledgerNetworkList(SmartList<HyperledgerNetwork> hyperledgerNetworkList,Map<String,Object> options){
		
		
		super.removeList(hyperledgerNetworkList, options);
		
		return hyperledgerNetworkList;
		
		
	}
	
	protected List<Object[]> prepareHyperledgerNetworkBatchCreateArgs(List<HyperledgerNetwork> hyperledgerNetworkList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(HyperledgerNetwork hyperledgerNetwork:hyperledgerNetworkList ){
			Object [] parameters = prepareHyperledgerNetworkCreateParameters(hyperledgerNetwork);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareHyperledgerNetworkBatchUpdateArgs(List<HyperledgerNetwork> hyperledgerNetworkList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(HyperledgerNetwork hyperledgerNetwork:hyperledgerNetworkList ){
			if(!hyperledgerNetwork.isChanged()){
				continue;
			}
			Object [] parameters = prepareHyperledgerNetworkUpdateParameters(hyperledgerNetwork);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchHyperledgerNetworkCreate(List<HyperledgerNetwork> hyperledgerNetworkList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareHyperledgerNetworkBatchCreateArgs(hyperledgerNetworkList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchHyperledgerNetworkUpdate(List<HyperledgerNetwork> hyperledgerNetworkList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareHyperledgerNetworkBatchUpdateArgs(hyperledgerNetworkList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitHyperledgerNetworkList(List<HyperledgerNetwork> hyperledgerNetworkList){
		
		List<HyperledgerNetwork> hyperledgerNetworkCreateList=new ArrayList<HyperledgerNetwork>();
		List<HyperledgerNetwork> hyperledgerNetworkUpdateList=new ArrayList<HyperledgerNetwork>();
		
		for(HyperledgerNetwork hyperledgerNetwork: hyperledgerNetworkList){
			if(isUpdateRequest(hyperledgerNetwork)){
				hyperledgerNetworkUpdateList.add( hyperledgerNetwork);
				continue;
			}
			hyperledgerNetworkCreateList.add(hyperledgerNetwork);
		}
		
		return new Object[]{hyperledgerNetworkCreateList,hyperledgerNetworkUpdateList};
	}
	
	protected boolean isUpdateRequest(HyperledgerNetwork hyperledgerNetwork){
 		return hyperledgerNetwork.getVersion() > 0;
 	}
 	protected String getSaveHyperledgerNetworkSQL(HyperledgerNetwork hyperledgerNetwork){
 		if(isUpdateRequest(hyperledgerNetwork)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveHyperledgerNetworkParameters(HyperledgerNetwork hyperledgerNetwork){
 		if(isUpdateRequest(hyperledgerNetwork) ){
 			return prepareHyperledgerNetworkUpdateParameters(hyperledgerNetwork);
 		}
 		return prepareHyperledgerNetworkCreateParameters(hyperledgerNetwork);
 	}
 	protected Object[] prepareHyperledgerNetworkUpdateParameters(HyperledgerNetwork hyperledgerNetwork){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = hyperledgerNetwork.getName();
 		parameters[1] = hyperledgerNetwork.getDescription();		
 		parameters[2] = hyperledgerNetwork.nextVersion();
 		parameters[3] = hyperledgerNetwork.getId();
 		parameters[4] = hyperledgerNetwork.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareHyperledgerNetworkCreateParameters(HyperledgerNetwork hyperledgerNetwork){
		Object[] parameters = new Object[3];
		String newHyperledgerNetworkId=getNextId();
		hyperledgerNetwork.setId(newHyperledgerNetworkId);
		parameters[0] =  hyperledgerNetwork.getId();
 
 		parameters[1] = hyperledgerNetwork.getName();
 		parameters[2] = hyperledgerNetwork.getDescription();		
 				
 		return parameters;
 	}
 	
	protected HyperledgerNetwork saveInternalHyperledgerNetwork(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
		
		saveHyperledgerNetwork(hyperledgerNetwork);

		
		if(isSaveOrganizationListEnabled(options)){
	 		saveOrganizationList(hyperledgerNetwork, options);
	 		//removeOrganizationList(hyperledgerNetwork, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveNodeTypeListEnabled(options)){
	 		saveNodeTypeList(hyperledgerNetwork, options);
	 		//removeNodeTypeList(hyperledgerNetwork, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveChannelListEnabled(options)){
	 		saveChannelList(hyperledgerNetwork, options);
	 		//removeChannelList(hyperledgerNetwork, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveApplicationListEnabled(options)){
	 		saveApplicationList(hyperledgerNetwork, options);
	 		//removeApplicationList(hyperledgerNetwork, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveServiceRecordListEnabled(options)){
	 		saveServiceRecordList(hyperledgerNetwork, options);
	 		//removeServiceRecordList(hyperledgerNetwork, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveChangeRequestTypeListEnabled(options)){
	 		saveChangeRequestTypeList(hyperledgerNetwork, options);
	 		//removeChangeRequestTypeList(hyperledgerNetwork, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveChangeRequestListEnabled(options)){
	 		saveChangeRequestList(hyperledgerNetwork, options);
	 		//removeChangeRequestList(hyperledgerNetwork, options);
	 		//Not delete the record
	 		
 		}		
		
		return hyperledgerNetwork;
		
	}
	
	
	
	//======================================================================================
	

	
	public HyperledgerNetwork planToRemoveOrganizationList(HyperledgerNetwork hyperledgerNetwork, String organizationIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Organization.NETWORK_PROPERTY, hyperledgerNetwork.getId());
		key.put(Organization.ID_PROPERTY, organizationIds);
		
		SmartList<Organization> externalOrganizationList = getOrganizationDAO().
				findOrganizationWithKey(key, options);
		if(externalOrganizationList == null){
			return hyperledgerNetwork;
		}
		if(externalOrganizationList.isEmpty()){
			return hyperledgerNetwork;
		}
		
		for(Organization organizationItem: externalOrganizationList){

			organizationItem.clearFromAll();
		}
		
		
		SmartList<Organization> organizationList = hyperledgerNetwork.getOrganizationList();		
		organizationList.addAllToRemoveList(externalOrganizationList);
		return hyperledgerNetwork;	
	
	}


	public HyperledgerNetwork planToRemoveNodeTypeList(HyperledgerNetwork hyperledgerNetwork, String nodeTypeIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NodeType.NETWORK_PROPERTY, hyperledgerNetwork.getId());
		key.put(NodeType.ID_PROPERTY, nodeTypeIds);
		
		SmartList<NodeType> externalNodeTypeList = getNodeTypeDAO().
				findNodeTypeWithKey(key, options);
		if(externalNodeTypeList == null){
			return hyperledgerNetwork;
		}
		if(externalNodeTypeList.isEmpty()){
			return hyperledgerNetwork;
		}
		
		for(NodeType nodeTypeItem: externalNodeTypeList){

			nodeTypeItem.clearFromAll();
		}
		
		
		SmartList<NodeType> nodeTypeList = hyperledgerNetwork.getNodeTypeList();		
		nodeTypeList.addAllToRemoveList(externalNodeTypeList);
		return hyperledgerNetwork;	
	
	}


	public HyperledgerNetwork planToRemoveChannelList(HyperledgerNetwork hyperledgerNetwork, String channelIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Channel.NETWORK_PROPERTY, hyperledgerNetwork.getId());
		key.put(Channel.ID_PROPERTY, channelIds);
		
		SmartList<Channel> externalChannelList = getChannelDAO().
				findChannelWithKey(key, options);
		if(externalChannelList == null){
			return hyperledgerNetwork;
		}
		if(externalChannelList.isEmpty()){
			return hyperledgerNetwork;
		}
		
		for(Channel channelItem: externalChannelList){

			channelItem.clearFromAll();
		}
		
		
		SmartList<Channel> channelList = hyperledgerNetwork.getChannelList();		
		channelList.addAllToRemoveList(externalChannelList);
		return hyperledgerNetwork;	
	
	}


	public HyperledgerNetwork planToRemoveApplicationList(HyperledgerNetwork hyperledgerNetwork, String applicationIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Application.NETWORK_PROPERTY, hyperledgerNetwork.getId());
		key.put(Application.ID_PROPERTY, applicationIds);
		
		SmartList<Application> externalApplicationList = getApplicationDAO().
				findApplicationWithKey(key, options);
		if(externalApplicationList == null){
			return hyperledgerNetwork;
		}
		if(externalApplicationList.isEmpty()){
			return hyperledgerNetwork;
		}
		
		for(Application applicationItem: externalApplicationList){

			applicationItem.clearFromAll();
		}
		
		
		SmartList<Application> applicationList = hyperledgerNetwork.getApplicationList();		
		applicationList.addAllToRemoveList(externalApplicationList);
		return hyperledgerNetwork;	
	
	}


	//disconnect HyperledgerNetwork with channel in Application
	public HyperledgerNetwork planToRemoveApplicationListWithChannel(HyperledgerNetwork hyperledgerNetwork, String channelId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Application.NETWORK_PROPERTY, hyperledgerNetwork.getId());
		key.put(Application.CHANNEL_PROPERTY, channelId);
		
		SmartList<Application> externalApplicationList = getApplicationDAO().
				findApplicationWithKey(key, options);
		if(externalApplicationList == null){
			return hyperledgerNetwork;
		}
		if(externalApplicationList.isEmpty()){
			return hyperledgerNetwork;
		}
		
		for(Application applicationItem: externalApplicationList){
			applicationItem.clearChannel();
			applicationItem.clearNetwork();
			
		}
		
		
		SmartList<Application> applicationList = hyperledgerNetwork.getApplicationList();		
		applicationList.addAllToRemoveList(externalApplicationList);
		return hyperledgerNetwork;
	}
	
	public int countApplicationListWithChannel(String hyperledgerNetworkId, String channelId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Application.NETWORK_PROPERTY, hyperledgerNetworkId);
		key.put(Application.CHANNEL_PROPERTY, channelId);
		
		int count = getApplicationDAO().countApplicationWithKey(key, options);
		return count;
	}
	
	public HyperledgerNetwork planToRemoveServiceRecordList(HyperledgerNetwork hyperledgerNetwork, String serviceRecordIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.NETWORK_PROPERTY, hyperledgerNetwork.getId());
		key.put(ServiceRecord.ID_PROPERTY, serviceRecordIds);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return hyperledgerNetwork;
		}
		if(externalServiceRecordList.isEmpty()){
			return hyperledgerNetwork;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){

			serviceRecordItem.clearFromAll();
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = hyperledgerNetwork.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return hyperledgerNetwork;	
	
	}


	//disconnect HyperledgerNetwork with channel in ServiceRecord
	public HyperledgerNetwork planToRemoveServiceRecordListWithChannel(HyperledgerNetwork hyperledgerNetwork, String channelId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.NETWORK_PROPERTY, hyperledgerNetwork.getId());
		key.put(ServiceRecord.CHANNEL_PROPERTY, channelId);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return hyperledgerNetwork;
		}
		if(externalServiceRecordList.isEmpty()){
			return hyperledgerNetwork;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){
			serviceRecordItem.clearChannel();
			serviceRecordItem.clearNetwork();
			
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = hyperledgerNetwork.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return hyperledgerNetwork;
	}
	
	public int countServiceRecordListWithChannel(String hyperledgerNetworkId, String channelId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.NETWORK_PROPERTY, hyperledgerNetworkId);
		key.put(ServiceRecord.CHANNEL_PROPERTY, channelId);
		
		int count = getServiceRecordDAO().countServiceRecordWithKey(key, options);
		return count;
	}
	
	//disconnect HyperledgerNetwork with chain_code in ServiceRecord
	public HyperledgerNetwork planToRemoveServiceRecordListWithChainCode(HyperledgerNetwork hyperledgerNetwork, String chainCodeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.NETWORK_PROPERTY, hyperledgerNetwork.getId());
		key.put(ServiceRecord.CHAIN_CODE_PROPERTY, chainCodeId);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return hyperledgerNetwork;
		}
		if(externalServiceRecordList.isEmpty()){
			return hyperledgerNetwork;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){
			serviceRecordItem.clearChainCode();
			serviceRecordItem.clearNetwork();
			
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = hyperledgerNetwork.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return hyperledgerNetwork;
	}
	
	public int countServiceRecordListWithChainCode(String hyperledgerNetworkId, String chainCodeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.NETWORK_PROPERTY, hyperledgerNetworkId);
		key.put(ServiceRecord.CHAIN_CODE_PROPERTY, chainCodeId);
		
		int count = getServiceRecordDAO().countServiceRecordWithKey(key, options);
		return count;
	}
	
	//disconnect HyperledgerNetwork with transaction_id in ServiceRecord
	public HyperledgerNetwork planToRemoveServiceRecordListWithTransactionId(HyperledgerNetwork hyperledgerNetwork, String transactionIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.NETWORK_PROPERTY, hyperledgerNetwork.getId());
		key.put(ServiceRecord.TRANSACTION_ID_PROPERTY, transactionIdId);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return hyperledgerNetwork;
		}
		if(externalServiceRecordList.isEmpty()){
			return hyperledgerNetwork;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){
			serviceRecordItem.clearTransactionId();
			serviceRecordItem.clearNetwork();
			
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = hyperledgerNetwork.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return hyperledgerNetwork;
	}
	
	public int countServiceRecordListWithTransactionId(String hyperledgerNetworkId, String transactionIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.NETWORK_PROPERTY, hyperledgerNetworkId);
		key.put(ServiceRecord.TRANSACTION_ID_PROPERTY, transactionIdId);
		
		int count = getServiceRecordDAO().countServiceRecordWithKey(key, options);
		return count;
	}
	
	//disconnect HyperledgerNetwork with block_id in ServiceRecord
	public HyperledgerNetwork planToRemoveServiceRecordListWithBlockId(HyperledgerNetwork hyperledgerNetwork, String blockIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.NETWORK_PROPERTY, hyperledgerNetwork.getId());
		key.put(ServiceRecord.BLOCK_ID_PROPERTY, blockIdId);
		
		SmartList<ServiceRecord> externalServiceRecordList = getServiceRecordDAO().
				findServiceRecordWithKey(key, options);
		if(externalServiceRecordList == null){
			return hyperledgerNetwork;
		}
		if(externalServiceRecordList.isEmpty()){
			return hyperledgerNetwork;
		}
		
		for(ServiceRecord serviceRecordItem: externalServiceRecordList){
			serviceRecordItem.clearBlockId();
			serviceRecordItem.clearNetwork();
			
		}
		
		
		SmartList<ServiceRecord> serviceRecordList = hyperledgerNetwork.getServiceRecordList();		
		serviceRecordList.addAllToRemoveList(externalServiceRecordList);
		return hyperledgerNetwork;
	}
	
	public int countServiceRecordListWithBlockId(String hyperledgerNetworkId, String blockIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.NETWORK_PROPERTY, hyperledgerNetworkId);
		key.put(ServiceRecord.BLOCK_ID_PROPERTY, blockIdId);
		
		int count = getServiceRecordDAO().countServiceRecordWithKey(key, options);
		return count;
	}
	
	public HyperledgerNetwork planToRemoveChangeRequestTypeList(HyperledgerNetwork hyperledgerNetwork, String changeRequestTypeIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChangeRequestType.NETWORK_PROPERTY, hyperledgerNetwork.getId());
		key.put(ChangeRequestType.ID_PROPERTY, changeRequestTypeIds);
		
		SmartList<ChangeRequestType> externalChangeRequestTypeList = getChangeRequestTypeDAO().
				findChangeRequestTypeWithKey(key, options);
		if(externalChangeRequestTypeList == null){
			return hyperledgerNetwork;
		}
		if(externalChangeRequestTypeList.isEmpty()){
			return hyperledgerNetwork;
		}
		
		for(ChangeRequestType changeRequestTypeItem: externalChangeRequestTypeList){

			changeRequestTypeItem.clearFromAll();
		}
		
		
		SmartList<ChangeRequestType> changeRequestTypeList = hyperledgerNetwork.getChangeRequestTypeList();		
		changeRequestTypeList.addAllToRemoveList(externalChangeRequestTypeList);
		return hyperledgerNetwork;	
	
	}


	public HyperledgerNetwork planToRemoveChangeRequestList(HyperledgerNetwork hyperledgerNetwork, String changeRequestIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChangeRequest.NETWORK_PROPERTY, hyperledgerNetwork.getId());
		key.put(ChangeRequest.ID_PROPERTY, changeRequestIds);
		
		SmartList<ChangeRequest> externalChangeRequestList = getChangeRequestDAO().
				findChangeRequestWithKey(key, options);
		if(externalChangeRequestList == null){
			return hyperledgerNetwork;
		}
		if(externalChangeRequestList.isEmpty()){
			return hyperledgerNetwork;
		}
		
		for(ChangeRequest changeRequestItem: externalChangeRequestList){

			changeRequestItem.clearFromAll();
		}
		
		
		SmartList<ChangeRequest> changeRequestList = hyperledgerNetwork.getChangeRequestList();		
		changeRequestList.addAllToRemoveList(externalChangeRequestList);
		return hyperledgerNetwork;	
	
	}


	//disconnect HyperledgerNetwork with request_type in ChangeRequest
	public HyperledgerNetwork planToRemoveChangeRequestListWithRequestType(HyperledgerNetwork hyperledgerNetwork, String requestTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChangeRequest.NETWORK_PROPERTY, hyperledgerNetwork.getId());
		key.put(ChangeRequest.REQUEST_TYPE_PROPERTY, requestTypeId);
		
		SmartList<ChangeRequest> externalChangeRequestList = getChangeRequestDAO().
				findChangeRequestWithKey(key, options);
		if(externalChangeRequestList == null){
			return hyperledgerNetwork;
		}
		if(externalChangeRequestList.isEmpty()){
			return hyperledgerNetwork;
		}
		
		for(ChangeRequest changeRequestItem: externalChangeRequestList){
			changeRequestItem.clearRequestType();
			changeRequestItem.clearNetwork();
			
		}
		
		
		SmartList<ChangeRequest> changeRequestList = hyperledgerNetwork.getChangeRequestList();		
		changeRequestList.addAllToRemoveList(externalChangeRequestList);
		return hyperledgerNetwork;
	}
	
	public int countChangeRequestListWithRequestType(String hyperledgerNetworkId, String requestTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChangeRequest.NETWORK_PROPERTY, hyperledgerNetworkId);
		key.put(ChangeRequest.REQUEST_TYPE_PROPERTY, requestTypeId);
		
		int count = getChangeRequestDAO().countChangeRequestWithKey(key, options);
		return count;
	}
	

		
	protected HyperledgerNetwork saveOrganizationList(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
		
		
		
		
		SmartList<Organization> organizationList = hyperledgerNetwork.getOrganizationList();
		if(organizationList == null){
			//null list means nothing
			return hyperledgerNetwork;
		}
		SmartList<Organization> mergedUpdateOrganizationList = new SmartList<Organization>();
		
		
		mergedUpdateOrganizationList.addAll(organizationList); 
		if(organizationList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateOrganizationList.addAll(organizationList.getToRemoveList());
			organizationList.removeAll(organizationList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getOrganizationDAO().saveOrganizationList(mergedUpdateOrganizationList,options);
		
		if(organizationList.getToRemoveList() != null){
			organizationList.removeAll(organizationList.getToRemoveList());
		}
		
		
		return hyperledgerNetwork;
	
	}
	
	protected HyperledgerNetwork removeOrganizationList(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
	
	
		SmartList<Organization> organizationList = hyperledgerNetwork.getOrganizationList();
		if(organizationList == null){
			return hyperledgerNetwork;
		}	
	
		SmartList<Organization> toRemoveOrganizationList = organizationList.getToRemoveList();
		
		if(toRemoveOrganizationList == null){
			return hyperledgerNetwork;
		}
		if(toRemoveOrganizationList.isEmpty()){
			return hyperledgerNetwork;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getOrganizationDAO().removeOrganizationList(toRemoveOrganizationList,options);
		
		return hyperledgerNetwork;
	
	}
	
	

 	
 	
	
	
	
		
	protected HyperledgerNetwork saveNodeTypeList(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
		
		
		
		
		SmartList<NodeType> nodeTypeList = hyperledgerNetwork.getNodeTypeList();
		if(nodeTypeList == null){
			//null list means nothing
			return hyperledgerNetwork;
		}
		SmartList<NodeType> mergedUpdateNodeTypeList = new SmartList<NodeType>();
		
		
		mergedUpdateNodeTypeList.addAll(nodeTypeList); 
		if(nodeTypeList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateNodeTypeList.addAll(nodeTypeList.getToRemoveList());
			nodeTypeList.removeAll(nodeTypeList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getNodeTypeDAO().saveNodeTypeList(mergedUpdateNodeTypeList,options);
		
		if(nodeTypeList.getToRemoveList() != null){
			nodeTypeList.removeAll(nodeTypeList.getToRemoveList());
		}
		
		
		return hyperledgerNetwork;
	
	}
	
	protected HyperledgerNetwork removeNodeTypeList(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
	
	
		SmartList<NodeType> nodeTypeList = hyperledgerNetwork.getNodeTypeList();
		if(nodeTypeList == null){
			return hyperledgerNetwork;
		}	
	
		SmartList<NodeType> toRemoveNodeTypeList = nodeTypeList.getToRemoveList();
		
		if(toRemoveNodeTypeList == null){
			return hyperledgerNetwork;
		}
		if(toRemoveNodeTypeList.isEmpty()){
			return hyperledgerNetwork;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getNodeTypeDAO().removeNodeTypeList(toRemoveNodeTypeList,options);
		
		return hyperledgerNetwork;
	
	}
	
	

 	
 	
	
	
	
		
	protected HyperledgerNetwork saveChannelList(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
		
		
		
		
		SmartList<Channel> channelList = hyperledgerNetwork.getChannelList();
		if(channelList == null){
			//null list means nothing
			return hyperledgerNetwork;
		}
		SmartList<Channel> mergedUpdateChannelList = new SmartList<Channel>();
		
		
		mergedUpdateChannelList.addAll(channelList); 
		if(channelList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateChannelList.addAll(channelList.getToRemoveList());
			channelList.removeAll(channelList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getChannelDAO().saveChannelList(mergedUpdateChannelList,options);
		
		if(channelList.getToRemoveList() != null){
			channelList.removeAll(channelList.getToRemoveList());
		}
		
		
		return hyperledgerNetwork;
	
	}
	
	protected HyperledgerNetwork removeChannelList(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
	
	
		SmartList<Channel> channelList = hyperledgerNetwork.getChannelList();
		if(channelList == null){
			return hyperledgerNetwork;
		}	
	
		SmartList<Channel> toRemoveChannelList = channelList.getToRemoveList();
		
		if(toRemoveChannelList == null){
			return hyperledgerNetwork;
		}
		if(toRemoveChannelList.isEmpty()){
			return hyperledgerNetwork;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getChannelDAO().removeChannelList(toRemoveChannelList,options);
		
		return hyperledgerNetwork;
	
	}
	
	

 	
 	
	
	
	
		
	protected HyperledgerNetwork saveApplicationList(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
		
		
		
		
		SmartList<Application> applicationList = hyperledgerNetwork.getApplicationList();
		if(applicationList == null){
			//null list means nothing
			return hyperledgerNetwork;
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
		
		
		return hyperledgerNetwork;
	
	}
	
	protected HyperledgerNetwork removeApplicationList(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
	
	
		SmartList<Application> applicationList = hyperledgerNetwork.getApplicationList();
		if(applicationList == null){
			return hyperledgerNetwork;
		}	
	
		SmartList<Application> toRemoveApplicationList = applicationList.getToRemoveList();
		
		if(toRemoveApplicationList == null){
			return hyperledgerNetwork;
		}
		if(toRemoveApplicationList.isEmpty()){
			return hyperledgerNetwork;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getApplicationDAO().removeApplicationList(toRemoveApplicationList,options);
		
		return hyperledgerNetwork;
	
	}
	
	

 	
 	
	
	
	
		
	protected HyperledgerNetwork saveServiceRecordList(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
		
		
		
		
		SmartList<ServiceRecord> serviceRecordList = hyperledgerNetwork.getServiceRecordList();
		if(serviceRecordList == null){
			//null list means nothing
			return hyperledgerNetwork;
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
		
		
		return hyperledgerNetwork;
	
	}
	
	protected HyperledgerNetwork removeServiceRecordList(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
	
	
		SmartList<ServiceRecord> serviceRecordList = hyperledgerNetwork.getServiceRecordList();
		if(serviceRecordList == null){
			return hyperledgerNetwork;
		}	
	
		SmartList<ServiceRecord> toRemoveServiceRecordList = serviceRecordList.getToRemoveList();
		
		if(toRemoveServiceRecordList == null){
			return hyperledgerNetwork;
		}
		if(toRemoveServiceRecordList.isEmpty()){
			return hyperledgerNetwork;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getServiceRecordDAO().removeServiceRecordList(toRemoveServiceRecordList,options);
		
		return hyperledgerNetwork;
	
	}
	
	

 	
 	
	
	
	
		
	protected HyperledgerNetwork saveChangeRequestTypeList(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
		
		
		
		
		SmartList<ChangeRequestType> changeRequestTypeList = hyperledgerNetwork.getChangeRequestTypeList();
		if(changeRequestTypeList == null){
			//null list means nothing
			return hyperledgerNetwork;
		}
		SmartList<ChangeRequestType> mergedUpdateChangeRequestTypeList = new SmartList<ChangeRequestType>();
		
		
		mergedUpdateChangeRequestTypeList.addAll(changeRequestTypeList); 
		if(changeRequestTypeList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateChangeRequestTypeList.addAll(changeRequestTypeList.getToRemoveList());
			changeRequestTypeList.removeAll(changeRequestTypeList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getChangeRequestTypeDAO().saveChangeRequestTypeList(mergedUpdateChangeRequestTypeList,options);
		
		if(changeRequestTypeList.getToRemoveList() != null){
			changeRequestTypeList.removeAll(changeRequestTypeList.getToRemoveList());
		}
		
		
		return hyperledgerNetwork;
	
	}
	
	protected HyperledgerNetwork removeChangeRequestTypeList(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
	
	
		SmartList<ChangeRequestType> changeRequestTypeList = hyperledgerNetwork.getChangeRequestTypeList();
		if(changeRequestTypeList == null){
			return hyperledgerNetwork;
		}	
	
		SmartList<ChangeRequestType> toRemoveChangeRequestTypeList = changeRequestTypeList.getToRemoveList();
		
		if(toRemoveChangeRequestTypeList == null){
			return hyperledgerNetwork;
		}
		if(toRemoveChangeRequestTypeList.isEmpty()){
			return hyperledgerNetwork;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getChangeRequestTypeDAO().removeChangeRequestTypeList(toRemoveChangeRequestTypeList,options);
		
		return hyperledgerNetwork;
	
	}
	
	

 	
 	
	
	
	
		
	protected HyperledgerNetwork saveChangeRequestList(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
		
		
		
		
		SmartList<ChangeRequest> changeRequestList = hyperledgerNetwork.getChangeRequestList();
		if(changeRequestList == null){
			//null list means nothing
			return hyperledgerNetwork;
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
		
		
		return hyperledgerNetwork;
	
	}
	
	protected HyperledgerNetwork removeChangeRequestList(HyperledgerNetwork hyperledgerNetwork, Map<String,Object> options){
	
	
		SmartList<ChangeRequest> changeRequestList = hyperledgerNetwork.getChangeRequestList();
		if(changeRequestList == null){
			return hyperledgerNetwork;
		}	
	
		SmartList<ChangeRequest> toRemoveChangeRequestList = changeRequestList.getToRemoveList();
		
		if(toRemoveChangeRequestList == null){
			return hyperledgerNetwork;
		}
		if(toRemoveChangeRequestList.isEmpty()){
			return hyperledgerNetwork;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getChangeRequestDAO().removeChangeRequestList(toRemoveChangeRequestList,options);
		
		return hyperledgerNetwork;
	
	}
	
	

 	
 	
	
	
	
		

	public HyperledgerNetwork present(HyperledgerNetwork hyperledgerNetwork,Map<String, Object> options){
	
		presentOrganizationList(hyperledgerNetwork,options);
		presentNodeTypeList(hyperledgerNetwork,options);
		presentChannelList(hyperledgerNetwork,options);
		presentApplicationList(hyperledgerNetwork,options);
		presentServiceRecordList(hyperledgerNetwork,options);
		presentChangeRequestTypeList(hyperledgerNetwork,options);
		presentChangeRequestList(hyperledgerNetwork,options);

		return hyperledgerNetwork;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected HyperledgerNetwork presentOrganizationList(
			HyperledgerNetwork hyperledgerNetwork,
			Map<String, Object> options) {

		SmartList<Organization> organizationList = hyperledgerNetwork.getOrganizationList();		
				SmartList<Organization> newList= presentSubList(hyperledgerNetwork.getId(),
				organizationList,
				options,
				getOrganizationDAO()::countOrganizationByNetwork,
				getOrganizationDAO()::findOrganizationByNetwork
				);

		
		hyperledgerNetwork.setOrganizationList(newList);
		

		return hyperledgerNetwork;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected HyperledgerNetwork presentNodeTypeList(
			HyperledgerNetwork hyperledgerNetwork,
			Map<String, Object> options) {

		SmartList<NodeType> nodeTypeList = hyperledgerNetwork.getNodeTypeList();		
				SmartList<NodeType> newList= presentSubList(hyperledgerNetwork.getId(),
				nodeTypeList,
				options,
				getNodeTypeDAO()::countNodeTypeByNetwork,
				getNodeTypeDAO()::findNodeTypeByNetwork
				);

		
		hyperledgerNetwork.setNodeTypeList(newList);
		

		return hyperledgerNetwork;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected HyperledgerNetwork presentChannelList(
			HyperledgerNetwork hyperledgerNetwork,
			Map<String, Object> options) {

		SmartList<Channel> channelList = hyperledgerNetwork.getChannelList();		
				SmartList<Channel> newList= presentSubList(hyperledgerNetwork.getId(),
				channelList,
				options,
				getChannelDAO()::countChannelByNetwork,
				getChannelDAO()::findChannelByNetwork
				);

		
		hyperledgerNetwork.setChannelList(newList);
		

		return hyperledgerNetwork;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected HyperledgerNetwork presentApplicationList(
			HyperledgerNetwork hyperledgerNetwork,
			Map<String, Object> options) {

		SmartList<Application> applicationList = hyperledgerNetwork.getApplicationList();		
				SmartList<Application> newList= presentSubList(hyperledgerNetwork.getId(),
				applicationList,
				options,
				getApplicationDAO()::countApplicationByNetwork,
				getApplicationDAO()::findApplicationByNetwork
				);

		
		hyperledgerNetwork.setApplicationList(newList);
		

		return hyperledgerNetwork;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected HyperledgerNetwork presentServiceRecordList(
			HyperledgerNetwork hyperledgerNetwork,
			Map<String, Object> options) {

		SmartList<ServiceRecord> serviceRecordList = hyperledgerNetwork.getServiceRecordList();		
				SmartList<ServiceRecord> newList= presentSubList(hyperledgerNetwork.getId(),
				serviceRecordList,
				options,
				getServiceRecordDAO()::countServiceRecordByNetwork,
				getServiceRecordDAO()::findServiceRecordByNetwork
				);

		
		hyperledgerNetwork.setServiceRecordList(newList);
		

		return hyperledgerNetwork;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected HyperledgerNetwork presentChangeRequestTypeList(
			HyperledgerNetwork hyperledgerNetwork,
			Map<String, Object> options) {

		SmartList<ChangeRequestType> changeRequestTypeList = hyperledgerNetwork.getChangeRequestTypeList();		
				SmartList<ChangeRequestType> newList= presentSubList(hyperledgerNetwork.getId(),
				changeRequestTypeList,
				options,
				getChangeRequestTypeDAO()::countChangeRequestTypeByNetwork,
				getChangeRequestTypeDAO()::findChangeRequestTypeByNetwork
				);

		
		hyperledgerNetwork.setChangeRequestTypeList(newList);
		

		return hyperledgerNetwork;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected HyperledgerNetwork presentChangeRequestList(
			HyperledgerNetwork hyperledgerNetwork,
			Map<String, Object> options) {

		SmartList<ChangeRequest> changeRequestList = hyperledgerNetwork.getChangeRequestList();		
				SmartList<ChangeRequest> newList= presentSubList(hyperledgerNetwork.getId(),
				changeRequestList,
				options,
				getChangeRequestDAO()::countChangeRequestByNetwork,
				getChangeRequestDAO()::findChangeRequestByNetwork
				);

		
		hyperledgerNetwork.setChangeRequestList(newList);
		

		return hyperledgerNetwork;
	}			
		

	
    public SmartList<HyperledgerNetwork> requestCandidateHyperledgerNetworkForOrganization(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(HyperledgerNetworkTable.COLUMN_NAME, filterKey, pageNo, pageSize, getHyperledgerNetworkMapper());
    }
		
    public SmartList<HyperledgerNetwork> requestCandidateHyperledgerNetworkForNodeType(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(HyperledgerNetworkTable.COLUMN_NAME, filterKey, pageNo, pageSize, getHyperledgerNetworkMapper());
    }
		
    public SmartList<HyperledgerNetwork> requestCandidateHyperledgerNetworkForChannel(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(HyperledgerNetworkTable.COLUMN_NAME, filterKey, pageNo, pageSize, getHyperledgerNetworkMapper());
    }
		
    public SmartList<HyperledgerNetwork> requestCandidateHyperledgerNetworkForApplication(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(HyperledgerNetworkTable.COLUMN_NAME, filterKey, pageNo, pageSize, getHyperledgerNetworkMapper());
    }
		
    public SmartList<HyperledgerNetwork> requestCandidateHyperledgerNetworkForServiceRecord(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(HyperledgerNetworkTable.COLUMN_NAME, filterKey, pageNo, pageSize, getHyperledgerNetworkMapper());
    }
		
    public SmartList<HyperledgerNetwork> requestCandidateHyperledgerNetworkForChangeRequestType(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(HyperledgerNetworkTable.COLUMN_NAME, filterKey, pageNo, pageSize, getHyperledgerNetworkMapper());
    }
		
    public SmartList<HyperledgerNetwork> requestCandidateHyperledgerNetworkForChangeRequest(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(HyperledgerNetworkTable.COLUMN_NAME, filterKey, pageNo, pageSize, getHyperledgerNetworkMapper());
    }
		

	protected String getTableName(){
		return HyperledgerNetworkTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<HyperledgerNetwork> hyperledgerNetworkList) {		
		this.enhanceListInternal(hyperledgerNetworkList, this.getHyperledgerNetworkMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:Organization的network的OrganizationList
	public SmartList<Organization> loadOurOrganizationList(HfgwUserContext userContext, List<HyperledgerNetwork> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Organization.NETWORK_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Organization> loadedObjs = userContext.getDAOGroup().getOrganizationDAO().findOrganizationWithKey(key, options);
		Map<String, List<Organization>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getNetwork().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<Organization> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<Organization> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setOrganizationList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:NodeType的network的NodeTypeList
	public SmartList<NodeType> loadOurNodeTypeList(HfgwUserContext userContext, List<HyperledgerNetwork> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(NodeType.NETWORK_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<NodeType> loadedObjs = userContext.getDAOGroup().getNodeTypeDAO().findNodeTypeWithKey(key, options);
		Map<String, List<NodeType>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getNetwork().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<NodeType> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<NodeType> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setNodeTypeList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:Channel的network的ChannelList
	public SmartList<Channel> loadOurChannelList(HfgwUserContext userContext, List<HyperledgerNetwork> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Channel.NETWORK_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Channel> loadedObjs = userContext.getDAOGroup().getChannelDAO().findChannelWithKey(key, options);
		Map<String, List<Channel>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getNetwork().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<Channel> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<Channel> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setChannelList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:Application的network的ApplicationList
	public SmartList<Application> loadOurApplicationList(HfgwUserContext userContext, List<HyperledgerNetwork> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Application.NETWORK_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Application> loadedObjs = userContext.getDAOGroup().getApplicationDAO().findApplicationWithKey(key, options);
		Map<String, List<Application>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getNetwork().getId()));
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
	
	// 需要一个加载引用我的对象的enhance方法:ServiceRecord的network的ServiceRecordList
	public SmartList<ServiceRecord> loadOurServiceRecordList(HfgwUserContext userContext, List<HyperledgerNetwork> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ServiceRecord.NETWORK_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ServiceRecord> loadedObjs = userContext.getDAOGroup().getServiceRecordDAO().findServiceRecordWithKey(key, options);
		Map<String, List<ServiceRecord>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getNetwork().getId()));
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
	
	// 需要一个加载引用我的对象的enhance方法:ChangeRequestType的network的ChangeRequestTypeList
	public SmartList<ChangeRequestType> loadOurChangeRequestTypeList(HfgwUserContext userContext, List<HyperledgerNetwork> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChangeRequestType.NETWORK_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ChangeRequestType> loadedObjs = userContext.getDAOGroup().getChangeRequestTypeDAO().findChangeRequestTypeWithKey(key, options);
		Map<String, List<ChangeRequestType>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getNetwork().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<ChangeRequestType> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<ChangeRequestType> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setChangeRequestTypeList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:ChangeRequest的network的ChangeRequestList
	public SmartList<ChangeRequest> loadOurChangeRequestList(HfgwUserContext userContext, List<HyperledgerNetwork> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChangeRequest.NETWORK_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ChangeRequest> loadedObjs = userContext.getDAOGroup().getChangeRequestDAO().findChangeRequestWithKey(key, options);
		Map<String, List<ChangeRequest>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getNetwork().getId()));
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
		List<HyperledgerNetwork> hyperledgerNetworkList = ownerEntity.collectRefsWithType(HyperledgerNetwork.INTERNAL_TYPE);
		this.enhanceList(hyperledgerNetworkList);
		
	}
	
	@Override
	public SmartList<HyperledgerNetwork> findHyperledgerNetworkWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getHyperledgerNetworkMapper());

	}
	@Override
	public int countHyperledgerNetworkWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countHyperledgerNetworkWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<HyperledgerNetwork> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getHyperledgerNetworkMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	
    
	public Map<String, Integer> countBySql(String sql, Object[] params) {
		if (params == null || params.length == 0) {
			return new HashMap<>();
		}
		List<Map<String, Object>> result = this.getJdbcTemplateObject().queryForList(sql, params);
		if (result == null || result.isEmpty()) {
			return new HashMap<>();
		}
		Map<String, Integer> cntMap = new HashMap<>();
		for (Map<String, Object> data : result) {
			String key = (String) data.get("id");
			Number value = (Number) data.get("count");
			cntMap.put(key, value.intValue());
		}
		this.logSQLAndParameters("countBySql", sql, params, cntMap.size() + " Counts");
		return cntMap;
	}

	public Integer singleCountBySql(String sql, Object[] params) {
		Integer cnt = this.getJdbcTemplateObject().queryForObject(sql, params, Integer.class);
		logSQLAndParameters("singleCountBySql", sql, params, cnt + "");
		return cnt;
	}

	public BigDecimal summaryBySql(String sql, Object[] params) {
		BigDecimal cnt = this.getJdbcTemplateObject().queryForObject(sql, params, BigDecimal.class);
		logSQLAndParameters("summaryBySql", sql, params, cnt + "");
		return cnt == null ? BigDecimal.ZERO : cnt;
	}

	public <T> List<T> queryForList(String sql, Object[] params, Class<T> claxx) {
		List<T> result = this.getJdbcTemplateObject().queryForList(sql, params, claxx);
		logSQLAndParameters("queryForList", sql, params, result.size() + " items");
		return result;
	}

	public Map<String, Object> queryForMap(String sql, Object[] params) throws DataAccessException {
		Map<String, Object> result = null;
		try {
			result = this.getJdbcTemplateObject().queryForMap(sql, params);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			// 空结果，返回null
		}
		logSQLAndParameters("queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
		return result;
	}

	public <T> T queryForObject(String sql, Object[] params, Class<T> claxx) throws DataAccessException {
		T result = null;
		try {
			result = this.getJdbcTemplateObject().queryForObject(sql, params, claxx);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			// 空结果，返回null
		}
		logSQLAndParameters("queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
		return result;
	}

	public List<Map<String, Object>> queryAsMapList(String sql, Object[] params) {
		List<Map<String, Object>> result = getJdbcTemplateObject().queryForList(sql, params);
		logSQLAndParameters("queryAsMapList", sql, params, result.size() + " items");
		return result;
	}

	public synchronized int updateBySql(String sql, Object[] params) {
		int result = getJdbcTemplateObject().update(sql, params);
		logSQLAndParameters("updateBySql", sql, params, result + " items");
		return result;
	}

	public void execSqlWithRowCallback(String sql, Object[] args, RowCallbackHandler callback) {
		getJdbcTemplateObject().query(sql, args, callback);
	}

	public void executeSql(String sql) {
		logSQLAndParameters("executeSql", sql, new Object[] {}, "");
		getJdbcTemplateObject().execute(sql);
	}


}


