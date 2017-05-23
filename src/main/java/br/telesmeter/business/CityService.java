package br.telesmeter.business;

import java.util.ArrayList;
import java.util.List;

import br.telesmeter.dao.CityDao;
import br.telesmeter.domain.City;
import br.telesmeter.exceptions.DataAlreadyExistsException;
import br.telesmeter.exceptions.DataNotFoundException;
import br.telesmeter.exceptions.IncompleteDataException;

public class CityService {
private CityDao cityDao = new CityDao();
	
	public void insert(City city) throws DataAlreadyExistsException, IncompleteDataException {
		verifyCity(city);
		ArrayList<City> citys = cityDao.findCityForCheck(city);
		if (citys.size() == 0) {
			cityDao.insert(city);
		} 
		else {
			throw new DataAlreadyExistsException("ERROR - INSERT: Reading already exists on database");
		}
	}
	
	public City update(City city) throws IncompleteDataException {
		if(validateId(city.getId())){
			verifyCity(city);
			cityDao.update(city);
			return city;
		}
		else{
			throw new IncompleteDataException("ERROR - UPDATE: Cannot work with incomplete reading");
		}
	}

	public void delete(City city) throws IncompleteDataException {
		if(validateId(city.getId())){
			verifyCity(city);
			cityDao.delete(city);
		}
		else{
			throw new IncompleteDataException("ERROR - DELETE: Cannot work with incomplete reading");
		}
	}

	public City find(int entityId) throws DataNotFoundException {
		City city = new City();
		if (validateId(entityId)) {
			city = cityDao.findById(entityId);
		} 
		if (city == null) {
			throw new DataNotFoundException("ERROR - FIND: Reading does not exist on database");
		} 
		else {
			return city;
		}
	}

	public List<City> list() throws DataNotFoundException {
		ArrayList<City> citys = new ArrayList<City>();
		citys = cityDao.list();
		if (citys.size() > 0) {
			return citys;
		} 
		else {
			throw new DataNotFoundException("ERROR - LIST: Readings table are empty");
		}
	}

	private void verifyCity(City city) throws IncompleteDataException {
		boolean hasError = false;
		// Required data
		
		// CITY NAME
		if (city.getName() == null) {
			hasError = true;
		}
		
		// CITY STATE
		if (city.getState() == null) {
			hasError = true;
		}
		
		if ( hasError ) {
			throw new IncompleteDataException("ERROR: Cannot work with incomplete reading");
		}
		
		
	}

	private boolean validateId(int id) {
		boolean valid = false;
		if (id > 0) {
			valid = true;
		}
		return valid;
	}
	
	public CityDao getCityDao() {
		return cityDao;
	}

}
