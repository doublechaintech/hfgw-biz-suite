
package com.doublechaintech.hfgw.channelpeerrole;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.hfgw.BaseDAO;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;
import com.doublechaintech.hfgw.MultipleAccessKey;
import com.doublechaintech.hfgw.HfgwUserContext;

import com.doublechaintech.hfgw.peerrole.PeerRole;
import com.doublechaintech.hfgw.node.Node;
import com.doublechaintech.hfgw.channel.Channel;

import com.doublechaintech.hfgw.node.NodeDAO;
import com.doublechaintech.hfgw.peerrole.PeerRoleDAO;
import com.doublechaintech.hfgw.channel.ChannelDAO;


public interface ChannelPeerRoleDAO extends BaseDAO{

	public SmartList<ChannelPeerRole> loadAll();
	public ChannelPeerRole load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ChannelPeerRole> channelPeerRoleList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ChannelPeerRole present(ChannelPeerRole channelPeerRole,Map<String,Object> options) throws Exception;
	public ChannelPeerRole clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ChannelPeerRole save(ChannelPeerRole channelPeerRole,Map<String,Object> options);
	public SmartList<ChannelPeerRole> saveChannelPeerRoleList(SmartList<ChannelPeerRole> channelPeerRoleList,Map<String,Object> options);
	public SmartList<ChannelPeerRole> removeChannelPeerRoleList(SmartList<ChannelPeerRole> channelPeerRoleList,Map<String,Object> options);
	public SmartList<ChannelPeerRole> findChannelPeerRoleWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countChannelPeerRoleWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countChannelPeerRoleWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String channelPeerRoleId, int version) throws Exception;
	public ChannelPeerRole disconnectFromAll(String channelPeerRoleId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<ChannelPeerRole> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<ChannelPeerRole> findChannelPeerRoleByChannel(String channelId, Map<String,Object> options);
 	public int countChannelPeerRoleByChannel(String channelId, Map<String,Object> options);
 	public Map<String, Integer> countChannelPeerRoleByChannelIds(String[] ids, Map<String,Object> options);
 	public SmartList<ChannelPeerRole> findChannelPeerRoleByChannel(String channelId, int start, int count, Map<String,Object> options);
 	public void analyzeChannelPeerRoleByChannel(SmartList<ChannelPeerRole> resultList, String channelId, Map<String,Object> options);

 
  
 	public SmartList<ChannelPeerRole> findChannelPeerRoleByNode(String nodeId, Map<String,Object> options);
 	public int countChannelPeerRoleByNode(String nodeId, Map<String,Object> options);
 	public Map<String, Integer> countChannelPeerRoleByNodeIds(String[] ids, Map<String,Object> options);
 	public SmartList<ChannelPeerRole> findChannelPeerRoleByNode(String nodeId, int start, int count, Map<String,Object> options);
 	public void analyzeChannelPeerRoleByNode(SmartList<ChannelPeerRole> resultList, String nodeId, Map<String,Object> options);

 
  
 	public SmartList<ChannelPeerRole> findChannelPeerRoleByPeerRole(String peerRoleId, Map<String,Object> options);
 	public int countChannelPeerRoleByPeerRole(String peerRoleId, Map<String,Object> options);
 	public Map<String, Integer> countChannelPeerRoleByPeerRoleIds(String[] ids, Map<String,Object> options);
 	public SmartList<ChannelPeerRole> findChannelPeerRoleByPeerRole(String peerRoleId, int start, int count, Map<String,Object> options);
 	public void analyzeChannelPeerRoleByPeerRole(SmartList<ChannelPeerRole> resultList, String peerRoleId, Map<String,Object> options);

 
 
}


