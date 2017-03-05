package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.zentect.ajax.AjaxRequest;
/**
 * Servlet implementation class DeleteState
 */

public class TraineeCenterAssessmentCalender extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TraineeCenterAssessmentCalender() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void callPost(HttpServletRequest request, HttpServletResponse response,String loginId,int profileCode) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		String name =  request.getQueryString();
    	String [] n1 = name.split("&");
		System.out.println("n1 "+n1);
		String courseType,courseName , trainerName, assDate , assTime ;
		try{
			courseType = n1[0].split("=")[1];
		}
		catch(Exception e){
			courseType = "%";	
		}
		
		try{
			courseName = n1[1].split("=")[1];	
		}catch(Exception e){
			courseName = "%";	
		}
		
		try{
			trainerName = n1[2].split("=")[1];	
		}catch(Exception e){
			trainerName = "%";	
		}
		
		
		try{
			assDate = n1[3].split("=")[1];	
		}catch(Exception e){
			assDate = "%";	
		}
		
		try{
			assTime = n1[4].split("=")[1];	
		}catch(Exception e){
			assTime = "%";	
		}
		String sql ="";
		sql = "select B.coursetype,C.coursename,A.trainername,A.assessmentdate,A.assessmenttime,D.firstname || D.middlename || D.lastname,A.trainingcalendarid,A.assessor  from trainingcalendar A  " +
				" inner join coursetype B on(A.coursetype=B.coursetypeid)  " +
				"inner join coursename C on(A.coursename=C.coursenameid)"+
				"inner join personalinformationtrainer D on(CAST(CAST (A.trainername AS NUMERIC(19,4)) AS INT)=D.personalinformationtrainerid)" +
				" where  cast(B.coursetypeid as varchar(10)) like '"+courseType+"%'  and cast(C.coursenameid as varchar(10)) like  '"+courseName+"%' and (D.firstname || ' '|| D.middlename ||' '|| D.lastname)  like  '"+trainerName+"%'  and  cast(A.assessmentdate as varchar(10)) like  '"+assDate+"%'  and cast(assessmenttime as varchar(10)) like '"+assTime+"%'  " ;
		
		List list = new AjaxRequest().returnList(sql);
		String newList = "";
		if(list.size() > 0 || list != null){
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
		String newList=null;
		System.out.println("district 0");
		String sql ="";
		sql = "select B.coursetype,C.coursename,A.trainername,A.assessmentdate,A.assessmenttime,D.firstname || D.middlename || D.lastname,A.trainingcalendarid,A.assessor  from trainingcalendar A  " +
				" inner join coursetype B on(A.coursetype=B.coursetypeid)  " +
				"inner join coursename C on(A.coursename=C.coursenameid)"+
				"inner join personalinformationtrainer D on(CAST(CAST (A.trainername AS NUMERIC(19,4)) AS INT)=D.personalinformationtrainerid)" +
				" where  cast(B.coursetypeid as varchar(10)) like '"+courseType+"%'  and cast(C.coursenameid as varchar(10)) like  '"+courseName+"%' and (D.firstname || ' '|| D.middlename ||' '|| D.lastname)  like  '"+trainerName+"%'  and  cast(A.assessmentdate as varchar(10)) like  '"+assDate+"%'  and cast(assessmenttime as varchar(10)) like '"+assTime+"%'  " ;
		System.out.println("sql "+sql);
		Query query = session.createSQLQuery(sql);
		List list = query.list();
		System.out.println(list.size());
		session.close();
		if(list.size() > 0 || list != null){
			System.out.println(list);
			Gson g =new Gson();
			newList = g.toJson(list); 
		}
		out.write(newList);
		out.flush();	*/	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession=request.getSession(false);
		String loginId="";
		int profileId=0;
		if(null!=httpSession.getAttribute("logId")){
			 loginId=httpSession.getAttribute("logId").toString();
			 profileId=Integer.parseInt(httpSession.getAttribute("profileId").toString());
		}
		
		// TODO Auto-generated method stub
		callPost(request, response,loginId,profileId);
	}

}
