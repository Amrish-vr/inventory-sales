package com.example.ProjectDemo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Division {

	@Id
	private int divisionNo;
	private String divisionName;

	public int getDivisionNo() {
		return divisionNo;
	}

	public void setDivisionNo(int divisionNo) {
		this.divisionNo = divisionNo;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

}
