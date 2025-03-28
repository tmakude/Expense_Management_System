package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entity.PolicyMaster;

public interface PolicyMasterService {
	
	PolicyMaster createPolicy(PolicyMaster policyMaster);
	PolicyMaster updatePolicy(Long id ,PolicyMaster updatedPolicy);
	String deletePolicy(Long id);
	List<PolicyMaster> getAllPolicy();
	Optional<PolicyMaster> getPolycybyId(Long id);
	Optional<PolicyMaster> getPolycybyPolicyName(String policyName);
	

}
