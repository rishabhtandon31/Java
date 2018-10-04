package com.cg.labassignments.lab2;

import java.util.Scanner;

public class LabAssingment2 {

	public static void main(String[] args) {
		System.out.println("Enter the number: ");
		Scanner input1 = new Scanner(System.in);
		int num= input1.nextInt();
		if(num<0)
			System.out.println("Number "+num+" is negative");
		else
			System.out.println("Number "+num+" is positive");
		input1.close();
	}

}
