package com.service;

import java.util.List;

import com.model.Customer;

public interface CustomerService {

	Customer findById(int id);
    
    void saveCustomer(Customer customer);
     
    void updateCustomer(Customer customer);
     
    //void deleteEmployeeBySsn(String ssn);
 
    List<Customer> findAllCustomers(); 
     
    Customer findCustomerByRole(String role);
    
    Customer findCustomerByname(String name,String pass);
 
    //boolean isEmployeeSsnUnique(Integer id, String ssn);
}
