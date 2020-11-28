package com.example.ProjectDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjectDemo.Model.SignUp;

public interface SignUpRepository extends JpaRepository<SignUp, String> {

}
