package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.zentect.ajax.AjaxRequest;

/**
 * Servlet implementation class MyServlt
 */

public class GetCourseName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCourseName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				System.out.println("onload training center post vacancy load course name list");
				response.setContentType("text/html;charset=UTF-8");
		        PrintWriter out = response.getWriter();
		      //  String sql = "select cn.coursenameid , cn.coursename from coursename as cn inner join coursetype as ct on ct.coursetypeid = cn.coursetypeid where cn.coursetypeid  = '"+ request.getQueryString() +"'" ;
		        String sql = "select cn.coursenameid , cn.coursecode from coursename as cn inner join coursetype as ct on ct.coursetypeid = cn.coursetypeid where cn.coursetypeid  = '"+ request.getQueryString() +"'" ;
		        List list = new AjaxRequest().returnList(sql);
		        String newList = "";
		        if(list.size() > 0 || list != null){
					System.out.println("data selected finally  " );
					System.out.println(list);
					Gson g =new Gson();
					newList = g.toJson(list); 
				}
				out.write(newList);
				out.flush();
				
		        /*Configuration conf = new Configuration();
				conf.configure("/hibernate.cfg.xml");
				SessionFactory sf = conf.buildSessionFactory();
				Session session = sf.openSession();
				String sql = "select cn.coursenameid , cn.coursename from coursename as cn inner join coursetype as ct on ct.coursetypeid = cn.coursetypeid where cn.coursetypeid  = '"+ request.getQueryString() +"'" ;
				Query query = session.createSQLQuery(sql);
				List list = query.list();
				Gson g =new Gson();
				String newList = g.toJson(list); 
				out.write(newList);
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
