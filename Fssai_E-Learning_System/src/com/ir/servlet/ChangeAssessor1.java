package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ir.model.LoginDetails;
import com.ir.util.HibernateUtil;
/**
 * Servlet implementation class DeleteState
 */

public class ChangeAssessor1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeAssessor1() {
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
		
		
		/*Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();*/
		SessionFactory sf = new HibernateUtil().getSessionFactory();
		Session session = sf.openSession();
		
		String newList = null;
		//PersonalInformationTrainingPartner  personalInformationTrainingPartner=(PersonalInformationTrainingPartner) session.load(PersonalInformationTrainingPartner.class,Integer.parseInt(name));
		LoginDetails ldd = (LoginDetails) session.load(LoginDetails.class, Integer.parseInt(name));
		
		//LoginDetails ld = new LoginDetails();
		ldd.setStatus("A");
		//ldd.setLoginId(personalInformationTrainingPartner.getLoginDetails().getLoginId());
		//ldd.setPassword(personalInformationTrainingPartner.getLoginDetails().getPassword());
			
		//personalInformationTrainingPartner.setLoginDetails(ld);
		session.update(ldd);
		session.beginTransaction().commit();
		session.close();
		newList = "Status changet to In-active" ;
		
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
