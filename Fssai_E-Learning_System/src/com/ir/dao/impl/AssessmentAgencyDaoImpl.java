package com.ir.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ir.dao.AssessmentAgencyDao;
import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.model.ContactTraineee;
import com.ir.model.CourseType;
import com.ir.model.assessmentagency.AssessmentAgencyForm;
import com.ir.util.ChangePasswordUtility;
import com.ir.util.SendContectMail;
@Service
public class AssessmentAgencyDaoImpl implements AssessmentAgencyDao {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	// Rishi
	@Autowired
	@Qualifier("changePasswordUtility")
	public ChangePasswordUtility changePasswordUtility;
	
	
	@Override
	public String contactSave(ContactTrainee contactTrainee  , String id) {
		SendContectMail traineeMaail=null;
		 traineeMaail = new SendContectMail();
			
		Session session = sessionFactory.getCurrentSession();
		ContactTraineee contactTrainerModel = new ContactTraineee();
		String email=contactTrainee.getEmailAddress();
		String msg=contactTrainee.getMessageDetails();
		traineeMaail.mailProperty(msg, email,id);
		
		System.out.println("sent mail to........................"+id);
		
		contactTrainerModel.setEmailAddress(email); 
		contactTrainerModel.setMessageDetails(msg);
		contactTrainerModel.setUserId(id);
		Integer contactTrainerModelId = (Integer) session.save(contactTrainerModel);
		System.out.println("contactTraineeSave after save");
		if(contactTrainerModelId >0 && contactTrainerModelId != null){
			return "created";
		}else{
			return "error";
		}
		
		
	}

	@Override
	public boolean changePasswordData(ChangePasswordForm changePasswordForm, String id) {
	String oldPassword=	changePasswordForm.getOldPassword();
		String newPassword=changePasswordForm.getNewPassword();
		boolean confirm = changePasswordUtility.changePasswordUtil(oldPassword, newPassword, id);
		return confirm;
	}
	
	@Override
	public AssessmentAgencyForm getAssessmentAgencyForm(int agencyLoginId){
		Session session = sessionFactory.getCurrentSession();
		AssessmentAgencyForm agencyForm = new AssessmentAgencyForm(); 
		String qry = "select mag.manageassessmentagencyid from manageassessmentagency mag "
				+ "where mag.logindetails = "+agencyLoginId;
		Query query = session.createSQLQuery(qry);
		List<Object[]> agencyDataForm =(List<Object[]>) query.list();
		if(agencyForm != null && agencyDataForm.size() >0){
			for(int i =0 ; i<agencyDataForm.size(); i++){
				Object o = agencyDataForm.get(0);
				agencyForm.setManageassessmentagencyid((int)o);
			}
		}
		return agencyForm;
	}
	
	
	
	@Override
	public List<CourseType> courseTypeList() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CourseType");
		List<CourseType> courseTypeList = query.list();
		return courseTypeList;
	}
	
	
	@Override
	public Map<String , String> assessorNameMap(int agencyId , int profileId) {
		HashMap<String , String> assessor = new HashMap<String , String>();
		Session session = sessionFactory.getCurrentSession();
		Query query = null ;
		if(profileId == 6){
			 query = session.createSQLQuery("select personalinformationassessorid , (firstname || ' '|| middlename || ' ' || lastname) from personalinformationassessor where personalinformationassessorid= '"+agencyId+"'");
		}else{
			 query = session.createSQLQuery("select manageassessmentagencyid , assessmentagencyname from manageAssessmentAgency where manageassessmentagencyid= '"+agencyId+"'");	
		}
		
		
		List<Object[]> assessorList = query.list();
		
		if(assessorList.size()>0){
			
			for(Object[] s : assessorList ){
				System.out.println( " s "+s[0].toString() + " 1 "+s[1].toString());
				assessor.put(s[0].toString(),s[1].toString());
			}
			
		}
		
		return assessor;
	}
	
}
