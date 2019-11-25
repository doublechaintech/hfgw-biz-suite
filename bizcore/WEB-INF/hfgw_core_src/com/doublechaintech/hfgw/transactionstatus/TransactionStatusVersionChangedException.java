
package com.doublechaintech.hfgw.transactionstatus;
import com.doublechaintech.hfgw.EntityNotFoundException;

public class TransactionStatusVersionChangedException extends TransactionStatusManagerException {
	private static final long serialVersionUID = 1L;
	public TransactionStatusVersionChangedException(String string) {
		super(string);
	}


}


