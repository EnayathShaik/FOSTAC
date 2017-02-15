package com.zentech.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import com.zentech.spring.dao.StateAdminDAO;
import com.zentech.spring.dao.UserDAO;
import com.zentech.spring.hb.model.PersonalInformationStateAdmin;


public class StateAdminServiceImpl implements StateAdminService {
	private StateAdminDAO stateAdminDAO;
	
	
	
	public void setStateAdminDAO(StateAdminDAO stateAdminDAO) {
		this.stateAdminDAO = stateAdminDAO;
	}


	//*************************** Register StateAdmin *****************************************************
	
	@Override
	@Transactional
	public void addPersonalInfoStateAdmin(PersonalInformationStateAdmin p) {
		// TODO Auto-generated method stub
		this.stateAdminDAO.addPersonalInfoStateAdmin(p);
	}

	@Override
	@Transactional
	public void updatePersonalInfoStateAdmin(PersonalInformationStateAdmin p) {
		// TODO Auto-generated method stub
		this.stateAdminDAO.updatePersonalInfoStateAdmin(p);
	}

	@Override
	@Transactional
	public List<PersonalInformationStateAdmin> listPersonalInfoStateAdmins() {
		// TODO Auto-generated method stub
		return this.stateAdminDAO.listPersonalInfoStateAdmins();
	}

	@Override
	@Transactional
	public PersonalInformationStateAdmin getPersonalInfoStateAdminById(int id) {
		// TODO Auto-generated method stub
		return this.stateAdminDAO.getPersonalInfoStateAdminById(id);
	}

	@Override
	@Transactional
	public void removePersonalInfoStateAdmin(int id) {
		// TODO Auto-generated method stub
		this.stateAdminDAO.removePersonalInfoStateAdmin(id);
	}
	

}
