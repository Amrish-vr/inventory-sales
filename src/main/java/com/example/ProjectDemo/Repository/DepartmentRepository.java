package com.example.ProjectDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjectDemo.Model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
