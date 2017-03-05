package com.ir.servlet;

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
import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;

/**
 * Servlet implementation class MyServlt
 */

public class SearchAssessorCalendar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAssessorCalendar() {
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
				System.out.println(" id "+id);
		        PrintWriter out = response.getWriter();
		        Configuration conf = new Configuration();
				conf.configure("/hibernate.cfg.xml");
				SessionFactory sf = conf.buildSessionFactory();
				Session session = sf.openSession();
				String newList=null;
				String sql = "select B.coursecode,A.trainingdate, "
						+ "concat(C.trainingpartnerpermanentline1, ', ', C.trainingpartnerpermanentline2, ' -', dt.districtname) as address, "
						+ "(select count(1) from courseenrolleduser where trainingcalendarid=A.trainingcalendarid) "
						+ " ,A.batchCode, A.assessmentdatetime "
						+ "from trainingcalendar A "
						+ "inner join coursename B on(A.coursename=B.coursenameid) "
						+ "inner join personalinformationtrainingpartner C on(A.trainingcenter=C.personalinformationtrainingpartnerid) "
						+ "inner join district dt on dt.districtid = C.trainingpartnerpermanentdistrict where to_timestamp(COALESCE(A.assessmentdatetime, '19900101010101'),'DD-MM-YYYY') > now() AND A.assessor= '"+id+"'";
			
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
