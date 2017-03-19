package com.ir.dao.impl;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ir.bean.common.IntStringBean;
import com.ir.dao.AssessmentDao;
import com.ir.form.AssessmentAnswerCriteria;
import com.ir.model.AssessmentQuestion;
import com.ir.model.CourseEnrolledUser;
import com.ir.model.CourseName;
import com.ir.model.CourseType;
import com.ir.model.trainee.TraineeAssessmentEvaluation;
import com.ir.util.HibernateUtil;
import com.zentech.logger.ZLogger;
import com.zentect.ajax.AjaxRequest;
@Repository("AssessmentDao")
@Service
public class AssessmentDaoImpl implements AssessmentDao{

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public List<AssessmentQuestion> getAssessmentQuestions(int courseType, int courseName) {
		System.out.println("AssessmentQuestions");
//		Criteria criteria = session.createCriteria(AssessmentQuestion.class);
//		criteria.add(Restrictions.eq("courseName", courseName));
//		criteria.add(Restrictions.eq("courseType", courseType));
//		List <AssessmentQuestion> listAssessmentQuestions = criteria.list();
		Session session = sessionFactory.getCurrentSession();
//		Query query = session.createQuery("from AssessmentQuestion where coursename = "+ courseName +" and courseType= "+courseType);
		Query query = session.createQuery("from AssessmentQuestion where coursename = "+ courseName);
		List<AssessmentQuestion> assessmentQuestions = query.list();
		return assessmentQuestions;
	}

