import java.text.ParseException;

import br.telesmeter.business.ReadingService;
import br.telesmeter.business.StationService;
import br.telesmeter.dao.DataBase;
import br.telesmeter.exceptions.DataAlreadyExistsException;
import br.telesmeter.exceptions.DataNotFoundException;
import br.telesmeter.exceptions.IncompleteDataException;
import br.telesmeter.sheetwork.StationDataCapture;

public class MainTest {

	public static void main(String[] args) throws ParseException, DataAlreadyExistsException, IncompleteDataException, DataNotFoundException {
		
		
		String source = new String(	"src/main/resources/data/stations/");
									
		StationDataCapture sdc = new StationDataCapture(source);
		sdc.CaptureDataFromSheet();
		/*SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Station s = new Station();
		s.setLatitude(12145);
		s.setLongitude(11345);
		s.setCodename("1214511345");
		
		Reading r = new Reading();
		r.setDate(sdf.parse("10/11/2014"));
		r.setValue(9.4);
		r.setStation(s);
		
		ss.insert(s);
		rs.insert(r);*/
	
	}

}
