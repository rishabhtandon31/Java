
public class SwapNumbersWithoutThirdVariable {

	public static void main(String[] args) {
		int a=10,b=5;
		System.out.println("Before swapping : a="+a+" , b="+b);
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("After swapping : a="+a+" , b="+b);

	}

}
