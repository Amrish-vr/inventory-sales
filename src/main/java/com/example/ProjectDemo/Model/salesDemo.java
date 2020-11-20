package com.example.ProjectDemo.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class salesDemo {

	@Id
	private String item;
	private int salesQuantity;
	private Date salesDate;
	private int availableSoh;

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getSalesQuantity() {
		return salesQuantity;
	}

	public void setSalesQuantity(int salesQuantity) {
		this.salesQuantity = salesQuantity;
	}

	public Date getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}

	public int getAvailableSoh() {
		return availableSoh;
	}

	public void setAvailableSoh(int availableSoh) {
		this.availableSoh = availableSoh;
	}

}
