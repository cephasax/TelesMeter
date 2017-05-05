package br.telesmeter.sheetwork;

import java.text.ParseException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import br.telesmeter.domain.AbstractData;
import br.telesmeter.domain.Station;

public class StationDataCapture extends DataCapture {

	public StationDataCapture() {
		this.dataFromSheet = new ArrayList<AbstractData>();
	}

	@Override
	public void work() {
		for (AbstractData a : dataFromSheet) {
			System.out.println(a);
		}
	}

	@Override
	public void readDataFromSheet(Sheet dataSheet) {

		int trigger = 0;

		DataFormatter sheetDataFormatter = new DataFormatter();

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
							setCorrectVAlueFromCell(station, cell.getColumnIndex(), cellData);
						}
					} 
					else {
						trigger = 1;
					}
				}
			}
		}
	}

	private void setCorrectVAlueFromCell(Station station, int i, String cellData) {
		Double d = new Double(0.0);
		try {
			// if column 0 - codeName
			if (i == 0) {
				station.setCodename(cellData);
			}
			// if column 1 - latitude
			else if (i == 1) {
				d = new Double(parseDecimal(cellData));
				station.setLatitude(d);
			}
			// if column 2 - longitude
			else if (i == 2) {
				d = new Double(parseDecimal(cellData));
				station.setLongitude(d);
			}
			// if column 3 - altitude
			else if (i == 3) {
				d = new Double(parseDecimal(cellData));
				station.setAltitude(d);
			}
			// if column 4 - latitude
			else if (i == 4) {
				d = new Double(parseDecimal(cellData));
				station.setLatitude(d);
			}
			// if column 5 - cityName
			else if (i == 5) {
				station.setCityName(cellData);
			}
			// if column 6 - basin
			else if (i == 6) {
				station.setBasin(cellData);
			}
			// if column 7 - subBasin
			else if (i == 7) {
				station.setSubBasin(cellData);
			}
			// if column 8 - river
			else if (i == 8) {
				station.setRiver(cellData);
			}
			// if column 9 - stateCode
			else if (i == 9) {
				station.setStateCode(Integer.valueOf(cellData));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
