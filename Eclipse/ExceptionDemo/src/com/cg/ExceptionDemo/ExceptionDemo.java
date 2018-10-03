package com.cg.ExceptionDemo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo {

	public static void main(String[] args) {
		try {
			Scanner input1= new Scanner(System.in);
			System.out.println("Enter number 1: ");
			int num1=input1.nextInt();
			System.out.println("Enter number 2: ");
			int num2=input1.nextInt();
			int result= num1/num2;
			System.out.println("Result: "+result);
		}
		
		catch (InputMismatchException e) {
			e.printStackTrace();
			System.out.println("Inside exception");
		}
		 catch (ArithmeticException e) {
				e.printStackTrace();
				System.out.println("Inside exception");
			}
		catch(Exception e){
			e.getMessage();
		}
		System.out.println("Outside try catch block");
	}

}
