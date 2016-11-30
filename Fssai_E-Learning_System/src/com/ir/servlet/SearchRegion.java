package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.ir.model.CourseName;
import com.ir.model.State;
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
        
        String total = request.getQueryString();
        System.out.println(total);
        String[] totalA  = total.split("%20");
		String cn = "";
		for(int i = 0 ; i < totalA.length ; i++){
			cn = cn + totalA[i] + " ";
		}
		String fcn = cn.substring(0, cn.length()-1);
		System.out.println(fcn.length() + "    "+ fcn);
        /*String[] totalConnected = total.split("&");
        String districtId = (totalConnected[1].split("="))[1];
        String	regionName =null ;
        
        try{
        	regionName =  (totalConnected[0].split("="))[1];
       }catch(Exception e){
    	   regionName = "%";
       }*/
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		String newList = null ;
		if(total.equals("") ){
			System.out.println("lkjkj");
			String sql = "select r.id , s.statename , d.districtname ,c.cityname, r.regionname from region as r "+
						" inner join state as s on s.stateid = r.stateid "+
						" inner join district as d on d.districtid = r.districtid "+
						" inner join city as c on c.cityid = r.cityid ";
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
			String sql = "select r.id , s.statename , d.districtname ,c.cityname, r.regionname from region as r "+
					" inner join state as s on s.stateid = r.stateid "+
					" inner join district as d on d.districtid = r.districtid "+
					" inner join city as c on c.cityid = r.cityid "+
					" where r.regionname = '"+fcn+"'";
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
