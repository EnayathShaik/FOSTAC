package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.zentect.ajax.AjaxRequest;

/**
 * Servlet implementation class MyServlt
 */
public class getFeedbackDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getFeedbackDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in get feedback details data servlet");

		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		String name = (request.getQueryString());
		System.out.println("passing name  1 :" + name);
		String names[] = name.split("&");
		String trainingcenter , userid , courseid ,coursename,trainingdate;
		try{
			trainingcenter = names[0];
			
			}catch(Exception e){
			trainingcenter = "%";
			}
		try{
		 userid = names[1];
		}catch(Exception e){
			userid = "%";
		}
		try{
		 courseid= names[2];
		}catch(Exception e){
			courseid = "%";
		}
		try{
		coursename= names[3];
		}catch(Exception e){
			coursename = "%";
		}
		try{
		trainingdate= names[4];
		}catch(Exception e){
			trainingdate = "%";
		}
		String sql="select fdm.feedback as feedbackId,fbd.feedbackrating as feedbackRating from feedbackdetail fbd left join feedbackmaster fdm on (fbd.feedbackid = cast(fdm.feedbacktypeid as varchar(10) ) ) left join courseenrolleduser ceu on fbd.userid = cast(ceu.logindetails as varchar(10)) left join trainingcalendar tc on (tc.trainingcalendarid = ceu.trainingcalendarid) left join personalinformationtrainingpartner ptp on (ptp.personalinformationtrainingpartnerid = tc.trainingcenter) left join logindetails ld on  ld.id = ptp.logindetails"+
				" where  fbd.courseid  like '"+courseid+"%'  and cast(tc.coursename as varchar(10))  like '"+coursename+"%' and tc.trainingdate like'"+trainingdate+"%' and cast(tc.trainingcenter as varchar(10)) like '"+trainingcenter+"%' and fbd.userid like '"+userid+"%'  order by fbd.feedbackid  " ;
		String newList = "";
		List list = new AjaxRequest().returnList(sql);
		if(list.size()>0){
			Gson g =new Gson();
			newList = g.toJson(list); 
		}
		out.write(newList);
		out.flush();
		
		/*Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		String sql="select fdm.feedback as feedbackId,fbd.feedbackrating as feedbackRating from feedbackdetail fbd left join feedbackmaster fdm on (fbd.feedbackid = cast(fdm.feedbacktypeid as varchar(10) ) ) left join courseenrolleduser ceu on fbd.userid = cast(ceu.logindetails as varchar(10)) left join trainingcalendar tc on (tc.trainingcalendarid = ceu.trainingcalendarid) left join personalinformationtrainingpartner ptp on (ptp.personalinformationtrainingpartnerid = tc.trainingcenter) left join logindetails ld on  ld.id = ptp.logindetails"+
				" where  fbd.courseid  like '"+courseid+"%'  and cast(tc.coursename as varchar(10))  like '"+coursename+"%' and tc.trainingdate like'"+trainingdate+"%' and cast(tc.trainingcenter as varchar(10)) like '"+trainingcenter+"%' and fbd.userid like '"+userid+"%'  order by fbd.feedbackid  " ;
		Query query = session.createSQLQuery(sql);
		System.out.println("sql>"+sql);
		List list = query.list();
		Gson g =new Gson();
		String newList = g.toJson(list); 
		out.write(newList);
		out.flush();*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
