import java.util.Arrays;


public class ThirdLargestInArray {

	public static void main(String[] args) {
		int []numList={4,2,6,8,3,9,1};	
		Arrays.sort(numList);
		System.out.println("Third largest number in array is "+numList[2]);
	}

}
