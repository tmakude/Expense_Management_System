package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entity.ExpenseTypeMaster;

public interface ExpenseTypeMasterService {
	
	ExpenseTypeMaster createExpenseTypeMaster(ExpenseTypeMaster expenseTypeMaster);
	ExpenseTypeMaster updateExpenseTypeMaster(Long id,ExpenseTypeMaster expenseTypeMaster);
	String deleteExpenseTypeMaster(Long id);
	Optional<ExpenseTypeMaster> getExpenseTypeMasterByName(String expencename);
	Optional<ExpenseTypeMaster> getExpenseTypeMasterByType(String expenceType);
	List<ExpenseTypeMaster> getAllExpenseTypeMasters();

}
