package component;

public interface UserComponent {
	public boolean checkUser(String userName, String userPass);
	public boolean checkFlag(String userName);
	public int updateFlag(String userName, int flag);
}
