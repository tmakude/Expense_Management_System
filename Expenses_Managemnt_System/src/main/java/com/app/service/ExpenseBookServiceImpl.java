package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springdoc.core.converters.models.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.app.customeException.CustomeException;
import com.app.dto.ExpenseDTO;
import com.app.entity.ExpenseBook;
import com.app.repository.EmployeeRepository;
import com.app.repository.ExpenseBookRepository;
import com.app.repository.ExpenseTypeMasterRepository;

@Service
public class ExpenseBookServiceImpl implements ExpenseBookService {
	@Autowired
	private EmployeeEMSService employeeEMSService;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ExpenseTypeMasterRepository expenseTypeMasterRepository;

	@Autowired
	private ExpenseBookRepository expenseBookRepository;

	@Override
	public ExpenseBook creatExpese(ExpenseDTO expenseDTO) {

		return expenseBookRepository.save(convertExpenseDTOToExpenseBook(expenseDTO));
	}

	@Override
	public ExpenseBook updateExpense(Long id, ExpenseDTO expenseDTO) {

		ExpenseBook book = expenseBookRepository.findById(id).orElse(null);

		book.setAmount(expenseDTO.getAmount());
		book.setExpenseType(expenseTypeMasterRepository.findByName(expenseDTO.getExpenseName()).orElse(null));

		return expenseBookRepository.save(book);
	}

	@Override
	public void deleteExpense(Long id) {

		Optional<ExpenseBook> expense = expenseBookRepository.findById(id);

		if (expense.isPresent()) {

			expenseBookRepository.deleteById(id);
		} else {

			throw new CustomeException("Expense with ID " + id + " not found.");
		}

	}

	@Override
	public List<ExpenseBook> getAllExpeses() {

		return expenseBookRepository.findAll();
	}

	@Override
	public List<ExpenseBook> getAllPendingExpenses(String status) {

		return null;
	}

	@Override
	public Page<ExpenseBook> getExpensesByStatus(String status, int page, int size) {
		
		 Pageable pageable = PageRequest.of(page, size);
		return null
	}

	@Override
	public ExpenseBook approvedExpenses() {
		// TODO Auto-generated method stub
		return null;
	}

	private ExpenseBook convertExpenseDTOToExpenseBook(ExpenseDTO expenseDTO) {

		return ExpenseBook.builder().employee(employeeRepository.findByEmployeeCode(expenseDTO.getEmployeeCode()))
				.amount(expenseDTO.getAmount()).ApprovedBy(null).status("PENDING")
				.expenseType(expenseTypeMasterRepository.findByName(expenseDTO.getExpenseName()).orElse(null)).build();

	}

}
