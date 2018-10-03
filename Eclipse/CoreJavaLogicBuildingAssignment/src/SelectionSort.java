
public class SelectionSort {

	public static void main(String[] args) {
		int []numList={3,6,1,4,8,9};
		int i,j,l;
		l=numList.length;
		for(i=0;i<l;i++){
			for(j=i+1;j<l-1;j++){
				if(numList[j]<numList[i]){
					numList[j]=swap(numList[i],numList[i]=numList[j]);
				}
			}
		}
		for(i=0;i<l;i++){
			System.out.print(numList[i]+" ");
		}

	}
	
	public static int swap(int itself,int dummy){
		return itself;
	}

}
