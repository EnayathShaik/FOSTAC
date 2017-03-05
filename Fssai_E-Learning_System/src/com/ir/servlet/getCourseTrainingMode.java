package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zentect.ajax.AjaxRequest;

/**
 * Servlet implementation class MyServlt
 */

public class getCourseTrainingMode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getCourseTrainingMode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
				System.out.println("in load city data servlet");
				response.setContentType("text/html;charset=UTF-8");
		        PrintWriter out = response.getWriter();
		        String mode = "";
				String courseNameId = (request.getQueryString());
				System.out.println("passing name   :" + courseNameId);
				String sql = "select online from coursename where coursenameid ="+courseNameId;
				List list = new AjaxRequest().returnList(sql);
				if(list.size()>0){
					mode = (String)list.get(0);	
				}
				out.write(mode);
				out.flush();
				/*Configuration conf = new Configuration();
				conf.configure("/hibernate.cfg.xml");
				SessionFactory sf = conf.buildSessionFactory();
				Session session = sf.openSession();
				Query query = session.createSQLQuery(" select online from coursename where coursenameid ="+courseNameId);
				List list = (List)query.list();
				System.out.println("after list load city");
				if(list.size()>0){
					mode = (String)list.get(0);	
				}	
				out.write(mode);
				out.flush();*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
