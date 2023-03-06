package service;

import component.UserComponent;
import component.UserComponentImpl;

public class LogoutServiceImpl implements LogoutService, Cloneable {
	private static LogoutServiceImpl logoutServiceImpl;

	private LogoutServiceImpl() {
	}

	public static LogoutServiceImpl getLogoutServiceImpl() {
		if (logoutServiceImpl == null) {
			logoutServiceImpl = new LogoutServiceImpl();
			return logoutServiceImpl;
		} else
			return logoutServiceImpl.createClone();
	}

	private LogoutServiceImpl createClone() {
		if (logoutServiceImpl != null) {
			try {
				return (LogoutServiceImpl) super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public String logout(String userName) {
		UserComponent user = UserComponentImpl.getUserComponentImpl();
		if (user.checkFlag(userName)) {
			return "Not logged in";
		} else {
			user.updateFlag(userName, 0);
			return "Logged out";
		}
	}
}
