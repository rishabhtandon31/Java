package com.cg.project.threadwork;
public class MyClass {
	public static void main(String[] args) throws InterruptedException {
		/*MyThread th1= new MyThread("odd");
		MyThread th2= new MyThread("even");
		th1.start();
		th2.start();
		*/
		Runnable r1= new RunnableResource();
		Thread th1= new Thread(r1, "odd");
		Thread th2= new Thread(r1, "even");
		th1.start();
		th1.join(5000);
		th2.start();
		System.out.println("main method ends here");
	}
}