package com.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.bean.InvoiceItemExport;
import com.bean.OrderProduct;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;



public class GeneratePDF {
	
	public File generatePDF(OrderProduct invoice) {
		File pdf = new File("Invoice_"+invoice.getInvno()+".pdf");
		Document doc = new Document();
		try {
			PdfWriter docWriter =PdfWriter.getInstance(doc , new FileOutputStream("Invoice_"+invoice.getInvno()+".pdf"));
			doc.open();
			Paragraph para = new Paragraph("Invoice Number : "+invoice.getInvno());
			doc.add(para);
			para = new Paragraph("Invoice Date : "+ new Date());
			doc.add(para);
			para = new Paragraph("Customer Name : " + invoice.getName());
			doc.add(para);
			para = new Paragraph("");
			doc.add(para);
			Set<InvoiceItemExport> items = new HashSet<InvoiceItemExport>();
			items=invoice.getOrders();
			Iterator<InvoiceItemExport> iter = items.iterator();
			PdfPTable table = new PdfPTable(new float[]{2f, 2f, 2f, 2f, 2f, 2f});
			table.addCell("Item name");
			table.addCell("Unit");
			table.addCell("Price");
			table.addCell("Quantity");
			table.addCell("Total");
			while(iter.hasNext()) {
				InvoiceItemExport item=iter.next();
				table.addCell(item.getItem().getItemdesc());
				table.addCell(item.getItem().getUnit());
				table.addCell(item.getItem().getPrice()+"");
				table.addCell(item.getQuantity()+"");
				table.addCell(item.getTotal()+"");
			}
			doc.add(table);
			para = new Paragraph("Total : " + invoice.getTotal());
			doc.add(para);
			doc.close();
			docWriter.close();
			System.out.println("PDF Generated at "+pdf.getAbsolutePath());
		}catch(Exception e) {e.printStackTrace();}
		return pdf;
		
	}
}
