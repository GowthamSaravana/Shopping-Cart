package com.service;

import java.util.List;
import com.model.Invoice;
import com.model.InvoiceTransaction;
import com.model.Item;

public interface InvoiceTransactionService {

	InvoiceTransaction findByItemNo(Item itemno);
    
    void saveInvoiceTransaction(InvoiceTransaction InvoiceTransaction);
     
    void updateInvoiceTransaction(InvoiceTransaction InvoiceTransaction);
     
    //void deleteEmployeeBySsn(String ssn);
 
    List<InvoiceTransaction> findAllTransactions(); 
     
    InvoiceTransaction  findItembyInvoiceNo(int inv_no);
}
