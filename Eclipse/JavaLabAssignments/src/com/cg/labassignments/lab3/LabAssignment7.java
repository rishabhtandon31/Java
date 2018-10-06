package com.cg.labassignments.lab3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LabAssignment7 {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		System.out.println("Enter the string : ");
		String str=input.next();
		//System.out.println(Pattern.matches("[A-Za-z]{8,}", str));
		if(checkPattern(str))
		System.out.println("String matches");
		else
			System.out.println("Not matches");
	}
	public static Boolean checkPattern(String str){
		//System.out.println((str.matches(".*_job\\b.*")));
		if((str.matches(".*_job\\b.*"))){
			String []assOfStr= str.split("_");
			return Pattern.matches("[A-Za-z]{8,}", assOfStr[0]);
		}
		return false;
	}
}
