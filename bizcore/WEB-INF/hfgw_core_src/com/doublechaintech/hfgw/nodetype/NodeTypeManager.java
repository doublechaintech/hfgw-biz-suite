
package com.doublechaintech.hfgw.nodetype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.HfgwUserContext;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;

public interface NodeTypeManager{

		
	

	public NodeType loadNodeTypeWithCode(HfgwUserContext userContext, String code, Map<String,Object>tokens) throws Exception;

	 

	public NodeType createNodeType(HfgwUserContext userContext, String name,String code,String networkId) throws Exception;	
	public NodeType updateNodeType(HfgwUserContext userContext,String nodeTypeId, int nodeTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public NodeType loadNodeType(HfgwUserContext userContext, String nodeTypeId, String [] tokensExpr) throws Exception;
	public NodeType internalSaveNodeType(HfgwUserContext userContext, NodeType nodeType) throws Exception;
	public NodeType internalSaveNodeType(HfgwUserContext userContext, NodeType nodeType,Map<String,Object>option) throws Exception;
	
	public NodeType transferToAnotherNetwork(HfgwUserContext userContext, String nodeTypeId, String anotherNetworkId)  throws Exception;
 

	public void delete(HfgwUserContext userContext, String nodeTypeId, int version) throws Exception;
	public int deleteAll(HfgwUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HfgwUserContext userContext, NodeType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  NodeManager getNodeManager(HfgwUserContext userContext, String nodeTypeId, String name, String url, String organizationId, String channelId, String networkId, String tlsCacert, String address, String contactPerson, String contactTelephone ,String [] tokensExpr)  throws Exception;
	
	public  NodeType addNode(HfgwUserContext userContext, String nodeTypeId, String name, String url, String organizationId, String channelId, String networkId, String tlsCacert, String address, String contactPerson, String contactTelephone , String [] tokensExpr)  throws Exception;
	public  NodeType removeNode(HfgwUserContext userContext, String nodeTypeId, String nodeId, int nodeVersion,String [] tokensExpr)  throws Exception;
	public  NodeType updateNode(HfgwUserContext userContext, String nodeTypeId, String nodeId, int nodeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


