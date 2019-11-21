
package com.doublechaintech.hfgw.organization;
//import com.doublechaintech.hfgw.EntityNotFoundException;
import com.doublechaintech.hfgw.HfgwException;
import com.doublechaintech.hfgw.Message;
import java.util.List;

public class OrganizationManagerException extends HfgwException {
	private static final long serialVersionUID = 1L;
	public OrganizationManagerException(String string) {
		super(string);
	}
	public OrganizationManagerException(Message message) {
		super(message);
	}
	public OrganizationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


