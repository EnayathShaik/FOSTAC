package com.zentech.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.zentech.spring.hb.model.City;
import com.zentech.spring.hb.model.District;
import com.zentech.spring.hb.model.Region;
import com.zentech.spring.hb.model.NState;

@Repository
public class MasterDAOImpl implements MasterDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(MasterDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addState(NState p) {
		// TODO Auto-generated method stub
		System.out.println("statename "+p.getName());
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);

		logger.info("State saved successfully, State Details=" + p);
	}

	@Override
	public void updateState(NState p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("State updated successfully, State Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NState> listStates() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<NState> statesList = session.createQuery("from State").list();
		for (NState p : statesList) {
			logger.info("State List::" + p);
		}
		return statesList;
	}

	@Override
	public NState getStateById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		NState p = (NState) session.load(NState.class, new Integer(id));
		logger.info("State loaded successfully, State details=" + p);
		return p;
	}

	@Override
	public void removeState(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		NState p = (NState) session.load(NState.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		logger.info("State deleted successfully, State details=" + p);
	}

	@Override
	public void addDistrict(District p) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("District saved successfully, Person Details=" + p);
	}

	@Override
	public void updateDistrict(District p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("District updated successfully, District Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<District> listDistricts() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<District> districtsList = session.createQuery("from District")
				.list();
		for (District p : districtsList) {
			logger.info("District List::" + p);
		}
		return districtsList;
	}

	@Override
	public District getDistrictById(int id) {
		// TODO Auto-generated method stub
		System.out.println("------------------------"+id);
		Session session = this.sessionFactory.getCurrentSession();
		District p = (District) session.load(District.class, new Integer(id));
		logger.info("District loaded successfully, District details=" + p);
		return p;
	}

	@Override
	public void removeDistrict(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		District p = (District) session.load(District.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		logger.info("District deleted successfully, District details=" + p);

	}

	@Override
	public void addCity(City p) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("City saved successfully, Person Details=" + p);
	}

	@Override
	public void updateCity(City p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("City updated successfully, City Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<City> listCitys() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<City> citiesList = session.createQuery("from City").list();
		for (City p : citiesList) {
			logger.info("City List::" + p);
		}
		return citiesList;
	}

	@Override
	public City getCityById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		City p = (City) session.load(City.class, new Integer(id));
		logger.info("City loaded successfully, City details=" + p);
		return p;
	}

	@Override
	public void removeCity(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		City p = (City) session.load(City.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		logger.info("City deleted successfully, City details=" + p);

	}

	@Override
	public void addRegion(Region p) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Region saved successfully, Person Details=" + p);
	}

	@Override
	public void updateRegion(Region p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Region updated successfully, Region Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Region> listRegions() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<Region> regionsList = session.createQuery("from Region").list();
		for (Region p : regionsList) {
			logger.info("Region List::" + p);
		}
		return regionsList;
	}

	@Override
	public Region getRegionById(int id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Region p = (Region) session.load(Region.class, new Integer(id));
		logger.info("Region loaded successfully, Region details=" + p);
		return p;
	}

	@Override
	public void removeRegion(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Region p = (Region) session.load(Region.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		logger.info("Region deleted successfully, Region details=" + p);

	}

}
