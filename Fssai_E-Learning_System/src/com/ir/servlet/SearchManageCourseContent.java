package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
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
import com.ir.model.CourseName;
import com.ir.model.CourseType;
import com.ir.model.ManageCourseContent;
/**
 * Servlet implementation class DeleteState
 */

public class SearchManageCourseContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchManageCourseContent() {
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
		System.out.println("passing name   :" + name);
		String[] totalConnected = name.split("&");
		String contentLocation , courseType,courseName,modeOfTraining,contentType;
		
		try{
		contentLocation = (totalConnected[0].split("="))[1];
		}
		catch(Exception e)
		{
			contentLocation = "%" ;
		}
		
		try{
		courseType = (totalConnected[1].split("="))[1];
		}
		catch(Exception e)
		{
			courseType = "%" ;	
		}
		
		try{
		courseName = (totalConnected[2].split("="))[1];
		}
		catch(Exception e)
		{
			courseName = "%" ;	
		}
		try{
			modeOfTraining = (totalConnected[3].split("="))[1];	
		}
		catch(Exception e)
		{
			modeOfTraining = "%" ;
		}
		try{
			contentType = (totalConnected[4].split("="))[1];	
		}
		catch(Exception e)
		{
			contentType = "%" ;	
		}
		
		
		System.out.println("contentLocation  "+contentLocation);
		System.out.println("courseType   "+courseType);
		System.out.println("courseName    "+   courseName);
		System.out.println("modeOfTraining    "+   modeOfTraining);
		System.out.println("contentType    "+   contentType);
		
		
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		
		String sql = "select cn.coursecode , ct.coursetype , mcm.contentlinkinput , mcm.contentlocationinput, "+
				"mcm.modeoftraininginput , mcm.contenttypeinput , mcm.contentnameinput from ManageCoursecontent as mcm "+
				"inner join coursetype as ct on ct.coursetypeid = mcm.coursetypeinput "+
				"inner join coursename as cn on cn.coursenameid = mcm.coursenameinput "+
				"where mcm.contentlocationinput = '"+ contentLocation+"%' and mcm.coursetypeinput = '"+courseType+"%' and mcm.coursenameinput = '"+courseName  +"%' and mcm.modeoftraininginput = '"+modeOfTraining+"%' and mcm.contenttypeinput = '"+contentType+ "%'  order by mcm.managecoursecontentid desc";
		
		Query query = session.createSQLQuery(sql);
		/*query.setString(1, contentLocation);
		query.setString(2,  courseType);
		query.setString(3, courseName);
		query.setString(4, modeOfTraining);
		query.setString(5, contentType);*/
		
		/*Criteria criteria = session.createCriteria(com.ir.model.ManageCourseContent.class);
		criteria.add(Restrictions.eq("contentLocationInput", contentLocation));
		criteria.add(Restrictions.eq("courseTypeInput", Integer.parseInt(courseType)));
		criteria.add(Restrictions.eq("courseNameInput", Integer.parseInt(courseName)));
		criteria.add(Restrictions.eq("modeOfTrainingInput", modeOfTraining));
		criteria.add(Restrictions.eq("contentTypeInput", contentType));*/
		List list = query.list();
		ManageCourseContent m = new ManageCourseContent();
		CourseType ct = new CourseType();
		CourseName cn = new CourseName();
		List<ManageCourseContent> l = new ArrayList<>();
		String newList = null;
		if(list.size() > 0 || list != null){
			System.out.println("data selected finally");
			Iterator itr = list.iterator();
			/*while(itr.hasNext()){
				m.setContentLocationInput(list.get(3).toString());
				ct.setCourseType(list.get(1).toString());
				cn.setCoursename(list.get(0).toString());
				m.setModeOfTrainingInput(list.get(4).toString());
				m.setContentTypeInput(list.get(5).toString());
				m.setContentNameInput(list.get(6).toString());
				m.setContentLinkInput(list.get(2).toString());
				l.add(m);
			}*/
			System.out.println(list);
			Gson g =new Gson();
			newList = g.toJson(list);
			System.out.println(newList);
		}
		
		out.write(newList);
		out.flush();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		String name = (request.getQueryString());
		System.out.println("passing name   :" + name);
		String[] totalConnected = name.split("&");
		String contentLocation="" , courseType="",courseName="",modeOfTraining="",contentType="",contentLink="",contentName="";
		// "contentLocation=0&courseType=0&courseName=&modeOfTraining=&contentType=0";
		
