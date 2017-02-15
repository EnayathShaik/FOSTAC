package com.zentech.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zentech.spring.hb.model.FUser;
import com.zentech.spring.hb.model.PersonalInformationTrainer;


public class TrainerDAOImpl implements TrainerDAO {
	private static final Logger logger = LoggerFactory.getLogger(TrainerDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	
	//Register Trainer  *******************************
	

	@Override
	public void addPersonalInfoTrainer(PersonalInformationTrainer p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Trainer saved successfully, Trainer Details="+p);
	}

	@Override
	public void updatePersonalInfoTrainer(PersonalInformationTrainer p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Trainer updated successfully, Trainer Details="+p);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PersonalInformationTrainer> listPersonalInfoTrainers() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("inside ");
		List<PersonalInformationTrainer> TrainersList = session.createQuery("from PersonalInformationTrainer").list();
		for(PersonalInformationTrainer p : TrainersList){
			logger.info("Trainers List::"+p);
		}
		return TrainersList;
	}

	@Override
	public PersonalInformationTrainer getPersonalInfoTrainerById(int id) {
		System.out.println("inside getPersonalInfoTrainerById");
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();		
		PersonalInformationTrainer p = (PersonalInformationTrainer) session.load(PersonalInformationTrainer.class, new Integer(id));
		logger.info("Trainer loaded successfully, Trainer details="+p);
		return p;
	}

	@Override
	public void removePersonalInfoTrainer(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		PersonalInformationTrainer p = (PersonalInformationTrainer) session.load(PersonalInformationTrainer.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Trainer deleted successfully, Trainer details="+p);
	}

}
