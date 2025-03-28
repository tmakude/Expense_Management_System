package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.PolicyMaster;
import com.app.entity.State;

@Repository
public interface PolicyMasterRepository extends JpaRepository<PolicyMaster, Long> {

	@Query("Select p From PolicyMaster p where p.policyName = :name")
	Optional<PolicyMaster> findByName(@Param("name") String policyName);

}
