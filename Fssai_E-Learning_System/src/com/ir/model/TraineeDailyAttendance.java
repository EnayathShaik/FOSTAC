package com.ir.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="traineeDailyAttendance")
public class TraineeDailyAttendance {
	
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int traineeAttendanceId;
	
private String rollNumber;

public int getTraineeAttendanceId() {
	return traineeAttendanceId;
}

public void setTraineeAttendanceId(int traineeAttendanceId) {
	this.traineeAttendanceId = traineeAttendanceId;
}

private String attendanceDate;

public String getRollNumber() {
	return rollNumber;
}

public void setRollNumber(String rollNumber) {
	this.rollNumber = rollNumber;
}

public String getAttendanceDate() {
	return attendanceDate;
}

public void setAttendanceDate(String attendanceDate) {
	this.attendanceDate = attendanceDate;
}


	
	
}
