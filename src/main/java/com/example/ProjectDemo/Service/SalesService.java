package com.example.ProjectDemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.ProjectDemo.Model.salesDemo;
import com.example.ProjectDemo.Repository.SalesRepository;

@Service
public class SalesService {

	@Autowired
	private SalesRepository salesRepo;

	public Page<salesDemo> display(int page) {
		return salesRepo.findAll(PageRequest.of(page, 5));
	}

	public List<salesDemo> exportData() {
		return salesRepo.findAll();
	}
}
