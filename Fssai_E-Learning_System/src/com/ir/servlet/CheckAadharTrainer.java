package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zentect.ajax.AjaxRequest;

/**
 * Servlet implementation class MyServlt
 */
@WebServlet("/CheckAadharTrainer")
public class CheckAadharTrainer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAadharTrainer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try{
			response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
			String name = (request.getQueryString());
			System.out.println("passing name   :" + name);
			String sql="select * from personalinformationtrainer where aadharnumber = '" + name + "'";
			List list = new AjaxRequest().returnList(sql);
			if(list.size() > 0){
				System.out.println("not available to use");
				out.println("Already");
			}else{
				System.out.println("not in database");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
