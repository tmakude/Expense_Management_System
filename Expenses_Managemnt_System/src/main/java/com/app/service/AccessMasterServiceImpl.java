package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.AccessMaster;
import com.app.repository.AccessMasterRepository;

@Service
public class AccessMasterServiceImpl implements AccessMasterService {
	
	@Autowired
	private AccessMasterRepository accessMasterRepository;

    public AccessMaster createAccessMaster(AccessMaster accessMaster) {
        return accessMasterRepository.save(accessMaster);
    }
    
    public AccessMaster updateAccessMaster(Long id, AccessMaster accessMaster) {
        return accessMasterRepository.findById(id).map(existingAccess -> {
            existingAccess.setRole(accessMaster.getRole());
            existingAccess.setPermissions(accessMaster.getPermissions());
            return accessMasterRepository.save(existingAccess);
        }).orElseThrow(() -> new RuntimeException("AccessMaster not found with ID: " + id));
    }

	@Override
	public String deleteAccessMaster(Long id) {
        if (accessMasterRepository.existsById(id)) {
            accessMasterRepository.deleteById(id);
            return "AccessMaster with ID " + id + " deleted successfully.";
        } else {
            throw new RuntimeException("AccessMaster not found with ID: " + id);
        }
	}

	@Override
	public Optional<AccessMaster> getAccessMasterByRole(String role) {
		return accessMasterRepository.findByRole(role);
	}

	@Override
	public List<AccessMaster> getAllAccessMaster() {
		return accessMasterRepository.findAll();
	}

}
