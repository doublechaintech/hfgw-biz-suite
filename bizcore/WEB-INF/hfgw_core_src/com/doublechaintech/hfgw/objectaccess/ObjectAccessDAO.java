
package com.doublechaintech.hfgw.objectaccess;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;
import com.doublechaintech.hfgw.MultipleAccessKey;
import com.doublechaintech.hfgw.HfgwUserContext;

import com.doublechaintech.hfgw.userapp.UserApp;

import com.doublechaintech.hfgw.userapp.UserAppDAO;


public interface ObjectAccessDAO{

	public SmartList<ObjectAccess> loadAll();
	public ObjectAccess load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ObjectAccess> objectAccessList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ObjectAccess present(ObjectAccess objectAccess,Map<String,Object> options) throws Exception;
	public ObjectAccess clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ObjectAccess save(ObjectAccess objectAccess,Map<String,Object> options);
	public SmartList<ObjectAccess> saveObjectAccessList(SmartList<ObjectAccess> objectAccessList,Map<String,Object> options);
	public SmartList<ObjectAccess> removeObjectAccessList(SmartList<ObjectAccess> objectAccessList,Map<String,Object> options);
	public SmartList<ObjectAccess> findObjectAccessWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countObjectAccessWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countObjectAccessWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String objectAccessId, int version) throws Exception;
	public ObjectAccess disconnectFromAll(String objectAccessId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<ObjectAccess> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<ObjectAccess> findObjectAccessByApp(String userAppId, Map<String,Object> options);
 	public int countObjectAccessByApp(String userAppId, Map<String,Object> options);
 	public Map<String, Integer> countObjectAccessByAppIds(String[] ids, Map<String,Object> options);
 	public SmartList<ObjectAccess> findObjectAccessByApp(String userAppId, int start, int count, Map<String,Object> options);
 	public void analyzeObjectAccessByApp(SmartList<ObjectAccess> resultList, String userAppId, Map<String,Object> options);

 
 
}


