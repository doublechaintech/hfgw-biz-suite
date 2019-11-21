
package com.doublechaintech.hfgw.userapp;
//import com.doublechaintech.hfgw.EntityNotFoundException;
import com.doublechaintech.hfgw.HfgwException;
import com.doublechaintech.hfgw.Message;
import java.util.List;

public class UserAppManagerException extends HfgwException {
	private static final long serialVersionUID = 1L;
	public UserAppManagerException(String string) {
		super(string);
	}
	public UserAppManagerException(Message message) {
		super(message);
	}
	public UserAppManagerException(List<Message> messageList) {
		super(messageList);
	}

}


