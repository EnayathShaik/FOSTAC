package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.ir.model.CourseName;
import com.ir.model.LoginDetails;
import com.ir.model.PersonalInformationAssessor;
import com.ir.model.PersonalInformationTrainee;
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
		
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		
		String newList = null;
		if(status.equalsIgnoreCase("A")){
			
			PersonalInformationAssessor   personalInformationAssessor=(PersonalInformationAssessor) session.load(PersonalInformationAssessor.class,Integer.parseInt(id));
			
			LoginDetails ld = new LoginDetails();
			ld.setStatus("I");
			ld.setLoginId(personalInformationAssessor.getLoginDetails().getLoginId());
			ld.setPassword(personalInformationAssessor.getLoginDetails().getPassword());
			
			personalInformationAssessor.setLoginDetails(ld);
			session.update(personalInformationAssessor);
			session.beginTransaction().commit();
			session.close();
			newList = "Status changet to In-active" ;
		}else{
			PersonalInformationAssessor   personalInformationAssessor=(PersonalInformationAssessor) session.load(PersonalInformationAssessor.class,Integer.parseInt(id));
			LoginDetails ld = new LoginDetails();
			ld.setStatus("A");
			ld.setLoginId(personalInformationAssessor.getLoginDetails().getLoginId());
			ld.setPassword(personalInformationAssessor.getLoginDetails().getPassword());
			
			
			personalInformationAssessor.setLoginDetails(ld);
			session.update(personalInformationAssessor);
			session.beginTransaction().commit();
			session.close();
			newList = "Status changet to Active" ;
		}
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
