package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
		StringBuffer wherebuffer = new StringBuffer();
		wherebuffer.append(" WHERE 1=1 ");
		if(courseTypeSearch > 0){
			wherebuffer.append(" AND ct.coursetypeid="+courseTypeSearch);
		}
		if(courseNameSearch > 0){
			wherebuffer.append(" AND cn.coursenameid="+courseNameSearch);
		}
		
		String sql = "select ct.coursetype , cn.coursename , aq.questionnumber, aq.assessmentquestionid, cn.coursecode   from assessmentquestion as aq "+
					" inner join coursetype as ct on ct.coursetypeid = aq.coursetype"+
					" inner join coursename as cn on cn.coursenameid = aq.coursename";
		sql = sql + wherebuffer.toString();
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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
