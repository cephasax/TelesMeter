package br.telesmeter.service;

import br.telesmeter.domain.AbstractData;
import br.telesmeter.sheetdatareader.StationDataCapture;
import br.telesmeter.sheetdatawriter.StationsToDb;
import br.telesmeter.utils.Buffer;

public class StationsLoaderService extends GenericService{
	private String fileName;
	
	public StationsLoaderService(String fn){
		fileName = fn;
	}
	
	public void run(){
		Buffer<AbstractData> fb = new Buffer<AbstractData>(500);
  
		Thread prod = new DataProducer(fb, new StationDataCapture(), fileName );
		Thread cons = new DataConsumer(fb, new StationsToDb());
				
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
