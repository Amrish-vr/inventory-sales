package com.example.ProjectDemo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.ProjectDemo.Model.Department;
import com.example.ProjectDemo.Repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository deptRepo;

	public Page<Department> display(int page) {
		return deptRepo.findAll(PageRequest.of(page, 3));
	}

	public Optional<Department> findbyID(int id) {
		return deptRepo.findById(id);
	}

	public void deletebyID(int id) {
		deptRepo.deleteById(id);
	}

	public void save(Department c) {
		deptRepo.save(c);
	}

}
