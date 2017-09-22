package br.telesmeter.sheetdatareader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.SAXHelper;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import br.telesmeter.utils.Buffer;
import br.telesmeter.utils.Triple;

public class SheetWindow extends Thread implements Runnable{
	private Buffer<Triple<String>> buffer;
	private OPCPackage xlsxPackage = null;
	private boolean emptyRowFound = false; 
	
	private class MyHandler implements SheetContentsHandler {
	     private int currentRow = -1;
	     private int currentCol = -1;
	     
	     /**
	      * Code executed every time the windows reach a new row of the file.
	      */
	     public void startRow(int rowNum) {
	    	 if(emptyRowFound){
	    		 return;
	    	 }
	    	 if(rowNum!=currentRow+1){
	    		System.out.println("SheetWindow => Empty row(s) found: " + (currentRow+1) + " to " + rowNum);
	    		emptyRowFound = true;
	    	 }
	         currentRow = rowNum;
	         currentCol = -1;
	     }

	     /**
	      * Code executed every time the windows reach the end of one row of the file.
	      */
	     public void endRow(int rowNum) {}

	     public void cell(String cellReference, String formattedValue, XSSFComment comment) {
	    	 if(emptyRowFound){
	    		 return;
	    	 }
	    	 
	         // gracefully handle missing CellRef here in a similar way as XSSFCell does
	         if(cellReference == null) {
	             cellReference = new CellAddress(currentRow, currentCol).formatAsString();
	         }
	         currentCol++;
	         
	         // Did we jump some cell because it was empty?
	         if((new CellReference(cellReference)).getCol() > currentCol){
	        	 System.out.println("SheetWindow => Empty Cell found: row " + currentRow + ", col " + currentCol +"\nExiting.\n"); 
	        	 System.exit(0);
	         }
	         
	         Triple<String> t = new Triple<String>();
	         t.setColumn(currentCol);
	         t.setRow(currentRow);
	         t.setData(formattedValue);
	         try {
	        	 buffer.produce(t);
	         } catch (InterruptedException e) {
	        	 e.printStackTrace();
	         }
	     }

	     public void headerFooter(String text, boolean isHeader, String tagName) {}
	 }
	
	public void run(){
		try {
			this.process();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (OpenXML4JException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}
	
	public void setFile(File file){
		try {
			this.xlsxPackage = OPCPackage.open(file.getAbsolutePath());
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
	}
	
	public void setBuffer( Buffer<Triple<String>> buffer ){
		this.buffer = buffer;
	}
	
	public Buffer<Triple<String>> getBuffer( ){
		return buffer;
	}
	
	public void process() throws IOException, OpenXML4JException, SAXException {
	     ReadOnlySharedStringsTable strings = new ReadOnlySharedStringsTable(this.xlsxPackage);
	     XSSFReader xssfReader = new XSSFReader(this.xlsxPackage);
	     StylesTable styles = xssfReader.getStylesTable();
	     XSSFReader.SheetIterator iter = (XSSFReader.SheetIterator) xssfReader.getSheetsData();
	     while (iter.hasNext()) {
	         InputStream stream = iter.next();
	         processSheet(styles, strings, new MyHandler(), stream);
	         stream.close();
	     }
	     xlsxPackage.close();
	     buffer.close();
	}
	 
	public void processSheet(
	        StylesTable styles,
	        ReadOnlySharedStringsTable strings,
	        SheetContentsHandler sheetHandler, 
	        InputStream sheetInputStream) throws IOException, SAXException {
	    DataFormatter formatter = new DataFormatter();
	    InputSource sheetSource = new InputSource(sheetInputStream);
	    try {
	        XMLReader sheetParser = SAXHelper.newXMLReader();
	        ContentHandler handler = new XSSFSheetXMLHandler(styles, null, strings, sheetHandler, formatter, false);
	        sheetParser.setContentHandler(handler);
	        sheetParser.parse(sheetSource);
	     } catch(ParserConfigurationException e) {
	        throw new RuntimeException("SAX parser appears to be broken - " + e.getMessage());
	     }
	}
	 
}
