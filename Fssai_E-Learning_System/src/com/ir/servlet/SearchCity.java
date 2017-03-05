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
 * Servlet implementation class DeleteState
 */

public class SearchCity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		String name = (request.getQueryString());
		String [] n1 = name.split("&");
		
		String stateId ;
		if((n1[0].split("="))[1].equals("0")){
			stateId = "%";
		}else{
			stateId = (n1[0].split("="))[1];
		}
		
		String districtId;
		if((n1[1].split("="))[1].equals("0")){
			districtId ="%";
		}else{
			districtId = (n1[1].split("="))[1];
		}
		
		String cityName = null;
		if( (n1[2].split("=")).length == 1){
			cityName = "%";
		}else{
			cityName =  (n1[2].split("="))[1].replaceAll("%20", " ");
		}
		String status = (n1[3].split("="))[1] ;
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		String newList=null;
		String sql = "select s.statename , d.districtname , c.cityname , c.status , c.cityId,d.districtid from city as c "+
					" inner join district d on d.districtid = c.districtid "+
					" inner join state as s on s.stateid = d.stateid"+
					" where CAST(s.stateid AS varchar(10)) like'"+ stateId +"'"+
					" and c.cityName like '"+cityName+"%' and  CAST(d.districtid AS varchar(10)) like '"+districtId+"'";

			Query query = session.createSQLQuery(sql);
			List list = query.list();
			System.out.println(list.size());
			session.close();

				System.out.println("data selected finally  " );
				System.out.println(list);
				Gson g =new Gson();
				newList = g.toJson(list); 
		
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
