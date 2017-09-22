package br.telesmeter.sheetdatawriter;
import java.util.ArrayList;

import br.telesmeter.business.StationService;
import br.telesmeter.domain.AbstractData;
import br.telesmeter.domain.Station;
import br.telesmeter.exceptions.DataAlreadyExistsException;
import br.telesmeter.exceptions.IncompleteDataException;


/**
 * 
 * @author Cephas
 *
 *Class to get stations informations from excel sheet and
 *put these information on DataBase
 *
 */
public class StationsToDb implements DataWriter{
	private StationService ss;
	
	public StationsToDb(){
		ss = new StationService();
	}
	
	public void writeDataFromSheet(ArrayList<AbstractData> dataList){
		for(AbstractData d : dataList){
			try {
				ss.insert(((Station)d));
			} catch (DataAlreadyExistsException e) {
				e.printStackTrace();
			} catch (IncompleteDataException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void writeDataFromSheet(AbstractData data){
		try {
			ss.insert(((Station)data));
		} catch (DataAlreadyExistsException e) {
			e.printStackTrace();
		} catch (IncompleteDataException e) {
			e.printStackTrace();
		}
	}

}
