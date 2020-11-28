package com.example.ProjectDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjectDemo.Model.Authorities;

public interface AuthoritiesRepository extends JpaRepository<Authorities, String> {

}
