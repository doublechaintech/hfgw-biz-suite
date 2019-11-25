
package com.doublechaintech.hfgw.peerrole;

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
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;

import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetworkDAO;
import com.doublechaintech.hfgw.channelpeerrole.ChannelPeerRoleDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class PeerRoleJDBCTemplateDAO extends HfgwBaseDAOImpl implements PeerRoleDAO{
 
 	
 	private  HyperledgerNetworkDAO  hyperledgerNetworkDAO;
 	public void setHyperledgerNetworkDAO(HyperledgerNetworkDAO hyperledgerNetworkDAO){
	 	this.hyperledgerNetworkDAO = hyperledgerNetworkDAO;
 	}
 	public HyperledgerNetworkDAO getHyperledgerNetworkDAO(){
	 	return this.hyperledgerNetworkDAO;
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
	protected PeerRole load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalPeerRole(accessKey, options);
	}
	*/
	
	public SmartList<PeerRole> loadAll() {
	    return this.loadAll(getPeerRoleMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public PeerRole load(String id,Map<String,Object> options) throws Exception{
		return loadInternalPeerRole(PeerRoleTable.withId(id), options);
	}
	
	
	
	public PeerRole loadByCode(String code,Map<String,Object> options) throws Exception{
		return loadInternalPeerRole(PeerRoleTable.withCode( code), options);
	}
	
	
	public PeerRole save(PeerRole peerRole,Map<String,Object> options){
		
		String methodName="save(PeerRole peerRole,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(peerRole, methodName, "peerRole");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalPeerRole(peerRole,options);
	}
	public PeerRole clone(String peerRoleId, Map<String,Object> options) throws Exception{
	
		return clone(PeerRoleTable.withId(peerRoleId),options);
	}
	
	protected PeerRole clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String peerRoleId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		PeerRole newPeerRole = loadInternalPeerRole(accessKey, options);
		newPeerRole.setVersion(0);
		
		
 		
 		if(isSaveChannelPeerRoleListEnabled(options)){
 			for(ChannelPeerRole item: newPeerRole.getChannelPeerRoleList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalPeerRole(newPeerRole,options);
		
		return newPeerRole;
	}
	
	
	
	public PeerRole cloneByCode(String code,Map<String,Object> options) throws Exception{
		return clone(PeerRoleTable.withCode( code), options);
	}
	
	
	

	protected void throwIfHasException(String peerRoleId,int version,int count) throws Exception{
		if (count == 1) {
			throw new PeerRoleVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new PeerRoleNotFoundException(
					"The " + this.getTableName() + "(" + peerRoleId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String peerRoleId, int version) throws Exception{
	
		String methodName="delete(String peerRoleId, int version)";
		assertMethodArgumentNotNull(peerRoleId, methodName, "peerRoleId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{peerRoleId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(peerRoleId,version);
		}
		
	
	}
	
	
	
	
	

	public PeerRole disconnectFromAll(String peerRoleId, int version) throws Exception{
	
		
		PeerRole peerRole = loadInternalPeerRole(PeerRoleTable.withId(peerRoleId), emptyOptions());
		peerRole.clearFromAll();
		this.savePeerRole(peerRole);
		return peerRole;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return PeerRoleTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "peer_role";
	}
	@Override
	protected String getBeanName() {
		
		return "peerRole";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return PeerRoleTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractNetworkEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, PeerRoleTokens.NETWORK);
 	}

 	protected boolean isSaveNetworkEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, PeerRoleTokens.NETWORK);
 	}
 	

 	
 
		
	
	protected boolean isExtractChannelPeerRoleListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PeerRoleTokens.CHANNEL_PEER_ROLE_LIST);
 	}
 	protected boolean isAnalyzeChannelPeerRoleListEnabled(Map<String,Object> options){		 		
 		return PeerRoleTokens.of(options).analyzeChannelPeerRoleListEnabled();
 	}
	
	protected boolean isSaveChannelPeerRoleListEnabled(Map<String,Object> options){
		return checkOptions(options, PeerRoleTokens.CHANNEL_PEER_ROLE_LIST);
		
 	}
 	
		

	

	protected PeerRoleMapper getPeerRoleMapper(){
		return new PeerRoleMapper();
	}

	
	
	protected PeerRole extractPeerRole(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			PeerRole peerRole = loadSingleObject(accessKey, getPeerRoleMapper());
			return peerRole;
		}catch(EmptyResultDataAccessException e){
			throw new PeerRoleNotFoundException("PeerRole("+accessKey+") is not found!");
		}

	}

	
	

	protected PeerRole loadInternalPeerRole(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		PeerRole peerRole = extractPeerRole(accessKey, loadOptions);
 	
 		if(isExtractNetworkEnabled(loadOptions)){
	 		extractNetwork(peerRole, loadOptions);
 		}
 
		
		if(isExtractChannelPeerRoleListEnabled(loadOptions)){
	 		extractChannelPeerRoleList(peerRole, loadOptions);
 		}	
 		if(isAnalyzeChannelPeerRoleListEnabled(loadOptions)){
	 		analyzeChannelPeerRoleList(peerRole, loadOptions);
 		}
 		
		
		return peerRole;
		
	}

	 

 	protected PeerRole extractNetwork(PeerRole peerRole, Map<String,Object> options) throws Exception{

		if(peerRole.getNetwork() == null){
			return peerRole;
		}
		String networkId = peerRole.getNetwork().getId();
		if( networkId == null){
			return peerRole;
		}
		HyperledgerNetwork network = getHyperledgerNetworkDAO().load(networkId,options);
		if(network != null){
			peerRole.setNetwork(network);
		}
		
 		
 		return peerRole;
 	}
 		
 
		
	protected void enhanceChannelPeerRoleList(SmartList<ChannelPeerRole> channelPeerRoleList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected PeerRole extractChannelPeerRoleList(PeerRole peerRole, Map<String,Object> options){
		
		
		if(peerRole == null){
			return null;
		}
		if(peerRole.getId() == null){
			return peerRole;
		}

		
		
		SmartList<ChannelPeerRole> channelPeerRoleList = getChannelPeerRoleDAO().findChannelPeerRoleByPeerRole(peerRole.getId(),options);
		if(channelPeerRoleList != null){
			enhanceChannelPeerRoleList(channelPeerRoleList,options);
			peerRole.setChannelPeerRoleList(channelPeerRoleList);
		}
		
		return peerRole;
	
	}	
	
	protected PeerRole analyzeChannelPeerRoleList(PeerRole peerRole, Map<String,Object> options){
		
		
		if(peerRole == null){
			return null;
		}
		if(peerRole.getId() == null){
			return peerRole;
		}

		
		
		SmartList<ChannelPeerRole> channelPeerRoleList = peerRole.getChannelPeerRoleList();
		if(channelPeerRoleList != null){
			getChannelPeerRoleDAO().analyzeChannelPeerRoleByPeerRole(channelPeerRoleList, peerRole.getId(), options);
			
		}
		
		return peerRole;
	
	}	
	
		
		
  	
 	public SmartList<PeerRole> findPeerRoleByNetwork(String hyperledgerNetworkId,Map<String,Object> options){
 	
  		SmartList<PeerRole> resultList = queryWith(PeerRoleTable.COLUMN_NETWORK, hyperledgerNetworkId, options, getPeerRoleMapper());
		// analyzePeerRoleByNetwork(resultList, hyperledgerNetworkId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<PeerRole> findPeerRoleByNetwork(String hyperledgerNetworkId, int start, int count,Map<String,Object> options){
 		
 		SmartList<PeerRole> resultList =  queryWithRange(PeerRoleTable.COLUMN_NETWORK, hyperledgerNetworkId, options, getPeerRoleMapper(), start, count);
 		//analyzePeerRoleByNetwork(resultList, hyperledgerNetworkId, options);
 		return resultList;
 		
 	}
 	public void analyzePeerRoleByNetwork(SmartList<PeerRole> resultList, String hyperledgerNetworkId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countPeerRoleByNetwork(String hyperledgerNetworkId,Map<String,Object> options){

 		return countWith(PeerRoleTable.COLUMN_NETWORK, hyperledgerNetworkId, options);
 	}
 	@Override
	public Map<String, Integer> countPeerRoleByNetworkIds(String[] ids, Map<String, Object> options) {
		return countWithIds(PeerRoleTable.COLUMN_NETWORK, ids, options);
	}
 	
 	
		
		
		

	

	protected PeerRole savePeerRole(PeerRole  peerRole){
		
		if(!peerRole.isChanged()){
			return peerRole;
		}
		
		
		String SQL=this.getSavePeerRoleSQL(peerRole);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSavePeerRoleParameters(peerRole);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		peerRole.incVersion();
		return peerRole;
	
	}
	public SmartList<PeerRole> savePeerRoleList(SmartList<PeerRole> peerRoleList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitPeerRoleList(peerRoleList);
		
		batchPeerRoleCreate((List<PeerRole>)lists[CREATE_LIST_INDEX]);
		
		batchPeerRoleUpdate((List<PeerRole>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(PeerRole peerRole:peerRoleList){
			if(peerRole.isChanged()){
				peerRole.incVersion();
			}
			
		
		}
		
		
		return peerRoleList;
	}

	public SmartList<PeerRole> removePeerRoleList(SmartList<PeerRole> peerRoleList,Map<String,Object> options){
		
		
		super.removeList(peerRoleList, options);
		
		return peerRoleList;
		
		
	}
	
	protected List<Object[]> preparePeerRoleBatchCreateArgs(List<PeerRole> peerRoleList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(PeerRole peerRole:peerRoleList ){
			Object [] parameters = preparePeerRoleCreateParameters(peerRole);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> preparePeerRoleBatchUpdateArgs(List<PeerRole> peerRoleList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(PeerRole peerRole:peerRoleList ){
			if(!peerRole.isChanged()){
				continue;
			}
			Object [] parameters = preparePeerRoleUpdateParameters(peerRole);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchPeerRoleCreate(List<PeerRole> peerRoleList){
		String SQL=getCreateSQL();
		List<Object[]> args=preparePeerRoleBatchCreateArgs(peerRoleList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchPeerRoleUpdate(List<PeerRole> peerRoleList){
		String SQL=getUpdateSQL();
		List<Object[]> args=preparePeerRoleBatchUpdateArgs(peerRoleList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitPeerRoleList(List<PeerRole> peerRoleList){
		
		List<PeerRole> peerRoleCreateList=new ArrayList<PeerRole>();
		List<PeerRole> peerRoleUpdateList=new ArrayList<PeerRole>();
		
		for(PeerRole peerRole: peerRoleList){
			if(isUpdateRequest(peerRole)){
				peerRoleUpdateList.add( peerRole);
				continue;
			}
			peerRoleCreateList.add(peerRole);
		}
		
		return new Object[]{peerRoleCreateList,peerRoleUpdateList};
	}
	
	protected boolean isUpdateRequest(PeerRole peerRole){
 		return peerRole.getVersion() > 0;
 	}
 	protected String getSavePeerRoleSQL(PeerRole peerRole){
 		if(isUpdateRequest(peerRole)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSavePeerRoleParameters(PeerRole peerRole){
 		if(isUpdateRequest(peerRole) ){
 			return preparePeerRoleUpdateParameters(peerRole);
 		}
 		return preparePeerRoleCreateParameters(peerRole);
 	}
 	protected Object[] preparePeerRoleUpdateParameters(PeerRole peerRole){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = peerRole.getName();
 		parameters[1] = peerRole.getCode(); 	
 		if(peerRole.getNetwork() != null){
 			parameters[2] = peerRole.getNetwork().getId();
 		}
 		
 		parameters[3] = peerRole.nextVersion();
 		parameters[4] = peerRole.getId();
 		parameters[5] = peerRole.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] preparePeerRoleCreateParameters(PeerRole peerRole){
		Object[] parameters = new Object[4];
		String newPeerRoleId=getNextId();
		peerRole.setId(newPeerRoleId);
		parameters[0] =  peerRole.getId();
 
 		parameters[1] = peerRole.getName();
 		parameters[2] = peerRole.getCode(); 	
 		if(peerRole.getNetwork() != null){
 			parameters[3] = peerRole.getNetwork().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected PeerRole saveInternalPeerRole(PeerRole peerRole, Map<String,Object> options){
		
		savePeerRole(peerRole);
 	
 		if(isSaveNetworkEnabled(options)){
	 		saveNetwork(peerRole, options);
 		}
 
		
		if(isSaveChannelPeerRoleListEnabled(options)){
	 		saveChannelPeerRoleList(peerRole, options);
	 		//removeChannelPeerRoleList(peerRole, options);
	 		//Not delete the record
	 		
 		}		
		
		return peerRole;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected PeerRole saveNetwork(PeerRole peerRole, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(peerRole.getNetwork() == null){
 			return peerRole;//do nothing when it is null
 		}
 		
 		getHyperledgerNetworkDAO().save(peerRole.getNetwork(),options);
 		return peerRole;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public PeerRole planToRemoveChannelPeerRoleList(PeerRole peerRole, String channelPeerRoleIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChannelPeerRole.PEER_ROLE_PROPERTY, peerRole.getId());
		key.put(ChannelPeerRole.ID_PROPERTY, channelPeerRoleIds);
		
		SmartList<ChannelPeerRole> externalChannelPeerRoleList = getChannelPeerRoleDAO().
				findChannelPeerRoleWithKey(key, options);
		if(externalChannelPeerRoleList == null){
			return peerRole;
		}
		if(externalChannelPeerRoleList.isEmpty()){
			return peerRole;
		}
		
		for(ChannelPeerRole channelPeerRoleItem: externalChannelPeerRoleList){

			channelPeerRoleItem.clearFromAll();
		}
		
		
		SmartList<ChannelPeerRole> channelPeerRoleList = peerRole.getChannelPeerRoleList();		
		channelPeerRoleList.addAllToRemoveList(externalChannelPeerRoleList);
		return peerRole;	
	
	}


	//disconnect PeerRole with channel in ChannelPeerRole
	public PeerRole planToRemoveChannelPeerRoleListWithChannel(PeerRole peerRole, String channelId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChannelPeerRole.PEER_ROLE_PROPERTY, peerRole.getId());
		key.put(ChannelPeerRole.CHANNEL_PROPERTY, channelId);
		
		SmartList<ChannelPeerRole> externalChannelPeerRoleList = getChannelPeerRoleDAO().
				findChannelPeerRoleWithKey(key, options);
		if(externalChannelPeerRoleList == null){
			return peerRole;
		}
		if(externalChannelPeerRoleList.isEmpty()){
			return peerRole;
		}
		
		for(ChannelPeerRole channelPeerRoleItem: externalChannelPeerRoleList){
			channelPeerRoleItem.clearChannel();
			channelPeerRoleItem.clearPeerRole();
			
		}
		
		
		SmartList<ChannelPeerRole> channelPeerRoleList = peerRole.getChannelPeerRoleList();		
		channelPeerRoleList.addAllToRemoveList(externalChannelPeerRoleList);
		return peerRole;
	}
	
	public int countChannelPeerRoleListWithChannel(String peerRoleId, String channelId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChannelPeerRole.PEER_ROLE_PROPERTY, peerRoleId);
		key.put(ChannelPeerRole.CHANNEL_PROPERTY, channelId);
		
		int count = getChannelPeerRoleDAO().countChannelPeerRoleWithKey(key, options);
		return count;
	}
	
	//disconnect PeerRole with node in ChannelPeerRole
	public PeerRole planToRemoveChannelPeerRoleListWithNode(PeerRole peerRole, String nodeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChannelPeerRole.PEER_ROLE_PROPERTY, peerRole.getId());
		key.put(ChannelPeerRole.NODE_PROPERTY, nodeId);
		
		SmartList<ChannelPeerRole> externalChannelPeerRoleList = getChannelPeerRoleDAO().
				findChannelPeerRoleWithKey(key, options);
		if(externalChannelPeerRoleList == null){
			return peerRole;
		}
		if(externalChannelPeerRoleList.isEmpty()){
			return peerRole;
		}
		
		for(ChannelPeerRole channelPeerRoleItem: externalChannelPeerRoleList){
			channelPeerRoleItem.clearNode();
			channelPeerRoleItem.clearPeerRole();
			
		}
		
		
		SmartList<ChannelPeerRole> channelPeerRoleList = peerRole.getChannelPeerRoleList();		
		channelPeerRoleList.addAllToRemoveList(externalChannelPeerRoleList);
		return peerRole;
	}
	
	public int countChannelPeerRoleListWithNode(String peerRoleId, String nodeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChannelPeerRole.PEER_ROLE_PROPERTY, peerRoleId);
		key.put(ChannelPeerRole.NODE_PROPERTY, nodeId);
		
		int count = getChannelPeerRoleDAO().countChannelPeerRoleWithKey(key, options);
		return count;
	}
	

		
	protected PeerRole saveChannelPeerRoleList(PeerRole peerRole, Map<String,Object> options){
		
		
		
		
		SmartList<ChannelPeerRole> channelPeerRoleList = peerRole.getChannelPeerRoleList();
		if(channelPeerRoleList == null){
			//null list means nothing
			return peerRole;
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
		
		
		return peerRole;
	
	}
	
	protected PeerRole removeChannelPeerRoleList(PeerRole peerRole, Map<String,Object> options){
	
	
		SmartList<ChannelPeerRole> channelPeerRoleList = peerRole.getChannelPeerRoleList();
		if(channelPeerRoleList == null){
			return peerRole;
		}	
	
		SmartList<ChannelPeerRole> toRemoveChannelPeerRoleList = channelPeerRoleList.getToRemoveList();
		
		if(toRemoveChannelPeerRoleList == null){
			return peerRole;
		}
		if(toRemoveChannelPeerRoleList.isEmpty()){
			return peerRole;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getChannelPeerRoleDAO().removeChannelPeerRoleList(toRemoveChannelPeerRoleList,options);
		
		return peerRole;
	
	}
	
	

 	
 	
	
	
	
		

	public PeerRole present(PeerRole peerRole,Map<String, Object> options){
	
		presentChannelPeerRoleList(peerRole,options);

		return peerRole;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected PeerRole presentChannelPeerRoleList(
			PeerRole peerRole,
			Map<String, Object> options) {

		SmartList<ChannelPeerRole> channelPeerRoleList = peerRole.getChannelPeerRoleList();		
				SmartList<ChannelPeerRole> newList= presentSubList(peerRole.getId(),
				channelPeerRoleList,
				options,
				getChannelPeerRoleDAO()::countChannelPeerRoleByPeerRole,
				getChannelPeerRoleDAO()::findChannelPeerRoleByPeerRole
				);

		
		peerRole.setChannelPeerRoleList(newList);
		

		return peerRole;
	}			
		

	
    public SmartList<PeerRole> requestCandidatePeerRoleForChannelPeerRole(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PeerRoleTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPeerRoleMapper());
    }
		

	protected String getTableName(){
		return PeerRoleTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<PeerRole> peerRoleList) {		
		this.enhanceListInternal(peerRoleList, this.getPeerRoleMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:ChannelPeerRole的peerRole的ChannelPeerRoleList
	public SmartList<ChannelPeerRole> loadOurChannelPeerRoleList(HfgwUserContext userContext, List<PeerRole> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChannelPeerRole.PEER_ROLE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ChannelPeerRole> loadedObjs = userContext.getDAOGroup().getChannelPeerRoleDAO().findChannelPeerRoleWithKey(key, options);
		Map<String, List<ChannelPeerRole>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getPeerRole().getId()));
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
		List<PeerRole> peerRoleList = ownerEntity.collectRefsWithType(PeerRole.INTERNAL_TYPE);
		this.enhanceList(peerRoleList);
		
	}
	
	@Override
	public SmartList<PeerRole> findPeerRoleWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getPeerRoleMapper());

	}
	@Override
	public int countPeerRoleWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countPeerRoleWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<PeerRole> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getPeerRoleMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


