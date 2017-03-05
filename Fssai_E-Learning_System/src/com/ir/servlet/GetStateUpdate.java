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
import com.ir.model.State;

/**
 * Servlet implementation class MyServlt
 */

public class GetStateUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStateUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
				System.out.println("in load state update data servlet");
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
				 String sql="select * from state  where status = 'A'" ;
				 List<State> list = new ArrayList<>();
				try {
					stmt = conn.prepareStatement(sql);
					System.out.println(stmt.toString());
					rs = stmt.executeQuery();
					
				
					while(rs.next()){
						State state = new State();
						state.setStateId(rs.getInt("stateid"));
						state.setStateName(rs.getString("statename"));
						list.add(state);
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
