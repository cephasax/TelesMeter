package br.telesmeter.sheetwork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Locale;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.telesmeter.domain.AbstractData;

public abstract class DataCapture {

	private ArrayList<String> files;
	private String FILES_SOURCE;
	private StringBuilder stringBuilder;
	private Workbook workBook;
	protected ArrayList<AbstractData> dataFromSheet;
	protected ArrayList<String> columnsNames;

	public void CaptureDataFromSheet() throws ParseException {

		files = new ArrayList<String>();
		columnsNames = new ArrayList<String>();
		stringBuilder = new StringBuilder();

		constructFileList(FILES_SOURCE);

		for (String file : files) {
			
			try {

				stringBuilder.append(FILES_SOURCE);
				stringBuilder.append(file);

				FileInputStream excelFile = new FileInputStream(new File(stringBuilder.toString()));
				workBook = new XSSFWorkbook(excelFile);
				Sheet dataSheet = workBook.getSheetAt(0);
	
				readDataFromSheet(dataSheet);
				
				work();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void constructFileList(String filesSource) {
		File filef = new File(filesSource);
		File oneFile[] = filef.listFiles();

		for (int i = 0; i < oneFile.length; i++) {
			File file = new File(oneFile[i].toString());
			files.add(file.getName());
		}
	}

	public double parseDecimal(String input) throws ParseException {
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
		ParsePosition parsePosition = new ParsePosition(0);
		Number number = numberFormat.parse(input, parsePosition);

		if (parsePosition.getIndex() != input.length()) {
			throw new ParseException("Invalid input", parsePosition.getIndex());
		}

		return number.doubleValue();
	}

	public abstract void work();
	
	public abstract void readDataFromSheet(Sheet dataSheet);
}
