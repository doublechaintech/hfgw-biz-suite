
package com.doublechaintech.hfgw.channelpeerrole;
//import com.doublechaintech.hfgw.EntityNotFoundException;
import com.doublechaintech.hfgw.HfgwException;
import com.doublechaintech.hfgw.Message;
import java.util.List;

public class ChannelPeerRoleManagerException extends HfgwException {
	private static final long serialVersionUID = 1L;
	public ChannelPeerRoleManagerException(String string) {
		super(string);
	}
	public ChannelPeerRoleManagerException(Message message) {
		super(message);
	}
	public ChannelPeerRoleManagerException(List<Message> messageList) {
		super(messageList);
	}

}


