package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.CityDTO;

public interface CityService {
	List<CityDTO> getAllCities();
    Optional<CityDTO> getCityById(Long id);
    Optional<CityDTO> getCityByName(String name);
    CityDTO saveCity(CityDTO cityDTO);
    void deleteCity(Long id);

}
