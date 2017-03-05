package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ir.model.FeedbackForm;
/**
 * Servlet implementation class DeleteState
 */

public class SaveFeedbackForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveFeedbackForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//		String courseId = request.getParameter("courseId");
//		if(request.getParameter("feedbackMastersIds")!=null){
//			String userId=request.getSession(false).getAttribute("loginIdUnique").toString();
//			String[] feedbackMastersIds=request.getParameter("feedbackMastersIds").split(",");
//			List<FeedbackForm> list =new ArrayList<>();
//			for(int index=0;index<feedbackMastersIds.length;index++){
//				FeedbackForm  feedbackForm=new FeedbackForm();
//				feedbackForm.setUserId(userId);
//				feedbackForm.setCourseId(userId);
//				String[] feedbaks=feedbackMastersIds[index].split("`");
//				feedbackForm.setFeedbackId(feedbaks[0]);
//				feedbackForm.setFeedbackRating(feedbaks[1]);
//				list.add(feedbackForm);
//			}
//			Configuration conf = new Configuration();
//			conf.configure("/hibernate.cfg.xml");
//			SessionFactory sf = conf.buildSessionFactory();
//			Session session = sf.openSession();
//			Transaction transaction=session.beginTransaction();
//			for(FeedbackForm feedbackForm:list){
//				session.save(feedbackForm);
//			}
//			transaction.commit();
////			Query query = session.createSQLQuery(sql);
//			
////			out.write(newList);
//			out.flush();
//
//		}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		String courseId = request.getParameter("courseId");
		if(request.getParameter("feedbackMastersIds")!=null){
			String userId=request.getSession(false).getAttribute("loginIdUnique").toString();
			String[] feedbackMastersIds=request.getParameter("feedbackMastersIds").split(",");
			List<FeedbackForm> list =new ArrayList<>();
			for(int index=0;index<feedbackMastersIds.length;index++){
				FeedbackForm  feedbackForm=new FeedbackForm();
				feedbackForm.setUserId(userId);
				feedbackForm.setCourseId(courseId);
				String[] feedbaks=feedbackMastersIds[index].split("`");
				feedbackForm.setFeedbackId(feedbaks[0]);
				feedbackForm.setFeedbackRating(feedbaks[1]);
				list.add(feedbackForm);
			}
			Configuration conf = new Configuration();
			conf.configure("/hibernate.cfg.xml");
			SessionFactory sf = conf.buildSessionFactory();
			Session session = sf.openSession();
			Transaction transaction=session.beginTransaction();
			for(FeedbackForm feedbackForm:list){
				session.save(feedbackForm);
			}
			transaction.commit();
//			Query query = session.createSQLQuery(sql);
			
//			out.write(newList);
			out.flush();

		}
	}

}
