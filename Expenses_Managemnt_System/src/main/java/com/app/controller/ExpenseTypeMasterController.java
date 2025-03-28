package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.ExpenseTypeMaster;
import com.app.service.ExpenseTypeMasterService;

@RestController
@RequestMapping("/api/Expensemaster")
public class ExpenseTypeMasterController {

	 @Autowired
	 private ExpenseTypeMasterService expenseTypeMasterService;
	 
	  @PostMapping
	    public ResponseEntity<ExpenseTypeMaster> createExpenseTypeMaster(@RequestBody ExpenseTypeMaster expenseTypeMaster) {
	        ExpenseTypeMaster createdExpenseType = expenseTypeMasterService.createExpenseTypeMaster(expenseTypeMaster);
	        return new ResponseEntity<>(createdExpenseType, HttpStatus.CREATED);
	    }

	    // Update an existing ExpenseTypeMaster
	    @PatchMapping("/{id}")
	    public ResponseEntity<ExpenseTypeMaster> updateExpenseTypeMaster(
	            @PathVariable Long id, 
	            @RequestBody ExpenseTypeMaster expenseTypeMaster) {
	        ExpenseTypeMaster updatedExpenseType = expenseTypeMasterService.updateExpenseTypeMaster(id, expenseTypeMaster);
	        if (updatedExpenseType != null) {
	            return new ResponseEntity<>(updatedExpenseType, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    // Delete an ExpenseTypeMaster
	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteExpenseTypeMaster(@PathVariable Long id) {
	        String response = expenseTypeMasterService.deleteExpenseTypeMaster(id);
	        if (response.equals("Expense Type Master deleted successfully.")) {
	            return new ResponseEntity<>(response, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	        }
	    }

	    // Get ExpenseTypeMaster by name
	    @GetMapping("/by-name")
	    public ResponseEntity<ExpenseTypeMaster> getExpenseTypeMasterByName(@RequestParam String name) {
	        Optional<ExpenseTypeMaster> expenseType = expenseTypeMasterService.getExpenseTypeMasterByName(name);
	        return expenseType.map(expense -> new ResponseEntity<>(expense, HttpStatus.OK))
	                          .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    // Get ExpenseTypeMaster by type
	    @GetMapping("/by-type")
	    public ResponseEntity<ExpenseTypeMaster> getExpenseTypeMasterByType(@RequestParam String type) {
	        Optional<ExpenseTypeMaster> expenseType = expenseTypeMasterService.getExpenseTypeMasterByType(type);
	        return expenseType.map(expense -> new ResponseEntity<>(expense, HttpStatus.OK))
	                          .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }
	    
	    @GetMapping
	    public ResponseEntity<List<ExpenseTypeMaster>> getExpenseTypeMasterAll() {
	        
	    	 return new ResponseEntity<>(expenseTypeMasterService.getAllExpenseTypeMasters(), HttpStatus.OK); 
	    }
}
