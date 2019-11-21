
package com.doublechaintech.hfgw.servicerecord;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.HfgwUserContext;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;

public interface ServiceRecordManager{

		

	public ServiceRecord createServiceRecord(HfgwUserContext userContext, String name,String payLoad,String channelId,String chainCodeId,String chainCodeFunction,String transactionId,String blockId,String networkId) throws Exception;	
	public ServiceRecord updateServiceRecord(HfgwUserContext userContext,String serviceRecordId, int serviceRecordVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ServiceRecord loadServiceRecord(HfgwUserContext userContext, String serviceRecordId, String [] tokensExpr) throws Exception;
	public ServiceRecord internalSaveServiceRecord(HfgwUserContext userContext, ServiceRecord serviceRecord) throws Exception;
	public ServiceRecord internalSaveServiceRecord(HfgwUserContext userContext, ServiceRecord serviceRecord,Map<String,Object>option) throws Exception;
	
	public ServiceRecord transferToAnotherChannel(HfgwUserContext userContext, String serviceRecordId, String anotherChannelId)  throws Exception;
 	public ServiceRecord transferToAnotherChainCode(HfgwUserContext userContext, String serviceRecordId, String anotherChainCodeId)  throws Exception;
 	public ServiceRecord apply(HfgwUserContext userContext, String serviceRecordId, String name, String mspid, String publicKey, String privateKey, String channelId, String networkId
)  throws Exception;
	public ServiceRecord transferToAnotherNetwork(HfgwUserContext userContext, String serviceRecordId, String anotherNetworkId)  throws Exception;
 

	public void delete(HfgwUserContext userContext, String serviceRecordId, int version) throws Exception;
	public int deleteAll(HfgwUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HfgwUserContext userContext, ServiceRecord newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


