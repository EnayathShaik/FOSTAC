package com.ir.servlet.assessor;

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

import com.google.gson.Gson;
import com.ir.util.HibernateUtil;

/**
 * Servlet implementation class MyServlt
 */

public class ViewAssessmentAgencyCalendar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAssessmentAgencyCalendar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
				System.out.println("Retrieve Assessment agency calendar");
				response.setContentType("text/html;charset=UTF-8");
				String agencyId = request.getParameter("agencyId");
		        PrintWriter out = response.getWriter();
		        String name = (request.getQueryString());
		        String [] n1 = name.split("&");
		        String courseType,courseName,assessmentDateTime,assessmentAgencyName ,assessorName ;
		        
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
					assessmentDateTime = n1[2].split("=")[1];
					assessmentDateTime = "%"+assessmentDateTime.replaceAll("%20", " ");
				}
				catch(Exception e){
					assessmentDateTime = "%";
				}
				
				try{
					assessmentAgencyName = n1[3].split("=")[1];
				}
				catch(Exception e){
					assessmentAgencyName = "%";
				}
				
				try{
					assessorName = n1[4].split("=")[1];
				}
				catch(Exception e){
					assessorName = "%";
				}
			
		        SessionFactory sf = new HibernateUtil().getSessionFactory();
				Session session = sf.openSession();
				String newList=null;
				String sql = " select B.coursetype,C.coursename,A.assessmentdatetime,F.statename,E.firstname || ' '|| E.middlename ||' '|| E.lastname ,CASE WHEN G.status = 'A' THEN 'ACTIVE' ELSE 'IN-ACTIVE' END,C.coursecode,A.batchCode	from trainingcalendar A inner join coursetype B on(A.coursetype=B.coursetypeid)	inner join coursename C on(A.coursename=C.coursenameid)        inner join personalinformationtrainingpartner D on(A.trainingcenter=D.personalinformationtrainingpartnerid) inner join personalinformationassessor E on(A.assessor=E.personalinformationassessorid) inner join state F on(E.assessorcorrespondencestate=F.stateid)  inner join logindetails G on(E.logindetails=G.id) where to_timestamp(COALESCE(A.trainingdate, '19900101010101'),'DD-MM-YYYY') > now()"+
				" and   cast(A.coursetype as varchar(10)) like '"+courseType+"%'  and  cast(A.coursename as varchar(10) ) like  '"+courseName+"%' "+
				" and cast(coalesce(A.assessmentdatetime , '') as varchar(100)) like '"+assessmentDateTime+"%' and  cast(A.assessmentpartnername as varchar(100)) like '"+assessmentAgencyName+"%' and  cast(A.assessor as varchar(100)) like '"+assessorName+"%'";
				
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
