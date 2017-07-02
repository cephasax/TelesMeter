package br.telesmeter.tests;

import br.telesmeter.domain.AbstractData;
import br.telesmeter.sheetdatawriter.DataWriter;
import br.telesmeter.utils.FixedBuffer;

public class Consumer extends Thread{
	private FixedBuffer<AbstractData> fixedBuffer;
	private DataWriter dataWriter;
	
	public Consumer(FixedBuffer<AbstractData> fb, DataWriter dw){
		fixedBuffer = fb;
		dataWriter = dw;
	}
	 
	public void run(){
		try {
			AbstractData data;
			while( !fixedBuffer.isClosed() ){
				data = fixedBuffer.consume();
				dataWriter.writeDataFromSheet(data);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
