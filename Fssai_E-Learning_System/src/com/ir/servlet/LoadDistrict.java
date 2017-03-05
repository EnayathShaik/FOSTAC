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
import com.ir.model.District;

/**
 * Servlet implementation class MyServlt
 */
public class LoadDistrict extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadDistrict() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try{
			System.out.println("in load district -- data servlet");
			response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
			String name = (request.getQueryString());
			System.out.println("passing name   :" + name);
			Configuration conf = new Configuration();
			conf.configure("/hibernate.cfg.xml");
			SessionFactory sf = conf.buildSessionFactory();
			Session session = sf.openSession();
			Query query = session.createQuery("from District where status='A' and stateid ='"+name+"'");
			List<District> list = query.list();
			System.out.println("after list load district");
			Gson g =new Gson();
			String newList = g.toJson(list); 
			out.write(newList);
			out.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
