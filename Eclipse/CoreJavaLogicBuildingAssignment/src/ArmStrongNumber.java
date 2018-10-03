import java.util.Scanner;
public class ArmStrongNumber {
	public static void main(String[] args) {
		System.out.println("Enter the number : ");
		Scanner input=new Scanner(System.in);
		int num1=input.nextInt();
		int rem,num2,x;
		num2=0;
		x=num1;
		while(x>0){
			rem=x%10;
			rem=rem*rem*rem;
			num2=num2+rem;
			x=x/10;
		}
		if(num1==num2)
			System.out.println(num1+" is an Armstrong number");
		else
			System.out.println(num1+" is not an Armstrong number");
		input.close();
	}
}
