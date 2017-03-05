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

public class SearchAssessorTraineesForResults extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAssessorTraineesForResults() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
				System.out.println("Retrieve upcoming calendar");
				response.setContentType("text/html;charset=UTF-8");
				String name = (request.getQueryString());
				String [] n1 = name.split("&");
		        PrintWriter out = response.getWriter();
			
		        String courseName , trainingDate , trainingCenter;
		        try{
					courseName = n1[0].split("=")[1];	
				}catch(Exception e){
					courseName = "%";	
				}
				
		        try{
		        	trainingCenter = n1[1].split("=")[1];	
				}catch(Exception e){
					trainingCenter = "%";	
				}
				
			
				try{
					trainingDate = n1[2].split("=")[1];
					trainingDate = "%"+trainingDate.replaceAll("%20", " ");
					System.out.println("trainingDate "+trainingDate);
				}
				catch(Exception e){
					trainingDate = "%";
				}
		        
		        SessionFactory sf = new HibernateUtil().getSessionFactory();
				Session session = sf.openSession();
				String newList=null;
				String sql = "select A.trainingcalendarid,B.courseenrolleduserid, C.coursename,A.trainingdate,"
						+ " concat(D.firstname , ' ' , D.middlename , ' ' , D.lastname ) TraineeCenter, "
						+ " concat(F.firstname , ' ' , F.middlename , ' ' , F.lastname ) Trainee "
						+ " ,B.result,B.assessorcomment,C.courseCode,A.batchCode "
						+ " from trainingcalendar A "
						+ " inner join courseenrolleduser B on(A.trainingcalendarid=B.trainingcalendarid) "
						+ " inner join coursename C on(A.coursename=C.coursenameid) "
						+ " inner join personalinformationtrainingpartner D on(A.trainingcenter=D.personalinformationtrainingpartnerid) "
						+ " inner join logindetails E on(D.logindetails=E.id)"
						+ " inner join personalinformationtrainee F on(F.logindetails=B.logindetails) "
						+" where cast(A.coursename as varchar(100)) like '"+courseName+"%'   and  cast(A.trainingdate as varchar(100)) like '"+trainingDate+"%'  and cast(A.trainingcenter as varchar(100)) like '"+trainingCenter+"%'";
						
						

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
