package com.dao;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.model.Customer;
import com.model.Invoice;

public interface InvoiceDAO {

	Invoice findById(int inv_no);
	
	int max();
	 
    void saveInvoice(Invoice invoice);
    List<Invoice> getAllInvoicesBetweenTwoDates(Date from, Date till);
     
    List<Invoice> findAllInvoice();
    List<Invoice> findAbyDate(Date date);
    
 
}
