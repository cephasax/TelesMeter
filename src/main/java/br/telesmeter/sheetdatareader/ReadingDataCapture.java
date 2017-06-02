package br.telesmeter.sheetdatareader;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;

import br.telesmeter.business.StationService;
import br.telesmeter.domain.AbstractData;
import br.telesmeter.domain.Reading;
import br.telesmeter.domain.Station;
import br.telesmeter.exceptions.DataNotFoundException;
import br.telesmeter.utils.SheetUtils;

public class ReadingDataCapture extends DataCapture {

	private ArrayList<Station> stations;
	private StationService stationService;

	public ReadingDataCapture() {
		this.sheetDataFormatter = new DataFormatter();
		this.stations = new ArrayList<Station>();
		this.stationService = new StationService();
	}

	public ArrayList<AbstractData> readDataFromSheet(Sheet sheet, int startFromRow, int numberOfRowsToRead) {
		
		ArrayList<AbstractData> data = new ArrayList<AbstractData>();
		
		Double d = new Double(0.0);
		Date date = new Date();
		int limit = startFromRow + numberOfRowsToRead;
		
		for(int i = startFromRow; i < limit; i++){
			for(Cell cell: sheet.getRow(i)){
				
				String cellData = new String(sheetDataFormatter.formatCellValue(cell));
				
				//if first row and second column or later
				if(i == 0 && cell.getColumnIndex() > 0){
					
					// get respective Station on database
					//put station on local collection to future Reading attribution 
					Station s = new Station();
					
					try {
						s = stationService.findByCodename(cellData);
						stations.add(s);
					} catch (DataNotFoundException e) {
						e.printStackTrace();
						s = null;
						stations.add(s);
					}
				}
				
				//Rows after first row
				else{
				
					// if Row is not empty
					if (!cellData.equals("")) {

						// if first column
						if (cell.getColumnIndex() == 0) {
							date = cell.getDateCellValue();
						}

						// if cell with precipitation data
						else {

							try {
								// Parse cell
								d = new Double(SheetUtils.parseDecimal(cellData));

							} catch (ParseException e) {
								e.printStackTrace();
							}

							Reading reading = new Reading();
							reading.setDate(date);
							reading.setValue(d);
							reading.setStation(stations.get(cell.getColumnIndex() - 1));
							data.add(reading);
						}
					}
				} 
			}
		}
		return data;
	}
}
