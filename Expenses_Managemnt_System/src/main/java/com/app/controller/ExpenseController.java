package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ExpenseDTO;
import com.app.entity.ExpenseBook;
import com.app.service.ExpenseBookService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/expesese")
public class ExpenseController {
	@Autowired
	private ExpenseBookService expenseBookService;
	
	@PostMapping
	public ResponseEntity<?> createExpese(@RequestBody ExpenseDTO expenseDTO){
		
		
	}
	
    @GetMapping("/status")
    public ResponseEntity<Page<ExpenseBook>> getExpensesByStatus(
            @RequestParam String status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        
        Page<ExpenseBook> expenses = expenseBookService.getExpensesByStatus(status, page, size);
        return ResponseEntity.ok(expenses);
    }

}
