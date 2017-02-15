package com.zentech.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zentech.spring.dao.MasterDAO;
import com.zentech.spring.hb.model.City;
import com.zentech.spring.hb.model.District;
import com.zentech.spring.hb.model.Person;
import com.zentech.spring.hb.model.Region;
import com.zentech.spring.hb.model.NState;
@Service
public class MasterServiceImpl implements MasterService {

	private MasterDAO masterDAO;
	
	/**
	 * @param masterDAO the masterDAO to set
	 */
	public void setMasterDAO(MasterDAO masterDAO) {
		this.masterDAO = masterDAO;
	}

	@Override
	@Transactional
	public void addState(NState p) {
		// TODO Auto-generated method stub
	this.masterDAO.addState(p);
	}

	@Override
	@Transactional
	public void updateState(NState p) {
		// TODO Auto-generated method stub
		this.masterDAO.updateState(p);
	}

	@Override
	@Transactional
	public List<NState> listStates() {
		// TODO Auto-generated method stub
		return this.masterDAO.listStates();
	}

	@Override
	@Transactional
	public NState getStateById(int id) {
		// TODO Auto-generated method stub
		return this.masterDAO.getStateById(id);
	}

	@Override
	@Transactional
	public void removeState(int id) {
		// TODO Auto-generated method stub
		this.masterDAO.removeState(id);
	}

	@Override
	@Transactional
	public void addDistrict(District p) {
		// TODO Auto-generated method stub
		this.masterDAO.addDistrict(p);
	}

	@Override
	@Transactional
	public void updateDistrict(District p) {
		// TODO Auto-generated method stub
		this.masterDAO.updateDistrict(p);
	}

	@Override
	@Transactional
	public List<District> listDistricts() {
		// TODO Auto-generated method stub
		return this.masterDAO.listDistricts();
	}

	@Override
	@Transactional
	public District getDistrictById(int id) {
		// TODO Auto-generated method stub
		return this.masterDAO.getDistrictById(id);
	}

	@Override
	@Transactional
	public void removeDistrict(int id) {
		// TODO Auto-generated method stub
		this.masterDAO.removeDistrict(id);
	}

	@Override
	@Transactional
	public void addCity(City p) {
		// TODO Auto-generated method stub
		this.masterDAO.addCity(p);
	}

	@Override
	@Transactional
	public void updateCity(City p) {
		// TODO Auto-generated method stub
		this.masterDAO.updateCity(p);
	}

	@Override
	@Transactional
	public List<City> listCitys() {
		// TODO Auto-generated method stub
		return this.masterDAO.listCitys();
	}

	@Override
	@Transactional
	public City getCityById(int id) {
		// TODO Auto-generated method stub
		return this.masterDAO.getCityById(id);
	}

	@Override
	@Transactional
	public void removeCity(int id) {
		// TODO Auto-generated method stub
		this.masterDAO.removeCity(id);
	}

	@Override
	@Transactional
	public void addRegion(Region p) {
		// TODO Auto-generated method stub
		this.masterDAO.addRegion(p);
	}

	@Override
	@Transactional
	public void updateRegion(Region p) {
		// TODO Auto-generated method stub
		this.masterDAO.updateRegion(p);
	}

	@Override
	@Transactional
	public List<Region> listRegions() {
		// TODO Auto-generated method stub
		return this.masterDAO.listRegions();
	}

	@Override
	@Transactional
	public Region getRegionById(int id) {
		// TODO Auto-generated method stub
		return this.masterDAO.getRegionById(id);
	}

	@Override
	@Transactional
	public void removeRegion(int id) {
		// TODO Auto-generated method stub
		this.masterDAO.removeRegion(id);
	}

	

}
