package br.telesmeter.service;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Sheet;

import br.telesmeter.domain.AbstractData;
import br.telesmeter.sheetdatareader.DataCapture;
import br.telesmeter.utils.Buffer;

public class DataProducer extends Thread{
	private Buffer<AbstractData> fixedBuffer;
	private DataCapture dataCapture;
	private String sourceFile; 
	
	public DataProducer(Buffer<AbstractData> fb, DataCapture dc, String fn){
		this.fixedBuffer = fb;
		this.dataCapture = dc; 
		this.sourceFile = fn;
	}
	
	public void run(){
		Sheet sheet = dataCapture.getSheetFromSourceFile(sourceFile, -1);
		int limit = dataCapture.getNumberOfNoEmptyRows(sheet);
		int step = 100;
		ArrayList<AbstractData> list;
		
		for( int begin=0 ; begin<limit ; begin+=step ){
			
			step = (begin+step)<limit ? step : (limit-begin);
			list = dataCapture.readDataFromSheet(sheet, begin, step);
			
			try {
				while( !list.isEmpty() ){
					fixedBuffer.produce(list.remove(0));
				}
			} catch (InterruptedException e) {
					e.printStackTrace();
			}
		}
		
		fixedBuffer.close();
	}
	
}
