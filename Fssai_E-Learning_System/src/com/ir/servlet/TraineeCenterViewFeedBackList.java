package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;
import com.ir.model.PostVacancyTrainingCenterBean;

/**
 * Servlet implementation class DeleteState
 */

public class TraineeCenterViewFeedBackList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TraineeCenterViewFeedBackList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void callPost(HttpServletRequest request, HttpServletResponse response,String loginId,int profileCode) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String courseType,courseName;
    	String name = (request.getQueryString());
		String [] n1 = name.split("&");
        System.out.println("Append Data = "+name);
		try{
			courseType = n1[0].split("=")[1];
		}
		catch(Exception e){
			courseType = "%";	
		}
		
		try{
			courseName = n1[1].split("=")[1];	
		}catch(Exception e){
			courseName = "%";	
		}
	
     	Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		String newList=null;
		
			String sql ="";
			sql = "select E.firstname || ' '|| E.middlename ||' '|| E.lastname, D.coursetype,C.coursename, B.feedback,A.feedbackrating  from feedbackdetail A" +
					" inner join feedbackmaster B on(CAST(CAST (A.feedbackid AS NUMERIC(19,4)) AS INT) = B.feedbacktypeid)" +
					" inner join coursename C on(CAST(CAST (A.courseid AS NUMERIC(19,4)) AS INT)=C.coursenameid) "+
					" inner join coursetype D on(C.coursetypeid=D.coursetypeid) "+
					" inner join personalinformationtrainee E on(CAST(CAST (A.userid AS NUMERIC(19,4)) AS INT)=E.logindetails)"
					+" WHERE cast( D.coursetypeid  as varchar(10)) like '"+courseType+"%' and cast(C.coursenameid as varchar(10))  like '"+courseName+"%' ";
					
			Query query = session.createSQLQuery(sql);
			System.out.println(query);
			List list = query.list();
			System.out.println(list.size());
			
			if(list.size() > 0 || list != null){
				System.out.println(list);
				Gson g =new Gson();
				newList = g.toJson(list); 
			}
			out.write(newList);
		
		
		session.close();
		
		out.flush();		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession=request.getSession(false);
		String loginId="";
		int profileId=0;
		if(null!=httpSession.getAttribute("logId")){
			 loginId=httpSession.getAttribute("logId").toString();
			 profileId=Integer.parseInt(httpSession.getAttribute("profileId").toString());
		}
		
		// TODO Auto-generated method stub
		callPost(request, response,loginId,profileId);
	}

}
