
package com.doublechaintech.hfgw.node;
//import com.doublechaintech.hfgw.EntityNotFoundException;
import com.doublechaintech.hfgw.HfgwException;
import com.doublechaintech.hfgw.Message;
import java.util.List;

public class NodeManagerException extends HfgwException {
	private static final long serialVersionUID = 1L;
	public NodeManagerException(String string) {
		super(string);
	}
	public NodeManagerException(Message message) {
		super(message);
	}
	public NodeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


