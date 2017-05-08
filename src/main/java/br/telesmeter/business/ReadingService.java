package br.telesmeter.business;

import java.util.ArrayList;
import java.util.List;

import br.telesmeter.dao.ReadingDao;
import br.telesmeter.domain.Reading;
import br.telesmeter.exceptions.DataAlreadyExistsException;
import br.telesmeter.exceptions.DataNotFoundException;
import br.telesmeter.exceptions.IncompleteDataException;

public class ReadingService {

	ReadingDao readingDao = new ReadingDao();

	public void insert(Reading reading) throws DataAlreadyExistsException, IncompleteDataException {
		verifyReading(reading);
		ArrayList<Reading> readings = readingDao.findReadingForCheck(reading);
		if (readings.size() == 0) {
			readingDao.insert(reading);
		} 
		else {
			throw new DataAlreadyExistsException("ERROR - INSERT: Reading already exists on database");
		}
	}

	public Reading update(Reading reading) throws IncompleteDataException {
		if(validateId(reading.getId())){
			verifyReading(reading);
			readingDao.update(reading);
			return reading;
		}
		else{
			throw new IncompleteDataException("ERROR - UPDATE: Cannot work with incomplete reading");
		}
	}

	public void delete(Reading reading) throws IncompleteDataException {
		if(validateId(reading.getId())){
			verifyReading(reading);
			readingDao.delete(reading);
		}
		else{
			throw new IncompleteDataException("ERROR - DELETE: Cannot work with incomplete reading");
		}
	}

	public Reading find(int entityId) throws DataNotFoundException {
		Reading reading = new Reading();
		if (validateId(entityId)) {
			reading = readingDao.findById(entityId);
		} 
		if (reading == null) {
			throw new DataNotFoundException("ERROR - FIND: Reading does not exist on database");
		} 
		else {
			return reading;
		}
	}

	public List<Reading> list() throws DataNotFoundException {
		ArrayList<Reading> readings = new ArrayList<Reading>();
		readings = readingDao.list();
		if (readings.size() > 0) {
			return readings;
		} 
		else {
			throw new DataNotFoundException("ERROR - LIST: Readings table are empty");
		}
	}

	private void verifyReading(Reading reading) throws IncompleteDataException {
		boolean hasError = false;

		// Required data
		
		// READING DATE
		if (reading.getDate() == null) {
			hasError = true;
		}
		
		//READING STATION
		if (reading.getStation() == null) {
			hasError = true;
		}

		if (hasError) {
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

	public ReadingDao getReadingDao() {
		return readingDao;
	}

		
	
}
