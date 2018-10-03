
public class LinearArraySearch {

	public static void main(String[] args) {
		int numlist[]={1,2,3,4,5,6,7,8,9,10};
		int n=7;
		int f=0;
		for(int i=0;i<10;i++){
			if(n==numlist[i]){
				System.out.println("Number found is "+n+" at position "+(i +1));
				f=1;
				break;
			}
		}
		if(f==0)
			System.out.println("Number not found.");
	}

}
