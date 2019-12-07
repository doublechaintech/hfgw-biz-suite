
package com.doublechaintech.hfgw.formmessage;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.HfgwUserContext;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.BaseManager;
import com.doublechaintech.hfgw.SmartList;

public interface FormMessageManager extends BaseManager{

		

	public FormMessage createFormMessage(HfgwUserContext userContext, String title,String formId,String level) throws Exception;	
	public FormMessage updateFormMessage(HfgwUserContext userContext,String formMessageId, int formMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormMessage loadFormMessage(HfgwUserContext userContext, String formMessageId, String [] tokensExpr) throws Exception;
	public FormMessage internalSaveFormMessage(HfgwUserContext userContext, FormMessage formMessage) throws Exception;
	public FormMessage internalSaveFormMessage(HfgwUserContext userContext, FormMessage formMessage,Map<String,Object>option) throws Exception;
	
	public FormMessage transferToAnotherForm(HfgwUserContext userContext, String formMessageId, String anotherFormId)  throws Exception;
 

	public void delete(HfgwUserContext userContext, String formMessageId, int version) throws Exception;
	public int deleteAll(HfgwUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HfgwUserContext userContext, FormMessage newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


