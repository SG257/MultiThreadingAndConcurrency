package com.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String source1 = "a.txt";
		String source2 = "b.txt";
		
		String dest1 = "c.txt";
		String dest2 = "d.txt";
		
		ExecutorService executor = Executors.newFixedThreadPool(5);
		executor.execute(new CopyTask(source1, dest1));
		executor.execute(new CopyTask(source2,dest2));
		
	}

}
