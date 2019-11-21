
package com.doublechaintech.hfgw.nodetype;

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


import com.doublechaintech.hfgw.node.Node;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetworkDAO;
import com.doublechaintech.hfgw.node.NodeDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class NodeTypeJDBCTemplateDAO extends HfgwBaseDAOImpl implements NodeTypeDAO{
 
 	
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
 	
			
		

	
	/*
	protected NodeType load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalNodeType(accessKey, options);
	}
	*/
	
	public SmartList<NodeType> loadAll() {
	    return this.loadAll(getNodeTypeMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public NodeType load(String id,Map<String,Object> options) throws Exception{
		return loadInternalNodeType(NodeTypeTable.withId(id), options);
	}
	
	
	
	public NodeType loadByCode(String code,Map<String,Object> options) throws Exception{
		return loadInternalNodeType(NodeTypeTable.withCode( code), options);
	}
	
	
	public NodeType save(NodeType nodeType,Map<String,Object> options){
		
		String methodName="save(NodeType nodeType,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(nodeType, methodName, "nodeType");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalNodeType(nodeType,options);
	}
	public NodeType clone(String nodeTypeId, Map<String,Object> options) throws Exception{
	
		return clone(NodeTypeTable.withId(nodeTypeId),options);
	}
	
	protected NodeType clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String nodeTypeId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		NodeType newNodeType = loadInternalNodeType(accessKey, options);
		newNodeType.setVersion(0);
		
		
 		
 		if(isSaveNodeListEnabled(options)){
 			for(Node item: newNodeType.getNodeList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalNodeType(newNodeType,options);
		
		return newNodeType;
	}
	
	
	
	public NodeType cloneByCode(String code,Map<String,Object> options) throws Exception{
		return clone(NodeTypeTable.withCode( code), options);
	}
	
	
	

	protected void throwIfHasException(String nodeTypeId,int version,int count) throws Exception{
		if (count == 1) {
			throw new NodeTypeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new NodeTypeNotFoundException(
					"The " + this.getTableName() + "(" + nodeTypeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String nodeTypeId, int version) throws Exception{
	
		String methodName="delete(String nodeTypeId, int version)";
		assertMethodArgumentNotNull(nodeTypeId, methodName, "nodeTypeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{nodeTypeId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(nodeTypeId,version);
		}
		
	
	}
	
	
	
	
	

	public NodeType disconnectFromAll(String nodeTypeId, int version) throws Exception{
	
		
		NodeType nodeType = loadInternalNodeType(NodeTypeTable.withId(nodeTypeId), emptyOptions());
		nodeType.clearFromAll();
		this.saveNodeType(nodeType);
		return nodeType;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return NodeTypeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "node_type";
	}
	@Override
	protected String getBeanName() {
		
		return "nodeType";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return NodeTypeTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractNetworkEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, NodeTypeTokens.NETWORK);
 	}

 	protected boolean isSaveNetworkEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, NodeTypeTokens.NETWORK);
 	}
 	

 	
 
		
	
	protected boolean isExtractNodeListEnabled(Map<String,Object> options){		
 		return checkOptions(options,NodeTypeTokens.NODE_LIST);
 	}
 	protected boolean isAnalyzeNodeListEnabled(Map<String,Object> options){		 		
 		return NodeTypeTokens.of(options).analyzeNodeListEnabled();
 	}
	
	protected boolean isSaveNodeListEnabled(Map<String,Object> options){
		return checkOptions(options, NodeTypeTokens.NODE_LIST);
		
 	}
 	
		

	

	protected NodeTypeMapper getNodeTypeMapper(){
		return new NodeTypeMapper();
	}

	
	
	protected NodeType extractNodeType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			NodeType nodeType = loadSingleObject(accessKey, getNodeTypeMapper());
			return nodeType;
		}catch(EmptyResultDataAccessException e){
			throw new NodeTypeNotFoundException("NodeType("+accessKey+") is not found!");
		}

	}

	
	

	protected NodeType loadInternalNodeType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		NodeType nodeType = extractNodeType(accessKey, loadOptions);
 	
 		if(isExtractNetworkEnabled(loadOptions)){
	 		extractNetwork(nodeType, loadOptions);
 		}
 
		
		if(isExtractNodeListEnabled(loadOptions)){
	 		extractNodeList(nodeType, loadOptions);
 		}	
 		if(isAnalyzeNodeListEnabled(loadOptions)){
	 		analyzeNodeList(nodeType, loadOptions);
 		}
 		
		
		return nodeType;
		
	}

	 

 	protected NodeType extractNetwork(NodeType nodeType, Map<String,Object> options) throws Exception{

		if(nodeType.getNetwork() == null){
			return nodeType;
		}
		String networkId = nodeType.getNetwork().getId();
		if( networkId == null){
			return nodeType;
		}
		HyperledgerNetwork network = getHyperledgerNetworkDAO().load(networkId,options);
		if(network != null){
			nodeType.setNetwork(network);
		}
		
 		
 		return nodeType;
 	}
 		
 
		
	protected void enhanceNodeList(SmartList<Node> nodeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected NodeType extractNodeList(NodeType nodeType, Map<String,Object> options){
		
		
		if(nodeType == null){
			return null;
		}
		if(nodeType.getId() == null){
			return nodeType;
		}

		
		
		SmartList<Node> nodeList = getNodeDAO().findNodeByType(nodeType.getId(),options);
		if(nodeList != null){
			enhanceNodeList(nodeList,options);
			nodeType.setNodeList(nodeList);
		}
		
		return nodeType;
	
	}	
	
	protected NodeType analyzeNodeList(NodeType nodeType, Map<String,Object> options){
		
		
		if(nodeType == null){
			return null;
		}
		if(nodeType.getId() == null){
			return nodeType;
		}

		
		
		SmartList<Node> nodeList = nodeType.getNodeList();
		if(nodeList != null){
			getNodeDAO().analyzeNodeByType(nodeList, nodeType.getId(), options);
			
		}
		
		return nodeType;
	
	}	
	
		
		
  	
 	public SmartList<NodeType> findNodeTypeByNetwork(String hyperledgerNetworkId,Map<String,Object> options){
 	
  		SmartList<NodeType> resultList = queryWith(NodeTypeTable.COLUMN_NETWORK, hyperledgerNetworkId, options, getNodeTypeMapper());
		// analyzeNodeTypeByNetwork(resultList, hyperledgerNetworkId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<NodeType> findNodeTypeByNetwork(String hyperledgerNetworkId, int start, int count,Map<String,Object> options){
 		
 		SmartList<NodeType> resultList =  queryWithRange(NodeTypeTable.COLUMN_NETWORK, hyperledgerNetworkId, options, getNodeTypeMapper(), start, count);
 		//analyzeNodeTypeByNetwork(resultList, hyperledgerNetworkId, options);
 		return resultList;
 		
 	}
 	public void analyzeNodeTypeByNetwork(SmartList<NodeType> resultList, String hyperledgerNetworkId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countNodeTypeByNetwork(String hyperledgerNetworkId,Map<String,Object> options){

 		return countWith(NodeTypeTable.COLUMN_NETWORK, hyperledgerNetworkId, options);
 	}
 	@Override
	public Map<String, Integer> countNodeTypeByNetworkIds(String[] ids, Map<String, Object> options) {
		return countWithIds(NodeTypeTable.COLUMN_NETWORK, ids, options);
	}
 	
 	
		
		
		

	

	protected NodeType saveNodeType(NodeType  nodeType){
		
		if(!nodeType.isChanged()){
			return nodeType;
		}
		
		
		String SQL=this.getSaveNodeTypeSQL(nodeType);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveNodeTypeParameters(nodeType);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		nodeType.incVersion();
		return nodeType;
	
	}
	public SmartList<NodeType> saveNodeTypeList(SmartList<NodeType> nodeTypeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitNodeTypeList(nodeTypeList);
		
		batchNodeTypeCreate((List<NodeType>)lists[CREATE_LIST_INDEX]);
		
		batchNodeTypeUpdate((List<NodeType>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(NodeType nodeType:nodeTypeList){
			if(nodeType.isChanged()){
				nodeType.incVersion();
			}
			
		
		}
		
		
		return nodeTypeList;
	}

	public SmartList<NodeType> removeNodeTypeList(SmartList<NodeType> nodeTypeList,Map<String,Object> options){
		
		
		super.removeList(nodeTypeList, options);
		
		return nodeTypeList;
		
		
	}
	
	protected List<Object[]> prepareNodeTypeBatchCreateArgs(List<NodeType> nodeTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(NodeType nodeType:nodeTypeList ){
			Object [] parameters = prepareNodeTypeCreateParameters(nodeType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareNodeTypeBatchUpdateArgs(List<NodeType> nodeTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(NodeType nodeType:nodeTypeList ){
			if(!nodeType.isChanged()){
				continue;
			}
			Object [] parameters = prepareNodeTypeUpdateParameters(nodeType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchNodeTypeCreate(List<NodeType> nodeTypeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareNodeTypeBatchCreateArgs(nodeTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchNodeTypeUpdate(List<NodeType> nodeTypeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareNodeTypeBatchUpdateArgs(nodeTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitNodeTypeList(List<NodeType> nodeTypeList){
		
		List<NodeType> nodeTypeCreateList=new ArrayList<NodeType>();
		List<NodeType> nodeTypeUpdateList=new ArrayList<NodeType>();
		
		for(NodeType nodeType: nodeTypeList){
			if(isUpdateRequest(nodeType)){
				nodeTypeUpdateList.add( nodeType);
				continue;
			}
			nodeTypeCreateList.add(nodeType);
		}
		
		return new Object[]{nodeTypeCreateList,nodeTypeUpdateList};
	}
	
	protected boolean isUpdateRequest(NodeType nodeType){
 		return nodeType.getVersion() > 0;
 	}
 	protected String getSaveNodeTypeSQL(NodeType nodeType){
 		if(isUpdateRequest(nodeType)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveNodeTypeParameters(NodeType nodeType){
 		if(isUpdateRequest(nodeType) ){
 			return prepareNodeTypeUpdateParameters(nodeType);
 		}
 		return prepareNodeTypeCreateParameters(nodeType);
 	}
 	protected Object[] prepareNodeTypeUpdateParameters(NodeType nodeType){
 		Object[] parameters = new Object[9];
 
 		parameters[0] = nodeType.getName();
 		parameters[1] = nodeType.getCode(); 	
 		if(nodeType.getNetwork() != null){
 			parameters[2] = nodeType.getNetwork().getId();
 		}
 
 		parameters[3] = nodeType.getAddress();
 		parameters[4] = nodeType.getContactPerson();
 		parameters[5] = nodeType.getContactTelephone();		
 		parameters[6] = nodeType.nextVersion();
 		parameters[7] = nodeType.getId();
 		parameters[8] = nodeType.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareNodeTypeCreateParameters(NodeType nodeType){
		Object[] parameters = new Object[7];
		String newNodeTypeId=getNextId();
		nodeType.setId(newNodeTypeId);
		parameters[0] =  nodeType.getId();
 
 		parameters[1] = nodeType.getName();
 		parameters[2] = nodeType.getCode(); 	
 		if(nodeType.getNetwork() != null){
 			parameters[3] = nodeType.getNetwork().getId();
 		
 		}
 		
 		parameters[4] = nodeType.getAddress();
 		parameters[5] = nodeType.getContactPerson();
 		parameters[6] = nodeType.getContactTelephone();		
 				
 		return parameters;
 	}
 	
	protected NodeType saveInternalNodeType(NodeType nodeType, Map<String,Object> options){
		
		saveNodeType(nodeType);
 	
 		if(isSaveNetworkEnabled(options)){
	 		saveNetwork(nodeType, options);
 		}
 
		
		if(isSaveNodeListEnabled(options)){
	 		saveNodeList(nodeType, options);
	 		//removeNodeList(nodeType, options);
	 		//Not delete the record
	 		
 		}		
		
		return nodeType;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected NodeType saveNetwork(NodeType nodeType, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(nodeType.getNetwork() == null){
 			return nodeType;//do nothing when it is null
 		}
 		
 		getHyperledgerNetworkDAO().save(nodeType.getNetwork(),options);
 		return nodeType;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public NodeType planToRemoveNodeList(NodeType nodeType, String nodeIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Node.TYPE_PROPERTY, nodeType.getId());
		key.put(Node.ID_PROPERTY, nodeIds);
		
		SmartList<Node> externalNodeList = getNodeDAO().
				findNodeWithKey(key, options);
		if(externalNodeList == null){
			return nodeType;
		}
		if(externalNodeList.isEmpty()){
			return nodeType;
		}
		
		for(Node nodeItem: externalNodeList){

			nodeItem.clearFromAll();
		}
		
		
		SmartList<Node> nodeList = nodeType.getNodeList();		
		nodeList.addAllToRemoveList(externalNodeList);
		return nodeType;	
	
	}


	//disconnect NodeType with organization in Node
	public NodeType planToRemoveNodeListWithOrganization(NodeType nodeType, String organizationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Node.TYPE_PROPERTY, nodeType.getId());
		key.put(Node.ORGANIZATION_PROPERTY, organizationId);
		
		SmartList<Node> externalNodeList = getNodeDAO().
				findNodeWithKey(key, options);
		if(externalNodeList == null){
			return nodeType;
		}
		if(externalNodeList.isEmpty()){
			return nodeType;
		}
		
		for(Node nodeItem: externalNodeList){
			nodeItem.clearOrganization();
			nodeItem.clearType();
			
		}
		
		
		SmartList<Node> nodeList = nodeType.getNodeList();		
		nodeList.addAllToRemoveList(externalNodeList);
		return nodeType;
	}
	
	public int countNodeListWithOrganization(String nodeTypeId, String organizationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Node.TYPE_PROPERTY, nodeTypeId);
		key.put(Node.ORGANIZATION_PROPERTY, organizationId);
		
		int count = getNodeDAO().countNodeWithKey(key, options);
		return count;
	}
	
	//disconnect NodeType with channel in Node
	public NodeType planToRemoveNodeListWithChannel(NodeType nodeType, String channelId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Node.TYPE_PROPERTY, nodeType.getId());
		key.put(Node.CHANNEL_PROPERTY, channelId);
		
		SmartList<Node> externalNodeList = getNodeDAO().
				findNodeWithKey(key, options);
		if(externalNodeList == null){
			return nodeType;
		}
		if(externalNodeList.isEmpty()){
			return nodeType;
		}
		
		for(Node nodeItem: externalNodeList){
			nodeItem.clearChannel();
			nodeItem.clearType();
			
		}
		
		
		SmartList<Node> nodeList = nodeType.getNodeList();		
		nodeList.addAllToRemoveList(externalNodeList);
		return nodeType;
	}
	
	public int countNodeListWithChannel(String nodeTypeId, String channelId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Node.TYPE_PROPERTY, nodeTypeId);
		key.put(Node.CHANNEL_PROPERTY, channelId);
		
		int count = getNodeDAO().countNodeWithKey(key, options);
		return count;
	}
	

		
	protected NodeType saveNodeList(NodeType nodeType, Map<String,Object> options){
		
		
		
		
		SmartList<Node> nodeList = nodeType.getNodeList();
		if(nodeList == null){
			//null list means nothing
			return nodeType;
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
		
		
		return nodeType;
	
	}
	
	protected NodeType removeNodeList(NodeType nodeType, Map<String,Object> options){
	
	
		SmartList<Node> nodeList = nodeType.getNodeList();
		if(nodeList == null){
			return nodeType;
		}	
	
		SmartList<Node> toRemoveNodeList = nodeList.getToRemoveList();
		
		if(toRemoveNodeList == null){
			return nodeType;
		}
		if(toRemoveNodeList.isEmpty()){
			return nodeType;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getNodeDAO().removeNodeList(toRemoveNodeList,options);
		
		return nodeType;
	
	}
	
	

 	
 	
	
	
	
		

	public NodeType present(NodeType nodeType,Map<String, Object> options){
	
		presentNodeList(nodeType,options);

		return nodeType;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected NodeType presentNodeList(
			NodeType nodeType,
			Map<String, Object> options) {

		SmartList<Node> nodeList = nodeType.getNodeList();		
				SmartList<Node> newList= presentSubList(nodeType.getId(),
				nodeList,
				options,
				getNodeDAO()::countNodeByType,
				getNodeDAO()::findNodeByType
				);

		
		nodeType.setNodeList(newList);
		

		return nodeType;
	}			
		

	
    public SmartList<NodeType> requestCandidateNodeTypeForNode(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(NodeTypeTable.COLUMN_NAME, filterKey, pageNo, pageSize, getNodeTypeMapper());
    }
		

	protected String getTableName(){
		return NodeTypeTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<NodeType> nodeTypeList) {		
		this.enhanceListInternal(nodeTypeList, this.getNodeTypeMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:Node的type的NodeList
	public SmartList<Node> loadOurNodeList(HfgwUserContext userContext, List<NodeType> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Node.TYPE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Node> loadedObjs = userContext.getDAOGroup().getNodeDAO().findNodeWithKey(key, options);
		Map<String, List<Node>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getType().getId()));
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
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<NodeType> nodeTypeList = ownerEntity.collectRefsWithType(NodeType.INTERNAL_TYPE);
		this.enhanceList(nodeTypeList);
		
	}
	
	@Override
	public SmartList<NodeType> findNodeTypeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getNodeTypeMapper());

	}
	@Override
	public int countNodeTypeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countNodeTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<NodeType> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getNodeTypeMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


