package com.example.ProjectDemo.Model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Receiving {

	@Id
	private String item;
	private int receivedQty;
	private LocalDateTime receivedDate;
	private int availableSoh;

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getReceivedQty() {
		return receivedQty;
	}

	public void setReceivedQty(int receivedQty) {
		this.receivedQty = receivedQty;
	}

	public LocalDateTime getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(LocalDateTime localDateTime) {
		this.receivedDate = localDateTime;
	}

	public int getAvailableSoh() {
		return availableSoh;
	}

	public void setAvailableSoh(int availableSoh) {
		this.availableSoh = availableSoh;
	}

}
