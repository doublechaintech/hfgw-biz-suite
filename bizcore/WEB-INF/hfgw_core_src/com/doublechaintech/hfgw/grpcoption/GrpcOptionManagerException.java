
package com.doublechaintech.hfgw.grpcoption;
//import com.doublechaintech.hfgw.EntityNotFoundException;
import com.doublechaintech.hfgw.HfgwException;
import com.doublechaintech.hfgw.Message;
import java.util.List;

public class GrpcOptionManagerException extends HfgwException {
	private static final long serialVersionUID = 1L;
	public GrpcOptionManagerException(String string) {
		super(string);
	}
	public GrpcOptionManagerException(Message message) {
		super(message);
	}
	public GrpcOptionManagerException(List<Message> messageList) {
		super(messageList);
	}

}


