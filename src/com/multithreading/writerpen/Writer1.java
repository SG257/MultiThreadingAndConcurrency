package com.multithreading.writerpen;

public class Writer1 extends Thread{
	Object pen;
	Object book;
	public Writer1(Object pen,Object book) {
		this.pen = pen;
		this.book = book;
	}
	@Override
	public void  run() {
		synchronized(book) {
			try {Thread.sleep(10);}catch(Exception e) {}
			synchronized(pen) {
				System.out.println("Writer one has started Writing...");
			}
		}
	}
}
