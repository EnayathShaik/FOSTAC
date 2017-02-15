package com.zentech.spring.hb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="MANAGECOURSECARRICULLUM")
public class ManageCourseCarricullum {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "MCC_SEQ", allocationSize=1, initialValue=1)
	private int id;
	
	private String trainingName;
	
	private String curricullumnTopic;
	
	private String  curricullumDuratiuon;

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public String getCurricullumnTopic() {
		return curricullumnTopic;
	}

	public void setCurricullumnTopic(String curricullumnTopic) {
		this.curricullumnTopic = curricullumnTopic;
	}

	public String getCurricullumDuratiuon() {
		return curricullumDuratiuon;
	}

	public void setCurricullumDuratiuon(String curricullumDuratiuon) {
		this.curricullumDuratiuon = curricullumDuratiuon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "State [id=" + id + ", curricullumnTopic=" + curricullumnTopic + ", curricullumDuratiuon=" + curricullumDuratiuon + "]";
	}

	
}
