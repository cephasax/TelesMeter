package br.telesmeter.sheetdatareader;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormatter;

import br.telesmeter.domain.AbstractData;
import br.telesmeter.domain.Station;
import br.telesmeter.exceptions.ClosedBufferException;
import br.telesmeter.utils.Buffer;
import br.telesmeter.utils.SheetUtils;
import br.telesmeter.utils.Triple;

public class StationDataCapture extends DataCapture {

	public StationDataCapture() {
		this.sheetDataFormatter = new DataFormatter();
	}
		
	public ArrayList<AbstractData> readDataFromSheet(SheetWindow sheet, int numberOfObjectsToRead) {
		Buffer<Triple<String>> stringToObjectBuffer = sheet.getBuffer();
		ArrayList<AbstractData> data = new ArrayList<AbstractData>();
		Triple<String> t = null;
		
		if(stringToObjectBuffer.isClosed()){
			return data;
		}
		
		//Ignore first line of file (not used in stations file)
		while( stringToObjectBuffer.isClosed() ){
			try {
				t = stringToObjectBuffer.consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ClosedBufferException e) {
				break;
			}
			if(t.getRow()>0){
				break;
			}
		}

		//Get a station information and build a station
		while( !stringToObjectBuffer.isClosed() || data.size()!=numberOfObjectsToRead ){
			
			Station station = new Station();
			while( true ){
				if( setStationAttribute(station, t.getColumn(), t.getData()) ){
					break;
				}
				try {
					t = stringToObjectBuffer.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ClosedBufferException e) {
					break;
				}
			}
			data.add(station);
			
			if(data.size()==numberOfObjectsToRead){
				break;
			}
			else{
				try {
					t = stringToObjectBuffer.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ClosedBufferException e) {
					break;
				}
			}
		}
		return data;
	}

	private boolean setStationAttribute(Station station, int i, String cellData) {
		Double d;
		try {
			
			// if column 0 - codeName
			if (i == 0) {
				station.setCodename(cellData);
				return false;
			}
			
			// if column 1 - latitude
			else if (i == 1) {
				d = new Double(SheetUtils.parseDecimal(cellData));
				station.setLatitude(d);
				return false;
			}
			
			// if column 2 - longitude
			else if (i == 2) {
				d = new Double(SheetUtils.parseDecimal(cellData));
				station.setLongitude(d);
				return false;
			}
			// if column 3 - altitude
			else if (i == 3) {
				d = new Double(SheetUtils.parseDecimal(cellData));
				station.setAltitude(d);
				return false;
			}		

			// if column 4 - cityName
			else if (i == 4) {
				station.setCityName(cellData);
				return false;
			}
			
			// if column 5 - basin
			else if (i == 5) {
				station.setBasin(cellData);
				return false;
			}
			
			// if column 6 - subBasin
			else if (i == 6) {
				station.setSubBasin(cellData);
				return false;
			}
			// if column 7 - river
			else if (i == 7) {
				station.setRiver(cellData);
				return false;
			}
			// if column 8 - stateCode
			else if (i == 8) {
				return true;
				//station.setStateCode(cellData);
				//System.out.println(station.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
