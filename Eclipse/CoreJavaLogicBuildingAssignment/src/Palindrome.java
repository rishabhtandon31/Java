import java.util.Scanner;
public class Palindrome {
	public static void main(String []str){
		System.out.println("Enter the number : ");
		Scanner input11=new Scanner(System.in);
		int num=input11.nextInt();
		input11.close();
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

