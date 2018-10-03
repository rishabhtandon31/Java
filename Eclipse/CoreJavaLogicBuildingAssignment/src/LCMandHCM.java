
public class LCMandHCM {

	public static void main(String[] args) {
		int num1,num2,i=1;
		num1=20; num2=15;
		int minMultiple=(num1<num2)?num1:num2;
		while(i==1){
			if(minMultiple%num1==0 && minMultiple%num2==0){
				System.out.println("LCM of "+num1+" and "+num2+" is "+minMultiple);
				break;
			}
			minMultiple++;
		}
		int hcm=0;
		for(i=1;i<num1 && i<num2; i++){
			if(num1%i==0 && num2%i==0){
				hcm=i;
			}
		}
		System.out.println("HCM of "+num1+" and "+num2+" is "+hcm);
	}

}
