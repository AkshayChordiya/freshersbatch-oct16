
/**
	The program tells us if the input number is armstrong or not.
	For Example:
	If 153 is the Supplied value, then 13 + 53 + 33 = 1+125+27 = 153 
	then number is armstrong
	@author Akshay Chordiya
*/
public class Armstrong {

	/**
		Starting point of the program. The Main function with arguments.
		Tells if the number is armstrong or not.
		@param args The arguments passed from the console
	*/
    public static void main(String[] args) {
		int additionHolder = 0;
		int divisionHolder;
		int tempInputNumber;  
		try {
			int number = Integer.parseInt(args[0]);				
			tempInputNumber = number;  
			while(number > 0) {  
				divisionHolder = number % 10;  
				number = number / 10;  
				additionHolder = additionHolder+(divisionHolder * divisionHolder * divisionHolder);  
			}  
			System.out.println(tempInputNumber == additionHolder ? "Armstrong number" : "Not armstrong number");   
		} catch (NumberFormatException e) {
			System.out.println("Not a number");
		}
    }

}