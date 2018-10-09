package com.cg.project.client;
import com.cg.project.threadwork.Customer;
public class MainClass {
	public static void main(String[] args) {
		Thread th1 = new Thread(new Customer(),"rahul");
		Thread th2= new Thread(new Customer(),"anil");
		Thread th3 = new Thread(new Customer() , "satish");
		th1.start();
		th2.start();
		th3.start();	
	}
}
