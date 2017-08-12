package br.telesmeter.sheetdatareader;

import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import br.telesmeter.utils.Buffer;
import br.telesmeter.utils.Triple;

public abstract class DataCapture implements SheetReader{

	protected DataFormatter sheetDataFormatter;
	
	public SheetWindow getSheetFromSourceFile(String sourceFile, int sheetIndex, int bufferSize) {
		Buffer<Triple<String>> buffer = new Buffer<Triple<String>>(bufferSize);
		SheetWindow sw = new SheetWindow();
		sw.setFile(new File(sourceFile));
		sw.setBuffer(buffer);
		return sw;		
	}
	
	//out
	public int getNumberOfNoEmptyColumns(Sheet sheet) {

		int numberOfColumns = 0;
		for (Cell cell : sheet.getRow(0)) {
			
			String cellData = new String (sheetDataFormatter.formatCellValue(cell));
			if(!cellData.equals("")){
				numberOfColumns++;
			}

		}
		return numberOfColumns;
	}

	//out
	public int getNumberOfNoEmptyRows(Sheet sheet) {

		int numberOfRows = 0;
		for (Row row : sheet) {
			String cellData = new String (sheetDataFormatter.formatCellValue(row.getCell(0)));
			if(!cellData.equals("")){
				numberOfRows++;
			}
		}
		return numberOfRows;
	}
	
}
