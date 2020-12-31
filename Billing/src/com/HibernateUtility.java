package com;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HibernateUtility {
	@Autowired
	 private  SessionFactory sessionFactory;
//	    static {
//	        try {
//	            // Create the SessionFactory from hibernate.cfg.xml
//	        	HibernateConfiguration con=new HibernateConfiguration();
//	        	
//	       
//	            sessionFactory= (SessionFactory)con.sessionFactory();
//	        } catch (Throwable ex) {
//	            // Make sure you log the exception, as it might be swallowed
//	            System.err.println("Initial SessionFactory creation failed." + ex);
//	            throw new ExceptionInInitializerError(ex);
//	        }
//	    }
	    public  final ThreadLocal<Session>  localthread=new ThreadLocal<Session>();
	    public  Session currentSession() throws HibernateException
	    {
	    	Session s=(Session)localthread.get();
	    	if(s==null){
	    		s=sessionFactory.openSession();
	    		localthread.set(s);
	    	}
	    	return s;
	    }
	    public  void closeSession()throws HibernateException
	    {
	    	Session s=localthread.get();
	    	localthread.set(null);
	    	if(s!=null)
	    	{
	    		s.close();
	    	}
	    }
		public SessionFactory getSessionFactory() {
			return sessionFactory;
		}
		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
	    
}