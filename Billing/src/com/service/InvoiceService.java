package com.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.model.Customer;
import com.model.Invoice;

public interface InvoiceService {

	Invoice findById(int id);
    
    void saveInvoice(Invoice invoice);
     
    int max();
    void updateInvoice(Invoice invoice);
     
    //void deleteEmployeeBySsn(String ssn);
 
    List<Invoice> findAllInvoice(); 
    List<Invoice> findAllbyDate(Date start,Date end); 
    List<Invoice> findbyDate(Date start); 
    Invoice  findInvoicebyCustomer(Customer customer);
    
    
}
