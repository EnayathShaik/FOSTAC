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
import com.ir.model.FeedbackMaster;
import com.ir.model.TrainingPartner;
import com.ir.service.PageLoadService;
import com.ir.service.impl.PageLoadServiceImpl;
import com.itextpdf.text.log.SysoCounter;

/**
 * Servlet implementation class MyServlt
 */

public class SearchFeedbackMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFeedbackMaster() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
				String searchStr = request.getQueryString();
				String courseType ="" , catagory ="", feedback = "" , status = "";
				if(!searchStr.equalsIgnoreCase("ALL")){
					
					 String [] n1 = searchStr.split("&");
						
						
						try{
							courseType = (n1[0].split("="))[1];
						}catch(Exception e){
							courseType = "%";
						}
						
						
						
						System.out.println("-----> "+(n1[1].split("="))[1]);
						try{
							catagory = n1[1].split("=")[1];
							
						}catch(Exception e){
							catagory ="%";
						}
						
						try{
							feedback = (n1[2].split("="))[1];
						}catch(Exception e){
							feedback = "%";
						}
						
						 status = (n1[3].split("="))[1] ;
				}
				response.setContentType("text/html;charset=UTF-8");
		        PrintWriter out = response.getWriter();
			
		        Configuration conf = new Configuration();
				conf.configure("/hibernate.cfg.xml");
				SessionFactory sf = conf.buildSessionFactory();
				Session session = sf.openSession();
				String newList=null;
				String sql  = null;
				
				if(searchStr.equalsIgnoreCase("ALL"))
				sql = "select feedbacktypeid,coursetype,catogery,feedback,status from feedbackmaster";
				else
				sql = "select feedbacktypeid,coursetype,catogery,feedback,status from feedbackmaster"+
				" where cast (coursetype as varchar(20)) like '"+courseType+"%' and cast(catogery as varchar(20)) like  '"+catagory+"%' and cast(feedback as varchar(20)) like '"+feedback+"%' and cast(status as varchar(10)) like '"+status+"%'";
					Query query = session.createSQLQuery(sql);
					List<FeedbackMaster> list = query.list();
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
