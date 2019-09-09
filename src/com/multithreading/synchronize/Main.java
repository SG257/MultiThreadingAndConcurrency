package com.multithreading.synchronize;

class MyThread extends Thread{
	Sample obj;
	public MyThread(Sample obj) {
		this.obj = obj;
	}
	@Override
	public void run(){
		obj.incr();
		try {
			Thread.yield();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sample obj = new Sample();
		Thread t1 = new Thread(new MyThread(obj));
		Thread t2 = new Thread(new MyThread(obj));
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
