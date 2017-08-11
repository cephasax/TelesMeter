package br.telesmeter.utils;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import br.telesmeter.exceptions.ClosedBufferException;

public class Buffer<T> {
	private int maxSize;
	private boolean closed;
	private Lock lock;
	private Condition notFull;
	private Condition notEmpty;
	private LinkedList<T> list;
	
	public Buffer(int maxSize){
		closed = false;
		this.maxSize = maxSize;
		lock = new ReentrantLock();
		notFull = lock.newCondition();
		notEmpty = lock.newCondition();
		list = new LinkedList<T>();
	}
	
	public T consume() throws ClosedBufferException, InterruptedException{
		lock.lock();
		try{
			while(list.size()<=0){
				if(closed){
					throw new ClosedBufferException("Buffer is empty. time to stop consumer");
				}
				notEmpty.await();
			}
			T temp = list.removeLast();
			if(list.size()<=maxSize/2){
				notFull.signal();
			}
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
			list.addFirst(t);
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
		lock.lock();
		closed = true;
		notEmpty.signal();
		lock.unlock();
	}
	
	
}
