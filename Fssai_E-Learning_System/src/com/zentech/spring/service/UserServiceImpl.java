package com.zentech.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zentech.spring.dao.UserDAO;
import com.zentech.spring.hb.model.FUser;
@Service
public class UserServiceImpl implements UserService {
	
	private UserDAO userDAO;
	/**
	 * @param userDAO the userDAO to set
	 */
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public void addUser(FUser p) {
		// TODO Auto-generated method stub
		this.userDAO.addUser(p);
	}

	@Override
	@Transactional
	public void updateUser(FUser p) {
		// TODO Auto-generated method stub
		this.userDAO.updateUser(p);
	}

	@Override
	@Transactional
	public List<FUser> listUsers() {
		// TODO Auto-generated method stub
		return this.userDAO.listUsers();
	}

	@Override
	@Transactional
	public FUser getUsereById(int id) {
		// TODO Auto-generated method stub
		return this.userDAO.getUsereById(id);
	}

	@Override
	@Transactional
	public void removeUser(int id) {
		// TODO Auto-generated method stub
		this.userDAO.removeUser(id);
	}

}
