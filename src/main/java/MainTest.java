import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.telesmeter.business.ReadingService;
import br.telesmeter.business.StationService;
import br.telesmeter.dao.DataBase;
import br.telesmeter.domain.Reading;
import br.telesmeter.domain.Station;
import br.telesmeter.exceptions.DataAlreadyExistsException;
import br.telesmeter.exceptions.DataNotFoundException;
import br.telesmeter.exceptions.IncompleteDataException;

public class MainTest {

	public static void main(String[] args) throws ParseException, DataAlreadyExistsException, IncompleteDataException, DataNotFoundException {
		
		DataBase db = DataBase.getInstance();
		ReadingService rs = new ReadingService();
		StationService ss = new StationService();
				
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Station s = new Station();
		s.setLatitude(12145);
		s.setLongitude(11345);
		s.setName("1214511345");
		
		Reading r = new Reading();
		r.setDate(sdf.parse("10/11/2014"));
		r.setValue(9.4);
		r.setStation(s);
		
		ss.insert(s);
		rs.insert(r);
		
		System.out.println(rs.find(1).toString());
	}

}
