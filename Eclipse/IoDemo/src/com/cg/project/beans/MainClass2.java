package com.cg.project.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class MainClass2 {

	public static void main(String[] args) {
		
		try {
			File file= new File("d:\\Associatedata.txt");
			SerializationDemo.doSerialization(file);
			SerializationDemo.doDeSerialization(file);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		/*
		System.out.println("fdhgfdg");
		try {
			Properties projectProperties= new Properties();
			projectProperties.load(new FileInputStream(new File(".\\resources\\projectProperties.properties")));
			String projectKey1= projectProperties.getProperty("projectkey1");
			String projectKey2=projectProperties.getProperty("projectkey2");
			System.out.println(projectKey1+" "+projectKey2);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		*/
	}

}
