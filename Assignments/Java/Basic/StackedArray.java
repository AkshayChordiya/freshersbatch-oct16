
/**
	Stack using Array Program
	@author Akshay Chordiya
*/
public class StackedArray {

	private int stack[];
	private int head;
	
	/** Default Constructor **/
	public StackedArray() {
		stack = new int[20];
		head = 0;
	}
	
	/** Methods **/
	
	public void push(int number) {
		this.stack[head] = number; 
		head++;
	}
	
	public int pop() {
		head--;
		return this.stack[head];
	}

	/**
		Starting point of the program. The Main function.
	*/
    public static void main(String[] args) {
		StackedArray stack = new StackedArray();
		stack.push(1000);
		System.out.println(stack.pop());
    }

}