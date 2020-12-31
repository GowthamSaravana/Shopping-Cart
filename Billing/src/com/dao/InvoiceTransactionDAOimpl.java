package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HibernateUtility;
import com.model.Invoice;
import com.model.InvoiceTransaction;
import com.model.Item;

@Repository
public class InvoiceTransactionDAOimpl implements InvoiceTransactionDAO {

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
	public InvoiceTransaction findByInvocieId(int invno) {
		Session session = getHibernateUtilty().currentSession();
		Criteria crit = session.createCriteria(InvoiceTransaction.class);
		crit.add(Restrictions.eq("invoice_number", invno));
		List<InvoiceTransaction> users = crit.list();
		if(users.size()>0)
			return users.get(0);
		else
			return null;
	}

	@Override
	public void saveInvoicetransaction(InvoiceTransaction InvoiceTransaction) {
		getSession().save(InvoiceTransaction);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InvoiceTransaction> findAllTransaction() {
		Criteria criteria = getSession().createCriteria(InvoiceTransaction.class);
        return (List<InvoiceTransaction>) criteria.list();
	}

	@Override
	public InvoiceTransaction findbyitem(Item item) {
		return (InvoiceTransaction)getSession().get(InvoiceTransaction.class,item);
	}

}
