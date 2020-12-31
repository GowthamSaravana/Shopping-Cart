package com.service;
import java.util.Set;

import com.bean.DateInvoice;
import com.bean.InvoiceItemExport;
import com.bean.Order;
import com.bean.OrderProduct;
import com.bean.SingleDateInvoice;

public interface ItemListService {
	OrderProduct save(int invno,OrderProduct invoiceParam,String uname,String upass);
	OrderProduct add(Order order,int invno,String uname,String upass);
	Set<InvoiceItemExport> create(Order order);
	DateInvoice save(DateInvoice in);
	SingleDateInvoice save(SingleDateInvoice date);
}
