package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.TallyExpensesHead;

@Repository
public interface TallyExpensesHeadRepository extends JpaRepository<TallyExpensesHead, Long> {
}

