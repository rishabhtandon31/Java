
public class ArrayConversion {

	public static void main(String[] args) {
		int array[]={1,2,3,4,5,6,7,8,9};
		int n=array.length;
		int arraydup[]= new int[10];
		int i=0,j=0;
		while(j<n){
			arraydup[j]=array[n-1-i];
			arraydup[j+1]=array[i];
			i++;
			j+=2;
			if(i>5){
				break;
			}		
		}
		System.out.println("The Rearranged array is:");
		for(i=0;i<n;i++){
		System.out.print(arraydup[i]+" ");
		}

	}

}
