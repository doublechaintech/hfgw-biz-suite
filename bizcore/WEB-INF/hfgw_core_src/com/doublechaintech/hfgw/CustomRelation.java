
package com.doublechaintech.hfgw;
import java.util.HashMap;
import java.util.Map;

public class CustomRelation extends BaseRelation{

	protected void prepareRelation()
	{
		super.prepareRelation();
		//Uncomment to make any change to the relation type
		//replaceGenericRelation("Organization"                          , BaseRelation.TRUST_CHAIN_ALL, "network");
		//replaceGenericRelation("NodeType"                              , BaseRelation.TRUST_CHAIN_ALL, "network");
		//replaceGenericRelation("Node"                                  , BaseRelation.TRUST_CHAIN_ALL, "organization");
		//replaceGenericRelation("Node"                                  , BaseRelation.TRUST_CHAIN_ALL, "channel");
		//replaceGenericRelation("Node"                                  , BaseRelation.TRUST_CHAIN_ALL, "type");
		//replaceGenericRelation("GrpcOption"                            , BaseRelation.TRUST_CHAIN_ALL, "node");
		//replaceGenericRelation("TlsCacert"                             , BaseRelation.TRUST_CHAIN_ALL, "node");
		//replaceGenericRelation("Channel"                               , BaseRelation.TRUST_CHAIN_ALL, "network");
		//replaceGenericRelation("ChainCode"                             , BaseRelation.TRUST_CHAIN_ALL, "channel");
		//replaceGenericRelation("Application"                           , BaseRelation.TRUST_CHAIN_ALL, "channel");
		//replaceGenericRelation("Application"                           , BaseRelation.TRUST_CHAIN_ALL, "network");
		//replaceGenericRelation("ServiceRecord"                         , BaseRelation.TRUST_CHAIN_ALL, "channel");
		//replaceGenericRelation("ServiceRecord"                         , BaseRelation.TRUST_CHAIN_ALL, "chainCode");
		//replaceGenericRelation("ServiceRecord"                         , BaseRelation.TRUST_CHAIN_ALL, "network");
		//replaceGenericRelation("ChangeRequestType"                     , BaseRelation.TRUST_CHAIN_ALL, "network");
		//replaceGenericRelation("ChangeRequest"                         , BaseRelation.TRUST_CHAIN_ALL, "requestType");
		//replaceGenericRelation("ChangeRequest"                         , BaseRelation.TRUST_CHAIN_ALL, "network");
		//replaceGenericRelation("UserWhiteList"                         , BaseRelation.TRUST_CHAIN_ALL, "domain");
		//replaceGenericRelation("SecUser"                               , BaseRelation.TRUST_CHAIN_ALL, "domain");
		//replaceGenericRelation("UserApp"                               , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("QuickLink"                             , BaseRelation.TRUST_CHAIN_ALL, "app");
		//replaceGenericRelation("ListAccess"                            , BaseRelation.TRUST_CHAIN_ALL, "app");
		//replaceGenericRelation("ObjectAccess"                          , BaseRelation.TRUST_CHAIN_ALL, "app");
		//replaceGenericRelation("LoginHistory"                          , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("FormMessage"                           , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("FormFieldMessage"                      , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("FormField"                             , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("FormAction"                            , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("CandidateElement"                      , BaseRelation.TRUST_CHAIN_ALL, "container");

	}
	
