import java.util.Scanner;
public class FibonacciSeries {

	public static void main(String[] args) {
		System.out.println("Enter the number of terms : ");
		Scanner input=new Scanner(System.in);
		int num1=input.nextInt();
		input.close();
		int x,y,i,t;
		x=0;
		y=1;
		System.out.print(x+" "+y);
		for(i=0;i<(num1-2);i++){
			t=y;
			y=y+x;
			System.out.print(" "+y);
			x=t;
		}

	}

}