		if(!name.equalsIgnoreCase("ALL")){
			
			try{
			contentLocation = (totalConnected[0].split("="))[1];
			}
			catch(Exception e)
			{
				contentLocation = "%" ;
			}
			
			try{
			courseType = (totalConnected[1].split("="))[1];
			}
			catch(Exception e)
			{
				courseType = "%" ;	
			}
			
			try{
			courseName = (totalConnected[2].split("="))[1];
			}
			catch(Exception e)
			{
				courseName = "%" ;	
			}
			try{
				modeOfTraining = (totalConnected[3].split("="))[1];	
			}
			catch(Exception e)
			{
				modeOfTraining = "%" ;
			}
			try{
				contentType = (totalConnected[4].split("="))[1];	
			}
			catch(Exception e)
			{
				contentType = "%" ;	
			}
			
			try{
				contentLink = (totalConnected[5].split("="))[1];	
			}
			catch(Exception e)
			{
				contentLink = "%" ;	
			}
			
			try{
				contentName = (totalConnected[6].split("="))[1];	
			}
			catch(Exception e)
			{
				contentName = "%" ;	
			}
			
			
		
		
		System.out.println("contentLocation  "+contentLocation);
		System.out.println("courseType   "+courseType);
		System.out.println("courseName    "+   courseName);
		System.out.println("modeOfTraining    "+   modeOfTraining);
		System.out.println("contentType    "+   contentType);
		
		}
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		String sql = null;
		
		
		if(!name.equalsIgnoreCase("ALL"))
		 sql= "select cn.coursecode , ct.coursetype , mcm.contentlinkinput , mcm.contentlocationinput, "+
				"mcm.modeoftraininginput , mcm.contenttypeinput , mcm.contentnameinput , mcm.managecoursecontentid from ManageCoursecontent as mcm "+
				"inner join coursetype as ct on ct.coursetypeid = mcm.coursetypeinput "+
				"inner join coursename as cn on cn.coursenameid = mcm.coursenameinput "+
				"where cast(mcm.contentlocationinput as varchar) like '"+ contentLocation+"' and cast(mcm.coursetypeinput as varchar) like '"+courseType+"' and cast(mcm.coursenameinput as varchar) like '"+courseName  +"' and cast(mcm.modeoftraininginput as varchar) like '"+modeOfTraining+"' and cast(mcm.contenttypeinput as varchar) like '"+contentType+ "' and mcm.contentnameinput like '"+contentName+"%' and cast(mcm.contentlinkinput as varchar) like '"+contentLink+"%'  order by mcm.managecoursecontentid desc";
		else
			 sql= "select cn.coursecode , ct.coursetype , mcm.contentlinkinput , mcm.contentlocationinput, "+
						"mcm.modeoftraininginput , mcm.contenttypeinput , mcm.contentnameinput , mcm.managecoursecontentid from ManageCoursecontent as mcm "+
						"inner join coursetype as ct on ct.coursetypeid = mcm.coursetypeinput "+
						"inner join coursename as cn on cn.coursenameid = mcm.coursenameinput order by mcm.managecoursecontentid desc";	
		
		
		Query query = session.createSQLQuery(sql);
		/*query.setString(1, contentLocation);
		query.setString(2,  courseType);
		query.setString(3, courseName);
		query.setString(4, modeOfTraining);
		query.setString(5, contentType);*/
		
		/*Criteria criteria = session.createCriteria(com.ir.model.ManageCourseContent.class);
		criteria.add(Restrictions.eq("contentLocationInput", contentLocation));
		criteria.add(Restrictions.eq("courseTypeInput", Integer.parseInt(courseType)));
		criteria.add(Restrictions.eq("courseNameInput", Integer.parseInt(courseName)));
		criteria.add(Restrictions.eq("modeOfTrainingInput", modeOfTraining));
		criteria.add(Restrictions.eq("contentTypeInput", contentType));*/
		List list = query.list();
		ManageCourseContent m = new ManageCourseContent();
		CourseType ct = new CourseType();
		CourseName cn = new CourseName();
		List<ManageCourseContent> l = new ArrayList<>();
		String newList = null;
		if(list.size() > 0 || list != null){
			System.out.println("data selected finally");
			Iterator itr = list.iterator();
			/*while(itr.hasNext()){
				m.setContentLocationInput(list.get(3).toString());
				ct.setCourseType(list.get(1).toString());
				cn.setCoursename(list.get(0).toString());
				m.setModeOfTrainingInput(list.get(4).toString());
				m.setContentTypeInput(list.get(5).toString());
				m.setContentNameInput(list.get(6).toString());
				m.setContentLinkInput(list.get(2).toString());
				l.add(m);
			}*/
			System.out.println(list);
			Gson g =new Gson();
			newList = g.toJson(list);
			System.out.println(newList);
		}
		
		out.write(newList);
		out.flush();
	}

}
