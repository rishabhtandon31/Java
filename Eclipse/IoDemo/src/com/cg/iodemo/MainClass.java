package com.cg.iodemo;

import java.io.File;
import java.io.IOException;

public class MainClass {

	public static void main(String[] args) throws IOException {
		IOClassesDemo.fileClassDemo();
		File fileFrom= new File("D:\\DataFile.txt");
		File fileTo= new File("D:\\DataFileCopy.txt");
		
		IOClassesDemo.byteStreamReadWrite(fileFrom, fileTo);
	}

}
