package dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class InvoiceDTO implements Serializable, Comparable<InvoiceDTO> {
	private Integer invoiceNo, customerID;
	private Date date;

	public InvoiceDTO() {
	}

	public InvoiceDTO(int invoiceNo, int customerID, Date date) {
		this.invoiceNo = invoiceNo;
		this.customerID = customerID;
		this.date = date;
	}

	public int getInvoiceNo() {
		return invoiceNo;
	}

	public int getCustomerID() {
		return customerID;
	}

	public Date getDate() {
		return date;
	}

	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int compareTo(InvoiceDTO o) {
		return invoiceNo.compareTo(o.customerID);
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerID, date, invoiceNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceDTO other = (InvoiceDTO) obj;
		return Objects.equals(customerID, other.customerID) && Objects.equals(date, other.date)
				&& Objects.equals(invoiceNo, other.invoiceNo);
	}

	@Override
	public String toString() {
		return "invoiceDTO [invoiceNo=" + invoiceNo + ", customerID=" + customerID + ", date=" + date + "]";
	}
}
