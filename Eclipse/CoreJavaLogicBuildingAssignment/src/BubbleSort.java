
public class BubbleSort {

	public static void main(String[] args) {
		int numArr[]={5,10,2,8,11,14,1,19,7,3};
		int l=numArr.length,temp,i,j,flag;
		for(i=0;i<l-1;i++){
			flag=1;
			for(j=0;j<l-i-1;j++){
				if(numArr[j]>numArr[j+1]){
					temp=numArr[j];
					numArr[j]=numArr[j+1];
					numArr[j+1]=temp;
					flag=0;
				}
			}
			if(flag==1)
				break;
		}
		for(i=0;i<l;i++){
			System.out.print(numArr[i]+"   ");
		}

	}

}
