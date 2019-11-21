
package com.doublechaintech.hfgw.organization;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.HfgwUserContext;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;

public interface OrganizationManager{

		

	public Organization createOrganization(HfgwUserContext userContext, String name,String mspid,String networkId) throws Exception;	
	public Organization updateOrganization(HfgwUserContext userContext,String organizationId, int organizationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Organization loadOrganization(HfgwUserContext userContext, String organizationId, String [] tokensExpr) throws Exception;
	public Organization internalSaveOrganization(HfgwUserContext userContext, Organization organization) throws Exception;
	public Organization internalSaveOrganization(HfgwUserContext userContext, Organization organization,Map<String,Object>option) throws Exception;
	
	public Organization transferToAnotherNetwork(HfgwUserContext userContext, String organizationId, String anotherNetworkId)  throws Exception;
 

	public void delete(HfgwUserContext userContext, String organizationId, int version) throws Exception;
	public int deleteAll(HfgwUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HfgwUserContext userContext, Organization newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  NodeManager getNodeManager(HfgwUserContext userContext, String organizationId, String name, String url, String channelId, String typeId ,String [] tokensExpr)  throws Exception;
	
	public  Organization addNode(HfgwUserContext userContext, String organizationId, String name, String url, String channelId, String typeId , String [] tokensExpr)  throws Exception;
	public  Organization removeNode(HfgwUserContext userContext, String organizationId, String nodeId, int nodeVersion,String [] tokensExpr)  throws Exception;
	public  Organization updateNode(HfgwUserContext userContext, String organizationId, String nodeId, int nodeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


