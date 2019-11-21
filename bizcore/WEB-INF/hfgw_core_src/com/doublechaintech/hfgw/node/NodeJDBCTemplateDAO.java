
package com.doublechaintech.hfgw.node;

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


import com.doublechaintech.hfgw.channelpeerrole.ChannelPeerRole;
import com.doublechaintech.hfgw.organization.Organization;
import com.doublechaintech.hfgw.channel.Channel;
import com.doublechaintech.hfgw.nodetype.NodeType;
import com.doublechaintech.hfgw.grpcoption.GrpcOption;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetworkDAO;
import com.doublechaintech.hfgw.channelpeerrole.ChannelPeerRoleDAO;
import com.doublechaintech.hfgw.grpcoption.GrpcOptionDAO;
import com.doublechaintech.hfgw.organization.OrganizationDAO;
import com.doublechaintech.hfgw.channel.ChannelDAO;
import com.doublechaintech.hfgw.nodetype.NodeTypeDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class NodeJDBCTemplateDAO extends HfgwBaseDAOImpl implements NodeDAO{
 
 	
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
 
 	
 	private  OrganizationDAO  organizationDAO;
 	public void setOrganizationDAO(OrganizationDAO organizationDAO){
	 	this.organizationDAO = organizationDAO;
 	}
 	public OrganizationDAO getOrganizationDAO(){
	 	return this.organizationDAO;
 	}
 
 	
 	private  NodeTypeDAO  nodeTypeDAO;
 	public void setNodeTypeDAO(NodeTypeDAO nodeTypeDAO){
	 	this.nodeTypeDAO = nodeTypeDAO;
 	}
 	public NodeTypeDAO getNodeTypeDAO(){
	 	return this.nodeTypeDAO;
 	}


			
		
	
  	private  GrpcOptionDAO  grpcOptionDAO;
 	public void setGrpcOptionDAO(GrpcOptionDAO pGrpcOptionDAO){
 	
 		if(pGrpcOptionDAO == null){
 			throw new IllegalStateException("Do not try to set grpcOptionDAO to null.");
 		}
	 	this.grpcOptionDAO = pGrpcOptionDAO;
 	}
 	public GrpcOptionDAO getGrpcOptionDAO(){
 		if(this.grpcOptionDAO == null){
 			throw new IllegalStateException("The grpcOptionDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.grpcOptionDAO;
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
 	
			
		

	
	/*
	protected Node load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalNode(accessKey, options);
	}
	*/
	
	public SmartList<Node> loadAll() {
	    return this.loadAll(getNodeMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Node load(String id,Map<String,Object> options) throws Exception{
		return loadInternalNode(NodeTable.withId(id), options);
	}
	
	
	
	public Node save(Node node,Map<String,Object> options){
		
		String methodName="save(Node node,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(node, methodName, "node");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalNode(node,options);
	}
	public Node clone(String nodeId, Map<String,Object> options) throws Exception{
	
		return clone(NodeTable.withId(nodeId),options);
	}
	
	protected Node clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String nodeId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Node newNode = loadInternalNode(accessKey, options);
		newNode.setVersion(0);
		
		
 		
 		if(isSaveGrpcOptionListEnabled(options)){
 			for(GrpcOption item: newNode.getGrpcOptionList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveChannelPeerRoleListEnabled(options)){
 			for(ChannelPeerRole item: newNode.getChannelPeerRoleList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalNode(newNode,options);
		
		return newNode;
	}
	
	
	
	

	protected void throwIfHasException(String nodeId,int version,int count) throws Exception{
		if (count == 1) {
			throw new NodeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new NodeNotFoundException(
					"The " + this.getTableName() + "(" + nodeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String nodeId, int version) throws Exception{
	
		String methodName="delete(String nodeId, int version)";
		assertMethodArgumentNotNull(nodeId, methodName, "nodeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{nodeId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(nodeId,version);
		}
		
	
	}
	
	
	
	
	

	public Node disconnectFromAll(String nodeId, int version) throws Exception{
	
		
		Node node = loadInternalNode(NodeTable.withId(nodeId), emptyOptions());
		node.clearFromAll();
		this.saveNode(node);
		return node;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return NodeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "node";
	}
	@Override
	protected String getBeanName() {
		
		return "node";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return NodeTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractOrganizationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, NodeTokens.ORGANIZATION);
 	}

 	protected boolean isSaveOrganizationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, NodeTokens.ORGANIZATION);
 	}
 	

 	
  

 	protected boolean isExtractChannelEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, NodeTokens.CHANNEL);
 	}

 	protected boolean isSaveChannelEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, NodeTokens.CHANNEL);
 	}
 	

 	
  

 	protected boolean isExtractNetworkEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, NodeTokens.NETWORK);
 	}

 	protected boolean isSaveNetworkEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, NodeTokens.NETWORK);
 	}
 	

 	
  

 	protected boolean isExtractTypeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, NodeTokens.TYPE);
 	}

 	protected boolean isSaveTypeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, NodeTokens.TYPE);
 	}
 	

 	
 
		
	
	protected boolean isExtractGrpcOptionListEnabled(Map<String,Object> options){		
 		return checkOptions(options,NodeTokens.GRPC_OPTION_LIST);
 	}
 	protected boolean isAnalyzeGrpcOptionListEnabled(Map<String,Object> options){		 		
 		return NodeTokens.of(options).analyzeGrpcOptionListEnabled();
 	}
	
	protected boolean isSaveGrpcOptionListEnabled(Map<String,Object> options){
		return checkOptions(options, NodeTokens.GRPC_OPTION_LIST);
		
 	}
 	
		
	
	protected boolean isExtractChannelPeerRoleListEnabled(Map<String,Object> options){		
 		return checkOptions(options,NodeTokens.CHANNEL_PEER_ROLE_LIST);
 	}
 	protected boolean isAnalyzeChannelPeerRoleListEnabled(Map<String,Object> options){		 		
 		return NodeTokens.of(options).analyzeChannelPeerRoleListEnabled();
 	}
	
	protected boolean isSaveChannelPeerRoleListEnabled(Map<String,Object> options){
		return checkOptions(options, NodeTokens.CHANNEL_PEER_ROLE_LIST);
		
 	}
 	
		

	

	protected NodeMapper getNodeMapper(){
		return new NodeMapper();
	}

	
	
	protected Node extractNode(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Node node = loadSingleObject(accessKey, getNodeMapper());
			return node;
		}catch(EmptyResultDataAccessException e){
			throw new NodeNotFoundException("Node("+accessKey+") is not found!");
		}

	}

	
	

	protected Node loadInternalNode(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Node node = extractNode(accessKey, loadOptions);
 	
 		if(isExtractOrganizationEnabled(loadOptions)){
	 		extractOrganization(node, loadOptions);
 		}
  	
 		if(isExtractChannelEnabled(loadOptions)){
	 		extractChannel(node, loadOptions);
 		}
  	
 		if(isExtractNetworkEnabled(loadOptions)){
	 		extractNetwork(node, loadOptions);
 		}
  	
 		if(isExtractTypeEnabled(loadOptions)){
	 		extractType(node, loadOptions);
 		}
 
		
		if(isExtractGrpcOptionListEnabled(loadOptions)){
	 		extractGrpcOptionList(node, loadOptions);
 		}	
 		if(isAnalyzeGrpcOptionListEnabled(loadOptions)){
	 		analyzeGrpcOptionList(node, loadOptions);
 		}
 		
		
		if(isExtractChannelPeerRoleListEnabled(loadOptions)){
	 		extractChannelPeerRoleList(node, loadOptions);
 		}	
 		if(isAnalyzeChannelPeerRoleListEnabled(loadOptions)){
	 		analyzeChannelPeerRoleList(node, loadOptions);
 		}
 		
		
		return node;
		
	}

	 

 	protected Node extractOrganization(Node node, Map<String,Object> options) throws Exception{

		if(node.getOrganization() == null){
			return node;
		}
		String organizationId = node.getOrganization().getId();
		if( organizationId == null){
			return node;
		}
		Organization organization = getOrganizationDAO().load(organizationId,options);
		if(organization != null){
			node.setOrganization(organization);
		}
		
 		
 		return node;
 	}
 		
  

 	protected Node extractChannel(Node node, Map<String,Object> options) throws Exception{

		if(node.getChannel() == null){
			return node;
		}
		String channelId = node.getChannel().getId();
		if( channelId == null){
			return node;
		}
		Channel channel = getChannelDAO().load(channelId,options);
		if(channel != null){
			node.setChannel(channel);
		}
		
 		
 		return node;
 	}
 		
  

 	protected Node extractNetwork(Node node, Map<String,Object> options) throws Exception{

		if(node.getNetwork() == null){
			return node;
		}
		String networkId = node.getNetwork().getId();
		if( networkId == null){
			return node;
		}
		HyperledgerNetwork network = getHyperledgerNetworkDAO().load(networkId,options);
		if(network != null){
			node.setNetwork(network);
		}
		
 		
 		return node;
 	}
 		
  

 	protected Node extractType(Node node, Map<String,Object> options) throws Exception{

		if(node.getType() == null){
			return node;
		}
		String typeId = node.getType().getId();
		if( typeId == null){
			return node;
		}
		NodeType type = getNodeTypeDAO().load(typeId,options);
		if(type != null){
			node.setType(type);
		}
		
 		
 		return node;
 	}
 		
 
		
	protected void enhanceGrpcOptionList(SmartList<GrpcOption> grpcOptionList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Node extractGrpcOptionList(Node node, Map<String,Object> options){
		
		
		if(node == null){
			return null;
		}
		if(node.getId() == null){
			return node;
		}

		
		
		SmartList<GrpcOption> grpcOptionList = getGrpcOptionDAO().findGrpcOptionByNode(node.getId(),options);
		if(grpcOptionList != null){
			enhanceGrpcOptionList(grpcOptionList,options);
			node.setGrpcOptionList(grpcOptionList);
		}
		
		return node;
	
	}	
	
	protected Node analyzeGrpcOptionList(Node node, Map<String,Object> options){
		
		
		if(node == null){
			return null;
		}
		if(node.getId() == null){
			return node;
		}

		
		
		SmartList<GrpcOption> grpcOptionList = node.getGrpcOptionList();
		if(grpcOptionList != null){
			getGrpcOptionDAO().analyzeGrpcOptionByNode(grpcOptionList, node.getId(), options);
			
		}
		
		return node;
	
	}	
	
		
	protected void enhanceChannelPeerRoleList(SmartList<ChannelPeerRole> channelPeerRoleList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Node extractChannelPeerRoleList(Node node, Map<String,Object> options){
		
		
		if(node == null){
			return null;
		}
		if(node.getId() == null){
			return node;
		}

		
		
		SmartList<ChannelPeerRole> channelPeerRoleList = getChannelPeerRoleDAO().findChannelPeerRoleByNode(node.getId(),options);
		if(channelPeerRoleList != null){
			enhanceChannelPeerRoleList(channelPeerRoleList,options);
			node.setChannelPeerRoleList(channelPeerRoleList);
		}
		
		return node;
	
	}	
	
	protected Node analyzeChannelPeerRoleList(Node node, Map<String,Object> options){
		
		
		if(node == null){
			return null;
		}
		if(node.getId() == null){
			return node;
		}

		
		
		SmartList<ChannelPeerRole> channelPeerRoleList = node.getChannelPeerRoleList();
		if(channelPeerRoleList != null){
			getChannelPeerRoleDAO().analyzeChannelPeerRoleByNode(channelPeerRoleList, node.getId(), options);
			
		}
		
		return node;
	
	}	
	
		
		
  	
 	public SmartList<Node> findNodeByOrganization(String organizationId,Map<String,Object> options){
 	
  		SmartList<Node> resultList = queryWith(NodeTable.COLUMN_ORGANIZATION, organizationId, options, getNodeMapper());
		// analyzeNodeByOrganization(resultList, organizationId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Node> findNodeByOrganization(String organizationId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Node> resultList =  queryWithRange(NodeTable.COLUMN_ORGANIZATION, organizationId, options, getNodeMapper(), start, count);
 		//analyzeNodeByOrganization(resultList, organizationId, options);
 		return resultList;
 		
 	}
 	public void analyzeNodeByOrganization(SmartList<Node> resultList, String organizationId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Node.ORGANIZATION_PROPERTY, organizationId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countNodeByOrganization(String organizationId,Map<String,Object> options){

 		return countWith(NodeTable.COLUMN_ORGANIZATION, organizationId, options);
 	}
 	@Override
	public Map<String, Integer> countNodeByOrganizationIds(String[] ids, Map<String, Object> options) {
		return countWithIds(NodeTable.COLUMN_ORGANIZATION, ids, options);
	}
 	
  	
 	public SmartList<Node> findNodeByChannel(String channelId,Map<String,Object> options){
 	
  		SmartList<Node> resultList = queryWith(NodeTable.COLUMN_CHANNEL, channelId, options, getNodeMapper());
		// analyzeNodeByChannel(resultList, channelId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Node> findNodeByChannel(String channelId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Node> resultList =  queryWithRange(NodeTable.COLUMN_CHANNEL, channelId, options, getNodeMapper(), start, count);
 		//analyzeNodeByChannel(resultList, channelId, options);
 		return resultList;
 		
 	}
 	public void analyzeNodeByChannel(SmartList<Node> resultList, String channelId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Node.CHANNEL_PROPERTY, channelId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countNodeByChannel(String channelId,Map<String,Object> options){

 		return countWith(NodeTable.COLUMN_CHANNEL, channelId, options);
 	}
 	@Override
	public Map<String, Integer> countNodeByChannelIds(String[] ids, Map<String, Object> options) {
		return countWithIds(NodeTable.COLUMN_CHANNEL, ids, options);
	}
 	
  	
 	public SmartList<Node> findNodeByNetwork(String hyperledgerNetworkId,Map<String,Object> options){
 	
  		SmartList<Node> resultList = queryWith(NodeTable.COLUMN_NETWORK, hyperledgerNetworkId, options, getNodeMapper());
		// analyzeNodeByNetwork(resultList, hyperledgerNetworkId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Node> findNodeByNetwork(String hyperledgerNetworkId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Node> resultList =  queryWithRange(NodeTable.COLUMN_NETWORK, hyperledgerNetworkId, options, getNodeMapper(), start, count);
 		//analyzeNodeByNetwork(resultList, hyperledgerNetworkId, options);
 		return resultList;
 		
 	}
 	public void analyzeNodeByNetwork(SmartList<Node> resultList, String hyperledgerNetworkId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Node.NETWORK_PROPERTY, hyperledgerNetworkId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countNodeByNetwork(String hyperledgerNetworkId,Map<String,Object> options){

 		return countWith(NodeTable.COLUMN_NETWORK, hyperledgerNetworkId, options);
 	}
 	@Override
	public Map<String, Integer> countNodeByNetworkIds(String[] ids, Map<String, Object> options) {
		return countWithIds(NodeTable.COLUMN_NETWORK, ids, options);
	}
 	
  	
 	public SmartList<Node> findNodeByType(String nodeTypeId,Map<String,Object> options){
 	
  		SmartList<Node> resultList = queryWith(NodeTable.COLUMN_TYPE, nodeTypeId, options, getNodeMapper());
		// analyzeNodeByType(resultList, nodeTypeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Node> findNodeByType(String nodeTypeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Node> resultList =  queryWithRange(NodeTable.COLUMN_TYPE, nodeTypeId, options, getNodeMapper(), start, count);
 		//analyzeNodeByType(resultList, nodeTypeId, options);
 		return resultList;
 		
 	}
 	public void analyzeNodeByType(SmartList<Node> resultList, String nodeTypeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Node.TYPE_PROPERTY, nodeTypeId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countNodeByType(String nodeTypeId,Map<String,Object> options){

 		return countWith(NodeTable.COLUMN_TYPE, nodeTypeId, options);
 	}
 	@Override
	public Map<String, Integer> countNodeByTypeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(NodeTable.COLUMN_TYPE, ids, options);
	}
 	
 	
		
		
		

	

	protected Node saveNode(Node  node){
		
		if(!node.isChanged()){
			return node;
		}
		
		
		String SQL=this.getSaveNodeSQL(node);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveNodeParameters(node);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		node.incVersion();
		return node;
	
	}
	public SmartList<Node> saveNodeList(SmartList<Node> nodeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitNodeList(nodeList);
		
		batchNodeCreate((List<Node>)lists[CREATE_LIST_INDEX]);
		
		batchNodeUpdate((List<Node>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Node node:nodeList){
			if(node.isChanged()){
				node.incVersion();
			}
			
		
		}
		
		
		return nodeList;
	}

	public SmartList<Node> removeNodeList(SmartList<Node> nodeList,Map<String,Object> options){
		
		
		super.removeList(nodeList, options);
		
		return nodeList;
		
		
	}
	
	protected List<Object[]> prepareNodeBatchCreateArgs(List<Node> nodeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Node node:nodeList ){
			Object [] parameters = prepareNodeCreateParameters(node);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareNodeBatchUpdateArgs(List<Node> nodeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Node node:nodeList ){
			if(!node.isChanged()){
				continue;
			}
			Object [] parameters = prepareNodeUpdateParameters(node);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchNodeCreate(List<Node> nodeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareNodeBatchCreateArgs(nodeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchNodeUpdate(List<Node> nodeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareNodeBatchUpdateArgs(nodeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitNodeList(List<Node> nodeList){
		
		List<Node> nodeCreateList=new ArrayList<Node>();
		List<Node> nodeUpdateList=new ArrayList<Node>();
		
		for(Node node: nodeList){
			if(isUpdateRequest(node)){
				nodeUpdateList.add( node);
				continue;
			}
			nodeCreateList.add(node);
		}
		
		return new Object[]{nodeCreateList,nodeUpdateList};
	}
	
	protected boolean isUpdateRequest(Node node){
 		return node.getVersion() > 0;
 	}
 	protected String getSaveNodeSQL(Node node){
 		if(isUpdateRequest(node)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveNodeParameters(Node node){
 		if(isUpdateRequest(node) ){
 			return prepareNodeUpdateParameters(node);
 		}
 		return prepareNodeCreateParameters(node);
 	}
 	protected Object[] prepareNodeUpdateParameters(Node node){
 		Object[] parameters = new Object[13];
 
 		parameters[0] = node.getName();
 		parameters[1] = node.getUrl(); 	
 		if(node.getOrganization() != null){
 			parameters[2] = node.getOrganization().getId();
 		}
  	
 		if(node.getChannel() != null){
 			parameters[3] = node.getChannel().getId();
 		}
  	
 		if(node.getNetwork() != null){
 			parameters[4] = node.getNetwork().getId();
 		}
 
 		parameters[5] = node.getTlsCacert(); 	
 		if(node.getType() != null){
 			parameters[6] = node.getType().getId();
 		}
 
 		parameters[7] = node.getAddress();
 		parameters[8] = node.getContactPerson();
 		parameters[9] = node.getContactTelephone();		
 		parameters[10] = node.nextVersion();
 		parameters[11] = node.getId();
 		parameters[12] = node.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareNodeCreateParameters(Node node){
		Object[] parameters = new Object[11];
		String newNodeId=getNextId();
		node.setId(newNodeId);
		parameters[0] =  node.getId();
 
 		parameters[1] = node.getName();
 		parameters[2] = node.getUrl(); 	
 		if(node.getOrganization() != null){
 			parameters[3] = node.getOrganization().getId();
 		
 		}
 		 	
 		if(node.getChannel() != null){
 			parameters[4] = node.getChannel().getId();
 		
 		}
 		 	
 		if(node.getNetwork() != null){
 			parameters[5] = node.getNetwork().getId();
 		
 		}
 		
 		parameters[6] = node.getTlsCacert(); 	
 		if(node.getType() != null){
 			parameters[7] = node.getType().getId();
 		
 		}
 		
 		parameters[8] = node.getAddress();
 		parameters[9] = node.getContactPerson();
 		parameters[10] = node.getContactTelephone();		
 				
 		return parameters;
 	}
 	
	protected Node saveInternalNode(Node node, Map<String,Object> options){
		
		saveNode(node);
 	
 		if(isSaveOrganizationEnabled(options)){
	 		saveOrganization(node, options);
 		}
  	
 		if(isSaveChannelEnabled(options)){
	 		saveChannel(node, options);
 		}
  	
 		if(isSaveNetworkEnabled(options)){
	 		saveNetwork(node, options);
 		}
  	
 		if(isSaveTypeEnabled(options)){
	 		saveType(node, options);
 		}
 
		
		if(isSaveGrpcOptionListEnabled(options)){
	 		saveGrpcOptionList(node, options);
	 		//removeGrpcOptionList(node, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveChannelPeerRoleListEnabled(options)){
	 		saveChannelPeerRoleList(node, options);
	 		//removeChannelPeerRoleList(node, options);
	 		//Not delete the record
	 		
 		}		
		
		return node;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Node saveOrganization(Node node, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(node.getOrganization() == null){
 			return node;//do nothing when it is null
 		}
 		
 		getOrganizationDAO().save(node.getOrganization(),options);
 		return node;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Node saveChannel(Node node, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(node.getChannel() == null){
 			return node;//do nothing when it is null
 		}
 		
 		getChannelDAO().save(node.getChannel(),options);
 		return node;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Node saveNetwork(Node node, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(node.getNetwork() == null){
 			return node;//do nothing when it is null
 		}
 		
 		getHyperledgerNetworkDAO().save(node.getNetwork(),options);
 		return node;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Node saveType(Node node, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(node.getType() == null){
 			return node;//do nothing when it is null
 		}
 		
 		getNodeTypeDAO().save(node.getType(),options);
 		return node;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public Node planToRemoveGrpcOptionList(Node node, String grpcOptionIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(GrpcOption.NODE_PROPERTY, node.getId());
		key.put(GrpcOption.ID_PROPERTY, grpcOptionIds);
		
		SmartList<GrpcOption> externalGrpcOptionList = getGrpcOptionDAO().
				findGrpcOptionWithKey(key, options);
		if(externalGrpcOptionList == null){
			return node;
		}
		if(externalGrpcOptionList.isEmpty()){
			return node;
		}
		
		for(GrpcOption grpcOptionItem: externalGrpcOptionList){

			grpcOptionItem.clearFromAll();
		}
		
		
		SmartList<GrpcOption> grpcOptionList = node.getGrpcOptionList();		
		grpcOptionList.addAllToRemoveList(externalGrpcOptionList);
		return node;	
	
	}


	public Node planToRemoveChannelPeerRoleList(Node node, String channelPeerRoleIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChannelPeerRole.NODE_PROPERTY, node.getId());
		key.put(ChannelPeerRole.ID_PROPERTY, channelPeerRoleIds);
		
		SmartList<ChannelPeerRole> externalChannelPeerRoleList = getChannelPeerRoleDAO().
				findChannelPeerRoleWithKey(key, options);
		if(externalChannelPeerRoleList == null){
			return node;
		}
		if(externalChannelPeerRoleList.isEmpty()){
			return node;
		}
		
		for(ChannelPeerRole channelPeerRoleItem: externalChannelPeerRoleList){

			channelPeerRoleItem.clearFromAll();
		}
		
		
		SmartList<ChannelPeerRole> channelPeerRoleList = node.getChannelPeerRoleList();		
		channelPeerRoleList.addAllToRemoveList(externalChannelPeerRoleList);
		return node;	
	
	}


	//disconnect Node with channel in ChannelPeerRole
	public Node planToRemoveChannelPeerRoleListWithChannel(Node node, String channelId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChannelPeerRole.NODE_PROPERTY, node.getId());
		key.put(ChannelPeerRole.CHANNEL_PROPERTY, channelId);
		
		SmartList<ChannelPeerRole> externalChannelPeerRoleList = getChannelPeerRoleDAO().
				findChannelPeerRoleWithKey(key, options);
		if(externalChannelPeerRoleList == null){
			return node;
		}
		if(externalChannelPeerRoleList.isEmpty()){
			return node;
		}
		
		for(ChannelPeerRole channelPeerRoleItem: externalChannelPeerRoleList){
			channelPeerRoleItem.clearChannel();
			channelPeerRoleItem.clearNode();
			
		}
		
		
		SmartList<ChannelPeerRole> channelPeerRoleList = node.getChannelPeerRoleList();		
		channelPeerRoleList.addAllToRemoveList(externalChannelPeerRoleList);
		return node;
	}
	
	public int countChannelPeerRoleListWithChannel(String nodeId, String channelId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChannelPeerRole.NODE_PROPERTY, nodeId);
		key.put(ChannelPeerRole.CHANNEL_PROPERTY, channelId);
		
		int count = getChannelPeerRoleDAO().countChannelPeerRoleWithKey(key, options);
		return count;
	}
	
	//disconnect Node with peer_role in ChannelPeerRole
	public Node planToRemoveChannelPeerRoleListWithPeerRole(Node node, String peerRoleId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChannelPeerRole.NODE_PROPERTY, node.getId());
		key.put(ChannelPeerRole.PEER_ROLE_PROPERTY, peerRoleId);
		
		SmartList<ChannelPeerRole> externalChannelPeerRoleList = getChannelPeerRoleDAO().
				findChannelPeerRoleWithKey(key, options);
		if(externalChannelPeerRoleList == null){
			return node;
		}
		if(externalChannelPeerRoleList.isEmpty()){
			return node;
		}
		
		for(ChannelPeerRole channelPeerRoleItem: externalChannelPeerRoleList){
			channelPeerRoleItem.clearPeerRole();
			channelPeerRoleItem.clearNode();
			
		}
		
		
		SmartList<ChannelPeerRole> channelPeerRoleList = node.getChannelPeerRoleList();		
		channelPeerRoleList.addAllToRemoveList(externalChannelPeerRoleList);
		return node;
	}
	
	public int countChannelPeerRoleListWithPeerRole(String nodeId, String peerRoleId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChannelPeerRole.NODE_PROPERTY, nodeId);
		key.put(ChannelPeerRole.PEER_ROLE_PROPERTY, peerRoleId);
		
		int count = getChannelPeerRoleDAO().countChannelPeerRoleWithKey(key, options);
		return count;
	}
	

		
	protected Node saveGrpcOptionList(Node node, Map<String,Object> options){
		
		
		
		
		SmartList<GrpcOption> grpcOptionList = node.getGrpcOptionList();
		if(grpcOptionList == null){
			//null list means nothing
			return node;
		}
		SmartList<GrpcOption> mergedUpdateGrpcOptionList = new SmartList<GrpcOption>();
		
		
		mergedUpdateGrpcOptionList.addAll(grpcOptionList); 
		if(grpcOptionList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateGrpcOptionList.addAll(grpcOptionList.getToRemoveList());
			grpcOptionList.removeAll(grpcOptionList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getGrpcOptionDAO().saveGrpcOptionList(mergedUpdateGrpcOptionList,options);
		
		if(grpcOptionList.getToRemoveList() != null){
			grpcOptionList.removeAll(grpcOptionList.getToRemoveList());
		}
		
		
		return node;
	
	}
	
	protected Node removeGrpcOptionList(Node node, Map<String,Object> options){
	
	
		SmartList<GrpcOption> grpcOptionList = node.getGrpcOptionList();
		if(grpcOptionList == null){
			return node;
		}	
	
		SmartList<GrpcOption> toRemoveGrpcOptionList = grpcOptionList.getToRemoveList();
		
		if(toRemoveGrpcOptionList == null){
			return node;
		}
		if(toRemoveGrpcOptionList.isEmpty()){
			return node;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getGrpcOptionDAO().removeGrpcOptionList(toRemoveGrpcOptionList,options);
		
		return node;
	
	}
	
	

 	
 	
	
	
	
		
	protected Node saveChannelPeerRoleList(Node node, Map<String,Object> options){
		
		
		
		
		SmartList<ChannelPeerRole> channelPeerRoleList = node.getChannelPeerRoleList();
		if(channelPeerRoleList == null){
			//null list means nothing
			return node;
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
		
		
		return node;
	
	}
	
	protected Node removeChannelPeerRoleList(Node node, Map<String,Object> options){
	
	
		SmartList<ChannelPeerRole> channelPeerRoleList = node.getChannelPeerRoleList();
		if(channelPeerRoleList == null){
			return node;
		}	
	
		SmartList<ChannelPeerRole> toRemoveChannelPeerRoleList = channelPeerRoleList.getToRemoveList();
		
		if(toRemoveChannelPeerRoleList == null){
			return node;
		}
		if(toRemoveChannelPeerRoleList.isEmpty()){
			return node;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getChannelPeerRoleDAO().removeChannelPeerRoleList(toRemoveChannelPeerRoleList,options);
		
		return node;
	
	}
	
	

 	
 	
	
	
	
		

	public Node present(Node node,Map<String, Object> options){
	
		presentGrpcOptionList(node,options);
		presentChannelPeerRoleList(node,options);

		return node;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Node presentGrpcOptionList(
			Node node,
			Map<String, Object> options) {

		SmartList<GrpcOption> grpcOptionList = node.getGrpcOptionList();		
				SmartList<GrpcOption> newList= presentSubList(node.getId(),
				grpcOptionList,
				options,
				getGrpcOptionDAO()::countGrpcOptionByNode,
				getGrpcOptionDAO()::findGrpcOptionByNode
				);

		
		node.setGrpcOptionList(newList);
		

		return node;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Node presentChannelPeerRoleList(
			Node node,
			Map<String, Object> options) {

		SmartList<ChannelPeerRole> channelPeerRoleList = node.getChannelPeerRoleList();		
				SmartList<ChannelPeerRole> newList= presentSubList(node.getId(),
				channelPeerRoleList,
				options,
				getChannelPeerRoleDAO()::countChannelPeerRoleByNode,
				getChannelPeerRoleDAO()::findChannelPeerRoleByNode
				);

		
		node.setChannelPeerRoleList(newList);
		

		return node;
	}			
		

	
    public SmartList<Node> requestCandidateNodeForGrpcOption(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(NodeTable.COLUMN_NAME, filterKey, pageNo, pageSize, getNodeMapper());
    }
		
    public SmartList<Node> requestCandidateNodeForChannelPeerRole(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(NodeTable.COLUMN_NAME, filterKey, pageNo, pageSize, getNodeMapper());
    }
		

	protected String getTableName(){
		return NodeTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Node> nodeList) {		
		this.enhanceListInternal(nodeList, this.getNodeMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:GrpcOption的node的GrpcOptionList
	public SmartList<GrpcOption> loadOurGrpcOptionList(HfgwUserContext userContext, List<Node> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(GrpcOption.NODE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<GrpcOption> loadedObjs = userContext.getDAOGroup().getGrpcOptionDAO().findGrpcOptionWithKey(key, options);
		Map<String, List<GrpcOption>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getNode().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<GrpcOption> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<GrpcOption> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setGrpcOptionList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:ChannelPeerRole的node的ChannelPeerRoleList
	public SmartList<ChannelPeerRole> loadOurChannelPeerRoleList(HfgwUserContext userContext, List<Node> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChannelPeerRole.NODE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ChannelPeerRole> loadedObjs = userContext.getDAOGroup().getChannelPeerRoleDAO().findChannelPeerRoleWithKey(key, options);
		Map<String, List<ChannelPeerRole>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getNode().getId()));
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
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Node> nodeList = ownerEntity.collectRefsWithType(Node.INTERNAL_TYPE);
		this.enhanceList(nodeList);
		
	}
	
	@Override
	public SmartList<Node> findNodeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getNodeMapper());

	}
	@Override
	public int countNodeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countNodeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Node> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getNodeMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


