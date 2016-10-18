
/**
	Account Program
	@author Akshay Chordiya
*/
public class Account {

	private double balance;
	
	/** Default Constructor **/
	public Account() {
		balance = 0.0;
	}
	
	public Account(double balance) {
		this.balance = balance;
	}
	
	public String toString() {
		return "Balance = " + balance;
	}
	
	/** GETTERS and SETTERS **/
	
	public void deposit(double amount) {
		this.balance += amount; 
	}
	
	public void withdraw(double amount) {
		this.balance -= amount; 
	}

	/**
		Starting point of the program. The Main function.
	*/
    public static void main(String[] args) {
		Account account = new Account(4000);
		System.out.println(account);
		account.deposit(1000);
		System.out.println(account);
		account.withdraw(100.5);
		System.out.println(account);
    }

}