
/*
	本类暂时没有很复杂的代码，这个类用于保留以后智能化推断代码
*/

package  com.doublechaintech.hfgw.changerequest;


import com.doublechaintech.hfgw.changerequest.ChangeRequest;
import com.doublechaintech.hfgw.HfgwUserContext;

public class CertUpdaterHandler extends ChangeRequestBaseHandler{
	@Override	
	protected void checkIfComplyWithSpec(HfgwUserContext userContext, ChangeRequest request){
		super.checkIfComplyWithSpec(userContext,request);
	}
}

