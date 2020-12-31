package com.dao;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HibernateUtility;
import com.model.Customer;
import com.model.Invoice;
import com.mysql.cj.Query;

@Repository
public class InvoiceDAOImpl implements InvoiceDAO{

	@Autowired
	private HibernateUtility hibernateUtilty;
	
	public HibernateUtility getHibernateUtilty() {
		return hibernateUtilty;
	}

	public void setHibernateUtilty(HibernateUtility hibernateUtilty) {
		this.hibernateUtilty = hibernateUtilty;
	}
	protected Session getSession(){
	    return getHibernateUtilty().currentSession();
	}
	@Override
	public Invoice findById(int inv_no) {
		return (Invoice)getSession().get(Invoice.class,inv_no);
	}

	@Override
	public void saveInvoice(Invoice invoice) {
	   getSession().save(invoice);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Invoice> findAllInvoice() {
		Criteria criteria = getSession().createCriteria(Invoice.class);
        return (List<Invoice>) criteria.list();
	}

	@Override
	public int max() {
		Session session = getHibernateUtilty().currentSession();
		Criteria criteria = session.createCriteria(Invoice.class)
	                .setProjection(Projections.max("invoice_number"));
	    Integer maxDuration = (Integer) criteria.uniqueResult();
		
		  return maxDuration;
	}
	@Override
	public List<Invoice> getAllInvoicesBetweenTwoDates(Date from, Date till) {
		Session session = getHibernateUtilty().currentSession();
		Criteria crit = session.createCriteria(Invoice.class);
		crit.add(Property.forName("invoice_date").between(from, till));
		List<Invoice> invoices = crit.list();
			return invoices;
		}

    @Override
	public List<Invoice> findAbyDate(Date date) {
		Session session = getHibernateUtilty().currentSession();
		Criteria crit = session.createCriteria(Invoice.class);
		crit.add(Restrictions.eq("invoice_date", date));
		List<Invoice> invoices = crit.list();
			return invoices;
		}
}
