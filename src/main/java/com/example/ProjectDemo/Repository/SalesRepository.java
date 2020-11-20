package com.example.ProjectDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ProjectDemo.Model.salesDemo;

public interface SalesRepository extends JpaRepository<salesDemo, String> {

}
