package com.app.repository;

import java.util.List;

import org.springdoc.core.converters.models.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entity.ExpenseBook;

@Repository
public interface ExpenseBookRepository extends JpaRepository<ExpenseBook, Long> {
	
	@Query("SELECT e FROM ExpenseBook e WHERE e.deleted = false")
	List<ExpenseBook> findAllActiveExpenses();
	
	List<ExpenseBook> findByEmployeeId(Long employeeId);
	
	Page<ExpenseBook> findByStatus(String status, Pageable pageable);
}

