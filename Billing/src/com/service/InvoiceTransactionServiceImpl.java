package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.InvoiceTransactionDAO;
import com.model.Invoice;
import com.model.InvoiceTransaction;
import com.model.Item;

@Service("invoicetransactionService")
@Transactional
public class InvoiceTransactionServiceImpl implements InvoiceTransactionService{

	@Autowired
	private InvoiceTransactionDAO dao;
	
	@Override
	public InvoiceTransaction findByItemNo(Item itemno) {
		// TODO Auto-generated method stub
		return dao.findbyitem(itemno);
	}

	@Override
	public void saveInvoiceTransaction(InvoiceTransaction InvoiceTransaction) {
		dao.saveInvoicetransaction(InvoiceTransaction);
		
	}

	@Override
	public void updateInvoiceTransaction(InvoiceTransaction InvoiceTransaction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<InvoiceTransaction> findAllTransactions() {
		// TODO Auto-generated method stub
		return dao.findAllTransaction();
	}

	@Override
	public InvoiceTransaction findItembyInvoiceNo(int inv_no) {
		// TODO Auto-generated method stub
		return dao.findByInvocieId(inv_no);
	}

}
