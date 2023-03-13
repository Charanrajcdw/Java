package action;

import service.LogoutService;
import service.LogoutServiceImpl;

public class LogoutActionImpl extends LogoutAction {
	@Override
	public String execute(String userName) {
		LogoutService logoutservice = LogoutServiceImpl.getLogoutServiceImpl();
		String result = logoutservice.logout(userName);
		return result;
	}
}
