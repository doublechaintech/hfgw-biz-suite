
package com.doublechaintech.hfgw.candidateelement;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.HfgwUserContext;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.BaseManager;
import com.doublechaintech.hfgw.SmartList;

public interface CandidateElementManager extends BaseManager{

		

	public CandidateElement createCandidateElement(HfgwUserContext userContext, String name,String type,String image,String containerId) throws Exception;	
	public CandidateElement updateCandidateElement(HfgwUserContext userContext,String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public CandidateElement loadCandidateElement(HfgwUserContext userContext, String candidateElementId, String [] tokensExpr) throws Exception;
	public CandidateElement internalSaveCandidateElement(HfgwUserContext userContext, CandidateElement candidateElement) throws Exception;
	public CandidateElement internalSaveCandidateElement(HfgwUserContext userContext, CandidateElement candidateElement,Map<String,Object>option) throws Exception;
	
	public CandidateElement transferToAnotherContainer(HfgwUserContext userContext, String candidateElementId, String anotherContainerId)  throws Exception;
 

	public void delete(HfgwUserContext userContext, String candidateElementId, int version) throws Exception;
	public int deleteAll(HfgwUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(HfgwUserContext userContext, CandidateElement newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}











