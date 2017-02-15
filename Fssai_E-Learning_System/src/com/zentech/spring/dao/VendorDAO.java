package com.zentech.spring.dao;

import java.util.List;

import com.zentech.spring.hb.model.Vendor;

public interface VendorDAO {
	//Vendor
			public void addVendor(Vendor p);
			public void updateVendor(Vendor p);
			public List<Vendor> listVendors();
			public Vendor getVendorById(int id);
			public void removeVendor(int id);
}
