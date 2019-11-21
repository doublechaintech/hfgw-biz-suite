
package com.doublechaintech.hfgw.secuserblocking;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.HfgwUserContext;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;

public interface SecUserBlockingManager{

		

	public SecUserBlocking createSecUserBlocking(HfgwUserContext userContext, String who,String comments) throws Exception;	
	public SecUserBlocking updateSecUserBlocking(HfgwUserContext userContext,String secUserBlockingId, int secUserBlockingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SecUserBlocking loadSecUserBlocking(HfgwUserContext userContext, String secUserBlockingId, String [] tokensExpr) throws Exception;
	public SecUserBlocking internalSaveSecUserBlocking(HfgwUserContext userContext, SecUserBlocking secUserBlocking) throws Exception;
	public SecUserBlocking internalSaveSecUserBlocking(HfgwUserContext userContext, SecUserBlocking secUserBlocking,Map<String,Object>option) throws Exception;
	


	public void delete(HfgwUserContext userContext, String secUserBlockingId, int version) throws Exception;
	public int deleteAll(HfgwUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HfgwUserContext userContext, SecUserBlocking newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  SecUserManager getSecUserManager(HfgwUserContext userContext, String secUserBlockingId, String login, String mobile, String email, String pwd, String weixinOpenid, String weixinAppid, String accessToken, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime, String domainId ,String [] tokensExpr)  throws Exception;
	
	public  SecUserBlocking addSecUser(HfgwUserContext userContext, String secUserBlockingId, String login, String mobile, String email, String pwd, String weixinOpenid, String weixinAppid, String accessToken, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime, String domainId , String [] tokensExpr)  throws Exception;
	public  SecUserBlocking removeSecUser(HfgwUserContext userContext, String secUserBlockingId, String secUserId, int secUserVersion,String [] tokensExpr)  throws Exception;
	public  SecUserBlocking updateSecUser(HfgwUserContext userContext, String secUserBlockingId, String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