	public String saveAssessment(List<AssessmentAnswerCriteria> answerCriterias){
		Session session = sessionFactory.getCurrentSession();
		try{
		for(int i= 0; i<answerCriterias.size(); i++){
			session.save(answerCriterias.get(i));
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		}
		
		return "Success";
	}
	
	@Override
	public List<CourseType> courseTypes() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CourseType");
		List<CourseType> courseTypeList = query.list();
		return courseTypeList;
	}
	
	
	@Override
	public List<CourseName> courseNames() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CourseName");
		List<CourseName> courseNameList = query.list();
		return courseNameList;
	}
	@Override
	public List<IntStringBean> getTrainingPartners(int assessorId){
		Session session = sessionFactory.getCurrentSession();
		List<IntStringBean> trainingPartnerList = new ArrayList<IntStringBean>();
		String strQuery = "select pit.personalinformationtrainingpartnerid, pit.trainingcentrename "
				+ "from personalinformationassessor pia "
				+ "inner join courseenrolled ce on ce.logindetails = pia.logindetails "
				+ "inner join trainingcalendar tc on tc.coursename = ce.coursenameid "
				+ "inner join coursename cn on cn.coursenameid = tc.coursename "
				+ "inner join personalinformationtrainingpartner pit on pit.personalinformationtrainingpartnerid = tc.trainingcenter "
				+ "where pia.logindetails = "+assessorId + " "
						+ "group by pit.personalinformationtrainingpartnerid, pit.trainingcentrename";
		Query query = session.createSQLQuery(strQuery);
		//List tpList = query.list();
		List<Object[]> tpList =(List<Object[]>) query.list();
		if(tpList != null && tpList.size() >0){
			for(int i =0 ; i<tpList.size(); i++){
				
				IntStringBean tc = new IntStringBean();
				Object[] o =tpList.get(0);
				tc.setId((int)o[0]);
				tc.setValue(o[1].toString());
				trainingPartnerList.add(tc);
			}
		}
		return trainingPartnerList;
	}

	@Override
	public List<AssessmentQuestion> getAssessmentAnswers(int courseType, List<Integer> questions) {
		Session session = sessionFactory.getCurrentSession();
		String questionIds = questions.toString();
		if(questionIds.length() >2){
			questionIds = questionIds.substring(1,questionIds.length()-1);
		}
		Query query = session.createQuery("from AssessmentQuestion where coursename = "+ courseType +" and assessmentquestionid in ("+questionIds+")");
		List<AssessmentQuestion> listAssessmentQuestions = query.list();
		
		return listAssessmentQuestions;
	}
	@Override
	public int saveTraineeAssessmentEvaluation(TraineeAssessmentEvaluation traineeAssessmentEvaluation){
		Session session = sessionFactory.getCurrentSession();
		Integer traineeAssessmentEvaluationId = (Integer) session.save(traineeAssessmentEvaluation);
		return traineeAssessmentEvaluationId;
	}

	@Override
	public int getElegibilityForAssessment(int coursenameid){
		Session session = sessionFactory.getCurrentSession();
		String sql = "select eligibility from assessmenteligibility where coursenameid="+coursenameid;
		Query query = session.createSQLQuery(sql);
		List listEligibility = query.list();
		if(listEligibility.size() > 0)
		{
			return (int)listEligibility.get(0);
		}
		return -1;
	}
	
	
	@Override
	public List<CourseType> courseTypeList() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CourseType");
		List<CourseType> courseTypeList = query.list();
		return courseTypeList;
	}
	
	//searchAssessorCalendar
	
	@Override
	public List searchAssessorCalendar(String data) {
		
		Session session = sessionFactory.getCurrentSession();
		String sql = "select B.coursecode,A.trainingdate, "
				+ "concat(C.trainingpartnerpermanentline1, ', ', C.trainingpartnerpermanentline2, ' -', dt.districtname) as address, "
				+ "(select count(1) from courseenrolleduser where trainingcalendarid=A.trainingcalendarid) "
				+ " ,A.batchCode, A.assessmentdatetime "
				+ "from trainingcalendar A "
				+ "inner join coursename B on(A.coursename=B.coursenameid) "
				+ "inner join personalinformationtrainingpartner C on(A.trainingcenter=C.personalinformationtrainingpartnerid) "
				+ "inner join district dt on dt.districtid = C.trainingpartnerpermanentdistrict where to_timestamp(COALESCE(A.assessmentdatetime, '19900101010101'),'DD-MM-YYYY') >= CURRENT_TIMESTAMP - INTERVAL '1 days' AND A.assessor= '"+data+"'";
	
			Query query = session.createSQLQuery(sql);
			List list = query.list();
		return list;
	}
	
	//viewAssessmentAgencyCalendar
	
	@Override
	public List viewAssessmentAgencyCalendar(String data) {
		
		String [] n1 = data.split("-");
        String courseType,courseName,assessmentDateTime,assessmentAgencyName ,assessorName ;
        
        try{
			courseType = n1[0].split("=")[1];
		}
		catch(Exception e){
			courseType = "%";	
		}
		
		try{
			courseName = n1[1].split("=")[1];	
		}catch(Exception e){
			courseName = "%";	
		}
		
		try{
			assessmentDateTime = n1[2].split("=")[1];
			assessmentDateTime = "%"+assessmentDateTime.replaceAll("%20", " ");
		}
		catch(Exception e){
			assessmentDateTime = "%";
		}
		
		try{
			assessmentAgencyName = n1[3].split("=")[1];
		}
		catch(Exception e){
			assessmentAgencyName = "%";
		}
		
		try{
			assessorName = n1[4].split("=")[1];
		}
		catch(Exception e){
			assessorName = "%";
		}
	
		String sql = " select B.coursetype,C.coursename,A.assessmentdatetime,F.statename,E.firstname || ' '|| E.middlename ||' '|| E.lastname ,CASE WHEN G.status = 'A' THEN 'ACTIVE' ELSE 'IN-ACTIVE' END,C.coursecode,A.batchCode	from trainingcalendar A inner join coursetype B on(A.coursetype=B.coursetypeid)	inner join coursename C on(A.coursename=C.coursenameid)        inner join personalinformationtrainingpartner D on(A.trainingcenter=D.personalinformationtrainingpartnerid) inner join personalinformationassessor E on(A.assessor=E.personalinformationassessorid) inner join state F on(E.assessorcorrespondencestate=F.stateid)  inner join logindetails G on(E.logindetails=G.id) where to_timestamp(COALESCE(A.trainingdate, '19900101010101'),'DD-MM-YYYY') > now()"+
				" and   cast(A.coursetype as varchar(10)) like '"+courseType+"%'  and  cast(A.coursename as varchar(10) ) like  '"+courseName+"%' "+
				" and cast(coalesce(A.assessmentdatetime , '') as varchar(100)) like '"+assessmentDateTime+"%' and  cast(A.assessmentpartnername as varchar(100)) like '"+assessmentAgencyName+"%' and  cast(A.assessor as varchar(100)) like '"+assessorName+"%'";
		Session session = sessionFactory.getCurrentSession();
				System.out.println(" sql "+sql);   
				Query query = session.createSQLQuery(sql);
				List list = query.list();
				
	
		return list;
	}
	
	//searchAssessorTraineesForResults
	
	@Override
	public List searchAssessorTraineesForResults(String data) {
		
		
		String [] n1 = data.split("@");
        
        String courseType , trainingDate , trainingCenter , courseName;
        try{
			courseType = n1[0].split("=")[1];	
		}catch(Exception e){
			courseType = "%";	
		}
		
        try{
        	trainingCenter = n1[1].split("=")[1];	
		}catch(Exception e){
			trainingCenter = "%";	
		}
		
	
		try{
			trainingDate = n1[2].split("=")[1];
			trainingDate = "%"+trainingDate.replaceAll("%20", " ");
			System.out.println("trainingDate "+trainingDate);
		}
		catch(Exception e){
			trainingDate = "%";
		}
		
		  try{
				courseName = n1[3].split("=")[1];	
			}catch(Exception e){
				courseName = "%";	
			}
		
		String sql = "select A.trainingcalendarid,B.courseenrolleduserid, C.coursename,A.trainingdate,"
				+ " concat(D.firstname , ' ' , D.middlename , ' ' , D.lastname ) TraineeCenter, "
				+ " concat(F.firstname , ' ' , F.middlename , ' ' , F.lastname ) Trainee "
				+ " ,B.result,B.assessorcomment,C.courseCode,A.batchCode , A.assessmentdatetime "
				+ " from trainingcalendar A "
				+ " inner join courseenrolleduser B on(A.trainingcalendarid=B.trainingcalendarid) "
				+ " inner join coursename C on(A.coursename=C.coursenameid) "
				+ " inner join personalinformationtrainingpartner D on(A.trainingcenter=D.personalinformationtrainingpartnerid) "
				+ " inner join logindetails E on(D.logindetails=E.id)"
				+ " inner join personalinformationtrainee F on(F.logindetails=B.logindetails) "
				+" where "
				//+ " to_timestamp(COALESCE(A.assessmentdatetime, '19900101010101'),'DD-MM-YYYY') >= CURRENT_TIMESTAMP - INTERVAL '1 days' and "
				+ "  cast(A.courseType as varchar(100)) like '"+courseType+"%'  and  cast(A.coursename as varchar(100)) like '"+courseName+"%'   and  cast(A.trainingdate as varchar(100)) like '"+trainingDate+"%'  and cast(A.trainingcenter as varchar(100)) like '"+trainingCenter+"%'";
				
				
		Session session = sessionFactory.getCurrentSession();
				System.out.println(" sql "+sql);   
				Query query = session.createSQLQuery(sql);
				List list = query.list();
				
	
		return list;
	}
	
	//updateTraineeAssessmentResult
	
	@Override
	public String updateTraineeAssessmentResult(String data) {
		
		
		System.out.println("passing name   :" + data);
		
		
		
		String[] updateDetails = data.split("@");
		String id , status , comment ;	
		id= (updateDetails[0].split("="))[1];
		
		status = (updateDetails[1].split("="))[1];
		comment = (updateDetails[2].split("="))[1];
		Session session = sessionFactory.getCurrentSession();
		CourseEnrolledUser courseEnrolledUser = (CourseEnrolledUser) session.load(CourseEnrolledUser.class, Integer.parseInt(id));
		courseEnrolledUser.setResult(status);
		courseEnrolledUser.setAssessorComment(comment);
		session.update(courseEnrolledUser);
		String newList = "Records successfully updated !!!" ; 
				
	
		return newList;
	}
	
	@Override
	public String updateTraineeAssessmentResultOnline(Integer userID,String result,String comment) {
		int courseenrolledUserID = 0;
		Session session = sessionFactory.getCurrentSession();
		String sql = "select courseenrolleduserid from courseenrolleduser where  status = 'N' and logindetails = "+userID;
		Query query = session.createSQLQuery(sql);
		List list = query.list();
		if(list.size() > 0){
			courseenrolledUserID = (Integer) list.get(0);
		}
		if(courseenrolledUserID > 0){
			CourseEnrolledUser courseEnrolledUser = (CourseEnrolledUser) session.load(CourseEnrolledUser.class, courseenrolledUserID);
			if(result != null && result.toUpperCase().equals("PASS")){
				courseEnrolledUser.setResult("P");
			}else{
				courseEnrolledUser.setResult("F");
			}
			courseEnrolledUser.setAssessorComment(comment);
			session.update(courseEnrolledUser);
		}
		String newList = "Records successfully updated !!!" ; 
		return newList;
	}
	
	
	//searchDataAssessmentAgency
	@Override
	public List searchDataAssessmentAgency(String name) {
		String[] totalConnected = name.split("-");
		String id,status;
		
		if(totalConnected[0].split("=").length == 1){
			id = "%";
		}else{
			id = (totalConnected[0].split("="))[1];
		}
		if(totalConnected[1].split("=").length == 1){
			status = "%";
		}else{
			status = (totalConnected[1].split("="))[1];
		}
		
		
		String[] statusA  = status.split("%20");
		String cn = "";
		for(int i = 0 ; i < statusA.length ; i++){
			cn = cn + statusA[i] + " ";
		}
		String fcn = cn.substring(0, cn.length()-1);
		System.out.println(fcn.length());
		
		Session session = sessionFactory.getCurrentSession();
		String sql ="select maa.manageassessmentagencyid  , ld.loginid, maa.assessmentagencyname , maa.websiteurl , (CASE WHEN ld.isActive = 'Y' THEN 'ACTIVE' ELSE 'INACTIVE' END) as currentstatus "+
					" from manageassessmentagency as maa inner join logindetails as ld "+
					" on ld.id = maa.logindetails "+
					" where upper(maa.assessmentagencyname) like '"+fcn.toUpperCase() +"' and ld.loginid like '"+id+"'";
		Query query = session.createSQLQuery(sql);
		List<CourseName> list = query.list();
		return list;
	}
	
	//editMAA
	
	@Override
	public List editMAA(String name) {

		String sql="select maa.manageassessmentagencyid  , ld.loginid ,maa.assessmentagencyname , maa.websiteurl , ld.status , "+
    			" maa.pan , maa.email , maa.headofficedataaddress1 , maa.headofficedataaddress2 , maa.pin ,s.statename , "+
    			" d.districtname  , c.cityname ,"+
    			" s.stateid ,d.districtid  , c.cityid "+
				" from manageassessmentagency as maa "+
				" inner join logindetails as ld on ld.id = maa.logindetails "+
				" inner join district as d on d.districtid = maa.district "+
				" inner join city as c on c.cityId = maa.city "+
				" inner join state as s on s.stateid = maa.stateid "+
				" where maa.manageassessmentagencyid = '"+ name+"' ";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(sql);
		List<CourseName> list =  query.list();
		return list;
	}
	
	//updateMAA
	
	@Override
	public String updateMAA(String name) {

		String [] total = name.split("-");
		String userId = total[0].split("=")[1];
		String status = total[1].split("=")[1];
		String websiteUrl = total[2].split("=")[1];
		String email = total[3].split("=")[1];
		String headOfficeDataAddress1 = total[4].split("=")[1].replaceAll("%20", " ");
		String headOfficeDataAddress2 = total[5].split("=")[1].replaceAll("%20", " ");
		System.out.println("address 1  :"+ headOfficeDataAddress1 +"     "+ headOfficeDataAddress2);
		String pin = total[6].split("=")[1];
		String stateId = total[7].split("=")[1];
		String district = total[8].split("=")[1];
		String city = total[9].split("=")[1];
		String isActive = status.equalsIgnoreCase("A")?"Y":"N";
		Session session = sessionFactory.getCurrentSession();
		
		String selectLoginDetails = "select logindetails from manageassessmentagency where manageassessmentagencyid = '"+userId+"'";
		Query querySel = session.createSQLQuery(selectLoginDetails);
		String selectSel = querySel.getQueryString();
		System.out.println("login id is   :"+ selectSel);
		
		String sql="UPDATE manageassessmentagency "+
				" SET city='"+city+"',  "+
				" district='"+district+"', email='"+email+"', "+
				" headofficedataaddress1='"+headOfficeDataAddress1+"', headofficedataaddress2='"+headOfficeDataAddress2+"', "+
				" pin='"+pin+"', stateid='"+stateId+"', "+
				" websiteurl='"+websiteUrl+"' "+
				" WHERE manageassessmentagencyid = '"+userId+"' ";

		String sqlLD = "update logindetails set status ='"+status+"' , isactive = '"+isActive+"' where id =("+selectSel+")";
		Query query2 = session.createSQLQuery(sqlLD);
		String result = null;
		Query query = session.createSQLQuery(sql);
		System.out.println(sql);
		Integer i = query.executeUpdate();
		System.out.println("i  :"+ i);
		
		Integer j = query2.executeUpdate();
		if(i > 0 ){
			System.out.println("data selected finally  " );
			result = "Data updated successfully"; 
		}else{
			result = "Oops , something went wrong try ageain !!!";
		}
		return result;
	}
}
