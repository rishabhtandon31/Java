import java.util.Arrays;


public class BinarySearch {

	public static void main(String[] args) {
		int []numList={5,3,7,8,1,4};
		Arrays.sort(numList);
		int searchElement=3;
		int mid,l,r,f=0;
		l=0; r=numList.length;
		while(l<r){
			 mid=l+(r-l)/2;
			 if(numList[mid] == searchElement){
				 System.out.println("Element found at position "+mid);
				 f=1;
				 break;
			 }
			 else if(numList[mid]<searchElement)
				 l=mid+1;
			 else
				 r=mid-1;
		}
		if(f==0){
			System.out.println("Element not found");
		}
	}

}
