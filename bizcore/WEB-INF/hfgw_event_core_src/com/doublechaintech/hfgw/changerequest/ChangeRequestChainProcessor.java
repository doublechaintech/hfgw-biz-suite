/*
	ChangeRequestBaseHandler 最基础的Handler，如果这些ChangeRequest都按照Event规则来处理，
	那么有这个ChangeRequestBaseHandler对于大多数系统就足够了。
*/
package  com.doublechaintech.hfgw.changerequest;
import java.util.Arrays;
import com.doublechaintech.hfgw.changerequest.ChangeRequest;
import com.doublechaintech.hfgw.HfgwUserContext;
import com.doublechaintech.hfgw.CustomHfgwCheckerManager;
public class ChangeRequestChainProcessor extends CustomHfgwCheckerManager{
	
	protected void preProcess(HfgwUserContext userContext, ChangeRequest request, String beanName){
		
	}
	public void process(HfgwUserContext userContext, ChangeRequest request, String beanName){
		preProcess(userContext, request, beanName);
		processInternal(userContext, request, beanName);
		postProcess(userContext, request, beanName);
	}
	protected void postProcess(HfgwUserContext userContext, ChangeRequest request, String beanName){
		
	}
	protected void processInternal(HfgwUserContext userContext, ChangeRequest request, String beanName){
		
	}
	
}




