package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ir.constantes.DBUtil;

/**
 * Servlet implementation class MyServlt
 */

public class OnLoadTrainingPartnerCenterId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnLoadTrainingPartnerCenterId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
				System.out.println("onload admin training center list ddd");
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
					conn = DriverManager.getConnection(DBUtil.databaseUrl,DBUtil.dbUsername,DBUtil.dbPassword);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ResultSet rs = null;
				PreparedStatement stmt = null;
				System.out.println("before sql query");
				String sql = "select pitp.personalinformationtrainingpartnerid as id , concat (pitp.firstname , ' ' , pitp.middlename ,'  ' , pitp.lastname), "+
							 " mtp.trainingpartnername , ld.loginid , ld.id   from personalinformationtrainingpartner as pitp "+
							 " inner join managetrainingpartner as mtp on pitp.trainingpartnername = mtp.managetrainingpartnerid "+
							 "  inner join logindetails as ld on ld.id = pitp.logindetails "+
							 " where mtp.managetrainingpartnerid = '"+id+"'  and ld.status = 'I'";
				System.out.println(sql);
				List list = new ArrayList<>();
				try {
					stmt = conn.prepareStatement(sql);
					System.out.println(stmt.toString());
					rs = stmt.executeQuery();
					
				
					while(rs.next()){
						List l = new ArrayList<>();
						l.add(rs.getInt(1));
						l.add(rs.getString(2));
						l.add(rs.getString(3));
						l.add(rs.getString(4));
						l.add(rs.getInt(5));
						list.add(l);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Gson g =new Gson();
				String newList = g.toJson(list); 
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
