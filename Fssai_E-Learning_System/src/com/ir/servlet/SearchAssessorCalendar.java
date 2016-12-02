package com.ir.servlet;

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
import com.ir.model.City;
import com.ir.model.District;
import com.ir.model.TrainingPartner;
import com.ir.service.PageLoadService;
import com.ir.service.impl.PageLoadServiceImpl;
import com.itextpdf.text.log.SysoCounter;

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
		        PrintWriter out = response.getWriter();
			
				try {
					Class.forName("org.postgresql.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Connection conn = null;
				try {
					conn = DriverManager.getConnection("jdbc:postgresql://localhost/FSSAI","postgres","Fss2iZentech");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ResultSet rs = null;
				PreparedStatement stmt = null;
				System.out.println("before sql query");
				String sql = "select pia.personalinformationassessorid,cn.coursename, tc.trainingdate, "
						+ "pia.assessorcorrespondencedistrict , tc.trainingcalendarid,ce.coursenameid,"
						+ "concat(pit.trainingpartnerpermanentline1, ', ', pit.trainingpartnerpermanentline2, ' -', dt.districtname) as address , count(ceu.courseenrolleduserid) "
						+ "from personalinformationassessor pia "
						+ "inner join courseenrolled ce on ce.logindetails = pia.logindetails "
						+ "inner join trainingcalendar tc on tc.coursename = ce.coursenameid and tc.personalinformationassessorid is null "
						+ "inner join personalinformationtrainingpartner pit on pit.personalinformationtrainingpartnerid = tc.trainingcenter "
						+ "inner join courseenrolleduser ceu on ceu.trainingcalendarid = tc.trainingcalendarid "
						+ "inner join coursename cn on cn.coursenameid = tc.coursename "
						+ "inner join district dt on dt.districtid = pit.trainingpartnerpermanentdistrict "
						+ "where pia.personalinformationassessorid = '710' "
						+ "group by pia.personalinformationassessorid, pia.assessorcorrespondencedistrict , tc.trainingcalendarid,ce.coursenameid, tc.trainingdate, cn.coursename, address";
				System.out.println(sql);
				List listUpcomingAssessments = new ArrayList<>();
				try {
					stmt = conn.prepareStatement(sql);
					System.out.println(stmt.toString());
					rs = stmt.executeQuery();
					
					while(rs.next()){
						List upcomingAssessment = new ArrayList<>();
						upcomingAssessment.add(rs.getString(1));
						upcomingAssessment.add(rs.getString(2));
						upcomingAssessment.add(rs.getString(3));
						upcomingAssessment.add(rs.getInt(5));
						upcomingAssessment.add(rs.getString(6));
						upcomingAssessment.add(rs.getString(7));
						upcomingAssessment.add(rs.getString(8));
						listUpcomingAssessments.add(upcomingAssessment);
					}
				} catch (SQLException e) {
					System.out.println("Error while fetching upcoming assement calendars : "+e.getMessage());
				}finally{
					try {
						if(rs != null){
							rs.close();
						}
						if(conn != null){
							conn.close();
						}
					} catch (SQLException e) {
					}
				}
				Gson g =new Gson();
				String newList = g.toJson(listUpcomingAssessments); 
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
