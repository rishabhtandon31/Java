package com.cg.project.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo{

	public static void doSerialization(File file) throws FileNotFoundException, IOException{
		try(ObjectOutputStream writer= new ObjectOutputStream(new FileOutputStream(file))){
			Associate associate= new Associate(101, "Rishabh", 2000000, new Address("Khanna", "India", 141401));
			writer.writeObject(associate);
			System.out.println("Object transfered to "+file);
		}
	}
	
	public static void doDeSerialization(File file) throws FileNotFoundException, IOException, ClassNotFoundException{
		try(ObjectInputStream reader= new ObjectInputStream(new FileInputStream(file))){
			Associate associate = (Associate) reader.readObject();
			System.out.println(associate);
		}
	}
}
