package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.DateInvoice;
import com.model.LoginForm;
import com.service.CustomerService;
import com.service.LoginService;
@Controller
public class LoginController {

	@SuppressWarnings("unused")
	private CustomerService cs;
	@Autowired(required=true)
	@Qualifier(value="customerService")
	public void setCs(CustomerService cs) {
		this.cs = cs;
	}
	private LoginService ls;
	@Autowired(required=true)
	@Qualifier(value="loginService")
	public void setLs(LoginService ls) {
		this.ls = ls;
	}
//	@RequestMapping(value="/",method = RequestMethod.GET)
//	public String welcome() {
//		return "login";
//	}
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView showPage(ModelAndView mav) {
		mav.addObject("loginform",new LoginForm());
		mav.setViewName("login");
		return mav;
	}
	@RequestMapping(method=RequestMethod.POST ,value = "/login")
	public String processingshowPage(@ModelAttribute("loginform") LoginForm lform,HttpSession session) {
		session.setAttribute("uname", lform.getUsername());
		session.setAttribute("upass", lform.getPassword());
		System.out.println((String)lform.getUsername()+"  "+lform.getPassword());
		String result = ls.checkUser(lform.getUsername(),lform.getPassword());
		ModelAndView mav=new ModelAndView();
		
		if(result.equals("valid")) {
			ls.updateFlag(lform.getUsername(),lform.getPassword(), 1);
			 
			return "redirect:/itemlistuser";
		}
		else if(result.equals("validadmin"))
		{
			ls.updateFlag(lform.getUsername(),lform.getPassword(), 1);
			return "redirect:/itemlist";
		}
		return "login";
	}
	@RequestMapping(value="/logout" , method = RequestMethod.GET)
	public String logout(HttpSession session) {
		String uname=(String)session.getAttribute("uname");
		String upass=(String)session.getAttribute("upass");
		ls.updateFlag(uname,upass, 0);
		session.removeAttribute("uname");
		session.removeAttribute("upass");
		return "redirect:/";
	}
}
