
package com.doublechaintech.hfgw.chaincode;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.HfgwUserContext;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;

public interface ChainCodeManager{

		

	public ChainCode createChainCode(HfgwUserContext userContext, String name,String codeName,String codeVersion,String channelId) throws Exception;	
	public ChainCode updateChainCode(HfgwUserContext userContext,String chainCodeId, int chainCodeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ChainCode loadChainCode(HfgwUserContext userContext, String chainCodeId, String [] tokensExpr) throws Exception;
	public ChainCode internalSaveChainCode(HfgwUserContext userContext, ChainCode chainCode) throws Exception;
	public ChainCode internalSaveChainCode(HfgwUserContext userContext, ChainCode chainCode,Map<String,Object>option) throws Exception;
	
	public ChainCode transferToAnotherChannel(HfgwUserContext userContext, String chainCodeId, String anotherChannelId)  throws Exception;
 

	public void delete(HfgwUserContext userContext, String chainCodeId, int version) throws Exception;
	public int deleteAll(HfgwUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HfgwUserContext userContext, ChainCode newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ServiceRecordManager getServiceRecordManager(HfgwUserContext userContext, String chainCodeId, String name, String payload, String channelId, String chainCodeFunction, String transactionId, String blockId, String appClientId, String networkId, String response, String statusId ,String [] tokensExpr)  throws Exception;
	
	public  ChainCode addServiceRecord(HfgwUserContext userContext, String chainCodeId, String name, String payload, String channelId, String chainCodeFunction, String transactionId, String blockId, String appClientId, String networkId, String response, String statusId , String [] tokensExpr)  throws Exception;
	public  ChainCode removeServiceRecord(HfgwUserContext userContext, String chainCodeId, String serviceRecordId, int serviceRecordVersion,String [] tokensExpr)  throws Exception;
	public  ChainCode updateServiceRecord(HfgwUserContext userContext, String chainCodeId, String serviceRecordId, int serviceRecordVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


