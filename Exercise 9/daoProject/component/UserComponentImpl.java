package component;

import dao.UserDAO;
import dao.UserDAOImpl;
import dto.UserDTO;

public class UserComponentImpl implements UserComponent, Cloneable {
	private static UserComponentImpl userComponentImpl;

	private UserComponentImpl() {
	}

	public static UserComponentImpl getUserComponentImpl() {
		if (userComponentImpl == null) {
			userComponentImpl = new UserComponentImpl();
			return userComponentImpl;
		} else
			return userComponentImpl.createClone();
	}

	private UserComponentImpl createClone() {
		if (userComponentImpl != null) {
			try {
				return (UserComponentImpl) super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public boolean checkUser(String userName, String userPass) {
		UserDAO userdao = UserDAOImpl.getUserDAOImpl();
		UserDTO userdto = userdao.findByName(userName);
		if (userdto != null)
			if (userdto.getUserPass().equals(userPass))
				return true;
		return false;
	}

	@Override
	public boolean checkFlag(String userName) {
		UserDAO userdao = UserDAOImpl.getUserDAOImpl();
		UserDTO userdto = userdao.findByName(userName);
		if (userdto != null)
			if (userdto.getFlag() == 0)
				return true;
		return false;
	}

	@Override
	public int updateFlag(String userName, int flag) {
		UserDAO userdao = UserDAOImpl.getUserDAOImpl();
		UserDTO userdto = userdao.findByName(userName);
		if (userdto != null) {
			userdto.setFlag(flag);
			int n = userdao.updateUser(userdto);
			return n;
		} else
			return 0;
	}
}
