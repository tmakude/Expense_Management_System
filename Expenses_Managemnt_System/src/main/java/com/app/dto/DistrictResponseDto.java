package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DistrictResponseDto {
	
	private String distrctName;
	private String StateName;
	
	public String getDistrctName() {
		return distrctName;
	}
	public void setDistrctName(String distrctName) {
		this.distrctName = distrctName;
	}
	public String getStateName() {
		return StateName;
	}
	public void setStateName(String stateName) {
		StateName = stateName;
	}
	
	
	

}
