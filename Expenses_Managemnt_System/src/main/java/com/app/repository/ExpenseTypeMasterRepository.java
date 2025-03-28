package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.ExpenseTypeMaster;

@Repository
public interface ExpenseTypeMasterRepository extends JpaRepository<ExpenseTypeMaster, Long> {
	
	@Query("Select s From ExpenseTypeMaster s where s.expenseName = :expenseName")
	Optional<ExpenseTypeMaster> findByName(@Param("expenseName") String name);
	
	@Query("Select s From ExpenseTypeMaster s where s.category = :category")
	Optional<ExpenseTypeMaster> findByType(@Param("category") String name);
	
}

