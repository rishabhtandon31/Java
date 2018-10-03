package com.cg.project.collectionsdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import com.cg.project.beans.Associate;

public class ListClassesDemo {
	public static void arrayListClassWork(){
		ArrayList<String> strList= new ArrayList<>();

		//insert

		strList.add("Rishabh");
		strList.add("Deepak");
		strList.add("Hitesh");
		strList.add("Ayush");
		strList.add("Vivek");

		//searching
		System.out.println(strList.contains("Vivek"));
		System.out.println(strList.indexOf("Ayush"));

		//sorting
		Collections.sort(strList);

		//iteration
		for(String name: strList)
			System.out.println(name);
		
		ArrayList<Associate> associateList= new ArrayList<>();
		
		associateList.add(new Associate("Rishabh", 101));
		associateList.add(new Associate("Rohit", 102));
		associateList.add(new Associate("Sahil", 103));
		
		Associate associateToBeSearch= new Associate("Rohit", 102);
		
		System.out.println(associateList.indexOf(associateToBeSearch));
		
		//for(Associate associate: associateList){
			//if(associate.getAssociateId()==103 && associate.getName().equals("Nilesh"));
		//}
		
		Collections.sort(associateList);
		Collections.sort(associateList,new AssociateComparator());
	}

	public static void LinkedListClassWork(){
		LinkedList<String> strList= new LinkedList<>();
		strList.add("Rishabh");
		strList.add("Deepak");
		strList.add("Hitesh");
		strList.add("Ayush");
		strList.add("Vivek");
		//searching
		System.out.println(strList.contains("Vivek"));
		System.out.println(strList.indexOf("Ayush"));

		//sorting
		Collections.sort(strList);

		//iteration
		for(String name: strList)
			System.out.println(name);
	}
}
