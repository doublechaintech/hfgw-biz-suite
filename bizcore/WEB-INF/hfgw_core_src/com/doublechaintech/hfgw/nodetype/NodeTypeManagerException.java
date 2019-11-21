
package com.doublechaintech.hfgw.nodetype;
//import com.doublechaintech.hfgw.EntityNotFoundException;
import com.doublechaintech.hfgw.HfgwException;
import com.doublechaintech.hfgw.Message;
import java.util.List;

public class NodeTypeManagerException extends HfgwException {
	private static final long serialVersionUID = 1L;
	public NodeTypeManagerException(String string) {
		super(string);
	}
	public NodeTypeManagerException(Message message) {
		super(message);
	}
	public NodeTypeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


