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
public class LoadTrainingCenter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadTrainingCenter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("in load training center data servlet");
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		String name = (request.getQueryString());
		System.out.println("passing name   :" + name);
		
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		String sql="select pitp.personalinformationtrainingpartnerid , pitp.trainingcentrename "+
				" from personalinformationtrainingpartner as pitp "+
				" inner join managetrainingpartner as mtp on pitp.trainingpartnername = mtp.managetrainingpartnerid "+
				" inner join logindetails as ld on ld.id = pitp.logindetails "+
				"  inner join state as s on s.stateid = pitp.trainingpartnerpermanentstate"+
				" where pitp.trainingpartnername = '"+name+"'" ;	
	 
		Query query = session.createSQLQuery(sql);
		List list = query.list();
		
		Gson g =new Gson();
		String newList = g.toJson(list); 
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
