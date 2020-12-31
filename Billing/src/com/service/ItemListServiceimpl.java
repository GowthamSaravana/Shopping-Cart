package com.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.DateInvoice;
import com.bean.InvoiceItemExport;
import com.bean.Order;
import com.bean.OrderProduct;
import com.bean.SingleDateInvoice;
import com.dao.InvoiceDAO;
import com.dao.InvoiceTransactionDAO;
import com.model.Customer;
import com.model.Invoice;
import com.model.InvoiceTransaction;
import com.model.Item;
@Service("itemlistService")
@Transactional
public class ItemListServiceimpl implements ItemListService{
	@Autowired
	InvoiceTransactionDAO invtransdao ;
	
	@Autowired
	InvoiceDAO invmasterdao;
	@Autowired
	CustomerService cs;
	@Autowired
	ItemService is;
	@Autowired
	ItemService itemmasterdao;
	@Override
	
	//This is for adding in cart
	public OrderProduct add(Order orders, int invno,String uname,String upass) {
		
		OrderProduct products=new OrderProduct();
		products.setInvno(invno);
		products.setName(uname);
		products.setOrders(create(orders));
		products=save(invno,products,uname,upass);
		return products;
		
	}
	@Override
	public Set<InvoiceItemExport> create(Order orders) {
		Set<InvoiceItemExport> order=new HashSet<InvoiceItemExport>();
		for(int i=0;i<orders.getItemno().length;i++) {
			if(orders.getQuantity()[i]>0) {
			InvoiceItemExport iteme=new InvoiceItemExport();
			iteme.setQuantity(orders.getQuantity()[i]);
		
			Item item=is.findById(orders.getItemno()[i]);
			iteme.setItem(item);
			iteme.setTotal(item.getPrice()*orders.getQuantity()[i]);
			order.add(iteme);
			  }
			}
		return order;
	}
	@Override
	public OrderProduct save(int invno,OrderProduct order,String uname,String upass) {
		float total = 0;
			Invoice invoice=new Invoice();
			Customer c=cs.findCustomerByname(uname, upass);
			invoice.setCustomer_id(c);
			LocalDate date=LocalDate.now();
			
			
			Date dateval=java.sql.Date.valueOf(date);
			invoice.setInvoice_date(dateval);
			Set<InvoiceTransaction> inv_transset = new HashSet<InvoiceTransaction>();
			invoice.setInv_tran(inv_transset);
			 invmasterdao.saveInvoice(invoice);
		
			invoice.setInvoice_number(invno);
			Set<InvoiceItemExport> cartitems = order.getOrders();
			Iterator<InvoiceItemExport> iter = cartitems.iterator();
			while(iter.hasNext()) {
				InvoiceItemExport item_inv_tran = iter.next();
				InvoiceTransaction invt = new InvoiceTransaction();
				invt.setItem_number(item_inv_tran.getItem());
				invt.setQuantity(item_inv_tran.getQuantity());
				total = total + (item_inv_tran.getTotal());
				System.out.println("total = " + total);
				invt.setInvoice_number(invoice);
				invtransdao.saveInvoicetransaction(invt);
				inv_transset.add(invt);
			}
			invoice.setInv_tran(inv_transset);
		
			order.setTotal(total);
		return order;
	}
	@Override
	public DateInvoice save(DateInvoice in) {
		DateInvoice date=new DateInvoice();
		date.setInvoicestart(in.getInvoicestart());
		date.setInvoiceend(in.getInvoiceend());
		return date;
	}
	@Override
	public SingleDateInvoice save(SingleDateInvoice date) {
		SingleDateInvoice invoice=new SingleDateInvoice();
		invoice.setDatevalue(date.getDatevalue());
		return invoice;
	}
	
	
	

}
