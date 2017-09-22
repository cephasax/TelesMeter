package br.telesmeter.sheetdatareader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.ss.usermodel.DataFormatter;

import br.telesmeter.business.StationService;
import br.telesmeter.domain.AbstractData;
import br.telesmeter.domain.Reading;
import br.telesmeter.domain.Station;
import br.telesmeter.exceptions.ClosedBufferException;
import br.telesmeter.exceptions.DataNotFoundException;
import br.telesmeter.utils.Buffer;
import br.telesmeter.utils.SheetUtils;
import br.telesmeter.utils.Triple;

public class ReadingDataCapture extends DataCapture {

	private ArrayList<Station> stations;
	private StationService stationService;

	public ReadingDataCapture() {
		this.sheetDataFormatter = new DataFormatter();
		this.stations = new ArrayList<Station>();
		this.stationService = new StationService();
	}

	public ArrayList<AbstractData> readDataFromSheet(SheetWindow sheet, int numberOfObjectsToRead) {
		Buffer<Triple<String>> stringToObjectBuffer = sheet.getBuffer();
		ArrayList<AbstractData> data = new ArrayList<AbstractData>();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Double d = new Double(0.0);
		Date date = new Date();
		Triple<String> t = null;
		
		if( stringToObjectBuffer.isClosed() ){
			return data;
		}
		
		//Get the first line (that contains codename of stations) and mound a list of stations
		//OBS: The list of stations does not increase the size of 'data' 
		while( !stringToObjectBuffer.isClosed() ){
			try {
				t = stringToObjectBuffer.consume();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} catch (ClosedBufferException e) {
				break;
			}
			//Not the first line? so is not a station's codename
			if(t.getRow()>0){
				break;
			}
			else{
				//Ignore the first cell (not used in Readings file)
				if(t.getColumn()==0){
					continue;
				}
				Station s = new Station();

				try {
					s = stationService.findByCodename(t.getData());
					stations.add(s);
				} catch (DataNotFoundException e) {
					e.printStackTrace();
					s = null;
					stations.add(s);
				}
			}
		}
		
		//Get the second row and forward, building the readings
		while( !stringToObjectBuffer.isClosed() || data.size()!=numberOfObjectsToRead ){
			//get date
			if(t.getColumn()==0){
				try {
					date = format.parse(t.getData());
					//System.out.println("data: '" + t.getData() + "' => " + date);
				} catch (ParseException e) {
					System.out.println("String: " + t.getData() );
					e.printStackTrace();
				}
			}
			else{ //get reading value and mount Reading
				try {
					d = new Double(SheetUtils.parseDecimal(t.getData()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				Reading reading = new Reading();
				reading.setDate(date);
				reading.setValue(d);
				reading.setStation(stations.get(t.getColumn()-1));
				data.add(reading);
			}
			
			//Hit the last reading on file or numberOfObjectsToRead? stop
			if( stringToObjectBuffer.isClosed() || data.size()==numberOfObjectsToRead){
				return data;
			}
			else{ // else, get a new reading and keep going
				try {
					t = stringToObjectBuffer.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ClosedBufferException e) {
					return data;
				}
			}
		}
		return data;
	}
}
