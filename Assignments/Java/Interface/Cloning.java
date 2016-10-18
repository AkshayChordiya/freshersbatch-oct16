
/**
	Cloning Program
	@author Akshay Chordiya
*/
public class Cloning {

	/**
		Starting point of the program. The Main function.
	*/
    public static void main(String[] args) throws CloneNotSupportedException {
		Cloning clone = new Cloning();
		clone.main();
    }
	
	public void main() throws CloneNotSupportedException {
		Employee employee1 = new Employee("Janhavi", 1000, new Date(2016, 10, 03));
		//sortables[1] = new Employee("Akshay", 2000);
		//sortables[2] = new Circle(3);
		Employee employee2 = employee1.clone();
		System.out.println("Employee 1: " + employee1.hashCode());
		System.out.println("Employee 2: " + employee2.hashCode());
	}
	
	class Employee implements Cloneable {
		private String name;
		private double salary;
		private Date dateOfJoining;
		
		public Employee(String name, double salary, Date dateOfJoining) {
			this.name = name;
			this.salary = salary;
			this.dateOfJoining = dateOfJoining;
		}
		
		public Date getJoining() {
			return dateOfJoining;
		}
		
		public String toString() {
			return name + " - " + salary + " joined on " + dateOfJoining;
		}
		
		public Employee clone() throws CloneNotSupportedException {
			Employee emp = (Employee) super.clone();
			emp.dateOfJoining = dateOfJoining.clone();
			return emp;
		}
	}
	
	class Date implements Cloneable {
	
		private int year;
		private int month;
		private int day;
		
		/** Default Constructor **/
		public Date() {
			day = 15;
			month = 06;
			year = 1995;
		}
		
		public Date(int year, int month, int day) {
			this.year = year;
			this.month = month;
			this.day = day;
		}
		
		public String toString() {
			return day + "/" + month + "/" + year;
		}
		
		public Date clone() throws CloneNotSupportedException {
			return (Date) super.clone();
		}
	}


}