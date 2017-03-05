package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ir.model.CourseName;
import com.ir.util.HibernateUtil;
/**
 * Servlet implementation class DeleteState
 */

public class DeleteManageCourseData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteManageCourseData() {
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
		String  id  , status;
		String newList = null;
		id = (totalConnected[0].split("="))[1];
		status = (totalConnected[1].split("="))[1];
		System.out.println("id   "+ id + "    "+ status);
		if(status.equalsIgnoreCase("I")){
			newList = "Record is already inactive !!!" ;
		}else{
			/*Configuration conf = new Configuration();
			conf.configure("/hibernate.cfg.xml");
			SessionFactory sf = conf.buildSessionFactory();*/
			SessionFactory sf = new HibernateUtil().getSessionFactory();
			Session session = sf.openSession();
			CourseName   courseNameee=(CourseName) session.load(CourseName.class, Integer.parseInt(id));
			courseNameee.setStatus("I");
			session.update(courseNameee);
			session.beginTransaction().commit();
			session.close();
			newList = "Record set to inactive !!!" ;
			
		}
		out.write(newList);
		out.flush();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
