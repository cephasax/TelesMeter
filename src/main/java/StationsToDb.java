import java.io.IOException;
import java.text.ParseException;

import br.telesmeter.exceptions.DataAlreadyExistsException;
import br.telesmeter.exceptions.DataNotFoundException;
import br.telesmeter.exceptions.IncompleteDataException;
import br.telesmeter.sheetwork.DataCapture;
import br.telesmeter.sheetwork.StationDataCapture;
import br.telesmeter.utils.JobDoneToFileReport;


/**
 * 
 * @author Cephas
 *
 *Class to get stations informations from excel sheet and
 *put these information on DataBase
 *
 */
public class StationsToDb {

	public static void main(String[] args) throws ParseException, DataAlreadyExistsException, IncompleteDataException, DataNotFoundException, IOException {
		
		String source = new String(	"src/main/resources/data/stations/");
									
		DataCapture sdc = new StationDataCapture(source);
		
		sdc.readDataFromFiles();
		sdc.work();
		
		JobDoneToFileReport.doResumeFromWork(sdc.getSheetData(), "station");
	
	}

}
