
package com.doublechaintech.hfgw.chaincodeinvoker;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.HfgwUserContext;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.BaseManager;
import com.doublechaintech.hfgw.SmartList;

public interface ChainCodeInvokerManager extends BaseManager{

		

	public ChainCodeInvoker createChainCodeInvoker(HfgwUserContext userContext, String appClientId,String chainCodeId,String parameters,String changeRequestId) throws Exception;	
	public ChainCodeInvoker updateChainCodeInvoker(HfgwUserContext userContext,String chainCodeInvokerId, int chainCodeInvokerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ChainCodeInvoker loadChainCodeInvoker(HfgwUserContext userContext, String chainCodeInvokerId, String [] tokensExpr) throws Exception;
	public ChainCodeInvoker internalSaveChainCodeInvoker(HfgwUserContext userContext, ChainCodeInvoker chainCodeInvoker) throws Exception;
	public ChainCodeInvoker internalSaveChainCodeInvoker(HfgwUserContext userContext, ChainCodeInvoker chainCodeInvoker,Map<String,Object>option) throws Exception;
	
	public ChainCodeInvoker transferToAnotherAppClient(HfgwUserContext userContext, String chainCodeInvokerId, String anotherAppClientId)  throws Exception;
 	public ChainCodeInvoker transferToAnotherChainCode(HfgwUserContext userContext, String chainCodeInvokerId, String anotherChainCodeId)  throws Exception;
 	public ChainCodeInvoker transferToAnotherChangeRequest(HfgwUserContext userContext, String chainCodeInvokerId, String anotherChangeRequestId)  throws Exception;
 

	public void delete(HfgwUserContext userContext, String chainCodeInvokerId, int version) throws Exception;
	public int deleteAll(HfgwUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HfgwUserContext userContext, ChainCodeInvoker newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


