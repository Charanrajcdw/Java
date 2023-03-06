package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import db.DBUtility;
import dto.TransactionDTO;

public class TransactionDAOImpl extends TransactionDAO implements Cloneable {
	private static TransactionDAOImpl transactiondao;

	private TransactionDAOImpl() {
	}

	public static TransactionDAOImpl getItemDAOImpl() {
		if (transactiondao == null) {
			transactiondao = new TransactionDAOImpl();
			return transactiondao;
		} else {
			return transactiondao.createClone();
		}
	}

	private TransactionDAOImpl createClone() {
		if (transactiondao != null) {
			try {
				return (TransactionDAOImpl) super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public TransactionDTO findTransaction(int invoiceNo, int itemNo) {
		try {
			Connection conn = DBUtility.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from invoice_trans where invoiceNo=? and itemNo=?");
			ps.setInt(1, invoiceNo);
			ps.setInt(2, itemNo);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				TransactionDTO transactiondto = new TransactionDTO();
				transactiondto.setInvoiceNo(invoiceNo);
				transactiondto.setItemNo(itemNo);
				transactiondto.setItemQuantity(rs.getInt("itemQuantity"));
				return transactiondto;
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
	public Collection<TransactionDTO> findAll() {
		try {
			Connection conn = DBUtility.getConnection();
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select * from invoice_trans");
			List<TransactionDTO> transactions = new ArrayList<TransactionDTO>();
			while (rs.next()) {
				TransactionDTO transactiondto = new TransactionDTO();
				transactiondto.setInvoiceNo(rs.getInt("invoiceNo"));
				transactiondto.setItemNo(rs.getInt("itemNo"));
				transactiondto.setItemQuantity(rs.getInt("itemQuantity"));
				transactions.add(transactiondto);
			}
			return transactions;
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public int updateTransaction(TransactionDTO transactiondto) {
		try {
			Connection conn = DBUtility.getConnection();
			int itemNo = transactiondto.getItemNo();
			int invoiceNo = transactiondto.getInvoiceNo();
			PreparedStatement ps = conn.prepareStatement("select * from invoice_trans where invoiceNo=? and itemNo=?");
			ps.setInt(1, invoiceNo);
			ps.setInt(2, itemNo);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ps = conn.prepareStatement("update invoice_trans set itemQuantity=? where invoiceNo=? and itemNo=?");
				ps.setInt(1, transactiondto.getItemQuantity());
				ps.setInt(2, transactiondto.getInvoiceNo());
				ps.setInt(3, transactiondto.getItemNo());
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
	public int deleteTransaction(int invoiceNo, int itemNo) {
		try {
			Connection conn = DBUtility.getConnection();
			PreparedStatement ps = conn.prepareStatement("delete from item_master where invoiceNo=? and itemNo=?");
			ps.setInt(1, invoiceNo);
			ps.setInt(2, itemNo);
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
