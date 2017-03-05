package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class DeleteState
 */

public class ManageCourseContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageCourseContent() {
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
		String contentLocationInput , courseTypeInput,courseNameInput,modeOfTrainingInput,contentTypeInput,contentNameInput,contentLinkInput;
		contentLocationInput = (totalConnected[0].split("="))[1];
		courseTypeInput = (totalConnected[1].split("="))[1];
		courseNameInput = (totalConnected[2].split("="))[1];
		modeOfTrainingInput = (totalConnected[3].split("="))[1];
		contentTypeInput = (totalConnected[4].split("="))[1];
		contentNameInput = (totalConnected[5].split("="))[1];
		contentLinkInput = (totalConnected[6].split("="))[1];
		System.out.println("contentLocationInput  "+contentLocationInput);
		System.out.println("courseTypeInput   "+courseTypeInput);
		System.out.println("courseNameInput    "+   courseNameInput);
		System.out.println("modeOfTrainingInput    "+   modeOfTrainingInput);
		System.out.println("contentTypeInput    "+   contentTypeInput);
		System.out.println("contentNameInput    "+   contentNameInput);
		System.out.println("contentLinkInput    "+   contentLinkInput);
		
		com.ir.model.ManageCourseContent manageCourseContent = new com.ir.model.ManageCourseContent();
		manageCourseContent.setContentLocationInput(contentLocationInput);
		manageCourseContent.setCourseTypeInput(Integer.parseInt(courseTypeInput));
		manageCourseContent.setCourseNameInput(Integer.parseInt(courseNameInput));
		manageCourseContent.setModeOfTrainingInput(modeOfTrainingInput);
		manageCourseContent.setContentTypeInput(contentTypeInput);
		manageCourseContent.setContentNameInput(contentNameInput);
		manageCourseContent.setContentLinkInput(contentLinkInput);
		
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Integer manageCourseContentId = (Integer)session.save(manageCourseContent);
		tx.commit();
		session.close();
		if(manageCourseContentId > 0){
			System.out.println("data inserted finally");
		}else{
			System.out.println("error again");
		}
		/*try {
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
