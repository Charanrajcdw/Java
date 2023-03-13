package dto;

import java.io.Serializable;
import java.util.Objects;

public class UserDTO implements Serializable, Comparable<UserDTO> {
	private Integer userID;
	private int age, flag;
	private String userName, userPass;

	public UserDTO() {
	}

	public UserDTO(int userID, int age, int flag, String userName, String userPass) {
		this.userID = userID;
		this.age = age;
		this.flag = flag;
		this.userName = userName;
		this.userPass = userPass;
	}

	public int getUserID() {
		return userID;
	}

	public int getAge() {
		return age;
	}

	public int getFlag() {
		return flag;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	@Override
	public int compareTo(UserDTO o) {
		return userID.compareTo(o.userID);
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, flag, userID, userName, userPass);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return age == other.age && flag == other.flag && userID == other.userID
				&& Objects.equals(userName, other.userName) && Objects.equals(userPass, other.userPass);
	}

	@Override
	public String toString() {
		return "UserDTO [userID=" + userID + ", age=" + age + ", flag=" + flag + ", userName=" + userName
				+ ", userPass=" + userPass + "]";
	}
}
