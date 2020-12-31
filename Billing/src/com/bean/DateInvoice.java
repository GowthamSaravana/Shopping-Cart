package com.bean;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.NotNull;

public class DateInvoice {

	@NotNull
	private String invoicestart;
	@NotNull
	private String invoiceend;
	public String getInvoicestart() {
		return invoicestart;
	}
	public void setInvoicestart(String invoicestart) {
		this.invoicestart = invoicestart;
	}
	public String getInvoiceend() {
		return invoiceend;
	}
	public void setInvoiceend(String invoiceend) {
		this.invoiceend = invoiceend;
	}
	
	

	
	
}
