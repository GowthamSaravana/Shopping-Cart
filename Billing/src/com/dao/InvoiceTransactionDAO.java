package com.dao;

import java.util.List;

import com.model.Invoice;
import com.model.InvoiceTransaction;
import com.model.Item;

public interface InvoiceTransactionDAO {

	InvoiceTransaction findByInvocieId(int invno);
	 
    void saveInvoicetransaction(InvoiceTransaction invoicetransaction);
     
    List<InvoiceTransaction> findAllTransaction();
    
    InvoiceTransaction findbyitem(Item item);
}
