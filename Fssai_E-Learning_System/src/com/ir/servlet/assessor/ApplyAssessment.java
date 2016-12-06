package com.ir.servlet.assessor;

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
import org.hibernate.Transaction;

import com.google.gson.Gson;
import com.ir.model.CourseName;
import com.ir.model.CourseType;
import com.ir.model.FeedbackForm;
import com.ir.model.ManageCourseContent;
/**
 * Servlet implementation class DeleteState
 */

public class ApplyAssessment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyAssessment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		String calendarIds = request.getParameter("calendarIds");
		String assessorId = request.getParameter("assessorId");
		int index = 0;
		if(calendarIds != null)
			{
				index =calendarIds.lastIndexOf(","); 
				calendarIds = calendarIds.substring(0, index);	
			}
		System.out.println("Calendar Id :" + calendarIds + "assessorId : " + assessorId);
		String updateQry = "update trainingcalendar set personalinformationassessorid = "+assessorId+" where trainingcalendarid in ("+calendarIds+")"; 
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Query query = session.createSQLQuery(updateQry);
		System.out.println(updateQry);
		Integer i = query.executeUpdate();
		System.out.println("i  :"+ i);
		session.beginTransaction().commit();
		session.close();
		String qryResponse = null ;
		
		if(i > 0 ){
			qryResponse = "*Selected assessments accepted successfully"; 
		}else{
			qryResponse = "Oops , something went wrong. Please try ageain !!";
		}
		out.write(qryResponse);
		out.flush();
		}

}
