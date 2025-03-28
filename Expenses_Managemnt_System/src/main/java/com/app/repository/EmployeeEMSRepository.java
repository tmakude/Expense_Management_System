package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.EmployeeEMS;

@Repository
public interface EmployeeEMSRepository extends JpaRepository<EmployeeEMS, Long> {
}

