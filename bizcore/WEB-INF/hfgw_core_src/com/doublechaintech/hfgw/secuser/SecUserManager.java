
package com.doublechaintech.hfgw.secuser;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.HfgwUserContext;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;

public interface SecUserManager{

		
	

	public SecUser loadSecUserWithLogin(HfgwUserContext userContext, String login, Map<String,Object>tokens) throws Exception;

	 
	

	public SecUser loadSecUserWithEmail(HfgwUserContext userContext, String email, Map<String,Object>tokens) throws Exception;

	 
	

	public SecUser loadSecUserWithMobile(HfgwUserContext userContext, String mobile, Map<String,Object>tokens) throws Exception;

	 

	public SecUser createSecUser(HfgwUserContext userContext, String login,String mobile,String email,String pwd,String weixinOpenid,String weixinAppid,String accessToken,int verificationCode,DateTime verificationCodeExpire,DateTime lastLoginTime,String domainId) throws Exception;	
	public SecUser updateSecUser(HfgwUserContext userContext,String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SecUser loadSecUser(HfgwUserContext userContext, String secUserId, String [] tokensExpr) throws Exception;
	public SecUser internalSaveSecUser(HfgwUserContext userContext, SecUser secUser) throws Exception;
	public SecUser internalSaveSecUser(HfgwUserContext userContext, SecUser secUser,Map<String,Object>option) throws Exception;
	
	public SecUser transferToAnotherDomain(HfgwUserContext userContext, String secUserId, String anotherDomainId)  throws Exception;
 	public SecUser block(HfgwUserContext userContext, String secUserId, String who, String comments
)  throws Exception;


	public void delete(HfgwUserContext userContext, String secUserId, int version) throws Exception;
	public int deleteAll(HfgwUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HfgwUserContext userContext, SecUser newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  UserAppManager getUserAppManager(HfgwUserContext userContext, String secUserId, String title, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location ,String [] tokensExpr)  throws Exception;
	
	public  SecUser addUserApp(HfgwUserContext userContext, String secUserId, String title, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location , String [] tokensExpr)  throws Exception;
	public  SecUser removeUserApp(HfgwUserContext userContext, String secUserId, String userAppId, int userAppVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateUserApp(HfgwUserContext userContext, String secUserId, String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  LoginHistoryManager getLoginHistoryManager(HfgwUserContext userContext, String secUserId, String fromIp, String description ,String [] tokensExpr)  throws Exception;
	
	public  SecUser addLoginHistory(HfgwUserContext userContext, String secUserId, String fromIp, String description , String [] tokensExpr)  throws Exception;
	public  SecUser removeLoginHistory(HfgwUserContext userContext, String secUserId, String loginHistoryId, int loginHistoryVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateLoginHistory(HfgwUserContext userContext, String secUserId, String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


