package com.app.service;

import java.util.List;

import org.springdoc.core.converters.models.Pageable;
import org.springframework.data.domain.Page;

import com.app.dto.ExpenseDTO;
import com.app.entity.ExpenseBook;

public interface ExpenseBookService {
	
	ExpenseBook creatExpese(ExpenseDTO expenseDTO);
	ExpenseBook updateExpense(Long id ,ExpenseDTO expenseDTO);
	void deleteExpense(Long id);
	List<ExpenseBook> getAllExpeses();
	List<ExpenseBook> getAllPendingExpenses(String status);
	Page<ExpenseBook> getExpensesByStatus(String status, int page, int size);
	ExpenseBook approvedExpenses();
	
	

}
