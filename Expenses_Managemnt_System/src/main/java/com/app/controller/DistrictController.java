package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.DistrictDto;
import com.app.entity.District;
import com.app.entity.State;
import com.app.service.DistrictService;

@RestController
@RequestMapping("/api/district")
public class DistrictController {
	
	@Autowired
	private DistrictService districtService;
	
	@PostMapping
	public ResponseEntity<?> createState(@RequestBody DistrictDto dto) {

		District
		ds = districtService.crearteDistrict(dto);
		return new ResponseEntity<>(ds, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllDistrict() {

		return new ResponseEntity<>(districtService.getAllDistrict(), HttpStatus.OK);
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<?> getByName(@PathVariable String str) {

		return new ResponseEntity<>(districtService.getDistrictByName(str), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getDistrictById(@PathVariable Long id) {

		return new ResponseEntity<>(districtService.findByid(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDistrict(@PathVariable Long id) {
		districtService.deleteDistrict(id);
		return ResponseEntity.noContent().build();
	}

}
