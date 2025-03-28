package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.CityMaster;
import com.app.entity.District;

@Repository
public interface CityMasterRepository extends JpaRepository<CityMaster, Long> {
	
	@Query("Select s From CityMaster s where s.cityName = :name")
	Optional<CityMaster> findByName(@Param("name") String CityMaster);
}

