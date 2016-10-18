import java.io.*;

/**
	A basic login program
	@author Akshay Chordiya
*/
public class GUI {
	
	public static final String USERNAME = "aky";
	public static final String PASSWORD = "aky";

	/**
		Starting point of the program.
		Takes username and password as input from the user if they are valid then shows
		welcome message else provides 2 more attempts.
		@param args The arguments passed from the console
	*/
    public static void main(String[] args) {		
		BufferedReader bufferedReader = null;
		int invalidAttempts = 0;
		try {
			do {
				bufferedReader = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Enter username: ");
				String username = bufferedReader.readLine();
				System.out.print("Enter password: ");
				String password = bufferedReader.readLine();
				if (username.equals(USERNAME) && password.equals(PASSWORD)) {
					System.out.println("Welcome");
					break;
				} else {
					System.out.println("Invalid username or password. Try again!");
					invalidAttempts++;
				}
			} while (invalidAttempts < 3);
			if (invalidAttempts != 0) {
				System.out.println("Contact Admin");
			}
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

}