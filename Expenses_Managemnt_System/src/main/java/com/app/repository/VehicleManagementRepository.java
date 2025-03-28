package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.VehicleManagement;

@Repository
public interface VehicleManagementRepository extends JpaRepository<VehicleManagement, Long> {
}
