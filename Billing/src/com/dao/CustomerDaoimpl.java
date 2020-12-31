package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HibernateUtility;
import com.model.Customer;

@Repository
public class CustomerDaoimpl implements CustomerDAO{

	@Autowired
	private HibernateUtility hibernateUtilty;
	private Transaction tx;
	
	public HibernateUtility getHibernateUtilty() {
		return hibernateUtilty;
	}

	public void setHibernateUtilty(HibernateUtility hibernateUtilty) {
		this.hibernateUtilty = hibernateUtilty;
	}
	protected Session getSession(){
	    return getHibernateUtilty().currentSession();
	}
	protected Transaction getTransaction(Session session) {
		return session.beginTransaction();
	}
	@Override
	public Customer findById(int id) {
		
		return (Customer)getSession().get(Customer.class,id);
		
	}

	@Override
	public void saveEmployee(Customer customer) {

		getSession().save(customer);
		getTransaction(getSession()).commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findAllCustomers() {
		Criteria criteria = getSession().createCriteria(Customer.class);
        return (List<Customer>) criteria.list();
	}

	@Override
	public Customer findCustomerbyrole(String role) {
		// TODO Auto-generated method stub
		return (Customer)getSession().get(Customer.class,role);
	}

	@Override
	public void deleteCustomer(int id) {
		Query query = getSession().createSQLQuery("delete from CUSTOMER where CUSTOMER_ID = :id");
        query.setInteger("CUSTOMER_ID", id);
        query.executeUpdate();
		
	}

	@Override
	public Customer findCustomerbyname(String uname,String upass) {
		Session session = getHibernateUtilty().currentSession();
		Criteria crit = session.createCriteria(Customer.class);
		crit.add(Restrictions.eq("uname", uname));
		crit.add(Restrictions.eq("upass", upass));
		List<Customer> users = crit.list();
		if(users.size()>0)
			return users.get(0);
		else
			return null;
	}

	@Override
	public void update(Customer c) {
		Session session = getHibernateUtilty().currentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(c);
			tx.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
			
		}
		
	}


}
