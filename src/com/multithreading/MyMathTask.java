package com.multithreading;

import java.util.concurrent.Callable;

public class MyMathTask implements Callable<Integer>{
	int x;
	int y;
	public MyMathTask(int x,int y){
		this.x = x;
		this.y = y;
	}
	public Integer call() {
		return MyMath.add(x, y);
	}
}
