package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.dto.EmployeeEMSDTO;
import com.app.entity.Employee;
import com.app.entity.EmployeeEMS;
import com.app.repository.EmployeeEMSRepository;
import com.app.repository.EmployeeRepository;

public class EmployeeEMSServiceImpl implements EmployeeEMSService {
	
	@Autowired
	private EmployeeEMSRepository employeeEMSRepository;
	
	@Autowired
	private EmployeeRepository  employeeRepository;

	@Override
	public EmployeeEMSDTO createEmployeeEMS(EmployeeEMS employee) {
		EmployeeEMS newEmployee = employeeEMSRepository.save(employee);
		return EmployeeEMSconvertDTOTo(newEmployee);
	}



	@Override
	public void deleteEmployeeEMS(String EmployeCode) {
		Employee em = employeeRepository.findByEmployeeCode(EmployeCode);
		
		employeeEMSRepository.deleteById(em.getId());

	}

	@Override
	public List<EmployeeEMSDTO> getAll(){
		List<EmployeeEMS> list = employeeEMSRepository.findAll();
		List<EmployeeEMSDTO> newList = new ArrayList<EmployeeEMSDTO>();
		for(EmployeeEMS e : list )
		{
			newList.add(EmployeeEMSconvertDTOTo(e));
		}
		return newList;
	}
	
	public EmployeeEMS convertDTOToEmployeeEMS(EmployeeEMSDTO employee)
	{
		return EmployeeEMS.builder()
				.employee(employeeRepository.findByEmployeeCode(employee.getEmployeeCode()))
				.role(employee.getRole())
				.password(employee.getPassword())
				.build();
		
	}
	
	public EmployeeEMSDTO EmployeeEMSconvertDTOTo(EmployeeEMS employee) {
		return EmployeeEMSDTO.builder()
				.employeeCode(employee.getEmployee().getEmployeeCode())
				.role(employee.getRole())
				.build();
	}

}
