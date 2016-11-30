package com.ir.util;

public enum Profiles {
	SUPERADMIN(1),
	ADMIN(2),
	TRAINEE(3),
	TRAINER(4),
	TRAININGCENTER(5),
	TRAININGPARTNER(7),
	ASSESSOR(6),
	ASSESSMENTAGENCY(8);
	
	private int value;
	
	public int value(){
		return value;
	}
	private Profiles (int value){
		this.value = value;
	}
	
}
