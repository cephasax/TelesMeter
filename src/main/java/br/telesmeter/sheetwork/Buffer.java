package br.telesmeter.sheetwork;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import br.telesmeter.domain.AbstractData;

public class Buffer {
	private BlockingQueue<AbstractData> bf;
	private boolean closed;
	
	public Buffer( int size){
		closed = false;
		bf = new ArrayBlockingQueue<AbstractData>(size);
	}
	
	public void push(ArrayList<AbstractData> array ){
		try {
			for(AbstractData d : array){
				bf.put(d);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public AbstractData pull(){
		try {
			return bf.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean isClosed(){
		return closed;
	}
	
	public boolean isEmpty(){
		return bf.isEmpty();
	}
	
	public void setClosed(boolean b){
		closed = b;
	}
	
}
