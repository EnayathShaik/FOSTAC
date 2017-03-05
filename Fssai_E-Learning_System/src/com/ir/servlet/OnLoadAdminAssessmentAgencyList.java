package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;

/**
 * Servlet implementation class MyServlt
 */

public class OnLoadAdminAssessmentAgencyList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnLoadAdminAssessmentAgencyList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
				System.out.println("onload admin trainer list");
				response.setContentType("text/html;charset=UTF-8");
		        PrintWriter out = response.getWriter();
			
		        Configuration conf = new Configuration();
				conf.configure("/hibernate.cfg.xml");
				SessionFactory sf = conf.buildSessionFactory();
				Session session = sf.openSession();
				String newList=null;
				
				String sql = "select maa.manageassessmentagencyid ,  maa.assessmentagencyname , "+
							" count(pia.assessmentagencyname) from personalinformationassessor as pia "+
  " inner join manageassessmentagency as maa on pia.assessmentagencyname = maa.manageassessmentagencyid  "+
  " inner join logindetails as ld on pia.logindetails = ld.id where ld.status='I' "+
 " group by maa.assessmentagencyname , maa.manageassessmentagencyid ";
				Query query = session.createSQLQuery(sql);
				List list = query.list();
				System.out.println(list.size());
				session.close();
				if(list.size() > 0 || list != null){
					System.out.println(list);
					Gson g =new Gson();
					newList = g.toJson(list); 
				}
				out.write(newList);
				out.flush();
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
