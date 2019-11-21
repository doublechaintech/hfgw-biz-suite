
package com.doublechaintech.hfgw.formaction;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.HfgwUserContext;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;

public interface FormActionManager{

		

	public FormAction createFormAction(HfgwUserContext userContext, String label,String localeKey,String actionKey,String level,String url,String formId) throws Exception;	
	public FormAction updateFormAction(HfgwUserContext userContext,String formActionId, int formActionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormAction loadFormAction(HfgwUserContext userContext, String formActionId, String [] tokensExpr) throws Exception;
	public FormAction internalSaveFormAction(HfgwUserContext userContext, FormAction formAction) throws Exception;
	public FormAction internalSaveFormAction(HfgwUserContext userContext, FormAction formAction,Map<String,Object>option) throws Exception;
	
	public FormAction transferToAnotherForm(HfgwUserContext userContext, String formActionId, String anotherFormId)  throws Exception;
 

	public void delete(HfgwUserContext userContext, String formActionId, int version) throws Exception;
	public int deleteAll(HfgwUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HfgwUserContext userContext, FormAction newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


