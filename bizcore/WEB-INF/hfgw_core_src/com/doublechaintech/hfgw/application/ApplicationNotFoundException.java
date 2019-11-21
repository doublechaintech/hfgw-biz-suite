
package com.doublechaintech.hfgw.application;
import com.doublechaintech.hfgw.EntityNotFoundException;
public class ApplicationNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public ApplicationNotFoundException(String string) {
		super(string);
	}

}

