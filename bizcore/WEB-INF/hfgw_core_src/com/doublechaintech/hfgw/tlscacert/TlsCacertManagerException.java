
package com.doublechaintech.hfgw.tlscacert;
//import com.doublechaintech.hfgw.EntityNotFoundException;
import com.doublechaintech.hfgw.HfgwException;
import com.doublechaintech.hfgw.Message;
import java.util.List;

public class TlsCacertManagerException extends HfgwException {
	private static final long serialVersionUID = 1L;
	public TlsCacertManagerException(String string) {
		super(string);
	}
	public TlsCacertManagerException(Message message) {
		super(message);
	}
	public TlsCacertManagerException(List<Message> messageList) {
		super(messageList);
	}

}


