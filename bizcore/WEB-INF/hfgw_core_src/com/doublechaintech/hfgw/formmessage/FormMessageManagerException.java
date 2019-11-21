
package com.doublechaintech.hfgw.formmessage;
//import com.doublechaintech.hfgw.EntityNotFoundException;
import com.doublechaintech.hfgw.HfgwException;
import com.doublechaintech.hfgw.Message;
import java.util.List;

public class FormMessageManagerException extends HfgwException {
	private static final long serialVersionUID = 1L;
	public FormMessageManagerException(String string) {
		super(string);
	}
	public FormMessageManagerException(Message message) {
		super(message);
	}
	public FormMessageManagerException(List<Message> messageList) {
		super(messageList);
	}

}


