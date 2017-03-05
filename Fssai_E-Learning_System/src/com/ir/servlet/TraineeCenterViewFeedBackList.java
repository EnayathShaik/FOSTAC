package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.zentect.ajax.AjaxRequest;

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
        String name = (request.getQueryString());
        String [] n1 = name.split("&");
        System.out.println("Append Data = "+name);
        String courseType,courseName;
        StringBuffer whereCondition = new StringBuffer();
        whereCondition.append(" WHERE 1=1");
        for(int i=0;i<n1.length;i++){
        	if(n1[i] != null && !n1[i].toUpperCase().equals("NULL")){
        		if(i==0){
            		whereCondition.append(" AND D.coursetypeid="+n1[i]);
            	}else if(i==1){
            		whereCondition.append(" AND C.coursenameid="+n1[i]);
            	}else if(i==2){
            		whereCondition.append(" AND E.personalinformationtraineeid="+n1[i]);
            	}
        	}
        }
        String sql ="";
		sql = "select E.firstname || ' '|| E.middlename ||' '|| E.lastname, D.coursetype,C.coursename, B.feedback,A.feedbackrating  from feedbackdetail A" +
				" inner join feedbackmaster B on(CAST(CAST (A.feedbackid AS NUMERIC(19,4)) AS INT) = B.feedbacktypeid)" +
				" inner join coursename C on(CAST(CAST (A.courseid AS NUMERIC(19,4)) AS INT)=C.coursenameid) "+
				" inner join coursetype D on(C.coursetypeid=D.coursetypeid) "+
				" inner join personalinformationtrainee E on(CAST(CAST (A.userid AS NUMERIC(19,4)) AS INT)=E.logindetails)";
		sql = sql+whereCondition.toString();
				
		String newList = "";
        List list = new AjaxRequest().returnList(sql);
        if(list.size() > 0 || list != null){
    		System.out.println(list);
    		Gson g =new Gson();
    		newList = g.toJson(list); 
    	}
    	out.write(newList);
    	out.flush();		
     	/*Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		String newList=null;
		System.out.println("district 0");
			String sql ="";
			sql = "select E.firstname || ' '|| E.middlename ||' '|| E.lastname, D.coursetype,C.coursename, B.feedback,A.feedbackrating  from feedbackdetail A" +
					" inner join feedbackmaster B on(CAST(CAST (A.feedbackid AS NUMERIC(19,4)) AS INT) = B.feedbacktypeid)" +
					" inner join coursename C on(CAST(CAST (A.courseid AS NUMERIC(19,4)) AS INT)=C.coursenameid) "+
					" inner join coursetype D on(C.coursetypeid=D.coursetypeid) "+
					" inner join personalinformationtrainee E on(CAST(CAST (A.userid AS NUMERIC(19,4)) AS INT)=E.logindetails)";
			sql = sql+whereCondition.toString();
					
					
			Query query = session.createSQLQuery(sql);
			
			List list = query.list();
			System.out.println(list.size());
			
			if(list.size() > 0 || list != null){
				System.out.println(list);
				Gson g =new Gson();
				newList = g.toJson(list); 
			}
			out.write(newList);
		
		
		session.close();
		
		out.flush();		*/
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
