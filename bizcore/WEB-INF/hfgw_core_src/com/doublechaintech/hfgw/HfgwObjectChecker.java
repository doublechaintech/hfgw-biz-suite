package com.doublechaintech.hfgw;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
public class HfgwObjectChecker extends HfgwChecker{

	Set<BaseEntity> checkedObjectSet;
	
	protected void markAsChecked(BaseEntity baseEntity) {
		if(checkedObjectSet==null) {
			checkedObjectSet =  new HashSet<BaseEntity>();
		}
		checkedObjectSet.add(baseEntity);
		
		
	}
	
	protected boolean isChecked(BaseEntity baseEntity) {
		if(checkedObjectSet==null) {
			return false;
			
		}
		return checkedObjectSet.contains(baseEntity);
	}
	@FunctionalInterface
	public interface CheckerParameterFunction<P1> {
		HfgwChecker apply(P1 valueToCheck);
	}
	@FunctionalInterface
	public interface AssignParameterFunction {
		HfgwObjectChecker apply(BaseEntity targetEntity);
	}
	
	protected boolean isReferenceObject(BaseEntity target) {
		
		if(target.getId()==null) {
			return false;
		}
		if(target.getId().isEmpty()) {
			return false;
		}
		if(target.getVersion() > 0) {
			return false;
		}
		
		return true;
		
	}
	protected boolean isObjectForCreate(BaseEntity target) {
		if(target.getVersion() > 0) {
			return false;
		}
		if(target.getId()==null) {
			return true;
		}
		if(!target.getId().isEmpty()) {
			return false;
		}
		
		
		return true;
		
	}
	protected void setEntityProperty(BaseEntity targetEntity, String property, Object value) {
		if(!targetEntity.isChanged()) {
			return;
		}
		try {
			targetEntity.setPropertyOf(property, value);
		} catch (Exception e) {
			throw new IllegalArgumentException(concat("set property <",property,"> with value ",value.toString()," of ",targetEntity.toString()," failed"));
		}
		
	}
	
	public <T> HfgwObjectChecker commonObjectPropertyAssign(BaseEntity target, String propertyName, AssignParameterFunction assigmentFunction) {
		assigmentFunction.apply(target);
		return this;
	}
	public <T> HfgwObjectChecker commonObjectPropertyCheck(BaseEntity target, String propertyName, CheckerParameterFunction<T> checkerFunction) {
		
		
		if(!target.isChanged()) {
			return this;
		}
		
		if(isReferenceObject(target)&&!propertyName.equals("id")) {
			//this is an object reference, so all other properties except id check will be ignored
			//id will be checked in this case
			return this; //with an Id, but version is 0 regard as refencer
		}
		if(isObjectForCreate(target)&&propertyName.equals("id")) {
			// ignore check id for new object to create
			return this;
		}
		pushPosition(propertyName);
		T valueToCheck=(T)target.propertyOf(propertyName);
		checkerFunction.apply(valueToCheck);
		popPosition();
		
		return this;
	}
	public  HfgwChecker commonObjectElementCheck(BaseEntity target, String propertyName, CheckerParameterFunction<BaseEntity> checkerFunction) {
		
		pushPosition(propertyName);
		checkerFunction.apply(target);
		popPosition();
		return this;
	}
	protected String wrapArrayIndex(int andIncrement) {
		return "["+andIncrement+"]";
	}
	protected String concat(String ...args) {
		
		return Arrays.asList(args).stream().collect(Collectors.joining(""));
		
	}
	// use like commonObjectPropertyCheck(changeRequestAsBaseEntity,"name",this::checkNameOfChangeRequest);

	public HfgwObjectChecker checkAndFixHyperledgerNetwork(BaseEntity hyperledgerNetworkAsBaseEntity){

		if( isChecked(hyperledgerNetworkAsBaseEntity) ){
			return this;
		}
		markAsChecked(hyperledgerNetworkAsBaseEntity);
		commonObjectPropertyCheck(hyperledgerNetworkAsBaseEntity,"id",this::checkIdOfHyperledgerNetwork);
		commonObjectPropertyCheck(hyperledgerNetworkAsBaseEntity,"name",this::checkNameOfHyperledgerNetwork);
		commonObjectPropertyCheck(hyperledgerNetworkAsBaseEntity,"description",this::checkDescriptionOfHyperledgerNetwork);
		commonObjectPropertyCheck(hyperledgerNetworkAsBaseEntity,"version",this::checkVersionOfHyperledgerNetwork);
		commonObjectPropertyCheck(hyperledgerNetworkAsBaseEntity,"organizationList",this::checkOrganizationListOfHyperledgerNetwork);
		commonObjectPropertyCheck(hyperledgerNetworkAsBaseEntity,"nodeList",this::checkNodeListOfHyperledgerNetwork);
		commonObjectPropertyCheck(hyperledgerNetworkAsBaseEntity,"channelList",this::checkChannelListOfHyperledgerNetwork);
		commonObjectPropertyCheck(hyperledgerNetworkAsBaseEntity,"applicationList",this::checkApplicationListOfHyperledgerNetwork);
		commonObjectPropertyCheck(hyperledgerNetworkAsBaseEntity,"serviceRecordList",this::checkServiceRecordListOfHyperledgerNetwork);
		commonObjectPropertyCheck(hyperledgerNetworkAsBaseEntity,"changeRequestTypeList",this::checkChangeRequestTypeListOfHyperledgerNetwork);
		commonObjectPropertyCheck(hyperledgerNetworkAsBaseEntity,"changeRequestList",this::checkChangeRequestListOfHyperledgerNetwork);
		return this;

	}

	public HfgwObjectChecker checkAndFixOrganization(BaseEntity organizationAsBaseEntity){

		if( isChecked(organizationAsBaseEntity) ){
			return this;
		}
		markAsChecked(organizationAsBaseEntity);
		commonObjectPropertyCheck(organizationAsBaseEntity,"id",this::checkIdOfOrganization);
		commonObjectPropertyCheck(organizationAsBaseEntity,"name",this::checkNameOfOrganization);
		commonObjectPropertyCheck(organizationAsBaseEntity,"mspid",this::checkMspidOfOrganization);
		commonObjectPropertyCheck(organizationAsBaseEntity,"network",this::checkNetworkOfOrganization);
		commonObjectPropertyCheck(organizationAsBaseEntity,"version",this::checkVersionOfOrganization);
		commonObjectPropertyCheck(organizationAsBaseEntity,"nodeList",this::checkNodeListOfOrganization);
		return this;

	}

	public HfgwObjectChecker checkAndFixNodeType(BaseEntity nodeTypeAsBaseEntity){

		if( isChecked(nodeTypeAsBaseEntity) ){
			return this;
		}
		markAsChecked(nodeTypeAsBaseEntity);
		commonObjectPropertyCheck(nodeTypeAsBaseEntity,"id",this::checkIdOfNodeType);
		commonObjectPropertyCheck(nodeTypeAsBaseEntity,"name",this::checkNameOfNodeType);
		commonObjectPropertyCheck(nodeTypeAsBaseEntity,"code",this::checkCodeOfNodeType);
		commonObjectPropertyCheck(nodeTypeAsBaseEntity,"version",this::checkVersionOfNodeType);
		commonObjectPropertyCheck(nodeTypeAsBaseEntity,"nodeList",this::checkNodeListOfNodeType);
		return this;

	}

