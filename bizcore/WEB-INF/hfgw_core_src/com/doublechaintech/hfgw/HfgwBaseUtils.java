package com.doublechaintech.hfgw;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.function.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.terapico.caf.form.ImageInfo;
import com.terapico.caf.viewcomponent.ButtonViewComponent;
import com.terapico.utils.TextUtil;

import com.doublechaintech.hfgw.nodetype.NodeType;
import com.doublechaintech.hfgw.peerrole.PeerRole;
import com.doublechaintech.hfgw.transactionstatus.TransactionStatus;
import com.doublechaintech.hfgw.changerequesttype.ChangeRequestType;

public class HfgwBaseUtils {
	protected static final Map<String, Object> emptyOptions = new HashMap<>();
	protected static final Map<String, Object> EO = new HashMap<>();

	public static String getOssUploadFolderName(String tokenType, String token, boolean isProdEnv) {
		String folderName;
		folderName = String.format("upload%s/%s/%s", isProdEnv ? "" : "/test", tokenType, token);
		return folderName;
	}
	
	public static String hashWithSHA256(String valueToHash, String salt) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			String textToHash = valueToHash+":"+salt;
			byte[] hash = digest.digest(textToHash.getBytes(StandardCharsets.UTF_8));
			StringBuilder stringBuilder = new StringBuilder();
		    for (byte b : hash) {
		        stringBuilder.append(String.format("%02X", b));
		    }
		    return stringBuilder.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException(e);
		}
	}
	
	private static final Pattern ptnChnMobile = Pattern.compile("1[3-9]\\d{9}");
	public static String formatChinaMobile(String mobile) {
		String num = TextUtil.onlyNumber(mobile);
		if (num.startsWith("86") || num.startsWith("086") || num.startsWith("0086")) {
			int pos = num.indexOf("86");
			num = num.substring(pos+2);
		}
		Matcher m = ptnChnMobile.matcher(num);
		if (m.matches()) {
			return num;
		}
		return null;
	}
	public static String checkChinaMobile(String mobile) throws Exception {
		String cleanMobile = formatChinaMobile(mobile);
		if (cleanMobile == null) {
			throw new Exception("您输入的"+mobile+"不是有效的中国大陆手机号");
		}
		return cleanMobile;
	}
	
	public static String getCacheAccessKey(HfgwUserContext ctx) {
		return ctx.tokenId()+":access_page_without_footprint";
	}
	public static <T> Set<Object> toSet(List<T> list, Function<T, ? extends Object> mapper) {
		return list.stream().map(mapper).collect(Collectors.toSet());
	}
	
	protected static BaseEntity loadCanCacheInLocal(HfgwUserContext userContext, String type, String id) throws Exception {
		String key = "baseentity:"+type+":"+id;
		BaseEntity result = (BaseEntity) userContext.getFromContextLocalStorage(key);
		if (result != null) {
			return result;
		}
		result = userContext.getDAOGroup().loadBasicData(type, id);
		userContext.putIntoContextLocalStorage(key, result);
		return result;
	}
	
	public static <T extends BaseEntity> List<T> collectReferencedObjectWithType(HfgwUserContext userContext,
			BaseEntity rootObject, Class<T> clazz) throws Exception {
		List<T> referedObject = new LinkedList<>();
		Set<Object> checkedObject = new HashSet<>();
		collectReferedObjectIdSet(userContext, referedObject, checkedObject, rootObject, clazz, "/");
		return referedObject;
	}

	public static <T extends BaseEntity> List<T> collectReferencedObjectWithType(HfgwUserContext userContext,
			SmartList<? extends BaseEntity> rootObjectList, Class<T> clazz) throws Exception {
		return collectReferencedObjectWithType(userContext, (List<BaseEntity>) rootObjectList, clazz);
	}

	public static <T extends BaseEntity> List<T> collectReferencedObjectWithType(HfgwUserContext userContext,
			List<? extends BaseEntity> rootObjectList, Class<T> clazz) throws Exception {
		List<T> referedObject = new LinkedList<>();
		Set<Object> checkedObject = new HashSet<>();
		if (rootObjectList == null || rootObjectList.isEmpty()) {
			return referedObject;
		}
		for (BaseEntity refObj : rootObjectList) {
			collectReferedObjectIdSet(userContext, referedObject, checkedObject, refObj, clazz, "/");
		}
		return referedObject;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static <T extends BaseEntity> void collectReferedObjectIdSet(HfgwUserContext userContext,
			List<T> referedObject, Set<Object> checkedObject, BaseEntity rootObject, Class<T> clazz, String path)
			throws Exception {
		if (rootObject == null) {
			return;
		}
		if (checkedObject.contains(rootObject)) {
			return;
		}
		checkedObject.add(rootObject);
		String pathKey = rootObject.hashCode() + "/";
		if (path.contains("/" + pathKey)) {
			// System.out.println("skip, since already collected object " + rootObject);
			return;
		}
		path += pathKey;
		if (clazz.isAssignableFrom(rootObject.getClass())) {
			referedObject.add((T) rootObject);
		}
		Field[] fields = rootObject.getClass().getDeclaredFields();
		for (Field field : fields) {
			boolean isStatic = Modifier.isStatic(field.getModifiers());
			if (isStatic) {
				continue;
			}
			field.setAccessible(true);
			Object value = field.get(rootObject);
			if (List.class.isAssignableFrom(field.getType())) {
				field.setAccessible(true);
				List fieldList = (List) value;
				if (fieldList != null && !fieldList.isEmpty()) {
					for (int i = 0; i < fieldList.size(); i++) {
						Object objData = fieldList.get(i);
						if (objData instanceof BaseEntity) {
							collectReferedObjectIdSet(userContext, referedObject, checkedObject, (BaseEntity) objData,
									clazz, path);
						}
					}
				}
				continue;
			}
			if (value instanceof BaseEntity) {
				collectReferedObjectIdSet(userContext, referedObject, checkedObject, (BaseEntity) value, clazz, path);
				continue;
			}
		}
	}
	
	public static String getImageFromArray(List<ImageInfo> imageArray, int idx) {
		if (imageArray == null || imageArray.size() <= idx) {
			return null;
		}
		return imageArray.get(idx).getImageUrl();
	}
	
	public static boolean isDivisible(BigDecimal divisor, BigDecimal dividend) throws Exception {
		if (dividend.signum() == 0) {
			throw new Exception("请不要输入0");
		}
		BigDecimal[] quotient = divisor.divideAndRemainder(dividend);
		if (quotient.length == 1) {
			return true;
		}
		if (quotient[1].signum() == 0) {
			return true;
		}
		return false;
	}
	
	static Pattern ptnVersionSegment = Pattern.compile("\\d+");
	public static int getBuildVersion(String appVersionStr) {
		if (appVersionStr == null || appVersionStr.isEmpty()) {
			return 0;
		}
		int pos = appVersionStr.lastIndexOf(".");
		if (pos < 0) {
			return Integer.parseInt(appVersionStr);
		}
		//return Integer.parseInt(appVersionStr.substring(pos+1));
		List<String> list = TextUtil.findAllMatched(appVersionStr, ptnVersionSegment);
		return Integer.parseInt(list.get(0));
	}
	public static int getAppBuildVersion(HfgwUserContext ctx) {
		return getBuildVersion(getRequestAppVersion(ctx));
	}
	protected static boolean startFromVersion(HfgwUserContext ctx, int version) {
		if (!ctx.isProductEnvironment()) {
			return true;
		}
		return getAppBuildVersion(ctx) >= version;
	}
	/*
	 * "x-app-device" : "EML-AL00",
  	 * "x-app-type" : "CommunityUser",
     * "X-Forwarded-For" : "123.121.90.15",
  	 * "X-Real-IP" : "123.121.90.15",
     * "X-Forwarded-Server" : "app.art0x.com",
     * "x-app-version" : "9"
	 */
	public static String getRequestAppVersion(HfgwUserContext userContext) {
		return userContext.getRequestHeader("x-app-version");
	}
	public static String getRequestAppDevice(HfgwUserContext userContext) {
		return userContext.getRequestHeader("x-app-device");
	}
	public static String getRequestAppType(HfgwUserContext userContext) {
		return userContext.getRequestHeader("x-app-type");
	}
	private static final NumberFormat cashFormat = new DecimalFormat("#,##0.00");
	private static final NumberFormat exRateFormat = new DecimalFormat("#,##0.00#");
	public static String formatCash(BigDecimal amount) {
		return cashFormat.format(amount)+"元";
	}
	public static String formatExchangeRate(BigDecimal amount) {
		return exRateFormat.format(amount);
	}


	public static NodeType getNodeType(HfgwUserContext userContext, String code) throws Exception {
		String key = "enum:" + NodeType.INTERNAL_TYPE + ":" + code;
		NodeType data = (NodeType) userContext.getFromContextLocalStorage(key);
		if (data != null) {
			return data;
		}
		data = userContext.getDAOGroup().getNodeTypeDAO().loadByCode(code, emptyOptions);
		userContext.putIntoContextLocalStorage(key, data);
		return data;
	}


	public static PeerRole getPeerRole(HfgwUserContext userContext, String code) throws Exception {
		String key = "enum:" + PeerRole.INTERNAL_TYPE + ":" + code;
		PeerRole data = (PeerRole) userContext.getFromContextLocalStorage(key);
		if (data != null) {
			return data;
		}
		data = userContext.getDAOGroup().getPeerRoleDAO().loadByCode(code, emptyOptions);
		userContext.putIntoContextLocalStorage(key, data);
		return data;
	}


	public static TransactionStatus getTransactionStatus(HfgwUserContext userContext, String code) throws Exception {
		String key = "enum:" + TransactionStatus.INTERNAL_TYPE + ":" + code;
		TransactionStatus data = (TransactionStatus) userContext.getFromContextLocalStorage(key);
		if (data != null) {
			return data;
		}
		data = userContext.getDAOGroup().getTransactionStatusDAO().loadByCode(code, emptyOptions);
		userContext.putIntoContextLocalStorage(key, data);
		return data;
	}


	public static ChangeRequestType getChangeRequestType(HfgwUserContext userContext, String code) throws Exception {
		String key = "enum:" + ChangeRequestType.INTERNAL_TYPE + ":" + code;
		ChangeRequestType data = (ChangeRequestType) userContext.getFromContextLocalStorage(key);
		if (data != null) {
			return data;
		}
		data = userContext.getDAOGroup().getChangeRequestTypeDAO().loadByCode(code, emptyOptions);
		userContext.putIntoContextLocalStorage(key, data);
		return data;
	}

	public static <T> T loadBaseEntityById(HfgwUserContext ctx, String type, String id) throws Exception {
		return loadBaseEntityById(ctx, type, id, null);
	}
	public static <T> T loadBaseEntityById(HfgwUserContext ctx, String type, String id, Consumer<T> enhancer) throws Exception {
		String key = type+":"+id;
		BaseEntity cachedValue = (BaseEntity) ctx.getFromContextLocalStorage(key);
		if (cachedValue != null){
			if (cachedValue.getInternalType().equals(type) && cachedValue.getId().equals(id)) {
				return (T) cachedValue;
			}
		}
		T enObj = (T) ctx.getDAOGroup().loadBasicData(type, id);
		if (enhancer != null) {
			enhancer.accept(enObj);
		}
		ctx.putIntoContextLocalStorage(key, enObj);
		return enObj;
	}
	

	
	public static <T extends BaseEntity> void appendLinkToUrl(HfgwUserContext ctx, List<T> list,
			Function<T, String> makeFunc) {
		if (list == null || list.isEmpty()) {
			return;
		}
		list.forEach(it -> {
			it.addItemToValueMap(HfgwBaseConstants.X_LINK_TO_URL, makeFunc.apply(it));
		});
	}

	public static <T extends BaseEntity> void appendLinkToUrl(HfgwUserContext ctx, T obj, String url) {
		if (obj == null) {
			return;
		}
		obj.addItemToValueMap(HfgwBaseConstants.X_LINK_TO_URL, url);
	}

	public static ButtonViewComponent addAction(HfgwUserContext ctx, BaseEntity obj, String title, String code,
			String linkToUrl) {
		ButtonViewComponent actionBtn = new ButtonViewComponent(title, null, code);
		actionBtn.setLinkToUrl(linkToUrl);
		List<ButtonViewComponent> actions = (List<ButtonViewComponent>) obj.valueByKey("actionList");
		if (actions == null) {
			actions = new ArrayList<>();
			obj.addItemToValueMap("actionList", actions);
		}
		actions.add(actionBtn);
		return actionBtn;
	}

	public static void setAction(HfgwUserContext ctx, BaseEntity obj, String title, String code, String linkToUrl) {
		ButtonViewComponent actionBtn = new ButtonViewComponent(title, null, code);
		actionBtn.setLinkToUrl(linkToUrl);
		obj.addItemToValueMap("action", actionBtn);
	}
}








