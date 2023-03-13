package dao;

import java.util.Collection;
import dto.CustomerDTO;

abstract public class CustomerDAO {
	public abstract CustomerDTO findByID(int customerID);
	public abstract CustomerDTO findByName(String customerName);
	public abstract Collection<CustomerDTO> findAll();
	public abstract int updateCustomer(CustomerDTO customerdto);
	public abstract int deleteCustomerByID(int customerID);
	public abstract int deleteCustomerByName(String customerName);
}
