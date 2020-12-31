package com.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bean.DateInvoice;
import com.bean.Order;
import com.bean.SingleDateInvoice;
import com.model.Customer;
import com.model.Item;
import com.model.LoginForm;
import com.service.CustomerService;
import com.service.ItemService;

@RequestMapping("/")
@Controller
public class CustomerController {
 
	private CustomerService cs;
	@Autowired(required=true)
	@Qualifier(value="customerService")
	public void setCs(CustomerService cs) {
		this.cs = cs;
	}
	private ItemService is;
	@Autowired(required=true)
	@Qualifier(value="itemService")
	public void setIs(ItemService is) {
		this.is = is;
	}


	
	@RequestMapping(value = { "/customer/add" }, method = RequestMethod.GET)
    public String newCustomer(ModelMap model) {
       Customer customer=new Customer();
        model.addAttribute("customer", customer);
 
        
        return "register";
    }
	@RequestMapping(value ={ "/customer/add" },method = RequestMethod.POST)
	public ModelAndView saveCustomer(@ModelAttribute("customer") Customer cus) {
		ModelAndView mav=new ModelAndView();
		cus.setFlag(0);
		this.cs.saveCustomer(cus);
		
		mav.addObject("loginform",new LoginForm());
		mav.setViewName("login");
		return mav;
		
	
	}
 
	//ITEMS CONTROLLER
	
	@RequestMapping(value ={"/itemlist"}, method = RequestMethod.GET)
	public String listItems(ModelMap model) {
		List<Item> items = this.is.findAllItems();
		ModelAndView mav=new ModelAndView();
        model.addAttribute("items", items);
        model.addAttribute("date",new DateInvoice());
        model.addAttribute("singledate",new SingleDateInvoice());
        
        mav.addObject("loginform",new LoginForm());
		return "welcome";
	}
	@RequestMapping(value ={"/itemlistuser"}, method = RequestMethod.GET)
	public String listItemsUser(ModelMap model,HttpSession session,HttpServletRequest request) {
		List<Item> items = this.is.findAllItems();
        model.addAttribute("items", items);
        
		 Order cart=new Order();
		model.addAttribute("cart",cart);
		return "userwelcome";
	}
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id,ModelMap model){
		this.is.deleteItem(id);
		return "redirect:/itemlist";
    }
	@RequestMapping(value="/item/add",method = RequestMethod.POST)
	public String createitem(Item item,@RequestParam("photo") MultipartFile photo) throws Exception{
		byte[] image=photo.getBytes();
		item.setImage(image);
		this.is.saveItem(item);
		System.out.println(this.is.findById(item.getItemno()));
		return "redirect:/itemlist";
	}
	@RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
	  public void showImage(@RequestParam("id") Integer itemId, HttpServletResponse response,HttpServletRequest request) 
	          throws ServletException, IOException{


	    Item item = is.findById(itemId);    
	    response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	    response.getOutputStream().write(item.getImage());


	    response.getOutputStream().close();
	}
	@RequestMapping(value = { "/item/add" }, method = RequestMethod.GET)
    public String newItem(ModelMap model) {
       Item item=new Item();
        model.addAttribute("item", item);
        model.addAttribute("edit", false);
        
        return "registeritem";
    }
	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
    public String editItem(@PathVariable int id, ModelMap model) {
        Item item=is.findById(id);
        model.addAttribute("item", item);
        model.addAttribute("edit", true);
        return "registeritem";
    }
	@RequestMapping("/edit/{id}")
    public String updateItem(@Valid Item item, BindingResult result,
            ModelMap model, @PathVariable int id){
//		 if (result.hasErrors()) {
//	            return "registeritem";
//	        }
       is.updateItem(item);
       return "redirect:/itemlist";
    }
}
