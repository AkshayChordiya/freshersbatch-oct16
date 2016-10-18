import java.io.*;
import java.util.*;

/**
	DesertShop Abstract Program
	@author Akshay Chordiya
*/
public class DesertShop {
	
	/** Role types **/
	private static final int ROLE_OWNER = 1;
	private static final int ROLE_CUSTOMER = 2;
	
	/** Desert types */
	private static final int DESERT_CANDY = 1;
	private static final int DESERT_COOKIE = 2;
	private static final int DESERT_ICECREAM = 3;
	
	
	private ArrayList<DessertItem> desertItems;
	private ArrayList<DessertItem> orderItems;
	private int desertItemCursor = 0;

	/**
		Starting point of the program. The Main function.
	*/
    public static void main(String[] args) {
		DesertShop desert = new DesertShop();
		desert.main();
    }
	
	public void main() {
		desertItems = new ArrayList();
		orderItems = new ArrayList();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			while (true) {
				System.out.println("\nRoles: ");
				System.out.println("1. Owner");
				System.out.println("2. Customer");
				System.out.println("3. Exit");
				System.out.print("Select your Role: ");
				int role = Integer.parseInt(bufferedReader.readLine());
				switch (role) {
					case ROLE_OWNER:
						System.out.println("\nLet's buy desert items: ");
						System.out.println("1. Candy");
						System.out.println("2. Cookie");
						System.out.println("3. Icecream");
						System.out.print("Select the desert item: ");
						DessertItem desertItem = getDesert(Integer.parseInt(bufferedReader.readLine()));
						System.out.println("Bought " + desertItem);
						desertItems.add(desertItem);
						break;
					case ROLE_CUSTOMER:
						if (desertItems.isEmpty()) {
							System.out.println("Sorry! We don't have any desert left");
							System.exit(0);
						}
						System.out.println("\nDesert items available: ");
						for (int index = 0 ; index < desertItems.size(); index++) {
							System.out.println((index + 1) + ". " + desertItems.get(index));
						}
						if (!orderItems.isEmpty()) {
							System.out.println("\nMy Cart: ");
							for (int index = 0 ; index < orderItems.size(); index++) {
								System.out.println((index + 1) + ". " + orderItems.get(index));
							}
						}
						System.out.print("\nSelect the desert item: ");
						int item = Integer.parseInt(bufferedReader.readLine());
						DessertItem removedDesert = desertItems.remove(item - 1);
						orderItems.add(removedDesert);
						System.out.println("Added " + removedDesert + " to cart");
						//placeOrder(desertItems);
						System.out.println("Do you want to checkout? Y/N");
						if (bufferedReader.readLine().contains("Y")) {
							placeOrder(orderItems);
							System.exit(0);
						}
						break;
					default:
						System.exit(0);
				} 
			}
		} catch (Exception e) {
			
		}
	}
	
	public DessertItem getDesert(int desertType) {
		switch (desertType) {
			case DESERT_CANDY:
				return new Candy(1);
			case DESERT_COOKIE:
				return new Cookie(1);
			case DESERT_ICECREAM:
				return new IceCream(40);
		}
		return null;
	}
	
	public void placeOrder(ArrayList<DessertItem> orderItems) {
		double totalBill = 0;
		System.out.println("\nBill: ");
		for (DessertItem desert: orderItems) {
			System.out.println(desert);
			totalBill += desert.getCost();
		}
		System.err.println("Amount = Rs. " + totalBill);
	}
	
	public abstract class DessertItem {
		public abstract double getCost();
	}
	
	public class Candy extends DessertItem {
		
		private double cost = 1;
		private static final double DOLLAR_CONVERSION = 60;
		
		public Candy(double cost) {
			this.cost = cost;
		}
		
		public double getCost() {
			return cost * DOLLAR_CONVERSION;
		}
		
		public String toString() {
			return "Candy - Rs. " + getCost();
		}
	} 
	
	public class Cookie extends DessertItem {
		
		private double cost = 1;
		private static final double EURO_CONVERSION = 70;
		
		public Cookie(double cost) {
			this.cost = cost;
		}
		
		public double getCost() {
			return cost * EURO_CONVERSION;
		}
		
		public String toString() {
			return "Cookie - Rs. " + getCost();
		}
	}
	
	public class IceCream extends DessertItem {
		
		private double cost = 1;
		
		public IceCream(double cost) {
			this.cost = cost;
		}
		
		public double getCost() {
			return cost;
		}
		
		public String toString() {
			return "IceCream - Rs. " + getCost();
		}
	}
	

}