
package com.doublechaintech.hfgw.transactionstatus;
//import com.doublechaintech.hfgw.EntityNotFoundException;
import com.doublechaintech.hfgw.HfgwException;
import com.doublechaintech.hfgw.Message;
import java.util.List;

public class TransactionStatusManagerException extends HfgwException {
	private static final long serialVersionUID = 1L;
	public TransactionStatusManagerException(String string) {
		super(string);
	}
	public TransactionStatusManagerException(Message message) {
		super(message);
	}
	public TransactionStatusManagerException(List<Message> messageList) {
		super(messageList);
	}

}


