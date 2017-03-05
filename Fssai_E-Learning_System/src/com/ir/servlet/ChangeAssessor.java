package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ir.model.LoginDetails;
import com.ir.model.PersonalInformationAssessor;
import com.ir.util.HibernateUtil;
/**
 * Servlet implementation class DeleteState
 */

public class ChangeAssessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeAssessor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		String name = (request.getQueryString());
		System.out.println("passing name   :" + name);
		String[] totalConnected = name.split("&");
		String id,status;
		
		id = (totalConnected[0].split("="))[1];
		status = (totalConnected[1].split("="))[1];
		
		/*Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();*/
		SessionFactory sf = new HibernateUtil().getSessionFactory();
		Session session = sf.openSession();
		
		String newList = null;
		PersonalInformationAssessor   personalInformationAssessor=(PersonalInformationAssessor) session.load(PersonalInformationAssessor.class,Integer.parseInt(id));
		LoginDetails ld = personalInformationAssessor.getLoginDetails();
		String newStatus = "I";
		if(status.equalsIgnoreCase("I")){
			newStatus = "A";
			newList = "Status changet to ACTIVE" ;
		}else{
			newList = "Status changet to IN-ACTIVE" ;
			newStatus = "I";
		}
				
				if(personalInformationAssessor.getLoginDetails() != null){
					String updateQry = "update logindetails set status ='"+newStatus+"' where id ="+personalInformationAssessor.getLoginDetails().getId(); 
					Query query = session.createSQLQuery(updateQry);
					System.out.println(updateQry);
					Integer i = query.executeUpdate();
					System.out.println("i  :"+ i);
					
					String responseStr = null ;
					if(i > 0 ){
						System.out.println("data selected finally  " );
						responseStr = "Data updated successfully"; 
					}else{
						responseStr = "Oops , something went wrong try ageain !!!";
					}
					out.write(newList);
					out.flush();
				}
			System.out.println("##################Session get");
			
			session.beginTransaction().commit();
			session.close();
		out.write(newList);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}