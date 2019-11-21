
package com.doublechaintech.hfgw.grpcoption;

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


public class GrpcOptionJDBCTemplateDAO extends HfgwBaseDAOImpl implements GrpcOptionDAO{
 
 	
 	private  NodeDAO  nodeDAO;
 	public void setNodeDAO(NodeDAO nodeDAO){
	 	this.nodeDAO = nodeDAO;
 	}
 	public NodeDAO getNodeDAO(){
	 	return this.nodeDAO;
 	}


			
		

	
	/*
	protected GrpcOption load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalGrpcOption(accessKey, options);
	}
	*/
	
	public SmartList<GrpcOption> loadAll() {
	    return this.loadAll(getGrpcOptionMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public GrpcOption load(String id,Map<String,Object> options) throws Exception{
		return loadInternalGrpcOption(GrpcOptionTable.withId(id), options);
	}
	
	
	
	public GrpcOption save(GrpcOption grpcOption,Map<String,Object> options){
		
		String methodName="save(GrpcOption grpcOption,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(grpcOption, methodName, "grpcOption");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalGrpcOption(grpcOption,options);
	}
	public GrpcOption clone(String grpcOptionId, Map<String,Object> options) throws Exception{
	
		return clone(GrpcOptionTable.withId(grpcOptionId),options);
	}
	
	protected GrpcOption clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String grpcOptionId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		GrpcOption newGrpcOption = loadInternalGrpcOption(accessKey, options);
		newGrpcOption.setVersion(0);
		
		

		
		saveInternalGrpcOption(newGrpcOption,options);
		
		return newGrpcOption;
	}
	
	
	
	

	protected void throwIfHasException(String grpcOptionId,int version,int count) throws Exception{
		if (count == 1) {
			throw new GrpcOptionVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new GrpcOptionNotFoundException(
					"The " + this.getTableName() + "(" + grpcOptionId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String grpcOptionId, int version) throws Exception{
	
		String methodName="delete(String grpcOptionId, int version)";
		assertMethodArgumentNotNull(grpcOptionId, methodName, "grpcOptionId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{grpcOptionId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(grpcOptionId,version);
		}
		
	
	}
	
	
	
	
	

	public GrpcOption disconnectFromAll(String grpcOptionId, int version) throws Exception{
	
		
		GrpcOption grpcOption = loadInternalGrpcOption(GrpcOptionTable.withId(grpcOptionId), emptyOptions());
		grpcOption.clearFromAll();
		this.saveGrpcOption(grpcOption);
		return grpcOption;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return GrpcOptionTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "grpc_option";
	}
	@Override
	protected String getBeanName() {
		
		return "grpcOption";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return GrpcOptionTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractNodeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, GrpcOptionTokens.NODE);
 	}

 	protected boolean isSaveNodeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, GrpcOptionTokens.NODE);
 	}
 	

 	
 
		

	

	protected GrpcOptionMapper getGrpcOptionMapper(){
		return new GrpcOptionMapper();
	}

	
	
