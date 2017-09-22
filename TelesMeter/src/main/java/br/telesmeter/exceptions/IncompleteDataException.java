package br.telesmeter.exceptions;

public class IncompleteDataException extends Exception{

	private static final long serialVersionUID = 5820168651909941775L;

	public IncompleteDataException(String msg){
		super(msg);
	}
	
}
