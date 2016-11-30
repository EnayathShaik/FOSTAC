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
import com.ir.model.PersonalInformationTrainee;
/**
 * Servlet implementation class DeleteState
 */

public class EditManageCourseData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditManageCourseData() {
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
		String courseName , courseDuration , online, status , paidunpaid , id  , classroom;
		
		courseName = (totalConnected[1].split("="))[1].replaceAll("%20", " ").trim();
		courseDuration = (totalConnected[4].split("="))[1].replaceAll("%20", " ").trim();
		if( (totalConnected[2].split("="))[1].equals("true")){
			online =  "Online";
		}else{
			online = "Nil";
		}
		paidunpaid = (totalConnected[0].split("="))[1];
		status = (totalConnected[3].split("="))[1];
		id = (totalConnected[5].split("="))[1];
		
		if( (totalConnected[6].split("="))[1].equals("true")){
			classroom =  "Classroom";
		}else{
			classroom = "Nil";
		}
		
		System.out.println(courseName + " "+courseDuration + " "+ online + "  "+ classroom + " "+ status + "  "+id);
		
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		CourseName   courseNameee=(CourseName) session.load(CourseName.class, Integer.parseInt(id));
		
		courseNameee.setCoursename(courseName);
		courseNameee.setCourseduration(courseDuration);
		courseNameee.setOnline(online);
		courseNameee.setClassroom(classroom);
		courseNameee.setStatus(status);
		courseNameee.setPaidunpaid(paidunpaid);
		session.update(courseNameee);
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
