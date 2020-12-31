package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CustomerDAO;
import com.model.Customer;

@Service("loginService")
@Transactional
public class LoginServiceImmpl implements LoginService{

	@Autowired
	private CustomerDAO udao;
	@Autowired
	private CustomerService sdao;
	@Override
	public String checkUser(String uname,String upass) {
		Customer user=udao.findCustomerbyname(uname,upass);
		//String role=user.getRole();
		//System.out.println(user.getRole());
		if(user!=null) {
			if(user.getFlag()==1) {
				return "already";
			}		
			else if(user.getRole().equals("user"))
					return "valid";
				else 
					return "validadmin";
			}
			else
			{
				return "invaliduser";
			}
		
		
		
	}


	@Override
	public void updateFlag(String uname,String upass, int flag) {
		Customer user=udao.findCustomerbyname(uname, upass);
		if(user!=null) {
		user.setFlag(flag);
		sdao.updateCustomer(user);
		}
	}



	
}
