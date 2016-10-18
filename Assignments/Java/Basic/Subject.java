
/**
	The program declares resu;lt after parsing the subject marks 
	from command line
	@author Akshay Chordiya
*/
public class Subject {

	/**
		Starting point of the program. The Main function with arguments.
		The result is declared from the subject marks passed.
		@param args The arguments passed from the console (Required 3 arguments)
	*/
    public static void main(String[] args) {
		int result = 0;
		if (args.length == 3) {
			for (String arg: args) {
				try {
					if (Integer.parseInt(arg) > 60) {
						result += 1;
					}
				} catch (NumberFormatException e) {
					System.out.println("Not a number");
				}
			}
			switch(result) {
				case 1:
					System.out.println("Failed!");
					break;
				case 2:
					System.out.println("Promoted!");
					break;
				case 3:
					System.out.println("Passed!");
					break;
			}		
		} else {
			System.out.println("Marks of 3 subjects are required!");
		}
    }

}