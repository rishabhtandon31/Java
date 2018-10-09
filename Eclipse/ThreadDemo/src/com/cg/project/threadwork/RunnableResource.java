package com.cg.project.threadwork;

public class RunnableResource implements Runnable{

	@Override
	public void run() {
		Thread t= Thread.currentThread();
		int i;
		/*if(t.getName().equals("odd"))
			for(i=0;i<=100;i++)
				if(i%2!=0)
					System.out.println("odd no : "+i);
		if(t.getName().equals("even"))
			for(i=0;i<=100;i++)
				if(i%2==0)
					System.out.println("even no : "+i);*/

		try {
			if(t.getName().equals("odd"))
				for(i=0;i<10;i++){
					System.out.println("* : "+i);
					Thread.sleep(1000);}
					if(t.getName().equals("even"))
						for(i=0;i<10;i++){
							System.out.println("@ : "+i); 
							Thread.sleep(1000);
				} 
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
