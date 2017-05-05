package br.telesmeter.sheetwork;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import br.telesmeter.domain.AbstractData;
import br.telesmeter.domain.Reading;

public class ReadingsDataCapture extends DataCapture {

	public ReadingsDataCapture() {
		this.dataFromSheet = new ArrayList<AbstractData>();
	}

	@Override
	public void work() {
		for(AbstractData a: dataFromSheet){
			System.out.println(a);
		}
	}

	@Override
	public void readDataFromSheet(Sheet dataSheet){
		
		int trigger = 0;
		
		DataFormatter sheetDataFormatter = new DataFormatter();
		Double d = new Double(0.0);
		DateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		
		
		while (trigger == 0) {
			for (Row row : dataSheet) {
				for (Cell cell : row) {
					
					//Read data from cell as String
					String cellData = new String (sheetDataFormatter.formatCellValue(cell));
					
					//if Row is not empty
					if (!cellData.equals("")) {

						// if first row
						if (cell.getRowIndex() == 0) {
							//add cellData to columns header names
							columnsNames.add(cellData);
						} else {

							// if first column
							if (cell.getColumnIndex() == 0) {
								try{
									//parse cellData to Date Class
									date = dateFormater.parse(cellData);
								}
								catch(ParseException e){
									e.printStackTrace();
								}
							} 
							
							//if cell with precipitation data
							else {
								
								try {
									//Parse cell
									d = new Double(parseDecimal(cellData));
									
								} catch (ParseException e) {
									e.printStackTrace();
								}

								Reading reading = new Reading();
								reading.setDate(date);
								reading.setValue(d);
								dataFromSheet.add(reading);
							}
						}
					} else {
						trigger = 1;
					}
				}
			}
		}
	}

}
