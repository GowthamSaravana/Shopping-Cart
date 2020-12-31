package com.bean;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import com.model.Item;

public class OrderProduct {

	private float total;
	private Set<InvoiceItemExport> orders;
	private int invno;
	private String name;
	
	
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<InvoiceItemExport> getOrders() {
		return orders;
	}
	public void setOrders(Set<InvoiceItemExport> orders) {
		this.orders = orders;
	}
	public int getInvno() {
		return invno;
	}
	public void setInvno(int invno) {
		this.invno = invno;
	}
	
    


	


	


	
    
}
