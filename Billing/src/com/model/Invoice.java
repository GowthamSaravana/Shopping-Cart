package com.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@SuppressWarnings("serial")
@Entity(name = "invoice")
@Table(name="invoice")
public class Invoice implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="invoice_number" , nullable = false)
	private int invoice_number;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "invoice_number")
	private Set<InvoiceTransaction> inv_tran;
	
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer_id;
	
	@Column(name="invoice_date", nullable=false)
	private Date invoice_date;
	
	
	public int getInvoice_number() {
		return invoice_number;
	}
	public void setInvoice_number(int invoice_number) {
		this.invoice_number = invoice_number;
	}
	public Set<InvoiceTransaction> getInv_tran() {
		return inv_tran;
	}
	public void setInv_tran(Set<InvoiceTransaction> inv_tran) {
		this.inv_tran = inv_tran;
	}
	public Customer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Customer customer_id) {
		this.customer_id = customer_id;
	}
	public Date getInvoice_date() {
		return invoice_date;
	}
	public void setInvoice_date(Date invoice_date) {
		this.invoice_date = invoice_date;
	}
	

	
	
	
	
}
