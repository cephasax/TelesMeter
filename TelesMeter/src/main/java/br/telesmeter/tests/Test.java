package br.telesmeter.tests;

import java.util.Scanner;

import br.telesmeter.business.ReadingService;
import br.telesmeter.business.StationService;
import br.telesmeter.exceptions.DataNotFoundException;
import br.telesmeter.service.GenericService;
import br.telesmeter.service.ReadingsLoaderService;
import br.telesmeter.service.StationsLoaderService;

public class Test {
	
	private static String menu = "<== MENU ==>\n"
			+ "(1) - Inserir novas estações;\n"
			+ "(2) - Inserir novas leituras;\n"
			+ "(3) - Ver quantidade de estações;\n"
			+ "(4) - Ver quantidade de leituras;\n"
			+ "(0) - Encerrar programa;\n"
			+ "Digite a opção que deseja selecionar: ";
	
	private static String request = "Entre com o nome e caminho do arquivo, ou '-' para usar o padrão.";
	private static Scanner r = new Scanner(System.in);
	
	public static void main(String[] agrs){	
		int choice = -1;
		do{
			System.out.println(menu);
			choice = r.nextInt();
			switch(choice){
				case 0:
					System.out.println("By! :D");
					break;
				case 1:
					insertStations();
					break;
				case 2:
					insertReadings();
					break;
				case 3:
					countStations();
					break;
				case 4:
					countReadings();
					break;
				default: 
					System.out.println("By! :D");
					break;
			}
		}while(choice!=0);
		r.close();
	}
	
	public static void insertStations(){
		System.out.println(request);
		String fileName = r.next();
		
		fileName = !fileName.equals("-") ? fileName : "src/main/resources/data/stations/stations.xlsx";
		GenericService sls = new StationsLoaderService(fileName);
		System.out.println("Loading stations...");
		
		long startTime = System.currentTimeMillis();
		sls.start();
		try {
			sls.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		
		System.out.print("Done.");
		System.out.println("Made in " + ((endTime-startTime)/1000) +" seconds.");
	}
	
	public static void insertReadings(){
		System.out.println(request);
		String fileName = r.next();
		
		fileName = !fileName.equals("-") ? fileName : "src/main/resources/data/readings/acre.xlsx";
		GenericService rls = new ReadingsLoaderService(fileName);
		System.out.println("Loading readings...");
		
		long startTime = System.currentTimeMillis();
		rls.start();
		try {
			rls.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		
		System.out.print("Done.");
		System.out.println("Made in " + ((endTime-startTime)/1000) +" seconds.");
	}

	public static void countStations(){
		StationService ss = new StationService();
		try {
			System.out.println("Existem " + ss.list().size() + " estações cadastradas.");
		} catch (DataNotFoundException e) {
			System.out.println("Por algum motivo não foi possível contar as estações cadastradas.");
			e.printStackTrace();
		}
	}
	
	public static void countReadings(){
		ReadingService rs = new ReadingService();
		try {
			System.out.println("Existem " + rs.list().size() + " estações cadastradas.");
		} catch (DataNotFoundException e) {
			System.out.println("Por algum motivo não foi possível contar as leituras cadastradas.");
			e.printStackTrace();
		}
	}
}
