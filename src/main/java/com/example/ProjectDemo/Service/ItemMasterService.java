package com.example.ProjectDemo.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.ProjectDemo.Model.ItemMaster;
import com.example.ProjectDemo.Model.ItemSoh;
import com.example.ProjectDemo.Repository.ItemMasterRepository;
import com.example.ProjectDemo.Repository.ItemSohRepository;

@Service
public class ItemMasterService {

	@Autowired
	private ItemMasterRepository itemMasterRepo;
	@Autowired
	private ItemSohRepository itemSOhRepo;

	public Page<ItemMaster> display(int page) {
		return itemMasterRepo.findAll(PageRequest.of(page, 5));
	}

	public Optional<ItemMaster> findbyID(String id) {
		return itemMasterRepo.findById(id);
	}

	public void deletebyID(String id) {
		itemMasterRepo.deleteById(id);
	}

	public void save(ItemMaster c) {
		itemMasterRepo.save(c);
		insertSOH(c);
		
	}
	
	
	public List<ItemMaster> displayAll (){
		return itemMasterRepo.findAll();
	}
	
	private void insertSOH (ItemMaster c) {
		ItemSoh itemsoh = new ItemSoh();
		itemsoh.setItem(c.getItem());
		itemsoh.setItemParent(c.getItemParent());
		itemsoh.setStockOnHand(0);
		itemsoh.setSohUpdateDatetime(LocalDateTime.now());
		itemSOhRepo.save(itemsoh);
	}
	
}
