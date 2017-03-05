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

public class TraineeCenterPaymentConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TraineeCenterPaymentConfirmation() {
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
		System.out.println("*******"+loginId);
		String name = (request.getQueryString());
		String [] n1 = name.split("&");
        System.out.println("Append Data = "+name);
  
        
        
        String courseType,courseName , trainingDate , trainingtime,status ;
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
		
	
		try{
			trainingDate = "%"+n1[2].split("=")[1].replaceAll("%20", " ");
		}
		catch(Exception e){
			trainingDate = "%";
		}
		
		try{
			trainingtime = "%"+n1[3].split("=")[1].replaceAll("%20", " ");
		}
		catch(Exception e){
			trainingtime = "%";
		}
        
		try{
			status = n1[4].split("=")[1];
		}
		catch(Exception e){
			status = "%";
		}
		String sql = "";
		sql = "select  B.batchcode,D.coursecode,B.trainingdate,B.trainingtime,C.firstname || ' '|| C.middlename ||' '|| C.lastname as participantName,D.modeoftraining,A.paymentstatus,A.courseenrolleduserid from courseenrolleduser  A"
				+ " inner join trainingcalendar B on(A.trainingcalendarid= B.trainingcalendarid)"
				+ " inner join personalinformationtrainingpartner C on (C.personalinformationtrainingpartnerid = B.trainingcenter)"
				+ " inner join coursename D on (D.coursenameid = B.coursename)"
				+ " inner join coursetype E on (E.coursetypeid = B.coursetype)"
				+ " inner join logindetails F on (F.ID = C.logindetails)"
				+" WHERE A.status = 'N' and  cast(E.coursetypeid  as varchar(10)) like '"+courseType+"%' and cast(D.COURSENAMEID as varchar(10))  like '"+courseName+"%'  and  cast(B.TRAININGDATE as varchar(10)) like '"+trainingDate+"%' and  cast(B.TRAININGTIME as varchar(10)) like '"+trainingtime+"%'  and cast(A.paymentstatus as varchar(10)) like '"+status+"%' "; 
					//	"  AND F.loginid ='"+loginId+"' ";
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
		sql = "select B.coursetype,C.coursename,A.trainingdate,A.trainingtime,pitr.firstname || ' '|| pitr.middlename ||' '|| pitr.lastname as participantName " +
				"from trainingcalendar A " +
				" inner join coursetype B on(A.coursetype=B.coursetypeid)" +
				" inner join coursename C on(A.coursename=C.coursenameid)"+
				" inner join personalinformationtrainer as pitr on CAST(CAST (A.trainername AS NUMERIC(19,4)) AS INT) = pitr.personalinformationtrainerid ";
		sql = "select  E.coursetype,D.coursename,B.trainingdate,B.trainingtime,C.firstname || ' '|| C.middlename ||' '|| C.lastname as participantName,D.modeoftraining,A.paymentstatus,A.courseenrolleduserid from courseenrolleduser  A"
				+ " inner join trainingcalendar B on(A.trainingcalendarid= B.trainingcalendarid)"
				+ " inner join personalinformationtrainingpartner C on (C.personalinformationtrainingpartnerid = B.trainingcenter)"
				+ " inner join coursename D on (D.coursenameid = B.coursename)"
				+ " inner join coursetype E on (E.coursetypeid = B.coursetype)"
				+ " inner join logindetails F on (F.ID = C.logindetails)"
				+" WHERE A.status = 'N' and  cast(E.coursetypeid  as varchar(10)) like '"+courseType+"%' and cast(D.COURSENAMEID as varchar(10))  like '"+courseName+"%'  and  cast(B.TRAININGDATE as varchar(10)) like '"+trainingDate+"%' and  cast(B.TRAININGTIME as varchar(10)) like '"+trainingtime+"%'  and cast(A.paymentstatus as varchar(10)) like '"+status+"%' "; 
					//	"  AND F.loginid ='"+loginId+"' ";
		
		System.out.println(sql);
		Query query = session.createSQLQuery(sql);
		List list = query.list();
		System.out.println(list.size());
		session.close();
		if(list.size() > 0 || list != null){
			System.out.println(list);
			Gson g =new Gson();
			newList = g.toJson(list); 
		}
		out.write(newList);
		out.flush();	*/	
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
