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

public class TraineeCenterViewTraineeLists extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TraineeCenterViewTraineeLists() {
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
        
        StringBuffer stringBuffer = new StringBuffer();
       // stringBuffer.append("WHERE 1=1 ");
        //stringBuffer.append(" WHERE F.loginid ='"+loginId+"'");
        if(name != null && name.length() > 0 ){
        	String[] whereList = name.split("&");
        	for(int i=0;i<whereList.length;i++){
        		if(i==0){
        			stringBuffer.append(whereList[0] != null & !whereList[0].equals("null") & whereList[0].length() > 0 ? " AND E.coursetypeid="+whereList[0] : "");
        		}else if(i==1){
        			stringBuffer.append(whereList[1] != null & !whereList[1].equals("null") & whereList[1].length() > 0 & whereList[1] == "0"  ? " AND D.COURSENAMEID="+whereList[1] : "");
        		}else if(i==2){
        			
        			stringBuffer.append(whereList[2] != null & !whereList[2].equals("null") & whereList[2].length() > 0 ? " AND B.TRAININGDATE='%"+whereList[2].replaceAll("%20", " ")+"'" : "");
        		}else if(i==3){
        			
        			stringBuffer.append(whereList[3] != null & !whereList[3].equals("null") & whereList[3].length() > 0 ? " AND B.TRAININGTIME='%"+whereList[3].replaceAll("%20", " ")+"'" : "");
        		}else if(i==4){
        			
        			stringBuffer.append(whereList[4] != null & !whereList[4].equals("null") & whereList[4].length() > 0 ? " AND A.PAYMENTSTATUS='"+whereList[4]+"'" : "");
        			
        		}else if(i==5){
        			
        			stringBuffer.append(whereList[5] != null & whereList[5].length() > 0 ? " AND  replace(D.classroom ||''|| D.online,'Nil','')= '"+whereList[5]+"'" : "");
        		
        		}
        	}
        }
        
        System.out.println("String -- "+stringBuffer.toString());
        String sql ="";
        sql = "select  B.batchCode,D.courseCode,B.trainingdate,B.trainingtime,C.firstname || ' '|| C.middlename ||' '|| C.lastname as participantName,replace(D.classroom ||' '|| D.online,'Nil',''),D.status from courseenrolleduser  A"
				+ " inner join trainingcalendar B on(A.trainingcalendarid= B.trainingcalendarid)"
				+ " inner join coursename D on (D.coursenameid = B.coursename)"
				+ " inner join coursetype E on (E.coursetypeid = B.coursetype)"
				+ "  inner join personalinformationtrainee C on (C.logindetails = A.logindetails)  "
				+ " inner join logindetails F on(F.id=C.logindetails)";
        sql = sql + stringBuffer.toString();
		List list = new AjaxRequest().returnList(sql);
		String newList=null;
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
		sql = "select B.coursetype,C.coursename,A.trainingdate,A.trainingtime,A.trainername," +
				//"concat(D.firstname,' ',D.middlename,' ',D.lastname),C.modeoftraining,'' from trainingcalendar A " +
				"C.modeoftraining from trainingcalendar A " +
				"inner join coursetype B on(A.coursetype=B.coursetypeid) " +
				"inner join coursename C on(A.coursename=C.coursenameid) ";
				//"inner join personalinformationtrainer D on(A.trainername::int=D.personalinformationtrainerid)";
		
		
		sql = "select  E.coursetype,D.coursename,B.trainingdate,B.trainingtime,C.firstname || ' '|| C.middlename ||' '|| C.lastname as participantName,replace(D.classroom ||' '|| D.online,'Nil',''),D.status from courseenrolleduser  A"
				+ " inner join trainingcalendar B on(A.trainingcalendarid= B.trainingcalendarid)"
				+ " inner join coursename D on (D.coursenameid = B.coursename)"
				+ " inner join coursetype E on (E.coursetypeid = B.coursetype)"
				+ "  inner join personalinformationtrainee C on (C.logindetails = A.logindetails)  "
				+ " inner join logindetails F on(F.id=C.logindetails)";
		
		
		
		sql = "select B.coursetype,C.coursename,A.trainingdate,A.trainingtime,A.trainername," +
				"G.firstname||G.middlename||G.lastname," +
				"F.paymentstatus from trainingcalendar A " +
				"inner join coursetype B on(A.coursetype=B.coursetypeid)  " +
				"inner join coursename C on(A.coursename=C.coursenameid)   " +
				"inner join personalinformationtrainingpartner D on(A.trainingcenter=D.personalinformationtrainingpartnerid)" +
				"inner join logindetails E on(D.logindetails=E.ID) " +
				"inner join courseenrolleduser F on(A.trainingcalendarid=F.trainingcalendarid) " +
				"inner join personalinformationtrainee G on(CAST(CAST (F.logindetails AS NUMERIC(19,4)) AS INT)=G.logindetails) ";
		
		sql = sql + stringBuffer.toString();
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
