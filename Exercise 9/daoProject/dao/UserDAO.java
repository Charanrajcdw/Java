package dao;

import java.util.Collection;
import dto.UserDTO;

abstract public class UserDAO {
	public abstract UserDTO findByID(int userID);
	public abstract UserDTO findByName(String userName);
	public abstract Collection<UserDTO> findAll();
	public abstract int updateUser(UserDTO userdto);
	public abstract int deleteUserByID(int userID);
	public abstract int deleteUserByName(String userName);
}
