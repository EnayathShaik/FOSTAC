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
		String courseType="",courseName="" , freePaid ="" , status="",duration = "" ;
		if(!name.equalsIgnoreCase("ALL")){
			
			try{
				courseType = (totalConnected[0].split("="))[1];
			}
			catch(Exception e)
			{
				courseType ="%" ;
			}
			
			try{
				courseName = (totalConnected[1].split("="))[1].replaceAll("%20", " ").trim();
			}
			catch(Exception e)
			{
				courseName = "%";
			}
			
			try{
				freePaid = (totalConnected[2].split("="))[1];
			}
			catch(Exception e)
			{
				freePaid = "%";
			}
			
				status = (totalConnected[3].split("="))[1];
				try{
					duration =totalConnected[4].split("=")[1];
				}catch(Exception e){
					duration = "%";	
				}
			
		}
		CourseName courseName1 = new CourseName();
		String sql = null;
		if(!name.equalsIgnoreCase("ALL"))
			sql ="select cn.coursetypeid,ct.coursetype , cn.coursename , cn.courseduration , cn.paidunpaid ,  cn.status ,cn.coursenameid , cn.online , cn.classroom"+
						" ,cn.courseCode from coursename as cn inner join coursetype as ct on ct.coursetypeid= cn.coursetypeid "+
						" where cast(cn.coursetypeid as varchar(10)) like '"+courseType+"%' and upper(cn.coursename) like '"+ courseName.toUpperCase()+"%'"+
						"  and paidunpaid like'"+freePaid+"%' and cn.courseduration like '"+duration+"%' and cn.status like '"+status+"%' Order By cn.coursenameid desc ";
			else
			sql ="select cn.coursetypeid,ct.coursetype , cn.coursename , cn.courseduration , cn.paidunpaid ,  cn.status ,cn.coursenameid , cn.online , cn.classroom"+
							" ,cn.courseCode from coursename as cn inner join coursetype as ct on ct.coursetypeid= cn.coursetypeid Order By cn.coursenameid desc " ;
			
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
		
		/*Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		String sql = null;
		if(!name.equalsIgnoreCase("ALL"))
		sql ="select cn.coursetypeid,ct.coursetype , cn.coursename , cn.courseduration , cn.paidunpaid ,  cn.status ,cn.coursenameid , cn.online , cn.classroom"+
					" from coursename as cn inner join coursetype as ct on ct.coursetypeid= cn.coursetypeid "+
					" where cast(cn.coursetypeid as varchar(10)) like '"+courseType+"%' and upper(cn.coursename) like '"+ courseName.toUpperCase()+"%'"+
					"  and paidunpaid like'"+freePaid+"%' and cn.courseduration like '"+duration+"%' and cn.status like '"+status+"%'  ";
		
		else
		
			sql ="select cn.coursetypeid,ct.coursetype , cn.coursename , cn.courseduration , cn.paidunpaid ,  cn.status ,cn.coursenameid , cn.online , cn.classroom"+
						" from coursename as cn inner join coursetype as ct on ct.coursetypeid= cn.coursetypeid " ;
		
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
