package dto;

import java.io.Serializable;
import java.util.Objects;

public class CustomerDTO implements Serializable, Comparable<CustomerDTO> {
	private Integer customerID;
	private String customerName, customerAddress;

	public CustomerDTO() {
	}

	public CustomerDTO(Integer customerID, String customerName, String customerAddress) {
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Override
	public int compareTo(CustomerDTO o) {
		return customerID.compareTo(o.customerID);
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerAddress, customerID, customerName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDTO other = (CustomerDTO) obj;
		return Objects.equals(customerAddress, other.customerAddress) && Objects.equals(customerID, other.customerID)
				&& Objects.equals(customerName, other.customerName);
	}

	@Override
	public String toString() {
		return "customerDTO [customerID=" + customerID + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + "]";
	}
}
