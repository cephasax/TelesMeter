package br.telesmeter.utils;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FixedBuffer<T> {
	private int maxSize;
	private boolean closed;
	private Lock lock;
	private Condition notFull;
	private Condition notEmpty;
	private LinkedList<T> list;
	
	public FixedBuffer(int maxSize){
		closed = false;
		this.maxSize = maxSize;
		lock = new ReentrantLock();
		notFull = lock.newCondition();
		notEmpty = lock.newCondition();
		list = new LinkedList<T>();
	}
	
	public T consume() throws InterruptedException{
		lock.lock();
		try{
			while(list.size()<=0){
				notEmpty.await();
			}
			T temp = list.removeLast();
			for(int x=0 ; x<list.size() ; x++){
				System.out.print(".");
			}
			System.out.println("(" + (list.size()) + ")");
			notFull.signal();
			return temp;
		}
		finally{
			lock.unlock();
		}
	}
	
	public void produce(T t) throws InterruptedException{
		lock.lock();
		try{
			while(list.size()==maxSize){
				notFull.await();
			}
			list.add(t);
			for(int x=0 ; x<list.size() ; x++){
				System.out.print(".");
			}
			System.out.println("(" + (list.size()) + ")");
			notEmpty.signal();
			return;
		}
		finally{
			lock.unlock();
		}
		
	}
	
	public boolean isClosed(){
		return (closed && list.isEmpty());
	}
	
	public void close(){
		closed = true;
	}
	
	
}
