package com.ir.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {

	 @Override
	    public void destroy() {
	        // TODO Auto-generated method stub

	    }

	    @Override
	    public void doFilter(ServletRequest request, ServletResponse response,
	            FilterChain chain) throws IOException, ServletException {

	        HttpSession session = ((HttpServletRequest) request).getSession(false);
	        PrintWriter out = response.getWriter();
	        if ( session != null && !session.isNew())
	        {
	            chain.doFilter(request, response);
	        }
	        else
	        {
	     /*   	request.setAttribute("sessionMsg", "Session Expired Please Relogin!!");

	            request.getRequestDispatcher("/index.jsp").forward(request, response);
	            */
	            
	            out.println("<script type=\"text/javascript\">");
	            out.println("alert('Session Expired Please Relogin');");
	            out.println("location='index.jsp';");
	            out.println("</script>");
	        }


	    }

	    @Override
	    public void init(FilterConfig arg0) throws ServletException {
	        // TODO Auto-generated method stub

	    }

}
