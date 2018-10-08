package com.cg.labassignments.lab7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class labAssignment1 {

	public static void main(String[] args) {

		/* LAB 1
		String []products= new String[5];
		Scanner input= new Scanner(System.in);
		int i=0;
		for(i=0;i<5;i++){
			products[i]=input.next();
		}
		Arrays.sort(products);
		for(String x: products )
			System.out.println(x);
		input.close();
	}*/
		ArrayList<String> products= new ArrayList<String>();
		Scanner input= new Scanner(System.in);
		int i=0;
		for(i=0;i<5;i++) products.add(input.next());
		Collections.sort(products);
		for(String x: products)
			System.out.println(x);

	}
}
