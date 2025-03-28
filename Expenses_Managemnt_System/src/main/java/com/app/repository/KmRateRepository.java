package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.KmRate;

@Repository
public interface KmRateRepository extends JpaRepository<KmRate, Long> {
}