	protected void prepareRelationIndex()
	{
		super.prepareRelationIndex();
		/*
		
		Note: you could delete some of the possible relations if you do not want it.
		Just uncomment the definition line and replaceRelationIndex line to replace existing one.
		
		*/
		//String [] organizationRelatedObjectNames = {"network:HyperledgerNetwork"};
		//replaceRelationIndex("Organization",organizationRelatedObjectNames);

		//String [] nodeTypeRelatedObjectNames = {"network:HyperledgerNetwork"};
		//replaceRelationIndex("NodeType",nodeTypeRelatedObjectNames);

		//String [] nodeRelatedObjectNames = {"organization:Organization","channel:Channel","type:NodeType"};
		//replaceRelationIndex("Node",nodeRelatedObjectNames);

		//String [] grpcOptionRelatedObjectNames = {"node:Node"};
		//replaceRelationIndex("GrpcOption",grpcOptionRelatedObjectNames);

		//String [] tlsCacertRelatedObjectNames = {"node:Node"};
		//replaceRelationIndex("TlsCacert",tlsCacertRelatedObjectNames);

		//String [] channelRelatedObjectNames = {"network:HyperledgerNetwork"};
		//replaceRelationIndex("Channel",channelRelatedObjectNames);

		//String [] chainCodeRelatedObjectNames = {"channel:Channel"};
		//replaceRelationIndex("ChainCode",chainCodeRelatedObjectNames);

		//String [] applicationRelatedObjectNames = {"channel:Channel","network:HyperledgerNetwork"};
		//replaceRelationIndex("Application",applicationRelatedObjectNames);

		//String [] serviceRecordRelatedObjectNames = {"channel:Channel","chain_code:ChainCode","network:HyperledgerNetwork"};
		//replaceRelationIndex("ServiceRecord",serviceRecordRelatedObjectNames);

		//String [] changeRequestTypeRelatedObjectNames = {"network:HyperledgerNetwork"};
		//replaceRelationIndex("ChangeRequestType",changeRequestTypeRelatedObjectNames);

		//String [] changeRequestRelatedObjectNames = {"request_type:ChangeRequestType","network:HyperledgerNetwork"};
		//replaceRelationIndex("ChangeRequest",changeRequestRelatedObjectNames);

		//String [] userWhiteListRelatedObjectNames = {"domain:UserDomain"};
		//replaceRelationIndex("UserWhiteList",userWhiteListRelatedObjectNames);

		//String [] secUserRelatedObjectNames = {"domain:UserDomain"};
		//replaceRelationIndex("SecUser",secUserRelatedObjectNames);

		//String [] userAppRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("UserApp",userAppRelatedObjectNames);

		//String [] quickLinkRelatedObjectNames = {"app:UserApp"};
		//replaceRelationIndex("QuickLink",quickLinkRelatedObjectNames);

		//String [] listAccessRelatedObjectNames = {"app:UserApp"};
		//replaceRelationIndex("ListAccess",listAccessRelatedObjectNames);

		//String [] objectAccessRelatedObjectNames = {"app:UserApp"};
		//replaceRelationIndex("ObjectAccess",objectAccessRelatedObjectNames);

		//String [] loginHistoryRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("LoginHistory",loginHistoryRelatedObjectNames);

		//String [] formMessageRelatedObjectNames = {"form:GenericForm"};
		//replaceRelationIndex("FormMessage",formMessageRelatedObjectNames);

		//String [] formFieldMessageRelatedObjectNames = {"form:GenericForm"};
		//replaceRelationIndex("FormFieldMessage",formFieldMessageRelatedObjectNames);

		//String [] formFieldRelatedObjectNames = {"form:GenericForm"};
		//replaceRelationIndex("FormField",formFieldRelatedObjectNames);

		//String [] formActionRelatedObjectNames = {"form:GenericForm"};
		//replaceRelationIndex("FormAction",formActionRelatedObjectNames);

		//String [] candidateElementRelatedObjectNames = {"container:CandidateContainer"};
		//replaceRelationIndex("CandidateElement",candidateElementRelatedObjectNames);

		
		
	
	}
	
	
	@Override
	public String getRelation(String fromType, String fromId, String targetField, String targetId)
	{

		String relation = super.getRelation(fromType, fromId, targetField, targetId);
		if(relation == null){
			throw new IllegalArgumentException("Not able to find any relation to the target type: "+ targetField);
		}
		return relation;
		
	}

}










