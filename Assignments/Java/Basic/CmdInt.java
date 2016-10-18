
/**
	The program parses all the command line arguments passed into integer
	and finally prints them. It also handles number format exception in case string
	is passed
	@author Akshay Chordiya
*/
public class CmdInt {

	/**
		Starting point of the program. The Main function with arguments
		@param args The arguments passed from the console
	*/
    public static void main(String[] args) {
		for (String arg: args) {
			try {
				System.out.println(Integer.parseInt(arg));
			} catch (NumberFormatException e) {
				System.out.println("Not a number");
			}
		}
    }

}