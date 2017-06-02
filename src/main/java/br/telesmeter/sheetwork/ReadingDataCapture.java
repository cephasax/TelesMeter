package br.telesmeter.sheetwork;

//import java.text.DateFormat;
import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import br.telesmeter.business.ReadingService;
import br.telesmeter.business.StationService;
//import br.telesmeter.domain.AbstractData;
import br.telesmeter.domain.Reading;
import br.telesmeter.domain.Station;
import br.telesmeter.exceptions.DataAlreadyExistsException;
import br.telesmeter.exceptions.DataNotFoundException;
import br.telesmeter.exceptions.IncompleteDataException;
import br.telesmeter.utils.SheetUtils;


public class ReadingDataCapture extends DataCapture {

	private ArrayList<Station> stations = new ArrayList<Station>(); 
	
	public ReadingDataCapture(String source, Buffer bf, char t) {
		super(bf, t);
		this.FILES_SOURCE = new String(source);
	}
	
	
	@Override
	public void work() {
		savaReadingsOnDataBase();
	}

	@Override
	public void readDataFromSheet(Sheet dataSheet){
		
		int trigger = 0;
		
		DataFormatter sheetDataFormatter = new DataFormatter();
		Double d = new Double(0.0);
		//DateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		StationService stationService = new StationService();
		int numReadMeasures=0;
		while (trigger == 0) {
			for (Row row : dataSheet) {
				for (Cell cell : row) {
					
					//Read data from cell as String
					String cellData = new String (sheetDataFormatter.formatCellValue(cell));
					
					//if Row is not empty
					if (!cellData.equals("")) {

						// if first row
						if (cell.getRowIndex() == 0) {
							if (cell.getColumnIndex() == 0) {
								continue;
							}
							//add cellData to columns header names
							columnsNames.add(cellData);
							Station s = new Station();
							try {
								s = stationService.findByCodename(cellData);
								stations.add(s);
							} catch (DataNotFoundException e) {
								e.printStackTrace();
							}
							
						} else {

							// if first column
							if (cell.getColumnIndex() == 0) {
								date = cell.getDateCellValue();
							} 
							
							//if cell with precipitation data
							else {
								
								try {
									//Parse cell
									d = new Double(SheetUtils.parseDecimal(cellData));
									
								} catch (ParseException e) {
									e.printStackTrace();
								}

								Reading reading = new Reading();
								reading.setDate(date);
								reading.setValue(d);
								reading.setStation(stations.get(cell.getColumnIndex()-1));
								sheetData.add(reading);
								if(++numReadMeasures>=50){
									buffer.push(sheetData);
									sheetData.clear();
									numReadMeasures=0;
								}
							}
						}
					} else {
						trigger = 1;
					}
				}
			}
		}
		buffer.push(sheetData);
		sheetData.clear();
		buffer.setClosed(true);
	}

	private void savaReadingsOnDataBase(){
		ReadingService readingService = new ReadingService();
		
		while(!(buffer.isClosed() && buffer.isEmpty())){
			Reading r = (Reading)buffer.pull();
			try {
				readingService.insert(r);
			} catch (DataAlreadyExistsException e) {
				
				System.out.println("Reading: " + r.toString()+ " - ERRO: ALREADY EXISTS ON DATABASE");
			} catch (IncompleteDataException e) {
				System.out.println("Reading: " + r.toString() + " - ERRO: INCOMPLETE");
			}
		}
	}
	
}
