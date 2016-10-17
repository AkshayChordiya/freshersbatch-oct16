
/**
	Bank Inheritance Program
	@author Akshay Chordiya
*/
public class Bank {

	/**
		Starting point of the program. The Main function.
	*/
    public static void main(String[] args) {
		Bank bank = new Bank();
		bank.main();
    }
	
	public void main() {
		Account accounts[] = new Account[2];
		accounts[0] = new Saving(1500, 1000);
		accounts[1] = new Current(1000, 500);
		System.out.println(accounts[0]);
		System.out.println(accounts[1]);
		System.out.print("Total Cash: " + getTotal(accounts));
	}
	
	public int getTotal(Account accounts[]) {
		int total = 0;
		for (Account acc: accounts) {
			total += acc.getBalance();
		}
		return total;
	}
	
	public class Account {
		private double balance;
		
		public Account(double balance) {
			this.balance = balance;
		}
		
		public double getBalance() {
			return balance;
		}
		
		public String toString() {
			return Double.toString(getBalance());
		}
	}
	
	public class Saving extends Account {
		private double fixedDeposits;
		
		public Saving(double balance, double fixedDeposits) {
			super(balance);
			this.fixedDeposits = fixedDeposits;
		}
		
		public double getBalance() {
			return super.getBalance() + fixedDeposits;
		}
	} 
	
	public class Current extends Account {
		private double cashCredit;
		
		public Current(double balance, double cashCredit) {
			super(balance);
			this.cashCredit = cashCredit;
		}
		
		public double getBalance() {
			return super.getBalance() - cashCredit;
		}
	}

}