import java.io.IOException;
import java.text.ParseException;

import br.telesmeter.exceptions.DataAlreadyExistsException;
import br.telesmeter.exceptions.DataNotFoundException;
import br.telesmeter.exceptions.IncompleteDataException;
import br.telesmeter.sheetwork.Buffer;
//import br.telesmeter.sheetwork.DataCapture;
import br.telesmeter.sheetwork.StationDataCapture;
//import br.telesmeter.utils.JobDoneToFileReport;


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
		
		long begin = System.currentTimeMillis();
		String source = new String(	"src/main/resources/data/stations/");
		Buffer bf = new Buffer(100); // haverá no máximo este número de objetos na memoria por vez		
		Thread sdcProducer = new StationDataCapture(source, bf, 'p');
		Thread sdcConsumer = new StationDataCapture(source, bf, 'c');
		
		sdcProducer.start();
		sdcConsumer.start();
		
		
		try {
			sdcProducer.join();
			sdcConsumer.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//JobDoneToFileReport.doResumeFromWork(sdc.getSheetData(), "station");
		long end = System.currentTimeMillis();
		
		System.out.println("Time to insert 9073 stations (seconds): "+ (double)(end-begin)/1000.0);
	
	}

}
