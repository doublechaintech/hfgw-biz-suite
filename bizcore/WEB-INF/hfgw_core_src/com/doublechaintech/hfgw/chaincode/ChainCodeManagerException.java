
package com.doublechaintech.hfgw.chaincode;
//import com.doublechaintech.hfgw.EntityNotFoundException;
import com.doublechaintech.hfgw.HfgwException;
import com.doublechaintech.hfgw.Message;
import java.util.List;

public class ChainCodeManagerException extends HfgwException {
	private static final long serialVersionUID = 1L;
	public ChainCodeManagerException(String string) {
		super(string);
	}
	public ChainCodeManagerException(Message message) {
		super(message);
	}
	public ChainCodeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


