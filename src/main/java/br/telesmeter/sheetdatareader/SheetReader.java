package br.telesmeter.sheetdatareader;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Sheet;

import br.telesmeter.domain.AbstractData;

public interface SheetReader {
		
	public int getNumberOfNoEmptyColumns(Sheet sheet);
	public int getNumberOfNoEmptyRows(Sheet sheet);
	public ArrayList<AbstractData> readDataFromSheet(Sheet sheet, int startFromRow, int numberOfRowsToRead);
	public Sheet getSheetFromSourceFile(String sourceFile, int sheetIndex);
	
}
