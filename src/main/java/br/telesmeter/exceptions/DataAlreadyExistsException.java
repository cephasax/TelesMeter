package br.telesmeter.exceptions;

public class DataAlreadyExistsException extends Exception{

	private static final long serialVersionUID = 5820168651909941775L;

	public DataAlreadyExistsException(String msg){
		super(msg);
	}
	
}
