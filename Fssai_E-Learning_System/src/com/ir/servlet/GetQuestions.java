package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.google.gson.Gson;

/**
 * Servlet implementation class DeleteState
 */

public class GetQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetQuestions() {
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
		String[] totalConnected = name.split("&");
		
		int  courseNameSearch = Integer.parseInt((totalConnected[0].split("="))[1]);
		int  courseTypeSearch = Integer.parseInt((totalConnected[1].split("="))[1]);
		
		String courseNameSearch1 , courseTypeSearch1;
		if(courseNameSearch == 0){
			courseNameSearch1 ="%";
		}else{
			courseNameSearch1 = (totalConnected[0].split("="))[1];
		}
		
		if(courseTypeSearch == 0){
			courseTypeSearch1 ="%";
		}else{
			courseTypeSearch1 = (totalConnected[0].split("="))[1];
		}
		
		
		System.out.println("contentLocationInput  "+courseNameSearch + "  "+ courseNameSearch1);
		System.out.println("courseTypeInput   "+courseTypeSearch + "  "+ courseTypeSearch1);
		
		String sql = "select ct.coursetype , cn.coursename , aq.questionnumber from assessmentquestion as aq "+
					" inner join coursetype as ct on ct.coursetypeid = aq.coursetype"+
					" inner join coursename as cn on cn.coursenameid = aq.coursename";
					//"where CAST(aq.coursetype AS varchar(10))  like '"+courseTypeSearch1+"' and CAST(aq.coursename AS varchar(10))  like '"+ courseNameSearch1+"'";
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Query query = session.createSQLQuery(sql);
		List assessmentQuestionsList = query.list();
		session.close();
		
		if(assessmentQuestionsList != null && assessmentQuestionsList.size() > 0){
			System.out.println("data seleted finally");
		}else{
			System.out.println("no records available");
		}
		Gson g =new Gson();
		String newList = g.toJson(assessmentQuestionsList); 
		out.write(newList);
		out.flush();
		/*try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","Fss2iZentech");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String sql="insert into managecoursecontent "
	    		+ "		    (contentLocationInput,		courseTypeInput,		courseNameInput,		modeOfTrainingInput,	contentTypeInput,	contentNameInput 	, contentLinkInput)"
	    		+ " values ('"+contentLocationInput+ "' , "+courseTypeInput+" , "+courseNameInput+" , '"+modeOfTrainingInput+"' , '"+contentTypeInput+"' , '"+contentNameInput+" ', '"+ contentLinkInput+"')";
	    int i = 0;
	    System.out.println("before try block");
		try {
			System.out.println("in try block");
			 i = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("in catch servlet ");
			e.printStackTrace();
		}
		if(i > 0 || i != 0){
			//String name_status= "OK";
			System.out.println("inserted");
			out.println("inserted");
		}else{
			//String name_status="";
			//out.println(""+name+" is available to use");
			System.out.println("not inserted");
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
