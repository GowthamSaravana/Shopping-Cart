package com.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="invoice_transaction")
@Table(name = "invoice_transaction")
public class InvoiceTransaction implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int row_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_number", nullable = false)
	private Invoice invoice_number;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "item_number", nullable = false)
	private Item item_number;
	
	@Column(name="quantity", nullable=false)
	private int quantity;
	
	
	public Invoice getInvoice_number() {
		return invoice_number;
	}
	public void setInvoice_number(Invoice invoice_number) {
		this.invoice_number = invoice_number;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Item getItem_number() {
		return item_number;
	}
	public void setItem_number(Item item_number) {
		this.item_number = item_number;
	}
	

	
	
}
