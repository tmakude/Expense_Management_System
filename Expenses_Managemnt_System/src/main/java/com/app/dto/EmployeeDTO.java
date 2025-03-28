package com.app.dto;

import org.springframework.data.annotation.ReadOnlyProperty;

import com.app.entity.AccessMaster;
import com.app.entity.BranchMaster;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class EmployeeDTO {
	

	private String employeeCode;
	private String expenseName;
    private String branchCode;
    private String accessMasterRole;

}
