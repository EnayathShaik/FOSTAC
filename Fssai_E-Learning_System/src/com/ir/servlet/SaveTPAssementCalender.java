package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ir.model.TrainingCalendar;
import com.ir.trainingcenter.model.AssesmentCalender;

/**
 * Servlet implementation class DeleteState
 */

public class SaveTPAssementCalender extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveTPAssementCalender() {
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
        System.out.println("Append Data = "+name);
		AssesmentCalender assesmentCalender = new AssesmentCalender();
		Integer trainingID = 0;
		Integer assessorID = 0;
        
        if(name != null && name.length() > 0){
        	String[] whereList = name.split("&");
        	for(int i=0;i<whereList.length;i++){
        		if(i==0){
        			assesmentCalender.setCourseType(whereList[0] != null & !whereList[0].equals("null") & whereList[0].length() > 0 ? whereList[0] : "");
        			//stringBuffer.append(whereList[0] != null & !whereList[0].equals("null") & whereList[0].length() > 0 ? " AND B.COURSETYPEID="+whereList[0] : "");
        		}else if(i==1){
        			assesmentCalender.setCourseName(whereList[1] != null & !whereList[1].equals("null") & whereList[1].length() > 0 ? whereList[1] : "");
        			//stringBuffer.append(whereList[1] != null & !whereList[1].equals("null") & whereList[1].length() > 0 ? " AND C.COURSENAMEID="+whereList[1] : "");
        		}else if(i==2){
        			assesmentCalender.setTrainerName(whereList[2] != null & !whereList[2].equals("null") & whereList[2].length() > 0 ? whereList[2] : "");
        			//stringBuffer.append(whereList[2] != null & !whereList[2].equals("null") & whereList[2].length() > 0 ? " AND A.TRAININGDATE='"+whereList[2]+"'" : "");
        		}else if(i==3){
        			assesmentCalender.setAssessmentDate(whereList[3] != null & !whereList[3].equals("null") & whereList[3].length() > 0 ? whereList[3] : "");
        			//stringBuffer.append(whereList[3] != null & !whereList[3].equals("null") & whereList[3].length() > 0 ? " AND A.TRAININGTIME='"+whereList[3]+"'" : "");
        		}else if(i==4){
        			System.out.println("-----------"+whereList[4]);
        			assesmentCalender.setAssessmentTime(whereList[4] != null & !whereList[4].equals("null") & whereList[4].length() > 0 ? whereList[4] : "");
        			//stringBuffer.append(whereList[4] != null & whereList[4].equals("null") & whereList[4].length() > 0 ? " AND B.COURSETYPEID"+whereList[4] : "");
        		}else if(i==5){
        			trainingID = Integer.parseInt(whereList[5]);
        			//stringBuffer.append(whereList[4] != null & whereList[4].equals("null") & whereList[4].length() > 0 ? " AND B.COURSETYPEID"+whereList[4] : "");
        		}else if(i==6){
        			assessorID = Integer.parseInt(whereList[6]);
        			assesmentCalender.setAssessorID(assessorID);
        			//stringBuffer.append(whereList[4] != null & whereList[4].equals("null") & whereList[4].length() > 0 ? " AND B.COURSETYPEID"+whereList[4] : "");
        		}
        	}
        }
        
        System.out.println("=== "+assesmentCalender.getAssessmentTime());
        
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
				TrainingCalendar trainingCalendar = (TrainingCalendar) session
				.load(TrainingCalendar.class, trainingID);
				trainingCalendar.setAssessmentDate(assesmentCalender.getAssessmentDate());
				trainingCalendar.setAssessmentTime(assesmentCalender.getAssessmentTime());
				//trainingCalendar.setAssessor(assesmentCalender.getAssessorID());
		session.update(trainingCalendar);
		session.beginTransaction().commit();
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
