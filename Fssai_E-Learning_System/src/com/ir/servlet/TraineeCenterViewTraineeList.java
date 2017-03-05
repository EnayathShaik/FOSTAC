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
import com.zentech.logger.ZLogger;
import com.zentect.ajax.AjaxRequest;
/**
 * Servlet implementation class DeleteState
 */

public class TraineeCenterViewTraineeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TraineeCenterViewTraineeList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void callPost(HttpServletRequest request, HttpServletResponse response,String loginId,int profileCode) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
			System.out.println("*******"+loginId);
			String name = (request.getQueryString());
			String [] n1 = name.split("&");
	        System.out.println("Append Data = "+name);
	  
	        
	        
	        String courseType,courseName , trainingStartDate , trainingEndDate,trainer , assessmentDateTime , assessmentAgencyName , assessorName , seatCapacity , type ;
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
				trainingStartDate = n1[2].split("=")[1];
				trainingStartDate = "%"+trainingStartDate.replaceAll("%20", " ");
				System.out.println("trainingStartDate "+trainingStartDate);
			}
			catch(Exception e){
				trainingStartDate = "%";
			}
			
			try{
				trainingEndDate = n1[3].split("=")[1];
				trainingEndDate = "%"+trainingEndDate.replaceAll("%20", " ");
			}
			catch(Exception e){
				trainingEndDate = "%";
			}
	        
			try{
				trainer = n1[4].split("=")[1];
			}
			catch(Exception e){
				trainer = "%";
			}
			
			try{
				assessmentDateTime = n1[5].split("=")[1];
				assessmentDateTime = "%"+assessmentDateTime.replaceAll("%20", " ");
			}
			catch(Exception e){
				assessmentDateTime = "%";
			}
			
			try{
				assessmentAgencyName = n1[6].split("=")[1];
			}
			catch(Exception e){
				assessmentAgencyName = "%";
			}
			
			try{
				assessorName = n1[7].split("=")[1];
			}
			catch(Exception e){
				assessorName = "%";
			}
			
			try{
				seatCapacity = n1[8].split("=")[1];
			}
			catch(Exception e){
				seatCapacity = "%";
			}
			
			try{
				type = n1[9].split("=")[1];
			}
			catch(Exception e){
				type = "%";
			}
	    
			
			 String sql ="";
				sql = "select A.trainingcalendarid , A.batchcode,C.coursecode,A.trainingdate,A.trainingtime,pitr.firstname || ' '|| pitr.middlename ||' '|| pitr.lastname as participantName   " +
						" , A.coursetype as coursetypeid  , A.coursename as coursenameid , A.trainername as trainernameid , A.assessmentDatetime , A.assessmentpartnername , D.assessmentagencyname ,  A.assessor , cast(E.firstname || ' ' ||  E.middlename || ' ' ||  E.lastname as varchar(100)) , A.seatcapacity , case when  A.type ='P' then 'Paid' else 'Un-Paid'  end as type ,A.type as typecode  from trainingcalendar A " +
						" inner join coursetype B on(A.coursetype=B.coursetypeid)" +
						" inner join coursename C on(A.coursename=C.coursenameid)"+
						" left join ManageAssessmentAgency D on(cast(A.assessmentpartnername as numeric)=D.manageassessmentagencyid)"+
						" left join personalInformationAssessor E on(A.assessor=E.personalinformationassessorid)"+
						" inner join personalinformationtrainer as pitr on CAST(CAST (A.trainername AS NUMERIC(19,4)) AS INT) = pitr.personalinformationtrainerid "
						+" where A.tcStatus is null  and  cast( B.coursetypeid  as varchar(10)) like '"+courseType+"%' " +
								"and  cast(C.coursenameid as varchar(10)) like '"+courseName+"%' and  " +
										"cast(A.trainingdate as varchar(100)) like '"+trainingStartDate+"%' " +
												"and cast(A.trainingtime as varchar(100)) like '"+trainingEndDate+"%' and cast(A.trainername as varchar(100)) like '"+trainer+"%'  and cast(coalesce(A.assessmentdatetime , '') as varchar(100)) like '"+assessmentDateTime+"%' and  cast(A.assessmentpartnername as varchar(100)) like '"+assessmentAgencyName+"%' and  cast(A.assessor as varchar(100)) like '"+assessorName+"%' and  cast(A.seatcapacity as varchar(100)) like '"+seatCapacity+"%'   AND to_timestamp(COALESCE(trainingdate, '19900101010101'),'DD-MM-YYYY') >= CURRENT_TIMESTAMP - INTERVAL '1 days' Order By A.trainingcalendarid desc";
			String newList=null;
			List list = new AjaxRequest().returnList(sql);
			new ZLogger("Info", sql, "TraineeCenterViewTraineeList.java");
			if(list != null || list.size() > 0 ){
				System.out.println(list);
				Gson g =new Gson();
				newList = g.toJson(list); 
			}
			out.write(newList);
			out.flush();	
		}catch(Exception e){
			e.printStackTrace();
		}
		
			
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
