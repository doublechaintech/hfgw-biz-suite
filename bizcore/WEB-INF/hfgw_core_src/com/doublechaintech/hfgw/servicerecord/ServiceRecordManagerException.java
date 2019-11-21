
package com.doublechaintech.hfgw.servicerecord;
//import com.doublechaintech.hfgw.EntityNotFoundException;
import com.doublechaintech.hfgw.HfgwException;
import com.doublechaintech.hfgw.Message;
import java.util.List;

public class ServiceRecordManagerException extends HfgwException {
	private static final long serialVersionUID = 1L;
	public ServiceRecordManagerException(String string) {
		super(string);
	}
	public ServiceRecordManagerException(Message message) {
		super(message);
	}
	public ServiceRecordManagerException(List<Message> messageList) {
		super(messageList);
	}

}


