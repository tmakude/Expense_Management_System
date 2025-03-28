package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
	
	@Query("Select s From State s where s.stateName = :name")
	Optional<State> findByName(@Param("name") String stateName);
}

