package br.telesmeter.business;

import java.util.ArrayList;
import java.util.List;

import br.telesmeter.dao.CountryDao;
import br.telesmeter.domain.Country;
import br.telesmeter.exceptions.DataAlreadyExistsException;
import br.telesmeter.exceptions.DataNotFoundException;
import br.telesmeter.exceptions.IncompleteDataException;

public class CountryService {

private CountryDao countryDao = new CountryDao();
	
	public void insert(Country country) throws DataAlreadyExistsException, IncompleteDataException {
		verifyCountry(country);
		ArrayList<Country> countrys = countryDao.findCountryForCheck(country);
		if (countrys.size() == 0) {
			countryDao.insert(country);
		} 
		else {
			throw new DataAlreadyExistsException("ERROR - INSERT: Reading already exists on database");
		}
	}
	
	public Country update(Country country) throws IncompleteDataException {
		if(validateId(country.getId())){
			verifyCountry(country);
			countryDao.update(country);
			return country;
		}
		else{
			throw new IncompleteDataException("ERROR - UPDATE: Cannot work with incomplete reading");
		}
	}

	public void delete(Country country) throws IncompleteDataException {
		if(validateId(country.getId())){
			verifyCountry(country);
			countryDao.delete(country);
		}
		else{
			throw new IncompleteDataException("ERROR - DELETE: Cannot work with incomplete reading");
		}
	}

	public Country find(int entityId) throws DataNotFoundException {
		Country country = new Country();
		if (validateId(entityId)) {
			country = countryDao.findById(entityId);
		} 
		if (country == null) {
			throw new DataNotFoundException("ERROR - FIND: Reading does not exist on database");
		} 
		else {
			return country;
		}
	}

	public List<Country> list() throws DataNotFoundException {
		ArrayList<Country> countrys = new ArrayList<Country>();
		countrys = countryDao.list();
		if (countrys.size() > 0) {
			return countrys;
		} 
		else {
			throw new DataNotFoundException("ERROR - LIST: Readings table are empty");
		}
	}

	private void verifyCountry(Country country) throws IncompleteDataException {
		// Required data

		// COUNTRY NAME
		if (country.getName() == null) {
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
	
	public CountryDao getCountryDao() {
		return countryDao;
	}
	
}
