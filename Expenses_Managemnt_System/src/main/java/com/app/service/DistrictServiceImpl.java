package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customeException.CustomeException;
import com.app.dto.DistrictDto;
import com.app.dto.DistrictResponseDto;
import com.app.entity.District;
import com.app.entity.State;
import com.app.repository.DistrictRepository;
import com.app.repository.StateRepository;

@Service
public class DistrictServiceImpl implements DistrictService {
	
	@Autowired
	private DistrictRepository districtRepo;
	
	@Autowired
	private StateRepository stateRepo;
	
	@Override
	public District crearteDistrict(DistrictDto districtdto) {
		
		
		State  state = stateRepo.findByName(districtdto.getStateName().trim()).orElseThrow(()->new CustomeException("State Not Found"));
		
		District ds = new District();
		
		ds.setState(state);
		ds.setDistrictName(districtdto.getDistrictName());
		districtRepo.save(ds);
		DistrictResponseDto dto = new DistrictResponseDto();
		return districtRepo.save(ds);
	}

	@Override
	public List<DistrictResponseDto> getAllDistrict() {
		
		List<District> list = districtRepo.findAll();
		
		List<DistrictResponseDto> dRS =list.stream().map(ds -> {
			DistrictResponseDto dto = new DistrictResponseDto();
			dto.setDistrctName(ds.getDistrictName());
			dto.setStateName(ds.getState().getStateName());
			return dto;
		}).collect(Collectors.toList());
		
		return dRS;
	}

	@Override
	public Optional<District> getDistrictByName(String name) {

		return districtRepo.findByName(name);
		
	}

	@Override
	public Optional<District> findByid(Long id) {
		
		return districtRepo.findById(id);
	}
	
	public void deleteDistrict(Long id) {

		districtRepo.deleteById(id);

	}

}