	public HfgwObjectChecker checkAndFixNode(BaseEntity nodeAsBaseEntity){

		if( isChecked(nodeAsBaseEntity) ){
			return this;
		}
		markAsChecked(nodeAsBaseEntity);
		commonObjectPropertyCheck(nodeAsBaseEntity,"id",this::checkIdOfNode);
		commonObjectPropertyCheck(nodeAsBaseEntity,"name",this::checkNameOfNode);
		commonObjectPropertyCheck(nodeAsBaseEntity,"url",this::checkUrlOfNode);
		commonObjectPropertyCheck(nodeAsBaseEntity,"organization",this::checkOrganizationOfNode);
		commonObjectPropertyCheck(nodeAsBaseEntity,"channel",this::checkChannelOfNode);
		commonObjectPropertyCheck(nodeAsBaseEntity,"network",this::checkNetworkOfNode);
		commonObjectPropertyCheck(nodeAsBaseEntity,"tlsCacert",this::checkTlsCacertOfNode);
		commonObjectPropertyCheck(nodeAsBaseEntity,"type",this::checkTypeOfNode);
		commonObjectPropertyCheck(nodeAsBaseEntity,"address",this::checkAddressOfNode);
		commonObjectPropertyCheck(nodeAsBaseEntity,"contactPerson",this::checkContactPersonOfNode);
		commonObjectPropertyCheck(nodeAsBaseEntity,"contactTelephone",this::checkContactTelephoneOfNode);
		commonObjectPropertyCheck(nodeAsBaseEntity,"version",this::checkVersionOfNode);
		commonObjectPropertyCheck(nodeAsBaseEntity,"grpcOptionList",this::checkGrpcOptionListOfNode);
		commonObjectPropertyCheck(nodeAsBaseEntity,"channelPeerRoleList",this::checkChannelPeerRoleListOfNode);
		return this;

	}

	public HfgwObjectChecker checkAndFixGrpcOption(BaseEntity grpcOptionAsBaseEntity){

		if( isChecked(grpcOptionAsBaseEntity) ){
			return this;
		}
		markAsChecked(grpcOptionAsBaseEntity);
		commonObjectPropertyCheck(grpcOptionAsBaseEntity,"id",this::checkIdOfGrpcOption);
		commonObjectPropertyCheck(grpcOptionAsBaseEntity,"parameterName",this::checkParameterNameOfGrpcOption);
		commonObjectPropertyCheck(grpcOptionAsBaseEntity,"parameterValue",this::checkParameterValueOfGrpcOption);
		commonObjectPropertyCheck(grpcOptionAsBaseEntity,"node",this::checkNodeOfGrpcOption);
		commonObjectPropertyCheck(grpcOptionAsBaseEntity,"version",this::checkVersionOfGrpcOption);
		return this;

	}

	public HfgwObjectChecker checkAndFixChannel(BaseEntity channelAsBaseEntity){

		if( isChecked(channelAsBaseEntity) ){
			return this;
		}
		markAsChecked(channelAsBaseEntity);
		commonObjectPropertyCheck(channelAsBaseEntity,"id",this::checkIdOfChannel);
		commonObjectPropertyCheck(channelAsBaseEntity,"name",this::checkNameOfChannel);
		commonObjectPropertyCheck(channelAsBaseEntity,"network",this::checkNetworkOfChannel);
		commonObjectPropertyCheck(channelAsBaseEntity,"version",this::checkVersionOfChannel);
		commonObjectPropertyCheck(channelAsBaseEntity,"nodeList",this::checkNodeListOfChannel);
		commonObjectPropertyCheck(channelAsBaseEntity,"channelPeerRoleList",this::checkChannelPeerRoleListOfChannel);
		commonObjectPropertyCheck(channelAsBaseEntity,"chainCodeList",this::checkChainCodeListOfChannel);
		commonObjectPropertyCheck(channelAsBaseEntity,"applicationList",this::checkApplicationListOfChannel);
		commonObjectPropertyCheck(channelAsBaseEntity,"serviceRecordList",this::checkServiceRecordListOfChannel);
		return this;

	}

	public HfgwObjectChecker checkAndFixPeerRole(BaseEntity peerRoleAsBaseEntity){

		if( isChecked(peerRoleAsBaseEntity) ){
			return this;
		}
		markAsChecked(peerRoleAsBaseEntity);
		commonObjectPropertyCheck(peerRoleAsBaseEntity,"id",this::checkIdOfPeerRole);
		commonObjectPropertyCheck(peerRoleAsBaseEntity,"name",this::checkNameOfPeerRole);
		commonObjectPropertyCheck(peerRoleAsBaseEntity,"code",this::checkCodeOfPeerRole);
		commonObjectPropertyCheck(peerRoleAsBaseEntity,"version",this::checkVersionOfPeerRole);
		commonObjectPropertyCheck(peerRoleAsBaseEntity,"channelPeerRoleList",this::checkChannelPeerRoleListOfPeerRole);
		return this;

	}

	public HfgwObjectChecker checkAndFixChannelPeerRole(BaseEntity channelPeerRoleAsBaseEntity){

		if( isChecked(channelPeerRoleAsBaseEntity) ){
			return this;
		}
		markAsChecked(channelPeerRoleAsBaseEntity);
		commonObjectPropertyCheck(channelPeerRoleAsBaseEntity,"id",this::checkIdOfChannelPeerRole);
		commonObjectPropertyCheck(channelPeerRoleAsBaseEntity,"channel",this::checkChannelOfChannelPeerRole);
		commonObjectPropertyCheck(channelPeerRoleAsBaseEntity,"node",this::checkNodeOfChannelPeerRole);
		commonObjectPropertyCheck(channelPeerRoleAsBaseEntity,"peerRole",this::checkPeerRoleOfChannelPeerRole);
		commonObjectPropertyCheck(channelPeerRoleAsBaseEntity,"version",this::checkVersionOfChannelPeerRole);
		return this;

	}

	public HfgwObjectChecker checkAndFixChainCode(BaseEntity chainCodeAsBaseEntity){

		if( isChecked(chainCodeAsBaseEntity) ){
			return this;
		}
		markAsChecked(chainCodeAsBaseEntity);
		commonObjectPropertyCheck(chainCodeAsBaseEntity,"id",this::checkIdOfChainCode);
		commonObjectPropertyCheck(chainCodeAsBaseEntity,"name",this::checkNameOfChainCode);
		commonObjectPropertyCheck(chainCodeAsBaseEntity,"codeName",this::checkCodeNameOfChainCode);
		commonObjectPropertyCheck(chainCodeAsBaseEntity,"codeVersion",this::checkCodeVersionOfChainCode);
		commonObjectPropertyCheck(chainCodeAsBaseEntity,"channel",this::checkChannelOfChainCode);
		commonObjectPropertyCheck(chainCodeAsBaseEntity,"version",this::checkVersionOfChainCode);
		commonObjectPropertyCheck(chainCodeAsBaseEntity,"serviceRecordList",this::checkServiceRecordListOfChainCode);
		return this;

	}

