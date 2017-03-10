package com.ir.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ir.model.State;
import com.ir.service.StateSaveService;
@Service
public class StateSaveServiceImpl implements StateSaveService {

	@Override
	@Transactional
	public int stateSave(List<State> statelist) {
		// TODO Auto-generated method stub
		return 0;
	}

}
