
package com.doublechaintech.hfgw.candidateelement;
//import com.doublechaintech.hfgw.EntityNotFoundException;
import com.doublechaintech.hfgw.HfgwException;
import com.doublechaintech.hfgw.Message;
import java.util.List;

public class CandidateElementManagerException extends HfgwException {
	private static final long serialVersionUID = 1L;
	public CandidateElementManagerException(String string) {
		super(string);
	}
	public CandidateElementManagerException(Message message) {
		super(message);
	}
	public CandidateElementManagerException(List<Message> messageList) {
		super(messageList);
	}

}









