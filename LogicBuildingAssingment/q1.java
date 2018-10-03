import java.util.Scanner;
class Myclass1{
	public static void main(String []str){
		System.out.println("Enter the number : ");
		Scanner input=new Scanner(System.in);
		int num=input.nextInt();
		int num2=0,a;
		a=num;
		while(a>0){
			num2=num2*10+a%10;
			a=a/10;
		}
		if(num==num2)
			System.out.println(num+" is Palindrome");
		else
			System.out.println(num+" is not a Palindrome");
	}
}