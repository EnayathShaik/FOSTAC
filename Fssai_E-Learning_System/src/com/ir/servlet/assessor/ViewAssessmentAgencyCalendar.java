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
import com.ir.model.City;
import com.ir.model.District;
import com.ir.model.TrainingPartner;
import com.ir.service.PageLoadService;
import com.ir.service.impl.PageLoadServiceImpl;
import com.itextpdf.text.log.SysoCounter;

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
				String sql = "select mag.manageassessmentagencyid,ct.coursetype,  cn.coursename ,"
						+ "concat(mag.headofficedataaddress1, ', ', headofficedataaddress2) as address "
						+ ",concat(pia.firstname, ' ', pia.middlename, ' ' , pia.lastname) as assessorname "
						+ ", case when logind.status='A' then 'Active' else 'In-active' end as status "
						+ "from manageassessmentagency mag "
						+ "inner join personalinformationassessor pia on pia.assessmentagencyname = mag.manageassessmentagencyid "
						+ "inner join logindetails logind on logind.id = pia.logindetails "
						+ "inner join courseenrolled ce on ce.logindetails = pia.logindetails "
						+ "inner join coursename cn on cn.coursenameid = ce.coursenameid "
						+ "inner join coursetype ct on ct.coursetypeid = cn.coursetypeid "
						+ "where mag.manageassessmentagencyid ="+agencyId;
				System.out.println(sql);
				List listUpcomingAssessments = new ArrayList<>();
				try {
					stmt = conn.prepareStatement(sql);
					System.out.println(stmt.toString());
					rs = stmt.executeQuery();
					
					while(rs.next()){
						List upcomingAssessment = new ArrayList<>();
						upcomingAssessment.add(rs.getInt(1));
						upcomingAssessment.add(rs.getString(2));
						upcomingAssessment.add(rs.getString(3));
						upcomingAssessment.add(rs.getString(4));
						upcomingAssessment.add(rs.getString(5));
						upcomingAssessment.add(rs.getString(6));
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
