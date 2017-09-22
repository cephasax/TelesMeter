package br.telesmeter.exceptions;

public class DataDoesNotExistException extends Exception{

	private static final long serialVersionUID = 8340578605390136493L;

	public DataDoesNotExistException(String msg){
		super(msg);
	}
	
}
