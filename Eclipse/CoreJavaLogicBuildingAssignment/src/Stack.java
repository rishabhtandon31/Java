
public class Stack {
	static int size=5, top=-1;
	public static int []stackBox=new int[5];
	public static void main(String[] args) {
		push(3);
		push(9);
		push(1);
		stackPrint();
		System.out.println("\nElement poped : " +pop());
		stackPrint();
		
	}
	public static void push(int element){
		if(top==size){
			System.out.println("Stack full");
		}
		else
		stackBox[++top]=element;
	}
	public static int pop(){
		if(top<0){
			System.out.println("Stack is empty");
			return -1;
		}
		else
			return stackBox[top--];
	}
	public static void stackPrint(){
		if(top>-1)
		for(int i=0; i<=top;i++){
			System.out.print(stackBox[i]+ "  ");
		}
		else
			System.out.println("Stack empty");
	}
}
