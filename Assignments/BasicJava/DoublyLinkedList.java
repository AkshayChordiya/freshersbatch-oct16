
/**
	Doubly LinkedList Program
	@author Akshay Chordiya
*/
public class DoublyLinkedList {
	
	private Node head = null;
	private Node currentNode = null;
	
	/**
		Starting point of the program. The Main function.
	*/
    public static void main(String[] args) {
		DoublyLinkedList doublylinkedList = new DoublyLinkedList();
		doublylinkedList.add(10);
		doublylinkedList.add(11);
		doublylinkedList.add(12);
		System.out.println("Count = " + doublylinkedList.count());
		doublylinkedList.print();
		doublylinkedList.remove(11);
		doublylinkedList.print();
    }
	
	public void add(int value) {
		if (head == null) {
			head = new Node(value);
			currentNode = head;
		} else {
			Node node = new Node(value);
			node.setPrevious(currentNode);
			
			currentNode.setNext(node);
			currentNode = node;
		}
	}
	
	public boolean remove(int value) {
		Node temp = head;
		while (temp != null) {
			if (temp.getData() == value) {
				Node prev = temp.prev();
				Node next = temp.next();
				prev.setNext(next);
				next.setPrevious(prev);
				
				temp.setPrevious(null);
				temp.setNext(null);
				
				return true;
			}
			temp = temp.next();
		}
		return false;
	}
	
	public int count() {
		int count = 0;
		Node temp = head;
		while (temp != null) {
			temp = temp.next();
			count++;
		}
		return count;
	}
	
	public void print() {
		System.out.println("List: ");
		Node temp = head;
		while (temp != null) {
			System.out.print(temp + "->");
			temp = temp.next();
		}
		System.out.println("");
	}
	
	class Node {
		private int data;
		private Node previous;
		private Node next;
		
		/** Default Constructor **/
		public Node() {
			data = 0;
			previous = null;
			next = null;
		}
		
		public Node(int data) {
			this.data = data;
			previous = null;
			next = null;
		}
		
		/** GETTERS and SETTERS **/
		
		public void setData(int data) {
			this.data = data; 
		}
		
		public int getData() {
			return data; 
		}
		
		public void setPrevious(Node previous) {
			this.previous = previous; 
		}
		
		public void setNext(Node next) {
			this.next = next; 
		}
		
		public Node prev() {
			return this.previous;
		}
		
		public Node next() {
			return this.next;
		}
		
		public boolean isNull() {
			return this != null;
		}
		
		public String toString() {
			return Integer.toString(this.data);
		}
	}

}