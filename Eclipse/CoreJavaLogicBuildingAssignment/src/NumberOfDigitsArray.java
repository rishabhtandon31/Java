
public class NumberOfDigitsArray {
	
	public static void main(String[] args) {
		int numArr[] = {2, 3, 4, 10, 40,465,123,7896}; 
        int length= numArr.length; 
        int singleDigit=0,doubleDigit=0,threeDigit=0,moreThanThree=0;
        for(int i=0;i<length;i++){
        	 if(numArr[i]>=0 && numArr[i]<10)
        		 singleDigit++;
        	 else if(numArr[i]>=10 && numArr[i]<100)
        		 doubleDigit++;
        	 else if(numArr[i]>=100 && numArr[i]<1000)
        		 threeDigit++;
        	 else 
        		 moreThanThree++;
        }
       System.out.println("Single digit numbers count : "+singleDigit+"\nDouble digit numbers count : "+doubleDigit+"\nThree digits numbers count : "+threeDigit+
    		   "\nMore than three digits numbers : "+moreThanThree);
	}
}
