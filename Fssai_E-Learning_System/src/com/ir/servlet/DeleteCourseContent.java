package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ir.model.ManageCourseContent;
import com.ir.util.HibernateUtil;
/**
 * Servlet implementation class DeleteState
 */

public class DeleteCourseContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCourseContent() {
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
		String  id  = name ;
		String newList = null;
	
			/*Configuration conf = new Configuration();
			conf.configure("/hibernate.cfg.xml");
			SessionFactory sf = conf.buildSessionFactory();*/
			SessionFactory sf = new HibernateUtil().getSessionFactory();
			Session session = sf.openSession();
			ManageCourseContent manageCourseContent = (ManageCourseContent) session.load(ManageCourseContent.class, Integer.parseInt(id));
			session.delete(manageCourseContent);
			session.beginTransaction().commit();
			session.close();
			newList = "Record deleted successfully !!!" ;
		out.write(newList);
		out.flush();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
