package com.app.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customeException.CustomeException;
import com.app.entity.State;
import com.app.repository.StateRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StateServiceImpl implements StateService {

	@Autowired
	private StateRepository stateRepository;

	@Override
	public State addState(State state) {

		return stateRepository.save(state);
	}

	@Override
	public List<State> getAllStates() {

		return stateRepository.findAll();
	}

	@Override
	public State getStateById(Long id) {

		return stateRepository.findById(id).orElseThrow(() -> new CustomeException("Satate not Found !!!"));
	}

	@Override
	public State updateState(Long id, State updatedState) {

		return stateRepository.findById(id).map(state -> {

			state.setStateName(updatedState.getStateName());
			return stateRepository.save(state);
		}).orElseThrow(() -> new CustomeException("Satate not Found !!!"));
	}

	@Override
	public void deleteState(Long id) {

		stateRepository.deleteById(id);

	}

	@Override
	public Optional<State> getStateByName(String stateName) {

		return stateRepository.findByName(stateName);
	}

}
