
/**
	Employee and Circle Sorting Interface Program
	@author Akshay Chordiya
*/
public class EmpSort {

	/**
		Starting point of the program. The Main function.
	*/
    public static void main(String[] args) {
		EmpSort em = new EmpSort();
		em.main();
    }
	
	public void main() {
		Sortable sortables[] = new Sortable[2];
		sortables[0] = new Employee("Janhavi", 1000);
		sortables[1] = new Employee("Akshay", 2000);
		//sortables[2] = new Circle(3);
		sortAll(sortables);
		printAll(sortables);
	}
	
	public void sortAll(Sortable sortables[]) {
		for (int i = 0 ; i < sortables.length ; i++) {
			for (int j = 0 ; j < sortables.length ; j++) {
				//sortable.compare();
				if (sortables[i].compare(sortables[j]) == 1) {
					Sortable temp = sortables[i];
					sortables[i] = sortables[j];
					sortables[j] = temp;
				}
			}
		}
	}
	
	public void printAll(Sortable sortables[]) {
		System.out.println("Sorted Data: ");
		for (Sortable sortable: sortables) {
			System.out.println(sortable);
		}
	}
	
	public interface Sortable {
		int compare(Sortable s);
	}
	
	class Employee implements Sortable {
		private String name;
		private double salary;
		
		public Employee(String name, double salary) {
			this.name = name;
			this.salary = salary;
		}
		
		public int compare(Sortable s) {
			double salary = ((Employee) s).salary;
			return this.salary > salary ? 1 : 0;
		}
		
		public String toString() {
			return name + " - " + salary;
		}
	} 
	
	class Circle implements Sortable {
		private double radius;
		
		public Circle(double radius) {
			this.radius = radius;
		}
		
		public int compare(Sortable s) {
			double radius = ((Circle) s).radius;
			return this.radius > radius ? 1 : 0;
		}
	} 


}