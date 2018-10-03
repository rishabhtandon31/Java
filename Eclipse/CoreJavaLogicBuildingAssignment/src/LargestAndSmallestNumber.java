import java.util.Arrays;


public class LargestAndSmallestNumber {

	public static void main(String[] args) {
		int num=760039;
		int numList[]= new int[6];
		int temp=num,i=0;
		while(temp>0){
			numList[i++]=temp%10;
			temp=temp/10;
		}
		
		int l=numList.length;
		Arrays.sort(numList);
		System.out.println("Largest Number");
		for(i=l-1;i>-1;i--)
		System.out.print(numList[i]+" ");
		for(i=0;i<l;i++){
			if(numList[i]!=0){
				temp=numList[0];
				numList[0]=numList[i];
				numList[i]=temp;
				break;
			}
		}
		System.out.println("\nSmallest Number");
		for(i=0;i<l;i++)
			System.out.print(numList[i]+" ");

	}

}
