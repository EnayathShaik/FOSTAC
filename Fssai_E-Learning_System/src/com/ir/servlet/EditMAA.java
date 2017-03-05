package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ir.model.CourseName;
import com.zentect.ajax.AjaxRequest;

/**
 * Servlet implementation class DeleteState
 */

public class EditMAA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMAA() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		String name = (request.getQueryString());
		System.out.println("kk");
		String id = request.getQueryString();
		/*Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();*/
		
		String sql="select maa.manageassessmentagencyid  , ld.loginid ,maa.assessmentagencyname , maa.websiteurl , ld.status , "+
    			" maa.pan , maa.email , maa.headofficedataaddress1 , maa.headofficedataaddress2 , maa.pin ,s.statename , "+
    			" d.districtname  , c.cityname ,"+
    			" s.stateid ,d.districtid  , c.cityid "+
				" from manageassessmentagency as maa "+
				" inner join logindetails as ld on ld.id = maa.logindetails "+
				" inner join district as d on d.districtid = maa.district "+
				" inner join city as c on c.cityId = maa.city "+
				" inner join state as s on s.stateid = maa.stateid "+
				" where maa.manageassessmentagencyid = '"+ id+"' ";
		List<CourseName> list = new AjaxRequest().returnList(sql);
		String newList = null ;
		if(list.size() > 0 || list != null){
			System.out.println("data selected finally  " );
			System.out.println(list);
			Gson g =new Gson();
			newList = g.toJson(list); 
		}
		out.write(newList);
		out.flush();
		/*Query query = session.createSQLQuery(sql);
		List<CourseName> list = query.list();
		System.out.println(list.size());
		session.close();
		String newList = null ;
		if(list.size() > 0 || list != null){
			System.out.println("data selected finally  " );
			System.out.println(list);
			Gson g =new Gson();
			newList = g.toJson(list); 
		}
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
