package com.example.ProjectDemo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.ProjectDemo.Model.Grp;
import com.example.ProjectDemo.Repository.GrpRepository;

@Service
public class GroupService {

	@Autowired
	private GrpRepository groupRepo;

	public Page<Grp> display(int page) {
		return groupRepo.findAll(PageRequest.of(page, 3));
	}

	public Optional<Grp> findbyID(int id) {
		return groupRepo.findById(id);
	}

	public void deletebyID(int id) {
		groupRepo.deleteById(id);
	}

	public void save(Grp c) {
		groupRepo.save(c);
	}

}
