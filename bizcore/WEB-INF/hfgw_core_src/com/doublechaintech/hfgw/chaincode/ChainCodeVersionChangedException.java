
package com.doublechaintech.hfgw.chaincode;
import com.doublechaintech.hfgw.EntityNotFoundException;

public class ChainCodeVersionChangedException extends ChainCodeManagerException {
	private static final long serialVersionUID = 1L;
	public ChainCodeVersionChangedException(String string) {
		super(string);
	}


}


