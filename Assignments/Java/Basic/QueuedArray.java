
/**
	Queue using Array Program
	@author Akshay Chordiya
*/
public class QueuedArray {

	private int queue[];
	private int top;
	private int rear;
	
	/** Default Constructor **/
	public QueuedArray() {
		queue = new int[20];
		top = -1;
		rear = -1;
	}
	
	/** Methods **/
	
	public void push(int number) {
		this.queue[++rear] = number; 
	}
	
	public int pop() {
		return this.queue[++top];
	}

	/**
		Starting point of the program. The Main function.
	*/
    public static void main(String[] args) {
		QueuedArray queue = new QueuedArray();
		queue.push(1000);
		queue.push(2000);
		queue.push(3000);
		System.out.println(queue.pop());
		System.out.println(queue.pop());
    }

}