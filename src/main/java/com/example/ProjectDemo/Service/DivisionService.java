package com.example.ProjectDemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjectDemo.Model.Division;
import com.example.ProjectDemo.Projection.HMaster;
import com.example.ProjectDemo.Repository.DivisionRepository;

@Service
public class DivisionService {

	@Autowired
	private DivisionRepository divisionRepo;

	public List<Division> displayAll() {
		return divisionRepo.findAll();
	}

	public List<HMaster> masterdetails() {
		return divisionRepo.masterDetails();
	}

}
