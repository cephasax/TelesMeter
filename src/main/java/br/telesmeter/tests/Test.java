package br.telesmeter.tests;

import br.telesmeter.domain.AbstractData;
import br.telesmeter.sheetdatareader.ReadingDataCapture;
import br.telesmeter.sheetdatareader.StationDataCapture;
import br.telesmeter.sheetdatawriter.ReadingsToDb;
import br.telesmeter.sheetdatawriter.StationsToDb;
import br.telesmeter.utils.FixedBuffer;

public class Test {
	
	public static void main(String[] agrs){
		FixedBuffer<AbstractData> fb = new FixedBuffer<AbstractData>(50);

		/** To Stations Test, uncomment the below code  
		Thread prod = new Producer(fb, new StationDataCapture(), new String("src/main/resources/data/stations/stations.xlsx") );
		Thread cons = new Consumer(fb, new StationsToDb());
		**/

		//** To Readings Test, uncomment the below code
		Thread prod = new Producer(fb, new ReadingDataCapture(), new String("src/main/resources/data/readings/acre.xlsx") );
		Thread cons = new Consumer(fb, new ReadingsToDb());
		//**/
		
		
		prod.start();
		cons.start();
		
		try {
			prod.join();
			cons.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
