package com.ir.service;

import java.util.List;

import javax.transaction.Transactional;

import com.ir.model.State;

public interface StateSaveService {
	@Transactional
	public int stateSave(List<State> statelist);

}
