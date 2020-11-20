package com.example.ProjectDemo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.ProjectDemo.Model.Division;
import com.example.ProjectDemo.Repository.DivisionRepository;


@Service
public class DivisionSer {
	
	@Autowired
	private DivisionRepository divisionRepo;
	
	
	public Page<Division> display(int page) {
		return divisionRepo.findAll(PageRequest.of(page, 3));
	}
	
	public Optional<Division> findbyID (int id) {
		return divisionRepo.findById(id);
	}
	
	public void deletebyID (int id) {
		 divisionRepo.deleteById(id);
	}
	
	public void save (Division c) {
		divisionRepo.save(c);
	}

}
