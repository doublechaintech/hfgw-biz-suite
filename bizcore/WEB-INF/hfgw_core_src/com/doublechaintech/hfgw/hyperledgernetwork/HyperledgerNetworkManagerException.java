
package com.doublechaintech.hfgw.hyperledgernetwork;
//import com.doublechaintech.hfgw.EntityNotFoundException;
import com.doublechaintech.hfgw.HfgwException;
import com.doublechaintech.hfgw.Message;
import java.util.List;

public class HyperledgerNetworkManagerException extends HfgwException {
	private static final long serialVersionUID = 1L;
	public HyperledgerNetworkManagerException(String string) {
		super(string);
	}
	public HyperledgerNetworkManagerException(Message message) {
		super(message);
	}
	public HyperledgerNetworkManagerException(List<Message> messageList) {
		super(messageList);
	}

}


