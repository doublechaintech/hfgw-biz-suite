
package com.doublechaintech.hfgw.peerrole;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;
import com.doublechaintech.hfgw.MultipleAccessKey;
import com.doublechaintech.hfgw.HfgwUserContext;

import com.doublechaintech.hfgw.channelpeerrole.ChannelPeerRole;

import com.doublechaintech.hfgw.channelpeerrole.ChannelPeerRoleDAO;


public interface PeerRoleDAO{

	public SmartList<PeerRole> loadAll();
	public PeerRole load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<PeerRole> peerRoleList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public PeerRole loadByCode(String code,Map<String,Object> options) throws Exception;
	
	
	public PeerRole present(PeerRole peerRole,Map<String,Object> options) throws Exception;
	public PeerRole clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public PeerRole cloneByCode(String code,Map<String,Object> options) throws Exception;
	
	
	public PeerRole save(PeerRole peerRole,Map<String,Object> options);
	public SmartList<PeerRole> savePeerRoleList(SmartList<PeerRole> peerRoleList,Map<String,Object> options);
	public SmartList<PeerRole> removePeerRoleList(SmartList<PeerRole> peerRoleList,Map<String,Object> options);
	public SmartList<PeerRole> findPeerRoleWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPeerRoleWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPeerRoleWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String peerRoleId, int version) throws Exception;
	public PeerRole disconnectFromAll(String peerRoleId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ChannelPeerRoleDAO getChannelPeerRoleDAO();
		
	
 	public SmartList<PeerRole> requestCandidatePeerRoleForChannelPeerRole(HfgwUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public PeerRole planToRemoveChannelPeerRoleList(PeerRole peerRole, String channelPeerRoleIds[], Map<String,Object> options)throws Exception;


	//disconnect PeerRole with channel in ChannelPeerRole
	public PeerRole planToRemoveChannelPeerRoleListWithChannel(PeerRole peerRole, String channelId, Map<String,Object> options)throws Exception;
	public int countChannelPeerRoleListWithChannel(String peerRoleId, String channelId, Map<String,Object> options)throws Exception;
	
	//disconnect PeerRole with node in ChannelPeerRole
	public PeerRole planToRemoveChannelPeerRoleListWithNode(PeerRole peerRole, String nodeId, Map<String,Object> options)throws Exception;
	public int countChannelPeerRoleListWithNode(String peerRoleId, String nodeId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<PeerRole> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);

	// 需要一个加载引用我的对象的enhance方法:ChannelPeerRole的peerRole的ChannelPeerRoleList
	public SmartList<ChannelPeerRole> loadOurChannelPeerRoleList(HfgwUserContext userContext, List<PeerRole> us, Map<String,Object> options) throws Exception;
	
}


