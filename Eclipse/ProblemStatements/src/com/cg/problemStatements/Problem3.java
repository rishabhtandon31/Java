import java.util.Scanner;

public class Problem3 {

public static void main(String[] args) {
System.out.println("Enter the size");
Scanner input1= new Scanner(System.in);
int size=input1.nextInt();
int i;
int []A= new int[size];
System.out.println("Enter the array elements of A: ");
for(i=0;i<size;i++){
A[i]=input1.nextInt();
}
int []B= new int[size];
System.out.println("Enter the array elements of B: ");
for(i=0;i<size;i++){
B[i]=input1.nextInt();
}
System.out.println("The no. of pairs : "+ Solution(A,B));
}
public static int Solution(int []A, int []B){
int l=A.length;
double []C= new double[l];
int i,j,count=0;
for(i=0;i<l;i++){
C[i]=(double)A[i]+((double)B[i]/1000000);
}
for(i=0;i<l-1;i++){
for(j=i+1;j<l;j++){
if((C[i]*C[j]) >= (C[i]+C[j])){
count++;
System.out.println("("+i+","+j+")");
}
}
}
return count;
}
}