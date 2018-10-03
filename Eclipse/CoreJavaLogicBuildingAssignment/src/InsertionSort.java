
public class InsertionSort {

	public static void main(String[] args) {
		int numArr[]={5,10,2,8,11,14,1,19,7};
		int n=numArr.length;
		int j, key;
		for(int i=0;i<n;i++){
			key=numArr[i];
			j=i-1;
			while(j>=0&&numArr[j]>key){
				numArr[j+1]=numArr[j];
				j=j-1;
			}
			numArr[j+1]=key;
		}
		for(int i=0;i<n;i++){
			System.out.print(numArr[i]+"   ");
		}
	}

}
