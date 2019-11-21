
package com.doublechaintech.hfgw.application;
import com.doublechaintech.hfgw.EntityNotFoundException;

public class ApplicationVersionChangedException extends ApplicationManagerException {
	private static final long serialVersionUID = 1L;
	public ApplicationVersionChangedException(String string) {
		super(string);
	}


}


