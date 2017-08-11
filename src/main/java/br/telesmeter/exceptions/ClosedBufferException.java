package br.telesmeter.exceptions;

public class ClosedBufferException extends Exception {
	private static final long serialVersionUID = -723437365260927040L;

	public ClosedBufferException(String msg) {
		super(msg);
	}
}
