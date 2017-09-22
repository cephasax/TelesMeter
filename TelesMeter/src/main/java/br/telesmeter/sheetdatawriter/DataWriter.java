package br.telesmeter.sheetdatawriter;

import java.util.ArrayList;

import br.telesmeter.domain.AbstractData;

public interface DataWriter {
	
	public void writeDataFromSheet(ArrayList<AbstractData> data);
	
	public void writeDataFromSheet(AbstractData data);
}
