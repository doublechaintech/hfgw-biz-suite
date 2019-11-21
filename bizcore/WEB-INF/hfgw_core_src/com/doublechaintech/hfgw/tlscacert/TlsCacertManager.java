
package com.doublechaintech.hfgw.tlscacert;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.HfgwUserContext;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;

public interface TlsCacertManager{

		

	public TlsCacert createTlsCacert(HfgwUserContext userContext, String path,String cert,String nodeId) throws Exception;	
	public TlsCacert updateTlsCacert(HfgwUserContext userContext,String tlsCacertId, int tlsCacertVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TlsCacert loadTlsCacert(HfgwUserContext userContext, String tlsCacertId, String [] tokensExpr) throws Exception;
	public TlsCacert internalSaveTlsCacert(HfgwUserContext userContext, TlsCacert tlsCacert) throws Exception;
	public TlsCacert internalSaveTlsCacert(HfgwUserContext userContext, TlsCacert tlsCacert,Map<String,Object>option) throws Exception;
	
	public TlsCacert transferToAnotherNode(HfgwUserContext userContext, String tlsCacertId, String anotherNodeId)  throws Exception;
 

	public void delete(HfgwUserContext userContext, String tlsCacertId, int version) throws Exception;
	public int deleteAll(HfgwUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HfgwUserContext userContext, TlsCacert newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


