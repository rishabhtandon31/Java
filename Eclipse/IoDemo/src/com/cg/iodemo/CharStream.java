package com.cg.iodemo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharStream {

	public static void fileClassDemo() throws IOException{
		File file= new File("d:\\DataFile.txt");
		System.out.println(file.exists());
		if(!file.exists())
			file.createNewFile();
		System.out.println(file.exists());
		System.out.println(file.canWrite());
		System.out.println(file.canRead());
		System.out.println(file.length());
		System.out.println(file.getPath());
		System.out.println(file.getName());
	}
	public static void charStreamReadWrite(File fileFrom, File fileTo) throws FileNotFoundException, IOException{
		try(BufferedReader srcStream = new BufferedReader(new FileReader(fileFrom))){
			try(BufferedWriter destStream = new BufferedWriter(new FileWriter(fileTo))){
				String data="";
				while((data=srcStream.readLine())!=null) destStream.write(data);
			}
		}
		System.out.println("File has transfered");
	}
}
