
package com.doublechaintech.hfgw.peerrole;
//import com.doublechaintech.hfgw.EntityNotFoundException;
import com.doublechaintech.hfgw.HfgwException;
import com.doublechaintech.hfgw.Message;
import java.util.List;

public class PeerRoleManagerException extends HfgwException {
	private static final long serialVersionUID = 1L;
	public PeerRoleManagerException(String string) {
		super(string);
	}
	public PeerRoleManagerException(Message message) {
		super(message);
	}
	public PeerRoleManagerException(List<Message> messageList) {
		super(messageList);
	}

}


