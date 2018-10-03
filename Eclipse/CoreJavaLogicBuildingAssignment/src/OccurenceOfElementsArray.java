
public class OccurenceOfElementsArray {

	public static void main(String[] args) {
		int []numList={5,45,789,10,410,2};
		int l=numList.length;
		int oneDigitNum=0,twoDigitNum=0, threeDigitNum=0;
		for(int i=0;i<l;i++){
			if(numList[i]>=0 && numList[i]<10)
				oneDigitNum++;
			else if(numList[i]>9 && numList[i]<100)
				twoDigitNum++;
			else if(numList[i]>99 && numList[i]<1000)
				threeDigitNum++;
			}
		System.out.println("One Digit Number :"+oneDigitNum+"\nTwo Digit Number :"+twoDigitNum+"\nThree Digit Number :"+threeDigitNum);
	}

}
