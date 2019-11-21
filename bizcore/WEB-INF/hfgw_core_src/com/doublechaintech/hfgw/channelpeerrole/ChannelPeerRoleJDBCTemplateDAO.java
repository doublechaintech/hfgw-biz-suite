
package com.doublechaintech.hfgw.channelpeerrole;

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


import com.doublechaintech.hfgw.peerrole.PeerRole;
import com.doublechaintech.hfgw.node.Node;
import com.doublechaintech.hfgw.channel.Channel;

import com.doublechaintech.hfgw.node.NodeDAO;
import com.doublechaintech.hfgw.peerrole.PeerRoleDAO;
import com.doublechaintech.hfgw.channel.ChannelDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class ChannelPeerRoleJDBCTemplateDAO extends HfgwBaseDAOImpl implements ChannelPeerRoleDAO{
 
 	
 	private  ChannelDAO  channelDAO;
 	public void setChannelDAO(ChannelDAO channelDAO){
	 	this.channelDAO = channelDAO;
 	}
 	public ChannelDAO getChannelDAO(){
	 	return this.channelDAO;
 	}
 
 	
 	private  NodeDAO  nodeDAO;
 	public void setNodeDAO(NodeDAO nodeDAO){
	 	this.nodeDAO = nodeDAO;
 	}
 	public NodeDAO getNodeDAO(){
	 	return this.nodeDAO;
 	}
 
 	
 	private  PeerRoleDAO  peerRoleDAO;
 	public void setPeerRoleDAO(PeerRoleDAO peerRoleDAO){
	 	this.peerRoleDAO = peerRoleDAO;
 	}
 	public PeerRoleDAO getPeerRoleDAO(){
	 	return this.peerRoleDAO;
 	}


			
		

	
	/*
	protected ChannelPeerRole load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalChannelPeerRole(accessKey, options);
	}
	*/
	
	public SmartList<ChannelPeerRole> loadAll() {
	    return this.loadAll(getChannelPeerRoleMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public ChannelPeerRole load(String id,Map<String,Object> options) throws Exception{
		return loadInternalChannelPeerRole(ChannelPeerRoleTable.withId(id), options);
	}
	
	
	
	public ChannelPeerRole save(ChannelPeerRole channelPeerRole,Map<String,Object> options){
		
		String methodName="save(ChannelPeerRole channelPeerRole,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(channelPeerRole, methodName, "channelPeerRole");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalChannelPeerRole(channelPeerRole,options);
	}
	public ChannelPeerRole clone(String channelPeerRoleId, Map<String,Object> options) throws Exception{
	
		return clone(ChannelPeerRoleTable.withId(channelPeerRoleId),options);
	}
	
	protected ChannelPeerRole clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String channelPeerRoleId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ChannelPeerRole newChannelPeerRole = loadInternalChannelPeerRole(accessKey, options);
		newChannelPeerRole.setVersion(0);
		
		

		
		saveInternalChannelPeerRole(newChannelPeerRole,options);
		
		return newChannelPeerRole;
	}
	
	
	
	

	protected void throwIfHasException(String channelPeerRoleId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ChannelPeerRoleVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ChannelPeerRoleNotFoundException(
					"The " + this.getTableName() + "(" + channelPeerRoleId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String channelPeerRoleId, int version) throws Exception{
	
		String methodName="delete(String channelPeerRoleId, int version)";
		assertMethodArgumentNotNull(channelPeerRoleId, methodName, "channelPeerRoleId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{channelPeerRoleId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(channelPeerRoleId,version);
		}
		
	
	}
	
	
	
	
	

	public ChannelPeerRole disconnectFromAll(String channelPeerRoleId, int version) throws Exception{
	
		
		ChannelPeerRole channelPeerRole = loadInternalChannelPeerRole(ChannelPeerRoleTable.withId(channelPeerRoleId), emptyOptions());
		channelPeerRole.clearFromAll();
		this.saveChannelPeerRole(channelPeerRole);
		return channelPeerRole;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ChannelPeerRoleTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "channel_peer_role";
	}
	@Override
	protected String getBeanName() {
		
		return "channelPeerRole";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ChannelPeerRoleTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractChannelEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ChannelPeerRoleTokens.CHANNEL);
 	}

 	protected boolean isSaveChannelEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ChannelPeerRoleTokens.CHANNEL);
 	}
 	

 	
  

 	protected boolean isExtractNodeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ChannelPeerRoleTokens.NODE);
 	}

 	protected boolean isSaveNodeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ChannelPeerRoleTokens.NODE);
 	}
 	

 	
  

 	protected boolean isExtractPeerRoleEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ChannelPeerRoleTokens.PEERROLE);
 	}

 	protected boolean isSavePeerRoleEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ChannelPeerRoleTokens.PEERROLE);
 	}
 	

 	
 
		

	

	protected ChannelPeerRoleMapper getChannelPeerRoleMapper(){
		return new ChannelPeerRoleMapper();
	}

	
	
	protected ChannelPeerRole extractChannelPeerRole(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ChannelPeerRole channelPeerRole = loadSingleObject(accessKey, getChannelPeerRoleMapper());
			return channelPeerRole;
		}catch(EmptyResultDataAccessException e){
			throw new ChannelPeerRoleNotFoundException("ChannelPeerRole("+accessKey+") is not found!");
		}

	}

	
	

	protected ChannelPeerRole loadInternalChannelPeerRole(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ChannelPeerRole channelPeerRole = extractChannelPeerRole(accessKey, loadOptions);
 	
 		if(isExtractChannelEnabled(loadOptions)){
	 		extractChannel(channelPeerRole, loadOptions);
 		}
  	
 		if(isExtractNodeEnabled(loadOptions)){
	 		extractNode(channelPeerRole, loadOptions);
 		}
  	
 		if(isExtractPeerRoleEnabled(loadOptions)){
	 		extractPeerRole(channelPeerRole, loadOptions);
 		}
 
		
		return channelPeerRole;
		
	}

	 

 	protected ChannelPeerRole extractChannel(ChannelPeerRole channelPeerRole, Map<String,Object> options) throws Exception{

		if(channelPeerRole.getChannel() == null){
			return channelPeerRole;
		}
		String channelId = channelPeerRole.getChannel().getId();
		if( channelId == null){
			return channelPeerRole;
		}
		Channel channel = getChannelDAO().load(channelId,options);
		if(channel != null){
			channelPeerRole.setChannel(channel);
		}
		
 		
 		return channelPeerRole;
 	}
 		
  

 	protected ChannelPeerRole extractNode(ChannelPeerRole channelPeerRole, Map<String,Object> options) throws Exception{

		if(channelPeerRole.getNode() == null){
			return channelPeerRole;
		}
		String nodeId = channelPeerRole.getNode().getId();
		if( nodeId == null){
			return channelPeerRole;
		}
		Node node = getNodeDAO().load(nodeId,options);
		if(node != null){
			channelPeerRole.setNode(node);
		}
		
 		
 		return channelPeerRole;
 	}
 		
  

 	protected ChannelPeerRole extractPeerRole(ChannelPeerRole channelPeerRole, Map<String,Object> options) throws Exception{

		if(channelPeerRole.getPeerRole() == null){
			return channelPeerRole;
		}
		String peerRoleId = channelPeerRole.getPeerRole().getId();
		if( peerRoleId == null){
			return channelPeerRole;
		}
		PeerRole peerRole = getPeerRoleDAO().load(peerRoleId,options);
		if(peerRole != null){
			channelPeerRole.setPeerRole(peerRole);
		}
		
 		
 		return channelPeerRole;
 	}
 		
 
		
		
  	
 	public SmartList<ChannelPeerRole> findChannelPeerRoleByChannel(String channelId,Map<String,Object> options){
 	
  		SmartList<ChannelPeerRole> resultList = queryWith(ChannelPeerRoleTable.COLUMN_CHANNEL, channelId, options, getChannelPeerRoleMapper());
		// analyzeChannelPeerRoleByChannel(resultList, channelId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ChannelPeerRole> findChannelPeerRoleByChannel(String channelId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ChannelPeerRole> resultList =  queryWithRange(ChannelPeerRoleTable.COLUMN_CHANNEL, channelId, options, getChannelPeerRoleMapper(), start, count);
 		//analyzeChannelPeerRoleByChannel(resultList, channelId, options);
 		return resultList;
 		
 	}
 	public void analyzeChannelPeerRoleByChannel(SmartList<ChannelPeerRole> resultList, String channelId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ChannelPeerRole.CHANNEL_PROPERTY, channelId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countChannelPeerRoleByChannel(String channelId,Map<String,Object> options){

 		return countWith(ChannelPeerRoleTable.COLUMN_CHANNEL, channelId, options);
 	}
 	@Override
	public Map<String, Integer> countChannelPeerRoleByChannelIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ChannelPeerRoleTable.COLUMN_CHANNEL, ids, options);
	}
 	
  	
 	public SmartList<ChannelPeerRole> findChannelPeerRoleByNode(String nodeId,Map<String,Object> options){
 	
  		SmartList<ChannelPeerRole> resultList = queryWith(ChannelPeerRoleTable.COLUMN_NODE, nodeId, options, getChannelPeerRoleMapper());
		// analyzeChannelPeerRoleByNode(resultList, nodeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ChannelPeerRole> findChannelPeerRoleByNode(String nodeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ChannelPeerRole> resultList =  queryWithRange(ChannelPeerRoleTable.COLUMN_NODE, nodeId, options, getChannelPeerRoleMapper(), start, count);
 		//analyzeChannelPeerRoleByNode(resultList, nodeId, options);
 		return resultList;
 		
 	}
 	public void analyzeChannelPeerRoleByNode(SmartList<ChannelPeerRole> resultList, String nodeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ChannelPeerRole.NODE_PROPERTY, nodeId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countChannelPeerRoleByNode(String nodeId,Map<String,Object> options){

 		return countWith(ChannelPeerRoleTable.COLUMN_NODE, nodeId, options);
 	}
 	@Override
	public Map<String, Integer> countChannelPeerRoleByNodeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ChannelPeerRoleTable.COLUMN_NODE, ids, options);
	}
 	
  	
 	public SmartList<ChannelPeerRole> findChannelPeerRoleByPeerRole(String peerRoleId,Map<String,Object> options){
 	
  		SmartList<ChannelPeerRole> resultList = queryWith(ChannelPeerRoleTable.COLUMN_PEER_ROLE, peerRoleId, options, getChannelPeerRoleMapper());
		// analyzeChannelPeerRoleByPeerRole(resultList, peerRoleId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ChannelPeerRole> findChannelPeerRoleByPeerRole(String peerRoleId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ChannelPeerRole> resultList =  queryWithRange(ChannelPeerRoleTable.COLUMN_PEER_ROLE, peerRoleId, options, getChannelPeerRoleMapper(), start, count);
 		//analyzeChannelPeerRoleByPeerRole(resultList, peerRoleId, options);
 		return resultList;
 		
 	}
 	public void analyzeChannelPeerRoleByPeerRole(SmartList<ChannelPeerRole> resultList, String peerRoleId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ChannelPeerRole.PEER_ROLE_PROPERTY, peerRoleId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countChannelPeerRoleByPeerRole(String peerRoleId,Map<String,Object> options){

 		return countWith(ChannelPeerRoleTable.COLUMN_PEER_ROLE, peerRoleId, options);
 	}
 	@Override
	public Map<String, Integer> countChannelPeerRoleByPeerRoleIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ChannelPeerRoleTable.COLUMN_PEER_ROLE, ids, options);
	}
 	
 	
		
		
		

	

	protected ChannelPeerRole saveChannelPeerRole(ChannelPeerRole  channelPeerRole){
		
		if(!channelPeerRole.isChanged()){
			return channelPeerRole;
		}
		
		
		String SQL=this.getSaveChannelPeerRoleSQL(channelPeerRole);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveChannelPeerRoleParameters(channelPeerRole);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		channelPeerRole.incVersion();
		return channelPeerRole;
	
	}
	public SmartList<ChannelPeerRole> saveChannelPeerRoleList(SmartList<ChannelPeerRole> channelPeerRoleList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitChannelPeerRoleList(channelPeerRoleList);
		
		batchChannelPeerRoleCreate((List<ChannelPeerRole>)lists[CREATE_LIST_INDEX]);
		
		batchChannelPeerRoleUpdate((List<ChannelPeerRole>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ChannelPeerRole channelPeerRole:channelPeerRoleList){
			if(channelPeerRole.isChanged()){
				channelPeerRole.incVersion();
			}
			
		
		}
		
		
		return channelPeerRoleList;
	}

	public SmartList<ChannelPeerRole> removeChannelPeerRoleList(SmartList<ChannelPeerRole> channelPeerRoleList,Map<String,Object> options){
		
		
		super.removeList(channelPeerRoleList, options);
		
		return channelPeerRoleList;
		
		
	}
	
	protected List<Object[]> prepareChannelPeerRoleBatchCreateArgs(List<ChannelPeerRole> channelPeerRoleList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ChannelPeerRole channelPeerRole:channelPeerRoleList ){
			Object [] parameters = prepareChannelPeerRoleCreateParameters(channelPeerRole);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareChannelPeerRoleBatchUpdateArgs(List<ChannelPeerRole> channelPeerRoleList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ChannelPeerRole channelPeerRole:channelPeerRoleList ){
			if(!channelPeerRole.isChanged()){
				continue;
			}
			Object [] parameters = prepareChannelPeerRoleUpdateParameters(channelPeerRole);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchChannelPeerRoleCreate(List<ChannelPeerRole> channelPeerRoleList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareChannelPeerRoleBatchCreateArgs(channelPeerRoleList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchChannelPeerRoleUpdate(List<ChannelPeerRole> channelPeerRoleList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareChannelPeerRoleBatchUpdateArgs(channelPeerRoleList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitChannelPeerRoleList(List<ChannelPeerRole> channelPeerRoleList){
		
		List<ChannelPeerRole> channelPeerRoleCreateList=new ArrayList<ChannelPeerRole>();
		List<ChannelPeerRole> channelPeerRoleUpdateList=new ArrayList<ChannelPeerRole>();
		
		for(ChannelPeerRole channelPeerRole: channelPeerRoleList){
			if(isUpdateRequest(channelPeerRole)){
				channelPeerRoleUpdateList.add( channelPeerRole);
				continue;
			}
			channelPeerRoleCreateList.add(channelPeerRole);
		}
		
		return new Object[]{channelPeerRoleCreateList,channelPeerRoleUpdateList};
	}
	
	protected boolean isUpdateRequest(ChannelPeerRole channelPeerRole){
 		return channelPeerRole.getVersion() > 0;
 	}
 	protected String getSaveChannelPeerRoleSQL(ChannelPeerRole channelPeerRole){
 		if(isUpdateRequest(channelPeerRole)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveChannelPeerRoleParameters(ChannelPeerRole channelPeerRole){
 		if(isUpdateRequest(channelPeerRole) ){
 			return prepareChannelPeerRoleUpdateParameters(channelPeerRole);
 		}
 		return prepareChannelPeerRoleCreateParameters(channelPeerRole);
 	}
 	protected Object[] prepareChannelPeerRoleUpdateParameters(ChannelPeerRole channelPeerRole){
 		Object[] parameters = new Object[6];
  	
 		if(channelPeerRole.getChannel() != null){
 			parameters[0] = channelPeerRole.getChannel().getId();
 		}
  	
 		if(channelPeerRole.getNode() != null){
 			parameters[1] = channelPeerRole.getNode().getId();
 		}
  	
 		if(channelPeerRole.getPeerRole() != null){
 			parameters[2] = channelPeerRole.getPeerRole().getId();
 		}
 		
 		parameters[3] = channelPeerRole.nextVersion();
 		parameters[4] = channelPeerRole.getId();
 		parameters[5] = channelPeerRole.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareChannelPeerRoleCreateParameters(ChannelPeerRole channelPeerRole){
		Object[] parameters = new Object[4];
		String newChannelPeerRoleId=getNextId();
		channelPeerRole.setId(newChannelPeerRoleId);
		parameters[0] =  channelPeerRole.getId();
  	
 		if(channelPeerRole.getChannel() != null){
 			parameters[1] = channelPeerRole.getChannel().getId();
 		
 		}
 		 	
 		if(channelPeerRole.getNode() != null){
 			parameters[2] = channelPeerRole.getNode().getId();
 		
 		}
 		 	
 		if(channelPeerRole.getPeerRole() != null){
 			parameters[3] = channelPeerRole.getPeerRole().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected ChannelPeerRole saveInternalChannelPeerRole(ChannelPeerRole channelPeerRole, Map<String,Object> options){
		
		saveChannelPeerRole(channelPeerRole);
 	
 		if(isSaveChannelEnabled(options)){
	 		saveChannel(channelPeerRole, options);
 		}
  	
 		if(isSaveNodeEnabled(options)){
	 		saveNode(channelPeerRole, options);
 		}
  	
 		if(isSavePeerRoleEnabled(options)){
	 		savePeerRole(channelPeerRole, options);
 		}
 
		
		return channelPeerRole;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ChannelPeerRole saveChannel(ChannelPeerRole channelPeerRole, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(channelPeerRole.getChannel() == null){
 			return channelPeerRole;//do nothing when it is null
 		}
 		
 		getChannelDAO().save(channelPeerRole.getChannel(),options);
 		return channelPeerRole;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected ChannelPeerRole saveNode(ChannelPeerRole channelPeerRole, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(channelPeerRole.getNode() == null){
 			return channelPeerRole;//do nothing when it is null
 		}
 		
 		getNodeDAO().save(channelPeerRole.getNode(),options);
 		return channelPeerRole;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected ChannelPeerRole savePeerRole(ChannelPeerRole channelPeerRole, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(channelPeerRole.getPeerRole() == null){
 			return channelPeerRole;//do nothing when it is null
 		}
 		
 		getPeerRoleDAO().save(channelPeerRole.getPeerRole(),options);
 		return channelPeerRole;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public ChannelPeerRole present(ChannelPeerRole channelPeerRole,Map<String, Object> options){
	

		return channelPeerRole;
	
	}
		

	

	protected String getTableName(){
		return ChannelPeerRoleTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<ChannelPeerRole> channelPeerRoleList) {		
		this.enhanceListInternal(channelPeerRoleList, this.getChannelPeerRoleMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<ChannelPeerRole> channelPeerRoleList = ownerEntity.collectRefsWithType(ChannelPeerRole.INTERNAL_TYPE);
		this.enhanceList(channelPeerRoleList);
		
	}
	
	@Override
	public SmartList<ChannelPeerRole> findChannelPeerRoleWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getChannelPeerRoleMapper());

	}
	@Override
	public int countChannelPeerRoleWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countChannelPeerRoleWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<ChannelPeerRole> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getChannelPeerRoleMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


