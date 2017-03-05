package com.ir.captcha;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import java.sql.Timestamp;


public class Otptime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Otptime() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  d1 = (String)request.getSession().getAttribute("d1");
		
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String d2 = dateFormat.format(date);
		Date d11 = null;
		Date d22 = null;
		try{
		//long ts = System.currentTimeMillis() -	Timestamp.parse(beforetime);
		System.out.println("d1.."+d1);
		System.out.println("d2.."+d2);
		
		d11 = dateFormat.parse(d1);
		d22 = dateFormat.parse(d2);
		//in milliseconds
		long diff = d22.getTime() - d11.getTime();
		
		long diffSeconds = diff / 1000;
		System.out.println("time difference in seconds.."+diffSeconds);
		PrintWriter out = response.getWriter();
		
		if(1<2){
		System.out.println("call");
		out.println("<p style='color: red;' align=center>Time Out.</p> ");
	    RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.include(request, response);
		}
		}catch(Exception e)
		{e.printStackTrace();}
	}
}
