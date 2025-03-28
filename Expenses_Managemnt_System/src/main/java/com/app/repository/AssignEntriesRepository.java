package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.AssignEntries;

@Repository
public interface AssignEntriesRepository extends JpaRepository<AssignEntries, Long> {
}

