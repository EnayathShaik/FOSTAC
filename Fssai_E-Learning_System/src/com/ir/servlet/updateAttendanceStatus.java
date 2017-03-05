package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ir.model.CourseEnrolledUser;
/**
 * Servlet implementation class DeleteState
 */

public class updateAttendanceStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateAttendanceStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		String name = (request.getQueryString());
		System.out.println("passing name   :" + name);
	
		Integer profileID = 0;
		HttpSession httpSession=request.getSession(false);
		if(null!=httpSession.getAttribute("profileId")){
			profileID=Integer.parseInt(httpSession.getAttribute("profileId").toString());
		}
		
		String[] updateDetails = name.split("&");
		String id , status ;	
		id= (updateDetails[0].split("="))[1];
		
		status = (updateDetails[1].split("="))[1];
		System.out.println("courseenroledId "+id);
		System.out.println("payment==>"+status);
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		
		CourseEnrolledUser courseEnrolledUser = (CourseEnrolledUser) session.load(CourseEnrolledUser.class, Integer.parseInt(id));
		if(profileID == 5){
			courseEnrolledUser.setUserStaus(status);
		}else if(profileID == 6){
			courseEnrolledUser.setUserStausAssessor(status);
		}
		
		
		session.update(courseEnrolledUser);
		session.beginTransaction().commit();
		session.close();

		String newList = "Recors successfully updated !!!" ; 
		out.write(newList);
		out.flush();
		
	}

	}