	protected GrpcOption extractGrpcOption(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			GrpcOption grpcOption = loadSingleObject(accessKey, getGrpcOptionMapper());
			return grpcOption;
		}catch(EmptyResultDataAccessException e){
			throw new GrpcOptionNotFoundException("GrpcOption("+accessKey+") is not found!");
		}

	}

	
	

	protected GrpcOption loadInternalGrpcOption(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		GrpcOption grpcOption = extractGrpcOption(accessKey, loadOptions);
 	
 		if(isExtractNodeEnabled(loadOptions)){
	 		extractNode(grpcOption, loadOptions);
 		}
 
		
		return grpcOption;
		
	}

	 

 	protected GrpcOption extractNode(GrpcOption grpcOption, Map<String,Object> options) throws Exception{

		if(grpcOption.getNode() == null){
			return grpcOption;
		}
		String nodeId = grpcOption.getNode().getId();
		if( nodeId == null){
			return grpcOption;
		}
		Node node = getNodeDAO().load(nodeId,options);
		if(node != null){
			grpcOption.setNode(node);
		}
		
 		
 		return grpcOption;
 	}
 		
 
		
		
  	
 	public SmartList<GrpcOption> findGrpcOptionByNode(String nodeId,Map<String,Object> options){
 	
  		SmartList<GrpcOption> resultList = queryWith(GrpcOptionTable.COLUMN_NODE, nodeId, options, getGrpcOptionMapper());
		// analyzeGrpcOptionByNode(resultList, nodeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<GrpcOption> findGrpcOptionByNode(String nodeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<GrpcOption> resultList =  queryWithRange(GrpcOptionTable.COLUMN_NODE, nodeId, options, getGrpcOptionMapper(), start, count);
 		//analyzeGrpcOptionByNode(resultList, nodeId, options);
 		return resultList;
 		
 	}
 	public void analyzeGrpcOptionByNode(SmartList<GrpcOption> resultList, String nodeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countGrpcOptionByNode(String nodeId,Map<String,Object> options){

 		return countWith(GrpcOptionTable.COLUMN_NODE, nodeId, options);
 	}
 	@Override
	public Map<String, Integer> countGrpcOptionByNodeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(GrpcOptionTable.COLUMN_NODE, ids, options);
	}
 	
 	
		
		
		

	

	protected GrpcOption saveGrpcOption(GrpcOption  grpcOption){
		
		if(!grpcOption.isChanged()){
			return grpcOption;
		}
		
		
		String SQL=this.getSaveGrpcOptionSQL(grpcOption);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveGrpcOptionParameters(grpcOption);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		grpcOption.incVersion();
		return grpcOption;
	
	}
	public SmartList<GrpcOption> saveGrpcOptionList(SmartList<GrpcOption> grpcOptionList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitGrpcOptionList(grpcOptionList);
		
		batchGrpcOptionCreate((List<GrpcOption>)lists[CREATE_LIST_INDEX]);
		
		batchGrpcOptionUpdate((List<GrpcOption>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(GrpcOption grpcOption:grpcOptionList){
			if(grpcOption.isChanged()){
				grpcOption.incVersion();
			}
			
		
		}
		
		
		return grpcOptionList;
	}

	public SmartList<GrpcOption> removeGrpcOptionList(SmartList<GrpcOption> grpcOptionList,Map<String,Object> options){
		
		
		super.removeList(grpcOptionList, options);
		
		return grpcOptionList;
		
		
	}
	
	protected List<Object[]> prepareGrpcOptionBatchCreateArgs(List<GrpcOption> grpcOptionList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(GrpcOption grpcOption:grpcOptionList ){
			Object [] parameters = prepareGrpcOptionCreateParameters(grpcOption);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareGrpcOptionBatchUpdateArgs(List<GrpcOption> grpcOptionList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(GrpcOption grpcOption:grpcOptionList ){
			if(!grpcOption.isChanged()){
				continue;
			}
			Object [] parameters = prepareGrpcOptionUpdateParameters(grpcOption);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchGrpcOptionCreate(List<GrpcOption> grpcOptionList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareGrpcOptionBatchCreateArgs(grpcOptionList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchGrpcOptionUpdate(List<GrpcOption> grpcOptionList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareGrpcOptionBatchUpdateArgs(grpcOptionList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitGrpcOptionList(List<GrpcOption> grpcOptionList){
		
		List<GrpcOption> grpcOptionCreateList=new ArrayList<GrpcOption>();
		List<GrpcOption> grpcOptionUpdateList=new ArrayList<GrpcOption>();
		
		for(GrpcOption grpcOption: grpcOptionList){
			if(isUpdateRequest(grpcOption)){
				grpcOptionUpdateList.add( grpcOption);
				continue;
			}
			grpcOptionCreateList.add(grpcOption);
		}
		
		return new Object[]{grpcOptionCreateList,grpcOptionUpdateList};
	}
	
	protected boolean isUpdateRequest(GrpcOption grpcOption){
 		return grpcOption.getVersion() > 0;
 	}
 	protected String getSaveGrpcOptionSQL(GrpcOption grpcOption){
 		if(isUpdateRequest(grpcOption)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveGrpcOptionParameters(GrpcOption grpcOption){
 		if(isUpdateRequest(grpcOption) ){
 			return prepareGrpcOptionUpdateParameters(grpcOption);
 		}
 		return prepareGrpcOptionCreateParameters(grpcOption);
 	}
 	protected Object[] prepareGrpcOptionUpdateParameters(GrpcOption grpcOption){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = grpcOption.getParameterName();
 		parameters[1] = grpcOption.getParameterValue(); 	
 		if(grpcOption.getNode() != null){
 			parameters[2] = grpcOption.getNode().getId();
 		}
 		
 		parameters[3] = grpcOption.nextVersion();
 		parameters[4] = grpcOption.getId();
 		parameters[5] = grpcOption.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareGrpcOptionCreateParameters(GrpcOption grpcOption){
		Object[] parameters = new Object[4];
		String newGrpcOptionId=getNextId();
		grpcOption.setId(newGrpcOptionId);
		parameters[0] =  grpcOption.getId();
 
 		parameters[1] = grpcOption.getParameterName();
 		parameters[2] = grpcOption.getParameterValue(); 	
 		if(grpcOption.getNode() != null){
 			parameters[3] = grpcOption.getNode().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected GrpcOption saveInternalGrpcOption(GrpcOption grpcOption, Map<String,Object> options){
		
		saveGrpcOption(grpcOption);
 	
 		if(isSaveNodeEnabled(options)){
	 		saveNode(grpcOption, options);
 		}
 
		
		return grpcOption;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected GrpcOption saveNode(GrpcOption grpcOption, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(grpcOption.getNode() == null){
 			return grpcOption;//do nothing when it is null
 		}
 		
 		getNodeDAO().save(grpcOption.getNode(),options);
 		return grpcOption;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public GrpcOption present(GrpcOption grpcOption,Map<String, Object> options){
	

		return grpcOption;
	
	}
		

	

	protected String getTableName(){
		return GrpcOptionTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<GrpcOption> grpcOptionList) {		
		this.enhanceListInternal(grpcOptionList, this.getGrpcOptionMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<GrpcOption> grpcOptionList = ownerEntity.collectRefsWithType(GrpcOption.INTERNAL_TYPE);
		this.enhanceList(grpcOptionList);
		
	}
	
	@Override
	public SmartList<GrpcOption> findGrpcOptionWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getGrpcOptionMapper());

	}
	@Override
	public int countGrpcOptionWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countGrpcOptionWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<GrpcOption> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getGrpcOptionMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


