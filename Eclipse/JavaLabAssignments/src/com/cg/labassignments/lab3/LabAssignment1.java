package com.cg.labassignments.lab3;

import java.util.Scanner;

public class LabAssignment1 {

	public static StringBuilder string1= new StringBuilder("California");
	public static void main(String[] args) {
		System.out.println("Given string is "+string1);
		int choice;
		String ch="y";
		@SuppressWarnings("resource")
		Scanner input= new Scanner(System.in);
		while(ch.equalsIgnoreCase("y")){
			//string1="California";
			System.out.println("\n1)Add the String to itself\n2)Replace odd positions with #\n3)Remove duplicate characters in the String\n4)Change odd characters to upper case");
			System.out.println("\nEnter your choice: ");
			choice=input.nextInt();
			switch(choice){
			case 1:
				System.out.println(addString(string1));
				break;
			case 2:
				System.out.println(replaceOddPositions(string1));
				break;
			case 3:
				System.out.println(removeDuplicateChars(string1));
				break;
			case 4:
				System.out.println(oddCharactersUpperCase(string1));
				break;
				default:
					System.out.println("Try Again...!!");
					break;
			}
			System.out.println("Do you want to continue (y/n)");
			ch=input.next();
		}

	}
	public static StringBuilder addString(StringBuilder string12){
		StringBuilder str= new StringBuilder(string12);
		return str.append(str); 
	}

	public static StringBuilder replaceOddPositions(StringBuilder string12){
		StringBuilder str= new StringBuilder(string12);
		for(int i=0;i<str.length();i++)
			if(i%2 == 0)
				str.setCharAt(i, '#');
		return str;
	}
	
	public static StringBuilder removeDuplicateChars(StringBuilder string12){
		StringBuilder str= new StringBuilder(string12);
		for(int i=0;i<str.length()-1;i++){
			for(int j=i+1 ;j<str.length();j++)
				if(str.charAt(i) == str.charAt(j))
					str.deleteCharAt(j);
		}
		return str;
	}
	public static StringBuilder oddCharactersUpperCase(StringBuilder string12){
		StringBuilder str= new StringBuilder(string12);
		for(int i=0;i<str.length();i++)
			if(i%2 == 0)
				if(str.charAt(i) >= 97 && str.charAt(i) <=122)
					str.setCharAt(i, (char)(str.charAt(i)-32));    
		return str;
	}
}
