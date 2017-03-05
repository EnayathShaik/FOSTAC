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
@WebServlet("/CheckAadharTrainee")
public class CheckAadharTrainee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAadharTrainee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				response.setContentType("text/html;charset=UTF-8");
		        PrintWriter out = response.getWriter();
				String name = (request.getQueryString());
				System.out.println("passing name   :" + name);
				String sqlQuery = "select * from personalinformationtrainee where aadharnumber = '" + name + "'";
				List list = new AjaxRequest().returnList(sqlQuery);
				if(list.size() > 0){
		        	out.println("Already");
				}else{
					System.out.println("Not In Database.");
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
