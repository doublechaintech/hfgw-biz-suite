
package com.doublechaintech.hfgw.userdomain;
import com.doublechaintech.hfgw.EntityNotFoundException;
public class UserDomainNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public UserDomainNotFoundException(String string) {
		super(string);
	}

}

