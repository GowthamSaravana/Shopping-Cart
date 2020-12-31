package com.controller;

import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.joda.time.LocalDate;

import com.bean.InvoiceItemExport;
import com.bean.OrderProduct;

@SuppressWarnings("serial")
public class DisplayInvoice extends TagSupport{
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		HttpSession session = pageContext.getSession();
		OrderProduct cart=(OrderProduct)session.getAttribute("orders");
		String output = new String("");
		try {
			output = output + "<br>Invoice number : " + cart.getInvno();
			output = output + "<br>Customer Name : " + cart.getName();
			output = output + "<br>Invoice Date : " + new LocalDate();
			output = output + "<table class=\"table table-hover\">\r\n"
					+ "		<tr>\r\n"
					+ "			<th>Item Name</th>\r\n"
					+ "			<th>Item Unit</th>\r\n"
					+ "			<th>Item Price</th>\r\n"
					+ "			<th>Quantity</th>\r\n"
					+ "			<th>total</th>\r\n"
					+ "		</tr>";
			Set<InvoiceItemExport> items = cart.getOrders();
			Iterator<InvoiceItemExport> iter = items.iterator();
			while(iter.hasNext()) {
				InvoiceItemExport item = iter.next();
				output = output 
						+ "		<tr>\r\n"
						+ "			<th>"+item.getItem().getItemdesc()+"</th>\r\n"
						+ "			<th>"+item.getItem().getUnit()+"</th>\r\n"
						+ "			<th>"+item.getItem().getPrice()+"</th>\r\n"
						+ "			<th>"+item.getQuantity()+"</th>\r\n"
						+ "			<th>"+item.getTotal()+"</th>\r\n"
						+ "		</tr>";
			}
			output = output + "</table><br> Total : "+cart.getTotal();
			out.print(output);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

}
