
/**
	The program prints table of the input number upto 10
	@author Akshay Chordiya
*/
public class Table {

	/**
		Starting point of the program. The Main function with arguments.
		It prints table of the number upto 10
		@param args The arguments passed from the console
	*/
    public static void main(String[] args) {
		try {
			int number = Integer.parseInt(args[0]);				
			for (int index = 1; index <= 10; index++) {
				System.out.println(number * index);
			}
		} catch (NumberFormatException e) {
			System.out.println("Not a number");
		}
    }

}