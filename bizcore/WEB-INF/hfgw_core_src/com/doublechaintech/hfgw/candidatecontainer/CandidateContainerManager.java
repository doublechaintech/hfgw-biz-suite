
package com.doublechaintech.hfgw.candidatecontainer;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.HfgwUserContext;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;

public interface CandidateContainerManager{

		

	public CandidateContainer createCandidateContainer(HfgwUserContext userContext, String name) throws Exception;	
	public CandidateContainer updateCandidateContainer(HfgwUserContext userContext,String candidateContainerId, int candidateContainerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public CandidateContainer loadCandidateContainer(HfgwUserContext userContext, String candidateContainerId, String [] tokensExpr) throws Exception;
	public CandidateContainer internalSaveCandidateContainer(HfgwUserContext userContext, CandidateContainer candidateContainer) throws Exception;
	public CandidateContainer internalSaveCandidateContainer(HfgwUserContext userContext, CandidateContainer candidateContainer,Map<String,Object>option) throws Exception;
	


	public void delete(HfgwUserContext userContext, String candidateContainerId, int version) throws Exception;
	public int deleteAll(HfgwUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HfgwUserContext userContext, CandidateContainer newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  CandidateElementManager getCandidateElementManager(HfgwUserContext userContext, String candidateContainerId, String name, String type, String image ,String [] tokensExpr)  throws Exception;
	
	public  CandidateContainer addCandidateElement(HfgwUserContext userContext, String candidateContainerId, String name, String type, String image , String [] tokensExpr)  throws Exception;
	public  CandidateContainer removeCandidateElement(HfgwUserContext userContext, String candidateContainerId, String candidateElementId, int candidateElementVersion,String [] tokensExpr)  throws Exception;
	public  CandidateContainer updateCandidateElement(HfgwUserContext userContext, String candidateContainerId, String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


