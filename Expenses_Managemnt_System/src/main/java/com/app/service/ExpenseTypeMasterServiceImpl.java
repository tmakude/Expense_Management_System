package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.ExpenseTypeMaster;
import com.app.repository.ExpenseTypeMasterRepository;

@Service
public class ExpenseTypeMasterServiceImpl implements ExpenseTypeMasterService {

	@Autowired
	private ExpenseTypeMasterRepository expensemasterrepo;

	@Override
	public ExpenseTypeMaster createExpenseTypeMaster(ExpenseTypeMaster expenseTypeMaster) {

		return expensemasterrepo.save(expenseTypeMaster);
	}

	@Override
	public ExpenseTypeMaster updateExpenseTypeMaster(Long id, ExpenseTypeMaster expenseTypeMaster) {
		Optional<ExpenseTypeMaster> existingExpenseType = expensemasterrepo.findById(id);
		if (existingExpenseType.isPresent()) {
			// Update the existing entity's fields
			ExpenseTypeMaster updatedExpenseType = existingExpenseType.get();
			updatedExpenseType.setExpenseName(expenseTypeMaster.getExpenseName());
			updatedExpenseType.setCategory(expenseTypeMaster.getCategory());
			updatedExpenseType.setCreditLimit(expenseTypeMaster.getCreditLimit());

			// Save the updated entity
			return expensemasterrepo.save(updatedExpenseType);
		}
		return null;

	}

	@Override
	public String deleteExpenseTypeMaster(Long id) {
		if (expensemasterrepo.existsById(id)) {
			expensemasterrepo.deleteById(id);
			return "Expense Type Master deleted successfully.";
		} else {
			return "Expense Type Master not found.";
		}
	}

	@Override
	public Optional<ExpenseTypeMaster> getExpenseTypeMasterByName(String expencename) {
		return expensemasterrepo.findByName(expencename);
	}

	@Override
	public Optional<ExpenseTypeMaster> getExpenseTypeMasterByType(String expenseType) {
		return expensemasterrepo.findByType(expenseType);
	}
	
    @Override
    public List<ExpenseTypeMaster> getAllExpenseTypeMasters() {
        return expensemasterrepo.findAll(); // Fetch all records
    }

}
