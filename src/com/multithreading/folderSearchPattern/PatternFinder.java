package com.multithreading.folderSearchPattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class PatternFinder {
	public List<Integer> find(File file, String pattern){
		//TODO
		List<Integer> lineNumber = new ArrayList<Integer>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			int lineno = 1;
			String line;
			while((line = br.readLine())!=null) {
				if(line.contains(pattern)) {
					lineNumber.add(lineno);
				}
				lineno++;
			}
			Thread.sleep(1000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return lineNumber;
	}
}
