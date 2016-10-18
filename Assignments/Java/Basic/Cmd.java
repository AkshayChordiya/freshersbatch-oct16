
/**
	The program prints all the command line arguments passed
	@author Akshay Chordiya
*/
public class Cmd {

	/**
		Starting point of the program. The Main function with arguments
		@param args The arguments passed from the console
	*/
    public static void main(String[] args) {
		for (String arg: args) {
			System.out.println(arg);
		}
    }

}