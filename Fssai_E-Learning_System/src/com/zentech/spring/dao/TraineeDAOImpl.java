package com.zentech.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zentech.spring.hb.model.FUser;
import com.zentech.spring.hb.model.PersonalInformationTrainee;
import com.zentech.spring.hb.model.Trainee;

public class TraineeDAOImpl implements TraineeDAO {
	private static final Logger logger = LoggerFactory.getLogger(TraineeDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addTrainee(Trainee p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Trainee saved successfully, Trainee Details="+p);
	}

	@Override
	public void updateTrainee(Trainee p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Trainee updated successfully, Trainee Details="+p);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Trainee> listTrainees() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<Trainee> traineesList = session.createQuery("from Trainee").list();
		for(Trainee p : traineesList){
			logger.info("Trainees List::"+p);
		}
		return traineesList;
	}

	@Override
	public Trainee getTraineeById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();		
		Trainee p = (Trainee) session.load(Trainee.class, new Integer(id));
		logger.info("Trainee loaded successfully, Trainee details="+p);
		return p;
	}

	@Override
	public void removeTrainee(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Trainee p = (Trainee) session.load(Trainee.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Trainee deleted successfully, Trainee details="+p);
	}
	
	
	//Register Trainee  *******************************
	

	@Override
	public void addPersonalInfoTrainee(PersonalInformationTrainee p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Trainee saved successfully, Trainee Details="+p);
	}

	@Override
	public void updatePersonalInfoTrainee(PersonalInformationTrainee p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Trainee updated successfully, Trainee Details="+p);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PersonalInformationTrainee> listPersonalInfoTrainees() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("inside ");
		List<PersonalInformationTrainee> traineesList = session.createQuery("from PersonalInformationTrainee").list();
		for(PersonalInformationTrainee p : traineesList){
			logger.info("Trainees List::"+p);
		}
		return traineesList;
	}

	@Override
	public PersonalInformationTrainee getPersonalInfoTraineeById(int id) {
		System.out.println("inside getPersonalInfoTraineeById");
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();		
		PersonalInformationTrainee p = (PersonalInformationTrainee) session.load(PersonalInformationTrainee.class, new Integer(id));
		logger.info("Trainee loaded successfully, Trainee details="+p);
		return p;
	}

	@Override
	public void removePersonalInfoTrainee(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		PersonalInformationTrainee p = (PersonalInformationTrainee) session.load(PersonalInformationTrainee.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Trainee deleted successfully, Trainee details="+p);
	}

}
