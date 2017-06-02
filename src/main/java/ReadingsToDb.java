import java.io.IOException;
import java.text.ParseException;

import br.telesmeter.exceptions.DataAlreadyExistsException;
import br.telesmeter.exceptions.DataNotFoundException;
import br.telesmeter.exceptions.IncompleteDataException;
import br.telesmeter.sheetwork.Buffer;
import br.telesmeter.sheetwork.ReadingDataCapture;
//import br.telesmeter.utils.JobDoneToFileReport;


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
		
		long begin = System.currentTimeMillis();
		String source = new String(	"src/main/resources/data/readings/");
		Buffer bf = new Buffer(100);
		Thread rdcP = new ReadingDataCapture(source, bf, 'p');
		Thread rdcC = new ReadingDataCapture(source, bf, 'c');
		
		rdcP.start();
		rdcC.start();
		
		try {
			rdcP.join();
			rdcC.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//JobDoneToFileReport.doResumeFromWork(rdc.getSheetData(), "reading");
		long end = System.currentTimeMillis();
		System.out.println("Time to insert all readings (seconds): "+ (double)(end-begin)/1000.0);
	}

}
