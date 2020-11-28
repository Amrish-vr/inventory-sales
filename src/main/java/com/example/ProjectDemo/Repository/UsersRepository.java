package com.example.ProjectDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjectDemo.Model.Users;

public interface UsersRepository extends JpaRepository<Users, String> {

}
