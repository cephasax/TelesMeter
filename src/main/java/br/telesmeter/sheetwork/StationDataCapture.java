package br.telesmeter.sheetwork;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import br.telesmeter.business.StationService;
//import br.telesmeter.domain.AbstractData;
import br.telesmeter.domain.Station;
import br.telesmeter.exceptions.DataAlreadyExistsException;
import br.telesmeter.exceptions.IncompleteDataException;
import br.telesmeter.utils.SheetUtils;

public class StationDataCapture extends DataCapture {

	public StationDataCapture(String source, Buffer bf, char t) {
		super(bf, t);
		this.FILES_SOURCE = new String(source);
	}

	@Override
	public void work() {
		savaStationsOnDataBase();
	}

	@Override
	public void readDataFromSheet(Sheet dataSheet) {

		int trigger = 0;

		DataFormatter sheetDataFormatter = new DataFormatter();

		int numReadStations = 0;
		while (trigger == 0) {
			for (Row row : dataSheet) {

				Station station = new Station();
				for (Cell cell : row) {

					// Read data from cell as String
					String cellData = new String(sheetDataFormatter.formatCellValue(cell));

					// if Row is not empty
					if (!cellData.equals("")) {

						// if first row
						if (cell.getRowIndex() == 0) {
							// add cellData to columns header names
							columnsNames.add(cellData);
						}
						else {
							setStationAttribute(station, cell.getColumnIndex(), cellData);
						}
					} 
					else {
						trigger = 1;
					}
				}
				sheetData.add(station);
				if(++numReadStations>=50){
					buffer.push(sheetData);
					sheetData.clear();
					numReadStations = 0;
				}
			}
		}
		buffer.push(sheetData);
		sheetData.clear();
		buffer.setClosed(true);
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

	private void savaStationsOnDataBase(){
		StationService ss = new StationService();
		while( !(buffer.isClosed() && buffer.isEmpty())){
			Station s = (Station)buffer.pull();
			try {
				ss.insert(s);
			} catch (DataAlreadyExistsException e) {
				
				System.out.println("Station: " + s.toString()+ " - ERRO: ALREADY EXISTS ON DATABASE");
			} catch (IncompleteDataException e) {
				// TODO Auto-generated catch block
				System.out.println("Station: " + s.toString() + " - ERRO: INCOMPLETE");
			}
		}
	}
}
