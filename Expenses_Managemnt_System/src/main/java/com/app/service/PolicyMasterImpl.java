package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customeException.CustomeException;
import com.app.entity.PolicyMaster;
import com.app.repository.PolicyMasterRepository;

@Service
public class PolicyMasterImpl implements PolicyMasterService {

	@Autowired
	private PolicyMasterRepository polyMasterRepo;

	@Override
	public PolicyMaster createPolicy(PolicyMaster policyMaster) {

		return polyMasterRepo.save(policyMaster);
	}

	public PolicyMaster updatePolicy(Long id, PolicyMaster updatedPolicy) {
		Optional<PolicyMaster> existingPolicy = polyMasterRepo.findById(id);

		if (existingPolicy.isPresent()) {
			PolicyMaster policy = existingPolicy.get();

			// Update fields
			policy.setPolicyName(updatedPolicy.getPolicyName());
			policy.setDescription(updatedPolicy.getDescription());
			policy.setEffectiveDate(LocalDate.now());

			return polyMasterRepo.save(policy);
		} else {
			throw new CustomeException("Policy with ID " + id + " not found");
		}
	}

	@Override
	public String deletePolicy(Long id) {
		Optional<PolicyMaster> existingPolicy = polyMasterRepo.findById(id);
		if (existingPolicy.isPresent()) {
			polyMasterRepo.deleteById(id);
			return "Police Deleted SuccesFully";
		} else {
			throw new CustomeException("Policy with ID " + id + " not found");
		}
	}

	@Override
	public List<PolicyMaster> getAllPolicy() {

		return polyMasterRepo.findAll();
	}

	@Override
	public Optional<PolicyMaster> getPolycybyId(Long id) {

		return polyMasterRepo.findById(id);
	}

	@Override
	public Optional<PolicyMaster> getPolycybyPolicyName(String policyName) {

		return polyMasterRepo.findByName(policyName);
	}

}
