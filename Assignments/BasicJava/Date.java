
/**
	Date Program
	@author Akshay Chordiya
*/
public class Date {
	
	private int year;
	private int month;
	private int day;
	
	/** Default Constructor **/
	public Date() {
		day = 15;
		month = 06;
		year = 1995;
	}
	
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public String toString() {
		return "DD/MM/YYYY = " + day + "/" + month + "/" + year;
	}
	
	/** GETTERS and SETTERS **/
	
	public void setYear(int year) {
		this.year = year; 
	}
	
	public void setMonth(int month) {
		this.month = month; 
	}
	
	public void setDay(int day) {
		this.day = day; 
	}
	
	public int getYear() {
		return year; 
	}
	
	public int getMonth() {
		return month; 
	}
	
	public int getDay() {
		return day; 
	}

	/**
		Starting point of the program. The Main function.
	*/
    public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		date.setYear(1994);
		System.out.println(date);
    }

}