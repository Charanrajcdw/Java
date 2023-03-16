package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import db.DBUtility;
import dto.CustomerDTO;

public class CustomerDAOImpl extends CustomerDAO implements Cloneable {
	private static CustomerDAOImpl customerdao;

	private CustomerDAOImpl() {
	}

	public static CustomerDAOImpl getCustomerDAOImpl() {
		if (customerdao == null) {
			customerdao = new CustomerDAOImpl();
			return customerdao;
		} else {
			return customerdao.createClone();
		}
	}

	private CustomerDAOImpl createClone() {
		if (customerdao != null) {
			try {
				return (CustomerDAOImpl) super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public CustomerDTO findByID(int customerID) {
		try {
			Connection conn = DBUtility.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from customer_master where customerID=?");
			ps.setInt(1, customerID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				CustomerDTO customerdto = new CustomerDTO();
				customerdto.setCustomerID(customerID);
				customerdto.setCustomerName(rs.getString("customerName"));
				customerdto.setCustomerAddress(rs.getString("customerAddress"));
				return customerdto;
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
	public CustomerDTO findByName(String customerName) {
		try {
			Connection conn = DBUtility.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from customer_master where customerName=?");
			ps.setString(1, customerName);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				CustomerDTO customerdto = new CustomerDTO();
				customerdto.setCustomerID(rs.getInt("customerID"));
				customerdto.setCustomerName(customerName);
				customerdto.setCustomerAddress(rs.getString("customerAddress"));
				return customerdto;
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
	public Collection<CustomerDTO> findAll() {
		try {
			Connection conn = DBUtility.getConnection();
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select * from customer_master");
			List<CustomerDTO> customers = new ArrayList<CustomerDTO>();
			while (rs.next()) {
				CustomerDTO customerdto = new CustomerDTO();
				customerdto.setCustomerID(rs.getInt("customerID"));
				customerdto.setCustomerName(rs.getString("customerName"));
				customerdto.setCustomerAddress(rs.getString("customerAddress"));
				customers.add(customerdto);
			}
			return customers;
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public int updateCustomer(CustomerDTO customerdto) {
		try {
			Connection conn = DBUtility.getConnection();
			int customerID = customerdto.getCustomerID();
			PreparedStatement ps = conn.prepareStatement("select * from customer_master where customerID=?");
			ps.setInt(1, customerID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ps = conn.prepareStatement(
						"update customer_master set customerName=?,customerAddress=? where customerID=?");
				ps.setString(1, customerdto.getCustomerName());
				ps.setString(2, customerdto.getCustomerAddress());
				ps.setInt(3, customerdto.getCustomerID());
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
	public int deleteCustomerByID(int customerID) {
		try {
			Connection conn = DBUtility.getConnection();
			PreparedStatement ps = conn.prepareStatement("delete from customer_master where customerID=?");
			ps.setInt(1, customerID);
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
	public int deleteCustomerByName(String customerName) {
		try {
			Connection conn = DBUtility.getConnection();
			PreparedStatement ps = conn.prepareStatement("delete from customer_master where customerName=?");
			ps.setString(1, customerName);
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
