package com.app.dto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.app.entity.CityMaster;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BranchDto {

	private String branchCode;
	private String branchName;
	private String cityName;

}
