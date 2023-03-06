package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import dto.UserDTO;
import db.DBUtility;

public class UserDAOImpl extends UserDAO implements Cloneable {
	private static UserDAOImpl userdao;

	private UserDAOImpl() {
	}

	public static UserDAOImpl getUserDAOImpl() {
		if (userdao == null) {
			userdao = new UserDAOImpl();
			return userdao;
		} else {
			return userdao.createClone();
		}
	}

	private UserDAOImpl createClone() {
		if (userdao != null) {
			try {
				return (UserDAOImpl) super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public UserDTO findByID(int userID) {
		try {
			Connection conn = DBUtility.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from users_master where userID=?");
			ps.setInt(1, userID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				UserDTO userdto = new UserDTO();
				userdto.setAge(rs.getInt("age"));
				userdto.setFlag(rs.getInt("flag"));
				userdto.setUserID(userID);
				userdto.setUserName(rs.getString("userName"));
				userdto.setUserPass(rs.getString("userPass"));
				return userdto;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public UserDTO findByName(String userName) {
		try {
			Connection conn = DBUtility.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from users_master where userName=?");
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				UserDTO userdto = new UserDTO();
				userdto.setAge(rs.getInt("age"));
				userdto.setFlag(rs.getInt("flag"));
				userdto.setUserID(rs.getInt("userID"));
				userdto.setUserName(userName);
				userdto.setUserPass(rs.getString("userPass"));
				return userdto;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public Collection<UserDTO> findAll() {
		try {
			Connection conn = DBUtility.getConnection();
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select * from users_master");
			List<UserDTO> users = new ArrayList<UserDTO>();
			while (rs.next()) {
				UserDTO userdto = new UserDTO();
				userdto.setAge(rs.getInt("age"));
				userdto.setFlag(rs.getInt("flag"));
				userdto.setUserID(rs.getInt("userID"));
				userdto.setUserName(rs.getString("userName"));
				userdto.setUserPass(rs.getString("userPass"));
				users.add(userdto);
			}
			return users;
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public int updateUser(UserDTO userdto) {
		try {
			Connection conn = DBUtility.getConnection();
			int userID = userdto.getUserID();
			PreparedStatement ps = conn.prepareStatement("select * from users_master where userID=?");
			ps.setInt(1, userID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ps = conn.prepareStatement("update users_master set userName=?,userPass=?,age=?,flag=? where userID=?");
				ps.setString(1, userdto.getUserName());
				ps.setString(2, userdto.getUserPass());
				ps.setInt(3, userdto.getAge());
				ps.setInt(4, userdto.getFlag());
				ps.setInt(5, userdto.getUserID());
				int n = ps.executeUpdate();
				DBUtility.closeConnection(null);
				return n;
			} else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return 0;
		}
	}

	@Override
	public int deleteUserByID(int userID) {
		try {
			Connection conn = DBUtility.getConnection();
			PreparedStatement ps = conn.prepareStatement("delete from users_master where userID=?");
			ps.setInt(1, userID);
			int n = ps.executeUpdate();
			DBUtility.closeConnection(null);
			return n;
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return 0;
		}
	}

	@Override
	public int deleteUserByName(String userName) {
		try {
			Connection conn = DBUtility.getConnection();
			PreparedStatement ps = conn.prepareStatement("delete from users_master where userName=?");
			ps.setString(1, userName);
			int n = ps.executeUpdate();
			DBUtility.closeConnection(null);
			return n;
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return 0;
		}
	}
}
