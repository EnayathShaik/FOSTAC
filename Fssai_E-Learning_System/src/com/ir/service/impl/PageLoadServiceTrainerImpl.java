package com.ir.service.impl;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ir.dao.PageLoadDaoTrainer;
import com.ir.model.CourseName;
import com.ir.model.State;
import com.ir.model.Title;
import com.ir.service.PageLoadServiceTrainer;
@Service
public class PageLoadServiceTrainerImpl implements PageLoadServiceTrainer {

	@Autowired
	@Qualifier("pageLoadDaoTrainer")
	private PageLoadDaoTrainer pageLoadDaoTrainer;
	
	@Override
	@Transactional
	public List<State> loadState() {
		List<State> listState = pageLoadDaoTrainer.loadState();
		return listState;
	}

	@Override
	@Transactional
	public List<Title> loadTitle() {
		// TODO Auto-generated method stub
		List<Title> titleList = pageLoadDaoTrainer.loadTitle();
		return titleList;
	}

	@Override
	@Transactional
	public List<CourseName> basicCourseName() {
		// TODO Auto-generated method stub
		List<CourseName> basicCourseName= pageLoadDaoTrainer.basicCourseName();
		return basicCourseName;
	}

	
	
	@Override
	@Transactional
	public List<String> loadCaste() {
		List<String> listCaste = pageLoadDaoTrainer.loadCaste();
		return listCaste;
	}

}
