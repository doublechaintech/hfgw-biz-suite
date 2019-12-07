package  com.doublechaintech.hfgw.changerequest;

import java.util.Arrays;
import com.doublechaintech.hfgw.changerequest.ChangeRequest;
import com.doublechaintech.hfgw.chaincodeinvoker.ChainCodeInvoker;
import com.doublechaintech.hfgw.HfgwUserContext;

public class ChainCodeInvokerProcessor extends ChangeRequestChainProcessor{
	
	
	protected void processInternal(HfgwUserContext userContext, ChangeRequest request, String beanName){
		request.getChainCodeInvokerList().forEach(event->{
			
			handleSingleEvent(userContext,request,event);
		});
	}
	protected void handleSingleEvent(HfgwUserContext userContext, ChangeRequest request, ChainCodeInvoker event ){
		
		userContext.log("ChainCodeInvokerProcessor\t"+ event +" from processor");
		
		/*
		try {
				Account a1 = accountManagerOf(userContext)
						.loadAccount(userContext, event.getAccount().getId(), new String[] {});
				a1.updateName(event.getName());
				accountManagerOf(userContext).internalSaveAccount(userContext, a1);
		} catch (Exception e) {
				
				e.printStackTrace();
		}*/
	}
	
}


