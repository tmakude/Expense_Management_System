package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.AccessMaster;
import com.app.service.AccessMasterService;

@RestController
@RequestMapping("/api/access-master")
public class AccessMasterController {

	@Autowired
	private AccessMasterService accessMasterService;

	@PostMapping
	public ResponseEntity<AccessMaster> createAccessMaster(@RequestBody AccessMaster accessMaster) {
		return ResponseEntity.ok(accessMasterService.createAccessMaster(accessMaster));
	}

	@PatchMapping("/{id}")
	public ResponseEntity<AccessMaster> updateAccessMaster(@PathVariable Long id,
			@RequestBody AccessMaster accessMaster) {
		return ResponseEntity.ok(accessMasterService.updateAccessMaster(id, accessMaster));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccessMaster(@PathVariable Long id) {
		return ResponseEntity.ok(accessMasterService.deleteAccessMaster(id));
	}

	@GetMapping("/role/{role}")
	public ResponseEntity<Optional<AccessMaster>> getAccessMasterByRole(@PathVariable String role) {
		return ResponseEntity.ok(accessMasterService.getAccessMasterByRole(role));
	}

	@GetMapping
	public ResponseEntity<List<AccessMaster>> getAllAccessMasters() {
		return ResponseEntity.ok(accessMasterService.getAllAccessMaster());
	}

}
