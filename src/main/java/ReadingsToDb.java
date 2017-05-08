import java.io.IOException;
import java.text.ParseException;

import br.telesmeter.exceptions.DataAlreadyExistsException;
import br.telesmeter.exceptions.DataNotFoundException;
import br.telesmeter.exceptions.IncompleteDataException;
import br.telesmeter.sheetwork.DataCapture;
import br.telesmeter.sheetwork.ReadingDataCapture;
import br.telesmeter.utils.JobDoneToFileReport;


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
									
		DataCapture rdc = new ReadingDataCapture(source);
		
		rdc.readDataFromFiles();
		rdc.work();
		
		JobDoneToFileReport.doResumeFromWork(rdc.getSheetData(), "reading");
	
	}

}
