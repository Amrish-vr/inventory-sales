package com.example.ProjectDemo.Model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemSoh {

	@Id
	private String item;
	private String itemParent;
	private int stockOnHand;
	private LocalDateTime SohUpdateDatetime;
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getItemParent() {
		return itemParent;
	}
	public void setItemParent(String itemParent) {
		this.itemParent = itemParent;
	}
	public int getStockOnHand() {
		return stockOnHand;
	}
	public void setStockOnHand(int stockOnHand) {
		this.stockOnHand = stockOnHand;
	}
	public LocalDateTime getSohUpdateDatetime() {
		return SohUpdateDatetime;
	}
	public void setSohUpdateDatetime(LocalDateTime sohUpdateDatetime) {
		SohUpdateDatetime = sohUpdateDatetime;
	}
	
	
}
