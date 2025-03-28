package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.EmployeeDTO;
import com.app.service.EmployeeService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	  @GetMapping
	    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
	        List<EmployeeDTO> employees = employeeService.getAllEmployees();
	        return ResponseEntity.ok(employees);
	    }

	    // Get employee by ID
	    @GetMapping("/{id}")
	    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
	        EmployeeDTO employee = employeeService.getEmployeeById(id);
	        return ResponseEntity.ok(employee);
	    }

	    // Get employee by code
	    @GetMapping("/code/{employeeCode}")
	    public ResponseEntity<EmployeeDTO> getEmployeeByCode(@PathVariable String employeeCode) {
	        EmployeeDTO employee = employeeService.getEmployeeByCode(employeeCode);
	        return ResponseEntity.ok(employee);
	    }

	    // Save a new employee
	    @PostMapping
	    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
	        EmployeeDTO savedEmployee = employeeService.saveEmployee(employeeDTO);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
	    }

	    // Delete an employee by ID
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
	        employeeService.deleteEmployee(id);
	        return ResponseEntity.noContent().build();
	    }

}
