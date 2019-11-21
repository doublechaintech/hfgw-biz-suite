
package com.doublechaintech.hfgw.organization;

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


public class OrganizationJDBCTemplateDAO extends HfgwBaseDAOImpl implements OrganizationDAO{
 
 	
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
	protected Organization load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalOrganization(accessKey, options);
	}
	*/
	
	public SmartList<Organization> loadAll() {
	    return this.loadAll(getOrganizationMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Organization load(String id,Map<String,Object> options) throws Exception{
		return loadInternalOrganization(OrganizationTable.withId(id), options);
	}
	
	
	
	public Organization save(Organization organization,Map<String,Object> options){
		
		String methodName="save(Organization organization,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(organization, methodName, "organization");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalOrganization(organization,options);
	}
	public Organization clone(String organizationId, Map<String,Object> options) throws Exception{
	
		return clone(OrganizationTable.withId(organizationId),options);
	}
	
	protected Organization clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String organizationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Organization newOrganization = loadInternalOrganization(accessKey, options);
		newOrganization.setVersion(0);
		
		
 		
 		if(isSaveNodeListEnabled(options)){
 			for(Node item: newOrganization.getNodeList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalOrganization(newOrganization,options);
		
		return newOrganization;
	}
	
	
	
	

	protected void throwIfHasException(String organizationId,int version,int count) throws Exception{
		if (count == 1) {
			throw new OrganizationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new OrganizationNotFoundException(
					"The " + this.getTableName() + "(" + organizationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String organizationId, int version) throws Exception{
	
		String methodName="delete(String organizationId, int version)";
		assertMethodArgumentNotNull(organizationId, methodName, "organizationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{organizationId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(organizationId,version);
		}
		
	
	}
	
	
	
	
	

	public Organization disconnectFromAll(String organizationId, int version) throws Exception{
	
		
		Organization organization = loadInternalOrganization(OrganizationTable.withId(organizationId), emptyOptions());
		organization.clearFromAll();
		this.saveOrganization(organization);
		return organization;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return OrganizationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "organization";
	}
	@Override
	protected String getBeanName() {
		
		return "organization";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return OrganizationTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractNetworkEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, OrganizationTokens.NETWORK);
 	}

 	protected boolean isSaveNetworkEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, OrganizationTokens.NETWORK);
 	}
 	

 	
 
		
	
	protected boolean isExtractNodeListEnabled(Map<String,Object> options){		
 		return checkOptions(options,OrganizationTokens.NODE_LIST);
 	}
 	protected boolean isAnalyzeNodeListEnabled(Map<String,Object> options){		 		
 		return OrganizationTokens.of(options).analyzeNodeListEnabled();
 	}
	
	protected boolean isSaveNodeListEnabled(Map<String,Object> options){
		return checkOptions(options, OrganizationTokens.NODE_LIST);
		
 	}
 	
		

	

	protected OrganizationMapper getOrganizationMapper(){
		return new OrganizationMapper();
	}

	
	
	protected Organization extractOrganization(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Organization organization = loadSingleObject(accessKey, getOrganizationMapper());
			return organization;
		}catch(EmptyResultDataAccessException e){
			throw new OrganizationNotFoundException("Organization("+accessKey+") is not found!");
		}

	}

	
	

	protected Organization loadInternalOrganization(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Organization organization = extractOrganization(accessKey, loadOptions);
 	
 		if(isExtractNetworkEnabled(loadOptions)){
	 		extractNetwork(organization, loadOptions);
 		}
 
		
		if(isExtractNodeListEnabled(loadOptions)){
	 		extractNodeList(organization, loadOptions);
 		}	
 		if(isAnalyzeNodeListEnabled(loadOptions)){
	 		analyzeNodeList(organization, loadOptions);
 		}
 		
		
		return organization;
		
	}

	 

 	protected Organization extractNetwork(Organization organization, Map<String,Object> options) throws Exception{

		if(organization.getNetwork() == null){
			return organization;
		}
		String networkId = organization.getNetwork().getId();
		if( networkId == null){
			return organization;
		}
		HyperledgerNetwork network = getHyperledgerNetworkDAO().load(networkId,options);
		if(network != null){
			organization.setNetwork(network);
		}
		
 		
 		return organization;
 	}
 		
 
		
	protected void enhanceNodeList(SmartList<Node> nodeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Organization extractNodeList(Organization organization, Map<String,Object> options){
		
		
		if(organization == null){
			return null;
		}
		if(organization.getId() == null){
			return organization;
		}

		
		
		SmartList<Node> nodeList = getNodeDAO().findNodeByOrganization(organization.getId(),options);
		if(nodeList != null){
			enhanceNodeList(nodeList,options);
			organization.setNodeList(nodeList);
		}
		
		return organization;
	
	}	
	
	protected Organization analyzeNodeList(Organization organization, Map<String,Object> options){
		
		
		if(organization == null){
			return null;
		}
		if(organization.getId() == null){
			return organization;
		}

		
		
		SmartList<Node> nodeList = organization.getNodeList();
		if(nodeList != null){
			getNodeDAO().analyzeNodeByOrganization(nodeList, organization.getId(), options);
			
		}
		
		return organization;
	
	}	
	
		
		
  	
 	public SmartList<Organization> findOrganizationByNetwork(String hyperledgerNetworkId,Map<String,Object> options){
 	
  		SmartList<Organization> resultList = queryWith(OrganizationTable.COLUMN_NETWORK, hyperledgerNetworkId, options, getOrganizationMapper());
		// analyzeOrganizationByNetwork(resultList, hyperledgerNetworkId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Organization> findOrganizationByNetwork(String hyperledgerNetworkId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Organization> resultList =  queryWithRange(OrganizationTable.COLUMN_NETWORK, hyperledgerNetworkId, options, getOrganizationMapper(), start, count);
 		//analyzeOrganizationByNetwork(resultList, hyperledgerNetworkId, options);
 		return resultList;
 		
 	}
 	public void analyzeOrganizationByNetwork(SmartList<Organization> resultList, String hyperledgerNetworkId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countOrganizationByNetwork(String hyperledgerNetworkId,Map<String,Object> options){

 		return countWith(OrganizationTable.COLUMN_NETWORK, hyperledgerNetworkId, options);
 	}
 	@Override
	public Map<String, Integer> countOrganizationByNetworkIds(String[] ids, Map<String, Object> options) {
		return countWithIds(OrganizationTable.COLUMN_NETWORK, ids, options);
	}
 	
 	
		
		
		

	

	protected Organization saveOrganization(Organization  organization){
		
		if(!organization.isChanged()){
			return organization;
		}
		
		
		String SQL=this.getSaveOrganizationSQL(organization);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveOrganizationParameters(organization);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		organization.incVersion();
		return organization;
	
	}
	public SmartList<Organization> saveOrganizationList(SmartList<Organization> organizationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitOrganizationList(organizationList);
		
		batchOrganizationCreate((List<Organization>)lists[CREATE_LIST_INDEX]);
		
		batchOrganizationUpdate((List<Organization>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Organization organization:organizationList){
			if(organization.isChanged()){
				organization.incVersion();
			}
			
		
		}
		
		
		return organizationList;
	}

	public SmartList<Organization> removeOrganizationList(SmartList<Organization> organizationList,Map<String,Object> options){
		
		
		super.removeList(organizationList, options);
		
		return organizationList;
		
		
	}
	
	protected List<Object[]> prepareOrganizationBatchCreateArgs(List<Organization> organizationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Organization organization:organizationList ){
			Object [] parameters = prepareOrganizationCreateParameters(organization);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareOrganizationBatchUpdateArgs(List<Organization> organizationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Organization organization:organizationList ){
			if(!organization.isChanged()){
				continue;
			}
			Object [] parameters = prepareOrganizationUpdateParameters(organization);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchOrganizationCreate(List<Organization> organizationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareOrganizationBatchCreateArgs(organizationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchOrganizationUpdate(List<Organization> organizationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareOrganizationBatchUpdateArgs(organizationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitOrganizationList(List<Organization> organizationList){
		
		List<Organization> organizationCreateList=new ArrayList<Organization>();
		List<Organization> organizationUpdateList=new ArrayList<Organization>();
		
		for(Organization organization: organizationList){
			if(isUpdateRequest(organization)){
				organizationUpdateList.add( organization);
				continue;
			}
			organizationCreateList.add(organization);
		}
		
		return new Object[]{organizationCreateList,organizationUpdateList};
	}
	
	protected boolean isUpdateRequest(Organization organization){
 		return organization.getVersion() > 0;
 	}
 	protected String getSaveOrganizationSQL(Organization organization){
 		if(isUpdateRequest(organization)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveOrganizationParameters(Organization organization){
 		if(isUpdateRequest(organization) ){
 			return prepareOrganizationUpdateParameters(organization);
 		}
 		return prepareOrganizationCreateParameters(organization);
 	}
 	protected Object[] prepareOrganizationUpdateParameters(Organization organization){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = organization.getName();
 		parameters[1] = organization.getMspid(); 	
 		if(organization.getNetwork() != null){
 			parameters[2] = organization.getNetwork().getId();
 		}
 		
 		parameters[3] = organization.nextVersion();
 		parameters[4] = organization.getId();
 		parameters[5] = organization.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareOrganizationCreateParameters(Organization organization){
		Object[] parameters = new Object[4];
		String newOrganizationId=getNextId();
		organization.setId(newOrganizationId);
		parameters[0] =  organization.getId();
 
 		parameters[1] = organization.getName();
 		parameters[2] = organization.getMspid(); 	
 		if(organization.getNetwork() != null){
 			parameters[3] = organization.getNetwork().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected Organization saveInternalOrganization(Organization organization, Map<String,Object> options){
		
		saveOrganization(organization);
 	
 		if(isSaveNetworkEnabled(options)){
	 		saveNetwork(organization, options);
 		}
 
		
		if(isSaveNodeListEnabled(options)){
	 		saveNodeList(organization, options);
	 		//removeNodeList(organization, options);
	 		//Not delete the record
	 		
 		}		
		
		return organization;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Organization saveNetwork(Organization organization, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(organization.getNetwork() == null){
 			return organization;//do nothing when it is null
 		}
 		
 		getHyperledgerNetworkDAO().save(organization.getNetwork(),options);
 		return organization;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public Organization planToRemoveNodeList(Organization organization, String nodeIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Node.ORGANIZATION_PROPERTY, organization.getId());
		key.put(Node.ID_PROPERTY, nodeIds);
		
		SmartList<Node> externalNodeList = getNodeDAO().
				findNodeWithKey(key, options);
		if(externalNodeList == null){
			return organization;
		}
		if(externalNodeList.isEmpty()){
			return organization;
		}
		
		for(Node nodeItem: externalNodeList){

			nodeItem.clearFromAll();
		}
		
		
		SmartList<Node> nodeList = organization.getNodeList();		
		nodeList.addAllToRemoveList(externalNodeList);
		return organization;	
	
	}


	//disconnect Organization with channel in Node
	public Organization planToRemoveNodeListWithChannel(Organization organization, String channelId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Node.ORGANIZATION_PROPERTY, organization.getId());
		key.put(Node.CHANNEL_PROPERTY, channelId);
		
		SmartList<Node> externalNodeList = getNodeDAO().
				findNodeWithKey(key, options);
		if(externalNodeList == null){
			return organization;
		}
		if(externalNodeList.isEmpty()){
			return organization;
		}
		
		for(Node nodeItem: externalNodeList){
			nodeItem.clearChannel();
			nodeItem.clearOrganization();
			
		}
		
		
		SmartList<Node> nodeList = organization.getNodeList();		
		nodeList.addAllToRemoveList(externalNodeList);
		return organization;
	}
	
	public int countNodeListWithChannel(String organizationId, String channelId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Node.ORGANIZATION_PROPERTY, organizationId);
		key.put(Node.CHANNEL_PROPERTY, channelId);
		
		int count = getNodeDAO().countNodeWithKey(key, options);
		return count;
	}
	
	//disconnect Organization with network in Node
	public Organization planToRemoveNodeListWithNetwork(Organization organization, String networkId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Node.ORGANIZATION_PROPERTY, organization.getId());
		key.put(Node.NETWORK_PROPERTY, networkId);
		
		SmartList<Node> externalNodeList = getNodeDAO().
				findNodeWithKey(key, options);
		if(externalNodeList == null){
			return organization;
		}
		if(externalNodeList.isEmpty()){
			return organization;
		}
		
		for(Node nodeItem: externalNodeList){
			nodeItem.clearNetwork();
			nodeItem.clearOrganization();
			
		}
		
		
		SmartList<Node> nodeList = organization.getNodeList();		
		nodeList.addAllToRemoveList(externalNodeList);
		return organization;
	}
	
	public int countNodeListWithNetwork(String organizationId, String networkId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Node.ORGANIZATION_PROPERTY, organizationId);
		key.put(Node.NETWORK_PROPERTY, networkId);
		
		int count = getNodeDAO().countNodeWithKey(key, options);
		return count;
	}
	
	//disconnect Organization with type in Node
	public Organization planToRemoveNodeListWithType(Organization organization, String typeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Node.ORGANIZATION_PROPERTY, organization.getId());
		key.put(Node.TYPE_PROPERTY, typeId);
		
		SmartList<Node> externalNodeList = getNodeDAO().
				findNodeWithKey(key, options);
		if(externalNodeList == null){
			return organization;
		}
		if(externalNodeList.isEmpty()){
			return organization;
		}
		
		for(Node nodeItem: externalNodeList){
			nodeItem.clearType();
			nodeItem.clearOrganization();
			
		}
		
		
		SmartList<Node> nodeList = organization.getNodeList();		
		nodeList.addAllToRemoveList(externalNodeList);
		return organization;
	}
	
	public int countNodeListWithType(String organizationId, String typeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Node.ORGANIZATION_PROPERTY, organizationId);
		key.put(Node.TYPE_PROPERTY, typeId);
		
		int count = getNodeDAO().countNodeWithKey(key, options);
		return count;
	}
	

		
	protected Organization saveNodeList(Organization organization, Map<String,Object> options){
		
		
		
		
		SmartList<Node> nodeList = organization.getNodeList();
		if(nodeList == null){
			//null list means nothing
			return organization;
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
		
		
		return organization;
	
	}
	
	protected Organization removeNodeList(Organization organization, Map<String,Object> options){
	
	
		SmartList<Node> nodeList = organization.getNodeList();
		if(nodeList == null){
			return organization;
		}	
	
		SmartList<Node> toRemoveNodeList = nodeList.getToRemoveList();
		
		if(toRemoveNodeList == null){
			return organization;
		}
		if(toRemoveNodeList.isEmpty()){
			return organization;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getNodeDAO().removeNodeList(toRemoveNodeList,options);
		
		return organization;
	
	}
	
	

 	
 	
	
	
	
		

	public Organization present(Organization organization,Map<String, Object> options){
	
		presentNodeList(organization,options);

		return organization;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Organization presentNodeList(
			Organization organization,
			Map<String, Object> options) {

		SmartList<Node> nodeList = organization.getNodeList();		
				SmartList<Node> newList= presentSubList(organization.getId(),
				nodeList,
				options,
				getNodeDAO()::countNodeByOrganization,
				getNodeDAO()::findNodeByOrganization
				);

		
		organization.setNodeList(newList);
		

		return organization;
	}			
		

	
    public SmartList<Organization> requestCandidateOrganizationForNode(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(OrganizationTable.COLUMN_NAME, filterKey, pageNo, pageSize, getOrganizationMapper());
    }
		

	protected String getTableName(){
		return OrganizationTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Organization> organizationList) {		
		this.enhanceListInternal(organizationList, this.getOrganizationMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:Node的organization的NodeList
	public SmartList<Node> loadOurNodeList(HfgwUserContext userContext, List<Organization> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Node.ORGANIZATION_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Node> loadedObjs = userContext.getDAOGroup().getNodeDAO().findNodeWithKey(key, options);
		Map<String, List<Node>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getOrganization().getId()));
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
		List<Organization> organizationList = ownerEntity.collectRefsWithType(Organization.INTERNAL_TYPE);
		this.enhanceList(organizationList);
		
	}
	
	@Override
	public SmartList<Organization> findOrganizationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getOrganizationMapper());

	}
	@Override
	public int countOrganizationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countOrganizationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Organization> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getOrganizationMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


