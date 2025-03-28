package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customeException.CustomeException;
import com.app.dto.CityDTO;
import com.app.entity.CityMaster;
import com.app.entity.State;
import com.app.repository.CityMasterRepository;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityMasterRepository cityRepository;

	@Autowired
	private StateService stateService;

	@Override
	public List<CityDTO> getAllCities() {
		return cityRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	public Optional<CityDTO> getCityById(Long id) {
		return cityRepository.findById(id).map(this::convertToDTO);
	}

	@Override
	public Optional<CityDTO> getCityByName(String name) {
		return cityRepository.findByName(name).map(this::convertToDTO);
	}

	@Override
	public CityDTO saveCity(CityDTO cityDTO) {
		CityMaster city = convertToEntity(cityDTO);
		CityMaster savedCity = cityRepository.save(city);
		return convertToDTO(savedCity);
	}

	@Override
	public void deleteCity(Long id) {
		cityRepository.deleteById(id);

	}

	private CityDTO convertToDTO(CityMaster city) {
		CityDTO dto = new CityDTO();
		dto.setCityName(city.getCityName());
		dto.setStateName(city.getState() != null ? city.getState().getStateName() : null);
		return dto;
	}

	private CityMaster convertToEntity(CityDTO dto) {

		State state = stateService.getStateByName(dto.getStateName())
				.orElseThrow(() -> new CustomeException("Satate not found"));

		CityMaster city = new CityMaster();
		city.setCityName(dto.getCityName());
		city.setState(state);
		return city;
	}

}
