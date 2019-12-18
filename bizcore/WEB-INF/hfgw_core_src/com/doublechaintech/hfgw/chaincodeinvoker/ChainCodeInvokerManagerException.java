
package com.doublechaintech.hfgw.chaincodeinvoker;
//import com.doublechaintech.hfgw.EntityNotFoundException;
import com.doublechaintech.hfgw.HfgwException;
import com.doublechaintech.hfgw.Message;
import java.util.List;

public class ChainCodeInvokerManagerException extends HfgwException {
	private static final long serialVersionUID = 1L;
	public ChainCodeInvokerManagerException(String string) {
		super(string);
	}
	public ChainCodeInvokerManagerException(Message message) {
		super(message);
	}
	public ChainCodeInvokerManagerException(List<Message> messageList) {
		super(messageList);
	}

}


