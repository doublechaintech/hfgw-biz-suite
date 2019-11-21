
package com.doublechaintech.hfgw.quicklink;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.HfgwUserContext;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;

public interface QuickLinkManager{

		

	public QuickLink createQuickLink(HfgwUserContext userContext, String name,String icon,String imagePath,String linkTarget,String appId) throws Exception;	
	public QuickLink updateQuickLink(HfgwUserContext userContext,String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public QuickLink loadQuickLink(HfgwUserContext userContext, String quickLinkId, String [] tokensExpr) throws Exception;
	public QuickLink internalSaveQuickLink(HfgwUserContext userContext, QuickLink quickLink) throws Exception;
	public QuickLink internalSaveQuickLink(HfgwUserContext userContext, QuickLink quickLink,Map<String,Object>option) throws Exception;
	
	public QuickLink transferToAnotherApp(HfgwUserContext userContext, String quickLinkId, String anotherAppId)  throws Exception;
 

	public void delete(HfgwUserContext userContext, String quickLinkId, int version) throws Exception;
	public int deleteAll(HfgwUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HfgwUserContext userContext, QuickLink newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


