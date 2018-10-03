
public class BinaryToDecimal {

	public static void main(String[] args) {
		int binary=10100,i=1;
		int rem,temp=binary,decimalNum=0;
		while(temp>0){
			rem=temp%10;
			decimalNum=decimalNum+rem*i;
			i=i*2;
			temp=temp/10;
		}
		System.out.println(decimalNum);
	}

}
