package com.ir.servlet.assessor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;
import com.ir.constantes.DBUtil;
import com.ir.model.City;
import com.ir.model.District;
import com.ir.model.TrainingPartner;
import com.ir.service.PageLoadService;
import com.ir.service.impl.PageLoadServiceImpl;
import com.ir.util.HibernateUtil;
import com.itextpdf.text.log.SysoCounter;

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
				String id = request.getQueryString();
		        PrintWriter out = response.getWriter();
			
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
						+ " inner join personalinformationtrainee F on(F.logindetails=B.logindetails) ";
						

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
