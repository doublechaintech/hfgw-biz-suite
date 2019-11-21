
package com.doublechaintech.hfgw.userwhitelist;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.HfgwUserContext;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;

public interface UserWhiteListManager{

		

	public UserWhiteList createUserWhiteList(HfgwUserContext userContext, String userIdentity,String userSpecialFunctions,String domainId) throws Exception;	
	public UserWhiteList updateUserWhiteList(HfgwUserContext userContext,String userWhiteListId, int userWhiteListVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UserWhiteList loadUserWhiteList(HfgwUserContext userContext, String userWhiteListId, String [] tokensExpr) throws Exception;
	public UserWhiteList internalSaveUserWhiteList(HfgwUserContext userContext, UserWhiteList userWhiteList) throws Exception;
	public UserWhiteList internalSaveUserWhiteList(HfgwUserContext userContext, UserWhiteList userWhiteList,Map<String,Object>option) throws Exception;
	
	public UserWhiteList transferToAnotherDomain(HfgwUserContext userContext, String userWhiteListId, String anotherDomainId)  throws Exception;
 

	public void delete(HfgwUserContext userContext, String userWhiteListId, int version) throws Exception;
	public int deleteAll(HfgwUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HfgwUserContext userContext, UserWhiteList newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


