package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ir.model.assessor.AssessorAttendance;
import com.ir.util.HibernateUtil;

/**
 * Servlet implementation class MyServlt
 */

public class MarkAssessorAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarkAssessorAttendance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
				System.out.println("Updating attendance for accessor..");
				response.setContentType("text/html;charset=UTF-8");
				String strAssessorId = request.getParameter("assessorId");
				String strTrainingcalId = request.getParameter("trainingcalId");
		        PrintWriter out = response.getWriter();
		        int assessorId, trainingCalId;
		        String responseStr="";
		        Integer attendanceId = 0;
		        if(strAssessorId != null && strTrainingcalId!=null){
		        	assessorId = Integer.parseInt(strAssessorId);
		        	trainingCalId = Integer.parseInt(strTrainingcalId);
				/*Configuration conf = new Configuration();
				conf.configure("/hibernate.cfg.xml");
				SessionFactory sf = conf.buildSessionFactory();*/
		        SessionFactory sf = new HibernateUtil().getSessionFactory();
				Session session = sf.openSession();
				Transaction tx = session.beginTransaction();
				String pattern = "dd-MM-yyyy"; 
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern); 
				String date = simpleDateFormat.format(new Date()); 
				AssessorAttendance attendanceObj = new AssessorAttendance();
				attendanceObj.setAssessorid(100);
				attendanceObj.setAttendance("A");
				attendanceObj.setCoursenameid(80);
				attendanceObj.setDate(date);
				attendanceId = (Integer)session.save(attendanceObj);
				tx.commit();
				session.close();
				
		        }
				if(attendanceId != 0 ){
					responseStr =  "Attendance marked successfully";
				}else{
					responseStr =  "Oops! Error occured while marking attendance.";
				}
				out.write(responseStr);
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
