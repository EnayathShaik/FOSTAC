package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ir.util.HibernateUtil;
/**
 * Servlet implementation class DeleteState
 */

public class EditCourseContentDataMCC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCourseContentDataMCC() {
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
		String[] totalConnected = name.split(",");
		String mccId ,contentLocation ,courseType ,courseName ,modeOfTraining ,contentType, contentLink ,contentName ;
		
		mccId = totalConnected[0];
		contentLocation = totalConnected[1];
		courseType = totalConnected[2];
		courseName = totalConnected[3];
		modeOfTraining = totalConnected[4];
		contentType = totalConnected[5];
		contentLink = totalConnected[6].replaceAll("%20", " ").trim();
		contentName = totalConnected[7].replaceAll("%20", " ").trim();
		
		
		/*Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();*/
		SessionFactory sf = new HibernateUtil().getSessionFactory();
		Session session = sf.openSession();
		com.ir.model.ManageCourseContent   mcc= (com.ir.model.ManageCourseContent) session.load(com.ir.model.ManageCourseContent.class, Integer.parseInt(mccId));
		mcc.setContentLocationInput(contentLocation);
		mcc.setContentTypeInput(courseType);
		mcc.setContentNameInput(contentName);
		mcc.setModeOfTrainingInput(modeOfTraining);
		mcc.setContentTypeInput(contentType);
		mcc.setContentLinkInput(contentLink);
		mcc.setContentNameInput(contentName);
		
		session.update(mcc);
		session.beginTransaction().commit();
		session.close();

		String newList = "Recors successfully updated !!!" ;
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
