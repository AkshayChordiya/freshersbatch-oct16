package stud;

import fact.Faculty;

/**
	Student Program
	@author Akshay Chordiya
*/
public class Student {

	/**
		Starting point of the program. The Main function.
	*/
    public static void main(String[] args) {
		Faculty f = new Faculty();
		System.out.println(f.getStudentMarks(2));
    }
	
	

}