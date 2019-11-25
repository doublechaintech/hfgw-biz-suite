
package com.doublechaintech.hfgw.application;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.HfgwUserContext;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;

public interface ApplicationManager{

		

	public Application createApplication(HfgwUserContext userContext, String name,String mspid,String publicKey,String privateKey,String channelId,String networkId) throws Exception;	
	public Application updateApplication(HfgwUserContext userContext,String applicationId, int applicationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Application loadApplication(HfgwUserContext userContext, String applicationId, String [] tokensExpr) throws Exception;
	public Application internalSaveApplication(HfgwUserContext userContext, Application application) throws Exception;
	public Application internalSaveApplication(HfgwUserContext userContext, Application application,Map<String,Object>option) throws Exception;
	
	public Application transferToAnotherChannel(HfgwUserContext userContext, String applicationId, String anotherChannelId)  throws Exception;
 	public Application transferToAnotherNetwork(HfgwUserContext userContext, String applicationId, String anotherNetworkId)  throws Exception;
 

	public void delete(HfgwUserContext userContext, String applicationId, int version) throws Exception;
	public int deleteAll(HfgwUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HfgwUserContext userContext, Application newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ServiceRecordManager getServiceRecordManager(HfgwUserContext userContext, String applicationId, String name, String payload, String channelId, String chainCodeId, String chainCodeFunction, String transactionId, String blockId, String networkId, String response, String statusId ,String [] tokensExpr)  throws Exception;
	
	public  Application addServiceRecord(HfgwUserContext userContext, String applicationId, String name, String payload, String channelId, String chainCodeId, String chainCodeFunction, String transactionId, String blockId, String networkId, String response, String statusId , String [] tokensExpr)  throws Exception;
	public  Application removeServiceRecord(HfgwUserContext userContext, String applicationId, String serviceRecordId, int serviceRecordVersion,String [] tokensExpr)  throws Exception;
	public  Application updateServiceRecord(HfgwUserContext userContext, String applicationId, String serviceRecordId, int serviceRecordVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


