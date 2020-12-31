package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CustomerDAO;
import com.model.Customer;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDAO dao;
	
	@Override
	public Customer findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveCustomer(Customer customer) {
		dao.saveEmployee(customer);
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		dao.update(customer);
	}

	@Override
	public List<Customer> findAllCustomers() {
		return dao.findAllCustomers();
	}

	@Override
	public Customer findCustomerByRole(String role) {
		return dao.findCustomerbyrole(role);
	}

	@Override
	public Customer findCustomerByname(String uname,String upass) {
		// TODO Auto-generated method stub
		return dao.findCustomerbyname(uname,upass);
	}

}
