package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;
import com.zentect.ajax.AjaxRequest;
/**
 * Servlet implementation class DeleteState
 */

public class SearchVacancy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchVacancy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void callPost(HttpServletRequest request, HttpServletResponse response,String loginId,int profileCode,int userId) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("loginId == "+loginId);
		System.out.println("userId == "+userId);
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		String name = (request.getQueryString());
		String [] n1 = name.split("&");
		
		String courseType,courseName , trainingDate , requiredExp ,noOfVacancy,selectAll, trainingendtime, trainingcenter;
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
			requiredExp = n1[3].split("=")[1];
		}
		catch(Exception e){
			requiredExp = "%";
		}
		
		try{
			noOfVacancy = n1[4].split("=")[1];
		}
		catch(Exception e){
			noOfVacancy = "%";
		}
		
		try{
			trainingcenter = n1[5].split("=")[1];
		}
		catch(Exception e){
			trainingcenter = "%";
		}
		
		try{
			trainingendtime = "%"+n1[6].split("=")[1].replaceAll("%20", " ");
		}
		catch(Exception e){
			trainingendtime = "%";
		}
		
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		String newList=null;
		System.out.println("district 0");
		String loginCK = "";
		if(profileCode == 7){
			loginCK = "1=1";
		}else{
			loginCK = "1=1";
			//loginCK = "E.loginid ='"+loginId+"'";
		}
		String sql ="";
		sql = "select pvtc.postvacancytrainingcenterid , ct.coursetype , cn.coursecode , pvtc.trainingdate , pvtc.trainingendtime ,pvtc.requiredexp , pvtc.noofvacancy,pvtc.loginid   from postvacancytrainingcenter pvtc left join coursetype as ct on ct.coursetypeid = pvtc.coursetype left join coursename as cn on cn.coursenameid = pvtc.coursename left join personalinformationtrainingpartner D on(pvtc.trainingcenter=D.personalinformationtrainingpartnerid)  left join  logindetails E on(D.logindetails=E.ID) " +
				" where "+loginCK+"  and pvtc.trainingcenter='"+trainingcenter+"'  and  cast(ct.coursetypeid as varchar(10))  like '"+courseType+"%' and CAST(cn.coursenameid AS VARCHAR(10)) like '"+courseName+"%' and  CAST(pvtc.trainingdate AS VARCHAR(100)) like '"+trainingDate+"%'   and cast(pvtc.requiredexp as varchar(10))  like '"+requiredExp+"%' and cast(pvtc.noofvacancy as varchar(10)) like '"+noOfVacancy+"%'  and cast(pvtc.trainingendtime as varchar(100)) like   '"+trainingendtime+"%'  ";
		
		List list = new AjaxRequest().returnList(sql);
		System.out.println(list.size());
		if(list.size() > 0 || list != null){
			System.out.println(list);
			Gson g =new Gson();
			newList = g.toJson(list); 
		}
		out.write(newList);
		out.flush();		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession=request.getSession(false);
		String loginId="";
		int profileId=0;
		Integer userId = 0;
		if(null!=httpSession.getAttribute("logId")){
			 loginId=httpSession.getAttribute("logId").toString();
			 profileId=Integer.parseInt(httpSession.getAttribute("profileId").toString());
			 userId = (Integer) httpSession.getAttribute("userId");
		}
		
		// TODO Auto-generated method stub
		callPost(request, response,loginId,profileId,userId);
	}

}
