package com.app.dto;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeEMSDTO {

	private String employeeCode;
	private String role; // Example: Admin, Checker, Maker, Employee
	private String password;

}
