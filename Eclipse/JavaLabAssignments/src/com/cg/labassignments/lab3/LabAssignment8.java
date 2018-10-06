package com.cg.labassignments.lab3;

import java.util.Arrays;
import java.util.Scanner;

public class LabAssignment8 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the size ");
		int size= input.nextInt();
		String []array= new String[size];
		System.out.println("Enter the string elements");
		for(int i=0;i<size;i++){
			array[i]=input.next();
		}
		sortArray(array);
		for(int i=0;i<size;i++)
			System.out.print(array[i]+" ");
		input.close();
	}

	public static String[] sortArray(String []array){
		Arrays.sort(array);
		for(int i=0;i<array.length;i++){
			if(i<array.length/2 || (array.length %2 !=0 && array.length/2 == i))
				array[i]=array[i].toUpperCase();
			else
				array[i]=array[i].toLowerCase();
		}
		return array;
	}
}
