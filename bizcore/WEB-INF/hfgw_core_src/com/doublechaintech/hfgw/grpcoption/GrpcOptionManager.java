
package com.doublechaintech.hfgw.grpcoption;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.HfgwUserContext;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.BaseManager;
import com.doublechaintech.hfgw.SmartList;

public interface GrpcOptionManager extends BaseManager{

		

	public GrpcOption createGrpcOption(HfgwUserContext userContext, String parameterName,String parameterValue,String nodeId) throws Exception;	
	public GrpcOption updateGrpcOption(HfgwUserContext userContext,String grpcOptionId, int grpcOptionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public GrpcOption loadGrpcOption(HfgwUserContext userContext, String grpcOptionId, String [] tokensExpr) throws Exception;
	public GrpcOption internalSaveGrpcOption(HfgwUserContext userContext, GrpcOption grpcOption) throws Exception;
	public GrpcOption internalSaveGrpcOption(HfgwUserContext userContext, GrpcOption grpcOption,Map<String,Object>option) throws Exception;
	
	public GrpcOption transferToAnotherNode(HfgwUserContext userContext, String grpcOptionId, String anotherNodeId)  throws Exception;
 

	public void delete(HfgwUserContext userContext, String grpcOptionId, int version) throws Exception;
	public int deleteAll(HfgwUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HfgwUserContext userContext, GrpcOption newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


