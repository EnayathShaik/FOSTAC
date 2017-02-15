package com.zentech.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zentech.spring.hb.model.FUser;
import com.zentech.spring.hb.model.PersonalInformationStateAdmin;


public class StateAdminDAOImpl implements StateAdminDAO {
	private static final Logger logger = LoggerFactory.getLogger(StateAdminDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	//Register StateAdmin  *******************************
	

	@Override
	public void addPersonalInfoStateAdmin(PersonalInformationStateAdmin p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("StateAdmin saved successfully, StateAdmin Details="+p);
	}

	@Override
	public void updatePersonalInfoStateAdmin(PersonalInformationStateAdmin p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("StateAdmin updated successfully, StateAdmin Details="+p);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PersonalInformationStateAdmin> listPersonalInfoStateAdmins() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("inside ");
		List<PersonalInformationStateAdmin> StateAdminsList = session.createQuery("from PersonalInformationStateAdmin").list();
		for(PersonalInformationStateAdmin p : StateAdminsList){
			logger.info("StateAdmins List::"+p);
		}
		return StateAdminsList;
	}

	@Override
	public PersonalInformationStateAdmin getPersonalInfoStateAdminById(int id) {
		System.out.println("inside getPersonalInfoStateAdminById");
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();		
		PersonalInformationStateAdmin p = (PersonalInformationStateAdmin) session.load(PersonalInformationStateAdmin.class, new Integer(id));
		logger.info("StateAdmin loaded successfully, StateAdmin details="+p);
		return p;
	}

	@Override
	public void removePersonalInfoStateAdmin(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		PersonalInformationStateAdmin p = (PersonalInformationStateAdmin) session.load(PersonalInformationStateAdmin.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("StateAdmin deleted successfully, StateAdmin details="+p);
	}

}
