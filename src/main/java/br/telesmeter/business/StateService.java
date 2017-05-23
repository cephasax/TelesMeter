package br.telesmeter.business;

import java.util.ArrayList;
import java.util.List;

import br.telesmeter.dao.StateDao;
import br.telesmeter.domain.State;
import br.telesmeter.exceptions.DataAlreadyExistsException;
import br.telesmeter.exceptions.DataNotFoundException;
import br.telesmeter.exceptions.IncompleteDataException;

public class StateService {
	
	private StateDao stateDao = new StateDao();
	
	public void insert(State state) throws DataAlreadyExistsException, IncompleteDataException {
		verifyState(state);
		ArrayList<State> states = stateDao.findStateForCheck(state);
		if (states.size() == 0) {
			stateDao.insert(state);
		} 
		else {
			throw new DataAlreadyExistsException("ERROR - INSERT: State already exists on database");
		}
	}
	
	public State update(State state) throws IncompleteDataException {
		if(validateId(state.getId())){
			verifyState(state);
			stateDao.update(state);
			return state;
		}
		else{
			throw new IncompleteDataException("ERROR - UPDATE: Cannot work with incomplete state");
		}
	}

	public void delete(State state) throws IncompleteDataException {
		if(validateId(state.getId())){
			verifyState(state);
			stateDao.delete(state);
		}
		else{
			throw new IncompleteDataException("ERROR - DELETE: Cannot work with incomplete State");
		}
	}

	public State find(int entityId) throws DataNotFoundException {
		State state = new State();
		if (validateId(entityId)) {
			state = stateDao.findById(entityId);
		} 
		if (state == null) {
			throw new DataNotFoundException("ERROR - FIND: State does not exist on database");
		} 
		else {
			return state;
		}
	}

	public List<State> list() throws DataNotFoundException {
		ArrayList<State> states = new ArrayList<State>();
		states = stateDao.list();
		if (states.size() > 0) {
			return states;
		} 
		else {
			throw new DataNotFoundException("ERROR - LIST: State table are empty");
		}
	}

	private void verifyState(State state) throws IncompleteDataException {
		boolean hasError = false;
		// Required data
		
		// STATE NAME
		if (state.getName() == null) {
			hasError = true;
		}
		
		// STATE COUNTRY
		if (state.getCountry() == null) {
			hasError = true;
		}
		
		if ( hasError ) {
			throw new IncompleteDataException("ERROR: Cannot work with incomplete state");
		}
		
		
	}

	private boolean validateId(int id) {
		boolean valid = false;
		if (id > 0) {
			valid = true;
		}
		return valid;
	}
	
	public StateDao getStateDao() {
		return stateDao;
	}
	
}
