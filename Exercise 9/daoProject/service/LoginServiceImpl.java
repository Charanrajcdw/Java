package service;

import component.UserComponent;
import component.UserComponentImpl;

public class LoginServiceImpl implements LoginService, Cloneable {
	private static LoginServiceImpl loginServiceImpl;

	private LoginServiceImpl() {
	}

	public static LoginServiceImpl getLoginServiceImpl() {
		if (loginServiceImpl == null) {
			loginServiceImpl = new LoginServiceImpl();
			return loginServiceImpl;
		} else
			return loginServiceImpl.createClone();
	}

	private LoginServiceImpl createClone() {
		if (loginServiceImpl != null) {
			try {
				return (LoginServiceImpl) super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public String login(String userName, String userPass) {
		UserComponent user = UserComponentImpl.getUserComponentImpl();
		if (user.checkUser(userName, userPass)) {
			if (user.checkFlag(userName)) {
				user.updateFlag(userName, 1);
				return "Welcome";
			} else {
				return "Already logged in";
			}
		} else {
			return "Signup";
		}
	}
}
