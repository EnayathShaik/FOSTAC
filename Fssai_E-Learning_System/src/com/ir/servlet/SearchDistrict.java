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

public class SearchDistrict extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchDistrict() {
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
        
        String total = request.getQueryString();
        String[] totalConnected = total.split("&");
        String stateId = (totalConnected[0].split("="))[1];
        String	districtName =null ;
        if(totalConnected[1].split("=").length == 1){
        	districtName ="%";	
        }else{
        	districtName =  (totalConnected[1].split("="))[1];
        }
       
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		String newList = null ;
		System.out.println(stateId + "   "+ districtName);
		if(districtName.equals("%") ){
			System.out.println("lkjkj");
			String sql = "select  s.stateName , d.districtName  , d.districtId  from district as d inner join state as s on s.stateid = d.stateid where "+
					 " s.stateId='"+stateId+"' or d.districtName='"+districtName+"%'";
			Query query = session.createSQLQuery(sql);
			List list = query.list();
			System.out.println(list.size());
			session.close();
			if(list.size() > 0 || list != null){
				System.out.println("data selected finally  " );
				System.out.println(list);
				Gson g =new Gson();
				newList = g.toJson(list); 
			}
		}else{
			String sql = "select  s.stateName , d.districtName  , d.districtId  from district as d inner join state as s on s.stateid = d.stateid where "+
					 " d.status = 'A' and upper(districtname) like '"+districtName.replaceAll("%20", " ").toUpperCase()+"%'";
			Query query = session.createSQLQuery(sql);
			List list = query.list();
			System.out.println(list.size());
			session.close();
			if(list.size() > 0 || list != null){
				System.out.println("data selected finally  " );
				System.out.println(list);
				Gson g =new Gson();
				newList = g.toJson(list); 
			}
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
