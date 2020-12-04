package com.example.ProjectDemo.Model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class salesDemo {

	@Id
	private String item;
	private int salesQuantity;
	private LocalDateTime salesDate;
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

	public LocalDateTime getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(LocalDateTime localDateTime) {
		this.salesDate = localDateTime;
	}

	public int getAvailableSoh() {
		return availableSoh;
	}

	public void setAvailableSoh(int availableSoh) {
		this.availableSoh = availableSoh;
	}

}
