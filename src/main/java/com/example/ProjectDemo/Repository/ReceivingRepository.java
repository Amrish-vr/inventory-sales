package com.example.ProjectDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjectDemo.Model.Receiving;

public interface ReceivingRepository extends JpaRepository<Receiving, String> {

}
