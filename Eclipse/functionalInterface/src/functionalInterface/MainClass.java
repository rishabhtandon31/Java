package functionalInterface;

public class MainClass {

	public static void main(String[] args) {
		FunctionalInterface1 rf1=()->System.out.println("Hello! This is Rishabh");
		rf1.greetUser();
		/*FunctionalInterface2 rf2=(name)->{
			System.out.println("Hello "+ name);
		};
		rf2.greetUser("rishabh");
	*/
		
	/*	
		FunctionalInterface2 rf2=(num1,num2)->{
			 return num1+num2;   // or num1+num2
			//num1 + num2;
		};
		*/
		FunctionalInterface2 rf2=(num1,num2)->num1+num2;
		System.out.println(rf2.add(3, 5));
	}

}
