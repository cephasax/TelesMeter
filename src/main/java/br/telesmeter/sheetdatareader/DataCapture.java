package br.telesmeter.sheetdatareader;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class DataCapture implements SheetReader{

	protected DataFormatter sheetDataFormatter;
	
	public Sheet getSheetFromSourceFile(String sourceFile, int sheetIndex) {
		try{
			FileInputStream excelFile = new FileInputStream(new File(sourceFile));
			
			Workbook workBook = new XSSFWorkbook(excelFile);
			Sheet dataSheet = workBook.getSheetAt(0);
			workBook.close();
			return dataSheet;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;		
	}
	
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
