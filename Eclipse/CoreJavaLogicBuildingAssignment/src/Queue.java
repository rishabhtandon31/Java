
public class Queue {
	static int size=5, rear=-1,front=-1;
	public static int []queueBox=new int[5];
	public static void main(String[] args) {
		enqueue(3);
		enqueue(8);
		enqueue(1);
		queuePrint();
		System.out.println("\nDequeued : "+dequeue());
	}
	public static void enqueue(int element){
		if(front==-1)
			front++;
		else if (rear== size){
			System.out.println("Queue is filled.");
			return;
		}
		queueBox[++ rear]=element;
	}
	public static int dequeue(){
		if(front<0 || front >rear){
			System.out.println("Queue is empty");
			return -1;
		}
		else
			return queueBox[front++];
	}
	public static void queuePrint(){
		if(front<=rear && front>=0)
		for(int i=front; i<=rear;i++){
			System.out.print(queueBox[i]+ "  ");
		}
		else
			System.out.println("Queue empty");
	}
}
