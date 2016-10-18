
/**
	The program prints all the armstrong numbers from 100 to 999.
	Example of Armstrong number:
	If 153 is the Supplied value, then 13 + 53 + 33 = 1+125+27 = 153 
	then number is armstrong
	@author Akshay Chordiya
*/
public class ArmstrongFinder {

	/**
		Starting point of the program. The Main function with arguments.
		Prints all the armstrong numbers from 100 to 999.
		@param args The arguments passed from the console
	*/
    public static void main(String[] args) {		
		for (int number = 100; number <= 999; number++) {	
			if (isArmstrong(number)) {
				System.out.println(number);
			}
		}
    }
	
	/**
		The function tells if the given number is armstrong or not
		@param number the input number
		@return true if number is armstrong else false
	*/
	public static boolean isArmstrong(int number) {
		int additionHolder = 0;
		int divisionHolder;
		int tempInputNumber;  
		tempInputNumber = number;  
		while(number > 0) {  
			divisionHolder = number % 10;  
			number = number / 10;  
			additionHolder = additionHolder + (divisionHolder * divisionHolder * divisionHolder);  
		}
		return tempInputNumber == additionHolder;
	}

}