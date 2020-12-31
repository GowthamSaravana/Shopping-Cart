package com.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.InvoiceDAO;
import com.model.Customer;
import com.model.Invoice;


@Service("invoiceService")
@Transactional
public class InvoiceServiceImpl implements InvoiceService{

	@Autowired
	private InvoiceDAO dao;
	@Override
	public Invoice findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveInvoice(Invoice invoice) {
		dao.saveInvoice(invoice);
		
	}

	@Override
	public void updateInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Invoice> findAllInvoice() {
		// TODO Auto-generated method stub
		return dao.findAllInvoice();
	}

	@Override
	public Invoice findInvoicebyCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int max() {
		return dao.max();
	}

	@Override
	public List<Invoice> findAllbyDate(Date start,Date end) {
		return dao.getAllInvoicesBetweenTwoDates(start, end);
	}

	@Override
	public List<Invoice> findbyDate(Date start) {
		// TODO Auto-generated method stub
		return dao.findAbyDate(start);
	}

	
}
