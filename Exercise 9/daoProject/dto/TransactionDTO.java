package dto;

import java.io.Serializable;
import java.util.Objects;

public class TransactionDTO implements Serializable, Comparable<TransactionDTO> {
	private Integer invoiceNo;
	private int itemNo, itemQuantity;

	public TransactionDTO() {
	}

	public TransactionDTO(Integer invoiceNo, int itemNo, int itemQuantity) {
		this.invoiceNo = invoiceNo;
		this.itemNo = itemNo;
		this.itemQuantity = itemQuantity;
	}

	public Integer getInvoiceNo() {
		return invoiceNo;
	}

	public int getItemNo() {
		return itemNo;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setInvoiceNo(Integer invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	@Override
	public int compareTo(TransactionDTO o) {
		return invoiceNo.compareTo(o.invoiceNo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(invoiceNo, itemNo, itemQuantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionDTO other = (TransactionDTO) obj;
		return Objects.equals(invoiceNo, other.invoiceNo) && itemNo == other.itemNo
				&& itemQuantity == other.itemQuantity;
	}

	@Override
	public String toString() {
		return "transactionDTO [invoiceNo=" + invoiceNo + ", itemNo=" + itemNo + ", itemQuantity=" + itemQuantity + "]";
	}
}
