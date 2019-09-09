package com.multithreading;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class CopyTask implements Runnable {
	
	String srcFile;
	String destFile;
	
	public CopyTask(String srcFile,String destFile) {
		// TODO Auto-generated constructor stub
		this.destFile = destFile;
		this.srcFile = srcFile;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			CopyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void CopyFile(String srcFile,String destFile) throws IOException {
		FileInputStream fileInStream = new FileInputStream(srcFile);
		FileOutputStream fileOutStream = new FileOutputStream(destFile);
		copy(fileInStream,fileOutStream);
		System.out.println("Done");
	}
	public static void copy(InputStream src,OutputStream dest) throws IOException {
		int value;
		while((value=src.read())!=-1) {
			dest.write(value);
		}
		src.close();
		dest.close();
	}
}
