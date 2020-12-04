package com.example.ProjectDemo.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.ProjectDemo.Model.ItemSoh;
import com.example.ProjectDemo.Model.Receiving;
import com.example.ProjectDemo.Model.salesDemo;
import com.example.ProjectDemo.Repository.ItemSohRepository;
import com.example.ProjectDemo.Repository.ReceivingRepository;
import com.example.ProjectDemo.Repository.SalesRepository;

@Service
public class ItemSohService {

	@Autowired
	private ItemSohRepository ItemSohRepo;
	@Autowired
	private ReceivingRepository receivingRepo;
	@Autowired
	private SalesRepository salesRepo;

	public Page<ItemSoh> display(int page) {
		return ItemSohRepo.findAll(PageRequest.of(page, 3));
	}

	public Optional<ItemSoh> findbyID(String id) {
		return ItemSohRepo.findById(id);
	}

	public void deletebyID(String id) {
		ItemSohRepo.deleteById(id);
	}

	public void save(ItemSoh c) {
		Optional<ItemSoh> itemsoh = ItemSohRepo.findById(c.getItem());
		if (c.getStockOnHand() > itemsoh.get().getStockOnHand()) {
			insertReceiving(c, c.getStockOnHand() - itemsoh.get().getStockOnHand());
		} else {
			insertSales (c,itemsoh.get().getStockOnHand()-c.getStockOnHand());
		}
		c.setSohUpdateDatetime(LocalDateTime.now());
		ItemSohRepo.save(c);
	}

	private void insertReceiving(ItemSoh c, int received) {
		Receiving receiving = new Receiving();
		receiving.setItem(c.getItem());
		receiving.setAvailableSoh(c.getStockOnHand());
		receiving.setReceivedQty(received);
		receiving.setReceivedDate(LocalDateTime.now());
		receivingRepo.save(receiving);

	}
	
	private void insertSales(ItemSoh c,int sale) {
	    salesDemo sales = new salesDemo();
	    sales.setItem(c.getItem());
	    sales.setAvailableSoh(c.getStockOnHand());
	    sales.setSalesQuantity(sale);
	    sales.setSalesDate(LocalDateTime.now());
	    salesRepo.save(sales);
	}
	

}
