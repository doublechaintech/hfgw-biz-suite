
package com.doublechaintech.hfgw.tlscacert;

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

import com.doublechaintech.hfgw.node.NodeDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class TlsCacertJDBCTemplateDAO extends HfgwBaseDAOImpl implements TlsCacertDAO{
 
 	
 	private  NodeDAO  nodeDAO;
 	public void setNodeDAO(NodeDAO nodeDAO){
	 	this.nodeDAO = nodeDAO;
 	}
 	public NodeDAO getNodeDAO(){
	 	return this.nodeDAO;
 	}


			
		

	
	/*
	protected TlsCacert load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTlsCacert(accessKey, options);
	}
	*/
	
	public SmartList<TlsCacert> loadAll() {
	    return this.loadAll(getTlsCacertMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public TlsCacert load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTlsCacert(TlsCacertTable.withId(id), options);
	}
	
	
	
	public TlsCacert save(TlsCacert tlsCacert,Map<String,Object> options){
		
		String methodName="save(TlsCacert tlsCacert,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(tlsCacert, methodName, "tlsCacert");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalTlsCacert(tlsCacert,options);
	}
	public TlsCacert clone(String tlsCacertId, Map<String,Object> options) throws Exception{
	
		return clone(TlsCacertTable.withId(tlsCacertId),options);
	}
	
	protected TlsCacert clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String tlsCacertId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		TlsCacert newTlsCacert = loadInternalTlsCacert(accessKey, options);
		newTlsCacert.setVersion(0);
		
		

		
		saveInternalTlsCacert(newTlsCacert,options);
		
		return newTlsCacert;
	}
	
	
	
	

	protected void throwIfHasException(String tlsCacertId,int version,int count) throws Exception{
		if (count == 1) {
			throw new TlsCacertVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TlsCacertNotFoundException(
					"The " + this.getTableName() + "(" + tlsCacertId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String tlsCacertId, int version) throws Exception{
	
		String methodName="delete(String tlsCacertId, int version)";
		assertMethodArgumentNotNull(tlsCacertId, methodName, "tlsCacertId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{tlsCacertId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(tlsCacertId,version);
		}
		
	
	}
	
	
	
	
	

	public TlsCacert disconnectFromAll(String tlsCacertId, int version) throws Exception{
	
		
		TlsCacert tlsCacert = loadInternalTlsCacert(TlsCacertTable.withId(tlsCacertId), emptyOptions());
		tlsCacert.clearFromAll();
		this.saveTlsCacert(tlsCacert);
		return tlsCacert;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return TlsCacertTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "tls_cacert";
	}
	@Override
	protected String getBeanName() {
		
		return "tlsCacert";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return TlsCacertTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractNodeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TlsCacertTokens.NODE);
 	}

 	protected boolean isSaveNodeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TlsCacertTokens.NODE);
 	}
 	

 	
 
		

	

	protected TlsCacertMapper getTlsCacertMapper(){
		return new TlsCacertMapper();
	}

	
	
	protected TlsCacert extractTlsCacert(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			TlsCacert tlsCacert = loadSingleObject(accessKey, getTlsCacertMapper());
			return tlsCacert;
		}catch(EmptyResultDataAccessException e){
			throw new TlsCacertNotFoundException("TlsCacert("+accessKey+") is not found!");
		}

	}

	
	

	protected TlsCacert loadInternalTlsCacert(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		TlsCacert tlsCacert = extractTlsCacert(accessKey, loadOptions);
 	
 		if(isExtractNodeEnabled(loadOptions)){
	 		extractNode(tlsCacert, loadOptions);
 		}
 
		
		return tlsCacert;
		
	}

	 

 	protected TlsCacert extractNode(TlsCacert tlsCacert, Map<String,Object> options) throws Exception{

		if(tlsCacert.getNode() == null){
			return tlsCacert;
		}
		String nodeId = tlsCacert.getNode().getId();
		if( nodeId == null){
			return tlsCacert;
		}
		Node node = getNodeDAO().load(nodeId,options);
		if(node != null){
			tlsCacert.setNode(node);
		}
		
 		
 		return tlsCacert;
 	}
 		
 
		
		
  	
 	public SmartList<TlsCacert> findTlsCacertByNode(String nodeId,Map<String,Object> options){
 	
  		SmartList<TlsCacert> resultList = queryWith(TlsCacertTable.COLUMN_NODE, nodeId, options, getTlsCacertMapper());
		// analyzeTlsCacertByNode(resultList, nodeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<TlsCacert> findTlsCacertByNode(String nodeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<TlsCacert> resultList =  queryWithRange(TlsCacertTable.COLUMN_NODE, nodeId, options, getTlsCacertMapper(), start, count);
 		//analyzeTlsCacertByNode(resultList, nodeId, options);
 		return resultList;
 		
 	}
 	public void analyzeTlsCacertByNode(SmartList<TlsCacert> resultList, String nodeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countTlsCacertByNode(String nodeId,Map<String,Object> options){

 		return countWith(TlsCacertTable.COLUMN_NODE, nodeId, options);
 	}
 	@Override
	public Map<String, Integer> countTlsCacertByNodeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TlsCacertTable.COLUMN_NODE, ids, options);
	}
 	
 	
		
		
		

	

	protected TlsCacert saveTlsCacert(TlsCacert  tlsCacert){
		
		if(!tlsCacert.isChanged()){
			return tlsCacert;
		}
		
		
		String SQL=this.getSaveTlsCacertSQL(tlsCacert);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTlsCacertParameters(tlsCacert);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		tlsCacert.incVersion();
		return tlsCacert;
	
	}
	public SmartList<TlsCacert> saveTlsCacertList(SmartList<TlsCacert> tlsCacertList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTlsCacertList(tlsCacertList);
		
		batchTlsCacertCreate((List<TlsCacert>)lists[CREATE_LIST_INDEX]);
		
		batchTlsCacertUpdate((List<TlsCacert>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(TlsCacert tlsCacert:tlsCacertList){
			if(tlsCacert.isChanged()){
				tlsCacert.incVersion();
			}
			
		
		}
		
		
		return tlsCacertList;
	}

	public SmartList<TlsCacert> removeTlsCacertList(SmartList<TlsCacert> tlsCacertList,Map<String,Object> options){
		
		
		super.removeList(tlsCacertList, options);
		
		return tlsCacertList;
		
		
	}
	
	protected List<Object[]> prepareTlsCacertBatchCreateArgs(List<TlsCacert> tlsCacertList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TlsCacert tlsCacert:tlsCacertList ){
			Object [] parameters = prepareTlsCacertCreateParameters(tlsCacert);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareTlsCacertBatchUpdateArgs(List<TlsCacert> tlsCacertList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TlsCacert tlsCacert:tlsCacertList ){
			if(!tlsCacert.isChanged()){
				continue;
			}
			Object [] parameters = prepareTlsCacertUpdateParameters(tlsCacert);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchTlsCacertCreate(List<TlsCacert> tlsCacertList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTlsCacertBatchCreateArgs(tlsCacertList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchTlsCacertUpdate(List<TlsCacert> tlsCacertList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTlsCacertBatchUpdateArgs(tlsCacertList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitTlsCacertList(List<TlsCacert> tlsCacertList){
		
		List<TlsCacert> tlsCacertCreateList=new ArrayList<TlsCacert>();
		List<TlsCacert> tlsCacertUpdateList=new ArrayList<TlsCacert>();
		
		for(TlsCacert tlsCacert: tlsCacertList){
			if(isUpdateRequest(tlsCacert)){
				tlsCacertUpdateList.add( tlsCacert);
				continue;
			}
			tlsCacertCreateList.add(tlsCacert);
		}
		
		return new Object[]{tlsCacertCreateList,tlsCacertUpdateList};
	}
	
	protected boolean isUpdateRequest(TlsCacert tlsCacert){
 		return tlsCacert.getVersion() > 0;
 	}
 	protected String getSaveTlsCacertSQL(TlsCacert tlsCacert){
 		if(isUpdateRequest(tlsCacert)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveTlsCacertParameters(TlsCacert tlsCacert){
 		if(isUpdateRequest(tlsCacert) ){
 			return prepareTlsCacertUpdateParameters(tlsCacert);
 		}
 		return prepareTlsCacertCreateParameters(tlsCacert);
 	}
 	protected Object[] prepareTlsCacertUpdateParameters(TlsCacert tlsCacert){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = tlsCacert.getPath();
 		parameters[1] = tlsCacert.getCert(); 	
 		if(tlsCacert.getNode() != null){
 			parameters[2] = tlsCacert.getNode().getId();
 		}
 		
 		parameters[3] = tlsCacert.nextVersion();
 		parameters[4] = tlsCacert.getId();
 		parameters[5] = tlsCacert.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareTlsCacertCreateParameters(TlsCacert tlsCacert){
		Object[] parameters = new Object[4];
		String newTlsCacertId=getNextId();
		tlsCacert.setId(newTlsCacertId);
		parameters[0] =  tlsCacert.getId();
 
 		parameters[1] = tlsCacert.getPath();
 		parameters[2] = tlsCacert.getCert(); 	
 		if(tlsCacert.getNode() != null){
 			parameters[3] = tlsCacert.getNode().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected TlsCacert saveInternalTlsCacert(TlsCacert tlsCacert, Map<String,Object> options){
		
		saveTlsCacert(tlsCacert);
 	
 		if(isSaveNodeEnabled(options)){
	 		saveNode(tlsCacert, options);
 		}
 
		
		return tlsCacert;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected TlsCacert saveNode(TlsCacert tlsCacert, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(tlsCacert.getNode() == null){
 			return tlsCacert;//do nothing when it is null
 		}
 		
 		getNodeDAO().save(tlsCacert.getNode(),options);
 		return tlsCacert;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public TlsCacert present(TlsCacert tlsCacert,Map<String, Object> options){
	

		return tlsCacert;
	
	}
		

	

	protected String getTableName(){
		return TlsCacertTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<TlsCacert> tlsCacertList) {		
		this.enhanceListInternal(tlsCacertList, this.getTlsCacertMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<TlsCacert> tlsCacertList = ownerEntity.collectRefsWithType(TlsCacert.INTERNAL_TYPE);
		this.enhanceList(tlsCacertList);
		
	}
	
	@Override
	public SmartList<TlsCacert> findTlsCacertWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getTlsCacertMapper());

	}
	@Override
	public int countTlsCacertWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countTlsCacertWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<TlsCacert> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getTlsCacertMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


