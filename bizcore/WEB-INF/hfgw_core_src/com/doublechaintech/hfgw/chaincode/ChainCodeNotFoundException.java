
package com.doublechaintech.hfgw.chaincode;
import com.doublechaintech.hfgw.EntityNotFoundException;
public class ChainCodeNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public ChainCodeNotFoundException(String string) {
		super(string);
	}

}

