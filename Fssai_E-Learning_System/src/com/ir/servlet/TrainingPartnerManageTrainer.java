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

import com.google.gson.Gson;
import com.ir.model.PostVacancyTrainingCenterBean;
import com.ir.util.HibernateUtil;
import com.zentect.ajax.AjaxRequest;
/**
 * Servlet implementation class DeleteState
 */

public class TrainingPartnerManageTrainer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainingPartnerManageTrainer() {
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
		Integer id = 0;
		if(name!=null && name.length() > 0 && !name.contains("&")){
		     id = Integer.valueOf(name);
		}
		String [] n1 = name.split("&");
        System.out.println("Append Data = "+name);
  
        
        
        String courseType,courseName , trainerName ;
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
			trainerName = n1[2].split("=")[1];	
		}catch(Exception e){
			trainerName = "%";	
		}
		
		
		if(id > 0){
			SessionFactory sf = new HibernateUtil().getSessionFactory();
			Session session = sf.openSession();
			System.out.println("ID == "+id);
			PostVacancyTrainingCenterBean centerBean = (PostVacancyTrainingCenterBean) session.load(PostVacancyTrainingCenterBean.class, id);
			session.delete(centerBean);
			session.beginTransaction().commit();
			out.write("Successfully Removed");
			out.flush();
		}else{
			String sql ="";
			sql = "select C.coursetype,D.coursecode,E.firstname || ' '|| E.middlename ||' '|| E.lastname,B.vacancyenrolledid from postvacancytrainingcenter A" +
					" inner join trainingcentervacancyenrolled B on(A.postvacancytrainingcenterid=B.postvacancyid)" +
					" inner join coursetype C on(A.coursetype=C.coursetypeid) "+
					" inner join coursename D on(A.coursename=D.coursenameid) "+
					" inner join personalinformationtrainer E on (E.logindetails = CAST(CAST (B.loginid AS NUMERIC(19,4)) AS INT))" +
					" where  cast(C.coursetypeid as varchar(10)) like '"+courseType+"%'  and cast(D.coursename as varchar(10)) like  '"+courseName+"%' and cast((E.firstname || ' '|| E.middlename ||' '|| E.lastname) as varchar(100)) like  '"+trainerName+"%'   " ;
		
			List list = new AjaxRequest().returnList(sql);
			String newList=null;
			if(list.size() > 0 || list != null){
				System.out.println(list);
				Gson g =new Gson();
				newList = g.toJson(list); 
			}
			out.write(newList);
			out.flush();	
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
