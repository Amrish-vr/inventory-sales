package com.example.ProjectDemo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.ProjectDemo.Model.ItemMaster;
import com.example.ProjectDemo.Repository.ItemMasterRepository;

@Service
public class ItemMasterService {

	@Autowired
	private ItemMasterRepository itemMasterRepo;

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
	}
	
	
	public List<ItemMaster> displayAll (){
		return itemMasterRepo.findAll();
	}

}
