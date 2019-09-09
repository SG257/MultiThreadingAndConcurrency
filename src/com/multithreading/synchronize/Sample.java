package com.multithreading.synchronize;

public class Sample {
	private int x=10;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public synchronized void incr() {
		int y = getX();
		y++;
		setX(y);
		System.out.println("Value of X : " + x);
	}
}
