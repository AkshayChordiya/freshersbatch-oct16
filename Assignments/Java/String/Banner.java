
/**
	Banner Program
	@author Akshay Chordiya
*/
public class Banner {

	/**
		Starting point of the program. The Main function.
	*/
    public static void main(String[] args) throws InterruptedException {
		StringBuilder stringBuilder = new StringBuilder("Welcome to Java");
		while (true) {
			System.out.print("\r" + stringBuilder);
			char first = stringBuilder.charAt(0);
			stringBuilder.deleteCharAt(0);
			stringBuilder.append(first);
			Thread.sleep(700);
		}
    }

}