package com.zentech.spring.service;

import java.util.List;

import com.zentech.spring.hb.model.City;
import com.zentech.spring.hb.model.District;
import com.zentech.spring.hb.model.Person;
import com.zentech.spring.hb.model.Region;
import com.zentech.spring.hb.model.NState;

public interface MasterService {
	//State
		public void addState(NState p);
		public void updateState(NState p);
		public List<NState> listStates();
		public NState getStateById(int id);
		public void removeState(int id);
		
		//District
		public void addDistrict(District p);
		public void updateDistrict(District p);
		public List<District> listDistricts();
		public District getDistrictById(int id);
		public void removeDistrict(int id);
		
		//City
		public void addCity(City p);
		public void updateCity(City p);
		public List<City> listCitys();
		public City getCityById(int id);
		public void removeCity(int id);
			
		//Region
		public void addRegion(Region p);
		public void updateRegion(Region p);
		public List<Region> listRegions();
		public Region getRegionById(int id);
		public void removeRegion(int id);
		
		
		//

}
