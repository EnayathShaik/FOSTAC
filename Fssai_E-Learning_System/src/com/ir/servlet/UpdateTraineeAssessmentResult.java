package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.ir.form.TrainingpartnerpaymentconfirmationForm;
import com.ir.model.CourseEnrolledUser;
import com.ir.model.CourseName;
import com.ir.model.PersonalInformationTrainee;
import com.ir.util.HibernateUtil;
/**
 * Servlet implementation class DeleteState
 */

public class UpdateTraineeAssessmentResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTraineeAssessmentResult() {
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
		String id , status , comment ;	
		id= (updateDetails[0].split("="))[1];
		
		status = (updateDetails[1].split("="))[1];
		comment = (updateDetails[2].split("="))[1];
		System.out.println("courseenroledId "+id);
		System.out.println("result==>"+status);
		System.out.println("comment==>"+comment);
		
		
		/*Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
	*/	
		SessionFactory sf = new HibernateUtil().getSessionFactory();
		Session session = sf.openSession();
		CourseEnrolledUser courseEnrolledUser = (CourseEnrolledUser) session.load(CourseEnrolledUser.class, Integer.parseInt(id));
		courseEnrolledUser.setResult(status);
		courseEnrolledUser.setAssessorComment(comment);
		session.update(courseEnrolledUser);
		session.beginTransaction().commit();
		session.close();
		String newList = "Records successfully updated !!!" ; 
		out.write(newList);
		out.flush();
		
	}

	}


