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

public class SearchRegion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchRegion() {
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
        
        String name = request.getQueryString();
        String [] n1 = name.split("&");
		
		String stateId ;
		if((n1[0].split("="))[1].equals("")){
			stateId = "%";
		}else{
			stateId = (n1[0].split("="))[1];
		}
		
		String districtId;
		System.out.println("-----> "+(n1[1].split("="))[1]);
		if((n1[1].split("="))[1].equals("0")){
			districtId ="%";
		}else{
			districtId = (n1[1].split("="))[1];
		}
		
		String cityName = null;
		System.out.println("city "+(n1[2].split("="))[1]);
		if( (n1[2].split("="))[1].equals("0")){
			cityName = "%";
		}else{
			cityName =  (n1[2].split("="))[1];
		}
		
		String status = (n1[3].split("="))[1] ;
		
        String	regionName ;
        
        try{
        	regionName =  (n1[4].split("="))[1];
       }catch(Exception e){
    	   regionName = "%";
       }
        System.out.println("region==>"+regionName);
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		String newList =  "No Data Found!!";
		//if(total.equals("") ){
			System.out.println("lkjkj");
			String sql = "select r.id , s.statename , d.districtname ,c.cityname, r.regionname from region as r "+
						" inner join state as s on s.stateid = r.stateid "+
						" inner join district as d on d.districtid = r.districtid "+
						" inner join city as c on c.cityid = r.cityid "+ 
						" where CAST(s.stateid AS varchar(10)) like'"+ stateId +"'"+
						" and CAST(c.cityId AS VARCHAR(10)) like '"+cityName+"%' and  CAST(d.districtid AS varchar(10)) like '"+districtId+"'"+
						" and r.regionname like '"+regionName+"%'  ";
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
