package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.District;
import com.app.entity.State;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {
	
	@Query("Select s From District s where s.districtName = :name")
	Optional<District> findByName(@Param("name") String DistrictName);
}

