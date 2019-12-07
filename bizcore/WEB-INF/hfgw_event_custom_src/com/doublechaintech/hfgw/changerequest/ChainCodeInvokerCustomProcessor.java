package  com.doublechaintech.hfgw.changerequest;

import java.util.Arrays;
import com.doublechaintech.hfgw.changerequest.ChangeRequest;
import com.doublechaintech.hfgw.chaincodeinvoker.ChainCodeInvoker;
import com.doublechaintech.hfgw.HfgwUserContext;

public class ChainCodeInvokerCustomProcessor extends ChainCodeInvokerProcessor{
	
	
	
	protected void handleSingleEvent(HfgwUserContext userContext, ChangeRequest request, ChainCodeInvoker event ){
		
		userContext.log("ChainCodeInvokerCustomProcessor\t"+ event +" from processor");
		
		
	}
	
}











