package br.telesmeter.service;

import br.telesmeter.domain.AbstractData;
import br.telesmeter.exceptions.ClosedBufferException;
import br.telesmeter.sheetdatawriter.DataWriter;
import br.telesmeter.utils.Buffer;

public class DataConsumer extends Thread{
	private Buffer<AbstractData> fixedBuffer;
	private DataWriter dataWriter;
	
	public DataConsumer(Buffer<AbstractData> fb, DataWriter dw){
		fixedBuffer = fb;
		dataWriter = dw;
	}
	 
	public void run(){
		AbstractData data;
		while( !fixedBuffer.isClosed() ){
			try {
				data = fixedBuffer.consume();
				dataWriter.writeDataFromSheet(data);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ClosedBufferException e) {
				break;
			}
		}
	}
}
