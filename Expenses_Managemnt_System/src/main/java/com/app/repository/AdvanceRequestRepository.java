package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.AdvanceRequest;

@Repository
public interface AdvanceRequestRepository extends JpaRepository<AdvanceRequest, Long> {
}

