package br.telesmeter.sheetdatareader;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Sheet;

import br.telesmeter.domain.AbstractData;

public interface SheetReader {
		
	public int getNumberOfNoEmptyColumns(Sheet sheet);
	public int getNumberOfNoEmptyRows(Sheet sheet);
	public ArrayList<AbstractData> readDataFromSheet(SheetWindow sheet, int numberOfObjectsToRead);
	public SheetWindow getSheetFromSourceFile(String sourceFile, int sheetIndex, int bufferSize);
	
}
