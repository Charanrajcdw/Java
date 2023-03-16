package dao;

import java.util.Collection;
import dto.InvoiceDTO;

abstract public class InvoiceDAO {
	public abstract InvoiceDTO findByInvoiceNo(int invoiceNo);
	public abstract Collection<InvoiceDTO> findAll();
	public abstract int updateInvoice(InvoiceDTO invoicedto);
	public abstract int deleteItemByInvoiceNo(int invoiceNo);
}
