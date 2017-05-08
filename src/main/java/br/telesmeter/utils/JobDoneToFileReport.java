package br.telesmeter.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import br.telesmeter.domain.AbstractData;

public class JobDoneToFileReport {

	private static FileWriter fileWriter;
	private static String fileName;
	private static PrintWriter printWriter;
	private static ArrayList<AbstractData> datas;

	public static void doResumeFromWork(ArrayList<AbstractData> datas, String tip) throws IOException {

		fileName = new String("src/main/resources/data/resumes/" + tip + ".txt");
		fileWriter = new FileWriter(new File(fileName));
		printWriter = new PrintWriter(fileWriter);
		JobDoneToFileReport.datas = new ArrayList<AbstractData>(datas);
		
		writeOnFile(fileName);

		System.out.println("Job result saved on file: " + fileName);
		fileWriter.close();
	}

	public static void writeOnFile(String arquivo) throws IOException {

		printWriter.printf(fileName + "%n");
		printWriter.printf("Size of objects array: " + datas.size() + "%n");
		printWriter.printf("Elements saved on DataBase:" + "%n");
		printWriter.printf("%n");
		for(AbstractData data: datas){
			printWriter.printf(data.toString() + "%n");
		}
	}

}
