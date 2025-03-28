package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entity.AccessMaster;
import com.app.entity.ExpenseTypeMaster;

public interface AccessMasterService {
	
	AccessMaster createAccessMaster(AccessMaster accessMaster);
	AccessMaster updateAccessMaster(Long id,AccessMaster accessMaster);
	String deleteAccessMaster(Long id);
	Optional<AccessMaster> getAccessMasterByRole(String role);
	List<AccessMaster> getAllAccessMaster();

}
