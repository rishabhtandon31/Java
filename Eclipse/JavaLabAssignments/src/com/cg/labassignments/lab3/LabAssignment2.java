package com.cg.labassignments.lab3;

public class LabAssignment2 {

	public static void main(String[] args) {
		String str1="ANTI";
		int flag=1;
		for(int i=0;i<str1.length()-1;i++){
			if(str1.charAt(i) > str1.charAt(i+1)){
				flag=0;
				break;
			}
		}
		if(flag==1)
			System.out.println("String is positive");
		else
			System.out.println("String is negative");

	}

}
