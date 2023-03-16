package action;

import service.LoginService;
import service.LoginServiceImpl;

public class LoginActionImpl extends LoginAction {
	@Override
	public String execute(String userName, String userPass) {
		LoginService loginservice = LoginServiceImpl.getLoginServiceImpl();
		String result = loginservice.login(userName, userPass);
		return result;
	}
}
