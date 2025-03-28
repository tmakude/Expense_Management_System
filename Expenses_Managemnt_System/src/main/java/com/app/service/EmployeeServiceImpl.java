package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customeException.CustomeException;
import com.app.dto.EmployeeDTO;
import com.app.entity.AccessMaster;
import com.app.entity.Employee;
import com.app.repository.AccessMasterRepository;
import com.app.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Autowired
	private AccessMasterRepository accessmasterRepo;

	private AccessMasterService accessMasterService;

	@Autowired
	public AccessMasterService getAccessMasterService() {
		return accessMasterService;
	}

	@Autowired
	private BranchMasterService branchMasterService;

	public void setAccessMasterService(AccessMasterService accessMasterService) {
		this.accessMasterService = accessMasterService;
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {

		List<Employee> list = employeeRepository.findAll();
		List<EmployeeDTO> newList = new ArrayList<EmployeeDTO>();
		for (Employee e : list) {

			newList.add(convertToDTO(e));
		}

		return newList;
	}

	@Override
	public EmployeeDTO getEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new CustomeException("Employyee not found"));
		EmployeeDTO newEmployee = convertToDTO(employee);
		return newEmployee;
	}

	@Override
	public EmployeeDTO getEmployeeByCode(String employeeCode) {
		Employee employee = employeeRepository.findByEmployeeCode(employeeCode);
		EmployeeDTO newEmployee = convertToDTO(employee);
		return newEmployee;
	}

	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {

		Employee newEmployee = convertToEntity(employeeDTO);

		Employee newEmployee2 = employeeRepository.save(newEmployee);

		return convertToDTO(newEmployee2);
	}

	public void deleteEmployee(Long id) {

		employeeRepository.deleteById(id);

	}

	private EmployeeDTO convertToDTO(Employee employee) {

		return EmployeeDTO.builder().employeeCode(employee.getEmployeeCode()).name(employee.getName())
				.branchCode(employee.getBranch().getBranchCode()).accessMasterRole(employee.getAccessMaster().getRole())
				.build();

	}

	private Employee convertToEntity(EmployeeDTO dto) {

		AccessMaster am = accessMasterService.getAccessMasterByRole(dto.getAccessMasterRole())
				.orElseThrow(() -> new CustomeException("Access master not found !!!"));

		return Employee.builder().employeeCode(dto.getEmployeeCode()).name(dto.getName()).accessMaster(am).build();

	}

}
