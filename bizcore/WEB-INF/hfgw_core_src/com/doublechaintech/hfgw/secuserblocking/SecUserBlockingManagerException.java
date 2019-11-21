
package com.doublechaintech.hfgw.secuserblocking;
//import com.doublechaintech.hfgw.EntityNotFoundException;
import com.doublechaintech.hfgw.HfgwException;
import com.doublechaintech.hfgw.Message;
import java.util.List;

public class SecUserBlockingManagerException extends HfgwException {
	private static final long serialVersionUID = 1L;
	public SecUserBlockingManagerException(String string) {
		super(string);
	}
	public SecUserBlockingManagerException(Message message) {
		super(message);
	}
	public SecUserBlockingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