	public HfgwObjectChecker checkAndFixApplication(BaseEntity applicationAsBaseEntity){

		if( isChecked(applicationAsBaseEntity) ){
			return this;
		}
		markAsChecked(applicationAsBaseEntity);
		commonObjectPropertyCheck(applicationAsBaseEntity,"id",this::checkIdOfApplication);
		commonObjectPropertyCheck(applicationAsBaseEntity,"name",this::checkNameOfApplication);
		commonObjectPropertyAssign(applicationAsBaseEntity,"createTime",this::assignCreateTimeOfApplication);
		commonObjectPropertyCheck(applicationAsBaseEntity,"mspid",this::checkMspidOfApplication);
		commonObjectPropertyCheck(applicationAsBaseEntity,"publicKey",this::checkPublicKeyOfApplication);
		commonObjectPropertyCheck(applicationAsBaseEntity,"privateKey",this::checkPrivateKeyOfApplication);
		commonObjectPropertyCheck(applicationAsBaseEntity,"channel",this::checkChannelOfApplication);
		commonObjectPropertyCheck(applicationAsBaseEntity,"network",this::checkNetworkOfApplication);
		commonObjectPropertyCheck(applicationAsBaseEntity,"version",this::checkVersionOfApplication);
		commonObjectPropertyCheck(applicationAsBaseEntity,"serviceRecordList",this::checkServiceRecordListOfApplication);
		return this;

	}

	public HfgwObjectChecker checkAndFixServiceRecord(BaseEntity serviceRecordAsBaseEntity){

		if( isChecked(serviceRecordAsBaseEntity) ){
			return this;
		}
		markAsChecked(serviceRecordAsBaseEntity);
		commonObjectPropertyCheck(serviceRecordAsBaseEntity,"id",this::checkIdOfServiceRecord);
		commonObjectPropertyCheck(serviceRecordAsBaseEntity,"name",this::checkNameOfServiceRecord);
		commonObjectPropertyCheck(serviceRecordAsBaseEntity,"payLoad",this::checkPayLoadOfServiceRecord);
		commonObjectPropertyCheck(serviceRecordAsBaseEntity,"channel",this::checkChannelOfServiceRecord);
		commonObjectPropertyCheck(serviceRecordAsBaseEntity,"chainCode",this::checkChainCodeOfServiceRecord);
		commonObjectPropertyCheck(serviceRecordAsBaseEntity,"chainCodeFunction",this::checkChainCodeFunctionOfServiceRecord);
		commonObjectPropertyCheck(serviceRecordAsBaseEntity,"transactionId",this::checkTransactionIdOfServiceRecord);
		commonObjectPropertyCheck(serviceRecordAsBaseEntity,"blockId",this::checkBlockIdOfServiceRecord);
		commonObjectPropertyAssign(serviceRecordAsBaseEntity,"createTime",this::assignCreateTimeOfServiceRecord);
		commonObjectPropertyCheck(serviceRecordAsBaseEntity,"network",this::checkNetworkOfServiceRecord);
		commonObjectPropertyAssign(serviceRecordAsBaseEntity,"currentStatus",this::assignCurrentStatusOfServiceRecord);
		commonObjectPropertyCheck(serviceRecordAsBaseEntity,"version",this::checkVersionOfServiceRecord);
		return this;

	}

	public HfgwObjectChecker checkAndFixChangeRequestType(BaseEntity changeRequestTypeAsBaseEntity){

		if( isChecked(changeRequestTypeAsBaseEntity) ){
			return this;
		}
		markAsChecked(changeRequestTypeAsBaseEntity);
		commonObjectPropertyCheck(changeRequestTypeAsBaseEntity,"id",this::checkIdOfChangeRequestType);
		commonObjectPropertyCheck(changeRequestTypeAsBaseEntity,"name",this::checkNameOfChangeRequestType);
		commonObjectPropertyCheck(changeRequestTypeAsBaseEntity,"code",this::checkCodeOfChangeRequestType);
		commonObjectPropertyCheck(changeRequestTypeAsBaseEntity,"icon",this::checkIconOfChangeRequestType);
		commonObjectPropertyCheck(changeRequestTypeAsBaseEntity,"displayOrder",this::checkDisplayOrderOfChangeRequestType);
		commonObjectPropertyCheck(changeRequestTypeAsBaseEntity,"bindTypes",this::checkBindTypesOfChangeRequestType);
		commonObjectPropertyCheck(changeRequestTypeAsBaseEntity,"stepConfiguration",this::checkStepConfigurationOfChangeRequestType);
		commonObjectPropertyCheck(changeRequestTypeAsBaseEntity,"network",this::checkNetworkOfChangeRequestType);
		commonObjectPropertyCheck(changeRequestTypeAsBaseEntity,"version",this::checkVersionOfChangeRequestType);
		commonObjectPropertyCheck(changeRequestTypeAsBaseEntity,"changeRequestList",this::checkChangeRequestListOfChangeRequestType);
		return this;

	}

	public HfgwObjectChecker checkAndFixChangeRequest(BaseEntity changeRequestAsBaseEntity){

		if( isChecked(changeRequestAsBaseEntity) ){
			return this;
		}
		markAsChecked(changeRequestAsBaseEntity);
		commonObjectPropertyCheck(changeRequestAsBaseEntity,"id",this::checkIdOfChangeRequest);
		commonObjectPropertyCheck(changeRequestAsBaseEntity,"name",this::checkNameOfChangeRequest);
		commonObjectPropertyAssign(changeRequestAsBaseEntity,"createTime",this::assignCreateTimeOfChangeRequest);
		commonObjectPropertyAssign(changeRequestAsBaseEntity,"remoteIp",this::assignRemoteIpOfChangeRequest);
		commonObjectPropertyCheck(changeRequestAsBaseEntity,"requestType",this::checkRequestTypeOfChangeRequest);
		commonObjectPropertyCheck(changeRequestAsBaseEntity,"network",this::checkNetworkOfChangeRequest);
		commonObjectPropertyCheck(changeRequestAsBaseEntity,"version",this::checkVersionOfChangeRequest);
		return this;

	}

