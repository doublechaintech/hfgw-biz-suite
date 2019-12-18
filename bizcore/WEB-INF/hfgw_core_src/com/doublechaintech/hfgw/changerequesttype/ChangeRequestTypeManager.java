
package com.doublechaintech.hfgw.changerequesttype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.HfgwUserContext;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.BaseManager;
import com.doublechaintech.hfgw.SmartList;

public interface ChangeRequestTypeManager extends BaseManager{

		
	

	public ChangeRequestType loadChangeRequestTypeWithCode(HfgwUserContext userContext, String code, Map<String,Object>tokens) throws Exception;

	 

	public ChangeRequestType createChangeRequestType(HfgwUserContext userContext, String name,String code,String icon,int displayOrder,String bindTypes,String stepConfiguration,String networkId) throws Exception;	
	public ChangeRequestType updateChangeRequestType(HfgwUserContext userContext,String changeRequestTypeId, int changeRequestTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ChangeRequestType loadChangeRequestType(HfgwUserContext userContext, String changeRequestTypeId, String [] tokensExpr) throws Exception;
	public ChangeRequestType internalSaveChangeRequestType(HfgwUserContext userContext, ChangeRequestType changeRequestType) throws Exception;
	public ChangeRequestType internalSaveChangeRequestType(HfgwUserContext userContext, ChangeRequestType changeRequestType,Map<String,Object>option) throws Exception;
	
	public ChangeRequestType transferToAnotherNetwork(HfgwUserContext userContext, String changeRequestTypeId, String anotherNetworkId)  throws Exception;
 

	public void delete(HfgwUserContext userContext, String changeRequestTypeId, int version) throws Exception;
	public int deleteAll(HfgwUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HfgwUserContext userContext, ChangeRequestType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ChangeRequestManager getChangeRequestManager(HfgwUserContext userContext, String changeRequestTypeId, String name, String networkId ,String [] tokensExpr)  throws Exception;
	
	public  ChangeRequestType addChangeRequest(HfgwUserContext userContext, String changeRequestTypeId, String name, String networkId , String [] tokensExpr)  throws Exception;
	public  ChangeRequestType removeChangeRequest(HfgwUserContext userContext, String changeRequestTypeId, String changeRequestId, int changeRequestVersion,String [] tokensExpr)  throws Exception;
	public  ChangeRequestType updateChangeRequest(HfgwUserContext userContext, String changeRequestTypeId, String changeRequestId, int changeRequestVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


