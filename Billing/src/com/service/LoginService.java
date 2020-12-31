package com.service;

import com.model.Customer;

public interface LoginService {
	
	public String checkUser(String uname,String upass);
	public void updateFlag(String customer,String ad,int flag);
}
