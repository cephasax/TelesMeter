package br.telesmeter.sheetdatawriter;
import java.io.IOException;
import java.text.ParseException;

import br.telesmeter.exceptions.DataAlreadyExistsException;
import br.telesmeter.exceptions.DataNotFoundException;
import br.telesmeter.exceptions.IncompleteDataException;


/**
 * 
 * @author Cephas
 *
 *Class to get readings informations from excel sheet and
 *put these information on DataBase. 
 *
 */
public class ReadingsToDb {

	public static void main(String[] args) throws ParseException, DataAlreadyExistsException, IncompleteDataException, DataNotFoundException, IOException {
		
		String source = new String(	"src/main/resources/data/readings/");
									
		DataCapture rdc = new Teste(source);
		
		rdc.readDataFromFiles();
		System.out.println(rdc.getSheetData().size());
		//rdc.work();
		
		//JobDoneToFileReport.doResumeFromWork(rdc.getSheetData(), "reading");
	
	}

}
