
public class DecToBinPalindromeCheck {

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
		System.out.println("Binary number is "+binary);
		int num2=0,a;
		a=binary;
		while(a>0){
			num2=num2*10+a%10;
			a=a/10;
		}
		if(binary==num2)
			System.out.println(binary+" is Palindrome");
		else
			System.out.println(binary+" is not a Palindrome");
	}

}
