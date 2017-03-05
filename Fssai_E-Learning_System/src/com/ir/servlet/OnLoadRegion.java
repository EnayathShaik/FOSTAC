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

public class OnLoadRegion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnLoadRegion() {
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
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("onload admin region list");
		response.setContentType("text/html;charset=UTF-8");
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
		String sql = "select d.districtName , r.regionname ,r.id , s.statename , c.cityname ,r.cityid , r.districtid , r.stateid , r.status  from region r left join city c on c.cityid = r.cityid left join district d on d.districtid = r.districtid left join state s on s.stateid = r.stateid  ";
		List list = new ArrayList<>();
		try {
			stmt = conn.prepareStatement(sql);
			System.out.println(stmt.toString());
			rs = stmt.executeQuery();
			
		
			while(rs.next()){
				List l = new ArrayList<>();
				l.add(rs.getString(1));
				l.add(rs.getString(2));
				l.add(rs.getInt(3));
				l.add(rs.getString(4));
				l.add(rs.getString(5));
				l.add(rs.getString(6));
				l.add(rs.getString(7));
				l.add(rs.getString(8));
				l.add(rs.getString(9));
				list.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson g =new Gson();
		String newList = g.toJson(list); 
		out.write(newList);
		out.flush();

	
	}

}
