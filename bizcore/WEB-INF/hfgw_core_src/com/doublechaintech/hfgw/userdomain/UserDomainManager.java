
package com.doublechaintech.hfgw.userdomain;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.HfgwUserContext;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;

public interface UserDomainManager{

		

	public UserDomain createUserDomain(HfgwUserContext userContext, String name) throws Exception;	
	public UserDomain updateUserDomain(HfgwUserContext userContext,String userDomainId, int userDomainVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UserDomain loadUserDomain(HfgwUserContext userContext, String userDomainId, String [] tokensExpr) throws Exception;
	public UserDomain internalSaveUserDomain(HfgwUserContext userContext, UserDomain userDomain) throws Exception;
	public UserDomain internalSaveUserDomain(HfgwUserContext userContext, UserDomain userDomain,Map<String,Object>option) throws Exception;
	


	public void delete(HfgwUserContext userContext, String userDomainId, int version) throws Exception;
	public int deleteAll(HfgwUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HfgwUserContext userContext, UserDomain newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  UserWhiteListManager getUserWhiteListManager(HfgwUserContext userContext, String userDomainId, String userIdentity, String userSpecialFunctions ,String [] tokensExpr)  throws Exception;
	
	public  UserDomain addUserWhiteList(HfgwUserContext userContext, String userDomainId, String userIdentity, String userSpecialFunctions , String [] tokensExpr)  throws Exception;
	public  UserDomain removeUserWhiteList(HfgwUserContext userContext, String userDomainId, String userWhiteListId, int userWhiteListVersion,String [] tokensExpr)  throws Exception;
	public  UserDomain updateUserWhiteList(HfgwUserContext userContext, String userDomainId, String userWhiteListId, int userWhiteListVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SecUserManager getSecUserManager(HfgwUserContext userContext, String userDomainId, String login, String mobile, String email, String pwd, String weixinOpenid, String weixinAppid, String accessToken, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime ,String [] tokensExpr)  throws Exception;
	
	public  UserDomain addSecUser(HfgwUserContext userContext, String userDomainId, String login, String mobile, String email, String pwd, String weixinOpenid, String weixinAppid, String accessToken, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime , String [] tokensExpr)  throws Exception;
	public  UserDomain removeSecUser(HfgwUserContext userContext, String userDomainId, String secUserId, int secUserVersion,String [] tokensExpr)  throws Exception;
	public  UserDomain updateSecUser(HfgwUserContext userContext, String userDomainId, String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  UserDomain associateSecUserListToNewBlocking(HfgwUserContext userContext, String userDomainId, String  secUserIds[], String who, String comments, String [] tokensExpr) throws Exception ;
	public  UserDomain associateSecUserListToBlocking(HfgwUserContext userContext, String userDomainId, String  secUserIds[],String blockingId, String [] tokensExpr) throws Exception ;

	*/



}


