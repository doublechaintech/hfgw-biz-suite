
package com.doublechaintech.hfgw.changerequesttype;
//import com.doublechaintech.hfgw.EntityNotFoundException;
import com.doublechaintech.hfgw.HfgwException;
import com.doublechaintech.hfgw.Message;
import java.util.List;

public class ChangeRequestTypeManagerException extends HfgwException {
	private static final long serialVersionUID = 1L;
	public ChangeRequestTypeManagerException(String string) {
		super(string);
	}
	public ChangeRequestTypeManagerException(Message message) {
		super(message);
	}
	public ChangeRequestTypeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


