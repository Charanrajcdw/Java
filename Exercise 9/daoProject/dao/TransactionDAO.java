package dao;

import java.util.Collection;
import dto.TransactionDTO;

abstract public class TransactionDAO {
	public abstract TransactionDTO findTransaction(int invoiceNo,int itemNo);
	public abstract Collection<TransactionDTO> findAll();
	public abstract int updateTransaction(TransactionDTO transactiondto);
	public abstract int deleteTransaction(int invoiceNo,int itemNo);
}
