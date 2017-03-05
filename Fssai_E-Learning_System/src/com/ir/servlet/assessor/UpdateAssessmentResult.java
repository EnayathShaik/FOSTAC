package com.ir.servlet.assessor;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ir.model.assessor.AssessmentResult;
import com.ir.util.HibernateUtil;

/**
 * Servlet implementation class MyServlt
 */

public class UpdateAssessmentResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAssessmentResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
				System.out.println("Updating attendance for accessor..");
				response.setContentType("text/html;charset=UTF-8");
				String strAssessorId = request.getParameter("assessorId");
				String strTrainingcalId = request.getParameter("trainingcalId");
				String strTraineeLogin = request.getParameter("traineeId");
				String strComments = request.getParameter("comments");
				String strResult = request.getParameter("result");
		        PrintWriter out = response.getWriter();
		        int assessorId, trainingCalId, traineeLoginId;
		        String responseStr="";
		        Integer result = 0;
		        if(strAssessorId != null && strTrainingcalId!=null && strTraineeLogin !=null){
		        	assessorId = Integer.parseInt(strAssessorId);
		        	trainingCalId = Integer.parseInt(strTrainingcalId);
		        	traineeLoginId = Integer.parseInt(strTraineeLogin);
				SessionFactory sf = new HibernateUtil().getSessionFactory();
				Session session = sf.openSession();
				
				Criteria assessmentResultCriteria = session.createCriteria(AssessmentResult.class)
						.add(Restrictions.eq("assessorid", assessorId))
						.add(Restrictions.eq("participantid", traineeLoginId))
						.add(Restrictions.eq("trainingcalendarid", trainingCalId));
				List assessmentResList = assessmentResultCriteria.list();
				
				if(assessmentResList.size() >0)
				{
					responseStr = "Assessment result already updated for the selected row..";
				}else
				{
					System.out.println("Assessment result not available..");
					Transaction tx = session.beginTransaction();
					String pattern = "dd/MM/yyyy"; 
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern); 
					String date = simpleDateFormat.format(new Date()); 
					AssessmentResult  resultObj = new AssessmentResult();
					resultObj.setAssessorid(assessorId);
					resultObj.setParticipantid(traineeLoginId);
					resultObj.setTrainingcalendarid(trainingCalId);
					resultObj.setComments(strComments);
					resultObj.setResult(strResult);
					resultObj.setUpdateddate(date);
					try{
					result = (Integer)session.save(resultObj);
					}catch(Exception e){
						System.out.println("Exception while saving assessment:"+e.getMessage());
					}
					tx.commit();
					session.close();
					if(result != 0){
						responseStr =  "Accessment result updated successfully";
					}else{
						responseStr =  "Oops! Error occured while marking attendance.";
					}
			        }
		        }
		        out.write(responseStr);
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
