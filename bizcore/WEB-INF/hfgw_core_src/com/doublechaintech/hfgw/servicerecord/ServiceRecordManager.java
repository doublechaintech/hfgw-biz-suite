
package com.doublechaintech.hfgw.servicerecord;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.HfgwUserContext;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.BaseManager;
import com.doublechaintech.hfgw.SmartList;

public interface ServiceRecordManager extends BaseManager{

		

	public ServiceRecord createServiceRecord(HfgwUserContext userContext, String transactionId,String name,String payload,String channelId,String chainCodeId,String chainCodeFunction,String blockId,String appClientId,String networkId,String response,String statusId) throws Exception;	
	public ServiceRecord updateServiceRecord(HfgwUserContext userContext,String serviceRecordId, int serviceRecordVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ServiceRecord loadServiceRecord(HfgwUserContext userContext, String serviceRecordId, String [] tokensExpr) throws Exception;
	public ServiceRecord internalSaveServiceRecord(HfgwUserContext userContext, ServiceRecord serviceRecord) throws Exception;
	public ServiceRecord internalSaveServiceRecord(HfgwUserContext userContext, ServiceRecord serviceRecord,Map<String,Object>option) throws Exception;
	
	public ServiceRecord transferToAnotherChannel(HfgwUserContext userContext, String serviceRecordId, String anotherChannelId)  throws Exception;
 	public ServiceRecord transferToAnotherChainCode(HfgwUserContext userContext, String serviceRecordId, String anotherChainCodeId)  throws Exception;
 	public ServiceRecord transferToAnotherAppClient(HfgwUserContext userContext, String serviceRecordId, String anotherAppClientId)  throws Exception;
 	public ServiceRecord transferToAnotherNetwork(HfgwUserContext userContext, String serviceRecordId, String anotherNetworkId)  throws Exception;
 	public ServiceRecord transferToAnotherStatus(HfgwUserContext userContext, String serviceRecordId, String anotherStatusId)  throws Exception;
 

	public void delete(HfgwUserContext userContext, String serviceRecordId, int version) throws Exception;
	public int deleteAll(HfgwUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HfgwUserContext userContext, ServiceRecord newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


