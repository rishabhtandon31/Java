package com.cg.project.threadwork;
public class MyThread extends Thread{
	public MyThread(String name) {
		super(name);
	}
	@Override
	public void run() {
		int i;
		if(this.getName().equals("odd"))
			for(i=0;i<=100;i++)
				if(i%2!=0)
					System.out.println("odd no : "+i);
		if(this.getName().equals("even"))
			for(i=0;i<=100;i++)
				if(i%2==0)
					System.out.println("even no : "+i);
	}
}