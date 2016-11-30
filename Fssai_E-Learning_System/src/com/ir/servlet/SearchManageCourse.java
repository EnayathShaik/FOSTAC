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
/**
 * Servlet implementation class DeleteState
 */

public class SearchManageCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchManageCourse() {
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
		System.out.println("passing name   :" + name);
		String[] totalConnected = name.split("&");
		String courseType,courseName , freePaid  , status,online,classroom;
		
		courseType = (totalConnected[0].split("="))[1];

		if( (totalConnected[1].split("=")).length == 1){
			courseName = "%";
		}else{
			courseName = (totalConnected[1].split("="))[1].replaceAll("%20", " ").trim();
		}

		if(totalConnected[2].split("=")[1].equalsIgnoreCase("0")){
			freePaid = "%";
		}else{
			freePaid = (totalConnected[2].split("="))[1];
		}
		
		status = (totalConnected[3].split("="))[1];
			
		if(totalConnected[4].split("=")[1].equalsIgnoreCase("false")){
			online = "%";
		}else{
			online = totalConnected[4].split("=")[1];
		}
		
		if(totalConnected[5].split("=")[1].equalsIgnoreCase("false")){
			classroom = "%";
		}else{
			classroom = (totalConnected[5].split("="))[1];
		}
		
		CourseName courseName1 = new CourseName();
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		String sql ="select ct.coursetype , cn.coursename , cn.courseduration , cn.paidunpaid ,  cn.status ,cn.coursenameid , cn.online , cn.classroom"+
					" from coursename as cn inner join coursetype as ct on ct.coursetypeid= cn.coursetypeid "+
					" where cn.coursetypeid = '"+ Integer.parseInt(courseType) +"' and  upper(cn.coursename) like '"+ courseName.toUpperCase()+"'"+
					" and status like'"+status+"' and online like'"+online+"' and classroom like'" +classroom+"' and paidunpaid like'"+freePaid+"'";
		
		Query query = session.createSQLQuery(sql);
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
