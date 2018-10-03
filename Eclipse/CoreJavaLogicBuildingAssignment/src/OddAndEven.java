
public class OddAndEven {

	public static void main(String[] args) {
		System.out.println("Odd numbers are ");
		for(int i=1;i<=20;i++){
			if(i%2!=0){
				System.out.print(i+" ");
			}
		}
		System.out.println("\nEven numbers are ");
		for(int i=1;i<=20;i++){
			if(i%2==0){
				System.out.print(i+" ");
			}
		}

	}

}
