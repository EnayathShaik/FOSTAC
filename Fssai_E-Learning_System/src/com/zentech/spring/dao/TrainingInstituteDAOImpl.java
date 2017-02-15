package com.zentech.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zentech.spring.hb.model.FUser;
import com.zentech.spring.hb.model.PersonalInformationTrainingInstitute;


public class TrainingInstituteDAOImpl implements TrainingInstituteDAO {
	private static final Logger logger = LoggerFactory.getLogger(TrainingInstituteDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	
	//Register TrainingInstitute  *******************************
	

	@Override
	public void addPersonalInfoTrainingInstitute(PersonalInformationTrainingInstitute p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("TrainingInstitute saved successfully, TrainingInstitute Details="+p);
	}

	@Override
	public void updatePersonalInfoTrainingInstitute(PersonalInformationTrainingInstitute p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("TrainingInstitute updated successfully, TrainingInstitute Details="+p);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PersonalInformationTrainingInstitute> listPersonalInfoTrainingInstitutes() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("inside ");
		List<PersonalInformationTrainingInstitute> TrainingInstitutesList = session.createQuery("from PersonalInformationTrainingInstitute").list();
		for(PersonalInformationTrainingInstitute p : TrainingInstitutesList){
			logger.info("TrainingInstitutes List::"+p);
		}
		return TrainingInstitutesList;
	}

	@Override
	public PersonalInformationTrainingInstitute getPersonalInfoTrainingInstituteById(int id) {
		System.out.println("inside getPersonalInfoTrainingInstituteById");
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();		
		PersonalInformationTrainingInstitute p = (PersonalInformationTrainingInstitute) session.load(PersonalInformationTrainingInstitute.class, new Integer(id));
		logger.info("TrainingInstitute loaded successfully, TrainingInstitute details="+p);
		return p;
	}

	@Override
	public void removePersonalInfoTrainingInstitute(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		PersonalInformationTrainingInstitute p = (PersonalInformationTrainingInstitute) session.load(PersonalInformationTrainingInstitute.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("TrainingInstitute deleted successfully, TrainingInstitute details="+p);
	}

}
