package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HibernateUtility;
import com.model.Item;

@Repository
public class ItemDAOImpl implements ItemDAO {
	
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
	public Item findByItemno(int item_no) {
		return (Item)getSession().get(Item.class,item_no);
	}

	@Override
	public void saveItem(Item item) {
		getSession().save(item);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> findAllItems() {
		Criteria criteria = getSession().createCriteria(Item.class);
        return (List<Item>) criteria.list();
	}

	@Override
	public void deleteItem(Integer itemno) {
		Query query = getSession().createSQLQuery("delete from item where item_no = :item_no");
        query.setInteger("item_no", itemno);
   
        query.executeUpdate();
		
	}

	@Override
	public void update(Item c) {
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
