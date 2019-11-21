
package com.doublechaintech.hfgw.changerequest;
//import com.doublechaintech.hfgw.EntityNotFoundException;
import com.doublechaintech.hfgw.HfgwException;
import com.doublechaintech.hfgw.Message;
import java.util.List;

public class ChangeRequestManagerException extends HfgwException {
	private static final long serialVersionUID = 1L;
	public ChangeRequestManagerException(String string) {
		super(string);
	}
	public ChangeRequestManagerException(Message message) {
		super(message);
	}
	public ChangeRequestManagerException(List<Message> messageList) {
		super(messageList);
	}

}


