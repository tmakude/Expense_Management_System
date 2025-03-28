package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entity.State;

public interface StateService {
	
	State addState(State state);
	List<State> getAllStates();
	State getStateById(Long id);
	State updateState(Long id, State updatedState);
	void deleteState(Long id);
	Optional<State> getStateByName(String stateName);
	

}
