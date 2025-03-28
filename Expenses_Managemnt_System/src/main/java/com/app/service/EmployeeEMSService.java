package com.app.service;

import java.util.List;

import com.app.dto.EmployeeEMSDTO;
import com.app.entity.EmployeeEMS;

public interface EmployeeEMSService {

	EmployeeEMSDTO createEmployeeEMS(EmployeeEMS employee);

	void deleteEmployeeEMS(String EmployeCode);

	List<EmployeeEMSDTO> getAll();

}
