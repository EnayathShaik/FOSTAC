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

public class GetAssessmentQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAssessmentQuestion() {
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
        String id = (request.getQueryString());
		System.out.println("passing id   :" + id);
		
		String sql ="";
		//sql = "select B.coursetype,C.coursename,A.trainingdate,A.trainingtime,A.trainername from trainingcalendar A inner join coursetype B on(A.coursetype=B.coursetypeid)inner join coursename C on(A.coursename=C.coursenameid)";
		sql = "select A.assessmentquestionid,A.coursetype,A.coursename,A.questionnumber,A.questionhint," +
				" A.questiontitle,A.noofoption,A.correctanswer,A.optionone,A.optiontwo,A.optionthree,A.optionfour, " +
				" A.optionfive,A.optionsix from assessmentquestion A where A.assessmentquestionid = "+id;
		String newList=null;
		List list = new AjaxRequest().returnList(sql);
		System.out.println(list.size());
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
		//sql = "select B.coursetype,C.coursename,A.trainingdate,A.trainingtime,A.trainername from trainingcalendar A inner join coursetype B on(A.coursetype=B.coursetypeid)inner join coursename C on(A.coursename=C.coursenameid)";
		sql = "select A.assessmentquestionid,A.coursetype,A.coursename,A.questionnumber,A.questionhint," +
				" A.questiontitle,A.noofoption,A.correctanswer,A.optionone,A.optiontwo,A.optionthree,A.optionfour, " +
				" A.optionfive,A.optionsix from assessmentquestion A where A.assessmentquestionid = "+id;
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
		out.flush();*/		
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
