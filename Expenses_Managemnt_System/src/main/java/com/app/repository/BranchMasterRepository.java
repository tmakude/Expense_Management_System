package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.BranchMaster;
import com.app.entity.State;

@Repository
public interface BranchMasterRepository extends JpaRepository<BranchMaster, Long> {
	
	@Query("Select s From BranchMaster s where s.branchCode = :code")
	Optional<BranchMaster> findByBranchCode(@Param("code") String code);
	
	@Query("Select s From BranchMaster s where s.branchName = :name")
	Optional<BranchMaster> findByName(@Param("name") String name);
	
	@Modifying
	@Query("DELETE FROM BranchMaster b WHERE b.branchCode = :branchCode")
	void deleteByBranchCode(@Param("branchCode") String BranchCode);
}

