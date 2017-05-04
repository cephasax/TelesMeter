package br.telesmeter.sheetwork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.telesmeter.domain.Reading;

public class SheetDataCapture {

	private static String fileName;
	private static ArrayList<String> arquivos;
	private static final String FILES_NEWS = "src/main/resources/data/news/";
	private static final String FILES_SOURCE = "src/main/resources/data/source/";
	private static StringBuilder stringBuilder;
	private static Workbook workbook;
	private static ArrayList<Reading> readings;
	private static ArrayList<String> columnsNames;
	private static ArrayList<String> dates;

	public static void main(String[] args) throws ParseException {

		readings = new ArrayList<Reading>();
		columnsNames = new ArrayList<String>();
		dates = new ArrayList<String>();

		arquivos = new ArrayList<String>();
		File file = new File(FILES_SOURCE);
		File oneFile[] = file.listFiles();

		for (int i = 0; i < oneFile.length; i++) {
			File arquivo = new File(oneFile[i].toString());
			arquivos.add(arquivo.getName());
			System.out.println(arquivo.getName());
		}

		// for (String arquivo : arquivos) {
		try {
			stringBuilder = new StringBuilder();
			stringBuilder.append(FILES_SOURCE);
			stringBuilder.append("teste2.xlsx");

			FileInputStream excelFile = new FileInputStream(new File(stringBuilder.toString()));
			workbook = new XSSFWorkbook(excelFile);
			Sheet dataSheet = workbook.getSheetAt(0);
			DataFormatter fmt = new DataFormatter();

			// READING PARTS AND PARSES
			String readingDate = new String();
			DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
			int contlines = 1;
			int rowsNumber = dataSheet.getPhysicalNumberOfRows();
			int lasRow = dataSheet.getLastRowNum();
			System.out.println(rowsNumber);
			System.out.println(lasRow);
			for (Row row : dataSheet) {
				System.out.println();
				for (Cell cell : row) {
					// This cell is empty
					
					
					System.out.print(fmt.formatCellValue(cell) + );
					/*// if first row
					if (cell.getRowIndex() == 0) {
						columnsNames.add(fmt.formatCellValue(cell));
					}

					else {

						// if first column
						if (cell.getColumnIndex() == 0) {
							readingDate = new String(fmt.formatCellValue(cell));
						} else {
							System.out.println("oi");
							Reading reading = new Reading();
							reading.setDate(sourceFormat.parse(readingDate));

							Double d = new Double(parseDecimal(fmt.formatCellValue(cell)));
							System.out.println(d);
							readings.add(reading);
						}
					}*/
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// }
	}

	/*public static boolean isRowEmpty(Row row) {
	    for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
	    	Cell cell = row.getCell(c);
	        if (cell != null && cell.getCellType() != BLANK)
	            return false;
	    }
	    return true;
	}*/
	
	public static double parseDecimal(String input) throws ParseException {
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
		ParsePosition parsePosition = new ParsePosition(0);
		Number number = numberFormat.parse(input, parsePosition);

		if (parsePosition.getIndex() != input.length()) {
			throw new ParseException("Invalid input", parsePosition.getIndex());
		}

		return number.doubleValue();
	}

}
