package com.example.ProjectDemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.ProjectDemo.Model.Receiving;
import com.example.ProjectDemo.Repository.ReceivingRepository;

@Service
public class ReceivingService {

	@Autowired
	private ReceivingRepository ReceivingRepo;

	public Page<Receiving> display(int page) {
		return ReceivingRepo.findAll(PageRequest.of(page, 5));
	}

	public List<Receiving> exportData() {
		return ReceivingRepo.findAll();
	}
}
