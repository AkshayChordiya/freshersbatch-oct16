import java.util.*;

/**
	Person with comparable and comparator
	@author Akshay Chordiya
*/
public class PersonMain {

	/**
		Starting point of the program. The Main function.
	*/
    public static void main(String[] args) {
		PersonMain pm = new PersonMain();
		pm.main();
    }
	
	public void main() {
		Person people[] = new Person[3];
		people[0] = new Person("Janhavi", 66.0, 55.0);
		people[1] = new Person("Akshay", 68.0, 66.0);
		people[2] = new Person("Aditya", 64.8, 67.0);
		printAll(people);
		
		Arrays.sort(people, new WeightComparator());
		printAll(people);
	}
	
	public void printAll(Person people[]) {
		System.out.println("Printing Data: ");
		for (Person person: people) {
			System.out.println(person);
		}
	}
	
	class HeightComparator implements Comparator<Person> {
		public int compare(Person p1, Person p2) {
			return p1.height.compareTo(p2.height);
		}
	}
	
	class WeightComparator implements Comparator<Person> {
		public int compare(Person p1, Person p2) {
			return p1.weight.compareTo(p2.weight);
		}
	}
	
	class Person implements Comparable<Person> {
		private String name;
		private Double height;
		private Double weight;
		
		public Person(String name, Double height, Double weight) {
			this.name = name;
			this.height = height;
			this.weight = weight;
		}
		
		public int compareTo(Person person2) {
			return this.name.compareTo(person2.name);
		}
		
		public String toString() {
			return name + " - " + height + " inch " + weight + " kg";
		}
	}


}