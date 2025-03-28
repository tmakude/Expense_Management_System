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

import com.app.dto.EmployeeEMSDTO;
import com.app.entity.EmployeeEMS;
import com.app.service.EmployeeEMSService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/ems")
public class EmployeeEMSController {
	
	
	  private final EmployeeEMSService employeeEMSService;

	    // Constructor-based Dependency Injection
	    @Autowired
	    public EmployeeEMSController(EmployeeEMSService employeeEMSService) {
	        this.employeeEMSService = employeeEMSService;
	    }

	    // Create Employee
	    @PostMapping
	    public ResponseEntity<EmployeeEMSDTO> createEmployee(@RequestBody EmployeeEMS employee) {
	        EmployeeEMSDTO createdEmployee = employeeEMSService.createEmployeeEMS(employee);
	        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
	    }

	    // Get All Employees
	    @GetMapping
	    public ResponseEntity<List<EmployeeEMSDTO>> getAllEmployees() {
	        List<EmployeeEMSDTO> employees = employeeEMSService.getAll();
	        return new ResponseEntity<>(employees, HttpStatus.OK);
	    }

	    // Delete Employee by Employee Code
	    @DeleteMapping("/{employeeCode}")
	    public ResponseEntity<String> deleteEmployee(@PathVariable String employeeCode) {
	        employeeEMSService.deleteEmployeeEMS(employeeCode);
	        return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
	    }
	    

}
