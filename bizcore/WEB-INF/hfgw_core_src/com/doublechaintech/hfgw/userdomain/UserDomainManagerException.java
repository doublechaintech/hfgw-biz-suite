
package com.doublechaintech.hfgw.userdomain;
//import com.doublechaintech.hfgw.EntityNotFoundException;
import com.doublechaintech.hfgw.HfgwException;
import com.doublechaintech.hfgw.Message;
import java.util.List;

public class UserDomainManagerException extends HfgwException {
	private static final long serialVersionUID = 1L;
	public UserDomainManagerException(String string) {
		super(string);
	}
	public UserDomainManagerException(Message message) {
		super(message);
	}
	public UserDomainManagerException(List<Message> messageList) {
		super(messageList);
	}

}


