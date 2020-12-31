package com.dao;

import java.util.List;

import com.model.Customer;
public interface CustomerDAO {

	Customer findById(int id);
	 
    void saveEmployee(Customer customer);
     
    List<Customer> findAllCustomers();
 
    Customer findCustomerbyrole(String role);
    
    Customer findCustomerbyname(String uname,String upass);
    
    void deleteCustomer(int id);
    
    void update(Customer c);
}

