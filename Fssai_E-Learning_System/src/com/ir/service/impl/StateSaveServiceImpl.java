package com.ir.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.ir.model.State;
import com.ir.service.StateSaveService;

public class StateSaveServiceImpl implements StateSaveService {

	@Override
	@Transactional
	public int stateSave(List<State> statelist) {
		// TODO Auto-generated method stub
		return 0;
	}

}
