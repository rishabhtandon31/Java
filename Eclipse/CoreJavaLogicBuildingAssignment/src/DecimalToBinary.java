
public class DecimalToBinary {

	public static void main(String[] args) {
		int decimalNum=20;
		int binary=0,temp,i=1,rem;
		temp=decimalNum;
		while(temp>0)
		{
			rem=temp%2;
			binary=binary+rem*i;
			i=i*10;
			temp=temp/2;
		}
		System.out.println(binary);
	}

}
