package com.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyMathMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Future<Integer> future = executor.submit(new MyMathTask(10,20)); 
		//do some parallel task
		while(!future.isDone())
			System.out.println("Waiting...");;//wait
		int z = future.get();
		System.out.println("Result is : " + z);
	}

}
