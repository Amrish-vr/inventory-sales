package com.example.ProjectDemo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Grp {
	@Id
	private int groupNo;
	private String groupName;
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	

}
