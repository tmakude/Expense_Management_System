package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.DistrictDto;
import com.app.dto.DistrictResponseDto;
import com.app.entity.District;

public interface DistrictService {
	
	District crearteDistrict(DistrictDto districtdto);
	List<DistrictResponseDto> getAllDistrict();
	Optional<District> getDistrictByName(String name);
	Optional<District> findByid(Long id);
	void deleteDistrict(Long id);

}
