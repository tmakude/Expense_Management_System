package com.app.service;

import com.app.dto.BranchDto;
import com.app.entity.BranchMaster;

public interface BranchMasterService {
	BranchMaster createBranch(BranchDto branchDto);
	BranchMaster updateBranch(Long id , BranchDto branch);
	void deleteBranchMaster(String BranchCode);
	BranchMaster findByBrahCode(String code);
	BranchMaster findByName(String branchname);

}
