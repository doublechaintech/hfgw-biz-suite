
package com.doublechaintech.hfgw.application;
//import com.doublechaintech.hfgw.EntityNotFoundException;
import com.doublechaintech.hfgw.HfgwException;
import com.doublechaintech.hfgw.Message;
import java.util.List;

public class ApplicationManagerException extends HfgwException {
	private static final long serialVersionUID = 1L;
	public ApplicationManagerException(String string) {
		super(string);
	}
	public ApplicationManagerException(Message message) {
		super(message);
	}
	public ApplicationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


