package com.doublechaintech.hfgw;
import com.terapico.caf.DateTime;
import com.terapico.uccaf.BaseUserContext;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class HfgwCheckerManager extends BaseManagerImpl {
	protected HfgwObjectChecker checkerOf(HfgwUserContext ctx) {
		return ctx.getChecker();
	}
	private static class AsyncManagerJob extends Thread {
		protected Object me;
		protected Object proxy;
		protected Method method;
		protected Object[] args;
		protected MethodProxy methodProxy;

		public AsyncManagerJob(Object me, Object proxy, Method method, Object[] args, MethodProxy methodProxy) {
			super();
			this.me = me;
			this.proxy = proxy;
			this.method = method;
			this.args = args;
			this.methodProxy = methodProxy;
		}

		@Override
		public void run() {
			try {
				method.setAccessible(true);
				method.invoke(me, args);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
	
	public static final Map<String, Object> EO = new HashMap<>();
	protected Object asyncProxy = null;
	protected Object getAsyncProxy() {
		if (asyncProxy != null) {
			return asyncProxy;
		}
		
		Object me = this;
		MethodInterceptor proxy = new MethodInterceptor() {

			@Override
			public Object intercept(Object proxyObj, Method method, Object[] args, MethodProxy methodProxy)
					throws Throwable {
				new AsyncManagerJob(me, proxyObj, method, args, methodProxy).start();
				return null;
			}
		};
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(me.getClass());
		enhancer.setCallback(proxy);
		return asyncProxy = enhancer.create();
	}
	
	protected void cacheVerifyCode(HfgwUserContext ctx, String mobile, String verifyCode) {
		String cacheKey = "verifyCode:"+mobile;
		ctx.putToCache(cacheKey, verifyCode, HfgwBaseConstants.DEFAULT_CACHE_TIME_FOR_VCODE);
	}

	protected String getVerifyCodeFromCache(HfgwUserContext ctx, String mobile) {
		String cacheKey = "verifyCode:"+mobile;
		return (String) ctx.getCachedObject(cacheKey, String.class);
	}
	protected void checkVerifyCode(HfgwUserContext ctx, String inputVerifyCode, String mobile) throws Exception {
		String cachedVerifyCode = getVerifyCodeFromCache(ctx, mobile);
		if (cachedVerifyCode == null) {
			throw new Exception("请先获取验证码");
		}
		if (!cachedVerifyCode.equals(inputVerifyCode)) {
			throw new Exception("验证码不正确");
		}
	}
	

	
	
	
	@Override
	protected<T extends BaseEntity> void addActions(BaseUserContext baseUserContext, T entity,
			Map<String, Object> tokens){
		
		entity.addAction(createAction("@view","view","view/"+entity.getId()+"/","main","primary"));
		this.requestTypeActions(baseUserContext, entity);
	}
	
	protected void convertToActions(BaseEntity targetObject,com.doublechaintech.hfgw.changerequesttype.ChangeRequestType changeRequestType) {
		
		
		String []bindTypes = changeRequestType.getBindTypes().split(",");
		
		boolean matchType = Arrays.stream(bindTypes).anyMatch(type->targetObject.getInternalType().equals(type.trim()));
		if(!matchType) {
			return ;
		}
		
		
		Action action = new Action();
		
		action.asChangeRequestGroup();
		action.setActionName(changeRequestType.getName());
		action.setActionKey(changeRequestType.getCode());
		action.setActionIcon(changeRequestType.getIcon());
		
		String actionPath = String.format("/%s/%s/%s/%s/%s",
				targetObject.getInternalType(),
				targetObject.getId(),
				changeRequestType.getInternalType(),
				changeRequestType.getCode(),
				changeRequestType.getName()
				);
		
		action.setActionPath(actionPath);
		targetObject.addAction(action);
		
		
		
		
	}
	protected void requestTypeActions(BaseUserContext userContext, BaseEntity targetObject) {
		
		changeRequestTypeDaoOf((HfgwUserContext)userContext)
			.loadAll()
			.forEach(crType->convertToActions(targetObject,crType));
	}


	public com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetworkManager hyperledgerNetworkManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getHyperledgerNetworkManager();
	}
	public com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetworkDAO hyperledgerNetworkDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getHyperledgerNetworkDAO();
	}
	public com.doublechaintech.hfgw.organization.OrganizationManager organizationManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getOrganizationManager();
	}
	public com.doublechaintech.hfgw.organization.OrganizationDAO organizationDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getOrganizationDAO();
	}
	public com.doublechaintech.hfgw.nodetype.NodeTypeManager nodeTypeManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getNodeTypeManager();
	}
	public com.doublechaintech.hfgw.nodetype.NodeTypeDAO nodeTypeDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getNodeTypeDAO();
	}
	public com.doublechaintech.hfgw.node.NodeManager nodeManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getNodeManager();
	}
	public com.doublechaintech.hfgw.node.NodeDAO nodeDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getNodeDAO();
	}
	public com.doublechaintech.hfgw.grpcoption.GrpcOptionManager grpcOptionManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getGrpcOptionManager();
	}
	public com.doublechaintech.hfgw.grpcoption.GrpcOptionDAO grpcOptionDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getGrpcOptionDAO();
	}
	public com.doublechaintech.hfgw.channel.ChannelManager channelManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getChannelManager();
	}
	public com.doublechaintech.hfgw.channel.ChannelDAO channelDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getChannelDAO();
	}
	public com.doublechaintech.hfgw.peerrole.PeerRoleManager peerRoleManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getPeerRoleManager();
	}
	public com.doublechaintech.hfgw.peerrole.PeerRoleDAO peerRoleDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getPeerRoleDAO();
	}
	public com.doublechaintech.hfgw.channelpeerrole.ChannelPeerRoleManager channelPeerRoleManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getChannelPeerRoleManager();
	}
	public com.doublechaintech.hfgw.channelpeerrole.ChannelPeerRoleDAO channelPeerRoleDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getChannelPeerRoleDAO();
	}
	public com.doublechaintech.hfgw.chaincode.ChainCodeManager chainCodeManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getChainCodeManager();
	}
	public com.doublechaintech.hfgw.chaincode.ChainCodeDAO chainCodeDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getChainCodeDAO();
	}
	public com.doublechaintech.hfgw.application.ApplicationManager applicationManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getApplicationManager();
	}
	public com.doublechaintech.hfgw.application.ApplicationDAO applicationDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getApplicationDAO();
	}
	public com.doublechaintech.hfgw.servicerecord.ServiceRecordManager serviceRecordManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getServiceRecordManager();
	}
	public com.doublechaintech.hfgw.servicerecord.ServiceRecordDAO serviceRecordDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getServiceRecordDAO();
	}
	public com.doublechaintech.hfgw.changerequesttype.ChangeRequestTypeManager changeRequestTypeManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getChangeRequestTypeManager();
	}
	public com.doublechaintech.hfgw.changerequesttype.ChangeRequestTypeDAO changeRequestTypeDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getChangeRequestTypeDAO();
	}
	public com.doublechaintech.hfgw.changerequest.ChangeRequestManager changeRequestManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getChangeRequestManager();
	}
	public com.doublechaintech.hfgw.changerequest.ChangeRequestDAO changeRequestDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getChangeRequestDAO();
	}
	public com.doublechaintech.hfgw.userdomain.UserDomainManager userDomainManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getUserDomainManager();
	}
	public com.doublechaintech.hfgw.userdomain.UserDomainDAO userDomainDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getUserDomainDAO();
	}
	public com.doublechaintech.hfgw.userwhitelist.UserWhiteListManager userWhiteListManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getUserWhiteListManager();
	}
	public com.doublechaintech.hfgw.userwhitelist.UserWhiteListDAO userWhiteListDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getUserWhiteListDAO();
	}
	public com.doublechaintech.hfgw.secuser.SecUserManager secUserManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getSecUserManager();
	}
	public com.doublechaintech.hfgw.secuser.SecUserDAO secUserDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getSecUserDAO();
	}
	public com.doublechaintech.hfgw.secuserblocking.SecUserBlockingManager secUserBlockingManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getSecUserBlockingManager();
	}
	public com.doublechaintech.hfgw.secuserblocking.SecUserBlockingDAO secUserBlockingDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getSecUserBlockingDAO();
	}
	public com.doublechaintech.hfgw.userapp.UserAppManager userAppManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getUserAppManager();
	}
	public com.doublechaintech.hfgw.userapp.UserAppDAO userAppDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getUserAppDAO();
	}
	public com.doublechaintech.hfgw.quicklink.QuickLinkManager quickLinkManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getQuickLinkManager();
	}
	public com.doublechaintech.hfgw.quicklink.QuickLinkDAO quickLinkDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getQuickLinkDAO();
	}
	public com.doublechaintech.hfgw.listaccess.ListAccessManager listAccessManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getListAccessManager();
	}
	public com.doublechaintech.hfgw.listaccess.ListAccessDAO listAccessDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getListAccessDAO();
	}
	public com.doublechaintech.hfgw.objectaccess.ObjectAccessManager objectAccessManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getObjectAccessManager();
	}
	public com.doublechaintech.hfgw.objectaccess.ObjectAccessDAO objectAccessDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getObjectAccessDAO();
	}
	public com.doublechaintech.hfgw.loginhistory.LoginHistoryManager loginHistoryManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getLoginHistoryManager();
	}
	public com.doublechaintech.hfgw.loginhistory.LoginHistoryDAO loginHistoryDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getLoginHistoryDAO();
	}
	public com.doublechaintech.hfgw.genericform.GenericFormManager genericFormManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getGenericFormManager();
	}
	public com.doublechaintech.hfgw.genericform.GenericFormDAO genericFormDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getGenericFormDAO();
	}
	public com.doublechaintech.hfgw.formmessage.FormMessageManager formMessageManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getFormMessageManager();
	}
	public com.doublechaintech.hfgw.formmessage.FormMessageDAO formMessageDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getFormMessageDAO();
	}
	public com.doublechaintech.hfgw.formfieldmessage.FormFieldMessageManager formFieldMessageManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getFormFieldMessageManager();
	}
	public com.doublechaintech.hfgw.formfieldmessage.FormFieldMessageDAO formFieldMessageDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getFormFieldMessageDAO();
	}
	public com.doublechaintech.hfgw.formfield.FormFieldManager formFieldManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getFormFieldManager();
	}
	public com.doublechaintech.hfgw.formfield.FormFieldDAO formFieldDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getFormFieldDAO();
	}
	public com.doublechaintech.hfgw.formaction.FormActionManager formActionManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getFormActionManager();
	}
	public com.doublechaintech.hfgw.formaction.FormActionDAO formActionDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getFormActionDAO();
	}
	public com.doublechaintech.hfgw.candidatecontainer.CandidateContainerManager candidateContainerManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getCandidateContainerManager();
	}
	public com.doublechaintech.hfgw.candidatecontainer.CandidateContainerDAO candidateContainerDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getCandidateContainerDAO();
	}
	public com.doublechaintech.hfgw.candidateelement.CandidateElementManager candidateElementManagerOf(HfgwUserContext userContext){
		return userContext.getManagerGroup().getCandidateElementManager();
	}
	public com.doublechaintech.hfgw.candidateelement.CandidateElementDAO candidateElementDaoOf(HfgwUserContext userContext){
		return userContext.getDAOGroup().getCandidateElementDAO();
	}
	
	
	
	

	protected void checkGender(String gender, int i, int j,String targetFieldName, List<Message> messageList) {
		
		
	}
	
	//for stub only
	protected void checkDateNow(Date likeTime, int i, Object now,
			String targetFieldName, HfgwException exception) {
		
		
	}


	protected Object now() {

		return null;
	}
	
	protected boolean isValidIdentifier(String value){
		return hasVisualChar(value);
		
	}
	
	protected boolean hasVisualChar(String value){
		if(value==null){
			return false;
		}
		if(value.isEmpty()){
			return false;
		}
		if(value.trim().isEmpty()){
			return false;
		}
		return true;
		
	}
	protected void checkBigDecimalRange(BigDecimal projectArea, double i, double j, String projectAreaOfProject,
			List<Message> messageList) {
		
	}
    
}








