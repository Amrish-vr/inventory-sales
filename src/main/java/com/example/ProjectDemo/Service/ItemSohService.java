package com.example.ProjectDemo.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.ProjectDemo.Model.ItemSoh;
import com.example.ProjectDemo.Repository.ItemSohRepository;

@Service
public class ItemSohService {

	@Autowired
	private ItemSohRepository ItemSohRepo;

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
		LocalDateTime now= LocalDateTime.now();
		c.setSohUpdateDatetime(now);
		ItemSohRepo.save(c);
	}

}
