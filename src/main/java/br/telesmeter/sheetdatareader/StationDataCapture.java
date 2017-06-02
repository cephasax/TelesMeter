package br.telesmeter.sheetdatareader;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;

import br.telesmeter.domain.AbstractData;
import br.telesmeter.domain.Station;
import br.telesmeter.utils.SheetUtils;

public class StationDataCapture extends DataCapture {

	public StationDataCapture() {
		this.sheetDataFormatter = new DataFormatter();
	}
	
	public ArrayList<AbstractData> readDataFromSheet(Sheet sheet, int startFromRow, int numberOfRowsToRead) {

		ArrayList<AbstractData> data = new ArrayList<AbstractData>();
		
		int limit = startFromRow + numberOfRowsToRead;
		
		for(int i = startFromRow; i < limit; i++){
			
			Station station = new Station();
			for(Cell cell: sheet.getRow(i)){
				
				String cellData = new String(sheetDataFormatter.formatCellValue(cell));
				
				// if Row is not empty
				if (!cellData.equals("")) {

					//Rows after first row
					if (cell.getRowIndex() > 0) {
						setStationAttribute(station, cell.getColumnIndex(), cellData);
					}
				} 
			}
			data.add(station);
		}
		return data;
	}

	private void setStationAttribute(Station station, int i, String cellData) {
		Double d;
		try {
			
			// if column 0 - codeName
			if (i == 0) {
				station.setCodename(cellData);
			}
			
			// if column 1 - latitude
			else if (i == 1) {
				d = new Double(SheetUtils.parseDecimal(cellData));
				station.setLatitude(d);
			}
			
			// if column 2 - longitude
			else if (i == 2) {
				d = new Double(SheetUtils.parseDecimal(cellData));
				station.setLongitude(d);
			}
			// if column 3 - altitude
			else if (i == 3) {
				d = new Double(SheetUtils.parseDecimal(cellData));
				station.setAltitude(d);
			}		

			// if column 4 - cityName
			else if (i == 4) {
				station.setCityName(cellData);
			}
			
			// if column 5 - basin
			else if (i == 5) {
				station.setBasin(cellData);
			}
			
			// if column 6 - subBasin
			else if (i == 7) {
				station.setSubBasin(cellData);
			}
			// if column 7 - river
			else if (i == 7) {
				station.setRiver(cellData);
			}
			// if column 8 - stateCode
			else if (i == 8) {
				//station.setStateCode(cellData);
				//System.out.println(station.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
