package com.multithreading.writerpen;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object pen = new Object();
		Object book = new Object();
		new Writer1(pen,book).start();
		new Writer2(pen,book).start();
		System.out.println("Main Thread Terminating...");
		
	}

}
