import java.io.*;
import java.util.Random;

/**
	A lottery program with 6 lotteries
	@author Akshay Chordiya
*/
public class Lottery {
	
	private static final int MIN = 1;
	private static final int MAX = 49;
	
	/**
		Starting point of the program.
		Takes 6 input numbers and matches with 6 random lottery numbers
		@param args The arguments passed from the console
	*/
    public static void main(String[] args) {		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int inputNumbers[] = new int[6];
		int lotteryNumbers[] = new int[6];
		Random random = new Random();
		try {
			// Taking input numbers
			System.out.println("Your numbers:");
			for (int index = 0; index < 6; index++) {
				inputNumbers[index] = Integer.parseInt(bufferedReader.readLine());
			}
			if (containsDuplicate(inputNumbers)) {
				System.out.println("Duplicate lottery numbers. Please enter again!");
				return;
			}			
			// Generating lottery numbers
			while(containsDuplicate(lotteryNumbers)) {
				for (int index = 0; index < 6; index++) {
					lotteryNumbers[index] = random.nextInt(MAX - MIN + 1) + MIN;
				}
			}
			System.out.println("Lottery numbers:");
			for (int index = 0; index < 6; index++) {
				System.out.println(lotteryNumbers[index]);
			}
			System.out.println(isLoterry(inputNumbers, lotteryNumbers) ? "Your lucky! You won the lottery!" : "Oops! You didn't win the lottery!");
		} catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
				try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
	/**
		The lottery matcher function checks if you won the lottery or not by comparing the input 
		lottery numbers with randomly generated lottery numbers. 
		@param numbers the 6 input numbers
		@param lotteryNumbers the 6 randomly generated lottery numbers
		@return true if you won the lottery else false
	*/
	public static boolean isLoterry(int numbers[], int lotteryNumbers[]) {
		for (int index = 0; index < numbers.length; index++) {
            for (int anotherIndex = 0; anotherIndex < lotteryNumbers.length; anotherIndex++) {
				if (numbers[index] == lotteryNumbers[anotherIndex]) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
		It checks if the input numbers contain any duplication
		@param numbers
		@return true if duplicate found else false
	*/
	public static boolean containsDuplicate(int numbers[]) {
		for (int index = 0; index < numbers.length; index++) {
            for (int anotherIndex = index + 1; anotherIndex < numbers.length; anotherIndex++) {
                if (numbers[index] == numbers[anotherIndex]) {
                   // Got the duplicate element
				   return true;
                }
            }
        }
		return false;
	}

}