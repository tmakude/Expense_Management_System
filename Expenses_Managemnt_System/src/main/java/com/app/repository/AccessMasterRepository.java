package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.AccessMaster;

@Repository
public interface AccessMasterRepository extends JpaRepository<AccessMaster , Long> {

	@Query("Select s From AccessMaster s where s.role = :role")
	Optional<AccessMaster> findByRole(@Param("role") String role);
}

