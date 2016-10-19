
/**
	StringPool Program
	@author Akshay Chordiya
*/
public class StringPool {

	/**
		Starting point of the program. The Main function.
	*/
    public static void main(String[] args) {
		String s1 = "ABC";
		System.out.println("S1 (Before) = " + s1.hashCode());
		s1 = s1 + "DEF";
		System.out.println("S1 (After) = " + s1.hashCode());
		
		StringBuilder stringBuilder = new StringBuilder("ABC");
		System.out.println("SB1 (Before) = " + stringBuilder.hashCode());
		stringBuilder.append("DEF");
		System.out.println("SB1 (After) = " + stringBuilder.hashCode());
    }

}