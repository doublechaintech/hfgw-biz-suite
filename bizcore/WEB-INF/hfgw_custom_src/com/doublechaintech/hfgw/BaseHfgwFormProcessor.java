package com.doublechaintech.hfgw;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.terapico.caf.form.ImageInfo;
import com.terapico.utils.DebugUtil;

public class BaseHfgwFormProcessor extends BaseFormProcessor{
	protected HfgwUserContext userContext;
	
	public HfgwUserContext getUserContext() {
		return userContext;
	}
	public void setUserContext(HfgwUserContext userContext) {
		this.userContext = userContext;
	}
	protected void addMessageToException(HfgwException e, String msg) {
		Message message = new Message();
		message.setBody(msg);
		e.addErrorMessage(message);
	}
	public Map<String, Object> mapToUiForm(HfgwUserContext userContext) {
		return null; 
	}
}

























