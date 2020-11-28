package com.example.ProjectDemo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {

	@Id
	private int deptNo;
	private String deptName;
	private int groupNo;

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	

}
