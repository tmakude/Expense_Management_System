package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.PolicyMaster;
import com.app.service.PolicyMasterService;



@RestController
@RequestMapping("/api/policyMaster")
public class PolicyMasterController {

	@Autowired
	private PolicyMasterService policyMasterService;


	@PostMapping
	public ResponseEntity<PolicyMaster> createPolicy( @RequestBody PolicyMaster policyMaster) {

		PolicyMaster newpolicy = policyMasterService.createPolicy(policyMaster);

		if (newpolicy != null) {
			return new ResponseEntity<>(newpolicy, HttpStatus.CREATED);
		}

		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<PolicyMaster> updatepolicy(@PathVariable Long id,
			 @RequestBody PolicyMaster policyMaster) {

		PolicyMaster updated = policyMasterService.updatePolicy(id, policyMaster);

		return new ResponseEntity<>(updated, HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePolicy(@PathVariable Long id) {

		return new ResponseEntity<>(policyMasterService.deletePolicy(id), HttpStatus.OK);

	}

	@GetMapping("/all")
	public ResponseEntity<List<PolicyMaster>> deletePolicy() {

		return new ResponseEntity<>(policyMasterService.getAllPolicy(), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<PolicyMaster> getPolicyById(@PathVariable Long id) {
		Optional<PolicyMaster> policy = policyMasterService.getPolycybyId(id);

		if (policy.isPresent()) {
			return new ResponseEntity<>(policy.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
    @GetMapping("/by-name")
    public ResponseEntity<PolicyMaster> getPolicyByName(@RequestParam String policyName) {
        Optional<PolicyMaster> policy = policyMasterService.getPolycybyPolicyName(policyName);
        
        if (policy.isPresent()) {
            return new ResponseEntity<>(policy.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
