package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.EmployeeDTO;
import com.app.entity.Employee;

public interface EmployeeService {
	List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(Long id);
    EmployeeDTO getEmployeeByCode(String employeeCode);
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    void deleteEmployee(Long id);

}
