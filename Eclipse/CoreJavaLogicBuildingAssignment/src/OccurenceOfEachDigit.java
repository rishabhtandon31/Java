
public class OccurenceOfEachDigit {

	public static void main(String[] args) {
		int num=878768553;
		int occurence[]=new int[10];
		int temp=num,rem;
		while(temp>0){
			rem=temp%10;
			occurence[rem]++;
			temp=temp/10;
		}
		for(int i=0;i<10;i++)
			System.out.println(i+ " occurred : "+occurence[i]);
	}

}
