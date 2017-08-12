package br.telesmeter.service;

import java.util.ArrayList;

import br.telesmeter.domain.AbstractData;
import br.telesmeter.sheetdatareader.DataCapture;
import br.telesmeter.sheetdatareader.SheetWindow;
import br.telesmeter.utils.Buffer;

public class DataProducer extends Thread{
	private Buffer<AbstractData> objectsToPersistBuffer;
	private DataCapture dataCapture;
	private String sourceFile; 
	
	public DataProducer(Buffer<AbstractData> fb, DataCapture dc, String fn){
		this.objectsToPersistBuffer = fb;
		this.dataCapture = dc; 
		this.sourceFile = fn;
	}
	
	public void run(){
		SheetWindow sheet = dataCapture.getSheetFromSourceFile(sourceFile, -1, 100);
		sheet.start();
		int step = 100;
		ArrayList<AbstractData> objectsToPersist = dataCapture.readDataFromSheet(sheet, step);
		
		while( !objectsToPersist.isEmpty() ){
			try {
				while( !objectsToPersist.isEmpty() ){
					objectsToPersistBuffer.produce(objectsToPersist.remove(0));
				}
			} catch (InterruptedException e) {
					e.printStackTrace();
			}
			objectsToPersist = dataCapture.readDataFromSheet(sheet, step);
		}
		objectsToPersistBuffer.close();
	}
	
}
