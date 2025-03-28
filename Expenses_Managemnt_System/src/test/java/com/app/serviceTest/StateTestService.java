package com.app.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.app.entity.State;
import com.app.repository.StateRepository;
import com.app.service.StateService;

@RunWith(MockitoJUnitRunner.class)
public class StateTestService {
	
	@Mock
	private StateRepository stateRepo;
	
	@InjectMocks
	private StateService stateService;
	
	@Test
	public void getAllStates() {
		
		List<State> listOfState = Arrays.asList(new State(1L , "Maharshtra"));
		
		when(stateRepo.findAll()).thenReturn(listOfState);
		
		List<State> listOfStates= stateService.getAllStates();
		
		assertEquals("Maharshtra" , listOfStates.get(0).getStateName()); 
		
		
	}

}
