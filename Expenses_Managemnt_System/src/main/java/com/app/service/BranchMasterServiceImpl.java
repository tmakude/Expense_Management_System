package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customeException.CustomeException;
import com.app.dto.BranchDto;
import com.app.entity.BranchMaster;
import com.app.entity.CityMaster;
import com.app.repository.BranchMasterRepository;
import com.app.repository.CityMasterRepository;

import io.swagger.v3.oas.annotations.servers.Server;

@Service
public class BranchMasterServiceImpl implements BranchMasterService {

	@Autowired
	private BranchMasterRepository branchMasterRepository;

	@Autowired
	private CityMasterRepository cityMasterRepository;

	@Override
	public BranchMaster createBranch(BranchDto branchMaster) {

		BranchMaster newBranch = convertDtoToEntity(branchMaster);
		return branchMasterRepository.save(newBranch);
	}

	@Override
	public BranchMaster updateBranch(Long id, BranchDto branch) {
		BranchMaster newBranch = convertDtoToEntity(branch);
		BranchMaster branchs = branchMasterRepository.findById(id)
				.orElseThrow(() -> new CustomeException("Branch not foundWZ"));

		branchs.setBranchCode(branch.getBranchCode());
		branchs.setBranchName(branch.getBranchName());
		branchs.setCity(cityMasterRepository.findByName(branch.getCityName()).orElseThrow());

		return branchMasterRepository.save(branchs);
	}

	@Override
	public void deleteBranchMaster(String BranchCode) {

		branchMasterRepository.deleteByBranchCode(BranchCode);

	}

	@Override
	public BranchMaster findByBrahCode(String code) {

		return branchMasterRepository.findByBranchCode(code).orElseThrow(()-> new CustomeException("Branch not found"));
	}

	@Override
	public BranchMaster findByName(String branchname) {

		return branchMasterRepository.findByName(branchname).orElseThrow(()-> new CustomeException("Branch not found"));
	}

	public BranchMaster convertDtoToEntity(BranchDto branchMaster) {

		CityMaster city = cityMasterRepository.findByName(branchMaster.getCityName())
				.orElseThrow(() -> new CustomeException("City not found"));

		return BranchMaster.builder().branchCode(branchMaster.getBranchCode()).branchName(branchMaster.getBranchName())
				.city(city).build();
	}

	public BranchDto convertEntityToDTO(BranchMaster branchMaster) {

		return BranchDto.builder().branchCode(branchMaster.getBranchCode()).branchName(branchMaster.getBranchName())
				.cityName(branchMaster.getCity().getCityName()).build();
	}

}
