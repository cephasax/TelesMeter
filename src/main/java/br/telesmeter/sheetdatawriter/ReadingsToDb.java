package br.telesmeter.sheetdatawriter;
import java.util.ArrayList;

import br.telesmeter.business.ReadingService;
import br.telesmeter.domain.AbstractData;
import br.telesmeter.domain.Reading;
import br.telesmeter.exceptions.DataAlreadyExistsException;
import br.telesmeter.exceptions.IncompleteDataException;


/**
 * 
 * @author Cephas
 *
 *Class to get readings informations from excel sheet and
 *put these information on DataBase. 
 *
 */
public class ReadingsToDb implements DataWriter{
	ReadingService rs;
	
	public ReadingsToDb(){ 
		rs = new ReadingService();
	}
	
	public void writeDataFromSheet(ArrayList<AbstractData> list) {
		for(AbstractData d : list){
			try {
				rs.insert( ((Reading)d) );
			} catch (DataAlreadyExistsException e) {
				e.printStackTrace();
			} catch (IncompleteDataException e) {
				e.printStackTrace();
			}
		}
	}

	public void writeDataFromSheet(AbstractData data) {
		try {
			rs.insert( ((Reading)data) );
		} catch (DataAlreadyExistsException e) {
			e.printStackTrace();
		} catch (IncompleteDataException e) {
			e.printStackTrace();
		}
	}
	

}