	public HfgwObjectChecker checkAndFixUserDomain(BaseEntity userDomainAsBaseEntity){

		if( isChecked(userDomainAsBaseEntity) ){
			return this;
		}
		markAsChecked(userDomainAsBaseEntity);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"id",this::checkIdOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"name",this::checkNameOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"version",this::checkVersionOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"userWhiteListList",this::checkUserWhiteListListOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"secUserList",this::checkSecUserListOfUserDomain);
		return this;

	}

	public HfgwObjectChecker checkAndFixUserWhiteList(BaseEntity userWhiteListAsBaseEntity){

		if( isChecked(userWhiteListAsBaseEntity) ){
			return this;
		}
		markAsChecked(userWhiteListAsBaseEntity);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"id",this::checkIdOfUserWhiteList);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"userIdentity",this::checkUserIdentityOfUserWhiteList);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"userSpecialFunctions",this::checkUserSpecialFunctionsOfUserWhiteList);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"domain",this::checkDomainOfUserWhiteList);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"version",this::checkVersionOfUserWhiteList);
		return this;

	}

	public HfgwObjectChecker checkAndFixSecUser(BaseEntity secUserAsBaseEntity){

		if( isChecked(secUserAsBaseEntity) ){
			return this;
		}
		markAsChecked(secUserAsBaseEntity);
		commonObjectPropertyCheck(secUserAsBaseEntity,"id",this::checkIdOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"login",this::checkLoginOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"mobile",this::checkMobileOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"email",this::checkEmailOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"pwd",this::checkPwdOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"weixinOpenid",this::checkWeixinOpenidOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"weixinAppid",this::checkWeixinAppidOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"accessToken",this::checkAccessTokenOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"verificationCode",this::checkVerificationCodeOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"verificationCodeExpire",this::checkVerificationCodeExpireOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"lastLoginTime",this::checkLastLoginTimeOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"domain",this::checkDomainOfSecUser);
		commonObjectPropertyAssign(secUserAsBaseEntity,"currentStatus",this::assignCurrentStatusOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"version",this::checkVersionOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"userAppList",this::checkUserAppListOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"loginHistoryList",this::checkLoginHistoryListOfSecUser);
		return this;

	}

	public HfgwObjectChecker checkAndFixSecUserBlocking(BaseEntity secUserBlockingAsBaseEntity){

		if( isChecked(secUserBlockingAsBaseEntity) ){
			return this;
		}
		markAsChecked(secUserBlockingAsBaseEntity);
		commonObjectPropertyCheck(secUserBlockingAsBaseEntity,"id",this::checkIdOfSecUserBlocking);
		commonObjectPropertyCheck(secUserBlockingAsBaseEntity,"who",this::checkWhoOfSecUserBlocking);
		commonObjectPropertyAssign(secUserBlockingAsBaseEntity,"blockTime",this::assignBlockTimeOfSecUserBlocking);
		commonObjectPropertyCheck(secUserBlockingAsBaseEntity,"comments",this::checkCommentsOfSecUserBlocking);
		commonObjectPropertyCheck(secUserBlockingAsBaseEntity,"version",this::checkVersionOfSecUserBlocking);
		commonObjectPropertyCheck(secUserBlockingAsBaseEntity,"secUserList",this::checkSecUserListOfSecUserBlocking);
		return this;

	}

	public HfgwObjectChecker checkAndFixUserApp(BaseEntity userAppAsBaseEntity){

		if( isChecked(userAppAsBaseEntity) ){
			return this;
		}
		markAsChecked(userAppAsBaseEntity);
		commonObjectPropertyCheck(userAppAsBaseEntity,"id",this::checkIdOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"title",this::checkTitleOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"secUser",this::checkSecUserOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"appIcon",this::checkAppIconOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"fullAccess",this::checkFullAccessOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"permission",this::checkPermissionOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"objectType",this::checkObjectTypeOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"objectId",this::checkObjectIdOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"location",this::checkLocationOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"version",this::checkVersionOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"quickLinkList",this::checkQuickLinkListOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"listAccessList",this::checkListAccessListOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"objectAccessList",this::checkObjectAccessListOfUserApp);
		return this;

	}

	public HfgwObjectChecker checkAndFixQuickLink(BaseEntity quickLinkAsBaseEntity){

		if( isChecked(quickLinkAsBaseEntity) ){
			return this;
		}
		markAsChecked(quickLinkAsBaseEntity);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"id",this::checkIdOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"name",this::checkNameOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"icon",this::checkIconOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"imagePath",this::checkImagePathOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"linkTarget",this::checkLinkTargetOfQuickLink);
		commonObjectPropertyAssign(quickLinkAsBaseEntity,"createTime",this::assignCreateTimeOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"app",this::checkAppOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"version",this::checkVersionOfQuickLink);
		return this;

	}

	public HfgwObjectChecker checkAndFixListAccess(BaseEntity listAccessAsBaseEntity){

		if( isChecked(listAccessAsBaseEntity) ){
			return this;
		}
		markAsChecked(listAccessAsBaseEntity);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"id",this::checkIdOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"name",this::checkNameOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"internalName",this::checkInternalNameOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"readPermission",this::checkReadPermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"createPermission",this::checkCreatePermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"deletePermission",this::checkDeletePermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"updatePermission",this::checkUpdatePermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"executionPermission",this::checkExecutionPermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"app",this::checkAppOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"version",this::checkVersionOfListAccess);
		return this;

	}

	public HfgwObjectChecker checkAndFixObjectAccess(BaseEntity objectAccessAsBaseEntity){

		if( isChecked(objectAccessAsBaseEntity) ){
			return this;
		}
		markAsChecked(objectAccessAsBaseEntity);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"id",this::checkIdOfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"name",this::checkNameOfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"objectType",this::checkObjectTypeOfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list1",this::checkList1OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list2",this::checkList2OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list3",this::checkList3OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list4",this::checkList4OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list5",this::checkList5OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list6",this::checkList6OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list7",this::checkList7OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list8",this::checkList8OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list9",this::checkList9OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"app",this::checkAppOfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"version",this::checkVersionOfObjectAccess);
		return this;

	}

	public HfgwObjectChecker checkAndFixLoginHistory(BaseEntity loginHistoryAsBaseEntity){

		if( isChecked(loginHistoryAsBaseEntity) ){
			return this;
		}
		markAsChecked(loginHistoryAsBaseEntity);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"id",this::checkIdOfLoginHistory);
		commonObjectPropertyAssign(loginHistoryAsBaseEntity,"loginTime",this::assignLoginTimeOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"fromIp",this::checkFromIpOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"description",this::checkDescriptionOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"secUser",this::checkSecUserOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"version",this::checkVersionOfLoginHistory);
		return this;

	}

	public HfgwObjectChecker checkAndFixGenericForm(BaseEntity genericFormAsBaseEntity){

		if( isChecked(genericFormAsBaseEntity) ){
			return this;
		}
		markAsChecked(genericFormAsBaseEntity);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"id",this::checkIdOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"title",this::checkTitleOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"description",this::checkDescriptionOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"version",this::checkVersionOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"formMessageList",this::checkFormMessageListOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"formFieldMessageList",this::checkFormFieldMessageListOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"formFieldList",this::checkFormFieldListOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"formActionList",this::checkFormActionListOfGenericForm);
		return this;

	}

	public HfgwObjectChecker checkAndFixFormMessage(BaseEntity formMessageAsBaseEntity){

		if( isChecked(formMessageAsBaseEntity) ){
			return this;
		}
		markAsChecked(formMessageAsBaseEntity);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"id",this::checkIdOfFormMessage);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"title",this::checkTitleOfFormMessage);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"form",this::checkFormOfFormMessage);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"level",this::checkLevelOfFormMessage);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"version",this::checkVersionOfFormMessage);
		return this;

	}

	public HfgwObjectChecker checkAndFixFormFieldMessage(BaseEntity formFieldMessageAsBaseEntity){

		if( isChecked(formFieldMessageAsBaseEntity) ){
			return this;
		}
		markAsChecked(formFieldMessageAsBaseEntity);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"id",this::checkIdOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"title",this::checkTitleOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"parameterName",this::checkParameterNameOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"form",this::checkFormOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"level",this::checkLevelOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"version",this::checkVersionOfFormFieldMessage);
		return this;

	}

	public HfgwObjectChecker checkAndFixFormField(BaseEntity formFieldAsBaseEntity){

		if( isChecked(formFieldAsBaseEntity) ){
			return this;
		}
		markAsChecked(formFieldAsBaseEntity);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"id",this::checkIdOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"label",this::checkLabelOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"localeKey",this::checkLocaleKeyOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"parameterName",this::checkParameterNameOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"type",this::checkTypeOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"form",this::checkFormOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"placeholder",this::checkPlaceholderOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"defaultValue",this::checkDefaultValueOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"description",this::checkDescriptionOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"fieldGroup",this::checkFieldGroupOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"minimumValue",this::checkMinimumValueOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"maximumValue",this::checkMaximumValueOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"required",this::checkRequiredOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"disabled",this::checkDisabledOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"customRendering",this::checkCustomRenderingOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"candidateValues",this::checkCandidateValuesOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"suggestValues",this::checkSuggestValuesOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"version",this::checkVersionOfFormField);
		return this;

	}

	public HfgwObjectChecker checkAndFixFormAction(BaseEntity formActionAsBaseEntity){

		if( isChecked(formActionAsBaseEntity) ){
			return this;
		}
		markAsChecked(formActionAsBaseEntity);
		commonObjectPropertyCheck(formActionAsBaseEntity,"id",this::checkIdOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"label",this::checkLabelOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"localeKey",this::checkLocaleKeyOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"actionKey",this::checkActionKeyOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"level",this::checkLevelOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"url",this::checkUrlOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"form",this::checkFormOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"version",this::checkVersionOfFormAction);
		return this;

	}

	public HfgwObjectChecker checkAndFixCandidateContainer(BaseEntity candidateContainerAsBaseEntity){

		if( isChecked(candidateContainerAsBaseEntity) ){
			return this;
		}
		markAsChecked(candidateContainerAsBaseEntity);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"id",this::checkIdOfCandidateContainer);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"name",this::checkNameOfCandidateContainer);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"version",this::checkVersionOfCandidateContainer);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"candidateElementList",this::checkCandidateElementListOfCandidateContainer);
		return this;

	}

	public HfgwObjectChecker checkAndFixCandidateElement(BaseEntity candidateElementAsBaseEntity){

		if( isChecked(candidateElementAsBaseEntity) ){
			return this;
		}
		markAsChecked(candidateElementAsBaseEntity);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"id",this::checkIdOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"name",this::checkNameOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"type",this::checkTypeOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"image",this::checkImageOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"container",this::checkContainerOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"version",this::checkVersionOfCandidateElement);
		return this;

	}


	public HfgwObjectChecker checkOrganizationListOfHyperledgerNetwork(List<BaseEntity> organizationList){
		AtomicInteger index = new AtomicInteger();
		organizationList.stream().forEach(organization->
			commonObjectElementCheck(organization,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixOrganization));
		return this;
	}

	public HfgwObjectChecker checkNodeListOfHyperledgerNetwork(List<BaseEntity> nodeList){
		AtomicInteger index = new AtomicInteger();
		nodeList.stream().forEach(node->
			commonObjectElementCheck(node,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixNode));
		return this;
	}

	public HfgwObjectChecker checkChannelListOfHyperledgerNetwork(List<BaseEntity> channelList){
		AtomicInteger index = new AtomicInteger();
		channelList.stream().forEach(channel->
			commonObjectElementCheck(channel,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixChannel));
		return this;
	}

	public HfgwObjectChecker checkApplicationListOfHyperledgerNetwork(List<BaseEntity> applicationList){
		AtomicInteger index = new AtomicInteger();
		applicationList.stream().forEach(application->
			commonObjectElementCheck(application,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixApplication));
		return this;
	}

	public HfgwObjectChecker checkServiceRecordListOfHyperledgerNetwork(List<BaseEntity> serviceRecordList){
		AtomicInteger index = new AtomicInteger();
		serviceRecordList.stream().forEach(serviceRecord->
			commonObjectElementCheck(serviceRecord,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixServiceRecord));
		return this;
	}

	public HfgwObjectChecker checkChangeRequestTypeListOfHyperledgerNetwork(List<BaseEntity> changeRequestTypeList){
		AtomicInteger index = new AtomicInteger();
		changeRequestTypeList.stream().forEach(changeRequestType->
			commonObjectElementCheck(changeRequestType,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixChangeRequestType));
		return this;
	}

	public HfgwObjectChecker checkChangeRequestListOfHyperledgerNetwork(List<BaseEntity> changeRequestList){
		AtomicInteger index = new AtomicInteger();
		changeRequestList.stream().forEach(changeRequest->
			commonObjectElementCheck(changeRequest,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixChangeRequest));
		return this;
	}

	public HfgwObjectChecker checkNodeListOfOrganization(List<BaseEntity> nodeList){
		AtomicInteger index = new AtomicInteger();
		nodeList.stream().forEach(node->
			commonObjectElementCheck(node,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixNode));
		return this;
	}

	public static final String NETWORK_OF_ORGANIZATION = "organization.network";


	public HfgwObjectChecker checkNetworkOfOrganization(BaseEntity networkAsBaseEntity){

		if(networkAsBaseEntity == null){
			checkBaseEntityReference(networkAsBaseEntity,true,NETWORK_OF_ORGANIZATION);
			return this;
		}
		checkAndFixHyperledgerNetwork(networkAsBaseEntity);
		return this;
	}


	public HfgwObjectChecker checkNodeListOfNodeType(List<BaseEntity> nodeList){
		AtomicInteger index = new AtomicInteger();
		nodeList.stream().forEach(node->
			commonObjectElementCheck(node,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixNode));
		return this;
	}

	public HfgwObjectChecker checkGrpcOptionListOfNode(List<BaseEntity> grpcOptionList){
		AtomicInteger index = new AtomicInteger();
		grpcOptionList.stream().forEach(grpcOption->
			commonObjectElementCheck(grpcOption,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixGrpcOption));
		return this;
	}

	public HfgwObjectChecker checkChannelPeerRoleListOfNode(List<BaseEntity> channelPeerRoleList){
		AtomicInteger index = new AtomicInteger();
		channelPeerRoleList.stream().forEach(channelPeerRole->
			commonObjectElementCheck(channelPeerRole,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixChannelPeerRole));
		return this;
	}

	public static final String ORGANIZATION_OF_NODE = "node.organization";


	public HfgwObjectChecker checkOrganizationOfNode(BaseEntity organizationAsBaseEntity){

		if(organizationAsBaseEntity == null){
			checkBaseEntityReference(organizationAsBaseEntity,true,ORGANIZATION_OF_NODE);
			return this;
		}
		checkAndFixOrganization(organizationAsBaseEntity);
		return this;
	}


	public static final String CHANNEL_OF_NODE = "node.channel";


	public HfgwObjectChecker checkChannelOfNode(BaseEntity channelAsBaseEntity){

		if(channelAsBaseEntity == null){
			checkBaseEntityReference(channelAsBaseEntity,true,CHANNEL_OF_NODE);
			return this;
		}
		checkAndFixChannel(channelAsBaseEntity);
		return this;
	}


	public static final String NETWORK_OF_NODE = "node.network";


	public HfgwObjectChecker checkNetworkOfNode(BaseEntity networkAsBaseEntity){

		if(networkAsBaseEntity == null){
			checkBaseEntityReference(networkAsBaseEntity,true,NETWORK_OF_NODE);
			return this;
		}
		checkAndFixHyperledgerNetwork(networkAsBaseEntity);
		return this;
	}


	public static final String TYPE_OF_NODE = "node.type";


	public HfgwObjectChecker checkTypeOfNode(BaseEntity typeAsBaseEntity){

		if(typeAsBaseEntity == null){
			checkBaseEntityReference(typeAsBaseEntity,true,TYPE_OF_NODE);
			return this;
		}
		checkAndFixNodeType(typeAsBaseEntity);
		return this;
	}


	public static final String NODE_OF_GRPC_OPTION = "grpc_option.node";


	public HfgwObjectChecker checkNodeOfGrpcOption(BaseEntity nodeAsBaseEntity){

		if(nodeAsBaseEntity == null){
			checkBaseEntityReference(nodeAsBaseEntity,true,NODE_OF_GRPC_OPTION);
			return this;
		}
		checkAndFixNode(nodeAsBaseEntity);
		return this;
	}


	public HfgwObjectChecker checkNodeListOfChannel(List<BaseEntity> nodeList){
		AtomicInteger index = new AtomicInteger();
		nodeList.stream().forEach(node->
			commonObjectElementCheck(node,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixNode));
		return this;
	}

	public HfgwObjectChecker checkChannelPeerRoleListOfChannel(List<BaseEntity> channelPeerRoleList){
		AtomicInteger index = new AtomicInteger();
		channelPeerRoleList.stream().forEach(channelPeerRole->
			commonObjectElementCheck(channelPeerRole,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixChannelPeerRole));
		return this;
	}

	public HfgwObjectChecker checkChainCodeListOfChannel(List<BaseEntity> chainCodeList){
		AtomicInteger index = new AtomicInteger();
		chainCodeList.stream().forEach(chainCode->
			commonObjectElementCheck(chainCode,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixChainCode));
		return this;
	}

	public HfgwObjectChecker checkApplicationListOfChannel(List<BaseEntity> applicationList){
		AtomicInteger index = new AtomicInteger();
		applicationList.stream().forEach(application->
			commonObjectElementCheck(application,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixApplication));
		return this;
	}

	public HfgwObjectChecker checkServiceRecordListOfChannel(List<BaseEntity> serviceRecordList){
		AtomicInteger index = new AtomicInteger();
		serviceRecordList.stream().forEach(serviceRecord->
			commonObjectElementCheck(serviceRecord,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixServiceRecord));
		return this;
	}

	public static final String NETWORK_OF_CHANNEL = "channel.network";


	public HfgwObjectChecker checkNetworkOfChannel(BaseEntity networkAsBaseEntity){

		if(networkAsBaseEntity == null){
			checkBaseEntityReference(networkAsBaseEntity,true,NETWORK_OF_CHANNEL);
			return this;
		}
		checkAndFixHyperledgerNetwork(networkAsBaseEntity);
		return this;
	}


	public HfgwObjectChecker checkChannelPeerRoleListOfPeerRole(List<BaseEntity> channelPeerRoleList){
		AtomicInteger index = new AtomicInteger();
		channelPeerRoleList.stream().forEach(channelPeerRole->
			commonObjectElementCheck(channelPeerRole,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixChannelPeerRole));
		return this;
	}

	public static final String CHANNEL_OF_CHANNEL_PEER_ROLE = "channel_peer_role.channel";


	public HfgwObjectChecker checkChannelOfChannelPeerRole(BaseEntity channelAsBaseEntity){

		if(channelAsBaseEntity == null){
			checkBaseEntityReference(channelAsBaseEntity,true,CHANNEL_OF_CHANNEL_PEER_ROLE);
			return this;
		}
		checkAndFixChannel(channelAsBaseEntity);
		return this;
	}


	public static final String NODE_OF_CHANNEL_PEER_ROLE = "channel_peer_role.node";


	public HfgwObjectChecker checkNodeOfChannelPeerRole(BaseEntity nodeAsBaseEntity){

		if(nodeAsBaseEntity == null){
			checkBaseEntityReference(nodeAsBaseEntity,true,NODE_OF_CHANNEL_PEER_ROLE);
			return this;
		}
		checkAndFixNode(nodeAsBaseEntity);
		return this;
	}


	public static final String PEER_ROLE_OF_CHANNEL_PEER_ROLE = "channel_peer_role.peer_role";


	public HfgwObjectChecker checkPeerRoleOfChannelPeerRole(BaseEntity peerRoleAsBaseEntity){

		if(peerRoleAsBaseEntity == null){
			checkBaseEntityReference(peerRoleAsBaseEntity,true,PEER_ROLE_OF_CHANNEL_PEER_ROLE);
			return this;
		}
		checkAndFixPeerRole(peerRoleAsBaseEntity);
		return this;
	}


	public HfgwObjectChecker checkServiceRecordListOfChainCode(List<BaseEntity> serviceRecordList){
		AtomicInteger index = new AtomicInteger();
		serviceRecordList.stream().forEach(serviceRecord->
			commonObjectElementCheck(serviceRecord,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixServiceRecord));
		return this;
	}

	public static final String CHANNEL_OF_CHAIN_CODE = "chain_code.channel";


	public HfgwObjectChecker checkChannelOfChainCode(BaseEntity channelAsBaseEntity){

		if(channelAsBaseEntity == null){
			checkBaseEntityReference(channelAsBaseEntity,true,CHANNEL_OF_CHAIN_CODE);
			return this;
		}
		checkAndFixChannel(channelAsBaseEntity);
		return this;
	}


	public HfgwObjectChecker checkServiceRecordListOfApplication(List<BaseEntity> serviceRecordList){
		AtomicInteger index = new AtomicInteger();
		serviceRecordList.stream().forEach(serviceRecord->
			commonObjectElementCheck(serviceRecord,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixServiceRecord));
		return this;
	}

	public static final String CHANNEL_OF_APPLICATION = "application.channel";


	public HfgwObjectChecker checkChannelOfApplication(BaseEntity channelAsBaseEntity){

		if(channelAsBaseEntity == null){
			checkBaseEntityReference(channelAsBaseEntity,true,CHANNEL_OF_APPLICATION);
			return this;
		}
		checkAndFixChannel(channelAsBaseEntity);
		return this;
	}


	public static final String NETWORK_OF_APPLICATION = "application.network";


	public HfgwObjectChecker checkNetworkOfApplication(BaseEntity networkAsBaseEntity){

		if(networkAsBaseEntity == null){
			checkBaseEntityReference(networkAsBaseEntity,true,NETWORK_OF_APPLICATION);
			return this;
		}
		checkAndFixHyperledgerNetwork(networkAsBaseEntity);
		return this;
	}


	public static final String CHANNEL_OF_SERVICE_RECORD = "service_record.channel";


	public HfgwObjectChecker checkChannelOfServiceRecord(BaseEntity channelAsBaseEntity){

		if(channelAsBaseEntity == null){
			checkBaseEntityReference(channelAsBaseEntity,true,CHANNEL_OF_SERVICE_RECORD);
			return this;
		}
		checkAndFixChannel(channelAsBaseEntity);
		return this;
	}


	public static final String CHAIN_CODE_OF_SERVICE_RECORD = "service_record.chain_code";


	public HfgwObjectChecker checkChainCodeOfServiceRecord(BaseEntity chainCodeAsBaseEntity){

		if(chainCodeAsBaseEntity == null){
			checkBaseEntityReference(chainCodeAsBaseEntity,true,CHAIN_CODE_OF_SERVICE_RECORD);
			return this;
		}
		checkAndFixChainCode(chainCodeAsBaseEntity);
		return this;
	}


	public static final String APPLICATION_OF_SERVICE_RECORD = "service_record.application";


	public HfgwObjectChecker checkApplicationOfServiceRecord(BaseEntity applicationAsBaseEntity){

		if(applicationAsBaseEntity == null){
			checkBaseEntityReference(applicationAsBaseEntity,true,APPLICATION_OF_SERVICE_RECORD);
			return this;
		}
		checkAndFixApplication(applicationAsBaseEntity);
		return this;
	}


	public static final String NETWORK_OF_SERVICE_RECORD = "service_record.network";


	public HfgwObjectChecker checkNetworkOfServiceRecord(BaseEntity networkAsBaseEntity){

		if(networkAsBaseEntity == null){
			checkBaseEntityReference(networkAsBaseEntity,true,NETWORK_OF_SERVICE_RECORD);
			return this;
		}
		checkAndFixHyperledgerNetwork(networkAsBaseEntity);
		return this;
	}


	public HfgwObjectChecker checkChangeRequestListOfChangeRequestType(List<BaseEntity> changeRequestList){
		AtomicInteger index = new AtomicInteger();
		changeRequestList.stream().forEach(changeRequest->
			commonObjectElementCheck(changeRequest,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixChangeRequest));
		return this;
	}

	public static final String NETWORK_OF_CHANGE_REQUEST_TYPE = "change_request_type.network";


	public HfgwObjectChecker checkNetworkOfChangeRequestType(BaseEntity networkAsBaseEntity){

		if(networkAsBaseEntity == null){
			checkBaseEntityReference(networkAsBaseEntity,true,NETWORK_OF_CHANGE_REQUEST_TYPE);
			return this;
		}
		checkAndFixHyperledgerNetwork(networkAsBaseEntity);
		return this;
	}


	public static final String REQUEST_TYPE_OF_CHANGE_REQUEST = "change_request.request_type";


	public HfgwObjectChecker checkRequestTypeOfChangeRequest(BaseEntity requestTypeAsBaseEntity){

		if(requestTypeAsBaseEntity == null){
			checkBaseEntityReference(requestTypeAsBaseEntity,true,REQUEST_TYPE_OF_CHANGE_REQUEST);
			return this;
		}
		checkAndFixChangeRequestType(requestTypeAsBaseEntity);
		return this;
	}


	public static final String NETWORK_OF_CHANGE_REQUEST = "change_request.network";


	public HfgwObjectChecker checkNetworkOfChangeRequest(BaseEntity networkAsBaseEntity){

		if(networkAsBaseEntity == null){
			checkBaseEntityReference(networkAsBaseEntity,true,NETWORK_OF_CHANGE_REQUEST);
			return this;
		}
		checkAndFixHyperledgerNetwork(networkAsBaseEntity);
		return this;
	}


	public HfgwObjectChecker checkUserWhiteListListOfUserDomain(List<BaseEntity> userWhiteListList){
		AtomicInteger index = new AtomicInteger();
		userWhiteListList.stream().forEach(userWhiteList->
			commonObjectElementCheck(userWhiteList,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixUserWhiteList));
		return this;
	}

	public HfgwObjectChecker checkSecUserListOfUserDomain(List<BaseEntity> secUserList){
		AtomicInteger index = new AtomicInteger();
		secUserList.stream().forEach(secUser->
			commonObjectElementCheck(secUser,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSecUser));
		return this;
	}

	public static final String DOMAIN_OF_USER_WHITE_LIST = "user_white_list.domain";


	public HfgwObjectChecker checkDomainOfUserWhiteList(BaseEntity domainAsBaseEntity){

		if(domainAsBaseEntity == null){
			checkBaseEntityReference(domainAsBaseEntity,true,DOMAIN_OF_USER_WHITE_LIST);
			return this;
		}
		checkAndFixUserDomain(domainAsBaseEntity);
		return this;
	}


	public HfgwObjectChecker checkUserAppListOfSecUser(List<BaseEntity> userAppList){
		AtomicInteger index = new AtomicInteger();
		userAppList.stream().forEach(userApp->
			commonObjectElementCheck(userApp,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixUserApp));
		return this;
	}

	public HfgwObjectChecker checkLoginHistoryListOfSecUser(List<BaseEntity> loginHistoryList){
		AtomicInteger index = new AtomicInteger();
		loginHistoryList.stream().forEach(loginHistory->
			commonObjectElementCheck(loginHistory,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixLoginHistory));
		return this;
	}

	public static final String DOMAIN_OF_SEC_USER = "sec_user.domain";


	public HfgwObjectChecker checkDomainOfSecUser(BaseEntity domainAsBaseEntity){

		if(domainAsBaseEntity == null){
			checkBaseEntityReference(domainAsBaseEntity,true,DOMAIN_OF_SEC_USER);
			return this;
		}
		checkAndFixUserDomain(domainAsBaseEntity);
		return this;
	}


	public static final String BLOCKING_OF_SEC_USER = "sec_user.blocking";


	public HfgwObjectChecker checkBlockingOfSecUser(BaseEntity blockingAsBaseEntity){

		if(blockingAsBaseEntity == null){
			checkBaseEntityReference(blockingAsBaseEntity,true,BLOCKING_OF_SEC_USER);
			return this;
		}
		checkAndFixSecUserBlocking(blockingAsBaseEntity);
		return this;
	}


	public HfgwObjectChecker checkSecUserListOfSecUserBlocking(List<BaseEntity> secUserList){
		AtomicInteger index = new AtomicInteger();
		secUserList.stream().forEach(secUser->
			commonObjectElementCheck(secUser,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSecUser));
		return this;
	}

	public HfgwObjectChecker checkQuickLinkListOfUserApp(List<BaseEntity> quickLinkList){
		AtomicInteger index = new AtomicInteger();
		quickLinkList.stream().forEach(quickLink->
			commonObjectElementCheck(quickLink,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixQuickLink));
		return this;
	}

	public HfgwObjectChecker checkListAccessListOfUserApp(List<BaseEntity> listAccessList){
		AtomicInteger index = new AtomicInteger();
		listAccessList.stream().forEach(listAccess->
			commonObjectElementCheck(listAccess,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixListAccess));
		return this;
	}

	public HfgwObjectChecker checkObjectAccessListOfUserApp(List<BaseEntity> objectAccessList){
		AtomicInteger index = new AtomicInteger();
		objectAccessList.stream().forEach(objectAccess->
			commonObjectElementCheck(objectAccess,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixObjectAccess));
		return this;
	}

	public static final String SEC_USER_OF_USER_APP = "user_app.sec_user";


	public HfgwObjectChecker checkSecUserOfUserApp(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_USER_APP);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public static final String APP_OF_QUICK_LINK = "quick_link.app";


	public HfgwObjectChecker checkAppOfQuickLink(BaseEntity appAsBaseEntity){

		if(appAsBaseEntity == null){
			checkBaseEntityReference(appAsBaseEntity,true,APP_OF_QUICK_LINK);
			return this;
		}
		checkAndFixUserApp(appAsBaseEntity);
		return this;
	}


	public static final String APP_OF_LIST_ACCESS = "list_access.app";


	public HfgwObjectChecker checkAppOfListAccess(BaseEntity appAsBaseEntity){

		if(appAsBaseEntity == null){
			checkBaseEntityReference(appAsBaseEntity,true,APP_OF_LIST_ACCESS);
			return this;
		}
		checkAndFixUserApp(appAsBaseEntity);
		return this;
	}


	public static final String APP_OF_OBJECT_ACCESS = "object_access.app";


	public HfgwObjectChecker checkAppOfObjectAccess(BaseEntity appAsBaseEntity){

		if(appAsBaseEntity == null){
			checkBaseEntityReference(appAsBaseEntity,true,APP_OF_OBJECT_ACCESS);
			return this;
		}
		checkAndFixUserApp(appAsBaseEntity);
		return this;
	}


	public static final String SEC_USER_OF_LOGIN_HISTORY = "login_history.sec_user";


	public HfgwObjectChecker checkSecUserOfLoginHistory(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_LOGIN_HISTORY);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public HfgwObjectChecker checkFormMessageListOfGenericForm(List<BaseEntity> formMessageList){
		AtomicInteger index = new AtomicInteger();
		formMessageList.stream().forEach(formMessage->
			commonObjectElementCheck(formMessage,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFormMessage));
		return this;
	}

	public HfgwObjectChecker checkFormFieldMessageListOfGenericForm(List<BaseEntity> formFieldMessageList){
		AtomicInteger index = new AtomicInteger();
		formFieldMessageList.stream().forEach(formFieldMessage->
			commonObjectElementCheck(formFieldMessage,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFormFieldMessage));
		return this;
	}

	public HfgwObjectChecker checkFormFieldListOfGenericForm(List<BaseEntity> formFieldList){
		AtomicInteger index = new AtomicInteger();
		formFieldList.stream().forEach(formField->
			commonObjectElementCheck(formField,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFormField));
		return this;
	}

	public HfgwObjectChecker checkFormActionListOfGenericForm(List<BaseEntity> formActionList){
		AtomicInteger index = new AtomicInteger();
		formActionList.stream().forEach(formAction->
			commonObjectElementCheck(formAction,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFormAction));
		return this;
	}

	public static final String FORM_OF_FORM_MESSAGE = "form_message.form";


	public HfgwObjectChecker checkFormOfFormMessage(BaseEntity formAsBaseEntity){

		if(formAsBaseEntity == null){
			checkBaseEntityReference(formAsBaseEntity,true,FORM_OF_FORM_MESSAGE);
			return this;
		}
		checkAndFixGenericForm(formAsBaseEntity);
		return this;
	}


	public static final String FORM_OF_FORM_FIELD_MESSAGE = "form_field_message.form";


	public HfgwObjectChecker checkFormOfFormFieldMessage(BaseEntity formAsBaseEntity){

		if(formAsBaseEntity == null){
			checkBaseEntityReference(formAsBaseEntity,true,FORM_OF_FORM_FIELD_MESSAGE);
			return this;
		}
		checkAndFixGenericForm(formAsBaseEntity);
		return this;
	}


	public static final String FORM_OF_FORM_FIELD = "form_field.form";


	public HfgwObjectChecker checkFormOfFormField(BaseEntity formAsBaseEntity){

		if(formAsBaseEntity == null){
			checkBaseEntityReference(formAsBaseEntity,true,FORM_OF_FORM_FIELD);
			return this;
		}
		checkAndFixGenericForm(formAsBaseEntity);
		return this;
	}


	public static final String FORM_OF_FORM_ACTION = "form_action.form";


	public HfgwObjectChecker checkFormOfFormAction(BaseEntity formAsBaseEntity){

		if(formAsBaseEntity == null){
			checkBaseEntityReference(formAsBaseEntity,true,FORM_OF_FORM_ACTION);
			return this;
		}
		checkAndFixGenericForm(formAsBaseEntity);
		return this;
	}


	public HfgwObjectChecker checkCandidateElementListOfCandidateContainer(List<BaseEntity> candidateElementList){
		AtomicInteger index = new AtomicInteger();
		candidateElementList.stream().forEach(candidateElement->
			commonObjectElementCheck(candidateElement,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixCandidateElement));
		return this;
	}

	public static final String CONTAINER_OF_CANDIDATE_ELEMENT = "candidate_element.container";


	public HfgwObjectChecker checkContainerOfCandidateElement(BaseEntity containerAsBaseEntity){

		if(containerAsBaseEntity == null){
			checkBaseEntityReference(containerAsBaseEntity,true,CONTAINER_OF_CANDIDATE_ELEMENT);
			return this;
		}
		checkAndFixCandidateContainer(containerAsBaseEntity);
		return this;
	}

	public HfgwObjectChecker assignCreateTimeOfApplication(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public HfgwObjectChecker assignCreateTimeOfServiceRecord(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public HfgwObjectChecker assignApplicationOfServiceRecord(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		return this;
	}
	public HfgwObjectChecker assignCurrentStatusOfServiceRecord(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"currentStatus","INIT");
		return this;
	}
	public HfgwObjectChecker assignCreateTimeOfChangeRequest(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public HfgwObjectChecker assignRemoteIpOfChangeRequest(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"remoteIp",userContext.getRemoteIP());
		return this;
	}
	public HfgwObjectChecker assignBlockingOfSecUser(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		return this;
	}
	public HfgwObjectChecker assignCurrentStatusOfSecUser(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"currentStatus","INIT");
		return this;
	}
	public HfgwObjectChecker assignBlockTimeOfSecUserBlocking(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"blockTime",userContext.now());
		return this;
	}
	public HfgwObjectChecker assignCreateTimeOfQuickLink(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public HfgwObjectChecker assignLoginTimeOfLoginHistory(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"loginTime",userContext.now());
		return this;
	}

}

