
package com.doublechaintech.hfgw.objectaccess;
import com.doublechaintech.hfgw.EntityNotFoundException;

public class ObjectAccessVersionChangedException extends ObjectAccessManagerException {
	private static final long serialVersionUID = 1L;
	public ObjectAccessVersionChangedException(String string) {
		super(string);
	}


}


