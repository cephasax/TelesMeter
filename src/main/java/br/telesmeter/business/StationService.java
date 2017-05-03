package br.telesmeter.business;

import java.util.ArrayList;
import java.util.List;

import br.telesmeter.dao.StationDao;
import br.telesmeter.domain.Station;
import br.telesmeter.exceptions.DataAlreadyExistsException;
import br.telesmeter.exceptions.DataNotFoundException;
import br.telesmeter.exceptions.IncompleteDataException;

public class StationService {

	StationDao stationDao = new StationDao();

	public void insert(Station station) throws DataAlreadyExistsException, IncompleteDataException {
		verifyStation(station);
		ArrayList<Station> stations = stationDao.findStationForCheck(station);
		if (stations.size() == 0) {
			stationDao.insert(station);
		} 
		else {
			throw new DataAlreadyExistsException("ERROR - INSERT: Station already exists on database");
		}
	}

	public Station update(Station station) throws IncompleteDataException {
		if(validateId(station.getId())){
			verifyStation(station);
			stationDao.update(station);
			return station;
		}
		else{
			throw new IncompleteDataException("ERROR - UPDATE: Cannot work with incomplete station");
		}
	}

	public void delete(Station station) throws IncompleteDataException {
		if(validateId(station.getId())){
			verifyStation(station);
			stationDao.delete(station);
		}
		else{
			throw new IncompleteDataException("ERROR - DELETE: Cannot work with incomplete station");
		}
	}

	public Station find(int entityId) throws DataNotFoundException {
		Station station = new Station();
		if (validateId(entityId)) {
			station = (Station)stationDao.findById(Station.class, entityId);
		} 
		if (station == null) {
			throw new DataNotFoundException("ERROR - FIND: Station does not exist on database");
		} 
		else {
			return station;
		}
	}

	public List<Station> list() throws DataNotFoundException {
		ArrayList<Station> stations = new ArrayList<Station>();
		stations = stationDao.list();
		if (stations.size() > 0) {
			return stations;
		} 
		else {
			throw new DataNotFoundException("ERROR - LIST: Stations table are empty");
		}
	}

	private void verifyStation(Station station) throws IncompleteDataException {
		boolean hasError = false;

		// Required data
		
		// STATION NAME
		if (station.getName() == null) {
			hasError = true;
		}
		
		// STATION LATITUDE
		if (station.getLatitude() == 0.0) {
			hasError = true;
		}
		
		// STATION LONGITUDE
		if (station.getLongitude() == 0.0) {
			hasError = true;
		}		

		if (hasError) {
			throw new IncompleteDataException("ERROR: Cannot work with incomplete station");
		}
	}

	private boolean validateId(int id) {
		boolean valid = false;
		if (id > 0) {
			valid = true;
		}
		return valid;
	}

}
