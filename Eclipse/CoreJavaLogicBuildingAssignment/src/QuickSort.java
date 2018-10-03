
public class QuickSort {

	int partition(int arr[],int l, int r){
		int pivot=arr[r];
		int i=l-1,j,temp;
		for(j=l;j<r;j++){
			if(arr[j]<=pivot){
				i=i+1;
				temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		temp=arr[i+1];
		arr[i+1]=arr[r];
		arr[r]=temp;
		return i+1;
	}

	void sortArray1(int arr[],int l, int r){
		if(l<r){
			int pi=partition(arr,l,r);
			sortArray1(arr,l,pi-1);
			sortArray1(arr,pi+1,r);
		}
	}
	
	public static void main(String[] args) {
		int []numList={4,2,7,6,1,9,5};
		int l,r,i;
		l=0;
		r=numList.length;
		QuickSort qs=new QuickSort();
		qs.sortArray1(numList,l,r-1);
		for(i=0;i<r;i++){
			System.out.print(numList[i]+" ");
		}
	}
}
