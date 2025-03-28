package com.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.State;
import com.app.service.StateService;

@RestController
@RequestMapping("/api")
public class StateController {

	@Autowired
	private StateService stateService;

	@PostMapping
	public ResponseEntity<?> createState(@RequestBody State state) {

		State newstate = stateService.addState(state);
		return new ResponseEntity<>(newstate, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllStates() {

		return new ResponseEntity<>(stateService.getAllStates(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getStateById(@PathVariable Long id) {

		return new ResponseEntity<>(stateService.getStateById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<State> updateState(@PathVariable Long id, @RequestBody State updatedState) {
		State updated = stateService.updateState(id, updatedState);
		return ResponseEntity.ok(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteState(@PathVariable Long id) {
		stateService.deleteState(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/name/{stateName}")
	public ResponseEntity<State> getStateByName(@PathVariable String stateName) {
		Optional<State> state = stateService.getStateByName(stateName);
		return state.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

}
