
package com.doublechaintech.hfgw.changerequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.HfgwUserContext;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;

public interface ChangeRequestManager{

		

	public ChangeRequest createChangeRequest(HfgwUserContext userContext, String name,String requestTypeId,String networkId) throws Exception;	
	public ChangeRequest updateChangeRequest(HfgwUserContext userContext,String changeRequestId, int changeRequestVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ChangeRequest loadChangeRequest(HfgwUserContext userContext, String changeRequestId, String [] tokensExpr) throws Exception;
	public ChangeRequest internalSaveChangeRequest(HfgwUserContext userContext, ChangeRequest changeRequest) throws Exception;
	public ChangeRequest internalSaveChangeRequest(HfgwUserContext userContext, ChangeRequest changeRequest,Map<String,Object>option) throws Exception;
	
	public ChangeRequest transferToAnotherRequestType(HfgwUserContext userContext, String changeRequestId, String anotherRequestTypeId)  throws Exception;
 	public ChangeRequest transferToAnotherNetwork(HfgwUserContext userContext, String changeRequestId, String anotherNetworkId)  throws Exception;
 

	public void delete(HfgwUserContext userContext, String changeRequestId, int version) throws Exception;
	public int deleteAll(HfgwUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HfgwUserContext userContext, ChangeRequest newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


