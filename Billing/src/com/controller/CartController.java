package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.Order;
import com.bean.OrderProduct;
import com.service.InvoiceService;
import com.service.ItemListService;
import com.service.ItemService;
@Controller
public class CartController {
	@SuppressWarnings("unused")
	@Autowired
	private ItemService pm;
	@Autowired
	private InvoiceService is;
	@Autowired
	private ItemListService items;
	


	@RequestMapping(value = "/shopping", method = RequestMethod.POST)
	public String order(@ModelAttribute("cart") Order orders,HttpSession session) {
		int invno=is.max()+1;
		String uname=(String)session.getAttribute("uname");
		String upass=(String)session.getAttribute("upass");
		OrderProduct finalcart=items.add(orders, invno, uname, upass);
	
		session.setAttribute("orders", finalcart);
		System.out.println(finalcart);
		System.out.println(orders.getQuantity()[0]);
		return "cart";
		
	}
	
}

