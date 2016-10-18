
/**
	Employee Interface Program
	@author Akshay Chordiya
*/
public class EmpInt {

	/**
		Starting point of the program. The Main function.
	*/
    public static void main(String[] args) {
		EmpInt em = new EmpInt();
		em.main();
    }
	
	public void main() {
		Printable printables[] = new Printable[2];
		printables[0] = new Employee();
		printables[1] = new Circle();
		printAll(printables);
	}
	
	public void printAll(Printable printables[]) {
		for (Printable printable: printables) {
			printable.print();
		}
	}
	
	public interface Printable {
		void print();
	}
	
	class Employee implements Printable {
		public void print() {
			System.out.println("Printing Employee");
		}
	} 
	
	class Circle implements Printable {
		public void print() {
			System.out.println("Printing Circle");
		}
	} 


}