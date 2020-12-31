package com;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Actioncontrolfilter
 */
public class Actioncontrolfilter implements Filter {


    public Actioncontrolfilter() {
        System.out.println("Filter method called..");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hrequest=(HttpServletRequest)request;
		HttpSession session=hrequest.getSession();
		if(session.isNew()) {
		
		  	hrequest.getSession().removeAttribute("uname");
	        hrequest.getSession().removeAttribute("upass");
	      
			
				HttpServletResponse hresponse=(HttpServletResponse)response;
				hresponse.sendRedirect("sessionExpiry.jsp");
			
			
		}
		else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
