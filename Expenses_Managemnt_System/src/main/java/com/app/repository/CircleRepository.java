package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Circle;

@Repository
public interface CircleRepository extends JpaRepository<Circle, Long> {
}

