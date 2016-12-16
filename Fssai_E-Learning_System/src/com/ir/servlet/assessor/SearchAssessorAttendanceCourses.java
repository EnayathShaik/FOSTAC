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
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;
import com.ir.constantes.DBUtil;
import com.ir.model.AdminUserManagement;
import com.ir.model.City;
import com.ir.model.District;
import com.ir.model.TrainingPartner;
import com.ir.model.assessor.AssessorAttendance;
import com.ir.model.assessor.MarkAttendanceForm;
import com.ir.service.PageLoadService;
import com.ir.service.impl.PageLoadServiceImpl;
import com.itextpdf.text.log.SysoCounter;

/**
 * Servlet implementation class MyServlt
 */

public class SearchAssessorAttendanceCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAssessorAttendanceCourses() {
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
				String id = request.getQueryString();
				
				String strAssessorId = request.getParameter("assessorId");
		        PrintWriter out = response.getWriter();
			
				try {
					Class.forName("org.postgresql.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Connection conn = null;
				try {
					conn = DriverManager.getConnection(DBUtil.databaseUrl,DBUtil.dbUsername,DBUtil.dbPassword);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				ResultSet rs = null;
				PreparedStatement stmt = null;
				System.out.println("before sql query");
				int assessorId = 710;
				String sql = "select pia.personalinformationassessorid, tc.trainingcalendarid, "
						+ "cn.coursenameid, cn.coursename, tc.trainingdate ,  tc.trainingtime "
						+ "from personalinformationassessor pia "
						+ "inner join courseenrolled ce on ce.logindetails = pia.logindetails "
						+ "inner join trainingcalendar tc on tc.coursename = ce.coursenameid "
						+ "inner join coursename cn on cn.coursenameid = tc.coursename "
						+ "where pia.personalinformationassessorid ="+assessorId;
				System.out.println(sql);
				List listCourseCalendar = new ArrayList<>();
				try {
					stmt = conn.prepareStatement(sql);
					System.out.println(stmt.toString());
					rs = stmt.executeQuery();
					
					while(rs.next()){
						List assessorCourseCalendar = new ArrayList<>();
						assessorCourseCalendar.add(rs.getInt(1));
						assessorCourseCalendar.add(rs.getInt(2));
						assessorCourseCalendar.add(rs.getInt(3));
						assessorCourseCalendar.add(rs.getString(4));
						assessorCourseCalendar.add(rs.getString(5));
						assessorCourseCalendar.add(rs.getString(6));
						listCourseCalendar.add(assessorCourseCalendar);
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
				String newList = g.toJson(listCourseCalendar); 
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
