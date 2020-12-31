package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.DateInvoice;
import com.bean.OrderProduct;
import com.bean.SingleDateInvoice;
import com.model.Customer;
import com.model.Invoice;
import com.model.Item;
import com.model.LoginForm;
import com.service.CustomerService;
import com.service.InvoiceService;
import com.service.ItemListService;
import com.service.ItemService;

@Controller
public class GenerateController {
	
	 @Autowired
	   MessageSource messageSource;
	 
	private CustomerService cs;
	@Autowired(required=true)
	@Qualifier(value="customerService")
	public void setCs(CustomerService cs) {
		this.cs = cs;
	}
	
	private InvoiceService is;
	@Autowired(required=true)
	@Qualifier(value="invoiceService")
	public void setIs(InvoiceService is) {
		this.is = is;
	}
	private ItemService item;
	@Autowired(required=true)
	@Qualifier(value="itemService")
	public void setItem(ItemService item) {
		this.item = item;
	}
	
	private ItemListService ils;
	@Autowired(required=true)
	@Qualifier(value="itemlistService")
	public void setIls(ItemListService ils) {
		this.ils = ils;
	}
	
	@RequestMapping(value="/generatePDF" , method = RequestMethod.GET)
	public String done(HttpSession session,HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		OrderProduct order=(OrderProduct)session.getAttribute("orders");
		GeneratePDF pdfGenerator = new GeneratePDF();
		File invoicePDF = pdfGenerator.generatePDF(order);
		response.setContentType("APPLICATION/OCTET-STREAM");
		try {
		PrintWriter out = response.getWriter();
        response.setHeader("Content-Disposition", "attachment; filename=\"" + invoicePDF.getName() + "\"");
        FileInputStream fl = new FileInputStream(invoicePDF);
        int i;
        while ((i = fl.read()) != -1) {
            out.write(i);
        }
        fl.close();
        out.close();
        invoicePDF.delete();
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/itemlistuser";
	}

	@RequestMapping(value = "/generateall" ,method = RequestMethod.GET)
	public String generatereport(HttpServletRequest request, HttpServletResponse response) {
		File CustomerReport = new File("InvoiceReport.xls");
		List<Invoice> invoice= is.findAllInvoice();
		try {
			HSSFWorkbook workbook = new HSSFWorkbook();   
			HSSFSheet sheet = workbook.createSheet("CustomerReport");   
			HSSFRow rowhead = sheet.createRow((short)0);  
			rowhead.createCell(0).setCellValue("Invoice Number");  
			rowhead.createCell(1).setCellValue("Invoice Date");  
			rowhead.createCell(2).setCellValue("Customer Name");  
			rowhead.createCell(3).setCellValue("Customer Address"); 
			int val=0;
			for(Invoice in:invoice) {
				 rowhead = sheet.createRow((short)(val+1));
				rowhead.createCell(0).setCellValue(in.getInvoice_number());  
				rowhead.createCell(1).setCellValue(in.getInvoice_date().toLocaleString()); 
				Customer c=cs.findById(in.getCustomer_id().getId());
				rowhead.createCell(2).setCellValue(c.getUname().toString());  
				rowhead.createCell(3).setCellValue(c.getAddress());  
				val++;
			}
			FileOutputStream fileOut = new FileOutputStream("InvoiceReport.xls");   
			workbook.write(fileOut); 
			workbook.close();
			fileOut.close();
			response.setContentType("APPLICATION/OCTET-STREAM");
			try {
		        PrintWriter out = response.getWriter();
		        response.setHeader("Content-Disposition", "attachment; filename=\"" + CustomerReport.getName() + "\"");
		        FileInputStream fl = new FileInputStream(CustomerReport);
		        int i;
		        while ((i = fl.read()) != -1) {
		            out.write(i);
		        }
		        fl.close();
		        out.close();
		        CustomerReport.delete();
		        
			}catch(Exception e) {e.printStackTrace();}
		}catch(Exception e) {e.printStackTrace();} 
		return "redirect:/itemlist";
	}
	@RequestMapping(value = "/generatedate")
	public String generatereportdate(@Valid DateInvoice date,BindingResult result,HttpSession session,HttpServletRequest request, HttpServletResponse response) {
		if(result.hasErrors()) {
			return "redirect:/itemlist";
		}
		DateInvoice ind=ils.save(date);
		String error=null;
		String date1=ind.getInvoicestart();
		//System.out.println(date.getInvoicestart());
		String date2=ind.getInvoiceend();
		System.out.println(date1+"  "+date2);
		Date from=null,till=null;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	      try {
	      from = (Date) format.parse(date1);
		     till = (Date) format.parse(date2);
	      }
	      catch(Exception e) {
	    	  
	      }
		System.out.println(from+"   "+till);
		List<Invoice> invoice= is.findAllbyDate(from, till);
		if(invoice!=null) {
		try {
			File CustomerReport = new File("DateReport.xls");
			session.setAttribute("error", error);
			HSSFWorkbook workbook = new HSSFWorkbook();   
			HSSFSheet sheet = workbook.createSheet("AllDateReport");   
			HSSFRow rowhead = sheet.createRow((short)0);  
			rowhead.createCell(0).setCellValue("Invoice Number");  
			rowhead.createCell(1).setCellValue("Invoice Date");  
			rowhead.createCell(2).setCellValue("Customer Name");  
			rowhead.createCell(3).setCellValue("Customer Address"); 
			int val=0;
			for(Invoice in:invoice) {
				 rowhead = sheet.createRow((short)(val+1));
				rowhead.createCell(0).setCellValue(in.getInvoice_number());  
				rowhead.createCell(1).setCellValue(in.getInvoice_date().toLocaleString()); 
				Customer c=cs.findById(in.getCustomer_id().getId());
				rowhead.createCell(2).setCellValue(c.getUname().toString());  
				rowhead.createCell(3).setCellValue(c.getAddress());  
				val++;
			}
			FileOutputStream fileOut = new FileOutputStream("DateReport.xls");   
			workbook.write(fileOut); 
			workbook.close();
			fileOut.close();
			response.setContentType("APPLICATION/OCTET-STREAM");
			try {
		        PrintWriter out = response.getWriter();
		        response.setHeader("Content-Disposition", "attachment; filename=\"" + CustomerReport.getName() + "\"");
		        FileInputStream fl = new FileInputStream(CustomerReport);
		        int i;
		        while ((i = fl.read()) != -1) {
		            out.write(i);
		        }
		        fl.close();
		        out.close();
		        CustomerReport.delete();
		        
			}catch(Exception e) {e.printStackTrace();}
		}catch(Exception e) {e.printStackTrace();} 
		
		}
		else {
			error="errrrr";
			
	
		}
		session.setAttribute("errorvalue", error);
		return "redirect:/itemlist";
		
	}
	@RequestMapping(value = "/generatesingledate")
	public String generatesingle(@Valid SingleDateInvoice date,BindingResult result,HttpSession session,HttpServletRequest request, HttpServletResponse response) {
		if(result.hasErrors()) {
			return "redirect:/itemlist";
		}
		SingleDateInvoice single=ils.save(date);
		String date1=single.getDatevalue();
		String error=null;
		System.out.println(date1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Date dateval=null;
		//DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate dt =LocalDate.parse(date1, formatter);
	      try {
	    	  
	    	  dateval=java.sql.Date.valueOf(dt);
	      }
	      catch(Exception e) {
	    	  
	      }
	      System.out.println(dateval);
		List<Invoice> invoice= is.findbyDate(dateval);
		if(invoice!=null) {
		try {
			File CustomerReport = new File("SingledateReport.xls");
			session.setAttribute("error", error);
			HSSFWorkbook workbook = new HSSFWorkbook();   
			HSSFSheet sheet = workbook.createSheet("DateReport");   
			HSSFRow rowhead = sheet.createRow((short)0);  
			rowhead.createCell(0).setCellValue("Invoice Number");  
			rowhead.createCell(1).setCellValue("Invoice Date");  
			rowhead.createCell(2).setCellValue("Customer Name");  
			rowhead.createCell(3).setCellValue("Customer Address"); 
			int val=0;
			for(Invoice in:invoice) {
				 rowhead = sheet.createRow((short)(val+1));
				rowhead.createCell(0).setCellValue(in.getInvoice_number());  
				rowhead.createCell(1).setCellValue(in.getInvoice_date().toLocaleString()); 
				Customer c=cs.findById(in.getCustomer_id().getId());
				rowhead.createCell(2).setCellValue(c.getUname().toString());  
				rowhead.createCell(3).setCellValue(c.getAddress());  
				val++;
			}
			FileOutputStream fileOut = new FileOutputStream("SingledateReport.xls");   
			workbook.write(fileOut); 
			workbook.close();
			fileOut.close();
			response.setContentType("APPLICATION/OCTET-STREAM");
			try {
		        PrintWriter out = response.getWriter();
		        response.setHeader("Content-Disposition", "attachment; filename=\"" + CustomerReport.getName() + "\"");
		        FileInputStream fl = new FileInputStream(CustomerReport);
		        int i;
		        while ((i = fl.read()) != -1) {
		            out.write(i);
		        }
		        fl.close();
		        out.close();
		        CustomerReport.delete();
		        
			}catch(Exception e) {e.printStackTrace();}
		}catch(Exception e) {e.printStackTrace();} 
		
		}
		else {
			error="errrrr";
			
	
		}
		session.setAttribute("errorvalue", error);
		return "redirect:/itemlist";
		
	}

}
