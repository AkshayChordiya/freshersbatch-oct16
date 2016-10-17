
/**
	Employee Inheritance Program
	@author Akshay Chordiya
*/
public class EmployeeMain {

	/**
		Starting point of the program. The Main function.
	*/
    public static void main(String[] args) {
		EmployeeMain em = new EmployeeMain();
		em.main();
    }
	
	public void main() {
		Employee empArray[] = new Employee[2];
		empArray[0] = new Manager("Akshay", 34000, 59);
		empArray[1] = new Labour("Akshay", 21000, 3000);
		System.out.println(empArray[0]);
		System.out.println(empArray[1]);
		System.out.print("Total Salary: " + getTotal(empArray));
	}
	
	public int getTotal(Employee empArray[]) {
		int total = 0;
		for (Employee emp: empArray) {
			total += emp.getSalary();
		}
		return total;
	}
	
	public class Employee {
		private String name;
		private double salary;
		
		public Employee(String name, double salary) {
			this.name = name;
			this.salary = salary;
		}
		
		public double getSalary() {
			return salary;
		}
		
		public String toString() {
			return name + " - " + getSalary();
		}
	}
	
	public class Manager extends Employee {
		private double incentive;
		
		public Manager(String name, double salary, double incentive) {
			super(name, salary);
			this.incentive = incentive;
		}
		
		public double getSalary() {
			return super.getSalary() + incentive;
		}
	} 
	
	public class Labour extends Employee {
		private double overtime;
		
		public Labour(String name, double salary, double overtime) {
			super(name, salary);
			this.overtime = overtime;
		}
		
		public double getSalary() {
			return super.getSalary() + overtime;
		}
	}

}