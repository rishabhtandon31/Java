import java.util.Scanner;
class MyClass{
	public static void main(String []str){
		int size,i;
		Scanner input=new Scanner(System.in);
		System.out.print("Enter the size of array : ");
		size=input.nextInt();
		int numlist[]=new int[size];
		System.out.println("Enter the elements of array: ");
		for(i=0;i<size;i++){
			numlist[i]=input.nextInt();
		}
		System.out.println("Enter the number to be searched: ");
		int n=input.nextInt();
		int f=0;
		for(i=0;i<10;i++){
			if(n==numlist[i]){
				System.out.println("Number found is "+n+" at position "+(i+1) );
				f=1;
				break;
			}
		}
		if(f==0)
			System.out.println("Number not found.");
	}
}