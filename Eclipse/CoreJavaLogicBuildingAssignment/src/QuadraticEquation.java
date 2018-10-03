
public class QuadraticEquation {

	public static void main(String[] args) {
		int a,b,c;
		a=1;
		b=5;
		c=6;
		int d;
		d=(int)(Math.pow(b, 2) - 4*a*c);
		int root1=(int)(-b+Math.sqrt(d))/(2*a);
		int root2=(int)(-b-Math.sqrt(d))/(2*a);
		System.out.println("Root1 "+root1);
		System.out.println("Root2 "+root2);
	}

}
