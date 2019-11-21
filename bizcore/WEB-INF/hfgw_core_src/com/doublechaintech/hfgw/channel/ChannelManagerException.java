
package com.doublechaintech.hfgw.channel;
//import com.doublechaintech.hfgw.EntityNotFoundException;
import com.doublechaintech.hfgw.HfgwException;
import com.doublechaintech.hfgw.Message;
import java.util.List;

public class ChannelManagerException extends HfgwException {
	private static final long serialVersionUID = 1L;
	public ChannelManagerException(String string) {
		super(string);
	}
	public ChannelManagerException(Message message) {
		super(message);
	}
	public ChannelManagerException(List<Message> messageList) {
		super(messageList);
	}

}


