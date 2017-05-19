package br.telesmeter.business;

import java.util.ArrayList;
import java.util.List;

import br.telesmeter.dao.SheetLogDao;
import br.telesmeter.domain.SheetLog;
import br.telesmeter.exceptions.DataAlreadyExistsException;
import br.telesmeter.exceptions.DataNotFoundException;
import br.telesmeter.exceptions.IncompleteDataException;

public class SheetLogService {
	
	private SheetLogDao sheetLogDao = new SheetLogDao();
	
	public void insert(SheetLog sheetLog) throws DataAlreadyExistsException, IncompleteDataException {
		verifySheetLog(sheetLog);
		ArrayList<SheetLog> logs = sheetLogDao.findSheetLogForCheck(sheetLog);
		if (logs.size() == 0) {
			sheetLogDao.insert(sheetLog);
		} 
		else {
			throw new DataAlreadyExistsException("ERROR - INSERT: Reading already exists on database");
		}
	}
	
	public SheetLog update(SheetLog sheetLog) throws IncompleteDataException {
		if(validateId(sheetLog.getId())){
			verifySheetLog(sheetLog);
			sheetLogDao.update(sheetLog);
			return sheetLog;
		}
		else{
			throw new IncompleteDataException("ERROR - UPDATE: Cannot work with incomplete reading");
		}
	}

	public void delete(SheetLog sheetLog) throws IncompleteDataException {
		if(validateId(sheetLog.getId())){
			verifySheetLog(sheetLog);
			sheetLogDao.delete(sheetLog);
		}
		else{
			throw new IncompleteDataException("ERROR - DELETE: Cannot work with incomplete reading");
		}
	}

	public SheetLog find(int entityId) throws DataNotFoundException {
		SheetLog sheetLog = new SheetLog();
		if (validateId(entityId)) {
			sheetLog = sheetLogDao.findById(entityId);
		} 
		if (sheetLog == null) {
			throw new DataNotFoundException("ERROR - FIND: Reading does not exist on database");
		} 
		else {
			return sheetLog;
		}
	}

	public List<SheetLog> list() throws DataNotFoundException {
		ArrayList<SheetLog> logs = new ArrayList<SheetLog>();
		logs = sheetLogDao.list();
		if (logs.size() > 0) {
			return logs;
		} 
		else {
			throw new DataNotFoundException("ERROR - LIST: Readings table are empty");
		}
	}

	private void verifySheetLog(SheetLog sheetLog) throws IncompleteDataException {
		boolean hasError = false;

		// Required data

		// SHEETLOG FILENAME
		if (sheetLog.getFileName() == null) {
			hasError = true;
		}
		
		// SHEETLOG DATE
		if (sheetLog.getDate() == null) {
			hasError = true;
		}
		
		// SHEETLOG COLUMNSNAMES
		if (sheetLog.getColumnsNames() == null) {
			hasError = true;
		}
		
		// SHEETLOG INSERT TIME
		if (sheetLog.getTimeToInsertInMinutes() < 0) {
			hasError = true;
		}

		//SHEETLOG ENTITY TYPE
		if (sheetLog.getEntityType() == null) {
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
	
	public SheetLogDao getSheetLogDao() {
		return sheetLogDao;
	}

}
