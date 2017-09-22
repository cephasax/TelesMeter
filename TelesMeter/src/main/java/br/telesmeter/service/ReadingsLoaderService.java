package br.telesmeter.service;

import br.telesmeter.domain.AbstractData;
import br.telesmeter.sheetdatareader.ReadingDataCapture;
import br.telesmeter.sheetdatawriter.ReadingsToDb;
import br.telesmeter.utils.Buffer;

public class ReadingsLoaderService extends GenericService {
	private String fileName;
	
	public ReadingsLoaderService(String fn) {
		fileName = fn;
	}
	
	public void run(){
		Buffer<AbstractData> fb = new Buffer<AbstractData>(500);

		Thread prod = new DataProducer(fb, new ReadingDataCapture(), fileName );
		Thread cons = new DataConsumer(fb, new ReadingsToDb());
		
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
