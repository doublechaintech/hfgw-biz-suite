
package com.doublechaintech.hfgw.servicerecord;
import com.doublechaintech.hfgw.EntityNotFoundException;

public class ServiceRecordVersionChangedException extends ServiceRecordManagerException {
	private static final long serialVersionUID = 1L;
	public ServiceRecordVersionChangedException(String string) {
		super(string);
	}


}


