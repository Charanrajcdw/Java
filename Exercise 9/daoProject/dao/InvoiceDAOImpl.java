package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import db.DBUtility;
import dto.InvoiceDTO;

public class InvoiceDAOImpl extends InvoiceDAO implements Cloneable {
	private static InvoiceDAOImpl invoicedao;

	private InvoiceDAOImpl() {
	}

	public static InvoiceDAOImpl getInvoiceDAOImpl() {
		if (invoicedao == null) {
			invoicedao = new InvoiceDAOImpl();
			return invoicedao;
		} else {
			return invoicedao.createClone();
		}
	}

	private InvoiceDAOImpl createClone() {
		if (invoicedao != null) {
			try {
				return (InvoiceDAOImpl) super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public InvoiceDTO findByInvoiceNo(int invoiceNo) {
		try {
			Connection conn = DBUtility.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from invoice_master where invoiceNo=?");
			ps.setInt(1, invoiceNo);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				InvoiceDTO invoicedto = new InvoiceDTO();
				invoicedto.setInvoiceNo(invoiceNo);
				invoicedto.setDate(rs.getDate("date"));
				invoicedto.setCustomerID(rs.getInt("customerID"));
				return invoicedto;
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
	public Collection<InvoiceDTO> findAll() {
		try {
			Connection conn = DBUtility.getConnection();
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select * from invoice_master");
			List<InvoiceDTO> invoices = new ArrayList<InvoiceDTO>();
			while (rs.next()) {
				InvoiceDTO invoicedto = new InvoiceDTO();
				invoicedto.setInvoiceNo(rs.getInt("invoiceNo"));
				invoicedto.setDate(rs.getDate("date"));
				invoicedto.setCustomerID(rs.getInt("customerID"));
				invoices.add(invoicedto);
			}
			return invoices;
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public int updateInvoice(InvoiceDTO invoicedto) {
		try {
			Connection conn = DBUtility.getConnection();
			int invoiceNo = invoicedto.getInvoiceNo();
			PreparedStatement ps = conn.prepareStatement("select * from invoice_master where invoiceNo=?");
			ps.setInt(1, invoiceNo);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ps = conn.prepareStatement("update invoice_master set customerID=?,date=? where invoiceNo=?");
				ps.setInt(1, invoicedto.getCustomerID());
				ps.setDate(2, invoicedto.getDate());
				ps.setInt(3, invoicedto.getInvoiceNo());
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
	public int deleteItemByInvoiceNo(int invoiceNo) {
		try {
			Connection conn = DBUtility.getConnection();
			PreparedStatement ps = conn.prepareStatement("delete from invoice_master where invoiceNo=?");
			ps.setInt(1, invoiceNo);
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
