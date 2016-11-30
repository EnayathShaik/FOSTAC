package com.ir.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="title")
public class Title {
	
	@Id
	@Column(name="titleId")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int titleId;
	@Column(name="titleName")
	private String titleName;
	
	public Title() {
	}
	
	public Title(int titleId, String titleName) {
		super();
		this.titleId = titleId;
		this.titleName = titleName;
	}

	public int getTitleId() {
		return titleId;
	}

	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	@Override
	public String toString() {
		return "Title [titleId=" + titleId + ", titleName=" + titleName + "]";
	}
	

}
