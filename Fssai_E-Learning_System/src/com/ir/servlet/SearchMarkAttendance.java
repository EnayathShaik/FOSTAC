package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;
/**
 * Servlet implementation class DeleteState
 */

public class SearchMarkAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMarkAttendance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void callPost(HttpServletRequest request, HttpServletResponse response,String loginId,int profileCode) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("loginId == "+loginId);
		
		response.setContentType("text/html;charset=UTF-8");
		
        PrintWriter out = response.getWriter();
		String name = (request.getQueryString());
		Integer profileID = 0;
		HttpSession httpSession=request.getSession(false);
		if(null!=httpSession.getAttribute("profileId")){
			profileID=Integer.parseInt(httpSession.getAttribute("profileId").toString());
		}
		System.out.println("profileID "+profileID);
		String [] n1 = name.split("&");
		
		String courseType,courseName , trainingDate , trainingTime ;
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
			trainingDate = "%"+n1[2].split("=")[1].replaceAll("%20", " ");
		}
		catch(Exception e){
			trainingDate = "%";
		}
		
		try{
			trainingTime ="%"+ n1[3].split("=")[1].replaceAll("%20", " ");
		}
		catch(Exception e){
			trainingTime = "%";
		}
		String userstatus = "";
		if(profileCode == 5){
			userstatus = "F.userstaus";
		}else if(profileCode == 6){
			userstatus = "F.userstausassessor";
		}
		
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		String newList=null;
		System.out.println("district 0");
		String sql ="";
		
		sql = "select A.batchCode,C.courseCode,A.trainingdate,A.trainingtime,G.firstname||' ' ||G.middlename|| ' ' ||G.lastname as participantName ,G.aadharnumber , courseenrolleduserid , " +userstatus+ " "+
				"from trainingcalendar A inner join coursetype B on(A.coursetype=B.coursetypeid)  inner join coursename C on(A.coursename=C.coursenameid)   inner join personalinformationtrainingpartner D on(A.trainingcenter=D.personalinformationtrainingpartnerid) "+
				"inner join logindetails E on(D.logindetails=E.ID) inner join courseenrolleduser F on(A.trainingcalendarid=F.trainingcalendarid) inner join personalinformationtrainee G on(CAST(CAST (F.logindetails AS NUMERIC(19,4)) AS INT)=G.logindetails)  " +
				"where 1=1 " +
				"and cast(B.coursetypeid as varchar(10)) like '"+courseType+"%'  and cast( C.coursenameid as varchar(10)) like  '"+courseName+"%' and cast(trainingdate as varchar(10)) like '"+trainingDate+"%' and trainingtime  like '"+trainingTime+"%'   ";
		
		
		System.out.println(" sql "+sql);
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
		out.flush();		
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
		}
		System.out.println("--------------------"+httpSession.getAttribute("profileId"));
		if(null!=httpSession.getAttribute("profileId")){
			 profileId=Integer.parseInt(httpSession.getAttribute("profileId").toString());
		}
		
		// TODO Auto-generated method stub
		callPost(request, response,loginId,profileId);
	}

}
