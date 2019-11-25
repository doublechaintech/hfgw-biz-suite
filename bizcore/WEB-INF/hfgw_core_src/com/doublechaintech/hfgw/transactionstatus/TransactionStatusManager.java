
package com.doublechaintech.hfgw.transactionstatus;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.HfgwUserContext;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;

public interface TransactionStatusManager{

		
	

	public TransactionStatus loadTransactionStatusWithCode(HfgwUserContext userContext, String code, Map<String,Object>tokens) throws Exception;

	 

	public TransactionStatus createTransactionStatus(HfgwUserContext userContext, String name,String code,String networkId) throws Exception;	
	public TransactionStatus updateTransactionStatus(HfgwUserContext userContext,String transactionStatusId, int transactionStatusVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TransactionStatus loadTransactionStatus(HfgwUserContext userContext, String transactionStatusId, String [] tokensExpr) throws Exception;
	public TransactionStatus internalSaveTransactionStatus(HfgwUserContext userContext, TransactionStatus transactionStatus) throws Exception;
	public TransactionStatus internalSaveTransactionStatus(HfgwUserContext userContext, TransactionStatus transactionStatus,Map<String,Object>option) throws Exception;
	
	public TransactionStatus transferToAnotherNetwork(HfgwUserContext userContext, String transactionStatusId, String anotherNetworkId)  throws Exception;
 

	public void delete(HfgwUserContext userContext, String transactionStatusId, int version) throws Exception;
	public int deleteAll(HfgwUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HfgwUserContext userContext, TransactionStatus newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ServiceRecordManager getServiceRecordManager(HfgwUserContext userContext, String transactionStatusId, String name, String payload, String channelId, String chainCodeId, String chainCodeFunction, String transactionId, String blockId, String appClientId, String networkId, String response ,String [] tokensExpr)  throws Exception;
	
	public  TransactionStatus addServiceRecord(HfgwUserContext userContext, String transactionStatusId, String name, String payload, String channelId, String chainCodeId, String chainCodeFunction, String transactionId, String blockId, String appClientId, String networkId, String response , String [] tokensExpr)  throws Exception;
	public  TransactionStatus removeServiceRecord(HfgwUserContext userContext, String transactionStatusId, String serviceRecordId, int serviceRecordVersion,String [] tokensExpr)  throws Exception;
	public  TransactionStatus updateServiceRecord(HfgwUserContext userContext, String transactionStatusId, String serviceRecordId, int serviceRecordVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


